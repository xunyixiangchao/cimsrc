package com.baidu.b.c.a;

import java.security.InvalidKeyException;

class d
  extends f
{
  protected byte[] a;
  private byte[] e;
  private byte[] f = null;
  
  d(b paramb)
  {
    super(paramb);
    int i = this.c;
    this.e = new byte[i];
    this.a = new byte[i];
  }
  
  void a()
  {
    System.arraycopy(this.d, 0, this.a, 0, this.c);
  }
  
  void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length == this.c))
    {
      this.d = paramArrayOfByte2;
      a();
      this.b.a(paramBoolean, paramString, paramArrayOfByte1);
      return;
    }
    throw new InvalidKeyException("Internal error");
  }
  
  void a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = paramInt3;
    paramInt3 = paramInt1;
    for (;;)
    {
      int j = paramInt3;
      if (j >= paramInt2 + paramInt1) {
        break;
      }
      paramInt3 = 0;
      while (paramInt3 < this.c)
      {
        this.e[paramInt3] = ((byte)(paramArrayOfByte1[(paramInt3 + j)] ^ this.a[paramInt3]));
        paramInt3 += 1;
      }
      this.b.a(this.e, 0, paramArrayOfByte2, i);
      System.arraycopy(paramArrayOfByte2, i, this.a, 0, this.c);
      int k = this.c;
      paramInt3 = j + k;
      i += k;
    }
  }
  
  void b()
  {
    if (this.f == null) {
      this.f = new byte[this.c];
    }
    System.arraycopy(this.a, 0, this.f, 0, this.c);
  }
  
  void b(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    byte[] arrayOfByte1;
    int i;
    if ((paramArrayOfByte1 == paramArrayOfByte2) && (paramInt1 >= paramInt3) && (paramInt1 - paramInt3 < this.c))
    {
      arrayOfByte1 = (byte[])paramArrayOfByte1.clone();
      i = paramInt1;
    }
    else
    {
      arrayOfByte1 = null;
      i = paramInt1;
    }
    for (;;)
    {
      int j = i;
      if (j >= paramInt2 + paramInt1) {
        break;
      }
      this.b.b(paramArrayOfByte1, j, this.e, 0);
      i = 0;
      for (;;)
      {
        k = this.c;
        if (i >= k) {
          break;
        }
        paramArrayOfByte2[(i + paramInt3)] = ((byte)(this.e[i] ^ this.a[i]));
        i += 1;
      }
      byte[] arrayOfByte2 = this.a;
      if (arrayOfByte1 == null) {
        System.arraycopy(paramArrayOfByte1, j, arrayOfByte2, 0, k);
      } else {
        System.arraycopy(arrayOfByte1, j, arrayOfByte2, 0, k);
      }
      int k = this.c;
      i = j + k;
      paramInt3 += k;
    }
  }
  
  void c()
  {
    System.arraycopy(this.f, 0, this.a, 0, this.c);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.d
 * JD-Core Version:    0.7.0.1
 */