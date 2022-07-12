package com.baidu.b.c.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Random;

public class b
{
  private static final int[] a = c(new byte[] { 101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107 });
  private final int b;
  
  public b(int paramInt)
  {
    this.b = paramInt;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    int j = paramByteBuffer2.remaining();
    int k = j / 64 + 1;
    int i = 0;
    while (i < k)
    {
      ByteBuffer localByteBuffer = a(paramArrayOfByte1, paramArrayOfByte2, this.b + i);
      if (i == k - 1) {
        a.a(paramByteBuffer1, paramByteBuffer2, localByteBuffer, j % 64);
      } else {
        a.a(paramByteBuffer1, paramByteBuffer2, localByteBuffer, 64);
      }
      i += 1;
    }
  }
  
  static void a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 10)
    {
      a(paramArrayOfInt, 0, 4, 8, 12);
      a(paramArrayOfInt, 1, 5, 9, 13);
      a(paramArrayOfInt, 2, 6, 10, 14);
      a(paramArrayOfInt, 3, 7, 11, 15);
      a(paramArrayOfInt, 0, 5, 10, 15);
      a(paramArrayOfInt, 1, 6, 11, 12);
      a(paramArrayOfInt, 2, 7, 8, 13);
      a(paramArrayOfInt, 3, 4, 9, 14);
      i += 1;
    }
  }
  
  static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramArrayOfInt[paramInt1] += paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt4] = a(paramArrayOfInt[paramInt4] ^ paramArrayOfInt[paramInt1], 16);
    paramArrayOfInt[paramInt3] += paramArrayOfInt[paramInt4];
    paramArrayOfInt[paramInt2] = a(paramArrayOfInt[paramInt2] ^ paramArrayOfInt[paramInt3], 12);
    paramArrayOfInt[paramInt1] += paramArrayOfInt[paramInt2];
    int i = paramArrayOfInt[paramInt4];
    paramArrayOfInt[paramInt4] = a(paramArrayOfInt[paramInt1] ^ i, 8);
    paramArrayOfInt[paramInt3] += paramArrayOfInt[paramInt4];
    paramArrayOfInt[paramInt2] = a(paramArrayOfInt[paramInt2] ^ paramArrayOfInt[paramInt3], 7);
  }
  
  static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = a;
    System.arraycopy(arrayOfInt, 0, paramArrayOfInt1, 0, arrayOfInt.length);
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, arrayOfInt.length, 8);
  }
  
  static int[] c(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
    int[] arrayOfInt = new int[paramArrayOfByte.remaining()];
    paramArrayOfByte.get(arrayOfInt);
    return arrayOfInt;
  }
  
  int a()
  {
    return 12;
  }
  
  ByteBuffer a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    paramArrayOfByte1 = a(c(paramArrayOfByte1), c(paramArrayOfByte2), paramInt);
    paramArrayOfByte2 = (int[])paramArrayOfByte1.clone();
    a(paramArrayOfByte2);
    paramInt = 0;
    while (paramInt < paramArrayOfByte1.length)
    {
      paramArrayOfByte1[paramInt] += paramArrayOfByte2[paramInt];
      paramInt += 1;
    }
    paramArrayOfByte2 = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
    paramArrayOfByte2.asIntBuffer().put(paramArrayOfByte1, 0, 16);
    return paramArrayOfByte2;
  }
  
  void a(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramByteBuffer.remaining() - a() >= paramArrayOfByte1.length)
    {
      byte[] arrayOfByte = paramArrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte = new byte[a()];
        new Random().nextBytes(arrayOfByte);
      }
      paramByteBuffer.put(arrayOfByte);
      a(arrayOfByte, com.baidu.b.c.c.b.a(), paramByteBuffer, ByteBuffer.wrap(paramArrayOfByte1));
      return;
    }
    throw new IllegalArgumentException("data output is too small");
  }
  
  byte[] a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.remaining() >= a())
    {
      byte[] arrayOfByte = new byte[a()];
      paramByteBuffer.get(arrayOfByte);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.remaining());
      a(arrayOfByte, com.baidu.b.c.c.b.b(), localByteBuffer, paramByteBuffer);
      return localByteBuffer.array();
    }
    throw new GeneralSecurityException("data too short");
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, null);
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length <= 2147483647 - a())
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(a() + paramArrayOfByte1.length);
      a(localByteBuffer, paramArrayOfByte1, paramArrayOfByte2);
      return localByteBuffer.array();
    }
    throw new GeneralSecurityException("data too long");
  }
  
  int[] a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    if (paramArrayOfInt1.length == a() / 4)
    {
      int[] arrayOfInt = new int[16];
      a(arrayOfInt, paramArrayOfInt2);
      arrayOfInt[12] = paramInt;
      System.arraycopy(paramArrayOfInt1, 0, arrayOfInt, 13, paramArrayOfInt1.length);
      return arrayOfInt;
    }
    throw new IllegalArgumentException(String.format("need 96-bit param, but got a %d-bit param", new Object[] { Integer.valueOf(paramArrayOfInt1.length * 32) }));
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    return a(ByteBuffer.wrap(paramArrayOfByte));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.b.b
 * JD-Core Version:    0.7.0.1
 */