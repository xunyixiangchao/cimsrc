package com.baidu.location;

public abstract class BDAbstractLocationListener
{
  public void onConnectHotSpotMessage(String paramString, int paramInt) {}
  
  public void onLocDiagnosticMessage(int paramInt1, int paramInt2, String paramString) {}
  
  public void onReceiveLocString(String paramString) {}
  
  public abstract void onReceiveLocation(BDLocation paramBDLocation);
  
  public void onReceiveVdrLocation(BDLocation paramBDLocation) {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.BDAbstractLocationListener
 * JD-Core Version:    0.7.0.1
 */