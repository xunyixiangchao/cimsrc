package androidx.camera.core;

import android.view.Surface;
import java.util.concurrent.Executor;
import s.l1;
import s.l1.a;

public class i2
  implements l1
{
  private final Object a = new Object();
  private int b = 0;
  private boolean c = false;
  private final l1 d;
  private final Surface e;
  private final j0.a f = new g2(this);
  
  public i2(l1 paraml1)
  {
    this.d = paraml1;
    this.e = paraml1.getSurface();
  }
  
  private e1 l(e1 parame1)
  {
    if (parame1 != null)
    {
      this.b += 1;
      parame1 = new l2(parame1);
      parame1.a(this.f);
      return parame1;
    }
    return null;
  }
  
  public e1 b()
  {
    synchronized (this.a)
    {
      e1 locale1 = l(this.d.b());
      return locale1;
    }
  }
  
  public int c()
  {
    synchronized (this.a)
    {
      int i = this.d.c();
      return i;
    }
  }
  
  public void close()
  {
    synchronized (this.a)
    {
      Surface localSurface = this.e;
      if (localSurface != null) {
        localSurface.release();
      }
      this.d.close();
      return;
    }
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      this.d.d();
      return;
    }
  }
  
  public void e(l1.a parama, Executor paramExecutor)
  {
    synchronized (this.a)
    {
      this.d.e(new h2(this, parama), paramExecutor);
      return;
    }
  }
  
  public int f()
  {
    synchronized (this.a)
    {
      int i = this.d.f();
      return i;
    }
  }
  
  public e1 g()
  {
    synchronized (this.a)
    {
      e1 locale1 = l(this.d.g());
      return locale1;
    }
  }
  
  public int getHeight()
  {
    synchronized (this.a)
    {
      int i = this.d.getHeight();
      return i;
    }
  }
  
  public Surface getSurface()
  {
    synchronized (this.a)
    {
      Surface localSurface = this.d.getSurface();
      return localSurface;
    }
  }
  
  public int getWidth()
  {
    synchronized (this.a)
    {
      int i = this.d.getWidth();
      return i;
    }
  }
  
  public void k()
  {
    synchronized (this.a)
    {
      this.c = true;
      this.d.d();
      if (this.b == 0) {
        close();
      }
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.i2
 * JD-Core Version:    0.7.0.1
 */