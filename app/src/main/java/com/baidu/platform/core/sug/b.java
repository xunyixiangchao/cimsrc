package com.baidu.platform.core.sug;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionResult.SuggestionInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.baidu.platform.base.b
{
  private static final String b = "b";
  
  private LatLng a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    double d1 = paramJSONObject.optDouble("lat");
    double d2 = paramJSONObject.optDouble("lng");
    if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
      return CoordTrans.baiduToGcj(new LatLng(d1, d2));
    }
    return new LatLng(d1, d2);
  }
  
  private List<PoiChildrenInfo> a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.length() != 0))
        {
          PoiChildrenInfo localPoiChildrenInfo = new PoiChildrenInfo();
          localPoiChildrenInfo.setUid(localJSONObject.optString("uid"));
          localPoiChildrenInfo.setName(localJSONObject.optString("name"));
          localPoiChildrenInfo.setShowName(localJSONObject.optString("show_name"));
          localPoiChildrenInfo.setTag(localJSONObject.optString("tag"));
          localPoiChildrenInfo.setAddress(localJSONObject.optString("address"));
          localArrayList.add(localPoiChildrenInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private boolean a(String paramString, SuggestionResult paramSuggestionResult)
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
        Log.e(b, "Parse sug search error", paramString);
      }
    }
    paramSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return false;
    i = paramString.optInt("status");
    if (i == 0) {
      return a(paramString, paramSuggestionResult);
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
    paramSuggestionResult.error = paramString;
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, SuggestionResult paramSuggestionResult)
  {
    int i = 0;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return false;
      }
      paramSuggestionResult.error = SearchResult.ERRORNO.NO_ERROR;
      paramJSONObject = paramJSONObject.optJSONArray("result");
      if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        while (i < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.opt(i);
          if ((localObject != null) && (((JSONObject)localObject).length() != 0))
          {
            SuggestionResult.SuggestionInfo localSuggestionInfo = new SuggestionResult.SuggestionInfo();
            localSuggestionInfo.setKey(((JSONObject)localObject).optString("name"));
            localSuggestionInfo.setCity(((JSONObject)localObject).optString("city"));
            localSuggestionInfo.setDistrict(((JSONObject)localObject).optString("district"));
            localSuggestionInfo.setUid(((JSONObject)localObject).optString("uid"));
            localSuggestionInfo.setTag(((JSONObject)localObject).optString("tag"));
            localSuggestionInfo.setAddress(((JSONObject)localObject).optString("address"));
            localSuggestionInfo.setPt(a(((JSONObject)localObject).optJSONObject("location")));
            localObject = ((JSONObject)localObject).optJSONArray("children");
            if ((localObject != null) && (((JSONArray)localObject).length() != 0)) {
              localSuggestionInfo.setPoiChildrenInfoList(a((JSONArray)localObject));
            }
            localArrayList.add(localSuggestionInfo);
          }
          i += 1;
        }
        paramSuggestionResult.setSuggestionInfo(localArrayList);
        return true;
      }
      paramSuggestionResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    return false;
  }
  
  public SearchResult a(String paramString)
  {
    SuggestionResult localSuggestionResult = new SuggestionResult();
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
        Log.e(b, "Parse suggestion search result error", paramString);
      }
    }
    for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED)
    {
      localSuggestionResult.error = paramString;
      return localSuggestionResult;
      if (!localJSONObject.has("SDK_InnerError")) {
        break label145;
      }
      localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
      if (!localJSONObject.has("PermissionCheckError")) {
        break;
      }
    }
    if (localJSONObject.has("httpStateError"))
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
      localSuggestionResult.error = paramString;
      return localSuggestionResult;
    }
    label145:
    if (!a(paramString, localSuggestionResult, false)) {
      a(paramString, localSuggestionResult);
    }
    return localSuggestionResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetSuggestionResultListener)) {
        return;
      }
      ((OnGetSuggestionResultListener)paramObject).onGetSuggestionResult((SuggestionResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.sug.b
 * JD-Core Version:    0.7.0.1
 */