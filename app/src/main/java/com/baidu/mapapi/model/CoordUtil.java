package com.baidu.mapapi.model;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mapsdkplatform.comapi.util.b;
import com.baidu.mapsdkplatform.comjni.tools.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.List;

public class CoordUtil
{
  public static LatLng Coordinate_encryptEx(float paramFloat1, float paramFloat2, String paramString)
  {
    return b.a(paramFloat1, paramFloat2, paramString);
  }
  
  public static LatLng decodeLocation(String paramString)
  {
    CoordType localCoordType1 = SDKInitializer.getCoordType();
    CoordType localCoordType2 = CoordType.GCJ02;
    LatLng localLatLng = b.a(paramString);
    paramString = localLatLng;
    if (localCoordType1 == localCoordType2) {
      paramString = CoordTrans.baiduToGcj(localLatLng);
    }
    return paramString;
  }
  
  public static List<LatLng> decodeLocationList(String paramString)
  {
    return b.b(paramString);
  }
  
  public static List<List<LatLng>> decodeLocationList2D(String paramString)
  {
    return b.c(paramString);
  }
  
  public static LatLng decodeNodeLocation(String paramString)
  {
    CoordType localCoordType1 = SDKInitializer.getCoordType();
    CoordType localCoordType2 = CoordType.GCJ02;
    LatLng localLatLng = b.d(paramString);
    paramString = localLatLng;
    if (localCoordType1 == localCoordType2) {
      paramString = CoordTrans.baiduToGcj(localLatLng);
    }
    return paramString;
  }
  
  public static double getDistance(Point paramPoint1, Point paramPoint2)
  {
    return a.a(paramPoint1, paramPoint2);
  }
  
  public static int getMCDistanceByOneLatLngAndRadius(LatLng paramLatLng, int paramInt)
  {
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      return b.a(CoordTrans.gcjToBaidu(paramLatLng), paramInt);
    }
    return b.a(paramLatLng, paramInt);
  }
  
  public static GeoPoint ll2mc(LatLng paramLatLng)
  {
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      return b.a(CoordTrans.gcjToBaidu(paramLatLng));
    }
    return b.a(paramLatLng);
  }
  
  public static Point ll2point(LatLng paramLatLng)
  {
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      return b.b(CoordTrans.gcjToBaidu(paramLatLng));
    }
    return b.b(paramLatLng);
  }
  
  public static LatLng mc2ll(GeoPoint paramGeoPoint)
  {
    CoordType localCoordType1 = SDKInitializer.getCoordType();
    CoordType localCoordType2 = CoordType.GCJ02;
    LatLng localLatLng = b.a(paramGeoPoint);
    paramGeoPoint = localLatLng;
    if (localCoordType1 == localCoordType2) {
      paramGeoPoint = CoordTrans.baiduToGcj(localLatLng);
    }
    return paramGeoPoint;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.model.CoordUtil
 * JD-Core Version:    0.7.0.1
 */