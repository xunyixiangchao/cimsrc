package r8;

import a9.f;
import java.util.Comparator;

class b
{
  public static <T extends Comparable<?>> int a(T paramT1, T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return paramT1.compareTo(paramT2);
  }
  
  public static <T extends Comparable<? super T>> Comparator<T> b()
  {
    e locale = e.a;
    f.d(locale, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
    return locale;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r8.b
 * JD-Core Version:    0.7.0.1
 */