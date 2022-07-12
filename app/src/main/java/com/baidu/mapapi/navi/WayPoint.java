package com.baidu.mapapi.navi;

import java.util.List;

public class WayPoint
{
  private List<WayPointInfo> a;
  
  public WayPoint(List<WayPointInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.a = paramList;
  }
  
  public List<WayPointInfo> getViaPoints()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.navi.WayPoint
 * JD-Core Version:    0.7.0.1
 */