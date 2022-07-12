package k2;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class r
{
  public static final boolean g;
  public static final boolean h;
  private static final File i = new File("/proc/self/fd");
  private static volatile r j;
  private static volatile int k = -1;
  private final boolean a = f();
  private final int b;
  private final int c;
  private int d;
  private boolean e = true;
  private final AtomicBoolean f = new AtomicBoolean(false);
  
  static
  {
    int m = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    boolean bool1;
    if (m < 29) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    g = bool1;
    if (m >= 26) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    h = bool1;
  }
  
  r()
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.b = 20000;
      this.c = 0;
      return;
    }
    this.b = 700;
    this.c = 128;
  }
  
  private boolean a()
  {
    return (g) && (!this.f.get());
  }
  
  public static r b()
  {
    if (j == null) {
      try
      {
        if (j == null) {
          j = new r();
        }
      }
      finally {}
    }
    return j;
  }
  
  private int c()
  {
    if (k != -1) {
      return k;
    }
    return this.b;
  }
  
  private boolean d()
  {
    for (;;)
    {
      try
      {
        int m = this.d;
        bool = true;
        m += 1;
        this.d = m;
        if (m >= 50)
        {
          this.d = 0;
          m = i.list().length;
          long l = c();
          if (m >= l) {
            break label137;
          }
          this.e = bool;
          if ((!bool) && (Log.isLoggable("Downsampler", 5)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
            localStringBuilder.append(m);
            localStringBuilder.append(", limit ");
            localStringBuilder.append(l);
            Log.w("Downsampler", localStringBuilder.toString());
          }
        }
        bool = this.e;
        return bool;
      }
      finally {}
      label137:
      boolean bool = false;
    }
  }
  
  private static boolean f()
  {
    return (!g()) && (!h());
  }
  
  private static boolean g()
  {
    if (Build.VERSION.SDK_INT != 26) {
      return false;
    }
    Iterator localIterator = Arrays.asList(new String[] { "SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play" }).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Build.MODEL.startsWith(str)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean h()
  {
    if (Build.VERSION.SDK_INT != 27) {
      return false;
    }
    return Arrays.asList(new String[] { "LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM" }).contains(Build.MODEL);
  }
  
  public boolean e(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by caller");
      }
      return false;
    }
    if (!this.a)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by device model");
      }
      return false;
    }
    if (!h)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by sdk");
      }
      return false;
    }
    if (a())
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed by app state");
      }
      return false;
    }
    if (paramBoolean2)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
      }
      return false;
    }
    int m = this.c;
    if (paramInt1 < m)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
      }
      return false;
    }
    if (paramInt2 < m)
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
      }
      return false;
    }
    if (!d())
    {
      if (Log.isLoggable("HardwareConfig", 2)) {
        Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(26)
  boolean i(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = e(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      paramOptions.inPreferredConfig = Bitmap.Config.HARDWARE;
      paramOptions.inMutable = false;
    }
    return paramBoolean1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k2.r
 * JD-Core Version:    0.7.0.1
 */