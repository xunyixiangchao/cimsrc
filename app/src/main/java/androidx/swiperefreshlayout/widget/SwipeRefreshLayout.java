package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.core.view.m;
import androidx.core.view.n;
import androidx.core.view.q;
import androidx.core.view.x;
import androidx.core.widget.j;

public class SwipeRefreshLayout
  extends ViewGroup
  implements m
{
  private static final String P = SwipeRefreshLayout.class.getSimpleName();
  private static final int[] Q = { 16842766 };
  int A;
  b B;
  private Animation C;
  private Animation E;
  private Animation F;
  private Animation G;
  private Animation H;
  boolean I;
  private int J;
  boolean K;
  private i L;
  private Animation.AnimationListener M = new a();
  private final Animation N = new f();
  private final Animation O = new g();
  private View a;
  j b;
  boolean c = false;
  private int d;
  private float e = -1.0F;
  private float f;
  private final q g;
  private final n h;
  private final int[] i = new int[2];
  private final int[] j = new int[2];
  private boolean k;
  private int l;
  int m;
  private float n;
  private float o;
  private boolean p;
  private int q = -1;
  boolean r;
  private boolean s;
  private final DecelerateInterpolator t;
  a u;
  private int v = -1;
  protected int w;
  float x;
  protected int y;
  int z;
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.l = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.t = new DecelerateInterpolator(2.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.J = ((int)(localDisplayMetrics.density * 40.0F));
    d();
    setChildrenDrawingOrderEnabled(true);
    int i1 = (int)(localDisplayMetrics.density * 64.0F);
    this.z = i1;
    this.e = i1;
    this.g = new q(this);
    this.h = new n(this);
    setNestedScrollingEnabled(true);
    i1 = -this.J;
    this.m = i1;
    this.y = i1;
    j(1.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, Q);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.w = paramInt;
    this.N.reset();
    this.N.setDuration(200L);
    this.N.setInterpolator(this.t);
    if (paramAnimationListener != null) {
      this.u.b(paramAnimationListener);
    }
    this.u.clearAnimation();
    this.u.startAnimation(this.N);
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    if (this.r)
    {
      t(paramInt, paramAnimationListener);
      return;
    }
    this.w = paramInt;
    this.O.reset();
    this.O.setDuration(200L);
    this.O.setInterpolator(this.t);
    if (paramAnimationListener != null) {
      this.u.b(paramAnimationListener);
    }
    this.u.clearAnimation();
    this.u.startAnimation(this.O);
  }
  
  private void d()
  {
    this.u = new a(getContext(), -328966);
    b localb = new b(getContext());
    this.B = localb;
    localb.l(1);
    this.u.setImageDrawable(this.B);
    this.u.setVisibility(8);
    addView(this.u);
  }
  
  private void e()
  {
    if (this.a == null)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (!localView.equals(this.u))
        {
          this.a = localView;
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void f(float paramFloat)
  {
    if (paramFloat > this.e)
    {
      n(true, true);
      return;
    }
    this.c = false;
    this.B.j(0.0F, 0.0F);
    e locale = null;
    if (!this.r) {
      locale = new e();
    }
    b(this.m, locale);
    this.B.d(false);
  }
  
  private boolean g(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private void i(float paramFloat)
  {
    this.B.d(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.e));
    float f2 = (float)Math.max(f1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.e;
    int i1 = this.A;
    if (i1 > 0) {}
    float f3;
    for (;;)
    {
      f3 = i1;
      break;
      if (this.K) {
        i1 = this.z - this.y;
      } else {
        i1 = this.z;
      }
    }
    double d1 = Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3) / 4.0F;
    f4 = (float)(d1 - Math.pow(d1, 2.0D)) * 2.0F;
    i1 = this.y;
    int i2 = (int)(f3 * f1 + f3 * f4 * 2.0F);
    if (this.u.getVisibility() != 0) {
      this.u.setVisibility(0);
    }
    if (!this.r)
    {
      this.u.setScaleX(1.0F);
      this.u.setScaleY(1.0F);
    }
    if (this.r) {
      setAnimationProgress(Math.min(1.0F, paramFloat / this.e));
    }
    if (paramFloat < this.e)
    {
      if ((this.B.getAlpha() > 76) && (!g(this.F))) {
        r();
      }
    }
    else if ((this.B.getAlpha() < 255) && (!g(this.G))) {
      q();
    }
    this.B.j(0.0F, Math.min(0.8F, f2 * 0.8F));
    this.B.e(Math.min(1.0F, f2));
    this.B.g((f2 * 0.4F - 0.25F + f4 * 2.0F) * 0.5F);
    setTargetOffsetTopAndBottom(i1 + i2 - this.m);
  }
  
  private void k(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.q)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.q = paramMotionEvent.getPointerId(i1);
    }
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != paramBoolean1)
    {
      this.I = paramBoolean2;
      e();
      this.c = paramBoolean1;
      if (paramBoolean1)
      {
        a(this.m, this.M);
        return;
      }
      s(this.M);
    }
  }
  
  private Animation o(final int paramInt1, final int paramInt2)
  {
    d locald = new d(paramInt1, paramInt2);
    locald.setDuration(300L);
    this.u.b(null);
    this.u.clearAnimation();
    this.u.startAnimation(locald);
    return locald;
  }
  
  private void p(float paramFloat)
  {
    float f1 = this.o;
    int i1 = this.d;
    if ((paramFloat - f1 > i1) && (!this.p))
    {
      this.n = (f1 + i1);
      this.p = true;
      this.B.setAlpha(76);
    }
  }
  
  private void q()
  {
    this.G = o(this.B.getAlpha(), 255);
  }
  
  private void r()
  {
    this.F = o(this.B.getAlpha(), 76);
  }
  
  private void setColorViewAlpha(int paramInt)
  {
    this.u.getBackground().setAlpha(paramInt);
    this.B.setAlpha(paramInt);
  }
  
  private void t(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    this.w = paramInt;
    this.x = this.u.getScaleX();
    h localh = new h();
    this.H = localh;
    localh.setDuration(150L);
    if (paramAnimationListener != null) {
      this.u.b(paramAnimationListener);
    }
    this.u.clearAnimation();
    this.u.startAnimation(this.H);
  }
  
  private void u(Animation.AnimationListener paramAnimationListener)
  {
    this.u.setVisibility(0);
    this.B.setAlpha(255);
    b localb = new b();
    this.C = localb;
    localb.setDuration(this.l);
    if (paramAnimationListener != null) {
      this.u.b(paramAnimationListener);
    }
    this.u.clearAnimation();
    this.u.startAnimation(this.C);
  }
  
  public boolean c()
  {
    Object localObject = this.L;
    if (localObject != null) {
      return ((i)localObject).a(this, this.a);
    }
    localObject = this.a;
    if ((localObject instanceof ListView)) {
      return j.a((ListView)localObject, -1);
    }
    return ((View)localObject).canScrollVertically(-1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.h.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.h.b(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.h.c(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.h.f(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.v;
    if (i1 < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i1;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= i1) {
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
  }
  
  public int getNestedScrollAxes()
  {
    return this.g.a();
  }
  
  public int getProgressCircleDiameter()
  {
    return this.J;
  }
  
  public int getProgressViewEndOffset()
  {
    return this.z;
  }
  
  public int getProgressViewStartOffset()
  {
    return this.y;
  }
  
  public boolean h()
  {
    return this.c;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.h.j();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.h.l();
  }
  
  void j(float paramFloat)
  {
    int i1 = this.w;
    setTargetOffsetTopAndBottom(i1 + (int)((this.y - i1) * paramFloat) - this.u.getTop());
  }
  
  void l()
  {
    this.u.clearAnimation();
    this.B.stop();
    this.u.setVisibility(8);
    setColorViewAlpha(255);
    if (this.r) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(this.y - this.m);
    }
    this.m = this.u.getTop();
  }
  
  public void m(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.r = paramBoolean;
    this.y = paramInt1;
    this.z = paramInt2;
    this.K = true;
    l();
    this.c = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    e();
    int i1 = paramMotionEvent.getActionMasked();
    if ((this.s) && (i1 == 0)) {
      this.s = false;
    }
    if ((isEnabled()) && (!this.s) && (!c()) && (!this.c))
    {
      if (this.k) {
        return false;
      }
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 6) {
                break label210;
              }
              k(paramMotionEvent);
              break label210;
            }
          }
          else
          {
            i1 = this.q;
            if (i1 == -1)
            {
              Log.e(P, "Got ACTION_MOVE event but don't have an active pointer id.");
              return false;
            }
            i1 = paramMotionEvent.findPointerIndex(i1);
            if (i1 < 0) {
              return false;
            }
            p(paramMotionEvent.getY(i1));
            break label210;
          }
        }
        this.p = false;
        this.q = -1;
      }
      else
      {
        setTargetOffsetTopAndBottom(this.y - this.u.getTop());
        i1 = paramMotionEvent.getPointerId(0);
        this.q = i1;
        this.p = false;
        i1 = paramMotionEvent.findPointerIndex(i1);
        if (i1 < 0) {
          return false;
        }
        this.o = paramMotionEvent.getY(i1);
      }
      label210:
      return this.p;
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {
      return;
    }
    if (this.a == null) {
      e();
    }
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    ((View)localObject).layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = this.u.getMeasuredWidth();
    paramInt2 = this.u.getMeasuredHeight();
    localObject = this.u;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = this.m;
    ((ImageView)localObject).layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.a == null) {
      e();
    }
    View localView = this.a;
    if (localView == null) {
      return;
    }
    localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.u.measure(View.MeasureSpec.makeMeasureSpec(this.J, 1073741824), View.MeasureSpec.makeMeasureSpec(this.J, 1073741824));
    this.v = -1;
    paramInt1 = 0;
    while (paramInt1 < getChildCount())
    {
      if (getChildAt(paramInt1) == this.u)
      {
        this.v = paramInt1;
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      float f1 = this.f;
      if (f1 > 0.0F)
      {
        float f2 = paramInt2;
        if (f2 > f1)
        {
          paramArrayOfInt[1] = (paramInt2 - (int)f1);
          this.f = 0.0F;
        }
        else
        {
          this.f = (f1 - f2);
          paramArrayOfInt[1] = paramInt2;
        }
        i(this.f);
      }
    }
    if ((this.K) && (paramInt2 > 0) && (this.f == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
      this.u.setVisibility(8);
    }
    paramView = this.i;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
    {
      paramArrayOfInt[0] += paramView[0];
      paramArrayOfInt[1] += paramView[1];
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.j);
    paramInt1 = paramInt4 + this.j[1];
    if ((paramInt1 < 0) && (!c()))
    {
      float f1 = this.f + Math.abs(paramInt1);
      this.f = f1;
      i(f1);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.g.b(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    this.f = 0.0F;
    this.k = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!this.s) && (!this.c) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.g.d(paramView);
    this.k = false;
    float f1 = this.f;
    if (f1 > 0.0F)
    {
      f(f1);
      this.f = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if ((this.s) && (i1 == 0)) {
      this.s = false;
    }
    if ((isEnabled()) && (!this.s) && (!c()) && (!this.c))
    {
      if (this.k) {
        return false;
      }
      if (i1 != 0)
      {
        float f1;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 5)
              {
                if (i1 != 6) {
                  return true;
                }
                k(paramMotionEvent);
                return true;
              }
              i1 = paramMotionEvent.getActionIndex();
              if (i1 < 0)
              {
                Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
              }
              this.q = paramMotionEvent.getPointerId(i1);
              return true;
            }
            return false;
          }
          i1 = paramMotionEvent.findPointerIndex(this.q);
          if (i1 < 0)
          {
            Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
            return false;
          }
          f1 = paramMotionEvent.getY(i1);
          p(f1);
          if (this.p)
          {
            f1 = (f1 - this.n) * 0.5F;
            if (f1 > 0.0F)
            {
              i(f1);
              return true;
            }
            return false;
          }
        }
        else
        {
          i1 = paramMotionEvent.findPointerIndex(this.q);
          if (i1 < 0)
          {
            Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
            return false;
          }
          if (this.p)
          {
            f1 = paramMotionEvent.getY(i1);
            float f2 = this.n;
            this.p = false;
            f((f1 - f2) * 0.5F);
          }
          this.q = -1;
          return false;
        }
      }
      else
      {
        this.q = paramMotionEvent.getPointerId(0);
        this.p = false;
      }
      return true;
    }
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    View localView = this.a;
    if ((localView != null) && (!x.V(localView))) {
      return;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  void s(Animation.AnimationListener paramAnimationListener)
  {
    c localc = new c();
    this.E = localc;
    localc.setDuration(150L);
    this.u.b(paramAnimationListener);
    this.u.clearAnimation();
    this.u.startAnimation(this.E);
  }
  
  void setAnimationProgress(float paramFloat)
  {
    this.u.setScaleX(paramFloat);
    this.u.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs)
  {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs)
  {
    e();
    this.B.f(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs)
  {
    Context localContext = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      arrayOfInt[i1] = androidx.core.content.b.b(localContext, paramVarArgs[i1]);
      i1 += 1;
    }
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!paramBoolean) {
      l();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.h.m(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(i parami)
  {
    this.L = parami;
  }
  
  public void setOnRefreshListener(j paramj)
  {
    this.b = paramj;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt)
  {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt)
  {
    this.u.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt)
  {
    setProgressBackgroundColorSchemeColor(androidx.core.content.b.b(getContext(), paramInt));
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.c != paramBoolean))
    {
      this.c = paramBoolean;
      int i1;
      if (!this.K) {
        i1 = this.z + this.y;
      } else {
        i1 = this.z;
      }
      setTargetOffsetTopAndBottom(i1 - this.m);
      this.I = false;
      u(this.M);
      return;
    }
    n(paramBoolean, false);
  }
  
  public void setSize(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f1;
    if (paramInt == 0) {
      f1 = 56.0F;
    } else {
      f1 = 40.0F;
    }
    this.J = ((int)(localDisplayMetrics.density * f1));
    this.u.setImageDrawable(null);
    this.B.l(paramInt);
    this.u.setImageDrawable(this.B);
  }
  
  public void setSlingshotDistance(int paramInt)
  {
    this.A = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt)
  {
    this.u.bringToFront();
    x.b0(this.u, paramInt);
    this.m = this.u.getTop();
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.h.o(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.h.q();
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation = SwipeRefreshLayout.this;
      if (paramAnimation.c)
      {
        paramAnimation.B.setAlpha(255);
        SwipeRefreshLayout.this.B.start();
        paramAnimation = SwipeRefreshLayout.this;
        if (paramAnimation.I)
        {
          paramAnimation = paramAnimation.b;
          if (paramAnimation != null) {
            paramAnimation.R();
          }
        }
        paramAnimation = SwipeRefreshLayout.this;
        paramAnimation.m = paramAnimation.u.getTop();
        return;
      }
      paramAnimation.l();
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class b
    extends Animation
  {
    b() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      SwipeRefreshLayout.this.setAnimationProgress(paramFloat);
    }
  }
  
  class c
    extends Animation
  {
    c() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      SwipeRefreshLayout.this.setAnimationProgress(1.0F - paramFloat);
    }
  }
  
  class d
    extends Animation
  {
    d(int paramInt1, int paramInt2) {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = SwipeRefreshLayout.this.B;
      int i = paramInt1;
      paramTransformation.setAlpha((int)(i + (paramInt2 - i) * paramFloat));
    }
  }
  
  class e
    implements Animation.AnimationListener
  {
    e() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      paramAnimation = SwipeRefreshLayout.this;
      if (!paramAnimation.r) {
        paramAnimation.s(null);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class f
    extends Animation
  {
    f() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = SwipeRefreshLayout.this;
      if (!paramTransformation.K) {
        i = paramTransformation.z - Math.abs(paramTransformation.y);
      } else {
        i = paramTransformation.z;
      }
      paramTransformation = SwipeRefreshLayout.this;
      int j = paramTransformation.w;
      int i = (int)((i - j) * paramFloat);
      int k = paramTransformation.u.getTop();
      SwipeRefreshLayout.this.setTargetOffsetTopAndBottom(j + i - k);
      SwipeRefreshLayout.this.B.e(1.0F - paramFloat);
    }
  }
  
  class g
    extends Animation
  {
    g() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      SwipeRefreshLayout.this.j(paramFloat);
    }
  }
  
  class h
    extends Animation
  {
    h() {}
    
    public void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = SwipeRefreshLayout.this;
      float f = paramTransformation.x;
      paramTransformation.setAnimationProgress(f + -f * paramFloat);
      SwipeRefreshLayout.this.j(paramFloat);
    }
  }
  
  public static abstract interface i
  {
    public abstract boolean a(SwipeRefreshLayout paramSwipeRefreshLayout, View paramView);
  }
  
  public static abstract interface j
  {
    public abstract void R();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */