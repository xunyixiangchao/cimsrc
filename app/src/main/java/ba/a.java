package ba;

import a9.f;
import aa.b;
import aa.b0;
import aa.o;
import aa.s;

public final class a
{
  private static final byte[] a = b0.a("0123456789abcdef");
  
  public static final byte[] a()
  {
    return a;
  }
  
  public static final String b(b paramb, long paramLong)
  {
    f.f(paramb, "<this>");
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (paramb.i0(l) == (byte)13)
      {
        str = paramb.w0(l);
        paramb.skip(2L);
        return str;
      }
    }
    String str = paramb.w0(paramLong);
    paramb.skip(1L);
    return str;
  }
  
  public static final int c(b paramb, o paramo, boolean paramBoolean)
  {
    f.f(paramb, "<this>");
    f.f(paramo, "options");
    s locals1 = paramb.a;
    if (locals1 == null)
    {
      if (paramBoolean) {
        return -2;
      }
      return -1;
    }
    paramb = locals1.a;
    int i = locals1.b;
    int j = locals1.c;
    int[] arrayOfInt = paramo.e();
    Object localObject = locals1;
    int m = -1;
    int k = 0;
    paramo = paramb;
    int i1 = k + 1;
    int i3 = arrayOfInt[k];
    int n = i1 + 1;
    k = arrayOfInt[i1];
    if (k != -1) {
      m = k;
    }
    int i2;
    if (localObject != null)
    {
      if (i3 >= 0) {}
    }
    else {
      for (k = n;; k = i1)
      {
        i2 = i + 1;
        i = paramo[i];
        i1 = k + 1;
        if ((i & 0xFF) != arrayOfInt[k]) {
          return m;
        }
        if (i1 == n + i3 * -1) {
          k = 1;
        } else {
          k = 0;
        }
        if (i2 == j)
        {
          f.c(localObject);
          paramb = ((s)localObject).f;
          f.c(paramb);
          j = paramb.b;
          paramo = paramb.a;
          i = paramb.c;
          if (paramb == locals1)
          {
            if (k == 0)
            {
              if (paramBoolean) {
                return -2;
              }
              return m;
            }
            paramb = null;
          }
        }
        else
        {
          i = j;
          j = i2;
          paramb = (b)localObject;
        }
        if (k != 0)
        {
          n = arrayOfInt[i1];
          k = i;
          i = j;
          break;
        }
        k = i;
        i = j;
        j = k;
        localObject = paramb;
      }
    }
    i1 = i + 1;
    k = paramo[i];
    i = n;
    for (;;)
    {
      if (i == n + i3) {
        return m;
      }
      if ((k & 0xFF) == arrayOfInt[i])
      {
        i2 = arrayOfInt[(i + i3)];
        n = i2;
        k = j;
        paramb = (b)localObject;
        i = i1;
        if (i1 == j)
        {
          s locals2 = ((s)localObject).f;
          f.c(locals2);
          j = locals2.b;
          localObject = locals2.a;
          i1 = locals2.c;
          paramo = (o)localObject;
          n = i2;
          k = i1;
          paramb = locals2;
          i = j;
          if (locals2 == locals1)
          {
            paramb = null;
            i = j;
            k = i1;
            n = i2;
            paramo = (o)localObject;
          }
        }
        if (n >= 0) {
          return n;
        }
        n = -n;
        j = k;
        k = n;
        localObject = paramb;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ba.a
 * JD-Core Version:    0.7.0.1
 */