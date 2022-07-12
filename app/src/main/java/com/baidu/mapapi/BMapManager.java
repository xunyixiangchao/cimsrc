package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.a;

public class BMapManager
{
  public static void destroy()
  {
    a.e().c();
  }
  
  public static Context getContext()
  {
    try
    {
      Context localContext = a.e().d();
      return localContext;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
    return null;
  }
  
  public static void init()
  {
    try
    {
      a.e().f();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.BMapManager
 * JD-Core Version:    0.7.0.1
 */