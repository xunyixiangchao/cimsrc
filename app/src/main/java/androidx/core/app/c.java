package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class c
{
  protected static final Class<?> a;
  protected static final Field b;
  protected static final Field c;
  protected static final Method d;
  protected static final Method e;
  protected static final Method f;
  private static final Handler g = new Handler(Looper.getMainLooper());
  
  static
  {
    Class localClass = a();
    a = localClass;
    b = b();
    c = f();
    d = d(localClass);
    e = c(localClass);
    f = e(localClass);
  }
  
  private static Class<?> a()
  {
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      return localClass;
    }
    finally
    {
      label8:
      break label8;
    }
    return null;
  }
  
  private static Field b()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mMainThread");
      localField.setAccessible(true);
      return localField;
    }
    finally
    {
      label15:
      break label15;
    }
    return null;
  }
  
  private static Method c(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally {}
    return null;
  }
  
  private static Method d(Class<?> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod("performStopActivity", new Class[] { IBinder.class, Boolean.TYPE, String.class });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally {}
    return null;
  }
  
  private static Method e(Class<?> paramClass)
  {
    if (g()) {
      if (paramClass == null) {
        return null;
      }
    }
    try
    {
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Boolean.TYPE;
      paramClass = paramClass.getDeclaredMethod("requestRelaunchActivity", new Class[] { IBinder.class, List.class, List.class, localClass1, localClass2, Configuration.class, Configuration.class, localClass2, localClass2 });
      paramClass.setAccessible(true);
      return paramClass;
    }
    finally {}
    return null;
    return null;
  }
  
  private static Field f()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mToken");
      localField.setAccessible(true);
      return localField;
    }
    finally
    {
      label15:
      break label15;
    }
    return null;
  }
  
  private static boolean g()
  {
    int i = Build.VERSION.SDK_INT;
    return (i == 26) || (i == 27);
  }
  
  protected static boolean h(Object paramObject, int paramInt, Activity paramActivity)
  {
    try
    {
      final Object localObject = c.get(paramActivity);
      if (localObject == paramObject)
      {
        if (paramActivity.hashCode() != paramInt) {
          return false;
        }
        paramObject = b.get(paramActivity);
        return true;
      }
      return false;
    }
    finally
    {
      Log.e("ActivityRecreator", "Exception while fetching field values", paramObject);
    }
    return false;
  }
  
  static boolean i(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramActivity.recreate();
      return true;
    }
    if ((g()) && (f == null)) {
      return false;
    }
    if ((e == null) && (d == null)) {
      return false;
    }
    try
    {
      final Object localObject1 = c.get(paramActivity);
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = b.get(paramActivity);
      if (localObject2 == null) {
        return false;
      }
      Application localApplication = paramActivity.getApplication();
      final d locald = new d(paramActivity);
      localApplication.registerActivityLifecycleCallbacks(locald);
      Handler localHandler = g;
      localHandler.post(new a(locald, localObject1));
      try
      {
        if (g())
        {
          paramActivity = f;
          Boolean localBoolean = Boolean.FALSE;
          paramActivity.invoke(localObject2, new Object[] { localObject1, null, null, Integer.valueOf(0), localBoolean, null, null, localBoolean, localBoolean });
        }
        else
        {
          paramActivity.recreate();
        }
        return true;
      }
      finally
      {
        g.post(new b(localApplication, locald));
      }
      return false;
    }
    finally {}
  }
  
  class a
    implements Runnable
  {
    a(Object paramObject) {}
    
    public void run()
    {
      c.this.a = localObject1;
    }
  }
  
  class b
    implements Runnable
  {
    b(c.d paramd) {}
    
    public void run()
    {
      c.this.unregisterActivityLifecycleCallbacks(locald);
    }
  }
  
  class c
    implements Runnable
  {
    c(Object paramObject) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 31	androidx/core/app/c:d	Ljava/lang/reflect/Method;
      //   3: astore_1
      //   4: aload_1
      //   5: ifnull +35 -> 40
      //   8: aload_1
      //   9: aload_0
      //   10: getfield 18	androidx/core/app/c$c:a	Ljava/lang/Object;
      //   13: iconst_3
      //   14: anewarray 4	java/lang/Object
      //   17: dup
      //   18: iconst_0
      //   19: aload_0
      //   20: getfield 20	androidx/core/app/c$c:b	Ljava/lang/Object;
      //   23: aastore
      //   24: dup
      //   25: iconst_1
      //   26: getstatic 37	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   29: aastore
      //   30: dup
      //   31: iconst_2
      //   32: ldc 39
      //   34: aastore
      //   35: invokevirtual 45	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   38: pop
      //   39: return
      //   40: getstatic 48	androidx/core/app/c:e	Ljava/lang/reflect/Method;
      //   43: aload_0
      //   44: getfield 18	androidx/core/app/c$c:a	Ljava/lang/Object;
      //   47: iconst_2
      //   48: anewarray 4	java/lang/Object
      //   51: dup
      //   52: iconst_0
      //   53: aload_0
      //   54: getfield 20	androidx/core/app/c$c:b	Ljava/lang/Object;
      //   57: aastore
      //   58: dup
      //   59: iconst_1
      //   60: getstatic 37	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   63: aastore
      //   64: invokevirtual 45	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   67: pop
      //   68: return
      //   69: astore_1
      //   70: ldc 50
      //   72: ldc 52
      //   74: aload_1
      //   75: invokestatic 57	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   78: pop
      //   79: return
      //   80: astore_1
      //   81: aload_1
      //   82: invokevirtual 61	java/lang/Object:getClass	()Ljava/lang/Class;
      //   85: ldc 27
      //   87: if_acmpne +25 -> 112
      //   90: aload_1
      //   91: invokevirtual 65	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
      //   94: ifnull +18 -> 112
      //   97: aload_1
      //   98: invokevirtual 65	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
      //   101: ldc 67
      //   103: invokevirtual 73	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   106: ifne +4 -> 110
      //   109: return
      //   110: aload_1
      //   111: athrow
      //   112: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	113	0	this	c
      //   3	6	1	localMethod	Method
      //   69	6	1	localThrowable	java.lang.Throwable
      //   80	31	1	localRuntimeException	java.lang.RuntimeException
      // Exception table:
      //   from	to	target	type
      //   0	4	69	finally
      //   8	39	69	finally
      //   40	68	69	finally
      //   0	4	80	java/lang/RuntimeException
      //   8	39	80	java/lang/RuntimeException
      //   40	68	80	java/lang/RuntimeException
    }
  }
  
  private static final class d
    implements Application.ActivityLifecycleCallbacks
  {
    Object a;
    private Activity b;
    private final int c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    
    d(Activity paramActivity)
    {
      this.b = paramActivity;
      this.c = paramActivity.hashCode();
    }
    
    public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityDestroyed(Activity paramActivity)
    {
      if (this.b == paramActivity)
      {
        this.b = null;
        this.e = true;
      }
    }
    
    public void onActivityPaused(Activity paramActivity)
    {
      if ((this.e) && (!this.f) && (!this.d) && (c.h(this.a, this.c, paramActivity)))
      {
        this.f = true;
        this.a = null;
      }
    }
    
    public void onActivityResumed(Activity paramActivity) {}
    
    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public void onActivityStarted(Activity paramActivity)
    {
      if (this.b == paramActivity) {
        this.d = true;
      }
    }
    
    public void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.c
 * JD-Core Version:    0.7.0.1
 */