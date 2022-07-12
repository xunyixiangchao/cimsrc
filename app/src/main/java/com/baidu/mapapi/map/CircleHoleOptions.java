package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;

public class CircleHoleOptions
  extends HoleOptions
{
  private LatLng a;
  private int b;
  
  public CircleHoleOptions()
  {
    this.mHoleType = "circle";
  }
  
  public CircleHoleOptions center(LatLng paramLatLng)
  {
    if (paramLatLng == null)
    {
      Log.e("baidumapsdk", "CircleHole center can not be null");
      return this;
    }
    this.a = paramLatLng;
    return this;
  }
  
  public LatLng getHoleCenter()
  {
    return this.a;
  }
  
  public int getHoleRadius()
  {
    return this.b;
  }
  
  public CircleHoleOptions radius(int paramInt)
  {
    if (paramInt <= 0)
    {
      Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
      return this;
    }
    this.b = paramInt;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.CircleHoleOptions
 * JD-Core Version:    0.7.0.1
 */