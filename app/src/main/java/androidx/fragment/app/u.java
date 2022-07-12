package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.a0;
import androidx.lifecycle.h;
import androidx.lifecycle.h.b;
import androidx.lifecycle.h.c;
import androidx.lifecycle.m;
import androidx.lifecycle.z;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.a;
import androidx.savedstate.b;

class u
  implements b, a0
{
  private final Fragment a;
  private final z b;
  private m c = null;
  private a d = null;
  
  u(Fragment paramFragment, z paramz)
  {
    this.a = paramFragment;
    this.b = paramz;
  }
  
  void a(h.b paramb)
  {
    this.c.h(paramb);
  }
  
  void b()
  {
    if (this.c == null)
    {
      this.c = new m(this);
      this.d = a.a(this);
    }
  }
  
  boolean c()
  {
    return this.c != null;
  }
  
  void d(Bundle paramBundle)
  {
    this.d.c(paramBundle);
  }
  
  void e(Bundle paramBundle)
  {
    this.d.d(paramBundle);
  }
  
  void f(h.c paramc)
  {
    this.c.o(paramc);
  }
  
  public h getLifecycle()
  {
    b();
    return this.c;
  }
  
  public SavedStateRegistry getSavedStateRegistry()
  {
    b();
    return this.d.b();
  }
  
  public z getViewModelStore()
  {
    b();
    return this.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.u
 * JD-Core Version:    0.7.0.1
 */