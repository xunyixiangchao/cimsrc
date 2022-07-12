package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  AsyncHttpClient a = new AsyncHttpClient();
  
  private b a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject = paramString.optJSONObject("result");
        if (localObject == null) {
          return new b(PanoStateError.c);
        }
        if (((JSONObject)localObject).optInt("error") == 0)
        {
          localObject = paramString.optJSONArray("content");
          if (localObject == null) {
            return new b(PanoStateError.c);
          }
          int i = 0;
          paramString = null;
          while (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i).optJSONObject("poiinfo");
            if (localJSONObject != null)
            {
              paramString = new b(PanoStateError.a);
              paramString.a(localJSONObject.optString("PID"));
              paramString.a(localJSONObject.optInt("hasstreet"));
            }
            i += 1;
          }
          return paramString;
        }
        return new b(PanoStateError.b);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return new b(PanoStateError.c);
      }
    }
    return new b(PanoStateError.c);
  }
  
  private String a(Uri.Builder paramBuilder)
  {
    paramBuilder = paramBuilder.build().toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBuilder);
    localStringBuilder.append(HttpClient.getPhoneInfo());
    paramBuilder = Uri.parse(localStringBuilder.toString()).buildUpon();
    paramBuilder.appendQueryParameter("sign", AppMD5.getSignMD5String(paramBuilder.build().getEncodedQuery()));
    return paramBuilder.build().toString();
  }
  
  private void a(Uri.Builder paramBuilder, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      paramBuilder.appendQueryParameter(paramString1, paramString2);
    }
  }
  
  public void a(String paramString, final b<b> paramb)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    String str;
    if (HttpClient.isHttpsEnable) {
      str = "https";
    } else {
      str = "http";
    }
    localBuilder.scheme(str);
    localBuilder.encodedAuthority("api.map.baidu.com");
    localBuilder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
    a(localBuilder, "qt", "poi");
    a(localBuilder, "uid", paramString);
    a(localBuilder, "action", "0");
    paramString = HttpClient.getAuthToken();
    if (paramString == null)
    {
      paramb.a(new b(PanoStateError.d));
      return;
    }
    a(localBuilder, "token", paramString);
    paramString = a(localBuilder);
    this.a.get(paramString, new a(paramb));
  }
  
  class a
    extends HttpClient.ProtoResultCallback
  {
    a(a.b paramb) {}
    
    public void onFailed(HttpClient.HttpStateError paramHttpStateError)
    {
      paramb.a(paramHttpStateError);
    }
    
    public void onSuccess(String paramString)
    {
      paramb.a(a.a(a.this, paramString));
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(HttpClient.HttpStateError paramHttpStateError);
    
    public abstract void a(T paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.pano.a
 * JD-Core Version:    0.7.0.1
 */