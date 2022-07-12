package p;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import s.b2;

public class k
  implements b2
{
  static final List<String> a = Arrays.asList(new String[] { "SM-A3000", "SM-A3009", "SM-A300F", "SM-A300FU", "SM-A300G", "SM-A300H", "SM-A300M", "SM-A300X", "SM-A300XU", "SM-A300XZ", "SM-A300Y", "SM-A300YZ", "SM-J510FN", "5059X" });
  
  static boolean a()
  {
    return a.contains(Build.MODEL.toUpperCase(Locale.US));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.k
 * JD-Core Version:    0.7.0.1
 */