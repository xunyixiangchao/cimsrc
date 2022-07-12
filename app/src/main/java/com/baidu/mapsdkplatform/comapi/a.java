package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck.d;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.c;
import com.baidu.mapsdkplatform.comapi.util.f;

public class a
  implements PermissionCheck.d
{
  private static a e;
  private static int f = -100;
  private Context a;
  private Handler b;
  private b c;
  private int d;
  
  static
  {
    NativeLoader.getInstance().loadLibrary("gnustl_shared");
    NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
    com.baidu.mapsdkplatform.comjni.tools.a.a();
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    Context localContext = this.a;
    if (localContext != null)
    {
      b localb = this.c;
      if (localb != null) {
        localContext.registerReceiver(localb, localIntentFilter);
      }
    }
  }
  
  private void a(Message paramMessage)
  {
    Object localObject;
    if (this.a == null)
    {
      localObject = JNIInitializer.getCachedContext();
      this.a = ((Context)localObject);
      if (localObject == null) {
        return;
      }
    }
    if (paramMessage.what == 2012)
    {
      if (paramMessage.arg1 == 0)
      {
        paramMessage = new Intent("permission check ok");
      }
      else
      {
        localObject = new Intent("permission check error");
        ((Intent)localObject).putExtra("error_code", paramMessage.arg1);
        ((Intent)localObject).putExtra("error_message", (String)paramMessage.obj);
        paramMessage = (Message)localObject;
      }
    }
    else
    {
      if (paramMessage.arg2 == 3)
      {
        localObject = new Intent("network error");
        this.a.sendBroadcast((Intent)localObject);
      }
      int i = paramMessage.arg2;
      if ((i != 2) && (i != 404) && (i != 5) && (i != 8)) {
        return;
      }
      paramMessage = new Intent("network error");
    }
    this.a.sendBroadcast(paramMessage);
  }
  
  private void b()
  {
    b localb = this.c;
    if (localb != null)
    {
      Context localContext = this.a;
      if (localContext != null) {
        localContext.unregisterReceiver(localb);
      }
    }
  }
  
  public static a e()
  {
    if (e == null) {
      e = new a();
    }
    return e;
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(PermissionCheck.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (paramc.a == 0)
    {
      f.x = paramc.e;
      f.a(paramc.b, paramc.c);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Authentication Error\n");
      ((StringBuilder)localObject).append(paramc.toString());
      Log.e("baidumapsdk", ((StringBuilder)localObject).toString());
    }
    int i = paramc.a;
    if ((i != PermissionCheck.k) && (i != PermissionCheck.j) && (i != PermissionCheck.l)) {
      c.a().a(paramc.f);
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      i = paramc.a;
      if (i != f)
      {
        f = i;
        localObject = ((Handler)localObject).obtainMessage();
        ((Message)localObject).what = 2012;
        ((Message)localObject).arg1 = paramc.a;
        ((Message)localObject).obj = paramc.d;
        this.b.sendMessage((Message)localObject);
      }
    }
  }
  
  public void c()
  {
    int i = this.d - 1;
    this.d = i;
    if (i == 0)
    {
      b();
      f.q();
    }
  }
  
  public Context d()
  {
    if (this.a == null) {
      this.a = JNIInitializer.getCachedContext();
    }
    return this.a;
  }
  
  public void f()
  {
    if (this.d == 0)
    {
      if (this.a == null)
      {
        Context localContext = JNIInitializer.getCachedContext();
        this.a = localContext;
        if (localContext == null)
        {
          Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
          return;
        }
      }
      this.c = new b();
      a();
      SysUpdateObservable.getInstance().updateNetworkInfo(this.a);
    }
    this.d += 1;
  }
  
  public boolean g()
  {
    if (this.a == null)
    {
      Context localContext = JNIInitializer.getCachedContext();
      this.a = localContext;
      if (localContext == null)
      {
        Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        return false;
      }
    }
    f.e(this.a);
    if (!Initializer.isAgreePrivacyMode()) {
      PermissionCheck.setPrivacyMode(false);
    } else {
      PermissionCheck.setPrivacyMode(true);
    }
    this.b = new a();
    f.b(this.a);
    c.a().a(this.a);
    f.r();
    PermissionCheck.init(this.a);
    PermissionCheck.setPermissionCheckResultListener(this);
    PermissionCheck.permissionCheck();
    if (Initializer.isAgreePrivacyMode()) {
      return true;
    }
    throw new BaiduMapSDKException("not agree privacyMode, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      a.a(a.this, paramMessage);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.a
 * JD-Core Version:    0.7.0.1
 */