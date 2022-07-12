package p8;

import a9.f;
import java.util.Collections;
import java.util.List;

class r
  extends q
{
  public static <T extends Comparable<? super T>> void r(List<T> paramList)
  {
    f.f(paramList, "<this>");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.r
 * JD-Core Version:    0.7.0.1
 */