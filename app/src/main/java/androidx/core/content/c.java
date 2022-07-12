package androidx.core.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import androidx.core.app.d;

public final class c
{
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {
      return -1;
    }
    String str = d.c(paramString1);
    if (str == null) {
      return 0;
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if (paramString1 != null)
      {
        if (paramString1.length <= 0) {
          return -1;
        }
        paramString1 = paramString1[0];
      }
      else
      {
        return -1;
      }
    }
    paramInt1 = Process.myUid();
    paramString2 = paramContext.getPackageName();
    if ((paramInt1 == paramInt2) && (x0.c.a(paramString2, paramString1))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0) {
      paramInt1 = d.a(paramContext, paramInt2, str, paramString1);
    } else {
      paramInt1 = d.b(paramContext, str, paramString1);
    }
    if (paramInt1 == 0) {
      return 0;
    }
    return -2;
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.content.c
 * JD-Core Version:    0.7.0.1
 */