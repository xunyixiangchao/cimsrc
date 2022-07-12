package androidx.concurrent.futures;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class c
{
  public static <T> u7.a<T> a(c<T> paramc)
  {
    a locala = new a();
    d locald = new d(locala);
    locala.b = locald;
    locala.a = paramc.getClass();
    try
    {
      paramc = paramc.a(locala);
      if (paramc != null)
      {
        locala.a = paramc;
        return locald;
      }
    }
    catch (Exception paramc)
    {
      locald.c(paramc);
    }
    return locald;
  }
  
  public static final class a<T>
  {
    Object a;
    c.d<T> b;
    private d<Void> c = d.s();
    private boolean d;
    
    private void e()
    {
      this.a = null;
      this.b = null;
      this.c = null;
    }
    
    public void a(Runnable paramRunnable, Executor paramExecutor)
    {
      d locald = this.c;
      if (locald != null) {
        locald.h(paramRunnable, paramExecutor);
      }
    }
    
    void b()
    {
      this.a = null;
      this.b = null;
      this.c.p(null);
    }
    
    public boolean c(T paramT)
    {
      boolean bool = true;
      this.d = true;
      c.d locald = this.b;
      if ((locald == null) || (!locald.b(paramT))) {
        bool = false;
      }
      if (bool) {
        e();
      }
      return bool;
    }
    
    public boolean d()
    {
      boolean bool = true;
      this.d = true;
      c.d locald = this.b;
      if ((locald == null) || (!locald.a(true))) {
        bool = false;
      }
      if (bool) {
        e();
      }
      return bool;
    }
    
    public boolean f(Throwable paramThrowable)
    {
      boolean bool = true;
      this.d = true;
      c.d locald = this.b;
      if ((locald == null) || (!locald.c(paramThrowable))) {
        bool = false;
      }
      if (bool) {
        e();
      }
      return bool;
    }
    
    protected void finalize()
    {
      Object localObject = this.b;
      if ((localObject != null) && (!((c.d)localObject).isDone()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
        localStringBuilder.append(this.a);
        ((c.d)localObject).c(new c.b(localStringBuilder.toString()));
      }
      if (!this.d)
      {
        localObject = this.c;
        if (localObject != null) {
          ((d)localObject).p(null);
        }
      }
    }
  }
  
  static final class b
    extends Throwable
  {
    b(String paramString)
    {
      super();
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract Object a(c.a<T> parama);
  }
  
  private static final class d<T>
    implements u7.a<T>
  {
    final WeakReference<c.a<T>> a;
    private final a<T> b = new a();
    
    d(c.a<T> parama)
    {
      this.a = new WeakReference(parama);
    }
    
    boolean a(boolean paramBoolean)
    {
      return this.b.cancel(paramBoolean);
    }
    
    boolean b(T paramT)
    {
      return this.b.p(paramT);
    }
    
    boolean c(Throwable paramThrowable)
    {
      return this.b.q(paramThrowable);
    }
    
    public boolean cancel(boolean paramBoolean)
    {
      c.a locala = (c.a)this.a.get();
      paramBoolean = this.b.cancel(paramBoolean);
      if ((paramBoolean) && (locala != null)) {
        locala.b();
      }
      return paramBoolean;
    }
    
    public T get()
    {
      return this.b.get();
    }
    
    public T get(long paramLong, TimeUnit paramTimeUnit)
    {
      return this.b.get(paramLong, paramTimeUnit);
    }
    
    public void h(Runnable paramRunnable, Executor paramExecutor)
    {
      this.b.h(paramRunnable, paramExecutor);
    }
    
    public boolean isCancelled()
    {
      return this.b.isCancelled();
    }
    
    public boolean isDone()
    {
      return this.b.isDone();
    }
    
    public String toString()
    {
      return this.b.toString();
    }
    
    class a
      extends a<T>
    {
      a() {}
      
      protected String m()
      {
        c.a locala = (c.a)c.d.this.a.get();
        if (locala == null) {
          return "Completer object has been garbage collected, future will fail soon";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tag=[");
        localStringBuilder.append(locala.a);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.concurrent.futures.c
 * JD-Core Version:    0.7.0.1
 */