package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.g;
import com.google.android.material.internal.g.a;
import com.google.android.material.internal.t;
import java.util.List;
import o7.f;
import p7.b;
import r7.i;
import r7.m;
import y0.d.a;
import y0.d.c;

public class Chip
  extends AppCompatCheckBox
  implements a.a, r7.p, g<Chip>
{
  private static final int[] A = { 16842911 };
  private static final int x = R.style.Widget_MaterialComponents_Chip_Action;
  private static final Rect y = new Rect();
  private static final int[] z = { 16842913 };
  private a e;
  private InsetDrawable f;
  private RippleDrawable g;
  private View.OnClickListener h;
  private CompoundButton.OnCheckedChangeListener i;
  private g.a<Chip> j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private CharSequence r;
  private final d s;
  private boolean t;
  private final Rect u = new Rect();
  private final RectF v = new RectF();
  private final f w = new a();
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    Context localContext = getContext();
    D(paramAttributeSet);
    paramContext = a.B0(localContext, paramAttributeSet, paramInt, i1);
    p(localContext, paramAttributeSet, paramInt);
    setChipDrawable(paramContext);
    paramContext.a0(x.w(this));
    paramAttributeSet = com.google.android.material.internal.p.h(localContext, paramAttributeSet, R.styleable.Chip, paramInt, i1, new int[0]);
    boolean bool = paramAttributeSet.hasValue(R.styleable.Chip_shapeAppearance);
    paramAttributeSet.recycle();
    this.s = new d(this);
    y();
    if (!bool) {
      q();
    }
    setChecked(this.k);
    setText(paramContext.n1());
    setEllipsize(paramContext.h1());
    C();
    if (!this.e.R2())
    {
      setLines(1);
      setHorizontallyScrolling(true);
    }
    setGravity(8388627);
    B();
    if (w()) {
      setMinHeight(this.q);
    }
    this.p = x.B(this);
    super.setOnCheckedChangeListener(new b());
  }
  
  private void A()
  {
    this.g = new RippleDrawable(b.d(this.e.l1()), getBackgroundDrawable(), null);
    this.e.Q2(false);
    x.u0(this, this.g);
    B();
  }
  
  private void B()
  {
    if (!TextUtils.isEmpty(getText()))
    {
      Object localObject = this.e;
      if (localObject == null) {
        return;
      }
      int i3 = (int)(((a)localObject).P0() + this.e.p1() + this.e.w0());
      int i4 = (int)(this.e.U0() + this.e.q1() + this.e.s0());
      int i2 = i3;
      int i1 = i4;
      if (this.f != null)
      {
        localObject = new Rect();
        this.f.getPadding((Rect)localObject);
        i1 = i4 + ((Rect)localObject).left;
        i2 = i3 + ((Rect)localObject).right;
      }
      x.F0(this, i1, getPaddingTop(), i2, getPaddingBottom());
    }
  }
  
  private void C()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = this.e;
    if (localObject != null) {
      localTextPaint.drawableState = ((Drawable)localObject).getState();
    }
    localObject = getTextAppearance();
    if (localObject != null) {
      ((o7.d)localObject).n(getContext(), localTextPaint, this.w);
    }
  }
  
  private void D(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
    }
    if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null)
      {
        if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null)
        {
          if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null)
          {
            if ((paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1) && (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1))
            {
              if (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
              }
              return;
            }
            throw new UnsupportedOperationException("Chip does not support multi-line text");
          }
          throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      }
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  private RectF getCloseIconTouchBounds()
  {
    this.v.setEmpty();
    if ((o()) && (this.h != null)) {
      this.e.e1(this.v);
    }
    return this.v;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.u.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.u;
  }
  
  private o7.d getTextAppearance()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.o1();
    }
    return null;
  }
  
  private void k(a parama)
  {
    parama.v2(this);
  }
  
  private int[] l()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void n()
  {
    if ((getBackgroundDrawable() == this.f) && (this.e.getCallback() == null)) {
      this.e.setCallback(this.f);
    }
  }
  
  private boolean o()
  {
    a locala = this.e;
    return (locala != null) && (locala.X0() != null);
  }
  
  private void p(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = com.google.android.material.internal.p.h(paramContext, paramAttributeSet, R.styleable.Chip, paramInt, x, new int[0]);
    this.o = paramContext.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
    float f1 = (float)Math.ceil(t.c(getContext(), 48));
    this.q = ((int)Math.ceil(paramContext.getDimension(R.styleable.Chip_chipMinTouchTargetSize, f1)));
    paramContext.recycle();
  }
  
  private void q()
  {
    setOutlineProvider(new c());
  }
  
  private void r(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = new InsetDrawable(this.e, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void v()
  {
    if (this.f != null)
    {
      this.f = null;
      setMinWidth(0);
      setMinHeight((int)getChipMinHeight());
      z();
    }
  }
  
  private void x(a parama)
  {
    if (parama != null) {
      parama.v2(null);
    }
  }
  
  private void y()
  {
    boolean bool;
    if ((o()) && (t()) && (this.h != null))
    {
      x.q0(this, this.s);
      bool = true;
    }
    else
    {
      x.q0(this, null);
      bool = false;
    }
    this.t = bool;
  }
  
  private void z()
  {
    if (b.a)
    {
      A();
      return;
    }
    this.e.Q2(true);
    x.u0(this, getBackgroundDrawable());
    B();
    n();
  }
  
  public void a()
  {
    m(this.q);
    requestLayout();
    invalidateOutline();
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if (!this.t) {
      return super.dispatchHoverEvent(paramMotionEvent);
    }
    return (this.s.v(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (!this.t) {
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    if ((this.s.w(paramKeyEvent)) && (this.s.A() != -2147483648)) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    a locala = this.e;
    boolean bool;
    if ((locala != null) && (locala.v1())) {
      bool = this.e.r2(l());
    } else {
      bool = false;
    }
    if (bool) {
      invalidate();
    }
  }
  
  public CharSequence getAccessibilityClassName()
  {
    if (!TextUtils.isEmpty(this.r)) {
      return this.r;
    }
    if (s())
    {
      ViewParent localViewParent = getParent();
      if (((localViewParent instanceof ChipGroup)) && (((ChipGroup)localViewParent).h())) {
        return "android.widget.RadioButton";
      }
      return "android.widget.CompoundButton";
    }
    if (isClickable()) {
      return "android.widget.Button";
    }
    return "android.view.View";
  }
  
  public Drawable getBackgroundDrawable()
  {
    InsetDrawable localInsetDrawable = this.f;
    Object localObject = localInsetDrawable;
    if (localInsetDrawable == null) {
      localObject = this.e;
    }
    return localObject;
  }
  
  public Drawable getCheckedIcon()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.L0();
    }
    return null;
  }
  
  public ColorStateList getCheckedIconTint()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.M0();
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.N0();
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    a locala = this.e;
    float f1 = 0.0F;
    if (locala != null) {
      f1 = Math.max(0.0F, locala.O0());
    }
    return f1;
  }
  
  public Drawable getChipDrawable()
  {
    return this.e;
  }
  
  public float getChipEndPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.P0();
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.Q0();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.R0();
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.S0();
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.T0();
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.U0();
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.V0();
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.W0();
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    return getText();
  }
  
  public Drawable getCloseIcon()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.X0();
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.Y0();
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.Z0();
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.a1();
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.b1();
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.d1();
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.h1();
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if ((this.t) && ((this.s.A() == 1) || (this.s.x() == 1)))
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  public e7.h getHideMotionSpec()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.i1();
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.j1();
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.k1();
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.l1();
    }
    return null;
  }
  
  public m getShapeAppearanceModel()
  {
    return this.e.E();
  }
  
  public e7.h getShowMotionSpec()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.m1();
    }
    return null;
  }
  
  public float getTextEndPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.p1();
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    a locala = this.e;
    if (locala != null) {
      return locala.q1();
    }
    return 0.0F;
  }
  
  public boolean m(int paramInt)
  {
    this.q = paramInt;
    boolean bool = w();
    int i2 = 0;
    if (!bool)
    {
      if (this.f != null)
      {
        v();
        return false;
      }
      z();
      return false;
    }
    int i3 = Math.max(0, paramInt - this.e.getIntrinsicHeight());
    int i1 = Math.max(0, paramInt - this.e.getIntrinsicWidth());
    if ((i1 <= 0) && (i3 <= 0))
    {
      if (this.f != null)
      {
        v();
        return false;
      }
      z();
      return false;
    }
    if (i1 > 0) {
      i1 /= 2;
    } else {
      i1 = 0;
    }
    if (i3 > 0) {
      i2 = i3 / 2;
    }
    if (this.f != null)
    {
      Rect localRect = new Rect();
      this.f.getPadding(localRect);
      if ((localRect.top == i2) && (localRect.bottom == i2) && (localRect.left == i1) && (localRect.right == i1))
      {
        z();
        return true;
      }
    }
    if (getMinHeight() != paramInt) {
      setMinHeight(paramInt);
    }
    if (getMinWidth() != paramInt) {
      setMinWidth(paramInt);
    }
    r(i1, i2, i1, i2);
    z();
    return true;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    i.f(this, this.e);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (isChecked()) {
      CheckBox.mergeDrawableStates(arrayOfInt, z);
    }
    if (s()) {
      CheckBox.mergeDrawableStates(arrayOfInt, A);
    }
    return arrayOfInt;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (this.t) {
      this.s.K(paramBoolean, paramInt, paramRect);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool;
    if (i1 != 7)
    {
      if (i1 != 10) {
        break label46;
      }
      bool = false;
    }
    else
    {
      bool = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    setCloseIconHovered(bool);
    label46:
    return super.onHoverEvent(paramMotionEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(getAccessibilityClassName());
    paramAccessibilityNodeInfo.setCheckable(s());
    paramAccessibilityNodeInfo.setClickable(isClickable());
    if ((getParent() instanceof ChipGroup))
    {
      ChipGroup localChipGroup = (ChipGroup)getParent();
      paramAccessibilityNodeInfo = y0.d.J0(paramAccessibilityNodeInfo);
      int i1;
      if (localChipGroup.c()) {
        i1 = localChipGroup.g(this);
      } else {
        i1 = -1;
      }
      paramAccessibilityNodeInfo.f0(d.c.a(localChipGroup.b(this), 1, i1, 1, false, isChecked()));
    }
  }
  
  @TargetApi(24)
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  @TargetApi(17)
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    if (this.p != paramInt)
    {
      this.p = paramInt;
      B();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool2 = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    boolean bool1 = false;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label108;
          }
        }
        else
        {
          if (!this.l) {
            break label108;
          }
          if (bool2) {
            break label103;
          }
          setCloseIconPressed(false);
          break label103;
        }
      }
      else if (this.l)
      {
        u();
        i1 = 1;
        break label85;
      }
      i1 = 0;
      label85:
      setCloseIconPressed(false);
      break label110;
    }
    else
    {
      if (!bool2) {
        break label108;
      }
      setCloseIconPressed(true);
    }
    label103:
    i1 = 1;
    break label110;
    label108:
    i1 = 0;
    label110:
    if ((i1 != 0) || (super.onTouchEvent(paramMotionEvent))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean s()
  {
    a locala = this.e;
    return (locala != null) && (locala.u1());
  }
  
  public void setAccessibilityClassName(CharSequence paramCharSequence)
  {
    this.r = paramCharSequence;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.g))
    {
      Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
      return;
    }
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != getBackgroundDrawable()) && (paramDrawable != this.g))
    {
      Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    a locala = this.e;
    if (locala != null) {
      locala.D1(paramBoolean);
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.E1(paramInt);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    a locala = this.e;
    if (locala == null)
    {
      this.k = paramBoolean;
      return;
    }
    if (locala.u1()) {
      super.setChecked(paramBoolean);
    }
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    a locala = this.e;
    if (locala != null) {
      locala.F1(paramDrawable);
    }
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.G1(paramInt);
    }
  }
  
  public void setCheckedIconTint(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.H1(paramColorStateList);
    }
  }
  
  public void setCheckedIconTintResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.I1(paramInt);
    }
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.J1(paramInt);
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    a locala = this.e;
    if (locala != null) {
      locala.K1(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.L1(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.M1(paramInt);
    }
  }
  
  @Deprecated
  public void setChipCornerRadius(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.N1(paramFloat);
    }
  }
  
  @Deprecated
  public void setChipCornerRadiusResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.O1(paramInt);
    }
  }
  
  public void setChipDrawable(a parama)
  {
    a locala = this.e;
    if (locala != parama)
    {
      x(locala);
      this.e = parama;
      parama.G2(false);
      k(this.e);
      m(this.q);
    }
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.P1(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.Q1(paramInt);
    }
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    a locala = this.e;
    if (locala != null) {
      locala.R1(paramDrawable);
    }
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.S1(paramInt);
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.T1(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.U1(paramInt);
    }
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.V1(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.W1(paramInt);
    }
  }
  
  public void setChipIconVisible(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.X1(paramInt);
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    a locala = this.e;
    if (locala != null) {
      locala.Y1(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.Z1(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.a2(paramInt);
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.b2(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.c2(paramInt);
    }
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.d2(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.e2(paramInt);
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.f2(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.g2(paramInt);
    }
  }
  
  @Deprecated
  public void setChipText(CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    a locala = this.e;
    if (locala != null) {
      locala.i2(paramDrawable);
    }
    y();
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    a locala = this.e;
    if (locala != null) {
      locala.j2(paramCharSequence);
    }
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.k2(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.l2(paramInt);
    }
  }
  
  public void setCloseIconResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.m2(paramInt);
    }
    y();
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.n2(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.o2(paramInt);
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.p2(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.q2(paramInt);
    }
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.s2(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.t2(paramInt);
    }
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    setCloseIconVisible(getResources().getBoolean(paramInt));
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    a locala = this.e;
    if (locala != null) {
      locala.u2(paramBoolean);
    }
    y();
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == 0)
    {
      if (paramInt3 == 0)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
        return;
      }
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 == null)
    {
      if (paramDrawable3 == null)
      {
        super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
        return;
      }
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    a locala = this.e;
    if (locala != null) {
      locala.a0(paramFloat);
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.e == null) {
      return;
    }
    if (paramTruncateAt != TextUtils.TruncateAt.MARQUEE)
    {
      super.setEllipsize(paramTruncateAt);
      a locala = this.e;
      if (locala != null) {
        locala.w2(paramTruncateAt);
      }
      return;
    }
    throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
  }
  
  public void setEnsureMinTouchTargetSize(boolean paramBoolean)
  {
    this.o = paramBoolean;
    m(this.q);
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt != 8388627)
    {
      Log.w("Chip", "Chip text must be vertically center and start aligned");
      return;
    }
    super.setGravity(paramInt);
  }
  
  public void setHideMotionSpec(e7.h paramh)
  {
    a locala = this.e;
    if (locala != null) {
      locala.x2(paramh);
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.y2(paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.z2(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.A2(paramInt);
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.B2(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.C2(paramInt);
    }
  }
  
  public void setInternalOnCheckedChangeListener(g.a<Chip> parama)
  {
    this.j = parama;
  }
  
  public void setLayoutDirection(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    super.setLayoutDirection(paramInt);
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMaxLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setMaxWidth(int paramInt)
  {
    super.setMaxWidth(paramInt);
    a locala = this.e;
    if (locala != null) {
      locala.D2(paramInt);
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt <= 1)
    {
      super.setMinLines(paramInt);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.i = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.h = paramOnClickListener;
    y();
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    a locala = this.e;
    if (locala != null) {
      locala.E2(paramColorStateList);
    }
    if (!this.e.s1()) {
      A();
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null)
    {
      locala.F2(paramInt);
      if (!this.e.s1()) {
        A();
      }
    }
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    this.e.setShapeAppearanceModel(paramm);
  }
  
  public void setShowMotionSpec(e7.h paramh)
  {
    a locala = this.e;
    if (locala != null) {
      locala.H2(paramh);
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.I2(paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setSingleLine(paramBoolean);
      return;
    }
    throw new UnsupportedOperationException("Chip does not support multi-line text");
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    a locala = this.e;
    if (locala == null) {
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (locala.R2()) {
      paramCharSequence = null;
    } else {
      paramCharSequence = (CharSequence)localObject;
    }
    super.setText(paramCharSequence, paramBufferType);
    paramCharSequence = this.e;
    if (paramCharSequence != null) {
      paramCharSequence.J2((CharSequence)localObject);
    }
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    a locala = this.e;
    if (locala != null) {
      locala.L2(paramInt);
    }
    C();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.L2(paramInt);
    }
    C();
  }
  
  public void setTextAppearance(o7.d paramd)
  {
    a locala = this.e;
    if (locala != null) {
      locala.K2(paramd);
    }
    C();
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.M2(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.N2(paramInt);
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    a locala = this.e;
    if (locala != null) {
      locala.O2(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    a locala = this.e;
    if (locala != null) {
      locala.P2(paramInt);
    }
  }
  
  public boolean t()
  {
    a locala = this.e;
    return (locala != null) && (locala.w1());
  }
  
  public boolean u()
  {
    boolean bool = false;
    playSoundEffect(0);
    View.OnClickListener localOnClickListener = this.h;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(this);
      bool = true;
    }
    if (this.t) {
      this.s.W(1, 1);
    }
    return bool;
  }
  
  public boolean w()
  {
    return this.o;
  }
  
  class a
    extends f
  {
    a() {}
    
    public void a(int paramInt) {}
    
    public void b(Typeface paramTypeface, boolean paramBoolean)
    {
      Chip localChip = Chip.this;
      if (Chip.b(localChip).R2()) {
        paramTypeface = Chip.b(Chip.this).n1();
      } else {
        paramTypeface = Chip.this.getText();
      }
      localChip.setText(paramTypeface);
      Chip.this.requestLayout();
      Chip.this.invalidate();
    }
  }
  
  class b
    implements CompoundButton.OnCheckedChangeListener
  {
    b() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (Chip.c(Chip.this) != null) {
        Chip.c(Chip.this).a(Chip.this, paramBoolean);
      }
      if (Chip.d(Chip.this) != null) {
        Chip.d(Chip.this).onCheckedChanged(paramCompoundButton, paramBoolean);
      }
    }
  }
  
  class c
    extends ViewOutlineProvider
  {
    c() {}
    
    @TargetApi(21)
    public void getOutline(View paramView, Outline paramOutline)
    {
      if (Chip.b(Chip.this) != null)
      {
        Chip.b(Chip.this).getOutline(paramOutline);
        return;
      }
      paramOutline.setAlpha(0.0F);
    }
  }
  
  private class d
    extends c1.a
  {
    d(Chip paramChip)
    {
      super();
    }
    
    protected int B(float paramFloat1, float paramFloat2)
    {
      if ((Chip.e(Chip.this)) && (Chip.f(Chip.this).contains(paramFloat1, paramFloat2))) {
        return 1;
      }
      return 0;
    }
    
    protected void C(List<Integer> paramList)
    {
      paramList.add(Integer.valueOf(0));
      if ((Chip.e(Chip.this)) && (Chip.this.t()) && (Chip.g(Chip.this) != null)) {
        paramList.add(Integer.valueOf(1));
      }
    }
    
    protected boolean L(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (paramInt2 == 16)
      {
        if (paramInt1 == 0) {
          return Chip.this.performClick();
        }
        if (paramInt1 == 1) {
          return Chip.this.u();
        }
      }
      return false;
    }
    
    protected void O(y0.d paramd)
    {
      paramd.a0(Chip.this.s());
      paramd.d0(Chip.this.isClickable());
      paramd.c0(Chip.this.getAccessibilityClassName());
      paramd.F0(Chip.this.getText());
    }
    
    protected void P(int paramInt, y0.d paramd)
    {
      Object localObject = "";
      if (paramInt == 1)
      {
        CharSequence localCharSequence = Chip.this.getCloseIconContentDescription();
        if (localCharSequence != null) {}
        Context localContext;
        for (localObject = localCharSequence;; localObject = localContext.getString(paramInt, new Object[] { localObject }).trim())
        {
          paramd.g0((CharSequence)localObject);
          break;
          localCharSequence = Chip.this.getText();
          localContext = Chip.this.getContext();
          paramInt = R.string.mtrl_chip_close_icon_content_description;
          if (!TextUtils.isEmpty(localCharSequence)) {
            localObject = localCharSequence;
          }
        }
        paramd.X(Chip.i(Chip.this));
        paramd.b(d.a.i);
        paramd.i0(Chip.this.isEnabled());
        return;
      }
      paramd.g0("");
      paramd.X(Chip.j());
    }
    
    protected void Q(int paramInt, boolean paramBoolean)
    {
      if (paramInt == 1)
      {
        Chip.h(Chip.this, paramBoolean);
        Chip.this.refreshDrawableState();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.chip.Chip
 * JD-Core Version:    0.7.0.1
 */