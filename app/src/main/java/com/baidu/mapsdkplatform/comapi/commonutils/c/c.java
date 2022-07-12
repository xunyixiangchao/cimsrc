package com.baidu.mapsdkplatform.comapi.commonutils.c;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class c
{
  private ExecutorService a = Executors.newCachedThreadPool();
  private int b = 1;
  private List<b> c = new LinkedList();
  private d d;
  
  private HttpURLConnection a(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      if (HttpClient.isHttpsEnable)
      {
        paramString = (HttpsURLConnection)paramString.openConnection();
        paramString.setHostnameVerifier(new e());
      }
      else
      {
        paramString = (HttpURLConnection)paramString.openConnection();
      }
      paramString.setConnectTimeout(5000);
      paramString.setRequestMethod("GET");
      paramString.connect();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(String paramString, File paramFile, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramFile != null) && (paramInt1 > 0))
    {
      if (paramInt2 <= 0) {
        return;
      }
      int j;
      for (int i = 0;; i = j)
      {
        int k = this.b;
        if (i >= k) {
          break;
        }
        j = i + 1;
        Object localObject1 = new a(i, i * paramInt1, j * paramInt1 - 1);
        if (i == k - 1) {
          ((a)localObject1).a(paramInt2);
        }
        localObject1 = new b(paramString, paramFile, (a)localObject1, new b(paramFile, null));
        Object localObject2 = this.c;
        if (localObject2 != null) {
          ((List)localObject2).add(localObject1);
        }
        localObject2 = this.a;
        if ((localObject2 != null) && (!((ExecutorService)localObject2).isShutdown())) {
          this.a.submit((Runnable)localObject1);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString2);
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return;
    }
    HttpURLConnection localHttpURLConnection = a(paramString1);
    if (localHttpURLConnection != null) {}
    try
    {
      if (localHttpURLConnection.getResponseCode() == 200)
      {
        int j = localHttpURLConnection.getContentLength();
        if (j > 0)
        {
          paramString2 = paramString3;
          if (paramString3 == null)
          {
            paramString2 = localHttpURLConnection.getHeaderField("Content-Disposition");
            if (paramString2 == null) {
              return;
            }
            if (paramString2.length() == 0) {
              return;
            }
            paramString3 = URLDecoder.decode(paramString2.substring(paramString2.indexOf("filename=") + 9), "UTF-8");
            if (paramString3 == null) {
              return;
            }
            paramString2 = paramString3;
            if (paramString3.length() == 0) {
              return;
            }
          }
          paramString2 = new File(localFile, paramString2);
          paramString3 = new RandomAccessFile(paramString2, "rw");
          paramString3.setLength(j);
          paramString3.close();
          localHttpURLConnection.disconnect();
          int k = this.b;
          int i = j / k;
          if (j % k != 0) {
            i += 1;
          }
          a(paramString1, paramString2, i, j);
        }
        else
        {
          throw new RuntimeException("unKnow file length");
        }
      }
      else
      {
        throw new RuntimeException("server no response.");
      }
    }
    catch (Exception paramString1) {}
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, d paramd)
  {
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      this.b = paramInt;
      this.d = paramd;
      a(paramString1, paramString2, paramString3);
    }
  }
  
  private class b
    implements c.c
  {
    private File a;
    
    private b(File paramFile)
    {
      this.a = paramFile;
    }
    
    public void a(b paramb)
    {
      if ((c.a(c.this) != null) && (c.a(c.this).size() != 0))
      {
        if (paramb == null) {
          return;
        }
        if ((paramb.a()) && (c.a(c.this) != null))
        {
          c.a(c.this).remove(paramb);
          if (c.a(c.this).size() == 0) {
            c.b(c.this).a(this.a);
          }
        }
      }
    }
    
    public void b(b paramb)
    {
      if ((c.a(c.this) != null) && (c.a(c.this).size() != 0))
      {
        if (paramb == null) {
          return;
        }
        c.a(c.this).clear();
        if (c.b(c.this) != null) {
          c.b(c.this).a();
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(b paramb);
    
    public abstract void b(b paramb);
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void a(File paramFile);
  }
  
  static class e
    implements HostnameVerifier
  {
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.commonutils.c.c
 * JD-Core Version:    0.7.0.1
 */