package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.location.c.a;
import com.baidu.location.c.i;
import com.baidu.location.e.h;

public class s
{
  private static Object a = new Object();
  private static s b;
  private HandlerThread c;
  private Handler d;
  private boolean e = false;
  
  public static s a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new s();
      }
      s locals = b;
      return locals;
    }
  }
  
  @TargetApi(24)
  public void a(GnssNavigationMessage paramGnssNavigationMessage, long paramLong)
  {
    if (this.e)
    {
      if (paramGnssNavigationMessage == null) {
        return;
      }
      try
      {
        Object localObject = this.d;
        if (localObject != null)
        {
          localObject = ((Handler)localObject).obtainMessage(11);
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("gnss_navigation_message", paramGnssNavigationMessage);
          localBundle.putLong("gps_time", paramLong);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).sendToTarget();
          return;
        }
      }
      catch (Exception paramGnssNavigationMessage)
      {
        paramGnssNavigationMessage.printStackTrace();
      }
    }
  }
  
  public void a(Location paramLocation, int paramInt)
  {
    if (this.e)
    {
      if (paramLocation == null) {
        return;
      }
      try
      {
        Object localObject = this.d;
        if (localObject != null)
        {
          localObject = ((Handler)localObject).obtainMessage(1);
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("loc", new Location(paramLocation));
          localBundle.putInt("satnum", paramInt);
          ((Message)localObject).setData(localBundle);
          ((Message)localObject).sendToTarget();
          return;
        }
      }
      catch (Exception paramLocation)
      {
        paramLocation.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if (!this.e) {
      return;
    }
    try
    {
      Handler localHandler = this.d;
      if (localHandler != null)
      {
        localHandler.obtainMessage(3).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    if (!this.e) {
      return;
    }
    try
    {
      Handler localHandler = this.d;
      if (localHandler != null)
      {
        localHandler.obtainMessage(2).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    if (!this.e) {
      return;
    }
    try
    {
      Handler localHandler = this.d;
      if (localHandler != null)
      {
        localHandler.obtainMessage(7).sendToTarget();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    Object localObject;
    if (this.c == null)
    {
      localObject = new HandlerThread("LocUploadThreadManager");
      this.c = ((HandlerThread)localObject);
      ((HandlerThread)localObject).start();
      if (this.c != null) {
        this.d = new Handler(this.c.getLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            int i = paramAnonymousMessage.what;
            if (i != 1) {
              if (i != 2) {
                if (i != 3) {
                  if (i != 4) {
                    if (i != 7) {
                      if ((i != 8) && (i != 9))
                      {
                        if (i != 11) {
                          return;
                        }
                        paramAnonymousMessage = paramAnonymousMessage.getData();
                      }
                    }
                  }
                }
              }
            }
            try
            {
              localObject = (GnssNavigationMessage)paramAnonymousMessage.getParcelable("gnss_navigation_message");
              long l = paramAnonymousMessage.getLong("gps_time");
              q.a().a((GnssNavigationMessage)localObject, l);
              return;
            }
            catch (Exception paramAnonymousMessage) {}
            paramAnonymousMessage.getData();
            return;
            r.a().c();
            return;
            boolean bool = i.a().i();
            if (h.b()) {
              bool = false;
            }
            if (bool) {
              g.a().d();
            }
            try
            {
              if (s.a(s.this) != null) {
                s.a(s.this).sendEmptyMessageDelayed(4, h.Q);
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              paramAnonymousMessage.printStackTrace();
            }
            q.a().b();
            return;
            a locala = n.c();
            paramAnonymousMessage = null;
            Object localObject = n.d();
            String str = b.a().c();
            break label211;
            locala = n.c();
            paramAnonymousMessage = i.a().n();
            localObject = n.d();
            str = n.a();
            label211:
            r.a(locala, paramAnonymousMessage, (Location)localObject, str);
            return;
            paramAnonymousMessage = paramAnonymousMessage.getData();
            try
            {
              localObject = (Location)paramAnonymousMessage.getParcelable("loc");
              paramAnonymousMessage.getInt("satnum");
              if (localObject != null)
              {
                e.a().a((Location)localObject);
                return;
              }
            }
            catch (Exception paramAnonymousMessage)
            {
              paramAnonymousMessage.printStackTrace();
            }
            return;
          }
        };
      }
    }
    try
    {
      localObject = this.d;
      if (localObject != null) {
        ((Handler)localObject).obtainMessage(5).sendToTarget();
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      Handler localHandler = this.d;
      if (localHandler != null)
      {
        localHandler.sendEmptyMessageDelayed(4, h.Q);
        return;
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public void f()
  {
    if (!this.e) {
      return;
    }
    e.a().b();
    try
    {
      Handler localHandler = this.d;
      if (localHandler != null) {
        localHandler.removeCallbacksAndMessages(null);
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    this.d = null;
    try
    {
      HandlerThread localHandlerThread = this.c;
      if (localHandlerThread != null)
      {
        localHandlerThread.quit();
        this.c.interrupt();
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    this.c = null;
    this.e = false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.s
 * JD-Core Version:    0.7.0.1
 */