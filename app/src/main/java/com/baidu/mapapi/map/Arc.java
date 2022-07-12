package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public final class Arc
  extends Overlay
{
  int e;
  int f;
  LatLng g;
  LatLng h;
  LatLng i;
  
  Arc()
  {
    this.type = e.f;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    ArrayList localArrayList = new ArrayList();
    localArrayList.clear();
    localArrayList.add(this.g);
    localArrayList.add(this.h);
    localArrayList.add(this.i);
    GeoPoint localGeoPoint = CoordUtil.ll2mc((LatLng)localArrayList.get(0));
    paramBundle.putDouble("location_x", localGeoPoint.getLongitudeE6());
    paramBundle.putDouble("location_y", localGeoPoint.getLatitudeE6());
    paramBundle.putInt("width", this.f);
    Overlay.c(localArrayList, paramBundle);
    Overlay.a(this.e, paramBundle);
    return paramBundle;
  }
  
  public int getColor()
  {
    return this.e;
  }
  
  public LatLng getEndPoint()
  {
    return this.i;
  }
  
  public LatLng getMiddlePoint()
  {
    return this.h;
  }
  
  public LatLng getStartPoint()
  {
    return this.g;
  }
  
  public int getWidth()
  {
    return this.f;
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
    this.listener.c(this);
  }
  
  public void setPoints(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    if ((paramLatLng1 != null) && (paramLatLng2 != null) && (paramLatLng3 != null))
    {
      if ((paramLatLng1 != paramLatLng2) && (paramLatLng1 != paramLatLng3) && (paramLatLng2 != paramLatLng3))
      {
        this.g = paramLatLng1;
        this.h = paramLatLng2;
        this.i = paramLatLng3;
        this.listener.c(this);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
    }
    throw new IllegalArgumentException("BDMapSDKException:start and middle and end points can not be null");
  }
  
  public void setWidth(int paramInt)
  {
    if (paramInt > 0)
    {
      this.f = paramInt;
      this.listener.c(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Arc
 * JD-Core Version:    0.7.0.1
 */