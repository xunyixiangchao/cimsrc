package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import m.b.a;
import n.z;
import r.j.a;
import s.b0;
import s.b0.c;
import s.c2;
import s.g2;
import s.g2.b;
import s.n0;
import s.n0.a;
import s.n2;
import s.s0;
import s.s0.a;
import s.s0.c;
import s.t1;
import u.d;
import u.f;

public class t
  implements b0
{
  final b b;
  final Executor c;
  private final Object d = new Object();
  private final z e;
  private final b0.c f;
  private final g2.b g;
  private final b2 h;
  private final d3 i;
  private final c3 j;
  private final y1 k;
  f3 l;
  private final r.g m;
  private final o0 n;
  private int o;
  private volatile boolean p;
  private volatile int q;
  private final q.a r;
  private final q.b s;
  private final AtomicLong t;
  private volatile u7.a<Void> u;
  private int v;
  private long w;
  private final a x;
  
  t(z paramz, ScheduledExecutorService paramScheduledExecutorService, Executor paramExecutor, b0.c paramc, c2 paramc2)
  {
    g2.b localb = new g2.b();
    this.g = localb;
    this.o = 0;
    this.p = false;
    this.q = 2;
    this.t = new AtomicLong(0L);
    this.u = f.h(null);
    this.v = 1;
    this.w = 0L;
    a locala = new a();
    this.x = locala;
    this.e = paramz;
    this.f = paramc;
    this.c = paramExecutor;
    paramc = new b(paramExecutor);
    this.b = paramc;
    localb.t(this.v);
    localb.j(n1.d(paramc));
    localb.j(locala);
    this.k = new y1(this, paramz, paramExecutor);
    this.h = new b2(this, paramScheduledExecutorService, paramExecutor, paramc2);
    this.i = new d3(this, paramz, paramExecutor);
    this.j = new c3(this, paramz, paramExecutor);
    this.l = new j3(paramz);
    this.r = new q.a(paramc2);
    this.s = new q.b(paramc2);
    this.m = new r.g(this, paramExecutor);
    this.n = new o0(this, paramz, paramc2, paramExecutor);
    paramExecutor.execute(new k(this));
  }
  
  private int C(int paramInt)
  {
    int[] arrayOfInt = (int[])this.e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
    if (arrayOfInt == null) {
      return 0;
    }
    if (J(paramInt, arrayOfInt)) {
      return paramInt;
    }
    if (J(1, arrayOfInt)) {
      return 1;
    }
    return 0;
  }
  
  private boolean I()
  {
    return E() > 0;
  }
  
  private boolean J(int paramInt, int[] paramArrayOfInt)
  {
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramInt == paramArrayOfInt[i1]) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  static boolean K(TotalCaptureResult paramTotalCaptureResult, long paramLong)
  {
    if (paramTotalCaptureResult.getRequest() == null) {
      return false;
    }
    paramTotalCaptureResult = paramTotalCaptureResult.getRequest().getTag();
    if ((paramTotalCaptureResult instanceof n2))
    {
      paramTotalCaptureResult = (Long)((n2)paramTotalCaptureResult).c("CameraControlSessionUpdateId");
      if (paramTotalCaptureResult == null) {
        return false;
      }
      if (paramTotalCaptureResult.longValue() >= paramLong) {
        return true;
      }
    }
    return false;
  }
  
  private u7.a<Void> h0(long paramLong)
  {
    return c.a(new i(this, paramLong));
  }
  
  int A(int paramInt)
  {
    int[] arrayOfInt = (int[])this.e.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
    if (arrayOfInt == null) {
      return 0;
    }
    if (J(paramInt, arrayOfInt)) {
      return paramInt;
    }
    if (J(1, arrayOfInt)) {
      return 1;
    }
    return 0;
  }
  
  int B(int paramInt)
  {
    int[] arrayOfInt = (int[])this.e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    if (arrayOfInt == null) {
      return 0;
    }
    if (J(paramInt, arrayOfInt)) {
      return paramInt;
    }
    if (J(4, arrayOfInt)) {
      return 4;
    }
    if (J(1, arrayOfInt)) {
      return 1;
    }
    return 0;
  }
  
  public c3 D()
  {
    return this.j;
  }
  
  int E()
  {
    synchronized (this.d)
    {
      int i1 = this.o;
      return i1;
    }
  }
  
  public d3 F()
  {
    return this.i;
  }
  
  public f3 G()
  {
    return this.l;
  }
  
  void H()
  {
    synchronized (this.d)
    {
      this.o += 1;
      return;
    }
  }
  
  boolean L()
  {
    return this.p;
  }
  
  void W(c paramc)
  {
    this.b.d(paramc);
  }
  
  void X(s.k paramk)
  {
    this.c.execute(new n(this, paramk));
  }
  
  void Y()
  {
    b0(1);
  }
  
  void Z(boolean paramBoolean)
  {
    this.h.m(paramBoolean);
    this.i.f(paramBoolean);
    this.j.j(paramBoolean);
    this.k.b(paramBoolean);
    this.m.s(paramBoolean);
  }
  
  public void a(g2.b paramb)
  {
    this.l.a(paramb);
  }
  
  public void a0(Rational paramRational)
  {
    this.h.n(paramRational);
  }
  
  public s0 b()
  {
    return this.m.k();
  }
  
  void b0(int paramInt)
  {
    this.v = paramInt;
    this.h.o(paramInt);
    this.n.d(this.v);
  }
  
  public u7.a<List<Void>> c(List<n0> paramList, int paramInt1, int paramInt2)
  {
    if (!I())
    {
      androidx.camera.core.n1.k("Camera2CameraControlImp", "Camera is not active.");
      return f.f(new m.a("Camera is not active."));
    }
    int i1 = w();
    return d.a(this.u).e(new g(this, paramList, paramInt1, i1, paramInt2), this.c);
  }
  
  public void c0(boolean paramBoolean)
  {
    this.l.f(paramBoolean);
  }
  
  public void d()
  {
    this.m.i().h(o.a, t.a.a());
  }
  
  void d0(List<n0> paramList)
  {
    this.f.b(paramList);
  }
  
  public void e(s0 params0)
  {
    this.m.g(j.a.e(params0).d()).h(p.a, t.a.a());
  }
  
  public void e0()
  {
    this.c.execute(new j(this));
  }
  
  public Rect f()
  {
    return (Rect)x0.h.g((Rect)this.e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
  }
  
  u7.a<Void> f0()
  {
    return f.j(c.a(new h(this)));
  }
  
  public void g(int paramInt)
  {
    if (!I())
    {
      androidx.camera.core.n1.k("Camera2CameraControlImp", "Camera is not active.");
      return;
    }
    this.q = paramInt;
    f3 localf3 = this.l;
    paramInt = this.q;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (this.q == 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    localf3.e(bool1);
    this.u = f0();
  }
  
  long g0()
  {
    this.w = this.t.getAndIncrement();
    this.f.a();
    return this.w;
  }
  
  public u7.a<Void> h(boolean paramBoolean)
  {
    if (!I()) {
      return f.f(new m.a("Camera is not active."));
    }
    return f.j(this.j.d(paramBoolean));
  }
  
  void s(c paramc)
  {
    this.b.b(paramc);
  }
  
  void t(Executor paramExecutor, s.k paramk)
  {
    this.c.execute(new m(this, paramExecutor, paramk));
  }
  
  void u()
  {
    synchronized (this.d)
    {
      int i1 = this.o;
      if (i1 != 0)
      {
        this.o = (i1 - 1);
        return;
      }
      throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
    }
  }
  
  void v(boolean paramBoolean)
  {
    this.p = paramBoolean;
    if (!paramBoolean)
    {
      n0.a locala = new n0.a();
      locala.p(this.v);
      locala.q(true);
      b.a locala1 = new b.a();
      locala1.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(A(1)));
      locala1.e(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      locala.e(locala1.c());
      d0(Collections.singletonList(locala.h()));
    }
    g0();
  }
  
  public int w()
  {
    return this.q;
  }
  
  public b2 x()
  {
    return this.h;
  }
  
  public g2 y()
  {
    this.g.t(this.v);
    this.g.r(z());
    Object localObject = this.m.k().L(null);
    if ((localObject != null) && ((localObject instanceof Integer))) {
      this.g.m("Camera2CameraControl", localObject);
    }
    this.g.m("CameraControlSessionUpdateId", Long.valueOf(this.w));
    return this.g.n();
  }
  
  s0 z()
  {
    b.a locala = new b.a();
    locala.e(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
    this.h.b(locala);
    this.r.a(locala);
    this.i.a(locala);
    if (this.p)
    {
      locala.e(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
    }
    else
    {
      i1 = this.q;
      if (i1 == 0) {
        break label90;
      }
      if (i1 == 1) {
        break label85;
      }
    }
    int i1 = 1;
    break label99;
    label85:
    i1 = 3;
    break label99;
    label90:
    i1 = this.s.a(2);
    label99:
    locala.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(A(i1)));
    locala.e(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(C(1)));
    this.k.c(locala);
    m.b localb = this.m.k();
    Iterator localIterator = localb.c().iterator();
    while (localIterator.hasNext())
    {
      s0.a locala1 = (s0.a)localIterator.next();
      locala.a().t(locala1, s0.c.a, localb.a(locala1));
    }
    return locala.c();
  }
  
  static final class a
    extends s.k
  {
    Set<s.k> a = new HashSet();
    Map<s.k, Executor> b = new ArrayMap();
    
    public void a()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        s.k localk = (s.k)localIterator.next();
        try
        {
          ((Executor)this.b.get(localk)).execute(new q(localk));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          androidx.camera.core.n1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", localRejectedExecutionException);
        }
      }
    }
    
    public void b(s.t paramt)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        s.k localk = (s.k)localIterator.next();
        try
        {
          ((Executor)this.b.get(localk)).execute(new s(localk, paramt));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          androidx.camera.core.n1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", localRejectedExecutionException);
        }
      }
    }
    
    public void c(s.m paramm)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        s.k localk = (s.k)localIterator.next();
        try
        {
          ((Executor)this.b.get(localk)).execute(new r(localk, paramm));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          androidx.camera.core.n1.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", localRejectedExecutionException);
        }
      }
    }
    
    void g(Executor paramExecutor, s.k paramk)
    {
      this.a.add(paramk);
      this.b.put(paramk, paramExecutor);
    }
    
    void k(s.k paramk)
    {
      this.a.remove(paramk);
      this.b.remove(paramk);
    }
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    final Set<t.c> a = new HashSet();
    private final Executor b;
    
    b(Executor paramExecutor)
    {
      this.b = paramExecutor;
    }
    
    void b(t.c paramc)
    {
      this.a.add(paramc);
    }
    
    void d(t.c paramc)
    {
      this.a.remove(paramc);
    }
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      this.b.execute(new u(this, paramTotalCaptureResult));
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(TotalCaptureResult paramTotalCaptureResult);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.t
 * JD-Core Version:    0.7.0.1
 */