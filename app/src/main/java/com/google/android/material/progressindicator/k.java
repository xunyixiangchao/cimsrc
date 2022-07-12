package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import g7.a;
import java.util.Arrays;

final class k
  extends h<ObjectAnimator>
{
  private static final Property<k, Float> j = new b(Float.class, "animationFraction");
  private ObjectAnimator d;
  private i1.b e;
  private final b f;
  private int g = 1;
  private boolean h;
  private float i;
  
  public k(LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(3);
    this.f = paramLinearProgressIndicatorSpec;
    this.e = new i1.b();
  }
  
  private float n()
  {
    return this.i;
  }
  
  private void o()
  {
    if (this.d == null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, j, new float[] { 0.0F, 1.0F });
      this.d = localObjectAnimator;
      localObjectAnimator.setDuration(333L);
      this.d.setInterpolator(null);
      this.d.setRepeatCount(-1);
      this.d.addListener(new a());
    }
  }
  
  private void p()
  {
    if ((this.h) && (this.b[3] < 1.0F))
    {
      int[] arrayOfInt = this.c;
      arrayOfInt[2] = arrayOfInt[1];
      arrayOfInt[1] = arrayOfInt[0];
      arrayOfInt[0] = a.a(this.f.c[this.g], this.a.getAlpha());
      this.h = false;
    }
  }
  
  private void s(int paramInt)
  {
    this.b[0] = 0.0F;
    float f1 = b(paramInt, 0, 667);
    float[] arrayOfFloat = this.b;
    float f2 = this.e.getInterpolation(f1);
    arrayOfFloat[2] = f2;
    arrayOfFloat[1] = f2;
    arrayOfFloat = this.b;
    f1 = this.e.getInterpolation(f1 + 0.4992504F);
    arrayOfFloat[4] = f1;
    arrayOfFloat[3] = f1;
    this.b[5] = 1.0F;
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
  
  public void d(androidx.vectordrawable.graphics.drawable.b paramb) {}
  
  public void f() {}
  
  public void g()
  {
    o();
    q();
    this.d.start();
  }
  
  public void h() {}
  
  void q()
  {
    this.h = true;
    this.g = 1;
    Arrays.fill(this.c, a.a(this.f.c[0], this.a.getAlpha()));
  }
  
  void r(float paramFloat)
  {
    this.i = paramFloat;
    s((int)(paramFloat * 333.0F));
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
      paramAnimator = k.this;
      k.j(paramAnimator, (k.i(paramAnimator) + 1) % k.k(k.this).c.length);
      k.l(k.this, true);
    }
  }
  
  class b
    extends Property<k, Float>
  {
    b(String paramString)
    {
      super(paramString);
    }
    
    public Float a(k paramk)
    {
      return Float.valueOf(k.m(paramk));
    }
    
    public void b(k paramk, Float paramFloat)
    {
      paramk.r(paramFloat.floatValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.k
 * JD-Core Version:    0.7.0.1
 */