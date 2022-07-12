package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class f
  extends Drawable
  implements Animatable
{
  private static final Property<f, Float> o = new c(Float.class, "growFraction");
  final Context a;
  final b b;
  n7.a c;
  private ValueAnimator d;
  private ValueAnimator e;
  private boolean f;
  private boolean g;
  private float h;
  private List<androidx.vectordrawable.graphics.drawable.b> i;
  private androidx.vectordrawable.graphics.drawable.b j;
  private boolean k;
  private float l;
  final Paint m = new Paint();
  private int n;
  
  f(Context paramContext, b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = new n7.a();
    setAlpha(255);
  }
  
  private void d()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((androidx.vectordrawable.graphics.drawable.b)localObject).a(this);
    }
    localObject = this.i;
    if ((localObject != null) && (!this.k))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((androidx.vectordrawable.graphics.drawable.b)((Iterator)localObject).next()).a(this);
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((androidx.vectordrawable.graphics.drawable.b)localObject).b(this);
    }
    localObject = this.i;
    if ((localObject != null) && (!this.k))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((androidx.vectordrawable.graphics.drawable.b)((Iterator)localObject).next()).b(this);
      }
    }
  }
  
  private void f(ValueAnimator... paramVarArgs)
  {
    boolean bool = this.k;
    this.k = true;
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramVarArgs[i1].end();
      i1 += 1;
    }
    this.k = bool;
  }
  
  private void k()
  {
    ObjectAnimator localObjectAnimator;
    if (this.d == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, o, new float[] { 0.0F, 1.0F });
      this.d = localObjectAnimator;
      localObjectAnimator.setDuration(500L);
      this.d.setInterpolator(e7.a.b);
      o(this.d);
    }
    if (this.e == null)
    {
      localObjectAnimator = ObjectAnimator.ofFloat(this, o, new float[] { 1.0F, 0.0F });
      this.e = localObjectAnimator;
      localObjectAnimator.setDuration(500L);
      this.e.setInterpolator(e7.a.b);
      n(this.e);
    }
  }
  
  private void n(ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.e;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }
    this.e = paramValueAnimator;
    paramValueAnimator.addListener(new b());
  }
  
  private void o(ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.d;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }
    this.d = paramValueAnimator;
    paramValueAnimator.addListener(new a());
  }
  
  float g()
  {
    if ((!this.b.b()) && (!this.b.a())) {
      return 1.0F;
    }
    if ((!this.g) && (!this.f)) {
      return this.l;
    }
    return this.h;
  }
  
  public int getAlpha()
  {
    return this.n;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean h()
  {
    return p(false, false, false);
  }
  
  public boolean i()
  {
    ValueAnimator localValueAnimator = this.e;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.g);
  }
  
  public boolean isRunning()
  {
    return (j()) || (i());
  }
  
  public boolean j()
  {
    ValueAnimator localValueAnimator = this.d;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.f);
  }
  
  public void l(androidx.vectordrawable.graphics.drawable.b paramb)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    if (!this.i.contains(paramb)) {
      this.i.add(paramb);
    }
  }
  
  void m(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      this.l = paramFloat;
      invalidateSelf();
    }
  }
  
  public boolean p(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    float f1 = this.c.a(this.a.getContentResolver());
    if ((paramBoolean3) && (f1 > 0.0F)) {
      paramBoolean3 = true;
    } else {
      paramBoolean3 = false;
    }
    return q(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  boolean q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    k();
    if ((!isVisible()) && (!paramBoolean1)) {
      return false;
    }
    ValueAnimator localValueAnimator;
    if (paramBoolean1) {
      localValueAnimator = this.d;
    } else {
      localValueAnimator = this.e;
    }
    if (!paramBoolean3)
    {
      if (localValueAnimator.isRunning()) {
        localValueAnimator.end();
      } else {
        f(new ValueAnimator[] { localValueAnimator });
      }
      return super.setVisible(paramBoolean1, false);
    }
    if ((paramBoolean3) && (localValueAnimator.isRunning())) {
      return false;
    }
    if ((paramBoolean1) && (!super.setVisible(paramBoolean1, false))) {
      paramBoolean3 = false;
    } else {
      paramBoolean3 = true;
    }
    if (paramBoolean1) {
      paramBoolean1 = this.b.b();
    } else {
      paramBoolean1 = this.b.a();
    }
    if (!paramBoolean1)
    {
      f(new ValueAnimator[] { localValueAnimator });
      return paramBoolean3;
    }
    if ((!paramBoolean2) && (localValueAnimator.isPaused()))
    {
      localValueAnimator.resume();
      return paramBoolean3;
    }
    localValueAnimator.start();
    return paramBoolean3;
  }
  
  public boolean r(androidx.vectordrawable.graphics.drawable.b paramb)
  {
    List localList = this.i;
    if ((localList != null) && (localList.contains(paramb)))
    {
      this.i.remove(paramb);
      if (this.i.isEmpty()) {
        this.i = null;
      }
      return true;
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.n = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.m.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return p(paramBoolean1, paramBoolean2, true);
  }
  
  public void start()
  {
    q(true, true, false);
  }
  
  public void stop()
  {
    q(false, true, false);
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      super.onAnimationStart(paramAnimator);
      f.a(f.this);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      super.onAnimationEnd(paramAnimator);
      f.b(f.this, false, false);
      f.c(f.this);
    }
  }
  
  class c
    extends Property<f, Float>
  {
    c(String paramString)
    {
      super(paramString);
    }
    
    public Float a(f paramf)
    {
      return Float.valueOf(paramf.g());
    }
    
    public void b(f paramf, Float paramFloat)
    {
      paramf.m(paramFloat.floatValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.progressindicator.f
 * JD-Core Version:    0.7.0.1
 */