package s;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.n1;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.util.concurrent.atomic.AtomicInteger;
import u.f;

public abstract class v0
{
  public static final Size i = new Size(0, 0);
  private static final boolean j = n1.f("DeferrableSurface");
  private static final AtomicInteger k = new AtomicInteger(0);
  private static final AtomicInteger l = new AtomicInteger(0);
  private final Object a = new Object();
  private int b = 0;
  private boolean c = false;
  private c.a<Void> d;
  private final u7.a<Void> e;
  private final Size f;
  private final int g;
  Class<?> h;
  
  public v0()
  {
    this(i, 0);
  }
  
  public v0(Size paramSize, int paramInt)
  {
    this.f = paramSize;
    this.g = paramInt;
    paramSize = c.a(new t0(this));
    this.e = paramSize;
    if (n1.f("DeferrableSurface"))
    {
      m("Surface created", l.incrementAndGet(), k.get());
      paramSize.h(new u0(this, Log.getStackTraceString(new Exception())), t.a.a());
    }
  }
  
  private void m(String paramString, int paramInt1, int paramInt2)
  {
    if ((!j) && (n1.f("DeferrableSurface"))) {
      n1.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("[total_surfaces=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", used_surfaces=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("](");
    localStringBuilder.append(this);
    localStringBuilder.append("}");
    n1.a("DeferrableSurface", localStringBuilder.toString());
  }
  
  public final void c()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.c) {
          break label123;
        }
        this.c = true;
        if (this.b == 0)
        {
          c.a locala = this.d;
          this.d = null;
          localObject3 = locala;
          if (n1.f("DeferrableSurface"))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("surface closed,  useCount=");
            ((StringBuilder)localObject3).append(this.b);
            ((StringBuilder)localObject3).append(" closed=true ");
            ((StringBuilder)localObject3).append(this);
            n1.a("DeferrableSurface", ((StringBuilder)localObject3).toString());
            localObject3 = locala;
          }
          if (localObject3 != null) {
            ((c.a)localObject3).c(null);
          }
          return;
        }
      }
      Object localObject2 = null;
      continue;
      label123:
      Object localObject3 = null;
    }
  }
  
  public void d()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        int m = this.b;
        if (m != 0)
        {
          m -= 1;
          this.b = m;
          if ((m == 0) && (this.c))
          {
            c.a locala = this.d;
            this.d = null;
            if (n1.f("DeferrableSurface"))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("use count-1,  useCount=");
              localStringBuilder.append(this.b);
              localStringBuilder.append(" closed=");
              localStringBuilder.append(this.c);
              localStringBuilder.append(" ");
              localStringBuilder.append(this);
              n1.a("DeferrableSurface", localStringBuilder.toString());
              if (this.b == 0) {
                m("Surface no longer in use", l.get(), k.decrementAndGet());
              }
            }
            if (locala != null) {
              locala.c(null);
            }
          }
        }
        else
        {
          throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
        }
      }
      Object localObject2 = null;
    }
  }
  
  public Class<?> e()
  {
    return this.h;
  }
  
  public Size f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public final u7.a<Surface> h()
  {
    synchronized (this.a)
    {
      if (this.c)
      {
        locala = f.f(new a("DeferrableSurface already closed.", this));
        return locala;
      }
      u7.a locala = n();
      return locala;
    }
  }
  
  public u7.a<Void> i()
  {
    return f.j(this.e);
  }
  
  public void j()
  {
    synchronized (this.a)
    {
      int m = this.b;
      if ((m == 0) && (this.c)) {
        throw new a("Cannot begin use on a closed surface.", this);
      }
      this.b = (m + 1);
      if (n1.f("DeferrableSurface"))
      {
        if (this.b == 1) {
          m("New surface in use", l.get(), k.incrementAndGet());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("use count+1, useCount=");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" ");
        localStringBuilder.append(this);
        n1.a("DeferrableSurface", localStringBuilder.toString());
      }
      return;
    }
  }
  
  protected abstract u7.a<Surface> n();
  
  public void o(Class<?> paramClass)
  {
    this.h = paramClass;
  }
  
  public static final class a
    extends Exception
  {
    v0 a;
    
    public a(String paramString, v0 paramv0)
    {
      super();
      this.a = paramv0;
    }
    
    public v0 a()
    {
      return this.a;
    }
  }
  
  public static final class b
    extends Exception
  {
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.v0
 * JD-Core Version:    0.7.0.1
 */