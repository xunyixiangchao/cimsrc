package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

public class PolygonHoleOptions
  extends HoleOptions
{
  private List<LatLng> a;
  
  public PolygonHoleOptions()
  {
    this.mHoleType = "polygon";
  }
  
  public PolygonHoleOptions addPoints(List<LatLng> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 3))
    {
      this.a = paramList;
      return this;
    }
    Log.e("baidumapsdk", "PolygonHole's points can not be null or points's size can not be less than three");
    return this;
  }
  
  public List<LatLng> getHolePoints()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.PolygonHoleOptions
 * JD-Core Version:    0.7.0.1
 */