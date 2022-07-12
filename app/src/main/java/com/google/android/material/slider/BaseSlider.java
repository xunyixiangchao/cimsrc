package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.s;
import com.google.android.material.internal.t;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import r7.h;
import r7.m;
import r7.m.b;
import y0.d.a;
import y0.d.d;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends a<S>, T extends b<S>>
  extends View
{
  private static final String f0 = BaseSlider.class.getSimpleName();
  static final int g0 = R.style.Widget_MaterialComponents_Slider;
  private int A;
  private float B;
  private MotionEvent C;
  private c E;
  private boolean F = false;
  private float G;
  private float H;
  private ArrayList<Float> I = new ArrayList();
  private int J = -1;
  private int K = -1;
  private float L = 0.0F;
  private float[] M;
  private boolean N = true;
  private int O;
  private boolean P;
  private boolean Q = false;
  private boolean R;
  private ColorStateList S;
  private ColorStateList T;
  private ColorStateList U;
  private ColorStateList V;
  private ColorStateList W;
  private final Paint a;
  private final h a0;
  private final Paint b;
  private Drawable b0;
  private final Paint c;
  private List<Drawable> c0;
  private final Paint d;
  private float d0;
  private final Paint e;
  private int e0;
  private final Paint f;
  private final e g;
  private final AccessibilityManager h;
  private BaseSlider<S, L, T>.d i;
  private final f j;
  private final List<t7.a> k = new ArrayList();
  private final List<L> l = new ArrayList();
  private final List<T> m = new ArrayList();
  private boolean n = false;
  private ValueAnimator o;
  private ValueAnimator p;
  private final int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public BaseSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.sliderStyle);
  }
  
  public BaseSlider(Context paramContext, final AttributeSet paramAttributeSet, final int paramInt)
  {
    super(s7.a.c(paramContext, paramAttributeSet, paramInt, g0), paramAttributeSet, paramInt);
    paramContext = new h();
    this.a0 = paramContext;
    this.c0 = Collections.emptyList();
    this.e0 = 0;
    Context localContext = getContext();
    Paint localPaint = new Paint();
    this.a = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint();
    this.b = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint(1);
    this.c = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    localPaint = new Paint(1);
    this.d = localPaint;
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = new Paint();
    this.e = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint = new Paint();
    this.f = localPaint;
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    K(localContext.getResources());
    this.j = new a(paramAttributeSet, paramInt);
    Y(localContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setClickable(true);
    paramContext.i0(2);
    this.q = ViewConfiguration.get(localContext).getScaledTouchSlop();
    paramContext = new e(this);
    this.g = paramContext;
    x.q0(this, paramContext);
    this.h = ((AccessibilityManager)getContext().getSystemService("accessibility"));
  }
  
  private String A(float paramFloat)
  {
    if (E()) {
      return this.E.a(paramFloat);
    }
    String str;
    if ((int)paramFloat == paramFloat) {
      str = "%.0f";
    } else {
      str = "%.2f";
    }
    return String.format(str, new Object[] { Float.valueOf(paramFloat) });
  }
  
  private static float B(ValueAnimator paramValueAnimator, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramValueAnimator != null)
    {
      f1 = paramFloat;
      if (paramValueAnimator.isRunning())
      {
        f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
        paramValueAnimator.cancel();
      }
    }
    return f1;
  }
  
  private float C(int paramInt, float paramFloat)
  {
    float f2 = getMinSeparation();
    float f1 = f2;
    if (this.e0 == 0) {
      f1 = q(f2);
    }
    f2 = f1;
    if (J()) {
      f2 = -f1;
    }
    int i1 = paramInt + 1;
    if (i1 >= this.I.size()) {
      f1 = this.H;
    } else {
      f1 = ((Float)this.I.get(i1)).floatValue() - f2;
    }
    paramInt -= 1;
    if (paramInt < 0) {
      f2 = this.G;
    } else {
      f2 = ((Float)this.I.get(paramInt)).floatValue() + f2;
    }
    return t0.a.a(paramFloat, f2, f1);
  }
  
  private int D(ColorStateList paramColorStateList)
  {
    return paramColorStateList.getColorForState(getDrawableState(), paramColorStateList.getDefaultColor());
  }
  
  private Drawable F(Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.mutate().getConstantState().newDrawable();
    h(paramDrawable);
    return paramDrawable;
  }
  
  private void G()
  {
    this.a.setStrokeWidth(this.v);
    this.b.setStrokeWidth(this.v);
    this.e.setStrokeWidth(this.v / 2.0F);
    this.f.setStrokeWidth(this.v / 2.0F);
  }
  
  private boolean H()
  {
    for (ViewParent localViewParent = getParent();; localViewParent = localViewParent.getParent())
    {
      boolean bool = localViewParent instanceof ViewGroup;
      int i1 = 0;
      if (!bool) {
        break;
      }
      ViewGroup localViewGroup = (ViewGroup)localViewParent;
      if ((localViewGroup.canScrollVertically(1)) || (localViewGroup.canScrollVertically(-1))) {
        i1 = 1;
      }
      if ((i1 != 0) && (localViewGroup.shouldDelayChildPressedState())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean I(float paramFloat)
  {
    double d1 = new BigDecimal(Float.toString(paramFloat)).divide(new BigDecimal(Float.toString(this.L)), MathContext.DECIMAL64).doubleValue();
    return Math.abs(Math.round(d1) - d1) < 0.0001D;
  }
  
  private void K(Resources paramResources)
  {
    this.t = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
    int i1 = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
    this.r = i1;
    this.w = i1;
    this.s = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
    this.x = paramResources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
    this.A = paramResources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
  }
  
  private void L()
  {
    if (this.L <= 0.0F) {
      return;
    }
    k0();
    int i2 = Math.min((int)((this.H - this.G) / this.L + 1.0F), this.O / (this.v * 2) + 1);
    float[] arrayOfFloat = this.M;
    if ((arrayOfFloat == null) || (arrayOfFloat.length != i2 * 2)) {
      this.M = new float[i2 * 2];
    }
    float f1 = this.O / (i2 - 1);
    int i1 = 0;
    while (i1 < i2 * 2)
    {
      arrayOfFloat = this.M;
      arrayOfFloat[i1] = (this.w + i1 / 2 * f1);
      arrayOfFloat[(i1 + 1)] = m();
      i1 += 2;
    }
  }
  
  private void M(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (c0())
    {
      paramInt1 = (int)(this.w + R(((Float)this.I.get(this.K)).floatValue()) * paramInt1);
      if (Build.VERSION.SDK_INT < 28)
      {
        int i1 = this.z;
        paramCanvas.clipRect(paramInt1 - i1, paramInt2 - i1, paramInt1 + i1, i1 + paramInt2, Region.Op.UNION);
      }
      paramCanvas.drawCircle(paramInt1, paramInt2, this.z, this.d);
    }
  }
  
  private void N(Canvas paramCanvas)
  {
    if (this.N)
    {
      if (this.L <= 0.0F) {
        return;
      }
      float[] arrayOfFloat = getActiveRange();
      int i2 = X(this.M, arrayOfFloat[0]);
      int i1 = X(this.M, arrayOfFloat[1]);
      arrayOfFloat = this.M;
      i2 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, 0, i2, this.e);
      arrayOfFloat = this.M;
      i1 *= 2;
      paramCanvas.drawPoints(arrayOfFloat, i2, i1 - i2, this.f);
      arrayOfFloat = this.M;
      paramCanvas.drawPoints(arrayOfFloat, i1, arrayOfFloat.length - i1, this.e);
    }
  }
  
  private void O()
  {
    int i1 = Math.max(this.y - this.s, 0);
    this.w = (this.r + i1);
    if (x.U(this)) {
      j0(getWidth());
    }
  }
  
  private boolean P(int paramInt)
  {
    int i1 = this.K;
    paramInt = (int)t0.a.c(i1 + paramInt, 0L, this.I.size() - 1);
    this.K = paramInt;
    if (paramInt == i1) {
      return false;
    }
    if (this.J != -1) {
      this.J = paramInt;
    }
    i0();
    postInvalidate();
    return true;
  }
  
  private boolean Q(int paramInt)
  {
    int i1 = paramInt;
    if (J()) {
      if (paramInt == -2147483648) {
        i1 = 2147483647;
      } else {
        i1 = -paramInt;
      }
    }
    return P(i1);
  }
  
  private float R(float paramFloat)
  {
    float f1 = this.G;
    paramFloat = (paramFloat - f1) / (this.H - f1);
    if (J()) {
      return 1.0F - paramFloat;
    }
    return paramFloat;
  }
  
  private Boolean S(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 61)
    {
      if (paramInt != 66)
      {
        if (paramInt != 81) {
          if (paramInt != 69) {
            if (paramInt == 70) {
              break label88;
            }
          }
        }
        switch (paramInt)
        {
        default: 
          return null;
        case 22: 
          Q(1);
          return Boolean.TRUE;
        case 21: 
          Q(-1);
          return Boolean.TRUE;
          P(-1);
          return Boolean.TRUE;
          label88:
          P(1);
          return Boolean.TRUE;
        }
      }
      this.J = this.K;
      postInvalidate();
      return Boolean.TRUE;
    }
    if (paramKeyEvent.hasNoModifiers()) {
      return Boolean.valueOf(P(1));
    }
    if (paramKeyEvent.isShiftPressed()) {
      return Boolean.valueOf(P(-1));
    }
    return Boolean.FALSE;
  }
  
  private void T()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).a(this);
    }
  }
  
  private void U()
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).b(this);
    }
  }
  
  private static t7.a V(Context paramContext, TypedArray paramTypedArray)
  {
    return t7.a.u0(paramContext, null, 0, paramTypedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
  }
  
  private static int X(float[] paramArrayOfFloat, float paramFloat)
  {
    return Math.round(paramFloat * (paramArrayOfFloat.length / 2 - 1));
  }
  
  private void Y(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = p.h(paramContext, paramAttributeSet, R.styleable.Slider, paramInt, g0, new int[0]);
    this.G = localTypedArray.getFloat(R.styleable.Slider_android_valueFrom, 0.0F);
    this.H = localTypedArray.getFloat(R.styleable.Slider_android_valueTo, 1.0F);
    setValues(new Float[] { Float.valueOf(this.G) });
    this.L = localTypedArray.getFloat(R.styleable.Slider_android_stepSize, 0.0F);
    paramInt = R.styleable.Slider_trackColor;
    boolean bool = localTypedArray.hasValue(paramInt);
    int i1;
    if (bool) {
      i1 = paramInt;
    } else {
      i1 = R.styleable.Slider_trackColorInactive;
    }
    if (!bool) {
      paramInt = R.styleable.Slider_trackColorActive;
    }
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet == null) {
      paramAttributeSet = c.a.a(paramContext, R.color.material_slider_inactive_track_color);
    }
    setTrackInactiveTintList(paramAttributeSet);
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet == null) {
      paramAttributeSet = c.a.a(paramContext, R.color.material_slider_active_track_color);
    }
    setTrackActiveTintList(paramAttributeSet);
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, R.styleable.Slider_thumbColor);
    this.a0.b0(paramAttributeSet);
    paramInt = R.styleable.Slider_thumbStrokeColor;
    if (localTypedArray.hasValue(paramInt)) {
      setThumbStrokeColor(o7.c.a(paramContext, localTypedArray, paramInt));
    }
    setThumbStrokeWidth(localTypedArray.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0F));
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, R.styleable.Slider_haloColor);
    if (paramAttributeSet == null) {
      paramAttributeSet = c.a.a(paramContext, R.color.material_slider_halo_color);
    }
    setHaloTintList(paramAttributeSet);
    this.N = localTypedArray.getBoolean(R.styleable.Slider_tickVisible, true);
    paramInt = R.styleable.Slider_tickColor;
    bool = localTypedArray.hasValue(paramInt);
    if (bool) {
      i1 = paramInt;
    } else {
      i1 = R.styleable.Slider_tickColorInactive;
    }
    if (!bool) {
      paramInt = R.styleable.Slider_tickColorActive;
    }
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, i1);
    if (paramAttributeSet == null) {
      paramAttributeSet = c.a.a(paramContext, R.color.material_slider_inactive_tick_marks_color);
    }
    setTickInactiveTintList(paramAttributeSet);
    paramAttributeSet = o7.c.a(paramContext, localTypedArray, paramInt);
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet;
    } else {
      paramContext = c.a.a(paramContext, R.color.material_slider_active_tick_marks_color);
    }
    setTickActiveTintList(paramContext);
    setThumbRadius(localTypedArray.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
    setHaloRadius(localTypedArray.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
    setThumbElevation(localTypedArray.getDimension(R.styleable.Slider_thumbElevation, 0.0F));
    setTrackHeight(localTypedArray.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
    setLabelBehavior(localTypedArray.getInt(R.styleable.Slider_labelBehavior, 0));
    if (!localTypedArray.getBoolean(R.styleable.Slider_android_enabled, true)) {
      setEnabled(false);
    }
    localTypedArray.recycle();
  }
  
  private void Z(int paramInt)
  {
    d locald = this.i;
    if (locald == null) {
      this.i = new d(null);
    } else {
      removeCallbacks(locald);
    }
    this.i.a(paramInt);
    postDelayed(this.i, 200L);
  }
  
  private void a0(t7.a parama, float paramFloat)
  {
    parama.C0(A(paramFloat));
    int i1 = this.w + (int)(R(paramFloat) * this.O) - parama.getIntrinsicWidth() / 2;
    int i2 = m() - (this.A + this.y);
    parama.setBounds(i1, i2 - parama.getIntrinsicHeight(), parama.getIntrinsicWidth() + i1, i2);
    Rect localRect = new Rect(parama.getBounds());
    com.google.android.material.internal.d.c(t.e(this), this, localRect);
    parama.setBounds(localRect);
    t.f(this).a(parama);
  }
  
  private boolean b0()
  {
    return this.u == 3;
  }
  
  private boolean c0()
  {
    return (this.P) || (!(getBackground() instanceof RippleDrawable));
  }
  
  private boolean d0(float paramFloat)
  {
    return f0(this.J, paramFloat);
  }
  
  private double e0(float paramFloat)
  {
    float f1 = this.L;
    if (f1 > 0.0F)
    {
      int i1 = (int)((this.H - this.G) / f1);
      return Math.round(paramFloat * i1) / i1;
    }
    return paramFloat;
  }
  
  private boolean f0(int paramInt, float paramFloat)
  {
    this.K = paramInt;
    if (Math.abs(paramFloat - ((Float)this.I.get(paramInt)).floatValue()) < 0.0001D) {
      return false;
    }
    paramFloat = C(paramInt, paramFloat);
    this.I.set(paramInt, Float.valueOf(paramFloat));
    r(paramInt);
    return true;
  }
  
  private boolean g0()
  {
    return d0(getValueOfTouchPosition());
  }
  
  private float[] getActiveRange()
  {
    float f2 = ((Float)Collections.max(getValues())).floatValue();
    float f1 = ((Float)Collections.min(getValues())).floatValue();
    if (this.I.size() == 1) {
      f1 = this.G;
    }
    f1 = R(f1);
    f2 = R(f2);
    if (J()) {
      return new float[] { f2, f1 };
    }
    return new float[] { f1, f2 };
  }
  
  private float getValueOfTouchPosition()
  {
    double d2 = e0(this.d0);
    double d1 = d2;
    if (J()) {
      d1 = 1.0D - d2;
    }
    float f1 = this.H;
    float f2 = this.G;
    return (float)(d1 * (f1 - f2) + f2);
  }
  
  private float getValueOfTouchPositionAbsolute()
  {
    float f2 = this.d0;
    float f1 = f2;
    if (J()) {
      f1 = 1.0F - f2;
    }
    f2 = this.H;
    float f3 = this.G;
    return f1 * (f2 - f3) + f3;
  }
  
  private void h(Drawable paramDrawable)
  {
    int i1 = this.y * 2;
    int i2 = paramDrawable.getIntrinsicWidth();
    int i3 = paramDrawable.getIntrinsicHeight();
    if ((i2 == -1) && (i3 == -1))
    {
      paramDrawable.setBounds(0, 0, i1, i1);
      return;
    }
    float f1 = i1 / Math.max(i2, i3);
    paramDrawable.setBounds(0, 0, (int)(i2 * f1), (int)(i3 * f1));
  }
  
  private void i(t7.a parama)
  {
    parama.A0(t.e(this));
  }
  
  private void i0()
  {
    if ((!c0()) && (getMeasuredWidth() > 0))
    {
      Drawable localDrawable = getBackground();
      if ((localDrawable instanceof RippleDrawable))
      {
        int i1 = (int)(R(((Float)this.I.get(this.K)).floatValue()) * this.O + this.w);
        int i2 = m();
        int i3 = this.z;
        r0.a.l(localDrawable, i1 - i3, i2 - i3, i1 + i3, i2 + i3);
      }
    }
  }
  
  private Float j(int paramInt)
  {
    float f1;
    if (this.Q) {
      f1 = l(20);
    } else {
      f1 = k();
    }
    if (paramInt != 21)
    {
      if (paramInt != 22)
      {
        if (paramInt != 69)
        {
          if ((paramInt != 70) && (paramInt != 81)) {
            return null;
          }
          return Float.valueOf(f1);
        }
        return Float.valueOf(-f1);
      }
      float f2 = f1;
      if (J()) {
        f2 = -f1;
      }
      return Float.valueOf(f2);
    }
    if (!J()) {
      f1 = -f1;
    }
    return Float.valueOf(f1);
  }
  
  private void j0(int paramInt)
  {
    this.O = Math.max(paramInt - this.w * 2, 0);
    L();
  }
  
  private float k()
  {
    float f2 = this.L;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    return f1;
  }
  
  private void k0()
  {
    if (this.R)
    {
      n0();
      o0();
      m0();
      p0();
      l0();
      s0();
      this.R = false;
    }
  }
  
  private float l(int paramInt)
  {
    float f1 = k();
    float f2 = (this.H - this.G) / f1;
    float f3 = paramInt;
    if (f2 <= f3) {
      return f1;
    }
    return Math.round(f2 / f3) * f1;
  }
  
  private void l0()
  {
    float f1 = getMinSeparation();
    if (f1 >= 0.0F)
    {
      float f2 = this.L;
      if ((f2 > 0.0F) && (f1 > 0.0F))
      {
        if (this.e0 == 1)
        {
          if ((f1 >= f2) && (I(f1))) {
            return;
          }
          throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { Float.valueOf(f1), Float.valueOf(this.L), Float.valueOf(this.L) }));
        }
        throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", new Object[] { Float.valueOf(f1), Float.valueOf(this.L) }));
      }
      return;
    }
    throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", new Object[] { Float.valueOf(f1) }));
  }
  
  private int m()
  {
    int i2 = this.x;
    int i3 = this.u;
    int i1 = 0;
    if ((i3 == 1) || (b0())) {
      i1 = ((t7.a)this.k.get(0)).getIntrinsicHeight();
    }
    return i2 + i1;
  }
  
  private void m0()
  {
    if (this.L > 0.0F)
    {
      if (q0(this.H)) {
        return;
      }
      throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.valueOf(this.L), Float.valueOf(this.G), Float.valueOf(this.H) }));
    }
  }
  
  private ValueAnimator n(boolean paramBoolean)
  {
    float f2 = 0.0F;
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    Object localObject;
    if (paramBoolean) {
      localObject = this.p;
    } else {
      localObject = this.o;
    }
    float f3 = B((ValueAnimator)localObject, f1);
    float f1 = f2;
    if (paramBoolean) {
      f1 = 1.0F;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f3, f1 });
    long l1;
    if (paramBoolean) {
      l1 = 83L;
    } else {
      l1 = 117L;
    }
    localValueAnimator.setDuration(l1);
    if (paramBoolean) {
      localObject = e7.a.e;
    } else {
      localObject = e7.a.c;
    }
    localValueAnimator.setInterpolator((TimeInterpolator)localObject);
    localValueAnimator.addUpdateListener(new b());
    return localValueAnimator;
  }
  
  private void n0()
  {
    if (this.G < this.H) {
      return;
    }
    throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[] { Float.valueOf(this.G), Float.valueOf(this.H) }));
  }
  
  private void o()
  {
    if (this.k.size() > this.I.size())
    {
      localObject = this.k.subList(this.I.size(), this.k.size());
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        t7.a locala = (t7.a)localIterator.next();
        if (x.T(this)) {
          p(locala);
        }
      }
      ((List)localObject).clear();
    }
    while (this.k.size() < this.I.size())
    {
      localObject = this.j.a();
      this.k.add(localObject);
      if (x.T(this)) {
        i((t7.a)localObject);
      }
    }
    int i2 = this.k.size();
    int i1 = 1;
    if (i2 == 1) {
      i1 = 0;
    }
    Object localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((t7.a)((Iterator)localObject).next()).m0(i1);
    }
  }
  
  private void o0()
  {
    if (this.H > this.G) {
      return;
    }
    throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[] { Float.valueOf(this.H), Float.valueOf(this.G) }));
  }
  
  private void p(t7.a parama)
  {
    s locals = t.f(this);
    if (locals != null)
    {
      locals.b(parama);
      parama.w0(t.e(this));
    }
  }
  
  private void p0()
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      Float localFloat = (Float)localIterator.next();
      if ((localFloat.floatValue() >= this.G) && (localFloat.floatValue() <= this.H))
      {
        if ((this.L > 0.0F) && (!q0(localFloat.floatValue()))) {
          throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[] { localFloat, Float.valueOf(this.G), Float.valueOf(this.L), Float.valueOf(this.L) }));
        }
      }
      else {
        throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[] { localFloat, Float.valueOf(this.G), Float.valueOf(this.H) }));
      }
    }
  }
  
  private float q(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    paramFloat = (paramFloat - this.w) / this.O;
    float f1 = this.G;
    return paramFloat * (f1 - this.H) + f1;
  }
  
  private boolean q0(float paramFloat)
  {
    return I(paramFloat - this.G);
  }
  
  private void r(int paramInt)
  {
    Object localObject = this.l.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(this, ((Float)this.I.get(paramInt)).floatValue(), true);
    }
    localObject = this.h;
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled())) {
      Z(paramInt);
    }
  }
  
  private float r0(float paramFloat)
  {
    return R(paramFloat) * this.O + this.w;
  }
  
  private void s()
  {
    Iterator localIterator1 = this.l.iterator();
    while (localIterator1.hasNext())
    {
      a locala = (a)localIterator1.next();
      Iterator localIterator2 = this.I.iterator();
      while (localIterator2.hasNext()) {
        locala.a(this, ((Float)localIterator2.next()).floatValue(), false);
      }
    }
  }
  
  private void s0()
  {
    float f1 = this.L;
    if (f1 == 0.0F) {
      return;
    }
    if ((int)f1 != f1) {
      Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[] { "stepSize", Float.valueOf(f1) }));
    }
    f1 = this.G;
    if ((int)f1 != f1) {
      Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[] { "valueFrom", Float.valueOf(f1) }));
    }
    f1 = this.H;
    if ((int)f1 != f1) {
      Log.w(f0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", new Object[] { "valueTo", Float.valueOf(f1) }));
    }
  }
  
  private void setValuesInternal(ArrayList<Float> paramArrayList)
  {
    if (!paramArrayList.isEmpty())
    {
      Collections.sort(paramArrayList);
      if ((this.I.size() == paramArrayList.size()) && (this.I.equals(paramArrayList))) {
        return;
      }
      this.I = paramArrayList;
      this.R = true;
      this.K = 0;
      i0();
      o();
      s();
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("At least one value must be set");
  }
  
  private void t(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i1 = this.w;
    float f1 = i1;
    float f2 = arrayOfFloat[1];
    float f3 = paramInt1;
    float f4 = i1;
    float f5 = arrayOfFloat[0];
    float f6 = paramInt2;
    paramCanvas.drawLine(f4 + f5 * f3, f6, f1 + f2 * f3, f6, this.b);
  }
  
  private void u(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = getActiveRange();
    int i1 = this.w;
    float f2 = i1;
    float f3 = arrayOfFloat[1];
    float f1 = paramInt1;
    f2 += f3 * f1;
    if (f2 < i1 + paramInt1)
    {
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, i1 + paramInt1, f3, this.a);
    }
    paramInt1 = this.w;
    f1 = paramInt1 + arrayOfFloat[0] * f1;
    if (f1 > paramInt1)
    {
      f2 = paramInt1;
      f3 = paramInt2;
      paramCanvas.drawLine(f2, f3, f1, f3, this.a);
    }
  }
  
  private void v(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat, Drawable paramDrawable)
  {
    paramCanvas.save();
    paramCanvas.translate(this.w + (int)(R(paramFloat) * paramInt1) - paramDrawable.getBounds().width() / 2.0F, paramInt2 - paramDrawable.getBounds().height() / 2.0F);
    paramDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private void w(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    while (i1 < this.I.size())
    {
      float f1 = ((Float)this.I.get(i1)).floatValue();
      Object localObject = this.b0;
      if (localObject != null) {}
      for (;;)
      {
        v(paramCanvas, paramInt1, paramInt2, f1, (Drawable)localObject);
        break;
        if (i1 < this.c0.size())
        {
          localObject = (Drawable)this.c0.get(i1);
        }
        else
        {
          if (!isEnabled()) {
            paramCanvas.drawCircle(this.w + R(f1) * paramInt1, paramInt2, this.y, this.c);
          }
          localObject = this.a0;
        }
      }
      i1 += 1;
    }
  }
  
  private void x()
  {
    if (this.u == 2) {
      return;
    }
    if (!this.n)
    {
      this.n = true;
      localObject = n(true);
      this.o = ((ValueAnimator)localObject);
      this.p = null;
      ((ValueAnimator)localObject).start();
    }
    Object localObject = this.k.iterator();
    int i1 = 0;
    while ((i1 < this.I.size()) && (((Iterator)localObject).hasNext()))
    {
      if (i1 != this.K) {
        a0((t7.a)((Iterator)localObject).next(), ((Float)this.I.get(i1)).floatValue());
      }
      i1 += 1;
    }
    if (((Iterator)localObject).hasNext())
    {
      a0((t7.a)((Iterator)localObject).next(), ((Float)this.I.get(this.K)).floatValue());
      return;
    }
    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[] { Integer.valueOf(this.k.size()), Integer.valueOf(this.I.size()) }));
  }
  
  private void y()
  {
    if (this.n)
    {
      this.n = false;
      ValueAnimator localValueAnimator = n(false);
      this.p = localValueAnimator;
      this.o = null;
      localValueAnimator.addListener(new c());
      this.p.start();
    }
  }
  
  private void z(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 17)
        {
          if (paramInt != 66) {
            return;
          }
          Q(-2147483648);
          return;
        }
        Q(2147483647);
        return;
      }
      P(-2147483648);
      return;
    }
    P(2147483647);
  }
  
  public boolean E()
  {
    return this.E != null;
  }
  
  final boolean J()
  {
    return x.B(this) == 1;
  }
  
  protected boolean W()
  {
    if (this.J != -1) {
      return true;
    }
    float f4 = getValueOfTouchPositionAbsolute();
    float f5 = r0(f4);
    this.J = 0;
    float f1 = Math.abs(((Float)this.I.get(0)).floatValue() - f4);
    int i1 = 1;
    while (i1 < this.I.size())
    {
      float f3 = Math.abs(((Float)this.I.get(i1)).floatValue() - f4);
      float f6 = r0(((Float)this.I.get(i1)).floatValue());
      if (Float.compare(f3, f1) > 1) {
        break;
      }
      int i2;
      if (J() ? f6 - f5 > 0.0F : f6 - f5 < 0.0F) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (Float.compare(f3, f1) < 0) {}
      for (;;)
      {
        this.J = i1;
        break;
        f2 = f1;
        if (Float.compare(f3, f1) != 0) {
          break label222;
        }
        if (Math.abs(f6 - f5) < this.q)
        {
          this.J = -1;
          return false;
        }
        f2 = f1;
        if (i2 == 0) {
          break label222;
        }
      }
      float f2 = f3;
      label222:
      i1 += 1;
      f1 = f2;
    }
    return this.J != -1;
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (this.g.v(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.a.setColor(D(this.W));
    this.b.setColor(D(this.V));
    this.e.setColor(D(this.U));
    this.f.setColor(D(this.T));
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      t7.a locala = (t7.a)localIterator.next();
      if (locala.isStateful()) {
        locala.setState(getDrawableState());
      }
    }
    if (this.a0.isStateful()) {
      this.a0.setState(getDrawableState());
    }
    this.d.setColor(D(this.S));
    this.d.setAlpha(63);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    return SeekBar.class.getName();
  }
  
  final int getAccessibilityFocusedVirtualViewId()
  {
    return this.g.x();
  }
  
  public int getActiveThumbIndex()
  {
    return this.J;
  }
  
  public int getFocusedThumbIndex()
  {
    return this.K;
  }
  
  public int getHaloRadius()
  {
    return this.z;
  }
  
  public ColorStateList getHaloTintList()
  {
    return this.S;
  }
  
  public int getLabelBehavior()
  {
    return this.u;
  }
  
  protected float getMinSeparation()
  {
    return 0.0F;
  }
  
  public float getStepSize()
  {
    return this.L;
  }
  
  public float getThumbElevation()
  {
    return this.a0.w();
  }
  
  public int getThumbRadius()
  {
    return this.y;
  }
  
  public ColorStateList getThumbStrokeColor()
  {
    return this.a0.F();
  }
  
  public float getThumbStrokeWidth()
  {
    return this.a0.H();
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.a0.x();
  }
  
  public ColorStateList getTickActiveTintList()
  {
    return this.T;
  }
  
  public ColorStateList getTickInactiveTintList()
  {
    return this.U;
  }
  
  public ColorStateList getTickTintList()
  {
    if (this.U.equals(this.T)) {
      return this.T;
    }
    throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
  }
  
  public ColorStateList getTrackActiveTintList()
  {
    return this.V;
  }
  
  public int getTrackHeight()
  {
    return this.v;
  }
  
  public ColorStateList getTrackInactiveTintList()
  {
    return this.W;
  }
  
  public int getTrackSidePadding()
  {
    return this.w;
  }
  
  public ColorStateList getTrackTintList()
  {
    if (this.W.equals(this.V)) {
      return this.V;
    }
    throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
  }
  
  public int getTrackWidth()
  {
    return this.O;
  }
  
  public float getValueFrom()
  {
    return this.G;
  }
  
  public float getValueTo()
  {
    return this.H;
  }
  
  List<Float> getValues()
  {
    return new ArrayList(this.I);
  }
  
  void h0(int paramInt, Rect paramRect)
  {
    paramInt = this.w + (int)(R(((Float)getValues().get(paramInt)).floatValue()) * this.O);
    int i1 = m();
    int i2 = this.y;
    paramRect.set(paramInt - i2, i1 - i2, paramInt + i2, i1 + i2);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      i((t7.a)localIterator.next());
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject = this.i;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
    this.n = false;
    localObject = this.k.iterator();
    while (((Iterator)localObject).hasNext()) {
      p((t7.a)((Iterator)localObject).next());
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.R)
    {
      k0();
      L();
    }
    super.onDraw(paramCanvas);
    int i1 = m();
    u(paramCanvas, this.O, i1);
    if (((Float)Collections.max(getValues())).floatValue() > this.G) {
      t(paramCanvas, this.O, i1);
    }
    N(paramCanvas);
    if (((this.F) || (isFocused()) || (b0())) && (isEnabled()))
    {
      M(paramCanvas, this.O, i1);
      if ((this.J != -1) || (b0()))
      {
        x();
        break label135;
      }
    }
    y();
    label135:
    w(paramCanvas, this.O, i1);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean)
    {
      this.J = -1;
      this.g.o(this.K);
      return;
    }
    z(paramInt);
    this.g.V(this.K);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!isEnabled()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    if (this.I.size() == 1) {
      this.J = 0;
    }
    if (this.J == -1)
    {
      localObject = S(paramInt, paramKeyEvent);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    this.Q |= paramKeyEvent.isLongPress();
    Object localObject = j(paramInt);
    if (localObject != null)
    {
      if (d0(((Float)this.I.get(this.J)).floatValue() + ((Float)localObject).floatValue()))
      {
        i0();
        postInvalidate();
      }
      return true;
    }
    if (paramInt != 23) {
      if (paramInt != 61)
      {
        if (paramInt != 66) {
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return P(1);
        }
        if (paramKeyEvent.isShiftPressed()) {
          return P(-1);
        }
        return false;
      }
    }
    this.J = -1;
    postInvalidate();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    this.Q = false;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = this.t;
    int i2 = this.u;
    paramInt2 = 0;
    if ((i2 == 1) || (b0())) {
      paramInt2 = ((t7.a)this.k.get(0)).getIntrinsicHeight();
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i1 + paramInt2, 1073741824));
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SliderState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.G = paramParcelable.a;
    this.H = paramParcelable.b;
    setValuesInternal(paramParcelable.c);
    this.L = paramParcelable.d;
    if (paramParcelable.e) {
      requestFocus();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SliderState localSliderState = new SliderState(super.onSaveInstanceState());
    localSliderState.a = this.G;
    localSliderState.b = this.H;
    localSliderState.c = new ArrayList(this.I);
    localSliderState.d = this.L;
    localSliderState.e = hasFocus();
    return localSliderState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    j0(paramInt1);
    i0();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = (f1 - this.w) / this.O;
    this.d0 = f2;
    f2 = Math.max(0.0F, f2);
    this.d0 = f2;
    this.d0 = Math.min(1.0F, f2);
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          break label328;
        }
        if (!this.F)
        {
          if ((H()) && (Math.abs(f1 - this.B) < this.q)) {
            return false;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          T();
        }
        if (!W()) {
          break label328;
        }
        this.F = true;
        g0();
        i0();
      }
      else
      {
        this.F = false;
        MotionEvent localMotionEvent = this.C;
        if ((localMotionEvent != null) && (localMotionEvent.getActionMasked() == 0) && (Math.abs(this.C.getX() - paramMotionEvent.getX()) <= this.q) && (Math.abs(this.C.getY() - paramMotionEvent.getY()) <= this.q) && (W())) {
          T();
        }
        if (this.J != -1)
        {
          g0();
          this.J = -1;
          U();
        }
      }
      invalidate();
    }
    else
    {
      this.B = f1;
      if (!H())
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (W())
        {
          requestFocus();
          this.F = true;
          g0();
          i0();
          invalidate();
          T();
        }
      }
    }
    label328:
    setPressed(this.F);
    this.C = MotionEvent.obtain(paramMotionEvent);
    return true;
  }
  
  protected void setActiveThumbIndex(int paramInt)
  {
    this.J = paramInt;
  }
  
  void setCustomThumbDrawable(int paramInt)
  {
    setCustomThumbDrawable(getResources().getDrawable(paramInt));
  }
  
  void setCustomThumbDrawable(Drawable paramDrawable)
  {
    this.b0 = F(paramDrawable);
    this.c0.clear();
    postInvalidate();
  }
  
  void setCustomThumbDrawablesForValues(int... paramVarArgs)
  {
    Drawable[] arrayOfDrawable = new Drawable[paramVarArgs.length];
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      arrayOfDrawable[i1] = getResources().getDrawable(paramVarArgs[i1]);
      i1 += 1;
    }
    setCustomThumbDrawablesForValues(arrayOfDrawable);
  }
  
  void setCustomThumbDrawablesForValues(Drawable... paramVarArgs)
  {
    this.b0 = null;
    this.c0 = new ArrayList();
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Drawable localDrawable = paramVarArgs[i1];
      this.c0.add(F(localDrawable));
      i1 += 1;
    }
    postInvalidate();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 2;
    }
    setLayerType(i1, null);
  }
  
  public void setFocusedThumbIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.I.size()))
    {
      this.K = paramInt;
      this.g.V(paramInt);
      postInvalidate();
      return;
    }
    throw new IllegalArgumentException("index out of range");
  }
  
  public void setHaloRadius(int paramInt)
  {
    if (paramInt == this.z) {
      return;
    }
    this.z = paramInt;
    Drawable localDrawable = getBackground();
    if ((!c0()) && ((localDrawable instanceof RippleDrawable)))
    {
      i7.a.b((RippleDrawable)localDrawable, this.z);
      return;
    }
    postInvalidate();
  }
  
  public void setHaloRadiusResource(int paramInt)
  {
    setHaloRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setHaloTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.S)) {
      return;
    }
    this.S = paramColorStateList;
    Drawable localDrawable = getBackground();
    if ((!c0()) && ((localDrawable instanceof RippleDrawable)))
    {
      ((RippleDrawable)localDrawable).setColor(paramColorStateList);
      return;
    }
    this.d.setColor(D(paramColorStateList));
    this.d.setAlpha(63);
    invalidate();
  }
  
  public void setLabelBehavior(int paramInt)
  {
    if (this.u != paramInt)
    {
      this.u = paramInt;
      requestLayout();
    }
  }
  
  public void setLabelFormatter(c paramc)
  {
    this.E = paramc;
  }
  
  protected void setSeparationUnit(int paramInt)
  {
    this.e0 = paramInt;
    this.R = true;
    postInvalidate();
  }
  
  public void setStepSize(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (this.L != paramFloat)
      {
        this.L = paramFloat;
        this.R = true;
        postInvalidate();
      }
      return;
    }
    throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.G), Float.valueOf(this.H) }));
  }
  
  public void setThumbElevation(float paramFloat)
  {
    this.a0.a0(paramFloat);
  }
  
  public void setThumbElevationResource(int paramInt)
  {
    setThumbElevation(getResources().getDimension(paramInt));
  }
  
  public void setThumbRadius(int paramInt)
  {
    if (paramInt == this.y) {
      return;
    }
    this.y = paramInt;
    O();
    this.a0.setShapeAppearanceModel(m.a().q(0, this.y).m());
    Object localObject = this.a0;
    paramInt = this.y;
    ((Drawable)localObject).setBounds(0, 0, paramInt * 2, paramInt * 2);
    localObject = this.b0;
    if (localObject != null) {
      h((Drawable)localObject);
    }
    localObject = this.c0.iterator();
    while (((Iterator)localObject).hasNext()) {
      h((Drawable)((Iterator)localObject).next());
    }
    postInvalidate();
  }
  
  public void setThumbRadiusResource(int paramInt)
  {
    setThumbRadius(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setThumbStrokeColor(ColorStateList paramColorStateList)
  {
    this.a0.l0(paramColorStateList);
    postInvalidate();
  }
  
  public void setThumbStrokeColorResource(int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeColor(c.a.a(getContext(), paramInt));
    }
  }
  
  public void setThumbStrokeWidth(float paramFloat)
  {
    this.a0.m0(paramFloat);
    postInvalidate();
  }
  
  public void setThumbStrokeWidthResource(int paramInt)
  {
    if (paramInt != 0) {
      setThumbStrokeWidth(getResources().getDimension(paramInt));
    }
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.a0.x())) {
      return;
    }
    this.a0.b0(paramColorStateList);
    invalidate();
  }
  
  public void setTickActiveTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.T)) {
      return;
    }
    this.T = paramColorStateList;
    this.f.setColor(D(paramColorStateList));
    invalidate();
  }
  
  public void setTickInactiveTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.U)) {
      return;
    }
    this.U = paramColorStateList;
    this.e.setColor(D(paramColorStateList));
    invalidate();
  }
  
  public void setTickTintList(ColorStateList paramColorStateList)
  {
    setTickInactiveTintList(paramColorStateList);
    setTickActiveTintList(paramColorStateList);
  }
  
  public void setTickVisible(boolean paramBoolean)
  {
    if (this.N != paramBoolean)
    {
      this.N = paramBoolean;
      postInvalidate();
    }
  }
  
  public void setTrackActiveTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.V)) {
      return;
    }
    this.V = paramColorStateList;
    this.b.setColor(D(paramColorStateList));
    invalidate();
  }
  
  public void setTrackHeight(int paramInt)
  {
    if (this.v != paramInt)
    {
      this.v = paramInt;
      G();
      postInvalidate();
    }
  }
  
  public void setTrackInactiveTintList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.equals(this.W)) {
      return;
    }
    this.W = paramColorStateList;
    this.a.setColor(D(paramColorStateList));
    invalidate();
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    setTrackInactiveTintList(paramColorStateList);
    setTrackActiveTintList(paramColorStateList);
  }
  
  public void setValueFrom(float paramFloat)
  {
    this.G = paramFloat;
    this.R = true;
    postInvalidate();
  }
  
  public void setValueTo(float paramFloat)
  {
    this.H = paramFloat;
    this.R = true;
    postInvalidate();
  }
  
  void setValues(List<Float> paramList)
  {
    setValuesInternal(new ArrayList(paramList));
  }
  
  void setValues(Float... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramVarArgs);
    setValuesInternal(localArrayList);
  }
  
  static class SliderState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SliderState> CREATOR = new a();
    float a;
    float b;
    ArrayList<Float> c;
    float d;
    boolean e;
    
    private SliderState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readFloat();
      this.b = paramParcel.readFloat();
      ArrayList localArrayList = new ArrayList();
      this.c = localArrayList;
      paramParcel.readList(localArrayList, Float.class.getClassLoader());
      this.d = paramParcel.readFloat();
      this.e = paramParcel.createBooleanArray()[0];
    }
    
    SliderState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.a);
      paramParcel.writeFloat(this.b);
      paramParcel.writeList(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeBooleanArray(new boolean[] { this.e });
    }
    
    class a
      implements Parcelable.Creator<BaseSlider.SliderState>
    {
      public BaseSlider.SliderState a(Parcel paramParcel)
      {
        return new BaseSlider.SliderState(paramParcel, null);
      }
      
      public BaseSlider.SliderState[] b(int paramInt)
      {
        return new BaseSlider.SliderState[paramInt];
      }
    }
  }
  
  class a
    implements BaseSlider.f
  {
    a(AttributeSet paramAttributeSet, int paramInt) {}
    
    public t7.a a()
    {
      TypedArray localTypedArray = p.h(BaseSlider.this.getContext(), paramAttributeSet, R.styleable.Slider, paramInt, BaseSlider.g0, new int[0]);
      t7.a locala = BaseSlider.a(BaseSlider.this.getContext(), localTypedArray);
      localTypedArray.recycle();
      return locala;
    }
  }
  
  class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      paramValueAnimator = BaseSlider.b(BaseSlider.this).iterator();
      while (paramValueAnimator.hasNext()) {
        ((t7.a)paramValueAnimator.next()).B0(f);
      }
      x.h0(BaseSlider.this);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      paramAnimator = BaseSlider.b(BaseSlider.this).iterator();
      while (paramAnimator.hasNext())
      {
        t7.a locala = (t7.a)paramAnimator.next();
        t.f(BaseSlider.this).b(locala);
      }
    }
  }
  
  private class d
    implements Runnable
  {
    int a = -1;
    
    private d() {}
    
    void a(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void run()
    {
      BaseSlider.c(BaseSlider.this).W(this.a, 4);
    }
  }
  
  private static class e
    extends c1.a
  {
    private final BaseSlider<?, ?, ?> q;
    final Rect r = new Rect();
    
    e(BaseSlider<?, ?, ?> paramBaseSlider)
    {
      super();
      this.q = paramBaseSlider;
    }
    
    private String Y(int paramInt)
    {
      Context localContext;
      if (paramInt == this.q.getValues().size() - 1) {
        localContext = this.q.getContext();
      }
      for (paramInt = R.string.material_slider_range_end;; paramInt = R.string.material_slider_range_start)
      {
        return localContext.getString(paramInt);
        if (paramInt != 0) {
          break;
        }
        localContext = this.q.getContext();
      }
      return "";
    }
    
    protected int B(float paramFloat1, float paramFloat2)
    {
      int i = 0;
      while (i < this.q.getValues().size())
      {
        this.q.h0(i, this.r);
        if (this.r.contains((int)paramFloat1, (int)paramFloat2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    protected void C(List<Integer> paramList)
    {
      int i = 0;
      while (i < this.q.getValues().size())
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }
    
    protected boolean L(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (!this.q.isEnabled()) {
        return false;
      }
      float f1;
      if ((paramInt2 != 4096) && (paramInt2 != 8192))
      {
        if (paramInt2 != 16908349) {
          return false;
        }
        if (paramBundle != null)
        {
          if (!paramBundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
            return false;
          }
          f1 = paramBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
          if (!BaseSlider.e(this.q, paramInt1, f1)) {}
        }
      }
      do
      {
        BaseSlider.f(this.q);
        this.q.postInvalidate();
        E(paramInt1);
        return true;
        return false;
        float f2 = BaseSlider.g(this.q, 20);
        f1 = f2;
        if (paramInt2 == 8192) {
          f1 = -f2;
        }
        f2 = f1;
        if (this.q.J()) {
          f2 = -f1;
        }
        f1 = t0.a.a(((Float)this.q.getValues().get(paramInt1)).floatValue() + f2, this.q.getValueFrom(), this.q.getValueTo());
      } while (BaseSlider.e(this.q, paramInt1, f1));
      return false;
    }
    
    protected void P(int paramInt, y0.d paramd)
    {
      paramd.b(d.a.L);
      List localList = this.q.getValues();
      float f1 = ((Float)localList.get(paramInt)).floatValue();
      float f2 = this.q.getValueFrom();
      float f3 = this.q.getValueTo();
      if (this.q.isEnabled())
      {
        if (f1 > f2) {
          paramd.a(8192);
        }
        if (f1 < f3) {
          paramd.a(4096);
        }
      }
      paramd.w0(d.d.a(1, f2, f3, f1));
      paramd.c0(SeekBar.class.getName());
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.q.getContentDescription() != null)
      {
        localStringBuilder.append(this.q.getContentDescription());
        localStringBuilder.append(",");
      }
      if (localList.size() > 1)
      {
        localStringBuilder.append(Y(paramInt));
        localStringBuilder.append(BaseSlider.d(this.q, f1));
      }
      paramd.g0(localStringBuilder.toString());
      this.q.h0(paramInt, this.r);
      paramd.X(this.r);
    }
  }
  
  private static abstract interface f
  {
    public abstract t7.a a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.slider.BaseSlider
 * JD-Core Version:    0.7.0.1
 */