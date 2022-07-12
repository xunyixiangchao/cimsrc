package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.Log;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.c;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class MapStatusUpdate
{
  private static final String p = "MapStatusUpdate";
  private int a;
  MapStatus b;
  LatLng c;
  LatLngBounds d;
  int e;
  int f;
  float g;
  int h;
  int i;
  float j;
  Point k;
  int l = 0;
  int m = 0;
  int n = 0;
  int o = 0;
  
  private MapStatusUpdate() {}
  
  MapStatusUpdate(int paramInt)
  {
    this.a = paramInt;
  }
  
  private float a(float paramFloat)
  {
    float f1 = SysOSUtil.getDensityDpi() / 310.0F;
    return (float)(Math.pow(2.0D, 18.0F - paramFloat) / f1);
  }
  
  private float a(LatLngBounds paramLatLngBounds, c paramc, int paramInt1, int paramInt2)
  {
    GeoPoint localGeoPoint = CoordUtil.ll2mc(paramLatLngBounds.southwest);
    paramLatLngBounds = CoordUtil.ll2mc(paramLatLngBounds.northeast);
    int i1 = (int)localGeoPoint.getLongitudeE6();
    int i2 = (int)localGeoPoint.getLatitudeE6();
    int i3 = (int)paramLatLngBounds.getLongitudeE6();
    return paramc.a(i1, (int)paramLatLngBounds.getLatitudeE6(), i3, i2, paramInt1, paramInt2);
  }
  
  private MapStatusUpdate a(MapStatus paramMapStatus)
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate();
    try
    {
      localMapStatusUpdate.b = paramMapStatus;
      localMapStatusUpdate.d = this.d;
      localMapStatusUpdate.l = this.l;
      localMapStatusUpdate.m = this.m;
      localMapStatusUpdate.n = this.n;
      localMapStatusUpdate.o = this.o;
      return localMapStatusUpdate;
    }
    finally {}
  }
  
  private LatLng a(LatLngBounds paramLatLngBounds, c paramc, float paramFloat)
  {
    if ((paramLatLngBounds != null) && (paramc != null))
    {
      paramLatLngBounds = CoordUtil.ll2mc(paramLatLngBounds.getCenter());
      int i1 = this.l;
      double d1 = i1 * paramFloat;
      int i2 = this.n;
      double d2 = i2 * paramFloat;
      double d3 = this.m * paramFloat;
      double d4 = this.o * paramFloat;
      if (i1 > i2) {
        d1 = paramLatLngBounds.getLongitudeE6() - (d1 - d2) / 2.0D;
      } else if (i1 < i2) {
        d1 = paramLatLngBounds.getLongitudeE6() + (d2 - d1) / 2.0D;
      } else {
        d1 = paramLatLngBounds.getLongitudeE6();
      }
      i1 = this.m;
      i2 = this.o;
      if (i1 < i2) {
        d2 = paramLatLngBounds.getLatitudeE6() - (d4 - d3) / 2.0D;
      }
      for (;;)
      {
        d2 += d3 / 2.0D;
        break label203;
        if (i1 <= i2) {
          break;
        }
        d2 = paramLatLngBounds.getLatitudeE6();
        d3 -= d4;
      }
      d2 = paramLatLngBounds.getLatitudeE6();
      label203:
      return CoordUtil.mc2ll(new GeoPoint(d2, d1));
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, c paramc)
  {
    paramc = paramc.p();
    if (paramc == null) {
      return true;
    }
    if ((paramInt1 == paramc.l) && (paramInt2 == paramc.m) && (paramInt3 == paramc.n)) {
      return paramInt4 != paramc.o;
    }
    return true;
  }
  
  private boolean a(LatLngBounds paramLatLngBounds, c paramc)
  {
    paramc = paramc.p();
    if (paramc == null) {
      return true;
    }
    LatLng localLatLng = paramLatLngBounds.southwest;
    double d1 = localLatLng.latitude;
    double d2 = localLatLng.longitude;
    paramLatLngBounds = paramLatLngBounds.northeast;
    double d3 = paramLatLngBounds.latitude;
    double d4 = paramLatLngBounds.longitude;
    paramLatLngBounds = paramc.d;
    paramc = paramLatLngBounds.southwest;
    double d5 = paramc.latitude;
    double d6 = paramc.longitude;
    paramLatLngBounds = paramLatLngBounds.northeast;
    double d7 = paramLatLngBounds.latitude;
    double d8 = paramLatLngBounds.longitude;
    return (d1 != d5) || (d2 != d6) || (d3 != d7) || (d4 != d8);
  }
  
  MapStatus a(c paramc, MapStatus paramMapStatus)
  {
    Object localObject1 = null;
    if (paramc != null)
    {
      if (paramMapStatus == null) {
        return null;
      }
      int i2;
      int i1;
      int i3;
      Object localObject2;
      double d1;
      double d2;
      double d3;
      double d4;
      float f1;
      switch (this.a)
      {
      default: 
        return null;
      case 11: 
        if (this.d == null) {
          return null;
        }
        i2 = paramc.y() - this.l - this.n;
        i1 = i2;
        if (i2 < 0)
        {
          i1 = paramc.y();
          Log.e(p, "Bound paddingLeft or paddingRight too larger, please check");
        }
        i3 = paramc.o() - this.m - this.o;
        i2 = i3;
        if (i3 < 0)
        {
          i2 = paramc.o();
          Log.e(p, "Bound paddingTop or paddingBottom too larger, please check");
        }
        localObject1 = CoordUtil.ll2mc(this.d.southwest);
        localObject2 = CoordUtil.ll2mc(this.d.northeast);
        d1 = ((GeoPoint)localObject1).getLongitudeE6();
        d2 = ((GeoPoint)localObject2).getLatitudeE6();
        d3 = ((GeoPoint)localObject2).getLongitudeE6();
        d4 = ((GeoPoint)localObject1).getLatitudeE6();
        f1 = paramc.a((int)d1, (int)d2, (int)d3, (int)d4, i1, i2);
        paramc = new Point(this.l + i1 / 2, this.m + i2 / 2);
        localObject1 = this.d.getCenter();
        return new MapStatus(paramMapStatus.rotate, (LatLng)localObject1, paramMapStatus.overlook, f1, paramc, null);
      case 10: 
        if (this.d == null) {
          return null;
        }
        i2 = paramc.y() - this.l - this.n;
        i1 = i2;
        if (i2 < 0)
        {
          i1 = paramc.y();
          Log.e(p, "Bound paddingLeft or paddingRight too larger, please check");
        }
        i3 = paramc.o() - this.m - this.o;
        i2 = i3;
        if (i3 < 0)
        {
          i2 = paramc.o();
          Log.e(p, "Bound paddingTop or paddingBottom too larger, please check");
        }
        f1 = a(this.d, paramc, i1, i2);
        float f2 = a(f1);
        localObject2 = a(this.d, paramc, f2);
        if (localObject2 == null)
        {
          Log.e(p, "Bound center error");
          return null;
        }
        boolean bool1 = a(this.d, paramc);
        boolean bool2 = a(this.l, this.m, this.n, this.o, paramc);
        if ((!bool1) && (!bool2))
        {
          paramMapStatus = (MapStatus)localObject1;
          if (paramc.p() != null) {
            return paramc.p().b;
          }
        }
        else
        {
          paramMapStatus = new MapStatus(paramMapStatus.rotate, (LatLng)localObject2, paramMapStatus.overlook, f1, null, null);
          paramc.a(a(paramMapStatus));
        }
        return paramMapStatus;
      case 9: 
        localObject1 = this.d;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = CoordUtil.ll2mc(((LatLngBounds)localObject1).southwest);
        localObject2 = CoordUtil.ll2mc(this.d.northeast);
        d1 = ((GeoPoint)localObject1).getLongitudeE6();
        d2 = ((GeoPoint)localObject2).getLatitudeE6();
        d3 = ((GeoPoint)localObject2).getLongitudeE6();
        d4 = ((GeoPoint)localObject1).getLatitudeE6();
        f1 = paramc.a((int)d1, (int)d2, (int)d3, (int)d4, this.e, this.f);
        paramc = this.d.getCenter();
        return new MapStatus(paramMapStatus.rotate, paramc, paramMapStatus.overlook, f1, paramMapStatus.targetScreen, null);
      case 8: 
        return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen, paramMapStatus.b(), paramMapStatus.c(), null);
      case 7: 
        localObject1 = this.k;
        paramc = CoordUtil.mc2ll(paramc.a(((Point)localObject1).x, ((Point)localObject1).y));
        return new MapStatus(paramMapStatus.rotate, paramc, paramMapStatus.overlook, paramMapStatus.zoom + this.j, this.k, null);
      case 6: 
        return new MapStatus(paramMapStatus.rotate, paramMapStatus.target, paramMapStatus.overlook, paramMapStatus.zoom + this.j, paramMapStatus.targetScreen, paramMapStatus.b(), paramMapStatus.c(), null);
      case 5: 
        paramc = paramc.a(paramc.y() / 2 + this.h, paramc.o() / 2 + this.i);
        localObject1 = CoordUtil.mc2ll(paramc);
        return new MapStatus(paramMapStatus.rotate, (LatLng)localObject1, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen, paramc.getLongitudeE6(), paramc.getLatitudeE6(), null);
      case 4: 
        return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, this.g, paramMapStatus.targetScreen, null);
      case 3: 
        localObject1 = this.d;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = CoordUtil.ll2mc(((LatLngBounds)localObject1).southwest);
        localObject2 = CoordUtil.ll2mc(this.d.northeast);
        d1 = ((GeoPoint)localObject1).getLongitudeE6();
        d2 = ((GeoPoint)localObject2).getLatitudeE6();
        d3 = ((GeoPoint)localObject2).getLongitudeE6();
        d4 = ((GeoPoint)localObject1).getLatitudeE6();
        i1 = (int)d1;
        i2 = (int)d2;
        i3 = (int)d3;
        int i4 = (int)d4;
        localObject1 = paramMapStatus.c.j;
        f1 = paramc.a(i1, i2, i3, i4, ((WinRound)localObject1).right - ((WinRound)localObject1).left, ((WinRound)localObject1).bottom - ((WinRound)localObject1).top);
        paramc = this.d.getCenter();
        return new MapStatus(paramMapStatus.rotate, paramc, paramMapStatus.overlook, f1, paramMapStatus.targetScreen, null);
      case 2: 
        return new MapStatus(paramMapStatus.rotate, this.c, paramMapStatus.overlook, paramMapStatus.zoom, paramMapStatus.targetScreen, null);
      }
      return this.b;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapStatusUpdate
 * JD-Core Version:    0.7.0.1
 */