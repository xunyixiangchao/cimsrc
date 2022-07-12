package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class e
  implements g, ComponentCallbacks2
{
  public void a(Activity paramActivity) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory()
  {
    onTrimMemory(20);
  }
  
  public void onTrimMemory(int paramInt) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.manager.e
 * JD-Core Version:    0.7.0.1
 */