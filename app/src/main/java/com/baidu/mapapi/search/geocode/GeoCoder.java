package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.platform.core.geocode.IGeoCoder;

public class GeoCoder
  extends com.baidu.mapapi.search.core.a
{
  private IGeoCoder a = new com.baidu.platform.core.geocode.a();
  private boolean b;
  
  public static GeoCoder newInstance()
  {
    BMapManager.init();
    return new GeoCoder();
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.a.destroy();
    BMapManager.destroy();
  }
  
  public boolean geocode(GeoCodeOption paramGeoCodeOption)
  {
    IGeoCoder localIGeoCoder = this.a;
    if (localIGeoCoder != null)
    {
      if ((paramGeoCodeOption != null) && (paramGeoCodeOption.mAddress != null) && (paramGeoCodeOption.mCity != null)) {
        return localIGeoCoder.geocode(paramGeoCodeOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
  }
  
  public boolean reverseGeoCode(ReverseGeoCodeOption paramReverseGeoCodeOption)
  {
    if (this.a != null)
    {
      if ((paramReverseGeoCodeOption != null) && (paramReverseGeoCodeOption.getLocation() != null)) {
        return this.a.reverseGeoCode(paramReverseGeoCodeOption);
      }
      throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
  }
  
  public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener paramOnGetGeoCoderResultListener)
  {
    IGeoCoder localIGeoCoder = this.a;
    if (localIGeoCoder != null)
    {
      if (paramOnGetGeoCoderResultListener != null)
      {
        localIGeoCoder.setOnGetGeoCodeResultListener(paramOnGetGeoCoderResultListener);
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.geocode.GeoCoder
 * JD-Core Version:    0.7.0.1
 */