package p8;

import a9.f;
import java.util.Collection;

class o
  extends n
{
  public static <T> int q(Iterable<? extends T> paramIterable, int paramInt)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof Collection)) {
      paramInt = ((Collection)paramIterable).size();
    }
    return paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.o
 * JD-Core Version:    0.7.0.1
 */