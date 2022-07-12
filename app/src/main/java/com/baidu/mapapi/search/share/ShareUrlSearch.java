package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.platform.core.share.IShareUrlSearch;
import com.baidu.platform.core.share.f;

public class ShareUrlSearch
  extends a
{
  IShareUrlSearch a = new f();
  private boolean b = false;
  
  private boolean a(String paramString)
  {
    return true;
  }
  
  public static ShareUrlSearch newInstance()
  {
    BMapManager.init();
    return new ShareUrlSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean requestLocationShareUrl(LocationShareURLOption paramLocationShareURLOption)
  {
    IShareUrlSearch localIShareUrlSearch = this.a;
    if (localIShareUrlSearch != null)
    {
      if ((paramLocationShareURLOption != null) && (paramLocationShareURLOption.mLocation != null) && (paramLocationShareURLOption.mName != null) && (paramLocationShareURLOption.mSnippet != null)) {
        return localIShareUrlSearch.requestLocationShareUrl(paramLocationShareURLOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or name or snippet  can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
  }
  
  public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    IShareUrlSearch localIShareUrlSearch = this.a;
    if (localIShareUrlSearch != null)
    {
      if ((paramPoiDetailShareURLOption != null) && (paramPoiDetailShareURLOption.mUid != null)) {
        return localIShareUrlSearch.requestPoiDetailShareUrl(paramPoiDetailShareURLOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
  }
  
  public boolean requestRouteShareUrl(RouteShareURLOption paramRouteShareURLOption)
  {
    if (this.a != null)
    {
      if (paramRouteShareURLOption != null)
      {
        if (paramRouteShareURLOption.getmMode().ordinal() < 0) {
          return false;
        }
        Object localObject = paramRouteShareURLOption.mFrom;
        if ((localObject != null) && (paramRouteShareURLOption.mTo != null))
        {
          RouteShareURLOption.RouteShareMode localRouteShareMode1 = paramRouteShareURLOption.mMode;
          RouteShareURLOption.RouteShareMode localRouteShareMode2 = RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE;
          localObject = ((PlanNode)localObject).getLocation();
          if (localRouteShareMode1 == localRouteShareMode2)
          {
            if (((localObject == null) || (paramRouteShareURLOption.mTo.getLocation() == null)) && (paramRouteShareURLOption.mCityCode < 0)) {
              throw new IllegalArgumentException("BDMapSDKException: city code can not be null if don't set start or end point");
            }
          }
          else
          {
            if ((localObject == null) && (!a(paramRouteShareURLOption.mFrom.getCity()))) {
              throw new IllegalArgumentException("BDMapSDKException: start cityCode must be set if not set start location");
            }
            if ((paramRouteShareURLOption.mTo.getLocation() == null) && (!a(paramRouteShareURLOption.mTo.getCity()))) {
              throw new IllegalArgumentException("BDMapSDKException: end cityCode must be set if not set end location");
            }
          }
          return this.a.requestRouteShareUrl(paramRouteShareURLOption);
        }
        throw new IllegalArgumentException("BDMapSDKException: start or end point can not be null");
      }
      throw new IllegalArgumentException("BDMapSDKException: option is null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
  }
  
  public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener paramOnGetShareUrlResultListener)
  {
    IShareUrlSearch localIShareUrlSearch = this.a;
    if (localIShareUrlSearch != null)
    {
      if (paramOnGetShareUrlResultListener != null)
      {
        localIShareUrlSearch.setOnGetShareUrlResultListener(paramOnGetShareUrlResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.share.ShareUrlSearch
 * JD-Core Version:    0.7.0.1
 */