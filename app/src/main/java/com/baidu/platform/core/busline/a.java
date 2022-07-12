package com.baidu.platform.core.busline;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.BusLineResult.BusStation;
import com.baidu.mapapi.search.busline.BusLineResult.BusStep;
import com.baidu.mapapi.search.busline.OnGetBusLineSearchResultListener;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.base.b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
{
  public SearchResult a(String paramString)
  {
    BusLineResult localBusLineResult = new BusLineResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localBusLineResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localBusLineResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localBusLineResult.error = paramString;
            return localBusLineResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, localBusLineResult, false)) && (!a(paramString, localBusLineResult))) {
        localBusLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return localBusLineResult;
    }
    catch (Exception paramString)
    {
      label154:
      break label154;
    }
    localBusLineResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localBusLineResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetBusLineSearchResultListener)) {
        return;
      }
      ((OnGetBusLineSearchResultListener)paramObject).onGetBusLineResult((BusLineResult)paramSearchResult);
    }
  }
  
  public boolean a(String paramString, BusLineResult paramBusLineResult)
  {
    int i = 0;
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return false;
      }
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optJSONObject("result");
        localObject1 = ((JSONObject)localObject1).optJSONObject("bsl");
        if (paramString != null)
        {
          if (localObject1 == null) {
            return false;
          }
          paramString = ((JSONObject)localObject1).optJSONArray("content");
          if (paramString != null)
          {
            if (paramString.length() <= 0) {
              return false;
            }
            paramString = paramString.optJSONObject(0);
            localObject1 = new SimpleDateFormat("HH:mm");
            try
            {
              paramBusLineResult.setStartTime(((SimpleDateFormat)localObject1).parse(paramString.optString("startTime")));
              paramBusLineResult.setEndTime(((SimpleDateFormat)localObject1).parse(paramString.optString("endTime")));
            }
            catch (ParseException localParseException)
            {
              localParseException.printStackTrace();
            }
            paramBusLineResult.setBusLineName(paramString.optString("name"));
            boolean bool;
            if (paramString.optInt("isMonTicket") == 1) {
              bool = true;
            } else {
              bool = false;
            }
            paramBusLineResult.setMonthTicket(bool);
            paramBusLineResult.setUid(paramString.optString("uid"));
            paramBusLineResult.setBasePrice(paramString.optInt("ticketPrice") / 100.0F);
            paramBusLineResult.setLineDirection(paramString.optString("line_direction"));
            paramBusLineResult.setMaxPrice(paramString.optInt("maxPrice") / 100.0F);
            ArrayList localArrayList = new ArrayList();
            Object localObject2 = CoordUtil.decodeLocationList2D(paramString.optString("geo"));
            Object localObject3;
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (List)((Iterator)localObject2).next();
                BusLineResult.BusStep localBusStep = new BusLineResult.BusStep();
                localBusStep.setWayPoints((List)localObject3);
                localArrayList.add(localBusStep);
              }
            }
            if (localArrayList.size() > 0) {
              paramBusLineResult.setSteps(localArrayList);
            }
            paramString = paramString.optJSONArray("stations");
            if (paramString != null)
            {
              localArrayList = new ArrayList();
              while (i < paramString.length())
              {
                localObject2 = paramString.optJSONObject(i);
                if (localObject2 != null)
                {
                  localObject3 = new BusLineResult.BusStation();
                  ((RouteNode)localObject3).setTitle(((JSONObject)localObject2).optString("name"));
                  ((RouteNode)localObject3).setLocation(CoordUtil.decodeLocation(((JSONObject)localObject2).optString("geo")));
                  ((RouteNode)localObject3).setUid(((JSONObject)localObject2).optString("uid"));
                  localArrayList.add(localObject3);
                }
                i += 1;
              }
              if (localArrayList.size() > 0) {
                paramBusLineResult.setStations(localArrayList);
              }
            }
            paramBusLineResult.error = SearchResult.ERRORNO.NO_ERROR;
            return true;
          }
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
 * Qualified Name:     com.baidu.platform.core.busline.a
 * JD-Core Version:    0.7.0.1
 */