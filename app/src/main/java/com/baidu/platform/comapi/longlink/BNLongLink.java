package com.baidu.platform.comapi.longlink;

public class BNLongLink
{
  private static BNLongLinkInitCallBack a;
  
  public static void initLongLink()
  {
    BNLongLinkInitCallBack localBNLongLinkInitCallBack = a;
    if (localBNLongLinkInitCallBack != null) {
      localBNLongLinkInitCallBack.onLongLinkInit();
    }
  }
  
  public static void registerLongLinkInitCallBack(BNLongLinkInitCallBack paramBNLongLinkInitCallBack)
  {
    a = paramBNLongLinkInitCallBack;
  }
  
  public static void unRegisterLongLinkInitCallBack(BNLongLinkInitCallBack paramBNLongLinkInitCallBack)
  {
    a = paramBNLongLinkInitCallBack;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.longlink.BNLongLink
 * JD-Core Version:    0.7.0.1
 */