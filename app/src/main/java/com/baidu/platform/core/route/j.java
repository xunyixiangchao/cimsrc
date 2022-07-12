package com.baidu.platform.core.route;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.platform.base.SearchType;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
  extends b
{
  SuggestAddrInfo b = null;
  protected boolean c;
  
  private SuggestAddrInfo a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("traffic_pois");
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject2 = paramJSONObject.optJSONObject("option");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("content");
    if (localObject2 != null)
    {
      if (localJSONObject == null) {
        return null;
      }
      paramJSONObject = ((JSONObject)localObject2).optJSONObject("start_city");
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.optString("cname");
      } else {
        paramJSONObject = null;
      }
      Object localObject1 = ((JSONObject)localObject2).optJSONArray("end_city");
      int j = 0;
      if (localObject1 != null)
      {
        localObject1 = (JSONObject)((JSONArray)localObject1).opt(0);
        if (localObject1 != null)
        {
          localObject1 = ((JSONObject)localObject1).optString("cname");
          break label118;
        }
      }
      localObject1 = null;
      label118:
      Object localObject3 = ((JSONObject)localObject2).optJSONArray("city_list");
      JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("prio_flag");
      if (localObject3 != null)
      {
        if (localJSONArray == null) {
          return null;
        }
        int k = ((JSONArray)localObject3).length();
        localObject2 = new boolean[k];
        boolean[] arrayOfBoolean = new boolean[k];
        int i = 0;
        while (i < k)
        {
          int m = Integer.parseInt(((JSONArray)localObject3).optString(i));
          int n = Integer.parseInt(localJSONArray.optString(i));
          int i2 = 1;
          int i1;
          if (m == 1) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          localObject2[i] = i1;
          if (n == 1) {
            i1 = i2;
          } else {
            i1 = 0;
          }
          arrayOfBoolean[i] = i1;
          i += 1;
        }
        localObject3 = new SuggestAddrInfo();
        i = j;
        while (i < k)
        {
          if (arrayOfBoolean[i] == 0) {
            if (localObject2[i] != 0)
            {
              if (i == 0) {
                ((SuggestAddrInfo)localObject3).setSuggestStartCity(a(localJSONObject.optJSONArray("start")));
              } else if ((i == k - 1) && (i > 0)) {
                ((SuggestAddrInfo)localObject3).setSuggestEndCity(a(localJSONObject.optJSONArray("end")));
              } else {
                ((SuggestAddrInfo)localObject3).setSuggestWpCity(b(localJSONObject, "multi_waypoints"));
              }
            }
            else if (i == 0) {
              ((SuggestAddrInfo)localObject3).setSuggestStartNode(a(localJSONObject.optJSONArray("start"), paramJSONObject));
            } else if ((i == k - 1) && (i > 0)) {
              ((SuggestAddrInfo)localObject3).setSuggestEndNode(a(localJSONObject.optJSONArray("end"), (String)localObject1));
            } else {
              ((SuggestAddrInfo)localObject3).setSuggestWpNode(a(localJSONObject, "multi_waypoints"));
            }
          }
          i += 1;
        }
        return localObject3;
      }
    }
    return null;
  }
  
  private List<CityInfo> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
        if (localJSONObject != null)
        {
          CityInfo localCityInfo = new CityInfo();
          localCityInfo.num = localJSONObject.optInt("num");
          localCityInfo.city = localJSONObject.optString("name");
          localArrayList.add(localCityInfo);
        }
        i += 1;
      }
      localArrayList.trimToSize();
      return localArrayList;
    }
    return null;
  }
  
  private List<PoiInfo> a(JSONArray paramJSONArray, String paramString)
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
          localPoiInfo.address = localJSONObject.optString("addr");
          localPoiInfo.uid = localJSONObject.optString("uid");
          localPoiInfo.name = localJSONObject.optString("name");
          localPoiInfo.location = CoordUtil.decodeLocation(localJSONObject.optString("geo"));
          localPoiInfo.city = paramString;
          localArrayList.add(localPoiInfo);
        }
        i += 1;
      }
      if (localArrayList.size() > 0) {
        return localArrayList;
      }
    }
    return null;
  }
  
  private List<List<PoiInfo>> a(JSONObject paramJSONObject, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString = a(((JSONObject)paramJSONObject.opt(i)).optJSONArray("way_ponits"), "");
      if (paramString != null) {
        localArrayList.add(paramString);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private List<List<CityInfo>> b(JSONObject paramJSONObject, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject == null) {
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    int i = 0;
    while (i < paramJSONObject.length())
    {
      paramString = a((JSONArray)paramJSONObject.opt(i));
      if (paramString != null) {
        localArrayList.add(paramString);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private boolean b(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = paramString.optJSONObject("result");
        if ((localJSONObject != null) && (localJSONObject.optInt("type") == 23))
        {
          if (localJSONObject.optInt("error") != 0) {
            return false;
          }
          paramString = a(paramString);
          this.b = paramString;
          return paramString != null;
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
  
  public SearchResult a(String paramString)
  {
    Object localObject = a();
    if (b(paramString)) {
      this.c = true;
    } else {
      this.c = false;
    }
    int i = a.a[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        localObject = new WalkingRouteResult();
        if (!this.c)
        {
          ((m)this).b(paramString, (WalkingRouteResult)localObject);
          return (String)localObject;
        }
        ((WalkingRouteResult)localObject).setSuggestAddrInfo(this.b);
        paramString = (String)localObject;
      }
      else
      {
        localObject = new DrivingRouteResult();
        if (!this.c)
        {
          ((c)this).a(paramString, (DrivingRouteResult)localObject);
          return (String)localObject;
        }
        ((DrivingRouteResult)localObject).setSuggestAddrInfo(this.b);
        paramString = (String)localObject;
      }
    }
    else
    {
      localObject = new TransitRouteResult();
      if (!this.c)
      {
        ((k)this).b(paramString, (TransitRouteResult)localObject);
        return (String)localObject;
      }
      ((TransitRouteResult)localObject).setSuggestAddrInfo(this.b);
      paramString = (String)localObject;
    }
    paramString.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
    return paramString;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetRoutePlanResultListener)) {
        return;
      }
      paramObject = (OnGetRoutePlanResultListener)paramObject;
      SearchType localSearchType = a();
      int i = a.a[localSearchType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramObject.onGetWalkingRouteResult((WalkingRouteResult)paramSearchResult);
          return;
        }
        paramObject.onGetDrivingRouteResult((DrivingRouteResult)paramSearchResult);
        return;
      }
      paramObject.onGetTransitRouteResult((TransitRouteResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.route.j
 * JD-Core Version:    0.7.0.1
 */