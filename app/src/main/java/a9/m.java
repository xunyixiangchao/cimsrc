package a9;

import b9.a;
import b9.b;
import java.util.List;

public class m
{
  public static List a(Object paramObject)
  {
    if (((paramObject instanceof a)) && (!(paramObject instanceof b))) {
      e(paramObject, "kotlin.collections.MutableList");
    }
    return b(paramObject);
  }
  
  public static List b(Object paramObject)
  {
    try
    {
      paramObject = (List)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw d(paramObject);
    }
  }
  
  private static <T extends Throwable> T c(T paramT)
  {
    return f.l(paramT, m.class.getName());
  }
  
  public static ClassCastException d(ClassCastException paramClassCastException)
  {
    throw ((ClassCastException)c(paramClassCastException));
  }
  
  public static void e(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" cannot be cast to ");
    localStringBuilder.append(paramString);
    f(localStringBuilder.toString());
  }
  
  public static void f(String paramString)
  {
    throw d(new ClassCastException(paramString));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.m
 * JD-Core Version:    0.7.0.1
 */