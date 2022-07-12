package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.n1;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import q.h;
import q.v;
import s.c2;
import s.v0;
import u.f;
import u7.a;

class w2
  extends r2
{
  private final Object o = new Object();
  private List<v0> p;
  a<Void> q;
  private final h r;
  private final v s;
  private final q.g t;
  
  w2(c2 paramc21, c2 paramc22, v1 paramv1, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler)
  {
    super(paramv1, paramExecutor, paramScheduledExecutorService, paramHandler);
    this.r = new h(paramc21, paramc22);
    this.s = new v(paramc21);
    this.t = new q.g(paramc22);
  }
  
  void N(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this);
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    n1.a("SyncCaptureSessionImpl", localStringBuilder.toString());
  }
  
  public void close()
  {
    N("Session call close()");
    this.s.f();
    this.s.c().h(new s2(this), c());
  }
  
  public a<List<Surface>> f(List<v0> paramList, long paramLong)
  {
    synchronized (this.o)
    {
      this.p = paramList;
      paramList = super.f(paramList, paramLong);
      return paramList;
    }
  }
  
  public a<Void> h()
  {
    return this.s.c();
  }
  
  public a<Void> i(CameraDevice paramCameraDevice, o.g paramg, List<v0> paramList)
  {
    synchronized (this.o)
    {
      paramCameraDevice = this.s.g(paramCameraDevice, paramg, paramList, this.b.e(), new u2(this));
      this.q = paramCameraDevice;
      paramCameraDevice = f.j(paramCameraDevice);
      return paramCameraDevice;
    }
  }
  
  public int m(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return this.s.h(paramCaptureRequest, paramCaptureCallback, new v2(this));
  }
  
  public void p(l2 paraml2)
  {
    synchronized (this.o)
    {
      this.r.a(this.p);
      N("onClosed()");
      super.p(paraml2);
      return;
    }
  }
  
  public void r(l2 paraml2)
  {
    N("Session onConfigured()");
    this.t.c(paraml2, this.b.f(), this.b.d(), new t2(this));
  }
  
  public boolean stop()
  {
    synchronized (this.o)
    {
      if (C())
      {
        this.r.a(this.p);
      }
      else
      {
        a locala = this.q;
        if (locala != null) {
          locala.cancel(true);
        }
      }
      boolean bool = super.stop();
      return bool;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.w2
 * JD-Core Version:    0.7.0.1
 */