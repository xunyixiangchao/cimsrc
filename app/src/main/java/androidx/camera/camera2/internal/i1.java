package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i1
{
  public static CameraDevice.StateCallback a(List<CameraDevice.StateCallback> paramList)
  {
    if (paramList.isEmpty()) {
      return b();
    }
    if (paramList.size() == 1) {
      return (CameraDevice.StateCallback)paramList.get(0);
    }
    return new a(paramList);
  }
  
  public static CameraDevice.StateCallback b()
  {
    return new b();
  }
  
  private static final class a
    extends CameraDevice.StateCallback
  {
    private final List<CameraDevice.StateCallback> a = new ArrayList();
    
    a(List<CameraDevice.StateCallback> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CameraDevice.StateCallback localStateCallback = (CameraDevice.StateCallback)paramList.next();
        if (!(localStateCallback instanceof i1.b)) {
          this.a.add(localStateCallback);
        }
      }
    }
    
    public void onClosed(CameraDevice paramCameraDevice)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onClosed(paramCameraDevice);
      }
    }
    
    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onDisconnected(paramCameraDevice);
      }
    }
    
    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onError(paramCameraDevice, paramInt);
      }
    }
    
    public void onOpened(CameraDevice paramCameraDevice)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraDevice.StateCallback)localIterator.next()).onOpened(paramCameraDevice);
      }
    }
  }
  
  static final class b
    extends CameraDevice.StateCallback
  {
    public void onClosed(CameraDevice paramCameraDevice) {}
    
    public void onDisconnected(CameraDevice paramCameraDevice) {}
    
    public void onError(CameraDevice paramCameraDevice, int paramInt) {}
    
    public void onOpened(CameraDevice paramCameraDevice) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.i1
 * JD-Core Version:    0.7.0.1
 */