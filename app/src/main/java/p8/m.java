package p8;

import a9.f;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import q8.a;

class m
{
  public static <E> List<E> a(List<E> paramList)
  {
    f.f(paramList, "builder");
    return ((a)paramList).h();
  }
  
  public static final <T> Object[] b(T[] paramArrayOfT, boolean paramBoolean)
  {
    f.f(paramArrayOfT, "<this>");
    if ((paramBoolean) && (f.a(paramArrayOfT.getClass(), [Ljava.lang.Object.class))) {
      return paramArrayOfT;
    }
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length, [Ljava.lang.Object.class);
    f.e(paramArrayOfT, "copyOf(this, this.size, Array<Any?>::class.java)");
    return paramArrayOfT;
  }
  
  public static <E> List<E> c()
  {
    return new a();
  }
  
  public static <T> List<T> d(T paramT)
  {
    paramT = Collections.singletonList(paramT);
    f.e(paramT, "singletonList(element)");
    return paramT;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.m
 * JD-Core Version:    0.7.0.1
 */