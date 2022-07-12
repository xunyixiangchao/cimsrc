package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;

class b
  implements ThreadFactory
{
  private String a;
  
  public b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaiduMapSDK-");
    localStringBuilder.append(paramString);
    this.a = localStringBuilder.toString();
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.a);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.b
 * JD-Core Version:    0.7.0.1
 */