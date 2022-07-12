package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public final class e
{
  private byte[] a = null;
  private int b;
  private int c;
  private int d = 0;
  private int e = 0;
  private int f;
  private i g = null;
  private f h = null;
  private int i = 1;
  private boolean j = false;
  
  public e(b paramb, int paramInt)
  {
    this.b = paramInt;
    this.c = paramInt;
    this.f = paramInt;
    this.a = new byte[paramInt * 2];
    this.h = new d(paramb);
    this.g = new h(this.b);
  }
  
  private int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfByte1 != null) && (paramInt3 != 0))
    {
      int k = this.i;
      if ((k != 2) && (k != 3) && (paramInt3 % this.c != 0) && (k != 6))
      {
        if (this.g != null)
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("Input length (with padding) not multiple of ");
          paramArrayOfByte1.append(this.c);
          paramArrayOfByte1.append(" bytes");
          throw new IllegalBlockSizeException(paramArrayOfByte1.toString());
        }
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("Input length not multiple of ");
        paramArrayOfByte1.append(this.c);
        paramArrayOfByte1.append(" bytes");
        throw new IllegalBlockSizeException(paramArrayOfByte1.toString());
      }
      if (this.j)
      {
        this.h.d(paramArrayOfByte1, paramInt1, paramInt3, paramArrayOfByte2, paramInt2);
        return paramInt3;
      }
      this.h.c(paramArrayOfByte1, paramInt1, paramInt3, paramArrayOfByte2, paramInt2);
      return paramInt3;
    }
    return 0;
  }
  
  int a(int paramInt)
  {
    paramInt = this.d + paramInt;
    i locali = this.g;
    if (locali == null) {
      return paramInt;
    }
    if (this.j) {
      return paramInt;
    }
    int m = this.c;
    int k = this.b;
    if (m != k)
    {
      m = this.f;
      if (paramInt < m) {
        return m;
      }
      return paramInt + k - (paramInt - m) % k;
    }
    return paramInt + locali.a(paramInt);
  }
  
  int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int n = this.d + paramInt2;
    int m = this.c;
    int k = this.b;
    Object localObject;
    if (m != k)
    {
      m = this.f;
      if (n < m) {
        k = m - n;
      } else {
        k -= (n - m) % k;
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        k = ((i)localObject).a(n);
      } else {
        k = 0;
      }
    }
    if ((k > 0) && (k != this.b) && (this.g != null) && (this.j))
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("Input length must be multiple of ");
      paramArrayOfByte1.append(this.b);
      paramArrayOfByte1.append(" when decrypting with padded cipher");
      throw new IllegalBlockSizeException(paramArrayOfByte1.toString());
    }
    boolean bool = this.j;
    if ((!bool) && (this.g != null)) {
      m = n + k;
    } else {
      m = n;
    }
    if (paramArrayOfByte2 != null)
    {
      int i1 = paramArrayOfByte2.length - paramInt3;
      if (((bool) && (this.g != null)) || ((i1 >= m) && ((!bool) || (i1 >= m - this.b))))
      {
        int i2 = this.d;
        if ((i2 == 0) && ((bool) || (this.g == null))) {
          break label351;
        }
        localObject = new byte[m];
        if (i2 != 0) {
          System.arraycopy(this.a, 0, localObject, 0, i2);
        }
        if (paramInt2 != 0) {
          System.arraycopy(paramArrayOfByte1, paramInt1, localObject, this.d, paramInt2);
        }
        if (!this.j)
        {
          paramArrayOfByte1 = this.g;
          if (paramArrayOfByte1 != null) {
            paramArrayOfByte1.a((byte[])localObject, n, k);
          }
        }
        paramArrayOfByte1 = (byte[])localObject;
        paramInt1 = 0;
        label351:
        if (this.j)
        {
          if (i1 < m) {
            this.h.b();
          }
          localObject = new byte[n];
          paramInt2 = a(paramArrayOfByte1, paramInt1, (byte[])localObject, 0, n);
          paramArrayOfByte1 = this.g;
          paramInt1 = paramInt2;
          if (paramArrayOfByte1 != null)
          {
            paramInt1 = paramArrayOfByte1.b((byte[])localObject, 0, paramInt2);
            if (paramInt1 < 0) {
              throw new BadPaddingException("Given final block not properly padded");
            }
          }
          if (paramArrayOfByte2.length - paramInt3 >= paramInt1)
          {
            paramInt2 = 0;
            for (;;)
            {
              k = paramInt1;
              if (paramInt2 >= paramInt1) {
                break;
              }
              paramArrayOfByte2[(paramInt3 + paramInt2)] = localObject[paramInt2];
              paramInt2 += 1;
            }
          }
          this.h.c();
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("Output buffer too short: ");
          paramArrayOfByte1.append(paramArrayOfByte2.length - paramInt3);
          paramArrayOfByte1.append(" bytes given, ");
          paramArrayOfByte1.append(paramInt1);
          paramArrayOfByte1.append(" bytes needed");
          throw new ShortBufferException(paramArrayOfByte1.toString());
        }
        k = a(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt3, m);
        this.d = 0;
        this.f = this.b;
        if (this.i != 0) {
          this.h.a();
        }
        return k;
      }
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("Output buffer too short: ");
      paramArrayOfByte1.append(i1);
      paramArrayOfByte1.append(" bytes given, ");
      paramArrayOfByte1.append(m);
      paramArrayOfByte1.append(" bytes needed");
      throw new ShortBufferException(paramArrayOfByte1.toString());
    }
    throw new ShortBufferException("Output buffer is null");
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, SecureRandom paramSecureRandom)
  {
    boolean bool;
    if ((paramInt != 2) && (paramInt != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    this.j = bool;
    byte[] arrayOfByte;
    if (this.i == 0)
    {
      if (paramArrayOfByte2 == null) {
        arrayOfByte = paramArrayOfByte2;
      } else {
        throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
      }
    }
    else
    {
      arrayOfByte = paramArrayOfByte2;
      if (paramArrayOfByte2 == null) {
        if (!bool)
        {
          paramArrayOfByte2 = paramSecureRandom;
          if (paramSecureRandom == null) {
            paramArrayOfByte2 = c.a;
          }
          arrayOfByte = new byte[this.b];
          paramArrayOfByte2.nextBytes(arrayOfByte);
        }
        else
        {
          throw new InvalidAlgorithmParameterException("Parameters missing");
        }
      }
    }
    this.d = 0;
    this.f = this.b;
    this.h.a(this.j, "", paramArrayOfByte1, arrayOfByte);
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      int k = a(paramInt2);
      localObject1 = localObject2;
      byte[] arrayOfByte = new byte[k];
      localObject1 = localObject2;
      paramInt1 = a(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
      paramArrayOfByte = arrayOfByte;
      if (paramInt1 >= k) {
        break label81;
      }
      localObject1 = localObject2;
      paramArrayOfByte = new byte[paramInt1];
      localObject1 = paramArrayOfByte;
      if (paramInt1 != 0)
      {
        localObject1 = paramArrayOfByte;
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, paramInt1);
        localObject1 = paramArrayOfByte;
      }
    }
    catch (ShortBufferException paramArrayOfByte)
    {
      label78:
      label81:
      break label78;
    }
    paramArrayOfByte = (byte[])localObject1;
    return paramArrayOfByte;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.c.a.e
 * JD-Core Version:    0.7.0.1
 */