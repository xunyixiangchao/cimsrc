package androidx.emoji2.text;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class b
{
  static ThreadPoolExecutor b(String paramString)
  {
    paramString = new a(paramString);
    paramString = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), paramString);
    paramString.allowCoreThreadTimeOut(true);
    return paramString;
  }
  
  static Handler d()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return a.a(Looper.getMainLooper());
    }
    return new Handler(Looper.getMainLooper());
  }
  
  static class a
  {
    public static Handler a(Looper paramLooper)
    {
      return Handler.createAsync(paramLooper);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.emoji2.text.b
 * JD-Core Version:    0.7.0.1
 */