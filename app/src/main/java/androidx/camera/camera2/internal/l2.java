package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import java.util.List;
import n.g;
import u7.a;

public abstract interface l2
{
  public abstract a a();
  
  public abstract void b();
  
  public abstract void close();
  
  public abstract void e();
  
  public abstract int g(List<CaptureRequest> paramList, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  
  public abstract a<Void> h();
  
  public abstract g j();
  
  public abstract void k();
  
  public abstract CameraDevice l();
  
  public abstract int m(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  
  public static abstract class a
  {
    void n(l2 paraml2) {}
    
    void o(l2 paraml2) {}
    
    public void p(l2 paraml2) {}
    
    public void q(l2 paraml2) {}
    
    void r(l2 paraml2) {}
    
    void s(l2 paraml2) {}
    
    void t(l2 paraml2) {}
    
    void u(l2 paraml2, Surface paramSurface) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.l2
 * JD-Core Version:    0.7.0.1
 */