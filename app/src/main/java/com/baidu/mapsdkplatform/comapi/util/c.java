package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class c
{
  private int a;
  private Context b;
  
  private int a(String paramString)
  {
    Context localContext = this.b;
    if (localContext == null) {
      return -101;
    }
    return localContext.getSharedPreferences("ad_auth", 0).getInt(paramString, 0);
  }
  
  public static c a()
  {
    return b.a();
  }
  
  private void a(String paramString, int paramInt)
  {
    Context localContext = this.b;
    if (localContext == null) {
      return;
    }
    localContext.getSharedPreferences("ad_auth", 0).edit().putInt(paramString, paramInt).apply();
  }
  
  public void a(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1)
    {
      paramInt = a("ad_key");
      i = paramInt;
      if (paramInt == -101) {
        return;
      }
    }
    this.a = i;
    a("ad_key", i);
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public boolean b()
  {
    int i = this.a;
    return (i >= 0) && ((i & 0x1) == 1);
  }
  
  public boolean c()
  {
    int i = this.a;
    return (i >= 0) && ((i & 0x400) == 1024);
  }
  
  private static class b
  {
    private static final c a = new c(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.c
 * JD-Core Version:    0.7.0.1
 */