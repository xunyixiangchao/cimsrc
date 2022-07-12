package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.LatLng;

public class InfoWindow
{
  String a = "";
  BitmapDescriptor b;
  View c;
  LatLng d;
  OnInfoWindowClickListener e;
  a f;
  int g;
  boolean h = false;
  int i = SysOSUtil.getDensityDpi();
  boolean j = false;
  boolean k = false;
  boolean l = false;
  
  public InfoWindow(View paramView, LatLng paramLatLng, int paramInt)
  {
    if ((paramView != null) && (paramLatLng != null))
    {
      this.c = paramView;
      this.d = paramLatLng;
      this.g = paramInt;
      this.k = true;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
  }
  
  public InfoWindow(View paramView, LatLng paramLatLng, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramView != null) && (paramLatLng != null))
    {
      this.c = paramView;
      this.d = paramLatLng;
      this.g = paramInt1;
      this.h = paramBoolean;
      this.i = paramInt2;
      this.k = true;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: view and position can not be null");
  }
  
  public InfoWindow(BitmapDescriptor paramBitmapDescriptor, LatLng paramLatLng, int paramInt, OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if ((paramBitmapDescriptor != null) && (paramLatLng != null))
    {
      this.b = paramBitmapDescriptor;
      this.d = paramLatLng;
      this.e = paramOnInfoWindowClickListener;
      this.g = paramInt;
      this.l = true;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: bitmapDescriptor and position can not be null");
  }
  
  public BitmapDescriptor getBitmapDescriptor()
  {
    return this.b;
  }
  
  public LatLng getPosition()
  {
    return this.d;
  }
  
  public String getTag()
  {
    return this.a;
  }
  
  public View getView()
  {
    return this.c;
  }
  
  public int getYOffset()
  {
    return this.g;
  }
  
  public void setBitmapDescriptor(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor == null) {
      return;
    }
    this.b = paramBitmapDescriptor;
    this.f.b(this);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    this.d = paramLatLng;
    this.f.b(this);
  }
  
  public void setTag(String paramString)
  {
    this.a = paramString;
  }
  
  public void setView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.c = paramView;
    this.f.b(this);
  }
  
  public void setYOffset(int paramInt)
  {
    this.g = paramInt;
    this.f.b(this);
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick();
  }
  
  static abstract interface a
  {
    public abstract void a(InfoWindow paramInfoWindow);
    
    public abstract void b(InfoWindow paramInfoWindow);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.InfoWindow
 * JD-Core Version:    0.7.0.1
 */