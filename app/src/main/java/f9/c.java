package f9;

class c
  extends b
{
  public static final boolean d(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (!paramBoolean) {
      return false;
    }
    paramChar1 = Character.toUpperCase(paramChar1);
    paramChar2 = Character.toUpperCase(paramChar2);
    paramBoolean = bool;
    if (paramChar1 != paramChar2)
    {
      if (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2)) {
        return true;
      }
      paramBoolean = false;
    }
    return paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.c
 * JD-Core Version:    0.7.0.1
 */