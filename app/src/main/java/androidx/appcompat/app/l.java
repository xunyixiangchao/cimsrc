package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.e.a;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.d;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.s;
import androidx.core.view.c0;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.x;
import g.a;
import g.b;
import g.b.a;
import g.g;
import g.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class l
  extends ActionBar
  implements ActionBarOverlayLayout.d
{
  private static final Interpolator E = new AccelerateInterpolator();
  private static final Interpolator F = new DecelerateInterpolator();
  boolean A;
  final androidx.core.view.d0 B = new a();
  final androidx.core.view.d0 C = new b();
  final f0 D = new c();
  Context a;
  private Context b;
  private Activity c;
  ActionBarOverlayLayout d;
  ActionBarContainer e;
  s f;
  ActionBarContextView g;
  View h;
  androidx.appcompat.widget.d0 i;
  private ArrayList<Object> j = new ArrayList();
  private int k = -1;
  private boolean l;
  d m;
  b n;
  b.a o;
  private boolean p;
  private ArrayList<ActionBar.a> q = new ArrayList();
  private boolean r;
  private int s = 0;
  boolean t = true;
  boolean u;
  boolean v;
  private boolean w;
  private boolean x = true;
  h y;
  private boolean z;
  
  public l(Activity paramActivity, boolean paramBoolean)
  {
    this.c = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    H(paramActivity);
    if (!paramBoolean) {
      this.h = paramActivity.findViewById(16908290);
    }
  }
  
  public l(Dialog paramDialog)
  {
    H(paramDialog.getWindow().getDecorView());
  }
  
  static boolean A(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {
      return true;
    }
    return (!paramBoolean1) && (!paramBoolean2);
  }
  
  private s E(View paramView)
  {
    if ((paramView instanceof s)) {
      return (s)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    if (paramView != null) {
      paramView = paramView.getClass().getSimpleName();
    } else {
      paramView = "null";
    }
    localStringBuilder.append(paramView);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void G()
  {
    if (this.w)
    {
      this.w = false;
      ActionBarOverlayLayout localActionBarOverlayLayout = this.d;
      if (localActionBarOverlayLayout != null) {
        localActionBarOverlayLayout.setShowingForActionMode(false);
      }
      P(false);
    }
  }
  
  private void H(View paramView)
  {
    Object localObject = (ActionBarOverlayLayout)paramView.findViewById(R.id.decor_content_parent);
    this.d = ((ActionBarOverlayLayout)localObject);
    if (localObject != null) {
      ((ActionBarOverlayLayout)localObject).setActionBarVisibilityCallback(this);
    }
    this.f = E(paramView.findViewById(R.id.action_bar));
    this.g = ((ActionBarContextView)paramView.findViewById(R.id.action_context_bar));
    paramView = (ActionBarContainer)paramView.findViewById(R.id.action_bar_container);
    this.e = paramView;
    localObject = this.f;
    if ((localObject != null) && (this.g != null) && (paramView != null))
    {
      this.a = ((s)localObject).c();
      if ((this.f.p() & 0x4) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        this.l = true;
      }
      paramView = a.b(this.a);
      boolean bool;
      if ((!paramView.a()) && (i1 == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      M(bool);
      K(paramView.g());
      paramView = this.a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
      if (paramView.getBoolean(R.styleable.ActionBar_hideOnContentScroll, false)) {
        L(true);
      }
      int i1 = paramView.getDimensionPixelSize(R.styleable.ActionBar_elevation, 0);
      if (i1 != 0) {
        J(i1);
      }
      paramView.recycle();
      return;
    }
    paramView = new StringBuilder();
    paramView.append(getClass().getSimpleName());
    paramView.append(" can only be used with a compatible window decor layout");
    throw new IllegalStateException(paramView.toString());
  }
  
  private void K(boolean paramBoolean)
  {
    this.r = paramBoolean;
    if (!paramBoolean)
    {
      this.f.k(null);
      this.e.setTabContainer(this.i);
    }
    else
    {
      this.e.setTabContainer(null);
      this.f.k(this.i);
    }
    int i1 = F();
    boolean bool = true;
    if (i1 == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.i;
    if (localObject != null) {
      if (i1 != 0)
      {
        ((HorizontalScrollView)localObject).setVisibility(0);
        localObject = this.d;
        if (localObject != null) {
          x.n0((View)localObject);
        }
      }
      else
      {
        ((HorizontalScrollView)localObject).setVisibility(8);
      }
    }
    localObject = this.f;
    if ((!this.r) && (i1 != 0)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((s)localObject).w(paramBoolean);
    localObject = this.d;
    if ((!this.r) && (i1 != 0)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((ActionBarOverlayLayout)localObject).setHasNonEmbeddedTabs(paramBoolean);
  }
  
  private boolean N()
  {
    return x.U(this.e);
  }
  
  private void O()
  {
    if (!this.w)
    {
      this.w = true;
      ActionBarOverlayLayout localActionBarOverlayLayout = this.d;
      if (localActionBarOverlayLayout != null) {
        localActionBarOverlayLayout.setShowingForActionMode(true);
      }
      P(false);
    }
  }
  
  private void P(boolean paramBoolean)
  {
    if (A(this.u, this.v, this.w))
    {
      if (!this.x)
      {
        this.x = true;
        D(paramBoolean);
      }
    }
    else if (this.x)
    {
      this.x = false;
      C(paramBoolean);
    }
  }
  
  void B()
  {
    b.a locala = this.o;
    if (locala != null)
    {
      locala.d(this.n);
      this.n = null;
      this.o = null;
    }
  }
  
  public void C(boolean paramBoolean)
  {
    h localh = this.y;
    if (localh != null) {
      localh.a();
    }
    if ((this.s == 0) && ((this.z) || (paramBoolean)))
    {
      this.e.setAlpha(1.0F);
      this.e.setTransitioning(true);
      localh = new h();
      float f2 = -this.e.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp82_80 = localObject;
        tmp82_80[0] = 0;
        Object tmp86_82 = tmp82_80;
        tmp86_82[1] = 0;
        tmp86_82;
        this.e.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = x.e(this.e).k(f1);
      ((c0)localObject).i(this.D);
      localh.c((c0)localObject);
      if (this.t)
      {
        localObject = this.h;
        if (localObject != null) {
          localh.c(x.e((View)localObject).k(f1));
        }
      }
      localh.f(E);
      localh.e(250L);
      localh.g(this.B);
      this.y = localh;
      localh.h();
      return;
    }
    this.B.b(null);
  }
  
  public void D(boolean paramBoolean)
  {
    Object localObject1 = this.y;
    if (localObject1 != null) {
      ((h)localObject1).a();
    }
    this.e.setVisibility(0);
    if ((this.s == 0) && ((this.z) || (paramBoolean)))
    {
      this.e.setTranslationY(0.0F);
      float f2 = -this.e.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject1 = new int[2];
        Object tmp73_71 = localObject1;
        tmp73_71[0] = 0;
        Object tmp77_73 = tmp73_71;
        tmp77_73[1] = 0;
        tmp77_73;
        this.e.getLocationInWindow((int[])localObject1);
        f1 = f2 - localObject1[1];
      }
      this.e.setTranslationY(f1);
      localObject1 = new h();
      Object localObject2 = x.e(this.e).k(0.0F);
      ((c0)localObject2).i(this.D);
      ((h)localObject1).c((c0)localObject2);
      if (this.t)
      {
        localObject2 = this.h;
        if (localObject2 != null)
        {
          ((View)localObject2).setTranslationY(f1);
          ((h)localObject1).c(x.e(this.h).k(0.0F));
        }
      }
      ((h)localObject1).f(F);
      ((h)localObject1).e(250L);
      ((h)localObject1).g(this.C);
      this.y = ((h)localObject1);
      ((h)localObject1).h();
    }
    else
    {
      this.e.setAlpha(1.0F);
      this.e.setTranslationY(0.0F);
      if (this.t)
      {
        localObject1 = this.h;
        if (localObject1 != null) {
          ((View)localObject1).setTranslationY(0.0F);
        }
      }
      this.C.b(null);
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      x.n0((View)localObject1);
    }
  }
  
  public int F()
  {
    return this.f.s();
  }
  
  public void I(int paramInt1, int paramInt2)
  {
    int i1 = this.f.p();
    if ((paramInt2 & 0x4) != 0) {
      this.l = true;
    }
    this.f.o(paramInt1 & paramInt2 | paramInt2 & i1);
  }
  
  public void J(float paramFloat)
  {
    x.y0(this.e, paramFloat);
  }
  
  public void L(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.d.w())) {
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    this.A = paramBoolean;
    this.d.setHideOnContentScrollEnabled(paramBoolean);
  }
  
  public void M(boolean paramBoolean)
  {
    this.f.m(paramBoolean);
  }
  
  public void a()
  {
    if (this.v)
    {
      this.v = false;
      P(true);
    }
  }
  
  public void b()
  {
    h localh = this.y;
    if (localh != null)
    {
      localh.a();
      this.y = null;
    }
  }
  
  public void c(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void d() {}
  
  public void e(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void f()
  {
    if (!this.v)
    {
      this.v = true;
      P(true);
    }
  }
  
  public boolean h()
  {
    s locals = this.f;
    if ((locals != null) && (locals.n()))
    {
      this.f.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean == this.p) {
      return;
    }
    this.p = paramBoolean;
    int i2 = this.q.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((ActionBar.a)this.q.get(i1)).a(paramBoolean);
      i1 += 1;
    }
  }
  
  public int j()
  {
    return this.f.p();
  }
  
  public Context k()
  {
    if (this.b == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.a.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      int i1 = localTypedValue.resourceId;
      if (i1 != 0) {
        this.b = new ContextThemeWrapper(this.a, i1);
      } else {
        this.b = this.a;
      }
    }
    return this.b;
  }
  
  public void l()
  {
    if (!this.u)
    {
      this.u = true;
      P(false);
    }
  }
  
  public void n(Configuration paramConfiguration)
  {
    K(a.b(this.a).g());
  }
  
  public boolean p(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.m;
    if (localObject == null) {
      return false;
    }
    localObject = ((d)localObject).e();
    if (localObject != null)
    {
      if (paramKeyEvent != null) {
        i1 = paramKeyEvent.getDeviceId();
      } else {
        i1 = -1;
      }
      int i1 = KeyCharacterMap.load(i1).getKeyboardType();
      boolean bool = true;
      if (i1 == 1) {
        bool = false;
      }
      ((Menu)localObject).setQwertyMode(bool);
      return ((Menu)localObject).performShortcut(paramInt, paramKeyEvent, 0);
    }
    return false;
  }
  
  public void s(boolean paramBoolean)
  {
    if (!this.l) {
      t(paramBoolean);
    }
  }
  
  public void t(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    I(i1, 4);
  }
  
  public void u(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    I(i1, 8);
  }
  
  public void v(boolean paramBoolean)
  {
    this.z = paramBoolean;
    if (!paramBoolean)
    {
      h localh = this.y;
      if (localh != null) {
        localh.a();
      }
    }
  }
  
  public void w(CharSequence paramCharSequence)
  {
    this.f.setWindowTitle(paramCharSequence);
  }
  
  public void x()
  {
    if (this.u)
    {
      this.u = false;
      P(false);
    }
  }
  
  public b y(b.a parama)
  {
    d locald = this.m;
    if (locald != null) {
      locald.c();
    }
    this.d.setHideOnContentScrollEnabled(false);
    this.g.k();
    parama = new d(this.g.getContext(), parama);
    if (parama.t())
    {
      this.m = parama;
      parama.k();
      this.g.h(parama);
      z(true);
      return parama;
    }
    return null;
  }
  
  public void z(boolean paramBoolean)
  {
    if (paramBoolean) {
      O();
    } else {
      G();
    }
    if (N())
    {
      c0 localc02;
      c0 localc01;
      if (paramBoolean)
      {
        localc02 = this.f.t(4, 100L);
        localc01 = this.g.f(0, 200L);
      }
      else
      {
        localc01 = this.f.t(0, 200L);
        localc02 = this.g.f(8, 100L);
      }
      h localh = new h();
      localh.d(localc02, localc01);
      localh.h();
      return;
    }
    if (paramBoolean)
    {
      this.f.setVisibility(4);
      this.g.setVisibility(0);
      return;
    }
    this.f.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  class a
    extends e0
  {
    a() {}
    
    public void b(View paramView)
    {
      paramView = l.this;
      if (paramView.t)
      {
        paramView = paramView.h;
        if (paramView != null)
        {
          paramView.setTranslationY(0.0F);
          l.this.e.setTranslationY(0.0F);
        }
      }
      l.this.e.setVisibility(8);
      l.this.e.setTransitioning(false);
      paramView = l.this;
      paramView.y = null;
      paramView.B();
      paramView = l.this.d;
      if (paramView != null) {
        x.n0(paramView);
      }
    }
  }
  
  class b
    extends e0
  {
    b() {}
    
    public void b(View paramView)
    {
      paramView = l.this;
      paramView.y = null;
      paramView.e.requestLayout();
    }
  }
  
  class c
    implements f0
  {
    c() {}
    
    public void a(View paramView)
    {
      ((View)l.this.e.getParent()).invalidate();
    }
  }
  
  public class d
    extends b
    implements e.a
  {
    private final Context c;
    private final e d;
    private b.a e;
    private WeakReference<View> f;
    
    public d(Context paramContext, b.a parama)
    {
      this.c = paramContext;
      this.e = parama;
      this$1 = new e(paramContext).W(1);
      this.d = l.this;
      l.this.V(this);
    }
    
    public boolean a(e parame, MenuItem paramMenuItem)
    {
      parame = this.e;
      if (parame != null) {
        return parame.c(this, paramMenuItem);
      }
      return false;
    }
    
    public void b(e parame)
    {
      if (this.e == null) {
        return;
      }
      k();
      l.this.g.l();
    }
    
    public void c()
    {
      l locall = l.this;
      if (locall.m != this) {
        return;
      }
      if (!l.A(locall.u, locall.v, false))
      {
        locall = l.this;
        locall.n = this;
        locall.o = this.e;
      }
      else
      {
        this.e.d(this);
      }
      this.e = null;
      l.this.z(false);
      l.this.g.g();
      locall = l.this;
      locall.d.setHideOnContentScrollEnabled(locall.A);
      l.this.m = null;
    }
    
    public View d()
    {
      WeakReference localWeakReference = this.f;
      if (localWeakReference != null) {
        return (View)localWeakReference.get();
      }
      return null;
    }
    
    public Menu e()
    {
      return this.d;
    }
    
    public MenuInflater f()
    {
      return new g(this.c);
    }
    
    public CharSequence g()
    {
      return l.this.g.getSubtitle();
    }
    
    public CharSequence i()
    {
      return l.this.g.getTitle();
    }
    
    public void k()
    {
      if (l.this.m != this) {
        return;
      }
      this.d.h0();
      try
      {
        this.e.a(this, this.d);
        return;
      }
      finally
      {
        this.d.g0();
      }
    }
    
    public boolean l()
    {
      return l.this.g.j();
    }
    
    public void m(View paramView)
    {
      l.this.g.setCustomView(paramView);
      this.f = new WeakReference(paramView);
    }
    
    public void n(int paramInt)
    {
      o(l.this.a.getResources().getString(paramInt));
    }
    
    public void o(CharSequence paramCharSequence)
    {
      l.this.g.setSubtitle(paramCharSequence);
    }
    
    public void q(int paramInt)
    {
      r(l.this.a.getResources().getString(paramInt));
    }
    
    public void r(CharSequence paramCharSequence)
    {
      l.this.g.setTitle(paramCharSequence);
    }
    
    public void s(boolean paramBoolean)
    {
      super.s(paramBoolean);
      l.this.g.setTitleOptional(paramBoolean);
    }
    
    public boolean t()
    {
      this.d.h0();
      try
      {
        boolean bool = this.e.b(this, this.d);
        return bool;
      }
      finally
      {
        this.d.g0();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.l
 * JD-Core Version:    0.7.0.1
 */