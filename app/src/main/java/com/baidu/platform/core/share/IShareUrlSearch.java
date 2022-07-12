package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;

public abstract interface IShareUrlSearch
{
  public abstract void destroy();
  
  public abstract boolean requestLocationShareUrl(LocationShareURLOption paramLocationShareURLOption);
  
  public abstract boolean requestPoiDetailShareUrl(PoiDetailShareURLOption paramPoiDetailShareURLOption);
  
  public abstract boolean requestRouteShareUrl(RouteShareURLOption paramRouteShareURLOption);
  
  public abstract void setOnGetShareUrlResultListener(OnGetShareUrlResultListener paramOnGetShareUrlResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.IShareUrlSearch
 * JD-Core Version:    0.7.0.1
 */