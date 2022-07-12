package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;

public class m
{
  public static GeoPoint a(GeoPoint paramGeoPoint)
  {
    paramGeoPoint = CoordinateUtil.bd09llTobd09mc(paramGeoPoint.getLongitude(), paramGeoPoint.getLatitude());
    if (paramGeoPoint != null) {
      return new GeoPoint(paramGeoPoint.getDoubleY(), paramGeoPoint.getDoubleX());
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.m
 * JD-Core Version:    0.7.0.1
 */