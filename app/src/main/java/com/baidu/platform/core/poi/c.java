package com.baidu.platform.core.poi;

import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends b
{
  private static final String c = "c";
  private boolean b = false;
  
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
  
  private boolean a(String paramString, SearchResult paramSearchResult)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.length() == 0) {
        return false;
      }
      if (paramString.optInt("status") != 0) {
        return false;
      }
      paramString = paramString.optJSONArray("result");
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return false;
        }
        if (this.b) {
          return a(paramString, (PoiDetailSearchResult)paramSearchResult);
        }
        return a(paramString, (PoiDetailResult)paramSearchResult);
      }
      return false;
    }
    catch (JSONException paramString)
    {
      Log.e(c, "Parse detail search result error", paramString);
    }
    return false;
  }
  
  private boolean a(JSONArray paramJSONArray, PoiDetailResult paramPoiDetailResult)
  {
    paramJSONArray = (JSONObject)paramJSONArray.opt(0);
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return false;
      }
      paramPoiDetailResult.setName(paramJSONArray.optString("name"));
      paramPoiDetailResult.setLocation(a(paramJSONArray.optJSONObject("location")));
      paramPoiDetailResult.setAddress(paramJSONArray.optString("address"));
      paramPoiDetailResult.setTelephone(paramJSONArray.optString("telephone"));
      paramPoiDetailResult.setUid(paramJSONArray.optString("uid"));
      paramJSONArray = paramJSONArray.optJSONObject("detail_info");
      if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
      {
        paramPoiDetailResult.setTag(paramJSONArray.optString("tag"));
        paramPoiDetailResult.setDetailUrl(paramJSONArray.optString("detail_url"));
        paramPoiDetailResult.setType(paramJSONArray.optString("type"));
        paramPoiDetailResult.setPrice(paramJSONArray.optDouble("price", 0.0D));
        paramPoiDetailResult.setOverallRating(paramJSONArray.optDouble("overall_rating", 0.0D));
        paramPoiDetailResult.setTasteRating(paramJSONArray.optDouble("taste_rating", 0.0D));
        paramPoiDetailResult.setServiceRating(paramJSONArray.optDouble("service_rating", 0.0D));
        paramPoiDetailResult.setEnvironmentRating(paramJSONArray.optDouble("environment_rating", 0.0D));
        paramPoiDetailResult.setFacilityRating(paramJSONArray.optDouble("facility_rating", 0.0D));
        paramPoiDetailResult.setHygieneRating(paramJSONArray.optDouble("hygiene_rating", 0.0D));
        paramPoiDetailResult.setTechnologyRating(paramJSONArray.optDouble("technology_rating", 0.0D));
        paramPoiDetailResult.setImageNum(paramJSONArray.optInt("image_num"));
        paramPoiDetailResult.setGrouponNum(paramJSONArray.optInt("groupon_num", 0));
        paramPoiDetailResult.setCommentNum(paramJSONArray.optInt("comment_num", 0));
        paramPoiDetailResult.setDiscountNum(paramJSONArray.optInt("discount_num", 0));
        paramPoiDetailResult.setFavoriteNum(paramJSONArray.optInt("favorite_num", 0));
        paramPoiDetailResult.setCheckinNum(paramJSONArray.optInt("checkin_num", 0));
        paramPoiDetailResult.setShopHours(paramJSONArray.optString("shop_hours"));
      }
      paramPoiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
      return true;
    }
    return false;
  }
  
  private boolean a(JSONArray paramJSONArray, PoiDetailSearchResult paramPoiDetailSearchResult)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = (JSONObject)paramJSONArray.opt(i);
      if ((localJSONObject != null) && (localJSONObject.length() != 0))
      {
        PoiDetailInfo localPoiDetailInfo = new PoiDetailInfo();
        localPoiDetailInfo.setName(localJSONObject.optString("name"));
        localPoiDetailInfo.setLocation(a(localJSONObject.optJSONObject("location")));
        localPoiDetailInfo.setAddress(localJSONObject.optString("address"));
        localPoiDetailInfo.setProvince(localJSONObject.optString("province"));
        localPoiDetailInfo.setCity(localJSONObject.optString("city"));
        localPoiDetailInfo.setArea(localJSONObject.optString("area"));
        localPoiDetailInfo.setTelephone(localJSONObject.optString("telephone"));
        localPoiDetailInfo.setUid(localJSONObject.optString("uid"));
        localPoiDetailInfo.setStreetId(localJSONObject.optString("setStreetId"));
        localPoiDetailInfo.setDetail(localJSONObject.optString("detail"));
        localJSONObject = localJSONObject.optJSONObject("detail_info");
        if ((localJSONObject != null) && (localJSONObject.length() != 0))
        {
          localPoiDetailInfo.setDistance(localJSONObject.optInt("distance", 0));
          localPoiDetailInfo.setType(localJSONObject.optString("type"));
          localPoiDetailInfo.setTag(localJSONObject.optString("tag"));
          localPoiDetailInfo.setDetailUrl(localJSONObject.optString("detail_url"));
          localPoiDetailInfo.setPrice(localJSONObject.optDouble("price", 0.0D));
          localPoiDetailInfo.setShopHours(localJSONObject.optString("shop_hours"));
          localPoiDetailInfo.setOverallRating(localJSONObject.optDouble("overall_rating", 0.0D));
          localPoiDetailInfo.setTasteRating(localJSONObject.optDouble("taste_rating", 0.0D));
          localPoiDetailInfo.setServiceRating(localJSONObject.optDouble("service_rating", 0.0D));
          localPoiDetailInfo.setEnvironmentRating(localJSONObject.optDouble("environment_rating", 0.0D));
          localPoiDetailInfo.setFacilityRating(localJSONObject.optDouble("facility_rating", 0.0D));
          localPoiDetailInfo.setHygieneRating(localJSONObject.optDouble("hygiene_rating", 0.0D));
          localPoiDetailInfo.setTechnologyRating(localJSONObject.optDouble("technology_rating", 0.0D));
          localPoiDetailInfo.setImageNum(localJSONObject.optInt("image_num"));
          localPoiDetailInfo.setGrouponNum(localJSONObject.optInt("groupon_num", 0));
          localPoiDetailInfo.setCommentNum(localJSONObject.optInt("comment_num", 0));
          localPoiDetailInfo.setDiscountNum(localJSONObject.optInt("discount_num", 0));
          localPoiDetailInfo.setFavoriteNum(localJSONObject.optInt("favorite_num", 0));
          localPoiDetailInfo.setCheckinNum(localJSONObject.optInt("checkin_num", 0));
        }
        localArrayList.add(localPoiDetailInfo);
      }
      i += 1;
    }
    paramPoiDetailSearchResult.setPoiDetailInfoList(localArrayList);
    paramPoiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
    return true;
  }
  
  public SearchResult a(String paramString)
  {
    Object localObject;
    if (this.b) {
      localObject = new PoiDetailSearchResult();
    } else {
      localObject = new PoiDetailResult();
    }
    if ((paramString != null) && (!paramString.isEmpty())) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.length() == 0)
        {
          ((SearchResult)localObject).error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          return localObject;
        }
        if (!localJSONObject.has("SDK_InnerError"))
        {
          if (!a(paramString, (SearchResult)localObject)) {
            ((SearchResult)localObject).error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          }
          return localObject;
        }
        paramString = localJSONObject.optJSONObject("SDK_InnerError");
        if ((paramString != null) && (paramString.length() != 0))
        {
          if (paramString.has("PermissionCheckError"))
          {
            paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
            ((SearchResult)localObject).error = paramString;
            return localObject;
          }
          if (paramString.has("httpStateError"))
          {
            paramString = paramString.optString("httpStateError");
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
            ((SearchResult)localObject).error = paramString;
          }
          return localObject;
        }
      }
      catch (JSONException paramString)
      {
        Log.e(c, "Parse detail search result failed", paramString);
        continue;
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
      boolean bool = this.b;
      paramObject = (OnGetPoiSearchResultListener)paramObject;
      if (bool)
      {
        paramObject.onGetPoiDetailResult((PoiDetailSearchResult)paramSearchResult);
        return;
      }
      paramObject.onGetPoiDetailResult((PoiDetailResult)paramSearchResult);
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.c
 * JD-Core Version:    0.7.0.1
 */