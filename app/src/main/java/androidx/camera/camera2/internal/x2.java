package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o.b;
import q.h;
import q.v;
import s.c2;
import s.v0;
import u7.a;

final class x2
{
  private final b a;
  
  x2(b paramb)
  {
    this.a = paramb;
  }
  
  o.g a(int paramInt, List<b> paramList, l2.a parama)
  {
    return this.a.d(paramInt, paramList, parama);
  }
  
  public Executor b()
  {
    return this.a.c();
  }
  
  a<Void> c(CameraDevice paramCameraDevice, o.g paramg, List<v0> paramList)
  {
    return this.a.i(paramCameraDevice, paramg, paramList);
  }
  
  a<List<Surface>> d(List<v0> paramList, long paramLong)
  {
    return this.a.f(paramList, paramLong);
  }
  
  boolean e()
  {
    return this.a.stop();
  }
  
  static class a
  {
    private final Executor a;
    private final ScheduledExecutorService b;
    private final Handler c;
    private final v1 d;
    private final c2 e;
    private final c2 f;
    private final boolean g;
    
    a(Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler, v1 paramv1, c2 paramc21, c2 paramc22)
    {
      this.a = paramExecutor;
      this.b = paramScheduledExecutorService;
      this.c = paramHandler;
      this.d = paramv1;
      this.e = paramc21;
      this.f = paramc22;
      boolean bool;
      if ((!new h(paramc21, paramc22).b()) && (!new v(paramc21).i()) && (!new q.g(paramc22).d())) {
        bool = false;
      } else {
        bool = true;
      }
      this.g = bool;
    }
    
    x2 a()
    {
      Object localObject;
      if (this.g) {
        localObject = new w2(this.e, this.f, this.d, this.a, this.b, this.c);
      } else {
        localObject = new r2(this.d, this.a, this.b, this.c);
      }
      return new x2((x2.b)localObject);
    }
  }
  
  static abstract interface b
  {
    public abstract Executor c();
    
    public abstract o.g d(int paramInt, List<b> paramList, l2.a parama);
    
    public abstract a<List<Surface>> f(List<v0> paramList, long paramLong);
    
    public abstract a<Void> i(CameraDevice paramCameraDevice, o.g paramg, List<v0> paramList);
    
    public abstract boolean stop();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.x2
 * JD-Core Version:    0.7.0.1
 */