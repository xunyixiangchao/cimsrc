package com.baidu.b.f;

import java.io.ByteArrayOutputStream;

public class a
{
  private String a;
  private boolean b;
  private boolean c;
  
  public a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramString;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  private static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return -1;
            }
            return 0;
          }
          return 1;
        }
        return 3;
      }
      return 4;
    }
    return 6;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    while (j < (paramArrayOfByte.length + 4) / 5)
    {
      short[] arrayOfShort = new short[5];
      int k = 0;
      int m = 5;
      while (k < 5)
      {
        n = j * 5 + k;
        if (n < paramArrayOfByte.length)
        {
          arrayOfShort[k] = ((short)(paramArrayOfByte[n] & 0xFF));
        }
        else
        {
          arrayOfShort[k] = 0;
          m -= 1;
        }
        k += 1;
      }
      int n = a(m);
      int i1 = (byte)(arrayOfShort[0] >> 3 & 0x1F);
      int i2 = (byte)((arrayOfShort[0] & 0x7) << 2 | arrayOfShort[1] >> 6 & 0x3);
      int i3 = (byte)(arrayOfShort[1] >> 1 & 0x1F);
      int i4 = (byte)((arrayOfShort[1] & 0x1) << 4 | arrayOfShort[2] >> 4 & 0xF);
      int i5 = (byte)((arrayOfShort[2] & 0xF) << 1 | arrayOfShort[3] >> 7 & 0x1);
      int i6 = (byte)(arrayOfShort[3] >> 2 & 0x1F);
      k = arrayOfShort[3];
      int i7 = (byte)(arrayOfShort[4] >> 5 & 0x7 | (k & 0x3) << 3);
      int i8 = (byte)(arrayOfShort[4] & 0x1F);
      k = 0;
      for (;;)
      {
        m = 8 - n;
        if (k >= m) {
          break;
        }
        int i = this.a.charAt(new int[] { i1, i2, i3, i4, i5, i6, i7, i8 }[k]);
        m = i;
        if (this.c) {
          m = Character.toLowerCase(i);
        }
        localByteArrayOutputStream.write(m);
        k += 1;
      }
      if (this.b)
      {
        k = m;
        while (k < 8)
        {
          localByteArrayOutputStream.write(61);
          k += 1;
        }
      }
      j += 1;
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.f.a
 * JD-Core Version:    0.7.0.1
 */