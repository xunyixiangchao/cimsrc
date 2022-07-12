package com.baidu.lbsapi.auth;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class h
  implements HostnameVerifier
{
  h(g paramg) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if ("api.map.baidu.com".equals(paramString)) {
      return true;
    }
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.h
 * JD-Core Version:    0.7.0.1
 */