package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.n0;
import androidx.core.view.v;
import androidx.core.view.x;
import androidx.core.widget.l;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.e;
import androidx.viewpager.widget.ViewPager.h;
import androidx.viewpager.widget.ViewPager.i;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import r7.i;
import x0.e;
import x0.f;
import x0.g;
import y0.d;
import y0.d.a;
import y0.d.b;
import y0.d.c;

@ViewPager.e
public class TabLayout
  extends HorizontalScrollView
{
  private static final int S = R.style.Widget_Design_TabLayout;
  private static final e<g> T = new g(16);
  boolean A;
  boolean B;
  int C = -1;
  int E;
  boolean F;
  private c G;
  private c H;
  private final ArrayList<c> I = new ArrayList();
  private c J;
  private ValueAnimator K;
  ViewPager L;
  private androidx.viewpager.widget.a M;
  private DataSetObserver N;
  private h O;
  private b P;
  private boolean Q;
  private final e<i> R = new f(12);
  private final ArrayList<g> a = new ArrayList();
  private g b;
  final f c;
  int d;
  int e;
  int f;
  int g;
  int h;
  ColorStateList i;
  ColorStateList j;
  ColorStateList k;
  Drawable l = new GradientDrawable();
  private int m = 0;
  PorterDuff.Mode n;
  float o;
  float p;
  final int q;
  int r = 2147483647;
  private final int s;
  private final int t;
  private final int u;
  private int v;
  int w;
  int x;
  int y;
  int z;
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i2), paramAttributeSet, paramInt);
    paramContext = getContext();
    setHorizontalScrollBarEnabled(false);
    Object localObject1 = new f(paramContext);
    this.c = ((f)localObject1);
    super.addView((View)localObject1, 0, new FrameLayout.LayoutParams(-2, -1));
    Object localObject2 = com.google.android.material.R.styleable.TabLayout;
    int i1 = com.google.android.material.R.styleable.TabLayout_tabTextAppearance;
    paramAttributeSet = p.h(paramContext, paramAttributeSet, (int[])localObject2, paramInt, i2, new int[] { i1 });
    if ((getBackground() instanceof ColorDrawable))
    {
      localObject2 = (ColorDrawable)getBackground();
      r7.h localh = new r7.h();
      localh.b0(ColorStateList.valueOf(((ColorDrawable)localObject2).getColor()));
      localh.Q(paramContext);
      localh.a0(x.w(this));
      x.u0(this, localh);
    }
    setSelectedTabIndicator(o7.c.e(paramContext, paramAttributeSet, com.google.android.material.R.styleable.TabLayout_tabIndicator));
    setSelectedTabIndicatorColor(paramAttributeSet.getColor(com.google.android.material.R.styleable.TabLayout_tabIndicatorColor, 0));
    ((f)localObject1).g(paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabIndicatorHeight, -1));
    setSelectedTabIndicatorGravity(paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorAnimationMode(paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
    setTabIndicatorFullWidth(paramAttributeSet.getBoolean(com.google.android.material.R.styleable.TabLayout_tabIndicatorFullWidth, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPadding, 0);
    this.g = paramInt;
    this.f = paramInt;
    this.e = paramInt;
    this.d = paramInt;
    this.d = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingStart, paramInt);
    this.e = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingTop, this.e);
    this.f = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingEnd, this.f);
    this.g = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabPaddingBottom, this.g);
    paramInt = paramAttributeSet.getResourceId(i1, R.style.TextAppearance_Design_Tab);
    this.h = paramInt;
    localObject1 = paramContext.obtainStyledAttributes(paramInt, androidx.appcompat.R.styleable.TextAppearance);
    try
    {
      this.o = ((TypedArray)localObject1).getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      this.i = o7.c.a(paramContext, (TypedArray)localObject1, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
      ((TypedArray)localObject1).recycle();
      paramInt = com.google.android.material.R.styleable.TabLayout_tabTextColor;
      if (paramAttributeSet.hasValue(paramInt)) {
        this.i = o7.c.a(paramContext, paramAttributeSet, paramInt);
      }
      paramInt = com.google.android.material.R.styleable.TabLayout_tabSelectedTextColor;
      if (paramAttributeSet.hasValue(paramInt))
      {
        paramInt = paramAttributeSet.getColor(paramInt, 0);
        this.i = o(this.i.getDefaultColor(), paramInt);
      }
      this.j = o7.c.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.TabLayout_tabIconTint);
      this.n = t.j(paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabIconTintMode, -1), null);
      this.k = o7.c.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.TabLayout_tabRippleColor);
      this.x = paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
      this.s = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMinWidth, -1);
      this.t = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabMaxWidth, -1);
      this.q = paramAttributeSet.getResourceId(com.google.android.material.R.styleable.TabLayout_tabBackground, 0);
      this.v = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.TabLayout_tabContentStart, 0);
      this.z = paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabMode, 1);
      this.w = paramAttributeSet.getInt(com.google.android.material.R.styleable.TabLayout_tabGravity, 0);
      this.A = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.TabLayout_tabInlineLabel, false);
      this.F = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.TabLayout_tabUnboundedRipple, false);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.p = paramContext.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.u = paramContext.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      l();
      return;
    }
    finally
    {
      ((TypedArray)localObject1).recycle();
    }
  }
  
  private void E(int paramInt)
  {
    i locali = (i)this.c.getChildAt(paramInt);
    this.c.removeViewAt(paramInt);
    if (locali != null)
    {
      locali.o();
      this.R.a(locali);
    }
    requestLayout();
  }
  
  private void L(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.L;
    if (localObject != null)
    {
      h localh = this.O;
      if (localh != null) {
        ((ViewPager)localObject).J(localh);
      }
      localObject = this.P;
      if (localObject != null) {
        this.L.I((ViewPager.h)localObject);
      }
    }
    localObject = this.J;
    if (localObject != null)
    {
      D((c)localObject);
      this.J = null;
    }
    if (paramViewPager != null)
    {
      this.L = paramViewPager;
      if (this.O == null) {
        this.O = new h(this);
      }
      this.O.a();
      paramViewPager.c(this.O);
      localObject = new j(paramViewPager);
      this.J = ((c)localObject);
      c((c)localObject);
      localObject = paramViewPager.getAdapter();
      if (localObject != null) {
        H((androidx.viewpager.widget.a)localObject, paramBoolean1);
      }
      if (this.P == null) {
        this.P = new b();
      }
      this.P.b(paramBoolean1);
      paramViewPager.b(this.P);
      I(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.L = null;
      H(null, false);
    }
    this.Q = paramBoolean2;
  }
  
  private void M()
  {
    int i2 = this.a.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((g)this.a.get(i1)).s();
      i1 += 1;
    }
  }
  
  private void N(LinearLayout.LayoutParams paramLayoutParams)
  {
    float f1;
    if ((this.z == 1) && (this.w == 0))
    {
      paramLayoutParams.width = 0;
      f1 = 1.0F;
    }
    else
    {
      paramLayoutParams.width = -2;
      f1 = 0.0F;
    }
    paramLayoutParams.weight = f1;
  }
  
  private void g(TabItem paramTabItem)
  {
    g localg = z();
    Object localObject = paramTabItem.a;
    if (localObject != null) {
      localg.r((CharSequence)localObject);
    }
    localObject = paramTabItem.b;
    if (localObject != null) {
      localg.p((Drawable)localObject);
    }
    int i1 = paramTabItem.c;
    if (i1 != 0) {
      localg.n(i1);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localg.m(paramTabItem.getContentDescription());
    }
    d(localg);
  }
  
  private int getDefaultHeight()
  {
    int i4 = this.a.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      g localg = (g)this.a.get(i1);
      if ((localg != null) && (localg.f() != null) && (!TextUtils.isEmpty(localg.i())))
      {
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if ((i2 != 0) && (!this.A)) {
      return 72;
    }
    return 48;
  }
  
  private int getTabMinWidth()
  {
    int i1 = this.s;
    if (i1 != -1) {
      return i1;
    }
    i1 = this.z;
    if ((i1 != 0) && (i1 != 2)) {
      return 0;
    }
    return this.u;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.c.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void h(g paramg)
  {
    i locali = paramg.i;
    locali.setSelected(false);
    locali.setActivated(false);
    this.c.addView(locali, paramg.g(), p());
  }
  
  private void i(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      g((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void j(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (x.U(this)) && (!this.c.d()))
    {
      int i1 = getScrollX();
      int i2 = m(paramInt, 0.0F);
      if (i1 != i2)
      {
        v();
        this.K.setIntValues(new int[] { i1, i2 });
        this.K.start();
      }
      this.c.c(paramInt, this.x);
      return;
    }
    I(paramInt, 0.0F, true);
  }
  
  private void k(int paramInt)
  {
    if (paramInt != 0)
    {
      int i1 = 1;
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else
      {
        localf = this.c;
        paramInt = i1;
        break label46;
      }
    }
    else
    {
      Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    }
    f localf = this.c;
    paramInt = 8388611;
    label46:
    localf.setGravity(paramInt);
  }
  
  private void l()
  {
    int i1 = this.z;
    if ((i1 != 0) && (i1 != 2)) {
      i1 = 0;
    } else {
      i1 = Math.max(0, this.v - this.d);
    }
    x.F0(this.c, i1, 0, 0, 0);
    i1 = this.z;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 2))
      {
        if (this.w == 2) {
          Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
        }
        this.c.setGravity(1);
      }
    }
    else {
      k(this.w);
    }
    O(true);
  }
  
  private int m(int paramInt, float paramFloat)
  {
    int i2 = this.z;
    int i1 = 0;
    if ((i2 != 0) && (i2 != 2)) {
      return 0;
    }
    View localView2 = this.c.getChildAt(paramInt);
    if (localView2 == null) {
      return 0;
    }
    paramInt += 1;
    View localView1;
    if (paramInt < this.c.getChildCount()) {
      localView1 = this.c.getChildAt(paramInt);
    } else {
      localView1 = null;
    }
    i2 = localView2.getWidth();
    paramInt = i1;
    if (localView1 != null) {
      paramInt = localView1.getWidth();
    }
    i1 = localView2.getLeft() + i2 / 2 - getWidth() / 2;
    paramInt = (int)((i2 + paramInt) * 0.5F * paramFloat);
    if (x.B(this) == 0) {
      return i1 + paramInt;
    }
    return i1 - paramInt;
  }
  
  private void n(g paramg, int paramInt)
  {
    paramg.q(paramInt);
    this.a.add(paramInt, paramg);
    int i1 = this.a.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i1) {
        break;
      }
      ((g)this.a.get(paramInt)).q(paramInt);
    }
  }
  
  private static ColorStateList o(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private LinearLayout.LayoutParams p()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    N(localLayoutParams);
    return localLayoutParams;
  }
  
  private i r(g paramg)
  {
    Object localObject1 = this.R;
    if (localObject1 != null) {
      localObject1 = (i)((e)localObject1).b();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new i(getContext());
    }
    ((i)localObject2).setTab(paramg);
    ((LinearLayout)localObject2).setFocusable(true);
    ((LinearLayout)localObject2).setMinimumWidth(getTabMinWidth());
    if (TextUtils.isEmpty(g.c(paramg))) {
      paramg = g.d(paramg);
    } else {
      paramg = g.c(paramg);
    }
    ((LinearLayout)localObject2).setContentDescription(paramg);
    return localObject2;
  }
  
  private void s(g paramg)
  {
    int i1 = this.I.size() - 1;
    while (i1 >= 0)
    {
      ((c)this.I.get(i1)).a(paramg);
      i1 -= 1;
    }
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int i2 = this.c.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.c.getChildAt(i1);
        boolean bool2 = true;
        boolean bool1;
        if (i1 == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView.setSelected(bool1);
        if (i1 == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localView.setActivated(bool1);
        i1 += 1;
      }
    }
  }
  
  private void t(g paramg)
  {
    int i1 = this.I.size() - 1;
    while (i1 >= 0)
    {
      ((c)this.I.get(i1)).c(paramg);
      i1 -= 1;
    }
  }
  
  private void u(g paramg)
  {
    int i1 = this.I.size() - 1;
    while (i1 >= 0)
    {
      ((c)this.I.get(i1)).b(paramg);
      i1 -= 1;
    }
  }
  
  private void v()
  {
    if (this.K == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      this.K = localValueAnimator;
      localValueAnimator.setInterpolator(e7.a.b);
      this.K.setDuration(this.x);
      this.K.addUpdateListener(new a());
    }
  }
  
  private boolean x()
  {
    return (getTabMode() == 0) || (getTabMode() == 2);
  }
  
  void A()
  {
    C();
    Object localObject = this.M;
    if (localObject != null)
    {
      int i2 = ((androidx.viewpager.widget.a)localObject).e();
      int i1 = 0;
      while (i1 < i2)
      {
        f(z().r(this.M.g(i1)), false);
        i1 += 1;
      }
      localObject = this.L;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPager)localObject).getCurrentItem();
        if ((i1 != getSelectedTabPosition()) && (i1 < getTabCount())) {
          F(w(i1));
        }
      }
    }
  }
  
  protected boolean B(g paramg)
  {
    return T.a(paramg);
  }
  
  public void C()
  {
    int i1 = this.c.getChildCount() - 1;
    while (i1 >= 0)
    {
      E(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      localIterator.remove();
      localg.k();
      B(localg);
    }
    this.b = null;
  }
  
  @Deprecated
  public void D(c paramc)
  {
    this.I.remove(paramc);
  }
  
  public void F(g paramg)
  {
    G(paramg, true);
  }
  
  public void G(g paramg, boolean paramBoolean)
  {
    g localg = this.b;
    if (localg == paramg)
    {
      if (localg != null)
      {
        s(paramg);
        j(paramg.g());
      }
    }
    else
    {
      int i1;
      if (paramg != null) {
        i1 = paramg.g();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localg == null) || (localg.g() == -1)) && (i1 != -1)) {
          I(i1, 0.0F, true);
        } else {
          j(i1);
        }
        if (i1 != -1) {
          setSelectedTabView(i1);
        }
      }
      this.b = paramg;
      if (localg != null) {
        u(localg);
      }
      if (paramg != null) {
        t(paramg);
      }
    }
  }
  
  void H(androidx.viewpager.widget.a parama, boolean paramBoolean)
  {
    androidx.viewpager.widget.a locala = this.M;
    if (locala != null)
    {
      DataSetObserver localDataSetObserver = this.N;
      if (localDataSetObserver != null) {
        locala.t(localDataSetObserver);
      }
    }
    this.M = parama;
    if ((paramBoolean) && (parama != null))
    {
      if (this.N == null) {
        this.N = new e();
      }
      parama.l(this.N);
    }
    A();
  }
  
  public void I(int paramInt, float paramFloat, boolean paramBoolean)
  {
    J(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void J(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if (i1 >= 0)
    {
      if (i1 >= this.c.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.c.f(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = this.K;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.K.cancel();
      }
      if (paramInt < 0) {
        paramInt = 0;
      } else {
        paramInt = m(paramInt, paramFloat);
      }
      scrollTo(paramInt, 0);
      if (paramBoolean1) {
        setSelectedTabView(i1);
      }
    }
  }
  
  public void K(ViewPager paramViewPager, boolean paramBoolean)
  {
    L(paramViewPager, paramBoolean, false);
  }
  
  void O(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      View localView = this.c.getChildAt(i1);
      localView.setMinimumWidth(getTabMinWidth());
      N((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView)
  {
    i(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    i(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    i(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    i(paramView);
  }
  
  @Deprecated
  public void c(c paramc)
  {
    if (!this.I.contains(paramc)) {
      this.I.add(paramc);
    }
  }
  
  public void d(g paramg)
  {
    f(paramg, this.a.isEmpty());
  }
  
  public void e(g paramg, int paramInt, boolean paramBoolean)
  {
    if (paramg.h == this)
    {
      n(paramg, paramInt);
      h(paramg);
      if (paramBoolean) {
        paramg.l();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void f(g paramg, boolean paramBoolean)
  {
    e(paramg, this.a.size(), paramBoolean);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    g localg = this.b;
    if (localg != null) {
      return localg.g();
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.a.size();
  }
  
  public int getTabGravity()
  {
    return this.w;
  }
  
  public ColorStateList getTabIconTint()
  {
    return this.j;
  }
  
  public int getTabIndicatorAnimationMode()
  {
    return this.E;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.y;
  }
  
  int getTabMaxWidth()
  {
    return this.r;
  }
  
  public int getTabMode()
  {
    return this.z;
  }
  
  public ColorStateList getTabRippleColor()
  {
    return this.k;
  }
  
  public Drawable getTabSelectedIndicator()
  {
    return this.l;
  }
  
  public ColorStateList getTabTextColors()
  {
    return this.i;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.e(this);
    if (this.L == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        L((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Q)
    {
      setupWithViewPager(null);
      this.Q = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i1 = 0;
    while (i1 < this.c.getChildCount())
    {
      View localView = this.c.getChildAt(i1);
      if ((localView instanceof i)) {
        i.c((i)localView, paramCanvas);
      }
      i1 += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    d.J0(paramAccessibilityNodeInfo).e0(d.b.b(1, getTabCount(), false, 1));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (x()) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = Math.round(t.c(getContext(), getDefaultHeight()));
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = 0;
    if (i1 != -2147483648)
    {
      if (i1 != 0) {
        i1 = paramInt2;
      } else {
        i1 = View.MeasureSpec.makeMeasureSpec(i3 + getPaddingTop() + getPaddingBottom(), 1073741824);
      }
    }
    else
    {
      i1 = paramInt2;
      if (getChildCount() == 1)
      {
        i1 = paramInt2;
        if (View.MeasureSpec.getSize(paramInt2) >= i3)
        {
          getChildAt(0).setMinimumHeight(i3);
          i1 = paramInt2;
        }
      }
    }
    i3 = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      paramInt2 = this.t;
      if (paramInt2 <= 0) {
        paramInt2 = (int)(i3 - t.c(getContext(), 56));
      }
      this.r = paramInt2;
    }
    super.onMeasure(paramInt1, i1);
    if (getChildCount() == 1)
    {
      View localView = getChildAt(0);
      paramInt1 = this.z;
      if (paramInt1 != 0) {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramInt1 = i2;
            break label224;
          }
        }
        else
        {
          paramInt1 = i2;
          if (localView.getMeasuredWidth() == getMeasuredWidth()) {
            break label224;
          }
        }
      }
      do
      {
        paramInt1 = 1;
        break;
        paramInt1 = i2;
      } while (localView.getMeasuredWidth() < getMeasuredWidth());
      label224:
      if (paramInt1 != 0)
      {
        paramInt1 = HorizontalScrollView.getChildMeasureSpec(i1, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getActionMasked() == 8) && (!x())) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected g q()
  {
    g localg2 = (g)T.b();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = new g();
    }
    return localg1;
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    i.d(this, paramFloat);
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.A != paramBoolean)
    {
      this.A = paramBoolean;
      int i1 = 0;
      while (i1 < this.c.getChildCount())
      {
        View localView = this.c.getChildAt(i1);
        if ((localView instanceof i)) {
          ((i)localView).v();
        }
        i1 += 1;
      }
      l();
    }
  }
  
  public void setInlineLabelResource(int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(c paramc)
  {
    c localc = this.H;
    if (localc != null) {
      D(localc);
    }
    this.H = paramc;
    if (paramc != null) {
      c(paramc);
    }
  }
  
  @Deprecated
  public void setOnTabSelectedListener(d paramd)
  {
    setOnTabSelectedListener(paramd);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    v();
    this.K.addListener(paramAnimatorListener);
  }
  
  public void setSelectedTabIndicator(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setSelectedTabIndicator(localDrawable);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable)
  {
    if (this.l != paramDrawable)
    {
      if (paramDrawable == null) {
        paramDrawable = new GradientDrawable();
      }
      this.l = paramDrawable;
      int i1 = this.C;
      if (i1 == -1) {
        i1 = paramDrawable.getIntrinsicHeight();
      }
      this.c.g(i1);
    }
  }
  
  public void setSelectedTabIndicatorColor(int paramInt)
  {
    this.m = paramInt;
    O(false);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.y != paramInt)
    {
      this.y = paramInt;
      x.h0(this.c);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.C = paramInt;
    this.c.g(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.w != paramInt)
    {
      this.w = paramInt;
      l();
    }
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList)
  {
    if (this.j != paramColorStateList)
    {
      this.j = paramColorStateList;
      M();
    }
  }
  
  public void setTabIconTintResource(int paramInt)
  {
    setTabIconTint(c.a.a(getContext(), paramInt));
  }
  
  public void setTabIndicatorAnimationMode(int paramInt)
  {
    this.E = paramInt;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          localObject = new b();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" is not a valid TabIndicatorAnimationMode");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        localObject = new a();
      }
    }
    else {
      localObject = new c();
    }
    this.G = ((c)localObject);
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.B = paramBoolean;
    f.a(this.c);
    x.h0(this.c);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.z)
    {
      this.z = paramInt;
      l();
    }
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList)
  {
    if (this.k != paramColorStateList)
    {
      this.k = paramColorStateList;
      int i1 = 0;
      while (i1 < this.c.getChildCount())
      {
        paramColorStateList = this.c.getChildAt(i1);
        if ((paramColorStateList instanceof i)) {
          i.b((i)paramColorStateList, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(int paramInt)
  {
    setTabRippleColor(c.a.a(getContext(), paramInt));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList)
  {
    if (this.i != paramColorStateList)
    {
      this.i = paramColorStateList;
      M();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(androidx.viewpager.widget.a parama)
  {
    H(parama, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.F != paramBoolean)
    {
      this.F = paramBoolean;
      int i1 = 0;
      while (i1 < this.c.getChildCount())
      {
        View localView = this.c.getChildAt(i1);
        if ((localView instanceof i)) {
          i.b((i)localView, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(ViewPager paramViewPager)
  {
    K(paramViewPager, true);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
  
  public g w(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (g)this.a.get(paramInt);
    }
    return null;
  }
  
  public boolean y()
  {
    return this.B;
  }
  
  public g z()
  {
    g localg = q();
    localg.h = this;
    localg.i = r(localg);
    if (g.a(localg) != -1) {
      localg.i.setId(g.a(localg));
    }
    return localg;
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      TabLayout.this.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
    }
  }
  
  private class b
    implements ViewPager.h
  {
    private boolean a;
    
    b() {}
    
    public void a(ViewPager paramViewPager, androidx.viewpager.widget.a parama1, androidx.viewpager.widget.a parama2)
    {
      parama1 = TabLayout.this;
      if (parama1.L == paramViewPager) {
        parama1.H(parama2, this.a);
      }
    }
    
    void b(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
  
  @Deprecated
  public static abstract interface c<T extends TabLayout.g>
  {
    public abstract void a(T paramT);
    
    public abstract void b(T paramT);
    
    public abstract void c(T paramT);
  }
  
  public static abstract interface d
    extends TabLayout.c<TabLayout.g>
  {}
  
  private class e
    extends DataSetObserver
  {
    e() {}
    
    public void onChanged()
    {
      TabLayout.this.A();
    }
    
    public void onInvalidated()
    {
      TabLayout.this.A();
    }
  }
  
  class f
    extends LinearLayout
  {
    ValueAnimator a;
    int b = -1;
    float c;
    private int d = -1;
    
    f(Context paramContext)
    {
      super();
      setWillNotDraw(false);
    }
    
    private void e()
    {
      View localView = getChildAt(this.b);
      c localc = TabLayout.a(TabLayout.this);
      TabLayout localTabLayout = TabLayout.this;
      localc.c(localTabLayout, localView, localTabLayout.l);
    }
    
    private void h(View paramView1, View paramView2, float paramFloat)
    {
      int i;
      if ((paramView1 != null) && (paramView1.getWidth() > 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        c localc = TabLayout.a(TabLayout.this);
        TabLayout localTabLayout = TabLayout.this;
        localc.d(localTabLayout, paramView1, paramView2, paramFloat, localTabLayout.l);
      }
      else
      {
        paramView1 = TabLayout.this.l;
        paramView1.setBounds(-1, paramView1.getBounds().top, -1, TabLayout.this.l.getBounds().bottom);
      }
      x.h0(this);
    }
    
    private void i(boolean paramBoolean, final int paramInt1, int paramInt2)
    {
      Object localObject1 = getChildAt(this.b);
      Object localObject2 = getChildAt(paramInt1);
      if (localObject2 == null)
      {
        e();
        return;
      }
      localObject1 = new a((View)localObject1, (View)localObject2);
      if (paramBoolean)
      {
        localObject2 = new ValueAnimator();
        this.a = ((ValueAnimator)localObject2);
        ((ValueAnimator)localObject2).setInterpolator(e7.a.b);
        ((ValueAnimator)localObject2).setDuration(paramInt2);
        ((ValueAnimator)localObject2).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
        ((ValueAnimator)localObject2).addListener(new b(paramInt1));
        ((ValueAnimator)localObject2).start();
        return;
      }
      this.a.removeAllUpdateListeners();
      this.a.addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
    }
    
    void c(int paramInt1, int paramInt2)
    {
      ValueAnimator localValueAnimator = this.a;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.a.cancel();
      }
      i(true, paramInt1, paramInt2);
    }
    
    boolean d()
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).getWidth() <= 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public void draw(Canvas paramCanvas)
    {
      int j = TabLayout.this.l.getBounds().height();
      int i = j;
      if (j < 0) {
        i = TabLayout.this.l.getIntrinsicHeight();
      }
      int n = TabLayout.this.y;
      int k = 0;
      int m = 0;
      if (n != 0)
      {
        if (n != 1)
        {
          j = k;
          if (n == 2) {
            break label116;
          }
          j = m;
          if (n != 3)
          {
            i = 0;
            j = k;
            break label116;
          }
        }
        else
        {
          j = (getHeight() - i) / 2;
          i = (getHeight() + i) / 2;
          break label116;
        }
      }
      else {
        j = getHeight() - i;
      }
      i = getHeight();
      label116:
      if (TabLayout.this.l.getBounds().width() > 0)
      {
        Object localObject = TabLayout.this.l.getBounds();
        TabLayout.this.l.setBounds(((Rect)localObject).left, j, ((Rect)localObject).right, i);
        TabLayout localTabLayout = TabLayout.this;
        localObject = localTabLayout.l;
        if (TabLayout.b(localTabLayout) != 0)
        {
          localObject = r0.a.r((Drawable)localObject);
          r0.a.n((Drawable)localObject, TabLayout.b(TabLayout.this));
        }
        else
        {
          r0.a.o((Drawable)localObject, null);
        }
        ((Drawable)localObject).draw(paramCanvas);
      }
      super.draw(paramCanvas);
    }
    
    void f(int paramInt, float paramFloat)
    {
      ValueAnimator localValueAnimator = this.a;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.a.cancel();
      }
      this.b = paramInt;
      this.c = paramFloat;
      h(getChildAt(paramInt), getChildAt(this.b + 1), this.c);
    }
    
    void g(int paramInt)
    {
      Rect localRect = TabLayout.this.l.getBounds();
      TabLayout.this.l.setBounds(localRect.left, 0, localRect.right, paramInt);
      requestLayout();
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      ValueAnimator localValueAnimator = this.a;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning()))
      {
        i(false, this.b, -1);
        return;
      }
      e();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        return;
      }
      Object localObject = TabLayout.this;
      int i = ((TabLayout)localObject).w;
      int n = 1;
      if ((i == 1) || (((TabLayout)localObject).z == 2))
      {
        int i1 = getChildCount();
        int m = 0;
        i = 0;
        int k;
        for (int j = i; i < i1; j = k)
        {
          localObject = getChildAt(i);
          k = j;
          if (((View)localObject).getVisibility() == 0) {
            k = Math.max(j, ((View)localObject).getMeasuredWidth());
          }
          i += 1;
        }
        if (j <= 0) {
          return;
        }
        i = (int)t.c(getContext(), 16);
        if (j * i1 <= getMeasuredWidth() - i * 2)
        {
          i = 0;
          k = m;
          while (k < i1)
          {
            localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
            if ((((LinearLayout.LayoutParams)localObject).width != j) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
            {
              ((LinearLayout.LayoutParams)localObject).width = j;
              ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
              i = 1;
            }
            k += 1;
          }
        }
        else
        {
          localObject = TabLayout.this;
          ((TabLayout)localObject).w = 0;
          ((TabLayout)localObject).O(false);
          i = n;
        }
        if (i != 0) {
          super.onMeasure(paramInt1, paramInt2);
        }
      }
    }
    
    public void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
    }
    
    class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(View paramView1, View paramView2) {}
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        TabLayout.f.b(TabLayout.f.this, this.a, this.b, paramValueAnimator.getAnimatedFraction());
      }
    }
    
    class b
      extends AnimatorListenerAdapter
    {
      b(int paramInt) {}
      
      public void onAnimationEnd(Animator paramAnimator)
      {
        TabLayout.f.this.b = paramInt1;
      }
      
      public void onAnimationStart(Animator paramAnimator)
      {
        TabLayout.f.this.b = paramInt1;
      }
    }
  }
  
  public static class g
  {
    private Object a;
    private Drawable b;
    private CharSequence c;
    private CharSequence d;
    private int e = -1;
    private View f;
    private int g = 1;
    public TabLayout h;
    public TabLayout.i i;
    private int j = -1;
    
    public View e()
    {
      return this.f;
    }
    
    public Drawable f()
    {
      return this.b;
    }
    
    public int g()
    {
      return this.e;
    }
    
    public int h()
    {
      return this.g;
    }
    
    public CharSequence i()
    {
      return this.c;
    }
    
    public boolean j()
    {
      TabLayout localTabLayout = this.h;
      if (localTabLayout != null)
      {
        int k = localTabLayout.getSelectedTabPosition();
        return (k != -1) && (k == this.e);
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    void k()
    {
      this.h = null;
      this.i = null;
      this.a = null;
      this.b = null;
      this.j = -1;
      this.c = null;
      this.d = null;
      this.e = -1;
      this.f = null;
    }
    
    public void l()
    {
      TabLayout localTabLayout = this.h;
      if (localTabLayout != null)
      {
        localTabLayout.F(this);
        return;
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public g m(CharSequence paramCharSequence)
    {
      this.d = paramCharSequence;
      s();
      return this;
    }
    
    public g n(int paramInt)
    {
      return o(LayoutInflater.from(this.i.getContext()).inflate(paramInt, this.i, false));
    }
    
    public g o(View paramView)
    {
      this.f = paramView;
      s();
      return this;
    }
    
    public g p(Drawable paramDrawable)
    {
      this.b = paramDrawable;
      paramDrawable = this.h;
      if ((paramDrawable.w == 1) || (paramDrawable.z == 2)) {
        paramDrawable.O(true);
      }
      s();
      if ((com.google.android.material.badge.b.a) && (TabLayout.i.d(this.i)) && (TabLayout.i.e(this.i).isVisible())) {
        this.i.invalidate();
      }
      return this;
    }
    
    void q(int paramInt)
    {
      this.e = paramInt;
    }
    
    public g r(CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.i.setContentDescription(paramCharSequence);
      }
      this.c = paramCharSequence;
      s();
      return this;
    }
    
    void s()
    {
      TabLayout.i locali = this.i;
      if (locali != null) {
        locali.t();
      }
    }
  }
  
  public static class h
    implements ViewPager.i
  {
    private final WeakReference<TabLayout> a;
    private int b;
    private int c;
    
    public h(TabLayout paramTabLayout)
    {
      this.a = new WeakReference(paramTabLayout);
    }
    
    public void D(int paramInt)
    {
      this.b = this.c;
      this.c = paramInt;
    }
    
    public void J(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.a.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount()))
      {
        int i = this.c;
        boolean bool;
        if ((i != 0) && ((i != 2) || (this.b != 0))) {
          bool = false;
        } else {
          bool = true;
        }
        localTabLayout.G(localTabLayout.w(paramInt), bool);
      }
    }
    
    void a()
    {
      this.c = 0;
      this.b = 0;
    }
    
    public void s(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)this.a.get();
      if (localTabLayout != null)
      {
        paramInt2 = this.c;
        boolean bool2 = false;
        boolean bool1;
        if ((paramInt2 == 2) && (this.b != 1)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if ((paramInt2 != 2) || (this.b != 0)) {
          bool2 = true;
        }
        localTabLayout.J(paramInt1, paramFloat, bool1, bool2);
      }
    }
  }
  
  public final class i
    extends LinearLayout
  {
    private TabLayout.g a;
    private TextView b;
    private ImageView c;
    private View d;
    private com.google.android.material.badge.a e;
    private View f;
    private TextView g;
    private ImageView h;
    private Drawable i;
    private int j = 2;
    
    public i(Context paramContext)
    {
      super();
      u(paramContext);
      x.F0(this, TabLayout.this.d, TabLayout.this.e, TabLayout.this.f, TabLayout.this.g);
      setGravity(17);
      setOrientation(TabLayout.this.A ^ true);
      setClickable(true);
      x.G0(this, v.b(getContext(), 1002));
    }
    
    private void f(final View paramView)
    {
      if (paramView == null) {
        return;
      }
      paramView.addOnLayoutChangeListener(new a(paramView));
    }
    
    private float g(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }
    
    private com.google.android.material.badge.a getBadge()
    {
      return this.e;
    }
    
    private com.google.android.material.badge.a getOrCreateBadge()
    {
      if (this.e == null) {
        this.e = com.google.android.material.badge.a.c(getContext());
      }
      r();
      com.google.android.material.badge.a locala = this.e;
      if (locala != null) {
        return locala;
      }
      throw new IllegalStateException("Unable to create badge");
    }
    
    private void h(boolean paramBoolean)
    {
      setClipChildren(paramBoolean);
      setClipToPadding(paramBoolean);
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup != null)
      {
        localViewGroup.setClipChildren(paramBoolean);
        localViewGroup.setClipToPadding(paramBoolean);
      }
    }
    
    private FrameLayout i()
    {
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      return localFrameLayout;
    }
    
    private void j(Canvas paramCanvas)
    {
      Drawable localDrawable = this.i;
      if (localDrawable != null)
      {
        localDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.i.draw(paramCanvas);
      }
    }
    
    private FrameLayout k(View paramView)
    {
      ImageView localImageView = this.c;
      FrameLayout localFrameLayout = null;
      if ((paramView != localImageView) && (paramView != this.b)) {
        return null;
      }
      if (com.google.android.material.badge.b.a) {
        localFrameLayout = (FrameLayout)paramView.getParent();
      }
      return localFrameLayout;
    }
    
    private boolean l()
    {
      return this.e != null;
    }
    
    private void m()
    {
      Object localObject;
      if (com.google.android.material.badge.b.a)
      {
        localObject = i();
        addView((View)localObject, 0);
      }
      else
      {
        localObject = this;
      }
      ImageView localImageView = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup)localObject, false);
      this.c = localImageView;
      ((ViewGroup)localObject).addView(localImageView, 0);
    }
    
    private void n()
    {
      Object localObject;
      if (com.google.android.material.badge.b.a)
      {
        localObject = i();
        addView((View)localObject);
      }
      else
      {
        localObject = this;
      }
      TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup)localObject, false);
      this.b = localTextView;
      ((ViewGroup)localObject).addView(localTextView);
    }
    
    private void p(View paramView)
    {
      if (!l()) {
        return;
      }
      if (paramView != null)
      {
        h(false);
        com.google.android.material.badge.b.a(this.e, paramView, k(paramView));
        this.d = paramView;
      }
    }
    
    private void q()
    {
      if (!l()) {
        return;
      }
      h(true);
      View localView = this.d;
      if (localView != null)
      {
        com.google.android.material.badge.b.d(this.e, localView);
        this.d = null;
      }
    }
    
    private void r()
    {
      if (!l()) {
        return;
      }
      if (this.f != null)
      {
        q();
        return;
      }
      View localView;
      Object localObject2;
      if (this.c != null)
      {
        localObject1 = this.a;
        if ((localObject1 != null) && (((TabLayout.g)localObject1).f() != null))
        {
          localView = this.d;
          localObject2 = this.c;
          localObject1 = localObject2;
          if (localView != localObject2) {
            q();
          }
        }
      }
      for (Object localObject1 = this.c;; localObject1 = this.b)
      {
        p((View)localObject1);
        return;
        do
        {
          s((View)localObject1);
          return;
          if (this.b == null) {
            break;
          }
          localObject1 = this.a;
          if ((localObject1 == null) || (((TabLayout.g)localObject1).h() != 1)) {
            break;
          }
          localView = this.d;
          localObject2 = this.b;
          localObject1 = localObject2;
        } while (localView == localObject2);
        q();
      }
    }
    
    private void s(View paramView)
    {
      if ((l()) && (paramView == this.d)) {
        com.google.android.material.badge.b.e(this.e, paramView, k(paramView));
      }
    }
    
    private void u(Context paramContext)
    {
      int m = TabLayout.this.q;
      Object localObject2 = null;
      if (m != 0)
      {
        paramContext = c.a.b(paramContext, m);
        this.i = paramContext;
        if ((paramContext != null) && (paramContext.isStateful())) {
          this.i.setState(getDrawableState());
        }
      }
      else
      {
        this.i = null;
      }
      paramContext = new GradientDrawable();
      paramContext.setColor(0);
      Object localObject1 = paramContext;
      if (TabLayout.this.k != null)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setCornerRadius(1.0E-005F);
        ((GradientDrawable)localObject1).setColor(-1);
        ColorStateList localColorStateList = p7.b.a(TabLayout.this.k);
        boolean bool = TabLayout.this.F;
        if (bool) {
          paramContext = null;
        }
        if (bool) {
          localObject1 = localObject2;
        }
        localObject1 = new RippleDrawable(localColorStateList, paramContext, (Drawable)localObject1);
      }
      x.u0(this, (Drawable)localObject1);
      TabLayout.this.invalidate();
    }
    
    private void w(TextView paramTextView, ImageView paramImageView)
    {
      Object localObject1 = this.a;
      Object localObject2 = null;
      Drawable localDrawable;
      if ((localObject1 != null) && (((TabLayout.g)localObject1).f() != null)) {
        localDrawable = r0.a.r(this.a.f()).mutate();
      } else {
        localDrawable = null;
      }
      if (localDrawable != null)
      {
        r0.a.o(localDrawable, TabLayout.this.j);
        localObject1 = TabLayout.this.n;
        if (localObject1 != null) {
          r0.a.p(localDrawable, (PorterDuff.Mode)localObject1);
        }
      }
      localObject1 = this.a;
      if (localObject1 != null) {
        localObject1 = ((TabLayout.g)localObject1).i();
      } else {
        localObject1 = null;
      }
      if (paramImageView != null) {
        if (localDrawable != null)
        {
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        else
        {
          paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
        }
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
      if (paramTextView != null) {
        if (bool)
        {
          paramTextView.setText((CharSequence)localObject1);
          if (TabLayout.g.b(this.a) == 1) {
            paramTextView.setVisibility(0);
          } else {
            paramTextView.setVisibility(8);
          }
          setVisibility(0);
        }
        else
        {
          paramTextView.setVisibility(8);
          paramTextView.setText(null);
        }
      }
      if (paramImageView != null)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        int m;
        if ((bool) && (paramImageView.getVisibility() == 0)) {
          m = (int)t.c(getContext(), 8);
        } else {
          m = 0;
        }
        if (TabLayout.this.A)
        {
          if (m == androidx.core.view.h.a(paramTextView)) {
            break label310;
          }
          androidx.core.view.h.c(paramTextView, m);
          paramTextView.bottomMargin = 0;
        }
        else
        {
          if (m == paramTextView.bottomMargin) {
            break label310;
          }
          paramTextView.bottomMargin = m;
          androidx.core.view.h.c(paramTextView, 0);
        }
        paramImageView.setLayoutParams(paramTextView);
        paramImageView.requestLayout();
      }
      label310:
      paramImageView = this.a;
      paramTextView = localObject2;
      if (paramImageView != null) {
        paramTextView = TabLayout.g.c(paramImageView);
      }
      if (Build.VERSION.SDK_INT > 23)
      {
        if (bool) {
          paramTextView = (TextView)localObject1;
        }
        n0.a(this, paramTextView);
      }
    }
    
    protected void drawableStateChanged()
    {
      super.drawableStateChanged();
      int[] arrayOfInt = getDrawableState();
      Drawable localDrawable = this.i;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localDrawable != null)
      {
        bool1 = bool2;
        if (localDrawable.isStateful()) {
          bool1 = false | this.i.setState(arrayOfInt);
        }
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
    }
    
    int getContentHeight()
    {
      TextView localTextView = this.b;
      int i1 = 0;
      ImageView localImageView = this.c;
      View localView1 = this.f;
      int i2 = 0;
      int m = i2;
      int i3;
      for (int n = m; i1 < 3; n = i3)
      {
        View localView2 = new View[] { localTextView, localImageView, localView1 }[i1];
        int i5 = i2;
        int i4 = m;
        i3 = n;
        if (localView2 != null)
        {
          i5 = i2;
          i4 = m;
          i3 = n;
          if (localView2.getVisibility() == 0)
          {
            if (n != 0) {
              m = Math.min(m, localView2.getTop());
            } else {
              m = localView2.getTop();
            }
            if (n != 0) {
              n = Math.max(i2, localView2.getBottom());
            } else {
              n = localView2.getBottom();
            }
            i3 = 1;
            i4 = m;
            i5 = n;
          }
        }
        i1 += 1;
        i2 = i5;
        m = i4;
      }
      return i2 - m;
    }
    
    int getContentWidth()
    {
      TextView localTextView = this.b;
      int i1 = 0;
      ImageView localImageView = this.c;
      View localView1 = this.f;
      int i2 = 0;
      int m = i2;
      int i3;
      for (int n = m; i1 < 3; n = i3)
      {
        View localView2 = new View[] { localTextView, localImageView, localView1 }[i1];
        int i5 = i2;
        int i4 = m;
        i3 = n;
        if (localView2 != null)
        {
          i5 = i2;
          i4 = m;
          i3 = n;
          if (localView2.getVisibility() == 0)
          {
            if (n != 0) {
              m = Math.min(m, localView2.getLeft());
            } else {
              m = localView2.getLeft();
            }
            if (n != 0) {
              n = Math.max(i2, localView2.getRight());
            } else {
              n = localView2.getRight();
            }
            i3 = 1;
            i4 = m;
            i5 = n;
          }
        }
        i1 += 1;
        i2 = i5;
        m = i4;
      }
      return i2 - m;
    }
    
    public TabLayout.g getTab()
    {
      return this.a;
    }
    
    void o()
    {
      setTab(null);
      setSelected(false);
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      Object localObject = this.e;
      if ((localObject != null) && (((Drawable)localObject).isVisible()))
      {
        localObject = getContentDescription();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject);
        localStringBuilder.append(", ");
        localStringBuilder.append(this.e.g());
        paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
      }
      paramAccessibilityNodeInfo = d.J0(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.f0(d.c.a(0, 1, this.a.g(), 1, false, isSelected()));
      if (isSelected())
      {
        paramAccessibilityNodeInfo.d0(false);
        paramAccessibilityNodeInfo.T(d.a.i);
      }
      paramAccessibilityNodeInfo.x0(getResources().getString(R.string.item_view_role_description));
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      int n = View.MeasureSpec.getSize(paramInt1);
      int i1 = View.MeasureSpec.getMode(paramInt1);
      int i2 = TabLayout.this.getTabMaxWidth();
      int m = paramInt1;
      if (i2 > 0) {
        if (i1 != 0)
        {
          m = paramInt1;
          if (n <= i2) {}
        }
        else
        {
          m = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r, -2147483648);
        }
      }
      super.onMeasure(m, paramInt2);
      if (this.b != null)
      {
        float f2 = TabLayout.this.o;
        n = this.j;
        Object localObject = this.c;
        i1 = 1;
        float f1;
        if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
        {
          paramInt1 = 1;
          f1 = f2;
        }
        else
        {
          localObject = this.b;
          f1 = f2;
          paramInt1 = n;
          if (localObject != null)
          {
            f1 = f2;
            paramInt1 = n;
            if (((TextView)localObject).getLineCount() > 1)
            {
              f1 = TabLayout.this.p;
              paramInt1 = n;
            }
          }
        }
        f2 = this.b.getTextSize();
        i2 = this.b.getLineCount();
        n = l.d(this.b);
        boolean bool = f1 < f2;
        if ((bool) || ((n >= 0) && (paramInt1 != n)))
        {
          n = i1;
          if (TabLayout.this.z == 1)
          {
            n = i1;
            if (bool)
            {
              n = i1;
              if (i2 == 1)
              {
                localObject = this.b.getLayout();
                if (localObject != null)
                {
                  n = i1;
                  if (g((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  n = 0;
                }
              }
            }
          }
          if (n != 0)
          {
            this.b.setTextSize(0, f1);
            this.b.setMaxLines(paramInt1);
            super.onMeasure(m, paramInt2);
          }
        }
      }
    }
    
    public boolean performClick()
    {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.a != null)
      {
        if (!bool2) {
          playSoundEffect(0);
        }
        this.a.l();
        bool1 = true;
      }
      return bool1;
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() == paramBoolean) {}
      super.setSelected(paramBoolean);
      Object localObject = this.b;
      if (localObject != null) {
        ((TextView)localObject).setSelected(paramBoolean);
      }
      localObject = this.c;
      if (localObject != null) {
        ((ImageView)localObject).setSelected(paramBoolean);
      }
      localObject = this.f;
      if (localObject != null) {
        ((View)localObject).setSelected(paramBoolean);
      }
    }
    
    void setTab(TabLayout.g paramg)
    {
      if (paramg != this.a)
      {
        this.a = paramg;
        t();
      }
    }
    
    final void t()
    {
      TabLayout.g localg = this.a;
      Object localObject2 = null;
      Object localObject1;
      if (localg != null) {
        localObject1 = localg.e();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getParent();
        if (localObject2 != this)
        {
          if (localObject2 != null) {
            ((ViewGroup)localObject2).removeView((View)localObject1);
          }
          addView((View)localObject1);
        }
        this.f = ((View)localObject1);
        localObject2 = this.b;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = this.c;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(8);
          this.c.setImageDrawable(null);
        }
        localObject2 = (TextView)((View)localObject1).findViewById(16908308);
        this.g = ((TextView)localObject2);
        if (localObject2 != null) {
          this.j = l.d((TextView)localObject2);
        }
        localObject1 = (ImageView)((View)localObject1).findViewById(16908294);
      }
      else
      {
        localObject1 = this.f;
        if (localObject1 != null)
        {
          removeView((View)localObject1);
          this.f = null;
        }
        this.g = null;
        localObject1 = localObject2;
      }
      this.h = ((ImageView)localObject1);
      if (this.f == null)
      {
        if (this.c == null) {
          m();
        }
        if (this.b == null)
        {
          n();
          this.j = l.d(this.b);
        }
        l.o(this.b, TabLayout.this.h);
        localObject1 = TabLayout.this.i;
        if (localObject1 != null) {
          this.b.setTextColor((ColorStateList)localObject1);
        }
        w(this.b, this.c);
        r();
        f(this.c);
        f(this.b);
      }
      else
      {
        localObject1 = this.g;
        if ((localObject1 != null) || (this.h != null)) {
          w((TextView)localObject1, this.h);
        }
      }
      if ((localg != null) && (!TextUtils.isEmpty(TabLayout.g.c(localg)))) {
        setContentDescription(TabLayout.g.c(localg));
      }
      boolean bool;
      if ((localg != null) && (localg.j())) {
        bool = true;
      } else {
        bool = false;
      }
      setSelected(bool);
    }
    
    final void v()
    {
      setOrientation(TabLayout.this.A ^ true);
      TextView localTextView = this.g;
      ImageView localImageView;
      if ((localTextView == null) && (this.h == null))
      {
        localTextView = this.b;
        localImageView = this.c;
      }
      else
      {
        localImageView = this.h;
      }
      w(localTextView, localImageView);
    }
    
    class a
      implements View.OnLayoutChangeListener
    {
      a(View paramView) {}
      
      public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
      {
        if (paramView.getVisibility() == 0) {
          TabLayout.i.a(TabLayout.i.this, paramView);
        }
      }
    }
  }
  
  public static class j
    implements TabLayout.d
  {
    private final ViewPager a;
    
    public j(ViewPager paramViewPager)
    {
      this.a = paramViewPager;
    }
    
    public void a(TabLayout.g paramg) {}
    
    public void b(TabLayout.g paramg) {}
    
    public void c(TabLayout.g paramg)
    {
      this.a.setCurrentItem(paramg.g());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.tabs.TabLayout
 * JD-Core Version:    0.7.0.1
 */