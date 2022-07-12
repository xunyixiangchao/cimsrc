package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import g0.g;
import h.c;
import h.d;
import java.util.ArrayList;
import s0.a;

public class f
  extends ActionMode
{
  final Context a;
  final b b;
  
  public f(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
  }
  
  public void finish()
  {
    this.b.c();
  }
  
  public View getCustomView()
  {
    return this.b.d();
  }
  
  public Menu getMenu()
  {
    return new d(this.a, (a)this.b.e());
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.b.f();
  }
  
  public CharSequence getSubtitle()
  {
    return this.b.g();
  }
  
  public Object getTag()
  {
    return this.b.h();
  }
  
  public CharSequence getTitle()
  {
    return this.b.i();
  }
  
  public boolean getTitleOptionalHint()
  {
    return this.b.j();
  }
  
  public void invalidate()
  {
    this.b.k();
  }
  
  public boolean isTitleOptional()
  {
    return this.b.l();
  }
  
  public void setCustomView(View paramView)
  {
    this.b.m(paramView);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.b.n(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.b.o(paramCharSequence);
  }
  
  public void setTag(Object paramObject)
  {
    this.b.p(paramObject);
  }
  
  public void setTitle(int paramInt)
  {
    this.b.q(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b.r(paramCharSequence);
  }
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.b.s(paramBoolean);
  }
  
  public static class a
    implements b.a
  {
    final ActionMode.Callback a;
    final Context b;
    final ArrayList<f> c;
    final g<Menu, Menu> d;
    
    public a(Context paramContext, ActionMode.Callback paramCallback)
    {
      this.b = paramContext;
      this.a = paramCallback;
      this.c = new ArrayList();
      this.d = new g();
    }
    
    private Menu f(Menu paramMenu)
    {
      Menu localMenu = (Menu)this.d.get(paramMenu);
      Object localObject = localMenu;
      if (localMenu == null)
      {
        localObject = new d(this.b, (a)paramMenu);
        this.d.put(paramMenu, localObject);
      }
      return localObject;
    }
    
    public boolean a(b paramb, Menu paramMenu)
    {
      return this.a.onPrepareActionMode(e(paramb), f(paramMenu));
    }
    
    public boolean b(b paramb, Menu paramMenu)
    {
      return this.a.onCreateActionMode(e(paramb), f(paramMenu));
    }
    
    public boolean c(b paramb, MenuItem paramMenuItem)
    {
      return this.a.onActionItemClicked(e(paramb), new c(this.b, (s0.b)paramMenuItem));
    }
    
    public void d(b paramb)
    {
      this.a.onDestroyActionMode(e(paramb));
    }
    
    public ActionMode e(b paramb)
    {
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        f localf = (f)this.c.get(i);
        if ((localf != null) && (localf.b == paramb)) {
          return localf;
        }
        i += 1;
      }
      paramb = new f(this.b, paramb);
      this.c.add(paramb);
      return paramb;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.f
 * JD-Core Version:    0.7.0.1
 */