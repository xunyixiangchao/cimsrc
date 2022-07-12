package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;

public class v
  implements f0
{
  public static final List<String> a = Arrays.asList(new String[] { "SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P" });
  
  static boolean a(z paramz)
  {
    return (a.contains(Build.MODEL.toUpperCase(Locale.US))) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.v
 * JD-Core Version:    0.7.0.1
 */