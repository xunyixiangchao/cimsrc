package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;

public class b
{
  public static void a(CameraCaptureSession.StateCallback paramStateCallback, CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
  {
    paramStateCallback.onSurfacePrepared(paramCameraCaptureSession, paramSurface);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.b
 * JD-Core Version:    0.7.0.1
 */