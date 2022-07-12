package com.baidu.platform.core.route;

import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.platform.base.b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends j
{
  private RouteNode a(JSONArray paramJSONArray, List<RouteNode> paramList)
  {
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      if (j <= 0) {
        return null;
      }
      int i = 0;
      while (i < j)
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = b((JSONObject)localObject);
          if (i == j - 1) {
            return localObject;
          }
          paramList.add(localObject);
        }
        i += 1;
      }
    }
    return null;
  }
  
  private List<DrivingRouteLine.DrivingStep> a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray1 != null)
    {
      int n = paramJSONArray1.length();
      if (n > 0)
      {
        int i;
        if (paramJSONArray2 != null)
        {
          i = paramJSONArray2.length();
          if (i > 0)
          {
            j = 1;
            break label45;
          }
        }
        else
        {
          i = 0;
        }
        int j = 0;
        label45:
        ArrayList localArrayList = new ArrayList();
        int k = 0;
        int m = k;
        while (k < n)
        {
          JSONObject localJSONObject = paramJSONArray1.optJSONObject(k);
          if (localJSONObject != null)
          {
            DrivingRouteLine.DrivingStep localDrivingStep = new DrivingRouteLine.DrivingStep();
            localDrivingStep.setDistance(localJSONObject.optInt("distance"));
            localDrivingStep.setDirection(localJSONObject.optInt("direction") * 30);
            Object localObject2 = localJSONObject.optString("instructions");
            Object localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((String)localObject2).length() >= 4) {
                localObject1 = ((String)localObject2).replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
              }
            }
            localDrivingStep.setInstructions((String)localObject1);
            localObject2 = localJSONObject.optString("start_instructions");
            if (localObject2 == null)
            {
              int i1 = localDrivingStep.getDistance();
              if (i1 < 1000)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(" - ");
                ((StringBuilder)localObject1).append(i1);
                ((StringBuilder)localObject1).append("米");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(" - ");
                ((StringBuilder)localObject1).append(i1 / 1000.0D);
                ((StringBuilder)localObject1).append("公里");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              localObject2 = localObject1;
              if (m <= localArrayList.size())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(((DrivingRouteLine.DrivingStep)localArrayList.get(m - 1)).getExitInstructions());
                ((StringBuilder)localObject2).append((String)localObject1);
                localObject2 = ((StringBuilder)localObject2).toString();
              }
            }
            localDrivingStep.setEntranceInstructions((String)localObject2);
            localDrivingStep.setExitInstructions(localJSONObject.optString("end_instructions"));
            localDrivingStep.setNumTurns(localJSONObject.optInt("turn"));
            localDrivingStep.setRoadLevel(localJSONObject.optInt("road_level"));
            localDrivingStep.setRoadName(localJSONObject.optString("road_name"));
            localObject1 = b(localJSONObject.optJSONArray("spath"));
            localDrivingStep.setPathList((List)localObject1);
            if (localObject1 != null)
            {
              localObject2 = new RouteNode();
              ((RouteNode)localObject2).setLocation((LatLng)((List)localObject1).get(0));
              localDrivingStep.setEntrance((RouteNode)localObject2);
              localObject2 = new RouteNode();
              ((RouteNode)localObject2).setLocation((LatLng)((List)localObject1).get(((List)localObject1).size() - 1));
              localDrivingStep.setExit((RouteNode)localObject2);
            }
            if ((j != 0) && (k < i)) {
              localDrivingStep.setTrafficList(c(paramJSONArray2.optJSONObject(k)));
            }
            m += 1;
            localArrayList.add(localDrivingStep);
          }
          k += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  private RouteNode b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setTitle(paramJSONObject.optString("wd"));
    localRouteNode.setUid(paramJSONObject.optString("uid"));
    GeoPoint localGeoPoint = new GeoPoint(0, 0);
    paramJSONObject = paramJSONObject.optJSONArray("spt");
    if (paramJSONObject != null)
    {
      localGeoPoint.setLongitudeE6(paramJSONObject.optInt(0));
      localGeoPoint.setLatitudeE6(paramJSONObject.optInt(1));
    }
    localRouteNode.setLocation(CoordUtil.mc2ll(localGeoPoint));
    return localRouteNode;
  }
  
  private List<LatLng> b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      if (j >= 6)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 5;
        double d1 = 0.0D;
        double d2 = 0.0D;
        while (i < j)
        {
          if (i % 2 != 0)
          {
            d2 += paramJSONArray.optInt(i);
          }
          else
          {
            d1 += paramJSONArray.optInt(i);
            localArrayList.add(CoordUtil.mc2ll(new GeoPoint(d1, d2)));
          }
          i += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  private List<DrivingRouteLine.DrivingStep> b(JSONArray paramJSONArray, List<DrivingRouteLine.DrivingStep> paramList)
  {
    if (paramJSONArray != null)
    {
      int k = paramJSONArray.length();
      if ((k > 0) && (paramList != null))
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
          if (localJSONObject != null)
          {
            int m = localJSONObject.optInt("n");
            int n = localJSONObject.optInt("s");
            int j = 0;
            while (j < m)
            {
              int i1 = n + j;
              if (i1 < paramList.size()) {
                localArrayList.add((DrivingRouteLine.DrivingStep)paramList.get(i1));
              }
              j += 1;
            }
          }
          i += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  private boolean b(String paramString, DrivingRouteResult paramDrivingRouteResult)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.optJSONObject("result");
        if (localObject1 == null) {
          return false;
        }
        int i = ((JSONObject)localObject1).optInt("error");
        if (i != 0)
        {
          if (i != 4) {
            return false;
          }
          paramDrivingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
          return true;
        }
        paramString = paramString.optJSONObject("cars");
        if (paramString == null) {
          return false;
        }
        localObject1 = paramString.optJSONObject("option");
        paramString = paramString.optJSONObject("content");
        if ((localObject1 != null) && (paramString != null))
        {
          RouteNode localRouteNode1 = b(((JSONObject)localObject1).optJSONObject("start"));
          ArrayList localArrayList1 = new ArrayList();
          RouteNode localRouteNode2 = a(((JSONObject)localObject1).optJSONArray("end"), localArrayList1);
          List localList = a(paramString.optJSONArray("steps"), paramString.optJSONArray("stepts"));
          ArrayList localArrayList2 = new ArrayList();
          localObject1 = paramString.optJSONArray("routes");
          if (localObject1 == null) {
            return false;
          }
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            DrivingRouteLine localDrivingRouteLine = new DrivingRouteLine();
            JSONObject localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
            if (localJSONObject != null)
            {
              JSONArray localJSONArray = localJSONObject.optJSONArray("legs");
              if (localJSONArray == null) {
                return false;
              }
              int j = localJSONArray.length();
              ArrayList localArrayList3 = new ArrayList();
              int n = 0;
              int k = 0;
              int m = 0;
              while (k < j)
              {
                Object localObject2 = localJSONArray.optJSONObject(k);
                if (localObject2 != null)
                {
                  int i1 = n + ((JSONObject)localObject2).optInt("distance");
                  int i2 = m + ((JSONObject)localObject2).optInt("duration");
                  localObject2 = b(((JSONObject)localObject2).optJSONArray("stepis"), localList);
                  n = i1;
                  m = i2;
                  if (localObject2 != null)
                  {
                    localArrayList3.addAll((Collection)localObject2);
                    m = i2;
                    n = i1;
                  }
                }
                k += 1;
              }
              localDrivingRouteLine.setStarting(localRouteNode1);
              localDrivingRouteLine.setTerminal(localRouteNode2);
              if (localArrayList1.size() == 0) {
                localDrivingRouteLine.setWayPoints(null);
              } else {
                localDrivingRouteLine.setWayPoints(localArrayList1);
              }
              localDrivingRouteLine.setDistance(n);
              localDrivingRouteLine.setDuration(m);
              localDrivingRouteLine.setCongestionDistance(localJSONObject.optInt("congestion_length"));
              localDrivingRouteLine.setLightNum(localJSONObject.optInt("light_num"));
              localDrivingRouteLine.setToll(localJSONObject.optInt("toll"));
              if (localArrayList3.size() == 0) {
                localDrivingRouteLine.setSteps(null);
              } else {
                localDrivingRouteLine.setSteps(localArrayList3);
              }
              localArrayList2.add(localDrivingRouteLine);
            }
            i += 1;
          }
          paramDrivingRouteResult.setRouteLines(localArrayList2);
          paramDrivingRouteResult.setTaxiInfos(c(paramString.optString("taxis")));
          return true;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  private List<TaxiInfo> c(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i);
          if (localObject != null)
          {
            TaxiInfo localTaxiInfo = new TaxiInfo();
            localObject = ((JSONObject)localObject).optString("total_price");
            if ((localObject != null) && (!((String)localObject).equals(""))) {
              localTaxiInfo.setTotalPrice(Float.parseFloat((String)localObject));
            } else {
              localTaxiInfo.setTotalPrice(0.0F);
            }
            localArrayList.add(localTaxiInfo);
          }
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException paramString)
      {
        if (Logger.debugEnable()) {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private int[] c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject = paramJSONObject.optJSONArray("end");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("status");
    if (localObject != null)
    {
      if (localJSONArray == null) {
        return null;
      }
      paramJSONObject = new ArrayList();
      int n = ((JSONArray)localObject).length();
      int i1 = localJSONArray.length();
      int m = 0;
      int i = 0;
      while (i < n)
      {
        int i2 = ((JSONArray)localObject).optInt(i);
        int j;
        if (i < i1) {
          j = localJSONArray.optInt(i);
        } else {
          j = 0;
        }
        int k = 0;
        while (k < i2)
        {
          paramJSONObject.add(Integer.valueOf(j));
          k += 1;
        }
        i += 1;
      }
      localObject = new int[paramJSONObject.size()];
      i = m;
      while (i < paramJSONObject.size())
      {
        localObject[i] = ((Integer)paramJSONObject.get(i)).intValue();
        i += 1;
      }
      return localObject;
    }
    return null;
  }
  
  public void a(String paramString, DrivingRouteResult paramDrivingRouteResult)
  {
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          paramDrivingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            paramDrivingRouteResult.error = paramString;
            return;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, paramDrivingRouteResult, false)) && (!b(paramString, paramDrivingRouteResult))) {
        paramDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return;
    }
    catch (Exception paramString)
    {
      label150:
      break label150;
    }
    paramDrivingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.c
 * JD-Core Version:    0.7.0.1
 */