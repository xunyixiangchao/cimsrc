package aa;

import ba.c;
import java.security.MessageDigest;

public final class u
  extends e
{
  private final transient byte[][] f;
  private final transient int[] g;
  
  public u(byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    super(e.e.e());
    this.f = paramArrayOfByte;
    this.g = paramArrayOfInt;
  }
  
  private final e z()
  {
    return new e(y());
  }
  
  public String a()
  {
    return z().a();
  }
  
  public e c(String paramString)
  {
    a9.f.f(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString);
    int m = x().length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = w()[(m + i)];
      k = w()[i];
      paramString.update(x()[i], n, k - j);
      i += 1;
    }
    paramString = paramString.digest();
    a9.f.e(paramString, "digestBytes");
    return new e(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof e))
    {
      paramObject = (e)paramObject;
      if ((paramObject.r() == r()) && (l(0, paramObject, 0, r()))) {
        return true;
      }
    }
    return false;
  }
  
  public int g()
  {
    return w()[(x().length - 1)];
  }
  
  public int hashCode()
  {
    int i = f();
    if (i != 0) {
      return i;
    }
    int i2 = x().length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      int i1 = w()[(i2 + k)];
      n = w()[k];
      byte[] arrayOfByte = x()[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    n(m);
    return m;
  }
  
  public String i()
  {
    return z().i();
  }
  
  public byte[] j()
  {
    return y();
  }
  
  public byte k(int paramInt)
  {
    c0.b(w()[(x().length - 1)], paramInt, 1L);
    int j = c.b(this, paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = w()[(j - 1)];
    }
    int k = w()[(x().length + j)];
    return x()[j][(paramInt - i + k)];
  }
  
  public boolean l(int paramInt1, e parame, int paramInt2, int paramInt3)
  {
    a9.f.f(parame, "other");
    boolean bool = false;
    if (paramInt1 >= 0)
    {
      if (paramInt1 > r() - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = c.b(this, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = w()[(paramInt1 - 1)];
        }
        int m = w()[paramInt1];
        int k = w()[(x().length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!parame.m(paramInt3, x()[paramInt1], k + (paramInt2 - i), m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean m(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    a9.f.f(paramArrayOfByte, "other");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 <= r() - paramInt3)
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 > paramArrayOfByte.length - paramInt3) {
            return false;
          }
          int j = paramInt3 + paramInt1;
          int i = c.b(this, paramInt1);
          paramInt3 = paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = i;
          while (paramInt2 < j)
          {
            if (paramInt1 == 0) {
              i = 0;
            } else {
              i = w()[(paramInt1 - 1)];
            }
            int m = w()[paramInt1];
            int k = w()[(x().length + paramInt1)];
            m = Math.min(j, m - i + i) - paramInt2;
            if (!c0.a(x()[paramInt1], k + (paramInt2 - i), paramArrayOfByte, paramInt3, m)) {
              return false;
            }
            paramInt3 += m;
            paramInt2 += m;
            paramInt1 += 1;
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public e t()
  {
    return z().t();
  }
  
  public String toString()
  {
    return z().toString();
  }
  
  public void v(b paramb, int paramInt1, int paramInt2)
  {
    a9.f.f(paramb, "buffer");
    int k = paramInt1 + paramInt2;
    int j = c.b(this, paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    while (i < k)
    {
      if (paramInt1 == 0) {
        j = 0;
      } else {
        j = w()[(paramInt1 - 1)];
      }
      int n = w()[paramInt1];
      int m = w()[(x().length + paramInt1)];
      n = Math.min(k, n - j + j) - i;
      j = m + (i - j);
      s locals1 = new s(x()[paramInt1], j, j + n, true, false);
      s locals2 = paramb.a;
      if (locals2 == null)
      {
        locals1.g = locals1;
        locals1.f = locals1;
        paramb.a = locals1;
      }
      else
      {
        a9.f.c(locals2);
        locals2 = locals2.g;
        a9.f.c(locals2);
        locals2.c(locals1);
      }
      i += n;
      paramInt1 += 1;
    }
    paramb.y0(paramb.z0() + paramInt2);
  }
  
  public final int[] w()
  {
    return this.g;
  }
  
  public final byte[][] x()
  {
    return this.f;
  }
  
  public byte[] y()
  {
    byte[] arrayOfByte1 = new byte[r()];
    int n = x().length;
    int i = 0;
    int k = 0;
    int j = k;
    while (i < n)
    {
      int i1 = w()[(n + i)];
      int m = w()[i];
      byte[] arrayOfByte2 = x()[i];
      k = m - k;
      p8.f.d(arrayOfByte2, arrayOfByte1, j, i1, i1 + k);
      j += k;
      i += 1;
      k = m;
    }
    return arrayOfByte1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.u
 * JD-Core Version:    0.7.0.1
 */