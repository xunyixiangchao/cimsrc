package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import m.b.a;
import r.j;
import r.j.a;
import s.a1;
import s.g2;
import s.h2.a;
import s.k;
import s.n0;
import s.s0;
import s.s0.a;
import s.v0;
import u.c;
import u.d;
import u7.a;
import x0.h;

final class j2
  implements t1
{
  private static List<v0> q = new ArrayList();
  private static int r = 0;
  private final s.h2 a;
  private final j0 b;
  final Executor c;
  private final ScheduledExecutorService d;
  private final s1 e = new s1();
  private List<v0> f = new ArrayList();
  private g2 g;
  private d1 h;
  private g2 i;
  private d j;
  private volatile n0 k = null;
  volatile boolean l = false;
  private final e m;
  private j n = new j.a().d();
  private j o = new j.a().d();
  private int p = 0;
  
  j2(s.h2 paramh2, j0 paramj0, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramh2;
    this.b = paramj0;
    this.c = paramExecutor;
    this.d = paramScheduledExecutorService;
    this.j = d.a;
    this.m = new e(paramExecutor);
    int i1 = r;
    r = i1 + 1;
    this.p = i1;
    paramh2 = new StringBuilder();
    paramh2.append("New ProcessingCaptureSession (id=");
    paramh2.append(this.p);
    paramh2.append(")");
    n1.a("ProcessingCaptureSession", paramh2.toString());
  }
  
  private static void l(List<n0> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Iterator localIterator = ((n0)paramList.next()).b().iterator();
      while (localIterator.hasNext()) {
        ((k)localIterator.next()).a();
      }
    }
  }
  
  private static List<s.i2> m(List<v0> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      v0 localv0 = (v0)paramList.next();
      h.b(localv0 instanceof s.i2, "Surface must be SessionProcessorSurface");
      localArrayList.add((s.i2)localv0);
    }
    return localArrayList;
  }
  
  private boolean n(List<n0> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((n0)paramList.next()).g() != 2) {
        return false;
      }
    }
    return true;
  }
  
  private void t(j paramj1, j paramj2)
  {
    b.a locala = new b.a();
    locala.d(paramj1);
    locala.d(paramj2);
    this.a.a(locala.c());
  }
  
  public a<Void> a(boolean paramBoolean)
  {
    boolean bool;
    if (this.j == d.e) {
      bool = true;
    } else {
      bool = false;
    }
    h.j(bool, "release() can only be called in CLOSED state");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release (id=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(")");
    n1.a("ProcessingCaptureSession", localStringBuilder.toString());
    return this.e.a(paramBoolean);
  }
  
  public List<n0> b()
  {
    if (this.k != null) {
      return Arrays.asList(new n0[] { this.k });
    }
    return Collections.emptyList();
  }
  
  public void c(List<n0> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    if ((paramList.size() <= 1) && (n(paramList)))
    {
      if ((this.k == null) && (!this.l))
      {
        Object localObject1 = (n0)paramList.get(0);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("issueCaptureRequests (id=");
        ((StringBuilder)localObject2).append(this.p);
        ((StringBuilder)localObject2).append(") + state =");
        ((StringBuilder)localObject2).append(this.j);
        n1.a("ProcessingCaptureSession", ((StringBuilder)localObject2).toString());
        int i1 = c.a[this.j.ordinal()];
        if ((i1 != 1) && (i1 != 2))
        {
          if (i1 != 3)
          {
            if ((i1 != 4) && (i1 != 5)) {
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Run issueCaptureRequests in wrong state, state = ");
            ((StringBuilder)localObject1).append(this.j);
            n1.a("ProcessingCaptureSession", ((StringBuilder)localObject1).toString());
            l(paramList);
            return;
          }
          this.l = true;
          paramList = j.a.e(((n0)localObject1).d());
          localObject2 = ((n0)localObject1).d();
          s0.a locala = n0.h;
          if (((s0)localObject2).b(locala)) {
            paramList.g(CaptureRequest.JPEG_ORIENTATION, (Integer)((n0)localObject1).d().a(locala));
          }
          localObject2 = ((n0)localObject1).d();
          locala = n0.i;
          if (((s0)localObject2).b(locala)) {
            paramList.g(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer)((n0)localObject1).d().a(locala)).byteValue()));
          }
          paramList = paramList.d();
          this.o = paramList;
          t(this.n, paramList);
          this.a.c(new b((n0)localObject1));
          return;
        }
        this.k = ((n0)localObject1);
        return;
      }
      l(paramList);
      return;
    }
    l(paramList);
  }
  
  public void close()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("close (id=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(") state=");
    ((StringBuilder)localObject).append(this.j);
    n1.a("ProcessingCaptureSession", ((StringBuilder)localObject).toString());
    int i1 = c.a[this.j.ordinal()];
    if (i1 != 2) {
      if (i1 != 3)
      {
        if (i1 != 4) {
          if (i1 != 5) {
            break label125;
          }
        }
      }
      else
      {
        this.a.e();
        localObject = this.h;
        if (localObject != null) {
          ((d1)localObject).a();
        }
        this.j = d.d;
      }
    }
    this.a.f();
    label125:
    this.j = d.e;
    this.e.close();
  }
  
  public g2 d()
  {
    return this.g;
  }
  
  public void e(g2 paramg2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSessionConfig (id=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(")");
    n1.a("ProcessingCaptureSession", ((StringBuilder)localObject).toString());
    this.g = paramg2;
    if (paramg2 == null) {
      return;
    }
    localObject = this.h;
    if (localObject != null) {
      ((d1)localObject).b(paramg2);
    }
    if (this.j == d.c)
    {
      paramg2 = j.a.e(paramg2.d()).d();
      this.n = paramg2;
      t(paramg2, this.o);
      this.a.b(this.m);
    }
  }
  
  public void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelIssuedCaptureRequests (id=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(")");
    n1.a("ProcessingCaptureSession", ((StringBuilder)localObject).toString());
    if (this.k != null)
    {
      localObject = this.k.b().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((k)((Iterator)localObject).next()).a();
      }
      this.k = null;
    }
  }
  
  public a<Void> g(g2 paramg2, CameraDevice paramCameraDevice, x2 paramx2)
  {
    boolean bool;
    if (this.j == d.a) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid state state:");
    ((StringBuilder)localObject).append(this.j);
    h.b(bool, ((StringBuilder)localObject).toString());
    h.b(paramg2.k().isEmpty() ^ true, "SessionConfig contains no surfaces");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("open (id=");
    ((StringBuilder)localObject).append(this.p);
    ((StringBuilder)localObject).append(")");
    n1.a("ProcessingCaptureSession", ((StringBuilder)localObject).toString());
    localObject = paramg2.k();
    this.f = ((List)localObject);
    return d.a(a1.k((Collection)localObject, false, 5000L, this.c, this.d)).e(new i2(this, paramg2, paramCameraDevice, paramx2), this.c).d(new h2(this), this.c);
  }
  
  void s(s1 params1)
  {
    boolean bool;
    if (this.j == d.b) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid state state:");
    localStringBuilder.append(this.j);
    h.b(bool, localStringBuilder.toString());
    params1 = new d1(params1, m(this.i.k()));
    this.h = params1;
    this.a.g(params1);
    this.j = d.c;
    params1 = this.g;
    if (params1 != null) {
      e(params1);
    }
    if (this.k != null)
    {
      params1 = Arrays.asList(new n0[] { this.k });
      this.k = null;
      c(params1);
    }
  }
  
  class a
    implements c<Void>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
    {
      n1.d("ProcessingCaptureSession", "open session failed ", paramThrowable);
      j2.this.close();
    }
    
    public void c(Void paramVoid) {}
  }
  
  class b
    implements h2.a
  {
    b(n0 paramn0) {}
  }
  
  private static enum d
  {
    static
    {
      d locald1 = new d("UNINITIALIZED", 0);
      a = locald1;
      d locald2 = new d("SESSION_INITIALIZED", 1);
      b = locald2;
      d locald3 = new d("ON_CAPTURE_SESSION_STARTED", 2);
      c = locald3;
      d locald4 = new d("ON_CAPTURE_SESSION_ENDED", 3);
      d = locald4;
      d locald5 = new d("CLOSED", 4);
      e = locald5;
      f = new d[] { locald1, locald2, locald3, locald4, locald5 };
    }
    
    private d() {}
  }
  
  private static class e
    implements h2.a
  {
    private List<k> a = Collections.emptyList();
    private final Executor b;
    
    e(Executor paramExecutor)
    {
      this.b = paramExecutor;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.j2
 * JD-Core Version:    0.7.0.1
 */