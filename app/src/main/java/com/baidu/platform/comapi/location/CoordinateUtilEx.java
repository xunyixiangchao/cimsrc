package com.baidu.platform.comapi.location;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.basestruct.a;
import java.util.ArrayList;

public class CoordinateUtilEx
{
  public static Point Coordinate_encryptEx(float paramFloat1, float paramFloat2, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString;
    if (paramString.equals("")) {
      str = "bd09ll";
    }
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      break;
    case 113079775: 
      if (str.equals("wgs84")) {
        i = 3;
      }
      break;
    case 98175376: 
      if (str.equals("gcj02")) {
        i = 2;
      }
      break;
    case -1395470175: 
      if (str.equals("bd09mc")) {
        i = 1;
      }
      break;
    case -1395470197: 
      if (str.equals("bd09ll")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 3: 
      return CoordinateUtil.wgs84Tobd09mc(paramFloat1, paramFloat2);
    case 2: 
      return CoordinateUtil.gcj02Tobd09mc(paramFloat1, paramFloat2);
    case 1: 
      return new Point(paramFloat1, paramFloat2);
    }
    return CoordinateUtil.bd09llTobd09mc(paramFloat1, paramFloat2);
  }
  
  public static ArrayList<Point> Coordinate_encryptExArray(ArrayList<Point> paramArrayList, String paramString)
  {
    Object localObject = paramString;
    if (localObject == null) {
      return null;
    }
    paramString = (String)localObject;
    if (((String)localObject).equals("")) {
      paramString = "bd09ll";
    }
    if ((!paramString.equals("bd09ll")) && (!paramString.equals("bd09mc")) && (!paramString.equals("gcj02")) && (!paramString.equals("wgs84"))) {
      return null;
    }
    int j = paramArrayList.size();
    localObject = new float[j];
    float[] arrayOfFloat = new float[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      localObject[i] = (((Point)paramArrayList.get(i)).getIntX() / 100000.0F);
      arrayOfFloat[i] = (((Point)paramArrayList.get(i)).getIntY() / 100000.0F);
      i += 1;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < j)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 113079775: 
        if (paramString.equals("wgs84")) {
          i = 3;
        }
        break;
      case 98175376: 
        if (paramString.equals("gcj02")) {
          i = 2;
        }
        break;
      case -1395470175: 
        if (paramString.equals("bd09mc")) {
          i = 1;
        }
        break;
      case -1395470197: 
        if (paramString.equals("bd09ll")) {
          i = 0;
        }
        break;
      }
      switch (i)
      {
      default: 
        paramArrayList = null;
        break;
      case 3: 
        paramArrayList = CoordinateUtil.wgs84Tobd09mc(localObject[k], arrayOfFloat[k]);
        break;
      case 2: 
        paramArrayList = CoordinateUtil.gcj02Tobd09mc(localObject[k], arrayOfFloat[k]);
        break;
      case 1: 
        paramArrayList = new Point(localObject[k], arrayOfFloat[k]);
        break;
      }
      paramArrayList = CoordinateUtil.bd09llTobd09mc(localObject[k], arrayOfFloat[k]);
      if (paramArrayList != null) {
        localArrayList.add(paramArrayList);
      }
      k += 1;
    }
    return localArrayList;
  }
  
  public static double getDistanceByMc(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return CoordinateUtil.getDistanceByMc(paramGeoPoint1.getLongitude(), paramGeoPoint1.getLatitude(), paramGeoPoint2.getLongitude(), paramGeoPoint2.getLatitude());
  }
  
  public static double getDistanceByMc(Point paramPoint1, Point paramPoint2)
  {
    return CoordinateUtil.getDistanceByMc(paramPoint1.getDoubleX(), paramPoint1.getDoubleY(), paramPoint2.getDoubleX(), paramPoint2.getDoubleY());
  }
  
  @Deprecated
  public static a getGeoComplexPointFromString(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      return CoordinateUtil.geoStringToComplexPt(paramString);
    }
    return null;
  }
  
  @Deprecated
  public static a getGeoComplexPtBoundFromString(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      return CoordinateUtil.geoStringToComplexPtBound(paramString);
    }
    return null;
  }
  
  public static Point getGeoPointFromString(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      return CoordinateUtil.geoStringToPoint(paramString);
    }
    return null;
  }
  
  public static String getStringFromGeoPoint(Point paramPoint)
  {
    return CoordinateUtil.pointToGeoString(paramPoint);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.location.CoordinateUtilEx
 * JD-Core Version:    0.7.0.1
 */