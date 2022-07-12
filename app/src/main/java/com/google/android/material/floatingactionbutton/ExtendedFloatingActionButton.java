package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.x;
import com.google.android.material.R.animator;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.p;
import e7.h;
import java.util.Iterator;
import java.util.List;
import r7.m;
import r7.m.b;

public class ExtendedFloatingActionButton
  extends MaterialButton
  implements CoordinatorLayout.b
{
  private static final int I = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
  static final Property<View, Float> J = new d(Float.class, "width");
  static final Property<View, Float> K = new e(Float.class, "height");
  static final Property<View, Float> L = new f(Float.class, "paddingStart");
  static final Property<View, Float> M = new g(Float.class, "paddingEnd");
  private int A;
  private int B;
  private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> C;
  private boolean E;
  private boolean F;
  private boolean G;
  protected ColorStateList H;
  private int t = 0;
  private final a u;
  private final f v;
  private final f w;
  private final f x;
  private final f y;
  private final int z;
  
  public ExtendedFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.extendedFloatingActionButtonStyle);
  }
  
  public ExtendedFloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    Object localObject1 = new a();
    this.u = ((a)localObject1);
    paramContext = new k((a)localObject1);
    this.x = paramContext;
    localObject1 = new i((a)localObject1);
    this.y = ((f)localObject1);
    this.E = true;
    this.F = false;
    this.G = false;
    Context localContext = getContext();
    this.C = new ExtendedFloatingActionButtonBehavior(localContext, paramAttributeSet);
    TypedArray localTypedArray = p.h(localContext, paramAttributeSet, R.styleable.ExtendedFloatingActionButton, paramInt, i, new int[0]);
    h localh1 = h.c(localContext, localTypedArray, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
    h localh2 = h.c(localContext, localTypedArray, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
    h localh3 = h.c(localContext, localTypedArray, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
    h localh4 = h.c(localContext, localTypedArray, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
    this.z = localTypedArray.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
    this.A = x.G(this);
    this.B = x.F(this);
    Object localObject2 = new a();
    h localh = new h((a)localObject2, new a(), true);
    this.w = localh;
    localObject2 = new h((a)localObject2, new b(), false);
    this.v = ((f)localObject2);
    paramContext.h(localh1);
    ((f)localObject1).h(localh2);
    localh.h(localh3);
    ((f)localObject2).h(localh4);
    localTypedArray.recycle();
    setShapeAppearanceModel(m.g(localContext, paramAttributeSet, paramInt, i, m.m).m());
    z();
  }
  
  private boolean A()
  {
    return ((x.U(this)) || ((!x()) && (this.G))) && (!isInEditMode());
  }
  
  private boolean w()
  {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 0)
    {
      if (this.t == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.t != 2) {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean x()
  {
    int i = getVisibility();
    boolean bool2 = false;
    boolean bool1 = false;
    if (i != 0)
    {
      if (this.t == 2) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.t != 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void y(final f paramf, j paramj)
  {
    if (paramf.g()) {
      return;
    }
    if (!A())
    {
      paramf.b();
      paramf.f(paramj);
      return;
    }
    measure(0, 0);
    AnimatorSet localAnimatorSet = paramf.d();
    localAnimatorSet.addListener(new c(paramf, paramj));
    paramf = paramf.e().iterator();
    while (paramf.hasNext()) {
      localAnimatorSet.addListener((Animator.AnimatorListener)paramf.next());
    }
    localAnimatorSet.start();
  }
  
  private void z()
  {
    this.H = getTextColors();
  }
  
  protected void B(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
  }
  
  public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior()
  {
    return this.C;
  }
  
  int getCollapsedPadding()
  {
    return (getCollapsedSize() - getIconSize()) / 2;
  }
  
  int getCollapsedSize()
  {
    int j = this.z;
    int i = j;
    if (j < 0) {
      i = Math.min(x.G(this), x.F(this)) * 2 + getIconSize();
    }
    return i;
  }
  
  public h getExtendMotionSpec()
  {
    return this.w.c();
  }
  
  public h getHideMotionSpec()
  {
    return this.y.c();
  }
  
  public h getShowMotionSpec()
  {
    return this.x.c();
  }
  
  public h getShrinkMotionSpec()
  {
    return this.v.c();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.E) && (TextUtils.isEmpty(getText())) && (getIcon() != null))
    {
      this.E = false;
      this.v.b();
    }
  }
  
  public void setAnimateShowBeforeLayout(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void setExtendMotionSpec(h paramh)
  {
    this.w.h(paramh);
  }
  
  public void setExtendMotionSpecResource(int paramInt)
  {
    setExtendMotionSpec(h.d(getContext(), paramInt));
  }
  
  public void setExtended(boolean paramBoolean)
  {
    if (this.E == paramBoolean) {
      return;
    }
    f localf;
    if (paramBoolean) {
      localf = this.w;
    } else {
      localf = this.v;
    }
    if (localf.g()) {
      return;
    }
    localf.b();
  }
  
  public void setHideMotionSpec(h paramh)
  {
    this.y.h(paramh);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(h.d(getContext(), paramInt));
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.E) && (!this.F))
    {
      this.A = x.G(this);
      this.B = x.F(this);
    }
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.E) && (!this.F))
    {
      this.A = paramInt1;
      this.B = paramInt3;
    }
  }
  
  public void setShowMotionSpec(h paramh)
  {
    this.x.h(paramh);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(h.d(getContext(), paramInt));
  }
  
  public void setShrinkMotionSpec(h paramh)
  {
    this.v.h(paramh);
  }
  
  public void setShrinkMotionSpecResource(int paramInt)
  {
    setShrinkMotionSpec(h.d(getContext(), paramInt));
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    z();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    super.setTextColor(paramColorStateList);
    z();
  }
  
  protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect a;
    private boolean b;
    private boolean c;
    
    public ExtendedFloatingActionButtonBehavior()
    {
      this.b = false;
      this.c = true;
    }
    
    public ExtendedFloatingActionButtonBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
      this.b = paramContext.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
      this.c = paramContext.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
      paramContext.recycle();
    }
    
    private static boolean G(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.e)) {
        return ((CoordinatorLayout.e)paramView).f() instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    private boolean J(View paramView, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      paramExtendedFloatingActionButton = (CoordinatorLayout.e)paramExtendedFloatingActionButton.getLayoutParams();
      if ((!this.b) && (!this.c)) {
        return false;
      }
      return paramExtendedFloatingActionButton.e() == paramView.getId();
    }
    
    private boolean L(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      if (!J(paramAppBarLayout, paramExtendedFloatingActionButton)) {
        return false;
      }
      if (this.a == null) {
        this.a = new Rect();
      }
      Rect localRect = this.a;
      d.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        K(paramExtendedFloatingActionButton);
      } else {
        E(paramExtendedFloatingActionButton);
      }
      return true;
    }
    
    private boolean M(View paramView, ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      if (!J(paramView, paramExtendedFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.e locale = (CoordinatorLayout.e)paramExtendedFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramExtendedFloatingActionButton.getHeight() / 2 + locale.topMargin) {
        K(paramExtendedFloatingActionButton);
      } else {
        E(paramExtendedFloatingActionButton);
      }
      return true;
    }
    
    protected void E(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      f localf;
      if (this.c) {
        localf = ExtendedFloatingActionButton.q(paramExtendedFloatingActionButton);
      } else {
        localf = ExtendedFloatingActionButton.r(paramExtendedFloatingActionButton);
      }
      ExtendedFloatingActionButton.p(paramExtendedFloatingActionButton, localf, null);
    }
    
    public boolean F(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, Rect paramRect)
    {
      return super.b(paramCoordinatorLayout, paramExtendedFloatingActionButton, paramRect);
    }
    
    public boolean H(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        L(paramCoordinatorLayout, (AppBarLayout)paramView, paramExtendedFloatingActionButton);
      } else if (G(paramView)) {
        M(paramView, paramExtendedFloatingActionButton);
      }
      return false;
    }
    
    public boolean I(CoordinatorLayout paramCoordinatorLayout, ExtendedFloatingActionButton paramExtendedFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.v(paramExtendedFloatingActionButton);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)localList.get(i);
        if ((localView instanceof AppBarLayout) ? !L(paramCoordinatorLayout, (AppBarLayout)localView, paramExtendedFloatingActionButton) : (G(localView)) && (M(localView, paramExtendedFloatingActionButton))) {
          break;
        }
        i += 1;
      }
      paramCoordinatorLayout.M(paramExtendedFloatingActionButton, paramInt);
      return true;
    }
    
    protected void K(ExtendedFloatingActionButton paramExtendedFloatingActionButton)
    {
      f localf;
      if (this.c) {
        localf = ExtendedFloatingActionButton.n(paramExtendedFloatingActionButton);
      } else {
        localf = ExtendedFloatingActionButton.o(paramExtendedFloatingActionButton);
      }
      ExtendedFloatingActionButton.p(paramExtendedFloatingActionButton, localf, null);
    }
    
    public void g(CoordinatorLayout.e parame)
    {
      if (parame.h == 0) {
        parame.h = 80;
      }
    }
  }
  
  class a
    implements ExtendedFloatingActionButton.l
  {
    a() {}
    
    public int a()
    {
      return ExtendedFloatingActionButton.k(ExtendedFloatingActionButton.this);
    }
    
    public int b()
    {
      return ExtendedFloatingActionButton.j(ExtendedFloatingActionButton.this);
    }
    
    public ViewGroup.LayoutParams c()
    {
      return new ViewGroup.LayoutParams(-2, -2);
    }
    
    public int getHeight()
    {
      return ExtendedFloatingActionButton.this.getMeasuredHeight();
    }
    
    public int getWidth()
    {
      return ExtendedFloatingActionButton.this.getMeasuredWidth() - ExtendedFloatingActionButton.this.getCollapsedPadding() * 2 + ExtendedFloatingActionButton.j(ExtendedFloatingActionButton.this) + ExtendedFloatingActionButton.k(ExtendedFloatingActionButton.this);
    }
  }
  
  class b
    implements ExtendedFloatingActionButton.l
  {
    b() {}
    
    public int a()
    {
      return ExtendedFloatingActionButton.this.getCollapsedPadding();
    }
    
    public int b()
    {
      return ExtendedFloatingActionButton.this.getCollapsedPadding();
    }
    
    public ViewGroup.LayoutParams c()
    {
      return new ViewGroup.LayoutParams(getWidth(), getHeight());
    }
    
    public int getHeight()
    {
      return ExtendedFloatingActionButton.this.getCollapsedSize();
    }
    
    public int getWidth()
    {
      return ExtendedFloatingActionButton.this.getCollapsedSize();
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    private boolean a;
    
    c(f paramf, ExtendedFloatingActionButton.j paramj) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
      paramf.onAnimationCancel();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      paramf.onAnimationEnd();
      if (!this.a) {
        paramf.f(null);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      paramf.onAnimationStart(paramAnimator);
      this.a = false;
    }
  }
  
  class d
    extends Property<View, Float>
  {
    d(String paramString)
    {
      super(paramString);
    }
    
    public Float a(View paramView)
    {
      return Float.valueOf(paramView.getLayoutParams().width);
    }
    
    public void b(View paramView, Float paramFloat)
    {
      paramView.getLayoutParams().width = paramFloat.intValue();
      paramView.requestLayout();
    }
  }
  
  class e
    extends Property<View, Float>
  {
    e(String paramString)
    {
      super(paramString);
    }
    
    public Float a(View paramView)
    {
      return Float.valueOf(paramView.getLayoutParams().height);
    }
    
    public void b(View paramView, Float paramFloat)
    {
      paramView.getLayoutParams().height = paramFloat.intValue();
      paramView.requestLayout();
    }
  }
  
  class f
    extends Property<View, Float>
  {
    f(String paramString)
    {
      super(paramString);
    }
    
    public Float a(View paramView)
    {
      return Float.valueOf(x.G(paramView));
    }
    
    public void b(View paramView, Float paramFloat)
    {
      x.F0(paramView, paramFloat.intValue(), paramView.getPaddingTop(), x.F(paramView), paramView.getPaddingBottom());
    }
  }
  
  class g
    extends Property<View, Float>
  {
    g(String paramString)
    {
      super(paramString);
    }
    
    public Float a(View paramView)
    {
      return Float.valueOf(x.F(paramView));
    }
    
    public void b(View paramView, Float paramFloat)
    {
      x.F0(paramView, x.G(paramView), paramView.getPaddingTop(), paramFloat.intValue(), paramView.getPaddingBottom());
    }
  }
  
  class h
    extends b
  {
    private final ExtendedFloatingActionButton.l g;
    private final boolean h;
    
    h(a parama, ExtendedFloatingActionButton.l paraml, boolean paramBoolean)
    {
      super(parama);
      this.g = paraml;
      this.h = paramBoolean;
    }
    
    public int a()
    {
      if (this.h) {
        return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
      }
      return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }
    
    public void b()
    {
      ExtendedFloatingActionButton.t(ExtendedFloatingActionButton.this, this.h);
      ViewGroup.LayoutParams localLayoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      localLayoutParams.width = this.g.c().width;
      localLayoutParams.height = this.g.c().height;
      x.F0(ExtendedFloatingActionButton.this, this.g.b(), ExtendedFloatingActionButton.this.getPaddingTop(), this.g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
      ExtendedFloatingActionButton.this.requestLayout();
    }
    
    public AnimatorSet d()
    {
      h localh = k();
      PropertyValuesHolder[] arrayOfPropertyValuesHolder;
      if (localh.j("width"))
      {
        arrayOfPropertyValuesHolder = localh.g("width");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ExtendedFloatingActionButton.this.getWidth(), this.g.getWidth() });
        localh.l("width", arrayOfPropertyValuesHolder);
      }
      if (localh.j("height"))
      {
        arrayOfPropertyValuesHolder = localh.g("height");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ExtendedFloatingActionButton.this.getHeight(), this.g.getHeight() });
        localh.l("height", arrayOfPropertyValuesHolder);
      }
      if (localh.j("paddingStart"))
      {
        arrayOfPropertyValuesHolder = localh.g("paddingStart");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { x.G(ExtendedFloatingActionButton.this), this.g.b() });
        localh.l("paddingStart", arrayOfPropertyValuesHolder);
      }
      if (localh.j("paddingEnd"))
      {
        arrayOfPropertyValuesHolder = localh.g("paddingEnd");
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { x.F(ExtendedFloatingActionButton.this), this.g.a() });
        localh.l("paddingEnd", arrayOfPropertyValuesHolder);
      }
      if (localh.j("labelOpacity"))
      {
        arrayOfPropertyValuesHolder = localh.g("labelOpacity");
        boolean bool = this.h;
        float f2 = 0.0F;
        float f1;
        if (bool) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        }
        if (bool) {
          f2 = 1.0F;
        }
        arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { f1, f2 });
        localh.l("labelOpacity", arrayOfPropertyValuesHolder);
      }
      return super.j(localh);
    }
    
    public void f(ExtendedFloatingActionButton.j paramj) {}
    
    public boolean g()
    {
      return (this.h == ExtendedFloatingActionButton.s(ExtendedFloatingActionButton.this)) || (ExtendedFloatingActionButton.this.getIcon() == null) || (TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText()));
    }
    
    public void onAnimationEnd()
    {
      super.onAnimationEnd();
      ExtendedFloatingActionButton.u(ExtendedFloatingActionButton.this, false);
      ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
      ViewGroup.LayoutParams localLayoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      localLayoutParams.width = this.g.c().width;
      localLayoutParams.height = this.g.c().height;
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      super.onAnimationStart(paramAnimator);
      ExtendedFloatingActionButton.t(ExtendedFloatingActionButton.this, this.h);
      ExtendedFloatingActionButton.u(ExtendedFloatingActionButton.this, true);
      ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
    }
  }
  
  class i
    extends b
  {
    private boolean g;
    
    public i(a parama)
    {
      super(parama);
    }
    
    public int a()
    {
      return R.animator.mtrl_extended_fab_hide_motion_spec;
    }
    
    public void b()
    {
      ExtendedFloatingActionButton.this.setVisibility(8);
    }
    
    public void f(ExtendedFloatingActionButton.j paramj) {}
    
    public boolean g()
    {
      return ExtendedFloatingActionButton.m(ExtendedFloatingActionButton.this);
    }
    
    public void onAnimationCancel()
    {
      super.onAnimationCancel();
      this.g = true;
    }
    
    public void onAnimationEnd()
    {
      super.onAnimationEnd();
      ExtendedFloatingActionButton.v(ExtendedFloatingActionButton.this, 0);
      if (!this.g) {
        ExtendedFloatingActionButton.this.setVisibility(8);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      super.onAnimationStart(paramAnimator);
      this.g = false;
      ExtendedFloatingActionButton.this.setVisibility(0);
      ExtendedFloatingActionButton.v(ExtendedFloatingActionButton.this, 1);
    }
  }
  
  public static abstract class j {}
  
  class k
    extends b
  {
    public k(a parama)
    {
      super(parama);
    }
    
    public int a()
    {
      return R.animator.mtrl_extended_fab_show_motion_spec;
    }
    
    public void b()
    {
      ExtendedFloatingActionButton.this.setVisibility(0);
      ExtendedFloatingActionButton.this.setAlpha(1.0F);
      ExtendedFloatingActionButton.this.setScaleY(1.0F);
      ExtendedFloatingActionButton.this.setScaleX(1.0F);
    }
    
    public void f(ExtendedFloatingActionButton.j paramj) {}
    
    public boolean g()
    {
      return ExtendedFloatingActionButton.l(ExtendedFloatingActionButton.this);
    }
    
    public void onAnimationEnd()
    {
      super.onAnimationEnd();
      ExtendedFloatingActionButton.v(ExtendedFloatingActionButton.this, 0);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      super.onAnimationStart(paramAnimator);
      ExtendedFloatingActionButton.this.setVisibility(0);
      ExtendedFloatingActionButton.v(ExtendedFloatingActionButton.this, 2);
    }
  }
  
  static abstract interface l
  {
    public abstract int a();
    
    public abstract int b();
    
    public abstract ViewGroup.LayoutParams c();
    
    public abstract int getHeight();
    
    public abstract int getWidth();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 * JD-Core Version:    0.7.0.1
 */