package com.baidu.platform.comapi.map.e0.e;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.e0.a.a;
import com.baidu.platform.comapi.map.e0.a.d;
import com.baidu.platform.comapi.map.e0.d;

public class b
{
  public a.a a;
  public a.a b;
  public a.a c;
  public MotionEvent d;
  public d e = new d();
  private a f;
  private boolean g = false;
  
  public b(a parama)
  {
    this.f = parama;
  }
  
  private void a()
  {
    this.e.b();
    this.a = null;
    this.b = null;
    this.c = null;
    this.g = true;
    this.f.b(this);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.e.a(paramMotionEvent);
    Pair localPair = this.e.c();
    if ((paramMotionEvent.getPointerCount() == 2) && ((Math.abs(((a.d)localPair.first).a) > 0.0D) || (Math.abs(((a.d)localPair.first).b) > 0.0D) || (Math.abs(((a.d)localPair.second).a) > 0.0D) || (Math.abs(((a.d)localPair.second).b) > 0.0D)))
    {
      c(paramMotionEvent);
      this.f.c(this);
    }
  }
  
  private void b()
  {
    this.e.a();
    this.g = false;
    this.f.a(this);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    a.a locala = a.a.a(paramMotionEvent);
    paramMotionEvent = this.c;
    if (paramMotionEvent == null) {
      paramMotionEvent = locala;
    }
    this.b = paramMotionEvent;
    this.c = locala;
    if (this.a == null) {
      this.a = locala;
    }
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    this.d = paramMotionEvent;
    int i = paramMotionEvent.getAction();
    if (i != 2)
    {
      if (i != 5)
      {
        if (i != 6)
        {
          if (i == 261) {
            break label53;
          }
          if (i != 262) {
            return;
          }
        }
        if (!this.g) {
          return;
        }
        b();
        return;
      }
      label53:
      if (this.g) {
        return;
      }
    }
    else
    {
      if (this.g)
      {
        a(paramMotionEvent);
        return;
      }
      if (paramMotionEvent.getPointerCount() != 2) {
        return;
      }
    }
    a();
  }
  
  public static abstract interface a
  {
    public abstract boolean a(b paramb);
    
    public abstract boolean b(b paramb);
    
    public abstract boolean c(b paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.e.b
 * JD-Core Version:    0.7.0.1
 */