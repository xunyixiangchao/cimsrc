package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.concurrent.futures.c.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import s.g0;
import s.v0;
import s.v0.b;
import u.f;
import x0.h;

public final class u2
{
  private final Object a = new Object();
  private final Size b;
  private final boolean c;
  private final g0 d;
  final u7.a<Surface> e;
  private final c.a<Surface> f;
  private final u7.a<Void> g;
  private final c.a<Void> h;
  private final v0 i;
  private g j;
  private h k;
  private Executor l;
  
  public u2(final Size paramSize, final g0 paramg0, boolean paramBoolean)
  {
    this.b = paramSize;
    this.d = paramg0;
    this.c = paramBoolean;
    paramg0 = new StringBuilder();
    paramg0.append("SurfaceRequest[size: ");
    paramg0.append(paramSize);
    paramg0.append(", id: ");
    paramg0.append(hashCode());
    paramg0.append("]");
    paramg0 = paramg0.toString();
    Object localObject2 = new AtomicReference(null);
    Object localObject1 = androidx.concurrent.futures.c.a(new n2((AtomicReference)localObject2, paramg0));
    localObject2 = (c.a)h.g((c.a)((AtomicReference)localObject2).get());
    this.h = ((c.a)localObject2);
    AtomicReference localAtomicReference = new AtomicReference(null);
    u7.a locala = androidx.concurrent.futures.c.a(new o2(localAtomicReference, paramg0));
    this.g = locala;
    f.b(locala, new a((c.a)localObject2, (u7.a)localObject1), t.a.a());
    localObject1 = (c.a)h.g((c.a)localAtomicReference.get());
    localAtomicReference = new AtomicReference(null);
    localObject2 = androidx.concurrent.futures.c.a(new m2(localAtomicReference, paramg0));
    this.e = ((u7.a)localObject2);
    this.f = ((c.a)h.g((c.a)localAtomicReference.get()));
    paramSize = new b(paramSize, 34);
    this.i = paramSize;
    paramSize = paramSize.i();
    f.b((u7.a)localObject2, new c(paramSize, (c.a)localObject1, paramg0), t.a.a());
    paramSize.h(new r2(this), t.a.a());
  }
  
  @SuppressLint({"PairedRegistration"})
  public void i(Executor paramExecutor, Runnable paramRunnable)
  {
    this.h.a(paramRunnable, paramExecutor);
  }
  
  public g0 j()
  {
    return this.d;
  }
  
  public v0 k()
  {
    return this.i;
  }
  
  public Size l()
  {
    return this.b;
  }
  
  public boolean m()
  {
    return this.c;
  }
  
  public void v(final Surface paramSurface, Executor paramExecutor, final x0.a<f> parama)
  {
    if ((!this.f.c(paramSurface)) && (!this.e.isCancelled())) {
      h.i(this.e.isDone());
    }
    try
    {
      this.e.get();
      paramExecutor.execute(new s2(parama, paramSurface));
      return;
    }
    catch (InterruptedException|ExecutionException localInterruptedException)
    {
      label64:
      break label64;
    }
    paramExecutor.execute(new t2(parama, paramSurface));
    return;
    f.b(this.g, new d(parama, paramSurface), paramExecutor);
  }
  
  public void w(Executor paramExecutor, h paramh)
  {
    synchronized (this.a)
    {
      this.k = paramh;
      this.l = paramExecutor;
      g localg = this.j;
      if (localg != null) {
        paramExecutor.execute(new p2(paramh, localg));
      }
      return;
    }
  }
  
  public void x(g paramg)
  {
    synchronized (this.a)
    {
      this.j = paramg;
      h localh = this.k;
      Executor localExecutor = this.l;
      if ((localh != null) && (localExecutor != null)) {
        localExecutor.execute(new q2(localh, paramg));
      }
      return;
    }
  }
  
  public boolean y()
  {
    return this.f.f(new v0.b("Surface request will not complete."));
  }
  
  class a
    implements u.c<Void>
  {
    a(c.a parama, u7.a parama1) {}
    
    public void a(Throwable paramThrowable)
    {
      boolean bool;
      if ((paramThrowable instanceof u2.e)) {
        bool = this.b.cancel(false);
      } else {
        bool = this.a.c(null);
      }
      h.i(bool);
    }
    
    public void c(Void paramVoid)
    {
      h.i(this.a.c(null));
    }
  }
  
  class b
    extends v0
  {
    b(Size paramSize, int paramInt)
    {
      super(paramInt);
    }
    
    protected u7.a<Surface> n()
    {
      return u2.this.e;
    }
  }
  
  class c
    implements u.c<Surface>
  {
    c(u7.a parama, c.a parama1, String paramString) {}
    
    public void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof CancellationException))
      {
        c.a locala = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramg0);
        localStringBuilder.append(" cancelled.");
        h.i(locala.f(new u2.e(localStringBuilder.toString(), paramThrowable)));
        return;
      }
      this.b.c(null);
    }
    
    public void c(Surface paramSurface)
    {
      f.k(paramSize, this.b);
    }
  }
  
  class d
    implements u.c<Void>
  {
    d(x0.a parama, Surface paramSurface) {}
    
    public void a(Throwable paramThrowable)
    {
      boolean bool = paramThrowable instanceof u2.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Camera surface session should only fail with request cancellation. Instead failed due to:\n");
      localStringBuilder.append(paramThrowable);
      h.j(bool, localStringBuilder.toString());
      parama.a(u2.f.c(1, paramSurface));
    }
    
    public void c(Void paramVoid)
    {
      parama.a(u2.f.c(0, paramSurface));
    }
  }
  
  private static final class e
    extends RuntimeException
  {
    e(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract class f
  {
    static f c(int paramInt, Surface paramSurface)
    {
      return new i(paramInt, paramSurface);
    }
    
    public abstract int a();
    
    public abstract Surface b();
  }
  
  public static abstract class g
  {
    public static g d(Rect paramRect, int paramInt1, int paramInt2)
    {
      return new j(paramRect, paramInt1, paramInt2);
    }
    
    public abstract Rect a();
    
    public abstract int b();
    
    public abstract int c();
  }
  
  public static abstract interface h
  {
    public abstract void a(u2.g paramg);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.u2
 * JD-Core Version:    0.7.0.1
 */