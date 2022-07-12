package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.Executor;
import x0.h;

class w
  implements g.a
{
  final CameraCaptureSession a;
  final Object b;
  
  w(CameraCaptureSession paramCameraCaptureSession, Object paramObject)
  {
    this.a = ((CameraCaptureSession)h.g(paramCameraCaptureSession));
    this.b = paramObject;
  }
  
  static g.a d(CameraCaptureSession paramCameraCaptureSession, Handler paramHandler)
  {
    return new w(paramCameraCaptureSession, new a(paramHandler));
  }
  
  public CameraCaptureSession a()
  {
    return this.a;
  }
  
  public int b(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    paramExecutor = new g.b(paramExecutor, paramCaptureCallback);
    paramCaptureCallback = (a)this.b;
    return this.a.setRepeatingRequest(paramCaptureRequest, paramExecutor, paramCaptureCallback.a);
  }
  
  public int c(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    paramExecutor = new g.b(paramExecutor, paramCaptureCallback);
    paramCaptureCallback = (a)this.b;
    return this.a.captureBurst(paramList, paramExecutor, paramCaptureCallback.a);
  }
  
  private static class a
  {
    final Handler a;
    
    a(Handler paramHandler)
    {
      this.a = paramHandler;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.w
 * JD-Core Version:    0.7.0.1
 */