package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public final class TileOverlayOptions
{
  private static Bundle i;
  private static final String j = "TileOverlayOptions";
  private int a = 209715200;
  private TileProvider b;
  private int c = 20;
  private int d = 3;
  public int datasource;
  private int e = 15786414;
  private int f = -20037726;
  private int g = -15786414;
  private int h = 20037726;
  public String urlString;
  
  public TileOverlayOptions()
  {
    Bundle localBundle = new Bundle();
    i = localBundle;
    localBundle.putInt("rectr", this.e);
    i.putInt("rectb", this.f);
    i.putInt("rectl", this.g);
    i.putInt("rectt", this.h);
  }
  
  private TileOverlayOptions a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    return this;
  }
  
  Bundle a()
  {
    i.putString("url", this.urlString);
    i.putInt("datasource", this.datasource);
    i.putInt("maxDisplay", this.c);
    i.putInt("minDisplay", this.d);
    i.putInt("sdktiletmpmax", this.a);
    return i;
  }
  
  TileOverlay a(BaiduMap paramBaiduMap)
  {
    return new TileOverlay(paramBaiduMap, this.b);
  }
  
  public TileOverlayOptions setMaxTileTmp(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public TileOverlayOptions setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (paramLatLngBounds != null)
    {
      GeoPoint localGeoPoint = CoordUtil.ll2mc(paramLatLngBounds.northeast);
      paramLatLngBounds = CoordUtil.ll2mc(paramLatLngBounds.southwest);
      double d1 = localGeoPoint.getLatitudeE6();
      double d2 = paramLatLngBounds.getLongitudeE6();
      double d3 = paramLatLngBounds.getLatitudeE6();
      double d4 = localGeoPoint.getLongitudeE6();
      if ((d1 > d3) && (d4 > d2))
      {
        i.putInt("rectr", (int)d4);
        i.putInt("rectb", (int)d3);
        i.putInt("rectl", (int)d2);
        i.putInt("rectt", (int)d1);
        return this;
      }
      Log.e(j, "BDMapSDKException: bounds is illegal, use default bounds");
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: bound can not be null");
  }
  
  public TileOverlayOptions tileProvider(TileProvider paramTileProvider)
  {
    if (paramTileProvider == null) {
      return null;
    }
    String str;
    if ((paramTileProvider instanceof UrlTileProvider))
    {
      this.datasource = 1;
      str = ((UrlTileProvider)paramTileProvider).getTileUrl();
      if ((str != null) && (!"".equals(str)) && (str.contains("{x}")) && (str.contains("{y}")) && (str.contains("{z}")))
      {
        this.urlString = str;
        break label110;
      }
      str = j;
    }
    for (paramTileProvider = "tile url template is illegal, must contains {x}、{y}、{z}";; paramTileProvider = "tileProvider must be UrlTileProvider or FileTileProvider")
    {
      Log.e(str, paramTileProvider);
      return null;
      if ((paramTileProvider instanceof FileTileProvider))
      {
        this.datasource = 0;
        label110:
        this.b = paramTileProvider;
        int k = paramTileProvider.getMaxDisLevel();
        int m = paramTileProvider.getMinDisLevel();
        if ((k <= 21) && (m >= 3))
        {
          a(k, m);
          return this;
        }
        Log.e(j, "display level is illegal");
        return this;
      }
      str = j;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.TileOverlayOptions
 * JD-Core Version:    0.7.0.1
 */