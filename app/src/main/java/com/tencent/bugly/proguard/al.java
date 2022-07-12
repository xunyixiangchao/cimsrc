package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class al
  extends j
{
  private static ArrayList<ak> A;
  private static Map<String, String> B;
  private static Map<String, String> C;
  private static Map<String, String> v;
  private static aj w;
  private static ai x;
  private static ArrayList<ai> y;
  private static ArrayList<ai> z;
  public String a = "";
  public long b = 0L;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public Map<String, String> h = null;
  public String i = "";
  public aj j = null;
  public int k = 0;
  public String l = "";
  public String m = "";
  public ai n = null;
  public ArrayList<ai> o = null;
  public ArrayList<ai> p = null;
  public ArrayList<ak> q = null;
  public Map<String, String> r = null;
  public Map<String, String> s = null;
  private String t = "";
  private boolean u = true;
  
  static
  {
    Object localObject = new HashMap();
    v = (Map)localObject;
    ((Map)localObject).put("", "");
    w = new aj();
    x = new ai();
    y = new ArrayList();
    localObject = new ai();
    y.add(localObject);
    z = new ArrayList();
    localObject = new ai();
    z.add(localObject);
    A = new ArrayList();
    localObject = new ak();
    A.add(localObject);
    localObject = new HashMap();
    B = (Map)localObject;
    ((Map)localObject).put("", "");
    localObject = new HashMap();
    C = (Map)localObject;
    ((Map)localObject).put("", "");
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = paramh.b(5, false);
    this.g = paramh.b(6, false);
    this.h = ((Map)paramh.a(v, 7, false));
    this.i = paramh.b(8, false);
    this.j = ((aj)paramh.a(w, 9, false));
    this.k = paramh.a(this.k, 10, false);
    this.l = paramh.b(11, false);
    this.m = paramh.b(12, false);
    this.n = ((ai)paramh.a(x, 13, false));
    this.o = ((ArrayList)paramh.a(y, 14, false));
    this.p = ((ArrayList)paramh.a(z, 15, false));
    this.q = ((ArrayList)paramh.a(A, 16, false));
    this.r = ((Map)paramh.a(B, 17, false));
    this.s = ((Map)paramh.a(C, 18, false));
    this.t = paramh.b(19, false);
    this.u = paramh.a(20, false);
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
      parami.a((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      parami.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      parami.a((Map)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      parami.a((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      parami.a((j)localObject, 9);
    }
    parami.a(this.k, 10);
    localObject = this.l;
    if (localObject != null) {
      parami.a((String)localObject, 11);
    }
    localObject = this.m;
    if (localObject != null) {
      parami.a((String)localObject, 12);
    }
    localObject = this.n;
    if (localObject != null) {
      parami.a((j)localObject, 13);
    }
    localObject = this.o;
    if (localObject != null) {
      parami.a((Collection)localObject, 14);
    }
    localObject = this.p;
    if (localObject != null) {
      parami.a((Collection)localObject, 15);
    }
    localObject = this.q;
    if (localObject != null) {
      parami.a((Collection)localObject, 16);
    }
    localObject = this.r;
    if (localObject != null) {
      parami.a((Map)localObject, 17);
    }
    localObject = this.s;
    if (localObject != null) {
      parami.a((Map)localObject, 18);
    }
    localObject = this.t;
    if (localObject != null) {
      parami.a((String)localObject, 19);
    }
    parami.a(this.u, 20);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.al
 * JD-Core Version:    0.7.0.1
 */