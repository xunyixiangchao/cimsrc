package com.baidu.platform.core.poi;

import android.util.Log;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.platform.util.a;

public class d
  extends com.baidu.platform.base.c
{
  d(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    a(paramPoiDetailSearchOption);
  }
  
  private void a(PoiDetailSearchOption paramPoiDetailSearchOption)
  {
    if (paramPoiDetailSearchOption == null)
    {
      Log.e(d.class.getSimpleName(), "Option is null");
      return;
    }
    if (!paramPoiDetailSearchOption.isSearchByUids()) {
      paramPoiDetailSearchOption.poiUids(paramPoiDetailSearchOption.getUid());
    }
    this.c.a("uids", paramPoiDetailSearchOption.getUids());
    this.c.a("output", "json");
    this.c.a("scope", "2");
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.u();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.d
 * JD-Core Version:    0.7.0.1
 */