package p8;

import c9.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import r8.a;

class n
  extends m
{
  public static final <T> Collection<T> e(T[] paramArrayOfT)
  {
    a9.f.f(paramArrayOfT, "<this>");
    return new d(paramArrayOfT, false);
  }
  
  public static final <T extends Comparable<? super T>> int f(List<? extends T> paramList, T paramT, int paramInt1, int paramInt2)
  {
    a9.f.f(paramList, "<this>");
    o(paramList.size(), paramInt1, paramInt2);
    paramInt2 -= 1;
    while (paramInt1 <= paramInt2)
    {
      int i = paramInt1 + paramInt2 >>> 1;
      int j = a.a((Comparable)paramList.get(i), paramT);
      if (j < 0) {
        paramInt1 = i + 1;
      } else if (j > 0) {
        paramInt2 = i - 1;
      } else {
        return i;
      }
    }
    return -(paramInt1 + 1);
  }
  
  public static <T> List<T> h()
  {
    return x.a;
  }
  
  public static c i(Collection<?> paramCollection)
  {
    a9.f.f(paramCollection, "<this>");
    return new c(0, paramCollection.size() - 1);
  }
  
  public static <T> int j(List<? extends T> paramList)
  {
    a9.f.f(paramList, "<this>");
    return paramList.size() - 1;
  }
  
  public static <T> List<T> k(T... paramVarArgs)
  {
    a9.f.f(paramVarArgs, "elements");
    if (paramVarArgs.length > 0) {
      return f.c(paramVarArgs);
    }
    return l.h();
  }
  
  public static <T> List<T> l(T... paramVarArgs)
  {
    a9.f.f(paramVarArgs, "elements");
    return j.n(paramVarArgs);
  }
  
  public static <T> List<T> m(T... paramVarArgs)
  {
    a9.f.f(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {
      return new ArrayList();
    }
    return new ArrayList(new d(paramVarArgs, true));
  }
  
  public static <T> List<T> n(List<? extends T> paramList)
  {
    a9.f.f(paramList, "<this>");
    int i = paramList.size();
    if (i != 0)
    {
      if (i != 1) {
        return paramList;
      }
      return l.d(paramList.get(0));
    }
    return l.h();
  }
  
  private static final void o(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= paramInt3)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt3 <= paramInt1) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("toIndex (");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(") is greater than size (");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(").");
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromIndex (");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(") is less than zero.");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") is greater than toIndex (");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(").");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static void p()
  {
    throw new ArithmeticException("Index overflow has happened.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.n
 * JD-Core Version:    0.7.0.1
 */