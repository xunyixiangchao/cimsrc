package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapapi.search.core.TransitBaseInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import com.baidu.mapapi.search.route.MassTransitRouteLine;
import com.baidu.mapapi.search.route.MassTransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.MassTransitRouteLine.TransitStep.StepVehicleInfoType;
import com.baidu.mapapi.search.route.MassTransitRouteLine.TransitStep.TrafficCondition;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends b
{
  private TransitResultNode a(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("wd");
    String str2 = paramJSONObject.optString("city_name");
    if (paramInt == 1) {
      localObject1 = "city_code";
    } else {
      localObject1 = "city_id";
    }
    paramInt = paramJSONObject.optInt((String)localObject1);
    Object localObject1 = paramJSONObject.optJSONObject("location");
    paramJSONObject = localObject2;
    if (localObject1 != null)
    {
      localObject1 = new LatLng(((JSONObject)localObject1).optDouble("lat"), ((JSONObject)localObject1).optDouble("lng"));
      paramJSONObject = (JSONObject)localObject1;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        paramJSONObject = CoordTrans.baiduToGcj((LatLng)localObject1);
      }
    }
    return new TransitResultNode(paramInt, str2, paramJSONObject, str1);
  }
  
  private SuggestAddrInfo a(JSONObject paramJSONObject)
  {
    SuggestAddrInfo localSuggestAddrInfo = new SuggestAddrInfo();
    localSuggestAddrInfo.setSuggestStartNode(b(paramJSONObject.optJSONArray("origin_list")));
    localSuggestAddrInfo.setSuggestEndNode(b(paramJSONObject.optJSONArray("destination_list")));
    return localSuggestAddrInfo;
  }
  
  private List<PriceInfo> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      PriceInfo localPriceInfo = new PriceInfo();
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject != null)
      {
        localPriceInfo.setTicketType(localJSONObject.optInt("ticket_type"));
        localPriceInfo.setTicketPrice(localJSONObject.optDouble("ticket_price"));
      }
      localArrayList.add(localPriceInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  private TaxiInfo b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if ("null".equals(paramString)) {
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
  
  private MassTransitRouteLine.TransitStep b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MassTransitRouteLine.TransitStep localTransitStep = new MassTransitRouteLine.TransitStep();
    localTransitStep.setDistance((int)paramJSONObject.optDouble("distance"));
    localTransitStep.setDuration((int)paramJSONObject.optDouble("duration"));
    localTransitStep.setInstructions(paramJSONObject.optString("instructions"));
    localTransitStep.setPathString(paramJSONObject.optString("path"));
    localTransitStep.setTrafficConditions(c(paramJSONObject.optJSONArray("traffic_condition")));
    Object localObject = paramJSONObject.optJSONObject("start_location");
    LatLng localLatLng;
    if (localObject != null)
    {
      localLatLng = new LatLng(((JSONObject)localObject).optDouble("lat"), ((JSONObject)localObject).optDouble("lng"));
      localObject = localLatLng;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject = CoordTrans.baiduToGcj(localLatLng);
      }
      localTransitStep.setStartLocation((LatLng)localObject);
    }
    localObject = paramJSONObject.optJSONObject("end_location");
    if (localObject != null)
    {
      localLatLng = new LatLng(((JSONObject)localObject).optDouble("lat"), ((JSONObject)localObject).optDouble("lng"));
      localObject = localLatLng;
      if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
        localObject = CoordTrans.baiduToGcj(localLatLng);
      }
      localTransitStep.setEndLocation((LatLng)localObject);
    }
    paramJSONObject = paramJSONObject.optJSONObject("vehicle_info");
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("type");
      paramJSONObject = paramJSONObject.optJSONObject("detail");
      switch (i)
      {
      default: 
        return localTransitStep;
      case 6: 
        localTransitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_COACH);
        if (paramJSONObject == null) {
          return localTransitStep;
        }
        localObject = new CoachInfo();
        ((TransitBaseInfo)localObject).setName(paramJSONObject.optString("name"));
        ((CoachInfo)localObject).setPrice(paramJSONObject.optDouble("price"));
        ((CoachInfo)localObject).setBooking(paramJSONObject.optString("booking"));
        ((CoachInfo)localObject).setProviderName(paramJSONObject.optString("provider_name"));
        ((CoachInfo)localObject).setProviderUrl(paramJSONObject.optString("provider_url"));
        ((TransitBaseInfo)localObject).setDepartureStation(paramJSONObject.optString("departure_station"));
        ((TransitBaseInfo)localObject).setArriveStation(paramJSONObject.optString("arrive_station"));
        ((TransitBaseInfo)localObject).setDepartureTime(paramJSONObject.optString("departure_time"));
        ((TransitBaseInfo)localObject).setArriveTime(paramJSONObject.optString("arrive_time"));
        localTransitStep.setCoachInfo((CoachInfo)localObject);
        return localTransitStep;
      case 5: 
        paramJSONObject = MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_WALK;
        break;
      case 4: 
        paramJSONObject = MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_DRIVING;
        localTransitStep.setVehileType(paramJSONObject);
        return localTransitStep;
      case 3: 
        localTransitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_BUS);
        if (paramJSONObject == null) {
          return localTransitStep;
        }
        localObject = new BusInfo();
        ((TransitBaseInfo)localObject).setName(paramJSONObject.optString("name"));
        ((BusInfo)localObject).setType(paramJSONObject.optInt("type"));
        ((BusInfo)localObject).setStopNum(paramJSONObject.optInt("stop_num"));
        ((TransitBaseInfo)localObject).setDepartureStation(paramJSONObject.optString("on_station"));
        ((TransitBaseInfo)localObject).setArriveStation(paramJSONObject.optString("off_station"));
        ((TransitBaseInfo)localObject).setDepartureTime(paramJSONObject.optString("first_time"));
        ((TransitBaseInfo)localObject).setArriveTime(paramJSONObject.optString("last_time"));
        localTransitStep.setBusInfo((BusInfo)localObject);
        return localTransitStep;
      case 2: 
        localTransitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_PLANE);
        if (paramJSONObject == null) {
          return localTransitStep;
        }
        localObject = new PlaneInfo();
        ((TransitBaseInfo)localObject).setName(paramJSONObject.optString("name"));
        ((PlaneInfo)localObject).setPrice(paramJSONObject.optDouble("price"));
        ((PlaneInfo)localObject).setDiscount(paramJSONObject.optDouble("discount"));
        ((PlaneInfo)localObject).setAirlines(paramJSONObject.optString("airlines"));
        ((PlaneInfo)localObject).setBooking(paramJSONObject.optString("booking"));
        ((TransitBaseInfo)localObject).setDepartureStation(paramJSONObject.optString("departure_station"));
        ((TransitBaseInfo)localObject).setArriveStation(paramJSONObject.optString("arrive_station"));
        ((TransitBaseInfo)localObject).setDepartureTime(paramJSONObject.optString("departure_time"));
        ((TransitBaseInfo)localObject).setArriveTime(paramJSONObject.optString("arrive_time"));
        localTransitStep.setPlaneInfo((PlaneInfo)localObject);
        return localTransitStep;
      }
      localTransitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_TRAIN);
      if (paramJSONObject == null) {
        return localTransitStep;
      }
      localObject = new TrainInfo();
      ((TransitBaseInfo)localObject).setName(paramJSONObject.optString("name"));
      ((TrainInfo)localObject).setPrice(paramJSONObject.optDouble("price"));
      ((TrainInfo)localObject).setBooking(paramJSONObject.optString("booking"));
      ((TransitBaseInfo)localObject).setDepartureStation(paramJSONObject.optString("departure_station"));
      ((TransitBaseInfo)localObject).setArriveStation(paramJSONObject.optString("arrive_station"));
      ((TransitBaseInfo)localObject).setDepartureTime(paramJSONObject.optString("departure_time"));
      ((TransitBaseInfo)localObject).setArriveTime(paramJSONObject.optString("arrive_time"));
      localTransitStep.setTrainInfo((TrainInfo)localObject);
    }
    return localTransitStep;
  }
  
  private List<PoiInfo> b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
        if (localJSONObject != null)
        {
          PoiInfo localPoiInfo = new PoiInfo();
          localPoiInfo.address = localJSONObject.optString("address");
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
          localArrayList.add(localPoiInfo);
        }
        i += 1;
      }
      if (!localArrayList.isEmpty()) {
        return localArrayList;
      }
    }
    return null;
  }
  
  private List<MassTransitRouteLine.TransitStep.TrafficCondition> c(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() >= 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null)
        {
          MassTransitRouteLine.TransitStep.TrafficCondition localTrafficCondition = new MassTransitRouteLine.TransitStep.TrafficCondition();
          localTrafficCondition.setTrafficStatus(localJSONObject.optInt("status"));
          localTrafficCondition.setTrafficGeoCnt(localJSONObject.optInt("geo_cnt"));
          localArrayList.add(localTrafficCondition);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private List<List<MassTransitRouteLine.TransitStep>> d(JSONArray paramJSONArray)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramJSONArray != null) && (paramJSONArray.length() >= 0))
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONArray localJSONArray = paramJSONArray.optJSONArray(i);
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          ArrayList localArrayList2 = new ArrayList();
          int j = 0;
          while (j < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(j);
            if (localJSONObject != null) {
              localArrayList2.add(b(localJSONObject));
            }
            j += 1;
          }
          localArrayList1.add(localArrayList2);
        }
        i += 1;
      }
      return localArrayList1;
    }
    return null;
  }
  
  public SearchResult a(String paramString)
  {
    MassTransitRouteResult localMassTransitRouteResult = new MassTransitRouteResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localMassTransitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localMassTransitRouteResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localMassTransitRouteResult.error = paramString;
            return localMassTransitRouteResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, localMassTransitRouteResult, false)) && (!a(paramString, localMassTransitRouteResult))) {
        localMassTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return localMassTransitRouteResult;
    }
    catch (Exception paramString)
    {
      label162:
      break label162;
    }
    localMassTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localMassTransitRouteResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetRoutePlanResultListener)) {
        return;
      }
      ((OnGetRoutePlanResultListener)paramObject).onGetMassTransitRouteResult((MassTransitRouteResult)paramSearchResult);
    }
  }
  
  public boolean a(String paramString, MassTransitRouteResult paramMassTransitRouteResult)
  {
    int i = 0;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int j = paramString.optInt("status_sdk");
        if (j != 0)
        {
          if (j != 1) {
            if (j != 2)
            {
              if (j != 1002) {
                return false;
              }
              paramString = SearchResult.ERRORNO.MASS_TRANSIT_NO_POI_ERROR;
            }
          }
          for (;;)
          {
            paramMassTransitRouteResult.error = paramString;
            return true;
            paramString = SearchResult.ERRORNO.MASS_TRANSIT_OPTION_ERROR;
            continue;
            paramString = SearchResult.ERRORNO.MASS_TRANSIT_SERVER_ERROR;
          }
        }
        j = paramString.optInt("type");
        Object localObject1 = paramString.optJSONObject("result");
        if (localObject1 != null)
        {
          if (j == 1)
          {
            paramMassTransitRouteResult.setOrigin(a(j, ((JSONObject)localObject1).optJSONObject("origin_info")));
            paramMassTransitRouteResult.setDestination(a(j, ((JSONObject)localObject1).optJSONObject("destination_info")));
            paramMassTransitRouteResult.setSuggestAddrInfo(a((JSONObject)localObject1));
          }
          for (paramString = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;; paramString = SearchResult.ERRORNO.NO_ERROR)
          {
            paramMassTransitRouteResult.error = paramString;
            return true;
            if (j != 2) {
              break label509;
            }
            paramString = a(j, ((JSONObject)localObject1).optJSONObject("origin"));
            paramMassTransitRouteResult.setOrigin(paramString);
            TransitResultNode localTransitResultNode = a(j, ((JSONObject)localObject1).optJSONObject("destination"));
            paramMassTransitRouteResult.setDestination(localTransitResultNode);
            paramMassTransitRouteResult.setTotal(((JSONObject)localObject1).optInt("total"));
            paramMassTransitRouteResult.setTaxiInfo(b(((JSONObject)localObject1).optString("taxi")));
            localObject1 = ((JSONObject)localObject1).optJSONArray("routes");
            if (localObject1 == null) {
              break;
            }
            if (((JSONArray)localObject1).length() <= 0) {
              return false;
            }
            ArrayList localArrayList = new ArrayList();
            while (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
              if (localObject2 != null)
              {
                MassTransitRouteLine localMassTransitRouteLine = new MassTransitRouteLine();
                localMassTransitRouteLine.setDistance(((JSONObject)localObject2).optInt("distance"));
                localMassTransitRouteLine.setDuration(((JSONObject)localObject2).optInt("duration"));
                localMassTransitRouteLine.setArriveTime(((JSONObject)localObject2).optString("arrive_time"));
                localMassTransitRouteLine.setPrice(((JSONObject)localObject2).optDouble("price"));
                localMassTransitRouteLine.setPriceInfo(a(((JSONObject)localObject2).optJSONArray("price_detail")));
                RouteNode localRouteNode;
                if (paramString != null)
                {
                  localRouteNode = new RouteNode();
                  localRouteNode.setLocation(paramString.getLocation());
                  localMassTransitRouteLine.setStarting(localRouteNode);
                }
                if (localTransitResultNode != null)
                {
                  localRouteNode = new RouteNode();
                  localRouteNode.setLocation(localTransitResultNode.getLocation());
                  localMassTransitRouteLine.setTerminal(localRouteNode);
                }
                localObject2 = ((JSONObject)localObject2).optJSONArray("steps");
                if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
                {
                  localMassTransitRouteLine.setNewSteps(d((JSONArray)localObject2));
                  localArrayList.add(localMassTransitRouteLine);
                }
              }
              i += 1;
            }
            paramMassTransitRouteResult.setRoutelines(localArrayList);
          }
          return false;
          label509:
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
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.g
 * JD-Core Version:    0.7.0.1
 */