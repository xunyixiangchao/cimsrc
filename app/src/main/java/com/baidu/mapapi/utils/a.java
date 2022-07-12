package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.AppTools;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.navi.NaviParaOption;
import com.baidu.mapapi.navi.TruckNaviOption;
import com.baidu.mapapi.utils.poi.DispathcPoiData;
import com.baidu.mapapi.utils.poi.PoiParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption;
import com.baidu.mapapi.utils.route.RouteParaOption.EBusStrategyType;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.IComOpenClient.a;
import com.baidu.mapframework.open.aidl.b.a;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.verify.SignUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static double A = 0.0D;
  private static double B = 0.0D;
  private static double C = 0.0D;
  private static int D = 0;
  private static boolean E = false;
  private static String F;
  private static int G = 0;
  private static int H = 0;
  private static int I = 0;
  private static int J = 0;
  private static int K = 0;
  static ServiceConnection L = new b();
  private static final String a = "com.baidu.mapapi.utils.a";
  private static com.baidu.mapframework.open.aidl.a b;
  private static IComOpenClient c;
  public static int d = -1;
  private static int e;
  private static String f;
  private static String g;
  private static String h;
  private static List<DispathcPoiData> i = new ArrayList();
  private static LatLng j = null;
  private static LatLng k = null;
  private static String l = null;
  private static String m = null;
  private static String n = null;
  private static String o;
  private static RouteParaOption.EBusStrategyType p;
  private static String q = null;
  private static String r = null;
  private static LatLng s = null;
  private static int t = 0;
  private static boolean u = false;
  private static boolean v = false;
  private static Thread w;
  private static int x;
  private static double y;
  private static double z;
  
  public static String a(Context paramContext)
  {
    localObject = null;
    try
    {
      localPackageManager = paramContext.getPackageManager();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      PackageManager localPackageManager;
      label20:
      label24:
      break label20;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = localObject;
      break label24;
    }
    localPackageManager = null;
    paramContext = localObject;
    return (String)localPackageManager.getApplicationLabel(paramContext);
  }
  
  public static void a(int paramInt, Context paramContext)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5) {
            if (paramInt != 7) {
              if (paramInt != 8) {
                if (paramInt == 9) {}
              }
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        return;
      case 104: 
        c(paramContext);
        return;
      case 103: 
        b(paramContext);
        return;
        g(paramContext);
        return;
        d(paramContext);
        return;
        f(paramContext);
        return;
        e(paramContext);
        return;
        i(paramContext);
        return;
        h(paramContext);
        return;
      }
    }
    c(paramContext, paramInt);
  }
  
  private static void a(Context paramContext, final int paramInt)
  {
    Intent localIntent = new Intent();
    String str = m();
    if (str == null) {
      return;
    }
    localIntent.putExtra("api_token", str);
    localIntent.setAction("com.baidu.map.action.OPEN_SERVICE");
    localIntent.setPackage("com.baidu.BaiduMap");
    if (paramInt != 9) {
      v = paramContext.bindService(localIntent, L, 1);
    }
    if (v)
    {
      paramContext = new Thread(new c(paramContext, paramInt));
      w = paramContext;
      paramContext.setDaemon(true);
      w.start();
      return;
    }
    Log.e("baidumapsdk", "bind service failed，call openapi");
    a(paramInt, paramContext);
  }
  
  private static void a(TruckNaviOption paramTruckNaviOption)
  {
    x = 0;
    y = 0.0D;
    z = 0.0D;
    A = 0.0D;
    B = 0.0D;
    C = 0.0D;
    D = 0;
    E = false;
    F = null;
    G = 0;
    H = 0;
    I = 0;
    J = 0;
    K = 0;
    if (paramTruckNaviOption.getNaviRoutePolicy() != null) {
      o = paramTruckNaviOption.getNaviRoutePolicy();
    }
    Object localObject = paramTruckNaviOption.getWayPoint();
    if (localObject != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("viaPoints", localObject);
        localObject = localJSONObject.toString();
        try
        {
          n = URLEncoder.encode((String)localObject, "utf-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        x = paramTruckNaviOption.getTruckType();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    y = paramTruckNaviOption.getHeight();
    z = paramTruckNaviOption.getWidth();
    A = paramTruckNaviOption.getWeight();
    B = paramTruckNaviOption.getLength();
    C = paramTruckNaviOption.getAxleWeight();
    D = paramTruckNaviOption.getAxleCount();
    E = paramTruckNaviOption.getIsTrailer();
    F = paramTruckNaviOption.getPlateNumber();
    G = paramTruckNaviOption.getPlateColor();
    H = paramTruckNaviOption.getDisplacement();
    I = paramTruckNaviOption.getPowerType();
    J = paramTruckNaviOption.getEmissionLimit();
    K = paramTruckNaviOption.getLoadWeight();
  }
  
  private static void a(List<DispathcPoiData> paramList, Context paramContext)
  {
    f = paramContext.getPackageName();
    g = a(paramContext);
    h = "";
    paramContext = i;
    if (paramContext != null) {
      paramContext.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramContext = (DispathcPoiData)paramList.next();
      i.add(paramContext);
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt != 101) && (paramInt != 102)) {
      switch (paramInt)
      {
      default: 
        return false;
      case 8: 
        return k();
      case 7: 
        return l();
      case 6: 
        return f();
      case 5: 
        return j();
      case 4: 
        return h();
      case 3: 
        return g();
      }
    }
    return i();
  }
  
  public static boolean a(NaviParaOption paramNaviParaOption, Context paramContext, int paramInt)
  {
    b(paramNaviParaOption, paramContext, paramInt);
    return b(paramContext, paramInt);
  }
  
  public static boolean a(PoiParaOption paramPoiParaOption, Context paramContext, int paramInt)
  {
    b(paramPoiParaOption, paramContext, paramInt);
    return b(paramContext, paramInt);
  }
  
  public static boolean a(RouteParaOption paramRouteParaOption, Context paramContext, int paramInt)
  {
    b(paramRouteParaOption, paramContext, paramInt);
    return b(paramContext, paramInt);
  }
  
  public static boolean a(List<DispathcPoiData> paramList, Context paramContext, int paramInt)
  {
    a(paramList, paramContext);
    return b(paramContext, paramInt);
  }
  
  private static void b(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/navi?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      j = CoordTrans.gcjToBaidu(j);
      k = CoordTrans.gcjToBaidu(k);
    }
    ((StringBuilder)localObject).append("origin=");
    ((StringBuilder)localObject).append(j.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(j.longitude);
    ((StringBuilder)localObject).append("&location=");
    ((StringBuilder)localObject).append(k.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(k.longitude);
    ((StringBuilder)localObject).append("&src=");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk_[");
    localStringBuilder.append(f);
    localStringBuilder.append("]");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(n))
    {
      ((StringBuilder)localObject).append("&viaPoints=");
      ((StringBuilder)localObject).append(n);
    }
    ((StringBuilder)localObject).append("&type=");
    ((StringBuilder)localObject).append(o);
    ((StringBuilder)localObject).append("&mode=");
    ((StringBuilder)localObject).append("neweng");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void b(NaviParaOption paramNaviParaOption, Context paramContext, int paramInt)
  {
    f = paramContext.getPackageName();
    l = null;
    j = null;
    m = null;
    k = null;
    n = null;
    if (paramNaviParaOption.getStartPoint() != null) {
      j = paramNaviParaOption.getStartPoint();
    }
    if (paramNaviParaOption.getEndPoint() != null) {
      k = paramNaviParaOption.getEndPoint();
    }
    if (paramNaviParaOption.getStartName() != null) {
      l = paramNaviParaOption.getStartName();
    }
    if (paramNaviParaOption.getEndName() != null) {
      m = paramNaviParaOption.getEndName();
    }
    if (paramNaviParaOption.getNaviRoutePolicy() != null) {
      o = paramNaviParaOption.getNaviRoutePolicy();
    }
    paramContext = paramNaviParaOption.getWayPoint();
    if (paramContext != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("viaPoints", paramContext);
        paramContext = localJSONObject.toString();
        try
        {
          n = URLEncoder.encode(paramContext, "utf-8");
        }
        catch (UnsupportedEncodingException paramContext)
        {
          paramContext.printStackTrace();
        }
        if (!(paramNaviParaOption instanceof TruckNaviOption)) {
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    a((TruckNaviOption)paramNaviParaOption);
  }
  
  private static void b(PoiParaOption paramPoiParaOption, Context paramContext, int paramInt)
  {
    q = null;
    r = null;
    s = null;
    t = 0;
    f = paramContext.getPackageName();
    if (paramPoiParaOption.getUid() != null) {
      q = paramPoiParaOption.getUid();
    }
    if (paramPoiParaOption.getKey() != null) {
      r = paramPoiParaOption.getKey();
    }
    if (paramPoiParaOption.getCenter() != null) {
      s = paramPoiParaOption.getCenter();
    }
    if (paramPoiParaOption.getRadius() != 0) {
      t = paramPoiParaOption.getRadius();
    }
  }
  
  private static void b(RouteParaOption paramRouteParaOption, Context paramContext, int paramInt)
  {
    l = null;
    j = null;
    m = null;
    k = null;
    f = paramContext.getPackageName();
    if (paramRouteParaOption.getStartPoint() != null) {
      j = paramRouteParaOption.getStartPoint();
    }
    if (paramRouteParaOption.getEndPoint() != null) {
      k = paramRouteParaOption.getEndPoint();
    }
    if (paramRouteParaOption.getStartName() != null) {
      l = paramRouteParaOption.getStartName();
    }
    if (paramRouteParaOption.getEndName() != null) {
      m = paramRouteParaOption.getEndName();
    }
    if (paramRouteParaOption.getBusStrategyType() != null) {
      p = paramRouteParaOption.getBusStrategyType();
    }
    int i1;
    if (paramInt != 0)
    {
      i1 = 1;
      if (paramInt != 1)
      {
        i1 = 2;
        if (paramInt != 2)
        {
          i1 = 101;
          if (paramInt != 101)
          {
            i1 = 102;
            if (paramInt == 102) {}
          }
        }
      }
    }
    else
    {
      i1 = 0;
    }
    e = i1;
  }
  
  public static boolean b(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!SignUtils.verifySign(paramContext))
        {
          Log.d(a, "package sign verify failed");
          return false;
        }
        u = false;
        switch (paramInt)
        {
        case 9: 
          d = 9;
          break;
        case 8: 
          d = 8;
          break;
        case 7: 
          d = 7;
          break;
        case 6: 
          d = 6;
          break;
        case 5: 
          d = 5;
          break;
        case 4: 
          d = 4;
          break;
        case 3: 
          d = 3;
          break;
        case 2: 
          d = 2;
          break;
        case 1: 
          d = 1;
          break;
        case 0: 
          d = 0;
          continue;
          d = 104;
          continue;
          d = 103;
          continue;
          d = 102;
          continue;
          d = 101;
          if (paramInt == 9) {
            v = false;
          }
          com.baidu.mapframework.open.aidl.a locala = b;
          if ((locala != null) && (v))
          {
            if (c != null)
            {
              u = true;
              return a(paramInt);
            }
            locala.a(new a(paramInt));
            return true;
          }
          a(paramContext, paramInt);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return true;
      }
      switch (paramInt)
      {
      }
    }
  }
  
  private static void c(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/truck/navigation?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      k = CoordTrans.gcjToBaidu(k);
    }
    ((StringBuilder)localObject).append("location=");
    ((StringBuilder)localObject).append(k.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(k.longitude);
    ((StringBuilder)localObject).append("&src=");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk_[");
    localStringBuilder.append(f);
    localStringBuilder.append("]");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(n))
    {
      ((StringBuilder)localObject).append("&viaPoints=");
      ((StringBuilder)localObject).append(n);
    }
    ((StringBuilder)localObject).append("&type=");
    ((StringBuilder)localObject).append(o);
    int i1 = x;
    if ((i1 > 0) && (i1 <= 4))
    {
      ((StringBuilder)localObject).append("&truck_type=");
      ((StringBuilder)localObject).append(x);
      double d1 = y;
      if ((d1 > 0.0D) && (d1 <= 10.0D))
      {
        ((StringBuilder)localObject).append("&height=");
        ((StringBuilder)localObject).append(y);
        d1 = z;
        if ((d1 > 0.0D) && (d1 <= 5.0D))
        {
          ((StringBuilder)localObject).append("&width=");
          ((StringBuilder)localObject).append(z);
          d1 = A;
          if ((d1 > 0.0D) && (d1 <= 100.0D))
          {
            ((StringBuilder)localObject).append("&weight=");
            ((StringBuilder)localObject).append(A);
            d1 = B;
            if ((d1 > 0.0D) && (d1 <= 25.0D))
            {
              ((StringBuilder)localObject).append("&length=");
              ((StringBuilder)localObject).append(B);
              d1 = C;
              if ((d1 >= 0.0D) && (d1 <= 100.0D))
              {
                ((StringBuilder)localObject).append("&axle_weight=");
                ((StringBuilder)localObject).append(C);
              }
              i1 = D;
              if ((i1 > 1) && (i1 <= 8))
              {
                ((StringBuilder)localObject).append("&axle_count=");
                ((StringBuilder)localObject).append(D);
                boolean bool = E;
                ((StringBuilder)localObject).append("&is_trailer=");
                if (bool) {
                  ((StringBuilder)localObject).append(1);
                } else {
                  ((StringBuilder)localObject).append(0);
                }
                if (!TextUtils.isEmpty(F))
                {
                  if ((F.length() != 7) && (F.length() != 8)) {
                    throw new IllegalArgumentException("BDMapSDKException: plateNumber error Please fill in the correct license plate");
                  }
                  ((StringBuilder)localObject).append("&plate_number=");
                  ((StringBuilder)localObject).append(F);
                  i1 = G;
                  if ((i1 >= 0) && (i1 <= 4))
                  {
                    ((StringBuilder)localObject).append("&plate_color=");
                    ((StringBuilder)localObject).append(G);
                  }
                  if (H > 0)
                  {
                    ((StringBuilder)localObject).append("&displacement=");
                    ((StringBuilder)localObject).append(H);
                  }
                  i1 = I;
                  if ((i1 > 0) && (i1 <= 4))
                  {
                    ((StringBuilder)localObject).append("&power_type=");
                    ((StringBuilder)localObject).append(I);
                    i1 = J;
                    if ((i1 >= 0) && (i1 <= 6))
                    {
                      ((StringBuilder)localObject).append("&emission_limit=");
                      ((StringBuilder)localObject).append(J);
                      i1 = K;
                      if ((i1 > 0) && (i1 <= 100))
                      {
                        ((StringBuilder)localObject).append("&load_weight=");
                        ((StringBuilder)localObject).append(K);
                        localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
                        ((Intent)localObject).setFlags(268435456);
                        paramContext.startActivity((Intent)localObject);
                        return;
                      }
                      throw new IllegalArgumentException("BDMapSDKException: loadWeight Must be between 1 and 100");
                    }
                    throw new IllegalArgumentException("BDMapSDKException: emissionLimit Must be between 0 and 6");
                  }
                  throw new IllegalArgumentException("BDMapSDKException: powerType Must be between 1 and 4");
                }
                throw new IllegalArgumentException("BDMapSDKException: plateNumber Can not be null");
              }
              throw new IllegalArgumentException("BDMapSDKException: axleCount Must be between 2 and 8");
            }
            throw new IllegalArgumentException("BDMapSDKException: length Must be between 1 and 25");
          }
          throw new IllegalArgumentException("BDMapSDKException: weight Must be between 1 and 100");
        }
        throw new IllegalArgumentException("BDMapSDKException: width Must be between 1 and 5");
      }
      throw new IllegalArgumentException("BDMapSDKException: height Must be between 1 and 10");
    }
    throw new IllegalArgumentException("BDMapSDKException: truckType Must be between 1 and 4");
  }
  
  private static void c(Context paramContext, int paramInt)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    int i1 = paramInt;
    if (paramInt == 101) {
      i1 = 3;
    }
    paramInt = i1;
    if (i1 == 102) {
      paramInt = 4;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("baidumap://map/direction?");
    localStringBuilder.append("origin=");
    if ((j != null) && (SDKInitializer.getCoordType() == CoordType.GCJ02)) {
      j = CoordTrans.gcjToBaidu(j);
    }
    if ((!TextUtils.isEmpty(l)) && (j != null))
    {
      localStringBuilder.append("name:");
      localStringBuilder.append(l);
      localStringBuilder.append("|latlng:");
      localObject = j;
    }
    do
    {
      localStringBuilder.append(((LatLng)localObject).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(j.longitude);
      break;
      if (!TextUtils.isEmpty(l))
      {
        localStringBuilder.append(l);
        break;
      }
      localObject = j;
    } while (localObject != null);
    localStringBuilder.append("&destination=");
    if ((k != null) && (SDKInitializer.getCoordType() == CoordType.GCJ02)) {
      k = CoordTrans.gcjToBaidu(k);
    }
    if ((!TextUtils.isEmpty(m)) && (k != null))
    {
      localStringBuilder.append("name:");
      localStringBuilder.append(m);
      localStringBuilder.append("|latlng:");
      localObject = k;
    }
    do
    {
      localStringBuilder.append(((LatLng)localObject).latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(k.longitude);
      break;
      if (!TextUtils.isEmpty(m))
      {
        localStringBuilder.append(m);
        break;
      }
      localObject = k;
    } while (localObject != null);
    localStringBuilder.append("&mode=");
    localStringBuilder.append(new String[] { "driving", "transit", "walking", "neweng", "truck" }[paramInt]);
    localStringBuilder.append("&target=");
    localStringBuilder.append("1");
    localStringBuilder.append("&src=");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sdk_[");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("]");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void d(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/bikenavi?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      j = CoordTrans.gcjToBaidu(j);
      k = CoordTrans.gcjToBaidu(k);
    }
    if (j != null)
    {
      if (k == null) {
        return;
      }
      ((StringBuilder)localObject).append("origin=");
      ((StringBuilder)localObject).append(j.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(j.longitude);
      ((StringBuilder)localObject).append("&destination=");
      ((StringBuilder)localObject).append(k.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(k.longitude);
      ((StringBuilder)localObject).append("&src=");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sdk_[");
      localStringBuilder.append(f);
      localStringBuilder.append("]");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  private static void e(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/navi?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      j = CoordTrans.gcjToBaidu(j);
      k = CoordTrans.gcjToBaidu(k);
    }
    ((StringBuilder)localObject).append("origin=");
    ((StringBuilder)localObject).append(j.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(j.longitude);
    ((StringBuilder)localObject).append("&location=");
    ((StringBuilder)localObject).append(k.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(k.longitude);
    ((StringBuilder)localObject).append("&src=");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk_[");
    localStringBuilder.append(f);
    localStringBuilder.append("]");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    if (!TextUtils.isEmpty(n))
    {
      ((StringBuilder)localObject).append("&viaPoints=");
      ((StringBuilder)localObject).append(n);
    }
    ((StringBuilder)localObject).append("&type=");
    ((StringBuilder)localObject).append(o);
    ((StringBuilder)localObject).append("&mode=");
    ((StringBuilder)localObject).append("driving");
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static void f(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/walknavi?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      j = CoordTrans.gcjToBaidu(j);
      k = CoordTrans.gcjToBaidu(k);
    }
    if (j != null)
    {
      if (k == null) {
        return;
      }
      ((StringBuilder)localObject).append("origin=");
      ((StringBuilder)localObject).append(j.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(j.longitude);
      ((StringBuilder)localObject).append("&destination=");
      ((StringBuilder)localObject).append(k.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(k.longitude);
      ((StringBuilder)localObject).append("&src=");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sdk_[");
      localStringBuilder.append(f);
      localStringBuilder.append("]");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  private static boolean f()
  {
    Object localObject1 = i;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return false;
      }
      try
      {
        Object localObject2 = a;
        Log.d((String)localObject2, "callDispatchPoiToBaiduMap");
        localObject1 = c.a("map.android.baidu.mainmap");
        if (localObject1 != null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("target", "favorite_page");
          Bundle localBundle = new Bundle();
          Object localObject3 = new JSONArray();
          int i3 = 0;
          int i2;
          for (int i1 = i3; i3 < i.size(); i1 = i2)
          {
            i2 = i1;
            if (((DispathcPoiData)i.get(i3)).name != null)
            {
              i2 = i1;
              if (!((DispathcPoiData)i.get(i3)).name.equals("")) {
                if (((DispathcPoiData)i.get(i3)).pt == null)
                {
                  i2 = i1;
                }
                else
                {
                  JSONObject localJSONObject = new JSONObject();
                  i2 = i1;
                  try
                  {
                    localJSONObject.put("name", ((DispathcPoiData)i.get(i3)).name);
                    i2 = i1;
                    GeoPoint localGeoPoint = CoordUtil.ll2mc(((DispathcPoiData)i.get(i3)).pt);
                    i2 = i1;
                    localJSONObject.put("ptx", localGeoPoint.getLongitudeE6());
                    i2 = i1;
                    localJSONObject.put("pty", localGeoPoint.getLatitudeE6());
                    i2 = i1;
                    localJSONObject.put("addr", ((DispathcPoiData)i.get(i3)).addr);
                    i2 = i1;
                    localJSONObject.put("uid", ((DispathcPoiData)i.get(i3)).uid);
                    i1 += 1;
                    i2 = i1;
                    ((JSONArray)localObject3).put(localJSONObject);
                    i2 = i1;
                  }
                  catch (JSONException localJSONException)
                  {
                    localJSONException.printStackTrace();
                  }
                }
              }
            }
            i3 += 1;
          }
          if (i1 == 0) {
            return false;
          }
          localBundle.putString("data", ((JSONArray)localObject3).toString());
          localBundle.putString("from", g);
          localBundle.putString("pkg", f);
          localBundle.putString("cls", h);
          localBundle.putInt("count", i1);
          ((Bundle)localObject2).putBundle("base_params", localBundle);
          localBundle = new Bundle();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("sdk_[");
          ((StringBuilder)localObject3).append(f);
          ((StringBuilder)localObject3).append("]");
          localBundle.putString("launch_from", ((StringBuilder)localObject3).toString());
          ((Bundle)localObject2).putBundle("ext_params", localBundle);
          return c.a("map.android.baidu.mainmap", (String)localObject1, (Bundle)localObject2);
        }
        Log.d((String)localObject2, "callDispatchPoiToBaiduMap com not found");
        return false;
      }
      catch (RemoteException localRemoteException)
      {
        Log.d(a, "callDispatchPoiToBaiduMap exception", localRemoteException);
      }
    }
    return false;
  }
  
  private static void g(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/walknavi?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      j = CoordTrans.gcjToBaidu(j);
      k = CoordTrans.gcjToBaidu(k);
    }
    if (j != null)
    {
      if (k == null) {
        return;
      }
      ((StringBuilder)localObject).append("origin=");
      ((StringBuilder)localObject).append(j.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(j.longitude);
      ((StringBuilder)localObject).append("&destination=");
      ((StringBuilder)localObject).append(k.latitude);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(k.longitude);
      ((StringBuilder)localObject).append("&mode=");
      ((StringBuilder)localObject).append("walking_ar");
      ((StringBuilder)localObject).append("&src=");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sdk_[");
      localStringBuilder.append(f);
      localStringBuilder.append("]");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      Log.e("test", ((StringBuilder)localObject).toString());
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
      ((Intent)localObject).setFlags(268435456);
      paramContext.startActivity((Intent)localObject);
    }
  }
  
  private static boolean g()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a;
        Log.d((String)localObject1, "callDispatchTakeOutPoiDetials");
        String str2 = c.a("map.android.baidu.mainmap");
        if (str2 != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putString("target", "request_poi_detail_page");
          Object localObject2 = new Bundle();
          localObject1 = q;
          if (localObject1 == null) {
            break label179;
          }
          ((Bundle)localObject2).putString("uid", (String)localObject1);
          localBundle.putBundle("base_params", (Bundle)localObject2);
          localObject1 = new Bundle();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sdk_[");
          ((StringBuilder)localObject2).append(f);
          ((StringBuilder)localObject2).append("]");
          ((Bundle)localObject1).putString("launch_from", ((StringBuilder)localObject2).toString());
          localBundle.putBundle("ext_params", (Bundle)localObject1);
          return c.a("map.android.baidu.mainmap", str2, localBundle);
        }
        Log.d((String)localObject1, "callDispatchTakeOut com not found");
      }
      catch (RemoteException localRemoteException)
      {
        Log.d(a, "callDispatchTakeOut exception", localRemoteException);
      }
      return false;
      label179:
      String str1 = "";
    }
  }
  
  private static void h(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/place/detail?");
    ((StringBuilder)localObject).append("uid=");
    ((StringBuilder)localObject).append(q);
    ((StringBuilder)localObject).append("&show_type=");
    ((StringBuilder)localObject).append("detail_page");
    ((StringBuilder)localObject).append("&src=");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk_[");
    localStringBuilder.append(f);
    localStringBuilder.append("]");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static boolean h()
  {
    try
    {
      Object localObject1 = a;
      Log.d((String)localObject1, "callDispatchTakeOutPoiNearbySearch");
      String str = c.a("map.android.baidu.mainmap");
      if (str != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("target", "poi_search_page");
        Bundle localBundle = new Bundle();
        Object localObject2 = r;
        if (localObject2 != null) {
          localBundle.putString("search_key", (String)localObject2);
        } else {
          localBundle.putString("search_key", "");
        }
        localObject2 = s;
        if (localObject2 != null)
        {
          localBundle.putInt("center_pt_x", (int)CoordUtil.ll2mc((LatLng)localObject2).getLongitudeE6());
          localBundle.putInt("center_pt_y", (int)CoordUtil.ll2mc(s).getLatitudeE6());
        }
        else
        {
          localBundle.putString("search_key", "");
        }
        int i1 = t;
        if (i1 != 0) {
          localBundle.putInt("search_radius", i1);
        } else {
          localBundle.putInt("search_radius", 1000);
        }
        localBundle.putBoolean("is_direct_search", true);
        localBundle.putBoolean("is_direct_area_search", true);
        ((Bundle)localObject1).putBundle("base_params", localBundle);
        localBundle = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_[");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append("]");
        localBundle.putString("launch_from", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putBundle("ext_params", localBundle);
        return c.a("map.android.baidu.mainmap", str, (Bundle)localObject1);
      }
      Log.d((String)localObject1, "callDispatchTakeOut com not found");
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(a, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  private static void i(Context paramContext)
  {
    Object localObject = w;
    if (localObject != null) {
      ((Thread)localObject).interrupt();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("baidumap://map/nearbysearch?");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      s = CoordTrans.gcjToBaidu(s);
    }
    ((StringBuilder)localObject).append("center=");
    ((StringBuilder)localObject).append(s.latitude);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(s.longitude);
    ((StringBuilder)localObject).append("&query=");
    ((StringBuilder)localObject).append(r);
    ((StringBuilder)localObject).append("&radius=");
    ((StringBuilder)localObject).append(t);
    ((StringBuilder)localObject).append("&src=");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sdk_[");
    localStringBuilder.append(f);
    localStringBuilder.append("]");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    localObject = new Intent("android.intent.action.VIEW", Uri.parse(((StringBuilder)localObject).toString()));
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
  
  private static boolean i()
  {
    try
    {
      Object localObject1 = a;
      Log.d((String)localObject1, "callDispatchTakeOutRoute");
      String str = c.a("map.android.baidu.mainmap");
      if (str != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("target", "route_search_page");
        Bundle localBundle = new Bundle();
        if (e == 102) {
          e = 7;
        }
        localBundle.putInt("route_type", e);
        localBundle.putInt("bus_strategy", p.ordinal());
        localBundle.putInt("cross_city_bus_strategy", 5);
        Object localObject2 = j;
        if (localObject2 != null)
        {
          localBundle.putInt("start_type", 1);
          localBundle.putInt("start_longitude", (int)CoordUtil.ll2mc(j).getLongitudeE6());
          localBundle.putInt("start_latitude", (int)CoordUtil.ll2mc(j).getLatitudeE6());
        }
        else
        {
          localBundle.putInt("start_type", 2);
          localBundle.putInt("start_longitude", 0);
          localBundle.putInt("start_latitude", 0);
        }
        localObject2 = l;
        if (localObject2 != null) {
          localBundle.putString("start_keyword", (String)localObject2);
        } else {
          localBundle.putString("start_keyword", "地图上的点");
        }
        localBundle.putString("start_uid", "");
        localObject2 = k;
        if (localObject2 != null)
        {
          localBundle.putInt("end_type", 1);
          localBundle.putInt("end_longitude", (int)CoordUtil.ll2mc(k).getLongitudeE6());
          localBundle.putInt("end_latitude", (int)CoordUtil.ll2mc(k).getLatitudeE6());
        }
        else
        {
          localBundle.putInt("end_type", 2);
          localBundle.putInt("end_longitude", 0);
          localBundle.putInt("end_latitude", 0);
        }
        localObject2 = m;
        if (localObject2 != null) {
          localBundle.putString("end_keyword", (String)localObject2);
        } else {
          localBundle.putString("end_keyword", "地图上的点");
        }
        localBundle.putString("end_uid", "");
        ((Bundle)localObject1).putBundle("base_params", localBundle);
        localBundle = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_[");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append("]");
        localBundle.putString("launch_from", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putBundle("ext_params", localBundle);
        return c.a("map.android.baidu.mainmap", str, (Bundle)localObject1);
      }
      Log.d((String)localObject1, "callDispatchTakeOut com not found");
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(a, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  public static void j(Context paramContext)
  {
    if (v)
    {
      paramContext.unbindService(L);
      v = false;
    }
  }
  
  private static boolean j()
  {
    try
    {
      Object localObject1 = a;
      Log.d((String)localObject1, "callDispatchTakeOutRouteNavi");
      String str = c.a("map.android.baidu.mainmap");
      if (str != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("target", "navigation_page");
        Bundle localBundle = new Bundle();
        localBundle.putString("coord_type", "bd09ll");
        Object localObject2 = new StringBuffer();
        Object localObject3 = l;
        if (localObject3 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("name:");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append("|");
          ((StringBuffer)localObject2).append(((StringBuilder)localObject3).toString());
        }
        Object localObject4 = SDKInitializer.getCoordType();
        localObject3 = CoordType.GCJ02;
        if (localObject4 == localObject3) {
          j = CoordTrans.gcjToBaidu(j);
        }
        ((StringBuffer)localObject2).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(j.latitude), Double.valueOf(j.longitude) }));
        localObject4 = new StringBuffer();
        if (m != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("name:");
          localStringBuilder.append(m);
          localStringBuilder.append("|");
          ((StringBuffer)localObject4).append(localStringBuilder.toString());
        }
        if (SDKInitializer.getCoordType() == localObject3) {
          k = CoordTrans.gcjToBaidu(k);
        }
        ((StringBuffer)localObject4).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        localBundle.putString("origin", ((StringBuffer)localObject2).toString());
        localBundle.putString("destination", ((StringBuffer)localObject4).toString());
        boolean bool = TextUtils.isEmpty(n);
        if (!bool) {
          localBundle.putString("viaPoints", n);
        }
        bool = TextUtils.isEmpty(o);
        if (!bool) {
          localBundle.putString("type", o);
        }
        ((Bundle)localObject1).putBundle("base_params", localBundle);
        localBundle = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_[");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append("]");
        localBundle.putString("launch_from", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putBundle("ext_params", localBundle);
        return c.a("map.android.baidu.mainmap", str, (Bundle)localObject1);
      }
      Log.d((String)localObject1, "callDispatchTakeOut com not found");
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(a, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  private static boolean k()
  {
    try
    {
      Object localObject1 = a;
      Log.d((String)localObject1, "callDispatchTakeOutRouteRidingNavi");
      String str = c.a("map.android.baidu.mainmap");
      if (str != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("target", "bikenavi_page");
        Bundle localBundle = new Bundle();
        localBundle.putString("coord_type", "bd09ll");
        Object localObject2 = new StringBuffer();
        Object localObject3 = l;
        if (localObject3 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("name:");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append("|");
          ((StringBuffer)localObject2).append(((StringBuilder)localObject3).toString());
        }
        Object localObject4 = SDKInitializer.getCoordType();
        localObject3 = CoordType.GCJ02;
        if (localObject4 == localObject3) {
          j = CoordTrans.gcjToBaidu(j);
        }
        ((StringBuffer)localObject2).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(j.latitude), Double.valueOf(j.longitude) }));
        localObject4 = new StringBuffer();
        if (m != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("name:");
          localStringBuilder.append(m);
          localStringBuilder.append("|");
          ((StringBuffer)localObject4).append(localStringBuilder.toString());
        }
        if (SDKInitializer.getCoordType() == localObject3) {
          k = CoordTrans.gcjToBaidu(k);
        }
        ((StringBuffer)localObject4).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        localBundle.putString("origin", ((StringBuffer)localObject2).toString());
        localBundle.putString("destination", ((StringBuffer)localObject4).toString());
        ((Bundle)localObject1).putBundle("base_params", localBundle);
        localBundle = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_[");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append("]");
        localBundle.putString("launch_from", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putBundle("ext_params", localBundle);
        return c.a("map.android.baidu.mainmap", str, (Bundle)localObject1);
      }
      Log.d((String)localObject1, "callDispatchTakeOut com not found");
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.d(a, "callDispatchTakeOut exception", localRemoteException);
    }
    return false;
  }
  
  private static boolean l()
  {
    try
    {
      Object localObject1 = a;
      Log.d((String)localObject1, "callDispatchTakeOutRouteNavi");
      String str = c.a("map.android.baidu.mainmap");
      if (str != null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("target", "walknavi_page");
        Bundle localBundle = new Bundle();
        localBundle.putString("coord_type", "bd09ll");
        Object localObject2 = new StringBuffer();
        Object localObject3 = l;
        if (localObject3 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("name:");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append("|");
          ((StringBuffer)localObject2).append(((StringBuilder)localObject3).toString());
        }
        Object localObject4 = SDKInitializer.getCoordType();
        localObject3 = CoordType.GCJ02;
        if (localObject4 == localObject3) {
          j = CoordTrans.gcjToBaidu(j);
        }
        ((StringBuffer)localObject2).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(j.latitude), Double.valueOf(j.longitude) }));
        localObject4 = new StringBuffer();
        if (m != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("name:");
          localStringBuilder.append(m);
          localStringBuilder.append("|");
          ((StringBuffer)localObject4).append(localStringBuilder.toString());
        }
        if (SDKInitializer.getCoordType() == localObject3) {
          k = CoordTrans.gcjToBaidu(k);
        }
        ((StringBuffer)localObject4).append(String.format("latlng:%f,%f", new Object[] { Double.valueOf(k.latitude), Double.valueOf(k.longitude) }));
        localBundle.putString("origin", ((StringBuffer)localObject2).toString());
        localBundle.putString("destination", ((StringBuffer)localObject4).toString());
        ((Bundle)localObject1).putBundle("base_params", localBundle);
        localBundle = new Bundle();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sdk_[");
        ((StringBuilder)localObject2).append(f);
        ((StringBuilder)localObject2).append("]");
        localBundle.putString("launch_from", ((StringBuilder)localObject2).toString());
        ((Bundle)localObject1).putBundle("ext_params", localBundle);
        return c.a("map.android.baidu.mainmap", str, (Bundle)localObject1);
      }
      Log.d((String)localObject1, "callDispatchTakeOut com not found");
      return false;
    }
    catch (Exception localException)
    {
      Log.d(a, "callDispatchTakeOut exception", localException);
    }
    return false;
  }
  
  public static String m()
  {
    return AppTools.getBaiduMapToken();
  }
  
  static final class a
    extends b.a
  {
    a(int paramInt) {}
    
    public void a(IBinder paramIBinder)
    {
      Log.d(a.a(), "onClientReady");
      if (a.b() != null) {
        a.a(null);
      }
      a.a(IComOpenClient.a.b(paramIBinder));
      a.a(this.a);
      a.a(true);
    }
  }
  
  static final class b
    implements ServiceConnection
  {
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (a.d() != null) {
        a.d().interrupt();
      }
      String str = a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceConnected ");
      localStringBuilder.append(paramComponentName);
      Log.d(str, localStringBuilder.toString());
      try
      {
        if (a.e() != null) {
          a.a(null);
        }
        a.a(com.baidu.mapframework.open.aidl.a.a.b(paramIBinder));
        a.e().a(new a());
        return;
      }
      catch (RemoteException paramComponentName)
      {
        Log.d(a.a(), "getComOpenClient ", paramComponentName);
        if (a.e() != null) {
          a.a(null);
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      String str = a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceDisconnected ");
      localStringBuilder.append(paramComponentName);
      Log.d(str, localStringBuilder.toString());
      if (a.e() != null)
      {
        a.a(null);
        a.b(false);
      }
    }
    
    class a
      extends b.a
    {
      a() {}
      
      public void a(IBinder paramIBinder)
      {
        Log.d(a.a(), "onClientReady");
        if (a.b() != null) {
          a.a(null);
        }
        a.a(IComOpenClient.a.b(paramIBinder));
        if (!a.c()) {
          a.a(a.d);
        }
        a.a(true);
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    c(Context paramContext, int paramInt) {}
    
    public void run()
    {
      long l = System.currentTimeMillis();
      do
      {
        if (System.currentTimeMillis() - l > 3000L)
        {
          a.j(this.a);
          a.a(paramInt, this.a);
        }
      } while (!a.d().isInterrupted());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.a
 * JD-Core Version:    0.7.0.1
 */