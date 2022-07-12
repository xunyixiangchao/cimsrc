package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.baidu.platform.base.b
{
  private static final String c = "b";
  private String b;
  
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
  
  private boolean a(String paramString, GeoCodeResult paramGeoCodeResult)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramGeoCodeResult == null) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("status");
        if (i != 0)
        {
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
          paramGeoCodeResult.error = paramString;
          return false;
        }
        paramString = paramString.optJSONObject("result");
        if (paramString == null)
        {
          paramGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          return false;
        }
        paramGeoCodeResult.setLocation(a(paramString.optJSONObject("location")));
        paramGeoCodeResult.setAddress(this.b);
        paramGeoCodeResult.setPrecise(paramString.optInt("precise"));
        paramGeoCodeResult.setConfidence(paramString.optInt("confidence"));
        paramGeoCodeResult.setLevel(paramString.optString("level"));
        paramGeoCodeResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
      }
      catch (JSONException paramString)
      {
        paramGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        Log.e(c, "Parse GeoCodeResult catch JSONException", paramString);
        return true;
      }
    }
    return false;
  }
  
  public SearchResult a(String paramString)
  {
    GeoCodeResult localGeoCodeResult = new GeoCodeResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("SDK_InnerError"))
        {
          if (a(paramString, localGeoCodeResult, false)) {
            return localGeoCodeResult;
          }
          if (!a(paramString, localGeoCodeResult)) {
            localGeoCodeResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
          }
          return localGeoCodeResult;
        }
        paramString = localJSONObject.optJSONObject("SDK_InnerError");
        if (paramString.has("PermissionCheckError"))
        {
          paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          localGeoCodeResult.error = paramString;
          return localGeoCodeResult;
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
          localGeoCodeResult.error = paramString;
          return localGeoCodeResult;
        }
      }
      catch (JSONException paramString)
      {
        Log.e(c, "JSONException caught", paramString);
        continue;
      }
      paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    }
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetGeoCoderResultListener)) {
        return;
      }
      ((OnGetGeoCoderResultListener)paramObject).onGetGeoCodeResult((GeoCodeResult)paramSearchResult);
    }
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.geocode.b
 * JD-Core Version:    0.7.0.1
 */