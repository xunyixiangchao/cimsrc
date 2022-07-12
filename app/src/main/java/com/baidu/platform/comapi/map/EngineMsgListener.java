package com.baidu.platform.comapi.map;

public abstract interface EngineMsgListener
{
  public abstract void onEnterIndoorMapMode(IndoorMapInfo paramIndoorMapInfo);
  
  public abstract void onExitIndoorMapMode();
  
  public abstract void onLongLinkConnect();
  
  public abstract void onLongLinkDisConnect();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.EngineMsgListener
 * JD-Core Version:    0.7.0.1
 */