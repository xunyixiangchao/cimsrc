package androidx.core.app;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class k
{
  private static final Object c = new Object();
  private static Set<String> d = new HashSet();
  private static final Object e = new Object();
  private final Context a;
  private final NotificationManager b;
  
  private k(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  public static k e(Context paramContext)
  {
    return new k(paramContext);
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.b.areNotificationsEnabled();
    }
    AppOpsManager localAppOpsManager = (AppOpsManager)this.a.getSystemService("appops");
    Object localObject = this.a.getApplicationInfo();
    String str = this.a.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      Class localClass = Integer.TYPE;
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { localClass, localClass, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      return i == 0;
    }
    catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|InvocationTargetException|IllegalAccessException|RuntimeException localClassNotFoundException) {}
    return true;
  }
  
  public void b(int paramInt)
  {
    c(null, paramInt);
  }
  
  public void c(String paramString, int paramInt)
  {
    this.b.cancel(paramString, paramInt);
  }
  
  public void d()
  {
    this.b.cancelAll();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.k
 * JD-Core Version:    0.7.0.1
 */