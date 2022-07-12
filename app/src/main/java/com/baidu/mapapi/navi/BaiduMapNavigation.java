package com.baidu.mapapi.navi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduMapNavigation
{
  private static boolean a = true;
  
  private static String a(Context paramContext)
  {
    localObject = null;
    try
    {
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      PackageManager localPackageManager;
      label23:
      label27:
      break label23;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = localObject;
      break label27;
    }
    localPackageManager = null;
    paramContext = localObject;
    return (String)localPackageManager.getApplicationLabel(paramContext);
  }
  
  private static void a(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      Object localObject1 = paramNaviParaOption.a;
      if ((localObject1 != null) && (paramNaviParaOption.c != null))
      {
        Object localObject2 = CoordUtil.ll2mc((LatLng)localObject1);
        GeoPoint localGeoPoint = CoordUtil.ll2mc(paramNaviParaOption.c);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("http://app.navi.baidu.com/mobile/#navi/naving/");
        ((StringBuilder)localObject1).append("&sy=0");
        ((StringBuilder)localObject1).append("&endp=");
        ((StringBuilder)localObject1).append("&start=");
        ((StringBuilder)localObject1).append("&startwd=");
        ((StringBuilder)localObject1).append("&endwd=");
        ((StringBuilder)localObject1).append("&fromprod=map_sdk");
        ((StringBuilder)localObject1).append("&app_version=");
        ((StringBuilder)localObject1).append("7_5_0");
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject2 = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        try
        {
          localJSONObject2.put("type", "1");
          Object localObject3 = paramNaviParaOption.b;
          if ((localObject3 != null) && (!((String)localObject3).equals(""))) {
            localJSONObject2.put("keyword", paramNaviParaOption.b);
          } else {
            localJSONObject2.put("keyword", "");
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(String.valueOf(((GeoPoint)localObject2).getLongitudeE6()));
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(String.valueOf(((GeoPoint)localObject2).getLatitudeE6()));
          localJSONObject2.put("xy", ((StringBuilder)localObject3).toString());
          localJSONArray.put(localJSONObject2);
          localJSONObject1.put("type", "1");
          localObject2 = paramNaviParaOption.d;
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            localJSONObject2.put("keyword", paramNaviParaOption.d);
          } else {
            localJSONObject2.put("keyword", "");
          }
          paramNaviParaOption = new StringBuilder();
          paramNaviParaOption.append(String.valueOf(localGeoPoint.getLongitudeE6()));
          paramNaviParaOption.append(",");
          paramNaviParaOption.append(String.valueOf(localGeoPoint.getLatitudeE6()));
          localJSONObject1.put("xy", paramNaviParaOption.toString());
          localJSONArray.put(localJSONObject1);
        }
        catch (JSONException paramNaviParaOption)
        {
          paramNaviParaOption.printStackTrace();
        }
        if (localJSONArray.length() > 0)
        {
          ((StringBuilder)localObject1).append("&positions=");
          ((StringBuilder)localObject1).append(localJSONArray.toString());
        }
        ((StringBuilder)localObject1).append("&ctrl_type=");
        ((StringBuilder)localObject1).append("&mrsl=");
        ((StringBuilder)localObject1).append("/vt=map&state=entry");
        paramNaviParaOption = Uri.parse(((StringBuilder)localObject1).toString());
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("android.intent.action.VIEW");
        ((Intent)localObject1).setFlags(268435456);
        ((Intent)localObject1).setData(paramNaviParaOption);
        paramContext.startActivity((Intent)localObject1);
        return;
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static void finish(Context paramContext)
  {
    if (paramContext != null) {
      a.j(paramContext);
    }
  }
  
  public static boolean openBaiduMapBikeNavi(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      if ((paramNaviParaOption.c != null) && (paramNaviParaOption.a != null))
      {
        int i = OpenClientUtil.getBaiduMapVersion(paramContext);
        if (i != 0) {
          if (i >= 869) {
            return a.a(paramNaviParaOption, paramContext, 8);
          }
        }
        for (paramNaviParaOption = "Baidumap app version is too lowl.Version is greater than 8.6.6";; paramNaviParaOption = "BaiduMap app is not installed.")
        {
          Log.e("baidumapsdk", paramNaviParaOption);
          return false;
        }
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapNavi(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      if ((paramNaviParaOption.c != null) && (paramNaviParaOption.a != null))
      {
        int i = OpenClientUtil.getBaiduMapVersion(paramContext);
        if (i != 0)
        {
          if (i >= 830) {
            return a.a(paramNaviParaOption, paramContext, 5);
          }
          Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.2");
          if (a)
          {
            a(paramNaviParaOption, paramContext);
            return true;
          }
          throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.2");
        }
        Log.e("baidumapsdk", "BaiduMap app is not installed.");
        if (a)
        {
          a(paramNaviParaOption, paramContext);
          return true;
        }
        throw new BaiduMapAppNotSupportNaviException("BDMapSDKException: BaiduMap app is not installed.");
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapWalkNavi(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      if ((paramNaviParaOption.c != null) && (paramNaviParaOption.a != null))
      {
        int i = OpenClientUtil.getBaiduMapVersion(paramContext);
        if (i != 0) {
          if (i >= 869) {
            return a.a(paramNaviParaOption, paramContext, 7);
          }
        }
        for (paramNaviParaOption = "Baidumap app version is too lowl.Version is greater than 8.6.6";; paramNaviParaOption = "BaiduMap app is not installed.")
        {
          Log.e("baidumapsdk", paramNaviParaOption);
          return false;
        }
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapWalkNaviAR(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      if ((paramNaviParaOption.c != null) && (paramNaviParaOption.a != null))
      {
        int i = OpenClientUtil.getBaiduMapVersion(paramContext);
        if (i != 0) {
          if (i >= 869) {
            return a.a(paramNaviParaOption, paramContext, 9);
          }
        }
        for (paramNaviParaOption = "Baidumap app version is too lowl.Version is greater than 8.6.6";; paramNaviParaOption = "BaiduMap app is not installed.")
        {
          Log.e("baidumapsdk", paramNaviParaOption);
          return false;
        }
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: start point or end point can not be null.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  @Deprecated
  public static void openWebBaiduMapNavi(NaviParaOption paramNaviParaOption, Context paramContext)
  {
    if ((paramNaviParaOption != null) && (paramContext != null))
    {
      Object localObject = paramNaviParaOption.a;
      if ((localObject != null) && (paramNaviParaOption.c != null))
      {
        localObject = CoordUtil.ll2mc((LatLng)localObject);
        paramNaviParaOption = CoordUtil.ll2mc(paramNaviParaOption.c);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("http://daohang.map.baidu.com/mobile/#navi/naving/start=");
        localStringBuilder.append(((GeoPoint)localObject).getLongitudeE6());
        localStringBuilder.append(",");
        localStringBuilder.append(((GeoPoint)localObject).getLatitudeE6());
        localStringBuilder.append("&endp=");
        localStringBuilder.append(paramNaviParaOption.getLongitudeE6());
        localStringBuilder.append(",");
        localStringBuilder.append(paramNaviParaOption.getLatitudeE6());
        localStringBuilder.append("&fromprod=");
        localStringBuilder.append(a(paramContext));
        localStringBuilder.append("/vt=map&state=entry");
        localObject = Uri.parse(localStringBuilder.toString());
        paramNaviParaOption = new Intent();
        paramNaviParaOption.setAction("android.intent.action.VIEW");
        paramNaviParaOption.setFlags(268435456);
      }
      for (;;)
      {
        paramNaviParaOption.setData((Uri)localObject);
        paramContext.startActivity(paramNaviParaOption);
        return;
        localObject = paramNaviParaOption.b;
        if ((localObject == null) || (((String)localObject).equals(""))) {
          break;
        }
        localObject = paramNaviParaOption.d;
        if ((localObject == null) || (((String)localObject).equals(""))) {
          break;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("http://daohang.map.baidu.com/mobile/#search/search/qt=nav&sn=2$$$$$$");
        ((StringBuilder)localObject).append(paramNaviParaOption.b);
        ((StringBuilder)localObject).append("$$$$$$&en=2$$$$$$");
        ((StringBuilder)localObject).append(paramNaviParaOption.d);
        ((StringBuilder)localObject).append("$$$$$$&fromprod=");
        ((StringBuilder)localObject).append(a(paramContext));
        localObject = Uri.parse(((StringBuilder)localObject).toString());
        paramNaviParaOption = new Intent();
        paramNaviParaOption.setAction("android.intent.action.VIEW");
      }
      throw new IllegalNaviArgumentException("BDMapSDKException: you must set start and end point or set the start and end name.");
    }
    throw new IllegalNaviArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static void setSupportWebNavi(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.navi.BaiduMapNavigation
 * JD-Core Version:    0.7.0.1
 */