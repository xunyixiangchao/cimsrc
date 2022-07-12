package x7;

import java.util.Objects;

public final class a
{
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static <T> T b(T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x7.a
 * JD-Core Version:    0.7.0.1
 */