package com.baidu.platform.core.share;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.platform.util.a;

public class b
  extends com.baidu.platform.base.c
{
  public b(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    a(paramPoiDetailShareURLOption);
  }
  
  private void a(PoiDetailShareURLOption paramPoiDetailShareURLOption)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://wapmap.baidu.com/s?tn=Detail&pid=");
    localStringBuilder.append(paramPoiDetailShareURLOption.mUid);
    localStringBuilder.append("&smsf=3");
    paramPoiDetailShareURLOption = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPoiDetailShareURLOption);
    localStringBuilder.append(HttpClient.getPhoneInfo());
    paramPoiDetailShareURLOption = localStringBuilder.toString();
    this.c.a("url", paramPoiDetailShareURLOption);
    b(false);
    a(false);
  }
  
  public String a(com.baidu.platform.domain.c paramc)
  {
    return paramc.r();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.core.share.b
 * JD-Core Version:    0.7.0.1
 */