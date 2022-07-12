package p;

import android.os.Build;
import android.util.Pair;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import s.b2;

public class q
  implements b2
{
  private static final Set<Pair<String, String>> a = new HashSet(Arrays.asList(new Pair[] { new Pair("sprd", "lemp") }));
  
  static boolean a()
  {
    Set localSet = a;
    String str = Build.MANUFACTURER;
    Locale localLocale = Locale.US;
    return localSet.contains(new Pair(str.toLowerCase(localLocale), Build.MODEL.toLowerCase(localLocale)));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.q
 * JD-Core Version:    0.7.0.1
 */