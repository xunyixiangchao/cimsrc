package f9;

import a9.f;
import a9.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class n
  extends m
{
  private static final z8.b<String, String> b(String paramString)
  {
    int i;
    if (paramString.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return a.b;
    }
    return new b(paramString);
  }
  
  public static final String c(String paramString1, String paramString2, String paramString3)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "newIndent");
    f.f(paramString3, "marginPrefix");
    if ((u.m(paramString3) ^ true))
    {
      Object localObject = v.V(paramString1);
      int k = paramString1.length();
      int m = paramString2.length();
      int n = ((List)localObject).size();
      z8.b localb = b(paramString2);
      int i1 = p8.l.j((List)localObject);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((Iterable)localObject).iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        paramString1 = localIterator.next();
        if (j < 0) {
          p8.l.p();
        }
        localObject = (String)paramString1;
        paramString2 = null;
        if (((j == 0) || (j == i1)) && (u.m((CharSequence)localObject)))
        {
          paramString1 = null;
        }
        else
        {
          int i2 = ((CharSequence)localObject).length();
          int i = 0;
          while (i < i2)
          {
            if ((b.c(((CharSequence)localObject).charAt(i)) ^ true)) {
              break label192;
            }
            i += 1;
          }
          i = -1;
          label192:
          if ((i != -1) && (l.w((String)localObject, paramString3, i, false, 4, null)))
          {
            i2 = paramString3.length();
            f.d(localObject, "null cannot be cast to non-null type java.lang.String");
            paramString2 = ((String)localObject).substring(i + i2);
            f.e(paramString2, "this as java.lang.String).substring(startIndex)");
          }
          paramString1 = (String)localObject;
          if (paramString2 != null)
          {
            paramString1 = (String)localb.c(paramString2);
            if (paramString1 == null) {
              paramString1 = (String)localObject;
            }
          }
        }
        if (paramString1 != null) {
          localArrayList.add(paramString1);
        }
        j += 1;
      }
      paramString1 = ((StringBuilder)p8.l.z(localArrayList, new StringBuilder(k + m * n), "\n", null, null, 0, null, null, 124, null)).toString();
      f.e(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
      return paramString1;
    }
    throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
  }
  
  public static final String d(String paramString1, String paramString2)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "marginPrefix");
    return c(paramString1, "", paramString2);
  }
  
  static final class a
    extends g
    implements z8.b<String, String>
  {
    public static final a b = new a();
    
    a()
    {
      super();
    }
    
    public final String d(String paramString)
    {
      f.f(paramString, "line");
      return paramString;
    }
  }
  
  static final class b
    extends g
    implements z8.b<String, String>
  {
    b(String paramString)
    {
      super();
    }
    
    public final String d(String paramString)
    {
      f.f(paramString, "line");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.n
 * JD-Core Version:    0.7.0.1
 */