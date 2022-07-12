package p;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import s.b2;

public class e0
  implements b2
{
  public static final List<String> a = Arrays.asList(new String[] { "mi a1", "mi a2", "mi a2 lite", "redmi 4x", "redmi 5a", "redmi 6 pro" });
  
  static boolean a()
  {
    return a.contains(Build.MODEL.toLowerCase(Locale.US));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.e0
 * JD-Core Version:    0.7.0.1
 */