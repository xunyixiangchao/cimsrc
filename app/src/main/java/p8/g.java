package p8;

import a9.f;
import java.lang.reflect.Array;

class g
{
  public static final <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    f.f(paramArrayOfT, "reference");
    paramArrayOfT = Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
    f.d(paramArrayOfT, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
    return (Object[])paramArrayOfT;
  }
  
  public static final void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") is greater than size (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(").");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.g
 * JD-Core Version:    0.7.0.1
 */