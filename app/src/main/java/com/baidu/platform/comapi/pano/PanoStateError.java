package com.baidu.platform.comapi.pano;

public enum PanoStateError
{
  static
  {
    PanoStateError localPanoStateError1 = new PanoStateError("PANO_NO_ERROR", 0);
    a = localPanoStateError1;
    PanoStateError localPanoStateError2 = new PanoStateError("PANO_UID_ERROR", 1);
    b = localPanoStateError2;
    PanoStateError localPanoStateError3 = new PanoStateError("PANO_NOT_FOUND", 2);
    c = localPanoStateError3;
    PanoStateError localPanoStateError4 = new PanoStateError("PANO_NO_TOKEN", 3);
    d = localPanoStateError4;
    e = new PanoStateError[] { localPanoStateError1, localPanoStateError2, localPanoStateError3, localPanoStateError4 };
  }
  
  private PanoStateError() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.pano.PanoStateError
 * JD-Core Version:    0.7.0.1
 */