package com.baidu.mapsdkplatform.comjni.tools;

public class JNITools
{
  public static native boolean CoordinateEncryptEx(float paramFloat1, float paramFloat2, String paramString, Object paramObject);
  
  public static native boolean CoordinateEncryptMc(float paramFloat1, float paramFloat2, Object paramObject);
  
  public static native void GetDistanceByMC(Object paramObject);
  
  public static native String GetToken();
  
  public static native boolean TransGeoStr2ComplexPt(Object paramObject);
  
  public static native boolean TransGeoStr2Pt(Object paramObject);
  
  public static native void TransNodeStr2Pt(Object paramObject);
  
  public static native double[] baiduToGcj(double paramDouble1, double paramDouble2);
  
  public static native double[] gcjToBaidu(double paramDouble1, double paramDouble2);
  
  public static native int initClass(Object paramObject, int paramInt);
  
  public static native void openLogEnable(boolean paramBoolean, int paramInt);
  
  public static native double[] wgsToBaidu(double paramDouble1, double paramDouble2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comjni.tools.JNITools
 * JD-Core Version:    0.7.0.1
 */