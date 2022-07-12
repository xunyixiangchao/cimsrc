package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapsdkplatform.comapi.map.z.b;
import java.util.List;

public class TraceOverlay
{
  int a = -265058817;
  int b = 14;
  List<LatLng> c;
  int d = 300;
  int e = 0;
  boolean f;
  int g;
  boolean h;
  public b mListener;
  
  public void clear()
  {
    this.mListener.b(this);
  }
  
  public int getAnimationDuration()
  {
    return this.e;
  }
  
  public int getAnimationTime()
  {
    return this.d;
  }
  
  public int getAnimationType()
  {
    return this.g;
  }
  
  public int getColor()
  {
    return this.a;
  }
  
  public LatLngBounds getLatLngBounds()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = new LatLngBounds.Builder();
      ((LatLngBounds.Builder)localObject).include(this.c);
      return ((LatLngBounds.Builder)localObject).build();
    }
    return null;
  }
  
  public List<LatLng> getPoints()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.b;
  }
  
  public boolean isAnimate()
  {
    return this.f;
  }
  
  public boolean isTrackMove()
  {
    return this.h;
  }
  
  public void remove()
  {
    this.mListener.c(this);
  }
  
  public void setAnimate(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setAnimationTime(int paramInt)
  {
    if (paramInt >= 300)
    {
      this.d = paramInt;
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
  }
  
  public void setColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setTraceAnimationType(TraceOptions.TraceAnimateType paramTraceAnimateType)
  {
    TraceOptions.TraceAnimateType localTraceAnimateType = paramTraceAnimateType;
    if (paramTraceAnimateType == null) {
      localTraceAnimateType = TraceOptions.TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
    }
    this.g = localTraceAnimateType.ordinal();
  }
  
  public void setTracePoints(List<LatLng> paramList)
  {
    this.c = paramList;
  }
  
  public void setTrackMove(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void update()
  {
    this.mListener.a(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.track.TraceOverlay
 * JD-Core Version:    0.7.0.1
 */