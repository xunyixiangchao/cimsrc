package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import s0.c;

class f
  extends d
  implements SubMenu
{
  private final c e;
  
  f(Context paramContext, c paramc)
  {
    super(paramContext, paramc);
    this.e = paramc;
  }
  
  public void clearHeader()
  {
    this.e.clearHeader();
  }
  
  public MenuItem getItem()
  {
    return c(this.e.getItem());
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    this.e.setHeaderIcon(paramInt);
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    this.e.setHeaderIcon(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    this.e.setHeaderTitle(paramInt);
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    this.e.setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    this.e.setHeaderView(paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    this.e.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    this.e.setIcon(paramDrawable);
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h.f
 * JD-Core Version:    0.7.0.1
 */