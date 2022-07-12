package c9;

import a9.f;

class i
  extends h
{
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    return i;
  }
  
  public static long d(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 > paramLong2) {
      l = paramLong2;
    }
    return l;
  }
  
  public static int e(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3)
    {
      if (paramInt1 < paramInt2) {
        return paramInt2;
      }
      if (paramInt1 > paramInt3) {
        return paramInt3;
      }
      return paramInt1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static long f(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong2 <= paramLong3)
    {
      if (paramLong1 < paramLong2) {
        return paramLong2;
      }
      if (paramLong1 > paramLong3) {
        return paramLong3;
      }
      return paramLong1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot coerce value to an empty range: maximum ");
    localStringBuilder.append(paramLong3);
    localStringBuilder.append(" is less than minimum ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static a g(int paramInt1, int paramInt2)
  {
    return a.d.a(paramInt1, paramInt2, -1);
  }
  
  public static a h(a parama, int paramInt)
  {
    f.f(parama, "<this>");
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    h.a(bool, Integer.valueOf(paramInt));
    a.a locala = a.d;
    int i = parama.a();
    int j = parama.b();
    if (parama.c() <= 0) {
      paramInt = -paramInt;
    }
    return locala.a(i, j, paramInt);
  }
  
  public static c i(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= -2147483648) {
      return c.e.a();
    }
    return new c(paramInt1, paramInt2 - 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.i
 * JD-Core Version:    0.7.0.1
 */