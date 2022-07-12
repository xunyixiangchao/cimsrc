package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Rational;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c.a;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import m.b.a;
import s.b0.b;
import s.c2;
import s.m;
import s.n0.a;

class b2
{
  private static final MeteringRectangle[] v = new MeteringRectangle[0];
  private final t a;
  final Executor b;
  private final ScheduledExecutorService c;
  private volatile boolean d = false;
  private volatile Rational e = null;
  private final q.k f;
  private boolean g = false;
  Integer h = Integer.valueOf(0);
  private ScheduledFuture<?> i;
  private ScheduledFuture<?> j;
  long k = 0L;
  boolean l = false;
  boolean m = false;
  private int n = 1;
  private t.c o = null;
  private t.c p = null;
  private MeteringRectangle[] q;
  private MeteringRectangle[] r;
  private MeteringRectangle[] s;
  c.a<Object> t;
  c.a<Void> u;
  
  b2(t paramt, ScheduledExecutorService paramScheduledExecutorService, Executor paramExecutor, c2 paramc2)
  {
    MeteringRectangle[] arrayOfMeteringRectangle = v;
    this.q = arrayOfMeteringRectangle;
    this.r = arrayOfMeteringRectangle;
    this.s = arrayOfMeteringRectangle;
    this.t = null;
    this.u = null;
    this.a = paramt;
    this.b = paramExecutor;
    this.c = paramScheduledExecutorService;
    this.f = new q.k(paramc2);
  }
  
  private void f()
  {
    ScheduledFuture localScheduledFuture = this.j;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(true);
      this.j = null;
    }
  }
  
  private void g()
  {
    c.a locala = this.u;
    if (locala != null)
    {
      locala.c(null);
      this.u = null;
    }
  }
  
  private void h()
  {
    ScheduledFuture localScheduledFuture = this.i;
    if (localScheduledFuture != null)
    {
      localScheduledFuture.cancel(true);
      this.i = null;
    }
  }
  
  private void i(String paramString)
  {
    this.a.W(this.o);
    c.a locala = this.t;
    if (locala != null)
    {
      locala.f(new m.a(paramString));
      this.t = null;
    }
  }
  
  private void j(String paramString)
  {
    this.a.W(this.p);
    c.a locala = this.u;
    if (locala != null)
    {
      locala.f(new m.a(paramString));
      this.u = null;
    }
  }
  
  private boolean p()
  {
    return this.q.length > 0;
  }
  
  void b(b.a parama)
  {
    int i1;
    if (this.g) {
      i1 = 1;
    } else {
      i1 = k();
    }
    parama.e(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.a.B(i1)));
    MeteringRectangle[] arrayOfMeteringRectangle = this.q;
    if (arrayOfMeteringRectangle.length != 0) {
      parama.e(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
    }
    arrayOfMeteringRectangle = this.r;
    if (arrayOfMeteringRectangle.length != 0) {
      parama.e(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
    }
    arrayOfMeteringRectangle = this.s;
    if (arrayOfMeteringRectangle.length != 0) {
      parama.e(CaptureRequest.CONTROL_AWB_REGIONS, arrayOfMeteringRectangle);
    }
  }
  
  void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.d) {
      return;
    }
    n0.a locala = new n0.a();
    locala.q(true);
    locala.p(this.n);
    b.a locala1 = new b.a();
    if (paramBoolean1) {
      locala1.e(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    }
    if (paramBoolean2) {
      locala1.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(2));
    }
    locala.e(locala1.c());
    this.a.d0(Collections.singletonList(locala.h()));
  }
  
  void d(c.a<Void> parama)
  {
    j("Cancelled by another cancelFocusAndMetering()");
    i("Cancelled by cancelFocusAndMetering()");
    this.u = parama;
    h();
    f();
    if (p()) {
      c(true, false);
    }
    parama = v;
    this.q = parama;
    this.r = parama;
    this.s = parama;
    this.g = false;
    long l1 = this.a.g0();
    if (this.u != null)
    {
      parama = new a2(this, this.a.B(k()), l1);
      this.p = parama;
      this.a.s(parama);
    }
  }
  
  void e()
  {
    d(null);
  }
  
  int k()
  {
    if (this.n != 3) {
      return 4;
    }
    return 3;
  }
  
  void m(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {
      return;
    }
    this.d = paramBoolean;
    if (!this.d) {
      e();
    }
  }
  
  public void n(Rational paramRational)
  {
    this.e = paramRational;
  }
  
  void o(int paramInt)
  {
    this.n = paramInt;
  }
  
  void q(final c.a<Void> parama)
  {
    if (!this.d)
    {
      if (parama != null) {
        parama.f(new m.a("Camera is not active."));
      }
      return;
    }
    n0.a locala = new n0.a();
    locala.p(this.n);
    locala.q(true);
    b.a locala1 = new b.a();
    locala1.e(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
    locala.e(locala1.c());
    locala.c(new b(parama));
    this.a.d0(Collections.singletonList(locala.h()));
  }
  
  void r(final c.a<s.t> parama, boolean paramBoolean)
  {
    if (!this.d)
    {
      if (parama != null) {
        parama.f(new m.a("Camera is not active."));
      }
      return;
    }
    n0.a locala = new n0.a();
    locala.p(this.n);
    locala.q(true);
    b.a locala1 = new b.a();
    locala1.e(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    if (paramBoolean) {
      locala1.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.a.A(1)));
    }
    locala.e(locala1.c());
    locala.c(new a(parama));
    this.a.d0(Collections.singletonList(locala.h()));
  }
  
  class a
    extends s.k
  {
    a(c.a parama) {}
    
    public void a()
    {
      c.a locala = parama;
      if (locala != null) {
        locala.f(new m.a("Camera is closed"));
      }
    }
    
    public void b(s.t paramt)
    {
      c.a locala = parama;
      if (locala != null) {
        locala.c(paramt);
      }
    }
    
    public void c(m paramm)
    {
      c.a locala = parama;
      if (locala != null) {
        locala.f(new b0.b(paramm));
      }
    }
  }
  
  class b
    extends s.k
  {
    b(c.a parama) {}
    
    public void a()
    {
      c.a locala = parama;
      if (locala != null) {
        locala.f(new m.a("Camera is closed"));
      }
    }
    
    public void b(s.t paramt)
    {
      paramt = parama;
      if (paramt != null) {
        paramt.c(null);
      }
    }
    
    public void c(m paramm)
    {
      c.a locala = parama;
      if (locala != null) {
        locala.f(new b0.b(paramm));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.b2
 * JD-Core Version:    0.7.0.1
 */