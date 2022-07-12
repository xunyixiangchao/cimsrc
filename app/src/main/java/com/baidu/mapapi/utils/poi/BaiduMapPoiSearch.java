package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.OpenClientUtil;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.pano.a.b;
import com.baidu.platform.comapi.pano.b;
import java.util.List;

public class BaiduMapPoiSearch
{
  private static boolean a = true;
  
  private static void a(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("http://api.map.baidu.com/place/detail?");
    ((StringBuilder)localObject).append("uid=");
    ((StringBuilder)localObject).append(paramPoiParaOption.a);
    ((StringBuilder)localObject).append("&output=html");
    ((StringBuilder)localObject).append("&src=");
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    paramPoiParaOption = Uri.parse(((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(paramPoiParaOption);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void b(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://api.map.baidu.com/place/search?");
    localStringBuilder.append("query=");
    localStringBuilder.append(paramPoiParaOption.b);
    localStringBuilder.append("&location=");
    LatLng localLatLng = paramPoiParaOption.c;
    Object localObject = localLatLng;
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      localObject = CoordTrans.gcjToBaidu(localLatLng);
    }
    localStringBuilder.append(((LatLng)localObject).latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(((LatLng)localObject).longitude);
    localStringBuilder.append("&radius=");
    localStringBuilder.append(paramPoiParaOption.d);
    localStringBuilder.append("&output=html");
    localStringBuilder.append("&src=");
    localStringBuilder.append(paramContext.getPackageName());
    paramPoiParaOption = Uri.parse(localStringBuilder.toString());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(paramPoiParaOption);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void b(String paramString, Context paramContext)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramContext != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("baidumap://map/streetscape?");
        localStringBuilder.append("panoid=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("&pid=");
        localStringBuilder.append(paramString);
        localStringBuilder.append("&panotype=");
        localStringBuilder.append("street");
        localStringBuilder.append("&src=");
        paramString = new StringBuilder();
        paramString.append("sdk_[");
        paramString.append(paramContext.getPackageName());
        paramString.append("]");
        localStringBuilder.append(paramString.toString());
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
        paramString.setFlags(268435456);
        if (paramString.resolveActivity(paramContext.getPackageManager()) != null)
        {
          paramContext.startActivity(paramString);
          return;
        }
        throw new RuntimeException("BDMapSDKException: BaiduMap app is not installed.");
      }
      throw new RuntimeException("BDMapSDKException: context cannot be null.");
    }
    throw new RuntimeException("BDMapSDKException: pano id can not be null.");
  }
  
  public static boolean dispatchPoiToBaiduMap(List<DispathcPoiData> paramList, Context paramContext)
  {
    if ((!paramList.isEmpty()) && (paramList.size() > 0))
    {
      int i = OpenClientUtil.getBaiduMapVersion(paramContext);
      if (i != 0)
      {
        if (i >= 840) {
          return com.baidu.mapapi.utils.a.a(paramList, paramContext, 6);
        }
        paramList = "Baidumap app version is too lowl.Version is greater than 8.4";
      }
      else
      {
        paramList = "BaiduMap app is not installed.";
      }
      Log.e("baidumapsdk", paramList);
      return false;
    }
    throw new NullPointerException("BDMapSDKException: dispatch poidata is null");
  }
  
  public static void finish(Context paramContext)
  {
    if (paramContext != null) {
      com.baidu.mapapi.utils.a.j(paramContext);
    }
  }
  
  public static void openBaiduMapPanoShow(String paramString, Context paramContext)
  {
    new com.baidu.platform.comapi.pano.a().a(paramString, new a(paramContext));
  }
  
  public static boolean openBaiduMapPoiDetialsPage(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    if ((paramPoiParaOption != null) && (paramContext != null))
    {
      String str = paramPoiParaOption.a;
      if (str != null)
      {
        if (!str.equals(""))
        {
          int i = OpenClientUtil.getBaiduMapVersion(paramContext);
          if (i != 0)
          {
            if (i >= 810) {
              return com.baidu.mapapi.utils.a.a(paramPoiParaOption, paramContext, 3);
            }
            Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
            if (a)
            {
              a(paramPoiParaOption, paramContext);
              return true;
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
          }
          Log.e("baidumapsdk", "BaiduMap app is not installed.");
          if (a)
          {
            a(paramPoiParaOption, paramContext);
            return true;
          }
          throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be empty string.");
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi uid can not be null.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static boolean openBaiduMapPoiNearbySearch(PoiParaOption paramPoiParaOption, Context paramContext)
  {
    if ((paramPoiParaOption != null) && (paramContext != null))
    {
      String str = paramPoiParaOption.b;
      if (str != null)
      {
        LatLng localLatLng = paramPoiParaOption.c;
        if (localLatLng != null)
        {
          if ((localLatLng.longitude != 0.0D) && (localLatLng.latitude != 0.0D))
          {
            if (paramPoiParaOption.d != 0)
            {
              if (!str.equals(""))
              {
                int i = OpenClientUtil.getBaiduMapVersion(paramContext);
                if (i != 0)
                {
                  if (i >= 810) {
                    return com.baidu.mapapi.utils.a.a(paramPoiParaOption, paramContext, 4);
                  }
                  Log.e("baidumapsdk", "Baidumap app version is too lowl.Version is greater than 8.1");
                  if (a)
                  {
                    b(paramPoiParaOption, paramContext);
                    return true;
                  }
                  throw new IllegalPoiSearchArgumentException("BDMapSDKException: Baidumap app version is too lowl.Version is greater than 8.1");
                }
                Log.e("baidumapsdk", "BaiduMap app is not installed.");
                if (a)
                {
                  b(paramPoiParaOption, paramContext);
                  return true;
                }
                throw new IllegalPoiSearchArgumentException("BDMapSDKException: BaiduMap app is not installed.");
              }
              throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi key can not be empty string");
            }
            throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search radius larger than 0.");
          }
          throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center longitude or latitude can not be 0.");
        }
        throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search center can not be null.");
      }
      throw new IllegalPoiSearchArgumentException("BDMapSDKException: poi search key can not be null.");
    }
    throw new IllegalPoiSearchArgumentException("BDMapSDKException: para or context can not be null.");
  }
  
  public static void setSupportWebPoi(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  static final class a
    implements a.b<b>
  {
    a(Context paramContext) {}
    
    public void a(HttpClient.HttpStateError paramHttpStateError)
    {
      int i = BaiduMapPoiSearch.b.b[paramHttpStateError.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramHttpStateError = "network inner error, please check network";
      }
      else
      {
        paramHttpStateError = "current network is not available";
      }
      Log.d("baidumapsdk", paramHttpStateError);
    }
    
    public void a(b paramb)
    {
      if (paramb == null)
      {
        Log.d("baidumapsdk", "pano info is null");
        return;
      }
      int i = BaiduMapPoiSearch.b.a[paramb.a().ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            if (paramb.b() == 1)
            {
              paramb = paramb.c();
              try
              {
                BaiduMapPoiSearch.a(paramb, this.a);
                return;
              }
              catch (Exception paramb)
              {
                paramb.printStackTrace();
                return;
              }
            }
            paramb = "this point do not support for pano show";
          }
          else
          {
            paramb = "please check ak for permission";
          }
        }
        else {
          paramb = "pano id not found for this poi point";
        }
      }
      else {
        paramb = "pano uid is error, please check param poi uid";
      }
      Log.d("baidumapsdk", paramb);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.poi.BaiduMapPoiSearch
 * JD-Core Version:    0.7.0.1
 */