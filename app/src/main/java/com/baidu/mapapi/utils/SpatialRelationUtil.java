package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpatialRelationUtil
{
  private static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    paramLatLng1 = CoordUtil.ll2mc(paramLatLng1);
    paramLatLng2 = CoordUtil.ll2mc(paramLatLng2);
    paramLatLng3 = CoordUtil.ll2mc(paramLatLng3);
    double d1 = Math.sqrt((paramLatLng2.getLongitudeE6() - paramLatLng1.getLongitudeE6()) * (paramLatLng2.getLongitudeE6() - paramLatLng1.getLongitudeE6()) + (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()));
    d1 = ((paramLatLng2.getLongitudeE6() - paramLatLng1.getLongitudeE6()) * (paramLatLng3.getLongitudeE6() - paramLatLng1.getLongitudeE6()) + (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * (paramLatLng3.getLatitudeE6() - paramLatLng1.getLatitudeE6())) / (d1 * d1);
    double d2 = paramLatLng1.getLongitudeE6();
    double d3 = paramLatLng2.getLongitudeE6();
    double d4 = paramLatLng1.getLongitudeE6();
    return CoordUtil.mc2ll(new GeoPoint(paramLatLng1.getLatitudeE6() + (paramLatLng2.getLatitudeE6() - paramLatLng1.getLatitudeE6()) * d1, d2 + (d3 - d4) * d1));
  }
  
  private static Point a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble5 - paramDouble3;
    double d2 = paramDouble6 - paramDouble4;
    paramDouble1 = (paramDouble1 - paramDouble3) * d1 + (paramDouble2 - paramDouble4) * d2;
    if (paramDouble1 <= 0.0D) {
      return new Point(paramDouble3, paramDouble4);
    }
    paramDouble2 = d1 * d1 + d2 * d2;
    if (paramDouble1 >= paramDouble2) {
      return new Point(paramDouble5, paramDouble6);
    }
    paramDouble1 /= paramDouble2;
    return new Point(paramDouble3 + d1 * paramDouble1, paramDouble4 + d2 * paramDouble1);
  }
  
  private static Point a(List<Point> paramList, Point paramPoint)
  {
    Object localObject2 = null;
    Point localPoint = null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramPoint != null)
      {
        localObject1 = localObject2;
        if (paramList.size() != 0)
        {
          if (paramList.size() < 2) {
            return null;
          }
          localObject2 = (Point)paramList.get(0);
          int i = paramList.size();
          int j = 1;
          for (localObject1 = localPoint;; localObject1 = localPoint)
          {
            int k = i - 1;
            if (j > k) {
              break;
            }
            localObject1 = (Point)paramList.get(j);
            if ((j == k) && (((Point)localObject1).equals(paramPoint))) {
              return paramPoint;
            }
            if (((Point)localObject2).equals(paramPoint)) {
              return paramPoint;
            }
            localPoint = a(paramPoint.doubleX, paramPoint.doubleY, ((Point)localObject2).doubleX, ((Point)localObject2).doubleY, ((Point)localObject1).doubleX, ((Point)localObject1).doubleY);
            j += 1;
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject1;
  }
  
  public static LatLng getNearestDistancePointFromLine(List<LatLng> paramList, LatLng paramLatLng)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramLatLng == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while ((paramList != null) && (paramList.hasNext()))
      {
        LatLng localLatLng = (LatLng)paramList.next();
        localArrayList.add(new Point(localLatLng.longitude, localLatLng.latitude));
        if (localLatLng.equals(paramLatLng)) {
          return localLatLng;
        }
      }
      paramList = a(localArrayList, new Point(paramLatLng.longitude, paramLatLng.latitude));
      if (paramList != null) {
        return new LatLng(paramList.doubleY, paramList.doubleX);
      }
    }
    return null;
  }
  
  public static LatLng getNearestPointFromLine(List<LatLng> paramList, LatLng paramLatLng)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    if (paramList != null)
    {
      localObject2 = localObject3;
      if (paramList.size() != 0)
      {
        if (paramLatLng == null) {
          return null;
        }
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= paramList.size() - 1) {
            break;
          }
          localObject2 = (LatLng)paramList.get(i);
          int j = i + 1;
          localObject2 = a((LatLng)localObject2, (LatLng)paramList.get(j), paramLatLng);
          if (((((LatLng)localObject2).latitude - ((LatLng)paramList.get(i)).latitude) * (((LatLng)localObject2).latitude - ((LatLng)paramList.get(j)).latitude) > 0.0D) || ((((LatLng)localObject2).longitude - ((LatLng)paramList.get(i)).longitude) * (((LatLng)localObject2).longitude - ((LatLng)paramList.get(j)).longitude) > 0.0D))
          {
            if (DistanceUtil.getDistance(paramLatLng, (LatLng)paramList.get(i)) < DistanceUtil.getDistance(paramLatLng, (LatLng)paramList.get(j))) {
              localObject2 = paramList.get(i);
            } else {
              localObject2 = paramList.get(j);
            }
            localObject2 = (LatLng)localObject2;
          }
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            if (DistanceUtil.getDistance(paramLatLng, (LatLng)localObject2) >= DistanceUtil.getDistance(paramLatLng, (LatLng)localObject1)) {}
          }
          else
          {
            localObject3 = localObject2;
          }
          i = j;
          localObject1 = localObject3;
        }
      }
    }
    return localObject2;
  }
  
  public static boolean isCircleContainsPoint(LatLng paramLatLng1, int paramInt, LatLng paramLatLng2)
  {
    if ((paramLatLng1 != null) && (paramInt != 0))
    {
      if (paramLatLng2 == null) {
        return false;
      }
      return DistanceUtil.getDistance(paramLatLng1, paramLatLng2) <= paramInt;
    }
    return false;
  }
  
  public static boolean isPolygonContainsPoint(List<LatLng> paramList, LatLng paramLatLng)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramLatLng != null))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramLatLng.longitude == ((LatLng)paramList.get(i)).longitude) && (paramLatLng.latitude == ((LatLng)paramList.get(i)).latitude)) {
          return true;
        }
        i += 1;
      }
      int j = paramList.size();
      int m = 0;
      int k;
      for (i = 0; m < j; i = k)
      {
        LatLng localLatLng1 = (LatLng)paramList.get(m);
        m += 1;
        LatLng localLatLng2 = (LatLng)paramList.get(m % j);
        double d1 = localLatLng1.latitude;
        double d2 = localLatLng2.latitude;
        if (d1 == d2) {}
        while ((paramLatLng.latitude < Math.min(d1, d2)) || (paramLatLng.latitude >= Math.max(localLatLng1.latitude, localLatLng2.latitude)))
        {
          k = i;
          break;
        }
        d1 = paramLatLng.latitude;
        d2 = localLatLng1.latitude;
        double d3 = localLatLng2.longitude;
        double d4 = localLatLng1.longitude;
        d1 = (d1 - d2) * (d3 - d4) / (localLatLng2.latitude - d2) + d4;
        d2 = paramLatLng.longitude;
        if (d1 == d2) {
          return true;
        }
        k = i;
        if (d1 < d2) {
          k = i + 1;
        }
      }
      return i % 2 == 1;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.SpatialRelationUtil
 * JD-Core Version:    0.7.0.1
 */