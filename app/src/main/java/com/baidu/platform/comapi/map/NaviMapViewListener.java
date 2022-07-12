package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

public abstract interface NaviMapViewListener
{
  public abstract void onAction(int paramInt, Object paramObject);
  
  public abstract boolean onItemClick(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onMapAnimationFinish();
  
  public abstract void onMapRenderModeChange(int paramInt);
  
  public abstract Point onTapInterception(Point paramPoint);
  
  public abstract void resizeScreen(int paramInt1, int paramInt2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.NaviMapViewListener
 * JD-Core Version:    0.7.0.1
 */