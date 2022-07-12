package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

class a
{
  private Animator a;
  
  public void a()
  {
    Animator localAnimator = this.a;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public void c(Animator paramAnimator)
  {
    a();
    this.a = paramAnimator;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.floatingactionbutton.a
 * JD-Core Version:    0.7.0.1
 */