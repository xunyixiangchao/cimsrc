package androidx.camera.core;

import android.os.Handler;
import java.util.UUID;
import java.util.concurrent.Executor;
import s.c0.a;
import s.d0.a;
import s.s0;
import s.s0.a;
import s.t1;
import s.u1;
import s.u2.c;
import s.y1;
import v.i;

public final class a0
  implements i<z>
{
  static final s0.a<d0.a> B = s0.a.a("camerax.core.appConfig.cameraFactoryProvider", d0.a.class);
  static final s0.a<c0.a> C = s0.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", c0.a.class);
  static final s0.a<u2.c> D = s0.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", u2.c.class);
  static final s0.a<Executor> E = s0.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);
  static final s0.a<Handler> F = s0.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);
  static final s0.a<Integer> G = s0.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
  static final s0.a<t> H = s0.a.a("camerax.core.appConfig.availableCamerasLimiter", t.class);
  private final y1 A;
  
  a0(y1 paramy1)
  {
    this.A = paramy1;
  }
  
  public t I(t paramt)
  {
    return (t)this.A.e(H, paramt);
  }
  
  public Executor J(Executor paramExecutor)
  {
    return (Executor)this.A.e(E, paramExecutor);
  }
  
  public d0.a K(d0.a parama)
  {
    return (d0.a)this.A.e(B, parama);
  }
  
  public c0.a L(c0.a parama)
  {
    return (c0.a)this.A.e(C, parama);
  }
  
  public Handler M(Handler paramHandler)
  {
    return (Handler)this.A.e(F, paramHandler);
  }
  
  public u2.c N(u2.c paramc)
  {
    return (u2.c)this.A.e(D, paramc);
  }
  
  public s0 p()
  {
    return this.A;
  }
  
  public static final class a
  {
    private final u1 a;
    
    public a()
    {
      this(u1.M());
    }
    
    private a(u1 paramu1)
    {
      this.a = paramu1;
      paramu1 = (Class)paramu1.e(i.x, null);
      if ((paramu1 != null) && (!paramu1.equals(z.class)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid target class configuration for ");
        localStringBuilder.append(this);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramu1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      e(z.class);
    }
    
    private t1 b()
    {
      return this.a;
    }
    
    public a0 a()
    {
      return new a0(y1.K(this.a));
    }
    
    public a c(d0.a parama)
    {
      b().G(a0.B, parama);
      return this;
    }
    
    public a d(c0.a parama)
    {
      b().G(a0.C, parama);
      return this;
    }
    
    public a e(Class<z> paramClass)
    {
      b().G(i.x, paramClass);
      if (b().e(i.w, null) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getCanonicalName());
        localStringBuilder.append("-");
        localStringBuilder.append(UUID.randomUUID());
        f(localStringBuilder.toString());
      }
      return this;
    }
    
    public a f(String paramString)
    {
      b().G(i.w, paramString);
      return this;
    }
    
    public a g(u2.c paramc)
    {
      b().G(a0.D, paramc);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract a0 getCameraXConfig();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.a0
 * JD-Core Version:    0.7.0.1
 */