package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class e
{
  private static final int a;
  private static final int b;
  
  static
  {
    int i = Runtime.getRuntime().availableProcessors();
    a = i;
    b = Math.min(i * 2 + 1, 8);
  }
  
  public static ExecutorService a(String paramString)
  {
    int i = b;
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    paramString = new ThreadPoolExecutor(i, i, 60L, localTimeUnit, new LinkedBlockingQueue(), new b(paramString));
    try
    {
      paramString.setKeepAliveTime(60L, localTimeUnit);
      paramString.allowCoreThreadTimeOut(true);
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.e
 * JD-Core Version:    0.7.0.1
 */