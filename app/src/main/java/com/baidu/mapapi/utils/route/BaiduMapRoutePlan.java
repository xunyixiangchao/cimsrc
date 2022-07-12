package com.baidu.mapapi.utils.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.IllegalNaviArgumentException;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapapi.utils.a;
import com.baidu.mapapi.utils.poi.IllegalPoiSearchArgumentException;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

public class BaiduMapRoutePlan
{
  private static boolean a = true;
  
  private static void a(RouteParaOption paramRouteParaOption, Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://api.map.baidu.com/direction?");
    localStringBuilder.append("origin=");
    Object localObject2 = paramRouteParaOption.a;
    CoordType localCoordType2 = SDKInitializer.getCoordType();
    CoordType localCoordType1 = CoordType.GCJ02;
    Object localObject1 = localObject2;
    if (localCoordType2 == localCoordType1)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
    }
    if (paramRouteParaOption.a != null)
    {
      localObject2 = paramRouteParaOption.c;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (localObject1 != null))
      {
        localStringBuilder.append("latlng:");
        localStringBuilder.append(((LatLng)localObject1).latitude);
        localStringBuilder.append(",");
        localStringBuilder.append(((LatLng)localObject1).longitude);
        localStringBuilder.append("|");
        localStringBuilder.append("name:");
        break label194;
      }
    }
    if ((paramRouteParaOption.a != null) && (localObject1 != null))
    {
      localStringBuilder.append(((LatLng)localObject1).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).longitude);
    }
    else
    {
      label194:
      localStringBuilder.append(paramRouteParaOption.c);
    }
    localObject2 = paramRouteParaOption.b;
    localObject1 = localObject2;
    if (SDKInitializer.getCoordType() == localCoordType1)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = CoordTrans.gcjToBaidu((LatLng)localObject2);
      }
    }
    localStringBuilder.append("&destination=");
    if (paramRouteParaOption.b != null)
    {
      localObject2 = paramRouteParaOption.d;
      if ((localObject2 != null) && (!((String)localObject2).equals("")) && (localObject1 != null))
      {
        localStringBuilder.append("latlng:");
        localStringBuilder.append(((LatLng)localObject1).latitude);
        localStringBuilder.append(",");
        localStringBuilder.append(((LatLng)localObject1).longitude);
        localStringBuilder.append("|");
        localStringBuilder.append("name:");
        break label372;
      }
    }
    if ((paramRouteParaOption.b != null) && (localObject1 != null))
    {
      localStringBuilder.append(((LatLng)localObject1).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(((LatLng)localObject1).longitude);
    }
    else
    {
      label372:
      localStringBuilder.append(paramRouteParaOption.d);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localObject1 = "";
        } else {
          localObject1 = "walking";
        }
      }
      else {
        localObject1 = "transit";
      }
    }
    else {
      localObject1 = "driving";
    }
    localStringBuilder.append("&mode=");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("&region=");
    if ((paramRouteParaOption.getCityName() != null) && (!paramRouteParaOption.getCityName().equals(""))) {
      paramRouteParaOption = paramRouteParaOption.getCityName();
    } else {
      paramRouteParaOption = "全国";
    }
    localStringBuilder.append(paramRouteParaOption);
    localStringBuilder.append("&output=html");
    localStringBuilder.append("&src=");
    localStringBuilder.append(paramContext.getPackageName());
    paramRouteParaOption = Uri.parse(localStringBuilder.toString());
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("android.intent.action.VIEW");
    ((Intent)localObject1).setFlags(268435456);
    ((Intent)localObject1).setData(paramRouteParaOption);
    paramContext.startActivity((Intent)localObject1);
  }
  
  public static void finish(Context paramContext)
  {
    if (paramContext != null) {
      a.j(paramContext);
    }
  }
  
  public static boolean openBaiduMapDrivingRoute(RouteParaOption paramRouteParaOption, Context paramContext)
  {
    if ((paramRouteParaOption != null) && (paramContext != null))
    {
      String str = paramRouteParaOption.c;
      if ((str == null) && (paramRouteParaOption.a == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
      }
      if ((paramRouteParaOption.d == null) && (paramRouteParaOption.b == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
      }
      if (((TextUtils.isEmpty(str)) && (paramRouteParaOption.a == null)) || ((TextUtils.isEmpty(paramRouteParaOption.d)) && (paramRouteParaOption.b == null)))
      {
        Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
        return false;
      }
      if (paramRouteParaOption.f == null) {
        paramRouteParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
      }
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 810) {
          return a.a(paramRouteParaOption, paramContext, 0);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (a)
        {
          a(paramRouteParaOption, paramContext, 0);
          return true;
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
      }
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
      if (a)
      {
        a(paramRouteParaOption, paramContext, 0);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapNewEnergyRoute(RouteParaOption paramRouteParaOption, Context paramContext)
  {
    if ((paramRouteParaOption != null) && (paramContext != null))
    {
      String str = paramRouteParaOption.c;
      if ((str == null) && (paramRouteParaOption.a == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
      }
      if ((paramRouteParaOption.d == null) && (paramRouteParaOption.b == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
      }
      if (((TextUtils.isEmpty(str)) && (paramRouteParaOption.a == null)) || ((TextUtils.isEmpty(paramRouteParaOption.d)) && (paramRouteParaOption.b == null)))
      {
        Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
        return false;
      }
      if (paramRouteParaOption.f == null) {
        paramRouteParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
      }
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 810) {
          return a.a(paramRouteParaOption, paramContext, 101);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (a)
        {
          a(paramRouteParaOption, paramContext, 101);
          return true;
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
      }
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
      if (a)
      {
        a(paramRouteParaOption, paramContext, 101);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapTransitRoute(RouteParaOption paramRouteParaOption, Context paramContext)
  {
    if ((paramRouteParaOption != null) && (paramContext != null))
    {
      String str = paramRouteParaOption.c;
      if ((str == null) && (paramRouteParaOption.a == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
      }
      if ((paramRouteParaOption.d == null) && (paramRouteParaOption.b == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
      }
      if (((TextUtils.isEmpty(str)) && (paramRouteParaOption.a == null)) || ((TextUtils.isEmpty(paramRouteParaOption.d)) && (paramRouteParaOption.b == null)))
      {
        Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
        return false;
      }
      if (paramRouteParaOption.f == null) {
        paramRouteParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
      }
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 810) {
          return a.a(paramRouteParaOption, paramContext, 1);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (a)
        {
          a(paramRouteParaOption, paramContext, 1);
          return true;
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
      }
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
      if (a)
      {
        a(paramRouteParaOption, paramContext, 1);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapTruckRoute(RouteParaOption paramRouteParaOption, Context paramContext)
  {
    if ((paramRouteParaOption != null) && (paramContext != null))
    {
      String str = paramRouteParaOption.c;
      if ((str == null) && (paramRouteParaOption.a == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
      }
      if ((paramRouteParaOption.d == null) && (paramRouteParaOption.b == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
      }
      if (((TextUtils.isEmpty(str)) && (paramRouteParaOption.a == null)) || ((TextUtils.isEmpty(paramRouteParaOption.d)) && (paramRouteParaOption.b == null)))
      {
        Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
        return false;
      }
      if (paramRouteParaOption.f == null) {
        paramRouteParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
      }
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 810) {
          return a.a(paramRouteParaOption, paramContext, 102);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (a)
        {
          a(paramRouteParaOption, paramContext, 7);
          return true;
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
      }
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
      if (a)
      {
        a(paramRouteParaOption, paramContext, 7);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapWalkingRoute(RouteParaOption paramRouteParaOption, Context paramContext)
  {
    if ((paramRouteParaOption != null) && (paramContext != null))
    {
      String str = paramRouteParaOption.c;
      if ((str == null) && (paramRouteParaOption.a == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: startPoint and startName not all null.");
      }
      if ((paramRouteParaOption.d == null) && (paramRouteParaOption.b == null)) {
        throw new IllegalNaviArgumentException("BDMapSDKException: endPoint and endName not all null.");
      }
      if (((TextUtils.isEmpty(str)) && (paramRouteParaOption.a == null)) || ((TextUtils.isEmpty(paramRouteParaOption.d)) && (paramRouteParaOption.b == null)))
      {
        Log.e(BaiduMapRoutePlan.class.getName(), "poi startName or endName can not be empty string while pt is null");
        return false;
      }
      if (paramRouteParaOption.f == null) {
        paramRouteParaOption.f = RouteParaOption.EBusStrategyType.bus_recommend_way;
      }
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 810) {
          return a.a(paramRouteParaOption, paramContext, 2);
        }
        Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
        if (a)
        {
          a(paramRouteParaOption, paramContext, 2);
          return true;
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
      }
      Log.e("baidumapsdk", "BaiduMap app is not installed.");
      if (a)
      {
        a(paramRouteParaOption, paramContext, 2);
        return true;
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static void setSupportWebRoute(boolean paramBoolean)
  {
    a = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.route.BaiduMapRoutePlan
 * JD-Core Version:    0.7.0.1
 */