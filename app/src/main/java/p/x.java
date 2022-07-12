package p;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import n.z;
import x.e;

public final class x
  implements e
{
  private static final Set<String> a = new HashSet(Arrays.asList(new String[] { "heroqltevzw", "heroqltetmo" }));
  
  static boolean a(z paramz)
  {
    return a.contains(Build.DEVICE.toLowerCase(Locale.US));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.x
 * JD-Core Version:    0.7.0.1
 */