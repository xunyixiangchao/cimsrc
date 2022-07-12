package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class a
  extends com.baidu.platform.base.a
  implements IGeoCoder
{
  OnGetGeoCoderResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean geocode(GeoCodeOption paramGeoCodeOption)
  {
    b localb = new b();
    c localc = new c(paramGeoCodeOption);
    localb.a(SearchType.g);
    if (paramGeoCodeOption != null) {
      localb.b(paramGeoCodeOption.getAddress());
    }
    return a(localc, this.g, localb);
  }
  
  public boolean reverseGeoCode(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    d locald = new d();
    paramReverseGeoCodeOption = new e(paramReverseGeoCodeOption);
    locald.a(SearchType.h);
    return a(paramReverseGeoCodeOption, this.g, locald);
  }
  
  public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener paramOnGetGeoCoderResultListener)
  {
    this.c.lock();
    this.g = paramOnGetGeoCoderResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.a
 * JD-Core Version:    0.7.0.1
 */