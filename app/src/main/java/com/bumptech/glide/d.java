package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.h.b;
import d2.k;
import e2.e;
import f2.a.a;
import f2.g;
import f2.j.a;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class d
{
  private final Map<Class<?>, l<?, ?>> a = new g0.a();
  private final f.a b = new f.a();
  private k c;
  private e2.d d;
  private e2.b e;
  private f2.i f;
  private g2.a g;
  private g2.a h;
  private a.a i;
  private f2.j j;
  private q2.b k;
  private int l = 4;
  private c.a m = new a();
  private h.b n;
  private g2.a o;
  private boolean p;
  private List<t2.h<Object>> q;
  
  c a(Context paramContext)
  {
    if (this.g == null) {
      this.g = g2.a.g();
    }
    if (this.h == null) {
      this.h = g2.a.e();
    }
    if (this.o == null) {
      this.o = g2.a.c();
    }
    if (this.j == null) {
      this.j = new j.a(paramContext).a();
    }
    if (this.k == null) {
      this.k = new q2.d();
    }
    if (this.d == null)
    {
      int i1 = this.j.b();
      if (i1 > 0) {
        this.d = new e2.j(i1);
      } else {
        this.d = new e();
      }
    }
    if (this.e == null) {
      this.e = new e2.i(this.j.a());
    }
    if (this.f == null) {
      this.f = new f2.h(this.j.d());
    }
    if (this.i == null) {
      this.i = new g(paramContext);
    }
    if (this.c == null) {
      this.c = new k(this.f, this.i, this.h, this.g, g2.a.h(), this.o, this.p);
    }
    Object localObject = this.q;
    if (localObject == null) {
      localObject = Collections.emptyList();
    } else {
      localObject = Collections.unmodifiableList((List)localObject);
    }
    this.q = ((List)localObject);
    localObject = this.b.b();
    com.bumptech.glide.manager.h localh = new com.bumptech.glide.manager.h(this.n, (f)localObject);
    return new c(paramContext, this.c, this.f, this.d, this.e, localh, this.k, this.l, this.m, this.a, this.q, (f)localObject);
  }
  
  public d b(a.a parama)
  {
    this.i = parama;
    return this;
  }
  
  public d c(int paramInt)
  {
    if ((paramInt >= 2) && (paramInt <= 6))
    {
      this.l = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
  }
  
  void d(h.b paramb)
  {
    this.n = paramb;
  }
  
  class a
    implements c.a
  {
    a() {}
    
    public t2.i build()
    {
      return new t2.i();
    }
  }
  
  static final class b {}
  
  static final class c {}
  
  public static final class d {}
  
  public static final class e {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.d
 * JD-Core Version:    0.7.0.1
 */