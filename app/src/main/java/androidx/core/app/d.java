package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build.VERSION;

public final class d
{
  public static int a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      AppOpsManager localAppOpsManager = a.c(paramContext);
      int i = a.a(localAppOpsManager, paramString1, Binder.getCallingUid(), paramString2);
      if (i != 0) {
        return i;
      }
      return a.a(localAppOpsManager, paramString1, paramInt, a.b(paramContext));
    }
    return b(paramContext, paramString1, paramString2);
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    return ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, paramString2);
  }
  
  public static String c(String paramString)
  {
    return AppOpsManager.permissionToOp(paramString);
  }
  
  static class a
  {
    static int a(AppOpsManager paramAppOpsManager, String paramString1, int paramInt, String paramString2)
    {
      if (paramAppOpsManager == null) {
        return 1;
      }
      return paramAppOpsManager.checkOpNoThrow(paramString1, paramInt, paramString2);
    }
    
    static String b(Context paramContext)
    {
      return paramContext.getOpPackageName();
    }
    
    static AppOpsManager c(Context paramContext)
    {
      return (AppOpsManager)paramContext.getSystemService(AppOpsManager.class);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.d
 * JD-Core Version:    0.7.0.1
 */