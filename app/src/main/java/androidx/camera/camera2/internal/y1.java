package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c.a;
import java.util.concurrent.Executor;
import m.b.a;
import n.z;

public class y1
{
  private final t a;
  private final z1 b;
  private final Executor c;
  private boolean d = false;
  private c.a<Integer> e;
  private t.c f;
  
  y1(t paramt, z paramz, Executor paramExecutor)
  {
    this.a = paramt;
    this.b = new z1(paramz, 0);
    this.c = paramExecutor;
  }
  
  private void a()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((c.a)localObject).f(new m.a("Cancelled by another setExposureCompensationIndex()"));
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      this.a.W((t.c)localObject);
      this.f = null;
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {
      return;
    }
    this.d = paramBoolean;
    if (!paramBoolean)
    {
      this.b.b(0);
      a();
    }
  }
  
  void c(b.a parama)
  {
    parama.e(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.b.a()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.y1
 * JD-Core Version:    0.7.0.1
 */