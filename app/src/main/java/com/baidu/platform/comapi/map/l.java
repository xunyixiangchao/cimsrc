package com.baidu.platform.comapi.map;

import android.util.Log;

public final class l
{
  static boolean a = false;
  
  static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MapTrace-");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("thread:");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(":");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(",");
      localStringBuilder.append(paramString2);
      Log.d(paramString1, localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.l
 * JD-Core Version:    0.7.0.1
 */