package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import r7.i;
import r7.m;

public class MaterialCardView
  extends CardView
  implements Checkable, r7.p
{
  private static final int[] o = { 16842911 };
  private static final int[] p = { 16842912 };
  private static final int[] q = { R.attr.state_dragged };
  private static final int r = R.style.Widget_MaterialComponents_CardView;
  private final a j;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private a n;
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i), paramAttributeSet, paramInt);
    paramContext = com.google.android.material.internal.p.h(getContext(), paramAttributeSet, R.styleable.MaterialCardView, paramInt, i, new int[0]);
    paramAttributeSet = new a(this, paramAttributeSet, paramInt, i);
    this.j = paramAttributeSet;
    paramAttributeSet.J(super.getCardBackgroundColor());
    paramAttributeSet.Y(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
    paramAttributeSet.G(paramContext);
    paramContext.recycle();
  }
  
  private RectF getBoundsAsRectF()
  {
    RectF localRectF = new RectF();
    localRectF.set(this.j.j().getBounds());
    return localRectF;
  }
  
  private void i()
  {
    if (Build.VERSION.SDK_INT > 26) {
      this.j.i();
    }
  }
  
  public ColorStateList getCardBackgroundColor()
  {
    return this.j.k();
  }
  
  public ColorStateList getCardForegroundColor()
  {
    return this.j.l();
  }
  
  float getCardViewRadius()
  {
    return h(this);
  }
  
  public Drawable getCheckedIcon()
  {
    return this.j.m();
  }
  
  public int getCheckedIconGravity()
  {
    return this.j.n();
  }
  
  public int getCheckedIconMargin()
  {
    return this.j.o();
  }
  
  public int getCheckedIconSize()
  {
    return this.j.p();
  }
  
  public ColorStateList getCheckedIconTint()
  {
    return this.j.q();
  }
  
  public int getContentPaddingBottom()
  {
    return this.j.A().bottom;
  }
  
  public int getContentPaddingLeft()
  {
    return this.j.A().left;
  }
  
  public int getContentPaddingRight()
  {
    return this.j.A().right;
  }
  
  public int getContentPaddingTop()
  {
    return this.j.A().top;
  }
  
  public float getProgress()
  {
    return this.j.u();
  }
  
  public float getRadius()
  {
    return this.j.s();
  }
  
  public ColorStateList getRippleColor()
  {
    return this.j.v();
  }
  
  public m getShapeAppearanceModel()
  {
    return this.j.w();
  }
  
  @Deprecated
  public int getStrokeColor()
  {
    return this.j.x();
  }
  
  public ColorStateList getStrokeColorStateList()
  {
    return this.j.y();
  }
  
  public int getStrokeWidth()
  {
    return this.j.z();
  }
  
  public boolean isChecked()
  {
    return this.l;
  }
  
  public boolean j()
  {
    a locala = this.j;
    return (locala != null) && (locala.D());
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  void l(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.g(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.f(this, this.j.j());
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    if (j()) {
      FrameLayout.mergeDrawableStates(arrayOfInt, o);
    }
    if (isChecked()) {
      FrameLayout.mergeDrawableStates(arrayOfInt, p);
    }
    if (k()) {
      FrameLayout.mergeDrawableStates(arrayOfInt, q);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
    paramAccessibilityNodeInfo.setCheckable(j());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    paramAccessibilityNodeInfo.setChecked(isChecked());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.j.H(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.k)
    {
      if (!this.j.C())
      {
        Log.i("MaterialCardView", "Setting a custom background is not supported.");
        this.j.I(true);
      }
      super.setBackgroundDrawable(paramDrawable);
    }
  }
  
  void setBackgroundInternal(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCardBackgroundColor(int paramInt)
  {
    this.j.J(ColorStateList.valueOf(paramInt));
  }
  
  public void setCardBackgroundColor(ColorStateList paramColorStateList)
  {
    this.j.J(paramColorStateList);
  }
  
  public void setCardElevation(float paramFloat)
  {
    super.setCardElevation(paramFloat);
    this.j.d0();
  }
  
  public void setCardForegroundColor(ColorStateList paramColorStateList)
  {
    this.j.K(paramColorStateList);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    this.j.L(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.l != paramBoolean) {
      toggle();
    }
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    this.j.N(paramDrawable);
  }
  
  public void setCheckedIconGravity(int paramInt)
  {
    if (this.j.n() != paramInt) {
      this.j.O(paramInt);
    }
  }
  
  public void setCheckedIconMargin(int paramInt)
  {
    this.j.P(paramInt);
  }
  
  public void setCheckedIconMarginResource(int paramInt)
  {
    if (paramInt != -1) {
      this.j.P(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    this.j.N(c.a.b(getContext(), paramInt));
  }
  
  public void setCheckedIconSize(int paramInt)
  {
    this.j.Q(paramInt);
  }
  
  public void setCheckedIconSizeResource(int paramInt)
  {
    if (paramInt != 0) {
      this.j.Q(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList)
  {
    this.j.R(paramColorStateList);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    super.setClickable(paramBoolean);
    a locala = this.j;
    if (locala != null) {
      locala.b0();
    }
  }
  
  public void setDragged(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      refreshDrawableState();
      i();
      invalidate();
    }
  }
  
  public void setMaxCardElevation(float paramFloat)
  {
    super.setMaxCardElevation(paramFloat);
    this.j.f0();
  }
  
  public void setOnCheckedChangeListener(a parama)
  {
    this.n = parama;
  }
  
  public void setPreventCornerOverlap(boolean paramBoolean)
  {
    super.setPreventCornerOverlap(paramBoolean);
    this.j.f0();
    this.j.c0();
  }
  
  public void setProgress(float paramFloat)
  {
    this.j.T(paramFloat);
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.j.S(paramFloat);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    this.j.U(paramColorStateList);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    this.j.U(c.a.a(getContext(), paramInt));
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    setClipToOutline(paramm.u(getBoundsAsRectF()));
    this.j.V(paramm);
  }
  
  public void setStrokeColor(int paramInt)
  {
    setStrokeColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    this.j.W(paramColorStateList);
    invalidate();
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.j.X(paramInt);
    invalidate();
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    super.setUseCompatPadding(paramBoolean);
    this.j.f0();
    this.j.c0();
  }
  
  public void toggle()
  {
    if ((j()) && (isEnabled()))
    {
      this.l ^= true;
      refreshDrawableState();
      i();
      this.j.M(this.l);
      a locala = this.n;
      if (locala != null) {
        locala.a(this, this.l);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(MaterialCardView paramMaterialCardView, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.card.MaterialCardView
 * JD-Core Version:    0.7.0.1
 */