package q8;

import a9.f;
import java.util.Arrays;
import java.util.List;

public final class b
{
  public static final <E> E[] d(int paramInt)
  {
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new Object[paramInt];
    }
    throw new IllegalArgumentException("capacity must be non-negative.".toString());
  }
  
  public static final <T> T[] e(T[] paramArrayOfT, int paramInt)
  {
    f.f(paramArrayOfT, "<this>");
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramInt);
    f.e(paramArrayOfT, "copyOf(this, newSize)");
    f.d(paramArrayOfT, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
    return paramArrayOfT;
  }
  
  public static final <E> void f(E[] paramArrayOfE, int paramInt)
  {
    f.f(paramArrayOfE, "<this>");
    paramArrayOfE[paramInt] = null;
  }
  
  public static final <E> void g(E[] paramArrayOfE, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfE, "<this>");
    while (paramInt1 < paramInt2)
    {
      f(paramArrayOfE, paramInt1);
      paramInt1 += 1;
    }
  }
  
  private static final <T> boolean h(T[] paramArrayOfT, int paramInt1, int paramInt2, List<?> paramList)
  {
    if (paramInt2 != paramList.size()) {
      return false;
    }
    int i = 0;
    while (i < paramInt2)
    {
      if (!f.a(paramArrayOfT[(paramInt1 + i)], paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static final <T> int i(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    while (i < paramInt2)
    {
      T ? = paramArrayOfT[(paramInt1 + i)];
      int k;
      if (? != null) {
        k = ?.hashCode();
      } else {
        k = 0;
      }
      j = j * 31 + k;
      i += 1;
    }
    return j;
  }
  
  private static final <T> String j(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2 * 3 + 2);
    localStringBuilder.append("[");
    int i = 0;
    while (i < paramInt2)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(paramArrayOfT[(paramInt1 + i)]);
      i += 1;
    }
    localStringBuilder.append("]");
    paramArrayOfT = localStringBuilder.toString();
    f.e(paramArrayOfT, "sb.toString()");
    return paramArrayOfT;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q8.b
 * JD-Core Version:    0.7.0.1
 */