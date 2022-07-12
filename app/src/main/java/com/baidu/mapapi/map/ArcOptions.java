package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

public final class ArcOptions
  extends OverlayOptions
{
  private int a = -16777216;
  private int b = 5;
  private LatLng c;
  private LatLng d;
  private LatLng e;
  int f;
  boolean g = true;
  Bundle h;
  
  Overlay a()
  {
    Arc localArc = new Arc();
    localArc.c = this.g;
    localArc.b = this.f;
    localArc.d = this.h;
    localArc.e = this.a;
    localArc.f = this.b;
    localArc.g = this.c;
    localArc.h = this.d;
    localArc.i = this.e;
    return localArc;
  }
  
  public ArcOptions color(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public ArcOptions extraInfo(Bundle paramBundle)
  {
    this.h = paramBundle;
    return this;
  }
  
  public int getColor()
  {
    return this.a;
  }
  
  public LatLng getEndPoint()
  {
    return this.e;
  }
  
  public Bundle getExtraInfo()
  {
    return this.h;
  }
  
  public LatLng getMiddlePoint()
  {
    return this.d;
  }
  
  public LatLng getStartPoint()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.b;
  }
  
  public int getZIndex()
  {
    return this.f;
  }
  
  public boolean isVisible()
  {
    return this.g;
  }
  
  public ArcOptions points(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    if ((paramLatLng1 != null) && (paramLatLng2 != null) && (paramLatLng3 != null))
    {
      if ((paramLatLng1 != paramLatLng2) && (paramLatLng1 != paramLatLng3) && (paramLatLng2 != paramLatLng3))
      {
        this.c = paramLatLng1;
        this.d = paramLatLng2;
        this.e = paramLatLng3;
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
    }
    throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
  }
  
  public ArcOptions visible(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public ArcOptions width(int paramInt)
  {
    if (paramInt > 0) {
      this.b = paramInt;
    }
    return this;
  }
  
  public ArcOptions zIndex(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.ArcOptions
 * JD-Core Version:    0.7.0.1
 */