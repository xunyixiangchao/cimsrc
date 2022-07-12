package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.h0;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.animator;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.b;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import com.google.android.material.internal.t.e;
import com.google.android.material.internal.t.f;
import e7.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import r7.f;
import r7.h;
import r7.i;
import r7.m;
import r7.m.b;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.b
{
  private static final int r0 = R.style.Widget_MaterialComponents_BottomAppBar;
  private Integer S;
  private final int T;
  private final h U;
  private Animator V;
  private Animator W;
  private int a0;
  private int b0;
  private boolean c0;
  private final boolean d0;
  private final boolean e0;
  private final boolean f0;
  private int g0;
  private ArrayList<j> h0;
  private int i0;
  private boolean j0;
  private boolean k0;
  private Behavior l0;
  private int m0;
  private int n0;
  private int o0;
  AnimatorListenerAdapter p0;
  k<FloatingActionButton> q0;
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomAppBarStyle);
  }
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = new h();
    this.U = paramContext;
    this.g0 = 0;
    this.i0 = 0;
    this.j0 = false;
    this.k0 = true;
    this.p0 = new a();
    this.q0 = new b();
    Context localContext = getContext();
    Object localObject = p.h(localContext, paramAttributeSet, R.styleable.BottomAppBar, paramInt, i, new int[0]);
    ColorStateList localColorStateList = o7.c.a(localContext, (TypedArray)localObject, R.styleable.BottomAppBar_backgroundTint);
    int j = R.styleable.BottomAppBar_navigationIconTint;
    if (((TypedArray)localObject).hasValue(j)) {
      setNavigationIconTint(((TypedArray)localObject).getColor(j, -1));
    }
    j = ((TypedArray)localObject).getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
    float f1 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
    float f2 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
    float f3 = ((TypedArray)localObject).getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
    this.a0 = ((TypedArray)localObject).getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
    this.b0 = ((TypedArray)localObject).getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
    this.c0 = ((TypedArray)localObject).getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
    this.d0 = ((TypedArray)localObject).getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
    this.e0 = ((TypedArray)localObject).getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
    this.f0 = ((TypedArray)localObject).getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
    ((TypedArray)localObject).recycle();
    this.T = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
    localObject = new a(f1, f2, f3);
    paramContext.setShapeAppearanceModel(m.a().B((f)localObject).m());
    paramContext.i0(2);
    paramContext.e0(Paint.Style.FILL);
    paramContext.Q(localContext);
    setElevation(j);
    r0.a.o(paramContext, localColorStateList);
    x.u0(this, paramContext);
    t.a(this, paramAttributeSet, paramInt, i, new c());
  }
  
  private void B0(int paramInt, List<Animator> paramList)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(F0(), "translationX", new float[] { I0(paramInt) });
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }
  
  private void C0(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    Object localObject = getActionMenuView();
    if (localObject == null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
    if (Math.abs(((ViewGroup)localObject).getTranslationX() - H0((ActionMenuView)localObject, paramInt, paramBoolean)) > 1.0F)
    {
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F });
      localObjectAnimator2.addListener(new g((ActionMenuView)localObject, paramInt, paramBoolean));
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
      return;
    }
    if (((ViewGroup)localObject).getAlpha() < 1.0F) {
      paramList.add(localObjectAnimator1);
    }
  }
  
  private void D0()
  {
    int i = this.g0 - 1;
    this.g0 = i;
    if (i == 0)
    {
      Object localObject = this.h0;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).a(this);
        }
      }
    }
  }
  
  private void E0()
  {
    int i = this.g0;
    this.g0 = (i + 1);
    if (i == 0)
    {
      Object localObject = this.h0;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).b(this);
        }
      }
    }
  }
  
  private FloatingActionButton F0()
  {
    View localView = G0();
    if ((localView instanceof FloatingActionButton)) {
      return (FloatingActionButton)localView;
    }
    return null;
  }
  
  private View G0()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).w(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (((localView instanceof FloatingActionButton)) || ((localView instanceof ExtendedFloatingActionButton))) {
        return localView;
      }
    }
    return null;
  }
  
  private float I0(int paramInt)
  {
    boolean bool = t.i(this);
    int i = 1;
    if (paramInt == 1)
    {
      if (bool) {
        paramInt = this.o0;
      } else {
        paramInt = this.n0;
      }
      int j = this.T;
      int k = getMeasuredWidth() / 2;
      if (bool) {
        i = -1;
      }
      return (k - (j + paramInt)) * i;
    }
    return 0.0F;
  }
  
  private boolean J0()
  {
    FloatingActionButton localFloatingActionButton = F0();
    return (localFloatingActionButton != null) && (localFloatingActionButton.o());
  }
  
  private void K0(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void L0(int paramInt)
  {
    if (this.a0 != paramInt)
    {
      if (!x.U(this)) {
        return;
      }
      Object localObject = this.V;
      if (localObject != null) {
        ((Animator)localObject).cancel();
      }
      localObject = new ArrayList();
      if (this.b0 == 1) {
        B0(paramInt, (List)localObject);
      } else {
        A0(paramInt, (List)localObject);
      }
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether((Collection)localObject);
      this.V = localAnimatorSet;
      localAnimatorSet.addListener(new d());
      this.V.start();
    }
  }
  
  private Drawable M0(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      localDrawable = paramDrawable;
      if (this.S != null)
      {
        localDrawable = r0.a.r(paramDrawable.mutate());
        r0.a.n(localDrawable, this.S.intValue());
      }
    }
    return localDrawable;
  }
  
  private void O0()
  {
    ActionMenuView localActionMenuView = getActionMenuView();
    if ((localActionMenuView != null) && (this.W == null))
    {
      localActionMenuView.setAlpha(1.0F);
      if (!J0())
      {
        S0(localActionMenuView, 0, false);
        return;
      }
      S0(localActionMenuView, this.a0, this.k0);
    }
  }
  
  private void P0()
  {
    getTopEdgeTreatment().q(getFabTranslationX());
    View localView = G0();
    h localh = this.U;
    float f;
    if ((this.k0) && (J0())) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    localh.c0(f);
    if (localView != null)
    {
      localView.setTranslationY(getFabTranslationY());
      localView.setTranslationX(getFabTranslationX());
    }
  }
  
  private void S0(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    T0(paramActionMenuView, paramInt, paramBoolean, false);
  }
  
  private void T0(final ActionMenuView paramActionMenuView, final int paramInt, final boolean paramBoolean1, boolean paramBoolean2)
  {
    h localh = new h(paramActionMenuView, paramInt, paramBoolean1);
    if (paramBoolean2)
    {
      paramActionMenuView.post(localh);
      return;
    }
    localh.run();
  }
  
  private ActionMenuView getActionMenuView()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private int getBottomInset()
  {
    return this.m0;
  }
  
  private float getFabTranslationX()
  {
    return I0(this.a0);
  }
  
  private float getFabTranslationY()
  {
    return -getTopEdgeTreatment().c();
  }
  
  private int getLeftInset()
  {
    return this.o0;
  }
  
  private int getRightInset()
  {
    return this.n0;
  }
  
  private a getTopEdgeTreatment()
  {
    return (a)this.U.E().p();
  }
  
  private void y0(FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.e(this.p0);
    paramFloatingActionButton.f(new i());
    paramFloatingActionButton.g(this.q0);
  }
  
  private void z0()
  {
    Animator localAnimator = this.W;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
    localAnimator = this.V;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  protected void A0(final int paramInt, List<Animator> paramList)
  {
    paramList = F0();
    if (paramList != null)
    {
      if (paramList.n()) {
        return;
      }
      E0();
      paramList.l(new e(paramInt));
    }
  }
  
  protected int H0(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      if (!paramBoolean) {
        return 0;
      }
      paramBoolean = t.i(this);
      if (paramBoolean) {
        paramInt = getMeasuredWidth();
      } else {
        paramInt = 0;
      }
      int j = 0;
      for (int i = paramInt; j < getChildCount(); i = paramInt)
      {
        View localView = getChildAt(j);
        int k;
        if (((localView.getLayoutParams() instanceof Toolbar.LayoutParams)) && ((((Toolbar.LayoutParams)localView.getLayoutParams()).a & 0x800007) == 8388611)) {
          k = 1;
        } else {
          k = 0;
        }
        paramInt = i;
        if (k != 0) {
          if (paramBoolean) {
            paramInt = Math.min(i, localView.getLeft());
          } else {
            paramInt = Math.max(i, localView.getRight());
          }
        }
        j += 1;
      }
      if (paramBoolean) {
        paramInt = paramActionMenuView.getRight();
      } else {
        paramInt = paramActionMenuView.getLeft();
      }
      if (paramBoolean) {
        j = this.n0;
      } else {
        j = -this.o0;
      }
      return i - (paramInt + j);
    }
    return 0;
  }
  
  public void N0(int paramInt)
  {
    if (paramInt != 0)
    {
      this.i0 = 0;
      getMenu().clear();
      x(paramInt);
    }
  }
  
  public void Q0(int paramInt1, int paramInt2)
  {
    this.i0 = paramInt2;
    this.j0 = true;
    K0(paramInt1, this.k0);
    L0(paramInt1);
    this.a0 = paramInt1;
  }
  
  boolean R0(int paramInt)
  {
    float f = paramInt;
    if (f != getTopEdgeTreatment().j())
    {
      getTopEdgeTreatment().p(f);
      this.U.invalidateSelf();
      return true;
    }
    return false;
  }
  
  public ColorStateList getBackgroundTint()
  {
    return this.U.I();
  }
  
  public Behavior getBehavior()
  {
    if (this.l0 == null) {
      this.l0 = new Behavior();
    }
    return this.l0;
  }
  
  public float getCradleVerticalOffset()
  {
    return getTopEdgeTreatment().c();
  }
  
  public int getFabAlignmentMode()
  {
    return this.a0;
  }
  
  public int getFabAnimationMode()
  {
    return this.b0;
  }
  
  public float getFabCradleMargin()
  {
    return getTopEdgeTreatment().e();
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return getTopEdgeTreatment().f();
  }
  
  public boolean getHideOnScroll()
  {
    return this.c0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.f(this, this.U);
    if ((getParent() instanceof ViewGroup)) {
      ((ViewGroup)getParent()).setClipChildren(false);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      z0();
      P0();
    }
    O0();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    this.a0 = paramParcelable.c;
    this.k0 = paramParcelable.d;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = this.a0;
    localSavedState.d = this.k0;
    return localSavedState;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    r0.a.o(this.U, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      getTopEdgeTreatment().l(paramFloat);
      this.U.invalidateSelf();
      P0();
    }
  }
  
  public void setElevation(float paramFloat)
  {
    this.U.a0(paramFloat);
    int i = this.U.D();
    int j = this.U.C();
    getBehavior().I(this, i - j);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    Q0(paramInt, 0);
  }
  
  public void setFabAnimationMode(int paramInt)
  {
    this.b0 = paramInt;
  }
  
  void setFabCornerSize(float paramFloat)
  {
    if (paramFloat != getTopEdgeTreatment().d())
    {
      getTopEdgeTreatment().m(paramFloat);
      this.U.invalidateSelf();
    }
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      getTopEdgeTreatment().n(paramFloat);
      this.U.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      getTopEdgeTreatment().o(paramFloat);
      this.U.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.c0 = paramBoolean;
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    super.setNavigationIcon(M0(paramDrawable));
  }
  
  public void setNavigationIconTint(int paramInt)
  {
    this.S = Integer.valueOf(paramInt);
    Drawable localDrawable = getNavigationIcon();
    if (localDrawable != null) {
      setNavigationIcon(localDrawable);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect e = new Rect();
    private WeakReference<BottomAppBar> f;
    private int g;
    private final View.OnLayoutChangeListener h = new a();
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean Q(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      this.f = new WeakReference(paramBottomAppBar);
      Object localObject = BottomAppBar.p0(paramBottomAppBar);
      if ((localObject != null) && (!x.U((View)localObject)))
      {
        CoordinatorLayout.e locale = (CoordinatorLayout.e)((View)localObject).getLayoutParams();
        locale.d = 49;
        this.g = locale.bottomMargin;
        if ((localObject instanceof FloatingActionButton))
        {
          localObject = (FloatingActionButton)localObject;
          if (((FloatingActionButton)localObject).getShowMotionSpec() == null) {
            ((FloatingActionButton)localObject).setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
          }
          if (((FloatingActionButton)localObject).getHideMotionSpec() == null) {
            ((FloatingActionButton)localObject).setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
          }
          ((ImageButton)localObject).addOnLayoutChangeListener(this.h);
          BottomAppBar.q0(paramBottomAppBar, (FloatingActionButton)localObject);
        }
        BottomAppBar.Y(paramBottomAppBar);
      }
      paramCoordinatorLayout.M(paramBottomAppBar, paramInt);
      return super.l(paramCoordinatorLayout, paramBottomAppBar, paramInt);
    }
    
    public boolean R(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      return (paramBottomAppBar.getHideOnScroll()) && (super.A(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
    }
    
    class a
      implements View.OnLayoutChangeListener
    {
      a() {}
      
      public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
      {
        BottomAppBar localBottomAppBar = (BottomAppBar)BottomAppBar.Behavior.N(BottomAppBar.Behavior.this).get();
        if ((localBottomAppBar != null) && ((paramView instanceof FloatingActionButton)))
        {
          FloatingActionButton localFloatingActionButton = (FloatingActionButton)paramView;
          localFloatingActionButton.j(BottomAppBar.Behavior.O(BottomAppBar.Behavior.this));
          paramInt1 = BottomAppBar.Behavior.O(BottomAppBar.Behavior.this).height();
          localBottomAppBar.R0(paramInt1);
          localBottomAppBar.setFabCornerSize(localFloatingActionButton.getShapeAppearanceModel().r().a(new RectF(BottomAppBar.Behavior.O(BottomAppBar.Behavior.this))));
          paramView = (CoordinatorLayout.e)paramView.getLayoutParams();
          if (BottomAppBar.Behavior.P(BottomAppBar.Behavior.this) == 0)
          {
            paramInt1 = (localFloatingActionButton.getMeasuredHeight() - paramInt1) / 2;
            paramInt2 = localBottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin);
            paramView.bottomMargin = (BottomAppBar.k0(localBottomAppBar) + (paramInt2 - paramInt1));
            paramView.leftMargin = BottomAppBar.l0(localBottomAppBar);
            paramView.rightMargin = BottomAppBar.m0(localBottomAppBar);
            if (t.i(localFloatingActionButton))
            {
              paramView.leftMargin += BottomAppBar.o0(localBottomAppBar);
              return;
            }
            paramView.rightMargin += BottomAppBar.o0(localBottomAppBar);
          }
          return;
        }
        paramView.removeOnLayoutChangeListener(this);
      }
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    int c;
    boolean d;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<BottomAppBar.SavedState>
    {
      public BottomAppBar.SavedState a(Parcel paramParcel)
      {
        return new BottomAppBar.SavedState(paramParcel, null);
      }
      
      public BottomAppBar.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new BottomAppBar.SavedState(paramParcel, paramClassLoader);
      }
      
      public BottomAppBar.SavedState[] c(int paramInt)
      {
        return new BottomAppBar.SavedState[paramInt];
      }
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (!BottomAppBar.R(BottomAppBar.this))
      {
        paramAnimator = BottomAppBar.this;
        BottomAppBar.n0(paramAnimator, BottomAppBar.T(paramAnimator), BottomAppBar.f0(BottomAppBar.this));
      }
    }
  }
  
  class b
    implements k<FloatingActionButton>
  {
    b() {}
    
    public void c(FloatingActionButton paramFloatingActionButton)
    {
      h localh = BottomAppBar.r0(BottomAppBar.this);
      float f;
      if (paramFloatingActionButton.getVisibility() == 0) {
        f = paramFloatingActionButton.getScaleY();
      } else {
        f = 0.0F;
      }
      localh.c0(f);
    }
    
    public void d(FloatingActionButton paramFloatingActionButton)
    {
      float f1 = paramFloatingActionButton.getTranslationX();
      if (BottomAppBar.s0(BottomAppBar.this).k() != f1)
      {
        BottomAppBar.s0(BottomAppBar.this).q(f1);
        BottomAppBar.r0(BottomAppBar.this).invalidateSelf();
      }
      float f2 = -paramFloatingActionButton.getTranslationY();
      f1 = 0.0F;
      f2 = Math.max(0.0F, f2);
      if (BottomAppBar.s0(BottomAppBar.this).c() != f2)
      {
        BottomAppBar.s0(BottomAppBar.this).l(f2);
        BottomAppBar.r0(BottomAppBar.this).invalidateSelf();
      }
      h localh = BottomAppBar.r0(BottomAppBar.this);
      if (paramFloatingActionButton.getVisibility() == 0) {
        f1 = paramFloatingActionButton.getScaleY();
      }
      localh.c0(f1);
    }
  }
  
  class c
    implements t.e
  {
    c() {}
    
    public h0 a(View paramView, h0 paramh0, t.f paramf)
    {
      if (BottomAppBar.t0(BottomAppBar.this)) {
        BottomAppBar.u0(BottomAppBar.this, paramh0.i());
      }
      boolean bool = BottomAppBar.v0(BottomAppBar.this);
      int k = 1;
      int m = 0;
      int j;
      if (bool)
      {
        if (BottomAppBar.w0(BottomAppBar.this) != paramh0.j()) {
          i = 1;
        } else {
          i = 0;
        }
        BottomAppBar.x0(BottomAppBar.this, paramh0.j());
        j = i;
      }
      else
      {
        j = 0;
      }
      int i = m;
      if (BottomAppBar.U(BottomAppBar.this))
      {
        if (BottomAppBar.V(BottomAppBar.this) != paramh0.k()) {
          i = k;
        } else {
          i = 0;
        }
        BottomAppBar.W(BottomAppBar.this, paramh0.k());
      }
      if ((j != 0) || (i != 0))
      {
        BottomAppBar.X(BottomAppBar.this);
        BottomAppBar.Y(BottomAppBar.this);
        BottomAppBar.Z(BottomAppBar.this);
      }
      return paramh0;
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BottomAppBar.b0(BottomAppBar.this);
      BottomAppBar.c0(BottomAppBar.this, null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BottomAppBar.a0(BottomAppBar.this);
    }
  }
  
  class e
    extends FloatingActionButton.b
  {
    e(int paramInt) {}
    
    public void a(FloatingActionButton paramFloatingActionButton)
    {
      paramFloatingActionButton.setTranslationX(BottomAppBar.d0(BottomAppBar.this, paramInt));
      paramFloatingActionButton.s(new a());
    }
    
    class a
      extends FloatingActionButton.b
    {
      a() {}
      
      public void b(FloatingActionButton paramFloatingActionButton)
      {
        BottomAppBar.b0(BottomAppBar.this);
      }
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      BottomAppBar.b0(BottomAppBar.this);
      BottomAppBar.S(BottomAppBar.this, false);
      BottomAppBar.e0(BottomAppBar.this, null);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BottomAppBar.a0(BottomAppBar.this);
    }
  }
  
  class g
    extends AnimatorListenerAdapter
  {
    public boolean a;
    
    g(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.a)
      {
        boolean bool;
        if (BottomAppBar.g0(BottomAppBar.this) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramAnimator = BottomAppBar.this;
        paramAnimator.N0(BottomAppBar.g0(paramAnimator));
        BottomAppBar.h0(BottomAppBar.this, this.b, paramInt, paramBoolean, bool);
      }
    }
  }
  
  class h
    implements Runnable
  {
    h(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean) {}
    
    public void run()
    {
      ActionMenuView localActionMenuView = paramActionMenuView;
      localActionMenuView.setTranslationX(BottomAppBar.this.H0(localActionMenuView, paramInt, paramBoolean1));
    }
  }
  
  class i
    extends AnimatorListenerAdapter
  {
    i() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      BottomAppBar.this.p0.onAnimationStart(paramAnimator);
      paramAnimator = BottomAppBar.i0(BottomAppBar.this);
      if (paramAnimator != null) {
        paramAnimator.setTranslationX(BottomAppBar.j0(BottomAppBar.this));
      }
    }
  }
  
  static abstract interface j
  {
    public abstract void a(BottomAppBar paramBottomAppBar);
    
    public abstract void b(BottomAppBar paramBottomAppBar);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */