package f9;

import c9.c;

class b
{
  public static int a(int paramInt)
  {
    if (new c(2, 36).f(paramInt)) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("radix ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" was not in valid range ");
    localStringBuilder.append(new c(2, 36));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static final int b(char paramChar, int paramInt)
  {
    return Character.digit(paramChar, paramInt);
  }
  
  public static final boolean c(char paramChar)
  {
    return (Character.isWhitespace(paramChar)) || (Character.isSpaceChar(paramChar));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.b
 * JD-Core Version:    0.7.0.1
 */