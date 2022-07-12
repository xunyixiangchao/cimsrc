package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

public class CoordinateConverter
{
  private LatLng a;
  private CoordType b;
  
  private static LatLng a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    return CoordTrans.baiduToGcj(paramLatLng);
  }
  
  private static LatLng a(LatLng paramLatLng, String paramString)
  {
    if (paramLatLng == null) {
      return null;
    }
    return CoordUtil.Coordinate_encryptEx((float)paramLatLng.longitude, (float)paramLatLng.latitude, paramString);
  }
  
  private static LatLng b(LatLng paramLatLng)
  {
    return a(paramLatLng, "bd09mc");
  }
  
  private static LatLng c(LatLng paramLatLng)
  {
    return a(paramLatLng, "gcj02");
  }
  
  private static LatLng d(LatLng paramLatLng)
  {
    return a(paramLatLng, "wgs84");
  }
  
  public LatLng convert()
  {
    if (this.a == null) {
      return null;
    }
    if (this.b == null) {
      this.b = CoordType.GPS;
    }
    int i = a.a[this.b.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return b(this.a);
        }
        return a(this.a);
      }
      return d(this.a);
    }
    return c(this.a);
  }
  
  public CoordinateConverter coord(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public CoordinateConverter from(CoordType paramCoordType)
  {
    this.b = paramCoordType;
    return this;
  }
  
  public static enum CoordType
  {
    static
    {
      CoordType localCoordType1 = new CoordType("GPS", 0);
      GPS = localCoordType1;
      CoordType localCoordType2 = new CoordType("COMMON", 1);
      COMMON = localCoordType2;
      CoordType localCoordType3 = new CoordType("BD09LL", 2);
      BD09LL = localCoordType3;
      CoordType localCoordType4 = new CoordType("BD09MC", 3);
      BD09MC = localCoordType4;
      $VALUES = new CoordType[] { localCoordType1, localCoordType2, localCoordType3, localCoordType4 };
    }
    
    private CoordType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.utils.CoordinateConverter
 * JD-Core Version:    0.7.0.1
 */