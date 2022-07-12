package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

class m
  extends Thread
{
  Handler a = null;
  private Object b = new Object();
  private boolean c = false;
  
  m() {}
  
  m(String paramString)
  {
    super(paramString);
  }
  
  public void a()
  {
    if (a.a) {
      a.a("Looper thread quit()");
    }
    this.a.getLooper().quit();
  }
  
  public void b()
  {
    try
    {
      synchronized (this.b)
      {
        if (!this.c) {
          this.b.wait();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      return;
    }
  }
  
  public void c()
  {
    synchronized (this.b)
    {
      this.c = true;
      this.b.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.a = new Handler();
    if (a.a) {
      a.a("new Handler() finish!!");
    }
    Looper.loop();
    if (a.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("LooperThread run() thread id:");
      localStringBuilder.append(String.valueOf(Thread.currentThread().getId()));
      a.a(localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.lbsapi.auth.m
 * JD-Core Version:    0.7.0.1
 */