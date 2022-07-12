package com.baidu.platform.core.share;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import com.baidu.platform.base.b;
import org.json.JSONException;
import org.json.JSONObject;

public class c
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
      if (!a(paramString, localShareUrlResult, false)) {
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.optInt("status_sdk") != 0) {}
          for (paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;; paramString = SearchResult.ERRORNO.NO_ERROR)
          {
            localShareUrlResult.error = paramString;
            return localShareUrlResult;
            localShareUrlResult.setUrl(paramString.optString("shorturl"));
            localShareUrlResult.setType(a().ordinal());
          }
          return localShareUrlResult;
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        }
      }
    }
    catch (Exception paramString)
    {
      label207:
      break label207;
    }
    localShareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    return localShareUrlResult;
  }
  
  public void a(SearchResult paramSearchResult, Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof OnGetShareUrlResultListener)) {
        return;
      }
      ((OnGetShareUrlResultListener)paramObject).onGetRouteShareUrlResult((ShareUrlResult)paramSearchResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.c
 * JD-Core Version:    0.7.0.1
 */