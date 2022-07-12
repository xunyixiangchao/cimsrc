package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.material.R.color;
import java.util.ArrayList;
import java.util.List;
import r7.m;

class e
  extends d
{
  e(FloatingActionButton paramFloatingActionButton, q7.b paramb)
  {
    super(paramFloatingActionButton, paramb);
  }
  
  private Animator i0(float paramFloat1, float paramFloat2)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", new float[] { paramFloat1 }).setDuration(0L)).with(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[] { paramFloat2 }).setDuration(100L));
    localAnimatorSet.setInterpolator(d.D);
    return localAnimatorSet;
  }
  
  void B()
  {
    e0();
  }
  
  void D(int[] paramArrayOfInt) {}
  
  void E(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = Build.VERSION.SDK_INT;
    StateListAnimator localStateListAnimator = new StateListAnimator();
    localStateListAnimator.addState(d.E, i0(paramFloat1, paramFloat3));
    localStateListAnimator.addState(d.F, i0(paramFloat1, paramFloat2));
    localStateListAnimator.addState(d.G, i0(paramFloat1, paramFloat2));
    localStateListAnimator.addState(d.H, i0(paramFloat1, paramFloat2));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this.w, "elevation", new float[] { paramFloat1 }).setDuration(0L));
    if (i <= 24)
    {
      FloatingActionButton localFloatingActionButton = this.w;
      localArrayList.add(ObjectAnimator.ofFloat(localFloatingActionButton, View.TRANSLATION_Z, new float[] { localFloatingActionButton.getTranslationZ() }).setDuration(100L));
    }
    localArrayList.add(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[] { 0.0F }).setDuration(100L));
    localAnimatorSet.playSequentially((Animator[])localArrayList.toArray(new Animator[0]));
    localAnimatorSet.setInterpolator(d.D);
    localStateListAnimator.addState(d.I, localAnimatorSet);
    localStateListAnimator.addState(d.J, i0(0.0F, 0.0F));
    this.w.setStateListAnimator(localStateListAnimator);
    if (Y()) {
      e0();
    }
  }
  
  boolean J()
  {
    return false;
  }
  
  void U(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = this.c;
    if ((localDrawable instanceof RippleDrawable))
    {
      ((RippleDrawable)localDrawable).setColor(p7.b.d(paramColorStateList));
      return;
    }
    super.U(paramColorStateList);
  }
  
  boolean Y()
  {
    return (this.x.c()) || (!a0());
  }
  
  void c0() {}
  
  c h0(int paramInt, ColorStateList paramColorStateList)
  {
    Context localContext = this.w.getContext();
    c localc = new c((m)x0.h.g(this.a));
    localc.e(androidx.core.content.b.b(localContext, R.color.design_fab_stroke_top_outer_color), androidx.core.content.b.b(localContext, R.color.design_fab_stroke_top_inner_color), androidx.core.content.b.b(localContext, R.color.design_fab_stroke_end_inner_color), androidx.core.content.b.b(localContext, R.color.design_fab_stroke_end_outer_color));
    localc.d(paramInt);
    localc.c(paramColorStateList);
    return localc;
  }
  
  r7.h j0()
  {
    return new a((m)x0.h.g(this.a));
  }
  
  public float m()
  {
    return this.w.getElevation();
  }
  
  void r(Rect paramRect)
  {
    if (this.x.c())
    {
      super.r(paramRect);
      return;
    }
    int i;
    if (!a0()) {
      i = (this.k - this.w.getSizeDimension()) / 2;
    } else {
      i = 0;
    }
    paramRect.set(i, i, i, i);
  }
  
  void w(ColorStateList paramColorStateList1, PorterDuff.Mode paramMode, ColorStateList paramColorStateList2, int paramInt)
  {
    r7.h localh = j0();
    this.b = localh;
    localh.setTintList(paramColorStateList1);
    if (paramMode != null) {
      this.b.setTintMode(paramMode);
    }
    this.b.Q(this.w.getContext());
    if (paramInt > 0)
    {
      this.d = h0(paramInt, paramColorStateList1);
      paramColorStateList1 = new LayerDrawable(new Drawable[] { (Drawable)x0.h.g(this.d), (Drawable)x0.h.g(this.b) });
    }
    else
    {
      this.d = null;
      paramColorStateList1 = this.b;
    }
    paramColorStateList1 = new RippleDrawable(p7.b.d(paramColorStateList2), paramColorStateList1, null);
    this.c = paramColorStateList1;
    this.e = paramColorStateList1;
  }
  
  void z() {}
  
  static class a
    extends r7.h
  {
    a(m paramm)
    {
      super();
    }
    
    public boolean isStateful()
    {
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.e
 * JD-Core Version:    0.7.0.1
 */