package com.baidu.platform.comapi.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.platform.comjni.map.commonmemcache.NACommonMemCache;
import com.baidu.vi.VIContext;
import java.io.File;

public class d
{
  private static NACommonMemCache a = new NACommonMemCache();
  
  public static void a() {}
  
  public static NACommonMemCache b()
  {
    return a;
  }
  
  private static void c()
  {
    JsonBuilder localJsonBuilder = new JsonBuilder();
    Object localObject1 = Build.MODEL;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Android");
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    localObject2 = ((StringBuilder)localObject2).toString();
    String str = SyncSysInfo.initPhoneInfo();
    a.a(str);
    localJsonBuilder.object();
    localJsonBuilder.putStringValue("pd", "map");
    localJsonBuilder.putStringValue("ov", (String)localObject2);
    localJsonBuilder.putStringValue("ver", "2");
    localJsonBuilder.key("sw").value(SysOSUtil.getInstance().getScreenWidth());
    localJsonBuilder.key("sh").value(SysOSUtil.getInstance().getScreenHeight());
    localJsonBuilder.putStringValue("channel", "oem");
    localJsonBuilder.putStringValue("mb", (String)localObject1);
    localJsonBuilder.putStringValue("sv", SyncSysInfo.getSoftWareVer());
    localJsonBuilder.putStringValue("os", "android");
    localJsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(SysOSUtil.getInstance().getOutputDirPath());
    ((StringBuilder)localObject1).append("/udc/");
    localJsonBuilder.putStringValue("path", ((StringBuilder)localObject1).toString());
    localJsonBuilder.endObject();
    a.a("logstatistics", localJsonBuilder.getJson());
    localJsonBuilder.reset();
    localJsonBuilder.object();
    localJsonBuilder.putStringValue("cuid", SyncSysInfo.getCid());
    localJsonBuilder.putStringValue("app", "1");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(VIContext.getContext().getCacheDir().getAbsolutePath());
    ((StringBuilder)localObject1).append("/");
    localJsonBuilder.putStringValue("path", ((StringBuilder)localObject1).toString());
    localJsonBuilder.putStringValue("domain", "");
    localJsonBuilder.endObject();
    a.a("longlink", localJsonBuilder.getJson());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.d
 * JD-Core Version:    0.7.0.1
 */