package com.baidu.mapsdkplatform.comapi.commonutils;

import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comapi.util.h;
import com.baidu.platform.comjni.engine.NAEngine;
import java.util.concurrent.ExecutorService;

public class b
{
  private static boolean a = true;
  private static boolean b = false;
  
  public static b a()
  {
    return d.a();
  }
  
  private void a(final c paramc, final String paramString1, final String paramString2)
  {
    if (!a) {
      return;
    }
    h.b().submit(new a(paramc, paramString1, paramString2));
  }
  
  private void d()
  {
    NAEngine.a(new String[] { e.a.name(), e.c.name() });
  }
  
  public void a(String paramString)
  {
    a(c.g, e.a.name(), paramString);
  }
  
  public void b()
  {
    boolean bool = OpenLogUtil.isMapLogEnable();
    a = bool;
    if (bool)
    {
      if (b) {
        return;
      }
      String str2 = OpenLogUtil.getMapLogFilePath();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = SysOSUtil.getInstance().getExternalFilesDir();
      }
      NAEngine.a(false);
      NAEngine.a(str1);
      NAEngine.b(b.c.a());
      NAEngine.a(c.f.ordinal());
      d();
      NAEngine.a(true);
      b = true;
    }
  }
  
  public void c()
  {
    if (a)
    {
      if (!b) {
        return;
      }
      b = false;
      a = false;
      NAEngine.a(false);
    }
  }
  
  class a
    implements Runnable
  {
    a(b.c paramc, String paramString1, String paramString2) {}
    
    public void run()
    {
      NAEngine.a(paramc.ordinal(), paramString1, paramString2);
    }
  }
  
  private static enum b
  {
    private int a;
    
    static
    {
      b localb1 = new b("eMonitorConsole", 0, 1);
      b = localb1;
      b localb2 = new b("eMonitorNative", 1, 2);
      c = localb2;
      b localb3 = new b("eMonitorNet", 2, 4);
      d = localb3;
      e = new b[] { localb1, localb2, localb3 };
    }
    
    private b(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int a()
    {
      return this.a;
    }
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("eNone", 0);
      a = localc1;
      c localc2 = new c("eMonitorVerbose", 1);
      b = localc2;
      c localc3 = new c("eMonitorDebug", 2);
      c = localc3;
      c localc4 = new c("eMonitorInfo", 3);
      d = localc4;
      c localc5 = new c("eMonitorWarn", 4);
      e = localc5;
      c localc6 = new c("eMonitorError", 5);
      f = localc6;
      c localc7 = new c("eMonitorRealTime", 6);
      g = localc7;
      h = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7 };
    }
    
    private c() {}
  }
  
  private static class d
  {
    private static final b a = new b(null);
  }
  
  public static enum e
  {
    static
    {
      e locale1 = new e("SDK_MAP", 0);
      a = locale1;
      e locale2 = new e("Net", 1);
      b = locale2;
      e locale3 = new e("Engine", 2);
      c = locale3;
      d = new e[] { locale1, locale2, locale3 };
    }
    
    private e() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.commonutils.b
 * JD-Core Version:    0.7.0.1
 */