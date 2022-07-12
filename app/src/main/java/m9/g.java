package m9;

import c9.a;
import f9.h;
import f9.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import l9.z;
import v8.c;

public final class g
{
  private static final j a = new j("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final j b = new j(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  
  public static final boolean a(z paramz, Object paramObject)
  {
    a9.f.f(paramz, "<this>");
    return ((paramObject instanceof z)) && (a9.f.a(((z)paramObject).c(), paramz.c()));
  }
  
  public static final int b(z paramz)
  {
    a9.f.f(paramz, "<this>");
    return paramz.c().hashCode();
  }
  
  public static final String c(z paramz, String paramString)
  {
    a9.f.f(paramz, "<this>");
    a9.f.f(paramString, "name");
    int j = paramz.d().length;
    int i = 0;
    j = c.c(0, j - 1, 2);
    if (j >= 0) {
      for (;;)
      {
        if (f9.l.l(paramz.d()[i], paramString, true)) {
          return paramz.d()[(i + 1)];
        }
        if (i == j) {
          break;
        }
        i += 2;
      }
    }
    return null;
  }
  
  public static final z d(String paramString)
  {
    a9.f.f(paramString, "<this>");
    Object localObject1 = l.y(a, paramString, 0);
    if (localObject1 != null)
    {
      String str1 = (String)((h)localObject1).a().get(1);
      Object localObject2 = Locale.ROOT;
      String str2 = str1.toLowerCase((Locale)localObject2);
      a9.f.e(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
      String str3 = ((String)((h)localObject1).a().get(2)).toLowerCase((Locale)localObject2);
      a9.f.e(str3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((h)localObject1).c();
      int j = ((a)localObject1).b() + 1;
      if (j < paramString.length())
      {
        h localh = l.y(b, paramString, j);
        int i;
        if (localh != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject1 = localh.b().get(1);
          if (localObject1 == null) {
            str1 = null;
          } else {
            str1 = ((f9.f)localObject1).a();
          }
          if (str1 == null) {}
          for (;;)
          {
            localObject1 = localh.c();
            break;
            localObject1 = localh.b().get(2);
            if (localObject1 == null) {
              localObject1 = null;
            } else {
              localObject1 = ((f9.f)localObject1).a();
            }
            if (localObject1 == null)
            {
              localObject1 = localh.b().get(3);
              a9.f.c(localObject1);
              localObject2 = ((f9.f)localObject1).a();
            }
            else
            {
              localObject2 = localObject1;
              if (f9.l.x((String)localObject1, "'", false, 2, null))
              {
                localObject2 = localObject1;
                if (f9.l.k((String)localObject1, "'", false, 2, null))
                {
                  localObject2 = localObject1;
                  if (((String)localObject1).length() > 2)
                  {
                    localObject2 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
                    a9.f.e(localObject2, "this as java.lang.String…ing(startIndex, endIndex)");
                  }
                }
              }
            }
            localArrayList.add(str1);
            localArrayList.add(localObject2);
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Parameter is not formatted correctly: \"");
        localObject2 = paramString.substring(j);
        a9.f.e(localObject2, "this as java.lang.String).substring(startIndex)");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("\" for: \"");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append('"');
        throw new IllegalArgumentException(((StringBuilder)localObject1).toString().toString());
      }
      localObject1 = localArrayList.toArray(new String[0]);
      Objects.requireNonNull(localObject1, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      return new z(paramString, str2, str3, (String[])localObject1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No subtype found for: \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append('"');
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public static final z e(String paramString)
  {
    a9.f.f(paramString, "<this>");
    try
    {
      paramString = d(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      label13:
      break label13;
    }
    return null;
  }
  
  public static final String f(z paramz)
  {
    a9.f.f(paramz, "<this>");
    return paramz.c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.g
 * JD-Core Version:    0.7.0.1
 */