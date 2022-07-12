package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract class ExpandableTransformationBehavior
  extends ExpandableBehavior
{
  private AnimatorSet b;
  
  public ExpandableTransformationBehavior() {}
  
  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean H(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AnimatorSet localAnimatorSet = this.b;
    boolean bool;
    if (localAnimatorSet != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      localAnimatorSet.cancel();
    }
    paramView1 = J(paramView1, paramView2, paramBoolean1, bool);
    this.b = paramView1;
    paramView1.addListener(new a());
    this.b.start();
    if (!paramBoolean2) {
      this.b.end();
    }
    return true;
  }
  
  protected abstract AnimatorSet J(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      ExpandableTransformationBehavior.I(ExpandableTransformationBehavior.this, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.transformation.ExpandableTransformationBehavior
 * JD-Core Version:    0.7.0.1
 */