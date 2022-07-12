package c8;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import com.yanzhenjie.permission.FileProvider;
import d8.i;
import d8.l;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final l a = new i();
  
  private static l8.c a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return new l8.a((Activity)paramContext);
    }
    if ((paramContext instanceof ContextWrapper)) {
      return a(((ContextWrapper)paramContext).getBaseContext());
    }
    return new l8.b(paramContext);
  }
  
  public static Uri b(Context paramContext, File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(".file.path.share");
      return FileProvider.g(paramContext, localStringBuilder.toString(), paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  public static boolean c(Activity paramActivity, List<String> paramList)
  {
    return f(new l8.a(paramActivity), paramList);
  }
  
  public static boolean d(Activity paramActivity, String... paramVarArgs)
  {
    return g(new l8.a(paramActivity), paramVarArgs);
  }
  
  public static boolean e(Context paramContext, List<String> paramList)
  {
    return f(a(paramContext), paramList);
  }
  
  private static boolean f(l8.c paramc, List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!paramc.g((String)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean g(l8.c paramc, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (!paramc.g(paramVarArgs[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean h(Activity paramActivity, String... paramVarArgs)
  {
    return a.a(paramActivity, paramVarArgs);
  }
  
  public static boolean i(Context paramContext, String... paramVarArgs)
  {
    return a.a(paramContext, paramVarArgs);
  }
  
  public static f8.a j(Activity paramActivity)
  {
    return new c(new l8.a(paramActivity));
  }
  
  public static f8.a k(Context paramContext)
  {
    return new c(a(paramContext));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c8.b
 * JD-Core Version:    0.7.0.1
 */