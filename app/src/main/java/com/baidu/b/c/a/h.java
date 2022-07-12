package com.baidu.b.c.a;

import javax.crypto.ShortBufferException;

final class h
  implements i
{
  private int a;
  
  h(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(int paramInt)
  {
    int i = this.a;
    return i - paramInt % i;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
    {
      int i = (byte)(paramInt2 & 0xFF);
      int j = 0;
      while (j < paramInt2)
      {
        paramArrayOfByte[(j + paramInt1)] = i;
        j += 1;
      }
      return;
    }
    throw new ShortBufferException("Buffer too small to hold padding");
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      if (paramInt2 == 0) {
        return 0;
      }
      paramInt2 += paramInt1;
      int j = paramArrayOfByte[(paramInt2 - 1)];
      int k = j & 0xFF;
      if (k >= 1)
      {
        if (k > this.a) {
          return -1;
        }
        int m = paramInt2 - k;
        paramInt2 = i;
        if (m < paramInt1) {
          return -1;
        }
        while (paramInt2 < k)
        {
          if (paramArrayOfByte[(m + paramInt2)] != j) {
            return -1;
          }
          paramInt2 += 1;
        }
        return m;
      }
      return -1;
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.h
 * JD-Core Version:    0.7.0.1
 */