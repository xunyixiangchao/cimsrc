package org.webrtc;

public abstract interface VideoProcessor
  extends CapturerObserver
{
  public abstract void onFrameCaptured(VideoFrame paramVideoFrame, FrameAdaptationParameters paramFrameAdaptationParameters);
  
  public abstract void setSink(VideoSink paramVideoSink);
  
  public static class FrameAdaptationParameters
  {
    public final int cropHeight;
    public final int cropWidth;
    public final int cropX;
    public final int cropY;
    public final boolean drop;
    public final int scaleHeight;
    public final int scaleWidth;
    public final long timestampNs;
    
    public FrameAdaptationParameters(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, boolean paramBoolean)
    {
      this.cropX = paramInt1;
      this.cropY = paramInt2;
      this.cropWidth = paramInt3;
      this.cropHeight = paramInt4;
      this.scaleWidth = paramInt5;
      this.scaleHeight = paramInt6;
      this.timestampNs = paramLong;
      this.drop = paramBoolean;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.VideoProcessor
 * JD-Core Version:    0.7.0.1
 */