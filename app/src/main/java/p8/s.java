package p8;

import java.util.Collection;
import java.util.Iterator;

class s
  extends r
{
  public static <T> boolean s(Collection<? super T> paramCollection, Iterable<? extends T> paramIterable)
  {
    a9.f.f(paramCollection, "<this>");
    a9.f.f(paramIterable, "elements");
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll((Collection)paramIterable);
    }
    boolean bool = false;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (paramCollection.add(paramIterable.next())) {
        bool = true;
      }
    }
    return bool;
  }
  
  public static <T> boolean t(Collection<? super T> paramCollection, T[] paramArrayOfT)
  {
    a9.f.f(paramCollection, "<this>");
    a9.f.f(paramArrayOfT, "elements");
    return paramCollection.addAll(f.c(paramArrayOfT));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.s
 * JD-Core Version:    0.7.0.1
 */