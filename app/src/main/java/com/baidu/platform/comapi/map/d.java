package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class d
  extends InnerOverlay
{
  public d(AppBaseMap paramAppBaseMap)
  {
    super(20, paramAppBaseMap);
  }
  
  public boolean getDefaultShowStatus()
  {
    return true;
  }
  
  public String getLayerTag()
  {
    return "compass";
  }
  
  public void setData(String paramString)
  {
    super.setData(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.d
 * JD-Core Version:    0.7.0.1
 */