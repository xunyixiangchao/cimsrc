package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;

public abstract interface IBuildingSearch
{
  public abstract void destroy();
  
  public abstract boolean searchBuilding(BuildingSearchOption paramBuildingSearchOption);
  
  public abstract void setOnBuildingSearchListener(OnGetBuildingSearchResultListener paramOnGetBuildingSearchResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.building.IBuildingSearch
 * JD-Core Version:    0.7.0.1
 */