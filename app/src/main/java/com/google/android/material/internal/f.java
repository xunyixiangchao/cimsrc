package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

public class f
{
  public static boolean a()
  {
    return (b()) || (d());
  }
  
  public static boolean b()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
  }
  
  public static boolean c()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu");
  }
  
  public static boolean d()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.f
 * JD-Core Version:    0.7.0.1
 */