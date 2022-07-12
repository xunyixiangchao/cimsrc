package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.Map;

public final class d
{
  private static d a;
  private com.tencent.bugly.crashreport.common.strategy.a b;
  private com.tencent.bugly.crashreport.common.info.a c;
  private b d;
  private Context e;
  
  private d(Context paramContext)
  {
    c localc = c.a();
    if (localc == null) {
      return;
    }
    this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.c = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.d = localc.p;
    this.e = paramContext;
    x.a().a(new a());
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {
      a = new d(paramContext);
    }
    return a;
  }
  
  public static void a(Thread paramThread, final int paramInt, final String paramString1, final String paramString2, final String paramString3, final Map<String, String> paramMap)
  {
    x.a().a(new b(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap));
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      d.a(d.this);
    }
  }
  
  static final class b
    implements Runnable
  {
    b(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map paramMap) {}
    
    public final void run()
    {
      try
      {
        if (d.a() == null)
        {
          y.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
          return;
        }
        d.a(d.a(), this.a, paramInt, paramString1, paramString2, paramString3, paramMap);
        return;
      }
      finally
      {
        if (!y.b(localThrowable)) {
          localThrowable.printStackTrace();
        }
        y.e("[ExtraCrashManager] Crash error %s %s %s", new Object[] { paramString1, paramString2, paramString3 });
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.d
 * JD-Core Version:    0.7.0.1
 */