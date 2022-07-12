package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.Button;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.t;
import o7.c;
import p7.b;
import r7.h;
import r7.m;
import r7.p;

class a
{
  private static final boolean t = true;
  private static final boolean u = false;
  private final MaterialButton a;
  private m b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private PorterDuff.Mode i;
  private ColorStateList j;
  private ColorStateList k;
  private ColorStateList l;
  private Drawable m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q;
  private LayerDrawable r;
  private int s;
  
  a(MaterialButton paramMaterialButton, m paramm)
  {
    this.a = paramMaterialButton;
    this.b = paramm;
  }
  
  private void E(int paramInt1, int paramInt2)
  {
    int i1 = x.G(this.a);
    int i2 = this.a.getPaddingTop();
    int i3 = x.F(this.a);
    int i4 = this.a.getPaddingBottom();
    int i5 = this.e;
    int i6 = this.f;
    this.f = paramInt2;
    this.e = paramInt1;
    if (!this.o) {
      F();
    }
    x.F0(this.a, i1, i2 + paramInt1 - i5, i3, i4 + paramInt2 - i6);
  }
  
  private void F()
  {
    this.a.setInternalBackground(a());
    h localh = f();
    if (localh != null) {
      localh.a0(this.s);
    }
  }
  
  private void G(m paramm)
  {
    if ((u) && (!this.o))
    {
      int i1 = x.G(this.a);
      int i2 = this.a.getPaddingTop();
      int i3 = x.F(this.a);
      int i4 = this.a.getPaddingBottom();
      F();
      x.F0(this.a, i1, i2, i3, i4);
      return;
    }
    if (f() != null) {
      f().setShapeAppearanceModel(paramm);
    }
    if (n() != null) {
      n().setShapeAppearanceModel(paramm);
    }
    if (e() != null) {
      e().setShapeAppearanceModel(paramm);
    }
  }
  
  private void H()
  {
    h localh1 = f();
    h localh2 = n();
    if (localh1 != null)
    {
      localh1.k0(this.h, this.k);
      if (localh2 != null)
      {
        float f1 = this.h;
        int i1;
        if (this.n) {
          i1 = g7.a.d(this.a, R.attr.colorSurface);
        } else {
          i1 = 0;
        }
        localh2.j0(f1, i1);
      }
    }
  }
  
