package r8;

import java.util.Comparator;

final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f a = new f();
  
  public int a(Comparable<Object> paramComparable1, Comparable<Object> paramComparable2)
  {
    a9.f.f(paramComparable1, "a");
    a9.f.f(paramComparable2, "b");
    return paramComparable2.compareTo(paramComparable1);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return e.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r8.f
 * JD-Core Version:    0.7.0.1
 */