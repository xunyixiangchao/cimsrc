package e9;

import a9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class i
  extends h
{
  public static <T> Iterable<T> a(c<? extends T> paramc)
  {
    f.f(paramc, "<this>");
    return new a(paramc);
  }
  
  public static <T> c<T> b(c<? extends T> paramc, int paramInt)
  {
    f.f(paramc, "<this>");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt == 0) {
        return paramc;
      }
      if ((paramc instanceof b)) {
        return ((b)paramc).a(paramInt);
      }
      return new a(paramc, paramInt);
    }
    paramc = new StringBuilder();
    paramc.append("Requested element count ");
    paramc.append(paramInt);
    paramc.append(" is less than zero.");
    throw new IllegalArgumentException(paramc.toString().toString());
  }
  
  public static final <T, A extends Appendable> A c(c<? extends T> paramc, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, z8.b<? super T, ? extends CharSequence> paramb)
  {
    f.f(paramc, "<this>");
    f.f(paramA, "buffer");
    f.f(paramCharSequence1, "separator");
    f.f(paramCharSequence2, "prefix");
    f.f(paramCharSequence3, "postfix");
    f.f(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    paramc = paramc.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramc.hasNext()) {
        break;
      }
      paramCharSequence2 = paramc.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      f9.l.a(paramA, paramCharSequence2, paramb);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    return paramA;
  }
  
  public static final <T> String d(c<? extends T> paramc, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, z8.b<? super T, ? extends CharSequence> paramb)
  {
    f.f(paramc, "<this>");
    f.f(paramCharSequence1, "separator");
    f.f(paramCharSequence2, "prefix");
    f.f(paramCharSequence3, "postfix");
    f.f(paramCharSequence4, "truncated");
    paramc = ((StringBuilder)c(paramc, new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    f.e(paramc, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramc;
  }
  
  public static <T, R> c<R> f(c<? extends T> paramc, z8.b<? super T, ? extends R> paramb)
  {
    f.f(paramc, "<this>");
    f.f(paramb, "transform");
    return new j(paramc, paramb);
  }
  
  public static final <T, C extends Collection<? super T>> C g(c<? extends T> paramc, C paramC)
  {
    f.f(paramc, "<this>");
    f.f(paramC, "destination");
    paramc = paramc.iterator();
    while (paramc.hasNext()) {
      paramC.add(paramc.next());
    }
    return paramC;
  }
  
  public static <T> List<T> h(c<? extends T> paramc)
  {
    f.f(paramc, "<this>");
    return p8.l.n(i(paramc));
  }
  
  public static final <T> List<T> i(c<? extends T> paramc)
  {
    f.f(paramc, "<this>");
    return (List)g(paramc, new ArrayList());
  }
  
  public static final class a
    implements Iterable<T>, b9.a
  {
    public a(c paramc) {}
    
    public Iterator<T> iterator()
    {
      return this.a.iterator();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e9.i
 * JD-Core Version:    0.7.0.1
 */