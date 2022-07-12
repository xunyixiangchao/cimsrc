package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

public class JNIInitializer
{
  private static Context a;
  
  public static Context getCachedContext()
  {
    return a;
  }
  
  public static void setContext(Application paramApplication)
  {
    if (paramApplication != null)
    {
      if (a == null) {
        a = paramApplication;
      }
      VIContext.init(paramApplication);
      return;
    }
    throw new RuntimeException();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.JNIInitializer
 * JD-Core Version:    0.7.0.1
 */