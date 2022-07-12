package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k
  extends j
{
  private boolean a(String paramString, TransitRouteResult paramTransitRouteResult)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
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
          if (i != 1) {
            if (i != 200) {
              return false;
            }
          }
          for (paramString = SearchResult.ERRORNO.NOT_SUPPORT_BUS_2CITY;; paramString = SearchResult.ERRORNO.ST_EN_TOO_NEAR)
          {
            paramTransitRouteResult.error = paramString;
            return true;
          }
        }
        paramString = paramString.optJSONObject("bus");
        if (paramString == null) {
          return false;
        }
        localObject1 = paramString.optJSONObject("taxi");
        if (localObject1 != null) {
          paramTransitRouteResult.setTaxiInfo(b((JSONObject)localObject1));
        }
        localObject1 = paramString.optJSONObject("option");
        if (localObject1 == null) {
          return false;
        }
        RouteNode localRouteNode = c((JSONObject)localObject1, "start");
        localObject1 = c((JSONObject)localObject1, "end");
        paramString = paramString.optJSONArray("routes");
        if ((paramString != null) && (paramString.length() > 0))
        {
          ArrayList localArrayList1 = new ArrayList();
          i = 0;
          while (i < paramString.length())
          {
            Object localObject2 = (JSONObject)((JSONObject)paramString.opt(i)).optJSONArray("legs").opt(0);
            if (localObject2 != null)
            {
              TransitRouteLine localTransitRouteLine = new TransitRouteLine();
              localTransitRouteLine.setDistance(((JSONObject)localObject2).optInt("distance"));
              localTransitRouteLine.setDuration(((JSONObject)localObject2).optInt("duration"));
              localTransitRouteLine.setStarting(localRouteNode);
              localTransitRouteLine.setTerminal((RouteNode)localObject1);
              JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("steps");
              if ((localJSONArray != null) && (localJSONArray.length() > 0))
              {
                ArrayList localArrayList2 = new ArrayList();
                int j = 0;
                while (j < localJSONArray.length())
                {
                  localObject2 = localJSONArray.optJSONObject(j).optJSONArray("step");
                  if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
                  {
                    JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(0);
                    TransitRouteLine.TransitStep localTransitStep = new TransitRouteLine.TransitStep();
                    localTransitStep.setEntrace(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("start_location"))));
                    localTransitStep.setExit(RouteNode.location(CoordUtil.decodeLocation(localJSONObject.optString("end_location"))));
                    if (localJSONObject.optInt("type") == 5) {
                      localObject2 = TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING;
                    } else {
                      localObject2 = TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE;
                    }
                    localTransitStep.setStepType((TransitRouteLine.TransitStep.TransitRouteStepType)localObject2);
                    localTransitStep.setInstructions(d(localJSONObject.optString("instructions")));
                    localTransitStep.setDistance(localJSONObject.optInt("distance"));
                    localTransitStep.setDuration(localJSONObject.optInt("duration"));
                    localTransitStep.setPathString(localJSONObject.optString("path"));
                    if (localJSONObject.has("vehicle"))
                    {
                      localTransitStep.setVehicleInfo(c(localJSONObject.optString("vehicle")));
                      localObject2 = localJSONObject.optJSONObject("vehicle");
                      localTransitStep.getEntrance().setUid(((JSONObject)localObject2).optString("start_uid"));
                      localTransitStep.getEntrance().setTitle(((JSONObject)localObject2).optString("start_name"));
                      localTransitStep.getExit().setUid(((JSONObject)localObject2).optString("end_uid"));
                      localTransitStep.getExit().setTitle(((JSONObject)localObject2).optString("end_name"));
                      localObject2 = Integer.valueOf(((JSONObject)localObject2).optInt("type"));
                      if ((localObject2 != null) && (((Integer)localObject2).intValue() == 1)) {
                        localObject2 = TransitRouteLine.TransitStep.TransitRouteStepType.SUBWAY;
                      } else {
                        localObject2 = TransitRouteLine.TransitStep.TransitRouteStepType.BUSLINE;
                      }
                      localTransitStep.setStepType((TransitRouteLine.TransitStep.TransitRouteStepType)localObject2);
                    }
                    localArrayList2.add(localTransitStep);
                  }
                  j += 1;
                }
                localObject2 = localObject1;
                localTransitRouteLine.setSteps(localArrayList2);
                localArrayList1.add(localTransitRouteLine);
                localObject1 = paramString;
                paramString = (String)localObject2;
                break label686;
              }
            }
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
            label686:
            i += 1;
            localObject2 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject2;
          }
          paramTransitRouteResult.setRoutelines(localArrayList1);
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
  
  private TaxiInfo b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    TaxiInfo localTaxiInfo = new TaxiInfo();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("detail");
    if (localJSONArray != null)
    {
      if (localJSONArray.length() <= 0) {
        return null;
      }
      int j = localJSONArray.length();
      int i = 0;
      float f4;
      for (;;)
      {
        f4 = 0.0F;
        if (i >= j) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)localJSONArray.opt(i);
        if ((localJSONObject != null) && (localJSONObject.optString("desc").contains("白天")))
        {
          f1 = (float)localJSONObject.optDouble("km_price");
          f3 = (float)localJSONObject.optDouble("start_price");
          f2 = (float)localJSONObject.optDouble("total_price");
          f4 = f1;
          break label146;
        }
        i += 1;
      }
      float f1 = 0.0F;
      float f3 = f1;
      float f2 = f1;
      label146:
      localTaxiInfo.setDesc(paramJSONObject.optString("remark"));
      localTaxiInfo.setDistance(paramJSONObject.optInt("distance"));
      localTaxiInfo.setDuration(paramJSONObject.optInt("duration"));
      localTaxiInfo.setTotalPrice(f2);
      localTaxiInfo.setStartPrice(f3);
      localTaxiInfo.setPerKMPrice(f4);
      return localTaxiInfo;
    }
    return null;
  }
  
  private RouteNode c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramString != null) && (!"".equals(paramString)))
    {
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      paramString = new RouteNode();
      paramString.setTitle(paramJSONObject.optString("wd"));
      paramString.setUid(paramJSONObject.optString("uid"));
      paramString.setLocation(CoordUtil.decodeLocation(paramJSONObject.optString("pt")));
      return paramString;
    }
    return null;
  }
  
  private VehicleInfo c(String paramString)
  {
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
    VehicleInfo localVehicleInfo = new VehicleInfo();
    localVehicleInfo.setZonePrice(paramString.optInt("zone_price"));
    localVehicleInfo.setTotalPrice(paramString.optInt("total_price"));
    localVehicleInfo.setTitle(paramString.optString("name"));
    localVehicleInfo.setPassStationNum(paramString.optInt("stop_num"));
    localVehicleInfo.setUid(paramString.optString("uid"));
    return localVehicleInfo;
  }
  
  private String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    int j = 0;
    int i;
    for (int k = j; j < paramString.length; k = i)
    {
      if (paramString[j] == '<')
      {
        i = 1;
      }
      else if (paramString[j] == '>')
      {
        i = 0;
      }
      else
      {
        i = k;
        if (k == 0)
        {
          localStringBuilder.append(paramString[j]);
          i = k;
        }
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void b(String paramString, TransitRouteResult paramTransitRouteResult)
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
          paramTransitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
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
            paramTransitRouteResult.error = paramString;
            return;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, paramTransitRouteResult, false)) && (!a(paramString, paramTransitRouteResult))) {
        paramTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return;
    }
    catch (Exception paramString)
    {
      label151:
      break label151;
    }
    paramTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.k
 * JD-Core Version:    0.7.0.1
 */