package x0;

import java.util.Objects;

public class c
{
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return Objects.equals(paramObject1, paramObject2);
  }
  
  public static int b(Object... paramVarArgs)
  {
    return Objects.hash(paramVarArgs);
  }
  
  public static <T> T c(T paramT, String paramString)
  {
    Objects.requireNonNull(paramT, paramString);
    return paramT;
  }
  
  public static String d(Object paramObject, String paramString)
  {
    if (paramObject != null) {
      paramString = paramObject.toString();
    }
    return paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x0.c
 * JD-Core Version:    0.7.0.1
 */