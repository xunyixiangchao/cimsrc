package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class g
{
  private static double a(double paramDouble)
  {
    return paramDouble / 3.141592653589793D * 180.0D;
  }
  
  private static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    double d1 = b(paramLatLng1.latitude);
    double d2 = b(paramLatLng2.latitude);
    double d3 = b(paramLatLng1.longitude);
    double d4 = b(paramLatLng2.longitude);
    return Math.acos(Math.sin(d1) * Math.sin(d2) + Math.cos(d1) * Math.cos(d2) * Math.cos(Math.abs(d4 - d3)));
  }
  
  private static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2, double paramDouble1, double paramDouble2)
  {
    double d5 = paramLatLng1.latitude;
    double d4 = paramLatLng2.latitude;
    double d3 = paramLatLng1.longitude;
    double d2 = paramLatLng2.longitude;
    double d1 = Math.sin((1.0D - paramDouble1) * paramDouble2) / Math.sin(paramDouble2);
    paramDouble1 = Math.sin(paramDouble1 * paramDouble2) / Math.sin(paramDouble2);
    paramDouble2 = b(d5);
    d4 = b(d4);
    d3 = b(d3);
    d5 = b(d2);
    d2 = Math.cos(paramDouble2) * d1 * Math.cos(d3) + Math.cos(d4) * paramDouble1 * Math.cos(d5);
    d3 = Math.cos(paramDouble2) * d1 * Math.sin(d3) + Math.cos(d4) * paramDouble1 * Math.sin(d5);
    paramDouble1 = Math.atan2(d1 * Math.sin(paramDouble2) + paramDouble1 * Math.sin(d4), Math.sqrt(Math.pow(d2, 2.0D) + Math.pow(d3, 2.0D)));
    paramDouble2 = Math.atan2(d3, d2);
    return new LatLng(a(paramDouble1), a(paramDouble2));
  }
  
  private static double b(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  public static List<LatLng> b(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    double d1 = c(paramLatLng1, paramLatLng2);
    ArrayList localArrayList = new ArrayList();
    if ((150000.0D <= d1) && (d1 >= 250000.0D))
    {
      double d2 = Math.round(d1 / 150000.0D);
      double d3 = a(paramLatLng1, paramLatLng2);
      localArrayList.add(paramLatLng1);
      for (d1 = 0.0D; d1 < d2; d1 += 1.0D) {
        localArrayList.add(a(paramLatLng1, paramLatLng2, d1 / d2, d3));
      }
      localArrayList.add(paramLatLng2);
      return localArrayList;
    }
    localArrayList.add(paramLatLng1);
    localArrayList.add(paramLatLng2);
    return localArrayList;
  }
  
  public static double c(LatLng paramLatLng1, LatLng paramLatLng2)
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
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.g
 * JD-Core Version:    0.7.0.1
 */