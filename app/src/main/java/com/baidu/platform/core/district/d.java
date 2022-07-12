package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class d
  extends com.baidu.platform.base.a
  implements IDistrictSearch
{
  private OnGetDistricSearchResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean searchDistrict(DistrictSearchOption paramDistrictSearchOption)
  {
    b localb = new b();
    localb.a(SearchType.p);
    return a(new a(paramDistrictSearchOption), this.g, localb);
  }
  
  public void setOnDistrictSearchListener(OnGetDistricSearchResultListener paramOnGetDistricSearchResultListener)
  {
    this.c.lock();
    this.g = paramOnGetDistricSearchResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.district.d
 * JD-Core Version:    0.7.0.1
 */