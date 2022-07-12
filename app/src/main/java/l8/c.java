package l8;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class c
{
  private int a;
  private String b;
  private PackageManager c;
  private AppOpsManager d;
  
  private AppOpsManager b()
  {
    if (this.d == null) {
      this.d = ((AppOpsManager)c().getSystemService("appops"));
    }
    return this.d;
  }
  
  private PackageManager d()
  {
    if (this.c == null) {
      this.c = c().getPackageManager();
    }
    return this.c;
  }
  
  private int f()
  {
    if (this.a < 14) {
      this.a = c().getApplicationInfo().targetSdkVersion;
    }
    return this.a;
  }
  
  private boolean h(String paramString)
  {
    int i = c().getApplicationInfo().uid;
    boolean bool = true;
    try
    {
      Object localObject = Integer.TYPE;
      localObject = AppOpsManager.class.getMethod("checkOpNoThrow", new Class[] { localObject, localObject, String.class });
      int j = ((Integer)AppOpsManager.class.getDeclaredField(paramString).get(Integer.class)).intValue();
      i = ((Integer)((Method)localObject).invoke(b(), new Object[] { Integer.valueOf(j), Integer.valueOf(i), e() })).intValue();
      if (i != 0)
      {
        if (i == 4) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    finally {}
    return true;
  }
  
  public final boolean a()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (f() < 26) {
        return h("OP_REQUEST_INSTALL_PACKAGES");
      }
      return d().canRequestPackageInstalls();
    }
    return true;
  }
  
  public abstract Context c();
  
  public String e()
  {
    if (this.b == null) {
      this.b = c().getApplicationContext().getPackageName();
    }
    return this.b;
  }
  
  public abstract boolean g(String paramString);
  
  public abstract void i(Intent paramIntent);
  
  public abstract void j(Intent paramIntent, int paramInt);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l8.c
 * JD-Core Version:    0.7.0.1
 */