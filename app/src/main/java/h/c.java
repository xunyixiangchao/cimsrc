package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.b.b;
import java.lang.reflect.Method;

public class c
  extends b
  implements MenuItem
{
  private final s0.b d;
  private Method e;
  
  public c(Context paramContext, s0.b paramb)
  {
    super(paramContext);
    if (paramb != null)
    {
      this.d = paramb;
      return;
    }
    throw new IllegalArgumentException("Wrapped Object can not be null.");
  }
  
  public boolean collapseActionView()
  {
    return this.d.collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return this.d.expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    androidx.core.view.b localb = this.d.b();
    if ((localb instanceof a)) {
      return ((a)localb).d;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView2 = this.d.getActionView();
    View localView1 = localView2;
    if ((localView2 instanceof c)) {
      localView1 = ((c)localView2).a();
    }
    return localView1;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.d.getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return this.d.getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return this.d.getContentDescription();
  }
  
  public int getGroupId()
  {
    return this.d.getGroupId();
  }
  
  public Drawable getIcon()
  {
    return this.d.getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return this.d.getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.d.getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return this.d.getIntent();
  }
  
  public int getItemId()
  {
    return this.d.getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.d.getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return this.d.getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return this.d.getNumericShortcut();
  }
  
  public int getOrder()
  {
    return this.d.getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return d(this.d.getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return this.d.getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return this.d.getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return this.d.getTooltipText();
  }
  
  public void h(boolean paramBoolean)
  {
    try
    {
      if (this.e == null) {
        this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
      }
      this.e.invoke(this.d, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
    }
  }
  
  public boolean hasSubMenu()
  {
    return this.d.hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return this.d.isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return this.d.isCheckable();
  }
  
  public boolean isChecked()
  {
    return this.d.isChecked();
  }
  
  public boolean isEnabled()
  {
    return this.d.isEnabled();
  }
  
  public boolean isVisible()
  {
    return this.d.isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    b localb = new b(this.a, paramActionProvider);
    s0.b localb1 = this.d;
    if (paramActionProvider != null) {
      paramActionProvider = localb;
    } else {
      paramActionProvider = null;
    }
    localb1.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    this.d.setActionView(paramInt);
    View localView = this.d.getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      this.d.setActionView(new c(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new c(paramView);
    }
    this.d.setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.d.setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.d.setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    this.d.setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    this.d.setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    this.d.setContentDescription(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    this.d.setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.d.setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.d.setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.d.setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.d.setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.d.setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.d.setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.d.setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    s0.b localb = this.d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new d(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localb.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    s0.b localb = this.d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new e(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localb.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.d.setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.d.setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    this.d.setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    this.d.setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    this.d.setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.d.setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.d.setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    this.d.setTooltipText(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return this.d.setVisible(paramBoolean);
  }
  
  private class a
    extends androidx.core.view.b
  {
    final ActionProvider d;
    
    a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.d = paramActionProvider;
    }
    
    public boolean b()
    {
      return this.d.hasSubMenu();
    }
    
    public View d()
    {
      return this.d.onCreateActionView();
    }
    
    public boolean f()
    {
      return this.d.onPerformDefaultAction();
    }
    
    public void g(SubMenu paramSubMenu)
    {
      this.d.onPrepareSubMenu(c.this.d(paramSubMenu));
    }
  }
  
  private class b
    extends c.a
    implements ActionProvider.VisibilityListener
  {
    private b.b f;
    
    b(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public boolean c()
    {
      return this.d.isVisible();
    }
    
    public View e(MenuItem paramMenuItem)
    {
      return this.d.onCreateActionView(paramMenuItem);
    }
    
    public boolean h()
    {
      return this.d.overridesItemVisibility();
    }
    
    public void k(b.b paramb)
    {
      this.f = paramb;
      ActionProvider localActionProvider = this.d;
      if (paramb != null) {
        paramb = this;
      } else {
        paramb = null;
      }
      localActionProvider.setVisibilityListener(paramb);
    }
    
    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      b.b localb = this.f;
      if (localb != null) {
        localb.onActionProviderVisibilityChanged(paramBoolean);
      }
    }
  }
  
  static class c
    extends FrameLayout
    implements g.c
  {
    final CollapsibleActionView a;
    
    c(View paramView)
    {
      super();
      this.a = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    View a()
    {
      return (View)this.a;
    }
    
    public void c()
    {
      this.a.onActionViewExpanded();
    }
    
    public void e()
    {
      this.a.onActionViewCollapsed();
    }
  }
  
  private class d
    implements MenuItem.OnActionExpandListener
  {
    private final MenuItem.OnActionExpandListener a;
    
    d(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      this.a = paramOnActionExpandListener;
    }
    
    public boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return this.a.onMenuItemActionCollapse(c.this.c(paramMenuItem));
    }
    
    public boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return this.a.onMenuItemActionExpand(c.this.c(paramMenuItem));
    }
  }
  
  private class e
    implements MenuItem.OnMenuItemClickListener
  {
    private final MenuItem.OnMenuItemClickListener a;
    
    e(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      this.a = paramOnMenuItemClickListener;
    }
    
    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return this.a.onMenuItemClick(c.this.c(paramMenuItem));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h.c
 * JD-Core Version:    0.7.0.1
 */