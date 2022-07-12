package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import org.json.JSONException;
import org.json.JSONObject;

class j
  implements Projection
{
  private MapController a;
  
  public j(MapController paramMapController)
  {
    this.a = paramMapController;
  }
  
  public GeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.a.getBaseMap();
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((AppBaseMap)localObject1).ScrPtToGeoPoint(paramInt1, paramInt2);
    localObject1 = new GeoPoint(0, 0);
    if (localObject2 != null) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      ((GeoPoint)localObject1).setLongitude(((JSONObject)localObject2).getDouble("geox"));
      ((GeoPoint)localObject1).setLatitude(((JSONObject)localObject2).getDouble("geoy"));
      return localObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
    return null;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return (float)(paramFloat / this.a.getZoomUnitsInMeter());
  }
  
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    Point localPoint = paramPoint;
    if (paramPoint == null) {
      localPoint = new Point(0, 0);
    }
    paramPoint = this.a.getBaseMap();
    if (paramPoint == null) {
      return localPoint;
    }
    paramGeoPoint = paramPoint.GeoPtToScrPoint((int)paramGeoPoint.getLongitude(), (int)paramGeoPoint.getLatitude());
    if (paramGeoPoint != null) {}
    try
    {
      paramGeoPoint = new JSONObject(paramGeoPoint);
      localPoint.setIntX(paramGeoPoint.getInt("scrx"));
      localPoint.setIntY(paramGeoPoint.getInt("scry"));
      return localPoint;
    }
    catch (JSONException paramGeoPoint) {}
    return localPoint;
  }
  
  public Point world2Screen(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Point localPoint = new Point(0, 0);
    Object localObject = this.a.getBaseMap();
    if (localObject == null) {
      return localPoint;
    }
    localObject = ((AppBaseMap)localObject).worldPointToScreenPoint(paramFloat1, paramFloat2, paramFloat3);
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      localPoint.setDoubleX(((JSONObject)localObject).optDouble("scrx"));
      localPoint.setDoubleY(((JSONObject)localObject).optDouble("scry"));
      return localPoint;
    }
    catch (JSONException localJSONException)
    {
      label81:
      break label81;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.j
 * JD-Core Version:    0.7.0.1
 */