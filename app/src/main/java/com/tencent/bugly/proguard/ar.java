package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class ar
  extends j
{
  private static Map<String, String> i;
  public long a = 0L;
  public byte b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public Map<String, String> f = null;
  public boolean g = true;
  private String h = "";
  
  static
  {
    HashMap localHashMap = new HashMap();
    i = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = ((Map)paramh.a(i, 5, false));
    this.h = paramh.b(6, false);
    this.g = paramh.a(7, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      parami.a((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      parami.a((Map)localObject, 5);
    }
    localObject = this.h;
    if (localObject != null) {
      parami.a((String)localObject, 6);
    }
    parami.a(this.g, 7);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ar
 * JD-Core Version:    0.7.0.1
 */