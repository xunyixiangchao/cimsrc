package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.platform.util.a;

public class b
  extends com.baidu.platform.base.c
{
  public b(PoiIndoorOption paramPoiIndoorOption)
  {
    a(paramPoiIndoorOption);
  }
  
  private void a(PoiIndoorOption paramPoiIndoorOption)
  {
    this.c.a("qt", "indoor_s");
    this.c.a("x", "0");
    this.c.a("y", "0");
    this.c.a("from", "android_map_sdk");
    Object localObject = paramPoiIndoorOption.bid;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      this.c.a("bid", (String)localObject);
    }
    localObject = paramPoiIndoorOption.wd;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      this.c.a("wd", (String)localObject);
    }
    localObject = paramPoiIndoorOption.floor;
    if ((localObject != null) && (!((String)localObject).equals(""))) {
      this.c.a("floor", (String)localObject);
    }
    localObject = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPoiIndoorOption.currentPage);
    localStringBuilder.append("");
    ((a)localObject).a("current", localStringBuilder.toString());
    localObject = this.c;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPoiIndoorOption.pageSize);
    localStringBuilder.append("");
    ((a)localObject).a("pageSize", localStringBuilder.toString());
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.b
 * JD-Core Version:    0.7.0.1
 */