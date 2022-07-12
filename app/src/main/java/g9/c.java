package g9;

import c9.g;

public final class c
{
  private static final long d(long paramLong, int paramInt)
  {
    return a.d((paramLong << 1) + paramInt);
  }
  
  private static final long e(long paramLong)
  {
    return a.d((paramLong << 1) + 1L);
  }
  
  private static final long f(long paramLong)
  {
    return a.d(paramLong << 1);
  }
  
  private static final long g(long paramLong)
  {
    return paramLong * 1000000;
  }
  
  public static final long h(int paramInt, d paramd)
  {
    a9.f.f(paramd, "unit");
    if (paramd.compareTo(d.e) <= 0) {
      return f(e.b(paramInt, paramd, d.b));
    }
    return i(paramInt, paramd);
  }
  
  public static final long i(long paramLong, d paramd)
  {
    a9.f.f(paramd, "unit");
    d locald = d.b;
    long l = e.b(4611686018426999999L, locald, paramd);
    if (new c9.f(-l, l).d(paramLong)) {
      return f(e.b(paramLong, paramd, locald));
    }
    return e(g.f(e.a(paramLong, paramd, d.d), -4611686018427387903L, 4611686018427387903L));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g9.c
 * JD-Core Version:    0.7.0.1
 */