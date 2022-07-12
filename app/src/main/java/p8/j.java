package p8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

class j
  extends i
{
  public static final <T> boolean m(T[] paramArrayOfT, T paramT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    return r(paramArrayOfT, paramT) >= 0;
  }
  
  public static final <T> List<T> n(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    return (List)o(paramArrayOfT, new ArrayList());
  }
  
  public static final <C extends Collection<? super T>, T> C o(T[] paramArrayOfT, C paramC)
  {
    a9.f.f(paramArrayOfT, "<this>");
    a9.f.f(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? != null) {
        paramC.add(?);
      }
      i += 1;
    }
    return paramC;
  }
  
  public static <T> int p(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    return paramArrayOfT.length - 1;
  }
  
  public static <T> T q(T[] paramArrayOfT, int paramInt)
  {
    a9.f.f(paramArrayOfT, "<this>");
    if ((paramInt >= 0) && (paramInt <= f.p(paramArrayOfT))) {
      return paramArrayOfT[paramInt];
    }
    return null;
  }
  
  public static final <T> int r(T[] paramArrayOfT, T paramT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    int j = 0;
    int i = 0;
    if (paramT == null)
    {
      j = paramArrayOfT.length;
      while (i < j)
      {
        if (paramArrayOfT[i] == null) {
          return i;
        }
        i += 1;
      }
    }
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      if (a9.f.a(paramT, paramArrayOfT[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static char s(char[] paramArrayOfChar)
  {
    a9.f.f(paramArrayOfChar, "<this>");
    int i = paramArrayOfChar.length;
    if (i != 0)
    {
      if (i == 1) {
        return paramArrayOfChar[0];
      }
      throw new IllegalArgumentException("Array has more than one element.");
    }
    throw new NoSuchElementException("Array is empty.");
  }
  
  public static <T> T t(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    if (paramArrayOfT.length == 1) {
      return paramArrayOfT[0];
    }
    return null;
  }
  
  public static <T> List<T> u(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    int i = paramArrayOfT.length;
    if (i != 0)
    {
      if (i != 1) {
        return f.v(paramArrayOfT);
      }
      return l.d(paramArrayOfT[0]);
    }
    return l.h();
  }
  
  public static <T> List<T> v(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    return new ArrayList(n.e(paramArrayOfT));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.j
 * JD-Core Version:    0.7.0.1
 */