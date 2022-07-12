package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.h0;
import androidx.core.view.m;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.integer;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r7.h;
import r7.i;
import x0.c;
import y0.d;
import y0.d.a;
import y0.g;
import y0.g.a;

public class AppBarLayout
  extends LinearLayout
  implements CoordinatorLayout.b
{
  private static final int t = R.style.Widget_Design_AppBarLayout;
  private int a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private boolean e;
  private int f = 0;
  private h0 g;
  private List<c> h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private int m;
  private WeakReference<View> n;
  private ValueAnimator o;
  private final List<f> p = new ArrayList();
  private int[] q;
  private Drawable r;
  private Behavior s;
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.appBarLayoutStyle);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i2), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    int i1 = Build.VERSION.SDK_INT;
    if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
      b.a(this);
    }
    b.c(this, paramAttributeSet, paramInt, i2);
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.AppBarLayout, paramInt, i2, new int[0]);
    x.u0(this, paramAttributeSet.getDrawable(R.styleable.AppBarLayout_android_background));
    if ((getBackground() instanceof ColorDrawable))
    {
      ColorDrawable localColorDrawable = (ColorDrawable)getBackground();
      h localh = new h();
      localh.b0(ColorStateList.valueOf(localColorDrawable.getColor()));
      localh.Q(paramContext);
      x.u0(this, localh);
    }
    paramInt = R.styleable.AppBarLayout_expanded;
    if (paramAttributeSet.hasValue(paramInt)) {
      w(paramAttributeSet.getBoolean(paramInt, false), false, false);
    }
    paramInt = R.styleable.AppBarLayout_elevation;
    if (paramAttributeSet.hasValue(paramInt)) {
      b.b(this, paramAttributeSet.getDimensionPixelSize(paramInt, 0));
    }
    if (i1 >= 26)
    {
      paramInt = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
      if (paramAttributeSet.hasValue(paramInt)) {
        setKeyboardNavigationCluster(paramAttributeSet.getBoolean(paramInt, false));
      }
      paramInt = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
      if (paramAttributeSet.hasValue(paramInt)) {
        setTouchscreenBlocksFocus(paramAttributeSet.getBoolean(paramInt, false));
      }
    }
    this.l = paramAttributeSet.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
    this.m = paramAttributeSet.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
    setStatusBarForeground(paramAttributeSet.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
    paramAttributeSet.recycle();
    x.E0(this, new a());
  }
  
  private boolean A()
  {
    return (this.r != null) && (getTopInset() > 0);
  }
  
  private boolean C()
  {
    int i1 = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
    {
      View localView = getChildAt(0);
      bool1 = bool2;
      if (localView.getVisibility() != 8)
      {
        bool1 = bool2;
        if (!x.y(localView)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void D(final h paramh, boolean paramBoolean)
  {
    float f1 = getResources().getDimension(R.dimen.design_appbar_elevation);
    float f2;
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = this.o;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.o = localValueAnimator;
    localValueAnimator.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
    this.o.setInterpolator(e7.a.a);
    this.o.addUpdateListener(new b(paramh));
    this.o.start();
  }
  
  private void E()
  {
    setWillNotDraw(A() ^ true);
  }
  
  private void g()
  {
    WeakReference localWeakReference = this.n;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.n = null;
  }
  
  private View h(View paramView)
  {
    Object localObject1 = this.n;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      int i1 = this.m;
      if (i1 != -1)
      {
        if (paramView != null) {
          paramView = paramView.findViewById(i1);
        } else {
          paramView = null;
        }
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((getParent() instanceof ViewGroup)) {
            localObject1 = ((ViewGroup)getParent()).findViewById(this.m);
          }
        }
        if (localObject1 != null) {
          this.n = new WeakReference(localObject1);
        }
      }
    }
    localObject1 = this.n;
    paramView = localObject2;
    if (localObject1 != null) {
      paramView = (View)((WeakReference)localObject1).get();
    }
    return paramView;
  }
  
  private boolean m()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((LayoutParams)getChildAt(i1).getLayoutParams()).e()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void o()
  {
    Object localObject = this.s;
    if ((localObject != null) && (this.b != -1) && (this.f == 0)) {
      localObject = ((BaseBehavior)localObject).t0(AbsSavedState.b, this);
    } else {
      localObject = null;
    }
    this.b = -1;
    this.c = -1;
    this.d = -1;
    if (localObject != null) {
      this.s.s0((AppBarLayout.BaseBehavior.SavedState)localObject, false);
    }
  }
  
  private void w(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    int i3 = 0;
    int i2;
    if (paramBoolean2) {
      i2 = 4;
    } else {
      i2 = 0;
    }
    if (paramBoolean3) {
      i3 = 8;
    }
    this.f = (i1 | i2 | i3);
    requestLayout();
  }
  
  private boolean x(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  boolean B(View paramView)
  {
    View localView = h(paramView);
    if (localView != null) {
      paramView = localView;
    }
    return (paramView != null) && ((paramView.canScrollVertically(-1)) || (paramView.getScrollY() > 0));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (A())
    {
      int i1 = paramCanvas.save();
      paramCanvas.translate(0.0F, -this.a);
      this.r.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.r;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidateDrawable(localDrawable);
    }
  }
  
  public void e(c paramc)
  {
    if (this.h == null) {
      this.h = new ArrayList();
    }
    if ((paramc != null) && (!this.h.contains(paramc))) {
      this.h.add(paramc);
    }
  }
  
  public void f(g paramg)
  {
    e(paramg);
  }
  
  public CoordinatorLayout.Behavior<AppBarLayout> getBehavior()
  {
    Behavior localBehavior = new Behavior();
    this.s = localBehavior;
    return localBehavior;
  }
  
  int getDownNestedPreScrollRange()
  {
    int i1 = this.c;
    if (i1 != -1) {
      return i1;
    }
    int i2 = getChildCount() - 1;
    for (int i3 = 0; i2 >= 0; i3 = i1)
    {
      View localView = getChildAt(i2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i5 = localView.getMeasuredHeight();
      i1 = localLayoutParams.a;
      if ((i1 & 0x5) == 5)
      {
        int i4 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((i1 & 0x8) != 0) {}
        for (i1 = x.C(localView);; i1 = i5 - x.C(localView))
        {
          i1 = i4 + i1;
          break label120;
          if ((i1 & 0x2) == 0) {
            break;
          }
        }
        i1 = i4 + i5;
        label120:
        i4 = i1;
        if (i2 == 0)
        {
          i4 = i1;
          if (x.y(localView)) {
            i4 = Math.min(i1, i5 - getTopInset());
          }
        }
        i1 = i3 + i4;
      }
      else
      {
        i1 = i3;
        if (i3 > 0) {
          break;
        }
      }
      i2 -= 1;
    }
    i1 = Math.max(0, i3);
    this.c = i1;
    return i1;
  }
  
  int getDownNestedScrollRange()
  {
    int i1 = this.d;
    if (i1 != -1) {
      return i1;
    }
    int i4 = getChildCount();
    int i2 = 0;
    i1 = i2;
    int i3;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      View localView = getChildAt(i2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i6 = localView.getMeasuredHeight();
      int i7 = localLayoutParams.topMargin;
      int i8 = localLayoutParams.bottomMargin;
      int i5 = localLayoutParams.a;
      i3 = i1;
      if ((i5 & 0x1) == 0) {
        break;
      }
      i1 += i6 + (i7 + i8);
      if ((i5 & 0x2) != 0)
      {
        i3 = i1 - x.C(localView);
        break;
      }
      i2 += 1;
    }
    i1 = Math.max(0, i3);
    this.d = i1;
    return i1;
  }
  
  public int getLiftOnScrollTargetViewId()
  {
    return this.m;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i2 = getTopInset();
    int i1 = x.C(this);
    if (i1 != 0) {}
    do
    {
      return i1 * 2 + i2;
      i1 = getChildCount();
      if (i1 >= 1) {
        i1 = x.C(getChildAt(i1 - 1));
      } else {
        i1 = 0;
      }
    } while (i1 != 0);
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.f;
  }
  
  public Drawable getStatusBarForeground()
  {
    return this.r;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  final int getTopInset()
  {
    h0 localh0 = this.g;
    if (localh0 != null) {
      return localh0.l();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    int i1 = this.b;
    if (i1 != -1) {
      return i1;
    }
    int i4 = getChildCount();
    int i2 = 0;
    i1 = i2;
    int i3;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      View localView = getChildAt(i2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i6 = localView.getMeasuredHeight();
      int i5 = localLayoutParams.a;
      i3 = i1;
      if ((i5 & 0x1) == 0) {
        break;
      }
      i3 = i1 + (i6 + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      i1 = i3;
      if (i2 == 0)
      {
        i1 = i3;
        if (x.y(localView)) {
          i1 = i3 - getTopInset();
        }
      }
      if ((i5 & 0x2) != 0)
      {
        i3 = i1 - x.C(localView);
        break;
      }
      i2 += 1;
    }
    i1 = Math.max(0, i3);
    this.b = i1;
    return i1;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected LayoutParams i()
  {
    return new LayoutParams(-1, -2);
  }
  
  public LayoutParams j(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams k(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  boolean l()
  {
    return this.e;
  }
  
  boolean n()
  {
    return getTotalScrollRange() != 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.e(this);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.q == null) {
      this.q = new int[4];
    }
    int[] arrayOfInt1 = this.q;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    boolean bool = this.j;
    paramInt = R.attr.state_liftable;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[0] = paramInt;
    if ((bool) && (this.k)) {
      paramInt = R.attr.state_lifted;
    } else {
      paramInt = -R.attr.state_lifted;
    }
    arrayOfInt1[1] = paramInt;
    paramInt = R.attr.state_collapsible;
    if (!bool) {
      paramInt = -paramInt;
    }
    arrayOfInt1[2] = paramInt;
    if ((bool) && (this.k)) {
      paramInt = R.attr.state_collapsed;
    } else {
      paramInt = -R.attr.state_collapsed;
    }
    arrayOfInt1[3] = paramInt;
    return LinearLayout.mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    g();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramBoolean = x.y(this);
    boolean bool = true;
    if ((paramBoolean) && (C()))
    {
      paramInt2 = getTopInset();
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        x.b0(getChildAt(paramInt1), paramInt2);
        paramInt1 -= 1;
      }
    }
    o();
    this.e = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).d() != null)
      {
        this.e = true;
        break;
      }
      paramInt1 += 1;
    }
    Drawable localDrawable = this.r;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, getWidth(), getTopInset());
    }
    if (!this.i)
    {
      paramBoolean = bool;
      if (!this.l) {
        if (m()) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      x(paramBoolean);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    if ((i1 != 1073741824) && (x.y(this)) && (C()))
    {
      paramInt1 = getMeasuredHeight();
      if (i1 != -2147483648)
      {
        if (i1 == 0) {
          paramInt1 += getTopInset();
        }
      }
      else {
        paramInt1 = t0.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    o();
  }
  
  public boolean p()
  {
    return this.l;
  }
  
  void q(int paramInt)
  {
    this.a = paramInt;
    if (!willNotDraw()) {
      x.h0(this);
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (c)this.h.get(i1);
        if (localObject != null) {
          ((c)localObject).a(this, paramInt);
        }
        i1 += 1;
      }
    }
  }
  
  h0 r(h0 paramh0)
  {
    h0 localh0;
    if (x.y(this)) {
      localh0 = paramh0;
    } else {
      localh0 = null;
    }
    if (!c.a(this.g, localh0))
    {
      this.g = localh0;
      E();
      requestLayout();
    }
    return paramh0;
  }
  
  public void s(c paramc)
  {
    List localList = this.h;
    if ((localList != null) && (paramc != null)) {
      localList.remove(paramc);
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    i.d(this, paramFloat);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    v(paramBoolean, x.U(this));
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(int paramInt)
  {
    this.m = paramInt;
    g();
  }
  
  public void setLiftableOverrideEnabled(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  public void setStatusBarForeground(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.r;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.r = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          this.r.setState(getDrawableState());
        }
        r0.a.m(this.r, x.B(this));
        paramDrawable = this.r;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.r.setCallback(this);
      }
      E();
      x.h0(this);
    }
  }
  
  public void setStatusBarForegroundColor(int paramInt)
  {
    setStatusBarForeground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarForegroundResource(int paramInt)
  {
    setStatusBarForeground(c.a.b(getContext(), paramInt));
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    b.b(this, paramFloat);
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
    Drawable localDrawable = this.r;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  public void t(g paramg)
  {
    s(paramg);
  }
  
  void u()
  {
    this.f = 0;
  }
  
  public void v(boolean paramBoolean1, boolean paramBoolean2)
  {
    w(paramBoolean1, paramBoolean2, true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.r);
  }
  
  boolean y(boolean paramBoolean)
  {
    return z(paramBoolean, this.i ^ true);
  }
  
  boolean z(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.k != paramBoolean1))
    {
      this.k = paramBoolean1;
      refreshDrawableState();
      if ((this.l) && ((getBackground() instanceof h))) {
        D((h)getBackground(), paramBoolean1);
      }
      return true;
    }
    return false;
  }
  
  protected static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private int k;
    private int l;
    private ValueAnimator m;
    private SavedState n;
    private WeakReference<View> o;
    private boolean p;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private boolean T(final CoordinatorLayout paramCoordinatorLayout, final T paramT, final View paramView)
    {
      final int i = M();
      int j = -paramT.getTotalScrollRange();
      boolean bool = false;
      if (i != j)
      {
        U(paramCoordinatorLayout, paramT, d.a.q, false);
        bool = true;
      }
      if (M() != 0) {
        if (paramView.canScrollVertically(-1))
        {
          i = -paramT.getDownNestedPreScrollRange();
          if (i != 0)
          {
            x.m0(paramCoordinatorLayout, d.a.r, null, new c(paramCoordinatorLayout, paramT, paramView, i));
            return true;
          }
        }
        else
        {
          U(paramCoordinatorLayout, paramT, d.a.r, true);
          return true;
        }
      }
      return bool;
    }
    
    private void U(CoordinatorLayout paramCoordinatorLayout, final T paramT, d.a parama, final boolean paramBoolean)
    {
      x.m0(paramCoordinatorLayout, parama, null, new d(paramT, paramBoolean));
    }
    
    private void V(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt, float paramFloat)
    {
      int i = Math.abs(M() - paramInt);
      paramFloat = Math.abs(paramFloat);
      if (paramFloat > 0.0F) {
        i = Math.round(i / paramFloat * 1000.0F) * 3;
      } else {
        i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F);
      }
      W(paramCoordinatorLayout, paramT, paramInt, i);
    }
    
    private void W(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt1, int paramInt2)
    {
      int i = M();
      if (i == paramInt1)
      {
        paramCoordinatorLayout = this.m;
        if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
          this.m.cancel();
        }
        return;
      }
      ValueAnimator localValueAnimator = this.m;
      if (localValueAnimator == null)
      {
        localValueAnimator = new ValueAnimator();
        this.m = localValueAnimator;
        localValueAnimator.setInterpolator(e7.a.e);
        this.m.addUpdateListener(new a(paramCoordinatorLayout, paramT));
      }
      else
      {
        localValueAnimator.cancel();
      }
      this.m.setDuration(Math.min(paramInt2, 600));
      this.m.setIntValues(new int[] { i, paramInt1 });
      this.m.start();
    }
    
    private int X(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < (paramInt2 + paramInt3) / 2) {
        return paramInt2;
      }
      return paramInt3;
    }
    
    private boolean Z(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView)
    {
      return (paramT.n()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
    }
    
    private static boolean a0(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    private boolean b0(AppBarLayout paramAppBarLayout)
    {
      int j = paramAppBarLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        if (((AppBarLayout.LayoutParams)paramAppBarLayout.getChildAt(i).getLayoutParams()).a != 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    private View c0(CoordinatorLayout paramCoordinatorLayout)
    {
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((!(localView instanceof m)) && (!(localView instanceof ListView)))
        {
          if ((localView instanceof ScrollView)) {
            return localView;
          }
          i += 1;
        }
        else
        {
          return localView;
        }
      }
      return null;
    }
    
    private static View d0(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
          return localView;
        }
        paramInt += 1;
      }
      return null;
    }
    
    private int e0(T paramT, int paramInt)
    {
      int i4 = paramT.getChildCount();
      int i = 0;
      while (i < i4)
      {
        Object localObject = paramT.getChildAt(i);
        int i3 = ((View)localObject).getTop();
        int i2 = ((View)localObject).getBottom();
        localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
        int i1 = i3;
        int j = i2;
        if (a0(((AppBarLayout.LayoutParams)localObject).c(), 32))
        {
          i1 = i3 - ((LinearLayout.LayoutParams)localObject).topMargin;
          j = i2 + ((LinearLayout.LayoutParams)localObject).bottomMargin;
        }
        i2 = -paramInt;
        if ((i1 <= i2) && (j >= i2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private View f0(CoordinatorLayout paramCoordinatorLayout)
    {
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((((CoordinatorLayout.e)localView.getLayoutParams()).f() instanceof AppBarLayout.ScrollingViewBehavior)) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    private int i0(T paramT, int paramInt)
    {
      int i1 = Math.abs(paramInt);
      int i2 = paramT.getChildCount();
      int j = 0;
      int i = 0;
      while (i < i2)
      {
        View localView = paramT.getChildAt(i);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        Interpolator localInterpolator = localLayoutParams.d();
        if ((i1 >= localView.getTop()) && (i1 <= localView.getBottom()))
        {
          if (localInterpolator == null) {
            break;
          }
          i2 = localLayoutParams.c();
          i = j;
          if ((i2 & 0x1) != 0)
          {
            j = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
            i = j;
            if ((i2 & 0x2) != 0) {
              i = j - x.C(localView);
            }
          }
          j = i;
          if (x.y(localView)) {
            j = i - paramT.getTopInset();
          }
          if (j <= 0) {
            break;
          }
          i = localView.getTop();
          float f = j;
          i = Math.round(f * localInterpolator.getInterpolation((i1 - i) / f));
          return Integer.signum(paramInt) * (localView.getTop() + i);
        }
        i += 1;
      }
      return paramInt;
    }
    
    private boolean v0(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      paramCoordinatorLayout = paramCoordinatorLayout.w(paramT);
      int j = paramCoordinatorLayout.size();
      boolean bool = false;
      int i = 0;
      while (i < j)
      {
        paramT = ((CoordinatorLayout.e)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).f();
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramT).K() != 0) {
            bool = true;
          }
          return bool;
        }
        i += 1;
      }
      return false;
    }
    
    private void w0(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      int i3 = paramT.getTopInset() + paramT.getPaddingTop();
      int i4 = M() - i3;
      int i1 = e0(paramT, i4);
      if (i1 >= 0)
      {
        View localView = paramT.getChildAt(i1);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        int i5 = localLayoutParams.c();
        if ((i5 & 0x11) == 17)
        {
          int i = -localView.getTop();
          int i2 = -localView.getBottom();
          int j = i;
          if (i1 == 0)
          {
            j = i;
            if (x.y(paramT))
            {
              j = i;
              if (x.y(localView)) {
                j = i - paramT.getTopInset();
              }
            }
          }
          if (a0(i5, 2))
          {
            i = i2 + x.C(localView);
            i1 = j;
          }
          else
          {
            i1 = j;
            i = i2;
            if (a0(i5, 5))
            {
              i = x.C(localView) + i2;
              if (i4 < i)
              {
                i1 = i;
                i = i2;
              }
              else
              {
                i1 = j;
              }
            }
          }
          i2 = i1;
          j = i;
          if (a0(i5, 32))
          {
            i2 = i1 + localLayoutParams.topMargin;
            j = i - localLayoutParams.bottomMargin;
          }
          V(paramCoordinatorLayout, paramT, t0.a.b(X(i4, j, i2) + i3, -paramT.getTotalScrollRange(), 0), 0.0F);
        }
      }
    }
    
    private void x0(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      x.k0(paramCoordinatorLayout, d.a.q.b());
      x.k0(paramCoordinatorLayout, d.a.r.b());
      if (paramT.getTotalScrollRange() == 0) {
        return;
      }
      View localView = f0(paramCoordinatorLayout);
      if (localView == null) {
        return;
      }
      if (!b0(paramT)) {
        return;
      }
      if (!x.O(paramCoordinatorLayout)) {
        x.q0(paramCoordinatorLayout, new b());
      }
      this.p = T(paramCoordinatorLayout, paramT, localView);
    }
    
    private void y0(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      View localView = d0(paramT, paramInt1);
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localView != null)
      {
        int i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).c();
        bool1 = bool2;
        if ((i & 0x1) != 0)
        {
          int j = x.C(localView);
          if ((paramInt2 > 0) && ((i & 0xC) != 0))
          {
            bool1 = bool2;
            if (-paramInt1 < localView.getBottom() - j - paramT.getTopInset()) {}
          }
          else
          {
            do
            {
              bool1 = true;
              break;
              bool1 = bool2;
              if ((i & 0x2) == 0) {
                break;
              }
              bool1 = bool2;
            } while (-paramInt1 >= localView.getBottom() - j - paramT.getTopInset());
          }
        }
      }
      if (paramT.p()) {
        bool1 = paramT.B(c0(paramCoordinatorLayout));
      }
      bool1 = paramT.y(bool1);
      if ((paramBoolean) || ((bool1) && (v0(paramCoordinatorLayout, paramT)))) {
        paramT.jumpDrawablesToCurrentState();
      }
    }
    
    int M()
    {
      return E() + this.k;
    }
    
    boolean Y(T paramT)
    {
      paramT = this.o;
      boolean bool = true;
      if (paramT != null)
      {
        paramT = (View)paramT.get();
        if ((paramT != null) && (paramT.isShown()) && (!paramT.canScrollVertically(-1))) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    
    int g0(T paramT)
    {
      return -paramT.getDownNestedScrollRange();
    }
    
    int h0(T paramT)
    {
      return paramT.getTotalScrollRange();
    }
    
    void j0(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      w0(paramCoordinatorLayout, paramT);
      if (paramT.p()) {
        paramT.y(paramT.B(c0(paramCoordinatorLayout)));
      }
    }
    
    public boolean k0(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      boolean bool = super.l(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      Object localObject = this.n;
      if ((localObject != null) && ((i & 0x8) == 0))
      {
        if (((SavedState)localObject).c)
        {
          i = -paramT.getTotalScrollRange();
          P(paramCoordinatorLayout, paramT, i);
          break label227;
        }
        if (!((SavedState)localObject).d) {}
      }
      do
      {
        P(paramCoordinatorLayout, paramT, 0);
        break label227;
        localObject = paramT.getChildAt(((SavedState)localObject).e);
        i = -((View)localObject).getBottom();
        if (this.n.g) {
          paramInt = x.C((View)localObject) + paramT.getTopInset();
        } else {
          paramInt = Math.round(((View)localObject).getHeight() * this.n.f);
        }
        P(paramCoordinatorLayout, paramT, i + paramInt);
        break label227;
        if (i == 0) {
          break label227;
        }
        if ((i & 0x4) != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((i & 0x2) != 0)
        {
          int j = -paramT.getUpNestedPreScrollRange();
          i = j;
          if (paramInt == 0) {
            break;
          }
          V(paramCoordinatorLayout, paramT, j, 0.0F);
          break label227;
        }
        if ((i & 0x1) == 0) {
          break label227;
        }
      } while (paramInt == 0);
      V(paramCoordinatorLayout, paramT, 0, 0.0F);
      label227:
      paramT.u();
      this.n = null;
      G(t0.a.b(E(), -paramT.getTotalScrollRange(), 0));
      y0(paramCoordinatorLayout, paramT, E(), 0, true);
      paramT.q(E());
      x0(paramCoordinatorLayout, paramT);
      return bool;
    }
    
    public boolean l0(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.e)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.N(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.m(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void m0(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt2 != 0)
      {
        if (paramInt2 < 0)
        {
          paramInt1 = -paramT.getTotalScrollRange();
          paramInt3 = paramT.getDownNestedPreScrollRange() + paramInt1;
        }
        else
        {
          paramInt1 = -paramT.getUpNestedPreScrollRange();
          paramInt3 = 0;
        }
        if (paramInt1 != paramInt3) {
          paramArrayOfInt[1] = O(paramCoordinatorLayout, paramT, paramInt2, paramInt1, paramInt3);
        }
      }
      if (paramT.p()) {
        paramT.y(paramT.B(paramView));
      }
    }
    
    public void n0(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      if (paramInt4 < 0) {
        paramArrayOfInt[1] = O(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
      }
      if (paramInt4 == 0) {
        x0(paramCoordinatorLayout, paramT);
      }
    }
    
    public void o0(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        s0((SavedState)paramParcelable, true);
        super.x(paramCoordinatorLayout, paramT, this.n.g());
        return;
      }
      super.x(paramCoordinatorLayout, paramT, paramParcelable);
      this.n = null;
    }
    
    public Parcelable p0(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      paramCoordinatorLayout = super.y(paramCoordinatorLayout, paramT);
      paramT = t0(paramCoordinatorLayout, paramT);
      if (paramT == null) {
        return paramCoordinatorLayout;
      }
      return paramT;
    }
    
    public boolean q0(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool;
      if (((paramInt1 & 0x2) != 0) && ((paramT.p()) || (Z(paramCoordinatorLayout, paramT, paramView1)))) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        paramCoordinatorLayout = this.m;
        if (paramCoordinatorLayout != null) {
          paramCoordinatorLayout.cancel();
        }
      }
      this.o = null;
      this.l = paramInt2;
      return bool;
    }
    
    public void r0(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      if ((this.l == 0) || (paramInt == 1))
      {
        w0(paramCoordinatorLayout, paramT);
        if (paramT.p()) {
          paramT.y(paramT.B(paramView));
        }
      }
      this.o = new WeakReference(paramView);
    }
    
    void s0(SavedState paramSavedState, boolean paramBoolean)
    {
      if ((this.n == null) || (paramBoolean)) {
        this.n = paramSavedState;
      }
    }
    
    SavedState t0(Parcelable paramParcelable, T paramT)
    {
      int j = E();
      int i1 = paramT.getChildCount();
      boolean bool2 = false;
      int i = 0;
      while (i < i1)
      {
        View localView = paramT.getChildAt(i);
        int i2 = localView.getBottom() + j;
        if ((localView.getTop() + j <= 0) && (i2 >= 0))
        {
          Object localObject = paramParcelable;
          if (paramParcelable == null) {
            localObject = AbsSavedState.b;
          }
          paramParcelable = new SavedState((Parcelable)localObject);
          if (j == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramParcelable.d = bool1;
          if ((!bool1) && (-j >= paramT.getTotalScrollRange())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          paramParcelable.c = bool1;
          paramParcelable.e = i;
          boolean bool1 = bool2;
          if (i2 == x.C(localView) + paramT.getTopInset()) {
            bool1 = true;
          }
          paramParcelable.g = bool1;
          paramParcelable.f = (i2 / localView.getHeight());
          return paramParcelable;
        }
        i += 1;
      }
      return null;
    }
    
    int u0(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3)
    {
      int i1 = M();
      int j = 0;
      int i = 0;
      if ((paramInt2 != 0) && (i1 >= paramInt2) && (i1 <= paramInt3))
      {
        paramInt2 = t0.a.b(paramInt1, paramInt2, paramInt3);
        paramInt1 = j;
        if (i1 != paramInt2)
        {
          if (paramT.l()) {
            paramInt1 = i0(paramT, paramInt2);
          } else {
            paramInt1 = paramInt2;
          }
          boolean bool = G(paramInt1);
          this.k = (paramInt2 - paramInt1);
          paramInt3 = 1;
          if (bool)
          {
            paramInt1 = i;
            while (paramInt1 < paramT.getChildCount())
            {
              AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)paramT.getChildAt(paramInt1).getLayoutParams();
              AppBarLayout.d locald = localLayoutParams.b();
              if ((locald != null) && ((localLayoutParams.c() & 0x1) != 0)) {
                locald.a(paramT, paramT.getChildAt(paramInt1), E());
              }
              paramInt1 += 1;
            }
          }
          if ((!bool) && (paramT.l())) {
            paramCoordinatorLayout.p(paramT);
          }
          paramT.q(E());
          paramInt1 = paramInt3;
          if (paramInt2 < i1) {
            paramInt1 = -1;
          }
          y0(paramCoordinatorLayout, paramT, paramInt2, paramInt1, false);
          paramInt1 = i1 - paramInt2;
        }
      }
      else
      {
        this.k = 0;
        paramInt1 = j;
      }
      x0(paramCoordinatorLayout, paramT);
      return paramInt1;
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new a();
      boolean c;
      boolean d;
      int e;
      float f;
      boolean g;
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        int i = paramParcel.readByte();
        boolean bool2 = true;
        boolean bool1;
        if (i != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.c = bool1;
        if (paramParcel.readByte() != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.d = bool1;
        this.e = paramParcel.readInt();
        this.f = paramParcel.readFloat();
        if (paramParcel.readByte() != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.g = bool1;
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeByte((byte)this.c);
        paramParcel.writeByte((byte)this.d);
        paramParcel.writeInt(this.e);
        paramParcel.writeFloat(this.f);
        paramParcel.writeByte((byte)this.g);
      }
      
      class a
        implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.SavedState>
      {
        public AppBarLayout.BaseBehavior.SavedState a(Parcel paramParcel)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramParcel, null);
        }
        
        public AppBarLayout.BaseBehavior.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramParcel, paramClassLoader);
        }
        
        public AppBarLayout.BaseBehavior.SavedState[] c(int paramInt)
        {
          return new AppBarLayout.BaseBehavior.SavedState[paramInt];
        }
      }
    }
    
    class a
      implements ValueAnimator.AnimatorUpdateListener
    {
      a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout) {}
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        AppBarLayout.BaseBehavior.this.P(paramCoordinatorLayout, paramT, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      }
    }
    
    class b
      extends androidx.core.view.a
    {
      b() {}
      
      public void g(View paramView, d paramd)
      {
        super.g(paramView, paramd);
        paramd.z0(AppBarLayout.BaseBehavior.R(AppBarLayout.BaseBehavior.this));
        paramd.c0(ScrollView.class.getName());
      }
    }
    
    class c
      implements g
    {
      c(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, View paramView, int paramInt) {}
      
      public boolean a(View paramView, g.a parama)
      {
        AppBarLayout.BaseBehavior.this.m0(paramCoordinatorLayout, paramT, paramView, 0, i, new int[] { 0, 0 }, 1);
        return true;
      }
    }
    
    class d
      implements g
    {
      d(AppBarLayout paramAppBarLayout, boolean paramBoolean) {}
      
      public boolean a(View paramView, g.a parama)
      {
        paramT.setExpanded(paramBoolean);
        return true;
      }
    }
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    int a = 1;
    private AppBarLayout.d b;
    Interpolator c;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_Layout);
      this.a = paramAttributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      f(a(paramAttributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
      int i = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
      if (paramAttributeSet.hasValue(i)) {
        this.c = AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(i, 0));
      }
      paramAttributeSet.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    private AppBarLayout.d a(int paramInt)
    {
      if (paramInt != 1) {
        return null;
      }
      return new AppBarLayout.e();
    }
    
    public AppBarLayout.d b()
    {
      return this.b;
    }
    
    public int c()
    {
      return this.a;
    }
    
    public Interpolator d()
    {
      return this.c;
    }
    
    boolean e()
    {
      int i = this.a;
      return ((i & 0x1) == 1) && ((i & 0xA) != 0);
    }
    
    public void f(AppBarLayout.d paramd)
    {
      this.b = paramd;
    }
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      O(paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      paramContext.recycle();
    }
    
    private static int R(AppBarLayout paramAppBarLayout)
    {
      paramAppBarLayout = ((CoordinatorLayout.e)paramAppBarLayout.getLayoutParams()).f();
      if ((paramAppBarLayout instanceof AppBarLayout.BaseBehavior)) {
        return ((AppBarLayout.BaseBehavior)paramAppBarLayout).M();
      }
      return 0;
    }
    
    private void S(View paramView1, View paramView2)
    {
      Object localObject = ((CoordinatorLayout.e)paramView2.getLayoutParams()).f();
      if ((localObject instanceof AppBarLayout.BaseBehavior))
      {
        localObject = (AppBarLayout.BaseBehavior)localObject;
        x.b0(paramView1, paramView2.getBottom() - paramView1.getTop() + AppBarLayout.BaseBehavior.S((AppBarLayout.BaseBehavior)localObject) + M() - I(paramView2));
      }
    }
    
    private void T(View paramView1, View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        paramView2 = (AppBarLayout)paramView2;
        if (paramView2.p()) {
          paramView2.y(paramView2.B(paramView1));
        }
      }
    }
    
    float J(View paramView)
    {
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        int i = R(paramView);
        if ((k != 0) && (j + i <= k)) {
          return 0.0F;
        }
        j -= k;
        if (j != 0) {
          return i / j + 1.0F;
        }
      }
      return 0.0F;
    }
    
    int L(View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.L(paramView);
    }
    
    AppBarLayout Q(List<View> paramList)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
        i += 1;
      }
      return null;
    }
    
    public boolean e(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean h(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      S(paramView1, paramView2);
      T(paramView1, paramView2);
      return false;
    }
    
    public void i(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        x.k0(paramCoordinatorLayout, d.a.q.b());
        x.k0(paramCoordinatorLayout, d.a.r.b());
        x.q0(paramCoordinatorLayout, null);
      }
    }
    
    public boolean w(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = Q(paramCoordinatorLayout.v(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.d;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          localAppBarLayout.v(false, paramBoolean ^ true);
          return true;
        }
      }
      return false;
    }
  }
  
  class a
    implements r
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      return AppBarLayout.this.r(paramh0);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(h paramh) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramh.a0(f);
      if ((AppBarLayout.c(AppBarLayout.this) instanceof h)) {
        ((h)AppBarLayout.c(AppBarLayout.this)).a0(f);
      }
      paramValueAnimator = AppBarLayout.d(AppBarLayout.this).iterator();
      while (paramValueAnimator.hasNext()) {
        ((AppBarLayout.f)paramValueAnimator.next()).a(f, paramh.A());
      }
    }
  }
  
  public static abstract interface c<T extends AppBarLayout>
  {
    public abstract void a(T paramT, int paramInt);
  }
  
  public static abstract class d
  {
    public abstract void a(AppBarLayout paramAppBarLayout, View paramView, float paramFloat);
  }
  
  public static class e
    extends AppBarLayout.d
  {
    private final Rect a = new Rect();
    private final Rect b = new Rect();
    
    private static void b(Rect paramRect, AppBarLayout paramAppBarLayout, View paramView)
    {
      paramView.getDrawingRect(paramRect);
      paramAppBarLayout.offsetDescendantRectToMyCoords(paramView, paramRect);
      paramRect.offset(0, -paramAppBarLayout.getTopInset());
    }
    
    public void a(AppBarLayout paramAppBarLayout, View paramView, float paramFloat)
    {
      b(this.a, paramAppBarLayout, paramView);
      float f = this.a.top - Math.abs(paramFloat);
      if (f <= 0.0F)
      {
        paramFloat = t0.a.a(Math.abs(f / this.a.height()), 0.0F, 1.0F);
        f = -f;
        paramFloat = 1.0F - paramFloat;
        paramFloat = f - this.a.height() * 0.3F * (1.0F - paramFloat * paramFloat);
        paramView.setTranslationY(paramFloat);
        paramView.getDrawingRect(this.b);
        this.b.offset(0, (int)-paramFloat);
        x.x0(paramView, this.b);
        return;
      }
      x.x0(paramView, null);
      paramView.setTranslationY(0.0F);
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(float paramFloat, int paramInt);
  }
  
  public static abstract interface g
    extends AppBarLayout.c<AppBarLayout>
  {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */