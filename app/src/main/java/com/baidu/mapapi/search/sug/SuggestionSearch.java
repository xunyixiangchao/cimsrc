package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.platform.core.sug.ISuggestionSearch;

public class SuggestionSearch
  extends com.baidu.mapapi.search.core.a
{
  ISuggestionSearch a = new com.baidu.platform.core.sug.a();
  private boolean b = false;
  
  public static SuggestionSearch newInstance()
  {
    BMapManager.init();
    return new SuggestionSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean requestSuggestion(SuggestionSearchOption paramSuggestionSearchOption)
  {
    ISuggestionSearch localISuggestionSearch = this.a;
    if (localISuggestionSearch != null)
    {
      if ((paramSuggestionSearchOption != null) && (paramSuggestionSearchOption.mKeyword != null) && (paramSuggestionSearchOption.mCity != null)) {
        return localISuggestionSearch.requestSuggestion(paramSuggestionSearchOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
  }
  
  public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener paramOnGetSuggestionResultListener)
  {
    ISuggestionSearch localISuggestionSearch = this.a;
    if (localISuggestionSearch != null)
    {
      if (paramOnGetSuggestionResultListener != null)
      {
        localISuggestionSearch.setOnGetSuggestionResultListener(paramOnGetSuggestionResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.sug.SuggestionSearch
 * JD-Core Version:    0.7.0.1
 */