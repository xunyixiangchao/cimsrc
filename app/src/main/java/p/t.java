package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;

public class t
  implements f0
{
  private static final List<String> a = Arrays.asList(new String[] { "itel w6004" });
  private static final List<String> b = Arrays.asList(new String[] { "sm-j700f", "sm-j710f" });
  
  static boolean a(z paramz)
  {
    List localList = b;
    String str = Build.MODEL;
    Locale localLocale = Locale.US;
    boolean bool2 = localList.contains(str.toLowerCase(localLocale));
    boolean bool1 = true;
    int i;
    if ((bool2) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    bool2 = a.contains(str.toLowerCase(localLocale));
    if (i == 0)
    {
      if (bool2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.t
 * JD-Core Version:    0.7.0.1
 */