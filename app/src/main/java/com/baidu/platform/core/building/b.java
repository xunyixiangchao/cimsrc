package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class b
  extends com.baidu.platform.base.a
  implements IBuildingSearch
{
  private OnGetBuildingSearchResultListener g;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean searchBuilding(BuildingSearchOption paramBuildingSearchOption)
  {
    a locala = new a();
    locala.a(SearchType.v);
    return a(new c(paramBuildingSearchOption), this.g, locala);
  }
  
  public void setOnBuildingSearchListener(OnGetBuildingSearchResultListener paramOnGetBuildingSearchResultListener)
  {
    this.c.lock();
    this.g = paramOnGetBuildingSearchResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.building.b
 * JD-Core Version:    0.7.0.1
 */