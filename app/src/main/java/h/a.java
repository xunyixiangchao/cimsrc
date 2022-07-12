package h;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class a
  implements s0.b
{
  private final int a;
  private final int b;
  private final int c;
  private CharSequence d;
  private CharSequence e;
  private Intent f;
  private char g;
  private int h = 4096;
  private char i;
  private int j = 4096;
  private Drawable k;
  private Context l;
  private MenuItem.OnMenuItemClickListener m;
  private CharSequence n;
  private CharSequence o;
  private ColorStateList p = null;
  private PorterDuff.Mode q = null;
  private boolean r = false;
  private boolean s = false;
  private int t = 16;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence)
  {
    this.l = paramContext;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt4;
    this.d = paramCharSequence;
  }
  
  private void c()
  {
    Drawable localDrawable = this.k;
    if ((localDrawable != null) && ((this.r) || (this.s)))
    {
      localDrawable = r0.a.r(localDrawable);
      this.k = localDrawable;
      localDrawable = localDrawable.mutate();
      this.k = localDrawable;
      if (this.r) {
        r0.a.o(localDrawable, this.p);
      }
      if (this.s) {
        r0.a.p(this.k, this.q);
      }
    }
  }
  
  public s0.b a(androidx.core.view.b paramb)
  {
    throw new UnsupportedOperationException();
  }
  
  public androidx.core.view.b b()
  {
    return null;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public s0.b d(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public s0.b e(View paramView)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean expandActionView()
  {
    return false;
  }
  
  public s0.b f(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException();
  }
  
  public View getActionView()
  {
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.j;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.i;
  }
  
  public CharSequence getContentDescription()
  {
    return this.n;
  }
  
  public int getGroupId()
  {
    return this.b;
  }
  
  public Drawable getIcon()
  {
    return this.k;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.p;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.q;
  }
  
  public Intent getIntent()
  {
    return this.f;
  }
  
  public int getItemId()
  {
    return this.a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public int getNumericModifiers()
  {
    return this.h;
  }
  
  public char getNumericShortcut()
  {
    return this.g;
  }
  
  public int getOrder()
  {
    return this.c;
  }
  
  public SubMenu getSubMenu()
  {
    return null;
  }
  
  public CharSequence getTitle()
  {
    return this.d;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = this.e;
    if (localCharSequence != null) {
      return localCharSequence;
    }
    return this.d;
  }
  
  public CharSequence getTooltipText()
  {
    return this.o;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isActionViewExpanded()
  {
    return false;
  }
  
  public boolean isCheckable()
  {
    return (this.t & 0x1) != 0;
  }
  
  public boolean isChecked()
  {
    return (this.t & 0x2) != 0;
  }
  
  public boolean isEnabled()
  {
    return (this.t & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    return (this.t & 0x8) == 0;
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    this.i = Character.toLowerCase(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    this.i = Character.toLowerCase(paramChar);
    this.j = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    this.t = (paramBoolean | this.t & 0xFFFFFFFE);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    int i2 = this.t;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    this.t = (i1 | i2 & 0xFFFFFFFD);
    return this;
  }
  
  public s0.b setContentDescription(CharSequence paramCharSequence)
  {
    this.n = paramCharSequence;
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int i2 = this.t;
    int i1;
    if (paramBoolean) {
      i1 = 16;
    } else {
      i1 = 0;
    }
    this.t = (i1 | i2 & 0xFFFFFFEF);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.k = androidx.core.content.b.d(this.l, paramInt);
    c();
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.k = paramDrawable;
    c();
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.p = paramColorStateList;
    this.r = true;
    c();
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.q = paramMode;
    this.s = true;
    c();
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.f = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    this.g = paramChar;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    this.g = paramChar;
    this.h = KeyEvent.normalizeMetaState(paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    throw new UnsupportedOperationException();
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.m = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.g = paramChar1;
    this.i = Character.toLowerCase(paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.g = paramChar1;
    this.h = KeyEvent.normalizeMetaState(paramInt1);
    this.i = Character.toLowerCase(paramChar2);
    this.j = KeyEvent.normalizeMetaState(paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt) {}
  
  public MenuItem setTitle(int paramInt)
  {
    this.d = this.l.getResources().getString(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    return this;
  }
  
  public s0.b setTooltipText(CharSequence paramCharSequence)
  {
    this.o = paramCharSequence;
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    int i2 = this.t;
    int i1 = 8;
    if (paramBoolean) {
      i1 = 0;
    }
    this.t = (i2 & 0x8 | i1);
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h.a
 * JD-Core Version:    0.7.0.1
 */