package u0;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class d
{
  public static Handler a(Looper paramLooper)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return a.a(paramLooper);
    }
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.TRUE });
      return localHandler;
    }
    catch (InvocationTargetException paramLooper)
    {
      paramLooper = paramLooper.getCause();
      if (!(paramLooper instanceof RuntimeException))
      {
        if ((paramLooper instanceof Error)) {
          throw ((Error)paramLooper);
        }
        throw new RuntimeException(paramLooper);
      }
      throw ((RuntimeException)paramLooper);
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", localIllegalAccessException);
    return new Handler(paramLooper);
  }
  
  public static boolean b(Handler paramHandler, Runnable paramRunnable, Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return a.b(paramHandler, paramRunnable, paramObject, paramLong);
    }
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
  
  private static class a
  {
    public static Handler a(Looper paramLooper)
    {
      return Handler.createAsync(paramLooper);
    }
    
    public static boolean b(Handler paramHandler, Runnable paramRunnable, Object paramObject, long paramLong)
    {
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u0.d
 * JD-Core Version:    0.7.0.1
 */