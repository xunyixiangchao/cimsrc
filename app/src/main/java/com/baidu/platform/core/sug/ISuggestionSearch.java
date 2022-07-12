package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

public abstract interface ISuggestionSearch
{
  public abstract void destroy();
  
  public abstract boolean requestSuggestion(SuggestionSearchOption paramSuggestionSearchOption);
  
  public abstract void setOnGetSuggestionResultListener(OnGetSuggestionResultListener paramOnGetSuggestionResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.sug.ISuggestionSearch
 * JD-Core Version:    0.7.0.1
 */