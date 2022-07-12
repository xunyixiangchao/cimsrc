package q;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.k0;
import androidx.camera.camera2.internal.l2;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import o.g;
import p.i;
import s.c2;
import s.v0;
import u.d;
import u.f;

public class v
{
  private final boolean a;
  private final Object b = new Object();
  private final u7.a<Void> c;
  c.a<Void> d;
  private boolean e;
  private final CameraCaptureSession.CaptureCallback f = new a();
  
  public v(c2 paramc2)
  {
    this.a = paramc2.a(i.class);
    if (i()) {
      paramc2 = c.a(new t(this));
    } else {
      paramc2 = f.h(null);
    }
    this.c = paramc2;
  }
  
  public u7.a<Void> c()
  {
    return f.j(this.c);
  }
  
  public void f()
  {
    synchronized (this.b)
    {
      if ((i()) && (!this.e)) {
        this.c.cancel(true);
      }
      return;
    }
  }
  
  public u7.a<Void> g(CameraDevice paramCameraDevice, g paramg, List<v0> paramList, List<l2> paramList1, b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext()) {
      localArrayList.add(((l2)paramList1.next()).h());
    }
    return d.a(f.n(localArrayList)).e(new u(paramb, paramCameraDevice, paramg, paramList), t.a.a());
  }
  
  public int h(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback, c paramc)
  {
    Object localObject = this.b;
    CameraCaptureSession.CaptureCallback localCaptureCallback = paramCaptureCallback;
    try
    {
      if (i())
      {
        localCaptureCallback = k0.b(new CameraCaptureSession.CaptureCallback[] { this.f, paramCaptureCallback });
        this.e = true;
      }
      int i = paramc.a(paramCaptureRequest, localCaptureCallback);
      return i;
    }
    finally {}
  }
  
  public boolean i()
  {
    return this.a;
  }
  
  class a
    extends CameraCaptureSession.CaptureCallback
  {
    a() {}
    
    public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      paramCameraCaptureSession = v.this.d;
      if (paramCameraCaptureSession != null)
      {
        paramCameraCaptureSession.d();
        v.this.d = null;
      }
    }
    
    public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      paramCameraCaptureSession = v.this.d;
      if (paramCameraCaptureSession != null)
      {
        paramCameraCaptureSession.c(null);
        v.this.d = null;
      }
    }
  }
  
  @FunctionalInterface
  public static abstract interface b
  {
    public abstract u7.a<Void> a(CameraDevice paramCameraDevice, g paramg, List<v0> paramList);
  }
  
  @FunctionalInterface
  public static abstract interface c
  {
    public abstract int a(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.v
 * JD-Core Version:    0.7.0.1
 */