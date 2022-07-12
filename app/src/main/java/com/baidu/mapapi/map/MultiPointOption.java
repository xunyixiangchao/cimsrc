package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import java.util.List;

public final class MultiPointOption
  extends OverlayOptions
{
  private List<MultiPointItem> a;
  private BitmapDescriptor b;
  private int c;
  private int d;
  private float e = 0.5F;
  private float f = 0.5F;
  private boolean g = true;
  
  Overlay a()
  {
    MultiPoint localMultiPoint = new MultiPoint();
    localMultiPoint.f = this.b;
    List localList = this.a;
    if (localList != null)
    {
      localMultiPoint.e = localList;
      localMultiPoint.h = this.d;
      localMultiPoint.g = this.c;
      localMultiPoint.i = this.e;
      localMultiPoint.j = this.f;
      localMultiPoint.c = this.g;
      return localMultiPoint;
    }
    throw new IllegalStateException("BDMapSDKException: when you add mMultiPointItems, you must set the mMultiPointItems");
  }
  
  public float getAnchorX()
  {
    return this.e;
  }
  
  public float getAnchorY()
  {
    return this.f;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.b;
  }
  
  public List<MultiPointItem> getMultiPointItems()
  {
    return this.a;
  }
  
  public int getPointSizeHeight()
  {
    return this.d;
  }
  
  public int getPointSizeWidth()
  {
    return this.c;
  }
  
  public boolean isVisible()
  {
    return this.g;
  }
  
  public MultiPointOption setAnchor(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat1 > 1.0F) {
        return this;
      }
      if (paramFloat2 >= 0.0F)
      {
        if (paramFloat2 > 1.0F) {
          return this;
        }
        this.e = paramFloat1;
        this.f = paramFloat2;
      }
    }
    return this;
  }
  
  public MultiPointOption setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      if (this.c == 0) {
        this.c = paramBitmapDescriptor.getBitmap().getWidth();
      }
      if (this.d == 0) {
        this.d = paramBitmapDescriptor.getBitmap().getHeight();
      }
      this.b = paramBitmapDescriptor;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: MultiPoint icon can not be null");
  }
  
  public MultiPointOption setMultiPointItems(List<MultiPointItem> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        this.a = paramList;
        return this;
      }
      throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
  }
  
  public MultiPointOption setPointSize(int paramInt1, int paramInt2)
  {
    if ((this.c > 0) && (this.d > 0))
    {
      this.c = paramInt1;
      this.d = paramInt2;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
  }
  
  public MultiPointOption visible(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MultiPointOption
 * JD-Core Version:    0.7.0.1
 */