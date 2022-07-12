package com.baidu.mapapi.search.busline;

public class BusLineSearchOption
{
  public String mCity = null;
  public String mUid = null;
  
  public BusLineSearchOption city(String paramString)
  {
    this.mCity = paramString;
    return this;
  }
  
  public BusLineSearchOption uid(String paramString)
  {
    this.mUid = paramString;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.search.busline.BusLineSearchOption
 * JD-Core Version:    0.7.0.1
 */