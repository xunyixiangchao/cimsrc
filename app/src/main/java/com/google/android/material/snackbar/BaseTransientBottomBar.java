package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.layout;
import com.google.android.material.R.styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.c;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import java.util.List;
import o7.c;
import y0.d;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  static final Handler s = new Handler(Looper.getMainLooper(), new h());
  private static final boolean t = false;
  private static final int[] u = { R.attr.snackbarStyle };
  private static final String v = BaseTransientBottomBar.class.getSimpleName();
  private final ViewGroup a;
  private final Context b;
  protected final s c;
  private final a d;
  private int e;
  private boolean f;
  private boolean g = false;
  private final Runnable h = new i();
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private List<q<B>> o;
  private Behavior p;
  private final AccessibilityManager q;
  b.b r = new l();
  
  protected BaseTransientBottomBar(Context paramContext, ViewGroup paramViewGroup, View paramView, a parama)
  {
    if (paramViewGroup != null)
    {
      if (paramView != null)
      {
        if (parama != null)
        {
          this.a = paramViewGroup;
          this.d = parama;
          this.b = paramContext;
          p.a(paramContext);
          paramViewGroup = (s)LayoutInflater.from(paramContext).inflate(y(), paramViewGroup, false);
          this.c = paramViewGroup;
          s.b(paramViewGroup, this);
          if ((paramView instanceof SnackbarContentLayout))
          {
            parama = (SnackbarContentLayout)paramView;
            parama.c(paramViewGroup.getActionTextColorAlpha());
            parama.setMaxInlineActionWidth(paramViewGroup.getMaxInlineActionWidth());
          }
          paramViewGroup.addView(paramView);
          x.s0(paramViewGroup, 1);
          x.B0(paramViewGroup, 1);
          x.z0(paramViewGroup, true);
          x.E0(paramViewGroup, new j());
          x.q0(paramViewGroup, new k());
          this.q = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
          return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
      }
      throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }
    throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
  }
  
  private int A()
  {
    int[] arrayOfInt = new int[2];
    this.c.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + this.c.getHeight();
  }
  
  private boolean E()
  {
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    return ((localLayoutParams instanceof CoordinatorLayout.e)) && ((((CoordinatorLayout.e)localLayoutParams).f() instanceof SwipeDismissBehavior));
  }
  
  private void K()
  {
    this.m = p();
    W();
  }
  
  private void M(CoordinatorLayout.e parame)
  {
    Behavior localBehavior = this.p;
    Object localObject = localBehavior;
    if (localBehavior == null) {
      localObject = v();
    }
    if ((localObject instanceof Behavior)) {
      Behavior.O((Behavior)localObject, this);
    }
    ((SwipeDismissBehavior)localObject).K(new n());
    parame.o((CoordinatorLayout.Behavior)localObject);
    if (t() == null) {
      parame.g = 80;
    }
  }
  
  private boolean O()
  {
    return (this.l > 0) && (!this.f) && (E());
  }
  
  private void R()
  {
    if (N())
    {
      n();
      return;
    }
    if (this.c.getParent() != null) {
      this.c.setVisibility(0);
    }
    J();
  }
  
  private void S()
  {
    ValueAnimator localValueAnimator1 = s(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator2 = w(new float[] { 0.8F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    localAnimatorSet.setDuration(150L);
    localAnimatorSet.addListener(new p());
    localAnimatorSet.start();
  }
  
  private void T(final int paramInt)
  {
    ValueAnimator localValueAnimator = s(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(75L);
    localValueAnimator.addListener(new a(paramInt));
    localValueAnimator.start();
  }
  
  private void U()
  {
    final int i1 = z();
    if (t) {
      x.b0(this.c, i1);
    } else {
      this.c.setTranslationY(i1);
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { i1, 0 });
    localValueAnimator.setInterpolator(e7.a.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new d());
    localValueAnimator.addUpdateListener(new e(i1));
    localValueAnimator.start();
  }
  
  private void V(final int paramInt)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setIntValues(new int[] { 0, z() });
    localValueAnimator.setInterpolator(e7.a.b);
    localValueAnimator.setDuration(250L);
    localValueAnimator.addListener(new f(paramInt));
    localValueAnimator.addUpdateListener(new g());
    localValueAnimator.start();
  }
  
  private void W()
  {
    Object localObject = this.c.getLayoutParams();
    if (((localObject instanceof ViewGroup.MarginLayoutParams)) && (s.a(this.c) != null))
    {
      if (this.c.getParent() == null) {
        return;
      }
      int i1;
      if (t() != null) {
        i1 = this.m;
      } else {
        i1 = this.i;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (s.a(this.c).bottom + i1);
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (s.a(this.c).left + this.j);
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (s.a(this.c).right + this.k);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = s.a(this.c).top;
      this.c.requestLayout();
      if ((Build.VERSION.SDK_INT >= 29) && (O()))
      {
        this.c.removeCallbacks(this.h);
        this.c.post(this.h);
      }
      return;
    }
    Log.w(v, "Unable to update margins because layout params are not MarginLayoutParams");
  }
  
  private void o(int paramInt)
  {
    if (this.c.getAnimationMode() == 1)
    {
      T(paramInt);
      return;
    }
    V(paramInt);
  }
  
  private int p()
  {
    if (t() == null) {
      return 0;
    }
    int[] arrayOfInt = new int[2];
    t().getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    arrayOfInt = new int[2];
    this.a.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + this.a.getHeight() - i1;
  }
  
  private ValueAnimator s(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(e7.a.a);
    paramVarArgs.addUpdateListener(new b());
    return paramVarArgs;
  }
  
  private ValueAnimator w(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(e7.a.d);
    paramVarArgs.addUpdateListener(new c());
    return paramVarArgs;
  }
  
  private int x()
  {
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  private int z()
  {
    int i2 = this.c.getHeight();
    ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
    int i1 = i2;
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i1 = i2 + ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin;
    }
    return i1;
  }
  
  protected boolean B()
  {
    TypedArray localTypedArray = this.b.obtainStyledAttributes(u);
    boolean bool = false;
    int i1 = localTypedArray.getResourceId(0, -1);
    localTypedArray.recycle();
    if (i1 != -1) {
      bool = true;
    }
    return bool;
  }
  
  final void C(int paramInt)
  {
    if ((N()) && (this.c.getVisibility() == 0))
    {
      o(paramInt);
      return;
    }
    I(paramInt);
  }
  
  public boolean D()
  {
    return b.c().e(this.r);
  }
  
  void F()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      WindowInsets localWindowInsets = this.c.getRootWindowInsets();
      if (localWindowInsets != null)
      {
        this.l = localWindowInsets.getMandatorySystemGestureInsets().bottom;
        W();
      }
    }
  }
  
  void G()
  {
    if (D()) {
      s.post(new m());
    }
  }
  
  void H()
  {
    if (this.n)
    {
      R();
      this.n = false;
    }
  }
  
  void I(int paramInt)
  {
    b.c().h(this.r);
    Object localObject = this.o;
    if (localObject != null)
    {
      int i1 = ((List)localObject).size() - 1;
      while (i1 >= 0)
      {
        ((q)this.o.get(i1)).a(this, paramInt);
        i1 -= 1;
      }
    }
    localObject = this.c.getParent();
    if ((localObject instanceof ViewGroup)) {
      ((ViewGroup)localObject).removeView(this.c);
    }
  }
  
  void J()
  {
    b.c().i(this.r);
    List localList = this.o;
    if (localList != null)
    {
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        ((q)this.o.get(i1)).b(this);
        i1 -= 1;
      }
    }
  }
  
  public B L(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  boolean N()
  {
    Object localObject = this.q;
    if (localObject == null) {
      return true;
    }
    localObject = ((AccessibilityManager)localObject).getEnabledAccessibilityServiceList(1);
    return (localObject != null) && (((List)localObject).isEmpty());
  }
  
  public void P()
  {
    b.c().m(u(), this.r);
  }
  
  final void Q()
  {
    if (this.c.getParent() == null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.e)) {
        M((CoordinatorLayout.e)localLayoutParams);
      }
      this.c.c(this.a);
      K();
      this.c.setVisibility(4);
    }
    if (x.U(this.c))
    {
      R();
      return;
    }
    this.n = true;
  }
  
  void n()
  {
    this.c.post(new o());
  }
  
  public void q()
  {
    r(3);
  }
  
  protected void r(int paramInt)
  {
    b.c().b(this.r, paramInt);
  }
  
  public View t()
  {
    return null;
  }
  
  public int u()
  {
    return this.e;
  }
  
  protected SwipeDismissBehavior<? extends View> v()
  {
    return new Behavior();
  }
  
  protected int y()
  {
    if (B()) {
      return R.layout.mtrl_layout_snackbar;
    }
    return R.layout.design_layout_snackbar;
  }
  
  public static class Behavior
    extends SwipeDismissBehavior<View>
  {
    private final BaseTransientBottomBar.r k = new BaseTransientBottomBar.r(this);
    
    private void P(BaseTransientBottomBar<?> paramBaseTransientBottomBar)
    {
      this.k.c(paramBaseTransientBottomBar);
    }
    
    public boolean E(View paramView)
    {
      return this.k.a(paramView);
    }
    
    public boolean k(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      this.k.b(paramCoordinatorLayout, paramView, paramMotionEvent);
      return super.k(paramCoordinatorLayout, paramView, paramMotionEvent);
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(int paramInt) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BaseTransientBottomBar.this.I(paramInt);
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      BaseTransientBottomBar.this.c.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      BaseTransientBottomBar.this.c.setScaleX(f);
      BaseTransientBottomBar.this.c.setScaleY(f);
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BaseTransientBottomBar.this.J();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BaseTransientBottomBar.e(BaseTransientBottomBar.this).a(70, 180);
    }
  }
  
  class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int a;
    
    e(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      if (BaseTransientBottomBar.f()) {
        x.b0(BaseTransientBottomBar.this.c, i - this.a);
      } else {
        BaseTransientBottomBar.this.c.setTranslationY(i);
      }
      this.a = i;
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f(int paramInt) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BaseTransientBottomBar.this.I(paramInt);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BaseTransientBottomBar.e(BaseTransientBottomBar.this).b(0, 180);
    }
  }
  
  class g
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int a = 0;
    
    g() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      if (BaseTransientBottomBar.f()) {
        x.b0(BaseTransientBottomBar.this.c, i - this.a);
      } else {
        BaseTransientBottomBar.this.c.setTranslationY(i);
      }
      this.a = i;
    }
  }
  
  class h
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1) {
          return false;
        }
        ((BaseTransientBottomBar)paramMessage.obj).C(paramMessage.arg1);
        return true;
      }
      ((BaseTransientBottomBar)paramMessage.obj).Q();
      return true;
    }
  }
  
  class i
    implements Runnable
  {
    i() {}
    
    public void run()
    {
      Object localObject = BaseTransientBottomBar.this;
      if (((BaseTransientBottomBar)localObject).c != null)
      {
        if (BaseTransientBottomBar.a((BaseTransientBottomBar)localObject) == null) {
          return;
        }
        int i = BaseTransientBottomBar.b(BaseTransientBottomBar.this) - BaseTransientBottomBar.g(BaseTransientBottomBar.this) + (int)BaseTransientBottomBar.this.c.getTranslationY();
        if (i >= BaseTransientBottomBar.h(BaseTransientBottomBar.this)) {
          return;
        }
        localObject = BaseTransientBottomBar.this.c.getLayoutParams();
        if (!(localObject instanceof ViewGroup.MarginLayoutParams))
        {
          Log.w(BaseTransientBottomBar.i(), "Unable to apply gesture inset because layout params are not MarginLayoutParams");
          return;
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += BaseTransientBottomBar.h(BaseTransientBottomBar.this) - i;
        BaseTransientBottomBar.this.c.requestLayout();
      }
    }
  }
  
  class j
    implements r
  {
    j() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      BaseTransientBottomBar.j(BaseTransientBottomBar.this, paramh0.i());
      BaseTransientBottomBar.k(BaseTransientBottomBar.this, paramh0.j());
      BaseTransientBottomBar.l(BaseTransientBottomBar.this, paramh0.k());
      BaseTransientBottomBar.m(BaseTransientBottomBar.this);
      return paramh0;
    }
  }
  
  class k
    extends androidx.core.view.a
  {
    k() {}
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      paramd.a(1048576);
      paramd.h0(true);
    }
    
    public boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      if (paramInt == 1048576)
      {
        BaseTransientBottomBar.this.q();
        return true;
      }
      return super.j(paramView, paramInt, paramBundle);
    }
  }
  
  class l
    implements b.b
  {
    l() {}
    
    public void a()
    {
      Handler localHandler = BaseTransientBottomBar.s;
      localHandler.sendMessage(localHandler.obtainMessage(0, BaseTransientBottomBar.this));
    }
    
    public void b(int paramInt)
    {
      Handler localHandler = BaseTransientBottomBar.s;
      localHandler.sendMessage(localHandler.obtainMessage(1, paramInt, 0, BaseTransientBottomBar.this));
    }
  }
  
  class m
    implements Runnable
  {
    m() {}
    
    public void run()
    {
      BaseTransientBottomBar.this.I(3);
    }
  }
  
  class n
    implements SwipeDismissBehavior.c
  {
    n() {}
    
    public void a(View paramView)
    {
      if (paramView.getParent() != null) {
        paramView.setVisibility(8);
      }
      BaseTransientBottomBar.this.r(0);
    }
    
    public void b(int paramInt)
    {
      if (paramInt != 0)
      {
        if ((paramInt != 1) && (paramInt != 2)) {
          return;
        }
        b.c().j(BaseTransientBottomBar.this.r);
        return;
      }
      b.c().k(BaseTransientBottomBar.this.r);
    }
  }
  
  class o
    implements Runnable
  {
    o() {}
    
    public void run()
    {
      BaseTransientBottomBar.s locals = BaseTransientBottomBar.this.c;
      if (locals == null) {
        return;
      }
      if (locals.getParent() != null) {
        BaseTransientBottomBar.this.c.setVisibility(0);
      }
      if (BaseTransientBottomBar.this.c.getAnimationMode() == 1)
      {
        BaseTransientBottomBar.c(BaseTransientBottomBar.this);
        return;
      }
      BaseTransientBottomBar.d(BaseTransientBottomBar.this);
    }
  }
  
  class p
    extends AnimatorListenerAdapter
  {
    p() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BaseTransientBottomBar.this.J();
    }
  }
  
  public static abstract class q<B>
  {
    public void a(B paramB, int paramInt) {}
    
    public void b(B paramB) {}
  }
  
  public static class r
  {
    private b.b a;
    
    public r(SwipeDismissBehavior<?> paramSwipeDismissBehavior)
    {
      paramSwipeDismissBehavior.L(0.1F);
      paramSwipeDismissBehavior.J(0.6F);
      paramSwipeDismissBehavior.M(0);
    }
    
    public boolean a(View paramView)
    {
      return paramView instanceof BaseTransientBottomBar.s;
    }
    
    public void b(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          return;
        }
        b.c().k(this.a);
        return;
      }
      if (paramCoordinatorLayout.F(paramView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        b.c().j(this.a);
      }
    }
    
    public void c(BaseTransientBottomBar<?> paramBaseTransientBottomBar)
    {
      this.a = paramBaseTransientBottomBar.r;
    }
  }
  
  protected static class s
    extends FrameLayout
  {
    private static final View.OnTouchListener k = new a();
    private BaseTransientBottomBar<?> a;
    private int b;
    private final float c;
    private final float d;
    private final int e;
    private final int f;
    private ColorStateList g;
    private PorterDuff.Mode h;
    private Rect i;
    private boolean j;
    
    protected s(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = getContext();
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      int m = R.styleable.SnackbarLayout_elevation;
      if (paramAttributeSet.hasValue(m)) {
        x.y0(this, paramAttributeSet.getDimensionPixelSize(m, 0));
      }
      this.b = paramAttributeSet.getInt(R.styleable.SnackbarLayout_animationMode, 0);
      this.c = paramAttributeSet.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0F);
      setBackgroundTintList(c.a(paramContext, paramAttributeSet, R.styleable.SnackbarLayout_backgroundTint));
      setBackgroundTintMode(t.j(paramAttributeSet.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
      this.d = paramAttributeSet.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0F);
      this.e = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
      this.f = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
      paramAttributeSet.recycle();
      setOnTouchListener(k);
      setFocusable(true);
      if (getBackground() == null) {
        x.u0(this, d());
      }
    }
    
    private Drawable d()
    {
      float f1 = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
      Object localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(0);
      ((GradientDrawable)localObject).setCornerRadius(f1);
      ((GradientDrawable)localObject).setColor(g7.a.i(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
      if (this.g != null)
      {
        localObject = r0.a.r((Drawable)localObject);
        r0.a.o((Drawable)localObject, this.g);
        return localObject;
      }
      return r0.a.r((Drawable)localObject);
    }
    
    private void e(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.i = new Rect(paramMarginLayoutParams.leftMargin, paramMarginLayoutParams.topMargin, paramMarginLayoutParams.rightMargin, paramMarginLayoutParams.bottomMargin);
    }
    
    private void setBaseTransientBottomBar(BaseTransientBottomBar<?> paramBaseTransientBottomBar)
    {
      this.a = paramBaseTransientBottomBar;
    }
    
    void c(ViewGroup paramViewGroup)
    {
      this.j = true;
      paramViewGroup.addView(this);
      this.j = false;
    }
    
    float getActionTextColorAlpha()
    {
      return this.d;
    }
    
    int getAnimationMode()
    {
      return this.b;
    }
    
    float getBackgroundOverlayColorAlpha()
    {
      return this.c;
    }
    
    int getMaxInlineActionWidth()
    {
      return this.f;
    }
    
    int getMaxWidth()
    {
      return this.e;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      BaseTransientBottomBar localBaseTransientBottomBar = this.a;
      if (localBaseTransientBottomBar != null) {
        localBaseTransientBottomBar.F();
      }
      x.n0(this);
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      BaseTransientBottomBar localBaseTransientBottomBar = this.a;
      if (localBaseTransientBottomBar != null) {
        localBaseTransientBottomBar.G();
      }
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      BaseTransientBottomBar localBaseTransientBottomBar = this.a;
      if (localBaseTransientBottomBar != null) {
        localBaseTransientBottomBar.H();
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (this.e > 0)
      {
        paramInt1 = getMeasuredWidth();
        int m = this.e;
        if (paramInt1 > m) {
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), paramInt2);
        }
      }
    }
    
    void setAnimationMode(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void setBackground(Drawable paramDrawable)
    {
      setBackgroundDrawable(paramDrawable);
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      Drawable localDrawable = paramDrawable;
      if (paramDrawable != null)
      {
        localDrawable = paramDrawable;
        if (this.g != null)
        {
          localDrawable = r0.a.r(paramDrawable.mutate());
          r0.a.o(localDrawable, this.g);
          r0.a.p(localDrawable, this.h);
        }
      }
      super.setBackgroundDrawable(localDrawable);
    }
    
    public void setBackgroundTintList(ColorStateList paramColorStateList)
    {
      this.g = paramColorStateList;
      if (getBackground() != null)
      {
        Drawable localDrawable = r0.a.r(getBackground().mutate());
        r0.a.o(localDrawable, paramColorStateList);
        r0.a.p(localDrawable, this.h);
        if (localDrawable != getBackground()) {
          super.setBackgroundDrawable(localDrawable);
        }
      }
    }
    
    public void setBackgroundTintMode(PorterDuff.Mode paramMode)
    {
      this.h = paramMode;
      if (getBackground() != null)
      {
        Drawable localDrawable = r0.a.r(getBackground().mutate());
        r0.a.p(localDrawable, paramMode);
        if (localDrawable != getBackground()) {
          super.setBackgroundDrawable(localDrawable);
        }
      }
    }
    
    public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super.setLayoutParams(paramLayoutParams);
      if ((!this.j) && ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)))
      {
        e((ViewGroup.MarginLayoutParams)paramLayoutParams);
        paramLayoutParams = this.a;
        if (paramLayoutParams != null) {
          BaseTransientBottomBar.m(paramLayoutParams);
        }
      }
    }
    
    public void setOnClickListener(View.OnClickListener paramOnClickListener)
    {
      View.OnTouchListener localOnTouchListener;
      if (paramOnClickListener != null) {
        localOnTouchListener = null;
      } else {
        localOnTouchListener = k;
      }
      setOnTouchListener(localOnTouchListener);
      super.setOnClickListener(paramOnClickListener);
    }
    
    class a
      implements View.OnTouchListener
    {
      @SuppressLint({"ClickableViewAccessibility"})
      public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        return true;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */