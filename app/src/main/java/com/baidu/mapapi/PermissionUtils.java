package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;

public class PermissionUtils
{
  public static PermissionUtils getInstance()
  {
    return b.a();
  }
  
  public boolean isIndoorNaviAuthorized()
  {
    return c.a().b();
  }
  
  public boolean isWalkARNaviAuthorized()
  {
    return c.a().c();
  }
  
  private static class b
  {
    private static final PermissionUtils a = new PermissionUtils(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */