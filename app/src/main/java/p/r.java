package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;

public class r
  implements f0
{
  private static final List<String> a = Arrays.asList(new String[] { "PIXEL 3A", "PIXEL 3A XL" });
  
  static boolean a(z paramz)
  {
    return (a.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.r
 * JD-Core Version:    0.7.0.1
 */