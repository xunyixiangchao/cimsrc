package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

public final class a
{
  public static Animator a(c paramc, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramc, c.c.a, c.b.b, new c.e[] { new c.e(paramFloat1, paramFloat2, paramFloat3) });
    Object localObject = paramc.getRevealInfo();
    if (localObject != null)
    {
      float f = ((c.e)localObject).c;
      paramc = ViewAnimationUtils.createCircularReveal((View)paramc, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator, paramc });
      return localObject;
    }
    throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
  }
  
  public static Animator.AnimatorListener b(c paramc)
  {
    return new a();
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      a.this.b();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      a.this.e();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.circularreveal.a
 * JD-Core Version:    0.7.0.1
 */