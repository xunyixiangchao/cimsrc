package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.m.a;
import androidx.concurrent.futures.c.a;
import m.b.a;
import n.z;

final class w1
  implements d3.b
{
  private final z a;
  private Rect b = null;
  private c.a<Void> c;
  private Rect d = null;
  
  w1(z paramz)
  {
    this.a = paramz;
  }
  
  public void a(TotalCaptureResult paramTotalCaptureResult)
  {
    if (this.c != null)
    {
      paramTotalCaptureResult = paramTotalCaptureResult.getRequest();
      if (paramTotalCaptureResult == null) {
        paramTotalCaptureResult = null;
      } else {
        paramTotalCaptureResult = (Rect)paramTotalCaptureResult.get(CaptureRequest.SCALER_CROP_REGION);
      }
      Rect localRect = this.d;
      if ((localRect != null) && (localRect.equals(paramTotalCaptureResult)))
      {
        this.c.c(null);
        this.c = null;
        this.d = null;
      }
    }
  }
  
  public float b()
  {
    Float localFloat = (Float)this.a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
    if (localFloat == null) {
      return 1.0F;
    }
    if (localFloat.floatValue() < d()) {
      return d();
    }
    return localFloat.floatValue();
  }
  
  public void c(b.a parama)
  {
    Rect localRect = this.b;
    if (localRect != null) {
      parama.e(CaptureRequest.SCALER_CROP_REGION, localRect);
    }
  }
  
  public float d()
  {
    return 1.0F;
  }
  
  public void e()
  {
    this.d = null;
    this.b = null;
    c.a locala = this.c;
    if (locala != null)
    {
      locala.f(new m.a("Camera is not active."));
      this.c = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.w1
 * JD-Core Version:    0.7.0.1
 */