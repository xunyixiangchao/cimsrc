package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PoiInfo.ParentPoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.AddressComponent;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.PoiRegionsInfo;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult.RoadInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends b
{
  private LatLng a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramString != null))
    {
      if ("".equals(paramString)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      if (paramJSONObject != null)
      {
        paramString = new LatLng(paramJSONObject.optDouble("lat"), paramJSONObject.optDouble("lng"));
        paramJSONObject = paramString;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
          paramJSONObject = CoordTrans.baiduToGcj(paramString);
        }
        return paramJSONObject;
      }
    }
    return null;
  }
  
  private PoiInfo.ParentPoiInfo a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.length() != 0))
    {
      PoiInfo.ParentPoiInfo localParentPoiInfo = new PoiInfo.ParentPoiInfo();
      localParentPoiInfo.setParentPoiAddress(paramJSONObject.optString("addr"));
      localParentPoiInfo.setParentPoiDirection(paramJSONObject.optString("direction"));
      localParentPoiInfo.setParentPoiDistance(paramJSONObject.optInt("distance"));
      localParentPoiInfo.setParentPoiName(paramJSONObject.optString("name"));
      localParentPoiInfo.setParentPoiTag(paramJSONObject.optString("tag"));
      localParentPoiInfo.setParentPoiUid(paramJSONObject.optString("uid"));
      localParentPoiInfo.setParentPoiLocation(b(paramJSONObject, "point"));
      return localParentPoiInfo;
    }
    return null;
  }
  
  private List<PoiInfo> a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (paramString1 != null))
    {
      if ("".equals(paramString1)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray(paramString1);
      if (paramJSONObject != null)
      {
        if (paramJSONObject.length() == 0) {
          return null;
        }
        paramString1 = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            PoiInfo localPoiInfo = new PoiInfo();
            localPoiInfo.setAddress(localJSONObject.optString("addr"));
            localPoiInfo.setPhoneNum(localJSONObject.optString("tel"));
            localPoiInfo.setUid(localJSONObject.optString("uid"));
            localPoiInfo.setPostCode(localJSONObject.optString("zip"));
            localPoiInfo.setName(localJSONObject.optString("name"));
            localPoiInfo.setLocation(b(localJSONObject, "point"));
            localPoiInfo.setCity(paramString2);
            localPoiInfo.setDirection(localJSONObject.optString("direction"));
            localPoiInfo.setDistance(localJSONObject.optInt("distance"));
            localPoiInfo.setTag(localJSONObject.optString("tag"));
            localPoiInfo.setParentPoi(a(localJSONObject.optJSONObject("parent_poi")));
            paramString1.add(localPoiInfo);
          }
          i += 1;
        }
        return paramString1;
      }
    }
    return null;
  }
  
  private boolean a(String paramString, ReverseGeoCodeResult paramReverseGeoCodeResult)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 0)
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("status");
        if (i != 0)
        {
          if (i != 1) {
            if (i != 2) {
              paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
          }
          for (;;)
          {
            paramReverseGeoCodeResult.error = paramString;
            return false;
            paramString = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            continue;
            paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
          }
        }
        if (!a(paramString, paramReverseGeoCodeResult))
        {
          paramReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          return false;
        }
      }
      else
      {
        paramReverseGeoCodeResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return false;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      return false;
    }
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject, ReverseGeoCodeResult paramReverseGeoCodeResult)
  {
    if (paramJSONObject == null) {
      return false;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("result");
    if (localJSONObject == null) {
      return false;
    }
    paramReverseGeoCodeResult.setCityCode(localJSONObject.optInt("cityCode"));
    paramReverseGeoCodeResult.setAddress(localJSONObject.optString("formatted_address"));
    paramReverseGeoCodeResult.setBusinessCircle(localJSONObject.optString("business"));
    ReverseGeoCodeResult.AddressComponent localAddressComponent = c(localJSONObject, "addressComponent");
    paramReverseGeoCodeResult.setAddressDetail(localAddressComponent);
    paramReverseGeoCodeResult.setLocation(a(localJSONObject, "location"));
    if (localAddressComponent != null)
    {
      paramJSONObject = localAddressComponent.city;
      paramReverseGeoCodeResult.setAdcode(localAddressComponent.adcode);
    }
    else
    {
      paramJSONObject = "";
    }
    paramReverseGeoCodeResult.setPoiList(a(localJSONObject, "pois", paramJSONObject));
    paramReverseGeoCodeResult.setSematicDescription(localJSONObject.optString("sematic_description"));
    paramReverseGeoCodeResult.setPoiRegionsInfoList(d(localJSONObject, "poiRegions"));
    paramReverseGeoCodeResult.setRoadInfoList(e(localJSONObject, "roads"));
    paramReverseGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
    return true;
  }
  
  private LatLng b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramString != null))
    {
      if ("".equals(paramString)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      if (paramJSONObject != null)
      {
        paramString = new LatLng(paramJSONObject.optDouble("y"), paramJSONObject.optDouble("x"));
        paramJSONObject = paramString;
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
          paramJSONObject = CoordTrans.baiduToGcj(paramString);
        }
        return paramJSONObject;
      }
    }
    return null;
  }
  
  private ReverseGeoCodeResult.AddressComponent c(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject(paramString);
      if (paramJSONObject != null)
      {
        paramString = new ReverseGeoCodeResult.AddressComponent();
        paramString.city = paramJSONObject.optString("city");
        paramString.setTown(paramJSONObject.optString("town"));
        paramString.district = paramJSONObject.optString("district");
        paramString.province = paramJSONObject.optString("province");
        paramString.adcode = paramJSONObject.optInt("adcode");
        paramString.street = paramJSONObject.optString("street");
        paramString.streetNumber = paramJSONObject.optString("street_number");
        paramString.countryName = paramJSONObject.optString("country");
        paramString.countryCode = paramJSONObject.optInt("country_code");
        paramString.setDirection(paramJSONObject.optString("direction"));
        paramString.setDistance(paramJSONObject.optString("distance"));
        paramString.countryCodeIso = paramJSONObject.optString("country_code_iso");
        paramString.countryCodeIso2 = paramJSONObject.optString("country_code_iso2");
        paramString.townCode = paramJSONObject.optString("town_code");
        paramString.cityLevel = paramJSONObject.optInt("cityLevel");
        return paramString;
      }
    }
    return null;
  }
  
  private List<ReverseGeoCodeResult.PoiRegionsInfo> d(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      if (paramJSONObject != null)
      {
        if (paramJSONObject.length() == 0) {
          return null;
        }
        paramString = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            ReverseGeoCodeResult.PoiRegionsInfo localPoiRegionsInfo = new ReverseGeoCodeResult.PoiRegionsInfo();
            localPoiRegionsInfo.setDirectionDesc(localJSONObject.optString("direction_desc"));
            localPoiRegionsInfo.setRegionName(localJSONObject.optString("name"));
            localPoiRegionsInfo.setRegionTag(localJSONObject.optString("tag"));
            paramString.add(localPoiRegionsInfo);
          }
          i += 1;
        }
        return paramString;
      }
    }
    return null;
  }
  
  private List<ReverseGeoCodeResult.RoadInfo> e(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      if (paramJSONObject != null)
      {
        if (paramJSONObject.length() == 0) {
          return null;
        }
        paramString = new ArrayList();
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
          if (localJSONObject != null)
          {
            ReverseGeoCodeResult.RoadInfo localRoadInfo = new ReverseGeoCodeResult.RoadInfo();
            localRoadInfo.name = localJSONObject.optString("name");
            localRoadInfo.distance = localJSONObject.optString("distance");
            paramString.add(localRoadInfo);
          }
          i += 1;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public SearchResult a(String paramString)
  {
    ReverseGeoCodeResult localReverseGeoCodeResult = new ReverseGeoCodeResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localReverseGeoCodeResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localReverseGeoCodeResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localReverseGeoCodeResult.error = paramString;
            return localReverseGeoCodeResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if (!a(paramString, localReverseGeoCodeResult, false)) {
        a(paramString, localReverseGeoCodeResult);
      }
      return localReverseGeoCodeResult;
    }
    catch (Exception paramString)
    {
      label152:
      break label152;
    }
    localReverseGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localReverseGeoCodeResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetGeoCoderResultListener)) {
        return;
      }
      ((OnGetGeoCoderResultListener)paramObject).onGetReverseGeoCodeResult((ReverseGeoCodeResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.d
 * JD-Core Version:    0.7.0.1
 */