  private InsetDrawable I(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.c, this.e, this.d, this.f);
  }
  
  private Drawable a()
  {
    Object localObject1 = new h(this.b);
    ((h)localObject1).Q(this.a.getContext());
    r0.a.o((Drawable)localObject1, this.j);
    Object localObject2 = this.i;
    if (localObject2 != null) {
      r0.a.p((Drawable)localObject1, (PorterDuff.Mode)localObject2);
    }
    ((h)localObject1).k0(this.h, this.k);
    localObject2 = new h(this.b);
    ((h)localObject2).setTint(0);
    float f1 = this.h;
    int i1;
    if (this.n) {
      i1 = g7.a.d(this.a, R.attr.colorSurface);
    } else {
      i1 = 0;
    }
    ((h)localObject2).j0(f1, i1);
    if (t)
    {
      localObject3 = new h(this.b);
      this.m = ((Drawable)localObject3);
      r0.a.n((Drawable)localObject3, -1);
      localObject1 = new RippleDrawable(b.d(this.l), I(new LayerDrawable(new Drawable[] { localObject2, localObject1 })), this.m);
      this.r = ((LayerDrawable)localObject1);
      return localObject1;
    }
    Object localObject3 = new p7.a(this.b);
    this.m = ((Drawable)localObject3);
    r0.a.o((Drawable)localObject3, b.d(this.l));
    localObject1 = new LayerDrawable(new Drawable[] { localObject2, localObject1, this.m });
    this.r = ((LayerDrawable)localObject1);
    return I((Drawable)localObject1);
  }
  
  private h g(boolean paramBoolean)
  {
    LayerDrawable localLayerDrawable = this.r;
    if ((localLayerDrawable != null) && (localLayerDrawable.getNumberOfLayers() > 0))
    {
      if (t) {}
      for (localLayerDrawable = (LayerDrawable)((InsetDrawable)this.r.getDrawable(0)).getDrawable();; localLayerDrawable = this.r) {
        return (h)localLayerDrawable.getDrawable(paramBoolean ^ true);
      }
    }
    return null;
  }
  
  private h n()
  {
    return g(true);
  }
  
  void A(ColorStateList paramColorStateList)
  {
    if (this.k != paramColorStateList)
    {
      this.k = paramColorStateList;
      H();
    }
  }
  
  void B(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      H();
    }
  }
  
  void C(ColorStateList paramColorStateList)
  {
    if (this.j != paramColorStateList)
    {
      this.j = paramColorStateList;
      if (f() != null) {
        r0.a.o(f(), this.j);
      }
    }
  }
  
  void D(PorterDuff.Mode paramMode)
  {
    if (this.i != paramMode)
    {
      this.i = paramMode;
      if ((f() != null) && (this.i != null)) {
        r0.a.p(f(), this.i);
      }
    }
  }
  
  int b()
  {
    return this.g;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public p e()
  {
    Object localObject = this.r;
    if ((localObject != null) && (((LayerDrawable)localObject).getNumberOfLayers() > 1))
    {
      if (this.r.getNumberOfLayers() > 2) {}
      for (localObject = this.r.getDrawable(2);; localObject = this.r.getDrawable(1)) {
        return (p)localObject;
      }
    }
    return null;
  }
  
  h f()
  {
    return g(false);
  }
  
  ColorStateList h()
  {
    return this.l;
  }
  
  m i()
  {
    return this.b;
  }
  
  ColorStateList j()
  {
    return this.k;
  }
  
  int k()
  {
    return this.h;
  }
  
  ColorStateList l()
  {
    return this.j;
  }
  
  PorterDuff.Mode m()
  {
    return this.i;
  }
  
  boolean o()
  {
    return this.o;
  }
  
  boolean p()
  {
    return this.q;
  }
  
  void q(TypedArray paramTypedArray)
  {
    this.c = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
    this.d = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    this.e = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    this.f = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    int i1 = R.styleable.MaterialButton_cornerRadius;
    if (paramTypedArray.hasValue(i1))
    {
      i1 = paramTypedArray.getDimensionPixelSize(i1, -1);
      this.g = i1;
      y(this.b.w(i1));
      this.p = true;
    }
    this.h = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    this.i = t.j(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.j = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    this.k = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    this.l = c.a(this.a.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    this.q = paramTypedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
    this.s = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
    i1 = x.G(this.a);
    int i2 = this.a.getPaddingTop();
    int i3 = x.F(this.a);
    int i4 = this.a.getPaddingBottom();
    if (paramTypedArray.hasValue(R.styleable.MaterialButton_android_background)) {
      s();
    } else {
      F();
    }
    x.F0(this.a, i1 + this.c, i2 + this.e, i3 + this.d, i4 + this.f);
  }
  
  void r(int paramInt)
  {
    if (f() != null) {
      f().setTint(paramInt);
    }
  }
  
  void s()
  {
    this.o = true;
    this.a.setSupportBackgroundTintList(this.j);
    this.a.setSupportBackgroundTintMode(this.i);
  }
  
  void t(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  void u(int paramInt)
  {
    if ((!this.p) || (this.g != paramInt))
    {
      this.g = paramInt;
      this.p = true;
      y(this.b.w(paramInt));
    }
  }
  
  public void v(int paramInt)
  {
    E(this.e, paramInt);
  }
  
  public void w(int paramInt)
  {
    E(paramInt, this.f);
  }
  
  void x(ColorStateList paramColorStateList)
  {
    if (this.l != paramColorStateList)
    {
      this.l = paramColorStateList;
      boolean bool = t;
      if ((bool) && ((this.a.getBackground() instanceof RippleDrawable)))
      {
        ((RippleDrawable)this.a.getBackground()).setColor(b.d(paramColorStateList));
        return;
      }
      if ((!bool) && ((this.a.getBackground() instanceof p7.a))) {
        ((p7.a)this.a.getBackground()).setTintList(b.d(paramColorStateList));
      }
    }
  }
  
  void y(m paramm)
  {
    this.b = paramm;
    G(paramm);
  }
  
  void z(boolean paramBoolean)
  {
    this.n = paramBoolean;
    H();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.button.a
 * JD-Core Version:    0.7.0.1
 */