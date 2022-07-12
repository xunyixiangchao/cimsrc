package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.h.a;
import java.util.Comparator;
import org.json.JSONObject;

public abstract class a
{
  public static Comparator c = new b();
  protected a a;
  protected com.baidu.b.e.a.a b;
  private final String d;
  private long e;
  
  public a(String paramString, long paramLong)
  {
    this.d = paramString;
    this.e = paramLong;
  }
  
  public abstract e a(String paramString, d paramd);
  
  public String a()
  {
    return this.d;
  }
  
  public final void a(a parama)
  {
    this.a = parama;
    this.b = parama.b.b().a("cs");
  }
  
  public abstract void a(c paramc);
  
  public long b()
  {
    return this.e;
  }
  
  public static class a
  {
    public Context a;
    public com.baidu.b.e.a b;
  }
  
  public static abstract class b
  {
    private com.baidu.b.e.a.a a;
    private String b;
    private String c;
    private boolean d = true;
    
    public b(com.baidu.b.e.a.a parama, String paramString)
    {
      this.a = parama;
      this.b = paramString;
      parama = new StringBuilder();
      parama.append("target-pkg-");
      parama.append(Base64.encodeToString(paramString.getBytes(), 3));
      this.c = parama.toString();
    }
    
    public abstract void a(JSONObject paramJSONObject);
    
    public void a(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
    
    public boolean a()
    {
      String str = this.a.a(this.c, true);
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        a(new JSONObject(str));
        a(false);
        return true;
      }
      catch (Exception localException) {}
      return false;
      return false;
    }
    
    public abstract void b(JSONObject paramJSONObject);
    
    public boolean b()
    {
      if (this.d) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        b(localJSONObject);
        this.a.a(this.c, localJSONObject.toString(), true);
        a(false);
        return true;
      }
      catch (Exception localException) {}
      return false;
      return false;
    }
  }
  
  public static class c {}
  
  public static class d
  {
    public boolean a;
  }
  
  public static class e
  {
    public h.a a;
    public int b;
    public Exception c;
    
    public e(int paramInt, h.a parama, Exception paramException)
    {
      this.b = paramInt;
      this.a = parama;
      this.c = paramException;
    }
    
    public static e a(int paramInt)
    {
      return new e(paramInt, null, null);
    }
    
    public static e a(h.a parama)
    {
      return new e(0, parama, null);
    }
    
    public static e b()
    {
      return new e(-1, null, null);
    }
    
    public boolean a()
    {
      return this.b == 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.b.a
 * JD-Core Version:    0.7.0.1
 */