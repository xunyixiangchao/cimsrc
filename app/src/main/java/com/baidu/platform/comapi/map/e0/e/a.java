package com.baidu.platform.comapi.map.e0.e;

import android.view.MotionEvent;

public class a
{
  private long a = 0L;
  private boolean b = false;
  private com.baidu.platform.comapi.map.e0.a.a c;
  private a d;
  
  public a(a parama)
  {
    this.d = parama;
  }
  
  private void a()
  {
    this.b = false;
    this.c = null;
    this.a = 0L;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2)
    {
      if (this.c == null) {
        return;
      }
      com.baidu.platform.comapi.map.e0.a.a locala1 = com.baidu.platform.comapi.map.e0.a.a.a(paramMotionEvent);
      com.baidu.platform.comapi.map.e0.a.a locala2 = this.c;
      paramMotionEvent = new com.baidu.platform.comapi.map.e0.a.a(locala2.a, locala1.a);
      locala1 = new com.baidu.platform.comapi.map.e0.a.a(locala2.b, locala1.b);
      double d1 = Math.abs(paramMotionEvent.b());
      int j = 1;
      int i;
      if ((d1 < 20.0D) && (Math.abs(locala1.b()) < 20.0D)) {
        i = 1;
      } else {
        i = 0;
      }
      if (System.currentTimeMillis() - this.a >= 200L) {
        j = 0;
      }
      if ((i != 0) && (j != 0) && (this.b)) {
        this.d.a(this);
      }
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() != 2) {
      return;
    }
    this.c = com.baidu.platform.comapi.map.e0.a.a.a(paramMotionEvent);
    this.b = true;
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 5)
      {
        if (i != 6)
        {
          if (i == 261) {
            break label45;
          }
          if (i != 262) {
            return;
          }
        }
        a(paramMotionEvent);
        a();
        return;
      }
      label45:
      c(paramMotionEvent);
      return;
    }
    this.a = System.currentTimeMillis();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(a parama);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.e.a
 * JD-Core Version:    0.7.0.1
 */