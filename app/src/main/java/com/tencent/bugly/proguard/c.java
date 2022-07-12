package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class c
  extends a
{
  protected HashMap<String, byte[]> d = null;
  private HashMap<String, Object> e = new HashMap();
  private h f = new h();
  
  public <T> void a(String paramString, T paramT)
  {
    if (this.d != null)
    {
      if (paramString != null)
      {
        if (paramT != null)
        {
          if (!(paramT instanceof Set))
          {
            i locali = new i();
            locali.a(this.b);
            locali.a(paramT, 0);
            paramT = k.a(locali.a());
            this.d.put(paramString, paramT);
            return;
          }
          throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
      }
      throw new IllegalArgumentException("put key can not is null");
    }
    super.a(paramString, paramT);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    try
    {
      super.a(paramArrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      label6:
      break label6;
    }
    this.f.a(paramArrayOfByte);
    this.f.a(this.b);
    paramArrayOfByte = new HashMap(1);
    paramArrayOfByte.put("", new byte[0]);
    this.d = this.f.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    if (this.d != null)
    {
      i locali = new i(0);
      locali.a(this.b);
      locali.a(this.d, 0);
      return k.a(locali.a());
    }
    return super.a();
  }
  
  public final <T> T b(String paramString, T paramT)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (!((HashMap)localObject1).containsKey(paramString)) {
        return null;
      }
      if (!this.e.containsKey(paramString)) {}
    }
    do
    {
      return this.e.get(paramString);
      localObject1 = (byte[])this.d.get(paramString);
      try
      {
        this.f.a((byte[])localObject1);
        this.f.a(this.b);
        paramT = this.f.a(paramT, 0, true);
        if (paramT != null) {
          this.e.put(paramString, paramT);
        }
        return paramT;
      }
      catch (Exception paramString)
      {
        throw new b(paramString);
      }
      if (!this.a.containsKey(paramString)) {
        return null;
      }
    } while (this.e.containsKey(paramString));
    Object localObject2 = (HashMap)this.a.get(paramString);
    localObject1 = new byte[0];
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      ((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    try
    {
      this.f.a((byte[])localObject1);
      this.f.a(this.b);
      paramT = this.f.a(paramT, 0, true);
      this.e.put(paramString, paramT);
      return paramT;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public void c()
  {
    this.d = new HashMap();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.c
 * JD-Core Version:    0.7.0.1
 */