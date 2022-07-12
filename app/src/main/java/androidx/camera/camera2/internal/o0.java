package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.c1;
import androidx.camera.core.e1;
import androidx.camera.core.n1;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import m.b.a;
import n.z;
import q.l;
import q.s;
import s.c2;
import s.k;
import s.m;
import s.n;
import s.n0.a;
import s.o;
import s.p;
import s.q;
import s.u;
import u.d;
import u.f;

class o0
{
  private static final Set<p> g = Collections.unmodifiableSet(EnumSet.of(p.d, p.e, p.f, p.g));
  private static final Set<q> h = Collections.unmodifiableSet(EnumSet.of(q.d, q.a));
  private static final Set<n> i;
  private static final Set<n> j;
  private final t a;
  private final s b;
  private final c2 c;
  private final Executor d;
  private final boolean e;
  private int f;
  
  static
  {
    Object localObject = n.e;
    n localn1 = n.d;
    n localn2 = n.a;
    localObject = Collections.unmodifiableSet(EnumSet.of((Enum)localObject, localn1, localn2));
    i = (Set)localObject;
    localObject = EnumSet.copyOf((Collection)localObject);
    ((EnumSet)localObject).remove(localn1);
    ((EnumSet)localObject).remove(localn2);
    j = Collections.unmodifiableSet((Set)localObject);
  }
  
  o0(t paramt, z paramz, c2 paramc2, Executor paramExecutor)
  {
    boolean bool = true;
    this.f = 1;
    this.a = paramt;
    paramt = (Integer)paramz.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if ((paramt == null) || (paramt.intValue() != 2)) {
      bool = false;
    }
    this.e = bool;
    this.d = paramExecutor;
    this.c = paramc2;
    this.b = new s(paramc2);
  }
  
