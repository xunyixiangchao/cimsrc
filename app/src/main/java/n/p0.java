package n;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

class p0
  extends o0
{
  p0(Context paramContext)
  {
    super(paramContext);
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
    try
    {
      this.a.openCamera(paramString, paramExecutor, paramStateCallback);
      return;
    }
    catch (CameraAccessException paramString)
    {
      throw f.e(paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.p0
 * JD-Core Version:    0.7.0.1
 */