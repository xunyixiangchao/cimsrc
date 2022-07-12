package l8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.lang.reflect.Method;

public class b
  extends c
{
  private Context e;
  
  public b(Context paramContext)
  {
    this.e = paramContext;
  }
  
  public Context c()
  {
    return this.e;
  }
  
  public boolean g(String paramString)
  {
    PackageManager localPackageManager = this.e.getPackageManager();
    Object localObject = localPackageManager.getClass();
    try
    {
      localObject = ((Class)localObject).getMethod("shouldShowRequestPermissionRationale", new Class[] { String.class });
      if (!((Method)localObject).isAccessible()) {
        ((Method)localObject).setAccessible(true);
      }
      boolean bool = ((Boolean)((Method)localObject).invoke(localPackageManager, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public void i(Intent paramIntent)
  {
    paramIntent.addFlags(268435456);
    this.e.startActivity(paramIntent);
  }
  
  public void j(Intent paramIntent, int paramInt)
  {
    throw new UnsupportedOperationException("Unsupported operation.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l8.b
 * JD-Core Version:    0.7.0.1
 */