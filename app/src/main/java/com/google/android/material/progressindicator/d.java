package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import e7.c;
import g7.a;

final class d
  extends h<ObjectAnimator>
{
  private static final int[] l = { 0, 1350, 2700, 4050 };
  private static final int[] m = { 667, 2017, 3367, 4717 };
  private static final int[] n = { 1000, 2350, 3700, 5050 };
  private static final Property<d, Float> o = new c(Float.class, "animationFraction");
  private static final Property<d, Float> p = new d(Float.class, "completeEndFraction");
  private ObjectAnimator d;
  private ObjectAnimator e;
  private final i1.b f;
  private final b g;
  private int h = 0;
  private float i;
  private float j;
  androidx.vectordrawable.graphics.drawable.b k = null;
  
  public d(CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    super(1);
    this.g = paramCircularProgressIndicatorSpec;
    this.f = new i1.b();
  }
  
  private float o()
  {
    return this.i;
  }
  
  private float p()
  {
    return this.j;
  }
  
  private void q()
  {
    ObjectAnimator localObjectAnimator;
    if (this.d == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, o, new float[] { 0.0F, 1.0F });
      this.d = localObjectAnimator;
      localObjectAnimator.setDuration(5400L);
      this.d.setInterpolator(null);
      this.d.setRepeatCount(-1);
      this.d.addListener(new a());
    }
    if (this.e == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, p, new float[] { 0.0F, 1.0F });
      this.e = localObjectAnimator;
      localObjectAnimator.setDuration(333L);
      this.e.setInterpolator(this.f);
      this.e.addListener(new b());
    }
  }
  
  private void r(int paramInt)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      float f1 = b(paramInt, n[i1], 333);
      if ((f1 >= 0.0F) && (f1 <= 1.0F))
      {
        paramInt = this.h;
        int[] arrayOfInt = this.g.c;
        i1 = (i1 + paramInt) % arrayOfInt.length;
        int i2 = arrayOfInt.length;
        paramInt = a.a(arrayOfInt[i1], this.a.getAlpha());
        i1 = a.a(this.g.c[((i1 + 1) % i2)], this.a.getAlpha());
        f1 = this.f.getInterpolation(f1);
        this.c[0] = c.b().a(f1, Integer.valueOf(paramInt), Integer.valueOf(i1)).intValue();
        return;
      }
      i1 += 1;
    }
  }
  
  private void u(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  private void v(int paramInt)
  {
    float[] arrayOfFloat = this.b;
    float f1 = this.i;
    arrayOfFloat[0] = (f1 * 1520.0F - 20.0F);
    arrayOfFloat[1] = (f1 * 1520.0F);
    int i1 = 0;
    while (i1 < 4)
    {
      f1 = b(paramInt, l[i1], 667);
      arrayOfFloat = this.b;
      arrayOfFloat[1] += this.f.getInterpolation(f1) * 250.0F;
      f1 = b(paramInt, m[i1], 667);
      arrayOfFloat = this.b;
      arrayOfFloat[0] += this.f.getInterpolation(f1) * 250.0F;
      i1 += 1;
    }
    arrayOfFloat = this.b;
    arrayOfFloat[0] += (arrayOfFloat[1] - arrayOfFloat[0]) * this.j;
    arrayOfFloat[0] /= 360.0F;
    arrayOfFloat[1] /= 360.0F;
  }
  
  void a()
  {
    ObjectAnimator localObjectAnimator = this.d;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c()
  {
    s();
  }
  
  public void d(androidx.vectordrawable.graphics.drawable.b paramb)
  {
    this.k = paramb;
  }
  
  void f()
  {
    ObjectAnimator localObjectAnimator = this.e;
    if (localObjectAnimator != null)
    {
      if (localObjectAnimator.isRunning()) {
        return;
      }
      if (this.a.isVisible())
      {
        this.e.start();
        return;
      }
      a();
    }
  }
  
  void g()
  {
    q();
    s();
    this.d.start();
  }
  
  public void h()
  {
    this.k = null;
  }
  
  void s()
  {
    this.h = 0;
    this.c[0] = a.a(this.g.c[0], this.a.getAlpha());
    this.j = 0.0F;
  }
  
  void t(float paramFloat)
  {
    this.i = paramFloat;
    int i1 = (int)(paramFloat * 5400.0F);
    v(i1);
    r(i1);
    this.a.invalidateSelf();
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      super.onAnimationRepeat(paramAnimator);
      paramAnimator = d.this;
      d.j(paramAnimator, (d.i(paramAnimator) + 4) % d.k(d.this).c.length);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      d.this.a();
      paramAnimator = d.this;
      androidx.vectordrawable.graphics.drawable.b localb = paramAnimator.k;
      if (localb != null) {
        localb.a(paramAnimator.a);
      }
    }
  }
  
  class c
    extends Property<d, Float>
  {
    c(String paramString)
    {
      super(paramString);
    }
    
    public Float a(d paramd)
    {
      return Float.valueOf(d.l(paramd));
    }
    
    public void b(d paramd, Float paramFloat)
    {
      paramd.t(paramFloat.floatValue());
    }
  }
  
  class d
    extends Property<d, Float>
  {
    d(String paramString)
    {
      super(paramString);
    }
    
    public Float a(d paramd)
    {
      return Float.valueOf(d.m(paramd));
    }
    
    public void b(d paramd, Float paramFloat)
    {
      d.n(paramd, paramFloat.floatValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.d
 * JD-Core Version:    0.7.0.1
 */