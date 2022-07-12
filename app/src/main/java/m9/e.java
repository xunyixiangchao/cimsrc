package m9;

import aa.b;
import f9.j;

public final class e
{
  private static final j a = new j("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  public static final boolean a(String paramString)
  {
    a9.f.f(paramString, "<this>");
    return a.b(paramString);
  }
  
  public static final boolean b(String paramString)
  {
    a9.f.f(paramString, "<this>");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (a9.f.h(c, 31) > 0)
      {
        if (a9.f.h(c, 127) >= 0) {
          return true;
        }
        if (f9.l.M(" #%/:?@[\\]", c, 0, false, 6, null) != -1) {
          return true;
        }
        i += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean c(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    a9.f.f(paramString, "input");
    a9.f.f(paramArrayOfByte, "address");
    int j = paramInt3;
    int i = paramInt1;
    boolean bool;
    for (;;)
    {
      bool = false;
      if (i >= paramInt2) {
        break;
      }
      if (j == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i;
      if (j != paramInt3)
      {
        if (paramString.charAt(i) != '.') {
          return false;
        }
        paramInt1 = i + 1;
      }
      i = paramInt1;
      int k = 0;
      while (i < paramInt2)
      {
        int m = paramString.charAt(i);
        if ((a9.f.h(m, 48) < 0) || (a9.f.h(m, 57) > 0)) {
          break;
        }
        if ((k == 0) && (paramInt1 != i)) {
          return false;
        }
        k = k * 10 + m - 48;
        if (k > 255) {
          return false;
        }
        i += 1;
      }
      if (i - paramInt1 == 0) {
        return false;
      }
      paramArrayOfByte[j] = ((byte)k);
      j += 1;
    }
    if (j == paramInt3 + 4) {
      bool = true;
    }
    return bool;
  }
  
  public static final byte[] d(String paramString, int paramInt1, int paramInt2)
  {
    a9.f.f(paramString, "input");
    byte[] arrayOfByte = new byte[16];
    int j = -1;
    int m = j;
    int i = 0;
    int k = paramInt1;
    int n;
    for (;;)
    {
      paramInt1 = i;
      n = j;
      if (k >= paramInt2) {
        break label295;
      }
      if (i == 16) {
        return null;
      }
      n = k + 2;
      if ((n <= paramInt2) && (f9.l.w(paramString, "::", k, false, 4, null)))
      {
        if (j != -1) {
          return null;
        }
        paramInt1 = i + 2;
        if (n == paramInt2)
        {
          n = paramInt1;
          break label295;
        }
        k = n;
        j = paramInt1;
        i = paramInt1;
        paramInt1 = k;
      }
      else
      {
        paramInt1 = k;
        if (i != 0) {
          if (f9.l.w(paramString, ":", k, false, 4, null))
          {
            paramInt1 = k + 1;
          }
          else
          {
            if (f9.l.w(paramString, ".", k, false, 4, null))
            {
              if (!c(paramString, m, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              paramInt1 = i + 2;
              n = j;
              break label295;
            }
            return null;
          }
        }
      }
      k = paramInt1;
      m = 0;
      while (k < paramInt2)
      {
        n = l.z(paramString.charAt(k));
        if (n == -1) {
          break;
        }
        m = (m << 4) + n;
        k += 1;
      }
      n = k - paramInt1;
      if (n == 0) {
        break;
      }
      if (n > 4) {
        return null;
      }
      n = i + 1;
      arrayOfByte[i] = ((byte)(m >>> 8 & 0xFF));
      i = n + 1;
      arrayOfByte[n] = ((byte)(m & 0xFF));
      m = paramInt1;
    }
    return null;
    label295:
    if (paramInt1 != 16)
    {
      if (n == -1) {
        return null;
      }
      p8.f.d(arrayOfByte, arrayOfByte, 16 - (paramInt1 - n), n, paramInt1);
      p8.f.j(arrayOfByte, (byte)0, n, 16 - paramInt1 + n);
    }
    return arrayOfByte;
  }
  
  public static final String e(byte[] paramArrayOfByte)
  {
    a9.f.f(paramArrayOfByte, "address");
    int i2 = 0;
    int k = -1;
    int i = 0;
    int m;
    int n;
    for (int j = i; i < paramArrayOfByte.length; j = n)
    {
      m = i;
      while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
        m += 2;
      }
      int i3 = m - i;
      int i1 = k;
      n = j;
      if (i3 > j)
      {
        i1 = k;
        n = j;
        if (i3 >= 4)
        {
          n = i3;
          i1 = i;
        }
      }
      i = m + 2;
      k = i1;
    }
    b localb = new b();
    i = i2;
    while (i < paramArrayOfByte.length) {
      if (i == k)
      {
        localb.H0(58);
        m = i + j;
        i = m;
        if (m == 16)
        {
          localb.H0(58);
          i = m;
        }
      }
      else
      {
        if (i > 0) {
          localb.H0(58);
        }
        localb.J0(l.b(paramArrayOfByte[i], 255) << 8 | l.b(paramArrayOfByte[(i + 1)], 255));
        i += 2;
      }
    }
    return localb.v0();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.e
 * JD-Core Version:    0.7.0.1
 */