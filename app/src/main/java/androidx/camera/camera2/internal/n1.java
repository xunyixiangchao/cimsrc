package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import java.util.Objects;
import s.k;

final class n1
  extends k
{
  private final CameraCaptureSession.CaptureCallback a;
  
  private n1(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    Objects.requireNonNull(paramCaptureCallback, "captureCallback is null");
    this.a = paramCaptureCallback;
  }
  
  static n1 d(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return new n1(paramCaptureCallback);
  }
  
  CameraCaptureSession.CaptureCallback e()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.n1
 * JD-Core Version:    0.7.0.1
 */