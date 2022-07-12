package h9;

import i9.c;
import i9.d;

class b
{
  private static String a(String paramString)
  {
    paramString = paramString.toLowerCase();
    Object localObject = paramString;
    if (paramString.matches("[a-z]*[1-5]?"))
    {
      if (paramString.matches("[a-z]*[1-5]"))
      {
        int n = Character.getNumericValue(paramString.charAt(paramString.length() - 1));
        int m = 97;
        int j = paramString.indexOf('a');
        int i = paramString.indexOf('e');
        int k = paramString.indexOf("ou");
        if (-1 != j)
        {
          i = m;
        }
        else if (-1 != i)
        {
          k = 101;
          j = i;
          i = k;
        }
        else if (-1 != k)
        {
          i = "ou".charAt(0);
          j = k;
        }
        else
        {
          j = paramString.length() - 1;
          while (j >= 0)
          {
            if (String.valueOf(paramString.charAt(j)).matches("[aeiouv]"))
            {
              i = paramString.charAt(j);
              break label162;
            }
            j -= 1;
          }
          i = 36;
          j = -1;
        }
        label162:
        localObject = paramString;
        if (36 != i)
        {
          localObject = paramString;
          if (-1 != j)
          {
            char c = "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt("aeiouv".indexOf(i) * 5 + (n - 1));
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.substring(0, j).replaceAll("v", "ü"));
            ((StringBuilder)localObject).append(c);
            ((StringBuilder)localObject).append(paramString.substring(j + 1, paramString.length() - 1).replaceAll("v", "ü"));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        return localObject;
      }
      localObject = paramString.replaceAll("v", "ü");
    }
    return localObject;
  }
  
  static String b(String paramString, i9.b paramb)
  {
    c localc = c.d;
    if ((localc == paramb.b()) && ((d.c == paramb.c()) || (d.b == paramb.c()))) {
      throw new j9.a("tone marks cannot be added to v or u:");
    }
    if (c.c == paramb.b())
    {
      str = paramString.replaceAll("[1-5]", "");
    }
    else
    {
      str = paramString;
      if (localc == paramb.b()) {
        str = a(paramString.replaceAll("u:", "v"));
      }
    }
    if (d.c == paramb.c())
    {
      paramString = str.replaceAll("u:", "v");
    }
    else
    {
      paramString = str;
      if (d.d == paramb.c()) {
        paramString = str.replaceAll("u:", "ü");
      }
    }
    String str = paramString;
    if (i9.a.b == paramb.a()) {
      str = paramString.toUpperCase();
    }
    return str;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h9.b
 * JD-Core Version:    0.7.0.1
 */