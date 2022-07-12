package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public final class CircleOptions
  extends OverlayOptions
{
  private LatLng a;
  private int b = -16777216;
  private int c;
  private Stroke d;
  private boolean e = false;
  private int f = 0;
  private List<HoleOptions> g;
  private HoleOptions h;
  int i;
  boolean j = true;
  Bundle k;
  
  Overlay a()
  {
    Circle localCircle = new Circle();
    localCircle.c = this.j;
    localCircle.b = this.i;
    localCircle.d = this.k;
    localCircle.f = this.b;
    localCircle.e = this.a;
    localCircle.g = this.c;
    localCircle.h = this.d;
    localCircle.i = this.e;
    localCircle.j = this.f;
    localCircle.k = this.g;
    localCircle.l = this.h;
    return localCircle;
  }
  
  public CircleOptions addHoleOption(HoleOptions paramHoleOptions)
  {
    this.h = paramHoleOptions;
    return this;
  }
  
  public CircleOptions addHoleOptions(List<HoleOptions> paramList)
  {
    this.g = paramList;
    return this;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.a = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
  }
  
  public CircleOptions dottedStroke(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public CircleOptions dottedStrokeType(CircleDottedStrokeType paramCircleDottedStrokeType)
  {
    this.f = paramCircleDottedStrokeType.ordinal();
    return this;
  }
  
  public CircleOptions extraInfo(Bundle paramBundle)
  {
    this.k = paramBundle;
    return this;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.a;
  }
  
  public Bundle getExtraInfo()
  {
    return this.k;
  }
  
  public int getFillColor()
  {
    return this.b;
  }
  
  public int getRadius()
  {
    return this.c;
  }
  
  public Stroke getStroke()
  {
    return this.d;
  }
  
  public int getZIndex()
  {
    return this.i;
  }
  
  public boolean isVisible()
  {
    return this.j;
  }
  
  public CircleOptions radius(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public CircleOptions stroke(Stroke paramStroke)
  {
    this.d = paramStroke;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public CircleOptions zIndex(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.CircleOptions
 * JD-Core Version:    0.7.0.1
 */