package p;

import android.hardware.camera2.CameraCharacteristics;
import n.z;
import s.b2;

public class j
  implements b2
{
  static boolean a(z paramz)
  {
    paramz = (Integer)paramz.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    return (paramz != null) && (paramz.intValue() == 2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.j
 * JD-Core Version:    0.7.0.1
 */