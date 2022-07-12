package androidx.camera.core;

import android.util.SparseArray;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import androidx.concurrent.futures.c.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s.k1;
import s.n2;
import u7.a;

final class k2
  implements k1
{
  final Object a = new Object();
  final SparseArray<c.a<e1>> b = new SparseArray();
  private final SparseArray<a<e1>> c = new SparseArray();
  private final List<e1> d = new ArrayList();
  private final List<Integer> e;
  private String f;
  private boolean g = false;
  
  k2(List<Integer> paramList, String paramString)
  {
    this.e = paramList;
    this.f = paramString;
    f();
  }
  
  private void f()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        final int i = ((Integer)localIterator.next()).intValue();
        a locala = c.a(new a(i));
        this.c.put(i, locala);
      }
      return;
    }
  }
  
  public a<e1> a(int paramInt)
  {
    synchronized (this.a)
    {
      if (!this.g)
      {
        Object localObject2 = (a)this.c.get(paramInt);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ImageProxyBundle does not contain this id: ");
        ((StringBuilder)localObject2).append(paramInt);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      }
      throw new IllegalStateException("ImageProxyBundle already closed.");
    }
  }
  
  public List<Integer> b()
  {
    return Collections.unmodifiableList(this.e);
  }
  
  void c(e1 parame1)
  {
    synchronized (this.a)
    {
      if (this.g) {
        return;
      }
      Integer localInteger = (Integer)parame1.q().a().c(this.f);
      if (localInteger != null)
      {
        c.a locala = (c.a)this.b.get(localInteger.intValue());
        if (locala != null)
        {
          this.d.add(parame1);
          locala.c(parame1);
          return;
        }
        parame1 = new StringBuilder();
        parame1.append("ImageProxyBundle does not contain this id: ");
        parame1.append(localInteger);
        throw new IllegalArgumentException(parame1.toString());
      }
      throw new IllegalArgumentException("CaptureId is null.");
    }
  }
  
  void d()
  {
    synchronized (this.a)
    {
      if (this.g) {
        return;
      }
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((e1)localIterator.next()).close();
      }
      this.d.clear();
      this.c.clear();
      this.b.clear();
      this.g = true;
      return;
    }
  }
  
  void e()
  {
    synchronized (this.a)
    {
      if (this.g) {
        return;
      }
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((e1)localIterator.next()).close();
      }
      this.d.clear();
      this.c.clear();
      this.b.clear();
      f();
      return;
    }
  }
  
  class a
    implements c.c<e1>
  {
    a(int paramInt) {}
    
    public Object a(c.a<e1> parama)
    {
      synchronized (k2.this.a)
      {
        k2.this.b.put(i, parama);
        parama = new StringBuilder();
        parama.append("getImageProxy(id: ");
        parama.append(i);
        parama.append(")");
        return parama.toString();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.k2
 * JD-Core Version:    0.7.0.1
 */