package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comapi.util.d;
import com.baidu.platform.comjni.engine.NAEngine;

public class f
{
  private static int a;
  private static Context b = ;
  
  static
  {
    if (!Initializer.isInitialized()) {
      NativeLoader.getInstance().loadLibrary(com.baidu.mapapi.VersionInfo.getKitName());
    }
    if (com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion()))
    {
      NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
      return;
    }
    throw new BaiduMapSDKException("the version of map is not match with base");
  }
  
  public static void a()
  {
    a -= 1;
    if (OpenLogUtil.isMapLogEnable())
    {
      com.baidu.mapsdkplatform.comapi.commonutils.b localb = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicMap destroy mRef = ");
      localStringBuilder.append(a);
      localb.a(localStringBuilder.toString());
    }
    if (a == 0)
    {
      com.baidu.mapsdkplatform.comapi.commonutils.b.a().c();
      com.baidu.platform.comapi.b.a();
    }
  }
  
  public static void b()
  {
    if (a == 0)
    {
      if (b == null)
      {
        Log.e("BDMapSDK", "you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        return;
      }
      com.baidu.mapsdkplatform.comapi.commonutils.b.a().b();
      com.baidu.platform.comapi.b.a((Application)b, true, false, false, true);
      com.baidu.platform.comapi.b.c();
      com.baidu.platform.comapi.b.a(new a());
      d.a();
      BNLongLink.initLongLink();
      NAEngine.b();
      NAEngine.startRunningRequest();
      SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
      SysUpdateObservable.getInstance().init("");
    }
    a += 1;
    if (OpenLogUtil.isMapLogEnable())
    {
      com.baidu.mapsdkplatform.comapi.commonutils.b localb = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicMap init mRef = ");
      localStringBuilder.append(a);
      localb.a(localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.f
 * JD-Core Version:    0.7.0.1
 */