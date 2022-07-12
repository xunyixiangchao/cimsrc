package com.baidu.mapapi.http;

import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpClient
{
  private int a = 10000;
  private int b = 10000;
  private ExecutorService c = Executors.newCachedThreadPool();
  
  public void get(final String paramString, final HttpClient.ProtoResultCallback paramProtoResultCallback)
  {
    if (paramString != null)
    {
      this.c.submit(new a(paramProtoResultCallback, paramString));
      return;
    }
    throw new IllegalArgumentException("URI cannot be null");
  }
  
  protected boolean isAuthorized()
  {
    int i = PermissionCheck.permissionCheck();
    return (i == 0) || (i == 602) || (i == 601);
  }
  
  class a
    extends AsyncHttpClient.b
  {
    a(HttpClient.ProtoResultCallback paramProtoResultCallback, String paramString)
    {
      super();
    }
    
    public void a()
    {
      HttpClient localHttpClient = new HttpClient("GET", paramProtoResultCallback);
      localHttpClient.setMaxTimeOut(AsyncHttpClient.a(AsyncHttpClient.this));
      localHttpClient.setReadTimeOut(AsyncHttpClient.b(AsyncHttpClient.this));
      localHttpClient.request(paramString);
    }
  }
  
  private static abstract class b
    implements Runnable
  {
    public abstract void a();
    
    public void run()
    {
      a();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.http.AsyncHttpClient
 * JD-Core Version:    0.7.0.1
 */