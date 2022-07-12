package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.h.c;
import androidx.lifecycle.l;

public final class a
{
  private final b a;
  private final SavedStateRegistry b;
  
  private a(b paramb)
  {
    this.a = paramb;
    this.b = new SavedStateRegistry();
  }
  
  public static a a(b paramb)
  {
    return new a(paramb);
  }
  
  public SavedStateRegistry b()
  {
    return this.b;
  }
  
  public void c(Bundle paramBundle)
  {
    h localh = this.a.getLifecycle();
    if (localh.b() == h.c.b)
    {
      localh.a(new Recreator(this.a));
      this.b.b(localh, paramBundle);
      return;
    }
    throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
  }
  
  public void d(Bundle paramBundle)
  {
    this.b.c(paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.savedstate.a
 * JD-Core Version:    0.7.0.1
 */