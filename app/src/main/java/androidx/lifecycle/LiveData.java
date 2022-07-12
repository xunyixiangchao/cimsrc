package androidx.lifecycle;

import i.a;
import j.b;
import j.b.d;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  static final Object k = new Object();
  final Object a = new Object();
  private b<s<? super T>, LiveData<T>.c> b = new b();
  int c = 0;
  private boolean d;
  private volatile Object e;
  volatile Object f;
  private int g;
  private boolean h;
  private boolean i;
  private final Runnable j;
  
  public LiveData()
  {
    Object localObject = k;
    this.f = localObject;
    this.j = new a();
    this.e = localObject;
    this.g = -1;
  }
  
  public LiveData(T paramT)
  {
    this.f = k;
    this.j = new a();
    this.e = paramT;
    this.g = 0;
  }
  
  static void b(String paramString)
  {
    if (a.e().b()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void d(LiveData<T>.c paramLiveData)
  {
    if (!paramLiveData.b) {
      return;
    }
    if (!paramLiveData.f())
    {
      paramLiveData.a(false);
      return;
    }
    int m = paramLiveData.c;
    int n = this.g;
    if (m >= n) {
      return;
    }
    paramLiveData.c = n;
    paramLiveData.a.a(this.e);
  }
  
  void c(int paramInt)
  {
    int m = this.c;
    this.c = (paramInt + m);
    if (this.d) {
      return;
    }
    this.d = true;
    for (;;)
    {
      int n;
      try
      {
        n = this.c;
        if (m != n)
        {
          if ((m == 0) && (n > 0))
          {
            paramInt = 1;
            break label90;
            if (paramInt != 0) {
              k();
            } else if (m != 0) {
              l();
            }
            m = n;
          }
        }
        else {
          return;
        }
      }
      finally
      {
        this.d = false;
      }
      paramInt = 0;
      label90:
      if ((m > 0) && (n == 0)) {
        m = 1;
      } else {
        m = 0;
      }
    }
  }
  
  void e(LiveData<T>.c paramLiveData)
  {
    if (this.h)
    {
      this.i = true;
      return;
    }
    this.h = true;
    do
    {
      this.i = false;
      LiveData<T>.c localLiveData;
      if (paramLiveData != null)
      {
        d(paramLiveData);
        localLiveData = null;
      }
      else
      {
        b.d locald = this.b.d();
        do
        {
          localLiveData = paramLiveData;
          if (!locald.hasNext()) {
            break;
          }
          d((c)((Map.Entry)locald.next()).getValue());
        } while (!this.i);
        localLiveData = paramLiveData;
      }
      paramLiveData = localLiveData;
    } while (this.i);
    this.h = false;
  }
  
  public T f()
  {
    Object localObject = this.e;
    if (localObject != k) {
      return localObject;
    }
    return null;
  }
  
  int g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.c > 0;
  }
  
  public void i(l paraml, s<? super T> params)
  {
    b("observe");
    if (paraml.getLifecycle().b() == h.c.a) {
      return;
    }
    LifecycleBoundObserver localLifecycleBoundObserver = new LifecycleBoundObserver(paraml, params);
    params = (c)this.b.g(params, localLifecycleBoundObserver);
    if ((params != null) && (!params.e(paraml))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (params != null) {
      return;
    }
    paraml.getLifecycle().a(localLifecycleBoundObserver);
  }
  
  public void j(s<? super T> params)
  {
    b("observeForever");
    b localb = new b(params);
    params = (c)this.b.g(params, localb);
    if (!(params instanceof LifecycleBoundObserver))
    {
      if (params != null) {
        return;
      }
      localb.a(true);
      return;
    }
    throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
  }
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m(T paramT)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.f == k)
        {
          m = 1;
          this.f = paramT;
          if (m == 0) {
            return;
          }
          a.e().c(this.j);
          return;
        }
      }
      int m = 0;
    }
  }
  
  public void n(s<? super T> params)
  {
    b("removeObserver");
    params = (c)this.b.h(params);
    if (params == null) {
      return;
    }
    params.c();
    params.a(false);
  }
  
  protected void o(T paramT)
  {
    b("setValue");
    this.g += 1;
    this.e = paramT;
    e(null);
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.c
    implements j
  {
    final l e;
    
    LifecycleBoundObserver(s<? super T> params)
    {
      super(locals);
      this.e = params;
    }
    
    void c()
    {
      this.e.getLifecycle().c(this);
    }
    
    public void d(l paraml, h.b paramb)
    {
      paraml = this.e.getLifecycle().b();
      if (paraml == h.c.a)
      {
        LiveData.this.n(this.a);
        return;
      }
      paramb = null;
      while (paramb != paraml)
      {
        a(f());
        h.c localc = this.e.getLifecycle().b();
        paramb = paraml;
        paraml = localc;
      }
    }
    
    boolean e(l paraml)
    {
      return this.e == paraml;
    }
    
    boolean f()
    {
      return this.e.getLifecycle().b().a(h.c.d);
    }
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      synchronized (LiveData.this.a)
      {
        Object localObject2 = LiveData.this.f;
        LiveData.this.f = LiveData.k;
        LiveData.this.o(localObject2);
        return;
      }
    }
  }
  
  private class b
    extends LiveData<T>.c
  {
    b()
    {
      super(locals);
    }
    
    boolean f()
    {
      return true;
    }
  }
  
  private abstract class c
  {
    final s<? super T> a;
    boolean b;
    int c = -1;
    
    c()
    {
      Object localObject;
      this.a = localObject;
    }
    
    void a(boolean paramBoolean)
    {
      if (paramBoolean == this.b) {
        return;
      }
      this.b = paramBoolean;
      LiveData localLiveData = LiveData.this;
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = -1;
      }
      localLiveData.c(i);
      if (this.b) {
        LiveData.this.e(this);
      }
    }
    
    void c() {}
    
    boolean e(l paraml)
    {
      return false;
    }
    
    abstract boolean f();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.LiveData
 * JD-Core Version:    0.7.0.1
 */