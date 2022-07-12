package com.baidu.platform.core.poi;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiIndoorInfo;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.platform.base.b;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
{
  private boolean a(String paramString, PoiIndoorResult paramPoiIndoorResult)
  {
    int i = 0;
    if (paramString != null)
    {
      if ("".equals(paramString)) {
        return false;
      }
      try
      {
        paramString = new JSONObject(paramString);
        int j = paramString.optInt("errNo");
        if (j != 0) {
          if (j != 1)
          {
            if (j == 5) {
              break label101;
            }
            paramString = SearchResult.ERRORNO.POIINDOOR_SERVER_ERROR;
          }
        }
        for (;;)
        {
          paramPoiIndoorResult.error = paramString;
          return true;
          paramString = paramString.optString("Msg");
          if (paramString.contains("bid"))
          {
            paramString = SearchResult.ERRORNO.POIINDOOR_BID_ERROR;
          }
          else if (paramString.contains("floor"))
          {
            paramString = SearchResult.ERRORNO.POIINDOOR_FLOOR_ERROR;
          }
          else
          {
            label101:
            return false;
            paramString = paramString.optJSONObject("data");
            if (paramString == null) {
              return false;
            }
            JSONArray localJSONArray = paramString.optJSONArray("poi_list");
            if ((localJSONArray != null) && (localJSONArray.length() > 0))
            {
              ArrayList localArrayList = new ArrayList();
              while (i < localJSONArray.length())
              {
                JSONObject localJSONObject = (JSONObject)localJSONArray.opt(i);
                if (localJSONObject != null)
                {
                  PoiIndoorInfo localPoiIndoorInfo = new PoiIndoorInfo();
                  localPoiIndoorInfo.address = localJSONObject.optString("address");
                  localPoiIndoorInfo.bid = localJSONObject.optString("bd_id");
                  localPoiIndoorInfo.cid = localJSONObject.optInt("cid");
                  localPoiIndoorInfo.discount = localJSONObject.optInt("discount");
                  localPoiIndoorInfo.floor = localJSONObject.optString("floor");
                  localPoiIndoorInfo.name = localJSONObject.optString("name");
                  localPoiIndoorInfo.phone = localJSONObject.optString("phone");
                  localPoiIndoorInfo.price = localJSONObject.optInt("price");
                  localPoiIndoorInfo.starLevel = localJSONObject.optInt("star_level");
                  localPoiIndoorInfo.tag = localJSONObject.optString("tag");
                  localPoiIndoorInfo.uid = localJSONObject.optString("uid");
                  localPoiIndoorInfo.groupNum = localJSONObject.optInt("tuan_nums");
                  j = Integer.parseInt(localJSONObject.optString("twp"));
                  if ((j & 0x1) == 1) {
                    localPoiIndoorInfo.isGroup = true;
                  }
                  if ((j & 0x2) == 1) {
                    localPoiIndoorInfo.isTakeOut = true;
                  }
                  if ((j & 0x4) == 1) {
                    localPoiIndoorInfo.isWaited = true;
                  }
                  localPoiIndoorInfo.latLng = CoordUtil.mc2ll(new GeoPoint(localJSONObject.optDouble("pt_y"), localJSONObject.optDouble("pt_x")));
                  localArrayList.add(localPoiIndoorInfo);
                }
                i += 1;
              }
              paramPoiIndoorResult.error = SearchResult.ERRORNO.NO_ERROR;
              paramPoiIndoorResult.setmArrayPoiInfo(localArrayList);
            }
            else
            {
              paramPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
            paramPoiIndoorResult.pageNum = paramString.optInt("page_num");
            paramPoiIndoorResult.poiNum = paramString.optInt("poi_num");
            paramString = SearchResult.ERRORNO.NO_ERROR;
          }
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public SearchResult a(String paramString)
  {
    PoiIndoorResult localPoiIndoorResult = new PoiIndoorResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localPoiIndoorResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localPoiIndoorResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localPoiIndoorResult.error = paramString;
            return localPoiIndoorResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if ((!a(paramString, localPoiIndoorResult, false)) && (!a(paramString, localPoiIndoorResult))) {
        localPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      return localPoiIndoorResult;
    }
    catch (Exception paramString)
    {
      label154:
      break label154;
    }
    localPoiIndoorResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localPoiIndoorResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetPoiSearchResultListener)) {
        return;
      }
      ((OnGetPoiSearchResultListener)paramObject).onGetPoiIndoorResult((PoiIndoorResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.poi.a
 * JD-Core Version:    0.7.0.1
 */