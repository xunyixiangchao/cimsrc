package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

public final class GroundOverlayOptions
  extends OverlayOptions
{
  private BitmapDescriptor a;
  private LatLng b;
  private int c;
  private int d;
  private float e = 0.5F;
  private float f = 0.5F;
  private LatLngBounds g;
  private float h = 1.0F;
  int i;
  boolean j = true;
  Bundle k;
  
  Overlay a()
  {
    GroundOverlay localGroundOverlay = new GroundOverlay();
    localGroundOverlay.c = this.j;
    localGroundOverlay.b = this.i;
    localGroundOverlay.d = this.k;
    Object localObject = this.a;
    if (localObject != null)
    {
      localGroundOverlay.f = ((BitmapDescriptor)localObject);
      localObject = this.g;
      int m;
      if (localObject == null)
      {
        LatLng localLatLng = this.b;
        if (localLatLng != null)
        {
          m = this.c;
          if (m > 0)
          {
            int n = this.d;
            if (n > 0)
            {
              localGroundOverlay.g = localLatLng;
              localGroundOverlay.j = this.e;
              localGroundOverlay.k = this.f;
              localGroundOverlay.h = m;
              localGroundOverlay.i = n;
              m = 2;
              break label158;
            }
          }
          throw new IllegalArgumentException("BDMapSDKException: when you add ground overlay, the width and height must greater than 0");
        }
      }
      if ((this.b == null) && (localObject != null))
      {
        localGroundOverlay.l = ((LatLngBounds)localObject);
        m = 1;
        label158:
        localGroundOverlay.e = m;
        localGroundOverlay.m = this.h;
        return localGroundOverlay;
      }
      throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set one of position or bounds");
    }
    throw new IllegalStateException("BDMapSDKException: when you add ground overlay, you must set the image");
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
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
  
  public GroundOverlayOptions dimensions(int paramInt)
  {
    this.c = paramInt;
    this.d = 2147483647;
    return this;
  }
  
  public GroundOverlayOptions dimensions(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    return this;
  }
  
  public GroundOverlayOptions extraInfo(Bundle paramBundle)
  {
    this.k = paramBundle;
    return this;
  }
  
  public float getAnchorX()
  {
    return this.e;
  }
  
  public float getAnchorY()
  {
    return this.f;
  }
  
  public LatLngBounds getBounds()
  {
    return this.g;
  }
  
  public Bundle getExtraInfo()
  {
    return this.k;
  }
  
  public int getHeight()
  {
    int n = this.d;
    int m = n;
    if (n == 2147483647) {
      m = (int)(this.c * this.a.a.getHeight() / this.a.a.getWidth());
    }
    return m;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.a;
  }
  
  public LatLng getPosition()
  {
    return this.b;
  }
  
  public float getTransparency()
  {
    return this.h;
  }
  
  public int getWidth()
  {
    return this.c;
  }
  
  public int getZIndex()
  {
    return this.i;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      this.a = paramBitmapDescriptor;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: image can not be null");
  }
  
  public boolean isVisible()
  {
    return this.j;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.b = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: position can not be null");
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null)
    {
      this.g = paramLatLngBounds;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: bounds can not be null");
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if (paramFloat <= 1.0F)
    {
      if (paramFloat < 0.0F) {
        return this;
      }
      this.h = paramFloat;
    }
    return this;
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.j = paramBoolean;
    return this;
  }
  
  public GroundOverlayOptions zIndex(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */