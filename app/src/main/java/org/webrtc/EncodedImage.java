package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class EncodedImage
  implements RefCounted
{
  public final ByteBuffer buffer;
  public final long captureTimeMs;
  public final long captureTimeNs;
  public final boolean completeFrame;
  public final int encodedHeight;
  public final int encodedWidth;
  public final FrameType frameType;
  public final Integer qp;
  private final RefCountDelegate refCountDelegate;
  public final int rotation;
  
  @CalledByNative
  private EncodedImage(ByteBuffer paramByteBuffer, Runnable paramRunnable, int paramInt1, int paramInt2, long paramLong, FrameType paramFrameType, int paramInt3, boolean paramBoolean, Integer paramInteger)
  {
    this.buffer = paramByteBuffer;
    this.encodedWidth = paramInt1;
    this.encodedHeight = paramInt2;
    this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(paramLong);
    this.captureTimeNs = paramLong;
    this.frameType = paramFrameType;
    this.rotation = paramInt3;
    this.completeFrame = paramBoolean;
    this.qp = paramInteger;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  @CalledByNative
  private ByteBuffer getBuffer()
  {
    return this.buffer;
  }
  
  @CalledByNative
  private long getCaptureTimeNs()
  {
    return this.captureTimeNs;
  }
  
  @CalledByNative
  private boolean getCompleteFrame()
  {
    return this.completeFrame;
  }
  
  @CalledByNative
  private int getEncodedHeight()
  {
    return this.encodedHeight;
  }
  
  @CalledByNative
  private int getEncodedWidth()
  {
    return this.encodedWidth;
  }
  
  @CalledByNative
  private int getFrameType()
  {
    return this.frameType.getNative();
  }
  
  @CalledByNative
  private Integer getQp()
  {
    return this.qp;
  }
  
  @CalledByNative
  private int getRotation()
  {
    return this.rotation;
  }
  
  public void release()
  {
    this.refCountDelegate.release();
  }
  
  public void retain()
  {
    this.refCountDelegate.retain();
  }
  
  public static class Builder
  {
    private ByteBuffer buffer;
    private long captureTimeNs;
    private boolean completeFrame;
    private int encodedHeight;
    private int encodedWidth;
    private EncodedImage.FrameType frameType;
    private Integer qp;
    private Runnable releaseCallback;
    private int rotation;
    
    public EncodedImage createEncodedImage()
    {
      return new EncodedImage(this.buffer, this.releaseCallback, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp, null);
    }
    
    public Builder setBuffer(ByteBuffer paramByteBuffer, Runnable paramRunnable)
    {
      this.buffer = paramByteBuffer;
      this.releaseCallback = paramRunnable;
      return this;
    }
    
    @Deprecated
    public Builder setCaptureTimeMs(long paramLong)
    {
      this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(paramLong);
      return this;
    }
    
    public Builder setCaptureTimeNs(long paramLong)
    {
      this.captureTimeNs = paramLong;
      return this;
    }
    
    public Builder setCompleteFrame(boolean paramBoolean)
    {
      this.completeFrame = paramBoolean;
      return this;
    }
    
    public Builder setEncodedHeight(int paramInt)
    {
      this.encodedHeight = paramInt;
      return this;
    }
    
    public Builder setEncodedWidth(int paramInt)
    {
      this.encodedWidth = paramInt;
      return this;
    }
    
    public Builder setFrameType(EncodedImage.FrameType paramFrameType)
    {
      this.frameType = paramFrameType;
      return this;
    }
    
    public Builder setQp(Integer paramInteger)
    {
      this.qp = paramInteger;
      return this;
    }
    
    public Builder setRotation(int paramInt)
    {
      this.rotation = paramInt;
      return this;
    }
  }
  
  public static enum FrameType
  {
    private final int nativeIndex;
    
    static
    {
      FrameType localFrameType1 = new FrameType("EmptyFrame", 0, 0);
      EmptyFrame = localFrameType1;
      FrameType localFrameType2 = new FrameType("VideoFrameKey", 1, 3);
      VideoFrameKey = localFrameType2;
      FrameType localFrameType3 = new FrameType("VideoFrameDelta", 2, 4);
      VideoFrameDelta = localFrameType3;
      $VALUES = new FrameType[] { localFrameType1, localFrameType2, localFrameType3 };
    }
    
    private FrameType(int paramInt)
    {
      this.nativeIndex = paramInt;
    }
    
    @CalledByNative("FrameType")
    static FrameType fromNativeIndex(int paramInt)
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        FrameType localFrameType = localObject[i];
        if (localFrameType.getNative() == paramInt) {
          return localFrameType;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown native frame type: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public int getNative()
    {
      return this.nativeIndex;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.EncodedImage
 * JD-Core Version:    0.7.0.1
 */