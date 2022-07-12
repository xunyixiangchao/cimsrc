package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;

public class a
  extends com.baidu.platform.base.c
{
  a(DistrictSearchOption paramDistrictSearchOption)
  {
    a(paramDistrictSearchOption);
  }
  
  private void a(DistrictSearchOption paramDistrictSearchOption)
  {
    if (paramDistrictSearchOption == null) {
      return;
    }
    this.c.a("qt", "con");
    this.c.a("rp_format", "json");
    this.c.a("rp_filter", "mobile");
    this.c.a("area_res", "true");
    this.c.a("addr_identify", "1");
    this.c.a("ie", "utf-8");
    this.c.a("pn", "0");
    this.c.a("rn", "10");
    this.c.a("c", paramDistrictSearchOption.mCityName);
    Object localObject1 = paramDistrictSearchOption.mDistrictName;
    Object localObject2;
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      localObject1 = this.c;
      localObject2 = paramDistrictSearchOption.mDistrictName;
      paramDistrictSearchOption = (DistrictSearchOption)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = this.c;
      localObject1 = paramDistrictSearchOption.mCityName;
      paramDistrictSearchOption = (DistrictSearchOption)localObject2;
    }
    paramDistrictSearchOption.a("wd", (String)localObject1);
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.j();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.district.a
 * JD-Core Version:    0.7.0.1
 */