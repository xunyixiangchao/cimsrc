package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.drawable;
import androidx.appcompat.R.id;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.view.menu.j.a;
import androidx.core.view.c0;
import androidx.core.view.e0;
import androidx.core.view.x;

public class m0
  implements s
{
  Toolbar a;
  private int b;
  private View c;
  private View d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  CharSequence i;
  private CharSequence j;
  private CharSequence k;
  Window.Callback l;
  boolean m;
  private ActionMenuPresenter n;
  private int o = 0;
  private int p = 0;
  private Drawable q;
  
  public m0(Toolbar paramToolbar, boolean paramBoolean)
  {
    this(paramToolbar, paramBoolean, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
  }
  
  public m0(Toolbar paramToolbar, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.a = paramToolbar;
    this.i = paramToolbar.getTitle();
    this.j = paramToolbar.getSubtitle();
    boolean bool;
    if (this.i != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.h = bool;
    this.g = paramToolbar.getNavigationIcon();
    paramToolbar = k0.v(paramToolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    this.q = paramToolbar.g(R.styleable.ActionBar_homeAsUpIndicator);
    if (paramBoolean)
    {
      Object localObject = paramToolbar.p(R.styleable.ActionBar_title);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        F((CharSequence)localObject);
      }
      localObject = paramToolbar.p(R.styleable.ActionBar_subtitle);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        E((CharSequence)localObject);
      }
      localObject = paramToolbar.g(R.styleable.ActionBar_logo);
      if (localObject != null) {
        A((Drawable)localObject);
      }
      localObject = paramToolbar.g(R.styleable.ActionBar_icon);
      if (localObject != null) {
        setIcon((Drawable)localObject);
      }
      if (this.g == null)
      {
        localObject = this.q;
        if (localObject != null) {
          D((Drawable)localObject);
        }
      }
      o(paramToolbar.k(R.styleable.ActionBar_displayOptions, 0));
      paramInt2 = paramToolbar.n(R.styleable.ActionBar_customNavigationLayout, 0);
      if (paramInt2 != 0)
      {
        y(LayoutInflater.from(this.a.getContext()).inflate(paramInt2, this.a, false));
        o(this.b | 0x10);
      }
      paramInt2 = paramToolbar.m(R.styleable.ActionBar_height, 0);
      if (paramInt2 > 0)
      {
        localObject = this.a.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramInt2 = paramToolbar.e(R.styleable.ActionBar_contentInsetStart, -1);
      int i1 = paramToolbar.e(R.styleable.ActionBar_contentInsetEnd, -1);
      if ((paramInt2 >= 0) || (i1 >= 0)) {
        this.a.J(Math.max(paramInt2, 0), Math.max(i1, 0));
      }
      paramInt2 = paramToolbar.n(R.styleable.ActionBar_titleTextStyle, 0);
      if (paramInt2 != 0)
      {
        localObject = this.a;
        ((Toolbar)localObject).N(((ViewGroup)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.n(R.styleable.ActionBar_subtitleTextStyle, 0);
      if (paramInt2 != 0)
      {
        localObject = this.a;
        ((Toolbar)localObject).M(((ViewGroup)localObject).getContext(), paramInt2);
      }
      paramInt2 = paramToolbar.n(R.styleable.ActionBar_popupTheme, 0);
      if (paramInt2 != 0) {
        this.a.setPopupTheme(paramInt2);
      }
    }
    else
    {
      this.b = x();
    }
    paramToolbar.w();
    z(paramInt1);
    this.k = this.a.getNavigationContentDescription();
    this.a.setNavigationOnClickListener(new a());
  }
  
  private void G(CharSequence paramCharSequence)
  {
    this.i = paramCharSequence;
    if ((this.b & 0x8) != 0)
    {
      this.a.setTitle(paramCharSequence);
      if (this.h) {
        x.t0(this.a.getRootView(), paramCharSequence);
      }
    }
  }
  
  private void H()
  {
    if ((this.b & 0x4) != 0)
    {
      if (TextUtils.isEmpty(this.k))
      {
        this.a.setNavigationContentDescription(this.p);
        return;
      }
      this.a.setNavigationContentDescription(this.k);
    }
  }
  
  private void I()
  {
    Toolbar localToolbar;
    Drawable localDrawable;
    if ((this.b & 0x4) != 0)
    {
      localToolbar = this.a;
      localDrawable = this.g;
      if (localDrawable == null) {
        localDrawable = this.q;
      }
    }
    else
    {
      localToolbar = this.a;
      localDrawable = null;
    }
    localToolbar.setNavigationIcon(localDrawable);
  }
  
  private void J()
  {
    int i1 = this.b;
    Drawable localDrawable;
    if ((i1 & 0x2) != 0)
    {
      if ((i1 & 0x1) != 0)
      {
        localDrawable = this.f;
        if (localDrawable != null) {}
      }
      else
      {
        localDrawable = this.e;
      }
    }
    else {
      localDrawable = null;
    }
    this.a.setLogo(localDrawable);
  }
  
  private int x()
  {
    if (this.a.getNavigationIcon() != null)
    {
      this.q = this.a.getNavigationIcon();
      return 15;
    }
    return 11;
  }
  
  public void A(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    J();
  }
  
  public void B(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      str = null;
    } else {
      str = c().getString(paramInt);
    }
    C(str);
  }
  
  public void C(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
    H();
  }
  
  public void D(Drawable paramDrawable)
  {
    this.g = paramDrawable;
    I();
  }
  
  public void E(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    if ((this.b & 0x8) != 0) {
      this.a.setSubtitle(paramCharSequence);
    }
  }
  
  public void F(CharSequence paramCharSequence)
  {
    this.h = true;
    G(paramCharSequence);
  }
  
  public void a(Menu paramMenu, j.a parama)
  {
    if (this.n == null)
    {
      ActionMenuPresenter localActionMenuPresenter = new ActionMenuPresenter(this.a.getContext());
      this.n = localActionMenuPresenter;
      localActionMenuPresenter.s(R.id.action_menu_presenter);
    }
    this.n.m(parama);
    this.a.K((e)paramMenu, this.n);
  }
  
  public boolean b()
  {
    return this.a.B();
  }
  
  public Context c()
  {
    return this.a.getContext();
  }
  
  public void collapseActionView()
  {
    this.a.e();
  }
  
  public void d()
  {
    this.m = true;
  }
  
  public boolean e()
  {
    return this.a.A();
  }
  
  public boolean f()
  {
    return this.a.w();
  }
  
  public boolean g()
  {
    return this.a.Q();
  }
  
  public CharSequence getTitle()
  {
    return this.a.getTitle();
  }
  
  public boolean h()
  {
    return this.a.d();
  }
  
  public void i()
  {
    this.a.f();
  }
  
  public void j(j.a parama, e.a parama1)
  {
    this.a.L(parama, parama1);
  }
  
  public void k(d0 paramd0)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      Toolbar localToolbar = this.a;
      if (localObject == localToolbar) {
        localToolbar.removeView(this.c);
      }
    }
    this.c = paramd0;
    if ((paramd0 != null) && (this.o == 2))
    {
      this.a.addView(paramd0, 0);
      localObject = (Toolbar.LayoutParams)this.c.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).width = -2;
      ((ViewGroup.MarginLayoutParams)localObject).height = -2;
      ((ActionBar.LayoutParams)localObject).a = 8388691;
      paramd0.setAllowCollapse(true);
    }
  }
  
  public ViewGroup l()
  {
    return this.a;
  }
  
  public void m(boolean paramBoolean) {}
  
  public boolean n()
  {
    return this.a.v();
  }
  
  public void o(int paramInt)
  {
    int i1 = this.b ^ paramInt;
    this.b = paramInt;
    if (i1 != 0)
    {
      if ((i1 & 0x4) != 0)
      {
        if ((paramInt & 0x4) != 0) {
          H();
        }
        I();
      }
      if ((i1 & 0x3) != 0) {
        J();
      }
      Object localObject;
      if ((i1 & 0x8) != 0)
      {
        CharSequence localCharSequence;
        if ((paramInt & 0x8) != 0)
        {
          this.a.setTitle(this.i);
          localObject = this.a;
          localCharSequence = this.j;
        }
        else
        {
          localObject = this.a;
          localCharSequence = null;
          ((Toolbar)localObject).setTitle(null);
          localObject = this.a;
        }
        ((Toolbar)localObject).setSubtitle(localCharSequence);
      }
      if ((i1 & 0x10) != 0)
      {
        localObject = this.d;
        if (localObject != null)
        {
          if ((paramInt & 0x10) != 0)
          {
            this.a.addView((View)localObject);
            return;
          }
          this.a.removeView((View)localObject);
        }
      }
    }
  }
  
  public int p()
  {
    return this.b;
  }
  
  public Menu q()
  {
    return this.a.getMenu();
  }
  
  public void r(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(c(), paramInt);
    } else {
      localDrawable = null;
    }
    A(localDrawable);
  }
  
  public int s()
  {
    return this.o;
  }
  
  public void setIcon(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(c(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    J();
  }
  
  public void setVisibility(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    this.l = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.h) {
      G(paramCharSequence);
    }
  }
  
  public c0 t(final int paramInt, long paramLong)
  {
    c0 localc0 = x.e(this.a);
    float f1;
    if (paramInt == 0) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    return localc0.a(f1).d(paramLong).f(new b(paramInt));
  }
  
  public void u()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void v()
  {
    Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
  }
  
  public void w(boolean paramBoolean)
  {
    this.a.setCollapsible(paramBoolean);
  }
  
  public void y(View paramView)
  {
    View localView = this.d;
    if ((localView != null) && ((this.b & 0x10) != 0)) {
      this.a.removeView(localView);
    }
    this.d = paramView;
    if ((paramView != null) && ((this.b & 0x10) != 0)) {
      this.a.addView(paramView);
    }
  }
  
  public void z(int paramInt)
  {
    if (paramInt == this.p) {
      return;
    }
    this.p = paramInt;
    if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
      B(this.p);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    final h.a a = new h.a(m0.this.a.getContext(), 0, 16908332, 0, 0, m0.this.i);
    
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = m0.this;
      Window.Callback localCallback = paramView.l;
      if ((localCallback != null) && (paramView.m)) {
        localCallback.onMenuItemSelected(0, this.a);
      }
    }
  }
  
  class b
    extends e0
  {
    private boolean a = false;
    
    b(int paramInt) {}
    
    public void a(View paramView)
    {
      this.a = true;
    }
    
    public void b(View paramView)
    {
      if (!this.a) {
        m0.this.a.setVisibility(paramInt);
      }
    }
    
    public void c(View paramView)
    {
      m0.this.a.setVisibility(0);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.m0
 * JD-Core Version:    0.7.0.1
 */