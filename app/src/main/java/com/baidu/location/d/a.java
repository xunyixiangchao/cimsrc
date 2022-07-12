package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.g;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.b.p;
import com.baidu.location.b.r;
import com.baidu.location.b.s;
import com.baidu.location.c.d;
import com.baidu.location.c.i;
import com.baidu.location.f;
import java.lang.ref.WeakReference;

public class a
  extends Service
  implements LLSInterface
{
  static a a;
  public static long c;
  private static long g;
  Messenger b = null;
  private Looper d = null;
  private HandlerThread e = null;
  private boolean f = true;
  private int h = 0;
  private boolean i = true;
  
  private void a()
  {
    com.baidu.location.a.a.a().a(f.getServiceContext());
    com.baidu.location.e.b.a();
    try
    {
      s.a().e();
      label19:
      g.a().b();
      d.a().b();
      com.baidu.location.c.b.a().b();
      k.c().d();
      i.a().c();
      this.h = 2;
      return;
    }
    catch (Exception localException)
    {
      break label19;
    }
  }
  
  private void a(Message paramMessage)
  {
    com.baidu.location.b.b.a().a(paramMessage);
  }
  
  private void b()
  {
    d.a().e();
    i.a().d();
    s.a().f();
    com.baidu.location.c.b.a().c();
    k.c().e();
    g.a().c();
    if (this.i) {
      r.d();
    }
    com.baidu.location.b.b.a().b();
    try
    {
      p.a().d();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.h = 4;
    Log.d("baidu_location_service", "baidu location service has stoped ...");
    if (!this.f) {
      Process.killProcess(Process.myPid());
    }
  }
  
  private void b(Message paramMessage)
  {
    com.baidu.location.b.b.a().b(paramMessage);
  }
  
  private void c(Message paramMessage)
  {
    com.baidu.location.b.b.a().c(paramMessage);
  }
  
  public double getVersion()
  {
    return 9.303000450134277D;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      com.baidu.location.e.b.h = paramIntent.getString("key");
      com.baidu.location.e.b.g = paramIntent.getString("sign");
      this.f = paramIntent.getBoolean("kill_process");
      paramIntent.getBoolean("cache_exception");
    }
    return this.b.getBinder();
  }
  
  public void onCreate(Context paramContext)
  {
    LBSAuthManager.getInstance(f.getServiceContext()).setPrivacyMode(true);
    try
    {
      com.baidu.location.e.h.aw = paramContext.getPackageName();
      label17:
      g = System.currentTimeMillis();
      paramContext = o.a();
      this.e = paramContext;
      if (paramContext != null) {
        this.d = paramContext.getLooper();
      }
      if (this.d == null) {
        paramContext = new a(Looper.getMainLooper(), this);
      } else {
        paramContext = new a(this.d, this);
      }
      a = paramContext;
      c = System.currentTimeMillis();
      this.b = new Messenger(a);
      a.sendEmptyMessage(0);
      this.h = 1;
      paramContext = new StringBuilder();
      paramContext.append("baidu location service start 0210 version ...20220210_1153...");
      paramContext.append(Process.myPid());
      Log.d("baidu_location_service", paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      break label17;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      a.sendEmptyMessage(1);
    }
    catch (Exception localException)
    {
      label11:
      break label11;
    }
    Log.d("baidu_location_service", "baidu location service stop exception...");
    this.i = false;
    b();
    Process.killProcess(Process.myPid());
    this.h = 3;
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        a locala = (a)this.a.get();
        if ((locala != null) && (a.a(locala) == 3))
        {
          Log.d("baidu_location_service", "baidu location service force stopped ...");
          a.a(locala, false);
          a.b(locala);
        }
      }
    }, 1000L);
    Log.d("baidu_location_service", "baidu location service stop ...");
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    Log.d("baidu_location_service", "baidu location service remove task...");
  }
  
  public boolean onUnBind(Intent paramIntent)
  {
    return false;
  }
  
  public static class a
    extends Handler
  {
    private final WeakReference<a> a;
    
    public a(Looper paramLooper, a parama)
    {
      super();
      this.a = new WeakReference(parama);
    }
    
    public void handleMessage(Message paramMessage)
    {
      a locala = (a)this.a.get();
      if (locala == null) {
        return;
      }
      if (f.isServing == true)
      {
        int i = paramMessage.what;
        if (i != 11) {
          if (i != 12) {
            if (i != 15) {
              if (i != 22) {
                if (i != 41) {
                  if (i != 401)
                  {
                    if (i != 406)
                    {
                      if (i != 705) {
                        break label164;
                      }
                      boolean bool = paramMessage.getData().getBoolean("foreground");
                      com.baidu.location.b.b.a().a(bool);
                      break label164;
                    }
                    g.a().e();
                    break label164;
                  }
                }
              }
            }
          }
        }
      }
      try
      {
        paramMessage.getData();
      }
      catch (Exception localException)
      {
        break label164;
      }
      k.c().i();
      break label164;
      k.c().b(paramMessage);
      break label164;
      a.c(locala, paramMessage);
      break label164;
      a.b(locala, paramMessage);
      break label164;
      a.a(locala, paramMessage);
      label164:
      if (paramMessage.what == 1) {
        a.b(locala);
      }
      if (paramMessage.what == 0) {
        a.c(locala);
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.d.a
 * JD-Core Version:    0.7.0.1
 */