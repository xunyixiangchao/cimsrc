package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.BikingRouteLine.BikingStep;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
{
  private LatLng a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    LatLng localLatLng = new LatLng(paramJSONObject.optDouble("lat"), paramJSONObject.optDouble("lng"));
    paramJSONObject = localLatLng;
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      paramJSONObject = CoordTrans.baiduToGcj(localLatLng);
    }
    return paramJSONObject;
  }
  
  private List<BikingRouteLine.BikingStep> a(JSONArray paramJSONArray)
  {
    int j = 1;
    int k = 0;
    if (paramJSONArray == null) {
      i = 1;
    } else {
      i = 0;
    }
    int m = paramJSONArray.length();
    if (m > 0) {
      j = 0;
    }
    if ((j | i) != 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = k;
    while (i < m)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        BikingRouteLine.BikingStep localBikingStep = new BikingRouteLine.BikingStep();
        localBikingStep.setDirection(localJSONObject.optInt("direction") * 30);
        localBikingStep.setDistance(localJSONObject.optInt("distance"));
        localBikingStep.setDuration(localJSONObject.optInt("duration"));
        localBikingStep.setName(localJSONObject.optString("name"));
        localBikingStep.setTurnType(localJSONObject.optString("turn_type"));
        localBikingStep.setEntrance(RouteNode.location(a(localJSONObject.optJSONObject("stepOriginLocation"))));
        localBikingStep.setExit(RouteNode.location(a(localJSONObject.optJSONObject("stepDestinationLocation"))));
        String str2 = localJSONObject.optString("instructions");
        String str1 = str2;
        if (str2 != null)
        {
          str1 = str2;
          if (str2.length() >= 4) {
            str1 = str2.replaceAll("</?[a-z]>", "");
          }
        }
        localBikingStep.setInstructions(str1);
        localBikingStep.setEntranceInstructions(localJSONObject.optString("stepOriginInstruction"));
        localBikingStep.setExitInstructions(localJSONObject.optString("stepDestinationInstruction"));
        localBikingStep.setPathString(localJSONObject.optString("path"));
        localArrayList.add(localBikingStep);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private List<PoiInfo> a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (paramString1 != null))
    {
      if ("".equals(paramString1)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray(paramString1);
      if (paramJSONObject != null)
      {
        paramString1 = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
          if (localJSONObject != null)
          {
            PoiInfo localPoiInfo = new PoiInfo();
            if (localJSONObject.has("address")) {
              localPoiInfo.address = localJSONObject.optString("address");
            }
            localPoiInfo.uid = localJSONObject.optString("uid");
            localPoiInfo.name = localJSONObject.optString("name");
            localJSONObject = localJSONObject.optJSONObject("location");
            if (localJSONObject != null)
            {
              localPoiInfo.location = new LatLng(localJSONObject.optDouble("lat"), localJSONObject.optDouble("lng"));
              if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                localPoiInfo.location = CoordTrans.baiduToGcj(localPoiInfo.location);
              }
            }
            localPoiInfo.city = paramString2;
            paramString1.add(localPoiInfo);
          }
          i += 1;
        }
        if (paramString1.size() > 0) {
          return paramString1;
        }
      }
    }
    return null;
  }
  
  private boolean a(String paramString, BikingRouteResult paramBikingRouteResult)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          i = paramString.optInt("status_sdk");
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2) {
                return false;
              }
              paramBikingRouteResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
              return false;
            }
            paramBikingRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            return true;
          }
          localObject = paramString.optJSONObject("result");
          if (localObject == null) {
            return false;
          }
          i = paramString.optInt("type");
          if (i == 1)
          {
            paramBikingRouteResult.setSuggestAddrInfo(b((JSONObject)localObject));
            paramBikingRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
            return true;
          }
          if (i == 2)
          {
            paramString = ((JSONObject)localObject).optJSONArray("routes");
            if (paramString != null)
            {
              if (paramString.length() <= 0) {
                return false;
              }
              localRouteNode = b((JSONObject)localObject, "origin", "originPt");
              localObject = b((JSONObject)localObject, "destination", "destinationPt");
              localArrayList = new ArrayList();
              i = 0;
              if (i < paramString.length()) {
                localBikingRouteLine = new BikingRouteLine();
              }
            }
          }
        }
        catch (JSONException paramString)
        {
          int i;
          Object localObject;
          RouteNode localRouteNode;
          ArrayList localArrayList;
          BikingRouteLine localBikingRouteLine;
          JSONObject localJSONObject;
          paramString.printStackTrace();
        }
        try
        {
          localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject == null) {
            return false;
          }
          localBikingRouteLine.setStarting(localRouteNode);
          localBikingRouteLine.setTerminal((RouteNode)localObject);
          localBikingRouteLine.setDistance(localJSONObject.optInt("distance"));
          localBikingRouteLine.setDuration(localJSONObject.optInt("duration"));
          localBikingRouteLine.setSteps(a(localJSONObject.optJSONArray("steps")));
          localArrayList.add(localBikingRouteLine);
        }
        catch (Exception localException)
        {
          continue;
        }
        i += 1;
        continue;
        paramBikingRouteResult.setRouteLines(localArrayList);
        return true;
        return false;
      }
    }
    return false;
  }
  
  private RouteNode b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (paramString1 != null))
    {
      if ("".equals(paramString1)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject(paramString1);
      if (paramJSONObject == null) {
        return null;
      }
      RouteNode localRouteNode = new RouteNode();
      localRouteNode.setTitle(paramJSONObject.optString("wd"));
      localRouteNode.setUid(paramJSONObject.optString("uid"));
      paramJSONObject = paramJSONObject.optJSONObject(paramString2);
      if (paramJSONObject != null)
      {
        paramString1 = new LatLng(paramJSONObject.optDouble("lat"), paramJSONObject.optDouble("lng"));
        paramJSONObject = paramString1;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
          paramJSONObject = CoordTrans.baiduToGcj(paramString1);
        }
        localRouteNode.setLocation(paramJSONObject);
      }
      return localRouteNode;
    }
    return null;
  }
  
  private SuggestAddrInfo b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    SuggestAddrInfo localSuggestAddrInfo = new SuggestAddrInfo();
    Object localObject = paramJSONObject.optJSONObject("origin");
    paramJSONObject = paramJSONObject.optJSONObject("destination");
    int i;
    if (localObject != null)
    {
      i = ((JSONObject)localObject).optInt("listType");
      String str = ((JSONObject)localObject).optString("cityName");
      if (i == 1) {
        localSuggestAddrInfo.setSuggestStartCity(a((JSONObject)localObject, "content"));
      } else if (i == 0) {
        localSuggestAddrInfo.setSuggestStartNode(a((JSONObject)localObject, "content", str));
      }
    }
    if (paramJSONObject != null)
    {
      i = paramJSONObject.optInt("listType");
      localObject = paramJSONObject.optString("cityName");
      if (i == 1)
      {
        localSuggestAddrInfo.setSuggestEndCity(a(paramJSONObject, "content"));
        return localSuggestAddrInfo;
      }
      if (i == 0) {
        localSuggestAddrInfo.setSuggestEndNode(a(paramJSONObject, "content", (String)localObject));
      }
    }
    return localSuggestAddrInfo;
  }
  
  public SearchResult a(String paramString)
  {
    BikingRouteResult localBikingRouteResult = new BikingRouteResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localBikingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localBikingRouteResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localBikingRouteResult.error = paramString;
            return localBikingRouteResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, localBikingRouteResult, false)) && (!a(paramString, localBikingRouteResult))) {
        localBikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return localBikingRouteResult;
    }
    catch (Exception paramString)
    {
      label161:
      break label161;
    }
    localBikingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localBikingRouteResult;
  }
  
  public List<CityInfo> a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramString != null))
    {
      if (paramString.equals("")) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        paramString = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
          if (localJSONObject != null)
          {
            CityInfo localCityInfo = new CityInfo();
            localCityInfo.num = localJSONObject.optInt("number");
            localCityInfo.city = localJSONObject.optString("name");
            paramString.add(localCityInfo);
          }
          i += 1;
        }
        paramString.trimToSize();
        return paramString;
      }
    }
    return null;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetRoutePlanResultListener)) {
        return;
      }
      ((OnGetRoutePlanResultListener)paramObject).onGetBikingRouteResult((BikingRouteResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.a
 * JD-Core Version:    0.7.0.1
 */