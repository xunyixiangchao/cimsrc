package n;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Build.VERSION;
import java.util.concurrent.Executor;

class o0
  extends q0
{
  o0(Context paramContext)
  {
    super(paramContext, null);
  }
  
  static o0 g(Context paramContext)
  {
    return new o0(paramContext);
  }
  
  private boolean h(Throwable paramThrowable)
  {
    return (Build.VERSION.SDK_INT == 28) && (i(paramThrowable));
  }
  
  private static boolean i(Throwable paramThrowable)
  {
    if (paramThrowable.getClass().equals(RuntimeException.class))
    {
      paramThrowable = paramThrowable.getStackTrace();
      if (paramThrowable != null)
      {
        if (paramThrowable.length < 0) {
          return false;
        }
        return "_enableShutterSound".equals(paramThrowable[0].getMethodName());
      }
    }
    return false;
  }
  
  private void j(Throwable paramThrowable)
  {
    throw new f(10001, paramThrowable);
  }
  
  public void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    this.a.registerAvailabilityCallback(paramExecutor, paramAvailabilityCallback);
  }
  
  public void b(CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    this.a.unregisterAvailabilityCallback(paramAvailabilityCallback);
  }
  
  public CameraCharacteristics c(String paramString)
  {
    try
    {
      paramString = super.c(paramString);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      if (h(paramString)) {
        j(paramString);
      }
      throw paramString;
    }
  }
  
  public void d(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    try
    {
      try
      {
        this.a.openCamera(paramString, paramExecutor, paramStateCallback);
        return;
      }
      catch (RuntimeException paramString)
      {
        if (h(paramString)) {
          j(paramString);
        }
        throw paramString;
      }
      catch (SecurityException paramString) {}catch (IllegalArgumentException paramString) {}
      throw paramString;
    }
    catch (CameraAccessException paramString)
    {
      throw f.e(paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.o0
 * JD-Core Version:    0.7.0.1
 */