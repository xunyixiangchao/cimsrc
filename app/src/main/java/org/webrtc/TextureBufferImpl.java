package org.webrtc;

import android.graphics.Matrix;
import android.os.Handler;

public class TextureBufferImpl
  implements VideoFrame.TextureBuffer
{
  private final int height;
  private final int id;
  private final RefCountDelegate refCountDelegate;
  private final RefCountMonitor refCountMonitor;
  private final Handler toI420Handler;
  private final Matrix transformMatrix;
  private final VideoFrame.TextureBuffer.Type type;
  private final int unscaledHeight;
  private final int unscaledWidth;
  private final int width;
  private final YuvConverter yuvConverter;
  
  private TextureBufferImpl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, VideoFrame.TextureBuffer.Type paramType, int paramInt5, Matrix paramMatrix, Handler paramHandler, YuvConverter paramYuvConverter, RefCountMonitor paramRefCountMonitor)
  {
    this.unscaledWidth = paramInt1;
    this.unscaledHeight = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.type = paramType;
    this.id = paramInt5;
    this.transformMatrix = paramMatrix;
    this.toI420Handler = paramHandler;
    this.yuvConverter = paramYuvConverter;
    this.refCountDelegate = new RefCountDelegate(new f0(this, paramRefCountMonitor));
    this.refCountMonitor = paramRefCountMonitor;
  }
  
  public TextureBufferImpl(int paramInt1, int paramInt2, VideoFrame.TextureBuffer.Type paramType, int paramInt3, Matrix paramMatrix, Handler paramHandler, YuvConverter paramYuvConverter, Runnable paramRunnable)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2, paramType, paramInt3, paramMatrix, paramHandler, paramYuvConverter, new RefCountMonitor()
    {
      public void onDestroy(TextureBufferImpl paramAnonymousTextureBufferImpl)
      {
        paramAnonymousTextureBufferImpl = TextureBufferImpl.this;
        if (paramAnonymousTextureBufferImpl != null) {
          paramAnonymousTextureBufferImpl.run();
        }
      }
      
      public void onRelease(TextureBufferImpl paramAnonymousTextureBufferImpl) {}
      
      public void onRetain(TextureBufferImpl paramAnonymousTextureBufferImpl) {}
    });
  }
  
  TextureBufferImpl(int paramInt1, int paramInt2, VideoFrame.TextureBuffer.Type paramType, int paramInt3, Matrix paramMatrix, Handler paramHandler, YuvConverter paramYuvConverter, RefCountMonitor paramRefCountMonitor)
  {
    this(paramInt1, paramInt2, paramInt1, paramInt2, paramType, paramInt3, paramMatrix, paramHandler, paramYuvConverter, paramRefCountMonitor);
  }
  
  private TextureBufferImpl applyTransformMatrix(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Matrix localMatrix = new Matrix(this.transformMatrix);
    localMatrix.preConcat(paramMatrix);
    retain();
    new TextureBufferImpl(paramInt1, paramInt2, paramInt3, paramInt4, this.type, this.id, localMatrix, this.toI420Handler, this.yuvConverter, new RefCountMonitor()
    {
      public void onDestroy(TextureBufferImpl paramAnonymousTextureBufferImpl)
      {
        TextureBufferImpl.this.release();
      }
      
      public void onRelease(TextureBufferImpl paramAnonymousTextureBufferImpl)
      {
        TextureBufferImpl.this.refCountMonitor.onRelease(TextureBufferImpl.this);
      }
      
      public void onRetain(TextureBufferImpl paramAnonymousTextureBufferImpl)
      {
        TextureBufferImpl.this.refCountMonitor.onRetain(TextureBufferImpl.this);
      }
    });
  }
  
  public TextureBufferImpl applyTransformMatrix(Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    return applyTransformMatrix(paramMatrix, paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Matrix localMatrix = new Matrix();
    int i = this.height;
    localMatrix.preTranslate(paramInt1 / this.width, (i - (paramInt2 + paramInt4)) / i);
    localMatrix.preScale(paramInt3 / this.width, paramInt4 / this.height);
    return applyTransformMatrix(localMatrix, Math.round(this.unscaledWidth * paramInt3 / this.width), Math.round(this.unscaledHeight * paramInt4 / this.height), paramInt5, paramInt6);
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getTextureId()
  {
    return this.id;
  }
  
  public Handler getToI420Handler()
  {
    return this.toI420Handler;
  }
  
  public Matrix getTransformMatrix()
  {
    return this.transformMatrix;
  }
  
  public VideoFrame.TextureBuffer.Type getType()
  {
    return this.type;
  }
  
  public int getUnscaledHeight()
  {
    return this.unscaledHeight;
  }
  
  public int getUnscaledWidth()
  {
    return this.unscaledWidth;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public YuvConverter getYuvConverter()
  {
    return this.yuvConverter;
  }
  
  public void release()
  {
    this.refCountMonitor.onRelease(this);
    this.refCountDelegate.release();
  }
  
  public void retain()
  {
    this.refCountMonitor.onRetain(this);
    this.refCountDelegate.retain();
  }
  
  public VideoFrame.I420Buffer toI420()
  {
    return (VideoFrame.I420Buffer)ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new g0(this));
  }
  
  static abstract interface RefCountMonitor
  {
    public abstract void onDestroy(TextureBufferImpl paramTextureBufferImpl);
    
    public abstract void onRelease(TextureBufferImpl paramTextureBufferImpl);
    
    public abstract void onRetain(TextureBufferImpl paramTextureBufferImpl);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.TextureBufferImpl
 * JD-Core Version:    0.7.0.1
 */