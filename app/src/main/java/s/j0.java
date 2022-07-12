package s;

import androidx.camera.core.k;
import androidx.camera.core.n1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import x0.h;

public final class j0
{
  private final StringBuilder a = new StringBuilder();
  private final Object b = new Object();
  private final int c;
  private final Map<k, a> d = new HashMap();
  private int e;
  
  public j0(int paramInt)
  {
    this.c = paramInt;
    try
    {
      this.e = paramInt;
      return;
    }
    finally {}
  }
  
  private static boolean b(g0.a parama)
  {
    return (parama != null) && (parama.a());
  }
  
  private void d()
  {
    if (n1.f("CameraStateRegistry"))
    {
      this.a.setLength(0);
      this.a.append("Recalculating open cameras:\n");
      this.a.append(String.format(Locale.US, "%-45s%-22s\n", new Object[] { "Camera", "State" }));
      this.a.append("-------------------------------------------------------------------\n");
    }
    Iterator localIterator = this.d.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (n1.f("CameraStateRegistry"))
      {
        String str;
        if (((a)localEntry.getValue()).a() != null) {
          str = ((a)localEntry.getValue()).a().toString();
        } else {
          str = "UNKNOWN";
        }
        this.a.append(String.format(Locale.US, "%-45s%-22s\n", new Object[] { ((k)localEntry.getKey()).toString(), str }));
      }
      if (b(((a)localEntry.getValue()).a())) {
        i += 1;
      }
    }
    if (n1.f("CameraStateRegistry"))
    {
      this.a.append("-------------------------------------------------------------------\n");
      this.a.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
      n1.a("CameraStateRegistry", this.a.toString());
    }
    this.e = Math.max(this.c - i, 0);
  }
  
  private g0.a g(k paramk)
  {
    paramk = (a)this.d.remove(paramk);
    if (paramk != null)
    {
      d();
      return paramk.a();
    }
    return null;
  }
  
  private g0.a h(k paramk, g0.a parama)
  {
    paramk = ((a)h.h((a)this.d.get(paramk), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).c(parama);
    g0.a locala = g0.a.c;
    if (parama == locala)
    {
      boolean bool;
      if ((!b(parama)) && (paramk != locala)) {
        bool = false;
      } else {
        bool = true;
      }
      h.j(bool, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
    }
    if (paramk != parama) {
      d();
    }
    return paramk;
  }
  
  public boolean a()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.d.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (((a)((Map.Entry)localIterator.next()).getValue()).a() == g0.a.e) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void c(k paramk, g0.a parama, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        int i = this.e;
        Object localObject1;
        if (parama == g0.a.h) {
          localObject1 = g(paramk);
        } else {
          localObject1 = h(paramk, parama);
        }
        if (localObject1 == parama) {
          return;
        }
        if ((i < 1) && (this.e > 0))
        {
          localObject1 = new HashMap();
          Iterator localIterator = this.d.entrySet().iterator();
          parama = (g0.a)localObject1;
          if (localIterator.hasNext())
          {
            parama = (Map.Entry)localIterator.next();
            if (((a)parama.getValue()).a() != g0.a.b) {
              continue;
            }
            ((Map)localObject1).put((k)parama.getKey(), (a)parama.getValue());
            continue;
          }
        }
        else
        {
          if ((parama != g0.a.b) || (this.e <= 0)) {
            break label271;
          }
          parama = new HashMap();
          parama.put(paramk, (a)this.d.get(paramk));
        }
        if ((parama != null) && (!paramBoolean)) {
          parama.remove(paramk);
        }
        if (parama != null)
        {
          paramk = parama.values().iterator();
          if (paramk.hasNext())
          {
            ((a)paramk.next()).b();
            continue;
          }
        }
        return;
      }
      label271:
      parama = null;
    }
  }
  
  public void e(k paramk, Executor paramExecutor, b paramb)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (!this.d.containsKey(paramk))
        {
          bool = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Camera is already registered: ");
          localStringBuilder.append(paramk);
          h.j(bool, localStringBuilder.toString());
          this.d.put(paramk, new a(null, paramExecutor, paramb));
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean f(k paramk)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        Object localObject2 = (a)h.h((a)this.d.get(paramk), "Camera must first be registered with registerCamera()");
        if (n1.f("CameraStateRegistry"))
        {
          this.a.setLength(0);
          this.a.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", new Object[] { paramk, Integer.valueOf(this.e), Boolean.valueOf(b(((a)localObject2).a())), ((a)localObject2).a() }));
        }
        if (this.e <= 0) {
          if (!b(((a)localObject2).a())) {
            break label213;
          }
        }
        ((a)localObject2).c(g0.a.c);
        bool = true;
        if (n1.f("CameraStateRegistry"))
        {
          localObject2 = this.a;
          Locale localLocale = Locale.US;
          if (!bool) {
            break label218;
          }
          paramk = "SUCCESS";
          ((StringBuilder)localObject2).append(String.format(localLocale, " --> %s", new Object[] { paramk }));
          n1.a("CameraStateRegistry", this.a.toString());
        }
        if (bool) {
          d();
        }
        return bool;
      }
      label213:
      boolean bool = false;
      continue;
      label218:
      paramk = "FAIL";
    }
  }
  
  private static class a
  {
    private g0.a a;
    private final Executor b;
    private final j0.b c;
    
    a(g0.a parama, Executor paramExecutor, j0.b paramb)
    {
      this.a = parama;
      this.b = paramExecutor;
      this.c = paramb;
    }
    
    g0.a a()
    {
      return this.a;
    }
    
    void b()
    {
      try
      {
        Executor localExecutor = this.b;
        j0.b localb = this.c;
        Objects.requireNonNull(localb);
        localExecutor.execute(new i0(localb));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        n1.d("CameraStateRegistry", "Unable to notify camera.", localRejectedExecutionException);
      }
    }
    
    g0.a c(g0.a parama)
    {
      g0.a locala = this.a;
      this.a = parama;
      return locala;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.j0
 * JD-Core Version:    0.7.0.1
 */