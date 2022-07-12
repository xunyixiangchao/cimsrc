package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.baidu.platform.util.a;

public class b
  extends com.baidu.platform.base.c
{
  public b(BusLineSearchOption paramBusLineSearchOption)
  {
    a(paramBusLineSearchOption);
  }
  
  private void a(BusLineSearchOption paramBusLineSearchOption)
  {
    this.c.a("qt", "bsl");
    this.c.a("rt_info", "1");
    this.c.a("ie", "utf-8");
    this.c.a("oue", "0");
    this.c.a("c", paramBusLineSearchOption.mCity);
    this.c.a("uid", paramBusLineSearchOption.mUid);
    paramBusLineSearchOption = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    paramBusLineSearchOption.a("t", localStringBuilder.toString());
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.f();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.busline.b
 * JD-Core Version:    0.7.0.1
 */