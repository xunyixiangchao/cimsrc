package com.baidu.mapapi.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.s.a;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class Projection
{
  private c a;
  
  Projection(c paramc)
  {
    this.a = paramc;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    if (paramPoint != null)
    {
      c localc = this.a;
      if (localc != null) {
        return CoordUtil.mc2ll(localc.a(paramPoint.x, paramPoint.y));
      }
    }
    return null;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return 0.0F;
    }
    return (float)(paramFloat / this.a.z());
  }
  
  public PointF toOpenGLLocation(LatLng paramLatLng, MapStatus paramMapStatus)
  {
    if ((paramLatLng != null) && (paramMapStatus != null))
    {
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      paramMapStatus = paramMapStatus.c;
      double d1 = paramMapStatus.d;
      double d2 = paramMapStatus.e;
      return new PointF((float)(paramLatLng.getLongitudeE6() - d1), (float)(paramLatLng.getLatitudeE6() - d2));
    }
    return null;
  }
  
  public PointF toOpenGLNormalization(LatLng paramLatLng, MapStatus paramMapStatus)
  {
    if ((paramLatLng != null) && (paramMapStatus != null))
    {
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      paramMapStatus = paramMapStatus.c.k;
      double d2 = Math.abs(paramMapStatus.b - paramMapStatus.a);
      double d1 = Math.abs(paramMapStatus.c - paramMapStatus.d);
      d2 = (paramLatLng.getLongitudeE6() - paramMapStatus.a) * 2.0D / d2;
      d1 = (paramLatLng.getLatitudeE6() - paramMapStatus.d) * 2.0D / d1;
      return new PointF((float)(d2 - 1.0D), (float)(d1 - 1.0D));
    }
    return null;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    if ((paramLatLng != null) && (this.a != null))
    {
      paramLatLng = CoordUtil.ll2mc(paramLatLng);
      return this.a.a(paramLatLng);
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Projection
 * JD-Core Version:    0.7.0.1
 */