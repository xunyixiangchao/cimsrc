package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class f
  extends com.baidu.platform.base.a
  implements IShareUrlSearch
{
  OnGetShareUrlResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean requestLocationShareUrl(LocationShareURLOption paramLocationShareURLOption)
  {
    e locale = new e();
    locale.a(SearchType.r);
    return a(new a(paramLocationShareURLOption), this.g, locale);
  }
  
  public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    e locale = new e();
    locale.a(SearchType.q);
    return a(new b(paramPoiDetailShareURLOption), this.g, locale);
  }
  
  public boolean requestRouteShareUrl(RouteShareURLOption paramRouteShareURLOption)
  {
    c localc = new c();
    localc.a(SearchType.s);
    return a(new d(paramRouteShareURLOption), this.g, localc);
  }
  
  public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener paramOnGetShareUrlResultListener)
  {
    this.c.lock();
    this.g = paramOnGetShareUrlResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.f
 * JD-Core Version:    0.7.0.1
 */