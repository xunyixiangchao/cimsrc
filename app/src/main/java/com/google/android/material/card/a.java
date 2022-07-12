package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import o7.c;
import p7.b;
import r7.d;
import r7.e;
import r7.h;
import r7.l;
import r7.m;
import r7.m.b;

class a
{
  private static final double u = Math.cos(Math.toRadians(45.0D));
  private static final Drawable v;
  private final MaterialCardView a;
  private final Rect b = new Rect();
  private final h c;
  private final h d;
  private int e;
  private int f;
  private int g;
  private int h;
  private Drawable i;
  private Drawable j;
  private ColorStateList k;
  private ColorStateList l;
  private m m;
  private ColorStateList n;
  private Drawable o;
  private LayerDrawable p;
  private h q;
  private h r;
  private boolean s = false;
  private boolean t;
  
  static
  {
    ColorDrawable localColorDrawable;
    if (Build.VERSION.SDK_INT <= 28) {
      localColorDrawable = new ColorDrawable();
    } else {
      localColorDrawable = null;
    }
    v = localColorDrawable;
  }
  
  public a(MaterialCardView paramMaterialCardView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.a = paramMaterialCardView;
    Object localObject = new h(paramMaterialCardView.getContext(), paramAttributeSet, paramInt1, paramInt2);
    this.c = ((h)localObject);
    ((h)localObject).Q(paramMaterialCardView.getContext());
    ((h)localObject).h0(-12303292);
    localObject = ((h)localObject).E().v();
    paramMaterialCardView = paramMaterialCardView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CardView, paramInt1, R.style.CardView);
    paramInt1 = R.styleable.CardView_cardCornerRadius;
    if (paramMaterialCardView.hasValue(paramInt1)) {
      ((m.b)localObject).o(paramMaterialCardView.getDimension(paramInt1, 0.0F));
    }
    this.d = new h();
    V(((m.b)localObject).m());
    paramMaterialCardView.recycle();
  }
  
  private Drawable B(Drawable paramDrawable)
  {
    int i1;
    int i2;
    int i3;
    if (this.a.getUseCompatPadding())
    {
      i1 = (int)Math.ceil(d());
      i2 = (int)Math.ceil(c());
      i3 = i1;
    }
    else
    {
      i1 = 0;
      i3 = i1;
      i2 = i1;
    }
    return new a(paramDrawable, i2, i3, i2, i3);
  }
  
  private boolean E()
  {
    return (this.g & 0x50) == 80;
  }
  
  private boolean F()
  {
    return (this.g & 0x800005) == 8388613;
  }
  
  private boolean Z()
  {
    return (this.a.getPreventCornerOverlap()) && (!e());
  }
  
  private float a()
  {
    return Math.max(Math.max(b(this.m.q(), this.c.J()), b(this.m.s(), this.c.K())), Math.max(b(this.m.k(), this.c.t()), b(this.m.i(), this.c.s())));
  }
  
  private boolean a0()
  {
    return (this.a.getPreventCornerOverlap()) && (e()) && (this.a.getUseCompatPadding());
  }
  
  private float b(d paramd, float paramFloat)
  {
    if ((paramd instanceof l)) {
      return (float)((1.0D - u) * paramFloat);
    }
    if ((paramd instanceof e)) {
      return paramFloat / 2.0F;
    }
    return 0.0F;
  }
  
  private float c()
  {
    float f2 = this.a.getMaxCardElevation();
    float f1;
    if (a0()) {
      f1 = a();
    } else {
      f1 = 0.0F;
    }
    return f2 + f1;
  }
  
  private float d()
  {
    float f2 = this.a.getMaxCardElevation();
    float f1;
    if (a0()) {
      f1 = a();
    } else {
      f1 = 0.0F;
    }
    return f2 * 1.5F + f1;
  }
  
  private boolean e()
  {
    return this.c.T();
  }
  
  private void e0(Drawable paramDrawable)
  {
    if ((this.a.getForeground() instanceof InsetDrawable))
    {
      ((InsetDrawable)this.a.getForeground()).setDrawable(paramDrawable);
      return;
    }
    this.a.setForeground(B(paramDrawable));
  }
  
  private Drawable f()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    h localh = h();
    this.q = localh;
    localh.b0(this.k);
    localh = this.q;
    localStateListDrawable.addState(new int[] { 16842919 }, localh);
    return localStateListDrawable;
  }
  
  private Drawable g()
  {
    if (b.a)
    {
      this.r = h();
      return new RippleDrawable(this.k, null, this.r);
    }
    return f();
  }
  
  private void g0()
  {
    if (b.a)
    {
      localObject = this.o;
      if (localObject != null)
      {
        ((RippleDrawable)localObject).setColor(this.k);
        return;
      }
    }
    Object localObject = this.q;
    if (localObject != null) {
      ((h)localObject).b0(this.k);
    }
  }
  
  private h h()
  {
    return new h(this.m);
  }
  
  private Drawable r()
  {
    if (this.o == null) {
      this.o = g();
    }
    if (this.p == null)
    {
      LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { this.o, this.d, this.j });
      this.p = localLayerDrawable;
      localLayerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
    }
    return this.p;
  }
  
  private float t()
  {
    if ((this.a.getPreventCornerOverlap()) && (this.a.getUseCompatPadding())) {
      return (float)((1.0D - u) * this.a.getCardViewRadius());
    }
    return 0.0F;
  }
  
  Rect A()
  {
    return this.b;
  }
  
  boolean C()
  {
    return this.s;
  }
  
  boolean D()
  {
    return this.t;
  }
  
  void G(TypedArray paramTypedArray)
  {
    ColorStateList localColorStateList = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialCardView_strokeColor);
    this.n = localColorStateList;
    if (localColorStateList == null) {
      this.n = ColorStateList.valueOf(-1);
    }
    this.h = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
    boolean bool = paramTypedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
    this.t = bool;
    this.a.setLongClickable(bool);
    this.l = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialCardView_checkedIconTint);
    N(c.e(this.a.getContext(), paramTypedArray, R.styleable.MaterialCardView_checkedIcon));
    Q(paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
    P(paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
    this.g = paramTypedArray.getInteger(R.styleable.MaterialCardView_checkedIconGravity, 8388661);
    localColorStateList = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialCardView_rippleColor);
    this.k = localColorStateList;
    if (localColorStateList == null) {
      this.k = ColorStateList.valueOf(g7.a.d(this.a, R.attr.colorControlHighlight));
    }
    K(c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialCardView_cardForegroundColor));
    g0();
    d0();
    h0();
    this.a.setBackgroundInternal(B(this.c));
    if (this.a.isClickable()) {
      paramTypedArray = r();
    } else {
      paramTypedArray = this.d;
    }
    this.i = paramTypedArray;
    this.a.setForeground(B(paramTypedArray));
  }
  
  void H(int paramInt1, int paramInt2)
  {
    if (this.p != null)
    {
      boolean bool = this.a.getUseCompatPadding();
      int i4 = 0;
      int i3;
      if (bool)
      {
        i3 = (int)Math.ceil(d() * 2.0F);
        i4 = (int)Math.ceil(c() * 2.0F);
      }
      else
      {
        i3 = 0;
      }
      int i1;
      if (F()) {
        i1 = paramInt1 - this.e - this.f - i4;
      } else {
        i1 = this.e;
      }
      int i2;
      if (E()) {
        i2 = this.e;
      } else {
        i2 = paramInt2 - this.e - this.f - i3;
      }
      if (F()) {
        paramInt1 = this.e;
      } else {
        paramInt1 = paramInt1 - this.e - this.f - i4;
      }
      if (E()) {
        paramInt2 = paramInt2 - this.e - this.f - i3;
      } else {
        paramInt2 = this.e;
      }
      if (x.B(this.a) == 1)
      {
        i3 = i1;
      }
      else
      {
        i3 = paramInt1;
        paramInt1 = i1;
      }
      this.p.setLayerInset(2, paramInt1, paramInt2, i3, i2);
    }
  }
  
  void I(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  void J(ColorStateList paramColorStateList)
  {
    this.c.b0(paramColorStateList);
  }
  
  void K(ColorStateList paramColorStateList)
  {
    h localh = this.d;
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    localh.b0(localColorStateList);
  }
  
  void L(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void M(boolean paramBoolean)
  {
    Drawable localDrawable = this.j;
    if (localDrawable != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 255;
      } else {
        i1 = 0;
      }
      localDrawable.setAlpha(i1);
    }
  }
  
  void N(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable = r0.a.r(paramDrawable).mutate();
      this.j = paramDrawable;
      r0.a.o(paramDrawable, this.l);
      M(this.a.isChecked());
    }
    else
    {
      this.j = v;
    }
    paramDrawable = this.p;
    if (paramDrawable != null) {
      paramDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.j);
    }
  }
  
  void O(int paramInt)
  {
    this.g = paramInt;
    H(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
  }
  
  void P(int paramInt)
  {
    this.e = paramInt;
  }
  
  void Q(int paramInt)
  {
    this.f = paramInt;
  }
  
  void R(ColorStateList paramColorStateList)
  {
    this.l = paramColorStateList;
    Drawable localDrawable = this.j;
    if (localDrawable != null) {
      r0.a.o(localDrawable, paramColorStateList);
    }
  }
  
  void S(float paramFloat)
  {
    V(this.m.w(paramFloat));
    this.i.invalidateSelf();
    if ((a0()) || (Z())) {
      c0();
    }
    if (a0()) {
      f0();
    }
  }
  
  void T(float paramFloat)
  {
    this.c.c0(paramFloat);
    h localh = this.d;
    if (localh != null) {
      localh.c0(paramFloat);
    }
    localh = this.r;
    if (localh != null) {
      localh.c0(paramFloat);
    }
  }
  
  void U(ColorStateList paramColorStateList)
  {
    this.k = paramColorStateList;
    g0();
  }
  
  void V(m paramm)
  {
    this.m = paramm;
    this.c.setShapeAppearanceModel(paramm);
    h localh = this.c;
    localh.g0(localh.T() ^ true);
    localh = this.d;
    if (localh != null) {
      localh.setShapeAppearanceModel(paramm);
    }
    localh = this.r;
    if (localh != null) {
      localh.setShapeAppearanceModel(paramm);
    }
    localh = this.q;
    if (localh != null) {
      localh.setShapeAppearanceModel(paramm);
    }
  }
  
  void W(ColorStateList paramColorStateList)
  {
    if (this.n == paramColorStateList) {
      return;
    }
    this.n = paramColorStateList;
    h0();
  }
  
  void X(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    this.h = paramInt;
    h0();
  }
  
  void Y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.set(paramInt1, paramInt2, paramInt3, paramInt4);
    c0();
  }
  
  void b0()
  {
    Drawable localDrawable = this.i;
    Object localObject;
    if (this.a.isClickable()) {
      localObject = r();
    } else {
      localObject = this.d;
    }
    this.i = ((Drawable)localObject);
    if (localDrawable != localObject) {
      e0((Drawable)localObject);
    }
  }
  
  void c0()
  {
    if ((!Z()) && (!a0())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    float f1;
    if (i1 != 0) {
      f1 = a();
    } else {
      f1 = 0.0F;
    }
    int i1 = (int)(f1 - t());
    MaterialCardView localMaterialCardView = this.a;
    Rect localRect = this.b;
    localMaterialCardView.l(localRect.left + i1, localRect.top + i1, localRect.right + i1, localRect.bottom + i1);
  }
  
  void d0()
  {
    this.c.a0(this.a.getCardElevation());
  }
  
  void f0()
  {
    if (!C()) {
      this.a.setBackgroundInternal(B(this.c));
    }
    this.a.setForeground(B(this.i));
  }
  
  void h0()
  {
    this.d.k0(this.h, this.n);
  }
  
  void i()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).getBounds();
      int i1 = ((Rect)localObject).bottom;
      this.o.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i1 - 1);
      this.o.setBounds(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, i1);
    }
  }
  
  h j()
  {
    return this.c;
  }
  
  ColorStateList k()
  {
    return this.c.x();
  }
  
  ColorStateList l()
  {
    return this.d.x();
  }
  
  Drawable m()
  {
    return this.j;
  }
  
  int n()
  {
    return this.g;
  }
  
  int o()
  {
    return this.e;
  }
  
  int p()
  {
    return this.f;
  }
  
  ColorStateList q()
  {
    return this.l;
  }
  
  float s()
  {
    return this.c.J();
  }
  
  float u()
  {
    return this.c.y();
  }
  
  ColorStateList v()
  {
    return this.k;
  }
  
  m w()
  {
    return this.m;
  }
  
  int x()
  {
    ColorStateList localColorStateList = this.n;
    if (localColorStateList == null) {
      return -1;
    }
    return localColorStateList.getDefaultColor();
  }
  
  ColorStateList y()
  {
    return this.n;
  }
  
  int z()
  {
    return this.h;
  }
  
  class a
    extends InsetDrawable
  {
    a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public int getMinimumHeight()
    {
      return -1;
    }
    
    public int getMinimumWidth()
    {
      return -1;
    }
    
    public boolean getPadding(Rect paramRect)
    {
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.card.a
 * JD-Core Version:    0.7.0.1
 */