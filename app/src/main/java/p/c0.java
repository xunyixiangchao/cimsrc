package p;

import android.os.Build;
import java.util.Locale;
import s.b2;

public class c0
  implements b2
{
  static boolean a()
  {
    String str = Build.MANUFACTURER;
    Locale localLocale = Locale.US;
    return ("SAMSUNG".equals(str.toUpperCase(localLocale))) && (Build.MODEL.toUpperCase(localLocale).startsWith("SM-A716"));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.c0
 * JD-Core Version:    0.7.0.1
 */