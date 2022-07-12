package androidx.lifecycle;

import j.b;
import java.util.Iterator;
import java.util.Map.Entry;

public class p<T>
  extends r<T>
{
  private b<LiveData<?>, a<?>> l = new b();
  
  protected void k()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).b();
    }
  }
  
  protected void l()
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).c();
    }
  }
  
  public <S> void p(LiveData<S> paramLiveData, s<? super S> params)
  {
    a locala = new a(paramLiveData, params);
    paramLiveData = (a)this.l.g(paramLiveData, locala);
    if ((paramLiveData != null) && (paramLiveData.b != params)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {
      return;
    }
    if (h()) {
      locala.b();
    }
  }
  
  public <S> void q(LiveData<S> paramLiveData)
  {
    paramLiveData = (a)this.l.h(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.c();
    }
  }
  
  private static class a<V>
    implements s<V>
  {
    final LiveData<V> a;
    final s<? super V> b;
    int c = -1;
    
    a(LiveData<V> paramLiveData, s<? super V> params)
    {
      this.a = paramLiveData;
      this.b = params;
    }
    
    public void a(V paramV)
    {
      if (this.c != this.a.g())
      {
        this.c = this.a.g();
        this.b.a(paramV);
      }
    }
    
    void b()
    {
      this.a.j(this);
    }
    
    void c()
    {
      this.a.n(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.p
 * JD-Core Version:    0.7.0.1
 */