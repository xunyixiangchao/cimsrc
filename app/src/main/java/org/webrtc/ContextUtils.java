package org.webrtc;

import android.content.Context;

public class ContextUtils
{
  private static final String TAG = "ContextUtils";
  private static Context applicationContext;
  
  @Deprecated
  public static Context getApplicationContext()
  {
    return applicationContext;
  }
  
  public static void initialize(Context paramContext)
  {
    if (paramContext != null)
    {
      applicationContext = paramContext;
      return;
    }
    throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.ContextUtils
 * JD-Core Version:    0.7.0.1
 */