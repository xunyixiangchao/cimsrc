package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public final class MultiPoint
  extends Overlay
{
  List<MultiPointItem> e;
  BitmapDescriptor f;
  int g;
  int h;
  float i;
  float j;
  
  public MultiPoint()
  {
    this.type = e.k;
  }
  
  Bundle a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e;
      int k = 0;
      localObject = CoordUtil.ll2mc(((MultiPointItem)((List)localObject).get(0)).getPoint());
      paramBundle.putDouble("location_x", ((GeoPoint)localObject).getLongitudeE6());
      paramBundle.putDouble("location_y", ((GeoPoint)localObject).getLatitudeE6());
      localObject = new ArrayList();
      while (k < this.e.size())
      {
        MultiPointItem localMultiPointItem = (MultiPointItem)this.e.get(k);
        if (localMultiPointItem != null) {
          ((List)localObject).add(localMultiPointItem.getPoint());
        }
        k += 1;
      }
      Overlay.c((List)localObject, paramBundle);
    }
    localObject = this.f;
    if (localObject != null) {
      paramBundle.putBundle("image_info", ((BitmapDescriptor)localObject).a());
    }
    paramBundle.putInt("isClickable", 1);
    paramBundle.putFloat("anchor_x", this.i);
    paramBundle.putFloat("anchor_y", this.j);
    paramBundle.putFloat("pointsize_x", this.g);
    paramBundle.putFloat("pointsize_y", this.h);
    return paramBundle;
  }
  
  public void anchor(float paramFloat1, float paramFloat2)
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
        this.i = paramFloat1;
        this.j = paramFloat2;
        this.listener.c(this);
      }
    }
  }
  
  public float getAnchorX()
  {
    return this.i;
  }
  
  public float getAnchorY()
  {
    return this.j;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.f;
  }
  
  public List<MultiPointItem> getMultiPointItems()
  {
    return this.e;
  }
  
  public int getPointSizeHeight()
  {
    return this.h;
  }
  
  public int getPointSizeWidth()
  {
    return this.g;
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      this.f = paramBitmapDescriptor;
      if (this.g == 0) {
        this.g = paramBitmapDescriptor.getBitmap().getWidth();
      }
      if (this.h == 0) {
        this.h = paramBitmapDescriptor.getBitmap().getHeight();
      }
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
  }
  
  public void setMultiPointItems(List<MultiPointItem> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        this.e = paramList;
        this.listener.c(this);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
  }
  
  public void setPointSize(int paramInt1, int paramInt2)
  {
    if ((this.g > 0) && (this.h > 0))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MultiPoint
 * JD-Core Version:    0.7.0.1
 */