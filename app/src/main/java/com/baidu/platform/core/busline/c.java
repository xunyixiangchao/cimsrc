package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class c
  extends com.baidu.platform.base.a
  implements IBusLineSearch
{
  OnGetBusLineSearchResultListener g = null;
  
  public void a(OnGetBusLineSearchResultListener paramOnGetBusLineSearchResultListener)
  {
    this.c.lock();
    this.g = paramOnGetBusLineSearchResultListener;
    this.c.unlock();
  }
  
  public boolean a(BusLineSearchOption paramBusLineSearchOption)
  {
    a locala = new a();
    locala.a(SearchType.o);
    return a(new b(paramBusLineSearchOption), this.g, locala);
  }
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.busline.c
 * JD-Core Version:    0.7.0.1
 */