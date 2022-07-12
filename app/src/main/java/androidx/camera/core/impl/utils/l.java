package androidx.camera.core.impl.utils;

import android.os.Looper;
import x0.h;

public final class l
{
  public static void a()
  {
    h.j(b(), "Not in application's main thread");
  }
  
  public static boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.l
 * JD-Core Version:    0.7.0.1
 */