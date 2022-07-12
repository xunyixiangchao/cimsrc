package m9;

import a9.b;
import f9.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l9.w;
import l9.w.a;
import o8.h;
import v8.c;

public final class d
{
  private static final String a(char paramChar)
  {
    String str2 = Integer.toString(paramChar, a.a(16));
    a9.f.e(str2, "toString(this, checkRadix(radix))");
    String str1 = str2;
    if (str2.length() < 2) {
      str1 = a9.f.m("0", str2);
    }
    return str1;
  }
  
  public static final w.a b(w.a parama, String paramString1, String paramString2)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString1, "name");
    a9.f.f(paramString2, "value");
    r(paramString1);
    s(paramString2, paramString1);
    d(parama, paramString1, paramString2);
    return parama;
  }
  
  public static final w.a c(w.a parama, w paramw)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramw, "headers");
    int j = paramw.size();
    int i = 0;
    while (i < j)
    {
      d(parama, paramw.c(i), paramw.f(i));
      i += 1;
    }
    return parama;
  }
  
  public static final w.a d(w.a parama, String paramString1, String paramString2)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString1, "name");
    a9.f.f(paramString2, "value");
    parama.g().add(paramString1);
    parama.g().add(f9.l.o0(paramString2).toString());
    return parama;
  }
  
  public static final w e(w.a parama)
  {
    a9.f.f(parama, "<this>");
    parama = parama.g().toArray(new String[0]);
    Objects.requireNonNull(parama, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    return new w((String[])parama);
  }
  
  public static final boolean f(w paramw, Object paramObject)
  {
    a9.f.f(paramw, "<this>");
    return ((paramObject instanceof w)) && (Arrays.equals(paramw.b(), ((w)paramObject).b()));
  }
  
  public static final int g(w paramw)
  {
    a9.f.f(paramw, "<this>");
    return Arrays.hashCode(paramw.b());
  }
  
  public static final String h(String[] paramArrayOfString, String paramString)
  {
    a9.f.f(paramArrayOfString, "namesAndValues");
    a9.f.f(paramString, "name");
    int i = paramArrayOfString.length - 2;
    int j = c.c(i, 0, -2);
    if (j <= i) {
      for (;;)
      {
        if (f9.l.l(paramString, paramArrayOfString[i], true)) {
          return paramArrayOfString[(i + 1)];
        }
        if (i == j) {
          break;
        }
        i -= 2;
      }
    }
    return null;
  }
  
  public static final w i(String... paramVarArgs)
  {
    a9.f.f(paramVarArgs, "inputNamesAndValues");
    int i = paramVarArgs.length;
    int k = 0;
    if (i % 2 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      String[] arrayOfString = (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length);
      int m = arrayOfString.length;
      i = 0;
      while (i < m)
      {
        if (arrayOfString[i] != null) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          arrayOfString[i] = f9.l.o0(paramVarArgs[i]).toString();
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("Headers cannot be null".toString());
        }
      }
      int j = c.c(0, arrayOfString.length - 1, 2);
      if (j >= 0)
      {
        i = k;
        for (;;)
        {
          paramVarArgs = arrayOfString[i];
          String str = arrayOfString[(i + 1)];
          r(paramVarArgs);
          s(str, paramVarArgs);
          if (i == j) {
            break;
          }
          i += 2;
        }
      }
      return new w(arrayOfString);
    }
    throw new IllegalArgumentException("Expected alternating header names and values".toString());
  }
  
  public static final Iterator<h<String, String>> j(w paramw)
  {
    a9.f.f(paramw, "<this>");
    int j = paramw.size();
    h[] arrayOfh = new h[j];
    int i = 0;
    while (i < j)
    {
      arrayOfh[i] = o8.l.a(paramw.c(i), paramw.f(i));
      i += 1;
    }
    return b.a(arrayOfh);
  }
  
  public static final String k(w paramw, int paramInt)
  {
    a9.f.f(paramw, "<this>");
    paramw = (String)p8.f.q(paramw.b(), paramInt * 2);
    if (paramw != null) {
      return paramw;
    }
    paramw = new StringBuilder();
    paramw.append("name[");
    paramw.append(paramInt);
    paramw.append(']');
    throw new IndexOutOfBoundsException(paramw.toString());
  }
  
  public static final w.a l(w paramw)
  {
    a9.f.f(paramw, "<this>");
    w.a locala = new w.a();
    p8.l.t(locala.g(), paramw.b());
    return locala;
  }
  
  public static final w.a m(w.a parama, String paramString)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString, "name");
    int j;
    for (int i = 0; i < parama.g().size(); i = j + 2)
    {
      j = i;
      if (f9.l.l(paramString, (String)parama.g().get(i), true))
      {
        parama.g().remove(i);
        parama.g().remove(i);
        j = i - 2;
      }
    }
    return parama;
  }
  
  public static final w.a n(w.a parama, String paramString1, String paramString2)
  {
    a9.f.f(parama, "<this>");
    a9.f.f(paramString1, "name");
    a9.f.f(paramString2, "value");
    r(paramString1);
    s(paramString2, paramString1);
    parama.h(paramString1);
    d(parama, paramString1, paramString2);
    return parama;
  }
  
  public static final String o(w paramw)
  {
    a9.f.f(paramw, "<this>");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramw.size();
    int i = 0;
    while (i < j)
    {
      String str2 = paramw.c(i);
      String str1 = paramw.f(i);
      localStringBuilder.append(str2);
      localStringBuilder.append(": ");
      if (l.x(str2)) {
        str1 = "██";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append("\n");
      i += 1;
    }
    paramw = localStringBuilder.toString();
    a9.f.e(paramw, "StringBuilder().apply(builderAction).toString()");
    return paramw;
  }
  
  public static final String p(w paramw, int paramInt)
  {
    a9.f.f(paramw, "<this>");
    paramw = (String)p8.f.q(paramw.b(), paramInt * 2 + 1);
    if (paramw != null) {
      return paramw;
    }
    paramw = new StringBuilder();
    paramw.append("value[");
    paramw.append(paramInt);
    paramw.append(']');
    throw new IndexOutOfBoundsException(paramw.toString());
  }
  
  public static final List<String> q(w paramw, String paramString)
  {
    a9.f.f(paramw, "<this>");
    a9.f.f(paramString, "name");
    int j = paramw.size();
    Object localObject3 = null;
    int i = 0;
    Object localObject2;
    for (Object localObject1 = null; i < j; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (f9.l.l(paramString, paramw.c(i), true))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(paramw.f(i));
      }
      i += 1;
    }
    if (localObject1 == null) {
      paramw = localObject3;
    } else {
      paramw = p8.l.J(localObject1);
    }
    paramString = paramw;
    if (paramw == null) {
      paramString = p8.l.h();
    }
    return paramString;
  }
  
  public static final void r(String paramString)
  {
    a9.f.f(paramString, "name");
    int i;
    if (paramString.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      int k = paramString.length();
      i = 0;
      while (i < k)
      {
        char c = paramString.charAt(i);
        int j;
        if (('!' <= c) && (c < '')) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          i += 1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected char 0x");
          localStringBuilder.append(a(c));
          localStringBuilder.append(" at ");
          localStringBuilder.append(i);
          localStringBuilder.append(" in header name: ");
          localStringBuilder.append(paramString);
          throw new IllegalArgumentException(localStringBuilder.toString().toString());
        }
      }
      return;
    }
    throw new IllegalArgumentException("name is empty".toString());
  }
  
  public static final void s(String paramString1, String paramString2)
  {
    a9.f.f(paramString1, "value");
    a9.f.f(paramString2, "name");
    int m = paramString1.length();
    int i = 0;
    while (i < m)
    {
      char c = paramString1.charAt(i);
      int k = 1;
      int j = k;
      if (c != '\t')
      {
        if ((' ' <= c) && (c < '')) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          j = k;
        } else {
          j = 0;
        }
      }
      if (j == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unexpected char 0x");
        localStringBuilder.append(a(c));
        localStringBuilder.append(" at ");
        localStringBuilder.append(i);
        localStringBuilder.append(" in ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" value");
        if (l.x(paramString2)) {
          paramString1 = "";
        } else {
          paramString1 = a9.f.m(": ", paramString1);
        }
        localStringBuilder.append(paramString1);
        throw new IllegalArgumentException(localStringBuilder.toString().toString());
      }
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.d
 * JD-Core Version:    0.7.0.1
 */