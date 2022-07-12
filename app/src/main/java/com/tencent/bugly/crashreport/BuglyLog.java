package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.aa;

public class BuglyLog
{
  public static void d(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.d(str, paramString1);
    }
    aa.a("D", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1);
    }
    aa.a("E", str, paramString1);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.e(str, paramString1, paramThrowable);
    }
    aa.a("E", str, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.i(str, paramString1);
    }
    aa.a("I", str, paramString1);
  }
  
  public static void setCache(int paramInt)
  {
    aa.a(paramInt);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.v(str, paramString1);
    }
    aa.a("V", str, paramString1);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "null";
    }
    if (b.c) {
      Log.w(str, paramString1);
    }
    aa.a("W", str, paramString1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.BuglyLog
 * JD-Core Version:    0.7.0.1
 */