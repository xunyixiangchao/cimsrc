package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import java.io.File;
import java.util.concurrent.Executor;
import p0.h;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class b
{
  private static final Object a = new Object();
  private static final Object b = new Object();
  
  public static int a(Context paramContext, String paramString)
  {
    x0.c.c(paramString, "permission must be non-null");
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    return d.a(paramContext, paramInt);
  }
  
  public static ColorStateList c(Context paramContext, int paramInt)
  {
    return h.d(paramContext.getResources(), paramInt, paramContext.getTheme());
  }
  
  public static Drawable d(Context paramContext, int paramInt)
  {
    return c.b(paramContext, paramInt);
  }
  
  public static File[] e(Context paramContext)
  {
    return b.a(paramContext);
  }
  
  public static File[] f(Context paramContext, String paramString)
  {
    return b.b(paramContext, paramString);
  }
  
  public static Executor g(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return e.a(paramContext);
    }
    return u0.c.a(new Handler(paramContext.getMainLooper()));
  }
  
  public static <T> T h(Context paramContext, Class<T> paramClass)
  {
    return d.b(paramContext, paramClass);
  }
  
  public static boolean i(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(paramContext, paramArrayOfIntent, paramBundle);
    return true;
  }
  
  public static void j(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    a.b(paramContext, paramIntent, paramBundle);
  }
  
  static class a
  {
    static void a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
    {
      paramContext.startActivities(paramArrayOfIntent, paramBundle);
    }
    
    static void b(Context paramContext, Intent paramIntent, Bundle paramBundle)
    {
      paramContext.startActivity(paramIntent, paramBundle);
    }
  }
  
  static class b
  {
    static File[] a(Context paramContext)
    {
      return paramContext.getExternalCacheDirs();
    }
    
    static File[] b(Context paramContext, String paramString)
    {
      return paramContext.getExternalFilesDirs(paramString);
    }
    
    static File[] c(Context paramContext)
    {
      return paramContext.getObbDirs();
    }
  }
  
  static class c
  {
    static File a(Context paramContext)
    {
      return paramContext.getCodeCacheDir();
    }
    
    static Drawable b(Context paramContext, int paramInt)
    {
      return paramContext.getDrawable(paramInt);
    }
    
    static File c(Context paramContext)
    {
      return paramContext.getNoBackupFilesDir();
    }
  }
  
  static class d
  {
    static int a(Context paramContext, int paramInt)
    {
      return paramContext.getColor(paramInt);
    }
    
    static <T> T b(Context paramContext, Class<T> paramClass)
    {
      return paramContext.getSystemService(paramClass);
    }
    
    static String c(Context paramContext, Class<?> paramClass)
    {
      return paramContext.getSystemServiceName(paramClass);
    }
  }
  
  static class e
  {
    static Executor a(Context paramContext)
    {
      return paramContext.getMainExecutor();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.content.b
 * JD-Core Version:    0.7.0.1
 */