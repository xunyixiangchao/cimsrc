package com.baidu.mapapi.search.busline;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.busline.IBusLineSearch;
import com.baidu.platform.core.busline.c;

public class BusLineSearch
  extends a
{
  IBusLineSearch a = new c();
  private boolean b = false;
  
  public static BusLineSearch newInstance()
  {
    BMapManager.init();
    return new BusLineSearch();
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
  
  public boolean searchBusLine(BusLineSearchOption paramBusLineSearchOption)
  {
    IBusLineSearch localIBusLineSearch = this.a;
    if (localIBusLineSearch != null)
    {
      if ((paramBusLineSearchOption != null) && (paramBusLineSearchOption.mCity != null) && (paramBusLineSearchOption.mUid != null)) {
        return localIBusLineSearch.a(paramBusLineSearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or city or uid can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
  
  public void setOnGetBusLineSearchResultListener(OnGetBusLineSearchResultListener paramOnGetBusLineSearchResultListener)
  {
    IBusLineSearch localIBusLineSearch = this.a;
    if (localIBusLineSearch != null)
    {
      if (paramOnGetBusLineSearchResultListener != null)
      {
        localIBusLineSearch.a(paramOnGetBusLineSearchResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineSearch
 * JD-Core Version:    0.7.0.1
 */