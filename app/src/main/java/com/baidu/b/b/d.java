package com.baidu.b.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.baidu.b.f.b;
import com.baidu.b.h;
import com.baidu.b.h.a;
import java.io.File;
import org.json.JSONObject;

public class d
  extends a
{
  com.baidu.b.e.a.a d;
  private a e = new a();
  
  public d()
  {
    super("isc", 8000000L);
  }
  
  public a.e a(String paramString, a.d paramd)
  {
    Object localObject1 = this.a.a.getPackageManager();
    Object localObject2 = null;
    try
    {
      localObject1 = ((PackageManager)localObject1).getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label24:
      Object localObject3;
      break label24;
    }
    localObject1 = null;
    if (localObject1 == null) {
      return a.e.a(-2);
    }
    if (paramd.a)
    {
      localObject3 = new b(paramString);
      ((a.b)localObject3).a();
      localObject2 = localObject3;
      if (paramString.equals(((b)localObject3).c()))
      {
        localObject2 = localObject3;
        if (((PackageInfo)localObject1).lastUpdateTime != ((b)localObject3).e()) {}
      }
    }
    for (paramString = ((b)localObject3).d();; paramString = ((a)localObject3).b())
    {
      return a.e.a(paramString);
      localObject3 = new a();
      if (!((a)localObject3).a((PackageInfo)localObject1)) {
        return a.e.a(-2);
      }
      if ((paramd.a) && (localObject2 != null))
      {
        localObject2.a((a)localObject3);
        localObject2.a(System.currentTimeMillis());
        localObject2.c(((PackageInfo)localObject1).lastUpdateTime);
        localObject2.a(paramString);
        localObject2.b();
      }
    }
  }
  
  public void a(a.c paramc)
  {
    this.d = this.b.a("isc");
  }
  
  class a
  {
    private b b = new b();
    private long c;
    private h.a d;
    private boolean e;
    private boolean f = true;
    private int g;
    
    a() {}
    
    private boolean a(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        paramString = new JSONObject(paramString);
        this.c = paramString.getLong("pub_lst_ts");
        this.d = h.a(paramString.getString("pub_info"));
        this.g = paramString.getInt("d_form_ver");
        this.e = false;
        return true;
      }
      catch (Exception paramString) {}
      return false;
      return false;
    }
    
    public long a()
    {
      return this.c;
    }
    
    public boolean a(PackageInfo paramPackageInfo)
    {
      paramPackageInfo = d.this.d.a(new File(paramPackageInfo.applicationInfo.dataDir)).a("pub.dat", true);
      this.f = false;
      return a(paramPackageInfo);
    }
    
    public h.a b()
    {
      return this.d;
    }
  }
  
  class b
    extends a.b
  {
    private int b;
    private String c;
    private long d;
    private long e;
    private long f;
    private h.a g;
    
    public b(String paramString)
    {
      super(paramString);
    }
    
    public void a(d.a parama)
    {
      a(parama.b());
      b(parama.a());
    }
    
    public void a(JSONObject paramJSONObject)
    {
      this.c = paramJSONObject.getString("pkg");
      this.e = paramJSONObject.getInt("tar_pkg_lst_pub_ts");
      this.d = paramJSONObject.getLong("last_fe_ts");
      this.g = h.a(paramJSONObject.getString("info"));
      this.f = paramJSONObject.getLong("tar_pkg_lst_up_ts");
      this.b = paramJSONObject.getInt("d_form_ver");
    }
    
    public boolean a(long paramLong)
    {
      if (this.d != paramLong)
      {
        this.d = paramLong;
        a(true);
        return true;
      }
      return false;
    }
    
    public boolean a(h.a parama)
    {
      if (!parama.equals(this.g))
      {
        this.g = parama;
        a(true);
        return true;
      }
      return false;
    }
    
    public boolean a(String paramString)
    {
      if (!paramString.equals(this.c))
      {
        this.c = paramString;
        a(true);
        return true;
      }
      return false;
    }
    
    public void b(JSONObject paramJSONObject)
    {
      paramJSONObject.put("pkg", this.c);
      paramJSONObject.put("last_fe_ts", this.d);
      paramJSONObject.put("tar_pkg_lst_pub_ts", this.e);
      paramJSONObject.put("info", this.g.a());
      paramJSONObject.put("tar_pkg_lst_up_ts", this.f);
      paramJSONObject.put("d_form_ver", 1);
    }
    
    public boolean b(long paramLong)
    {
      if (this.e != paramLong)
      {
        this.e = paramLong;
        a(true);
        return true;
      }
      return false;
    }
    
    public String c()
    {
      return this.c;
    }
    
    public boolean c(long paramLong)
    {
      if (this.f != paramLong)
      {
        this.f = paramLong;
        a(true);
        return true;
      }
      return false;
    }
    
    public h.a d()
    {
      return this.g;
    }
    
    public long e()
    {
      return this.f;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.b.d
 * JD-Core Version:    0.7.0.1
 */