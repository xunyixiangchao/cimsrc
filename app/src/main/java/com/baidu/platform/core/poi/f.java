package com.baidu.platform.core.poi;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiChildrenInfo;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.SearchType;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends b
{
  private static final String d = "f";
  private int b;
  private int c;
  
  f(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
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
  
  private boolean a(String paramString, PoiResult paramPoiResult)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (paramString.isEmpty()) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("status");
        if (i == 0) {
          return a(paramString, paramPoiResult);
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
        paramPoiResult.error = paramString;
        return false;
      }
      catch (JSONException paramString)
      {
        Log.e(d, "Parse poi search failed", paramString);
        paramPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject, PoiResult paramPoiResult)
  {
    int j = 0;
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return false;
      }
      paramPoiResult.error = SearchResult.ERRORNO.NO_ERROR;
      JSONArray localJSONArray = paramJSONObject.optJSONArray("results");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        int i = paramJSONObject.optInt("total");
        paramPoiResult.setTotalPoiNum(i);
        int k = localJSONArray.length();
        paramPoiResult.setCurrentPageCapacity(k);
        paramPoiResult.setCurrentPageNum(this.b);
        if (k != 0)
        {
          int m = this.c;
          k = i / m;
          if (i % m > 0) {
            i = 1;
          } else {
            i = 0;
          }
          paramPoiResult.setTotalPageNum(k + i);
        }
        paramJSONObject = new ArrayList();
        i = j;
        while (i < localJSONArray.length())
        {
          Object localObject = (JSONObject)localJSONArray.opt(i);
          if ((localObject != null) && (((JSONObject)localObject).length() != 0))
          {
            PoiInfo localPoiInfo = new PoiInfo();
            localPoiInfo.setName(((JSONObject)localObject).optString("name"));
            localPoiInfo.setAddress(((JSONObject)localObject).optString("address"));
            localPoiInfo.setProvince(((JSONObject)localObject).optString("province"));
            localPoiInfo.setCity(((JSONObject)localObject).optString("city"));
            localPoiInfo.setArea(((JSONObject)localObject).optString("area"));
            localPoiInfo.setStreetId(((JSONObject)localObject).optString("street_id"));
            localPoiInfo.setUid(((JSONObject)localObject).optString("uid"));
            localPoiInfo.setPhoneNum(((JSONObject)localObject).optString("telephone"));
            localPoiInfo.setDetail(((JSONObject)localObject).optInt("detail"));
            localPoiInfo.setLocation(a(((JSONObject)localObject).optJSONObject("location")));
            localObject = ((JSONObject)localObject).optString("detail_info");
            if ((localObject != null) && (((String)localObject).length() != 0)) {
              localPoiInfo.setPoiDetailInfo(b((String)localObject));
            }
            paramJSONObject.add(localPoiInfo);
          }
          i += 1;
        }
        paramPoiResult.setPoiInfo(paramJSONObject);
        return true;
      }
      paramPoiResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
    return false;
  }
  
  private PoiDetailInfo b(String paramString)
  {
    PoiDetailInfo localPoiDetailInfo = new PoiDetailInfo();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.length() == 0) {
        return null;
      }
      localPoiDetailInfo.setDistance(paramString.optInt("distance", 0));
      localPoiDetailInfo.setTag(paramString.optString("tag"));
      localPoiDetailInfo.setDetailUrl(paramString.optString("detail_url"));
      localPoiDetailInfo.setType(paramString.optString("type"));
      localPoiDetailInfo.setPrice(paramString.optDouble("price", 0.0D));
      localPoiDetailInfo.setOverallRating(paramString.optDouble("overall_rating", 0.0D));
      localPoiDetailInfo.setTasteRating(paramString.optDouble("taste_rating", 0.0D));
      localPoiDetailInfo.setServiceRating(paramString.optDouble("service_rating", 0.0D));
      localPoiDetailInfo.setEnvironmentRating(paramString.optDouble("environment_rating", 0.0D));
      localPoiDetailInfo.setFacilityRating(paramString.optDouble("facility_rating", 0.0D));
      localPoiDetailInfo.setHygieneRating(paramString.optDouble("hygiene_rating", 0.0D));
      localPoiDetailInfo.setTechnologyRating(paramString.optDouble("technology_rating", 0.0D));
      localPoiDetailInfo.setImageNum(paramString.optInt("image_num"));
      localPoiDetailInfo.setGrouponNum(paramString.optInt("groupon_num"));
      localPoiDetailInfo.setCommentNum(paramString.optInt("comment_num"));
      localPoiDetailInfo.setDiscountNum(paramString.optInt("discount_num"));
      localPoiDetailInfo.setFavoriteNum(paramString.optInt("favorite_num"));
      localPoiDetailInfo.setCheckinNum(paramString.optInt("checkin_num"));
      localPoiDetailInfo.setShopHours(paramString.optString("shop_hours"));
      localPoiDetailInfo.naviLocation = a(paramString.optJSONObject("navi_location"));
      SearchType localSearchType = a();
      if ((SearchType.b == localSearchType) || (SearchType.a == localSearchType)) {
        localPoiDetailInfo.setPoiChildrenInfoList(b(paramString));
      }
      return localPoiDetailInfo;
    }
    catch (JSONException paramString)
    {
      Log.e(d, "Parse poi search detail info failed", paramString);
    }
    return null;
  }
  
  private List<PoiChildrenInfo> b(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("children");
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.length() != 0))
        {
          PoiChildrenInfo localPoiChildrenInfo = new PoiChildrenInfo();
          localPoiChildrenInfo.setUid(localJSONObject.optString("uid"));
          localPoiChildrenInfo.setName(localJSONObject.optString("name"));
          localPoiChildrenInfo.setShowName(localJSONObject.optString("show_name"));
          localPoiChildrenInfo.setTag(localJSONObject.optString("tag"));
          localPoiChildrenInfo.setLocation(a(localJSONObject.optJSONObject("location")));
          localPoiChildrenInfo.setAddress(localJSONObject.optString("address"));
          localArrayList.add(localPoiChildrenInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public SearchResult a(String paramString)
  {
    PoiResult localPoiResult = new PoiResult();
    if ((paramString != null) && (!paramString.equals("")) && (!paramString.isEmpty())) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("SDK_InnerError"))
        {
          localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
          if (localJSONObject.has("PermissionCheckError"))
          {
            paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
            localPoiResult.error = paramString;
            return localPoiResult;
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
            localPoiResult.error = paramString;
            return localPoiResult;
          }
        }
        if (a(paramString, localPoiResult, false)) {
          return localPoiResult;
        }
        if (a(paramString, localPoiResult)) {
          paramString = SearchResult.ERRORNO.NO_ERROR;
        } else {
          paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
        localPoiResult.error = paramString;
        return localPoiResult;
      }
      catch (JSONException paramString)
      {
        Log.e(d, "Parse poi search error", paramString);
      }
      paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetPoiSearchResultListener)) {
        return;
      }
      SearchType localSearchType = a();
      int i = a.a[localSearchType.ordinal()];
      if ((i != 1) && (i != 2) && (i != 3)) {
        return;
      }
      ((OnGetPoiSearchResultListener)paramObject).onGetPoiResult((PoiResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.f
 * JD-Core Version:    0.7.0.1
 */