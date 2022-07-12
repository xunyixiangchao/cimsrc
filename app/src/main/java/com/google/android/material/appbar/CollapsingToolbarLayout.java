package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.d;
import com.google.android.material.internal.p;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private static final int E = com.google.android.material.R.style.Widget_Design_CollapsingToolbar;
  private boolean A;
  private int B = 0;
  private boolean C;
  private boolean a = true;
  private int b;
  private ViewGroup c;
  private View d;
  private View e;
  private int f;
  private int g;
  private int h;
  private int i;
  private final Rect j = new Rect();
  final com.google.android.material.internal.b k;
  final j7.a l;
  private boolean m;
  private boolean n;
  private Drawable o;
  Drawable p;
  private int q;
  private boolean r;
  private ValueAnimator s;
  private long t;
  private int u = -1;
  private AppBarLayout.g v;
  int w;
  private int x;
  h0 y;
  private int z = 0;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.collapsingToolbarLayoutStyle);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    paramContext = getContext();
    com.google.android.material.internal.b localb = new com.google.android.material.internal.b(this);
    this.k = localb;
    localb.G0(e7.a.e);
    localb.D0(false);
    this.l = new j7.a(paramContext);
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, i1, new int[0]);
    localb.q0(paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    localb.g0(paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.i = paramInt;
    this.h = paramInt;
    this.g = paramInt;
    this.f = paramInt;
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.f = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.h = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.g = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
    if (paramAttributeSet.hasValue(paramInt)) {
      this.i = paramAttributeSet.getDimensionPixelSize(paramInt, 0);
    }
    this.m = paramAttributeSet.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(paramAttributeSet.getText(R.styleable.CollapsingToolbarLayout_title));
    localb.n0(com.google.android.material.R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    localb.d0(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.n0(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramInt = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.d0(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramInt = R.styleable.CollapsingToolbarLayout_expandedTitleTextColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.p0(o7.c.a(paramContext, paramAttributeSet, paramInt));
    }
    paramInt = R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.f0(o7.c.a(paramContext, paramAttributeSet, paramInt));
    }
    this.u = paramAttributeSet.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    paramInt = R.styleable.CollapsingToolbarLayout_maxLines;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.B0(paramAttributeSet.getInt(paramInt, 1));
    }
    paramInt = R.styleable.CollapsingToolbarLayout_titlePositionInterpolator;
    if (paramAttributeSet.hasValue(paramInt)) {
      localb.C0(AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(paramInt, 0)));
    }
    this.t = paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(paramAttributeSet.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(paramAttributeSet.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    setTitleCollapseMode(paramAttributeSet.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
    this.b = paramAttributeSet.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    this.A = paramAttributeSet.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
    this.C = paramAttributeSet.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
    paramAttributeSet.recycle();
    setWillNotDraw(false);
    x.E0(this, new a());
  }
  
  private void a(int paramInt)
  {
    c();
    Object localObject = this.s;
    if (localObject == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      this.s = localValueAnimator;
      if (paramInt > this.q) {
        localObject = e7.a.c;
      } else {
        localObject = e7.a.d;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      this.s.addUpdateListener(new b());
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      this.s.cancel();
    }
    this.s.setDuration(this.t);
    this.s.setIntValues(new int[] { this.q, paramInt });
    this.s.start();
  }
  
  private void b(AppBarLayout paramAppBarLayout)
  {
    if (k()) {
      paramAppBarLayout.setLiftOnScroll(false);
    }
  }
  
  private void c()
  {
    if (!this.a) {
      return;
    }
    Object localObject2 = null;
    this.c = null;
    this.d = null;
    int i1 = this.b;
    Object localObject1;
    if (i1 != -1)
    {
      localObject1 = (ViewGroup)findViewById(i1);
      this.c = ((ViewGroup)localObject1);
      if (localObject1 != null) {
        this.d = d((View)localObject1);
      }
    }
    if (this.c == null)
    {
      int i2 = getChildCount();
      i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i2) {
          break;
        }
        localObject1 = getChildAt(i1);
        if (l((View)localObject1))
        {
          localObject1 = (ViewGroup)localObject1;
          break;
        }
        i1 += 1;
      }
      this.c = ((ViewGroup)localObject1);
    }
    t();
    this.a = false;
  }
  
  private View d(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  private static int g(View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return paramView.getMeasuredHeight();
  }
  
  private static CharSequence i(View paramView)
  {
    if ((paramView instanceof androidx.appcompat.widget.Toolbar)) {
      return ((androidx.appcompat.widget.Toolbar)paramView).getTitle();
    }
    if ((paramView instanceof android.widget.Toolbar)) {
      return ((android.widget.Toolbar)paramView).getTitle();
    }
    return null;
  }
  
  static a j(View paramView)
  {
    int i1 = R.id.view_offset_helper;
    a locala2 = (a)paramView.getTag(i1);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramView);
      paramView.setTag(i1, locala1);
    }
    return locala1;
  }
  
  private boolean k()
  {
    return this.x == 1;
  }
  
  private static boolean l(View paramView)
  {
    return ((paramView instanceof androidx.appcompat.widget.Toolbar)) || ((paramView instanceof android.widget.Toolbar));
  }
  
  private boolean m(View paramView)
  {
    View localView = this.d;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == this.c) {
      return true;
    }
    return false;
  }
  
  private void p(boolean paramBoolean)
  {
    Object localObject = this.d;
    if (localObject == null) {
      localObject = this.c;
    }
    int i6 = h((View)localObject);
    d.a(this, this.e, this.j);
    localObject = this.c;
    boolean bool = localObject instanceof androidx.appcompat.widget.Toolbar;
    int i2 = 0;
    int i1;
    int i4;
    int i3;
    if (bool)
    {
      localObject = (androidx.appcompat.widget.Toolbar)localObject;
      i2 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginStart();
      i1 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginEnd();
      i4 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginTop();
      i3 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else if ((Build.VERSION.SDK_INT >= 24) && ((localObject instanceof android.widget.Toolbar)))
    {
      localObject = (android.widget.Toolbar)localObject;
      i2 = ((android.widget.Toolbar)localObject).getTitleMarginStart();
      i1 = ((android.widget.Toolbar)localObject).getTitleMarginEnd();
      i4 = ((android.widget.Toolbar)localObject).getTitleMarginTop();
      i3 = ((android.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else
    {
      i3 = 0;
      i1 = i3;
      i4 = i1;
    }
    localObject = this.k;
    Rect localRect = this.j;
    int i7 = localRect.left;
    int i5;
    if (paramBoolean) {
      i5 = i1;
    } else {
      i5 = i2;
    }
    int i8 = localRect.top;
    int i9 = localRect.right;
    if (paramBoolean) {
      i1 = i2;
    }
    ((com.google.android.material.internal.b)localObject).b0(i7 + i5, i8 + i6 + i4, i9 - i1, localRect.bottom + i6 - i3);
  }
  
  private void q()
  {
    setContentDescription(getTitle());
  }
  
  private void r(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    s(paramDrawable, this.c, paramInt1, paramInt2);
  }
  
  private void s(Drawable paramDrawable, View paramView, int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (k())
    {
      i1 = paramInt2;
      if (paramView != null)
      {
        i1 = paramInt2;
        if (this.m) {
          i1 = paramView.getBottom();
        }
      }
    }
    paramDrawable.setBounds(0, 0, paramInt1, i1);
  }
  
  private void t()
  {
    if (!this.m)
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.e);
        }
      }
    }
    if ((this.m) && (this.c != null))
    {
      if (this.e == null) {
        this.e = new View(getContext());
      }
      if (this.e.getParent() == null) {
        this.c.addView(this.e, -1, -1);
      }
    }
  }
  
  private void v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.m)
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        boolean bool1 = x.T((View)localObject);
        boolean bool2 = false;
        if ((bool1) && (this.e.getVisibility() == 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.n = bool1;
        if ((bool1) || (paramBoolean))
        {
          bool1 = bool2;
          if (x.B(this) == 1) {
            bool1 = true;
          }
          p(bool1);
          localObject = this.k;
          int i1;
          if (bool1) {
            i1 = this.h;
          } else {
            i1 = this.f;
          }
          int i3 = this.j.top;
          int i4 = this.g;
          int i2;
          if (bool1) {
            i2 = this.f;
          } else {
            i2 = this.h;
          }
          ((com.google.android.material.internal.b)localObject).k0(i1, i3 + i4, paramInt3 - paramInt1 - i2, paramInt4 - paramInt2 - this.i);
          this.k.Z(paramBoolean);
        }
      }
    }
  }
  
  private void w()
  {
    if ((this.c != null) && (this.m) && (TextUtils.isEmpty(this.k.M()))) {
      setTitle(i(this.c));
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    c();
    Object localObject;
    if (this.c == null)
    {
      localObject = this.o;
      if ((localObject != null) && (this.q > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(this.q);
        this.o.draw(paramCanvas);
      }
    }
    int i1;
    if ((this.m) && (this.n)) {
      if ((this.c != null) && (this.o != null) && (this.q > 0) && (k()) && (this.k.D() < this.k.E()))
      {
        i1 = paramCanvas.save();
        paramCanvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
        this.k.l(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      else
      {
        this.k.l(paramCanvas);
      }
    }
    if ((this.p != null) && (this.q > 0))
    {
      localObject = this.y;
      if (localObject != null) {
        i1 = ((h0)localObject).l();
      } else {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.p.setBounds(0, -this.w, getWidth(), i1 - this.w);
        this.p.mutate().setAlpha(this.q);
        this.p.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Drawable localDrawable = this.o;
    boolean bool = true;
    int i1;
    if ((localDrawable != null) && (this.q > 0) && (m(paramView)))
    {
      s(this.o, paramView, getWidth(), getHeight());
      this.o.mutate().setAlpha(this.q);
      this.o.draw(paramCanvas);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong))
    {
      if (i1 != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Object localObject = this.p;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.o;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.k;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((com.google.android.material.internal.b)localObject).E0(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  protected LayoutParams e()
  {
    return new LayoutParams(-1, -1);
  }
  
  protected FrameLayout.LayoutParams f(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity()
  {
    return this.k.q();
  }
  
  public Typeface getCollapsedTitleTypeface()
  {
    return this.k.u();
  }
  
  public Drawable getContentScrim()
  {
    return this.o;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.k.A();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.i;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.h;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.f;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.g;
  }
  
  public Typeface getExpandedTitleTypeface()
  {
    return this.k.C();
  }
  
  public int getHyphenationFrequency()
  {
    return this.k.F();
  }
  
  public int getLineCount()
  {
    return this.k.G();
  }
  
  public float getLineSpacingAdd()
  {
    return this.k.H();
  }
  
  public float getLineSpacingMultiplier()
  {
    return this.k.I();
  }
  
  public int getMaxLines()
  {
    return this.k.J();
  }
  
  int getScrimAlpha()
  {
    return this.q;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.t;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    int i1 = this.u;
    if (i1 >= 0) {
      return i1 + this.z + this.B;
    }
    h0 localh0 = this.y;
    if (localh0 != null) {
      i1 = localh0.l();
    } else {
      i1 = 0;
    }
    int i2 = x.C(this);
    if (i2 > 0) {
      return Math.min(i2 * 2 + i1, getHeight());
    }
    return getHeight() / 3;
  }
  
  public Drawable getStatusBarScrim()
  {
    return this.p;
  }
  
  public CharSequence getTitle()
  {
    if (this.m) {
      return this.k.M();
    }
    return null;
  }
  
  public int getTitleCollapseMode()
  {
    return this.x;
  }
  
  public TimeInterpolator getTitlePositionInterpolator()
  {
    return this.k.L();
  }
  
  final int h(View paramView)
  {
    a locala = j(paramView);
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - locala.b() - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  h0 n(h0 paramh0)
  {
    h0 localh0;
    if (x.y(this)) {
      localh0 = paramh0;
    } else {
      localh0 = null;
    }
    if (!x0.c.a(this.y, localh0))
    {
      this.y = localh0;
      requestLayout();
    }
    return paramh0.c();
  }
  
  public void o(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.r != paramBoolean1)
    {
      int i1 = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          i1 = 0;
        }
        a(i1);
      }
      else
      {
        if (!paramBoolean1) {
          i1 = 0;
        }
        setScrimAlpha(i1);
      }
      this.r = paramBoolean1;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof AppBarLayout))
    {
      localObject = (AppBarLayout)localObject;
      b((AppBarLayout)localObject);
      x.z0(this, x.y((View)localObject));
      if (this.v == null) {
        this.v = new c();
      }
      ((AppBarLayout)localObject).f(this.v);
      x.n0(this);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.k.V(paramConfiguration);
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.g localg = this.v;
    if ((localg != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).t(localg);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.y;
    int i2 = 0;
    if (localObject != null)
    {
      i3 = ((h0)localObject).l();
      int i4 = getChildCount();
      i1 = 0;
      while (i1 < i4)
      {
        localObject = getChildAt(i1);
        if ((!x.y((View)localObject)) && (((View)localObject).getTop() < i3)) {
          x.b0((View)localObject, i3);
        }
        i1 += 1;
      }
    }
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      j(getChildAt(i1)).d();
      i1 += 1;
    }
    v(paramInt1, paramInt2, paramInt3, paramInt4, false);
    w();
    u();
    paramInt2 = getChildCount();
    paramInt1 = i2;
    while (paramInt1 < paramInt2)
    {
      j(getChildAt(paramInt1)).a();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    Object localObject = this.y;
    if (localObject != null) {
      paramInt2 = ((h0)localObject).l();
    } else {
      paramInt2 = 0;
    }
    if (((i1 == 0) || (this.A)) && (paramInt2 > 0))
    {
      this.z = paramInt2;
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
    if ((this.C) && (this.k.J() > 1))
    {
      w();
      v(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
      paramInt2 = this.k.y();
      if (paramInt2 > 1)
      {
        this.B = (Math.round(this.k.z()) * (paramInt2 - 1));
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
      }
    }
    localObject = this.c;
    if (localObject != null)
    {
      View localView = this.d;
      if ((localView != null) && (localView != this)) {
        paramInt1 = g(localView);
      } else {
        paramInt1 = g((View)localObject);
      }
      setMinimumHeight(paramInt1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = this.o;
    if (localDrawable != null) {
      r(localDrawable, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.k.g0(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt)
  {
    this.k.d0(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.k.f0(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface)
  {
    this.k.h0(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.o;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.o = localDrawable1;
      if (localDrawable1 != null)
      {
        r(localDrawable1, getWidth(), getHeight());
        this.o.setCallback(this);
        this.o.setAlpha(this.q);
      }
      x.h0(this);
    }
  }
  
  public void setContentScrimColor(int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt)
  {
    setContentScrim(androidx.core.content.b.d(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.k.q0(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.f = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt)
  {
    this.k.n0(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList)
  {
    this.k.p0(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface)
  {
    this.k.s0(paramTypeface);
  }
  
  public void setExtraMultilineHeightEnabled(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void setForceApplySystemWindowInsetTop(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void setHyphenationFrequency(int paramInt)
  {
    this.k.x0(paramInt);
  }
  
  public void setLineSpacingAdd(float paramFloat)
  {
    this.k.z0(paramFloat);
  }
  
  public void setLineSpacingMultiplier(float paramFloat)
  {
    this.k.A0(paramFloat);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.k.B0(paramInt);
  }
  
  public void setRtlTextDirectionHeuristicsEnabled(boolean paramBoolean)
  {
    this.k.D0(paramBoolean);
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.q)
    {
      if (this.o != null)
      {
        ViewGroup localViewGroup = this.c;
        if (localViewGroup != null) {
          x.h0(localViewGroup);
        }
      }
      this.q = paramInt;
      x.h0(this);
    }
  }
  
  public void setScrimAnimationDuration(long paramLong)
  {
    this.t = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt)
  {
    if (this.u != paramInt)
    {
      this.u = paramInt;
      u();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    boolean bool;
    if ((x.U(this)) && (!isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    o(paramBoolean, bool);
  }
  
  public void setStatusBarScrim(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.p;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.p = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          this.p.setState(getDrawableState());
        }
        r0.a.m(this.p, x.B(this));
        paramDrawable = this.p;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.p.setCallback(this);
        this.p.setAlpha(this.q);
      }
      x.h0(this);
    }
  }
  
  public void setStatusBarScrimColor(int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt)
  {
    setStatusBarScrim(androidx.core.content.b.d(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.k.F0(paramCharSequence);
    q();
  }
  
  public void setTitleCollapseMode(int paramInt)
  {
    this.x = paramInt;
    boolean bool = k();
    this.k.v0(bool);
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout)) {
      b((AppBarLayout)localViewParent);
    }
    if ((bool) && (this.o == null))
    {
      float f1 = getResources().getDimension(R.dimen.design_appbar_elevation);
      setContentScrimColor(this.l.d(f1));
    }
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.m)
    {
      this.m = paramBoolean;
      q();
      t();
      requestLayout();
    }
  }
  
  public void setTitlePositionInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.k.C0(paramTimeInterpolator);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.p;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.p.setVisible(bool, false);
    }
    localDrawable = this.o;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.o.setVisible(bool, false);
    }
  }
  
  final void u()
  {
    if ((this.o != null) || (this.p != null))
    {
      boolean bool;
      if (getHeight() + this.w < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.o) || (paramDrawable == this.p);
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    int a = 0;
    float b = 0.5F;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingToolbarLayout_Layout);
      this.a = paramContext.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      a(paramContext.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void a(float paramFloat)
    {
      this.b = paramFloat;
    }
  }
  
  class a
    implements r
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      return CollapsingToolbarLayout.this.n(paramh0);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      CollapsingToolbarLayout.this.setScrimAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
  }
  
  private class c
    implements AppBarLayout.g
  {
    c() {}
    
    public void a(AppBarLayout paramAppBarLayout, int paramInt)
    {
      paramAppBarLayout = CollapsingToolbarLayout.this;
      paramAppBarLayout.w = paramInt;
      paramAppBarLayout = paramAppBarLayout.y;
      if (paramAppBarLayout != null) {
        i = paramAppBarLayout.l();
      } else {
        i = 0;
      }
      int m = CollapsingToolbarLayout.this.getChildCount();
      int j = 0;
      while (j < m)
      {
        paramAppBarLayout = CollapsingToolbarLayout.this.getChildAt(j);
        CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramAppBarLayout.getLayoutParams();
        a locala = CollapsingToolbarLayout.j(paramAppBarLayout);
        k = localLayoutParams.a;
        if (k != 1)
        {
          if (k != 2) {
            break label138;
          }
          k = Math.round(-paramInt * localLayoutParams.b);
        }
        else
        {
          k = t0.a.b(-paramInt, 0, CollapsingToolbarLayout.this.h(paramAppBarLayout));
        }
        locala.f(k);
        label138:
        j += 1;
      }
      CollapsingToolbarLayout.this.u();
      paramAppBarLayout = CollapsingToolbarLayout.this;
      if ((paramAppBarLayout.p != null) && (i > 0)) {
        x.h0(paramAppBarLayout);
      }
      j = CollapsingToolbarLayout.this.getHeight();
      int i = j - x.C(CollapsingToolbarLayout.this) - i;
      int k = CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger();
      paramAppBarLayout = CollapsingToolbarLayout.this.k;
      float f1 = j - k;
      float f2 = i;
      paramAppBarLayout.w0(Math.min(1.0F, f1 / f2));
      paramAppBarLayout = CollapsingToolbarLayout.this;
      paramAppBarLayout.k.j0(paramAppBarLayout.w + i);
      CollapsingToolbarLayout.this.k.u0(Math.abs(paramInt) / f2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */