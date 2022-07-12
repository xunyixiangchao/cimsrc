package p;

import android.hardware.camera2.CameraCharacteristics;
import n.z;
import s.b2;

public class c
  implements b2
{
  static boolean b(z paramz)
  {
    paramz = (Integer)paramz.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
    if (paramz != null) {
      paramz.intValue();
    }
    return false;
  }
  
  public int a()
  {
    return 2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.c
 * JD-Core Version:    0.7.0.1
 */