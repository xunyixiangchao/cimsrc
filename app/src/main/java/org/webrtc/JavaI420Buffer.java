package org.webrtc;

import java.nio.ByteBuffer;

public class JavaI420Buffer
  implements VideoFrame.I420Buffer
{
  private final ByteBuffer dataU;
  private final ByteBuffer dataV;
  private final ByteBuffer dataY;
  private final int height;
  private final RefCountDelegate refCountDelegate;
  private final int strideU;
  private final int strideV;
  private final int strideY;
  private final int width;
  
  private JavaI420Buffer(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4, ByteBuffer paramByteBuffer3, int paramInt5, Runnable paramRunnable)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.dataY = paramByteBuffer1;
    this.dataU = paramByteBuffer2;
    this.dataV = paramByteBuffer3;
    this.strideY = paramInt3;
    this.strideU = paramInt4;
    this.strideV = paramInt5;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }
  
  public static JavaI420Buffer allocate(int paramInt1, int paramInt2)
  {
    int i = (paramInt2 + 1) / 2;
    int j = (paramInt1 + 1) / 2;
    int k = paramInt1 * paramInt2;
    int m = k + 0;
    int n = j * i;
    int i1 = m + n;
    ByteBuffer localByteBuffer1 = JniCommon.nativeAllocateByteBuffer(k + j * 2 * i);
    localByteBuffer1.position(0);
    localByteBuffer1.limit(m);
    ByteBuffer localByteBuffer2 = localByteBuffer1.slice();
    localByteBuffer1.position(m);
    localByteBuffer1.limit(i1);
    ByteBuffer localByteBuffer3 = localByteBuffer1.slice();
    localByteBuffer1.position(i1);
    localByteBuffer1.limit(i1 + n);
    return new JavaI420Buffer(paramInt1, paramInt2, localByteBuffer2, paramInt1, localByteBuffer3, j, localByteBuffer1.slice(), j, new q(localByteBuffer1));
  }
  
  private static void checkCapacity(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = paramInt3 * (paramInt2 - 1) + paramInt1;
    if (paramByteBuffer.capacity() >= paramInt1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Buffer must be at least ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" bytes, but was ");
    localStringBuilder.append(paramByteBuffer.capacity());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static VideoFrame.Buffer cropAndScaleI420(VideoFrame.I420Buffer paramI420Buffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt3 == paramInt5) {
      if (paramInt4 == paramInt6)
      {
        localObject = paramI420Buffer.getDataY();
        ByteBuffer localByteBuffer1 = paramI420Buffer.getDataU();
        ByteBuffer localByteBuffer2 = paramI420Buffer.getDataV();
        ((ByteBuffer)localObject).position(paramInt1 + paramI420Buffer.getStrideY() * paramInt2);
        paramInt1 /= 2;
        paramInt2 /= 2;
        localByteBuffer1.position(paramI420Buffer.getStrideU() * paramInt2 + paramInt1);
        localByteBuffer2.position(paramInt1 + paramInt2 * paramI420Buffer.getStrideV());
        paramI420Buffer.retain();
        return wrap(paramInt5, paramInt6, ((ByteBuffer)localObject).slice(), paramI420Buffer.getStrideY(), localByteBuffer1.slice(), paramI420Buffer.getStrideU(), localByteBuffer2.slice(), paramI420Buffer.getStrideV(), new s(paramI420Buffer));
      }
    }
    Object localObject = allocate(paramInt5, paramInt6);
    nativeCropAndScaleI420(paramI420Buffer.getDataY(), paramI420Buffer.getStrideY(), paramI420Buffer.getDataU(), paramI420Buffer.getStrideU(), paramI420Buffer.getDataV(), paramI420Buffer.getStrideV(), paramInt1, paramInt2, paramInt3, paramInt4, ((JavaI420Buffer)localObject).getDataY(), ((JavaI420Buffer)localObject).getStrideY(), ((JavaI420Buffer)localObject).getDataU(), ((JavaI420Buffer)localObject).getStrideU(), ((JavaI420Buffer)localObject).getDataV(), ((JavaI420Buffer)localObject).getStrideV(), paramInt5, paramInt6);
    return localObject;
  }
  
  private static native void nativeCropAndScaleI420(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer4, int paramInt8, ByteBuffer paramByteBuffer5, int paramInt9, ByteBuffer paramByteBuffer6, int paramInt10, int paramInt11, int paramInt12);
  
  public static JavaI420Buffer wrap(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, int paramInt3, ByteBuffer paramByteBuffer2, int paramInt4, ByteBuffer paramByteBuffer3, int paramInt5, Runnable paramRunnable)
  {
    if ((paramByteBuffer1 != null) && (paramByteBuffer2 != null) && (paramByteBuffer3 != null))
    {
      if ((paramByteBuffer1.isDirect()) && (paramByteBuffer2.isDirect()) && (paramByteBuffer3.isDirect()))
      {
        paramByteBuffer1 = paramByteBuffer1.slice();
        paramByteBuffer2 = paramByteBuffer2.slice();
        paramByteBuffer3 = paramByteBuffer3.slice();
        int i = (paramInt1 + 1) / 2;
        int j = (paramInt2 + 1) / 2;
        checkCapacity(paramByteBuffer1, paramInt1, paramInt2, paramInt3);
        checkCapacity(paramByteBuffer2, i, j, paramInt4);
        checkCapacity(paramByteBuffer3, i, j, paramInt5);
        return new JavaI420Buffer(paramInt1, paramInt2, paramByteBuffer1, paramInt3, paramByteBuffer2, paramInt4, paramByteBuffer3, paramInt5, paramRunnable);
      }
      throw new IllegalArgumentException("Data buffers must be direct byte buffers.");
    }
    throw new IllegalArgumentException("Data buffers cannot be null.");
  }
  
  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return cropAndScaleI420(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public ByteBuffer getDataU()
  {
    return this.dataU.slice();
  }
  
  public ByteBuffer getDataV()
  {
    return this.dataV.slice();
  }
  
  public ByteBuffer getDataY()
  {
    return this.dataY.slice();
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getStrideU()
  {
    return this.strideU;
  }
  
  public int getStrideV()
  {
    return this.strideV;
  }
  
  public int getStrideY()
  {
    return this.strideY;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void release()
  {
    this.refCountDelegate.release();
  }
  
  public void retain()
  {
    this.refCountDelegate.retain();
  }
  
  public VideoFrame.I420Buffer toI420()
  {
    retain();
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.JavaI420Buffer
 * JD-Core Version:    0.7.0.1
 */