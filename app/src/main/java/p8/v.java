package p8;

import a9.f;
import c9.g;
import e9.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import z8.b;

class v
  extends u
{
  public static final <T> String A(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    f.f(paramIterable, "<this>");
    f.f(paramCharSequence1, "separator");
    f.f(paramCharSequence2, "prefix");
    f.f(paramCharSequence3, "postfix");
    f.f(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)y(paramIterable, new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    f.e(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    return paramIterable;
  }
  
  public static <T> T C(List<? extends T> paramList)
  {
    f.f(paramList, "<this>");
    if (!paramList.isEmpty()) {
      return paramList.get(l.j(paramList));
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static <T> List<T> D(Collection<? extends T> paramCollection, Iterable<? extends T> paramIterable)
  {
    f.f(paramCollection, "<this>");
    f.f(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      int i = paramCollection.size();
      Collection localCollection = (Collection)paramIterable;
      paramIterable = new ArrayList(i + localCollection.size());
      paramIterable.addAll(paramCollection);
      paramIterable.addAll(localCollection);
      return paramIterable;
    }
    paramCollection = new ArrayList(paramCollection);
    l.s(paramCollection, paramIterable);
    return paramCollection;
  }
  
  public static <T> List<T> E(Collection<? extends T> paramCollection, T paramT)
  {
    f.f(paramCollection, "<this>");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + 1);
    localArrayList.addAll(paramCollection);
    localArrayList.add(paramT);
    return localArrayList;
  }
  
  public static <T> T F(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof List)) {
      return G((List)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (!paramIterable.hasNext()) {
        return localObject;
      }
      throw new IllegalArgumentException("Collection has more than one element.");
    }
    throw new NoSuchElementException("Collection is empty.");
  }
  
  public static final <T> T G(List<? extends T> paramList)
  {
    f.f(paramList, "<this>");
    int i = paramList.size();
    if (i != 0)
    {
      if (i == 1) {
        return paramList.get(0);
      }
      throw new IllegalArgumentException("List has more than one element.");
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static final <T> List<T> H(Iterable<? extends T> paramIterable, int paramInt)
  {
    f.f(paramIterable, "<this>");
    int j = 0;
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt == 0) {
        return l.h();
      }
      if ((paramIterable instanceof Collection))
      {
        if (paramInt >= ((Collection)paramIterable).size()) {
          return l.J(paramIterable);
        }
        if (paramInt == 1) {
          return l.d(w(paramIterable));
        }
      }
      ArrayList localArrayList = new ArrayList(paramInt);
      paramIterable = paramIterable.iterator();
      i = j;
      do
      {
        if (!paramIterable.hasNext()) {
          break;
        }
        localArrayList.add(paramIterable.next());
        j = i + 1;
        i = j;
      } while (j != paramInt);
      return l.n(localArrayList);
    }
    paramIterable = new StringBuilder();
    paramIterable.append("Requested element count ");
    paramIterable.append(paramInt);
    paramIterable.append(" is less than zero.");
    throw new IllegalArgumentException(paramIterable.toString().toString());
  }
  
  public static final <T, C extends Collection<? super T>> C I(Iterable<? extends T> paramIterable, C paramC)
  {
    f.f(paramIterable, "<this>");
    f.f(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    return paramC;
  }
  
  public static <T> List<T> J(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1) {
          return l.L(localCollection);
        }
        if ((paramIterable instanceof List)) {
          paramIterable = ((List)paramIterable).get(0);
        } else {
          paramIterable = paramIterable.iterator().next();
        }
        return l.d(paramIterable);
      }
      return l.h();
    }
    return l.n(K(paramIterable));
  }
  
  public static final <T> List<T> K(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof Collection)) {
      return l.L((Collection)paramIterable);
    }
    return (List)I(paramIterable, new ArrayList());
  }
  
  public static <T> List<T> L(Collection<? extends T> paramCollection)
  {
    f.f(paramCollection, "<this>");
    return new ArrayList(paramCollection);
  }
  
  public static <T> Set<T> M(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof Collection))
    {
      Collection localCollection = (Collection)paramIterable;
      int i = localCollection.size();
      if (i != 0)
      {
        if (i != 1) {
          return (Set)I(paramIterable, new LinkedHashSet(e0.a(localCollection.size())));
        }
        if ((paramIterable instanceof List)) {
          paramIterable = ((List)paramIterable).get(0);
        } else {
          paramIterable = paramIterable.iterator().next();
        }
        return j0.a(paramIterable);
      }
      return i0.b();
    }
    return k0.c((Set)I(paramIterable, new LinkedHashSet()));
  }
  
  public static <T> c<T> u(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    return new a(paramIterable);
  }
  
  public static <T> List<T> v(List<? extends T> paramList, int paramInt)
  {
    f.f(paramList, "<this>");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return H(paramList, g.b(paramList.size() - paramInt, 0));
    }
    paramList = new StringBuilder();
    paramList.append("Requested element count ");
    paramList.append(paramInt);
    paramList.append(" is less than zero.");
    throw new IllegalArgumentException(paramList.toString().toString());
  }
  
  public static final <T> T w(Iterable<? extends T> paramIterable)
  {
    f.f(paramIterable, "<this>");
    if ((paramIterable instanceof List)) {
      return l.x((List)paramIterable);
    }
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext()) {
      return paramIterable.next();
    }
    throw new NoSuchElementException("Collection is empty.");
  }
  
  public static <T> T x(List<? extends T> paramList)
  {
    f.f(paramList, "<this>");
    if (!paramList.isEmpty()) {
      return paramList.get(0);
    }
    throw new NoSuchElementException("List is empty.");
  }
  
  public static final <T, A extends Appendable> A y(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    f.f(paramIterable, "<this>");
    f.f(paramA, "buffer");
    f.f(paramCharSequence1, "separator");
    f.f(paramCharSequence2, "prefix");
    f.f(paramCharSequence3, "postfix");
    f.f(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    paramIterable = paramIterable.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramCharSequence2 = paramIterable.next();
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
  
  public static final class a
    implements c<T>
  {
    public a(Iterable paramIterable) {}
    
    public Iterator<T> iterator()
    {
      return this.a.iterator();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.v
 * JD-Core Version:    0.7.0.1
 */