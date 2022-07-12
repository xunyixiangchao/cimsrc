package androidx.camera.core.impl.utils;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;

public final class d
{
  public static Context a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramContext = a.b(paramContext);
      if (paramContext != null) {
        return a.a(localContext, paramContext);
      }
    }
    return localContext;
  }
  
  public static Application b(Context paramContext)
  {
    for (paramContext = a(paramContext); (paramContext instanceof ContextWrapper); paramContext = c((ContextWrapper)paramContext)) {
      if ((paramContext instanceof Application)) {
        return (Application)paramContext;
      }
    }
    return null;
  }
  
  public static Context c(ContextWrapper paramContextWrapper)
  {
    Context localContext = paramContextWrapper.getBaseContext();
    if (Build.VERSION.SDK_INT >= 30)
    {
      paramContextWrapper = a.b(paramContextWrapper);
      if (paramContextWrapper != null) {
        return a.a(localContext, paramContextWrapper);
      }
    }
    return localContext;
  }
  
  private static class a
  {
    static Context a(Context paramContext, String paramString)
    {
      return paramContext.createAttributionContext(paramString);
    }
    
    static String b(Context paramContext)
    {
      return paramContext.getAttributionTag();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.impl.utils.d
 * JD-Core Version:    0.7.0.1
 */