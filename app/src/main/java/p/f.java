package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;

public class f
  implements f0
{
  public static final List<String> a = Arrays.asList(new String[] { "SM-N9200", "SM-N9208", "SAMSUNG-SM-N920A", "SM-N920C", "SM-N920F", "SM-N920G", "SM-N920I", "SM-N920K", "SM-N920L", "SM-N920P", "SM-N920R4", "SM-N920R6", "SM-N920R7", "SM-N920S", "SM-N920T", "SM-N920V", "SM-N920W8", "SM-N920X", "SM-J510FN" });
  
  static boolean a(z paramz)
  {
    return (a.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.f
 * JD-Core Version:    0.7.0.1
 */