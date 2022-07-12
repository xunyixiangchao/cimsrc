package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class i
  extends com.baidu.platform.base.a
  implements IRoutePlanSearch
{
  private OnGetRoutePlanResultListener g = null;
  
  public boolean bikingSearch(BikingRoutePlanOption paramBikingRoutePlanOption)
  {
    a locala = new a();
    locala.a(SearchType.l);
    return a(new b(paramBikingRoutePlanOption), this.g, locala);
  }
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean drivingSearch(DrivingRoutePlanOption paramDrivingRoutePlanOption)
  {
    c localc = new c();
    localc.a(SearchType.k);
    return a(new d(paramDrivingRoutePlanOption), this.g, localc);
  }
  
  public boolean masstransitSearch(MassTransitRoutePlanOption paramMassTransitRoutePlanOption)
  {
    g localg = new g();
    localg.a(SearchType.i);
    return a(new h(paramMassTransitRoutePlanOption), this.g, localg);
  }
  
  public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener paramOnGetRoutePlanResultListener)
  {
    this.c.lock();
    this.g = paramOnGetRoutePlanResultListener;
    this.c.unlock();
  }
  
  public boolean transitSearch(TransitRoutePlanOption paramTransitRoutePlanOption)
  {
    k localk = new k();
    localk.a(SearchType.j);
    return a(new l(paramTransitRoutePlanOption), this.g, localk);
  }
  
  public boolean walkingIndoorSearch(IndoorRoutePlanOption paramIndoorRoutePlanOption)
  {
    e locale = new e();
    locale.a(SearchType.n);
    return a(new f(paramIndoorRoutePlanOption), this.g, locale);
  }
  
  public boolean walkingSearch(WalkingRoutePlanOption paramWalkingRoutePlanOption)
  {
    m localm = new m();
    localm.a(SearchType.m);
    return a(new n(paramWalkingRoutePlanOption), this.g, localm);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.i
 * JD-Core Version:    0.7.0.1
 */