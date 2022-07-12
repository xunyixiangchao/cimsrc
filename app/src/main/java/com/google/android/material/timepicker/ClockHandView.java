package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClockHandView
  extends View
{
  private ValueAnimator a;
  private boolean b;
  private float c;
  private float d;
  private boolean e;
  private int f;
  private final List<d> g = new ArrayList();
  private final int h;
  private final float i;
  private final Paint j;
  private final RectF k;
  private final int l;
  private float m;
  private boolean n;
  private c o;
  private double p;
  private int q;
  
  public ClockHandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialClockStyle);
  }
  
  public ClockHandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Paint localPaint = new Paint();
    this.j = localPaint;
    this.k = new RectF();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ClockHandView, paramInt, R.style.Widget_MaterialComponents_TimePicker_Clock);
    this.q = paramAttributeSet.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
    this.h = paramAttributeSet.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
    Resources localResources = getResources();
    this.l = localResources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
    this.i = localResources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
    paramInt = paramAttributeSet.getColor(R.styleable.ClockHandView_clockHandColor, 0);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt);
    k(0.0F);
    this.f = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    x.B0(this, 2);
    paramAttributeSet.recycle();
  }
  
  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = getWidth() / 2;
    float f1 = i2;
    float f3 = this.q;
    float f4 = (float)Math.cos(this.p);
    float f2 = i1;
    float f5 = this.q;
    float f6 = (float)Math.sin(this.p);
    this.j.setStrokeWidth(0.0F);
    paramCanvas.drawCircle(f3 * f4 + f1, f5 * f6 + f2, this.h, this.j);
    double d1 = Math.sin(this.p);
    double d2 = Math.cos(this.p);
    double d3 = this.q - this.h;
    f3 = i2 + (int)(d2 * d3);
    f4 = i1 + (int)(d3 * d1);
    this.j.setStrokeWidth(this.l);
    paramCanvas.drawLine(f1, f2, f3, f4, this.j);
    paramCanvas.drawCircle(f1, f2, this.i, this.j);
  }
  
  private int e(float paramFloat1, float paramFloat2)
  {
    int i1 = getWidth() / 2;
    int i2 = getHeight() / 2;
    double d1 = paramFloat1 - i1;
    i2 = (int)Math.toDegrees(Math.atan2(paramFloat2 - i2, d1)) + 90;
    i1 = i2;
    if (i2 < 0) {
      i1 = i2 + 360;
    }
    return i1;
  }
  
  private Pair<Float, Float> h(float paramFloat)
  {
    float f4 = f();
    float f3 = f4;
    float f2 = paramFloat;
    if (Math.abs(f4 - paramFloat) > 180.0F)
    {
      float f1 = paramFloat;
      if (f4 > 180.0F)
      {
        f1 = paramFloat;
        if (paramFloat < 180.0F) {
          f1 = paramFloat + 360.0F;
        }
      }
      f3 = f4;
      f2 = f1;
      if (f4 < 180.0F)
      {
        f3 = f4;
        f2 = f1;
        if (f1 > 180.0F)
        {
          f3 = f4 + 360.0F;
          f2 = f1;
        }
      }
    }
    return new Pair(Float.valueOf(f3), Float.valueOf(f2));
  }
  
  private boolean i(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = e(paramFloat1, paramFloat2);
    paramFloat1 = f();
    paramFloat2 = i1;
    boolean bool = false;
    if (paramFloat1 != paramFloat2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramBoolean2) && (i1 != 0)) {
      return true;
    }
    if ((i1 == 0) && (!paramBoolean1)) {
      return false;
    }
    paramBoolean1 = bool;
    if (paramBoolean3)
    {
      paramBoolean1 = bool;
      if (this.b) {
        paramBoolean1 = true;
      }
    }
    l(paramFloat2, paramBoolean1);
    return true;
  }
  
  private void m(float paramFloat, boolean paramBoolean)
  {
    paramFloat %= 360.0F;
    this.m = paramFloat;
    this.p = Math.toRadians(paramFloat - 90.0F);
    int i1 = getHeight() / 2;
    float f1 = getWidth() / 2 + this.q * (float)Math.cos(this.p);
    float f2 = i1 + this.q * (float)Math.sin(this.p);
    Object localObject = this.k;
    i1 = this.h;
    ((RectF)localObject).set(f1 - i1, f2 - i1, f1 + i1, f2 + i1);
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((d)((Iterator)localObject).next()).a(paramFloat, paramBoolean);
    }
    invalidate();
  }
  
  public void b(d paramd)
  {
    this.g.add(paramd);
  }
  
  public RectF d()
  {
    return this.k;
  }
  
  public float f()
  {
    return this.m;
  }
  
  public int g()
  {
    return this.h;
  }
  
  public void j(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
  
  public void k(float paramFloat)
  {
    l(paramFloat, false);
  }
  
  public void l(float paramFloat, boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    if (!paramBoolean)
    {
      m(paramFloat, false);
      return;
    }
    localObject = h(paramFloat);
    localObject = ValueAnimator.ofFloat(new float[] { ((Float)((Pair)localObject).first).floatValue(), ((Float)((Pair)localObject).second).floatValue() });
    this.a = ((ValueAnimator)localObject);
    ((ValueAnimator)localObject).setDuration(200L);
    this.a.addUpdateListener(new a());
    this.a.addListener(new b());
    this.a.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    c(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    k(f());
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool1;
    boolean bool3;
    if (i1 != 0)
    {
      if ((i1 != 1) && (i1 != 2))
      {
        bool1 = false;
        bool2 = bool1;
        bool3 = bool2;
      }
      else
      {
        int i2 = (int)(f1 - this.c);
        int i3 = (int)(f2 - this.d);
        if (i2 * i2 + i3 * i3 > this.f) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.e = bool1;
        bool2 = this.n;
        if (i1 == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool3 = false;
      }
    }
    else
    {
      this.c = f1;
      this.d = f2;
      this.e = true;
      this.n = false;
      bool1 = false;
      bool2 = bool1;
      bool3 = true;
    }
    boolean bool4 = this.n;
    boolean bool2 = i(f1, f2, bool2, bool3, bool1) | bool4;
    this.n = bool2;
    if ((bool2) && (bool1))
    {
      paramMotionEvent = this.o;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(e(f1, f2), this.e);
      }
    }
    return true;
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      ClockHandView.a(ClockHandView.this, f, true);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      paramAnimator.end();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(float paramFloat, boolean paramBoolean);
  }
  
  public static abstract interface d
  {
    public abstract void a(float paramFloat, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.timepicker.ClockHandView
 * JD-Core Version:    0.7.0.1
 */