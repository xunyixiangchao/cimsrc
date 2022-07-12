package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;

public abstract interface IRecommendStop
{
  public abstract void destroy();
  
  public abstract boolean requestRecommendStop(RecommendStopSearchOption paramRecommendStopSearchOption);
  
  public abstract void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener paramOnGetRecommendStopResultListener);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.recommendstop.IRecommendStop
 * JD-Core Version:    0.7.0.1
 */