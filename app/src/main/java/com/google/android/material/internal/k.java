package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

public final class k
{
  private final ArrayList<b> a = new ArrayList();
  private b b = null;
  ValueAnimator c = null;
  private final Animator.AnimatorListener d = new a();
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new b(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.d);
    this.a.add(paramArrayOfInt);
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      k localk = k.this;
      if (localk.c == paramAnimator) {
        localk.c = null;
      }
    }
  }
  
  static class b
  {
    final int[] a;
    final ValueAnimator b;
    
    b(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
    {
      this.a = paramArrayOfInt;
      this.b = paramValueAnimator;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.k
 * JD-Core Version:    0.7.0.1
 */