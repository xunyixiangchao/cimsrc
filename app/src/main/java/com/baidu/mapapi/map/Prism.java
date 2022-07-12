package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

public final class Prism
  extends Overlay
{
  float e;
  List<LatLng> f;
  int g = -16777216;
  int h = -16711936;
  BuildingInfo i;
  BitmapDescriptor j;
  
  public Prism()
  {
    this.type = e.l;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Overlay.c(this.g, paramBundle);
    Overlay.b(this.h, paramBundle);
    Object localObject = this.j;
    if (localObject != null) {
      paramBundle.putBundle("image_info", ((BitmapDescriptor)localObject).a());
    }
    localObject = this.i;
    int k = 0;
    if (localObject != null)
    {
      paramBundle.putDouble("m_height", ((BuildingInfo)localObject).getHeight());
      localObject = new t();
      Overlay.c(((t)localObject).d(this.i.getGeom()), paramBundle);
      localObject = CoordUtil.ll2mc(((t)localObject).c(this.i.getCenter()));
      paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
    }
    else
    {
      localObject = CoordUtil.ll2mc((LatLng)this.f.get(0));
      paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
      Overlay.c(this.f, paramBundle);
      paramBundle.putDouble("m_height", this.e);
    }
    if (this.i != null) {
      k = 1;
    }
    paramBundle.putInt("m_isBuilding", k);
    return paramBundle;
  }
  
  public BuildingInfo getBuildingInfo()
  {
    return this.i;
  }
  
  public BitmapDescriptor getCustomSideImage()
  {
    return this.j;
  }
  
  public float getHeight()
  {
    return this.e;
  }
  
  public List<LatLng> getPoints()
  {
    return this.f;
  }
  
  public int getSideFaceColor()
  {
    return this.h;
  }
  
  public int getTopFaceColor()
  {
    return this.g;
  }
  
  public void setBuildingInfo(BuildingInfo paramBuildingInfo)
  {
    this.i = paramBuildingInfo;
    this.listener.c(this);
  }
  
  public void setCustomSideImage(BitmapDescriptor paramBitmapDescriptor)
  {
    this.j = paramBitmapDescriptor;
    this.listener.c(this);
  }
  
  public void setHeight(float paramFloat)
  {
    this.e = paramFloat;
    this.listener.c(this);
  }
  
  public void setPoints(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() > 3)
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
          this.f = paramList;
          this.listener.c(this);
          return;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public void setSideFaceColor(int paramInt)
  {
    this.h = paramInt;
    this.listener.c(this);
  }
  
  public void setTopFaceColor(int paramInt)
  {
    this.g = paramInt;
    this.listener.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Prism
 * JD-Core Version:    0.7.0.1
 */