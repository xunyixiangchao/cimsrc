package org.webrtc;

public class VideoSource
  extends MediaSource
{
  private final CapturerObserver capturerObserver = new CapturerObserver()
  {
    public void onCapturerStarted(boolean paramAnonymousBoolean)
    {
      VideoSource.this.nativeAndroidVideoTrackSource.setState(paramAnonymousBoolean);
      synchronized (VideoSource.this.videoProcessorLock)
      {
        VideoSource.access$202(VideoSource.this, paramAnonymousBoolean);
        if (VideoSource.this.videoProcessor != null) {
          VideoSource.this.videoProcessor.onCapturerStarted(paramAnonymousBoolean);
        }
        return;
      }
    }
    
    public void onCapturerStopped()
    {
      VideoSource.this.nativeAndroidVideoTrackSource.setState(false);
      synchronized (VideoSource.this.videoProcessorLock)
      {
        VideoSource.access$202(VideoSource.this, false);
        if (VideoSource.this.videoProcessor != null) {
          VideoSource.this.videoProcessor.onCapturerStopped();
        }
        return;
      }
    }
    
    public void onFrameCaptured(VideoFrame paramAnonymousVideoFrame)
    {
      VideoProcessor.FrameAdaptationParameters localFrameAdaptationParameters = VideoSource.this.nativeAndroidVideoTrackSource.adaptFrame(paramAnonymousVideoFrame);
      synchronized (VideoSource.this.videoProcessorLock)
      {
        if (VideoSource.this.videoProcessor != null)
        {
          VideoSource.this.videoProcessor.onFrameCaptured(paramAnonymousVideoFrame, localFrameAdaptationParameters);
          return;
        }
        paramAnonymousVideoFrame = r0.b(paramAnonymousVideoFrame, localFrameAdaptationParameters);
        if (paramAnonymousVideoFrame != null)
        {
          VideoSource.this.nativeAndroidVideoTrackSource.onFrameCaptured(paramAnonymousVideoFrame);
          paramAnonymousVideoFrame.release();
        }
        return;
      }
    }
  };
  private boolean isCapturerRunning;
  private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;
  private VideoProcessor videoProcessor;
  private final Object videoProcessorLock = new Object();
  
  public VideoSource(long paramLong)
  {
    super(paramLong);
    this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(paramLong);
  }
  
  public void adaptOutputFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    adaptOutputFormat(i, paramInt1, paramInt1, i, paramInt3);
  }
  
  public void adaptOutputFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    adaptOutputFormat(new AspectRatio(paramInt1, paramInt2), Integer.valueOf(paramInt1 * paramInt2), new AspectRatio(paramInt3, paramInt4), Integer.valueOf(paramInt3 * paramInt4), Integer.valueOf(paramInt5));
  }
  
  public void adaptOutputFormat(AspectRatio paramAspectRatio1, Integer paramInteger1, AspectRatio paramAspectRatio2, Integer paramInteger2, Integer paramInteger3)
  {
    this.nativeAndroidVideoTrackSource.adaptOutputFormat(paramAspectRatio1, paramInteger1, paramAspectRatio2, paramInteger2, paramInteger3);
  }
  
  public void dispose()
  {
    setVideoProcessor(null);
    super.dispose();
  }
  
  public CapturerObserver getCapturerObserver()
  {
    return this.capturerObserver;
  }
  
  long getNativeVideoTrackSource()
  {
    return getNativeMediaSource();
  }
  
  public void setIsScreencast(boolean paramBoolean)
  {
    this.nativeAndroidVideoTrackSource.setIsScreencast(paramBoolean);
  }
  
  public void setVideoProcessor(VideoProcessor paramVideoProcessor)
  {
    synchronized (this.videoProcessorLock)
    {
      VideoProcessor localVideoProcessor = this.videoProcessor;
      if (localVideoProcessor != null)
      {
        localVideoProcessor.setSink(null);
        if (this.isCapturerRunning) {
          this.videoProcessor.onCapturerStopped();
        }
      }
      this.videoProcessor = paramVideoProcessor;
      if (paramVideoProcessor != null)
      {
        paramVideoProcessor.setSink(new t0(this));
        if (this.isCapturerRunning) {
          paramVideoProcessor.onCapturerStarted(true);
        }
      }
      return;
    }
  }
  
  public static class AspectRatio
  {
    public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
    public final int height;
    public final int width;
    
    public AspectRatio(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoSource
 * JD-Core Version:    0.7.0.1
 */