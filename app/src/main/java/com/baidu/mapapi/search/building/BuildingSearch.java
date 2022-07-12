package com.baidu.mapapi.search.building;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.a;
import com.baidu.platform.core.building.b;

public class BuildingSearch
  extends a
{
  private final b a = new b();
  private boolean b = false;
  
  public static BuildingSearch newInstance()
  {
    BMapManager.init();
    return new BuildingSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean requestBuilding(BuildingSearchOption paramBuildingSearchOption)
  {
    if (this.a != null)
    {
      if ((paramBuildingSearchOption != null) && (paramBuildingSearchOption.getLatLng() != null)) {
        return this.a.searchBuilding(paramBuildingSearchOption);
      }
      throw new IllegalStateException("BDMapSDKException: option or location can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance() first.");
  }
  
  public void setOnGetBuildingSearchResultListener(OnGetBuildingSearchResultListener paramOnGetBuildingSearchResultListener)
  {
    b localb = this.a;
    if (localb != null)
    {
      if (paramOnGetBuildingSearchResultListener != null)
      {
        localb.setOnBuildingSearchListener(paramOnGetBuildingSearchResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.building.BuildingSearch
 * JD-Core Version:    0.7.0.1
 */