package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;

public class d
{
  public static <T> OutputConfiguration a(Size paramSize, Class<T> paramClass)
  {
    return new OutputConfiguration(paramSize, paramClass);
  }
  
  public static void b(CameraCaptureSession.StateCallback paramStateCallback, CameraCaptureSession paramCameraCaptureSession)
  {
    paramStateCallback.onCaptureQueueEmpty(paramCameraCaptureSession);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.d
 * JD-Core Version:    0.7.0.1
 */