package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class m
  extends e
  implements SubMenu
{
  private e B;
  private g C;
  
  public m(Context paramContext, e parame, g paramg)
  {
    super(paramContext);
    this.B = parame;
    this.C = paramg;
  }
  
  public e F()
  {
    return this.B.F();
  }
  
  public boolean H()
  {
    return this.B.H();
  }
  
  public boolean I()
  {
    return this.B.I();
  }
  
  public boolean J()
  {
    return this.B.J();
  }
  
  public void V(e.a parama)
  {
    this.B.V(parama);
  }
  
  public boolean f(g paramg)
  {
    return this.B.f(paramg);
  }
  
  public MenuItem getItem()
  {
    return this.C;
  }
  
  boolean h(e parame, MenuItem paramMenuItem)
  {
    return (super.h(parame, paramMenuItem)) || (this.B.h(parame, paramMenuItem));
  }
  
  public Menu i0()
  {
    return this.B;
  }
  
  public boolean m(g paramg)
  {
    return this.B.m(paramg);
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    this.B.setGroupDividerEnabled(paramBoolean);
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    return (SubMenu)super.Y(paramInt);
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    return (SubMenu)super.Z(paramDrawable);
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    return (SubMenu)super.b0(paramInt);
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    return (SubMenu)super.c0(paramCharSequence);
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    return (SubMenu)super.d0(paramView);
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.C.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.C.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.B.setQwertyMode(paramBoolean);
  }
  
  public String v()
  {
    Object localObject = this.C;
    int i;
    if (localObject != null) {
      i = ((g)localObject).getItemId();
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(super.v());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.m
 * JD-Core Version:    0.7.0.1
 */