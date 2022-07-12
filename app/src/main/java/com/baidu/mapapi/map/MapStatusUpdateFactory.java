package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

public final class MapStatusUpdateFactory
{
  public static MapStatusUpdate newLatLng(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(2);
    localMapStatusUpdate.c = paramLatLng;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate newLatLngBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(3);
    localMapStatusUpdate.d = paramLatLngBounds;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2)
  {
    if ((paramLatLngBounds != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(9);
      localMapStatusUpdate.d = paramLatLngBounds;
      localMapStatusUpdate.e = paramInt1;
      localMapStatusUpdate.f = paramInt2;
      return localMapStatusUpdate;
    }
    return null;
  }
  
  public static MapStatusUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramLatLngBounds == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(10);
    localMapStatusUpdate.d = paramLatLngBounds;
    localMapStatusUpdate.l = paramInt1;
    localMapStatusUpdate.m = paramInt2;
    localMapStatusUpdate.n = paramInt3;
    localMapStatusUpdate.o = paramInt4;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(4);
    if (paramLatLng == null) {
      return null;
    }
    localMapStatusUpdate.c = paramLatLng;
    localMapStatusUpdate.g = paramFloat;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate newLatLngZoom(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramLatLngBounds == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(11);
    localMapStatusUpdate.d = paramLatLngBounds;
    localMapStatusUpdate.l = paramInt1;
    localMapStatusUpdate.m = paramInt2;
    localMapStatusUpdate.n = paramInt3;
    localMapStatusUpdate.o = paramInt4;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate newMapStatus(MapStatus paramMapStatus)
  {
    if (paramMapStatus == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(1);
    localMapStatusUpdate.b = paramMapStatus;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate scrollBy(int paramInt1, int paramInt2)
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(5);
    localMapStatusUpdate.h = paramInt1;
    localMapStatusUpdate.i = paramInt2;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate zoomBy(float paramFloat)
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(6);
    localMapStatusUpdate.j = paramFloat;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    if (paramPoint == null) {
      return null;
    }
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(7);
    localMapStatusUpdate.j = paramFloat;
    localMapStatusUpdate.k = paramPoint;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate zoomIn()
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(6);
    localMapStatusUpdate.j = 1.0F;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate zoomOut()
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(6);
    localMapStatusUpdate.j = -1.0F;
    return localMapStatusUpdate;
  }
  
  public static MapStatusUpdate zoomTo(float paramFloat)
  {
    MapStatusUpdate localMapStatusUpdate = new MapStatusUpdate(8);
    localMapStatusUpdate.g = paramFloat;
    return localMapStatusUpdate;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MapStatusUpdateFactory
 * JD-Core Version:    0.7.0.1
 */