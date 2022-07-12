package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.platform.base.SearchType;
import java.util.concurrent.locks.Lock;

public class a
  extends com.baidu.platform.base.a
  implements IRecommendStop
{
  private OnGetRecommendStopResultListener g = null;
  
  public void destroy()
  {
    this.c.lock();
    this.g = null;
    this.c.unlock();
  }
  
  public boolean requestRecommendStop(RecommendStopSearchOption paramRecommendStopSearchOption)
  {
    b localb = new b();
    localb.a(SearchType.u);
    return a(new c(paramRecommendStopSearchOption), this.g, localb);
  }
  
  public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener paramOnGetRecommendStopResultListener)
  {
    this.c.lock();
    this.g = paramOnGetRecommendStopResultListener;
    this.c.unlock();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.recommendstop.a
 * JD-Core Version:    0.7.0.1
 */