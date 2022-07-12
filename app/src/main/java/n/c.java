package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;

public class c
{
  public static void a(CameraCaptureSession.CaptureCallback paramCaptureCallback, CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
  {
    paramCaptureCallback.onCaptureBufferLost(paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.c
 * JD-Core Version:    0.7.0.1
 */