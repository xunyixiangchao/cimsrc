package com.baidu.mapapi.map;

public abstract interface CustomMapStyleCallBack
{
  public abstract boolean onCustomMapStyleLoadFailed(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean onCustomMapStyleLoadSuccess(boolean paramBoolean, String paramString);
  
  public abstract boolean onPreLoadLastCustomMapStyle(String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.CustomMapStyleCallBack
 * JD-Core Version:    0.7.0.1
 */