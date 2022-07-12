package com.baidu.mapapi.map;

public enum LogoPosition
{
  static
  {
    LogoPosition localLogoPosition1 = new LogoPosition("logoPostionleftBottom", 0);
    logoPostionleftBottom = localLogoPosition1;
    LogoPosition localLogoPosition2 = new LogoPosition("logoPostionleftTop", 1);
    logoPostionleftTop = localLogoPosition2;
    LogoPosition localLogoPosition3 = new LogoPosition("logoPostionCenterBottom", 2);
    logoPostionCenterBottom = localLogoPosition3;
    LogoPosition localLogoPosition4 = new LogoPosition("logoPostionCenterTop", 3);
    logoPostionCenterTop = localLogoPosition4;
    LogoPosition localLogoPosition5 = new LogoPosition("logoPostionRightBottom", 4);
    logoPostionRightBottom = localLogoPosition5;
    LogoPosition localLogoPosition6 = new LogoPosition("logoPostionRightTop", 5);
    logoPostionRightTop = localLogoPosition6;
    a = new LogoPosition[] { localLogoPosition1, localLogoPosition2, localLogoPosition3, localLogoPosition4, localLogoPosition5, localLogoPosition6 };
  }
  
  private LogoPosition() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.LogoPosition
 * JD-Core Version:    0.7.0.1
 */