package androidx.camera.view;

import androidx.camera.core.n1;
import androidx.concurrent.futures.c.a;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import s.e0;
import s.g0.a;
import s.t;
import s.w1.a;
import u.f;

final class e
  implements w1.a<g0.a>
{
  private final e0 a;
  private final androidx.lifecycle.r<PreviewView.g> b;
  private PreviewView.g c;
  private final k d;
  u7.a<Void> e;
  private boolean f = false;
  
  e(e0 parame0, androidx.lifecycle.r<PreviewView.g> paramr, k paramk)
  {
    this.a = parame0;
    this.b = paramr;
    this.d = paramk;
    try
    {
      this.c = ((PreviewView.g)paramr.f());
      return;
    }
    finally {}
  }
  
  private void f()
  {
    u7.a locala = this.e;
    if (locala != null)
    {
      locala.cancel(false);
      this.e = null;
    }
  }
  
  private void l(final androidx.camera.core.r paramr)
  {
    m(PreviewView.g.a);
    final ArrayList localArrayList = new ArrayList();
    u.d locald = u.d.a(n(paramr, localArrayList)).e(new d(this), t.a.a()).d(new c(this), t.a.a());
    this.e = locald;
    f.b(locald, new a(localArrayList, paramr), t.a.a());
  }
  
  private u7.a<Void> n(androidx.camera.core.r paramr, List<s.k> paramList)
  {
    return androidx.concurrent.futures.c.a(new b(this, paramr, paramList));
  }
  
  public void a(Throwable paramThrowable)
  {
    g();
    m(PreviewView.g.a);
  }
  
  void g()
  {
    f();
  }
  
  public void k(g0.a parama)
  {
    if ((parama != g0.a.e) && (parama != g0.a.f) && (parama != g0.a.g) && (parama != g0.a.h))
    {
      if (((parama == g0.a.c) || (parama == g0.a.d) || (parama == g0.a.b)) && (!this.f))
      {
        l(this.a);
        this.f = true;
      }
    }
    else
    {
      m(PreviewView.g.a);
      if (this.f)
      {
        this.f = false;
        f();
      }
    }
  }
  
  void m(PreviewView.g paramg)
  {
    try
    {
      if (this.c.equals(paramg)) {
        return;
      }
      this.c = paramg;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Update Preview stream state to ");
      localStringBuilder.append(paramg);
      n1.a("StreamStateObserver", localStringBuilder.toString());
      this.b.m(paramg);
      return;
    }
    finally {}
  }
  
  class a
    implements u.c<Void>
  {
    a(List paramList, androidx.camera.core.r paramr) {}
    
    public void a(Throwable paramThrowable)
    {
      e.this.e = null;
      if (!localArrayList.isEmpty())
      {
        paramThrowable = localArrayList.iterator();
        while (paramThrowable.hasNext())
        {
          s.k localk = (s.k)paramThrowable.next();
          ((e0)paramr).g(localk);
        }
        localArrayList.clear();
      }
    }
    
    public void c(Void paramVoid)
    {
      e.this.e = null;
    }
  }
  
  class b
    extends s.k
  {
    b(c.a parama, androidx.camera.core.r paramr) {}
    
    public void b(t paramt)
    {
      this.a.c(null);
      ((e0)this.b).g(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.e
 * JD-Core Version:    0.7.0.1
 */