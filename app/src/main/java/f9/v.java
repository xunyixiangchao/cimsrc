package f9;

import c9.a;
import e9.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o8.h;
import p8.a0;

class v
  extends u
{
  public static final boolean A(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence1, "<this>");
    a9.f.f(paramCharSequence2, "other");
    if ((paramCharSequence2 instanceof String))
    {
      if (l.N(paramCharSequence1, (String)paramCharSequence2, 0, paramBoolean, 2, null) >= 0) {
        return true;
      }
    }
    else if (L(paramCharSequence1, paramCharSequence2, 0, paramCharSequence1.length(), paramBoolean, false, 16, null) >= 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean D(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence1, "<this>");
    a9.f.f(paramCharSequence2, "suffix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return l.k((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return c0(paramCharSequence1, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  private static final h<Integer, String> F(CharSequence paramCharSequence, Collection<String> paramCollection, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramCollection.size() == 1))
    {
      paramCollection = (String)p8.l.F(paramCollection);
      if (!paramBoolean2) {
        paramInt = l.N(paramCharSequence, paramCollection, paramInt, false, 4, null);
      } else {
        paramInt = S(paramCharSequence, paramCollection, paramInt, false, 4, null);
      }
      if (paramInt < 0) {
        return null;
      }
      return o8.l.a(Integer.valueOf(paramInt), paramCollection);
    }
    Object localObject;
    if (!paramBoolean2) {
      localObject = new c9.c(c9.g.b(paramInt, 0), paramCharSequence.length());
    } else {
      localObject = c9.g.g(c9.g.c(paramInt, H(paramCharSequence)), 0);
    }
    int i;
    int j;
    int k;
    Iterator localIterator;
    String str;
    if ((paramCharSequence instanceof String))
    {
      i = ((a)localObject).a();
      j = ((a)localObject).b();
      k = ((a)localObject).c();
      if (k > 0)
      {
        paramInt = i;
        if (i <= j) {}
      }
      else
      {
        if ((k >= 0) || (j > i)) {
          break label403;
        }
        paramInt = i;
      }
      for (;;)
      {
        localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          str = (String)localObject;
          if (u.n(str, 0, (String)paramCharSequence, paramInt, str.length(), paramBoolean1)) {
            break label225;
          }
        }
        localObject = null;
        label225:
        localObject = (String)localObject;
        if (localObject != null)
        {
          paramCharSequence = (CharSequence)localObject;
          return o8.l.a(Integer.valueOf(paramInt), paramCharSequence);
        }
        if (paramInt == j) {
          break;
        }
        paramInt += k;
      }
    }
    else
    {
      i = ((a)localObject).a();
      j = ((a)localObject).b();
      k = ((a)localObject).c();
      if (k > 0)
      {
        paramInt = i;
        if (i <= j) {}
      }
      else
      {
        if ((k >= 0) || (j > i)) {
          break label403;
        }
        paramInt = i;
      }
      for (;;)
      {
        localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          str = (String)localObject;
          if (c0(str, 0, paramCharSequence, paramInt, str.length(), paramBoolean1)) {
            break label371;
          }
        }
        localObject = null;
        label371:
        localObject = (String)localObject;
        if (localObject != null)
        {
          paramCharSequence = (CharSequence)localObject;
          break;
        }
        if (paramInt == j) {
          break label403;
        }
        paramInt += k;
      }
    }
    label403:
    return null;
  }
  
  public static final c9.c G(CharSequence paramCharSequence)
  {
    a9.f.f(paramCharSequence, "<this>");
    return new c9.c(0, paramCharSequence.length() - 1);
  }
  
  public static final int H(CharSequence paramCharSequence)
  {
    a9.f.f(paramCharSequence, "<this>");
    return paramCharSequence.length() - 1;
  }
  
  public static final int I(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).indexOf(paramChar, paramInt);
    }
    return O(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
  }
  
  public static final int J(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).indexOf(paramString, paramInt);
    }
    return L(paramCharSequence, paramString, paramInt, paramCharSequence.length(), paramBoolean, false, 16, null);
  }
  
  private static final int K(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean2) {
      localObject = new c9.c(c9.g.b(paramInt1, 0), c9.g.c(paramInt2, paramCharSequence1.length()));
    } else {
      localObject = c9.g.g(c9.g.c(paramInt1, H(paramCharSequence1)), c9.g.b(paramInt2, 0));
    }
    int i;
    int j;
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
    {
      paramInt2 = ((a)localObject).a();
      i = ((a)localObject).b();
      j = ((a)localObject).c();
      if (j > 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 <= i) {}
      }
      else
      {
        if ((j >= 0) || (i > paramInt2)) {
          break label230;
        }
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        if (u.n((String)paramCharSequence2, 0, (String)paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
          return paramInt1;
        }
        if (paramInt1 == i) {
          break;
        }
        paramInt1 += j;
      }
    }
    else
    {
      paramInt2 = ((a)localObject).a();
      i = ((a)localObject).b();
      j = ((a)localObject).c();
      if (j > 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 <= i) {}
      }
      else
      {
        if ((j >= 0) || (i > paramInt2)) {
          break label230;
        }
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        if (c0(paramCharSequence2, 0, paramCharSequence1, paramInt1, paramCharSequence2.length(), paramBoolean1)) {
          return paramInt1;
        }
        if (paramInt1 == i) {
          break;
        }
        paramInt1 += j;
      }
    }
    label230:
    return -1;
  }
  
  public static final int O(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = p8.f.s(paramArrayOfChar);
      return ((String)paramCharSequence).indexOf(i, paramInt);
    }
    a0 locala0 = new c9.c(c9.g.b(paramInt, 0), H(paramCharSequence)).d();
    while (locala0.hasNext())
    {
      i = locala0.a();
      char c = paramCharSequence.charAt(i);
      int j = paramArrayOfChar.length;
      paramInt = 0;
      while (paramInt < j)
      {
        if (c.d(paramArrayOfChar[paramInt], c, paramBoolean))
        {
          paramInt = 1;
          break label132;
        }
        paramInt += 1;
      }
      paramInt = 0;
      label132:
      if (paramInt != 0) {
        return i;
      }
    }
    return -1;
  }
  
  public static final int P(CharSequence paramCharSequence, char paramChar, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).lastIndexOf(paramChar, paramInt);
    }
    return T(paramCharSequence, new char[] { paramChar }, paramInt, paramBoolean);
  }
  
  public static final int Q(CharSequence paramCharSequence, String paramString, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramString, "string");
    if ((!paramBoolean) && ((paramCharSequence instanceof String))) {
      return ((String)paramCharSequence).lastIndexOf(paramString, paramInt);
    }
    return K(paramCharSequence, paramString, paramInt, 0, paramBoolean, true);
  }
  
  public static final int T(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramArrayOfChar, "chars");
    int i;
    if ((!paramBoolean) && (paramArrayOfChar.length == 1) && ((paramCharSequence instanceof String)))
    {
      i = p8.f.s(paramArrayOfChar);
      return ((String)paramCharSequence).lastIndexOf(i, paramInt);
    }
    paramInt = c9.g.c(paramInt, H(paramCharSequence));
    while (-1 < paramInt)
    {
      char c = paramCharSequence.charAt(paramInt);
      int m = paramArrayOfChar.length;
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (c.d(paramArrayOfChar[i], c, paramBoolean))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public static final e9.c<String> U(CharSequence paramCharSequence)
  {
    a9.f.f(paramCharSequence, "<this>");
    return k0(paramCharSequence, new String[] { "\r\n", "\n", "\r" }, false, 0, 6, null);
  }
  
  public static final List<String> V(CharSequence paramCharSequence)
  {
    a9.f.f(paramCharSequence, "<this>");
    return d.h(U(paramCharSequence));
  }
  
  public static final CharSequence W(CharSequence paramCharSequence, int paramInt, char paramChar)
  {
    a9.f.f(paramCharSequence, "<this>");
    if (paramInt >= 0)
    {
      if (paramInt <= paramCharSequence.length()) {
        return paramCharSequence.subSequence(0, paramCharSequence.length());
      }
      StringBuilder localStringBuilder = new StringBuilder(paramInt);
      a0 locala0 = new c9.c(1, paramInt - paramCharSequence.length()).d();
      while (locala0.hasNext())
      {
        locala0.a();
        localStringBuilder.append(paramChar);
      }
      localStringBuilder.append(paramCharSequence);
      return localStringBuilder;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Desired length ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than zero.");
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  public static String X(String paramString, int paramInt, char paramChar)
  {
    a9.f.f(paramString, "<this>");
    return W(paramString, paramInt, paramChar).toString();
  }
  
  private static final e9.c<c9.c> Y(CharSequence paramCharSequence, char[] paramArrayOfChar, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    f0(paramInt2);
    return new e(paramCharSequence, paramInt1, paramInt2, new a(paramArrayOfChar, paramBoolean));
  }
  
  private static final e9.c<c9.c> Z(CharSequence paramCharSequence, String[] paramArrayOfString, int paramInt1, final boolean paramBoolean, int paramInt2)
  {
    f0(paramInt2);
    return new e(paramCharSequence, paramInt1, paramInt2, new b(p8.f.c(paramArrayOfString), paramBoolean));
  }
  
  public static final boolean c0(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence1, "<this>");
    a9.f.f(paramCharSequence2, "other");
    if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 <= paramCharSequence1.length() - paramInt3))
    {
      if (paramInt2 > paramCharSequence2.length() - paramInt3) {
        return false;
      }
      int i = 0;
      while (i < paramInt3)
      {
        if (!c.d(paramCharSequence1.charAt(paramInt1 + i), paramCharSequence2.charAt(paramInt2 + i), paramBoolean)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static String d0(String paramString, CharSequence paramCharSequence)
  {
    a9.f.f(paramString, "<this>");
    a9.f.f(paramCharSequence, "prefix");
    String str = paramString;
    if (m0(paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(paramCharSequence.length());
      a9.f.e(str, "this as java.lang.String).substring(startIndex)");
    }
    return str;
  }
  
  public static String e0(String paramString, CharSequence paramCharSequence)
  {
    a9.f.f(paramString, "<this>");
    a9.f.f(paramCharSequence, "suffix");
    String str = paramString;
    if (E(paramString, paramCharSequence, false, 2, null))
    {
      str = paramString.substring(0, paramString.length() - paramCharSequence.length());
      a9.f.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
    }
    return str;
  }
  
  public static final void f0(int paramInt)
  {
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Limit must be non-negative, but was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString().toString());
  }
  
  public static final List<String> g0(CharSequence paramCharSequence, char[] paramArrayOfChar, boolean paramBoolean, int paramInt)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramArrayOfChar, "delimiters");
    if (paramArrayOfChar.length == 1) {
      return h0(paramCharSequence, String.valueOf(paramArrayOfChar[0]), paramBoolean, paramInt);
    }
    Object localObject = d.a(a0(paramCharSequence, paramArrayOfChar, 0, paramBoolean, paramInt, 2, null));
    paramArrayOfChar = new ArrayList(p8.l.q((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramArrayOfChar.add(n0(paramCharSequence, (c9.c)((Iterator)localObject).next()));
    }
    return paramArrayOfChar;
  }
  
  private static final List<String> h0(CharSequence paramCharSequence, String paramString, boolean paramBoolean, int paramInt)
  {
    f0(paramInt);
    int k = 0;
    int m = J(paramCharSequence, paramString, 0, paramBoolean);
    if ((m != -1) && (paramInt != 1))
    {
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = 0;
      }
      int j = 10;
      if (i != 0) {
        j = c9.g.c(paramInt, 10);
      }
      ArrayList localArrayList = new ArrayList(j);
      j = m;
      int n;
      do
      {
        localArrayList.add(paramCharSequence.subSequence(k, j).toString());
        m = paramString.length() + j;
        if ((i != 0) && (localArrayList.size() == paramInt - 1)) {
          break;
        }
        n = J(paramCharSequence, paramString, m, paramBoolean);
        k = m;
        j = n;
      } while (n != -1);
      localArrayList.add(paramCharSequence.subSequence(m, paramCharSequence.length()).toString());
      return localArrayList;
    }
    return p8.l.d(paramCharSequence.toString());
  }
  
  public static final e9.c<String> j0(CharSequence paramCharSequence, String[] paramArrayOfString, boolean paramBoolean, int paramInt)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramArrayOfString, "delimiters");
    return d.f(b0(paramCharSequence, paramArrayOfString, 0, paramBoolean, paramInt, 2, null), new c(paramCharSequence));
  }
  
  public static final boolean l0(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence1, "<this>");
    a9.f.f(paramCharSequence2, "prefix");
    if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return l.x((String)paramCharSequence1, (String)paramCharSequence2, false, 2, null);
    }
    return c0(paramCharSequence1, 0, paramCharSequence2, 0, paramCharSequence2.length(), paramBoolean);
  }
  
  public static final String n0(CharSequence paramCharSequence, c9.c paramc)
  {
    a9.f.f(paramCharSequence, "<this>");
    a9.f.f(paramc, "range");
    return paramCharSequence.subSequence(paramc.h().intValue(), paramc.g().intValue() + 1).toString();
  }
  
  public static CharSequence o0(CharSequence paramCharSequence)
  {
    a9.f.f(paramCharSequence, "<this>");
    int j = paramCharSequence.length() - 1;
    int i = 0;
    int k = 0;
    while (i <= j)
    {
      int m;
      if (k == 0) {
        m = i;
      } else {
        m = j;
      }
      boolean bool = b.c(paramCharSequence.charAt(m));
      if (k == 0)
      {
        if (!bool) {
          k = 1;
        } else {
          i += 1;
        }
      }
      else
      {
        if (!bool) {
          break;
        }
        j -= 1;
      }
    }
    return paramCharSequence.subSequence(i, j + 1);
  }
  
  public static final boolean z(CharSequence paramCharSequence, char paramChar, boolean paramBoolean)
  {
    a9.f.f(paramCharSequence, "<this>");
    return l.M(paramCharSequence, paramChar, 0, paramBoolean, 2, null) >= 0;
  }
  
  static final class a
    extends a9.g
    implements z8.c<CharSequence, Integer, h<? extends Integer, ? extends Integer>>
  {
    a(char[] paramArrayOfChar, boolean paramBoolean)
    {
      super();
    }
    
    public final h<Integer, Integer> d(CharSequence paramCharSequence, int paramInt)
    {
      a9.f.f(paramCharSequence, "$this$$receiver");
      paramInt = v.O(paramCharSequence, this.b, paramInt, paramBoolean);
      if (paramInt < 0) {
        return null;
      }
      return o8.l.a(Integer.valueOf(paramInt), Integer.valueOf(1));
    }
  }
  
  static final class b
    extends a9.g
    implements z8.c<CharSequence, Integer, h<? extends Integer, ? extends Integer>>
  {
    b(List<String> paramList, boolean paramBoolean)
    {
      super();
    }
    
    public final h<Integer, Integer> d(CharSequence paramCharSequence, int paramInt)
    {
      a9.f.f(paramCharSequence, "$this$$receiver");
      paramCharSequence = v.y(paramCharSequence, this.b, paramInt, paramBoolean, false);
      if (paramCharSequence != null) {
        return o8.l.a(paramCharSequence.c(), Integer.valueOf(((String)paramCharSequence.d()).length()));
      }
      return null;
    }
  }
  
  static final class c
    extends a9.g
    implements z8.b<c9.c, String>
  {
    c(CharSequence paramCharSequence)
    {
      super();
    }
    
    public final String d(c9.c paramc)
    {
      a9.f.f(paramc, "it");
      return v.n0(this.b, paramc);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.v
 * JD-Core Version:    0.7.0.1
 */