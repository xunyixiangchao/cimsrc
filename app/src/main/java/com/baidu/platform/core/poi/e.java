package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class e
  extends com.baidu.platform.base.a
  implements IPoiSearch
{
  private OnGetPoiSearchResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean searchInBound(PoiBoundSearchOption paramPoiBoundSearchOption)
  {
    f localf = new f(paramPoiBoundSearchOption.mPageNum, paramPoiBoundSearchOption.mPageCapacity);
    localf.a(SearchType.c);
    return a(new g(paramPoiBoundSearchOption), this.g, localf);
  }
  
  public boolean searchInCity(PoiCitySearchOption paramPoiCitySearchOption)
  {
    f localf = new f(paramPoiCitySearchOption.mPageNum, paramPoiCitySearchOption.mPageCapacity);
    localf.a(SearchType.b);
    return a(new g(paramPoiCitySearchOption), this.g, localf);
  }
  
  public boolean searchNearby(PoiNearbySearchOption paramPoiNearbySearchOption)
  {
    f localf = new f(paramPoiNearbySearchOption.mPageNum, paramPoiNearbySearchOption.mPageCapacity);
    localf.a(SearchType.a);
    return a(new g(paramPoiNearbySearchOption), this.g, localf);
  }
  
  public boolean searchPoiDetail(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    c localc = new c();
    if (paramPoiDetailSearchOption != null) {
      localc.a(paramPoiDetailSearchOption.isSearchByUids());
    }
    localc.a(SearchType.d);
    return a(new d(paramPoiDetailSearchOption), this.g, localc);
  }
  
  public boolean searchPoiIndoor(PoiIndoorOption paramPoiIndoorOption)
  {
    a locala = new a();
    locala.a(SearchType.e);
    return a(new b(paramPoiIndoorOption), this.g, locala);
  }
  
  public void setOnPoiSearchListener(OnGetPoiSearchResultListener paramOnGetPoiSearchResultListener)
  {
    this.c.lock();
    this.g = paramOnGetPoiSearchResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.e
 * JD-Core Version:    0.7.0.1
 */