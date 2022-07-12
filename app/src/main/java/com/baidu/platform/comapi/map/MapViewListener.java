package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;
import org.json.JSONObject;

public abstract interface MapViewListener
{
  public abstract void onClickPolymericMapObj(List<MapObj> paramList);
  
  public abstract void onClickSdkMapObj(int paramInt, JSONObject paramJSONObject);
  
  public abstract void onClickStreetArrow(MapObj paramMapObj);
  
  public abstract void onClickStreetSurface(MapObj paramMapObj);
  
  public abstract void onClickedBackground(int paramInt1, int paramInt2);
  
  public abstract void onClickedItem(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, long paramLong);
  
  public abstract void onClickedItem(int paramInt, GeoPoint paramGeoPoint, long paramLong);
  
  public abstract void onClickedItsMapObj(List<ItsMapObj> paramList);
  
  public abstract void onClickedMapObj(List<MapObj> paramList);
  
  @Deprecated
  public abstract void onClickedOPPoiEventMapObj(MapObj paramMapObj);
  
  public abstract void onClickedParticleEventMapObj(List<MapObj> paramList);
  
  public abstract void onClickedPoiObj(List<MapObj> paramList);
  
  public abstract void onClickedPopup(int paramInt);
  
  public abstract void onClickedRouteLabelObj(List<MapObj> paramList);
  
  public abstract void onClickedRouteObj(List<MapObj> paramList);
  
  public abstract void onClickedStreetIndoorPoi(MapObj paramMapObj);
  
  public abstract void onClickedStreetPopup(String paramString);
  
  public abstract void onClickedTrafficUgcEventMapObj(MapObj paramMapObj, boolean paramBoolean);
  
  public abstract void onClickedUniversalLayerPoiEventMapObj(List<MapObj> paramList);
  
  public abstract void onMapAnimationFinish();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.MapViewListener
 * JD-Core Version:    0.7.0.1
 */