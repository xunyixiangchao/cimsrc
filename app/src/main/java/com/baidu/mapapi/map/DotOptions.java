package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

public final class DotOptions
  extends OverlayOptions
{
  private LatLng a;
  private int b = -16777216;
  private int c = 5;
  int d;
  boolean e = true;
  Bundle f;
  
  Overlay a()
  {
    Dot localDot = new Dot();
    localDot.c = this.e;
    localDot.b = this.d;
    localDot.d = this.f;
    localDot.f = this.b;
    localDot.e = this.a;
    localDot.g = this.c;
    return localDot;
  }
  
  public DotOptions center(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.a = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
  }
  
  public DotOptions color(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public DotOptions extraInfo(Bundle paramBundle)
  {
    this.f = paramBundle;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.a;
  }
  
  public int getColor()
  {
    return this.b;
  }
  
  public Bundle getExtraInfo()
  {
    return this.f;
  }
  
  public int getRadius()
  {
    return this.c;
  }
  
  public int getZIndex()
  {
    return this.d;
  }
  
  public boolean isVisible()
  {
    return this.e;
  }
  
  public DotOptions radius(int paramInt)
  {
    if (paramInt > 0) {
      this.c = paramInt;
    }
    return this;
  }
  
  public DotOptions visible(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public DotOptions zIndex(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.DotOptions
 * JD-Core Version:    0.7.0.1
 */