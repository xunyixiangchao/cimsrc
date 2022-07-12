package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.baidu.location.e.b;
import com.baidu.location.e.f;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class q
{
  private b a;
  private long b = 0L;
  private long c = 0L;
  
  public static q a()
  {
    return a.a();
  }
  
  @TargetApi(24)
  public void a(GnssNavigationMessage paramGnssNavigationMessage, long paramLong)
  {
    l.a().a(paramGnssNavigationMessage, paramLong);
    this.b = System.currentTimeMillis();
    this.c = paramLong;
  }
  
  public void b()
  {
    if ((this.b != 0L) && (Math.abs(System.currentTimeMillis() - this.b) < 20000L))
    {
      if (this.a == null) {
        this.a = new b();
      }
      Object localObject = this.a;
      if ((localObject != null) && (!((b)localObject).b()))
      {
        localObject = l.a().b();
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          int i = 0;
          Iterator localIterator = ((ArrayList)localObject).iterator();
          while (localIterator.hasNext())
          {
            localStringBuffer.append((String)localIterator.next());
            int j = i + 1;
            i = j;
            if (j != ((ArrayList)localObject).size())
            {
              localStringBuffer.append(";");
              i = j;
            }
          }
          this.a.a(localStringBuffer.toString(), this.c);
        }
      }
    }
  }
  
  private static class a
  {
    private static q a = new q();
  }
  
  class b
    extends f
  {
    public boolean a = false;
    public long b = 0L;
    private boolean d = false;
    private String e = null;
    
    public b()
    {
      this.j = new HashMap();
    }
    
    public void a()
    {
      String str1 = b.a().b();
      Object localObject = str1;
      if (str1 != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append("&gnsst=");
        ((StringBuilder)localObject).append(this.b);
        localObject = ((StringBuilder)localObject).toString();
      }
      localObject = i.a().a((String)localObject);
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      str1 = "null";
      if (!bool) {
        localObject = ((String)localObject).trim().replaceAll("\r|\n", "");
      } else {
        localObject = "null";
      }
      String str2 = i.a().a(this.e);
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.trim().replaceAll("\r|\n", "");
      }
      try
      {
        this.j.put("info", URLEncoder.encode((String)localObject, "utf-8"));
        this.j.put("enl", URLEncoder.encode(str1, "utf-8"));
        return;
      }
      catch (Exception localException) {}
    }
    
    public void a(String paramString, long paramLong)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      this.e = paramString;
      this.b = paramLong;
      paramString = p.a().c();
      if (paramString != null)
      {
        a(paramString, "https://ofloc.map.baidu.com/locnu");
        return;
      }
      b("https://ofloc.map.baidu.com/locnu");
    }
    
    public void a(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.i != null)) {}
      try
      {
        new JSONObject(this.i);
        this.a = true;
        label28:
        Map localMap = this.j;
        if (localMap != null) {
          localMap.clear();
        }
        this.d = false;
        return;
      }
      finally
      {
        break label28;
      }
    }
    
    public boolean b()
    {
      return this.d;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.q
 * JD-Core Version:    0.7.0.1
 */