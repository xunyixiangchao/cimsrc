package h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import g0.g;

abstract class b
{
  final Context a;
  private g<s0.b, MenuItem> b;
  private g<s0.c, SubMenu> c;
  
  b(Context paramContext)
  {
    this.a = paramContext;
  }
  
  final MenuItem c(MenuItem paramMenuItem)
  {
    Object localObject = paramMenuItem;
    if ((paramMenuItem instanceof s0.b))
    {
      s0.b localb = (s0.b)paramMenuItem;
      if (this.b == null) {
        this.b = new g();
      }
      paramMenuItem = (MenuItem)this.b.get(paramMenuItem);
      localObject = paramMenuItem;
      if (paramMenuItem == null)
      {
        localObject = new c(this.a, localb);
        this.b.put(localb, localObject);
      }
    }
    return localObject;
  }
  
  final SubMenu d(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof s0.c))
    {
      s0.c localc = (s0.c)paramSubMenu;
      if (this.c == null) {
        this.c = new g();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new f(this.a, localc);
        this.c.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final void e()
  {
    g localg = this.b;
    if (localg != null) {
      localg.clear();
    }
    localg = this.c;
    if (localg != null) {
      localg.clear();
    }
  }
  
  final void f(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    int j;
    for (int i = 0; i < this.b.size(); i = j + 1)
    {
      j = i;
      if (((s0.b)this.b.i(i)).getGroupId() == paramInt)
      {
        this.b.k(i);
        j = i - 1;
      }
    }
  }
  
  final void g(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    int i = 0;
    while (i < this.b.size())
    {
      if (((s0.b)this.b.i(i)).getItemId() == paramInt)
      {
        this.b.k(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h.b
 * JD-Core Version:    0.7.0.1
 */