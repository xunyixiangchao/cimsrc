package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.a0.b;
import androidx.camera.core.i3;
import androidx.camera.core.k;
import androidx.camera.core.q;
import androidx.camera.core.r;
import androidx.camera.core.s;
import androidx.camera.core.t;
import androidx.camera.core.t.a;
import androidx.camera.core.v2;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import s.b1;
import s.g0;
import s.h0;
import s.t2;
import u.f;
import v.e.b;
import x0.h;

public final class e
  implements s
{
  private static final e h = new e();
  private final Object a = new Object();
  private a0.b b = null;
  private u7.a<androidx.camera.core.z> c;
  private u7.a<Void> d = f.h(null);
  private final LifecycleCameraRepository e = new LifecycleCameraRepository();
  private androidx.camera.core.z f;
  private Context g;
  
  public static u7.a<e> g(Context paramContext)
  {
    h.g(paramContext);
    return f.o(h.h(paramContext), new c(paramContext), t.a.a());
  }
  
  private u7.a<androidx.camera.core.z> h(Context paramContext)
  {
    synchronized (this.a)
    {
      u7.a locala = this.c;
      if (locala != null) {
        return locala;
      }
      paramContext = androidx.concurrent.futures.c.a(new b(this, new androidx.camera.core.z(paramContext, this.b)));
      this.c = paramContext;
      return paramContext;
    }
  }
  
  private void m(androidx.camera.core.z paramz)
  {
    this.f = paramz;
  }
  
  private void n(Context paramContext)
  {
    this.g = paramContext;
  }
  
  public List<r> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.e().a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((g0)localIterator.next()).e());
    }
    return localArrayList;
  }
  
  k e(androidx.lifecycle.l paraml, t paramt, i3 parami3, v2... paramVarArgs)
  {
    androidx.camera.core.impl.utils.l.a();
    Object localObject1 = t.a.c(paramt);
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = null;
      if (i >= j) {
        break;
      }
      localObject2 = paramVarArgs[i].g().y(null);
      if (localObject2 != null)
      {
        localObject2 = ((t)localObject2).c().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((t.a)localObject1).a((q)((Iterator)localObject2).next());
        }
      }
      i += 1;
    }
    LinkedHashSet localLinkedHashSet = ((t.a)localObject1).b().a(this.f.e().a());
    if (!localLinkedHashSet.isEmpty())
    {
      localObject1 = v.e.w(localLinkedHashSet);
      Object localObject3 = this.e.c(paraml, (e.b)localObject1);
      localObject1 = this.e.e();
      j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        v2 localv2 = paramVarArgs[i];
        Iterator localIterator = ((Collection)localObject1).iterator();
        while (localIterator.hasNext())
        {
          LifecycleCamera localLifecycleCamera = (LifecycleCamera)localIterator.next();
          if ((localLifecycleCamera.q(localv2)) && (localLifecycleCamera != localObject3)) {
            throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", new Object[] { localv2 }));
          }
        }
        i += 1;
      }
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = this.e.b(paraml, new v.e(localLinkedHashSet, this.f.d(), this.f.g()));
      }
      localObject3 = paramt.c().iterator();
      paraml = (androidx.lifecycle.l)localObject2;
      while (((Iterator)localObject3).hasNext())
      {
        paramt = (q)((Iterator)localObject3).next();
        if (paramt.a() != q.a)
        {
          paramt = b1.b(paramt.a()).a(((LifecycleCamera)localObject1).e(), this.g);
          if (paramt != null) {
            if (paraml == null) {
              paraml = paramt;
            } else {
              throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
            }
          }
        }
      }
      ((LifecycleCamera)localObject1).h(paraml);
      if (paramVarArgs.length == 0) {
        return localObject1;
      }
      this.e.a((LifecycleCamera)localObject1, parami3, Arrays.asList(paramVarArgs));
      return localObject1;
    }
    throw new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
  }
  
  public k f(androidx.lifecycle.l paraml, t paramt, v2... paramVarArgs)
  {
    return e(paraml, paramt, null, paramVarArgs);
  }
  
  public boolean i(t paramt)
  {
    try
    {
      paramt.e(this.f.e().a());
      return true;
    }
    catch (IllegalArgumentException paramt)
    {
      label17:
      break label17;
    }
    return false;
  }
  
  public void o()
  {
    androidx.camera.core.impl.utils.l.a();
    this.e.k();
  }
  
  class a
    implements u.c<Void>
  {
    a(c.a parama, androidx.camera.core.z paramz) {}
    
    public void a(Throwable paramThrowable)
    {
      this.a.f(paramThrowable);
    }
    
    public void c(Void paramVoid)
    {
      this.a.c(this.b);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.lifecycle.e
 * JD-Core Version:    0.7.0.1
 */