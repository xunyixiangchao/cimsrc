package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Range;
import androidx.camera.core.j3;
import androidx.camera.core.n1;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import java.util.concurrent.Executor;
import m.b.a;
import n.z;
import v.f;

final class d3
{
  private final t a;
  private final Executor b;
  private final e3 c;
  private final r<j3> d;
  final b e;
  private boolean f = false;
  private t.c g = new a();
  
  d3(t paramt, z paramz, Executor paramExecutor)
  {
    this.a = paramt;
    this.b = paramExecutor;
    paramz = b(paramz);
    this.e = paramz;
    paramz = new e3(paramz.b(), paramz.d());
    this.c = paramz;
    paramz.f(1.0F);
    this.d = new r(f.e(paramz));
    paramt.s(this.g);
  }
  
  private static b b(z paramz)
  {
    if (e(paramz)) {
      return new a(paramz);
    }
    return new w1(paramz);
  }
  
  private static Range<Float> c(z paramz)
  {
    try
    {
      paramz = (Range)paramz.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
      return paramz;
    }
    catch (AssertionError paramz)
    {
      n1.l("ZoomControl", "AssertionError, fail to get camera characteristic.", paramz);
    }
    return null;
  }
  
  static boolean e(z paramz)
  {
    return (Build.VERSION.SDK_INT >= 30) && (c(paramz) != null);
  }
  
  private void g(j3 paramj3)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.d.o(paramj3);
      return;
    }
    this.d.m(paramj3);
  }
  
  void a(b.a parama)
  {
    this.e.c(parama);
  }
  
  LiveData<j3> d()
  {
    return this.d;
  }
  
  void f(boolean paramBoolean)
  {
    if (this.f == paramBoolean) {
      return;
    }
    this.f = paramBoolean;
    if (!paramBoolean) {
      synchronized (this.c)
      {
        this.c.f(1.0F);
        j3 localj3 = f.e(this.c);
        g(localj3);
        this.e.e();
        this.a.g0();
        return;
      }
    }
  }
  
  class a
    implements t.c
  {
    a() {}
    
    public boolean a(TotalCaptureResult paramTotalCaptureResult)
    {
      d3.this.e.a(paramTotalCaptureResult);
      return false;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(TotalCaptureResult paramTotalCaptureResult);
    
    public abstract float b();
    
    public abstract void c(b.a parama);
    
    public abstract float d();
    
    public abstract void e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.d3
 * JD-Core Version:    0.7.0.1
 */