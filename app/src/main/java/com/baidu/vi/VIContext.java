package com.baidu.vi;

import android.content.Context;

public class VIContext
{
  static Context a;
  
  public static Context getContext()
  {
    return a;
  }
  
  public static void init(Context paramContext)
  {
    a = paramContext;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.VIContext
 * JD-Core Version:    0.7.0.1
 */