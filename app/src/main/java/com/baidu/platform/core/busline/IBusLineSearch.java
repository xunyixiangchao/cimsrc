package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;

public abstract interface IBusLineSearch
{
  public abstract void a(OnGetBusLineSearchResultListener paramOnGetBusLineSearchResultListener);
  
  public abstract boolean a(BusLineSearchOption paramBusLineSearchOption);
  
  public abstract void destroy();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.busline.IBusLineSearch
 * JD-Core Version:    0.7.0.1
 */