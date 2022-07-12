package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.BMapManager;
import com.baidu.platform.core.recommendstop.IRecommendStop;

public class RecommendStopSearch
  extends com.baidu.mapapi.search.core.a
{
  private IRecommendStop a = new com.baidu.platform.core.recommendstop.a();
  private boolean b = false;
  
  public static RecommendStopSearch newInstance()
  {
    BMapManager.init();
    return new RecommendStopSearch();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    IRecommendStop localIRecommendStop = this.a;
    if (localIRecommendStop != null) {
      localIRecommendStop.destroy();
    }
    BMapManager.destroy();
  }
  
  public boolean requestRecommendStop(RecommendStopSearchOption paramRecommendStopSearchOption)
  {
    if (this.a != null)
    {
      if ((paramRecommendStopSearchOption != null) && (paramRecommendStopSearchOption.getLocation() != null)) {
        return this.a.requestRecommendStop(paramRecommendStopSearchOption);
      }
      throw new IllegalStateException("BDMapSDKException: option or location can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
  }
  
  public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener paramOnGetRecommendStopResultListener)
  {
    IRecommendStop localIRecommendStop = this.a;
    if (localIRecommendStop != null)
    {
      if (paramOnGetRecommendStopResultListener != null)
      {
        localIRecommendStop.setOnGetRecommendStopResultListener(paramOnGetRecommendStopResultListener);
        return;
      }
      throw new IllegalStateException("BDMapSDKException: OnGetRecommendStopResultListener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.recommendstop.RecommendStopSearch
 * JD-Core Version:    0.7.0.1
 */