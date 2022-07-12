package n;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import java.util.List;
import o.a;
import o.g;
import x0.h;

class g0
  extends f0
{
  g0(CameraDevice paramCameraDevice, Object paramObject)
  {
    super(paramCameraDevice, paramObject);
  }
  
  static g0 g(CameraDevice paramCameraDevice, Handler paramHandler)
  {
    return new g0(paramCameraDevice, new i0.a(paramHandler));
  }
  
  public void a(g paramg)
  {
    i0.c(this.a, paramg);
    g.c localc = new g.c(paramg.a(), paramg.e());
    List localList = paramg.c();
    Handler localHandler = ((i0.a)h.g((i0.a)this.b)).a;
    a locala = paramg.b();
    if (locala != null) {}
    try
    {
      paramg = (InputConfiguration)locala.a();
      h.g(paramg);
      this.a.createReprocessableCaptureSessionByConfigurations(paramg, g.h(localList), localc, localHandler);
      return;
    }
    catch (CameraAccessException paramg)
    {
      throw f.e(paramg);
    }
    if (paramg.d() == 1)
    {
      this.a.createConstrainedHighSpeedCaptureSession(i0.e(localList), localc, localHandler);
      return;
    }
    this.a.createCaptureSessionByOutputConfigurations(g.h(localList), localc, localHandler);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.g0
 * JD-Core Version:    0.7.0.1
 */