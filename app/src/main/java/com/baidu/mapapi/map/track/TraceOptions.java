package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

public class TraceOptions
{
  private int a = -15794282;
  private int b = 14;
  private List<LatLng> c;
  private int d = 300;
  private boolean e = false;
  private int f;
  private int g = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();
  private boolean h = false;
  
  public TraceOptions animate(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public TraceOptions animationDuration(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public TraceOptions animationTime(int paramInt)
  {
    if (paramInt >= 300)
    {
      this.d = paramInt;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
  }
  
  public TraceOptions animationType(TraceAnimateType paramTraceAnimateType)
  {
    TraceAnimateType localTraceAnimateType = paramTraceAnimateType;
    if (paramTraceAnimateType == null) {
      localTraceAnimateType = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
    }
    this.g = localTraceAnimateType.ordinal();
    return this;
  }
  
  public TraceOptions color(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public TraceAnimateType getAnimateType()
  {
    int i = this.g;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut;
      }
      return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut;
    }
    return TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
  }
  
  public int getAnimationDuration()
  {
    return this.f;
  }
  
  public int getAnimationTime()
  {
    return this.d;
  }
  
  public int getColor()
  {
    return this.a;
  }
  
  public TraceOverlay getOverlay()
  {
    TraceOverlay localTraceOverlay = new TraceOverlay();
    localTraceOverlay.a = this.a;
    localTraceOverlay.b = this.b;
    localTraceOverlay.c = this.c;
    localTraceOverlay.d = this.d;
    localTraceOverlay.f = this.e;
    localTraceOverlay.e = this.f;
    localTraceOverlay.g = this.g;
    localTraceOverlay.h = this.h;
    return localTraceOverlay;
  }
  
  public List<LatLng> getPoints()
  {
    return this.c;
  }
  
  public int getWidth()
  {
    return this.b;
  }
  
  public boolean isAnimation()
  {
    return this.e;
  }
  
  public boolean isTrackMove()
  {
    return this.h;
  }
  
  public TraceOptions points(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2)
      {
        if (!paramList.contains(null))
        {
          this.c = paramList;
          return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public TraceOptions setTrackMove(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }
  
  public TraceOptions width(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public static enum TraceAnimateType
  {
    static
    {
      TraceAnimateType localTraceAnimateType1 = new TraceAnimateType("TraceOverlayAnimationEasingCurveLinear", 0);
      TraceOverlayAnimationEasingCurveLinear = localTraceAnimateType1;
      TraceAnimateType localTraceAnimateType2 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseIn", 1);
      TraceOverlayAnimationEasingCurveEaseIn = localTraceAnimateType2;
      TraceAnimateType localTraceAnimateType3 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseOut", 2);
      TraceOverlayAnimationEasingCurveEaseOut = localTraceAnimateType3;
      TraceAnimateType localTraceAnimateType4 = new TraceAnimateType("TraceOverlayAnimationEasingCurveEaseInOut", 3);
      TraceOverlayAnimationEasingCurveEaseInOut = localTraceAnimateType4;
      a = new TraceAnimateType[] { localTraceAnimateType1, localTraceAnimateType2, localTraceAnimateType3, localTraceAnimateType4 };
    }
    
    private TraceAnimateType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.track.TraceOptions
 * JD-Core Version:    0.7.0.1
 */