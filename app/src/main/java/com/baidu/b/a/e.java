package com.baidu.b.a;

import com.baidu.b.c.a.c;
import com.baidu.b.c.a.g;
import java.lang.reflect.Method;

public class e
{
  public static String a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = g.a();
    return new String(c.a(arrayOfByte, arrayOfByte, paramArrayOfByte));
  }
  
  public static Method a(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  public static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
    
    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.a.e
 * JD-Core Version:    0.7.0.1
 */