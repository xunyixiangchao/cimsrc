package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.location.Location;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.g3;
import androidx.concurrent.futures.c.a;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import s.c2;
import s.e0;
import s.e2;
import s.g0;
import s.g2.b;
import s.h1;
import s.j1;
import s.k;
import s.l1.a;
import s.m0;
import s.m1;
import s.n0.a;
import s.s0.a;
import s.t1;
import s.t2;
import s.t2.a;
import s.u1;
import s.u2;
import s.u2.b;
import s.v1;
import s.w;
import s.y1;
import u.f;
import v.g;
import v.i;
import v.m;
import v.p;
import x0.h;
import z.b;

public final class z0
  extends v2
{
  public static final j H = new j();
  static final y.a I = new y.a();
  a2 A;
  private u7.a<Void> B = f.h(null);
  private k C;
  private s.v0 D;
  private l E;
  final Executor F;
  private Matrix G = new Matrix();
  private final l1.a l = o0.a;
  final Executor m;
  private final int n;
  private final AtomicReference<Integer> o = new AtomicReference(null);
  private final int p;
  private int q = -1;
  private Rational r = null;
  private ExecutorService s;
  private s.n0 t;
  private m0 u;
  private int v;
  private s.p0 w;
  private boolean x = false;
  g2.b y;
  i2 z;
  
  z0(s.e1 parame1)
  {
    super(parame1);
    parame1 = (s.e1)g();
    int i;
    if (parame1.b(s.e1.B)) {
      i = parame1.J();
    } else {
      i = 1;
    }
    this.n = i;
    this.p = parame1.M(0);
    parame1 = (Executor)h.g(parame1.O(t.a.c()));
    this.m = parame1;
    this.F = t.a.f(parame1);
  }
  
  private u7.a<e1> A0(k paramk)
  {
    return androidx.concurrent.futures.c.a(new r0(this, paramk));
  }
  
  private void B0()
  {
    synchronized (this.o)
    {
      if (this.o.get() != null) {
        return;
      }
      e().g(e0());
      return;
    }
  }
  
  private void W()
  {
    if (this.E != null)
    {
      l locall = new l("Camera is closed.");
      this.E.b(locall);
    }
  }
  
  static Rect Y(Rect paramRect, Rational paramRational, int paramInt1, Size paramSize, int paramInt2)
  {
    if (paramRect != null) {
      return b.b(paramRect, paramInt1, paramSize, paramInt2);
    }
    if (paramRational != null)
    {
      paramRect = paramRational;
      if (paramInt2 % 180 != 0) {
        paramRect = new Rational(paramRational.getDenominator(), paramRational.getNumerator());
      }
      if (b.g(paramSize, paramRect)) {
        return b.a(paramSize, paramRect);
      }
    }
    return new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
  }
  
  static boolean a0(t1 paramt1)
  {
    s0.a locala = s.e1.I;
    Boolean localBoolean = Boolean.FALSE;
    boolean bool1 = ((Boolean)paramt1.e(locala, localBoolean)).booleanValue();
    boolean bool2 = false;
    boolean bool3 = false;
    if (bool1)
    {
      bool1 = true;
      int i = Build.VERSION.SDK_INT;
      if (i < 26)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Software JPEG only supported on API 26+, but current API level is ");
        ((StringBuilder)localObject).append(i);
        n1.k("ImageCapture", ((StringBuilder)localObject).toString());
        bool1 = false;
      }
      Object localObject = (Integer)paramt1.e(s.e1.F, null);
      if ((localObject != null) && (((Integer)localObject).intValue() != 256))
      {
        n1.k("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
        bool1 = bool3;
      }
      bool2 = bool1;
      if (!bool1)
      {
        n1.k("ImageCapture", "Unable to support software JPEG. Disabling.");
        paramt1.G(locala, localBoolean);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  private m0 b0(m0 paramm0)
  {
    List localList = this.u.c();
    m0 localm0 = paramm0;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return paramm0;
      }
      localm0 = b0.a(localList);
    }
    return localm0;
  }
  
  static int d0(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof l)) {
      return 3;
    }
    if ((paramThrowable instanceof c1)) {
      return ((c1)paramThrowable).a();
    }
    return 0;
  }
  
  private int f0(g0 paramg0, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = k(paramg0);
      paramg0 = c();
      Rect localRect = Y(o(), this.r, i, paramg0, i);
      if (b.m(paramg0.getWidth(), paramg0.getHeight(), localRect.width(), localRect.height()))
      {
        if (this.n == 0) {
          return 100;
        }
        return 95;
      }
    }
    return g0();
  }
  
  private int g0()
  {
    Object localObject = (s.e1)g();
    if (((s.e1)localObject).b(s.e1.K)) {
      return ((s.e1)localObject).P();
    }
    int i = this.n;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CaptureMode ");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(" is invalid");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      return 95;
    }
    return 100;
  }
  
  private static boolean h0(List<Pair<Integer, Size[]>> paramList, int paramInt)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Integer)((Pair)paramList.next()).first).equals(Integer.valueOf(paramInt))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean i0()
  {
    Object localObject = d();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = d().n();
    if (localObject == null) {
      return false;
    }
    if (((w)localObject).v(null) != null) {
      bool = true;
    }
    return bool;
  }
  
  private void w0()
  {
    synchronized (this.o)
    {
      if (this.o.get() != null) {
        return;
      }
      this.o.set(Integer.valueOf(e0()));
      return;
    }
  }
  
  private void x0(Executor paramExecutor, n paramn, boolean paramBoolean)
  {
    g0 localg0 = d();
    if (localg0 == null)
    {
      paramExecutor.execute(new t0(this, paramn));
      return;
    }
    l locall = this.E;
    if (locall == null)
    {
      paramExecutor.execute(new s0(paramn));
      return;
    }
    locall.d(new k(k(localg0), f0(localg0, paramBoolean), this.r, o(), this.G, paramExecutor, paramn));
  }
  
  public void A()
  {
    u7.a locala = this.B;
    W();
    X();
    this.x = false;
    locala.h(new v0(this.s), t.a.a());
  }
  
  protected t2<?> B(e0 parame0, t2.a<?, ?, ?> parama)
  {
    Object localObject2 = parama.b();
    Object localObject1 = s.e1.E;
    if ((((e2)localObject2).e((s0.a)localObject1, null) != null) && (Build.VERSION.SDK_INT >= 29))
    {
      n1.e("ImageCapture", "Requesting software JPEG due to a CaptureProcessor is set.");
      parama.a().G(s.e1.I, Boolean.TRUE);
    }
    else if (parame0.f().a(x.e.class))
    {
      parame0 = parama.a();
      localObject2 = s.e1.I;
      Boolean localBoolean = Boolean.TRUE;
      if (!((Boolean)parame0.e((s0.a)localObject2, localBoolean)).booleanValue())
      {
        n1.k("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
      }
      else
      {
        n1.e("ImageCapture", "Requesting software JPEG due to device quirk.");
        parama.a().G((s0.a)localObject2, localBoolean);
      }
    }
    boolean bool3 = a0(parama.a());
    parame0 = (Integer)parama.a().e(s.e1.F, null);
    boolean bool2 = false;
    int i = 35;
    if (parame0 != null)
    {
      if (parama.a().e((s0.a)localObject1, null) == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      h.b(bool1, "Cannot set buffer format with CaptureProcessor defined.");
      localObject1 = parama.a();
      localObject2 = h1.f;
      if (!bool3) {
        i = parame0.intValue();
      }
      ((t1)localObject1).G((s0.a)localObject2, Integer.valueOf(i));
    }
    else if ((parama.a().e((s0.a)localObject1, null) == null) && (!bool3))
    {
      parame0 = (List)parama.a().e(j1.m, null);
      if (parame0 == null) {}
      while (h0(parame0, 256))
      {
        parama.a().G(h1.f, Integer.valueOf(256));
        break;
      }
      if (!h0(parame0, 35)) {}
    }
    else
    {
      parama.a().G(h1.f, Integer.valueOf(35));
    }
    boolean bool1 = bool2;
    if (((Integer)parama.a().e(s.e1.G, Integer.valueOf(2))).intValue() >= 1) {
      bool1 = true;
    }
    h.b(bool1, "Maximum outstanding image count must be at least 1");
    return parama.b();
  }
  
  void C0()
  {
    synchronized (this.o)
    {
      Integer localInteger = (Integer)this.o.getAndSet(null);
      if (localInteger == null) {
        return;
      }
      if (localInteger.intValue() != e0()) {
        B0();
      }
      return;
    }
  }
  
  public void D()
  {
    W();
  }
  
  protected Size E(Size paramSize)
  {
    g2.b localb = Z(f(), (s.e1)g(), paramSize);
    this.y = localb;
    I(localb.n());
    r();
    return paramSize;
  }
  
  public void G(Matrix paramMatrix)
  {
    this.G = paramMatrix;
  }
  
  void X()
  {
    androidx.camera.core.impl.utils.l.a();
    Object localObject = this.E;
    if (localObject != null)
    {
      ((l)localObject).b(new CancellationException("Request is canceled."));
      this.E = null;
    }
    localObject = this.D;
    this.D = null;
    this.z = null;
    this.A = null;
    this.B = f.h(null);
    if (localObject != null) {
      ((s.v0)localObject).c();
    }
  }
  
  g2.b Z(String paramString, s.e1 parame1, Size paramSize)
  {
    androidx.camera.core.impl.utils.l.a();
    g2.b localb = g2.b.p(parame1);
    int k = Build.VERSION.SDK_INT;
    if (c0() == 2) {
      e().a(localb);
    }
    if (parame1.N() != null)
    {
      this.z = new i2(parame1.N().a(paramSize.getWidth(), paramSize.getHeight(), i(), 2, 0L));
      this.C = new a();
    }
    else
    {
      if (i0())
      {
        if (i() == 256)
        {
          localObject2 = new d(ImageReader.newInstance(paramSize.getWidth(), paramSize.getHeight(), i(), 2));
          localObject1 = null;
        }
        else
        {
          if (i() != 35) {
            break label311;
          }
          if (k < 26) {
            break label300;
          }
          localObject1 = new p(g0(), 2);
          s1 locals1 = new s1(ImageReader.newInstance(paramSize.getWidth(), paramSize.getHeight(), 35, 2));
          m0 localm0 = b0.c();
          localObject2 = new a2.e(locals1, localm0, (s.p0)localObject1).c(this.s).b(256).a();
          v1 localv1 = v1.f();
          localv1.h(((a2)localObject2).n(), Integer.valueOf(((s.q0)localm0.c().get(0)).getId()));
          locals1.m(localv1);
        }
        this.C = new b();
        this.z = new i2((s.l1)localObject2);
        break label624;
        label300:
        throw new UnsupportedOperationException("Does not support API level < 26");
        label311:
        paramString = new StringBuilder();
        paramString.append("Unsupported image format:");
        paramString.append(i());
        throw new IllegalArgumentException(paramString.toString());
      }
      localObject2 = this.w;
      if ((localObject2 != null) || (this.x)) {
        break label419;
      }
      localObject1 = new q1(paramSize.getWidth(), paramSize.getHeight(), i(), 2);
      this.C = ((q1)localObject1).m();
      this.z = new i2((s.l1)localObject1);
    }
    Object localObject1 = null;
    break label624;
    label419:
    int j = i();
    int i = i();
    if (this.x)
    {
      if (k >= 26)
      {
        n1.e("ImageCapture", "Using software JPEG encoder.");
        if (this.w != null)
        {
          localObject1 = new p(g0(), this.v);
          localObject2 = new h0(this.w, this.v, (s.p0)localObject1, this.s);
        }
        else
        {
          localObject1 = new p(g0(), this.v);
          localObject2 = localObject1;
        }
        i = 256;
      }
      else
      {
        throw new IllegalStateException("Software JPEG only supported on API 26+");
      }
    }
    else {
      localObject1 = null;
    }
    Object localObject2 = new a2.e(paramSize.getWidth(), paramSize.getHeight(), j, this.v, b0(b0.c()), (s.p0)localObject2).c(this.s).b(i).a();
    this.A = ((a2)localObject2);
    this.C = ((a2)localObject2).l();
    this.z = new i2(this.A);
    label624:
    localObject2 = this.E;
    if (localObject2 != null) {
      ((l)localObject2).b(new CancellationException("Request is canceled."));
    }
    localObject2 = new n0(this);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = new c((p)localObject1);
    }
    this.E = new l(2, (z0.l.b)localObject2, (z0.l.c)localObject1);
    this.z.e(this.l, t.a.d());
    localObject1 = this.D;
    if (localObject1 != null) {
      ((s.v0)localObject1).c();
    }
    this.D = new m1(this.z.getSurface(), new Size(this.z.getWidth(), this.z.getHeight()), i());
    localObject1 = this.A;
    if (localObject1 != null) {
      localObject1 = ((a2)localObject1).m();
    } else {
      localObject1 = f.h(null);
    }
    this.B = ((u7.a)localObject1);
    localObject1 = this.D.i();
    localObject2 = this.z;
    Objects.requireNonNull(localObject2);
    ((u7.a)localObject1).h(new g3((i2)localObject2), t.a.d());
    localb.h(this.D);
    localb.f(new p0(this, paramString, parame1, paramSize));
    return localb;
  }
  
  public int c0()
  {
    return this.n;
  }
  
  public int e0()
  {
    synchronized (this.o)
    {
      int i = this.q;
      if (i == -1) {
        i = ((s.e1)g()).L(2);
      }
      return i;
    }
  }
  
  public t2<?> h(boolean paramBoolean, u2 paramu2)
  {
    s.s0 locals0 = paramu2.a(u2.b.a, c0());
    paramu2 = locals0;
    if (paramBoolean) {
      paramu2 = s.r0.b(locals0, H.a());
    }
    if (paramu2 == null) {
      return null;
    }
    return n(paramu2).b();
  }
  
  u7.a<Void> j0(k paramk)
  {
    n1.a("ImageCapture", "issueTakePicture");
    ArrayList localArrayList = new ArrayList();
    String str;
    if (this.A != null)
    {
      localObject = b0(b0.c());
      if (localObject == null) {
        return f.f(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
      }
      if ((this.w == null) && (((m0)localObject).c().size() > 1)) {
        return f.f(new IllegalArgumentException("No CaptureProcessor can be found to process the images captured for multiple CaptureStages."));
      }
      if (((m0)localObject).c().size() > this.v) {
        return f.f(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
      }
      this.A.s((m0)localObject);
      this.A.t(t.a.a(), new q0(paramk));
      str = this.A.n();
    }
    else
    {
      localObject = b0(b0.c());
      if (((m0)localObject).c().size() > 1) {
        return f.f(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
      }
      str = null;
    }
    Object localObject = ((m0)localObject).c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      s.q0 localq0 = (s.q0)((Iterator)localObject).next();
      n0.a locala = new n0.a();
      locala.p(this.t.g());
      locala.e(this.t.d());
      locala.a(this.y.q());
      locala.f(this.D);
      if (i() == 256)
      {
        if (I.a()) {
          locala.d(s.n0.h, Integer.valueOf(paramk.a));
        }
        locala.d(s.n0.i, Integer.valueOf(paramk.b));
      }
      locala.e(localq0.a().d());
      if (str != null) {
        locala.g(str, Integer.valueOf(localq0.getId()));
      }
      locala.c(this.C);
      localArrayList.add(locala.h());
    }
    return f.o(e().c(localArrayList, this.n, this.p), x0.a, t.a.a());
  }
  
  public t2.a<?, ?, ?> n(s.s0 params0)
  {
    return i.d(params0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageCapture:");
    localStringBuilder.append(j());
    return localStringBuilder.toString();
  }
  
  public void x()
  {
    s.e1 locale1 = (s.e1)g();
    this.t = n0.a.j(locale1).h();
    this.w = locale1.K(null);
    this.v = locale1.Q(2);
    this.u = locale1.I(b0.c());
    this.x = locale1.S();
    h.h(d(), "Attached camera cannot be null");
    this.s = Executors.newFixedThreadPool(1, new g());
  }
  
  protected void y()
  {
    B0();
  }
  
  public void y0(Rational paramRational)
  {
    this.r = paramRational;
  }
  
  public void z0(final p paramp, final Executor paramExecutor, final o paramo)
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      t.a.d().execute(new u0(this, paramp, paramExecutor, paramo));
      return;
    }
    final d locald = new d(paramo);
    paramp = new e(paramp, g0(), paramExecutor, locald, paramo);
    x0(t.a.d(), paramp, true);
  }
  
  class a
    extends k
  {
    a() {}
  }
  
  class b
    extends k
  {
    b() {}
  }
  
  class c
    implements z0.l.c
  {
    c(p paramp) {}
    
    public void a(z0.k paramk)
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.a.h(paramk.b);
        this.a.i(paramk.a);
      }
    }
  }
  
  class d
    implements k1.b
  {
    d(z0.o paramo) {}
    
    public void a(k1.c paramc, String paramString, Throwable paramThrowable)
    {
      int j = z0.h.a[paramc.ordinal()];
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      paramo.t0(new c1(i, paramString, paramThrowable));
    }
    
    public void d(z0.q paramq)
    {
      paramo.d(paramq);
    }
  }
  
  class e
    extends z0.n
  {
    e(z0.p paramp, int paramInt, Executor paramExecutor, k1.b paramb, z0.o paramo) {}
    
    public void a(e1 parame1)
    {
      z0.this.m.execute(new k1(parame1, paramp, parame1.q().c(), this.b, paramExecutor, z0.this.F, locald));
    }
    
    public void b(c1 paramc1)
    {
      paramo.t0(paramc1);
    }
  }
  
  class f
    implements u.c<Void>
  {
    f(c.a parama) {}
    
    public void a(Throwable paramThrowable)
    {
      z0.this.C0();
      this.a.f(paramThrowable);
    }
    
    public void c(Void paramVoid)
    {
      z0.this.C0();
    }
  }
  
  class g
    implements ThreadFactory
  {
    private final AtomicInteger a = new AtomicInteger(0);
    
    g() {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CameraX-image_capture_");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramRunnable, localStringBuilder.toString());
    }
  }
  
  public static final class i
    implements t2.a<z0, s.e1, i>
  {
    private final u1 a;
    
    public i()
    {
      this(u1.M());
    }
    
    private i(u1 paramu1)
    {
      this.a = paramu1;
      paramu1 = (Class)paramu1.e(i.x, null);
      if ((paramu1 != null) && (!paramu1.equals(z0.class)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid target class configuration for ");
        localStringBuilder.append(this);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramu1);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      m(z0.class);
    }
    
    public static i d(s.s0 params0)
    {
      return new i(u1.N(params0));
    }
    
    public t1 a()
    {
      return this.a;
    }
    
    public z0 c()
    {
      if ((a().e(j1.g, null) != null) && (a().e(j1.j, null) != null)) {
        throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
      }
      Object localObject1 = (Integer)a().e(s.e1.F, null);
      boolean bool2 = false;
      int i;
      if (localObject1 != null)
      {
        if (a().e(s.e1.E, null) == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        h.b(bool1, "Cannot set buffer format with CaptureProcessor defined.");
        a().G(h1.f, localObject1);
      }
      else
      {
        if (a().e(s.e1.E, null) != null)
        {
          localObject1 = a();
          localObject2 = h1.f;
          i = 35;
        }
        else
        {
          localObject1 = a();
          localObject2 = h1.f;
          i = 256;
        }
        ((t1)localObject1).G((s0.a)localObject2, Integer.valueOf(i));
      }
      localObject1 = new z0(e());
      Object localObject2 = (Size)a().e(j1.j, null);
      if (localObject2 != null) {
        ((z0)localObject1).y0(new Rational(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight()));
      }
      boolean bool1 = bool2;
      if (((Integer)a().e(s.e1.G, Integer.valueOf(2))).intValue() >= 1) {
        bool1 = true;
      }
      h.b(bool1, "Maximum outstanding image count must be at least 1");
      h.h((Executor)a().e(g.v, t.a.c()), "The IO executor can't be null");
      localObject2 = a();
      s0.a locala = s.e1.C;
      if (((s.s0)localObject2).b(locala))
      {
        i = ((Integer)a().a(locala)).intValue();
        if ((i != 0) && (i != 1))
        {
          if (i == 2) {
            return localObject1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("The flash mode is not allowed to set: ");
          ((StringBuilder)localObject1).append(i);
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      return localObject1;
    }
    
    public s.e1 e()
    {
      return new s.e1(y1.K(this.a));
    }
    
    public i f(m0 paramm0)
    {
      a().G(s.e1.D, paramm0);
      return this;
    }
    
    public i g(int paramInt)
    {
      a().G(s.e1.B, Integer.valueOf(paramInt));
      return this;
    }
    
    public i h(s.p0 paramp0)
    {
      a().G(s.e1.E, paramp0);
      return this;
    }
    
    public i i(int paramInt)
    {
      a().G(s.e1.G, Integer.valueOf(paramInt));
      return this;
    }
    
    public i j(List<Pair<Integer, Size[]>> paramList)
    {
      a().G(j1.m, paramList);
      return this;
    }
    
    public i k(int paramInt)
    {
      a().G(t2.r, Integer.valueOf(paramInt));
      return this;
    }
    
    public i l(int paramInt)
    {
      a().G(j1.g, Integer.valueOf(paramInt));
      return this;
    }
    
    public i m(Class<z0> paramClass)
    {
      a().G(i.x, paramClass);
      if (a().e(i.w, null) == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getCanonicalName());
        localStringBuilder.append("-");
        localStringBuilder.append(UUID.randomUUID());
        n(localStringBuilder.toString());
      }
      return this;
    }
    
    public i n(String paramString)
    {
      a().G(i.w, paramString);
      return this;
    }
    
    public i o(int paramInt)
    {
      a().G(j1.h, Integer.valueOf(paramInt));
      return this;
    }
    
    public i p(v2.b paramb)
    {
      a().G(m.z, paramb);
      return this;
    }
  }
  
  public static final class j
  {
    private static final s.e1 a = new z0.i().k(4).l(0).e();
    
    public s.e1 a()
    {
      return a;
    }
  }
  
  static class k
  {
    final int a;
    final int b;
    private final Rational c;
    private final Executor d;
    private final z0.n e;
    AtomicBoolean f;
    private final Rect g;
    private final Matrix h;
    
    k(int paramInt1, int paramInt2, Rational paramRational, Rect paramRect, Matrix paramMatrix, Executor paramExecutor, z0.n paramn)
    {
      boolean bool = false;
      this.f = new AtomicBoolean(false);
      this.a = paramInt1;
      this.b = paramInt2;
      if (paramRational != null)
      {
        h.b(paramRational.isZero() ^ true, "Target ratio cannot be zero");
        if (paramRational.floatValue() > 0.0F) {
          bool = true;
        }
        h.b(bool, "Target ratio must be positive");
      }
      this.c = paramRational;
      this.g = paramRect;
      this.h = paramMatrix;
      this.d = paramExecutor;
      this.e = paramn;
    }
    
    void c(e1 parame1)
    {
      if (!this.f.compareAndSet(false, true))
      {
        parame1.close();
        return;
      }
      int i;
      Size localSize;
      if (z0.I.b(parame1))
      {
        try
        {
          Object localObject1 = parame1.j()[0].b();
          ((ByteBuffer)localObject1).rewind();
          localObject2 = new byte[((ByteBuffer)localObject1).capacity()];
          ((ByteBuffer)localObject1).get((byte[])localObject2);
          localObject2 = androidx.camera.core.impl.utils.e.k(new ByteArrayInputStream((byte[])localObject2));
          ((ByteBuffer)localObject1).rewind();
          localObject1 = new Size(((androidx.camera.core.impl.utils.e)localObject2).u(), ((androidx.camera.core.impl.utils.e)localObject2).p());
          i = ((androidx.camera.core.impl.utils.e)localObject2).s();
        }
        catch (IOException localIOException)
        {
          f(1, "Unable to parse JPEG exif", localIOException);
          parame1.close();
          return;
        }
      }
      else
      {
        localSize = new Size(parame1.getWidth(), parame1.getHeight());
        i = this.a;
      }
      Object localObject2 = new j2(parame1, localSize, l1.e(parame1.q().a(), parame1.q().getTimestamp(), i, this.h));
      ((e1)localObject2).n(z0.Y(this.g, this.c, this.a, localSize, i));
      try
      {
        this.d.execute(new b1(this, (e1)localObject2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        label235:
        break label235;
      }
      n1.c("ImageCapture", "Unable to post to the supplied executor.");
      parame1.close();
    }
    
    void f(int paramInt, String paramString, Throwable paramThrowable)
    {
      if (!this.f.compareAndSet(false, true)) {
        return;
      }
      try
      {
        this.d.execute(new a1(this, paramInt, paramString, paramThrowable));
        return;
      }
      catch (RejectedExecutionException paramString)
      {
        label34:
        break label34;
      }
      n1.c("ImageCapture", "Unable to post to the supplied executor.");
    }
  }
  
  static class l
    implements j0.a
  {
    private final Deque<z0.k> a = new ArrayDeque();
    z0.k b = null;
    u7.a<e1> c = null;
    int d = 0;
    private final b e;
    private final int f;
    private final c g;
    final Object h = new Object();
    
    l(int paramInt, b paramb, c paramc)
    {
      this.f = paramInt;
      this.e = paramb;
      this.g = paramc;
    }
    
    public void a(e1 arg1)
    {
      synchronized (this.h)
      {
        this.d -= 1;
        c();
        return;
      }
    }
    
    public void b(Throwable paramThrowable)
    {
      synchronized (this.h)
      {
        z0.k localk = this.b;
        this.b = null;
        u7.a locala = this.c;
        this.c = null;
        ArrayList localArrayList = new ArrayList(this.a);
        this.a.clear();
        if ((localk != null) && (locala != null))
        {
          localk.f(z0.d0(paramThrowable), paramThrowable.getMessage(), paramThrowable);
          locala.cancel(true);
        }
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((z0.k)((Iterator)???).next()).f(z0.d0(paramThrowable), paramThrowable.getMessage(), paramThrowable);
        }
        return;
      }
    }
    
    void c()
    {
      synchronized (this.h)
      {
        if (this.b != null) {
          return;
        }
        if (this.d >= this.f)
        {
          n1.k("ImageCapture", "Too many acquire images. Close image to be able to process next.");
          return;
        }
        final z0.k localk = (z0.k)this.a.poll();
        if (localk == null) {
          return;
        }
        this.b = localk;
        Object localObject3 = this.g;
        if (localObject3 != null) {
          ((c)localObject3).a(localk);
        }
        localObject3 = this.e.a(localk);
        this.c = ((u7.a)localObject3);
        f.b((u7.a)localObject3, new a(localk), t.a.a());
        return;
      }
    }
    
    public void d(z0.k paramk)
    {
      for (;;)
      {
        synchronized (this.h)
        {
          this.a.offer(paramk);
          paramk = Locale.US;
          if (this.b != null)
          {
            i = 1;
            n1.a("ImageCapture", String.format(paramk, "Send image capture request [current, pending] = [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.a.size()) }));
            c();
            return;
          }
        }
        int i = 0;
      }
    }
    
    class a
      implements u.c<e1>
    {
      a(z0.k paramk) {}
      
      public void a(Throwable paramThrowable)
      {
        for (;;)
        {
          synchronized (z0.l.this.h)
          {
            if (!(paramThrowable instanceof CancellationException))
            {
              z0.k localk = localk;
              int i = z0.d0(paramThrowable);
              if (paramThrowable != null)
              {
                str = paramThrowable.getMessage();
                localk.f(i, str, paramThrowable);
              }
            }
            else
            {
              paramThrowable = z0.l.this;
              paramThrowable.b = null;
              paramThrowable.c = null;
              paramThrowable.c();
              return;
            }
          }
          String str = "Unknown error";
        }
      }
      
      public void c(e1 parame1)
      {
        synchronized (z0.l.this.h)
        {
          h.g(parame1);
          parame1 = new l2(parame1);
          parame1.a(z0.l.this);
          z0.l locall = z0.l.this;
          locall.d += 1;
          localk.c(parame1);
          parame1 = z0.l.this;
          parame1.b = null;
          parame1.c = null;
          parame1.c();
          return;
        }
      }
    }
    
    static abstract interface b
    {
      public abstract u7.a<e1> a(z0.k paramk);
    }
    
    static abstract interface c
    {
      public abstract void a(z0.k paramk);
    }
  }
  
  public static final class m
  {
    private boolean a;
    private boolean b = false;
    private boolean c;
    private Location d;
    
    public Location a()
    {
      return this.d;
    }
    
    public boolean b()
    {
      return this.a;
    }
    
    public boolean c()
    {
      return this.c;
    }
  }
  
  public static abstract class n
  {
    public abstract void a(e1 parame1);
    
    public abstract void b(c1 paramc1);
  }
  
  public static abstract interface o
  {
    public abstract void d(z0.q paramq);
    
    public abstract void t0(c1 paramc1);
  }
  
  public static final class p
  {
    private final File a;
    private final ContentResolver b;
    private final Uri c;
    private final ContentValues d;
    private final OutputStream e;
    private final z0.m f;
    
    p(File paramFile, ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, OutputStream paramOutputStream, z0.m paramm)
    {
      this.a = paramFile;
      this.b = paramContentResolver;
      this.c = paramUri;
      this.d = paramContentValues;
      this.e = paramOutputStream;
      paramFile = paramm;
      if (paramm == null) {
        paramFile = new z0.m();
      }
      this.f = paramFile;
    }
    
    ContentResolver a()
    {
      return this.b;
    }
    
    ContentValues b()
    {
      return this.d;
    }
    
    File c()
    {
      return this.a;
    }
    
    public z0.m d()
    {
      return this.f;
    }
    
    OutputStream e()
    {
      return this.e;
    }
    
    Uri f()
    {
      return this.c;
    }
    
    public static final class a
    {
      private File a;
      private ContentResolver b;
      private Uri c;
      private ContentValues d;
      private OutputStream e;
      private z0.m f;
      
      public a(File paramFile)
      {
        this.a = paramFile;
      }
      
      public z0.p a()
      {
        return new z0.p(this.a, this.b, this.c, this.d, this.e, this.f);
      }
    }
  }
  
  public static class q
  {
    private Uri a;
    
    q(Uri paramUri)
    {
      this.a = paramUri;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.z0
 * JD-Core Version:    0.7.0.1
 */