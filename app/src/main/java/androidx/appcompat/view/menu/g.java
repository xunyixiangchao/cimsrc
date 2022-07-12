package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import androidx.appcompat.R.string;
import androidx.core.view.b.b;

public final class g
  implements s0.b
{
  private View A;
  private androidx.core.view.b B;
  private MenuItem.OnActionExpandListener C;
  private boolean D = false;
  private ContextMenu.ContextMenuInfo E;
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  private Intent g;
  private char h;
  private int i = 4096;
  private char j;
  private int k = 4096;
  private Drawable l;
  private int m = 0;
  e n;
  private m o;
  private Runnable p;
  private MenuItem.OnMenuItemClickListener q;
  private CharSequence r;
  private CharSequence s;
  private ColorStateList t = null;
  private PorterDuff.Mode u = null;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private int y = 16;
  private int z;
  
  g(e parame, int paramInt1, int paramInt2, int paramInt3, int paramInt4, CharSequence paramCharSequence, int paramInt5)
  {
    this.n = parame;
    this.a = paramInt2;
    this.b = paramInt1;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramCharSequence;
    this.z = paramInt5;
  }
  
  private static void d(StringBuilder paramStringBuilder, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 & paramInt2) == paramInt2) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private Drawable e(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.x) {
        if (!this.v)
        {
          localDrawable = paramDrawable;
          if (!this.w) {}
        }
        else
        {
          localDrawable = r0.a.r(paramDrawable).mutate();
          if (this.v) {
            r0.a.o(localDrawable, this.t);
          }
          if (this.w) {
            r0.a.p(localDrawable, this.u);
          }
          this.x = false;
        }
      }
    }
    return localDrawable;
  }
  
  boolean A()
  {
    return (this.n.J()) && (g() != 0);
  }
  
  public boolean B()
  {
    return (this.z & 0x4) == 4;
  }
  
  public s0.b a(androidx.core.view.b paramb)
  {
    androidx.core.view.b localb = this.B;
    if (localb != null) {
      localb.i();
    }
    this.A = null;
    this.B = paramb;
    this.n.M(true);
    paramb = this.B;
    if (paramb != null) {
      paramb.k(new a());
    }
    return this;
  }
  
  public androidx.core.view.b b()
  {
    return this.B;
  }
  
  public void c()
  {
    this.n.K(this);
  }
  
  public boolean collapseActionView()
  {
    if ((this.z & 0x8) == 0) {
      return false;
    }
    if (this.A == null) {
      return true;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = this.C;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionCollapse(this))) {
      return false;
    }
    return this.n.f(this);
  }
  
  public boolean expandActionView()
  {
    if (!j()) {
      return false;
    }
    MenuItem.OnActionExpandListener localOnActionExpandListener = this.C;
    if ((localOnActionExpandListener != null) && (!localOnActionExpandListener.onMenuItemActionExpand(this))) {
      return false;
    }
    return this.n.m(this);
  }
  
  public int f()
  {
    return this.d;
  }
  
  char g()
  {
    if (this.n.I()) {
      return this.j;
    }
    return this.h;
  }
  
  public ActionProvider getActionProvider()
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
  }
  
  public View getActionView()
  {
    Object localObject = this.A;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.B;
    if (localObject != null)
    {
      localObject = ((androidx.core.view.b)localObject).e(this);
      this.A = ((View)localObject);
      return localObject;
    }
    return null;
  }
  
  public int getAlphabeticModifiers()
  {
    return this.k;
  }
  
  public char getAlphabeticShortcut()
  {
    return this.j;
  }
  
  public CharSequence getContentDescription()
  {
    return this.r;
  }
  
  public int getGroupId()
  {
    return this.b;
  }
  
  public Drawable getIcon()
  {
    Drawable localDrawable = this.l;
    if (localDrawable != null) {
      return e(localDrawable);
    }
    if (this.m != 0)
    {
      localDrawable = c.a.b(this.n.w(), this.m);
      this.m = 0;
      this.l = localDrawable;
      return e(localDrawable);
    }
    return null;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.t;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.u;
  }
  
  public Intent getIntent()
  {
    return this.g;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getItemId()
  {
    return this.a;
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return this.E;
  }
  
  public int getNumericModifiers()
  {
    return this.i;
  }
  
  public char getNumericShortcut()
  {
    return this.h;
  }
  
  public int getOrder()
  {
    return this.c;
  }
  
  public SubMenu getSubMenu()
  {
    return this.o;
  }
  
  @ViewDebug.CapturedViewProperty
  public CharSequence getTitle()
  {
    return this.e;
  }
  
  public CharSequence getTitleCondensed()
  {
    CharSequence localCharSequence = this.f;
    if (localCharSequence != null) {
      return localCharSequence;
    }
    return this.e;
  }
  
  public CharSequence getTooltipText()
  {
    return this.s;
  }
  
  String h()
  {
    char c1 = g();
    if (c1 == 0) {
      return "";
    }
    Resources localResources = this.n.w().getResources();
    StringBuilder localStringBuilder = new StringBuilder();
    if (ViewConfiguration.get(this.n.w()).hasPermanentMenuKey()) {
      localStringBuilder.append(localResources.getString(R.string.abc_prepend_shortcut_label));
    }
    int i1;
    if (this.n.I()) {
      i1 = this.k;
    } else {
      i1 = this.i;
    }
    d(localStringBuilder, i1, 65536, localResources.getString(R.string.abc_menu_meta_shortcut_label));
    d(localStringBuilder, i1, 4096, localResources.getString(R.string.abc_menu_ctrl_shortcut_label));
    d(localStringBuilder, i1, 2, localResources.getString(R.string.abc_menu_alt_shortcut_label));
    d(localStringBuilder, i1, 1, localResources.getString(R.string.abc_menu_shift_shortcut_label));
    d(localStringBuilder, i1, 4, localResources.getString(R.string.abc_menu_sym_shortcut_label));
    d(localStringBuilder, i1, 8, localResources.getString(R.string.abc_menu_function_shortcut_label));
    if (c1 != '\b')
    {
      if (c1 != '\n')
      {
        if (c1 != ' ')
        {
          localStringBuilder.append(c1);
          break label230;
        }
        i1 = R.string.abc_menu_space_shortcut_label;
      }
      else
      {
        i1 = R.string.abc_menu_enter_shortcut_label;
      }
    }
    else {
      i1 = R.string.abc_menu_delete_shortcut_label;
    }
    localStringBuilder.append(localResources.getString(i1));
    label230:
    return localStringBuilder.toString();
  }
  
  public boolean hasSubMenu()
  {
    return this.o != null;
  }
  
  CharSequence i(k.a parama)
  {
    if ((parama != null) && (parama.d())) {
      return getTitleCondensed();
    }
    return getTitle();
  }
  
  public boolean isActionViewExpanded()
  {
    return this.D;
  }
  
  public boolean isCheckable()
  {
    return (this.y & 0x1) == 1;
  }
  
  public boolean isChecked()
  {
    return (this.y & 0x2) == 2;
  }
  
  public boolean isEnabled()
  {
    return (this.y & 0x10) != 0;
  }
  
  public boolean isVisible()
  {
    androidx.core.view.b localb = this.B;
    if ((localb != null) && (localb.h())) {
      return ((this.y & 0x8) == 0) && (this.B.c());
    }
    return (this.y & 0x8) == 0;
  }
  
  public boolean j()
  {
    int i1 = this.z;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((i1 & 0x8) != 0)
    {
      if (this.A == null)
      {
        androidx.core.view.b localb = this.B;
        if (localb != null) {
          this.A = localb.e(this);
        }
      }
      bool1 = bool2;
      if (this.A != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean k()
  {
    Object localObject = this.q;
    if ((localObject != null) && (((MenuItem.OnMenuItemClickListener)localObject).onMenuItemClick(this))) {
      return true;
    }
    localObject = this.n;
    if (((e)localObject).h((e)localObject, this)) {
      return true;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((Runnable)localObject).run();
      return true;
    }
    if (this.g != null) {
      try
      {
        this.n.w().startActivity(this.g);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", localActivityNotFoundException);
      }
    }
    androidx.core.view.b localb = this.B;
    return (localb != null) && (localb.f());
  }
  
  public boolean l()
  {
    return (this.y & 0x20) == 32;
  }
  
  public boolean m()
  {
    return (this.y & 0x4) != 0;
  }
  
  public boolean n()
  {
    return (this.z & 0x1) == 1;
  }
  
  public boolean o()
  {
    return (this.z & 0x2) == 2;
  }
  
  public s0.b p(int paramInt)
  {
    Context localContext = this.n.w();
    q(LayoutInflater.from(localContext).inflate(paramInt, new LinearLayout(localContext), false));
    return this;
  }
  
  public s0.b q(View paramView)
  {
    this.A = paramView;
    this.B = null;
    if ((paramView != null) && (paramView.getId() == -1))
    {
      int i1 = this.a;
      if (i1 > 0) {
        paramView.setId(i1);
      }
    }
    this.n.K(this);
    return this;
  }
  
  public void r(boolean paramBoolean)
  {
    this.D = paramBoolean;
    this.n.M(false);
  }
  
  void s(boolean paramBoolean)
  {
    int i2 = this.y;
    int i1;
    if (paramBoolean) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    i1 |= i2 & 0xFFFFFFFD;
    this.y = i1;
    if (i2 != i1) {
      this.n.M(false);
    }
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    if (this.j == paramChar) {
      return this;
    }
    this.j = Character.toLowerCase(paramChar);
    this.n.M(false);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    if ((this.j == paramChar) && (this.k == paramInt)) {
      return this;
    }
    this.j = Character.toLowerCase(paramChar);
    this.k = KeyEvent.normalizeMetaState(paramInt);
    this.n.M(false);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    int i1 = this.y;
    int i2 = paramBoolean | i1 & 0xFFFFFFFE;
    this.y = i2;
    if (i1 != i2) {
      this.n.M(false);
    }
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    if ((this.y & 0x4) != 0)
    {
      this.n.X(this);
      return this;
    }
    s(paramBoolean);
    return this;
  }
  
  public s0.b setContentDescription(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = this.y | 0x10;
    } else {
      i1 = this.y & 0xFFFFFFEF;
    }
    this.y = i1;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    this.l = null;
    this.m = paramInt;
    this.x = true;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    this.m = 0;
    this.l = paramDrawable;
    this.x = true;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    this.t = paramColorStateList;
    this.v = true;
    this.x = true;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    this.u = paramMode;
    this.w = true;
    this.x = true;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    this.g = paramIntent;
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    if (this.h == paramChar) {
      return this;
    }
    this.h = paramChar;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    if ((this.h == paramChar) && (this.i == paramInt)) {
      return this;
    }
    this.h = paramChar;
    this.i = KeyEvent.normalizeMetaState(paramInt);
    this.n.M(false);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    this.C = paramOnActionExpandListener;
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.q = paramOnMenuItemClickListener;
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    this.h = paramChar1;
    this.j = Character.toLowerCase(paramChar2);
    this.n.M(false);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    this.h = paramChar1;
    this.i = KeyEvent.normalizeMetaState(paramInt1);
    this.j = Character.toLowerCase(paramChar2);
    this.k = KeyEvent.normalizeMetaState(paramInt2);
    this.n.M(false);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    int i1 = paramInt & 0x3;
    if ((i1 != 0) && (i1 != 1) && (i1 != 2)) {
      throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }
    this.z = paramInt;
    this.n.K(this);
  }
  
  public MenuItem setTitle(int paramInt)
  {
    return setTitle(this.n.w().getString(paramInt));
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    this.n.M(false);
    m localm = this.o;
    if (localm != null) {
      localm.setHeaderTitle(paramCharSequence);
    }
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    this.n.M(false);
    return this;
  }
  
  public s0.b setTooltipText(CharSequence paramCharSequence)
  {
    this.s = paramCharSequence;
    this.n.M(false);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    if (y(paramBoolean)) {
      this.n.L(this);
    }
    return this;
  }
  
  public void t(boolean paramBoolean)
  {
    int i2 = this.y;
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    this.y = (i1 | i2 & 0xFFFFFFFB);
  }
  
  public String toString()
  {
    CharSequence localCharSequence = this.e;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public void u(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = this.y | 0x20;
    } else {
      i1 = this.y & 0xFFFFFFDF;
    }
    this.y = i1;
  }
  
  void v(ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.E = paramContextMenuInfo;
  }
  
  public s0.b w(int paramInt)
  {
    setShowAsAction(paramInt);
    return this;
  }
  
  public void x(m paramm)
  {
    this.o = paramm;
    paramm.setHeaderTitle(getTitle());
  }
  
  boolean y(boolean paramBoolean)
  {
    int i2 = this.y;
    boolean bool = false;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    i1 |= i2 & 0xFFFFFFF7;
    this.y = i1;
    paramBoolean = bool;
    if (i2 != i1) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean z()
  {
    return this.n.C();
  }
  
  class a
    implements b.b
  {
    a() {}
    
    public void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      g localg = g.this;
      localg.n.L(localg);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.g
 * JD-Core Version:    0.7.0.1
 */