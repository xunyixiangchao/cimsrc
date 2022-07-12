package r8;

import java.util.Comparator;

final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e a = new e();
  
  public int a(Comparable<Object> paramComparable1, Comparable<Object> paramComparable2)
  {
    a9.f.f(paramComparable1, "a");
    a9.f.f(paramComparable2, "b");
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return f.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r8.e
 * JD-Core Version:    0.7.0.1
 */