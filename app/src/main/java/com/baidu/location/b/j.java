package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class j
{
  private static long j = 12000L;
  public e a = new e();
  private Context b = null;
  private WebView c;
  private LocationClient d = null;
  private a e = null;
  private List<b> f = null;
  private boolean g = false;
  private long h = 0L;
  private BDLocation i = null;
  private f k = null;
  private boolean l = false;
  
  public static j a()
  {
    return c.a();
  }
  
  @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
  private void a(WebView paramWebView)
  {
    paramWebView.addJavascriptInterface(new d(null), "BaiduLocAssistant");
  }
  
  public void a(Context paramContext, WebView paramWebView, LocationClient paramLocationClient)
  {
    if (this.g) {
      return;
    }
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
      return;
    }
    this.b = paramContext;
    this.c = paramWebView;
    this.d = paramLocationClient;
    paramContext = new a(Looper.getMainLooper());
    this.e = paramContext;
    paramContext.obtainMessage(3).sendToTarget();
    paramContext = paramWebView.getSettings();
    paramContext.setJavaScriptEnabled(true);
    paramContext.setAllowFileAccess(false);
    paramContext.setSavePassword(false);
    this.c.removeJavascriptInterface("searchBoxJavaBridge_");
    this.c.removeJavascriptInterface("accessibility");
    this.c.removeJavascriptInterface("accessibilityTraversal");
    a(this.c);
    this.g = true;
  }
  
  public void b()
  {
    if (!this.g) {
      return;
    }
    this.e.obtainMessage(4).sendToTarget();
    this.g = false;
  }
  
  private class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    private String a(BDLocation paramBDLocation)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("latitude", paramBDLocation.getLatitude());
        localJSONObject.put("longitude", paramBDLocation.getLongitude());
        localJSONObject.put("radius", paramBDLocation.getRadius());
        localJSONObject.put("errorcode", 1);
        if (paramBDLocation.hasAltitude()) {
          localJSONObject.put("altitude", paramBDLocation.getAltitude());
        }
        if (paramBDLocation.hasSpeed()) {
          localJSONObject.put("speed", paramBDLocation.getSpeed() / 3.6F);
        }
        if (paramBDLocation.getLocType() == 61) {
          localJSONObject.put("direction", paramBDLocation.getDirection());
        }
        if (paramBDLocation.getBuildingName() != null) {
          localJSONObject.put("buildingname", paramBDLocation.getBuildingName());
        }
        if (paramBDLocation.getBuildingID() != null) {
          localJSONObject.put("buildingid", paramBDLocation.getBuildingID());
        }
        if (paramBDLocation.getFloor() != null) {
          localJSONObject.put("floor", paramBDLocation.getFloor());
        }
        paramBDLocation = localJSONObject.toString();
        return paramBDLocation;
      }
      catch (Exception paramBDLocation)
      {
        label172:
        break label172;
      }
      return null;
    }
    
    private void a(String paramString)
    {
      if (j.c(j.this))
      {
        j.b(j.this).removeCallbacks(j.d(j.this));
        j.a(j.this, false);
      }
      Iterator localIterator;
      if ((j.e(j.this) != null) && (j.e(j.this).size() > 0)) {
        localIterator = j.e(j.this).iterator();
      }
      try
      {
        while (localIterator.hasNext())
        {
          Object localObject = (j.b)localIterator.next();
          if (((j.b)localObject).b() != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("javascript:");
            localStringBuilder.append(((j.b)localObject).b());
            localStringBuilder.append("('");
            localStringBuilder.append(paramString);
            localStringBuilder.append("')");
            localObject = localStringBuilder.toString();
            j.f(j.this).loadUrl((String)localObject);
          }
          localIterator.remove();
        }
        return;
      }
      catch (Exception paramString) {}
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      Object localObject2 = null;
      Object localObject1 = null;
      switch (i)
      {
      default: 
        return;
      }
      try
      {
        paramMessage = new JSONObject();
        paramMessage.put("errorcode", 2);
        paramMessage = paramMessage.toString();
        if (paramMessage == null) {}
      }
      catch (Exception paramMessage)
      {
        try
        {
          paramMessage = new JSONObject();
          paramMessage.put("errorcode", 0);
          paramMessage = paramMessage.toString();
          if (paramMessage != null)
          {
            a(paramMessage);
            return;
            if (j.e(j.this) != null)
            {
              j.e(j.this).clear();
              j.a(j.this, null);
            }
            j.g(j.this).unRegisterLocationListener(j.this.a);
            j.a(j.this, 0L);
            j.a(j.this, null);
            if ((j.d(j.this) != null) && (j.c(j.this))) {
              j.b(j.this).removeCallbacks(j.d(j.this));
            }
            j.a(j.this, false);
            j.f(j.this).removeJavascriptInterface("BaiduLocAssistant");
            return;
            if (j.e(j.this) == null) {
              j.a(j.this, new ArrayList());
            } else {
              j.e(j.this).clear();
            }
            j.g(j.this).registerLocationListener(j.this.a);
            return;
            a(a((BDLocation)paramMessage.obj));
            return;
            paramMessage = (j.b)paramMessage.obj;
            if (j.e(j.this) != null) {
              j.e(j.this).add(paramMessage);
            }
            if (j.g(j.this) != null)
            {
              if (j.g(j.this).requestLocation() != 0)
              {
                long l1 = System.currentTimeMillis();
                long l2 = j.h(j.this);
                if ((j.i(j.this) != null) && (l1 - l2 <= 10000L))
                {
                  paramMessage = j.b(j.this).obtainMessage(2);
                  paramMessage.obj = j.i(j.this);
                  paramMessage.sendToTarget();
                  i = 0;
                  break label434;
                }
              }
              i = 1;
              label434:
              if (i != 0)
              {
                if (j.c(j.this))
                {
                  j.b(j.this).removeCallbacks(j.d(j.this));
                  j.a(j.this, false);
                }
                if (j.d(j.this) == null)
                {
                  paramMessage = j.this;
                  j.a(paramMessage, new j.f(paramMessage, null));
                }
                j.b(j.this).postDelayed(j.d(j.this), j.c());
                j.a(j.this, true);
              }
            }
          }
          return;
          paramMessage = paramMessage;
          paramMessage = localObject1;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            paramMessage = localObject2;
          }
        }
      }
    }
  }
  
  private class b
  {
    private String b = null;
    private String c = null;
    private long d = 0L;
    
    b(String paramString)
    {
      try
      {
        this$1 = new JSONObject(paramString);
        if (j.this.has("action")) {
          this.b = j.this.getString("action");
        }
        if (j.this.has("callback")) {
          this.c = j.this.getString("callback");
        }
        if (j.this.has("timeout"))
        {
          long l = j.this.getLong("timeout");
          if (l >= 1000L) {
            j.a(l);
          }
        }
        this.d = System.currentTimeMillis();
        return;
      }
      catch (Exception this$1)
      {
        label108:
        break label108;
      }
      this.b = null;
      this.c = null;
    }
    
    public String a()
    {
      return this.b;
    }
    
    public String b()
    {
      return this.c;
    }
  }
  
  private static final class c
  {
    private static final j a = new j(null);
  }
  
  private class d
  {
    private d() {}
    
    @JavascriptInterface
    public void sendMessage(String paramString)
    {
      if ((paramString != null) && (j.a(j.this)))
      {
        paramString = new j.b(j.this, paramString);
        if ((paramString.a() != null) && (paramString.a().equals("requestLoc")) && (j.b(j.this) != null))
        {
          Message localMessage = j.b(j.this).obtainMessage(1);
          localMessage.obj = paramString;
          localMessage.sendToTarget();
        }
      }
    }
    
    @JavascriptInterface
    public void showLog(String paramString) {}
  }
  
  public class e
    extends BDAbstractLocationListener
  {
    public e() {}
    
    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      if ((j.a(j.this)) && (paramBDLocation != null))
      {
        Object localObject = new BDLocation(paramBDLocation);
        int i = ((BDLocation)localObject).getLocType();
        String str = ((BDLocation)localObject).getCoorType();
        if ((i != 61) && (i != 161) && (i != 66))
        {
          paramBDLocation = j.b(j.this).obtainMessage(5);
        }
        else
        {
          paramBDLocation = (BDLocation)localObject;
          if (str != null) {
            if (str.equals("gcj02"))
            {
              paramBDLocation = LocationClient.getBDLocationInCoorType((BDLocation)localObject, "gcj2wgs");
            }
            else
            {
              if (str.equals("bd09")) {}
              for (paramBDLocation = "bd092gcj";; paramBDLocation = "bd09ll2gcj")
              {
                paramBDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType((BDLocation)localObject, paramBDLocation), "gcj2wgs");
                break;
                paramBDLocation = (BDLocation)localObject;
                if (!str.equals("bd09ll")) {
                  break;
                }
              }
            }
          }
          j.a(j.this, System.currentTimeMillis());
          j.a(j.this, new BDLocation(paramBDLocation));
          localObject = j.b(j.this).obtainMessage(2);
          ((Message)localObject).obj = paramBDLocation;
          paramBDLocation = (BDLocation)localObject;
        }
        paramBDLocation.sendToTarget();
      }
    }
  }
  
  private class f
    implements Runnable
  {
    private f() {}
    
    public void run()
    {
      j.a(j.this, false);
      j.b(j.this).obtainMessage(6).sendToTarget();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.j
 * JD-Core Version:    0.7.0.1
 */