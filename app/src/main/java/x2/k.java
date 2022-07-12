package x2;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class k
{
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException("Must not be null or empty");
  }
  
  public static <T extends Collection<Y>, Y> T c(T paramT)
  {
    if (!paramT.isEmpty()) {
      return paramT;
    }
    throw new IllegalArgumentException("Must not be empty.");
  }
  
  public static <T> T d(T paramT)
  {
    return e(paramT, "Argument must not be null");
  }
  
  public static <T> T e(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.k
 * JD-Core Version:    0.7.0.1
 */