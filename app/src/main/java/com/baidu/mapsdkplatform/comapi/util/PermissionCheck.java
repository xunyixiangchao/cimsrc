package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionCheck
{
  private static final String a = "PermissionCheck";
  private static Context b;
  private static String c;
  private static Hashtable<String, String> d;
  private static LBSAuthManager e;
  private static LBSAuthManagerListener f;
  private static d g;
  private static int h = 601;
  private static boolean i = false;
  public static int j = 200;
  public static int k = 202;
  public static int l = 252;
  
  public static void destory()
  {
    g = null;
    b = null;
    f = null;
  }
  
  public static int getPermissionResult()
  {
    return h;
  }
  
  public static void init(Context paramContext)
  {
    b = paramContext;
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(b.getPackageName(), 128);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
      localObject = null;
    }
    if ((localObject != null) && (TextUtils.isEmpty(c))) {
      c = ((ApplicationInfo)localObject).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
    if (d == null) {
      d = new Hashtable();
    }
    if (e == null) {
      e = LBSAuthManager.getInstance(b);
    }
    if (f == null) {
      f = new b(null);
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(b.getPackageName(), 0).applicationInfo.loadLabel(b.getPackageManager()).toString();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "";
    }
    Object localObject = f.o();
    try
    {
      localObject = new JSONObject((String)localObject);
      d.put("mb", ((JSONObject)localObject).optString("mb"));
      d.put("os", ((JSONObject)localObject).optString("os"));
      d.put("sv", ((JSONObject)localObject).optString("sv"));
      d.put("imt", "1");
      d.put("net", ((JSONObject)localObject).optString("net"));
      d.put("cpu", ((JSONObject)localObject).optString("cpu"));
      d.put("glr", ((JSONObject)localObject).optString("glr"));
      d.put("glv", ((JSONObject)localObject).optString("glv"));
      d.put("resid", ((JSONObject)localObject).optString("resid"));
      d.put("appid", "-1");
      d.put("ver", "1");
      Hashtable localHashtable = d;
      localHashtable.put("screen", String.format("(%d,%d)", new Object[] { Integer.valueOf(((JSONObject)localObject).optInt("screen_x")), Integer.valueOf(((JSONObject)localObject).optInt("screen_y")) }));
      localHashtable = d;
      localHashtable.put("dpi", String.format("(%d,%d)", new Object[] { Integer.valueOf(((JSONObject)localObject).optInt("dpi_x")), Integer.valueOf(((JSONObject)localObject).optInt("dpi_y")) }));
      d.put("pcn", ((JSONObject)localObject).optString("pcn"));
      d.put("cuid", ((JSONObject)localObject).optString("cuid"));
      d.put("name", paramContext);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int permissionCheck()
  {
    try
    {
      Object localObject1 = e;
      if ((localObject1 != null) && (f != null) && (b != null))
      {
        ((LBSAuthManager)localObject1).setKey(c);
        int m = e.authenticate(false, "lbs_androidmapsdk", d, f);
        if (m != 0)
        {
          localObject1 = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("permission check result is: ");
          localStringBuilder.append(m);
          Log.e((String)localObject1, localStringBuilder.toString());
        }
        return m;
      }
      localObject1 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The authManager is: ");
      localStringBuilder.append(e);
      localStringBuilder.append("; the authCallback is: ");
      localStringBuilder.append(f);
      localStringBuilder.append("; the mContext is: ");
      localStringBuilder.append(b);
      Log.e((String)localObject1, localStringBuilder.toString());
      return 0;
    }
    finally {}
  }
  
  public static void setApiKey(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      c = paramString;
    }
  }
  
  public static void setPermissionCheckResultListener(d paramd)
  {
    g = paramd;
  }
  
  public static void setPrivacyMode(boolean paramBoolean)
  {
    i = paramBoolean;
    if (paramBoolean) {
      permissionCheck();
    }
  }
  
  private static class b
    implements LBSAuthManagerListener
  {
    public void onAuthResult(int paramInt, String paramString)
    {
      if (paramString == null)
      {
        Log.e(PermissionCheck.a(), "The result is null");
        paramInt = PermissionCheck.permissionCheck();
        paramString = PermissionCheck.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAuthResult try permissionCheck result is: ");
        ((StringBuilder)localObject).append(paramInt);
        Log.d(paramString, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = new PermissionCheck.c();
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("status")) {
          ((PermissionCheck.c)localObject).a = paramString.optInt("status");
        }
        if (paramString.has("appid")) {
          ((PermissionCheck.c)localObject).c = paramString.optString("appid");
        }
        if (paramString.has("uid")) {
          ((PermissionCheck.c)localObject).b = paramString.optString("uid");
        }
        if (paramString.has("message")) {
          ((PermissionCheck.c)localObject).d = paramString.optString("message");
        }
        if (paramString.has("token")) {
          ((PermissionCheck.c)localObject).e = paramString.optString("token");
        }
        if (paramString.has("ak_permission")) {
          ((PermissionCheck.c)localObject).f = paramString.optInt("ak_permission");
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      PermissionCheck.a(((PermissionCheck.c)localObject).a);
      if ((PermissionCheck.b() != null) && (PermissionCheck.c())) {
        PermissionCheck.b().a((PermissionCheck.c)localObject);
      }
    }
  }
  
  public static class c
  {
    public int a = 0;
    public String b = "-1";
    public String c = "-1";
    public String d = "";
    public String e;
    public int f;
    
    public String toString()
    {
      return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", new Object[] { a.a(PermissionCheck.d()), PermissionCheck.e(), Integer.valueOf(this.a), this.b, this.c, this.d });
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(PermissionCheck.c paramc);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.PermissionCheck
 * JD-Core Version:    0.7.0.1
 */