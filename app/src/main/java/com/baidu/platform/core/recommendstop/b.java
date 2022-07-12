package com.baidu.platform.core.recommendstop;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RecommendStopInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopResult;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.baidu.platform.base.b
{
  private static final String b = "b";
  
  private LatLng a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    double d1 = paramJSONObject.optDouble("bd09ll_y");
    double d2 = paramJSONObject.optDouble("bd09ll_x");
    double d3 = paramJSONObject.optDouble("gcj02ll_y");
    double d4 = paramJSONObject.optDouble("gcj02ll_x");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02)
    {
      if (Double.compare(d3, 0.0D) == 0)
      {
        paramJSONObject = localObject;
        if (Double.compare(d4, 0.0D) == 0) {}
      }
      else
      {
        return new LatLng(d3, d4);
      }
    }
    else if (Double.compare(d1, 0.0D) == 0)
    {
      paramJSONObject = localObject;
      if (Double.compare(d2, 0.0D) == 0) {}
    }
    else
    {
      paramJSONObject = new LatLng(d1, d2);
    }
    return paramJSONObject;
  }
  
  private boolean a(String paramString, RecommendStopResult paramRecommendStopResult)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.length() != 0) {
        break label25;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label25:
        int i;
        Log.e(b, "Parse RecommendStop error", paramString);
      }
    }
    paramRecommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return false;
    i = paramString.optInt("status");
    if (i == 0) {
      return a(paramString, paramRecommendStopResult);
    }
    if (i != 1)
    {
      if (i != 2) {
        paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      } else {
        paramString = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
      }
    }
    else {
      paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
    }
    paramRecommendStopResult.error = paramString;
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, RecommendStopResult paramRecommendStopResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return false;
      }
      paramRecommendStopResult.error = SearchResult.ERRORNO.NO_ERROR;
      paramJSONObject = paramJSONObject.optJSONArray("recommendStops");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
          if ((localJSONObject != null) && (localJSONObject.length() != 0))
          {
            RecommendStopInfo localRecommendStopInfo = new RecommendStopInfo();
            localRecommendStopInfo.setName(localJSONObject.optString("name"));
            localRecommendStopInfo.setDistance((float)localJSONObject.optDouble("distance"));
            localRecommendStopInfo.setAddress(localJSONObject.optString("address"));
            localRecommendStopInfo.setId(localJSONObject.optString("id"));
            localRecommendStopInfo.setLocation(a(localJSONObject));
            localArrayList.add(localRecommendStopInfo);
          }
          i += 1;
        }
        paramRecommendStopResult.setRecommendStopInfoList(localArrayList);
        return true;
      }
      paramRecommendStopResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    return false;
  }
  
  public SearchResult a(String paramString)
  {
    RecommendStopResult localRecommendStopResult = new RecommendStopResult();
    if ((paramString != null) && (!paramString.isEmpty())) {}
    try
    {
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.length() != 0) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Log.e(b, "Parse RecommendStopResult result error", paramString);
      }
    }
    for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED)
    {
      localRecommendStopResult.error = paramString;
      return localRecommendStopResult;
      if (!localJSONObject.has("SDK_InnerError")) {
        break label153;
      }
      localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
      if ((localJSONObject == null) || (!localJSONObject.has("PermissionCheckError"))) {
        break;
      }
    }
    if ((localJSONObject != null) && (localJSONObject.has("httpStateError")))
    {
      paramString = localJSONObject.optString("httpStateError");
      paramString.hashCode();
      if (!paramString.equals("NETWORK_ERROR"))
      {
        if (!paramString.equals("REQUEST_ERROR")) {
          paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        } else {
          paramString = SearchResult.ERRORNO.REQUEST_ERROR;
        }
      }
      else {
        paramString = SearchResult.ERRORNO.NETWORK_ERROR;
      }
      localRecommendStopResult.error = paramString;
      return localRecommendStopResult;
    }
    label153:
    if (!a(paramString, localRecommendStopResult, true)) {
      a(paramString, localRecommendStopResult);
    }
    return localRecommendStopResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (!(paramObject instanceof OnGetRecommendStopResultListener)) {
      return;
    }
    ((OnGetRecommendStopResultListener)paramObject).onGetRecommendStopResult((RecommendStopResult)paramSearchResult);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.recommendstop.b
 * JD-Core Version:    0.7.0.1
 */