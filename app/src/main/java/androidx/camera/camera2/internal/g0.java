package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.n1;
import androidx.camera.core.u.a;
import androidx.camera.core.v2;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import n.m0;
import p.l;
import s.b0.c;
import s.g2;
import s.g2.b;
import s.g2.c;
import s.g2.g;
import s.h2;
import s.j0.b;
import s.m1;
import s.n0;
import s.n0.a;
import s.r1;
import s.r2;
import s.t2;
import s.v0;
import s.v0.a;
import u.c;
import x0.h;

final class g0
  implements s.g0
{
  boolean A;
  private final x1 B;
  private final r2 a;
  private final m0 b;
  private final Executor c;
  private final ScheduledExecutorService d;
  volatile f e = f.a;
  private final r1<s.g0.a> f;
  private final k1 g;
  private final t h;
  private final g i;
  final j0 j;
  CameraDevice k;
  int l;
  t1 m;
  final AtomicInteger n;
  c.a<Void> o;
  final Map<t1, u7.a<Void>> p;
  private final d q;
  private final s.j0 r;
  final Set<s1> s;
  private e2 t;
  private final v1 u;
  private final x2.a v;
  private final Set<String> w;
  private s.w x;
  final Object y;
  private h2 z;
  
  g0(m0 paramm0, String paramString, j0 paramj0, s.j0 paramj01, Executor paramExecutor, Handler paramHandler, x1 paramx1)
  {
    Object localObject = new r1();
    this.f = ((r1)localObject);
    this.l = 0;
    this.n = new AtomicInteger(0);
    this.p = new LinkedHashMap();
    this.s = new HashSet();
    this.w = new HashSet();
    this.y = new Object();
    this.A = false;
    this.b = paramm0;
    this.r = paramj01;
    ScheduledExecutorService localScheduledExecutorService = t.a.e(paramHandler);
    this.d = localScheduledExecutorService;
    paramExecutor = t.a.f(paramExecutor);
    this.c = paramExecutor;
    this.i = new g(paramExecutor, localScheduledExecutorService);
    this.a = new r2(paramString);
    ((r1)localObject).g(s.g0.a.f);
    localObject = new k1(paramj01);
    this.g = ((k1)localObject);
    v1 localv1 = new v1(paramExecutor);
    this.u = localv1;
    this.B = paramx1;
    this.m = X();
    try
    {
      paramx1 = new t(paramm0.c(paramString), localScheduledExecutorService, paramExecutor, new e(), paramj0.f());
      this.h = paramx1;
      this.j = paramj0;
      paramj0.m(paramx1);
      paramj0.p(((k1)localObject).a());
      this.v = new x2.a(paramExecutor, localScheduledExecutorService, paramHandler, localv1, paramj0.f(), l.b());
      paramString = new d(paramString);
      this.q = paramString;
      paramj01.e(this, paramExecutor, paramString);
      paramm0.f(paramExecutor, paramString);
      return;
    }
    catch (n.f paramm0)
    {
      throw l1.a(paramm0);
    }
  }
  
  private boolean A(n0.a parama)
  {
    if (!parama.l().isEmpty()) {}
    for (parama = "The capture config builder already has surface inside.";; parama = "Unable to find a repeating surface to attach to CaptureConfig")
    {
      n1.k("Camera2CameraImpl", parama);
      return false;
      Iterator localIterator = this.a.e().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = ((g2)localIterator.next()).h().e();
        if (!((List)localObject).isEmpty())
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.f((v0)((Iterator)localObject).next());
          }
        }
      }
      if (!parama.l().isEmpty()) {
        break;
      }
    }
    return true;
  }
  
  private void C()
  {
    F("Closing camera.");
    int i1 = c.a[this.e.ordinal()];
    boolean bool = false;
    if (i1 != 2)
    {
      if (i1 != 4)
      {
        if ((i1 != 5) && (i1 != 6))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("close() ignored due to being in state: ");
          localStringBuilder.append(this.e);
          F(localStringBuilder.toString());
          return;
        }
        bool = this.i.a();
        i0(f.e);
        if (bool)
        {
          h.i(M());
          I();
        }
      }
      else
      {
        i0(f.e);
        B(false);
      }
    }
    else
    {
      if (this.k == null) {
        bool = true;
      }
      h.i(bool);
      i0(f.a);
    }
  }
  
  private void D(boolean paramBoolean)
  {
    s1 locals1 = new s1();
    this.s.add(locals1);
    h0(paramBoolean);
    Object localObject2 = new SurfaceTexture(0);
    ((SurfaceTexture)localObject2).setDefaultBufferSize(640, 480);
    Object localObject1 = new Surface((SurfaceTexture)localObject2);
    localObject2 = new w((Surface)localObject1, (SurfaceTexture)localObject2);
    g2.b localb = new g2.b();
    localObject1 = new m1((Surface)localObject1);
    localb.h((v0)localObject1);
    localb.t(1);
    F("Start configAndClose.");
    locals1.g(localb.n(), (CameraDevice)h.g(this.k), this.v.a()).h(new x(this, locals1, (v0)localObject1, (Runnable)localObject2), this.c);
  }
  
  private CameraDevice.StateCallback E()
  {
    ArrayList localArrayList = new ArrayList(this.a.f().b().b());
    localArrayList.add(this.u.c());
    localArrayList.add(this.i);
    return i1.a(localArrayList);
  }
  
  private void G(String paramString, Throwable paramThrowable)
  {
    n1.b("Camera2CameraImpl", String.format("{%s} %s", new Object[] { toString(), paramString }), paramThrowable);
  }
  
  static String J(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return "UNKNOWN ERROR";
              }
              return "ERROR_CAMERA_SERVICE";
            }
            return "ERROR_CAMERA_DEVICE";
          }
          return "ERROR_CAMERA_DISABLED";
        }
        return "ERROR_MAX_CAMERAS_IN_USE";
      }
      return "ERROR_CAMERA_IN_USE";
    }
    return "ERROR_NONE";
  }
  
  static String K(v2 paramv2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramv2.j());
    localStringBuilder.append(paramv2.hashCode());
    return localStringBuilder.toString();
  }
  
  private boolean L()
  {
    return ((j0)i()).l() == 2;
  }
  
  private t1 X()
  {
    synchronized (this.y)
    {
      if (this.z == null)
      {
        localObject2 = new s1();
        return localObject2;
      }
      Object localObject2 = new j2(this.z, this.j, this.c, this.d);
      return localObject2;
    }
  }
  
  private void Y(List<v2> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      v2 localv2 = (v2)paramList.next();
      String str = K(localv2);
      if (!this.w.contains(str))
      {
        this.w.add(str);
        localv2.C();
      }
    }
  }
  
  private void Z(List<v2> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      v2 localv2 = (v2)paramList.next();
      String str = K(localv2);
      if (this.w.contains(str))
      {
        localv2.D();
        this.w.remove(str);
      }
    }
  }
  
  @SuppressLint({"MissingPermission"})
  private void a0(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.i.d();
    }
    this.i.a();
    F("Opening camera.");
    i0(f.c);
    try
    {
      this.b.e(this.j.c(), this.c, E());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to open camera due to ");
      localStringBuilder.append(localSecurityException.getMessage());
      F(localStringBuilder.toString());
      i0(f.f);
      this.i.e();
      return;
    }
    catch (n.f localf)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to open camera due to ");
      localStringBuilder.append(localf.getMessage());
      F(localStringBuilder.toString());
      if (localf.d() != 10001) {
        return;
      }
      j0(f.a, u.a.b(7, localf));
    }
  }
  
  private void c0()
  {
    int i1 = c.a[this.e.ordinal()];
    boolean bool = false;
    if ((i1 != 1) && (i1 != 2))
    {
      if (i1 != 3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("open() ignored due to being in state: ");
        localStringBuilder.append(this.e);
        F(localStringBuilder.toString());
        return;
      }
      i0(f.f);
      if ((!M()) && (this.l == 0))
      {
        if (this.k != null) {
          bool = true;
        }
        h.j(bool, "Camera Device should be open if session close is not complete");
        i0(f.d);
        b0();
      }
    }
    else
    {
      p0(false);
    }
  }
  
  private void g0()
  {
    if (this.t != null)
    {
      r2 localr2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.c());
      localStringBuilder.append(this.t.hashCode());
      localr2.s(localStringBuilder.toString());
      localr2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.c());
      localStringBuilder.append(this.t.hashCode());
      localr2.t(localStringBuilder.toString());
      this.t.b();
      this.t = null;
    }
  }
  
  private Collection<h> m0(Collection<v2> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(h.b((v2)paramCollection.next()));
    }
    return localArrayList;
  }
  
  private void n0(Collection<h> paramCollection)
  {
    boolean bool = this.a.g().isEmpty();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramCollection.iterator();
    paramCollection = null;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (h)((Iterator)localObject1).next();
      if (!this.a.l(((h)localObject2).f()))
      {
        this.a.r(((h)localObject2).f(), ((h)localObject2).c(), ((h)localObject2).e());
        localArrayList.add(((h)localObject2).f());
        if (((h)localObject2).g() == androidx.camera.core.w1.class)
        {
          localObject2 = ((h)localObject2).d();
          if (localObject2 != null) {
            paramCollection = new Rational(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
          }
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Use cases [");
    ((StringBuilder)localObject1).append(TextUtils.join(", ", localArrayList));
    ((StringBuilder)localObject1).append("] now ATTACHED");
    F(((StringBuilder)localObject1).toString());
    if (bool)
    {
      this.h.Z(true);
      this.h.H();
    }
    z();
    s0();
    r0();
    h0(false);
    if (this.e == f.d) {
      b0();
    } else {
      c0();
    }
    if (paramCollection != null) {
      this.h.a0(paramCollection);
    }
  }
  
  private void o0(Collection<h> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    int i1 = 0;
    while (paramCollection.hasNext())
    {
      h localh = (h)paramCollection.next();
      if (this.a.l(localh.f()))
      {
        this.a.p(localh.f());
        localArrayList.add(localh.f());
        if (localh.g() == androidx.camera.core.w1.class) {
          i1 = 1;
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    paramCollection = new StringBuilder();
    paramCollection.append("Use cases [");
    paramCollection.append(TextUtils.join(", ", localArrayList));
    paramCollection.append("] now DETACHED for camera");
    F(paramCollection.toString());
    if (i1 != 0) {
      this.h.a0(null);
    }
    z();
    if (this.a.h().isEmpty()) {
      this.h.c0(false);
    } else {
      s0();
    }
    if (this.a.g().isEmpty())
    {
      this.h.u();
      h0(false);
      this.h.Z(false);
      this.m = X();
      C();
      return;
    }
    r0();
    h0(false);
    if (this.e == f.d) {
      b0();
    }
  }
  
  private void s0()
  {
    Iterator localIterator = this.a.h().iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((t2)localIterator.next()).w(false);
    }
    this.h.c0(bool);
  }
  
  private void y()
  {
    if (this.t != null)
    {
      r2 localr2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.c());
      localStringBuilder.append(this.t.hashCode());
      localr2.r(localStringBuilder.toString(), this.t.e(), this.t.f());
      localr2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.t.c());
      localStringBuilder.append(this.t.hashCode());
      localr2.q(localStringBuilder.toString(), this.t.e(), this.t.f());
    }
  }
  
  private void z()
  {
    Object localObject = this.a.f().b();
    n0 localn0 = ((g2)localObject).h();
    int i1 = localn0.e().size();
    int i2 = ((g2)localObject).k().size();
    if (!((g2)localObject).k().isEmpty())
    {
      if (localn0.e().isEmpty())
      {
        if (this.t == null) {
          this.t = new e2(this.j.i(), this.B);
        }
        y();
        return;
      }
      if (((i2 == 1) && (i1 == 1)) || (i1 >= 2))
      {
        g0();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mMeteringRepeating is ATTACHED, SessionConfig Surfaces: ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(", CaptureConfig Surfaces: ");
      ((StringBuilder)localObject).append(i1);
      n1.a("Camera2CameraImpl", ((StringBuilder)localObject).toString());
    }
  }
  
  void B(boolean paramBoolean)
  {
    boolean bool;
    if ((this.e != f.e) && (this.e != f.g) && ((this.e != f.f) || (this.l == 0))) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" (error: ");
    localStringBuilder.append(J(this.l));
    localStringBuilder.append(")");
    h.j(bool, localStringBuilder.toString());
    int i1 = Build.VERSION.SDK_INT;
    if ((i1 > 23) && (i1 < 29) && (L()) && (this.l == 0)) {
      D(paramBoolean);
    } else {
      h0(paramBoolean);
    }
    this.m.f();
  }
  
  void F(String paramString)
  {
    G(paramString, null);
  }
  
  g2 H(v0 paramv0)
  {
    Iterator localIterator = this.a.g().iterator();
    while (localIterator.hasNext())
    {
      g2 localg2 = (g2)localIterator.next();
      if (localg2.k().contains(paramv0)) {
        return localg2;
      }
    }
    return null;
  }
  
  void I()
  {
    boolean bool;
    if ((this.e != f.g) && (this.e != f.e)) {
      bool = false;
    } else {
      bool = true;
    }
    h.i(bool);
    h.i(this.p.isEmpty());
    this.k = null;
    if (this.e == f.e)
    {
      i0(f.a);
      return;
    }
    this.b.g(this.q);
    i0(f.h);
    c.a locala = this.o;
    if (locala != null)
    {
      locala.c(null);
      this.o = null;
    }
  }
  
  boolean M()
  {
    return (this.p.isEmpty()) && (this.s.isEmpty());
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.execute(new e0(this, paramBoolean));
  }
  
  public void b(v2 paramv2)
  {
    h.g(paramv2);
    String str = K(paramv2);
    g2 localg2 = paramv2.l();
    paramv2 = paramv2.g();
    this.c.execute(new b0(this, str, localg2, paramv2));
  }
  
  void b0()
  {
    boolean bool;
    if (this.e == f.d) {
      bool = true;
    } else {
      bool = false;
    }
    h.i(bool);
    g2.g localg = this.a.f();
    if (!localg.e())
    {
      F("Unable to create capture session due to conflicting configurations");
      return;
    }
    u.f.b(this.m.g(localg.b(), (CameraDevice)h.g(this.k), this.v.a()), new b(), this.c);
  }
  
  public void d(v2 paramv2)
  {
    h.g(paramv2);
    String str = K(paramv2);
    g2 localg2 = paramv2.l();
    paramv2 = paramv2.g();
    this.c.execute(new a0(this, str, localg2, paramv2));
  }
  
  void d0(g2 paramg2)
  {
    ScheduledExecutorService localScheduledExecutorService = t.a.d();
    Object localObject = paramg2.c();
    if (!((List)localObject).isEmpty())
    {
      localObject = (g2.c)((List)localObject).get(0);
      G("Posting surface closed", new Throwable());
      localScheduledExecutorService.execute(new f0((g2.c)localObject, paramg2));
    }
  }
  
  void e0(s1 params1, v0 paramv0, Runnable paramRunnable)
  {
    this.s.remove(params1);
    params1 = f0(params1, false);
    paramv0.c();
    u.f.n(Arrays.asList(new u7.a[] { params1, paramv0.i() })).h(paramRunnable, t.a.a());
  }
  
  public void f(Collection<v2> paramCollection)
  {
    paramCollection = new ArrayList(paramCollection);
    if (paramCollection.isEmpty()) {
      return;
    }
    this.h.H();
    Y(new ArrayList(paramCollection));
    paramCollection = new ArrayList(m0(paramCollection));
    try
    {
      this.c.execute(new c0(this, paramCollection));
      return;
    }
    catch (RejectedExecutionException paramCollection)
    {
      G("Unable to attach use cases.", paramCollection);
      this.h.u();
    }
  }
  
  u7.a<Void> f0(final t1 paramt1, boolean paramBoolean)
  {
    paramt1.close();
    u7.a locala = paramt1.a(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Releasing session in state ");
    localStringBuilder.append(this.e.name());
    F(localStringBuilder.toString());
    this.p.put(paramt1, locala);
    u.f.b(locala, new a(paramt1), t.a.a());
    return locala;
  }
  
  public void g(Collection<v2> paramCollection)
  {
    paramCollection = new ArrayList(paramCollection);
    if (paramCollection.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList(m0(paramCollection));
    Z(new ArrayList(paramCollection));
    this.c.execute(new d0(this, localArrayList));
  }
  
  public void h(s.w paramw)
  {
    ??? = paramw;
    if (paramw == null) {
      ??? = s.a0.a();
    }
    paramw = ((s.w)???).v(null);
    this.x = ((s.w)???);
    synchronized (this.y)
    {
      this.z = paramw;
      return;
    }
  }
  
  void h0(boolean paramBoolean)
  {
    boolean bool;
    if (this.m != null) {
      bool = true;
    } else {
      bool = false;
    }
    h.i(bool);
    F("Resetting Capture Session");
    t1 localt11 = this.m;
    g2 localg2 = localt11.d();
    List localList = localt11.b();
    t1 localt12 = X();
    this.m = localt12;
    localt12.e(localg2);
    this.m.c(localList);
    f0(localt11, paramBoolean);
  }
  
  public s.e0 i()
  {
    return this.j;
  }
  
  void i0(f paramf)
  {
    j0(paramf, null);
  }
  
  public void j(v2 paramv2)
  {
    h.g(paramv2);
    paramv2 = K(paramv2);
    this.c.execute(new y(this, paramv2));
  }
  
  void j0(f paramf, u.a parama)
  {
    k0(paramf, parama, true);
  }
  
  public void k(v2 paramv2)
  {
    h.g(paramv2);
    String str = K(paramv2);
    g2 localg2 = paramv2.l();
    paramv2 = paramv2.g();
    this.c.execute(new z(this, str, localg2, paramv2));
  }
  
  void k0(f paramf, u.a parama, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Transitioning camera internal state: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" --> ");
    localStringBuilder.append(paramf);
    F(localStringBuilder.toString());
    this.e = paramf;
    switch (c.a[paramf.ordinal()])
    {
    default: 
      parama = new StringBuilder();
      parama.append("Unknown state: ");
      parama.append(paramf);
      throw new IllegalStateException(parama.toString());
    case 8: 
      paramf = s.g0.a.h;
      break;
    case 7: 
      paramf = s.g0.a.g;
      break;
    case 5: 
    case 6: 
      paramf = s.g0.a.c;
      break;
    case 4: 
      paramf = s.g0.a.d;
      break;
    case 3: 
      paramf = s.g0.a.e;
      break;
    case 2: 
      paramf = s.g0.a.b;
      break;
    case 1: 
      paramf = s.g0.a.f;
    }
    this.r.c(this, paramf, paramBoolean);
    this.f.g(paramf);
    this.g.c(paramf, parama);
  }
  
  public s.w1<s.g0.a> l()
  {
    return this.f;
  }
  
  void l0(List<n0> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      n0 localn0 = (n0)paramList.next();
      n0.a locala = n0.a.k(localn0);
      if ((localn0.g() == 5) && (localn0.c() != null)) {
        locala.n(localn0.c());
      }
      if ((!localn0.e().isEmpty()) || (!localn0.h()) || (A(locala))) {
        localArrayList.add(locala.h());
      }
    }
    F("Issue capture request");
    this.m.c(localArrayList);
  }
  
  public s.b0 m()
  {
    return this.h;
  }
  
  public s.w n()
  {
    return this.x;
  }
  
  void p0(boolean paramBoolean)
  {
    F("Attempting to force open the camera.");
    if (!this.r.f(this))
    {
      F("No cameras available. Waiting for available camera before opening camera.");
      i0(f.b);
      return;
    }
    a0(paramBoolean);
  }
  
  void q0(boolean paramBoolean)
  {
    F("Attempting to open the camera.");
    int i1;
    if ((this.q.b()) && (this.r.f(this))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      F("No cameras available. Waiting for available camera before opening camera.");
      i0(f.b);
      return;
    }
    a0(paramBoolean);
  }
  
  void r0()
  {
    Object localObject = this.a.d();
    if (((g2.g)localObject).e())
    {
      g2 localg2 = ((g2.g)localObject).b();
      this.h.b0(localg2.l());
      ((g2.g)localObject).a(this.h.y());
      localObject = ((g2.g)localObject).b();
      this.m.e((g2)localObject);
      return;
    }
    this.h.Y();
    this.m.e(this.h.y());
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Camera@%x[id=%s]", new Object[] { Integer.valueOf(hashCode()), this.j.c() });
  }
  
  class a
    implements c<Void>
  {
    a(t1 paramt1) {}
    
    public void a(Throwable paramThrowable) {}
    
    public void c(Void paramVoid)
    {
      g0.this.p.remove(paramt1);
      int i = g0.c.a[g0.this.e.ordinal()];
      if (i != 3) {
        if (i != 6)
        {
          if (i == 7) {}
        }
        else if (g0.this.l == 0) {
          return;
        }
      }
      if (g0.this.M())
      {
        paramVoid = g0.this.k;
        if (paramVoid != null)
        {
          n.a.a(paramVoid);
          g0.this.k = null;
        }
      }
    }
  }
  
  class b
    implements c<Void>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
    {
      if ((paramThrowable instanceof v0.a))
      {
        paramThrowable = g0.this.H(((v0.a)paramThrowable).a());
        if (paramThrowable != null) {
          g0.this.d0(paramThrowable);
        }
        return;
      }
      if ((paramThrowable instanceof CancellationException))
      {
        g0.this.F("Unable to configure camera cancelled");
        return;
      }
      Object localObject1 = g0.this.e;
      Object localObject2 = g0.f.d;
      if (localObject1 == localObject2) {
        g0.this.j0((g0.f)localObject2, u.a.b(4, paramThrowable));
      }
      if ((paramThrowable instanceof CameraAccessException))
      {
        localObject1 = g0.this;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unable to configure camera due to ");
        ((StringBuilder)localObject2).append(paramThrowable.getMessage());
        ((g0)localObject1).F(((StringBuilder)localObject2).toString());
        return;
      }
      if ((paramThrowable instanceof TimeoutException))
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append("Unable to configure camera ");
        paramThrowable.append(g0.this.j.c());
        paramThrowable.append(", timeout!");
        n1.c("Camera2CameraImpl", paramThrowable.toString());
      }
    }
    
    public void c(Void paramVoid) {}
  }
  
  final class d
    extends CameraManager.AvailabilityCallback
    implements j0.b
  {
    private final String a;
    private boolean b = true;
    
    d(String paramString)
    {
      this.a = paramString;
    }
    
    public void a()
    {
      if (g0.this.e == g0.f.b) {
        g0.this.q0(false);
      }
    }
    
    boolean b()
    {
      return this.b;
    }
    
    public void onCameraAvailable(String paramString)
    {
      if (!this.a.equals(paramString)) {
        return;
      }
      this.b = true;
      if (g0.this.e == g0.f.b) {
        g0.this.q0(false);
      }
    }
    
    public void onCameraUnavailable(String paramString)
    {
      if (!this.a.equals(paramString)) {
        return;
      }
      this.b = false;
    }
  }
  
  final class e
    implements b0.c
  {
    e() {}
    
    public void a()
    {
      g0.this.r0();
    }
    
    public void b(List<n0> paramList)
    {
      g0.this.l0((List)h.g(paramList));
    }
  }
  
  static enum f
  {
    static
    {
      f localf1 = new f("INITIALIZED", 0);
      a = localf1;
      f localf2 = new f("PENDING_OPEN", 1);
      b = localf2;
      f localf3 = new f("OPENING", 2);
      c = localf3;
      f localf4 = new f("OPENED", 3);
      d = localf4;
      f localf5 = new f("CLOSING", 4);
      e = localf5;
      f localf6 = new f("REOPENING", 5);
      f = localf6;
      f localf7 = new f("RELEASING", 6);
      g = localf7;
      f localf8 = new f("RELEASED", 7);
      h = localf8;
      i = new f[] { localf1, localf2, localf3, localf4, localf5, localf6, localf7, localf8 };
    }
    
    private f() {}
  }
  
  final class g
    extends CameraDevice.StateCallback
  {
    private final Executor a;
    private final ScheduledExecutorService b;
    private b c;
    ScheduledFuture<?> d;
    private final a e = new a();
    
    g(Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
    {
      this.a = paramExecutor;
      this.b = paramScheduledExecutorService;
    }
    
    private void b(CameraDevice paramCameraDevice, int paramInt)
    {
      boolean bool;
      if ((g0.this.e != g0.f.c) && (g0.this.e != g0.f.d) && (g0.this.e != g0.f.f)) {
        bool = false;
      } else {
        bool = true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Attempt to handle open error from non open state: ");
      localStringBuilder.append(g0.this.e);
      h.j(bool, localStringBuilder.toString());
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error observed on open (or opening) camera device ");
        localStringBuilder.append(paramCameraDevice.getId());
        localStringBuilder.append(": ");
        localStringBuilder.append(g0.J(paramInt));
        localStringBuilder.append(" closing camera.");
        n1.c("Camera2CameraImpl", localStringBuilder.toString());
        if (paramInt == 3) {
          paramInt = 5;
        } else {
          paramInt = 6;
        }
        g0.this.j0(g0.f.e, u.a.a(paramInt));
        g0.this.B(false);
        return;
      }
      n1.a("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", new Object[] { paramCameraDevice.getId(), g0.J(paramInt) }));
      c(paramInt);
    }
    
    private void c(int paramInt)
    {
      int j = g0.this.l;
      int i = 1;
      boolean bool;
      if (j != 0) {
        bool = true;
      } else {
        bool = false;
      }
      h.j(bool, "Can only reopen camera device after error if the camera device is actually in an error state.");
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          i = 3;
        }
      }
      else {
        i = 2;
      }
      g0.this.j0(g0.f.f, u.a.a(i));
      g0.this.B(false);
    }
    
    boolean a()
    {
      Object localObject = this.d;
      boolean bool = false;
      if (localObject != null)
      {
        localObject = g0.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cancelling scheduled re-open: ");
        localStringBuilder.append(this.c);
        ((g0)localObject).F(localStringBuilder.toString());
        this.c.b();
        this.c = null;
        this.d.cancel(false);
        this.d = null;
        bool = true;
      }
      return bool;
    }
    
    void d()
    {
      this.e.e();
    }
    
    void e()
    {
      Object localObject = this.c;
      boolean bool2 = true;
      boolean bool1;
      if (localObject == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      h.i(bool1);
      if (this.d == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      h.i(bool1);
      if (this.e.a())
      {
        this.c = new b(this.a);
        localObject = g0.this;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Attempting camera re-open in ");
        localStringBuilder.append(this.e.c());
        localStringBuilder.append("ms: ");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" activeResuming = ");
        localStringBuilder.append(g0.this.A);
        ((g0)localObject).F(localStringBuilder.toString());
        this.d = this.b.schedule(this.c, this.e.c(), TimeUnit.MILLISECONDS);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Camera reopening attempted for ");
      ((StringBuilder)localObject).append(this.e.d());
      ((StringBuilder)localObject).append("ms without success.");
      n1.c("Camera2CameraImpl", ((StringBuilder)localObject).toString());
      g0.this.k0(g0.f.b, null, false);
    }
    
    boolean f()
    {
      g0 localg0 = g0.this;
      boolean bool2 = localg0.A;
      boolean bool1 = true;
      if (bool2)
      {
        int i = localg0.l;
        if (i == 1) {
          return bool1;
        }
        if (i == 2) {
          return true;
        }
      }
      bool1 = false;
      return bool1;
    }
    
    public void onClosed(CameraDevice paramCameraDevice)
    {
      g0.this.F("CameraDevice.onClosed()");
      boolean bool;
      if (g0.this.k == null) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected onClose callback on camera device: ");
      localStringBuilder.append(paramCameraDevice);
      h.j(bool, localStringBuilder.toString());
      int i = g0.c.a[g0.this.e.ordinal()];
      if (i != 3) {
        if (i != 6)
        {
          if (i != 7)
          {
            paramCameraDevice = new StringBuilder();
            paramCameraDevice.append("Camera closed while in state: ");
            paramCameraDevice.append(g0.this.e);
            throw new IllegalStateException(paramCameraDevice.toString());
          }
        }
        else
        {
          paramCameraDevice = g0.this;
          if (paramCameraDevice.l != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Camera closed due to error: ");
            localStringBuilder.append(g0.J(g0.this.l));
            paramCameraDevice.F(localStringBuilder.toString());
            e();
            return;
          }
          paramCameraDevice.q0(false);
          return;
        }
      }
      h.i(g0.this.M());
      g0.this.I();
    }
    
    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      g0.this.F("CameraDevice.onDisconnected()");
      onError(paramCameraDevice, 1);
    }
    
    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      g0 localg0 = g0.this;
      localg0.k = paramCameraDevice;
      localg0.l = paramInt;
      int i = g0.c.a[localg0.e.ordinal()];
      if (i != 3) {
        if ((i != 4) && (i != 5) && (i != 6))
        {
          if (i != 7)
          {
            paramCameraDevice = new StringBuilder();
            paramCameraDevice.append("onError() should not be possible from state: ");
            paramCameraDevice.append(g0.this.e);
            throw new IllegalStateException(paramCameraDevice.toString());
          }
        }
        else
        {
          n1.a("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", new Object[] { paramCameraDevice.getId(), g0.J(paramInt), g0.this.e.name() }));
          b(paramCameraDevice, paramInt);
          return;
        }
      }
      n1.c("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", new Object[] { paramCameraDevice.getId(), g0.J(paramInt), g0.this.e.name() }));
      g0.this.B(false);
    }
    
    public void onOpened(CameraDevice paramCameraDevice)
    {
      g0.this.F("CameraDevice.onOpened()");
      g0 localg0 = g0.this;
      localg0.k = paramCameraDevice;
      localg0.l = 0;
      d();
      int i = g0.c.a[g0.this.e.ordinal()];
      if (i != 3) {
        if ((i != 5) && (i != 6))
        {
          if (i != 7)
          {
            paramCameraDevice = new StringBuilder();
            paramCameraDevice.append("onOpened() should not be possible from state: ");
            paramCameraDevice.append(g0.this.e);
            throw new IllegalStateException(paramCameraDevice.toString());
          }
        }
        else
        {
          g0.this.i0(g0.f.d);
          g0.this.b0();
          return;
        }
      }
      h.i(g0.this.M());
      g0.this.k.close();
      g0.this.k = null;
    }
    
    class a
    {
      private long a = -1L;
      
      a() {}
      
      boolean a()
      {
        int i;
        if (b() >= d()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          e();
          return false;
        }
        return true;
      }
      
      long b()
      {
        long l = SystemClock.uptimeMillis();
        if (this.a == -1L) {
          this.a = l;
        }
        return l - this.a;
      }
      
      int c()
      {
        if (!g0.g.this.f()) {
          return 700;
        }
        long l = b();
        if (l <= 120000L) {
          return 1000;
        }
        if (l <= 300000L) {
          return 2000;
        }
        return 4000;
      }
      
      int d()
      {
        if (!g0.g.this.f()) {
          return 10000;
        }
        return 1800000;
      }
      
      void e()
      {
        this.a = -1L;
      }
    }
    
    class b
      implements Runnable
    {
      private Executor a;
      private boolean b = false;
      
      b(Executor paramExecutor)
      {
        this.a = paramExecutor;
      }
      
      void b()
      {
        this.b = true;
      }
      
      public void run()
      {
        this.a.execute(new h0(this));
      }
    }
  }
  
  static abstract class h
  {
    static h a(String paramString, Class<?> paramClass, g2 paramg2, t2<?> paramt2, Size paramSize)
    {
      return new b(paramString, paramClass, paramg2, paramt2, paramSize);
    }
    
    static h b(v2 paramv2)
    {
      return a(g0.K(paramv2), paramv2.getClass(), paramv2.l(), paramv2.g(), paramv2.c());
    }
    
    abstract g2 c();
    
    abstract Size d();
    
    abstract t2<?> e();
    
    abstract String f();
    
    abstract Class<?> g();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.g0
 * JD-Core Version:    0.7.0.1
 */