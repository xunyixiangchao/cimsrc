package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.t;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import o7.c;
import r7.m;
import r7.m.b;

public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements k7.a, r7.p, CoordinatorLayout.b
{
  private static final int r = R.style.Widget_Design_FloatingActionButton;
  private ColorStateList b;
  private PorterDuff.Mode c;
  private ColorStateList d;
  private PorterDuff.Mode e;
  private ColorStateList f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  boolean l;
  final Rect m = new Rect();
  private final Rect n = new Rect();
  private final androidx.appcompat.widget.k o;
  private final k7.b p;
  private d q;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.floatingActionButtonStyle);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    Object localObject2 = getContext();
    Object localObject1 = com.google.android.material.internal.p.h((Context)localObject2, paramAttributeSet, R.styleable.FloatingActionButton, paramInt, i1, new int[0]);
    this.b = c.a((Context)localObject2, (TypedArray)localObject1, R.styleable.FloatingActionButton_backgroundTint);
    this.c = t.j(((TypedArray)localObject1).getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    this.f = c.a((Context)localObject2, (TypedArray)localObject1, R.styleable.FloatingActionButton_rippleColor);
    this.h = ((TypedArray)localObject1).getInt(R.styleable.FloatingActionButton_fabSize, -1);
    this.i = ((TypedArray)localObject1).getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
    this.g = ((TypedArray)localObject1).getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = ((TypedArray)localObject1).getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = ((TypedArray)localObject1).getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = ((TypedArray)localObject1).getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.l = ((TypedArray)localObject1).getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    int i2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
    setMaxImageSize(((TypedArray)localObject1).getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0));
    paramContext = e7.h.c((Context)localObject2, (TypedArray)localObject1, R.styleable.FloatingActionButton_showMotionSpec);
    e7.h localh = e7.h.c((Context)localObject2, (TypedArray)localObject1, R.styleable.FloatingActionButton_hideMotionSpec);
    localObject2 = m.g((Context)localObject2, paramAttributeSet, paramInt, i1, m.m).m();
    boolean bool = ((TypedArray)localObject1).getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
    setEnabled(((TypedArray)localObject1).getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
    ((TypedArray)localObject1).recycle();
    localObject1 = new androidx.appcompat.widget.k(this);
    this.o = ((androidx.appcompat.widget.k)localObject1);
    ((androidx.appcompat.widget.k)localObject1).g(paramAttributeSet, paramInt);
    this.p = new k7.b(this);
    getImpl().W((m)localObject2);
    getImpl().w(this.b, this.c, this.f, this.g);
    getImpl().S(i2);
    getImpl().M(f1);
    getImpl().P(f2);
    getImpl().T(f3);
    getImpl().X(paramContext);
    getImpl().O(localh);
    getImpl().N(bool);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private d getImpl()
  {
    if (this.q == null) {
      this.q = h();
    }
    return this.q;
  }
  
  private d h()
  {
    return new e(this, new c());
  }
  
  private int k(int paramInt)
  {
    int i1 = this.i;
    if (i1 != 0) {
      return i1;
    }
    Resources localResources = getResources();
    if (paramInt != -1)
    {
      if (paramInt != 1) {}
      for (paramInt = R.dimen.design_fab_size_normal;; paramInt = R.dimen.design_fab_size_mini) {
        return localResources.getDimensionPixelSize(paramInt);
      }
    }
    if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
      return k(1);
    }
    return k(0);
  }
  
  private void p(Rect paramRect)
  {
    int i1 = paramRect.left;
    Rect localRect = this.m;
    paramRect.left = (i1 + localRect.left);
    paramRect.top += localRect.top;
    paramRect.right -= localRect.right;
    paramRect.bottom -= localRect.bottom;
  }
  
  private void q()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    Object localObject = this.d;
    if (localObject == null)
    {
      r0.a.c(localDrawable);
      return;
    }
    int i1 = ((ColorStateList)localObject).getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode = this.e;
    localObject = localMode;
    if (localMode == null) {
      localObject = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(androidx.appcompat.widget.g.e(i1, (PorterDuff.Mode)localObject));
  }
  
  private static int r(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 != -2147483648)
    {
      if (i1 != 0)
      {
        if (i1 == 1073741824) {
          return paramInt2;
        }
        throw new IllegalArgumentException();
      }
    }
    else {
      paramInt1 = Math.min(paramInt1, paramInt2);
    }
    return paramInt1;
  }
  
  private d.k u(final b paramb)
  {
    if (paramb == null) {
      return null;
    }
    return new a(paramb);
  }
  
  public boolean a()
  {
    return this.p.c();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().D(getDrawableState());
  }
  
  public void e(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().e(paramAnimatorListener);
  }
  
  public void f(Animator.AnimatorListener paramAnimatorListener)
  {
    getImpl().f(paramAnimatorListener);
  }
  
  public void g(e7.k<? extends FloatingActionButton> paramk)
  {
    getImpl().g(new d(paramk));
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.b;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.c;
  }
  
  public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior()
  {
    return new Behavior();
  }
  
  public float getCompatElevation()
  {
    return getImpl().m();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().p();
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().s();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().l();
  }
  
  public int getCustomSize()
  {
    return this.i;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.p.b();
  }
  
  public e7.h getHideMotionSpec()
  {
    return getImpl().o();
  }
  
  @Deprecated
  public int getRippleColor()
  {
    ColorStateList localColorStateList = this.f;
    if (localColorStateList != null) {
      return localColorStateList.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.f;
  }
  
  public m getShapeAppearanceModel()
  {
    return (m)x0.h.g(getImpl().t());
  }
  
  public e7.h getShowMotionSpec()
  {
    return getImpl().u();
  }
  
  public int getSize()
  {
    return this.h;
  }
  
  int getSizeDimension()
  {
    return k(this.h);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return this.d;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.e;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.l;
  }
  
  @Deprecated
  public boolean i(Rect paramRect)
  {
    if (x.U(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      p(paramRect);
      return true;
    }
    return false;
  }
  
  public void j(Rect paramRect)
  {
    paramRect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    p(paramRect);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().z();
  }
  
  public void l(b paramb)
  {
    m(paramb, true);
  }
  
  void m(b paramb, boolean paramBoolean)
  {
    getImpl().v(u(paramb), paramBoolean);
  }
  
  public boolean n()
  {
    return getImpl().x();
  }
  
  public boolean o()
  {
    return getImpl().y();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().A();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().C();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getSizeDimension();
    this.j = ((i1 - this.k) / 2);
    getImpl().e0();
    paramInt1 = Math.min(r(i1, paramInt1), r(i1, paramInt2));
    Rect localRect = this.m;
    setMeasuredDimension(localRect.left + paramInt1 + localRect.right, paramInt1 + localRect.top + localRect.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    this.p.d((Bundle)x0.h.g(paramParcelable.c.get("expandableWidgetHelper")));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Object localObject = localParcelable;
    if (localParcelable == null) {
      localObject = new Bundle();
    }
    localObject = new ExtendableSavedState((Parcelable)localObject);
    ((ExtendableSavedState)localObject).c.put("expandableWidgetHelper", this.p.e());
    return localObject;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (i(this.n)) && (!this.n.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void s(b paramb)
  {
    t(paramb, true);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.b != paramColorStateList)
    {
      this.b = paramColorStateList;
      getImpl().K(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != paramMode)
    {
      this.c = paramMode;
      getImpl().L(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().M(paramFloat);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().P(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().T(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt != this.i)
      {
        this.i = paramInt;
        requestLayout();
      }
      return;
    }
    throw new IllegalArgumentException("Custom size must be non-negative");
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    getImpl().f0(paramFloat);
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    if (paramBoolean != getImpl().n())
    {
      getImpl().N(paramBoolean);
      requestLayout();
    }
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.p.f(paramInt);
  }
  
  public void setHideMotionSpec(e7.h paramh)
  {
    getImpl().O(paramh);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(e7.h.d(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (getDrawable() != paramDrawable)
    {
      super.setImageDrawable(paramDrawable);
      getImpl().d0();
      if (this.d != null) {
        q();
      }
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.o.i(paramInt);
    q();
  }
  
  public void setMaxImageSize(int paramInt)
  {
    this.k = paramInt;
    getImpl().R(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.f != paramColorStateList)
    {
      this.f = paramColorStateList;
      getImpl().U(this.f);
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    super.setScaleX(paramFloat);
    getImpl().H();
  }
  
  public void setScaleY(float paramFloat)
  {
    super.setScaleY(paramFloat);
    getImpl().H();
  }
  
  public void setShadowPaddingEnabled(boolean paramBoolean)
  {
    getImpl().V(paramBoolean);
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    getImpl().W(paramm);
  }
  
  public void setShowMotionSpec(e7.h paramh)
  {
    getImpl().X(paramh);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(e7.h.d(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.i = 0;
    if (paramInt != this.h)
    {
      this.h = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.d != paramColorStateList)
    {
      this.d = paramColorStateList;
      q();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.e != paramMode)
    {
      this.e = paramMode;
      q();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    super.setTranslationX(paramFloat);
    getImpl().I();
  }
  
  public void setTranslationY(float paramFloat)
  {
    super.setTranslationY(paramFloat);
    getImpl().I();
  }
  
  public void setTranslationZ(float paramFloat)
  {
    super.setTranslationZ(paramFloat);
    getImpl().I();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      getImpl().B();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  void t(b paramb, boolean paramBoolean)
  {
    getImpl().b0(u(paramb), paramBoolean);
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect a;
    private FloatingActionButton.b b;
    private boolean c;
    
    public BaseBehavior()
    {
      this.c = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
      this.c = paramContext.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
    }
    
    private static boolean F(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.e)) {
        return ((CoordinatorLayout.e)paramView).f() instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    private void G(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = paramFloatingActionButton.m;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        CoordinatorLayout.e locale = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
        int i = paramFloatingActionButton.getRight();
        int k = paramCoordinatorLayout.getWidth();
        int m = locale.rightMargin;
        int j = 0;
        if (i >= k - m) {
          i = localRect.right;
        } else if (paramFloatingActionButton.getLeft() <= locale.leftMargin) {
          i = -localRect.left;
        } else {
          i = 0;
        }
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - locale.bottomMargin) {
          j = localRect.bottom;
        } else if (paramFloatingActionButton.getTop() <= locale.topMargin) {
          j = -localRect.top;
        }
        if (j != 0) {
          x.b0(paramFloatingActionButton, j);
        }
        if (i != 0) {
          x.a0(paramFloatingActionButton, i);
        }
      }
    }
    
    private boolean J(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.e locale = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
      if (!this.c) {
        return false;
      }
      if (locale.e() != paramView.getId()) {
        return false;
      }
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }
    
    private boolean K(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!J(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.a == null) {
        this.a = new Rect();
      }
      Rect localRect = this.a;
      com.google.android.material.internal.d.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.m(this.b, false);
      } else {
        paramFloatingActionButton.t(this.b, false);
      }
      return true;
    }
    
    private boolean L(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!J(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.e locale = (CoordinatorLayout.e)paramFloatingActionButton.getLayoutParams();
      if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + locale.topMargin) {
        paramFloatingActionButton.m(this.b, false);
      } else {
        paramFloatingActionButton.t(this.b, false);
      }
      return true;
    }
    
    public boolean E(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, Rect paramRect)
    {
      paramCoordinatorLayout = paramFloatingActionButton.m;
      paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
      return true;
    }
    
    public boolean H(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        K(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      } else if (F(paramView)) {
        L(paramView, paramFloatingActionButton);
      }
      return false;
    }
    
    public boolean I(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.v(paramFloatingActionButton);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)localList.get(i);
        if ((localView instanceof AppBarLayout) ? !K(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton) : (F(localView)) && (L(localView, paramFloatingActionButton))) {
          break;
        }
        i += 1;
      }
      paramCoordinatorLayout.M(paramFloatingActionButton, paramInt);
      G(paramCoordinatorLayout, paramFloatingActionButton);
      return true;
    }
    
    public void g(CoordinatorLayout.e parame)
    {
      if (parame.h == 0) {
        parame.h = 80;
      }
    }
  }
  
  public static class Behavior
    extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  class a
    implements d.k
  {
    a(FloatingActionButton.b paramb) {}
    
    public void a()
    {
      paramb.b(FloatingActionButton.this);
    }
    
    public void b()
    {
      paramb.a(FloatingActionButton.this);
    }
  }
  
  public static abstract class b
  {
    public void a(FloatingActionButton paramFloatingActionButton) {}
    
    public void b(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class c
    implements q7.b
  {
    c() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.m.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(paramInt1 + FloatingActionButton.c(localFloatingActionButton), paramInt2 + FloatingActionButton.c(FloatingActionButton.this), paramInt3 + FloatingActionButton.c(FloatingActionButton.this), paramInt4 + FloatingActionButton.c(FloatingActionButton.this));
    }
    
    public void b(Drawable paramDrawable)
    {
      if (paramDrawable != null) {
        FloatingActionButton.d(FloatingActionButton.this, paramDrawable);
      }
    }
    
    public boolean c()
    {
      return FloatingActionButton.this.l;
    }
  }
  
  class d<T extends FloatingActionButton>
    implements d.j
  {
    private final e7.k<T> a;
    
    d()
    {
      Object localObject;
      this.a = localObject;
    }
    
    public void a()
    {
      this.a.a(FloatingActionButton.this);
    }
    
    public void b()
    {
      this.a.b(FloatingActionButton.this);
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof d)) && (((d)paramObject).a.equals(this.a));
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */