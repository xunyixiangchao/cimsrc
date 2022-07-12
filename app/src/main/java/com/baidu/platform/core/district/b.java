package com.baidu.platform.core.district;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.baidu.platform.base.b
{
  boolean b = false;
  String c = null;
  
  private boolean a(String paramString, DistrictResult paramDistrictResult)
  {
    if ((paramString != null) && (!"".equals(paramString)) && (paramDistrictResult != null)) {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optJSONObject("result");
        localObject1 = ((JSONObject)localObject1).optJSONObject("city_result");
        if ((paramString != null) && (localObject1 != null))
        {
          if (paramString.optInt("error") != 0) {
            return false;
          }
          paramString = ((JSONObject)localObject1).optJSONObject("content");
          if (paramString == null) {
            return false;
          }
          localObject1 = paramString.optJSONObject("sgeo");
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).optJSONArray("geo_elements");
            if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
            {
              ArrayList localArrayList1 = new ArrayList();
              int j = 0;
              while (j < ((JSONArray)localObject1).length())
              {
                Object localObject2 = ((JSONArray)localObject1).optJSONObject(j);
                if (localObject2 != null)
                {
                  localObject2 = ((JSONObject)localObject2).optJSONArray("point");
                  if (localObject2 != null)
                  {
                    int i1 = ((JSONArray)localObject2).length();
                    if (i1 > 0)
                    {
                      ArrayList localArrayList2 = new ArrayList();
                      int n = 0;
                      int i = n;
                      int m = i;
                      int k = i;
                      i = n;
                      while (i < i1)
                      {
                        n = ((JSONArray)localObject2).optInt(i);
                        if (i % 2 == 0)
                        {
                          m += n;
                        }
                        else
                        {
                          k += n;
                          localArrayList2.add(CoordUtil.mc2ll(new GeoPoint(k, m)));
                        }
                        i += 1;
                      }
                      localArrayList1.add(localArrayList2);
                    }
                  }
                }
                j += 1;
              }
              if (localArrayList1.size() > 0)
              {
                paramDistrictResult.setPolylines(localArrayList1);
                paramDistrictResult.setCenterPt(CoordUtil.decodeLocation(paramString.optString("geo")));
                paramDistrictResult.setCityCode(paramString.optInt("code"));
                paramDistrictResult.setCityName(paramString.optString("cname"));
                paramDistrictResult.error = SearchResult.ERRORNO.NO_ERROR;
                return true;
              }
            }
          }
          paramDistrictResult.setCityName(paramString.optString("uid"));
          this.c = paramString.optString("cname");
          paramDistrictResult.setCenterPt(CoordUtil.decodeLocation(paramString.optString("geo")));
          paramDistrictResult.setCityCode(paramString.optInt("code"));
          return false;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  private boolean b(String paramString, DistrictResult paramDistrictResult)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (paramDistrictResult == null) {
        return false;
      }
      try
      {
        Object localObject1 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject1).optJSONObject("result");
        Object localObject2 = ((JSONObject)localObject1).optJSONObject("content");
        if (paramString != null)
        {
          if (localObject2 == null) {
            return false;
          }
          if (paramString.optInt("error") != 0) {
            return false;
          }
          localObject1 = new ArrayList();
          if (this.c != null) {
            try
            {
              paramString = CoordUtil.decodeLocationList2D(((JSONObject)localObject2).optString("geo"));
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
          } else {
            paramString = null;
          }
          if (paramString != null)
          {
            paramString = paramString.iterator();
            while (paramString.hasNext())
            {
              Object localObject3 = (List)paramString.next();
              localObject2 = new ArrayList();
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((List)localObject2).add((LatLng)((Iterator)localObject3).next());
              }
              ((List)localObject1).add(localObject2);
            }
          }
          if (((List)localObject1).size() > 0) {
            paramDistrictResult.setPolylines((List)localObject1);
          }
          paramDistrictResult.setCityName(this.c);
          paramDistrictResult.error = SearchResult.ERRORNO.NO_ERROR;
          this.c = null;
          return true;
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
    DistrictResult localDistrictResult = new DistrictResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localDistrictResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localDistrictResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localDistrictResult.error = paramString;
            return localDistrictResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      if (!a(paramString, localDistrictResult, false)) {
        if (!this.b)
        {
          if (!a(paramString, localDistrictResult))
          {
            localDistrictResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return localDistrictResult;
          }
        }
        else {
          b(paramString, localDistrictResult);
        }
      }
      return localDistrictResult;
    }
    catch (Exception paramString)
    {
      label170:
      break label170;
    }
    localDistrictResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localDistrictResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetDistricSearchResultListener)) {
        return;
      }
      ((OnGetDistricSearchResultListener)paramObject).onGetDistrictResult((DistrictResult)paramSearchResult);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.district.b
 * JD-Core Version:    0.7.0.1
 */