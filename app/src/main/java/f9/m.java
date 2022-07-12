package f9;

import a9.f;
import z8.b;

class m
{
  public static <T> void a(Appendable paramAppendable, T paramT, b<? super T, ? extends CharSequence> paramb)
  {
    f.f(paramAppendable, "<this>");
    if (paramb != null) {
      paramT = paramb.c(paramT);
    }
    for (paramT = (CharSequence)paramT;; paramT = String.valueOf(paramT))
    {
      paramAppendable.append(paramT);
      return;
      boolean bool;
      if (paramT == null) {
        bool = true;
      } else {
        bool = paramT instanceof CharSequence;
      }
      if (bool) {
        break;
      }
      if ((paramT instanceof Character))
      {
        paramAppendable.append(((Character)paramT).charValue());
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.m
 * JD-Core Version:    0.7.0.1
 */