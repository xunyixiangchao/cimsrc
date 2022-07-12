package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.concurrent.futures.c.a;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import n.a0;
import o.b;
import s.a1;
import s.v0;
import u.d;
import u.f;
import x0.h;

class r2
  extends l2.a
  implements l2, x2.b
{
  final Object a = new Object();
  final v1 b;
  final Handler c;
  final Executor d;
  private final ScheduledExecutorService e;
  l2.a f;
  n.g g;
  u7.a<Void> h;
  c.a<Void> i;
  private u7.a<List<Surface>> j;
  private List<v0> k = null;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  
  r2(v1 paramv1, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler)
  {
    this.b = paramv1;
    this.c = paramHandler;
    this.d = paramExecutor;
    this.e = paramScheduledExecutorService;
  }
  
  void A(CameraCaptureSession paramCameraCaptureSession)
  {
    if (this.g == null) {
      this.g = n.g.d(paramCameraCaptureSession, this.c);
    }
  }
  
  void B(List<v0> paramList)
  {
    synchronized (this.a)
    {
      I();
      a1.f(paramList);
      this.k = paramList;
      return;
    }
  }
  
  boolean C()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.h != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  void I()
  {
    synchronized (this.a)
    {
      List localList = this.k;
      if (localList != null)
      {
        a1.e(localList);
        this.k = null;
      }
      return;
    }
  }
  
  public l2.a a()
  {
    return this;
  }
  
  public void b()
  {
    I();
  }
  
  public Executor c()
  {
    return this.d;
  }
  
  public void close()
  {
    h.h(this.g, "Need to call openCaptureSession before using this API.");
    this.b.i(this);
    this.g.c().close();
    c().execute(new n2(this));
  }
  
  public o.g d(int paramInt, List<b> paramList, l2.a parama)
  {
    this.f = parama;
    return new o.g(paramInt, paramList, c(), new b());
  }
  
  public void e()
  {
    h.h(this.g, "Need to call openCaptureSession before using this API.");
    this.g.c().stopRepeating();
  }
  
  public u7.a<List<Surface>> f(List<v0> paramList, long paramLong)
  {
    synchronized (this.a)
    {
      if (this.m)
      {
        paramList = f.f(new CancellationException("Opener is disabled"));
        return paramList;
      }
      paramList = d.a(a1.k(paramList, false, paramLong, c(), this.e)).e(new q2(this, paramList), c());
      this.j = paramList;
      paramList = f.j(paramList);
      return paramList;
    }
  }
  
  public int g(List<CaptureRequest> paramList, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    h.h(this.g, "Need to call openCaptureSession before using this API.");
    return this.g.a(paramList, c(), paramCaptureCallback);
  }
  
  public u7.a<Void> h()
  {
    return f.h(null);
  }
  
  public u7.a<Void> i(CameraDevice paramCameraDevice, o.g paramg, List<v0> paramList)
  {
    synchronized (this.a)
    {
      if (this.m)
      {
        paramCameraDevice = f.f(new CancellationException("Opener is disabled"));
        return paramCameraDevice;
      }
      this.b.l(this);
      paramCameraDevice = androidx.concurrent.futures.c.a(new m2(this, paramList, a0.b(paramCameraDevice, this.c), paramg));
      this.h = paramCameraDevice;
      f.b(paramCameraDevice, new a(), t.a.a());
      paramCameraDevice = f.j(this.h);
      return paramCameraDevice;
    }
  }
  
  public n.g j()
  {
    h.g(this.g);
    return this.g;
  }
  
  public void k()
  {
    h.h(this.g, "Need to call openCaptureSession before using this API.");
    this.g.c().abortCaptures();
  }
  
  public CameraDevice l()
  {
    h.g(this.g);
    return this.g.c().getDevice();
  }
  
  public int m(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    h.h(this.g, "Need to call openCaptureSession before using this API.");
    return this.g.b(paramCaptureRequest, c(), paramCaptureCallback);
  }
  
  public void n(l2 paraml2)
  {
    this.f.n(paraml2);
  }
  
  public void o(l2 paraml2)
  {
    this.f.o(paraml2);
  }
  
  public void p(l2 paraml2)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (!this.l)
        {
          this.l = true;
          h.h(this.h, "Need to call openCaptureSession before using this API.");
          locala = this.h;
          b();
          if (locala != null) {
            locala.h(new p2(this, paraml2), t.a.a());
          }
          return;
        }
      }
      u7.a locala = null;
    }
  }
  
  public void q(l2 paraml2)
  {
    b();
    this.b.j(this);
    this.f.q(paraml2);
  }
  
  public void r(l2 paraml2)
  {
    this.b.k(this);
    this.f.r(paraml2);
  }
  
  public void s(l2 paraml2)
  {
    this.f.s(paraml2);
  }
  
  public boolean stop()
  {
    Object localObject2 = null;
    u7.a locala = null;
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject1 = localObject6;
    for (;;)
    {
      try
      {
        Object localObject7 = this.a;
        localObject1 = localObject6;
        localObject1 = locala;
        try
        {
          if (!this.m)
          {
            localObject1 = locala;
            locala = this.j;
            localObject2 = localObject5;
            if (locala != null) {
              localObject2 = locala;
            }
            localObject1 = localObject2;
            this.m = true;
          }
          localObject1 = localObject2;
          if (!C())
          {
            bool = true;
            localObject1 = localObject2;
            return bool;
          }
        }
        finally {}
        boolean bool = false;
      }
      finally
      {
        if (localObject1 != null) {
          ((Future)localObject1).cancel(true);
        }
      }
    }
  }
  
  void t(l2 paraml2)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (!this.n)
        {
          this.n = true;
          h.h(this.h, "Need to call openCaptureSession before using this API.");
          locala = this.h;
          if (locala != null) {
            locala.h(new o2(this, paraml2), t.a.a());
          }
          return;
        }
      }
      u7.a locala = null;
    }
  }
  
  public void u(l2 paraml2, Surface paramSurface)
  {
    this.f.u(paraml2, paramSurface);
  }
  
  class a
    implements u.c<Void>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
    {
      r2.this.b();
      paramThrowable = r2.this;
      paramThrowable.b.j(paramThrowable);
    }
    
    public void c(Void paramVoid) {}
  }
  
  class b
    extends CameraCaptureSession.StateCallback
  {
    b() {}
    
    public void onActive(CameraCaptureSession paramCameraCaptureSession)
    {
      r2.this.A(paramCameraCaptureSession);
      paramCameraCaptureSession = r2.this;
      paramCameraCaptureSession.n(paramCameraCaptureSession);
    }
    
    public void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession)
    {
      r2.this.A(paramCameraCaptureSession);
      paramCameraCaptureSession = r2.this;
      paramCameraCaptureSession.o(paramCameraCaptureSession);
    }
    
    public void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      r2.this.A(paramCameraCaptureSession);
      paramCameraCaptureSession = r2.this;
      paramCameraCaptureSession.p(paramCameraCaptureSession);
    }
    
    /* Error */
    public void onConfigureFailed(CameraCaptureSession arg1)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   4: aload_1
      //   5: invokevirtual 24	androidx/camera/camera2/internal/r2:A	(Landroid/hardware/camera2/CameraCaptureSession;)V
      //   8: aload_0
      //   9: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   12: astore_1
      //   13: aload_1
      //   14: aload_1
      //   15: invokevirtual 40	androidx/camera/camera2/internal/r2:q	(Landroidx/camera/camera2/internal/l2;)V
      //   18: aload_0
      //   19: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   22: getfield 43	androidx/camera/camera2/internal/r2:a	Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_1
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   32: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   35: ldc 49
      //   37: invokestatic 55	x0/h:h	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   40: pop
      //   41: aload_0
      //   42: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   45: astore_2
      //   46: aload_2
      //   47: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   50: astore_3
      //   51: aload_2
      //   52: aconst_null
      //   53: putfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   56: aload_1
      //   57: monitorexit
      //   58: aload_3
      //   59: new 57	java/lang/IllegalStateException
      //   62: dup
      //   63: ldc 58
      //   65: invokespecial 61	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   68: invokevirtual 67	androidx/concurrent/futures/c$a:f	(Ljava/lang/Throwable;)Z
      //   71: pop
      //   72: return
      //   73: astore_2
      //   74: aload_1
      //   75: monitorexit
      //   76: aload_2
      //   77: athrow
      //   78: astore_2
      //   79: aload_0
      //   80: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   83: getfield 43	androidx/camera/camera2/internal/r2:a	Ljava/lang/Object;
      //   86: astore_1
      //   87: aload_1
      //   88: monitorenter
      //   89: aload_0
      //   90: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   93: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   96: ldc 49
      //   98: invokestatic 55	x0/h:h	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   101: pop
      //   102: aload_0
      //   103: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   106: astore_3
      //   107: aload_3
      //   108: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   111: astore 4
      //   113: aload_3
      //   114: aconst_null
      //   115: putfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   118: aload_1
      //   119: monitorexit
      //   120: aload 4
      //   122: new 57	java/lang/IllegalStateException
      //   125: dup
      //   126: ldc 58
      //   128: invokespecial 61	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   131: invokevirtual 67	androidx/concurrent/futures/c$a:f	(Ljava/lang/Throwable;)Z
      //   134: pop
      //   135: aload_2
      //   136: athrow
      //   137: astore_2
      //   138: aload_1
      //   139: monitorexit
      //   140: aload_2
      //   141: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	this	b
      //   45	7	2	localr2	r2
      //   73	4	2	localObject1	Object
      //   78	58	2	localObject2	Object
      //   137	4	2	localObject3	Object
      //   50	64	3	localObject4	Object
      //   111	10	4	locala	c.a
      // Exception table:
      //   from	to	target	type
      //   28	58	73	finally
      //   74	76	73	finally
      //   0	18	78	finally
      //   89	120	137	finally
      //   138	140	137	finally
    }
    
    /* Error */
    public void onConfigured(CameraCaptureSession arg1)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   4: aload_1
      //   5: invokevirtual 24	androidx/camera/camera2/internal/r2:A	(Landroid/hardware/camera2/CameraCaptureSession;)V
      //   8: aload_0
      //   9: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   12: astore_1
      //   13: aload_1
      //   14: aload_1
      //   15: invokevirtual 71	androidx/camera/camera2/internal/r2:r	(Landroidx/camera/camera2/internal/l2;)V
      //   18: aload_0
      //   19: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   22: getfield 43	androidx/camera/camera2/internal/r2:a	Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_1
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   32: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   35: ldc 49
      //   37: invokestatic 55	x0/h:h	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   40: pop
      //   41: aload_0
      //   42: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   45: astore_2
      //   46: aload_2
      //   47: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   50: astore_3
      //   51: aload_2
      //   52: aconst_null
      //   53: putfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   56: aload_1
      //   57: monitorexit
      //   58: aload_3
      //   59: aconst_null
      //   60: invokevirtual 75	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
      //   63: pop
      //   64: return
      //   65: astore_2
      //   66: aload_1
      //   67: monitorexit
      //   68: aload_2
      //   69: athrow
      //   70: astore_2
      //   71: aload_0
      //   72: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   75: getfield 43	androidx/camera/camera2/internal/r2:a	Ljava/lang/Object;
      //   78: astore_1
      //   79: aload_1
      //   80: monitorenter
      //   81: aload_0
      //   82: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   85: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   88: ldc 49
      //   90: invokestatic 55	x0/h:h	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   93: pop
      //   94: aload_0
      //   95: getfield 15	androidx/camera/camera2/internal/r2$b:a	Landroidx/camera/camera2/internal/r2;
      //   98: astore_3
      //   99: aload_3
      //   100: getfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   103: astore 4
      //   105: aload_3
      //   106: aconst_null
      //   107: putfield 47	androidx/camera/camera2/internal/r2:i	Landroidx/concurrent/futures/c$a;
      //   110: aload_1
      //   111: monitorexit
      //   112: aload 4
      //   114: aconst_null
      //   115: invokevirtual 75	androidx/concurrent/futures/c$a:c	(Ljava/lang/Object;)Z
      //   118: pop
      //   119: aload_2
      //   120: athrow
      //   121: astore_2
      //   122: aload_1
      //   123: monitorexit
      //   124: aload_2
      //   125: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	126	0	this	b
      //   45	7	2	localr2	r2
      //   65	4	2	localObject1	Object
      //   70	50	2	localObject2	Object
      //   121	4	2	localObject3	Object
      //   50	56	3	localObject4	Object
      //   103	10	4	locala	c.a
      // Exception table:
      //   from	to	target	type
      //   28	58	65	finally
      //   66	68	65	finally
      //   0	18	70	finally
      //   81	112	121	finally
      //   122	124	121	finally
    }
    
    public void onReady(CameraCaptureSession paramCameraCaptureSession)
    {
      r2.this.A(paramCameraCaptureSession);
      paramCameraCaptureSession = r2.this;
      paramCameraCaptureSession.s(paramCameraCaptureSession);
    }
    
    public void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
    {
      r2.this.A(paramCameraCaptureSession);
      paramCameraCaptureSession = r2.this;
      paramCameraCaptureSession.u(paramCameraCaptureSession, paramSurface);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.r2
 * JD-Core Version:    0.7.0.1
 */