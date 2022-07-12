package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.b;
import n.d;

public final class h1
{
  public static CameraCaptureSession.StateCallback a(List<CameraCaptureSession.StateCallback> paramList)
  {
    if (paramList.isEmpty()) {
      return b();
    }
    if (paramList.size() == 1) {
      return (CameraCaptureSession.StateCallback)paramList.get(0);
    }
    return new a(paramList);
  }
  
  public static CameraCaptureSession.StateCallback b()
  {
    return new b();
  }
  
  static final class a
    extends CameraCaptureSession.StateCallback
  {
    private final List<CameraCaptureSession.StateCallback> a = new ArrayList();
    
    a(List<CameraCaptureSession.StateCallback> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CameraCaptureSession.StateCallback localStateCallback = (CameraCaptureSession.StateCallback)paramList.next();
        if (!(localStateCallback instanceof h1.b)) {
          this.a.add(localStateCallback);
        }
      }
    }
    
    public void onActive(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.StateCallback)localIterator.next()).onActive(paramCameraCaptureSession);
      }
    }
    
    public void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        d.b((CameraCaptureSession.StateCallback)localIterator.next(), paramCameraCaptureSession);
      }
    }
    
    public void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.StateCallback)localIterator.next()).onClosed(paramCameraCaptureSession);
      }
    }
    
    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.StateCallback)localIterator.next()).onConfigureFailed(paramCameraCaptureSession);
      }
    }
    
    public void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.StateCallback)localIterator.next()).onConfigured(paramCameraCaptureSession);
      }
    }
    
    public void onReady(CameraCaptureSession paramCameraCaptureSession)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.StateCallback)localIterator.next()).onReady(paramCameraCaptureSession);
      }
    }
    
    public void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        b.a((CameraCaptureSession.StateCallback)localIterator.next(), paramCameraCaptureSession, paramSurface);
      }
    }
  }
  
  static final class b
    extends CameraCaptureSession.StateCallback
  {
    public void onActive(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onClosed(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onConfigured(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onReady(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.h1
 * JD-Core Version:    0.7.0.1
 */