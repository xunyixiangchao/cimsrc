package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.x;
import androidx.core.widget.l;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.t;
import java.util.Iterator;
import java.util.LinkedHashSet;
import o7.c;
import r7.h;
import r7.i;
import r7.m;
import r7.m.b;

public class MaterialButton
  extends AppCompatButton
  implements Checkable, r7.p
{
  private static final int[] q = { 16842911 };
  private static final int[] r = { 16842912 };
  private static final int s = R.style.Widget_MaterialComponents_Button;
  private final a d;
  private final LinkedHashSet<a> e = new LinkedHashSet();
  private b f;
  private PorterDuff.Mode g;
  private ColorStateList h;
  private Drawable i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  private int p;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, i1), paramAttributeSet, paramInt);
    boolean bool = false;
    this.n = false;
    this.o = false;
    Context localContext = getContext();
    paramContext = com.google.android.material.internal.p.h(localContext, paramAttributeSet, R.styleable.MaterialButton, paramInt, i1, new int[0]);
    this.m = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    this.g = t.j(paramContext.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.h = c.a(getContext(), paramContext, R.styleable.MaterialButton_iconTint);
    this.i = c.e(getContext(), paramContext, R.styleable.MaterialButton_icon);
    this.p = paramContext.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    this.j = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    paramAttributeSet = new a(this, m.e(localContext, paramAttributeSet, paramInt, i1).m());
    this.d = paramAttributeSet;
    paramAttributeSet.q(paramContext);
    paramContext.recycle();
    setCompoundDrawablePadding(this.m);
    if (this.i != null) {
      bool = true;
    }
    h(bool);
  }
  
  private boolean b()
  {
    int i1 = this.p;
    return (i1 == 3) || (i1 == 4);
  }
  
  private boolean c()
  {
    int i1 = this.p;
    boolean bool = true;
    if (i1 != 1)
    {
      if (i1 == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean d()
  {
    int i1 = this.p;
    return (i1 == 16) || (i1 == 32);
  }
  
  private boolean e()
  {
    return x.B(this) == 1;
  }
  
  private boolean f()
  {
    a locala = this.d;
    return (locala != null) && (!locala.o());
  }
  
  private void g()
  {
    if (c())
    {
      l.j(this, this.i, null, null, null);
      return;
    }
    if (b())
    {
      l.j(this, null, null, this.i, null);
      return;
    }
    if (d()) {
      l.j(this, null, this.i, null, null);
    }
  }
  
  private String getA11yClassName()
  {
    Object localObject;
    if (a()) {
      localObject = CompoundButton.class;
    } else {
      localObject = Button.class;
    }
    return ((Class)localObject).getName();
  }
  
  private Layout.Alignment getActualTextAlignment()
  {
    int i1 = getTextAlignment();
    if (i1 != 1)
    {
      if ((i1 != 6) && (i1 != 3))
      {
        if (i1 != 4) {
          return Layout.Alignment.ALIGN_NORMAL;
        }
        return Layout.Alignment.ALIGN_CENTER;
      }
      return Layout.Alignment.ALIGN_OPPOSITE;
    }
    return getGravityTextAlignment();
  }
  
  private Layout.Alignment getGravityTextAlignment()
  {
    int i1 = getGravity() & 0x800007;
    if (i1 != 1)
    {
      if ((i1 != 5) && (i1 != 8388613)) {
        return Layout.Alignment.ALIGN_NORMAL;
      }
      return Layout.Alignment.ALIGN_OPPOSITE;
    }
    return Layout.Alignment.ALIGN_CENTER;
  }
  
  private int getTextHeight()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject2 = getText().toString();
    Object localObject1 = localObject2;
    if (getTransformationMethod() != null) {
      localObject1 = getTransformationMethod().getTransformation((CharSequence)localObject2, this).toString();
    }
    localObject2 = new Rect();
    localTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return Math.min(((Rect)localObject2).height(), getLayout().getHeight());
  }
  
  private int getTextWidth()
  {
    TextPaint localTextPaint = getPaint();
    String str2 = getText().toString();
    String str1 = str2;
    if (getTransformationMethod() != null) {
      str1 = getTransformationMethod().getTransformation(str2, this).toString();
    }
    return Math.min((int)localTextPaint.measureText(str1), getLayout().getEllipsizedWidth());
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject1 = this.i;
    int i3 = 1;
    int i1;
    if (localObject1 != null)
    {
      localObject1 = r0.a.r((Drawable)localObject1).mutate();
      this.i = ((Drawable)localObject1);
      r0.a.o((Drawable)localObject1, this.h);
      localObject1 = this.g;
      if (localObject1 != null) {
        r0.a.p(this.i, (PorterDuff.Mode)localObject1);
      }
      i1 = this.j;
      if (i1 == 0) {
        i1 = this.i.getIntrinsicWidth();
      }
      int i2 = this.j;
      if (i2 == 0) {
        i2 = this.i.getIntrinsicHeight();
      }
      localObject1 = this.i;
      int i4 = this.k;
      int i5 = this.l;
      ((Drawable)localObject1).setBounds(i4, i5, i1 + i4, i2 + i5);
      this.i.setVisible(true, paramBoolean);
    }
    if (paramBoolean)
    {
      g();
      return;
    }
    Object localObject3 = l.a(this);
    localObject1 = localObject3[0];
    Object localObject2 = localObject3[1];
    localObject3 = localObject3[2];
    if (c())
    {
      i1 = i3;
      if (localObject1 != this.i) {}
    }
    else if (b())
    {
      i1 = i3;
      if (localObject3 != this.i) {}
    }
    else if ((d()) && (localObject2 != this.i))
    {
      i1 = i3;
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      g();
    }
  }
  
  private void i(int paramInt1, int paramInt2)
  {
    if (this.i != null)
    {
      if (getLayout() == null) {
        return;
      }
      if ((!c()) && (!b()))
      {
        if (!d()) {
          break label291;
        }
        this.k = 0;
        if (this.p == 16) {
          this.l = 0;
        }
      }
      for (;;)
      {
        h(false);
        return;
        int i1 = this.j;
        paramInt1 = i1;
        if (i1 == 0) {
          paramInt1 = this.i.getIntrinsicHeight();
        }
        paramInt1 = (paramInt2 - getTextHeight() - getPaddingTop() - paramInt1 - this.m - getPaddingBottom()) / 2;
        if (this.l != paramInt1)
        {
          this.l = paramInt1;
          for (;;)
          {
            h(false);
            return;
            this.l = 0;
            Layout.Alignment localAlignment = getActualTextAlignment();
            paramInt2 = this.p;
            boolean bool1 = true;
            if ((paramInt2 == 1) || (paramInt2 == 3) || ((paramInt2 == 2) && (localAlignment == Layout.Alignment.ALIGN_NORMAL)) || ((paramInt2 == 4) && (localAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
              break label292;
            }
            i1 = this.j;
            paramInt2 = i1;
            if (i1 == 0) {
              paramInt2 = this.i.getIntrinsicWidth();
            }
            paramInt2 = paramInt1 - getTextWidth() - x.F(this) - paramInt2 - this.m - x.G(this);
            paramInt1 = paramInt2;
            if (localAlignment == Layout.Alignment.ALIGN_CENTER) {
              paramInt1 = paramInt2 / 2;
            }
            boolean bool2 = e();
            if (this.p != 4) {
              bool1 = false;
            }
            paramInt2 = paramInt1;
            if (bool2 != bool1) {
              paramInt2 = -paramInt1;
            }
            if (this.k == paramInt2) {
              break;
            }
            this.k = paramInt2;
          }
        }
        label291:
        return;
        label292:
        this.k = 0;
      }
    }
  }
  
  public boolean a()
  {
    a locala = this.d;
    return (locala != null) && (locala.p());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    if (f()) {
      return this.d.b();
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.i;
  }
  
  public int getIconGravity()
  {
    return this.p;
  }
  
  public int getIconPadding()
  {
    return this.m;
  }
  
  public int getIconSize()
  {
    return this.j;
  }
  
  public ColorStateList getIconTint()
  {
    return this.h;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.g;
  }
  
  public int getInsetBottom()
  {
    return this.d.c();
  }
  
  public int getInsetTop()
  {
    return this.d.d();
  }
  
  public ColorStateList getRippleColor()
  {
    if (f()) {
      return this.d.h();
    }
    return null;
  }
  
  public m getShapeAppearanceModel()
  {
    if (f()) {
      return this.d.i();
    }
    throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
  }
  
  public ColorStateList getStrokeColor()
  {
    if (f()) {
      return this.d.j();
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (f()) {
      return this.d.k();
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (f()) {
      return this.d.l();
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (f()) {
      return this.d.m();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  public boolean isChecked()
  {
    return this.n;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (f()) {
      i.f(this, this.d.f());
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 2);
    if (a()) {
      Button.mergeDrawableStates(arrayOfInt, q);
    }
    if (isChecked()) {
      Button.mergeDrawableStates(arrayOfInt, r);
    }
    return arrayOfInt;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(getA11yClassName());
    paramAccessibilityEvent.setChecked(isChecked());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(getA11yClassName());
    paramAccessibilityNodeInfo.setCheckable(a());
    paramAccessibilityNodeInfo.setChecked(isChecked());
    paramAccessibilityNodeInfo.setClickable(isClickable());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    i(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    setChecked(paramParcelable.c);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.c = this.n;
    return localSavedState;
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    i(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean performClick()
  {
    toggle();
    return super.performClick();
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    if (this.i != null)
    {
      int[] arrayOfInt = getDrawableState();
      if (this.i.setState(arrayOfInt)) {
        invalidate();
      }
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (f())
    {
      this.d.r(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (f()) {
      if (paramDrawable != getBackground())
      {
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        this.d.s();
      }
      else
      {
        getBackground().setState(paramDrawable.getState());
        return;
      }
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (f()) {
      this.d.t(paramBoolean);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if ((a()) && (isEnabled()) && (this.n != paramBoolean))
    {
      this.n = paramBoolean;
      refreshDrawableState();
      if ((getParent() instanceof MaterialButtonToggleGroup)) {
        ((MaterialButtonToggleGroup)getParent()).m(this, this.n);
      }
      if (this.o) {
        return;
      }
      this.o = true;
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(this, this.n);
      }
      this.o = false;
    }
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (f()) {
      this.d.u(paramInt);
    }
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (f()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    if (f()) {
      this.d.f().a0(paramFloat);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.i != paramDrawable)
    {
      this.i = paramDrawable;
      h(true);
      i(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    if (this.p != paramInt)
    {
      this.p = paramInt;
      i(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.j != paramInt)
      {
        this.j = paramInt;
        h(true);
      }
      return;
    }
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.h != paramColorStateList)
    {
      this.h = paramColorStateList;
      h(false);
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.g != paramMode)
    {
      this.g = paramMode;
      h(false);
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(c.a.a(getContext(), paramInt));
  }
  
  public void setInsetBottom(int paramInt)
  {
    this.d.v(paramInt);
  }
  
  public void setInsetTop(int paramInt)
  {
    this.d.w(paramInt);
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  void setOnPressedChangeListenerInternal(b paramb)
  {
    this.f = paramb;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    b localb = this.f;
    if (localb != null) {
      localb.a(this, paramBoolean);
    }
    super.setPressed(paramBoolean);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (f()) {
      this.d.x(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (f()) {
      setRippleColor(c.a.a(getContext(), paramInt));
    }
  }
  
  public void setShapeAppearanceModel(m paramm)
  {
    if (f())
    {
      this.d.y(paramm);
      return;
    }
    throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
  }
  
  void setShouldDrawSurfaceColorStroke(boolean paramBoolean)
  {
    if (f()) {
      this.d.z(paramBoolean);
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (f()) {
      this.d.A(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (f()) {
      setStrokeColor(c.a.a(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (f()) {
      this.d.B(paramInt);
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (f()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (f())
    {
      this.d.C(paramColorStateList);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (f())
    {
      this.d.D(paramMode);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
  
  public void setTextAlignment(int paramInt)
  {
    super.setTextAlignment(paramInt);
    i(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void toggle()
  {
    setChecked(this.n ^ true);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    boolean c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        getClass().getClassLoader();
      }
      h(paramParcel);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void h(Parcel paramParcel)
    {
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.c = bool;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<MaterialButton.SavedState>
    {
      public MaterialButton.SavedState a(Parcel paramParcel)
      {
        return new MaterialButton.SavedState(paramParcel, null);
      }
      
      public MaterialButton.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new MaterialButton.SavedState(paramParcel, paramClassLoader);
      }
      
      public MaterialButton.SavedState[] c(int paramInt)
      {
        return new MaterialButton.SavedState[paramInt];
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(MaterialButton paramMaterialButton, boolean paramBoolean);
  }
  
  static abstract interface b
  {
    public abstract void a(MaterialButton paramMaterialButton, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */