package n;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.b;
import o.g;
import x0.h;

class i0
  implements a0.a
{
  final CameraDevice a;
  final Object b;
  
  i0(CameraDevice paramCameraDevice, Object paramObject)
  {
    this.a = ((CameraDevice)h.g(paramCameraDevice));
    this.b = paramObject;
  }
  
  private static void b(CameraDevice paramCameraDevice, List<b> paramList)
  {
    paramCameraDevice = paramCameraDevice.getId();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((b)paramList.next()).c();
      if ((str != null) && (!str.isEmpty()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Camera ");
        localStringBuilder.append(paramCameraDevice);
        localStringBuilder.append(": Camera doesn't support physicalCameraId ");
        localStringBuilder.append(str);
        localStringBuilder.append(". Ignoring.");
        n1.k("CameraDeviceCompat", localStringBuilder.toString());
      }
    }
  }
  
  static void c(CameraDevice paramCameraDevice, g paramg)
  {
    h.g(paramCameraDevice);
    h.g(paramg);
    h.g(paramg.e());
    List localList = paramg.c();
    if (localList != null)
    {
      if (paramg.a() != null)
      {
        b(paramCameraDevice, localList);
        return;
      }
      throw new IllegalArgumentException("Invalid executor");
    }
    throw new IllegalArgumentException("Invalid output configurations");
  }
  
  static List<Surface> e(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((b)paramList.next()).d());
    }
    return localArrayList;
  }
  
  void d(CameraDevice paramCameraDevice, List<Surface> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    try
    {
      paramCameraDevice.createCaptureSession(paramList, paramStateCallback, paramHandler);
      return;
    }
    catch (CameraAccessException paramCameraDevice)
    {
      throw f.e(paramCameraDevice);
    }
  }
  
  static class a
  {
    final Handler a;
    
    a(Handler paramHandler)
    {
      this.a = paramHandler;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.i0
 * JD-Core Version:    0.7.0.1
 */