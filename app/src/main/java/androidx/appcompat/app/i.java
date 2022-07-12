package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.j.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.e;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.s;
import androidx.core.view.x;
import java.util.ArrayList;
import x0.h;

class i
  extends ActionBar
{
  final s a;
  final Window.Callback b;
  final AppCompatDelegateImpl.g c;
  boolean d;
  private boolean e;
  private boolean f;
  private ArrayList<ActionBar.a> g = new ArrayList();
  private final Runnable h = new a();
  private final Toolbar.e i;
  
  i(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    b localb = new b();
    this.i = localb;
    h.g(paramToolbar);
    m0 localm0 = new m0(paramToolbar, false);
    this.a = localm0;
    this.b = ((Window.Callback)h.g(paramCallback));
    localm0.setWindowCallback(paramCallback);
    paramToolbar.setOnMenuItemClickListener(localb);
    localm0.setWindowTitle(paramCharSequence);
    this.c = new e();
  }
  
  private Menu z()
  {
    if (!this.e)
    {
      this.a.j(new c(), new d());
      this.e = true;
    }
    return this.a.q();
  }
  
  void A()
  {
    Menu localMenu = z();
    e locale;
    if ((localMenu instanceof e)) {
      locale = (e)localMenu;
    } else {
      locale = null;
    }
    if (locale != null) {
      locale.h0();
    }
    try
    {
      localMenu.clear();
      if ((!this.b.onCreatePanelMenu(0, localMenu)) || (!this.b.onPreparePanel(0, null, localMenu))) {
        localMenu.clear();
      }
      return;
    }
    finally
    {
      if (locale != null) {
        locale.g0();
      }
    }
  }
  
  public void B(int paramInt1, int paramInt2)
  {
    int j = this.a.p();
    this.a.o(paramInt1 & paramInt2 | paramInt2 & j);
  }
  
  public boolean g()
  {
    return this.a.f();
  }
  
  public boolean h()
  {
    if (this.a.n())
    {
      this.a.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean == this.f) {
      return;
    }
    this.f = paramBoolean;
    int k = this.g.size();
    int j = 0;
    while (j < k)
    {
      ((ActionBar.a)this.g.get(j)).a(paramBoolean);
      j += 1;
    }
  }
  
  public int j()
  {
    return this.a.p();
  }
  
  public Context k()
  {
    return this.a.c();
  }
  
  public void l()
  {
    this.a.setVisibility(8);
  }
  
  public boolean m()
  {
    this.a.l().removeCallbacks(this.h);
    x.i0(this.a.l(), this.h);
    return true;
  }
  
  public void n(Configuration paramConfiguration)
  {
    super.n(paramConfiguration);
  }
  
  void o()
  {
    this.a.l().removeCallbacks(this.h);
  }
  
  public boolean p(int paramInt, KeyEvent paramKeyEvent)
  {
    Menu localMenu = z();
    if (localMenu != null)
    {
      if (paramKeyEvent != null) {
        j = paramKeyEvent.getDeviceId();
      } else {
        j = -1;
      }
      int j = KeyCharacterMap.load(j).getKeyboardType();
      boolean bool = true;
      if (j == 1) {
        bool = false;
      }
      localMenu.setQwertyMode(bool);
      return localMenu.performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public boolean q(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      r();
    }
    return true;
  }
  
  public boolean r()
  {
    return this.a.g();
  }
  
  public void s(boolean paramBoolean) {}
  
  public void t(boolean paramBoolean)
  {
    int j;
    if (paramBoolean) {
      j = 4;
    } else {
      j = 0;
    }
    B(j, 4);
  }
  
  public void u(boolean paramBoolean)
  {
    int j;
    if (paramBoolean) {
      j = 8;
    } else {
      j = 0;
    }
    B(j, 8);
  }
  
  public void v(boolean paramBoolean) {}
  
  public void w(CharSequence paramCharSequence)
  {
    this.a.setWindowTitle(paramCharSequence);
  }
  
  public void x()
  {
    this.a.setVisibility(0);
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      i.this.A();
    }
  }
  
  class b
    implements Toolbar.e
  {
    b() {}
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return i.this.b.onMenuItemSelected(0, paramMenuItem);
    }
  }
  
  private final class c
    implements j.a
  {
    private boolean a;
    
    c() {}
    
    public void b(e parame, boolean paramBoolean)
    {
      if (this.a) {
        return;
      }
      this.a = true;
      i.this.a.i();
      i.this.b.onPanelClosed(108, parame);
      this.a = false;
    }
    
    public boolean c(e parame)
    {
      i.this.b.onMenuOpened(108, parame);
      return true;
    }
  }
  
  private final class d
    implements e.a
  {
    d() {}
    
    public boolean a(e parame, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public void b(e parame)
    {
      if (i.this.a.b())
      {
        i.this.b.onPanelClosed(108, parame);
        return;
      }
      if (i.this.b.onPreparePanel(0, null, parame)) {
        i.this.b.onMenuOpened(108, parame);
      }
    }
  }
  
  private class e
    implements AppCompatDelegateImpl.g
  {
    e() {}
    
    public boolean a(int paramInt)
    {
      if (paramInt == 0)
      {
        i locali = i.this;
        if (!locali.d)
        {
          locali.a.d();
          i.this.d = true;
        }
      }
      return false;
    }
    
    public View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(i.this.a.c());
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.i
 * JD-Core Version:    0.7.0.1
 */