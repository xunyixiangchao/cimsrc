package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;

public class SurfaceTextureHelper
{
  private static final String TAG = "SurfaceTextureHelper";
  private final EglBase eglBase;
  private final FrameRefMonitor frameRefMonitor;
  private int frameRotation;
  private final Handler handler;
  private boolean hasPendingTexture;
  private boolean isQuitting;
  private volatile boolean isTextureInUse;
  private VideoSink listener;
  private final int oesTextureId;
  private VideoSink pendingListener;
  final Runnable setListenerRunnable = new Runnable()
  {
    public void run()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Setting listener to ");
      ((StringBuilder)localObject).append(SurfaceTextureHelper.this.pendingListener);
      Logging.d("SurfaceTextureHelper", ((StringBuilder)localObject).toString());
      localObject = SurfaceTextureHelper.this;
      SurfaceTextureHelper.access$402((SurfaceTextureHelper)localObject, ((SurfaceTextureHelper)localObject).pendingListener);
      SurfaceTextureHelper.access$302(SurfaceTextureHelper.this, null);
      if (SurfaceTextureHelper.this.hasPendingTexture)
      {
        SurfaceTextureHelper.this.updateTexImage();
        SurfaceTextureHelper.access$502(SurfaceTextureHelper.this, false);
      }
    }
  };
  private final SurfaceTexture surfaceTexture;
  private int textureHeight;
  private final TextureBufferImpl.RefCountMonitor textureRefCountMonitor = new TextureBufferImpl.RefCountMonitor()
  {
    public void onDestroy(TextureBufferImpl paramAnonymousTextureBufferImpl)
    {
      SurfaceTextureHelper.this.returnTextureFrame();
      if (SurfaceTextureHelper.this.frameRefMonitor != null) {
        SurfaceTextureHelper.this.frameRefMonitor.onDestroyBuffer(paramAnonymousTextureBufferImpl);
      }
    }
    
    public void onRelease(TextureBufferImpl paramAnonymousTextureBufferImpl)
    {
      if (SurfaceTextureHelper.this.frameRefMonitor != null) {
        SurfaceTextureHelper.this.frameRefMonitor.onReleaseBuffer(paramAnonymousTextureBufferImpl);
      }
    }
    
    public void onRetain(TextureBufferImpl paramAnonymousTextureBufferImpl)
    {
      if (SurfaceTextureHelper.this.frameRefMonitor != null) {
        SurfaceTextureHelper.this.frameRefMonitor.onRetainBuffer(paramAnonymousTextureBufferImpl);
      }
    }
  };
  private int textureWidth;
  private final TimestampAligner timestampAligner;
  private final YuvConverter yuvConverter;
  
  private SurfaceTextureHelper(EglBase.Context paramContext, Handler paramHandler, boolean paramBoolean, YuvConverter paramYuvConverter, FrameRefMonitor paramFrameRefMonitor)
  {
    if (paramHandler.getLooper().getThread() == Thread.currentThread())
    {
      this.handler = paramHandler;
      TimestampAligner localTimestampAligner;
      if (paramBoolean) {
        localTimestampAligner = new TimestampAligner();
      } else {
        localTimestampAligner = null;
      }
      this.timestampAligner = localTimestampAligner;
      this.yuvConverter = paramYuvConverter;
      this.frameRefMonitor = paramFrameRefMonitor;
      paramContext = g.d(paramContext, EglBase.CONFIG_PIXEL_BUFFER);
      this.eglBase = paramContext;
      try
      {
        paramContext.createDummyPbufferSurface();
        paramContext.makeCurrent();
        int i = GlUtil.generateTexture(36197);
        this.oesTextureId = i;
        paramContext = new SurfaceTexture(i);
        this.surfaceTexture = paramContext;
        setOnFrameAvailableListener(paramContext, new x(this), paramHandler);
        return;
      }
      catch (RuntimeException paramContext)
      {
        this.eglBase.release();
        paramHandler.getLooper().quit();
        throw paramContext;
      }
    }
    throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
  }
  
  public static SurfaceTextureHelper create(String paramString, EglBase.Context paramContext)
  {
    return create(paramString, paramContext, false, new YuvConverter(), null);
  }
  
  public static SurfaceTextureHelper create(String paramString, EglBase.Context paramContext, boolean paramBoolean)
  {
    return create(paramString, paramContext, paramBoolean, new YuvConverter(), null);
  }
  
  public static SurfaceTextureHelper create(String paramString, EglBase.Context paramContext, boolean paramBoolean, YuvConverter paramYuvConverter)
  {
    return create(paramString, paramContext, paramBoolean, paramYuvConverter, null);
  }
  
  public static SurfaceTextureHelper create(final String paramString, EglBase.Context paramContext, final boolean paramBoolean, final YuvConverter paramYuvConverter, final FrameRefMonitor paramFrameRefMonitor)
  {
    Object localObject = new HandlerThread(paramString);
    ((HandlerThread)localObject).start();
    localObject = new Handler(((HandlerThread)localObject).getLooper());
    (SurfaceTextureHelper)ThreadUtils.invokeAtFrontUninterruptibly((Handler)localObject, new Callable()
    {
      public SurfaceTextureHelper call()
      {
        try
        {
          SurfaceTextureHelper localSurfaceTextureHelper = new SurfaceTextureHelper(SurfaceTextureHelper.this, this.val$handler, paramBoolean, paramYuvConverter, paramFrameRefMonitor, null);
          return localSurfaceTextureHelper;
        }
        catch (RuntimeException localRuntimeException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(" create failure");
          Logging.e("SurfaceTextureHelper", localStringBuilder.toString(), localRuntimeException);
        }
        return null;
      }
    });
  }
  
  private void release()
  {
    if (this.handler.getLooper().getThread() == Thread.currentThread())
    {
      if ((!this.isTextureInUse) && (this.isQuitting))
      {
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[] { this.oesTextureId }, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
        TimestampAligner localTimestampAligner = this.timestampAligner;
        if (localTimestampAligner != null) {
          localTimestampAligner.dispose();
        }
        return;
      }
      throw new IllegalStateException("Unexpected release.");
    }
    throw new IllegalStateException("Wrong thread.");
  }
  
  private void returnTextureFrame()
  {
    this.handler.post(new b0(this));
  }
  
  @TargetApi(21)
  private static void setOnFrameAvailableListener(SurfaceTexture paramSurfaceTexture, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
  {
    paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener, paramHandler);
  }
  
  private void tryDeliverTextureFrame()
  {
    if (this.handler.getLooper().getThread() == Thread.currentThread())
    {
      if ((!this.isQuitting) && (this.hasPendingTexture) && (!this.isTextureInUse))
      {
        if (this.listener == null) {
          return;
        }
        if ((this.textureWidth != 0) && (this.textureHeight != 0))
        {
          this.isTextureInUse = true;
          this.hasPendingTexture = false;
          updateTexImage();
          Object localObject1 = new float[16];
          this.surfaceTexture.getTransformMatrix((float[])localObject1);
          long l2 = this.surfaceTexture.getTimestamp();
          Object localObject2 = this.timestampAligner;
          long l1 = l2;
          if (localObject2 != null) {
            l1 = ((TimestampAligner)localObject2).translateTimestamp(l2);
          }
          localObject1 = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix((float[])localObject1), this.handler, this.yuvConverter, this.textureRefCountMonitor);
          localObject2 = this.frameRefMonitor;
          if (localObject2 != null) {
            ((FrameRefMonitor)localObject2).onNewBuffer((VideoFrame.TextureBuffer)localObject1);
          }
          localObject1 = new VideoFrame((VideoFrame.Buffer)localObject1, this.frameRotation, l1);
          this.listener.onFrame((VideoFrame)localObject1);
          ((VideoFrame)localObject1).release();
          return;
        }
        Logging.w("SurfaceTextureHelper", "Texture size has not been set.");
      }
      return;
    }
    throw new IllegalStateException("Wrong thread.");
  }
  
  private void updateTexImage()
  {
    synchronized (EglBase.lock)
    {
      this.surfaceTexture.updateTexImage();
      return;
    }
  }
  
  public void dispose()
  {
    Logging.d("SurfaceTextureHelper", "dispose()");
    ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new y(this));
  }
  
  public void forceFrame()
  {
    this.handler.post(new z(this));
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public boolean isTextureInUse()
  {
    return this.isTextureInUse;
  }
  
  public void setFrameRotation(int paramInt)
  {
    this.handler.post(new c0(this, paramInt));
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0)
      {
        this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
        this.handler.post(new d0(this, paramInt1, paramInt2));
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Texture height must be positive, but was ");
      localStringBuilder.append(paramInt2);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Texture width must be positive, but was ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void startListening(VideoSink paramVideoSink)
  {
    if ((this.listener == null) && (this.pendingListener == null))
    {
      this.pendingListener = paramVideoSink;
      this.handler.post(this.setListenerRunnable);
      return;
    }
    throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
  }
  
  public void stopListening()
  {
    Logging.d("SurfaceTextureHelper", "stopListening()");
    this.handler.removeCallbacks(this.setListenerRunnable);
    ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new a0(this));
  }
  
  @Deprecated
  public VideoFrame.I420Buffer textureToYuv(VideoFrame.TextureBuffer paramTextureBuffer)
  {
    return paramTextureBuffer.toI420();
  }
  
  public static abstract interface FrameRefMonitor
  {
    public abstract void onDestroyBuffer(VideoFrame.TextureBuffer paramTextureBuffer);
    
    public abstract void onNewBuffer(VideoFrame.TextureBuffer paramTextureBuffer);
    
    public abstract void onReleaseBuffer(VideoFrame.TextureBuffer paramTextureBuffer);
    
    public abstract void onRetainBuffer(VideoFrame.TextureBuffer paramTextureBuffer);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SurfaceTextureHelper
 * JD-Core Version:    0.7.0.1
 */