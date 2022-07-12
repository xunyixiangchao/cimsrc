package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.route.IndoorRouteLine;
import com.baidu.mapapi.search.route.IndoorRouteLine.IndoorRouteStep;
import com.baidu.mapapi.search.route.IndoorRouteLine.IndoorRouteStep.IndoorStepNode;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.platform.base.b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends b
{
  private LatLng a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new GeoPoint(0, 0);
      paramString.setLatitudeE6((int)paramJSONObject.optDouble(1));
      paramString.setLongitudeE6((int)paramJSONObject.optDouble(0));
      return CoordUtil.mc2ll(paramString);
    }
    return null;
  }
  
  private boolean a(String paramString, IndoorRouteResult paramIndoorRouteResult)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        paramString = paramString.optJSONObject("indoor_navi");
        if (paramString == null) {
          return false;
        }
        Object localObject1 = paramString.optJSONObject("option");
        if (localObject1 == null) {
          return false;
        }
        int i = ((JSONObject)localObject1).optInt("error");
        if (i != 0)
        {
          if (i != 6) {
            if (i != 7) {
              return false;
            }
          }
          for (paramString = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_SAME_BUILDING;; paramString = SearchResult.ERRORNO.INDOOR_ROUTE_NO_IN_BUILDING)
          {
            paramIndoorRouteResult.error = paramString;
            return true;
          }
        }
        paramString = paramString.optJSONArray("routes");
        if (paramString == null) {
          return false;
        }
        paramString = paramString.optJSONObject(0);
        if (paramString == null) {
          return false;
        }
        ArrayList localArrayList1 = new ArrayList();
        paramString = paramString.optJSONArray("legs");
        if (paramString == null) {
          return false;
        }
        i = 0;
        while (i < paramString.length())
        {
          IndoorRouteLine localIndoorRouteLine = new IndoorRouteLine();
          Object localObject4 = paramString.optJSONObject(i);
          if (localObject4 != null)
          {
            String str = "distance";
            localIndoorRouteLine.setDistance(((JSONObject)localObject4).optInt("distance"));
            localObject1 = "duration";
            localIndoorRouteLine.setDuration(((JSONObject)localObject4).optInt("duration"));
            Object localObject2 = "sstart_location";
            localIndoorRouteLine.setStarting(RouteNode.location(a((JSONObject)localObject4, "sstart_location")));
            Object localObject3 = "send_location";
            localIndoorRouteLine.setTerminal(RouteNode.location(a((JSONObject)localObject4, "send_location")));
            localObject4 = ((JSONObject)localObject4).optJSONArray("steps");
            if (localObject4 != null)
            {
              ArrayList localArrayList2 = new ArrayList();
              int j = 0;
              while (j < ((JSONArray)localObject4).length())
              {
                IndoorRouteLine.IndoorRouteStep localIndoorRouteStep = new IndoorRouteLine.IndoorRouteStep();
                Object localObject6 = ((JSONArray)localObject4).optJSONObject(j);
                if (localObject6 == null) {}
                do
                {
                  localObject5 = localObject3;
                  localObject3 = localObject2;
                  localObject2 = localObject5;
                  break;
                  localIndoorRouteStep.setDistance(((JSONObject)localObject6).optInt(str));
                  localIndoorRouteStep.setDuration(((JSONObject)localObject6).optInt((String)localObject1));
                  localIndoorRouteStep.setBuildingId(((JSONObject)localObject6).optString("buildingid"));
                  localIndoorRouteStep.setFloorId(((JSONObject)localObject6).optString("floorid"));
                  localIndoorRouteStep.setEntrace(RouteNode.location(a((JSONObject)localObject6, (String)localObject2)));
                  localIndoorRouteStep.setExit(RouteNode.location(a((JSONObject)localObject6, (String)localObject3)));
                  localObject5 = ((JSONObject)localObject6).optJSONArray("spath");
                } while (localObject5 == null);
                Object localObject7 = new ArrayList();
                double d1 = 0.0D;
                int k = 5;
                double d2 = 0.0D;
                Object localObject8;
                while (k < ((JSONArray)localObject5).length())
                {
                  d2 += ((JSONArray)localObject5).optDouble(k + 1);
                  d1 += ((JSONArray)localObject5).optDouble(k);
                  localObject8 = new GeoPoint(0, 0);
                  int m = (int)d2;
                  ((GeoPoint)localObject8).setLatitudeE6(m);
                  ((GeoPoint)localObject8).setLongitudeE6((int)d1);
                  localObject8 = CoordUtil.mc2ll((GeoPoint)localObject8);
                  ((List)localObject7).add(Double.valueOf(((LatLng)localObject8).latitude));
                  ((List)localObject7).add(Double.valueOf(((LatLng)localObject8).longitude));
                  k += 2;
                }
                Object localObject5 = localObject2;
                localObject2 = localObject3;
                localIndoorRouteStep.setPath((List)localObject7);
                localIndoorRouteStep.setInstructions(((JSONObject)localObject6).optString("instructions"));
                localObject3 = ((JSONObject)localObject6).optJSONArray("pois");
                if (localObject3 != null)
                {
                  localObject6 = new ArrayList();
                  k = 0;
                  while (k < ((JSONArray)localObject3).length())
                  {
                    localObject7 = ((JSONArray)localObject3).optJSONObject(k);
                    if (localObject7 != null)
                    {
                      localObject8 = new IndoorRouteLine.IndoorRouteStep.IndoorStepNode();
                      ((IndoorRouteLine.IndoorRouteStep.IndoorStepNode)localObject8).setDetail(((JSONObject)localObject7).optString("detail"));
                      ((IndoorRouteLine.IndoorRouteStep.IndoorStepNode)localObject8).setName(((JSONObject)localObject7).optString("name"));
                      ((IndoorRouteLine.IndoorRouteStep.IndoorStepNode)localObject8).setType(((JSONObject)localObject7).optInt("type"));
                      ((IndoorRouteLine.IndoorRouteStep.IndoorStepNode)localObject8).setLocation(a((JSONObject)localObject7, "location"));
                      ((List)localObject6).add(localObject8);
                    }
                    k += 1;
                  }
                  localIndoorRouteStep.setStepNodes((List)localObject6);
                }
                localArrayList2.add(localIndoorRouteStep);
                localObject3 = localObject5;
                j += 1;
                localObject5 = localObject2;
                localObject2 = localObject3;
                localObject3 = localObject5;
              }
              localObject1 = paramString;
              paramString = (String)localObject1;
              if (localArrayList2.size() > 0)
              {
                localIndoorRouteLine.setSteps(localArrayList2);
                paramString = (String)localObject1;
              }
            }
            localArrayList1.add(localIndoorRouteLine);
          }
          i += 1;
        }
        paramIndoorRouteResult.setRouteLines(localArrayList1);
        return true;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public SearchResult a(String paramString)
  {
    IndoorRouteResult localIndoorRouteResult = new IndoorRouteResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localIndoorRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localIndoorRouteResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localIndoorRouteResult.error = paramString;
            return localIndoorRouteResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if (!a(paramString, localIndoorRouteResult)) {
        localIndoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return localIndoorRouteResult;
    }
    catch (Exception paramString)
    {
      label145:
      break label145;
    }
    localIndoorRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localIndoorRouteResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetRoutePlanResultListener)) {
        return;
      }
      ((OnGetRoutePlanResultListener)paramObject).onGetIndoorRouteResult((IndoorRouteResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.e
 * JD-Core Version:    0.7.0.1
 */