package com.baidu.platform.core.share;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import com.baidu.platform.base.SearchType;
import com.baidu.platform.base.b;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends b
{
  public SearchResult a(String paramString)
  {
    ShareUrlResult localShareUrlResult = new ShareUrlResult();
    if ((paramString != null) && (!paramString.equals(""))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("SDK_InnerError"))
      {
        localJSONObject = localJSONObject.optJSONObject("SDK_InnerError");
        if (localJSONObject.has("PermissionCheckError"))
        {
          localShareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
          return localShareUrlResult;
        }
        if (localJSONObject.has("httpStateError"))
        {
          paramString = localJSONObject.optString("httpStateError");
          if (paramString.equals("NETWORK_ERROR")) {
            paramString = SearchResult.ERRORNO.NETWORK_ERROR;
          }
          for (;;)
          {
            localShareUrlResult.error = paramString;
            return localShareUrlResult;
            if (paramString.equals("REQUEST_ERROR")) {
              paramString = SearchResult.ERRORNO.REQUEST_ERROR;
            } else {
              paramString = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            }
          }
        }
      }
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.optString("state").equals("success")) {}
        for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.NO_ERROR)
        {
          localShareUrlResult.error = paramString;
          return localShareUrlResult;
          localShareUrlResult.setUrl(paramString.optString("url"));
          localShareUrlResult.setType(a().ordinal());
        }
        localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return localShareUrlResult;
      }
    }
    catch (Exception paramString)
    {
      label202:
      break label202;
    }
    return localShareUrlResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetShareUrlResultListener)) {
        return;
      }
      paramObject = (OnGetShareUrlResultListener)paramObject;
      SearchType localSearchType = a();
      int i = a.a[localSearchType.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        paramObject.onGetLocationShareUrlResult((ShareUrlResult)paramSearchResult);
        return;
      }
      paramObject.onGetPoiDetailShareUrlResult((ShareUrlResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.e
 * JD-Core Version:    0.7.0.1
 */