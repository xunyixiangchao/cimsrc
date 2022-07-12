package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.mapsdkplatform.comjni.util.a;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
{
  private static a a = new a();
  private static String b = "02";
  private static String c;
  private static String d;
  private static String e;
  private static String f;
  private static int g = 0;
  private static int h = 0;
  private static int i = 0;
  private static String j;
  private static String k = "baidu";
  private static String l = "";
  private static String m = "";
  private static String n = "";
  private static String o;
  private static String p = "-1";
  private static String q = "-1";
  public static Context r;
  public static final int s = Build.VERSION.SDK_INT;
  public static float t = 1.0F;
  private static String u = "";
  private static Map<String, String> v = new HashMap();
  private static String w = "";
  public static String x;
  
  public static String a()
  {
    return k;
  }
  
  public static void a(String paramString)
  {
    j = paramString;
    r();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    p = paramString2;
    q = paramString1;
    r();
  }
  
  public static byte[] a(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        SigningInfo localSigningInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 134217728).signingInfo;
        if (localSigningInfo == null) {
          return null;
        }
        if (localSigningInfo.hasMultipleSigners()) {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 134217728).signingInfo.getApkContentsSigners();
        } else {
          paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 134217728).signingInfo.getSigningCertificateHistory();
        }
      }
      else
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
      }
      if ((paramContext != null) && (paramContext.length > 0))
      {
        paramContext = paramContext[0].toByteArray();
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String b()
  {
    try
    {
      str = LBSAuthManager.getInstance(r).getCUID();
    }
    catch (Exception localException)
    {
      String str;
      label13:
      break label13;
    }
    str = "";
    if (str == null) {
      return "";
    }
    return str;
  }
  
  public static void b(Context paramContext)
  {
    r = paramContext;
    if (paramContext.getFilesDir() != null) {
      o = paramContext.getFilesDir().getAbsolutePath();
    }
    if (paramContext.getCacheDir() != null) {
      paramContext.getCacheDir().getAbsolutePath();
    }
    d = Build.MODEL;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android");
    localStringBuilder.append(Build.VERSION.SDK);
    e = localStringBuilder.toString();
    c = paramContext.getPackageName();
    c(paramContext);
    d(paramContext);
    n();
    u = b();
    v.put("resid", AppMD5.encodeUrlParamsValue(b));
    v.put("channel", AppMD5.encodeUrlParamsValue(a()));
    v.put("mb", AppMD5.encodeUrlParamsValue(j()));
    v.put("sv", AppMD5.encodeUrlParamsValue(m()));
    v.put("os", AppMD5.encodeUrlParamsValue(i()));
    v.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", new Object[] { Integer.valueOf(c()), Integer.valueOf(c()) })));
    v.put("cuid", AppMD5.encodeUrlParamsValue(u));
    v.put("pcn", AppMD5.encodeUrlParamsValue(r.getPackageName()));
    v.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", new Object[] { Integer.valueOf(k()), Integer.valueOf(l()) })));
    paramContext = a;
    if (paramContext != null) {
      paramContext.a();
    }
  }
  
  public static int c()
  {
    return i;
  }
  
  private static void c(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0);
      localObject = VersionInfo.getApiVersion();
      f = (String)localObject;
      if ((localObject != null) && (!((String)localObject).equals(""))) {
        f = f.replace('_', '.');
      }
      int i1 = paramContext.versionCode;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label55:
      break label55;
    }
    f = "1.0.0";
  }
  
  public static String d()
  {
    return o;
  }
  
  private static void d(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (paramContext != null) {
      paramContext = paramContext.getDefaultDisplay();
    } else {
      paramContext = null;
    }
    if (paramContext != null)
    {
      g = paramContext.getWidth();
      h = paramContext.getHeight();
      paramContext.getMetrics(localDisplayMetrics);
    }
    t = localDisplayMetrics.density;
    if (s > 3) {
      i = localDisplayMetrics.densityDpi;
    } else {
      i = 160;
    }
    if (i == 0) {
      i = 160;
    }
  }
  
  public static String e()
  {
    return j;
  }
  
  public static void e(Context paramContext)
  {
    r = paramContext;
  }
  
  public static String f()
  {
    return c;
  }
  
  public static String g()
  {
    if (v == null) {
      return null;
    }
    Object localObject = new Date();
    long l1 = ((Date)localObject).getTime() + ((Date)localObject).getSeconds() * 1000;
    double d1 = l1 / 1000L;
    double d2 = l1 % 1000L / 1000.0D;
    v.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", new Object[] { Double.valueOf(d1 + d2) })));
    localObject = new StringBuilder();
    Iterator localIterator = v.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append((String)localEntry.getKey());
      ((StringBuilder)localObject).append("=");
      ((StringBuilder)localObject).append((String)localEntry.getValue());
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static String h()
  {
    return w;
  }
  
  public static String i()
  {
    return e;
  }
  
  public static String j()
  {
    return d;
  }
  
  public static int k()
  {
    return g;
  }
  
  public static int l()
  {
    return h;
  }
  
  public static String m()
  {
    return f;
  }
  
  private static void n()
  {
    j = "0";
  }
  
  public static String o()
  {
    Object localObject = new JsonBuilder();
    ((JsonBuilder)localObject).object();
    ((JsonBuilder)localObject).putStringValue("cpu", l);
    ((JsonBuilder)localObject).putStringValue("resid", b);
    ((JsonBuilder)localObject).putStringValue("channel", k);
    ((JsonBuilder)localObject).putStringValue("glr", m);
    ((JsonBuilder)localObject).putStringValue("glv", n);
    ((JsonBuilder)localObject).putStringValue("mb", j());
    ((JsonBuilder)localObject).putStringValue("sv", m());
    ((JsonBuilder)localObject).putStringValue("os", i());
    ((JsonBuilder)localObject).key("dpi_x").value(c());
    ((JsonBuilder)localObject).key("dpi_y").value(c());
    ((JsonBuilder)localObject).putStringValue("net", j);
    ((JsonBuilder)localObject).putStringValue("cuid", u);
    ((JsonBuilder)localObject).key("signature").arrayValue();
    byte[] arrayOfByte = a(r);
    if (arrayOfByte != null)
    {
      int i1 = 0;
      while (i1 < arrayOfByte.length)
      {
        ((JsonBuilder)localObject).value(arrayOfByte[i1]);
        i1 += 1;
      }
    }
    ((JsonBuilder)localObject).endArrayValue();
    ((JsonBuilder)localObject).putStringValue("pcn", r.getPackageName());
    ((JsonBuilder)localObject).key("screen_x").value(k());
    ((JsonBuilder)localObject).key("screen_y").value(l());
    ((JsonBuilder)localObject).endObject();
    localObject = ((JsonBuilder)localObject).getJson();
    w = (String)localObject;
    return localObject;
  }
  
  public static void p()
  {
    a locala = a;
    if (locala != null) {
      locala.b();
    }
  }
  
  public static void q() {}
  
  public static void r()
  {
    v.put("net", AppMD5.encodeUrlParamsValue(e()));
    v.put("appid", AppMD5.encodeUrlParamsValue(p));
    v.put("bduid", "");
    JsonBuilder localJsonBuilder = new JsonBuilder();
    localJsonBuilder.object();
    localJsonBuilder.putStringValue("cpu", l);
    localJsonBuilder.putStringValue("resid", b);
    localJsonBuilder.putStringValue("channel", k);
    localJsonBuilder.putStringValue("glr", m);
    localJsonBuilder.putStringValue("glv", n);
    localJsonBuilder.putStringValue("mb", j());
    localJsonBuilder.putStringValue("sv", m());
    localJsonBuilder.putStringValue("os", i());
    localJsonBuilder.key("dpi_x").value(c());
    localJsonBuilder.key("dpi_y").value(c());
    localJsonBuilder.putStringValue("net", j);
    localJsonBuilder.putStringValue("cuid", u);
    localJsonBuilder.putStringValue("pcn", r.getPackageName());
    localJsonBuilder.key("screen_x").value(k());
    localJsonBuilder.key("screen_y").value(l());
    localJsonBuilder.putStringValue("appid", p);
    localJsonBuilder.putStringValue("duid", q);
    if (!TextUtils.isEmpty(x)) {
      localJsonBuilder.putStringValue("token", x);
    }
    localJsonBuilder.endObject();
    SysUpdateObservable.getInstance().updatePhoneInfo(localJsonBuilder.getJson());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.f
 * JD-Core Version:    0.7.0.1
 */