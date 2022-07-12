package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class aq
  extends j
  implements Cloneable
{
  private static ap m;
  private static Map<String, String> n;
  public boolean a = true;
  public boolean b = true;
  public boolean c = true;
  public String d = "";
  public String e = "";
  public ap f = null;
  public Map<String, String> g = null;
  public long h = 0L;
  public int i = 0;
  private String j = "";
  private String k = "";
  private int l = 0;
  
  static
  {
    m = new ap();
    HashMap localHashMap = new HashMap();
    n = localHashMap;
    localHashMap.put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(0, true);
    this.b = paramh.a(1, true);
    this.c = paramh.a(2, true);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = ((ap)paramh.a(m, 5, false));
    this.g = ((Map)paramh.a(n, 6, false));
    this.h = paramh.a(this.h, 7, false);
    this.j = paramh.b(8, false);
    this.k = paramh.b(9, false);
    this.l = paramh.a(this.l, 10, false);
    this.i = paramh.a(this.i, 11, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    Object localObject = this.d;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      parami.a((j)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      parami.a((Map)localObject, 6);
    }
    parami.a(this.h, 7);
    localObject = this.j;
    if (localObject != null) {
      parami.a((String)localObject, 8);
    }
    localObject = this.k;
    if (localObject != null) {
      parami.a((String)localObject, 9);
    }
    parami.a(this.l, 10);
    parami.a(this.i, 11);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new z(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "enable");
    paramStringBuilder.a(this.b, "enableUserInfo");
    paramStringBuilder.a(this.c, "enableQuery");
    paramStringBuilder.a(this.d, "url");
    paramStringBuilder.a(this.e, "expUrl");
    paramStringBuilder.a(this.f, "security");
    paramStringBuilder.a(this.g, "valueMap");
    paramStringBuilder.a(this.h, "strategylastUpdateTime");
    paramStringBuilder.a(this.j, "httpsUrl");
    paramStringBuilder.a(this.k, "httpsExpUrl");
    paramStringBuilder.a(this.l, "eventRecordCount");
    paramStringBuilder.a(this.i, "eventTimeInterval");
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (o) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (aq)paramObject;
    return (k.a(this.a, paramObject.a)) && (k.a(this.b, paramObject.b)) && (k.a(this.c, paramObject.c)) && (k.a(this.d, paramObject.d)) && (k.a(this.e, paramObject.e)) && (k.a(this.f, paramObject.f)) && (k.a(this.g, paramObject.g)) && (k.a(this.h, paramObject.h)) && (k.a(this.j, paramObject.j)) && (k.a(this.k, paramObject.k)) && (k.a(this.l, paramObject.l)) && (k.a(this.i, paramObject.i));
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.aq
 * JD-Core Version:    0.7.0.1
 */