package com.baidu.lbsapi.auth;

import android.util.Log;

class a
{
  public static boolean a = false;
  private static String b = "BaiduApiAuth";
  
  public static String a()
  {
    StackTraceElement localStackTraceElement = new java.lang.Throwable().getStackTrace()[2];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localStackTraceElement.getFileName());
    localStringBuilder.append("[");
    localStringBuilder.append(localStackTraceElement.getLineNumber());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    if (a)
    {
      if (Thread.currentThread().getStackTrace().length == 0) {
        return;
      }
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(";");
      localStringBuilder.append(paramString);
      Log.d(str, localStringBuilder.toString());
    }
  }
  
  public static void b(String paramString)
  {
    if (Thread.currentThread().getStackTrace().length == 0) {
      return;
    }
    Log.i(b, paramString);
  }
  
  public static void c(String paramString)
  {
    if (a)
    {
      if (Thread.currentThread().getStackTrace().length == 0) {
        return;
      }
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append(";");
      localStringBuilder.append(paramString);
      Log.e(str, localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.a
 * JD-Core Version:    0.7.0.1
 */