package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;
import s.b2;

public class s
  implements b2
{
  private static final List<String> a = Arrays.asList(new String[] { "sm-j700f", "sm-j710f" });
  
  static boolean a(z paramz)
  {
    return (a.contains(Build.MODEL.toLowerCase(Locale.US))) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.s
 * JD-Core Version:    0.7.0.1
 */