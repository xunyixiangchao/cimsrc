package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import n.z;

final class k3
{
  public static boolean a(z paramz, int paramInt)
  {
    paramz = (int[])paramz.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
    if (paramz != null)
    {
      int j = paramz.length;
      int i = 0;
      while (i < j)
      {
        if (paramz[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.k3
 * JD-Core Version:    0.7.0.1
 */