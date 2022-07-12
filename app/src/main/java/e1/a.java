package e1;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import g0.g;
import java.util.ArrayList;

class a
{
  public static final ThreadLocal<a> g = new ThreadLocal();
  private final g<b, Long> a = new g();
  final ArrayList<b> b = new ArrayList();
  private final a c = new a();
  private c d;
  long e = 0L;
  private boolean f = false;
  
  private void b()
  {
    if (this.f)
    {
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        if (this.b.get(i) == null) {
          this.b.remove(i);
        }
        i -= 1;
      }
      this.f = false;
    }
  }
  
  public static a d()
  {
    ThreadLocal localThreadLocal = g;
    if (localThreadLocal.get() == null) {
      localThreadLocal.set(new a());
    }
    return (a)localThreadLocal.get();
  }
  
  private boolean f(b paramb, long paramLong)
  {
    Long localLong = (Long)this.a.get(paramb);
    if (localLong == null) {
      return true;
    }
    if (localLong.longValue() < paramLong)
    {
      this.a.remove(paramb);
      return true;
    }
    return false;
  }
  
  public void a(b paramb, long paramLong)
  {
    if (this.b.size() == 0) {
      e().a();
    }
    if (!this.b.contains(paramb)) {
      this.b.add(paramb);
    }
    if (paramLong > 0L) {
      this.a.put(paramb, Long.valueOf(SystemClock.uptimeMillis() + paramLong));
    }
  }
  
  void c(long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    int i = 0;
    while (i < this.b.size())
    {
      b localb = (b)this.b.get(i);
      if ((localb != null) && (f(localb, l))) {
        localb.a(paramLong);
      }
      i += 1;
    }
    b();
  }
  
  c e()
  {
    if (this.d == null) {
      this.d = new d(this.c);
    }
    return this.d;
  }
  
  public void g(b paramb)
  {
    this.a.remove(paramb);
    int i = this.b.indexOf(paramb);
    if (i >= 0)
    {
      this.b.set(i, null);
      this.f = true;
    }
  }
  
  class a
  {
    a() {}
    
    void a()
    {
      a.this.e = SystemClock.uptimeMillis();
      a locala = a.this;
      locala.c(locala.e);
      if (a.this.b.size() > 0) {
        a.this.e().a();
      }
    }
  }
  
  static abstract interface b
  {
    public abstract boolean a(long paramLong);
  }
  
  static abstract class c
  {
    final a.a a;
    
    c(a.a parama)
    {
      this.a = parama;
    }
    
    abstract void a();
  }
  
  private static class d
    extends a.c
  {
    private final Choreographer b = Choreographer.getInstance();
    private final Choreographer.FrameCallback c = new a();
    
    d(a.a parama)
    {
      super();
    }
    
    void a()
    {
      this.b.postFrameCallback(this.c);
    }
    
    class a
      implements Choreographer.FrameCallback
    {
      a() {}
      
      public void doFrame(long paramLong)
      {
        a.d.this.a.a();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e1.a
 * JD-Core Version:    0.7.0.1
 */