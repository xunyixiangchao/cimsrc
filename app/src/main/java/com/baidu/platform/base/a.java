package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.core.geocode.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
{
  private AsyncHttpClient a = new AsyncHttpClient();
  private Handler b = new Handler(Looper.getMainLooper());
  protected final Lock c = new ReentrantLock();
  private boolean d = true;
  private DistrictResult e = null;
  private SearchType f;
  
  private int a(String paramString)
  {
    if (paramString != null) {
      if (paramString.equals("")) {
        return 10204;
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("status")) {
        return paramString.getInt("status");
      }
      if (paramString.has("status_sp")) {
        return paramString.getInt("status_sp");
      }
      if (paramString.has("result"))
      {
        paramString = paramString.optJSONObject("result");
        if (paramString == null) {
          return 10204;
        }
        int i = paramString.optInt("error");
        return i;
      }
      return 10204;
    }
    catch (JSONException paramString)
    {
      label95:
      break label95;
    }
    Log.e("BaseSearch", "Create JSONObject failed when get response result status");
    return 10204;
  }
  
  private void a(AsyncHttpClient paramAsyncHttpClient, HttpClient.ProtoResultCallback paramProtoResultCallback, SearchResult paramSearchResult)
  {
    paramAsyncHttpClient.get(new com.baidu.platform.core.district.c(((DistrictResult)paramSearchResult).getCityName()).b(this.f), paramProtoResultCallback);
  }
  
  private void a(HttpClient.HttpStateError paramHttpStateError, b paramb, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{SDK_InnerError:{httpStateError:");
    localStringBuilder.append(paramHttpStateError);
    localStringBuilder.append("}}");
    a(paramb.a(localStringBuilder.toString()), paramObject, paramb);
  }
  
  private void a(final SearchResult paramSearchResult, final Object paramObject, final b paramb)
  {
    this.b.post(new b(paramb, paramSearchResult, paramObject));
  }
  
  private void a(String paramString, b paramb, Object paramObject, AsyncHttpClient paramAsyncHttpClient, HttpClient.ProtoResultCallback paramProtoResultCallback)
  {
    SearchResult localSearchResult = paramb.a(paramString);
    localSearchResult.status = a(paramString);
    if (a(paramb, localSearchResult))
    {
      a(paramAsyncHttpClient, paramProtoResultCallback, localSearchResult);
      return;
    }
    if ((paramb instanceof com.baidu.platform.core.district.b))
    {
      paramString = this.e;
      if (paramString != null)
      {
        paramAsyncHttpClient = (DistrictResult)localSearchResult;
        paramAsyncHttpClient.setCityCode(paramString.getCityCode());
        paramAsyncHttpClient.setCenterPt(this.e.getCenterPt());
      }
      a(localSearchResult, paramObject, paramb);
      this.d = true;
      this.e = null;
      ((com.baidu.platform.core.district.b)paramb).a(false);
      return;
    }
    a(localSearchResult, paramObject, paramb);
  }
  
  private boolean a(b paramb, SearchResult paramSearchResult)
  {
    if (!(paramb instanceof com.baidu.platform.core.district.b)) {
      return false;
    }
    SearchResult.ERRORNO localERRORNO = SearchResult.ERRORNO.RESULT_NOT_FOUND;
    paramSearchResult = (DistrictResult)paramSearchResult;
    if (localERRORNO != paramSearchResult.error) {
      return false;
    }
    if (paramSearchResult.getCityName() == null) {
      return false;
    }
    if (this.d)
    {
      this.d = false;
      this.e = paramSearchResult;
      ((com.baidu.platform.core.district.b)paramb).a(true);
      return true;
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool = paramString.has("status");
      if ((!bool) && (!paramString.has("status_sp"))) {
        break label97;
      }
      if (paramString.has("status")) {
        i = paramString.getInt("status");
      } else {
        i = paramString.getInt("status_sp");
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        int i;
        label97:
        continue;
        if ((i == 105) || (i == 106)) {}
      }
    }
    i = PermissionCheck.permissionCheck();
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("permissionCheck result is: ");
      paramString.append(i);
      Log.e("BaseSearch", paramString.toString());
    }
    return true;
    return false;
  }
  
  private String c(String paramString)
  {
    byte[] arrayOfByte = new byte[5];
    byte[] tmp5_4 = arrayOfByte;
    tmp5_4[0] = 102;
    byte[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 97;
    byte[] tmp15_10 = tmp10_5;
    tmp15_10[2] = 105;
    byte[] tmp20_15 = tmp15_10;
    tmp20_15[3] = 108;
    byte[] tmp25_20 = tmp20_15;
    tmp25_20[4] = 100;
    tmp25_20;
    try
    {
      paramString = Base64.decode(paramString.getBytes(), 0);
      paramString = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), paramString);
    }
    catch (Exception paramString)
    {
      label54:
      break label54;
    }
    Log.e("BaseSearch", "transform result failed");
    paramString = arrayOfByte;
    return new String(paramString).trim();
  }
  
  protected boolean a(c paramc, final Object paramObject, final b paramb)
  {
    if (paramb == null)
    {
      Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
      return false;
    }
    Object localObject = paramb.a();
    this.f = ((SearchType)localObject);
    paramc = paramc.b((SearchType)localObject);
    if (paramc == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("The sendurl is: ");
      ((StringBuilder)localObject).append(paramc);
      Log.e("BaseSearch", ((StringBuilder)localObject).toString());
      a(paramb.a("{SDK_InnerError:{PermissionCheckError:Error}}"), paramObject, paramb);
      return false;
    }
    this.a.get(paramc, new a(paramb, paramObject));
    return true;
  }
  
  class a
    extends HttpClient.ProtoResultCallback
  {
    a(b paramb, Object paramObject) {}
    
    public void onFailed(HttpClient.HttpStateError paramHttpStateError)
    {
      a.a(a.this, paramHttpStateError, paramb, paramObject);
    }
    
    public void onSuccess(String paramString)
    {
      if (!a.a(a.this, paramString))
      {
        if ((paramb instanceof d)) {
          localObject = a.b(a.this, paramString);
        } else {
          localObject = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = (String)localObject;
        }
      }
      Object localObject = a.this;
      a.a((a)localObject, paramString, paramb, paramObject, a.a((a)localObject), this);
    }
  }
  
  class b
    implements Runnable
  {
    b(b paramb, SearchResult paramSearchResult, Object paramObject) {}
    
    public void run()
    {
      if (paramb != null)
      {
        a.this.c.lock();
        try
        {
          paramb.a(paramSearchResult, paramObject);
          return;
        }
        finally
        {
          a.this.c.unlock();
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.base.a
 * JD-Core Version:    0.7.0.1
 */