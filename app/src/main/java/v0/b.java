package v0;

import android.os.Handler;
import android.os.Looper;

class b
{
  static Handler a()
  {
    if (Looper.myLooper() == null) {
      return new Handler(Looper.getMainLooper());
    }
    return new Handler();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v0.b
 * JD-Core Version:    0.7.0.1
 */