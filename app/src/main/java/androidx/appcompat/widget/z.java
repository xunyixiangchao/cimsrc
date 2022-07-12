package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R.attr;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.i;
import g.g;

public class z
{
  private final Context a;
  private final e b;
  private final View c;
  final i d;
  d e;
  c f;
  
  public z(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0);
  }
  
  public z(Context paramContext, View paramView, int paramInt)
  {
    this(paramContext, paramView, paramInt, R.attr.popupMenuStyle, 0);
  }
  
  public z(Context paramContext, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramContext;
    this.c = paramView;
    e locale = new e(paramContext);
    this.b = locale;
    locale.V(new a());
    paramContext = new i(paramContext, locale, paramView, false, paramInt2, paramInt3);
    this.d = paramContext;
    paramContext.h(paramInt1);
    paramContext.i(new b());
  }
  
  public Menu a()
  {
    return this.b;
  }
  
  public MenuInflater b()
  {
    return new g(this.a);
  }
  
  class a
    implements e.a
  {
    a() {}
    
    public boolean a(e parame, MenuItem paramMenuItem)
    {
      parame = z.this.e;
      if (parame != null) {
        return parame.onMenuItemClick(paramMenuItem);
      }
      return false;
    }
    
    public void b(e parame) {}
  }
  
  class b
    implements PopupWindow.OnDismissListener
  {
    b() {}
    
    public void onDismiss()
    {
      z localz = z.this;
      z.c localc = localz.f;
      if (localc != null) {
        localc.a(localz);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(z paramz);
  }
  
  public static abstract interface d
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.z
 * JD-Core Version:    0.7.0.1
 */