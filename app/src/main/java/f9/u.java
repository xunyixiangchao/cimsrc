package f9;

import a9.f;
import c9.a;
import c9.g;
import java.util.Collection;
import java.util.Iterator;
import p8.a0;
import p8.b.a;

class u
  extends t
{
  public static String h(char[] paramArrayOfChar)
  {
    f.f(paramArrayOfChar, "<this>");
    return new String(paramArrayOfChar);
  }
  
  public static String i(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    f.f(paramArrayOfChar, "<this>");
    p8.b.a.a(paramInt1, paramInt2, paramArrayOfChar.length);
    return new String(paramArrayOfChar, paramInt1, paramInt2 - paramInt1);
  }
  
  public static final boolean j(String paramString1, String paramString2, boolean paramBoolean)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "suffix");
    if (!paramBoolean) {
      return paramString1.endsWith(paramString2);
    }
    return n(paramString1, paramString1.length() - paramString2.length(), paramString2, 0, paramString2.length(), true);
  }
  
  public static boolean l(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    if (!paramBoolean) {
      return paramString1.equals(paramString2);
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public static final boolean m(CharSequence paramCharSequence)
  {
    f.f(paramCharSequence, "<this>");
    int i = paramCharSequence.length();
    boolean bool = false;
    if (i != 0)
    {
      Object localObject = v.G(paramCharSequence);
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
      } while (b.c(paramCharSequence.charAt(((a0)localObject).a())));
      i = 0;
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static final boolean n(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "other");
    if (!paramBoolean) {
      return paramString1.regionMatches(paramInt1, paramString2, paramInt2, paramInt3);
    }
    return paramString1.regionMatches(paramBoolean, paramInt1, paramString2, paramInt2, paramInt3);
  }
  
  public static String p(CharSequence paramCharSequence, int paramInt)
  {
    f.f(paramCharSequence, "<this>");
    int k = 0;
    int j;
    if (paramInt >= 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          j = paramCharSequence.length();
          localObject1 = localObject2;
          if (j != 0)
          {
            if (j != 1)
            {
              localObject1 = new StringBuilder(paramCharSequence.length() * paramInt);
              localObject2 = new c9.c(1, paramInt).d();
              while (((Iterator)localObject2).hasNext())
              {
                ((a0)localObject2).a();
                ((StringBuilder)localObject1).append(paramCharSequence);
              }
              paramCharSequence = ((StringBuilder)localObject1).toString();
              f.e(paramCharSequence, "{\n                    va…tring()\n                }");
              return paramCharSequence;
            }
            int i = paramCharSequence.charAt(0);
            paramCharSequence = new char[paramInt];
            j = k;
            while (j < paramInt)
            {
              paramCharSequence[j] = i;
              j += 1;
            }
            return new String(paramCharSequence);
          }
        }
        else
        {
          localObject1 = paramCharSequence.toString();
        }
      }
      return localObject1;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Count 'n' must be non-negative, but was ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append('.');
    throw new IllegalArgumentException(paramCharSequence.toString().toString());
  }
  
  public static final String q(String paramString, char paramChar1, char paramChar2, boolean paramBoolean)
  {
    f.f(paramString, "<this>");
    if (!paramBoolean) {
      paramString = paramString.replace(paramChar1, paramChar2);
    }
    for (Object localObject = "this as java.lang.String…replace(oldChar, newChar)";; localObject = "StringBuilder(capacity).…builderAction).toString()")
    {
      f.e(paramString, (String)localObject);
      return paramString;
      localObject = new StringBuilder(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        char c2 = paramString.charAt(i);
        char c1 = c2;
        if (c.d(c2, paramChar1, paramBoolean)) {
          c1 = paramChar2;
        }
        ((StringBuilder)localObject).append(c1);
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString();
    }
  }
  
  public static final String r(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "oldValue");
    f.f(paramString3, "newValue");
    int j = 0;
    int i = v.J(paramString1, paramString2, 0, paramBoolean);
    if (i < 0) {
      return paramString1;
    }
    int n = paramString2.length();
    int i1 = g.b(n, 1);
    int k = paramString1.length() - n + paramString3.length();
    if (k >= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(k);
      int m;
      do
      {
        localStringBuilder.append(paramString1, j, i);
        localStringBuilder.append(paramString3);
        k = i + n;
        if (i >= paramString1.length()) {
          break;
        }
        m = v.J(paramString1, paramString2, i + i1, paramBoolean);
        j = k;
        i = m;
      } while (m > 0);
      localStringBuilder.append(paramString1, k, paramString1.length());
      paramString1 = localStringBuilder.toString();
      f.e(paramString1, "stringBuilder.append(this, i, length).toString()");
      return paramString1;
    }
    throw new OutOfMemoryError();
  }
  
  public static boolean u(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2, paramInt);
    }
    return n(paramString1, paramInt, paramString2, 0, paramString2.length(), paramBoolean);
  }
  
  public static boolean v(String paramString1, String paramString2, boolean paramBoolean)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "prefix");
    if (!paramBoolean) {
      return paramString1.startsWith(paramString2);
    }
    return n(paramString1, 0, paramString2, 0, paramString2.length(), paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.u
 * JD-Core Version:    0.7.0.1
 */