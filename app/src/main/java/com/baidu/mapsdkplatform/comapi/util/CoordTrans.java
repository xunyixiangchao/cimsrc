package com.baidu.mapsdkplatform.comapi.util;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comjni.tools.JNITools;

public class CoordTrans
{
  public static LatLng baiduToGcj(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramLatLng = JNITools.baiduToGcj(paramLatLng.latitude, paramLatLng.longitude);
    if (paramLatLng == null) {
      return null;
    }
    return new LatLng(paramLatLng[0], paramLatLng[1]);
  }
  
  public static LatLng gcjToBaidu(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramLatLng = JNITools.gcjToBaidu(paramLatLng.latitude, paramLatLng.longitude);
    if (paramLatLng == null) {
      return null;
    }
    return new LatLng(paramLatLng[0], paramLatLng[1]);
  }
  
  public static LatLng wgsToBaidu(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramLatLng = JNITools.wgsToBaidu(paramLatLng.latitude, paramLatLng.longitude);
    if (paramLatLng == null) {
      return null;
    }
    return new LatLng(paramLatLng[0], paramLatLng[1]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.CoordTrans
 * JD-Core Version:    0.7.0.1
 */