package i8;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class e
  implements j8.a
{
  private static final a b = new b();
  private static List<String> c;
  private l8.c a;
  
  public e(l8.c paramc)
  {
    this.a = paramc;
  }
  
  private void c(String... paramVarArgs)
  {
    if (c == null) {
      c = d(this.a.c());
    }
    if (paramVarArgs.length != 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if ((!c.contains(str)) && ((!"com.android.voicemail.permission.ADD_VOICEMAIL".equals(str)) || (!c.contains("android.permission.ADD_VOICEMAIL")))) {
          throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", new Object[] { str }));
        }
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("Please enter at least one permission.");
  }
  
  private static List<String> d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      if ((paramContext != null) && (paramContext.length != 0)) {
        return Collections.unmodifiableList(Arrays.asList(paramContext));
      }
      throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label45:
      break label45;
    }
    throw new AssertionError("Package name cannot be found.");
  }
  
  public d a(String... paramVarArgs)
  {
    c(paramVarArgs);
    return b.a(this.a).a(paramVarArgs);
  }
  
  public k8.c b()
  {
    return new k8.a(this.a);
  }
  
  public static abstract interface a
  {
    public abstract d a(l8.c paramc);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i8.e
 * JD-Core Version:    0.7.0.1
 */