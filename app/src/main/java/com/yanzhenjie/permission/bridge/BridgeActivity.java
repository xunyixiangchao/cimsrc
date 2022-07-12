package com.yanzhenjie.permission.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import l8.c;

public final class BridgeActivity
  extends Activity
{
  static void a(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 5);
    paramc.i(localIntent);
  }
  
  static void b(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 1);
    paramc.i(localIntent);
  }
  
  static void c(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 3);
    paramc.i(localIntent);
  }
  
  static void d(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 7);
    paramc.i(localIntent);
  }
  
  static void e(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 6);
    paramc.i(localIntent);
  }
  
  static void f(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 4);
    paramc.i(localIntent);
  }
  
  static void g(c paramc, String[] paramArrayOfString)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 2);
    localIntent.putExtra("KEY_PERMISSIONS", paramArrayOfString);
    paramc.i(localIntent);
  }
  
  static void h(c paramc)
  {
    Intent localIntent = new Intent(paramc.c(), BridgeActivity.class);
    localIntent.putExtra("KEY_TYPE", 8);
    paramc.i(localIntent);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b.b(this);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent();
    int i;
    switch (paramBundle.getIntExtra("KEY_TYPE", -1))
    {
    default: 
      return;
    case 8: 
      paramBundle = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
      paramBundle.setData(Uri.fromParts("package", getPackageName(), null));
      i = 8;
      break;
    case 7: 
      paramBundle = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
      i = 7;
      break;
    case 6: 
      paramBundle = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
      paramBundle.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
      i = 6;
      break;
    case 5: 
      new h8.a(new l8.a(this)).f(5);
      return;
    case 4: 
      new h8.b(new l8.a(this)).e(4);
      return;
    case 3: 
      paramBundle = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
      paramBundle.setData(Uri.fromParts("package", getPackageName(), null));
      i = 3;
      break;
    case 2: 
      requestPermissions(paramBundle.getStringArrayExtra("KEY_PERMISSIONS"), 2);
      return;
    case 1: 
      paramBundle = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramBundle.setData(Uri.fromParts("package", getPackageName(), null));
      i = 1;
    }
    startActivityForResult(paramBundle, i);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    b.b(this);
    finish();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yanzhenjie.permission.bridge.BridgeActivity
 * JD-Core Version:    0.7.0.1
 */