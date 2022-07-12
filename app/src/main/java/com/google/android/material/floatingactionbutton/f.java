package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import e7.h;
import java.util.List;

abstract interface f
{
  public abstract int a();
  
  public abstract void b();
  
  public abstract h c();
  
  public abstract AnimatorSet d();
  
  public abstract List<Animator.AnimatorListener> e();
  
  public abstract void f(ExtendedFloatingActionButton.j paramj);
  
  public abstract boolean g();
  
  public abstract void h(h paramh);
  
  public abstract void onAnimationCancel();
  
  public abstract void onAnimationEnd();
  
  public abstract void onAnimationStart(Animator paramAnimator);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.f
 * JD-Core Version:    0.7.0.1
 */