package p;

import android.os.Build;
import android.util.Size;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import s.b2;
import s.l2.b;

public class o
  implements b2
{
  private static final List<String> a = Arrays.asList(new String[] { "SM-T580", "SM-J710MN", "SM-A320FL", "SM-G570M", "SM-G610F", "SM-G610M" });
  
  private static boolean b()
  {
    return ("samsung".equalsIgnoreCase(Build.BRAND)) && (a.contains(Build.MODEL.toUpperCase(Locale.US)));
  }
  
  static boolean c()
  {
    return b();
  }
  
  public Size a(l2.b paramb)
  {
    if (b())
    {
      int i = a.a[paramb.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return new Size(3264, 1836);
        }
        return new Size(1280, 720);
      }
      return new Size(1920, 1080);
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p.o
 * JD-Core Version:    0.7.0.1
 */