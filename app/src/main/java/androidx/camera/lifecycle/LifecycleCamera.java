package androidx.camera.lifecycle;

import android.os.Build.VERSION;
import androidx.camera.core.m;
import androidx.camera.core.r;
import androidx.camera.core.v2;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.l;
import androidx.lifecycle.t;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import s.w;
import v.e;

final class LifecycleCamera
  implements androidx.lifecycle.k, androidx.camera.core.k
{
  private final Object a = new Object();
  private final l b;
  private final e c;
  private volatile boolean d = false;
  private boolean e = false;
  private boolean f = false;
  
  LifecycleCamera(l paraml, e parame)
  {
    this.b = paraml;
    this.c = parame;
    if (paraml.getLifecycle().b().a(h.c.d)) {
      parame.k();
    } else {
      parame.v();
    }
    paraml.getLifecycle().a(this);
  }
  
  public m c()
  {
    return this.c.c();
  }
  
  public r e()
  {
    return this.c.e();
  }
  
  public void h(w paramw)
  {
    this.c.h(paramw);
  }
  
  void j(Collection<v2> paramCollection)
  {
    synchronized (this.a)
    {
      this.c.j(paramCollection);
      return;
    }
  }
  
  public e k()
  {
    return this.c;
  }
  
  public l o()
  {
    synchronized (this.a)
    {
      l locall = this.b;
      return locall;
    }
  }
  
  @t(h.b.ON_DESTROY)
  public void onDestroy(l arg1)
  {
    synchronized (this.a)
    {
      e locale = this.c;
      locale.H(locale.z());
      return;
    }
  }
  
  @t(h.b.ON_PAUSE)
  public void onPause(l paraml)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.c.a(false);
    }
  }
  
  @t(h.b.ON_RESUME)
  public void onResume(l paraml)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.c.a(true);
    }
  }
  
  @t(h.b.ON_START)
  public void onStart(l arg1)
  {
    synchronized (this.a)
    {
      if ((!this.e) && (!this.f))
      {
        this.c.k();
        this.d = true;
      }
      return;
    }
  }
  
  @t(h.b.ON_STOP)
  public void onStop(l arg1)
  {
    synchronized (this.a)
    {
      if ((!this.e) && (!this.f))
      {
        this.c.v();
        this.d = false;
      }
      return;
    }
  }
  
  public List<v2> p()
  {
    synchronized (this.a)
    {
      List localList = Collections.unmodifiableList(this.c.z());
      return localList;
    }
  }
  
  public boolean q(v2 paramv2)
  {
    synchronized (this.a)
    {
      boolean bool = this.c.z().contains(paramv2);
      return bool;
    }
  }
  
  public void r()
  {
    synchronized (this.a)
    {
      if (this.e) {
        return;
      }
      onStop(this.b);
      this.e = true;
      return;
    }
  }
  
  void s()
  {
    synchronized (this.a)
    {
      e locale = this.c;
      locale.H(locale.z());
      return;
    }
  }
  
  public void t()
  {
    synchronized (this.a)
    {
      if (!this.e) {
        return;
      }
      this.e = false;
      if (this.b.getLifecycle().b().a(h.c.d)) {
        onStart(this.b);
      }
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.lifecycle.LifecycleCamera
 * JD-Core Version:    0.7.0.1
 */