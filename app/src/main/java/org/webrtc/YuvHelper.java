package org.webrtc;

import java.nio.ByteBuffer;

public class YuvHelper
{
  public static void ABGRToI420(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5, int paramInt6)
  {
    nativeABGRToI420(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramInt5, paramInt6);
  }
  
  public static void I420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5)
  {
    int k = (paramInt5 + 1) / 2;
    int i = (paramInt4 + 1) / 2;
    int j = paramInt4 * paramInt5;
    k *= i;
    int m = k * 2 + j;
    if (paramByteBuffer4.capacity() >= m)
    {
      paramByteBuffer4.position(0);
      ByteBuffer localByteBuffer1 = paramByteBuffer4.slice();
      paramByteBuffer4.position(j);
      ByteBuffer localByteBuffer2 = paramByteBuffer4.slice();
      paramByteBuffer4.position(k + j);
      nativeI420Copy(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer1, paramInt4, localByteBuffer2, i, paramByteBuffer4.slice(), i, paramInt4, paramInt5);
      return;
    }
    paramByteBuffer1 = new StringBuilder();
    paramByteBuffer1.append("Expected destination buffer capacity to be at least ");
    paramByteBuffer1.append(m);
    paramByteBuffer1.append(" was ");
    paramByteBuffer1.append(paramByteBuffer4.capacity());
    throw new IllegalArgumentException(paramByteBuffer1.toString());
  }
  
  public static void I420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8)
  {
    nativeI420Copy(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramByteBuffer6, paramInt6, paramInt7, paramInt8);
  }
  
  public static void I420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5, int paramInt6)
  {
    int j = paramInt6 % 180;
    int i;
    if (j == 0) {
      i = paramInt4;
    } else {
      i = paramInt5;
    }
    if (j == 0) {
      j = paramInt5;
    } else {
      j = paramInt4;
    }
    int m = (j + 1) / 2;
    int k = (i + 1) / 2;
    j *= i;
    m *= k;
    int n = m * 2 + j;
    if (paramByteBuffer4.capacity() >= n)
    {
      paramByteBuffer4.position(0);
      ByteBuffer localByteBuffer1 = paramByteBuffer4.slice();
      paramByteBuffer4.position(j);
      ByteBuffer localByteBuffer2 = paramByteBuffer4.slice();
      paramByteBuffer4.position(m + j);
      nativeI420Rotate(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer1, i, localByteBuffer2, k, paramByteBuffer4.slice(), k, paramInt4, paramInt5, paramInt6);
      return;
    }
    paramByteBuffer1 = new StringBuilder();
    paramByteBuffer1.append("Expected destination buffer capacity to be at least ");
    paramByteBuffer1.append(n);
    paramByteBuffer1.append(" was ");
    paramByteBuffer1.append(paramByteBuffer4.capacity());
    throw new IllegalArgumentException(paramByteBuffer1.toString());
  }
  
  public static void I420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    nativeI420Rotate(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramByteBuffer6, paramInt6, paramInt7, paramInt8, paramInt9);
  }
  
  public static void I420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5)
  {
    int i = (paramInt4 + 1) / 2;
    int k = (paramInt5 + 1) / 2;
    int j = paramInt4 * paramInt5;
    k = k * i * 2 + j;
    if (paramByteBuffer4.capacity() >= k)
    {
      paramByteBuffer4.position(0);
      ByteBuffer localByteBuffer = paramByteBuffer4.slice();
      paramByteBuffer4.position(j);
      nativeI420ToNV12(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, localByteBuffer, paramInt4, paramByteBuffer4.slice(), i * 2, paramInt4, paramInt5);
      return;
    }
    paramByteBuffer1 = new StringBuilder();
    paramByteBuffer1.append("Expected destination buffer capacity to be at least ");
    paramByteBuffer1.append(k);
    paramByteBuffer1.append(" was ");
    paramByteBuffer1.append(paramByteBuffer4.capacity());
    throw new IllegalArgumentException(paramByteBuffer1.toString());
  }
  
  public static void I420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, int paramInt6, int paramInt7)
  {
    nativeI420ToNV12(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramByteBuffer3, paramInt3, paramByteBuffer4, paramInt4, paramByteBuffer5, paramInt5, paramInt6, paramInt7);
  }
  
  public static void copyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4)
  {
    nativeCopyPlane(paramByteBuffer1, paramInt1, paramByteBuffer2, paramInt2, paramInt3, paramInt4);
  }
  
  private static native void nativeABGRToI420(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, int paramInt5, int paramInt6);
  
  private static native void nativeCopyPlane(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeI420Copy(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8);
  
  private static native void nativeI420Rotate(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, ByteBuffer paramByteBuffer6, int paramInt6, int paramInt7, int paramInt8, int paramInt9);
  
  private static native void nativeI420ToNV12(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, ByteBuffer paramByteBuffer4, int paramInt4, ByteBuffer paramByteBuffer5, int paramInt5, int paramInt6, int paramInt7);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.YuvHelper
 * JD-Core Version:    0.7.0.1
 */