  static boolean a(TotalCaptureResult paramTotalCaptureResult, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramTotalCaptureResult == null) {
      return false;
    }
    e locale = new e(paramTotalCaptureResult);
    int k;
    if ((locale.h() != o.b) && (locale.h() != o.a) && (!g.contains(locale.g()))) {
      k = 0;
    } else {
      k = 1;
    }
    if (paramBoolean) {
      paramTotalCaptureResult = j;
    } else {
      paramTotalCaptureResult = i;
    }
    boolean bool2 = paramTotalCaptureResult.contains(locale.c());
    boolean bool3 = h.contains(locale.d());
    paramTotalCaptureResult = new StringBuilder();
    paramTotalCaptureResult.append("checkCaptureResult, AE=");
    paramTotalCaptureResult.append(locale.c());
    paramTotalCaptureResult.append(" AF =");
    paramTotalCaptureResult.append(locale.g());
    paramTotalCaptureResult.append(" AWB=");
    paramTotalCaptureResult.append(locale.d());
    n1.a("Camera2CapturePipeline", paramTotalCaptureResult.toString());
    paramBoolean = bool1;
    if (k != 0)
    {
      paramBoolean = bool1;
      if (bool2)
      {
        paramBoolean = bool1;
        if (bool3) {
          paramBoolean = true;
        }
      }
    }
    return paramBoolean;
  }
  
  static boolean b(int paramInt, TotalCaptureResult paramTotalCaptureResult)
  {
    boolean bool2 = false;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return false;
        }
        throw new AssertionError(paramInt);
      }
      return true;
    }
    if (paramTotalCaptureResult != null) {
      paramTotalCaptureResult = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
    } else {
      paramTotalCaptureResult = null;
    }
    boolean bool1 = bool2;
    if (paramTotalCaptureResult != null)
    {
      bool1 = bool2;
      if (paramTotalCaptureResult.intValue() == 4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean c(int paramInt)
  {
    boolean bool3 = this.b.a();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.f != 3)
      {
        if (paramInt == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  static u7.a<TotalCaptureResult> f(long paramLong, t paramt, o0.e.a parama)
  {
    parama = new e(paramLong, parama);
    paramt.s(parama);
    return parama.c();
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public u7.a<List<Void>> e(List<s.n0> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new l(this.c);
    c localc = new c(this.f, this.d, this.a, this.e, (l)localObject);
    if (paramInt1 == 0) {
      localc.g(new b(this.a));
    }
    if (c(paramInt3)) {
      localObject = new f(this.a, paramInt2, this.d);
    } else {
      localObject = new a(this.a, paramInt2, (l)localObject);
    }
    localc.g((d)localObject);
    return f.j(localc.j(paramList, paramInt2));
  }
  
  static class a
    implements o0.d
  {
    private final t a;
    private final l b;
    private final int c;
    private boolean d = false;
    
    a(t paramt, int paramInt, l paraml)
    {
      this.a = paramt;
      this.c = paramInt;
      this.b = paraml;
    }
    
    public boolean a()
    {
      return this.c == 0;
    }
    
    public u7.a<Boolean> b(TotalCaptureResult paramTotalCaptureResult)
    {
      if (o0.b(this.c, paramTotalCaptureResult))
      {
        n1.a("Camera2CapturePipeline", "Trigger AE");
        this.d = true;
        return d.a(c.a(new m0(this))).d(n0.a, t.a.a());
      }
      return f.h(Boolean.FALSE);
    }
    
    public void c()
    {
      if (this.d)
      {
        n1.a("Camera2CapturePipeline", "cancel TriggerAePreCapture");
        this.a.x().c(false, true);
        this.b.a();
      }
    }
  }
  
  static class b
    implements o0.d
  {
    private final t a;
    private boolean b = false;
    
    b(t paramt)
    {
      this.a = paramt;
    }
    
    public boolean a()
    {
      return true;
    }
    
    public u7.a<Boolean> b(TotalCaptureResult paramTotalCaptureResult)
    {
      u7.a locala = f.h(Boolean.TRUE);
      if (paramTotalCaptureResult == null) {
        return locala;
      }
      Integer localInteger = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
      if (localInteger == null) {
        return locala;
      }
      int i = localInteger.intValue();
      if ((i != 1) && (i != 2)) {
        return locala;
      }
      n1.a("Camera2CapturePipeline", "TriggerAf? AF mode auto");
      paramTotalCaptureResult = (Integer)paramTotalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      if ((paramTotalCaptureResult != null) && (paramTotalCaptureResult.intValue() == 0))
      {
        n1.a("Camera2CapturePipeline", "Trigger AF");
        this.b = true;
        this.a.x().r(null, false);
      }
      return locala;
    }
    
    public void c()
    {
      if (this.b)
      {
        n1.a("Camera2CapturePipeline", "cancel TriggerAF");
        this.a.x().c(true, false);
      }
    }
  }
  
  static class c
  {
    private static final long i;
    private static final long j;
    private final int a;
    private final Executor b;
    private final t c;
    private final l d;
    private final boolean e;
    private long f = i;
    final List<o0.d> g = new ArrayList();
    private final o0.d h = new a();
    
    static
    {
      TimeUnit localTimeUnit = TimeUnit.SECONDS;
      i = localTimeUnit.toNanos(1L);
      j = localTimeUnit.toNanos(5L);
    }
    
    c(int paramInt, Executor paramExecutor, t paramt, boolean paramBoolean, l paraml)
    {
      this.a = paramInt;
      this.b = paramExecutor;
      this.c = paramt;
      this.e = paramBoolean;
      this.d = paraml;
    }
    
    private void h(n0.a parama)
    {
      b.a locala = new b.a();
      locala.e(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
      parama.e(locala.c());
    }
    
    private void i(n0.a parama, s.n0 paramn0)
    {
      int k;
      if ((this.a == 3) && (!this.e)) {
        k = 4;
      } else if ((paramn0.g() != -1) && (paramn0.g() != 5)) {
        k = -1;
      } else {
        k = 2;
      }
      if (k != -1) {
        parama.p(k);
      }
    }
    
    private void q(long paramLong)
    {
      this.f = paramLong;
    }
    
    void g(o0.d paramd)
    {
      this.g.add(paramd);
    }
    
    u7.a<List<Void>> j(List<s.n0> paramList, int paramInt)
    {
      Object localObject = f.h(null);
      if (!this.g.isEmpty())
      {
        if (this.h.a()) {
          localObject = o0.f(0L, this.c, null);
        } else {
          localObject = f.h(null);
        }
        localObject = d.a((u7.a)localObject).e(new t0(this, paramInt), this.b).e(new s0(this), this.b);
      }
      paramList = d.a((u7.a)localObject).e(new u0(this, paramList, paramInt), this.b);
      paramList.h(new r0(this), this.b);
      return paramList;
    }
    
    u7.a<List<Void>> r(List<s.n0> paramList, int paramInt)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        s.n0 localn0 = (s.n0)localIterator.next();
        n0.a locala = n0.a.k(localn0);
        Object localObject = null;
        paramList = localObject;
        if (localn0.g() == 5)
        {
          paramList = localObject;
          if (!this.c.G().c())
          {
            paramList = localObject;
            if (!this.c.G().b())
            {
              e1 locale1 = this.c.G().g();
              int k;
              if ((locale1 != null) && (this.c.G().d(locale1))) {
                k = 1;
              } else {
                k = 0;
              }
              paramList = localObject;
              if (k != 0) {
                paramList = u.a(locale1.q());
              }
            }
          }
        }
        if (paramList != null) {
          locala.n(paramList);
        } else {
          i(locala, localn0);
        }
        if (this.d.c(paramInt)) {
          h(locala);
        }
        localArrayList1.add(c.a(new q0(this, locala)));
        localArrayList2.add(locala.h());
      }
      this.c.d0(localArrayList2);
      return f.c(localArrayList1);
    }
    
    class a
      implements o0.d
    {
      a() {}
      
      public boolean a()
      {
        Iterator localIterator = o0.c.this.g.iterator();
        while (localIterator.hasNext()) {
          if (((o0.d)localIterator.next()).a()) {
            return true;
          }
        }
        return false;
      }
      
      public u7.a<Boolean> b(TotalCaptureResult paramTotalCaptureResult)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = o0.c.this.g.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(((o0.d)localIterator.next()).b(paramTotalCaptureResult));
        }
        return f.o(f.c(localArrayList), v0.a, t.a.a());
      }
      
      public void c()
      {
        Iterator localIterator = o0.c.this.g.iterator();
        while (localIterator.hasNext()) {
          ((o0.d)localIterator.next()).c();
        }
      }
    }
    
    class b
      extends k
    {
      b(c.a parama) {}
      
      public void a()
      {
        this.a.f(new c1(3, "Capture request is cancelled because camera is closed", null));
      }
      
      public void b(s.t paramt)
      {
        this.a.c(null);
      }
      
      public void c(m paramm)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Capture request failed with reason ");
        localStringBuilder.append(paramm.a());
        paramm = localStringBuilder.toString();
        this.a.f(new c1(2, paramm, null));
      }
    }
  }
  
  static abstract interface d
  {
    public abstract boolean a();
    
    public abstract u7.a<Boolean> b(TotalCaptureResult paramTotalCaptureResult);
    
    public abstract void c();
  }
  
  static class e
    implements t.c
  {
    private c.a<TotalCaptureResult> a;
    private final u7.a<TotalCaptureResult> b = c.a(new w0(this));
    private final long c;
    private final a d;
    private volatile Long e = null;
    
    e(long paramLong, a parama)
    {
      this.c = paramLong;
      this.d = parama;
    }
    
    public boolean a(TotalCaptureResult paramTotalCaptureResult)
    {
      Object localObject = (Long)paramTotalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
      if ((localObject != null) && (this.e == null)) {
        this.e = ((Long)localObject);
      }
      Long localLong = this.e;
      if ((0L != this.c) && (localLong != null) && (localObject != null) && (((Long)localObject).longValue() - localLong.longValue() > this.c))
      {
        this.a.c(null);
        paramTotalCaptureResult = new StringBuilder();
        paramTotalCaptureResult.append("Wait for capture result timeout, current:");
        paramTotalCaptureResult.append(localObject);
        paramTotalCaptureResult.append(" first: ");
        paramTotalCaptureResult.append(localLong);
        n1.a("Camera2CapturePipeline", paramTotalCaptureResult.toString());
        return true;
      }
      localObject = this.d;
      if ((localObject != null) && (!((a)localObject).a(paramTotalCaptureResult))) {
        return false;
      }
      this.a.c(paramTotalCaptureResult);
      return true;
    }
    
    public u7.a<TotalCaptureResult> c()
    {
      return this.b;
    }
    
    static abstract interface a
    {
      public abstract boolean a(TotalCaptureResult paramTotalCaptureResult);
    }
  }
  
  static class f
    implements o0.d
  {
    private static final long e = TimeUnit.SECONDS.toNanos(2L);
    private final t a;
    private final int b;
    private boolean c = false;
    private final Executor d;
    
    f(t paramt, int paramInt, Executor paramExecutor)
    {
      this.a = paramt;
      this.b = paramInt;
      this.d = paramExecutor;
    }
    
    public boolean a()
    {
      return this.b == 0;
    }
    
    public u7.a<Boolean> b(TotalCaptureResult paramTotalCaptureResult)
    {
      if (o0.b(this.b, paramTotalCaptureResult)) {
        if (this.a.L())
        {
          n1.a("Camera2CapturePipeline", "Torch already on, not turn on");
        }
        else
        {
          n1.a("Camera2CapturePipeline", "Turn on torch");
          this.c = true;
          return d.a(c.a(new y0(this))).e(new a1(this), this.d).d(z0.a, t.a.a());
        }
      }
      return f.h(Boolean.FALSE);
    }
    
    public void c()
    {
      if (this.c)
      {
        this.a.D().e(null, false);
        n1.a("Camera2CapturePipeline", "Turn off torch");
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.o0
 * JD-Core Version:    0.7.0.1
 */