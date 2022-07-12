package f9;

import a9.f;

class t
  extends s
{
  public static Integer f(String paramString)
  {
    f.f(paramString, "<this>");
    return g(paramString, 10);
  }
  
  public static final Integer g(String paramString, int paramInt)
  {
    f.f(paramString, "<this>");
    a.a(paramInt);
    int i2 = paramString.length();
    if (i2 == 0) {
      return null;
    }
    int n = 0;
    int i = paramString.charAt(0);
    int m = f.h(i, 48);
    int k = -2147483647;
    int j = 1;
    if (m < 0)
    {
      if (i2 == 1) {
        return null;
      }
      if (i == 45)
      {
        k = -2147483648;
        i = 1;
      }
      else if (i == 43)
      {
        i = 0;
      }
      else
      {
        return null;
      }
    }
    else
    {
      i = 0;
      j = i;
    }
    for (int i1 = -59652323; j < i2; i1 = m)
    {
      int i3 = b.b(paramString.charAt(j), paramInt);
      if (i3 < 0) {
        return null;
      }
      m = i1;
      if (n < i1) {
        if (i1 == -59652323)
        {
          i1 = k / paramInt;
          m = i1;
          if (n >= i1) {}
        }
        else
        {
          return null;
        }
      }
      n *= paramInt;
      if (n < k + i3) {
        return null;
      }
      n -= i3;
      j += 1;
    }
    if (i != 0) {
      return Integer.valueOf(n);
    }
    return Integer.valueOf(-n);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.t
 * JD-Core Version:    0.7.0.1
 */