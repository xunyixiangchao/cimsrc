package h8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import java.util.List;
import l8.c;

public class b
{
  private static final String b = Build.MANUFACTURER.toLowerCase();
  private c a;
  
  public b(c paramc)
  {
    this.a = paramc;
  }
  
  private static Intent a(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    return localIntent;
  }
  
  private static Intent b(Context paramContext)
  {
    Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
    localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    if (c(paramContext, localIntent)) {
      return localIntent;
    }
    return a(paramContext);
  }
  
  private static boolean c(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0;
  }
  
  private static Intent d(Context paramContext)
  {
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
    if (c(paramContext, localIntent)) {
      return localIntent;
    }
    return b(paramContext);
  }
  
  public void e(int paramInt)
  {
    if (b.contains("meizu")) {
      localIntent = d(this.a.c());
    } else {
      localIntent = b(this.a.c());
    }
    try
    {
      this.a.j(localIntent, paramInt);
      return;
    }
    catch (Exception localException)
    {
      label46:
      break label46;
    }
    Intent localIntent = a(this.a.c());
    this.a.j(localIntent, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h8.b
 * JD-Core Version:    0.7.0.1
 */