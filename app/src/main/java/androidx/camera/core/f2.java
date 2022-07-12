package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import s.j2;
import s.k;
import s.l1;
import s.l1.a;
import s.n2;
import s.p0;
import s.q0;
import s.v0;
import u.c;
import u.f;

final class f2
  extends v0
{
  final Object m = new Object();
  private final l1.a n;
  boolean o;
  private final Size p;
  final q1 q;
  final Surface r;
  private final Handler s;
  final q0 t;
  final p0 u;
  private final k v;
  private final v0 w;
  private String x;
  
  f2(int paramInt1, int paramInt2, int paramInt3, Handler paramHandler, q0 paramq0, p0 paramp0, v0 paramv0, String paramString)
  {
    super(new Size(paramInt1, paramInt2), paramInt3);
    e2 locale2 = new e2(this);
    this.n = locale2;
    this.o = false;
    Size localSize = new Size(paramInt1, paramInt2);
    this.p = localSize;
    if (paramHandler != null)
    {
      this.s = paramHandler;
    }
    else
    {
      paramHandler = Looper.myLooper();
      if (paramHandler == null) {
        break label228;
      }
      this.s = new Handler(paramHandler);
    }
    paramHandler = t.a.e(this.s);
    q1 localq1 = new q1(paramInt1, paramInt2, paramInt3, 2);
    this.q = localq1;
    localq1.e(locale2, paramHandler);
    this.r = localq1.getSurface();
    this.v = localq1.m();
    this.u = paramp0;
    paramp0.a(localSize);
    this.t = paramq0;
    this.w = paramv0;
    this.x = paramString;
    f.b(paramv0.h(), new a(), t.a.a());
    i().h(new d2(this), t.a.a());
    return;
    label228:
    throw new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
  }
  
  private void u()
  {
    synchronized (this.m)
    {
      if (this.o) {
        return;
      }
      this.q.close();
      this.r.release();
      this.w.c();
      this.o = true;
      return;
    }
  }
  
  public u7.a<Surface> n()
  {
    synchronized (this.m)
    {
      u7.a locala = f.h(this.r);
      return locala;
    }
  }
  
  k r()
  {
    synchronized (this.m)
    {
      if (!this.o)
      {
        k localk = this.v;
        return localk;
      }
      throw new IllegalStateException("ProcessingSurface already released!");
    }
  }
  
  void s(l1 paraml1)
  {
    if (this.o) {
      return;
    }
    Object localObject = null;
    try
    {
      paraml1 = paraml1.g();
    }
    catch (IllegalStateException paraml1)
    {
      n1.d("ProcessingSurfaceTextur", "Failed to acquire next image.", paraml1);
      paraml1 = (l1)localObject;
    }
    if (paraml1 == null) {
      return;
    }
    localObject = paraml1.q();
    if (localObject == null)
    {
      paraml1.close();
      return;
    }
    localObject = (Integer)((d1)localObject).a().c(this.x);
    if (localObject == null)
    {
      paraml1.close();
      return;
    }
    if (this.t.getId() != ((Integer)localObject).intValue())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ImageProxyBundle does not contain this id: ");
      localStringBuilder.append(localObject);
      n1.k("ProcessingSurfaceTextur", localStringBuilder.toString());
      paraml1.close();
      return;
    }
    paraml1 = new j2(paraml1, this.x);
    this.u.b(paraml1);
    paraml1.c();
  }
  
  class a
    implements c<Surface>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
    {
      n1.d("ProcessingSurfaceTextur", "Failed to extract Listenable<Surface>.", paramThrowable);
    }
    
    public void c(Surface paramSurface)
    {
      synchronized (f2.this.m)
      {
        f2.this.u.c(paramSurface, 1);
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.f2
 * JD-Core Version:    0.7.0.1
 */