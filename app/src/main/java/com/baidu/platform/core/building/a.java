package com.baidu.platform.core.building;

import android.util.Log;
import com.baidu.mapapi.search.building.BuildingResult;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
{
  private static final String b = "a";
  
  private boolean a(String paramString, BuildingResult paramBuildingResult)
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
        Log.e(b, "ParseBuidingResult error: ", paramString);
      }
    }
    paramBuildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return false;
    i = paramString.optInt("status");
    if (i == 0) {
      return a(paramString, paramBuildingResult);
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
    paramBuildingResult.error = paramString;
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, BuildingResult paramBuildingResult)
  {
    paramJSONObject = paramJSONObject.optJSONArray("buildinginfo");
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return false;
      }
      ArrayList localArrayList = new ArrayList();
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONObject.opt(i);
        if (localJSONObject != null)
        {
          BuildingInfo localBuildingInfo = new BuildingInfo();
          localBuildingInfo.setHeight((float)localJSONObject.optLong("height"));
          localBuildingInfo.setAccuracy(localJSONObject.optInt("accuracy"));
          localBuildingInfo.setGeom(localJSONObject.optString("geom"));
          localBuildingInfo.setCenter(localJSONObject.optString("center"));
          localArrayList.add(localBuildingInfo);
        }
        i += 1;
      }
      paramBuildingResult.setBuildingList(localArrayList);
      return true;
    }
    return false;
  }
  
  public SearchResult a(String paramString)
  {
    BuildingResult localBuildingResult = new BuildingResult();
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
        Log.e(b, "ParseBuidingResult: ", paramString);
      }
    }
    for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED)
    {
      localBuildingResult.error = paramString;
      return localBuildingResult;
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
      localBuildingResult.error = paramString;
      return localBuildingResult;
    }
    label153:
    if (!a(paramString, localBuildingResult, true)) {
      a(paramString, localBuildingResult);
    }
    return localBuildingResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (!(paramObject instanceof OnGetBuildingSearchResultListener)) {
      return;
    }
    ((OnGetBuildingSearchResultListener)paramObject).onGetBuildingResult((BuildingResult)paramSearchResult);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.building.a
 * JD-Core Version:    0.7.0.1
 */