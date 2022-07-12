package h8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import java.util.List;
import l8.c;

public class a
{
  private static final String b = Build.MANUFACTURER.toLowerCase();
  private c a;
  
  public a(c paramc)
  {
    this.a = paramc;
  }
  
  private static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    return localIntent;
  }
  
  private static boolean b(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  private Intent c(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  private Intent d(Context paramContext)
  {
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  private Intent e(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  private Intent g(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
    localIntent.putExtra("packagename", paramContext.getPackageName());
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  private Intent h(Context paramContext)
  {
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    if (b(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  public void f(int paramInt)
  {
    Object localObject = b;
    if (((String)localObject).contains("huawei")) {
      localObject = c(this.a.c());
    } else if (((String)localObject).contains("xiaomi")) {
      localObject = h(this.a.c());
    } else if (((String)localObject).contains("oppo")) {
      localObject = e(this.a.c());
    } else if (((String)localObject).contains("vivo")) {
      localObject = g(this.a.c());
    } else if (((String)localObject).contains("meizu")) {
      localObject = d(this.a.c());
    } else {
      localObject = a(this.a.c());
    }
    try
    {
      this.a.j((Intent)localObject, paramInt);
      return;
    }
    catch (Exception localException)
    {
      label145:
      break label145;
    }
    localObject = a(this.a.c());
    this.a.j((Intent)localObject, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h8.a
 * JD-Core Version:    0.7.0.1
 */