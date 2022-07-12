package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class GroundOverlay
  extends Overlay
{
  int e;
  BitmapDescriptor f;
  LatLng g;
  double h;
  double i;
  float j;
  float k;
  LatLngBounds l;
  float m;
  
  GroundOverlay()
  {
    this.type = e.d;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putBundle("image_info", this.f.a());
    GeoPoint localGeoPoint;
    if (this.e == 1)
    {
      localGeoPoint = CoordUtil.ll2mc(this.l.southwest);
      d1 = localGeoPoint.getLongitudeE6();
      double d2 = localGeoPoint.getLatitudeE6();
      localGeoPoint = CoordUtil.ll2mc(this.l.northeast);
      double d4 = localGeoPoint.getLongitudeE6();
      double d3 = localGeoPoint.getLatitudeE6();
      d4 -= d1;
      this.h = d4;
      d3 -= d2;
      this.i = d3;
      this.g = CoordUtil.mc2ll(new GeoPoint(d2 + d3 / 2.0D, d1 + d4 / 2.0D));
      this.j = 0.5F;
      this.k = 0.5F;
    }
    double d1 = this.h;
    if ((d1 > 0.0D) && (this.i > 0.0D))
    {
      paramBundle.putDouble("x_distance", d1);
      if (this.i == 2147483647.0D) {
        this.i = ((int)(this.h * this.f.a.getHeight() / this.f.a.getWidth()));
      }
      paramBundle.putDouble("y_distance", this.i);
      localGeoPoint = CoordUtil.ll2mc(this.g);
      paramBundle.putDouble("location_x", localGeoPoint.getLongitudeE6());
      paramBundle.putDouble("location_y", localGeoPoint.getLatitudeE6());
      paramBundle.putFloat("anchor_x", this.j);
      paramBundle.putFloat("anchor_y", this.k);
      paramBundle.putFloat("transparency", this.m);
      return paramBundle;
    }
    throw new IllegalStateException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
  }
  
  public float getAnchorX()
  {
    return this.j;
  }
  
  public float getAnchorY()
  {
    return this.k;
  }
  
  public LatLngBounds getBounds()
  {
    return this.l;
  }
  
  public double getHeight()
  {
    return this.i;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.f;
  }
  
  public LatLng getPosition()
  {
    return this.g;
  }
  
  public float getTransparency()
  {
    return this.m;
  }
  
  public double getWidth()
  {
    return this.h;
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat1 > 1.0F) {
        return;
      }
      if (paramFloat2 >= 0.0F)
      {
        if (paramFloat2 > 1.0F) {
          return;
        }
        this.j = paramFloat1;
        this.k = paramFloat2;
        this.listener.c(this);
      }
    }
  }
  
  public void setDimensions(int paramInt)
  {
    this.h = paramInt;
    this.i = 2147483647.0D;
    this.listener.c(this);
  }
  
  public void setDimensions(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.listener.c(this);
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      this.f = paramBitmapDescriptor;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: image can not be null");
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.e = 2;
      this.g = paramLatLng;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: position can not be null");
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null)
    {
      this.e = 1;
      this.l = paramLatLngBounds;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
  }
  
  public void setTransparency(float paramFloat)
  {
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return;
      }
      this.m = paramFloat;
      this.listener.c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.GroundOverlay
 * JD-Core Version:    0.7.0.1
 */