package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;

public class DistanceUtil
{
  public static double getDistance(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (paramLatLng1 != null)
    {
      if (paramLatLng2 == null) {
        return -1.0D;
      }
      paramLatLng1 = CoordUtil.ll2point(paramLatLng1);
      paramLatLng2 = CoordUtil.ll2point(paramLatLng2);
      if (paramLatLng1 != null)
      {
        if (paramLatLng2 == null) {
          return -1.0D;
        }
        return CoordUtil.getDistance(paramLatLng1, paramLatLng2);
      }
    }
    return -1.0D;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.DistanceUtil
 * JD-Core Version:    0.7.0.1
 */