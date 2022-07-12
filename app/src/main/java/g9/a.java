package g9;

import f9.l;

public final class a
  implements Comparable<a>
{
  public static final a b = new a(null);
  private static final long c = d(0L);
  private static final long d = c.b(4611686018427387903L);
  private static final long e = c.b(-4611686018427387903L);
  private final long a;
  
  private static final void a(long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    paramStringBuilder.append(paramInt1);
    if (paramInt2 != 0)
    {
      paramStringBuilder.append('.');
      String str = l.X(String.valueOf(paramInt2), paramInt3, '0');
      paramInt1 = str.length();
      paramInt3 = -1;
      paramInt2 = paramInt1 - 1;
      paramInt1 = paramInt3;
      if (paramInt2 >= 0)
      {
        int i;
        for (paramInt1 = paramInt2;; paramInt1 = i)
        {
          i = paramInt1 - 1;
          if (str.charAt(paramInt1) != '0') {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (paramInt2 != 0) {
            break;
          }
          if (i < 0)
          {
            paramInt1 = paramInt3;
            break;
          }
        }
      }
      paramInt1 += 1;
      if ((paramBoolean) || (paramInt1 >= 3)) {
        paramInt1 = (paramInt1 + 2) / 3 * 3;
      }
      paramStringBuilder.append(str, 0, paramInt1);
      a9.f.e(paramStringBuilder, "this.append(value, startIndex, endIndex)");
    }
    paramStringBuilder.append(paramString);
  }
  
  public static int c(long paramLong1, long paramLong2)
  {
    long l = paramLong1 ^ paramLong2;
    if ((l >= 0L) && (((int)l & 0x1) != 0))
    {
      int j = ((int)paramLong1 & 0x1) - ((int)paramLong2 & 0x1);
      int i = j;
      if (u(paramLong1)) {
        i = -j;
      }
      return i;
    }
    return a9.f.i(paramLong1, paramLong2);
  }
  
  public static long d(long paramLong)
  {
    if (b.a())
    {
      if (s(paramLong))
      {
        if (new c9.f(-4611686018426999999L, 4611686018426999999L).d(p(paramLong))) {
          return paramLong;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(p(paramLong));
        localStringBuilder.append(" ns is out of nanoseconds range");
        throw new AssertionError(localStringBuilder.toString());
      }
      if (new c9.f(-4611686018427387903L, 4611686018427387903L).d(p(paramLong)))
      {
        if (!new c9.f(-4611686018426L, 4611686018426L).d(p(paramLong))) {
          return paramLong;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(p(paramLong));
        localStringBuilder.append(" ms is denormalized");
        throw new AssertionError(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(p(paramLong));
      localStringBuilder.append(" ms is out of milliseconds range");
      throw new AssertionError(localStringBuilder.toString());
    }
    return paramLong;
  }
  
  public static boolean e(long paramLong, Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    return paramLong == ((a)paramObject).y();
  }
  
  public static final long f(long paramLong)
  {
    long l = paramLong;
    if (u(paramLong)) {
      l = x(paramLong);
    }
    return l;
  }
  
  public static final int g(long paramLong)
  {
    if (t(paramLong)) {
      return 0;
    }
    return (int)(i(paramLong) % 24);
  }
  
  public static final long h(long paramLong)
  {
    return v(paramLong, d.h);
  }
  
  public static final long i(long paramLong)
  {
    return v(paramLong, d.g);
  }
  
  public static final long j(long paramLong)
  {
    return v(paramLong, d.f);
  }
  
  public static final long k(long paramLong)
  {
    return v(paramLong, d.e);
  }
  
  public static final int l(long paramLong)
  {
    if (t(paramLong)) {
      return 0;
    }
    return (int)(j(paramLong) % 60);
  }
  
  public static final int m(long paramLong)
  {
    if (t(paramLong)) {
      return 0;
    }
    boolean bool = r(paramLong);
    paramLong = p(paramLong);
    if (bool) {
      paramLong = c.c(paramLong % 1000);
    } else {
      paramLong %= 1000000000;
    }
    return (int)paramLong;
  }
  
  public static final int n(long paramLong)
  {
    if (t(paramLong)) {
      return 0;
    }
    return (int)(k(paramLong) % 60);
  }
  
  private static final d o(long paramLong)
  {
    if (s(paramLong)) {
      return d.b;
    }
    return d.d;
  }
  
  private static final long p(long paramLong)
  {
    return paramLong >> 1;
  }
  
  public static int q(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  private static final boolean r(long paramLong)
  {
    return ((int)paramLong & 0x1) == 1;
  }
  
  private static final boolean s(long paramLong)
  {
    return ((int)paramLong & 0x1) == 0;
  }
  
  public static final boolean t(long paramLong)
  {
    return (paramLong == d) || (paramLong == e);
  }
  
  public static final boolean u(long paramLong)
  {
    return paramLong < 0L;
  }
  
  public static final long v(long paramLong, d paramd)
  {
    a9.f.f(paramd, "unit");
    if (paramLong == d) {
      return 9223372036854775807L;
    }
    if (paramLong == e) {
      return -9223372036854775808L;
    }
    return e.a(p(paramLong), o(paramLong), paramd);
  }
  
  public static String w(long paramLong)
  {
    if (paramLong == 0L) {
      return "0s";
    }
    if (paramLong == d) {
      return "Infinity";
    }
    if (paramLong == e) {
      return "-Infinity";
    }
    boolean bool = u(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    if (bool) {
      localStringBuilder.append('-');
    }
    long l1 = f(paramLong);
    long l2 = h(l1);
    int i5 = g(l1);
    int i4 = l(l1);
    int i3 = n(l1);
    int i2 = m(l1);
    int i = 0;
    int k;
    if (l2 != 0L) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (i5 != 0) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (i4 != 0) {
      n = 1;
    } else {
      n = 0;
    }
    int i1;
    if ((i3 == 0) && (i2 == 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (k != 0)
    {
      localStringBuilder.append(l2);
      localStringBuilder.append('d');
      i = 1;
    }
    if (m == 0)
    {
      j = i;
      if (k == 0) {
        break label247;
      }
      if (n == 0)
      {
        j = i;
        if (i1 == 0) {
          break label247;
        }
      }
    }
    if (i > 0) {
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(i5);
    localStringBuilder.append('h');
    int j = i + 1;
    label247:
    if (n == 0)
    {
      i = j;
      if (i1 == 0) {
        break label303;
      }
      if (m == 0)
      {
        i = j;
        if (k == 0) {
          break label303;
        }
      }
    }
    if (j > 0) {
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(i4);
    localStringBuilder.append('m');
    i = j + 1;
    label303:
    j = i;
    if (i1 != 0)
    {
      if (i > 0) {
        localStringBuilder.append(' ');
      }
      if ((i3 == 0) && (k == 0) && (m == 0) && (n == 0))
      {
        if (i2 >= 1000000)
        {
          m = i2 / 1000000;
          k = i2 % 1000000;
          j = 6;
        }
        for (str = "ms";; str = "us")
        {
          n = j;
          break label449;
          if (i2 < 1000) {
            break;
          }
          m = i2 / 1000;
          k = i2 % 1000;
          j = 3;
        }
        localStringBuilder.append(i2);
        localStringBuilder.append("ns");
      }
      else
      {
        n = 9;
        j = i3;
        k = i2;
        str = "s";
        m = j;
        label449:
        a(paramLong, localStringBuilder, m, k, n, str, false);
      }
      j = i + 1;
    }
    if ((bool) && (j > 1)) {
      localStringBuilder.insert(1, '(').append(')');
    }
    String str = localStringBuilder.toString();
    a9.f.e(str, "StringBuilder().apply(builderAction).toString()");
    return str;
  }
  
  public static final long x(long paramLong)
  {
    return c.a(-p(paramLong), (int)paramLong & 0x1);
  }
  
  public int b(long paramLong)
  {
    return c(this.a, paramLong);
  }
  
  public boolean equals(Object paramObject)
  {
    return e(this.a, paramObject);
  }
  
  public int hashCode()
  {
    return q(this.a);
  }
  
  public String toString()
  {
    return w(this.a);
  }
  
  public static final class a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g9.a
 * JD-Core Version:    0.7.0.1
 */