package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import q2.a.a;
import q2.b;
import q2.f;

public class k
  implements ComponentCallbacks2, f
{
  private static final t2.i l = (t2.i)t2.i.o0(Bitmap.class).R();
  private static final t2.i m = (t2.i)t2.i.o0(o2.c.class).R();
  private static final t2.i n = (t2.i)((t2.i)t2.i.p0(d2.j.c).a0(h.d)).i0(true);
  protected final c a;
  protected final Context b;
  final q2.e c;
  private final q2.i d;
  private final q2.h e;
  private final q2.k f = new q2.k();
  private final Runnable g;
  private final q2.a h;
  private final CopyOnWriteArrayList<t2.h<Object>> i;
  private t2.i j;
  private boolean k;
  
  public k(c paramc, q2.e parame, q2.h paramh, Context paramContext)
  {
    this(paramc, parame, paramh, new q2.i(), paramc.g(), paramContext);
  }
  
  k(c paramc, q2.e parame, q2.h paramh, q2.i parami, b paramb, Context paramContext)
  {
    a locala = new a();
    this.g = locala;
    this.a = paramc;
    this.c = parame;
    this.e = paramh;
    this.d = parami;
    this.b = paramContext;
    paramh = paramb.a(paramContext.getApplicationContext(), new b(parami));
    this.h = paramh;
    if (x2.l.q()) {
      x2.l.u(locala);
    } else {
      parame.b(this);
    }
    parame.b(paramh);
    this.i = new CopyOnWriteArrayList(paramc.i().c());
    v(paramc.i().d());
    paramc.o(this);
  }
  
  private void y(u2.h<?> paramh)
  {
    boolean bool = x(paramh);
    t2.e locale = paramh.j();
    if ((!bool) && (!this.a.p(paramh)) && (locale != null))
    {
      paramh.l(null);
      locale.clear();
    }
  }
  
  public void a()
  {
    try
    {
      u();
      this.f.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    try
    {
      t();
      this.f.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public <ResourceType> j<ResourceType> e(Class<ResourceType> paramClass)
  {
    return new j(this.a, this, paramClass, this.b);
  }
  
  public j<Bitmap> h()
  {
    return e(Bitmap.class).p0(l);
  }
  
  public j<o2.c> m()
  {
    return e(o2.c.class).p0(m);
  }
  
  public void n(u2.h<?> paramh)
  {
    if (paramh == null) {
      return;
    }
    y(paramh);
  }
  
  List<t2.h<Object>> o()
  {
    return this.i;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy()
  {
    try
    {
      this.f.onDestroy();
      Iterator localIterator = this.f.h().iterator();
      while (localIterator.hasNext()) {
        n((u2.h)localIterator.next());
      }
      this.f.e();
      this.d.b();
      this.c.a(this);
      this.c.a(this.h);
      x2.l.v(this.g);
      this.a.s(this);
      return;
    }
    finally {}
  }
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if ((paramInt == 60) && (this.k)) {
      s();
    }
  }
  
  t2.i p()
  {
    try
    {
      t2.i locali = this.j;
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  <T> l<?, T> q(Class<T> paramClass)
  {
    return this.a.i().e(paramClass);
  }
  
  public void r()
  {
    try
    {
      this.d.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void s()
  {
    try
    {
      r();
      Iterator localIterator = this.e.a().iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).r();
      }
      return;
    }
    finally {}
  }
  
  public void t()
  {
    try
    {
      this.d.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(super.toString());
      ((StringBuilder)localObject1).append("{tracker=");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(", treeNode=");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("}");
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void u()
  {
    try
    {
      this.d.f();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void v(t2.i parami)
  {
    try
    {
      this.j = ((t2.i)((t2.i)parami.c()).b());
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
  
  void w(u2.h<?> paramh, t2.e parame)
  {
    try
    {
      this.f.m(paramh);
      this.d.g(parame);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  boolean x(u2.h<?> paramh)
  {
    try
    {
      t2.e locale = paramh.j();
      if (locale == null) {
        return true;
      }
      if (this.d.a(locale))
      {
        this.f.n(paramh);
        paramh.l(null);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      k localk = k.this;
      localk.c.b(localk);
    }
  }
  
  private class b
    implements a.a
  {
    private final q2.i a;
    
    b(q2.i parami)
    {
      this.a = parami;
    }
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        synchronized (k.this)
        {
          this.a.e();
          return;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.k
 * JD-Core Version:    0.7.0.1
 */