package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class WeightedLatLng
  extends b.a
{
  public static final double DEFAULT_INTENSITY = 1.0D;
  private Point a;
  public final double intensity;
  public final LatLng latLng;
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    if (paramLatLng != null)
    {
      this.latLng = paramLatLng;
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      this.a = new Point((int)paramLatLng.getLongitudeE6(), (int)paramLatLng.getLatitudeE6());
      if (paramDouble > 0.0D)
      {
        this.intensity = paramDouble;
        return;
      }
      this.intensity = 1.0D;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: latLng can not be null");
  }
  
  Point a()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.WeightedLatLng
 * JD-Core Version:    0.7.0.1
 */