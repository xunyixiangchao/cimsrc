package p;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import s.b2;

public class u
  implements b2
{
  public static final List<String> a = Arrays.asList(new String[] { "Pixel 2", "Pixel 2 XL", "Pixel 3", "Pixel 3 XL" });
  
  static boolean a()
  {
    return (a.contains(Build.MODEL)) && ("Google".equals(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 26);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.u
 * JD-Core Version:    0.7.0.1
 */