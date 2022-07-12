package aa;

import a9.f;

public final class z
{
  public static final long a(String paramString, int paramInt1, int paramInt2)
  {
    f.f(paramString, "<this>");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          long l = 0L;
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            if (k < 128)
            {
              l += 1L;
              label89:
              paramInt1 += 1;
            }
            else
            {
              if (k < 2048) {}
              for (i = 2;; i = 3)
              {
                l += i;
                break label89;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                  {
                    l += 4;
                    paramInt1 += 2;
                    break;
                  }
                  l += 1L;
                  paramInt1 = j;
                  break;
                }
              }
            }
          }
          return l;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("endIndex > string.length: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" > ");
        localStringBuilder.append(paramString.length());
        throw new IllegalArgumentException(localStringBuilder.toString().toString());
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString().toString());
    }
    throw new IllegalArgumentException(f.m("beginIndex < 0: ", Integer.valueOf(paramInt1)).toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.z
 * JD-Core Version:    0.7.0.1
 */