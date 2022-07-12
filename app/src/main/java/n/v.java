package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

class v
  extends w
{
  v(CameraCaptureSession paramCameraCaptureSession)
  {
    super(paramCameraCaptureSession, null);
  }
  
  public int b(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return this.a.setSingleRepeatingRequest(paramCaptureRequest, paramExecutor, paramCaptureCallback);
  }
  
  public int c(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return this.a.captureBurstRequests(paramList, paramExecutor, paramCaptureCallback);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.v
 * JD-Core Version:    0.7.0.1
 */