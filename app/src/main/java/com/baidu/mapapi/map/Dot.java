package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class Dot
  extends Overlay
{
  LatLng e;
  int f;
  int g;
  
  Dot()
  {
    this.type = e.g;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    GeoPoint localGeoPoint = CoordUtil.ll2mc(this.e);
    paramBundle.putDouble("location_x", localGeoPoint.getLongitudeE6());
    paramBundle.putDouble("location_y", localGeoPoint.getLatitudeE6());
    paramBundle.putInt("radius", this.g);
    Overlay.a(this.f, paramBundle);
    return paramBundle;
  }
  
  public LatLng getCenter()
  {
    return this.e;
  }
  
  public int getColor()
  {
    return this.f;
  }
  
  public int getRadius()
  {
    return this.g;
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.e = paramLatLng;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: dot center can not be null");
  }
  
  public void setColor(int paramInt)
  {
    this.f = paramInt;
    this.listener.c(this);
  }
  
  public void setRadius(int paramInt)
  {
    if (paramInt > 0)
    {
      this.g = paramInt;
      this.listener.c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Dot
 * JD-Core Version:    0.7.0.1
 */