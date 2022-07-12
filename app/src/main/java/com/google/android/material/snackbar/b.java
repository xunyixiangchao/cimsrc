package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class b
{
  private static b e;
  private final Object a = new Object();
  private final Handler b = new Handler(Looper.getMainLooper(), new a());
  private c c;
  private c d;
  
  private boolean a(c paramc, int paramInt)
  {
    b localb = (b)paramc.a.get();
    if (localb != null)
    {
      this.b.removeCallbacksAndMessages(paramc);
      localb.b(paramInt);
      return true;
    }
    return false;
  }
  
  static b c()
  {
    if (e == null) {
      e = new b();
    }
    return e;
  }
  
  private boolean f(b paramb)
  {
    c localc = this.c;
    return (localc != null) && (localc.a(paramb));
  }
  
  private boolean g(b paramb)
  {
    c localc = this.d;
    return (localc != null) && (localc.a(paramb));
  }
  
  private void l(c paramc)
  {
    int i = paramc.b;
    if (i == -2) {
      return;
    }
    if (i <= 0) {
      if (i == -1) {
        i = 1500;
      } else {
        i = 2750;
      }
    }
    this.b.removeCallbacksAndMessages(paramc);
    Handler localHandler = this.b;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramc), i);
  }
  
  private void n()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      this.c = ((c)localObject);
      this.d = null;
      localObject = (b)((c)localObject).a.get();
      if (localObject != null)
      {
        ((b)localObject).a();
        return;
      }
      this.c = null;
    }
  }
  
  public void b(b paramb, int paramInt)
  {
    synchronized (this.a)
    {
      if (f(paramb)) {}
      for (paramb = this.c;; paramb = this.d)
      {
        a(paramb, paramInt);
        break;
        if (!g(paramb)) {
          break;
        }
      }
      return;
    }
  }
  
  void d(c paramc)
  {
    synchronized (this.a)
    {
      if ((this.c == paramc) || (this.d == paramc)) {
        a(paramc, 2);
      }
      return;
    }
  }
  
  public boolean e(b paramb)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (f(paramb)) {
          break label40;
        }
        if (g(paramb))
        {
          break label40;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
  
  public void h(b paramb)
  {
    synchronized (this.a)
    {
      if (f(paramb))
      {
        this.c = null;
        if (this.d != null) {
          n();
        }
      }
      return;
    }
  }
  
  public void i(b paramb)
  {
    synchronized (this.a)
    {
      if (f(paramb)) {
        l(this.c);
      }
      return;
    }
  }
  
  public void j(b paramb)
  {
    synchronized (this.a)
    {
      if (f(paramb))
      {
        paramb = this.c;
        if (!paramb.c)
        {
          paramb.c = true;
          this.b.removeCallbacksAndMessages(paramb);
        }
      }
      return;
    }
  }
  
  public void k(b paramb)
  {
    synchronized (this.a)
    {
      if (f(paramb))
      {
        paramb = this.c;
        if (paramb.c)
        {
          paramb.c = false;
          l(paramb);
        }
      }
      return;
    }
  }
  
  public void m(int paramInt, b paramb)
  {
    synchronized (this.a)
    {
      if (f(paramb))
      {
        paramb = this.c;
        paramb.b = paramInt;
        this.b.removeCallbacksAndMessages(paramb);
        l(this.c);
        return;
      }
      if (g(paramb)) {
        this.d.b = paramInt;
      } else {
        this.d = new c(paramInt, paramb);
      }
      paramb = this.c;
      if ((paramb != null) && (a(paramb, 4))) {
        return;
      }
      this.c = null;
      n();
      return;
    }
  }
  
  class a
    implements Handler.Callback
  {
    a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 0) {
        return false;
      }
      b.this.d((b.c)paramMessage.obj);
      return true;
    }
  }
  
  static abstract interface b
  {
    public abstract void a();
    
    public abstract void b(int paramInt);
  }
  
  private static class c
  {
    final WeakReference<b.b> a;
    int b;
    boolean c;
    
    c(int paramInt, b.b paramb)
    {
      this.a = new WeakReference(paramb);
      this.b = paramInt;
    }
    
    boolean a(b.b paramb)
    {
      return (paramb != null) && (this.a.get() == paramb);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.snackbar.b
 * JD-Core Version:    0.7.0.1
 */