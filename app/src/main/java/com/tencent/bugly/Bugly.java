package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.y;
import java.util.Map;

public class Bugly
{
  public static final String SDK_IS_DEV = "false";
  private static boolean a = false;
  public static Context applicationContext;
  private static String[] b = { "BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule" };
  private static String[] c = { "BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule" };
  public static boolean enable = true;
  public static Boolean isDev;
  
  public static String getAppChannel()
  {
    try
    {
      Object localObject1 = a.b();
      if (localObject1 == null) {
        return null;
      }
      if (TextUtils.isEmpty(((a)localObject1).k))
      {
        Object localObject3 = o.a();
        if (localObject3 == null)
        {
          localObject1 = ((a)localObject1).k;
          return localObject1;
        }
        localObject3 = ((o)localObject3).a(556, null, true);
        if (localObject3 != null)
        {
          localObject3 = (byte[])((Map)localObject3).get("app_channel");
          if (localObject3 != null)
          {
            localObject1 = new String((byte[])localObject3);
            return localObject1;
          }
        }
      }
      localObject1 = ((a)localObject1).k;
      return localObject1;
    }
    finally {}
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean)
  {
    init(paramContext, paramString, paramBoolean, null);
  }
  
  public static void init(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = a;
        if (bool) {
          return;
        }
        a = true;
        paramContext = ab.a(paramContext);
        applicationContext = paramContext;
        if (paramContext == null)
        {
          Log.e(y.a, "init arg 'context' should not be null!");
          return;
        }
        if (isDev()) {
          b = c;
        }
        paramContext = b;
        int j = paramContext.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramContext[i];
          try
          {
            if (localObject.equals("BuglyCrashModule")) {
              b.a(CrashModule.getInstance());
            } else if ((!localObject.equals("BuglyBetaModule")) && (!localObject.equals("BuglyRqdModule"))) {
              localObject.equals("BuglyFeedbackModule");
            }
          }
          finally
          {
            y.b(localThrowable);
            break label169;
          }
        }
        else
        {
          b.a = enable;
          b.a(applicationContext, paramString, paramBoolean, paramBuglyStrategy);
          return;
        }
      }
      finally {}
      label169:
      i += 1;
    }
  }
  
  public static boolean isDev()
  {
    if (isDev == null) {
      isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
    }
    return isDev.booleanValue();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.Bugly
 * JD-Core Version:    0.7.0.1
 */