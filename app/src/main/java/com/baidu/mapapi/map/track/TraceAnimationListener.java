package com.baidu.mapapi.map.track;

import com.baidu.mapapi.model.LatLng;

public abstract interface TraceAnimationListener
{
  public abstract void onTraceAnimationFinish();
  
  public abstract void onTraceAnimationUpdate(int paramInt);
  
  public abstract void onTraceUpdatePosition(LatLng paramLatLng);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.track.TraceAnimationListener
 * JD-Core Version:    0.7.0.1
 */