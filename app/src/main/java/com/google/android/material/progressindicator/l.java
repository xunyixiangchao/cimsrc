package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.d;
import com.google.android.material.R.animator;
import g7.a;
import java.util.Arrays;

final class l
  extends h<ObjectAnimator>
{
  private static final int[] l = { 533, 567, 850, 750 };
  private static final int[] m = { 1267, 1000, 333, 0 };
  private static final Property<l, Float> n = new c(Float.class, "animationFraction");
  private ObjectAnimator d;
  private ObjectAnimator e;
  private final Interpolator[] f;
  private final b g;
  private int h = 0;
  private boolean i;
  private float j;
  androidx.vectordrawable.graphics.drawable.b k = null;
  
  public l(Context paramContext, LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(2);
    this.g = paramLinearProgressIndicatorSpec;
    this.f = new Interpolator[] { d.a(paramContext, R.animator.linear_indeterminate_line1_head_interpolator), d.a(paramContext, R.animator.linear_indeterminate_line1_tail_interpolator), d.a(paramContext, R.animator.linear_indeterminate_line2_head_interpolator), d.a(paramContext, R.animator.linear_indeterminate_line2_tail_interpolator) };
  }
  
  private float n()
  {
    return this.j;
  }
  
  private void o()
  {
    ObjectAnimator localObjectAnimator;
    if (this.d == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, n, new float[] { 0.0F, 1.0F });
      this.d = localObjectAnimator;
      localObjectAnimator.setDuration(1800L);
      this.d.setInterpolator(null);
      this.d.setRepeatCount(-1);
      this.d.addListener(new a());
    }
    if (this.e == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, n, new float[] { 1.0F });
      this.e = localObjectAnimator;
      localObjectAnimator.setDuration(1800L);
      this.e.setInterpolator(null);
      this.e.addListener(new b());
    }
  }
  
  private void p()
  {
    if (this.i)
    {
      Arrays.fill(this.c, a.a(this.g.c[this.h], this.a.getAlpha()));
      this.i = false;
    }
  }
  
  private void s(int paramInt)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      float f1 = b(paramInt, m[i1], l[i1]);
      f1 = this.f[i1].getInterpolation(f1);
      this.b[i1] = Math.max(0.0F, Math.min(1.0F, f1));
      i1 += 1;
    }
  }
  
  public void a()
  {
    ObjectAnimator localObjectAnimator = this.d;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c()
  {
    q();
  }
  
  public void d(androidx.vectordrawable.graphics.drawable.b paramb)
  {
    this.k = paramb;
  }
  
  public void f()
  {
    ObjectAnimator localObjectAnimator = this.e;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        return;
      }
      a();
      if (this.a.isVisible())
      {
        this.e.setFloatValues(new float[] { this.j, 1.0F });
        this.e.setDuration(((1.0F - this.j) * 1800.0F));
        this.e.start();
      }
    }
  }
  
  public void g()
  {
    o();
    q();
    this.d.start();
  }
  
  public void h()
  {
    this.k = null;
  }
  
  void q()
  {
    this.h = 0;
    int i1 = a.a(this.g.c[0], this.a.getAlpha());
    int[] arrayOfInt = this.c;
    arrayOfInt[0] = i1;
    arrayOfInt[1] = i1;
  }
  
  void r(float paramFloat)
  {
    this.j = paramFloat;
    s((int)(paramFloat * 1800.0F));
    p();
    this.a.invalidateSelf();
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      super.onAnimationRepeat(paramAnimator);
      paramAnimator = l.this;
      l.j(paramAnimator, (l.i(paramAnimator) + 1) % l.k(l.this).c.length);
      l.l(l.this, true);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      l.this.a();
      paramAnimator = l.this;
      androidx.vectordrawable.graphics.drawable.b localb = paramAnimator.k;
      if (localb != null) {
        localb.a(paramAnimator.a);
      }
    }
  }
  
  class c
    extends Property<l, Float>
  {
    c(String paramString)
    {
      super(paramString);
    }
    
    public Float a(l paraml)
    {
      return Float.valueOf(l.m(paraml));
    }
    
    public void b(l paraml, Float paramFloat)
    {
      paraml.r(paramFloat.floatValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.l
 * JD-Core Version:    0.7.0.1
 */