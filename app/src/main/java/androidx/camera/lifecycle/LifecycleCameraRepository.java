package androidx.camera.lifecycle;

import androidx.camera.core.i3;
import androidx.camera.core.v2;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import v.e;
import v.e.a;
import v.e.b;

final class LifecycleCameraRepository
{
  private final Object a = new Object();
  private final Map<a, LifecycleCamera> b = new HashMap();
  private final Map<LifecycleCameraRepositoryObserver, Set<a>> c = new HashMap();
  private final ArrayDeque<l> d = new ArrayDeque();
  
  private LifecycleCameraRepositoryObserver d(l paraml)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver = (LifecycleCameraRepositoryObserver)localIterator.next();
        if (paraml.equals(localLifecycleCameraRepositoryObserver.a())) {
          return localLifecycleCameraRepositoryObserver;
        }
      }
      return null;
    }
  }
  
  private boolean f(l paraml)
  {
    synchronized (this.a)
    {
      paraml = d(paraml);
      if (paraml == null) {
        return false;
      }
      paraml = ((Set)this.c.get(paraml)).iterator();
      while (paraml.hasNext())
      {
        a locala = (a)paraml.next();
        if (!((LifecycleCamera)x0.h.g((LifecycleCamera)this.b.get(locala))).p().isEmpty()) {
          return true;
        }
      }
      return false;
    }
  }
  
  private void g(LifecycleCamera paramLifecycleCamera)
  {
    synchronized (this.a)
    {
      l locall = paramLifecycleCamera.o();
      a locala = a.a(locall, paramLifecycleCamera.k().x());
      LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver = d(locall);
      Object localObject1;
      if (localLifecycleCameraRepositoryObserver != null) {
        localObject1 = (Set)this.c.get(localLifecycleCameraRepositoryObserver);
      } else {
        localObject1 = new HashSet();
      }
      ((Set)localObject1).add(locala);
      this.b.put(locala, paramLifecycleCamera);
      if (localLifecycleCameraRepositoryObserver == null)
      {
        paramLifecycleCamera = new LifecycleCameraRepositoryObserver(locall, this);
        this.c.put(paramLifecycleCamera, localObject1);
        locall.getLifecycle().a(paramLifecycleCamera);
      }
      return;
    }
  }
  
  private void j(l paraml)
  {
    synchronized (this.a)
    {
      paraml = d(paraml);
      if (paraml == null) {
        return;
      }
      paraml = ((Set)this.c.get(paraml)).iterator();
      while (paraml.hasNext())
      {
        a locala = (a)paraml.next();
        ((LifecycleCamera)x0.h.g((LifecycleCamera)this.b.get(locala))).r();
      }
      return;
    }
  }
  
  private void m(l paraml)
  {
    synchronized (this.a)
    {
      paraml = d(paraml);
      paraml = ((Set)this.c.get(paraml)).iterator();
      while (paraml.hasNext())
      {
        Object localObject2 = (a)paraml.next();
        localObject2 = (LifecycleCamera)this.b.get(localObject2);
        if (!((LifecycleCamera)x0.h.g(localObject2)).p().isEmpty()) {
          ((LifecycleCamera)localObject2).t();
        }
      }
      return;
    }
  }
  
  void a(LifecycleCamera paramLifecycleCamera, i3 parami3, Collection<v2> paramCollection)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (!paramCollection.isEmpty())
        {
          bool = true;
          x0.h.a(bool);
          l locall = paramLifecycleCamera.o();
          Object localObject2 = d(locall);
          localObject2 = ((Set)this.c.get(localObject2)).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (a)((Iterator)localObject2).next();
            localObject3 = (LifecycleCamera)x0.h.g((LifecycleCamera)this.b.get(localObject3));
            if ((localObject3.equals(paramLifecycleCamera)) || (((LifecycleCamera)localObject3).p().isEmpty())) {
              continue;
            }
            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
          }
          try
          {
            paramLifecycleCamera.k().J(parami3);
            paramLifecycleCamera.j(paramCollection);
            if (locall.getLifecycle().b().a(h.c.d)) {
              h(locall);
            }
            return;
          }
          catch (e.a paramLifecycleCamera)
          {
            throw new IllegalArgumentException(paramLifecycleCamera.getMessage());
          }
        }
      }
      boolean bool = false;
    }
  }
  
  LifecycleCamera b(l paraml, e parame)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        a locala = a.a(paraml, parame.x());
        if (this.b.get(locala) == null)
        {
          bool = true;
          x0.h.b(bool, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
          if (paraml.getLifecycle().b() != h.c.a)
          {
            paraml = new LifecycleCamera(paraml, parame);
            if (parame.z().isEmpty()) {
              paraml.r();
            }
            g(paraml);
            return paraml;
          }
          throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
        }
      }
      boolean bool = false;
    }
  }
  
  LifecycleCamera c(l paraml, e.b paramb)
  {
    synchronized (this.a)
    {
      paraml = (LifecycleCamera)this.b.get(a.a(paraml, paramb));
      return paraml;
    }
  }
  
  Collection<LifecycleCamera> e()
  {
    synchronized (this.a)
    {
      Collection localCollection = Collections.unmodifiableCollection(this.b.values());
      return localCollection;
    }
  }
  
  void h(l paraml)
  {
    synchronized (this.a)
    {
      if (!f(paraml)) {
        return;
      }
      if (this.d.isEmpty()) {}
      for (Object localObject1 = this.d;; localObject1 = this.d)
      {
        ((ArrayDeque)localObject1).push(paraml);
        break;
        localObject1 = (l)this.d.peek();
        if (paraml.equals(localObject1)) {
          break;
        }
        j((l)localObject1);
        this.d.remove(paraml);
      }
      m(paraml);
      return;
    }
  }
  
  void i(l paraml)
  {
    synchronized (this.a)
    {
      this.d.remove(paraml);
      j(paraml);
      if (!this.d.isEmpty()) {
        m((l)this.d.peek());
      }
      return;
    }
  }
  
  void k()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (a)localIterator.next();
        localObject3 = (LifecycleCamera)this.b.get(localObject3);
        ((LifecycleCamera)localObject3).s();
        i(((LifecycleCamera)localObject3).o());
      }
      return;
    }
  }
  
  void l(l paraml)
  {
    synchronized (this.a)
    {
      LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver = d(paraml);
      if (localLifecycleCameraRepositoryObserver == null) {
        return;
      }
      i(paraml);
      paraml = ((Set)this.c.get(localLifecycleCameraRepositoryObserver)).iterator();
      while (paraml.hasNext())
      {
        a locala = (a)paraml.next();
        this.b.remove(locala);
      }
      this.c.remove(localLifecycleCameraRepositoryObserver);
      localLifecycleCameraRepositoryObserver.a().getLifecycle().c(localLifecycleCameraRepositoryObserver);
      return;
    }
  }
  
  private static class LifecycleCameraRepositoryObserver
    implements k
  {
    private final LifecycleCameraRepository a;
    private final l b;
    
    LifecycleCameraRepositoryObserver(l paraml, LifecycleCameraRepository paramLifecycleCameraRepository)
    {
      this.b = paraml;
      this.a = paramLifecycleCameraRepository;
    }
    
    l a()
    {
      return this.b;
    }
    
    @t(h.b.ON_DESTROY)
    public void onDestroy(l paraml)
    {
      this.a.l(paraml);
    }
    
    @t(h.b.ON_START)
    public void onStart(l paraml)
    {
      this.a.h(paraml);
    }
    
    @t(h.b.ON_STOP)
    public void onStop(l paraml)
    {
      this.a.i(paraml);
    }
  }
  
  static abstract class a
  {
    static a a(l paraml, e.b paramb)
    {
      return new a(paraml, paramb);
    }
    
    public abstract e.b b();
    
    public abstract l c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.lifecycle.LifecycleCameraRepository
 * JD-Core Version:    0.7.0.1
 */