package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R.attr;
import androidx.core.view.a;
import androidx.core.view.m;
import androidx.core.view.n;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.x;
import java.util.ArrayList;
import java.util.List;
import y0.d;
import y0.d.a;
import y0.f;

public class NestedScrollView
  extends FrameLayout
  implements p, m
{
  private static final a A = new a();
  private static final int[] B = { 16843130 };
  private long a;
  private final Rect b = new Rect();
  private OverScroller c;
  public EdgeEffect d;
  public EdgeEffect e;
  private int f;
  private boolean g = true;
  private boolean h = false;
  private View i = null;
  private boolean j = false;
  private VelocityTracker k;
  private boolean l;
  private boolean m = true;
  private int n;
  private int o;
  private int p;
  private int q = -1;
  private final int[] r = new int[2];
  private final int[] s = new int[2];
  private int t;
  private int u;
  private SavedState v;
  private final q w;
  private final n x;
  private float y;
  private b z;
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.nestedScrollViewStyle);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = g.a(paramContext, paramAttributeSet);
    this.e = g.a(paramContext, paramAttributeSet);
    x();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, B, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.w = new q(this);
    this.x = new n(this);
    setNestedScrollingEnabled(true);
    x.q0(this, A);
  }
  
  private static boolean A(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (A((View)paramView1, paramView2));
  }
  
  private boolean B(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    return (this.b.bottom + paramInt1 >= getScrollY()) && (this.b.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private void C(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i1 = getScrollY();
    scrollBy(0, paramInt1);
    i1 = getScrollY() - i1;
    if (paramArrayOfInt != null) {
      paramArrayOfInt[1] += i1;
    }
    this.x.e(0, i1, 0, paramInt1 - i1, null, paramInt2, paramArrayOfInt);
  }
  
  private void D(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.q)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.f = ((int)paramMotionEvent.getY(i1));
      this.q = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.k;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private void G()
  {
    VelocityTracker localVelocityTracker = this.k;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.k = null;
    }
  }
  
  private int H(int paramInt, float paramFloat)
  {
    float f1 = paramFloat / getWidth();
    float f2 = paramInt / getHeight();
    float f3 = g.b(this.d);
    paramFloat = 0.0F;
    EdgeEffect localEdgeEffect;
    if (f3 != 0.0F)
    {
      f1 = -g.d(this.d, -f2, f1);
      paramFloat = f1;
      if (g.b(this.d) == 0.0F) {
        localEdgeEffect = this.d;
      }
    }
    for (paramFloat = f1;; paramFloat = f1)
    {
      localEdgeEffect.onRelease();
      do
      {
        break;
        if (g.b(this.e) == 0.0F) {
          break;
        }
        f1 = g.d(this.e, f2, 1.0F - f1);
        paramFloat = f1;
      } while (g.b(this.e) != 0.0F);
      localEdgeEffect = this.e;
    }
    paramInt = Math.round(paramFloat * getHeight());
    if (paramInt != 0) {
      invalidate();
    }
    return paramInt;
  }
  
  private void I(boolean paramBoolean)
  {
    if (paramBoolean) {
      Q(2, 1);
    } else {
      S(1);
    }
    this.u = getScrollY();
    x.h0(this);
  }
  
  private boolean J(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = getHeight();
    int i1 = getScrollY();
    i2 += i1;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    View localView = r(bool1, paramInt2, paramInt3);
    Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    if ((paramInt2 >= i1) && (paramInt3 <= i2))
    {
      bool1 = bool2;
    }
    else
    {
      if (bool1) {
        paramInt2 -= i1;
      } else {
        paramInt2 = paramInt3 - i2;
      }
      k(paramInt2);
      bool1 = true;
    }
    if (localObject != findFocus()) {
      ((View)localObject).requestFocus(paramInt1);
    }
    return bool1;
  }
  
  private void K(View paramView)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    int i1 = f(this.b);
    if (i1 != 0) {
      scrollBy(0, i1);
    }
  }
  
  private boolean L(Rect paramRect, boolean paramBoolean)
  {
    int i1 = f(paramRect);
    boolean bool;
    if (i1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramBoolean)
      {
        scrollBy(0, i1);
        return bool;
      }
      M(0, i1);
    }
    return bool;
  }
  
  private void N(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getHeight();
      int i2 = localLayoutParams.topMargin;
      int i3 = localLayoutParams.bottomMargin;
      int i4 = getHeight();
      int i5 = getPaddingTop();
      int i6 = getPaddingBottom();
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, Math.max(0, i1 + i2 + i3 - (i4 - i5 - i6))));
      this.c.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1, paramInt3);
      I(paramBoolean);
    }
    else
    {
      if (!this.c.isFinished()) {
        a();
      }
      scrollBy(paramInt1, paramInt2);
    }
    this.a = AnimationUtils.currentAnimationTimeMillis();
  }
  
  private boolean R(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (g.b(this.d) != 0.0F)
    {
      g.d(this.d, 0.0F, paramMotionEvent.getY() / getHeight());
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (g.b(this.e) != 0.0F)
    {
      g.d(this.e, 0.0F, 1.0F - paramMotionEvent.getY() / getHeight());
      return true;
    }
    return bool;
  }
  
  private void a()
  {
    this.c.abortAnimation();
    S(1);
  }
  
  private boolean d()
  {
    int i1 = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      bool1 = bool2;
      if (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin > getHeight() - getPaddingTop() - getPaddingBottom()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static int e(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      if (paramInt2 + paramInt1 > paramInt3) {
        return paramInt3 - paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (this.y == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.y = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return this.y;
  }
  
  private void k(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.m)
      {
        M(0, paramInt);
        return;
      }
      scrollBy(0, paramInt);
    }
  }
  
  private boolean l(int paramInt)
  {
    EdgeEffect localEdgeEffect;
    if (g.b(this.d) != 0.0F) {
      localEdgeEffect = this.d;
    }
    for (;;)
    {
      localEdgeEffect.onAbsorb(paramInt);
      break;
      if (g.b(this.e) == 0.0F) {
        break label50;
      }
      localEdgeEffect = this.e;
      paramInt = -paramInt;
    }
    return true;
    label50:
    return false;
  }
  
  private void p()
  {
    this.j = false;
    G();
    S(0);
    this.d.onRelease();
    this.e.onRelease();
  }
  
  private View r(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    int i6 = localArrayList.size();
    Object localObject2 = null;
    int i3 = 0;
    int i2;
    for (int i4 = i3; i3 < i6; i4 = i2)
    {
      View localView = (View)localArrayList.get(i3);
      int i5 = localView.getTop();
      int i7 = localView.getBottom();
      Object localObject1 = localObject2;
      i2 = i4;
      if (paramInt1 < i7)
      {
        localObject1 = localObject2;
        i2 = i4;
        if (i5 < paramInt2)
        {
          int i1;
          if ((paramInt1 < i5) && (i7 < paramInt2)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (localObject2 == null)
          {
            localObject1 = localView;
            i2 = i1;
          }
          else
          {
            if (((paramBoolean) && (i5 < localObject2.getTop())) || ((!paramBoolean) && (i7 > localObject2.getBottom()))) {
              i5 = 1;
            } else {
              i5 = 0;
            }
            if (i4 != 0)
            {
              localObject1 = localObject2;
              i2 = i4;
              if (i1 == 0) {
                break label233;
              }
              localObject1 = localObject2;
              i2 = i4;
              if (i5 == 0) {
                break label233;
              }
            }
            else
            {
              if (i1 != 0)
              {
                localObject1 = localView;
                i2 = 1;
                break label233;
              }
              localObject1 = localObject2;
              i2 = i4;
              if (i5 == 0) {
                break label233;
              }
            }
            localObject1 = localView;
            i2 = i4;
          }
        }
      }
      label233:
      i3 += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  private boolean v(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
    {
      i1 = getScrollY();
      View localView = getChildAt(0);
      bool1 = bool2;
      if (paramInt2 >= localView.getTop() - i1)
      {
        bool1 = bool2;
        if (paramInt2 < localView.getBottom() - i1)
        {
          bool1 = bool2;
          if (paramInt1 >= localView.getLeft())
          {
            bool1 = bool2;
            if (paramInt1 < localView.getRight()) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void w()
  {
    VelocityTracker localVelocityTracker = this.k;
    if (localVelocityTracker == null)
    {
      this.k = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void x()
  {
    this.c = new OverScroller(getContext());
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.n = localViewConfiguration.getScaledTouchSlop();
    this.o = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.p = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void y()
  {
    if (this.k == null) {
      this.k = VelocityTracker.obtain();
    }
  }
  
  private boolean z(View paramView)
  {
    return B(paramView, 0, getHeight()) ^ true;
  }
  
  boolean E(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int i3 = getOverScrollMode();
    int i1 = computeHorizontalScrollRange();
    int i2 = computeHorizontalScrollExtent();
    boolean bool2 = false;
    if (i1 > i2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if ((i3 != 0) && ((i3 != 1) || (i1 == 0))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i3 != 0) && ((i3 != 1) || (i2 == 0))) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    paramInt3 += paramInt1;
    if (i1 == 0) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramInt7;
    }
    paramInt4 += paramInt2;
    if (i2 == 0) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramInt8;
    }
    paramInt7 = -paramInt1;
    paramInt1 += paramInt5;
    paramInt5 = -paramInt2;
    paramInt2 += paramInt6;
    if (paramInt3 > paramInt1)
    {
      paramBoolean = true;
    }
    else if (paramInt3 < paramInt7)
    {
      paramBoolean = true;
      paramInt1 = paramInt7;
    }
    else
    {
      paramBoolean = false;
      paramInt1 = paramInt3;
    }
    boolean bool1;
    if (paramInt4 > paramInt2)
    {
      bool1 = true;
    }
    else if (paramInt4 < paramInt5)
    {
      bool1 = true;
      paramInt2 = paramInt5;
    }
    else
    {
      bool1 = false;
      paramInt2 = paramInt4;
    }
    if ((bool1) && (!u(1))) {
      this.c.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
    }
    onOverScrolled(paramInt1, paramInt2, paramBoolean, bool1);
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!bool1) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean F(int paramInt)
  {
    if (paramInt == 130) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = getHeight();
    if (i1 != 0)
    {
      this.b.top = (getScrollY() + i2);
      i1 = getChildCount();
      if (i1 > 0)
      {
        localObject = getChildAt(i1 - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        i1 = ((View)localObject).getBottom() + localLayoutParams.bottomMargin + getPaddingBottom();
        localObject = this.b;
        if (((Rect)localObject).top + i2 > i1) {
          ((Rect)localObject).top = (i1 - i2);
        }
      }
    }
    else
    {
      this.b.top = (getScrollY() - i2);
      localObject = this.b;
      if (((Rect)localObject).top < 0) {
        ((Rect)localObject).top = 0;
      }
    }
    Object localObject = this.b;
    int i1 = ((Rect)localObject).top;
    i2 += i1;
    ((Rect)localObject).bottom = i2;
    return J(paramInt, i1, i2);
  }
  
  public final void M(int paramInt1, int paramInt2)
  {
    N(paramInt1, paramInt2, 250, false);
  }
  
  void O(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    N(paramInt1 - getScrollX(), paramInt2 - getScrollY(), paramInt3, paramBoolean);
  }
  
  void P(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    O(paramInt1, paramInt2, 250, paramBoolean);
  }
  
  public boolean Q(int paramInt1, int paramInt2)
  {
    return this.x.p(paramInt1, paramInt2);
  }
  
  public void S(int paramInt)
  {
    this.x.r(paramInt);
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public boolean b(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i2 = getMaxScrollAmount();
    if ((localView2 != null) && (B(localView2, i2, getHeight())))
    {
      localView2.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(localView2, this.b);
      k(f(this.b));
      localView2.requestFocus(paramInt);
    }
    else
    {
      int i1;
      if ((paramInt == 33) && (getScrollY() < i2))
      {
        i1 = getScrollY();
      }
      else
      {
        i1 = i2;
        if (paramInt == 130)
        {
          i1 = i2;
          if (getChildCount() > 0)
          {
            localView2 = getChildAt(0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView2.getLayoutParams();
            i1 = Math.min(localView2.getBottom() + localLayoutParams.bottomMargin - (getScrollY() + getHeight() - getPaddingBottom()), i2);
          }
        }
      }
      if (i1 == 0) {
        return false;
      }
      if (paramInt != 130) {
        i1 = -i1;
      }
      k(i1);
    }
    if ((localView1 != null) && (localView1.isFocused()) && (z(localView1)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  public void c(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.w.c(paramView1, paramView2, paramInt1, paramInt2);
    Q(2, paramInt2);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    if (this.c.isFinished()) {
      return;
    }
    this.c.computeScrollOffset();
    int i2 = this.c.getCurrY();
    int i1 = i2 - this.u;
    this.u = i2;
    Object localObject = this.s;
    int i3 = 0;
    localObject[1] = 0;
    g(0, i1, (int[])localObject, null, 1);
    i2 = i1 - this.s[1];
    int i4 = getScrollRange();
    i1 = i2;
    if (i2 != 0)
    {
      i1 = getScrollY();
      E(0, i2, getScrollX(), i1, 0, i4, 0, 0, false);
      i1 = getScrollY() - i1;
      i2 -= i1;
      localObject = this.s;
      localObject[1] = 0;
      h(0, i1, 0, i2, this.r, 1, (int[])localObject);
      i1 = i2 - this.s[1];
    }
    if (i1 != 0)
    {
      int i5 = getOverScrollMode();
      if (i5 != 0)
      {
        i2 = i3;
        if (i5 == 1)
        {
          i2 = i3;
          if (i4 <= 0) {}
        }
      }
      else
      {
        i2 = 1;
      }
      if (i2 != 0)
      {
        if (i1 < 0)
        {
          if (!this.d.isFinished()) {
            break label241;
          }
          localObject = this.d;
        }
        else
        {
          if (!this.e.isFinished()) {
            break label241;
          }
          localObject = this.e;
        }
        ((EdgeEffect)localObject).onAbsorb((int)this.c.getCurrVelocity());
      }
      label241:
      a();
    }
    if (!this.c.isFinished())
    {
      x.h0(this);
      return;
    }
    S(1);
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int i2 = getChildCount();
    int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i2 == 0) {
      return i1;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    i2 = localView.getBottom() + localLayoutParams.bottomMargin;
    int i3 = getScrollY();
    int i4 = Math.max(0, i2 - i1);
    if (i3 < 0) {
      return i2 - i3;
    }
    i1 = i2;
    if (i3 > i4) {
      i1 = i2 + (i3 - i4);
    }
    return i1;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (q(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.x.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.x.b(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return g(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.x.f(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i8 = getScrollY();
    boolean bool = this.d.isFinished();
    int i5 = 0;
    int i9;
    int i1;
    int i7;
    int i6;
    int i2;
    int i4;
    int i3;
    if (!bool)
    {
      i9 = paramCanvas.save();
      i1 = getWidth();
      i7 = getHeight();
      i6 = Math.min(0, i8);
      if (getClipToPadding())
      {
        i1 -= getPaddingLeft() + getPaddingRight();
        i2 = getPaddingLeft() + 0;
      }
      else
      {
        i2 = 0;
      }
      i4 = i7;
      i3 = i6;
      if (getClipToPadding())
      {
        i4 = i7 - (getPaddingTop() + getPaddingBottom());
        i3 = i6 + getPaddingTop();
      }
      paramCanvas.translate(i2, i3);
      this.d.setSize(i1, i4);
      if (this.d.draw(paramCanvas)) {
        x.h0(this);
      }
      paramCanvas.restoreToCount(i9);
    }
    if (!this.e.isFinished())
    {
      i9 = paramCanvas.save();
      i3 = getWidth();
      i6 = getHeight();
      i7 = Math.max(getScrollRange(), i8) + i6;
      i2 = i5;
      i1 = i3;
      if (getClipToPadding())
      {
        i1 = i3 - (getPaddingLeft() + getPaddingRight());
        i2 = 0 + getPaddingLeft();
      }
      i4 = i7;
      i3 = i6;
      if (getClipToPadding())
      {
        i3 = i6 - (getPaddingTop() + getPaddingBottom());
        i4 = i7 - getPaddingBottom();
      }
      paramCanvas.translate(i2 - i1, i4);
      paramCanvas.rotate(180.0F, i1, 0.0F);
      this.e.setSize(i1, i3);
      if (this.e.draw(paramCanvas)) {
        x.h0(this);
      }
      paramCanvas.restoreToCount(i9);
    }
  }
  
  protected int f(Rect paramRect)
  {
    int i1 = getChildCount();
    int i4 = 0;
    if (i1 == 0) {
      return 0;
    }
    int i5 = getHeight();
    int i2 = getScrollY();
    int i3 = i2 + i5;
    int i6 = getVerticalFadingEdgeLength();
    i1 = i2;
    if (paramRect.top > 0) {
      i1 = i2 + i6;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    if (paramRect.bottom < localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin) {
      i2 = i3 - i6;
    } else {
      i2 = i3;
    }
    i6 = paramRect.bottom;
    if ((i6 > i2) && (paramRect.top > i1))
    {
      if (paramRect.height() > i5) {
        i1 = paramRect.top - i1;
      } else {
        i1 = paramRect.bottom - i2;
      }
      return Math.min(i1 + 0, localView.getBottom() + localLayoutParams.bottomMargin - i3);
    }
    i3 = i4;
    if (paramRect.top < i1)
    {
      i3 = i4;
      if (i6 < i2)
      {
        if (paramRect.height() > i5) {
          i1 = 0 - (i2 - paramRect.bottom);
        } else {
          i1 = 0 - (i1 - paramRect.top);
        }
        i3 = Math.max(i1, -getScrollY());
      }
    }
    return i3;
  }
  
  public boolean g(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return this.x.d(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    View localView = getChildAt(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    i2 = localView.getBottom() + localLayoutParams.bottomMargin - getScrollY() - (i2 - i3);
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return this.w.a();
  }
  
  int getScrollRange()
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i2 > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      i1 = Math.max(0, localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin - (getHeight() - getPaddingTop() - getPaddingBottom()));
    }
    return i1;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getScrollY();
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public void h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int paramInt5, int[] paramArrayOfInt2)
  {
    this.x.e(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return u(0);
  }
  
  public void i(View paramView, int paramInt)
  {
    this.w.e(paramView, paramInt);
    S(paramInt);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.x.l();
  }
  
  public void j(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    g(paramInt1, paramInt2, paramArrayOfInt, null, paramInt3);
  }
  
  public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    C(paramInt4, paramInt5, paramArrayOfInt);
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, 0));
  }
  
  public void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    C(paramInt4, paramInt5, null);
  }
  
  public boolean o(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0x2) != 0;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.h = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0)
    {
      if (paramMotionEvent.getAction() != 8) {
        return false;
      }
      if (!this.j)
      {
        float f1 = paramMotionEvent.getAxisValue(9);
        if (f1 != 0.0F)
        {
          int i2 = (int)(f1 * getVerticalScrollFactorCompat());
          int i1 = getScrollRange();
          int i3 = getScrollY();
          i2 = i3 - i2;
          if (i2 < 0) {
            i1 = 0;
          } else if (i2 <= i1) {
            i1 = i2;
          }
          if (i1 != i3)
          {
            super.scrollTo(getScrollX(), i1);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    boolean bool3 = true;
    boolean bool2 = true;
    if ((i1 == 2) && (this.j)) {
      return true;
    }
    i1 &= 0xFF;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 6) {
              break label407;
            }
            D(paramMotionEvent);
            break label407;
          }
        }
        else
        {
          i1 = this.q;
          if (i1 == -1) {
            break label407;
          }
          int i2 = paramMotionEvent.findPointerIndex(i1);
          if (i2 == -1)
          {
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("Invalid pointerId=");
            paramMotionEvent.append(i1);
            paramMotionEvent.append(" in onInterceptTouchEvent");
            Log.e("NestedScrollView", paramMotionEvent.toString());
            break label407;
          }
          i1 = (int)paramMotionEvent.getY(i2);
          if ((Math.abs(i1 - this.f) <= this.n) || ((0x2 & getNestedScrollAxes()) != 0)) {
            break label407;
          }
          this.j = true;
          this.f = i1;
          y();
          this.k.addMovement(paramMotionEvent);
          this.t = 0;
          paramMotionEvent = getParent();
          if (paramMotionEvent == null) {
            break label407;
          }
          paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          break label407;
        }
      }
      this.j = false;
      this.q = -1;
      G();
      if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        x.h0(this);
      }
      S(0);
    }
    else
    {
      i1 = (int)paramMotionEvent.getY();
      boolean bool1;
      if (!v((int)paramMotionEvent.getX(), i1))
      {
        bool1 = bool2;
        if (!R(paramMotionEvent)) {
          if (!this.c.isFinished()) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        this.j = bool1;
        G();
      }
      else
      {
        this.f = i1;
        this.q = paramMotionEvent.getPointerId(0);
        w();
        this.k.addMovement(paramMotionEvent);
        this.c.computeScrollOffset();
        bool1 = bool3;
        if (!R(paramMotionEvent)) {
          if (!this.c.isFinished()) {
            bool1 = bool3;
          } else {
            bool1 = false;
          }
        }
        this.j = bool1;
        Q(2, 0);
      }
    }
    label407:
    return this.j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    this.g = false;
    View localView = this.i;
    if ((localView != null) && (A(localView, this))) {
      K(this.i);
    }
    this.i = null;
    if (!this.h)
    {
      if (this.v != null)
      {
        scrollTo(getScrollX(), this.v.a);
        this.v = null;
      }
      if (getChildCount() > 0)
      {
        localView = getChildAt(0);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        paramInt1 = localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      }
      int i1 = getPaddingTop();
      int i2 = getPaddingBottom();
      paramInt3 = getScrollY();
      paramInt1 = e(paramInt3, paramInt4 - paramInt2 - i1 - i2, paramInt1);
      if (paramInt1 != paramInt3) {
        scrollTo(getScrollX(), paramInt1);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    this.h = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.l) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = localView.getMeasuredHeight();
      int i1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - localLayoutParams.topMargin - localLayoutParams.bottomMargin;
      if (paramInt2 < i1) {
        localView.measure(FrameLayout.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      dispatchNestedFling(0.0F, paramFloat2, true);
      s((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    j(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    C(paramInt4, 0, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    c(paramView1, paramView2, paramInt, 0);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1;
    if (paramInt == 2)
    {
      i1 = 130;
    }
    else
    {
      i1 = paramInt;
      if (paramInt == 1) {
        i1 = 33;
      }
    }
    Object localObject = FocusFinder.getInstance();
    if (paramRect == null) {
      localObject = ((FocusFinder)localObject).findNextFocus(this, null, i1);
    } else {
      localObject = ((FocusFinder)localObject).findNextFocusFromRect(this, paramRect, i1);
    }
    if (localObject == null) {
      return false;
    }
    if (z((View)localObject)) {
      return false;
    }
    return ((View)localObject).requestFocus(i1, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.v = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = this.z;
    if (localb != null) {
      localb.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if (localView != null)
    {
      if (this == localView) {
        return;
      }
      if (B(localView, 0, paramInt4))
      {
        localView.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(localView, this.b);
        k(f(this.b));
      }
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return o(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    i(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    y();
    int i1 = paramMotionEvent.getActionMasked();
    int i4 = 0;
    if (i1 == 0) {
      this.t = 0;
    }
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.offsetLocation(0.0F, this.t);
    Object localObject;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 5)
            {
              if (i1 != 6) {
                break label925;
              }
              D(paramMotionEvent);
              this.f = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.q)));
              break label925;
            }
            i1 = paramMotionEvent.getActionIndex();
            this.f = ((int)paramMotionEvent.getY(i1));
            this.q = paramMotionEvent.getPointerId(i1);
            break label925;
          }
          if ((!this.j) || (getChildCount() <= 0) || (!this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {}
        }
      }
      for (;;)
      {
        x.h0(this);
        do
        {
          for (;;)
          {
            this.q = -1;
            p();
            break label925;
            int i5 = paramMotionEvent.findPointerIndex(this.q);
            if (i5 == -1)
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("Invalid pointerId=");
              paramMotionEvent.append(this.q);
              paramMotionEvent.append(" in onTouchEvent");
              Log.e("NestedScrollView", paramMotionEvent.toString());
              break label925;
            }
            int i3 = (int)paramMotionEvent.getY(i5);
            i1 = this.f - i3;
            int i2 = i1 - H(i1, paramMotionEvent.getX(i5));
            i1 = i2;
            if (!this.j)
            {
              i1 = i2;
              if (Math.abs(i2) > this.n)
              {
                localObject = getParent();
                if (localObject != null) {
                  ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
                }
                this.j = true;
                i1 = this.n;
                if (i2 > 0) {
                  i1 = i2 - i1;
                } else {
                  i1 = i2 + i1;
                }
              }
            }
            if (!this.j) {
              break label925;
            }
            i2 = i1;
            if (g(0, i1, this.s, this.r, 0))
            {
              i2 = i1 - this.s[1];
              this.t += this.r[1];
            }
            this.f = (i3 - this.r[1]);
            int i7 = getScrollY();
            int i6 = getScrollRange();
            i1 = getOverScrollMode();
            if ((i1 != 0) && ((i1 != 1) || (i6 <= 0))) {
              i3 = 0;
            } else {
              i3 = 1;
            }
            if ((E(0, i2, 0, getScrollY(), 0, i6, 0, 0, true)) && (!u(0))) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            int i8 = getScrollY() - i7;
            localObject = this.s;
            localObject[1] = 0;
            h(0, i8, 0, i2 - i8, this.r, 0, (int[])localObject);
            i8 = this.f;
            localObject = this.r;
            this.f = (i8 - localObject[1]);
            this.t += localObject[1];
            if (i3 != 0)
            {
              i2 -= this.s[1];
              i3 = i7 + i2;
              if (i3 < 0)
              {
                g.d(this.d, -i2 / getHeight(), paramMotionEvent.getX(i5) / getWidth());
                if (this.e.isFinished()) {}
              }
              else
              {
                for (paramMotionEvent = this.e;; paramMotionEvent = this.d)
                {
                  paramMotionEvent.onRelease();
                  break;
                  if (i3 <= i6) {
                    break;
                  }
                  g.d(this.e, i2 / getHeight(), 1.0F - paramMotionEvent.getX(i5) / getWidth());
                  if (this.d.isFinished()) {
                    break;
                  }
                }
              }
              if ((!this.d.isFinished()) || (!this.e.isFinished()))
              {
                x.h0(this);
                i1 = i4;
              }
            }
            if (i1 == 0) {
              break label925;
            }
            this.k.clear();
            break label925;
            paramMotionEvent = this.k;
            paramMotionEvent.computeCurrentVelocity(1000, this.p);
            i1 = (int)paramMotionEvent.getYVelocity(this.q);
            if (Math.abs(i1) < this.o) {
              break;
            }
            if (!l(i1))
            {
              i1 = -i1;
              float f1 = i1;
              if (!dispatchNestedPreFling(0.0F, f1))
              {
                dispatchNestedFling(0.0F, f1, true);
                s(i1);
              }
            }
          }
        } while (!this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()));
      }
    }
    else
    {
      if (getChildCount() == 0) {
        return false;
      }
      if (this.j)
      {
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.c.isFinished()) {
        a();
      }
      this.f = ((int)paramMotionEvent.getY());
      this.q = paramMotionEvent.getPointerId(0);
      Q(2, 0);
    }
    label925:
    paramMotionEvent = this.k;
    if (paramMotionEvent != null) {
      paramMotionEvent.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return true;
  }
  
  public boolean q(KeyEvent paramKeyEvent)
  {
    this.b.setEmpty();
    boolean bool3 = d();
    boolean bool1 = false;
    boolean bool2 = false;
    int i1 = 130;
    if (!bool3)
    {
      bool1 = bool2;
      if (isFocused())
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 4)
        {
          View localView = findFocus();
          paramKeyEvent = localView;
          if (localView == this) {
            paramKeyEvent = null;
          }
          paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent != this)
            {
              bool1 = bool2;
              if (paramKeyEvent.requestFocus(130)) {
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    if (paramKeyEvent.getAction() == 0)
    {
      int i2 = paramKeyEvent.getKeyCode();
      if (i2 != 19)
      {
        if (i2 != 20)
        {
          if (i2 != 62) {
            return false;
          }
          if (paramKeyEvent.isShiftPressed()) {
            i1 = 33;
          }
          F(i1);
          return false;
        }
        if (!paramKeyEvent.isAltPressed()) {
          return b(130);
        }
        return t(130);
      }
      if (!paramKeyEvent.isAltPressed()) {
        return b(33);
      }
      bool1 = t(33);
    }
    return bool1;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.g) {
      K(paramView2);
    } else {
      this.i = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    return L(paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      G();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.g = true;
    super.requestLayout();
  }
  
  public void s(int paramInt)
  {
    if (getChildCount() > 0)
    {
      this.c.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      I(true);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      int i7 = getWidth();
      int i8 = getPaddingLeft();
      int i9 = getPaddingRight();
      int i10 = localView.getWidth();
      int i11 = localLayoutParams.leftMargin;
      int i12 = localLayoutParams.rightMargin;
      int i1 = getHeight();
      int i2 = getPaddingTop();
      int i3 = getPaddingBottom();
      int i4 = localView.getHeight();
      int i5 = localLayoutParams.topMargin;
      int i6 = localLayoutParams.bottomMargin;
      paramInt1 = e(paramInt1, i7 - i8 - i9, i10 + i11 + i12);
      paramInt2 = e(paramInt2, i1 - i2 - i3, i4 + i5 + i6);
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
    {
      this.l = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.x.m(paramBoolean);
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.z = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return Q(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    S(0);
  }
  
  public boolean t(int paramInt)
  {
    int i1;
    if (paramInt == 130) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = getHeight();
    Object localObject = this.b;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = i2;
    if (i1 != 0)
    {
      i1 = getChildCount();
      if (i1 > 0)
      {
        localObject = getChildAt(i1 - 1);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        this.b.bottom = (((View)localObject).getBottom() + localLayoutParams.bottomMargin + getPaddingBottom());
        localObject = this.b;
        ((Rect)localObject).top = (((Rect)localObject).bottom - i2);
      }
    }
    localObject = this.b;
    return J(paramInt, ((Rect)localObject).top, ((Rect)localObject).bottom);
  }
  
  public boolean u(int paramInt)
  {
    return this.x.k(paramInt);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    public int a;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HorizontalScrollView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" scrollPosition=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
    }
    
    class a
      implements Parcelable.Creator<NestedScrollView.SavedState>
    {
      public NestedScrollView.SavedState a(Parcel paramParcel)
      {
        return new NestedScrollView.SavedState(paramParcel);
      }
      
      public NestedScrollView.SavedState[] b(int paramInt)
      {
        return new NestedScrollView.SavedState[paramInt];
      }
    }
  }
  
  static class a
    extends a
  {
    public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.f(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      boolean bool;
      if (paramView.getScrollRange() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setScrollY(paramView.getScrollY());
      f.a(paramAccessibilityEvent, paramView.getScrollX());
      f.b(paramAccessibilityEvent, paramView.getScrollRange());
    }
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramView = (NestedScrollView)paramView;
      paramd.c0(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramd.z0(true);
          if (paramView.getScrollY() > 0)
          {
            paramd.b(d.a.r);
            paramd.b(d.a.C);
          }
          if (paramView.getScrollY() < i)
          {
            paramd.b(d.a.q);
            paramd.b(d.a.E);
          }
        }
      }
    }
    
    public boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.j(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      if (paramInt != 4096) {
        if ((paramInt != 8192) && (paramInt != 16908344))
        {
          if (paramInt != 16908346) {
            return false;
          }
        }
        else
        {
          paramInt = paramView.getHeight();
          i = paramView.getPaddingBottom();
          j = paramView.getPaddingTop();
          paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
          if (paramInt != paramView.getScrollY())
          {
            paramView.P(0, paramInt, true);
            return true;
          }
          return false;
        }
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.min(paramView.getScrollY() + (paramInt - i - j), paramView.getScrollRange());
      if (paramInt != paramView.getScrollY())
      {
        paramView.P(0, paramInt, true);
        return true;
      }
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */