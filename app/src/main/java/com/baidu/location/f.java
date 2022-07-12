package com.baidu.location;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.location.d.a;

public class f
  extends Service
{
  public static boolean isServing = false;
  public static boolean isStartedServing = false;
  public static Context mC;
  public static String replaceFileName = "repll.jar";
  LLSInterface a = null;
  LLSInterface b = null;
  LLSInterface c = null;
  
  public static float getFrameVersion()
  {
    return 9.303001F;
  }
  
  public static String getJarFileName()
  {
    return "app.jar";
  }
  
  public static Context getServiceContext()
  {
    return mC;
  }
  
  public static void setServiceContext(Context paramContext)
  {
    mC = paramContext;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    LLSInterface localLLSInterface = this.c;
    if (localLLSInterface != null) {
      return localLLSInterface.onBind(paramIntent);
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate()
  {
    if (isServing)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baidu location service can not start again ...20190306...");
      ((StringBuilder)localObject).append(Process.myPid());
      Log.d("baidu_location_service", ((StringBuilder)localObject).toString());
      return;
    }
    mC = getApplicationContext();
    System.currentTimeMillis();
    this.b = new a();
    Object localObject = this.a;
    if ((localObject != null) && (((LLSInterface)localObject).getVersion() >= this.b.getVersion()))
    {
      this.c = this.a;
      this.b = null;
    }
    else
    {
      this.c = this.b;
      this.a = null;
    }
    isServing = true;
    this.c.onCreate(this);
  }
  
  public void onDestroy()
  {
    isServing = false;
    LLSInterface localLLSInterface = this.c;
    if (localLLSInterface != null) {
      localLLSInterface.onDestroy();
    }
    if (isStartedServing) {
      stopForeground(true);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      try
      {
        int i = paramIntent.getIntExtra("command", 0);
        if (i == 1)
        {
          startForeground(paramIntent.getIntExtra("id", 0), (Notification)paramIntent.getParcelableExtra("notification"));
          isStartedServing = true;
        }
        else if (i == 2)
        {
          stopForeground(paramIntent.getBooleanExtra("removenotify", true));
          isStartedServing = false;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    LLSInterface localLLSInterface = this.c;
    if (localLLSInterface == null) {
      return 2;
    }
    return localLLSInterface.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    LLSInterface localLLSInterface = this.c;
    if (localLLSInterface != null) {
      localLLSInterface.onTaskRemoved(paramIntent);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.f
 * JD-Core Version:    0.7.0.1
 */