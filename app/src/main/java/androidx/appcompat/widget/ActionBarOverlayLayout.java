package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.view.menu.j.a;
import androidx.core.view.h0;
import androidx.core.view.h0.b;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.x;
import q0.b;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout
  extends ViewGroup
  implements r, o, p
{
  static final int[] G = { R.attr.actionBarSize, 16842841 };
  ViewPropertyAnimator A;
  final AnimatorListenerAdapter B;
  private final Runnable C;
  private final Runnable E;
  private final q F;
  private int a;
  private int b = 0;
  private ContentFrameLayout c;
  ActionBarContainer d;
  private s e;
  private Drawable f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  boolean k;
  private int l;
  private int m;
  private final Rect n = new Rect();
  private final Rect o = new Rect();
  private final Rect p = new Rect();
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private h0 u;
  private h0 v;
  private h0 w;
  private h0 x;
  private d y;
  private OverScroller z;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = h0.b;
    this.u = paramAttributeSet;
    this.v = paramAttributeSet;
    this.w = paramAttributeSet;
    this.x = paramAttributeSet;
    this.B = new a();
    this.C = new b();
    this.E = new c();
    v(paramContext);
    this.F = new q(this);
  }
  
  private void A()
  {
    u();
    this.C.run();
  }
  
  private boolean B(float paramFloat)
  {
    this.z.fling(0, 0, 0, (int)paramFloat, 0, 0, -2147483648, 2147483647);
    return this.z.getFinalY() > this.d.getHeight();
  }
  
  private void p()
  {
    u();
    this.E.run();
  }
  
  private boolean q(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    int i1;
    int i2;
    if (paramBoolean1)
    {
      i1 = paramView.leftMargin;
      i2 = paramRect.left;
      if (i1 != i2)
      {
        paramView.leftMargin = i2;
        bool = true;
        break label46;
      }
    }
    boolean bool = false;
    label46:
    paramBoolean1 = bool;
    if (paramBoolean2)
    {
      i1 = paramView.topMargin;
      i2 = paramRect.top;
      paramBoolean1 = bool;
      if (i1 != i2)
      {
        paramView.topMargin = i2;
        paramBoolean1 = true;
      }
    }
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4)
    {
      i1 = paramView.rightMargin;
      i2 = paramRect.right;
      paramBoolean2 = paramBoolean1;
      if (i1 != i2)
      {
        paramView.rightMargin = i2;
        paramBoolean2 = true;
      }
    }
    if (paramBoolean3)
    {
      i1 = paramView.bottomMargin;
      i2 = paramRect.bottom;
      if (i1 != i2)
      {
        paramView.bottomMargin = i2;
        return true;
      }
    }
    return paramBoolean2;
  }
  
  private s t(View paramView)
  {
    if ((paramView instanceof s)) {
      return (s)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Can't make a decor toolbar out of ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void v(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(G);
    boolean bool2 = false;
    this.a = localTypedArray.getDimensionPixelSize(0, 0);
    Drawable localDrawable = localTypedArray.getDrawable(1);
    this.f = localDrawable;
    if (localDrawable == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    localTypedArray.recycle();
    boolean bool1 = bool2;
    if (paramContext.getApplicationInfo().targetSdkVersion < 19) {
      bool1 = true;
    }
    this.g = bool1;
    this.z = new OverScroller(paramContext);
  }
  
  private void x()
  {
    u();
    postDelayed(this.E, 600L);
  }
  
  private void y()
  {
    u();
    postDelayed(this.C, 600L);
  }
  
  public void a(Menu paramMenu, j.a parama)
  {
    z();
    this.e.a(paramMenu, parama);
  }
  
  public boolean b()
  {
    z();
    return this.e.b();
  }
  
  public void c(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      onNestedScrollAccepted(paramView1, paramView2, paramInt1);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void d()
  {
    z();
    this.e.d();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.f != null) && (!this.g))
    {
      int i1;
      if (this.d.getVisibility() == 0) {
        i1 = (int)(this.d.getBottom() + this.d.getTranslationY() + 0.5F);
      } else {
        i1 = 0;
      }
      this.f.setBounds(0, i1, getWidth(), this.f.getIntrinsicHeight() + i1);
      this.f.draw(paramCanvas);
    }
  }
  
  public boolean e()
  {
    z();
    return this.e.e();
  }
  
  public boolean f()
  {
    z();
    return this.e.f();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    return super.fitSystemWindows(paramRect);
  }
  
  public boolean g()
  {
    z();
    return this.e.g();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = this.d;
    if (localActionBarContainer != null) {
      return -(int)localActionBarContainer.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.F.a();
  }
  
  public CharSequence getTitle()
  {
    z();
    return this.e.getTitle();
  }
  
  public boolean h()
  {
    z();
    return this.e.h();
  }
  
  public void i(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      onStopNestedScroll(paramView);
    }
  }
  
  public void j(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 0) {
      onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfInt);
    }
  }
  
  public void k(int paramInt)
  {
    z();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 109) {
          return;
        }
        setOverlayMode(true);
        return;
      }
      this.e.v();
      return;
    }
    this.e.u();
  }
  
  public void l()
  {
    z();
    this.e.i();
  }
  
  public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    n(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean o(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt2 == 0) && (onStartNestedScroll(paramView1, paramView2, paramInt1));
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    z();
    paramWindowInsets = h0.x(paramWindowInsets, this);
    Object localObject = new Rect(paramWindowInsets.j(), paramWindowInsets.l(), paramWindowInsets.k(), paramWindowInsets.i());
    boolean bool1 = q(this.d, (Rect)localObject, true, true, false, true);
    x.f(this, paramWindowInsets, this.n);
    localObject = this.n;
    localObject = paramWindowInsets.n(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
    this.u = ((h0)localObject);
    boolean bool3 = this.v.equals(localObject);
    boolean bool2 = true;
    if (!bool3)
    {
      this.v = this.u;
      bool1 = true;
    }
    if (!this.o.equals(this.n))
    {
      this.o.set(this.n);
      bool1 = bool2;
    }
    if (bool1) {
      requestLayout();
    }
    return paramWindowInsets.a().c().b().v();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    v(getContext());
    x.n0(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    u();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = localLayoutParams.leftMargin + paramInt3;
        int i4 = localLayoutParams.topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    z();
    measureChildWithMargins(this.d, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.d.getLayoutParams();
    int i6 = Math.max(0, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
    int i5 = Math.max(0, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    int i4 = View.combineMeasuredStates(0, this.d.getMeasuredState());
    if ((x.M(this) & 0x100) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0)
    {
      i3 = this.a;
      i1 = i3;
      if (this.i)
      {
        i1 = i3;
        if (this.d.getTabContainer() != null) {
          i1 = i3 + this.a;
        }
      }
    }
    else if (this.d.getVisibility() != 8)
    {
      i1 = this.d.getMeasuredHeight();
    }
    else
    {
      i1 = 0;
    }
    this.p.set(this.n);
    localObject = this.u;
    this.w = ((h0)localObject);
    if ((!this.h) && (i2 == 0))
    {
      Rect localRect = this.p;
      localRect.top += i1;
      localRect.bottom += 0;
      localObject = ((h0)localObject).n(0, i1, 0, 0);
    }
    else
    {
      localObject = b.b(((h0)localObject).j(), this.w.l() + i1, this.w.k(), this.w.i() + 0);
      localObject = new h0.b(this.w).c((b)localObject).a();
    }
    this.w = ((h0)localObject);
    q(this.c, this.p, true, true, true, true);
    if (!this.x.equals(this.w))
    {
      localObject = this.w;
      this.x = ((h0)localObject);
      x.g(this.c, (h0)localObject);
    }
    measureChildWithMargins(this.c, paramInt1, 0, paramInt2, 0);
    localObject = (LayoutParams)this.c.getLayoutParams();
    int i1 = Math.max(i6, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
    int i2 = Math.max(i5, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
    int i3 = View.combineMeasuredStates(i4, this.c.getMeasuredState());
    i4 = getPaddingLeft();
    i5 = getPaddingRight();
    i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), View.resolveSizeAndState(i2, paramInt2, i3 << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((this.j) && (paramBoolean))
    {
      if (B(paramFloat2)) {
        p();
      } else {
        A();
      }
      this.k = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.l + paramInt2;
    this.l = paramInt1;
    setActionBarHideOffset(paramInt1);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.F.b(paramView1, paramView2, paramInt);
    this.l = getActionBarHideOffset();
    u();
    paramView1 = this.y;
    if (paramView1 != null) {
      paramView1.b();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (this.d.getVisibility() == 0)) {
      return this.j;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.j) && (!this.k)) {
      if (this.l <= this.d.getHeight()) {
        y();
      } else {
        x();
      }
    }
    paramView = this.y;
    if (paramView != null) {
      paramView.d();
    }
  }
  
  @Deprecated
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    super.onWindowSystemUiVisibilityChanged(paramInt);
    z();
    int i3 = this.m;
    this.m = paramInt;
    int i2 = 0;
    int i1;
    if ((paramInt & 0x4) == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt & 0x100) != 0) {
      i2 = 1;
    }
    d locald = this.y;
    if (locald != null)
    {
      locald.e(i2 ^ 0x1);
      if ((i1 == 0) && (i2 != 0)) {
        this.y.f();
      } else {
        this.y.a();
      }
    }
    if ((((i3 ^ paramInt) & 0x100) != 0) && (this.y != null)) {
      x.n0(this);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.b = paramInt;
    d locald = this.y;
    if (locald != null) {
      locald.c(paramInt);
    }
  }
  
  protected LayoutParams r()
  {
    return new LayoutParams(-1, -1);
  }
  
  public LayoutParams s(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    u();
    paramInt = Math.max(0, Math.min(paramInt, this.d.getHeight()));
    this.d.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(d paramd)
  {
    this.y = paramd;
    if (getWindowToken() != null)
    {
      this.y.c(this.b);
      int i1 = this.m;
      if (i1 != 0)
      {
        onWindowSystemUiVisibilityChanged(i1);
        x.n0(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.j)
    {
      this.j = paramBoolean;
      if (!paramBoolean)
      {
        u();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    z();
    this.e.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    z();
    this.e.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    z();
    this.e.r(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.g = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    z();
    this.e.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    z();
    this.e.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  void u()
  {
    removeCallbacks(this.C);
    removeCallbacks(this.E);
    ViewPropertyAnimator localViewPropertyAnimator = this.A;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public boolean w()
  {
    return this.h;
  }
  
  void z()
  {
    if (this.c == null)
    {
      this.c = ((ContentFrameLayout)findViewById(R.id.action_bar_activity_content));
      this.d = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      this.e = t(findViewById(R.id.action_bar));
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramAnimator = ActionBarOverlayLayout.this;
      paramAnimator.A = null;
      paramAnimator.k = false;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramAnimator = ActionBarOverlayLayout.this;
      paramAnimator.A = null;
      paramAnimator.k = false;
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      ActionBarOverlayLayout.this.u();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.A = localActionBarOverlayLayout.d.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.B);
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      ActionBarOverlayLayout.this.u();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.A = localActionBarOverlayLayout.d.animate().translationY(-ActionBarOverlayLayout.this.d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c(int paramInt);
    
    public abstract void d();
    
    public abstract void e(boolean paramBoolean);
    
    public abstract void f();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */