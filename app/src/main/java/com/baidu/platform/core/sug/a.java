package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class a
  extends com.baidu.platform.base.a
  implements ISuggestionSearch
{
  private OnGetSuggestionResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean requestSuggestion(SuggestionSearchOption paramSuggestionSearchOption)
  {
    b localb = new b();
    localb.a(SearchType.f);
    return a(new c(paramSuggestionSearchOption), this.g, localb);
  }
  
  public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener paramOnGetSuggestionResultListener)
  {
    this.c.lock();
    this.g = paramOnGetSuggestionResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.sug.a
 * JD-Core Version:    0.7.0.1
 */