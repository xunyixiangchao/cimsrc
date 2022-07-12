package r;

import androidx.camera.camera2.internal.t;
import androidx.camera.camera2.internal.t.c;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c.a;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import m.b.a;
import s.s0.a;
import s.t1;

public final class g
{
  private boolean a = false;
  private boolean b = false;
  private final t c;
  final Executor d;
  final Object e = new Object();
  private b.a f = new b.a();
  c.a<Void> g;
  private final t.c h = new a(this);
  
  public g(t paramt, Executor paramExecutor)
  {
    this.c = paramt;
    this.d = paramExecutor;
  }
  
  private void h(j paramj)
  {
    synchronized (this.e)
    {
      Iterator localIterator = paramj.c().iterator();
      while (localIterator.hasNext())
      {
        s0.a locala = (s0.a)localIterator.next();
        this.f.a().G(locala, paramj.a(locala));
      }
      return;
    }
  }
  
  private void j()
  {
    synchronized (this.e)
    {
      this.f = new b.a();
      return;
    }
  }
  
  private void t(boolean paramBoolean)
  {
    if (this.a == paramBoolean) {
      return;
    }
    this.a = paramBoolean;
    if (paramBoolean)
    {
      if (this.b) {
        v();
      }
    }
    else
    {
      c.a locala = this.g;
      if (locala != null)
      {
        locala.f(new m.a("The camera control has became inactive."));
        this.g = null;
      }
    }
  }
  
  private void u(c.a<Void> parama)
  {
    this.b = true;
    c.a locala = this.g;
    if (locala == null) {
      locala = null;
    }
    this.g = parama;
    if (this.a) {
      v();
    }
    if (locala != null) {
      locala.f(new m.a("Camera2CameraControl was updated with new options."));
    }
  }
  
  private void v()
  {
    this.c.e0();
    this.b = false;
  }
  
  public u7.a<Void> g(j paramj)
  {
    h(paramj);
    return u.f.j(androidx.concurrent.futures.c.a(new c(this)));
  }
  
  public u7.a<Void> i()
  {
    j();
    return u.f.j(androidx.concurrent.futures.c.a(new b(this)));
  }
  
  public m.b k()
  {
    synchronized (this.e)
    {
      if (this.g != null) {
        this.f.a().G(m.b.G, Integer.valueOf(this.g.hashCode()));
      }
      m.b localb = this.f.c();
      return localb;
    }
  }
  
  public t.c l()
  {
    return this.h;
  }
  
  public void s(boolean paramBoolean)
  {
    this.d.execute(new f(this, paramBoolean));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r.g
 * JD-Core Version:    0.7.0.1
 */