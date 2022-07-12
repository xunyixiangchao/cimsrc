package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b
{
  private final Context a;
  private a b;
  private b c;
  
  public b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Context a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public abstract View d();
  
  public View e(MenuItem paramMenuItem)
  {
    return d();
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void g(SubMenu paramSubMenu) {}
  
  public boolean h()
  {
    return false;
  }
  
  public void i()
  {
    this.c = null;
    this.b = null;
  }
  
  public void j(a parama)
  {
    this.b = parama;
  }
  
  public void k(b paramb)
  {
    if ((this.c != null) && (paramb != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" instance while it is still in use somewhere else?");
      Log.w("ActionProvider(support)", localStringBuilder.toString());
    }
    this.c = paramb;
  }
  
  public void l(boolean paramBoolean)
  {
    a locala = this.b;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void onActionProviderVisibilityChanged(boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.b
 * JD-Core Version:    0.7.0.1
 */