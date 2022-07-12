package com.yanzhenjie.permission.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class b
  extends BroadcastReceiver
{
  private final Context a;
  private final a b;
  
  public b(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
  }
  
  public static void b(Context paramContext)
  {
    paramContext.sendBroadcast(new Intent("com.yanzhenjie.permission.bridge"));
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.yanzhenjie.permission.bridge");
    this.a.registerReceiver(this, localIntentFilter);
  }
  
  public void c()
  {
    this.a.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.b.b();
  }
  
  public static abstract interface a
  {
    public abstract void b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yanzhenjie.permission.bridge.b
 * JD-Core Version:    0.7.0.1
 */