package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c.a;
import m.b.a;
import n.z;

final class a
  implements d3.b
{
  private final z a;
  private final Range<Float> b;
  private float c = 1.0F;
  private c.a<Void> d;
  private float e = 1.0F;
  
  a(z paramz)
  {
    this.a = paramz;
    this.b = ((Range)paramz.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE));
  }
  
  public void a(TotalCaptureResult paramTotalCaptureResult)
  {
    if (this.d != null)
    {
      paramTotalCaptureResult = paramTotalCaptureResult.getRequest();
      if (paramTotalCaptureResult == null) {
        paramTotalCaptureResult = null;
      } else {
        paramTotalCaptureResult = (Float)paramTotalCaptureResult.get(CaptureRequest.CONTROL_ZOOM_RATIO);
      }
      if (paramTotalCaptureResult == null) {
        return;
      }
      float f = paramTotalCaptureResult.floatValue();
      if (this.e == f)
      {
        this.d.c(null);
        this.d = null;
      }
    }
  }
  
  public float b()
  {
    return ((Float)this.b.getUpper()).floatValue();
  }
  
  public void c(b.a parama)
  {
    parama.e(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.c));
  }
  
  public float d()
  {
    return ((Float)this.b.getLower()).floatValue();
  }
  
  public void e()
  {
    this.c = 1.0F;
    c.a locala = this.d;
    if (locala != null)
    {
      locala.f(new m.a("Camera is not active."));
      this.d = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.a
 * JD-Core Version:    0.7.0.1
 */