package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import java.util.Objects;
import s.k;
import s.m;
import s.m.a;
import s.n2;
import x0.h;

final class m1
  extends CameraCaptureSession.CaptureCallback
{
  private final k a;
  
  m1(k paramk)
  {
    Objects.requireNonNull(paramk, "cameraCaptureCallback is null");
    this.a = paramk;
  }
  
  public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
  {
    super.onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if (paramCameraCaptureSession != null)
    {
      h.b(paramCameraCaptureSession instanceof n2, "The tagBundle object from the CaptureResult is not a TagBundle object.");
      paramCameraCaptureSession = (n2)paramCameraCaptureSession;
    }
    else
    {
      paramCameraCaptureSession = n2.a();
    }
    this.a.b(new e(paramCameraCaptureSession, paramTotalCaptureResult));
  }
  
  public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
  {
    super.onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
    paramCameraCaptureSession = new m(m.a.a);
    this.a.c(paramCameraCaptureSession);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.m1
 * JD-Core Version:    0.7.0.1
 */