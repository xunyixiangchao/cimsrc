package com.baidu.mapapi.map;

import com.baidu.mapsdkplatform.comapi.map.c;

public final class UiSettings
{
  private c a;
  
  UiSettings(c paramc)
  {
    this.a = paramc;
  }
  
  public boolean isCompassEnabled()
  {
    return this.a.j();
  }
  
  public boolean isOverlookingGesturesEnabled()
  {
    return this.a.I();
  }
  
  public boolean isRotateGesturesEnabled()
  {
    return this.a.J();
  }
  
  public boolean isScrollGesturesEnabled()
  {
    return this.a.L();
  }
  
  public boolean isZoomGesturesEnabled()
  {
    return this.a.N();
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    setRotateGesturesEnabled(paramBoolean);
    setScrollGesturesEnabled(paramBoolean);
    setOverlookingGesturesEnabled(paramBoolean);
    setZoomGesturesEnabled(paramBoolean);
    setDoubleClickZoomEnabled(paramBoolean);
    setTwoTouchClickZoomEnabled(paramBoolean);
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    this.a.f(paramBoolean);
  }
  
  public void setDoubleClickZoomEnabled(boolean paramBoolean)
  {
    this.a.g(paramBoolean);
  }
  
  public void setEnlargeCenterWithDoubleClickEnable(boolean paramBoolean)
  {
    this.a.h(paramBoolean);
  }
  
  public void setOverlookingGesturesEnabled(boolean paramBoolean)
  {
    this.a.n(paramBoolean);
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    this.a.o(paramBoolean);
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.a.q(paramBoolean);
  }
  
  public void setTwoTouchClickZoomEnabled(boolean paramBoolean)
  {
    this.a.s(paramBoolean);
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    this.a.t(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.UiSettings
 * JD-Core Version:    0.7.0.1
 */