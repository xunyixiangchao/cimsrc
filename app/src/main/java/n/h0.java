package n;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import o.g;
import x0.h;

class h0
  extends g0
{
  h0(CameraDevice paramCameraDevice)
  {
    super((CameraDevice)h.g(paramCameraDevice), null);
  }
  
  public void a(g paramg)
  {
    paramg = (SessionConfiguration)paramg.j();
    h.g(paramg);
    try
    {
      this.a.createCaptureSession(paramg);
      return;
    }
    catch (CameraAccessException paramg)
    {
      throw f.e(paramg);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.h0
 * JD-Core Version:    0.7.0.1
 */