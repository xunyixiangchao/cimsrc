package f9;

import a9.f;
import c9.g;

class x
  extends w
{
  public static String p0(String paramString, int paramInt)
  {
    f.f(paramString, "<this>");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramString = paramString.substring(0, g.c(paramInt, paramString.length()));
      f.e(paramString, "this as java.lang.String…ing(startIndex, endIndex)");
      return paramString;
    }
    paramString = new StringBuilder();
    paramString.append("Requested character count ");
    paramString.append(paramInt);
    paramString.append(" is less than zero.");
    throw new IllegalArgumentException(paramString.toString().toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.x
 * JD-Core Version:    0.7.0.1
 */