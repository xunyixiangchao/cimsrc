package com.baidu.b.a;

class k
{
  private final byte[] a = new byte[1];
  private final int[] b = new int[4];
  private final byte[] c = new byte[16];
  private final int d;
  private int e;
  private int f;
  
  protected k()
  {
    this(0);
  }
  
  protected k(int paramInt)
  {
    this.d = paramInt;
    b();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return (int)(b(paramArrayOfByte, paramInt, 4) & 0xFFFFFFFF);
  }
  
  private static long b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 8)
    {
      long l = 0L;
      int i = 0;
      while (i < paramInt2)
      {
        l |= (paramArrayOfByte[(paramInt1 + i)] & 0xFF) << i * 8;
        i += 1;
      }
      return l;
    }
    throw new IllegalArgumentException("can't read more than eight bytes into a long value");
  }
  
  private void b()
  {
    int[] arrayOfInt = this.b;
    int i = this.d;
    arrayOfInt[0] = (i - 1640531535 - 2048144777);
    arrayOfInt[1] = (-2048144777 + i);
    arrayOfInt[2] = i;
    arrayOfInt[3] = (i + 1640531535);
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = this.b;
    int j = arrayOfInt[0];
    int m = arrayOfInt[1];
    int k = arrayOfInt[2];
    int i = arrayOfInt[3];
    j = Integer.rotateLeft(j + a(paramArrayOfByte, paramInt) * -2048144777, 13);
    m = Integer.rotateLeft(m + a(paramArrayOfByte, paramInt + 4) * -2048144777, 13);
    k = Integer.rotateLeft(k + a(paramArrayOfByte, paramInt + 8) * -2048144777, 13);
    paramInt = Integer.rotateLeft(i + a(paramArrayOfByte, paramInt + 12) * -2048144777, 13);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] = (j * -1640531535);
    paramArrayOfByte[1] = (m * -1640531535);
    paramArrayOfByte[2] = (k * -1640531535);
    paramArrayOfByte[3] = (paramInt * -1640531535);
    this.f = 0;
  }
  
  protected long a()
  {
    int i = this.e;
    int j = 0;
    if (i > 16) {
      i = Integer.rotateLeft(this.b[0], 1) + Integer.rotateLeft(this.b[1], 7) + Integer.rotateLeft(this.b[2], 12) + Integer.rotateLeft(this.b[3], 18);
    } else {
      i = this.b[2] + 374761393;
    }
    int k = i + this.e;
    int n = this.f;
    i = j;
    j = k;
    int m;
    for (;;)
    {
      k = j;
      m = i;
      if (i > n - 4) {
        break;
      }
      j = Integer.rotateLeft(j + a(this.c, i) * -1028477379, 17) * 668265263;
      i += 4;
    }
    while (m < this.f)
    {
      k = Integer.rotateLeft(k + (this.c[m] & 0xFF) * 374761393, 11) * -1640531535;
      m += 1;
    }
    i = (k ^ k >>> 15) * -2048144777;
    i = (i ^ i >>> 13) * -1028477379;
    return (i ^ i >>> 16) & 0xFFFFFFFF;
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    this.e += paramInt2;
    int i = paramInt1 + paramInt2;
    int j = this.f;
    if (j + paramInt2 < 16)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.c, j, paramInt2);
      this.f += paramInt2;
      return;
    }
    paramInt2 = paramInt1;
    if (j > 0)
    {
      paramInt2 = 16 - j;
      System.arraycopy(paramArrayOfByte, paramInt1, this.c, j, paramInt2);
      b(this.c, 0);
      paramInt2 = paramInt1 + paramInt2;
    }
    while (paramInt2 <= i - 16)
    {
      b(paramArrayOfByte, paramInt2);
      paramInt2 += 16;
    }
    if (paramInt2 < i)
    {
      paramInt1 = i - paramInt2;
      this.f = paramInt1;
      System.arraycopy(paramArrayOfByte, paramInt2, this.c, 0, paramInt1);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.k
 * JD-Core Version:    0.7.0.1
 */