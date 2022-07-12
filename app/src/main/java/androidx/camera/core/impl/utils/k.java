package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import u0.d;

public final class k
{
  private static volatile Handler a;
  
  public static Handler a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = d.a(Looper.getMainLooper());
      }
      return a;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.k
 * JD-Core Version:    0.7.0.1
 */