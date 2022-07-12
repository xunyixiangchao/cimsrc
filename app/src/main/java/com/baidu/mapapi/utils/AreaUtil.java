package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

public class AreaUtil
{
  public static double calculateArea(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (paramLatLng1 != null)
    {
      if (paramLatLng2 == null) {
        return 0.0D;
      }
      LatLng localLatLng = new LatLng(paramLatLng1.latitude, paramLatLng2.longitude);
      double d1 = DistanceUtil.getDistance(localLatLng, paramLatLng2);
      double d2 = DistanceUtil.getDistance(paramLatLng1, localLatLng);
      if (d1 != 0.0D)
      {
        if (d2 == 0.0D) {
          return 0.0D;
        }
        return d1 * d2;
      }
    }
    return 0.0D;
  }
  
  public static double calculateArea(List<LatLng> paramList)
  {
    double d1 = 0.0D;
    if (paramList != null)
    {
      if (paramList.size() < 3) {
        return 0.0D;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        LatLng localLatLng1 = (LatLng)paramList.get(i);
        i += 1;
        LatLng localLatLng2 = (LatLng)paramList.get(i % j);
        double d2 = localLatLng1.longitude;
        double d3 = Math.cos(localLatLng1.latitude * 0.0174532925199433D);
        double d4 = localLatLng1.latitude;
        double d5 = localLatLng2.longitude;
        double d6 = Math.cos(localLatLng2.latitude * 0.0174532925199433D);
        d1 += d2 * 111319.49079327358D * d3 * (localLatLng2.latitude * 111319.49079327358D) - d4 * 111319.49079327358D * (d5 * 111319.49079327358D * d6);
      }
      return (float)Math.abs(d1 / 2.0D);
    }
    return 0.0D;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.AreaUtil
 * JD-Core Version:    0.7.0.1
 */