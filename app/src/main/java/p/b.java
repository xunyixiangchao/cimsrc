package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import n.z;
import s.b2;

public class b
  implements b2
{
  static boolean a(z paramz)
  {
    return (Build.BRAND.equalsIgnoreCase("SAMSUNG")) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.b
 * JD-Core Version:    0.7.0.1
 */