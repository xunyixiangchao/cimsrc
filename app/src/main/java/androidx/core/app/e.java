package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;

public final class e
{
  public static Intent a(Activity paramActivity)
  {
    Object localObject = paramActivity.getParentActivityIntent();
    if (localObject != null) {
      return localObject;
    }
    localObject = c(paramActivity);
    if (localObject == null) {
      return null;
    }
    ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject);
    try
    {
      if (d(paramActivity, localComponentName) == null) {
        return Intent.makeMainActivity(localComponentName);
      }
      paramActivity = new Intent().setComponent(localComponentName);
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      label59:
      break label59;
    }
    paramActivity = new StringBuilder();
    paramActivity.append("getParentActivityIntent: bad parentActivityName '");
    paramActivity.append((String)localObject);
    paramActivity.append("' in manifest");
    Log.e("NavUtils", paramActivity.toString());
    return null;
  }
  
  public static Intent b(Context paramContext, ComponentName paramComponentName)
  {
    String str = d(paramContext, paramComponentName);
    if (str == null) {
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (d(paramContext, paramComponentName) == null) {
      return Intent.makeMainActivity(paramComponentName);
    }
    return new Intent().setComponent(paramComponentName);
  }
  
  public static String c(Activity paramActivity)
  {
    try
    {
      paramActivity = d(paramActivity, paramActivity.getComponentName());
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      throw new IllegalArgumentException(paramActivity);
    }
  }
  
  public static String d(Context paramContext, ComponentName paramComponentName)
  {
    Object localObject = paramContext.getPackageManager();
    int j = Build.VERSION.SDK_INT;
    int i = 640;
    if (j >= 29) {
      i = 269222528;
    } else if (j >= 24) {
      i = 787072;
    }
    paramComponentName = ((PackageManager)localObject).getActivityInfo(paramComponentName, i);
    localObject = paramComponentName.parentActivityName;
    if (localObject != null) {
      return localObject;
    }
    paramComponentName = paramComponentName.metaData;
    if (paramComponentName == null) {
      return null;
    }
    localObject = paramComponentName.getString("android.support.PARENT_ACTIVITY");
    if (localObject == null) {
      return null;
    }
    paramComponentName = (ComponentName)localObject;
    if (((String)localObject).charAt(0) == '.')
    {
      paramComponentName = new StringBuilder();
      paramComponentName.append(paramContext.getPackageName());
      paramComponentName.append((String)localObject);
      paramComponentName = paramComponentName.toString();
    }
    return paramComponentName;
  }
  
  public static void e(Activity paramActivity, Intent paramIntent)
  {
    paramActivity.navigateUpTo(paramIntent);
  }
  
  public static boolean f(Activity paramActivity, Intent paramIntent)
  {
    return paramActivity.shouldUpRecreateTask(paramIntent);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.e
 * JD-Core Version:    0.7.0.1
 */