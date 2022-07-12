package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends j
{
  private static byte[] y;
  private static Map<String, String> z;
  public int a = 0;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public int g = 0;
  public byte[] h = null;
  public String i = "";
  public String j = "";
  public Map<String, String> k = null;
  public String l = "";
  public long m = 0L;
  public String n = "";
  public String o = "";
  public String p = "";
  public long q = 0L;
  public String r = "";
  public String s = "";
  public String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  private String x = "";
  
  static
  {
    Object localObject = new byte[1];
    y = (byte[])localObject;
    localObject[0] = 0;
    localObject = new HashMap();
    z = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.b(4, false);
    this.f = paramh.b(5, true);
    this.g = paramh.a(this.g, 6, true);
    this.h = paramh.c(7, true);
    this.i = paramh.b(8, false);
    this.j = paramh.b(9, false);
    this.k = ((Map)paramh.a(z, 10, false));
    this.l = paramh.b(11, false);
    this.m = paramh.a(this.m, 12, false);
    this.n = paramh.b(13, false);
    this.o = paramh.b(14, false);
    this.p = paramh.b(15, false);
    this.q = paramh.a(this.q, 16, false);
    this.u = paramh.b(17, false);
    this.r = paramh.b(18, false);
    this.v = paramh.b(19, false);
    this.w = paramh.b(20, false);
    this.s = paramh.b(21, false);
    this.t = paramh.b(22, false);
    this.x = paramh.b(23, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    Object localObject = this.e;
    if (localObject != null) {
      parami.a((String)localObject, 4);
    }
    parami.a(this.f, 5);
    parami.a(this.g, 6);
    parami.a(this.h, 7);
    localObject = this.i;
    if (localObject != null) {
      parami.a((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      parami.a((String)localObject, 9);
    }
    localObject = this.k;
    if (localObject != null) {
      parami.a((Map)localObject, 10);
    }
    localObject = this.l;
    if (localObject != null) {
      parami.a((String)localObject, 11);
    }
    parami.a(this.m, 12);
    localObject = this.n;
    if (localObject != null) {
      parami.a((String)localObject, 13);
    }
    localObject = this.o;
    if (localObject != null) {
      parami.a((String)localObject, 14);
    }
    localObject = this.p;
    if (localObject != null) {
      parami.a((String)localObject, 15);
    }
    parami.a(this.q, 16);
    localObject = this.u;
    if (localObject != null) {
      parami.a((String)localObject, 17);
    }
    localObject = this.r;
    if (localObject != null) {
      parami.a((String)localObject, 18);
    }
    localObject = this.v;
    if (localObject != null) {
      parami.a((String)localObject, 19);
    }
    localObject = this.w;
    if (localObject != null) {
      parami.a((String)localObject, 20);
    }
    localObject = this.s;
    if (localObject != null) {
      parami.a((String)localObject, 21);
    }
    localObject = this.t;
    if (localObject != null) {
      parami.a((String)localObject, 22);
    }
    localObject = this.x;
    if (localObject != null) {
      parami.a((String)localObject, 23);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.an
 * JD-Core Version:    0.7.0.1
 */