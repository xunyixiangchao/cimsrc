package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

public abstract interface SysUpdateObserver
{
  public abstract void init(String paramString);
  
  public abstract void updateNetworkInfo(Context paramContext);
  
  public abstract void updateNetworkProxy(Context paramContext);
  
  public abstract void updatePhoneInfo(String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
 * JD-Core Version:    0.7.0.1
 */