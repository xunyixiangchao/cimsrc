package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public final class PolygonOptions
  extends OverlayOptions
{
  private Stroke a;
  private int b = -16777216;
  private List<LatLng> c;
  private List<HoleOptions> d;
  private HoleOptions e;
  private boolean f = false;
  private int g = 0;
  int h;
  boolean i = true;
  Bundle j;
  
  Overlay a()
  {
    Polygon localPolygon = new Polygon();
    localPolygon.c = this.i;
    localPolygon.b = this.h;
    localPolygon.d = this.j;
    List localList = this.c;
    if ((localList != null) && (localList.size() >= 2))
    {
      localPolygon.g = this.c;
      localPolygon.f = this.b;
      localPolygon.e = this.a;
      localPolygon.h = this.d;
      localPolygon.i = this.e;
      localPolygon.j = this.f;
      localPolygon.k = this.g;
      return localPolygon;
    }
    throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
  }
  
  public PolygonOptions addHoleOption(HoleOptions paramHoleOptions)
  {
    this.e = paramHoleOptions;
    return this;
  }
  
  public PolygonOptions addHoleOptions(List<HoleOptions> paramList)
  {
    this.d = paramList;
    return this;
  }
  
  public PolygonOptions dottedStroke(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public PolygonOptions dottedStrokeType(PolylineDottedLineType paramPolylineDottedLineType)
  {
    this.g = paramPolylineDottedLineType.ordinal();
    return this;
  }
  
  public PolygonOptions extraInfo(Bundle paramBundle)
  {
    this.j = paramBundle;
    return this;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Bundle getExtraInfo()
  {
    return this.j;
  }
  
  public int getFillColor()
  {
    return this.b;
  }
  
  public List<LatLng> getPoints()
  {
    return this.c;
  }
  
  public Stroke getStroke()
  {
    return this.a;
  }
  
  public int getZIndex()
  {
    return this.h;
  }
  
  public boolean isVisible()
  {
    return this.i;
  }
  
  public PolygonOptions points(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() > 2)
      {
        if (!paramList.contains(null))
        {
          int m;
          for (int k = 0; k < paramList.size(); k = m)
          {
            m = k + 1;
            int n = m;
            while (n < paramList.size()) {
              if ((LatLng)paramList.get(k) != (LatLng)paramList.get(n)) {
                n += 1;
              } else {
                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
              }
            }
          }
          this.c = paramList;
          return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public PolygonOptions stroke(Stroke paramStroke)
  {
    this.a = paramStroke;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }
  
  public PolygonOptions zIndex(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.PolygonOptions
 * JD-Core Version:    0.7.0.1
 */