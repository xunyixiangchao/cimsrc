package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport.WebViewInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class H5JavaScriptInterface
{
  private static HashSet<Integer> a = new HashSet();
  private String b = null;
  private Thread c = null;
  private String d = null;
  private Map<String, String> e = null;
  
  private static a a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return null;
      }
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new a();
        String str = ((JSONObject)localObject).getString("projectRoot");
        paramString.a = str;
        if (str == null) {
          return null;
        }
        str = ((JSONObject)localObject).getString("context");
        paramString.b = str;
        if (str == null) {
          return null;
        }
        str = ((JSONObject)localObject).getString("url");
        paramString.c = str;
        if (str == null) {
          return null;
        }
        str = ((JSONObject)localObject).getString("userAgent");
        paramString.d = str;
        if (str == null) {
          return null;
        }
        str = ((JSONObject)localObject).getString("language");
        paramString.e = str;
        if (str == null) {
          return null;
        }
        str = ((JSONObject)localObject).getString("name");
        paramString.f = str;
        if (str != null)
        {
          if (str.equals("null")) {
            return null;
          }
          str = ((JSONObject)localObject).getString("stacktrace");
          if (str == null) {
            return null;
          }
          int i = str.indexOf("\n");
          if (i < 0)
          {
            y.d("H5 crash stack's format is wrong!", new Object[0]);
            return null;
          }
          paramString.h = str.substring(i + 1);
          str = str.substring(0, i);
          paramString.g = str;
          i = str.indexOf(":");
          if (i > 0) {
            paramString.g = paramString.g.substring(i + 1);
          }
          paramString.i = ((JSONObject)localObject).getString("file");
          if (paramString.f == null) {
            return null;
          }
          long l = ((JSONObject)localObject).getLong("lineNumber");
          paramString.j = l;
          if (l < 0L) {
            return null;
          }
          l = ((JSONObject)localObject).getLong("columnNumber");
          paramString.k = l;
          if (l < 0L) {
            return null;
          }
          y.a("H5 crash information is following: ", new Object[0]);
          localObject = new StringBuilder("[projectRoot]: ");
          ((StringBuilder)localObject).append(paramString.a);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[context]: ");
          ((StringBuilder)localObject).append(paramString.b);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[url]: ");
          ((StringBuilder)localObject).append(paramString.c);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[userAgent]: ");
          ((StringBuilder)localObject).append(paramString.d);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[language]: ");
          ((StringBuilder)localObject).append(paramString.e);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[name]: ");
          ((StringBuilder)localObject).append(paramString.f);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[message]: ");
          ((StringBuilder)localObject).append(paramString.g);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[stacktrace]: \n");
          ((StringBuilder)localObject).append(paramString.h);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[file]: ");
          ((StringBuilder)localObject).append(paramString.i);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[lineNumber]: ");
          ((StringBuilder)localObject).append(paramString.j);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[columnNumber]: ");
          ((StringBuilder)localObject).append(paramString.k);
          y.a(((StringBuilder)localObject).toString(), new Object[0]);
          return paramString;
        }
        return null;
      }
      finally
      {
        if (!y.a(paramString)) {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface paramWebViewInterface)
  {
    Object localObject1 = null;
    if (paramWebViewInterface != null)
    {
      if (a.contains(Integer.valueOf(paramWebViewInterface.hashCode()))) {
        return null;
      }
      H5JavaScriptInterface localH5JavaScriptInterface = new H5JavaScriptInterface();
      a.add(Integer.valueOf(paramWebViewInterface.hashCode()));
      Object localObject2 = Thread.currentThread();
      localH5JavaScriptInterface.c = ((Thread)localObject2);
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("\n");
        int i = 2;
        while (i < ((Thread)localObject2).getStackTrace().length)
        {
          StackTraceElement localStackTraceElement = localObject2.getStackTrace()[i];
          if (!localStackTraceElement.toString().contains("crashreport"))
          {
            ((StringBuilder)localObject1).append(localStackTraceElement.toString());
            ((StringBuilder)localObject1).append("\n");
          }
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localH5JavaScriptInterface.d = ((String)localObject1);
      localObject1 = new HashMap();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramWebViewInterface.getContentDescription());
      ((Map)localObject1).put("[WebView] ContentDescription", ((StringBuilder)localObject2).toString());
      localH5JavaScriptInterface.e = ((Map)localObject1);
      return localH5JavaScriptInterface;
    }
    return null;
  }
  
  @JavascriptInterface
  public void printLog(String paramString)
  {
    y.d("Log from js: %s", new Object[] { paramString });
  }
  
  @JavascriptInterface
  public void reportJSException(String paramString)
  {
    if (paramString == null)
    {
      y.d("Payload from JS is null.", new Object[0]);
      return;
    }
    Object localObject1 = ab.a(paramString.getBytes());
    Object localObject2 = this.b;
    if ((localObject2 != null) && (((String)localObject2).equals(localObject1)))
    {
      y.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
      return;
    }
    this.b = ((String)localObject1);
    y.d("Handling JS exception ...", new Object[0]);
    paramString = a(paramString);
    if (paramString == null)
    {
      y.d("Failed to parse payload.", new Object[0]);
      return;
    }
    localObject1 = new LinkedHashMap();
    localObject2 = new LinkedHashMap();
    String str = paramString.a;
    if (str != null) {
      ((Map)localObject2).put("[JS] projectRoot", str);
    }
    str = paramString.b;
    if (str != null) {
      ((Map)localObject2).put("[JS] context", str);
    }
    str = paramString.c;
    if (str != null) {
      ((Map)localObject2).put("[JS] url", str);
    }
    str = paramString.d;
    if (str != null) {
      ((Map)localObject2).put("[JS] userAgent", str);
    }
    str = paramString.i;
    if (str != null) {
      ((Map)localObject2).put("[JS] file", str);
    }
    long l = paramString.j;
    if (l != 0L) {
      ((Map)localObject2).put("[JS] lineNumber", Long.toString(l));
    }
    ((Map)localObject1).putAll((Map)localObject2);
    ((Map)localObject1).putAll(this.e);
    ((Map)localObject1).put("Java Stack", this.d);
    InnerApi.postH5CrashAsync(this.c, paramString.f, paramString.g, paramString.h, (Map)localObject1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface
 * JD-Core Version:    0.7.0.1
 */