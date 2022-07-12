package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r.j;
import r.j.a;
import s.n0;
import s.s0;
import s.s0.a;
import s.t;
import s.v0;

class b1
{
  private static void a(CaptureRequest.Builder paramBuilder, s0 params0)
  {
    params0 = j.a.e(params0).d();
    Iterator localIterator = params0.c().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (s0.a)localIterator.next();
      CaptureRequest.Key localKey = (CaptureRequest.Key)((s0.a)localObject).d();
      try
      {
        paramBuilder.set(localKey, params0.a((s0.a)localObject));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        label61:
        break label61;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CaptureRequest.Key is not supported: ");
      ((StringBuilder)localObject).append(localKey);
      n1.c("Camera2CaptureRequestBuilder", ((StringBuilder)localObject).toString());
    }
  }
  
  public static CaptureRequest b(n0 paramn0, CameraDevice paramCameraDevice, Map<v0, Surface> paramMap)
  {
    if (paramCameraDevice == null) {
      return null;
    }
    paramMap = d(paramn0.e(), paramMap);
    if (paramMap.isEmpty()) {
      return null;
    }
    Object localObject = paramn0.c();
    if ((paramn0.g() == 5) && (localObject != null) && ((((t)localObject).f() instanceof TotalCaptureResult)))
    {
      n1.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
      paramCameraDevice = a.a(paramCameraDevice, (TotalCaptureResult)((t)localObject).f());
    }
    else
    {
      n1.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
      paramCameraDevice = paramCameraDevice.createCaptureRequest(paramn0.g());
    }
    a(paramCameraDevice, paramn0.d());
    localObject = paramn0.d();
    s0.a locala = n0.h;
    if (((s0)localObject).b(locala)) {
      paramCameraDevice.set(CaptureRequest.JPEG_ORIENTATION, (Integer)paramn0.d().a(locala));
    }
    localObject = paramn0.d();
    locala = n0.i;
    if (((s0)localObject).b(locala)) {
      paramCameraDevice.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer)paramn0.d().a(locala)).byteValue()));
    }
    paramMap = paramMap.iterator();
    while (paramMap.hasNext()) {
      paramCameraDevice.addTarget((Surface)paramMap.next());
    }
    paramCameraDevice.setTag(paramn0.f());
    return paramCameraDevice.build();
  }
  
  public static CaptureRequest c(n0 paramn0, CameraDevice paramCameraDevice)
  {
    if (paramCameraDevice == null) {
      return null;
    }
    paramCameraDevice = paramCameraDevice.createCaptureRequest(paramn0.g());
    a(paramCameraDevice, paramn0.d());
    return paramCameraDevice.build();
  }
  
  private static List<Surface> d(List<v0> paramList, Map<v0, Surface> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Surface localSurface = (Surface)paramMap.get((v0)paramList.next());
      if (localSurface != null) {
        localArrayList.add(localSurface);
      } else {
        throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
      }
    }
    return localArrayList;
  }
  
  static class a
  {
    static CaptureRequest.Builder a(CameraDevice paramCameraDevice, TotalCaptureResult paramTotalCaptureResult)
    {
      return paramCameraDevice.createReprocessCaptureRequest(paramTotalCaptureResult);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.b1
 * JD-Core Version:    0.7.0.1
 */