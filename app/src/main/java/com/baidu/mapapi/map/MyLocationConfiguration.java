package com.baidu.mapapi.map;

import android.graphics.Color;

public class MyLocationConfiguration
{
  public int accuracyCircleFillColor = 4521984;
  public int accuracyCircleStrokeColor = 4653056;
  public final BitmapDescriptor customMarker;
  public final boolean enableDirection;
  public final LocationMode locationMode;
  
  public MyLocationConfiguration(LocationMode paramLocationMode, boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor)
  {
    LocationMode localLocationMode = paramLocationMode;
    if (paramLocationMode == null) {
      localLocationMode = LocationMode.NORMAL;
    }
    this.locationMode = localLocationMode;
    this.enableDirection = paramBoolean;
    this.customMarker = paramBitmapDescriptor;
    this.accuracyCircleFillColor = a(4521984);
    this.accuracyCircleStrokeColor = a(this.accuracyCircleStrokeColor);
  }
  
  public MyLocationConfiguration(LocationMode paramLocationMode, boolean paramBoolean, BitmapDescriptor paramBitmapDescriptor, int paramInt1, int paramInt2)
  {
    LocationMode localLocationMode = paramLocationMode;
    if (paramLocationMode == null) {
      localLocationMode = LocationMode.NORMAL;
    }
    this.locationMode = localLocationMode;
    this.enableDirection = paramBoolean;
    this.customMarker = paramBitmapDescriptor;
    this.accuracyCircleFillColor = a(paramInt1);
    this.accuracyCircleStrokeColor = a(paramInt2);
  }
  
  private int a(int paramInt)
  {
    return Color.argb((0xFF000000 & paramInt) >> 24, paramInt & 0xFF, (0xFF00 & paramInt) >> 8, (0xFF0000 & paramInt) >> 16);
  }
  
  public static enum LocationMode
  {
    static
    {
      LocationMode localLocationMode1 = new LocationMode("NORMAL", 0);
      NORMAL = localLocationMode1;
      LocationMode localLocationMode2 = new LocationMode("FOLLOWING", 1);
      FOLLOWING = localLocationMode2;
      LocationMode localLocationMode3 = new LocationMode("COMPASS", 2);
      COMPASS = localLocationMode3;
      a = new LocationMode[] { localLocationMode1, localLocationMode2, localLocationMode3 };
    }
    
    private LocationMode() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.MyLocationConfiguration
 * JD-Core Version:    0.7.0.1
 */