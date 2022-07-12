package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.m.b;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import o7.c;
import o7.d;
import p7.b;

public class a
  extends r7.h
  implements Drawable.Callback, m.b
{
  private static final int[] K0 = { 16842910 };
  private static final ShapeDrawable L0 = new ShapeDrawable(new OvalShape());
  private ColorStateList A;
  private ColorStateList A0;
  private float B;
  private PorterDuff.Mode B0 = PorterDuff.Mode.SRC_IN;
  private float C = -1.0F;
  private int[] C0;
  private boolean D0;
  private ColorStateList E;
  private ColorStateList E0;
  private float F;
  private WeakReference<a> F0 = new WeakReference(null);
  private ColorStateList G;
  private TextUtils.TruncateAt G0;
  private CharSequence H;
  private boolean H0;
  private boolean I;
  private int I0;
  private Drawable J;
  private boolean J0;
  private ColorStateList K;
  private float L;
  private boolean M;
  private boolean N;
  private Drawable O;
  private Drawable P;
  private ColorStateList Q;
  private float R;
  private CharSequence S;
  private boolean T;
  private boolean U;
  private Drawable V;
  private ColorStateList W;
  private e7.h X;
  private e7.h Y;
  private float Z;
  private float a0;
  private float b0;
  private float c0;
  private float d0;
  private float e0;
  private float f0;
  private float g0;
  private final Context h0;
  private final Paint i0 = new Paint(1);
  private final Paint j0;
  private final Paint.FontMetrics k0 = new Paint.FontMetrics();
  private final RectF l0 = new RectF();
  private final PointF m0 = new PointF();
  private final Path n0 = new Path();
  private final com.google.android.material.internal.m o0;
  private int p0;
  private int q0;
  private int r0;
  private int s0;
  private int t0;
  private int u0;
  private boolean v0;
  private int w0;
  private int x0 = 255;
  private ColorFilter y0;
  private ColorStateList z;
  private PorterDuffColorFilter z0;
  
  private a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    Q(paramContext);
    this.h0 = paramContext;
    paramAttributeSet = new com.google.android.material.internal.m(this);
    this.o0 = paramAttributeSet;
    this.H = "";
    paramAttributeSet.e().density = paramContext.getResources().getDisplayMetrics().density;
    this.j0 = null;
    paramContext = K0;
    setState(paramContext);
    r2(paramContext);
    this.H0 = true;
    if (b.a) {
      L0.setTint(-1);
    }
  }
  
  private boolean A0()
  {
    return (this.U) && (this.V != null) && (this.T);
  }
  
  private void A1(AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = p.h(this.h0, paramAttributeSet, R.styleable.Chip, paramInt1, paramInt2, new int[0]);
    this.J0 = localTypedArray.hasValue(R.styleable.Chip_shapeAppearance);
    h2(c.a(this.h0, localTypedArray, R.styleable.Chip_chipSurfaceColor));
    L1(c.a(this.h0, localTypedArray, R.styleable.Chip_chipBackgroundColor));
    Z1(localTypedArray.getDimension(R.styleable.Chip_chipMinHeight, 0.0F));
    paramInt1 = R.styleable.Chip_chipCornerRadius;
    if (localTypedArray.hasValue(paramInt1)) {
      N1(localTypedArray.getDimension(paramInt1, 0.0F));
    }
    d2(c.a(this.h0, localTypedArray, R.styleable.Chip_chipStrokeColor));
    f2(localTypedArray.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0F));
    E2(c.a(this.h0, localTypedArray, R.styleable.Chip_rippleColor));
    J2(localTypedArray.getText(R.styleable.Chip_android_text));
    Object localObject = c.g(this.h0, localTypedArray, R.styleable.Chip_android_textAppearance);
    ((d)localObject).l(localTypedArray.getDimension(R.styleable.Chip_android_textSize, ((d)localObject).j()));
    K2((d)localObject);
    paramInt1 = localTypedArray.getInt(R.styleable.Chip_android_ellipsize, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          break label249;
        }
        localObject = TextUtils.TruncateAt.END;
      }
      else
      {
        localObject = TextUtils.TruncateAt.MIDDLE;
      }
    }
    else {
      localObject = TextUtils.TruncateAt.START;
    }
    w2((TextUtils.TruncateAt)localObject);
    label249:
    Y1(localTypedArray.getBoolean(R.styleable.Chip_chipIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null)) {
      Y1(localTypedArray.getBoolean(R.styleable.Chip_chipIconEnabled, false));
    }
    R1(c.e(this.h0, localTypedArray, R.styleable.Chip_chipIcon));
    paramInt1 = R.styleable.Chip_chipIconTint;
    if (localTypedArray.hasValue(paramInt1)) {
      V1(c.a(this.h0, localTypedArray, paramInt1));
    }
    T1(localTypedArray.getDimension(R.styleable.Chip_chipIconSize, -1.0F));
    u2(localTypedArray.getBoolean(R.styleable.Chip_closeIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null)) {
      u2(localTypedArray.getBoolean(R.styleable.Chip_closeIconEnabled, false));
    }
    i2(c.e(this.h0, localTypedArray, R.styleable.Chip_closeIcon));
    s2(c.a(this.h0, localTypedArray, R.styleable.Chip_closeIconTint));
    n2(localTypedArray.getDimension(R.styleable.Chip_closeIconSize, 0.0F));
    D1(localTypedArray.getBoolean(R.styleable.Chip_android_checkable, false));
    K1(localTypedArray.getBoolean(R.styleable.Chip_checkedIconVisible, false));
    if ((paramAttributeSet != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null) && (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null)) {
      K1(localTypedArray.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
    }
    F1(c.e(this.h0, localTypedArray, R.styleable.Chip_checkedIcon));
    paramInt1 = R.styleable.Chip_checkedIconTint;
    if (localTypedArray.hasValue(paramInt1)) {
      H1(c.a(this.h0, localTypedArray, paramInt1));
    }
    H2(e7.h.c(this.h0, localTypedArray, R.styleable.Chip_showMotionSpec));
    x2(e7.h.c(this.h0, localTypedArray, R.styleable.Chip_hideMotionSpec));
    b2(localTypedArray.getDimension(R.styleable.Chip_chipStartPadding, 0.0F));
    B2(localTypedArray.getDimension(R.styleable.Chip_iconStartPadding, 0.0F));
    z2(localTypedArray.getDimension(R.styleable.Chip_iconEndPadding, 0.0F));
    O2(localTypedArray.getDimension(R.styleable.Chip_textStartPadding, 0.0F));
    M2(localTypedArray.getDimension(R.styleable.Chip_textEndPadding, 0.0F));
    p2(localTypedArray.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0F));
    k2(localTypedArray.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0F));
    P1(localTypedArray.getDimension(R.styleable.Chip_chipEndPadding, 0.0F));
    D2(localTypedArray.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, 2147483647));
    localTypedArray.recycle();
  }
  
  public static a B0(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = new a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramContext.A1(paramAttributeSet, paramInt1, paramInt2);
    return paramContext;
  }
  
  private void C0(Canvas paramCanvas, Rect paramRect)
  {
    if (S2())
    {
      r0(paramRect, this.l0);
      paramRect = this.l0;
      float f1 = paramRect.left;
      float f2 = paramRect.top;
      paramCanvas.translate(f1, f2);
      this.V.setBounds(0, 0, (int)this.l0.width(), (int)this.l0.height());
      this.V.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private boolean C1(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool1 = super.onStateChange(paramArrayOfInt1);
    Object localObject = this.z;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.p0);
    } else {
      i = 0;
    }
    int j = l(i);
    int i = this.p0;
    boolean bool3 = true;
    if (i != j)
    {
      this.p0 = j;
      bool1 = true;
    }
    localObject = this.A;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.q0);
    } else {
      i = 0;
    }
    i = l(i);
    if (this.q0 != i)
    {
      this.q0 = i;
      bool1 = true;
    }
    int k = g7.a.g(j, i);
    if (this.r0 != k) {
      i = 1;
    } else {
      i = 0;
    }
    if (x() == null) {
      j = 1;
    } else {
      j = 0;
    }
    if ((i | j) != 0)
    {
      this.r0 = k;
      b0(ColorStateList.valueOf(k));
      bool1 = true;
    }
    localObject = this.E;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.s0);
    } else {
      i = 0;
    }
    if (this.s0 != i)
    {
      this.s0 = i;
      bool1 = true;
    }
    if ((this.E0 != null) && (b.e(paramArrayOfInt1))) {
      i = this.E0.getColorForState(paramArrayOfInt1, this.t0);
    } else {
      i = 0;
    }
    boolean bool2 = bool1;
    if (this.t0 != i)
    {
      this.t0 = i;
      bool2 = bool1;
      if (this.D0) {
        bool2 = true;
      }
    }
    if ((this.o0.d() != null) && (this.o0.d().i() != null)) {
      i = this.o0.d().i().getColorForState(paramArrayOfInt1, this.u0);
    } else {
      i = 0;
    }
    bool1 = bool2;
    if (this.u0 != i)
    {
      this.u0 = i;
      bool1 = true;
    }
    if ((t1(getState(), 16842912)) && (this.T)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((this.v0 != bool2) && (this.V != null))
    {
      float f = s0();
      this.v0 = bool2;
      if (f != s0())
      {
        bool1 = true;
        bool2 = bool1;
      }
      else
      {
        bool2 = false;
        bool1 = true;
      }
    }
    else
    {
      bool2 = false;
    }
    localObject = this.A0;
    if (localObject != null) {
      i = ((ColorStateList)localObject).getColorForState(paramArrayOfInt1, this.w0);
    } else {
      i = 0;
    }
    if (this.w0 != i)
    {
      this.w0 = i;
      this.z0 = i7.a.c(this, this.A0, this.B0);
    }
    else
    {
      bool3 = bool1;
    }
    bool1 = bool3;
    if (y1(this.J)) {
      bool1 = bool3 | this.J.setState(paramArrayOfInt1);
    }
    bool3 = bool1;
    if (y1(this.V)) {
      bool3 = bool1 | this.V.setState(paramArrayOfInt1);
    }
    bool1 = bool3;
    if (y1(this.O))
    {
      localObject = new int[paramArrayOfInt1.length + paramArrayOfInt2.length];
      System.arraycopy(paramArrayOfInt1, 0, localObject, 0, paramArrayOfInt1.length);
      System.arraycopy(paramArrayOfInt2, 0, localObject, paramArrayOfInt1.length, paramArrayOfInt2.length);
      bool1 = bool3 | this.O.setState((int[])localObject);
    }
    bool3 = bool1;
    if (b.a)
    {
      bool3 = bool1;
      if (y1(this.P)) {
        bool3 = bool1 | this.P.setState(paramArrayOfInt2);
      }
    }
    if (bool3) {
      invalidateSelf();
    }
    if (bool2) {
      B1();
    }
    return bool3;
  }
  
  private void D0(Canvas paramCanvas, Rect paramRect)
  {
    if (!this.J0)
    {
      this.i0.setColor(this.q0);
      this.i0.setStyle(Paint.Style.FILL);
      this.i0.setColorFilter(r1());
      this.l0.set(paramRect);
      paramCanvas.drawRoundRect(this.l0, O0(), O0(), this.i0);
    }
  }
  
  private void E0(Canvas paramCanvas, Rect paramRect)
  {
    if (T2())
    {
      r0(paramRect, this.l0);
      paramRect = this.l0;
      float f1 = paramRect.left;
      float f2 = paramRect.top;
      paramCanvas.translate(f1, f2);
      this.J.setBounds(0, 0, (int)this.l0.width(), (int)this.l0.height());
      this.J.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void F0(Canvas paramCanvas, Rect paramRect)
  {
    if ((this.F > 0.0F) && (!this.J0))
    {
      this.i0.setColor(this.s0);
      this.i0.setStyle(Paint.Style.STROKE);
      if (!this.J0) {
        this.i0.setColorFilter(r1());
      }
      RectF localRectF = this.l0;
      float f1 = paramRect.left;
      float f2 = this.F;
      localRectF.set(f1 + f2 / 2.0F, paramRect.top + f2 / 2.0F, paramRect.right - f2 / 2.0F, paramRect.bottom - f2 / 2.0F);
      f1 = this.C - this.F / 2.0F;
      paramCanvas.drawRoundRect(this.l0, f1, f1, this.i0);
    }
  }
  
  private void G0(Canvas paramCanvas, Rect paramRect)
  {
    if (!this.J0)
    {
      this.i0.setColor(this.p0);
      this.i0.setStyle(Paint.Style.FILL);
      this.l0.set(paramRect);
      paramCanvas.drawRoundRect(this.l0, O0(), O0(), this.i0);
    }
  }
  
  private void H0(Canvas paramCanvas, Rect paramRect)
  {
    if (U2())
    {
      u0(paramRect, this.l0);
      paramRect = this.l0;
      float f1 = paramRect.left;
      float f2 = paramRect.top;
      paramCanvas.translate(f1, f2);
      this.O.setBounds(0, 0, (int)this.l0.width(), (int)this.l0.height());
      if (b.a)
      {
        this.P.setBounds(this.O.getBounds());
        this.P.jumpToCurrentState();
        paramRect = this.P;
      }
      else
      {
        paramRect = this.O;
      }
      paramRect.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void I0(Canvas paramCanvas, Rect paramRect)
  {
    this.i0.setColor(this.t0);
    this.i0.setStyle(Paint.Style.FILL);
    this.l0.set(paramRect);
    if (!this.J0)
    {
      paramCanvas.drawRoundRect(this.l0, O0(), O0(), this.i0);
      return;
    }
    h(new RectF(paramRect), this.n0);
    super.p(paramCanvas, this.i0, this.n0, u());
  }
  
  private void J0(Canvas paramCanvas, Rect paramRect)
  {
    Paint localPaint = this.j0;
    if (localPaint != null)
    {
      localPaint.setColor(q0.a.o(-16777216, 127));
      paramCanvas.drawRect(paramRect, this.j0);
      if ((T2()) || (S2()))
      {
        r0(paramRect, this.l0);
        paramCanvas.drawRect(this.l0, this.j0);
      }
      if (this.H != null) {
        paramCanvas.drawLine(paramRect.left, paramRect.exactCenterY(), paramRect.right, paramRect.exactCenterY(), this.j0);
      }
      if (U2())
      {
        u0(paramRect, this.l0);
        paramCanvas.drawRect(this.l0, this.j0);
      }
      this.j0.setColor(q0.a.o(-65536, 127));
      t0(paramRect, this.l0);
      paramCanvas.drawRect(this.l0, this.j0);
      this.j0.setColor(q0.a.o(-16711936, 127));
      v0(paramRect, this.l0);
      paramCanvas.drawRect(this.l0, this.j0);
    }
  }
  
  private void K0(Canvas paramCanvas, Rect paramRect)
  {
    if (this.H != null)
    {
      Object localObject = z0(paramRect, this.m0);
      x0(paramRect, this.l0);
      if (this.o0.d() != null)
      {
        this.o0.e().drawableState = getState();
        this.o0.j(this.h0);
      }
      this.o0.e().setTextAlign((Paint.Align)localObject);
      int i = Math.round(this.o0.f(n1().toString()));
      int k = Math.round(this.l0.width());
      int j = 0;
      if (i > k) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        j = paramCanvas.save();
        paramCanvas.clipRect(this.l0);
      }
      localObject = this.H;
      paramRect = (Rect)localObject;
      if (i != 0)
      {
        paramRect = (Rect)localObject;
        if (this.G0 != null) {
          paramRect = TextUtils.ellipsize((CharSequence)localObject, this.o0.e(), this.l0.width(), this.G0);
        }
      }
      k = paramRect.length();
      localObject = this.m0;
      paramCanvas.drawText(paramRect, 0, k, ((PointF)localObject).x, ((PointF)localObject).y, this.o0.e());
      if (i != 0) {
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  private boolean S2()
  {
    return (this.U) && (this.V != null) && (this.v0);
  }
  
  private boolean T2()
  {
    return (this.I) && (this.J != null);
  }
  
  private boolean U2()
  {
    return (this.N) && (this.O != null);
  }
  
  private void V2(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void W2()
  {
    ColorStateList localColorStateList;
    if (this.D0) {
      localColorStateList = b.d(this.G);
    } else {
      localColorStateList = null;
    }
    this.E0 = localColorStateList;
  }
  
  @TargetApi(21)
  private void X2()
  {
    this.P = new RippleDrawable(b.d(l1()), this.O, L0);
  }
  
  private float f1()
  {
    Drawable localDrawable;
    if (this.v0) {
      localDrawable = this.V;
    } else {
      localDrawable = this.J;
    }
    float f2 = this.L;
    float f1 = f2;
    if (f2 <= 0.0F)
    {
      f1 = f2;
      if (localDrawable != null)
      {
        f2 = (float)Math.ceil(t.c(this.h0, 24));
        f1 = f2;
        if (localDrawable.getIntrinsicHeight() <= f2) {
          return localDrawable.getIntrinsicHeight();
        }
      }
    }
    return f1;
  }
  
  private float g1()
  {
    Drawable localDrawable;
    if (this.v0) {
      localDrawable = this.V;
    } else {
      localDrawable = this.J;
    }
    float f = this.L;
    if ((f <= 0.0F) && (localDrawable != null)) {
      return localDrawable.getIntrinsicWidth();
    }
    return f;
  }
  
  private void h2(ColorStateList paramColorStateList)
  {
    if (this.z != paramColorStateList)
    {
      this.z = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  private void q0(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.setCallback(this);
    r0.a.m(paramDrawable, r0.a.f(this));
    paramDrawable.setLevel(getLevel());
    paramDrawable.setVisible(isVisible(), false);
    if (paramDrawable == this.O)
    {
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(c1());
      }
      r0.a.o(paramDrawable, this.Q);
      return;
    }
    Drawable localDrawable = this.J;
    if ((paramDrawable == localDrawable) && (this.M)) {
      r0.a.o(localDrawable, this.K);
    }
    if (paramDrawable.isStateful()) {
      paramDrawable.setState(getState());
    }
  }
  
  private void r0(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if ((T2()) || (S2()))
    {
      float f2 = this.Z + this.a0;
      float f1 = g1();
      if (r0.a.f(this) == 0)
      {
        f2 = paramRect.left + f2;
        paramRectF.left = f2;
        paramRectF.right = (f2 + f1);
      }
      else
      {
        f2 = paramRect.right - f2;
        paramRectF.right = f2;
        paramRectF.left = (f2 - f1);
      }
      f1 = f1();
      f2 = paramRect.exactCenterY() - f1 / 2.0F;
      paramRectF.top = f2;
      paramRectF.bottom = (f2 + f1);
    }
  }
  
  private ColorFilter r1()
  {
    ColorFilter localColorFilter = this.y0;
    if (localColorFilter != null) {
      return localColorFilter;
    }
    return this.z0;
  }
  
  private void t0(Rect paramRect, RectF paramRectF)
  {
    paramRectF.set(paramRect);
    if (U2())
    {
      float f = this.g0 + this.f0 + this.R + this.e0 + this.d0;
      if (r0.a.f(this) == 0)
      {
        paramRectF.right = (paramRect.right - f);
        return;
      }
      paramRectF.left = (paramRect.left + f);
    }
  }
  
  private static boolean t1(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void u0(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (U2())
    {
      float f1 = this.g0 + this.f0;
      if (r0.a.f(this) == 0)
      {
        f1 = paramRect.right - f1;
        paramRectF.right = f1;
        paramRectF.left = (f1 - this.R);
      }
      else
      {
        f1 = paramRect.left + f1;
        paramRectF.left = f1;
        paramRectF.right = (f1 + this.R);
      }
      float f2 = paramRect.exactCenterY();
      f1 = this.R;
      f2 -= f1 / 2.0F;
      paramRectF.top = f2;
      paramRectF.bottom = (f2 + f1);
    }
  }
  
  private void v0(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (U2())
    {
      float f1 = this.g0 + this.f0 + this.R + this.e0 + this.d0;
      if (r0.a.f(this) == 0)
      {
        float f2 = paramRect.right;
        paramRectF.right = f2;
        paramRectF.left = (f2 - f1);
      }
      else
      {
        int i = paramRect.left;
        paramRectF.left = i;
        paramRectF.right = (i + f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private void x0(Rect paramRect, RectF paramRectF)
  {
    paramRectF.setEmpty();
    if (this.H != null)
    {
      float f1 = this.Z + s0() + this.c0;
      float f2 = this.g0 + w0() + this.d0;
      if (r0.a.f(this) == 0)
      {
        paramRectF.left = (paramRect.left + f1);
        paramRectF.right = (paramRect.right - f2);
      }
      else
      {
        paramRectF.left = (paramRect.left + f2);
        paramRectF.right = (paramRect.right - f1);
      }
      paramRectF.top = paramRect.top;
      paramRectF.bottom = paramRect.bottom;
    }
  }
  
  private static boolean x1(ColorStateList paramColorStateList)
  {
    return (paramColorStateList != null) && (paramColorStateList.isStateful());
  }
  
  private float y0()
  {
    this.o0.e().getFontMetrics(this.k0);
    Paint.FontMetrics localFontMetrics = this.k0;
    return (localFontMetrics.descent + localFontMetrics.ascent) / 2.0F;
  }
  
  private static boolean y1(Drawable paramDrawable)
  {
    return (paramDrawable != null) && (paramDrawable.isStateful());
  }
  
  private static boolean z1(d paramd)
  {
    return (paramd != null) && (paramd.i() != null) && (paramd.i().isStateful());
  }
  
  public void A2(int paramInt)
  {
    z2(this.h0.getResources().getDimension(paramInt));
  }
  
  protected void B1()
  {
    a locala = (a)this.F0.get();
    if (locala != null) {
      locala.a();
    }
  }
  
  public void B2(float paramFloat)
  {
    if (this.a0 != paramFloat)
    {
      float f = s0();
      this.a0 = paramFloat;
      paramFloat = s0();
      invalidateSelf();
      if (f != paramFloat) {
        B1();
      }
    }
  }
  
  public void C2(int paramInt)
  {
    B2(this.h0.getResources().getDimension(paramInt));
  }
  
  public void D1(boolean paramBoolean)
  {
    if (this.T != paramBoolean)
    {
      this.T = paramBoolean;
      float f1 = s0();
      if ((!paramBoolean) && (this.v0)) {
        this.v0 = false;
      }
      float f2 = s0();
      invalidateSelf();
      if (f1 != f2) {
        B1();
      }
    }
  }
  
  public void D2(int paramInt)
  {
    this.I0 = paramInt;
  }
  
  public void E1(int paramInt)
  {
    D1(this.h0.getResources().getBoolean(paramInt));
  }
  
  public void E2(ColorStateList paramColorStateList)
  {
    if (this.G != paramColorStateList)
    {
      this.G = paramColorStateList;
      W2();
      onStateChange(getState());
    }
  }
  
  public void F1(Drawable paramDrawable)
  {
    if (this.V != paramDrawable)
    {
      float f1 = s0();
      this.V = paramDrawable;
      float f2 = s0();
      V2(this.V);
      q0(this.V);
      invalidateSelf();
      if (f1 != f2) {
        B1();
      }
    }
  }
  
  public void F2(int paramInt)
  {
    E2(c.a.a(this.h0, paramInt));
  }
  
  public void G1(int paramInt)
  {
    F1(c.a.b(this.h0, paramInt));
  }
  
  void G2(boolean paramBoolean)
  {
    this.H0 = paramBoolean;
  }
  
  public void H1(ColorStateList paramColorStateList)
  {
    if (this.W != paramColorStateList)
    {
      this.W = paramColorStateList;
      if (A0()) {
        r0.a.o(this.V, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void H2(e7.h paramh)
  {
    this.X = paramh;
  }
  
  public void I1(int paramInt)
  {
    H1(c.a.a(this.h0, paramInt));
  }
  
  public void I2(int paramInt)
  {
    H2(e7.h.d(this.h0, paramInt));
  }
  
  public void J1(int paramInt)
  {
    K1(this.h0.getResources().getBoolean(paramInt));
  }
  
  public void J2(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!TextUtils.equals(this.H, (CharSequence)localObject))
    {
      this.H = ((CharSequence)localObject);
      this.o0.i(true);
      invalidateSelf();
      B1();
    }
  }
  
  public void K1(boolean paramBoolean)
  {
    if (this.U != paramBoolean)
    {
      boolean bool = S2();
      this.U = paramBoolean;
      paramBoolean = S2();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          q0(this.V);
        } else {
          V2(this.V);
        }
        invalidateSelf();
        B1();
      }
    }
  }
  
  public void K2(d paramd)
  {
    this.o0.h(paramd, this.h0);
  }
  
  public Drawable L0()
  {
    return this.V;
  }
  
  public void L1(ColorStateList paramColorStateList)
  {
    if (this.A != paramColorStateList)
    {
      this.A = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void L2(int paramInt)
  {
    K2(new d(this.h0, paramInt));
  }
  
  public ColorStateList M0()
  {
    return this.W;
  }
  
  public void M1(int paramInt)
  {
    L1(c.a.a(this.h0, paramInt));
  }
  
  public void M2(float paramFloat)
  {
    if (this.d0 != paramFloat)
    {
      this.d0 = paramFloat;
      invalidateSelf();
      B1();
    }
  }
  
  public ColorStateList N0()
  {
    return this.A;
  }
  
  @Deprecated
  public void N1(float paramFloat)
  {
    if (this.C != paramFloat)
    {
      this.C = paramFloat;
      setShapeAppearanceModel(E().w(paramFloat));
    }
  }
  
  public void N2(int paramInt)
  {
    M2(this.h0.getResources().getDimension(paramInt));
  }
  
  public float O0()
  {
    if (this.J0) {
      return J();
    }
    return this.C;
  }
  
  @Deprecated
  public void O1(int paramInt)
  {
    N1(this.h0.getResources().getDimension(paramInt));
  }
  
  public void O2(float paramFloat)
  {
    if (this.c0 != paramFloat)
    {
      this.c0 = paramFloat;
      invalidateSelf();
      B1();
    }
  }
  
  public float P0()
  {
    return this.g0;
  }
  
  public void P1(float paramFloat)
  {
    if (this.g0 != paramFloat)
    {
      this.g0 = paramFloat;
      invalidateSelf();
      B1();
    }
  }
  
  public void P2(int paramInt)
  {
    O2(this.h0.getResources().getDimension(paramInt));
  }
  
  public Drawable Q0()
  {
    Drawable localDrawable = this.J;
    if (localDrawable != null) {
      return r0.a.q(localDrawable);
    }
    return null;
  }
  
  public void Q1(int paramInt)
  {
    P1(this.h0.getResources().getDimension(paramInt));
  }
  
  public void Q2(boolean paramBoolean)
  {
    if (this.D0 != paramBoolean)
    {
      this.D0 = paramBoolean;
      W2();
      onStateChange(getState());
    }
  }
  
  public float R0()
  {
    return this.L;
  }
  
  public void R1(Drawable paramDrawable)
  {
    Drawable localDrawable = Q0();
    if (localDrawable != paramDrawable)
    {
      float f1 = s0();
      if (paramDrawable != null) {
        paramDrawable = r0.a.r(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.J = paramDrawable;
      float f2 = s0();
      V2(localDrawable);
      if (T2()) {
        q0(this.J);
      }
      invalidateSelf();
      if (f1 != f2) {
        B1();
      }
    }
  }
  
  boolean R2()
  {
    return this.H0;
  }
  
  public ColorStateList S0()
  {
    return this.K;
  }
  
  public void S1(int paramInt)
  {
    R1(c.a.b(this.h0, paramInt));
  }
  
  public float T0()
  {
    return this.B;
  }
  
  public void T1(float paramFloat)
  {
    if (this.L != paramFloat)
    {
      float f = s0();
      this.L = paramFloat;
      paramFloat = s0();
      invalidateSelf();
      if (f != paramFloat) {
        B1();
      }
    }
  }
  
  public float U0()
  {
    return this.Z;
  }
  
  public void U1(int paramInt)
  {
    T1(this.h0.getResources().getDimension(paramInt));
  }
  
  public ColorStateList V0()
  {
    return this.E;
  }
  
  public void V1(ColorStateList paramColorStateList)
  {
    this.M = true;
    if (this.K != paramColorStateList)
    {
      this.K = paramColorStateList;
      if (T2()) {
        r0.a.o(this.J, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public float W0()
  {
    return this.F;
  }
  
  public void W1(int paramInt)
  {
    V1(c.a.a(this.h0, paramInt));
  }
  
  public Drawable X0()
  {
    Drawable localDrawable = this.O;
    if (localDrawable != null) {
      return r0.a.q(localDrawable);
    }
    return null;
  }
  
  public void X1(int paramInt)
  {
    Y1(this.h0.getResources().getBoolean(paramInt));
  }
  
  public CharSequence Y0()
  {
    return this.S;
  }
  
  public void Y1(boolean paramBoolean)
  {
    if (this.I != paramBoolean)
    {
      boolean bool = T2();
      this.I = paramBoolean;
      paramBoolean = T2();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          q0(this.J);
        } else {
          V2(this.J);
        }
        invalidateSelf();
        B1();
      }
    }
  }
  
  public float Z0()
  {
    return this.f0;
  }
  
  public void Z1(float paramFloat)
  {
    if (this.B != paramFloat)
    {
      this.B = paramFloat;
      invalidateSelf();
      B1();
    }
  }
  
  public void a()
  {
    B1();
    invalidateSelf();
  }
  
  public float a1()
  {
    return this.R;
  }
  
  public void a2(int paramInt)
  {
    Z1(this.h0.getResources().getDimension(paramInt));
  }
  
  public float b1()
  {
    return this.e0;
  }
  
  public void b2(float paramFloat)
  {
    if (this.Z != paramFloat)
    {
      this.Z = paramFloat;
      invalidateSelf();
      B1();
    }
  }
  
  public int[] c1()
  {
    return this.C0;
  }
  
  public void c2(int paramInt)
  {
    b2(this.h0.getResources().getDimension(paramInt));
  }
  
  public ColorStateList d1()
  {
    return this.Q;
  }
  
  public void d2(ColorStateList paramColorStateList)
  {
    if (this.E != paramColorStateList)
    {
      this.E = paramColorStateList;
      if (this.J0) {
        l0(paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if (!localRect.isEmpty())
    {
      if (getAlpha() == 0) {
        return;
      }
      int i = 0;
      int j = this.x0;
      if (j < 255) {
        i = f7.a.a(paramCanvas, localRect.left, localRect.top, localRect.right, localRect.bottom, j);
      }
      G0(paramCanvas, localRect);
      D0(paramCanvas, localRect);
      if (this.J0) {
        super.draw(paramCanvas);
      }
      F0(paramCanvas, localRect);
      I0(paramCanvas, localRect);
      E0(paramCanvas, localRect);
      C0(paramCanvas, localRect);
      if (this.H0) {
        K0(paramCanvas, localRect);
      }
      H0(paramCanvas, localRect);
      J0(paramCanvas, localRect);
      if (this.x0 < 255) {
        paramCanvas.restoreToCount(i);
      }
    }
  }
  
  public void e1(RectF paramRectF)
  {
    v0(getBounds(), paramRectF);
  }
  
  public void e2(int paramInt)
  {
    d2(c.a.a(this.h0, paramInt));
  }
  
  public void f2(float paramFloat)
  {
    if (this.F != paramFloat)
    {
      this.F = paramFloat;
      this.i0.setStrokeWidth(paramFloat);
      if (this.J0) {
        super.m0(paramFloat);
      }
      invalidateSelf();
    }
  }
  
  public void g2(int paramInt)
  {
    f2(this.h0.getResources().getDimension(paramInt));
  }
  
  public int getAlpha()
  {
    return this.x0;
  }
  
  public ColorFilter getColorFilter()
  {
    return this.y0;
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.B;
  }
  
  public int getIntrinsicWidth()
  {
    return Math.min(Math.round(this.Z + s0() + this.c0 + this.o0.f(n1().toString()) + this.d0 + w0() + this.g0), this.I0);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @TargetApi(21)
  public void getOutline(Outline paramOutline)
  {
    if (this.J0)
    {
      super.getOutline(paramOutline);
      return;
    }
    Rect localRect = getBounds();
    if (!localRect.isEmpty()) {
      paramOutline.setRoundRect(localRect, this.C);
    } else {
      paramOutline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.C);
    }
    paramOutline.setAlpha(getAlpha() / 255.0F);
  }
  
  public TextUtils.TruncateAt h1()
  {
    return this.G0;
  }
  
  public e7.h i1()
  {
    return this.Y;
  }
  
  public void i2(Drawable paramDrawable)
  {
    Drawable localDrawable = X0();
    if (localDrawable != paramDrawable)
    {
      float f1 = w0();
      if (paramDrawable != null) {
        paramDrawable = r0.a.r(paramDrawable).mutate();
      } else {
        paramDrawable = null;
      }
      this.O = paramDrawable;
      if (b.a) {
        X2();
      }
      float f2 = w0();
      V2(localDrawable);
      if (U2()) {
        q0(this.O);
      }
      invalidateSelf();
      if (f1 != f2) {
        B1();
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public boolean isStateful()
  {
    return (x1(this.z)) || (x1(this.A)) || (x1(this.E)) || ((this.D0) && (x1(this.E0))) || (z1(this.o0.d())) || (A0()) || (y1(this.J)) || (y1(this.V)) || (x1(this.A0));
  }
  
  public float j1()
  {
    return this.b0;
  }
  
  public void j2(CharSequence paramCharSequence)
  {
    if (this.S != paramCharSequence)
    {
      this.S = w0.a.c().h(paramCharSequence);
      invalidateSelf();
    }
  }
  
  public float k1()
  {
    return this.a0;
  }
  
  public void k2(float paramFloat)
  {
    if (this.f0 != paramFloat)
    {
      this.f0 = paramFloat;
      invalidateSelf();
      if (U2()) {
        B1();
      }
    }
  }
  
  public ColorStateList l1()
  {
    return this.G;
  }
  
  public void l2(int paramInt)
  {
    k2(this.h0.getResources().getDimension(paramInt));
  }
  
  public e7.h m1()
  {
    return this.X;
  }
  
  public void m2(int paramInt)
  {
    i2(c.a.b(this.h0, paramInt));
  }
  
  public CharSequence n1()
  {
    return this.H;
  }
  
  public void n2(float paramFloat)
  {
    if (this.R != paramFloat)
    {
      this.R = paramFloat;
      invalidateSelf();
      if (U2()) {
        B1();
      }
    }
  }
  
  public d o1()
  {
    return this.o0.d();
  }
  
  public void o2(int paramInt)
  {
    n2(this.h0.getResources().getDimension(paramInt));
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    boolean bool2 = super.onLayoutDirectionChanged(paramInt);
    boolean bool1 = bool2;
    if (T2()) {
      bool1 = bool2 | r0.a.m(this.J, paramInt);
    }
    bool2 = bool1;
    if (S2()) {
      bool2 = bool1 | r0.a.m(this.V, paramInt);
    }
    bool1 = bool2;
    if (U2()) {
      bool1 = bool2 | r0.a.m(this.O, paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return true;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    boolean bool2 = super.onLevelChange(paramInt);
    boolean bool1 = bool2;
    if (T2()) {
      bool1 = bool2 | this.J.setLevel(paramInt);
    }
    bool2 = bool1;
    if (S2()) {
      bool2 = bool1 | this.V.setLevel(paramInt);
    }
    bool1 = bool2;
    if (U2()) {
      bool1 = bool2 | this.O.setLevel(paramInt);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.J0) {
      super.onStateChange(paramArrayOfInt);
    }
    return C1(paramArrayOfInt, c1());
  }
  
  public float p1()
  {
    return this.d0;
  }
  
  public void p2(float paramFloat)
  {
    if (this.e0 != paramFloat)
    {
      this.e0 = paramFloat;
      invalidateSelf();
      if (U2()) {
        B1();
      }
    }
  }
  
  public float q1()
  {
    return this.c0;
  }
  
  public void q2(int paramInt)
  {
    p2(this.h0.getResources().getDimension(paramInt));
  }
  
  public boolean r2(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.C0, paramArrayOfInt))
    {
      this.C0 = paramArrayOfInt;
      if (U2()) {
        return C1(getState(), paramArrayOfInt);
      }
    }
    return false;
  }
  
  float s0()
  {
    if ((!T2()) && (!S2())) {
      return 0.0F;
    }
    return this.a0 + g1() + this.b0;
  }
  
  public boolean s1()
  {
    return this.D0;
  }
  
  public void s2(ColorStateList paramColorStateList)
  {
    if (this.Q != paramColorStateList)
    {
      this.Q = paramColorStateList;
      if (U2()) {
        r0.a.o(this.O, paramColorStateList);
      }
      onStateChange(getState());
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.x0 != paramInt)
    {
      this.x0 = paramInt;
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.y0 != paramColorFilter)
    {
      this.y0 = paramColorFilter;
      invalidateSelf();
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    if (this.A0 != paramColorStateList)
    {
      this.A0 = paramColorStateList;
      onStateChange(getState());
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    if (this.B0 != paramMode)
    {
      this.B0 = paramMode;
      this.z0 = i7.a.c(this, this.A0, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = super.setVisible(paramBoolean1, paramBoolean2);
    boolean bool1 = bool2;
    if (T2()) {
      bool1 = bool2 | this.J.setVisible(paramBoolean1, paramBoolean2);
    }
    bool2 = bool1;
    if (S2()) {
      bool2 = bool1 | this.V.setVisible(paramBoolean1, paramBoolean2);
    }
    bool1 = bool2;
    if (U2()) {
      bool1 = bool2 | this.O.setVisible(paramBoolean1, paramBoolean2);
    }
    if (bool1) {
      invalidateSelf();
    }
    return bool1;
  }
  
  public void t2(int paramInt)
  {
    s2(c.a.a(this.h0, paramInt));
  }
  
  public boolean u1()
  {
    return this.T;
  }
  
  public void u2(boolean paramBoolean)
  {
    if (this.N != paramBoolean)
    {
      boolean bool = U2();
      this.N = paramBoolean;
      paramBoolean = U2();
      int i;
      if (bool != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          q0(this.O);
        } else {
          V2(this.O);
        }
        invalidateSelf();
        B1();
      }
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public boolean v1()
  {
    return y1(this.O);
  }
  
  public void v2(a parama)
  {
    this.F0 = new WeakReference(parama);
  }
  
  float w0()
  {
    if (U2()) {
      return this.e0 + this.R + this.f0;
    }
    return 0.0F;
  }
  
  public boolean w1()
  {
    return this.N;
  }
  
  public void w2(TextUtils.TruncateAt paramTruncateAt)
  {
    this.G0 = paramTruncateAt;
  }
  
  public void x2(e7.h paramh)
  {
    this.Y = paramh;
  }
  
  public void y2(int paramInt)
  {
    x2(e7.h.d(this.h0, paramInt));
  }
  
  Paint.Align z0(Rect paramRect, PointF paramPointF)
  {
    paramPointF.set(0.0F, 0.0F);
    Paint.Align localAlign = Paint.Align.LEFT;
    if (this.H != null)
    {
      float f = this.Z + s0() + this.c0;
      if (r0.a.f(this) == 0)
      {
        paramPointF.x = (paramRect.left + f);
        localAlign = Paint.Align.LEFT;
      }
      else
      {
        paramPointF.x = (paramRect.right - f);
        localAlign = Paint.Align.RIGHT;
      }
      paramPointF.y = (paramRect.centerY() - y0());
    }
    return localAlign;
  }
  
  public void z2(float paramFloat)
  {
    if (this.b0 != paramFloat)
    {
      float f = s0();
      this.b0 = paramFloat;
      paramFloat = s0();
      invalidateSelf();
      if (f != paramFloat) {
        B1();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.chip.a
 * JD-Core Version:    0.7.0.1
 */