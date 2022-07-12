package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b
{
  protected SearchType a;
  
  public abstract SearchResult a(String paramString);
  
  public SearchType a()
  {
    return this.a;
  }
  
  public abstract void a(SearchResult paramSearchResult, Object paramObject);
  
  public void a(SearchType paramSearchType)
  {
    this.a = paramSearchType;
  }
  
  protected boolean a(String paramString, SearchResult paramSearchResult, boolean paramBoolean)
  {
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramString.length() > 0)
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          if (paramBoolean)
          {
            paramString = "status";
            i = localJSONObject.optInt(paramString);
            break label124;
            paramString = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            continue;
            paramString = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
            paramSearchResult.error = paramString;
            return true;
            paramString = SearchResult.ERRORNO.NO_DATA_FOR_LATLNG;
            continue;
            paramString = SearchResult.ERRORNO.INVALID_DISTRICT_ID;
            continue;
            paramString = SearchResult.ERRORNO.PARAMER_ERROR;
            continue;
            paramString = SearchResult.ERRORNO.KEY_ERROR;
            continue;
            paramString = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
            continue;
          }
        }
        else
        {
          paramSearchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
          return true;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramSearchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return true;
      }
      paramString = "status_sp";
      continue;
      label124:
      if (i == 0) {
        break;
      }
      if (i != 2) {
        if ((i != 200) && (i != 230)) {
          if ((i != 10) && (i != 11)) {
            if (i != 40) {
              if ((i != 41) && (i != 44)) {
                if (i != 45) {
                  switch (i)
                  {
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.base.b
 * JD-Core Version:    0.7.0.1
 */