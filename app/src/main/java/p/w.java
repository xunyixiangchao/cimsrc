package p;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import n.z;

public class w
  implements f0
{
  public static final List<String> a = Arrays.asList(new String[] { "sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn" });
  
  static boolean a(z paramz)
  {
    return (a.contains(Build.MODEL.toLowerCase(Locale.US))) && (((Integer)paramz.a(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.w
 * JD-Core Version:    0.7.0.1
 */