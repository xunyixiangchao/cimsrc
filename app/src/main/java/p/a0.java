package p;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import s.b2;

public class a0
  implements b2
{
  private static final List<String> a = Arrays.asList(new String[] { "sunfish", "bramble", "redfin", "barbet" });
  
  static boolean a()
  {
    return ("Google".equals(Build.MANUFACTURER)) && (a.contains(Build.DEVICE.toLowerCase(Locale.getDefault())));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.a0
 * JD-Core Version:    0.7.0.1
 */