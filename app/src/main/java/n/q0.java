package n;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Handler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import x0.h;

class q0
  implements m0.b
{
  final CameraManager a;
  final Object b;
  
  q0(Context paramContext, Object paramObject)
  {
    this.a = ((CameraManager)paramContext.getSystemService("camera"));
    this.b = paramObject;
  }
  
  static q0 f(Context paramContext, Handler paramHandler)
  {
    return new q0(paramContext, new a(paramHandler));
  }
  
  public void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    if (paramExecutor != null)
    {
      Object localObject = null;
      a locala1 = (a)this.b;
      if (paramAvailabilityCallback != null) {
        synchronized (locala1.a)
        {
          m0.a locala = (m0.a)locala1.a.get(paramAvailabilityCallback);
          localObject = locala;
          if (locala == null)
          {
            localObject = new m0.a(paramExecutor, paramAvailabilityCallback);
            locala1.a.put(paramAvailabilityCallback, localObject);
          }
        }
      }
      this.a.registerAvailabilityCallback((CameraManager.AvailabilityCallback)localObject, locala1.b);
      return;
    }
    throw new IllegalArgumentException("executor was null");
  }
  
  public void b(CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    if (paramAvailabilityCallback != null)
    {
      a locala = (a)this.b;
      synchronized (locala.a)
      {
        paramAvailabilityCallback = (m0.a)locala.a.remove(paramAvailabilityCallback);
      }
    }
    paramAvailabilityCallback = null;
    if (paramAvailabilityCallback != null) {
      paramAvailabilityCallback.g();
    }
    this.a.unregisterAvailabilityCallback(paramAvailabilityCallback);
  }
  
  public CameraCharacteristics c(String paramString)
  {
    try
    {
      paramString = this.a.getCameraCharacteristics(paramString);
      return paramString;
    }
    catch (CameraAccessException paramString)
    {
      throw f.e(paramString);
    }
  }
  
  public void d(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    h.g(paramExecutor);
    h.g(paramStateCallback);
    paramExecutor = new a0.b(paramExecutor, paramStateCallback);
    paramStateCallback = (a)this.b;
    try
    {
      this.a.openCamera(paramString, paramExecutor, paramStateCallback.b);
      return;
    }
    catch (CameraAccessException paramString)
    {
      throw f.e(paramString);
    }
  }
  
  public String[] e()
  {
    try
    {
      String[] arrayOfString = this.a.getCameraIdList();
      return arrayOfString;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      throw f.e(localCameraAccessException);
    }
  }
  
  static final class a
  {
    final Map<CameraManager.AvailabilityCallback, m0.a> a = new HashMap();
    final Handler b;
    
    a(Handler paramHandler)
    {
      this.b = paramHandler;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.q0
 * JD-Core Version:    0.7.0.1
 */