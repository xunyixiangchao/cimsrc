package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import java.util.List<Lcom.baidu.mapapi.search.core.RouteNode;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
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
        RouteNode localRouteNode = b(paramJSONArray.optJSONObject(i));
        if (i == j - 1) {
          return localRouteNode;
        }
        Object localObject = paramList;
        if (paramList == null) {
          localObject = new ArrayList();
        }
        ((List)localObject).add(localRouteNode);
        i += 1;
        paramList = (List<RouteNode>)localObject;
      }
    }
    return null;
  }
  
  private boolean a(String paramString, WalkingRouteResult paramWalkingRouteResult)
  {
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        if (paramWalkingRouteResult == null) {
          return false;
        }
        if (paramString.has("taxi")) {
          paramWalkingRouteResult.setTaxiInfo(c(paramString.optString("taxi")));
        }
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
          paramWalkingRouteResult.error = SearchResult.ERRORNO.ST_EN_TOO_NEAR;
          return true;
        }
        localObject1 = paramString.optJSONObject("walk");
        if (localObject1 == null) {
          return false;
        }
        paramString = ((JSONObject)localObject1).optJSONArray("routes");
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("option");
        if (localObject2 != null)
        {
          if (paramString == null) {
            return false;
          }
          localObject1 = b(((JSONObject)localObject2).optJSONObject("start"));
          localObject2 = a(((JSONObject)localObject2).optJSONArray("end"), null);
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < paramString.length())
          {
            Object localObject3 = paramString.optJSONObject(i);
            if (localObject3 != null)
            {
              localObject3 = ((JSONObject)localObject3).optJSONArray("legs");
              if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
              {
                int j = 0;
                while (j < ((JSONArray)localObject3).length())
                {
                  JSONObject localJSONObject = ((JSONArray)localObject3).optJSONObject(i);
                  if (localJSONObject != null)
                  {
                    WalkingRouteLine localWalkingRouteLine = new WalkingRouteLine();
                    localWalkingRouteLine.setStarting((RouteNode)localObject1);
                    localWalkingRouteLine.setTerminal((RouteNode)localObject2);
                    localWalkingRouteLine.setDistance(localJSONObject.optInt("distance"));
                    localWalkingRouteLine.setDuration(localJSONObject.optInt("duration"));
                    localWalkingRouteLine.setSteps(b(localJSONObject.optJSONArray("steps")));
                    localArrayList.add(localWalkingRouteLine);
                  }
                  j += 1;
                }
              }
            }
            i += 1;
          }
          paramWalkingRouteResult.setRouteLines(localArrayList);
          return true;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  private RouteNode b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    RouteNode localRouteNode = new RouteNode();
    localRouteNode.setTitle(paramJSONObject.optString("wd"));
    localRouteNode.setUid(paramJSONObject.optString("uid"));
    localRouteNode.setLocation(CoordUtil.decodeLocation(paramJSONObject.optString("pt")));
    return localRouteNode;
  }
  
  private List<WalkingRouteLine.WalkingStep> b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      if (j > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
          if (localJSONObject != null)
          {
            WalkingRouteLine.WalkingStep localWalkingStep = new WalkingRouteLine.WalkingStep();
            localWalkingStep.setDirection(localJSONObject.optInt("direction") * 30);
            localWalkingStep.setDistance(localJSONObject.optInt("distance"));
            localWalkingStep.setDuration(localJSONObject.optInt("duration"));
            localWalkingStep.setEntrance(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("start_location"))));
            localWalkingStep.setExit(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("end_location"))));
            String str2 = localJSONObject.optString("instructions");
            String str1 = str2;
            if (str2 != null)
            {
              str1 = str2;
              if (str2.length() >= 4) {
                str1 = str2.replaceAll("</?[a-z]>", "");
              }
            }
            localWalkingStep.setInstructions(str1);
            localWalkingStep.setEntranceInstructions(localJSONObject.optString("start_instructions"));
            localWalkingStep.setExitInstructions(localJSONObject.optString("end_instructions"));
            localWalkingStep.setPathString(localJSONObject.optString("path"));
            localArrayList.add(localWalkingStep);
          }
          i += 1;
        }
        return localArrayList;
      }
    }
    return null;
  }
  
  private TaxiInfo c(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      if (paramString == null) {
        return null;
      }
      TaxiInfo localTaxiInfo = new TaxiInfo();
      localTaxiInfo.setDesc(paramString.optString("remark"));
      localTaxiInfo.setDistance(paramString.optInt("distance"));
      localTaxiInfo.setDuration(paramString.optInt("duration"));
      localTaxiInfo.setTotalPrice((float)paramString.optDouble("total_price"));
      localTaxiInfo.setStartPrice((float)paramString.optDouble("start_price"));
      localTaxiInfo.setPerKMPrice((float)paramString.optDouble("km_price"));
      return localTaxiInfo;
    }
    return null;
  }
  
  public void b(String paramString, WalkingRouteResult paramWalkingRouteResult)
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
          paramWalkingRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
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
            paramWalkingRouteResult.error = paramString;
            return;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, paramWalkingRouteResult, false)) && (!a(paramString, paramWalkingRouteResult))) {
        paramWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return;
    }
    catch (Exception paramString)
    {
      label150:
      break label150;
    }
    paramWalkingRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.m
 * JD-Core Version:    0.7.0.1
 */