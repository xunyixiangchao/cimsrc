package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import e7.a;

public class HideBottomViewOnScrollBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private int a = 0;
  private int b = 2;
  private int c = 0;
  private ViewPropertyAnimator d;
  
  public HideBottomViewOnScrollBehavior() {}
  
  public HideBottomViewOnScrollBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void F(V paramV, int paramInt, long paramLong, TimeInterpolator paramTimeInterpolator)
  {
    this.d = paramV.animate().translationY(paramInt).setInterpolator(paramTimeInterpolator).setDuration(paramLong).setListener(new a());
  }
  
  public boolean A(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    return paramInt1 == 2;
  }
  
  public boolean G()
  {
    return this.b == 1;
  }
  
  public boolean H()
  {
    return this.b == 2;
  }
  
  public void I(V paramV, int paramInt)
  {
    this.c = paramInt;
    if (this.b == 1) {
      paramV.setTranslationY(this.a + paramInt);
    }
  }
  
  public void J(V paramV)
  {
    K(paramV, true);
  }
  
  public void K(V paramV, boolean paramBoolean)
  {
    if (G()) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.d;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    this.b = 1;
    int i = this.a + this.c;
    if (paramBoolean)
    {
      F(paramV, i, 175L, a.c);
      return;
    }
    paramV.setTranslationY(i);
  }
  
  public void L(V paramV)
  {
    M(paramV, true);
  }
  
  public void M(V paramV, boolean paramBoolean)
  {
    if (H()) {
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = this.d;
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator.cancel();
      paramV.clearAnimation();
    }
    this.b = 2;
    if (paramBoolean)
    {
      F(paramV, 0, 225L, a.d);
      return;
    }
    paramV.setTranslationY(0);
  }
  
  public boolean l(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramV.getLayoutParams();
    this.a = (paramV.getMeasuredHeight() + localMarginLayoutParams.bottomMargin);
    return super.l(paramCoordinatorLayout, paramV, paramInt);
  }
  
  public void t(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt2 > 0)
    {
      J(paramV);
      return;
    }
    if (paramInt2 < 0) {
      L(paramV);
    }
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      HideBottomViewOnScrollBehavior.E(HideBottomViewOnScrollBehavior.this, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.behavior.HideBottomViewOnScrollBehavior
 * JD-Core Version:    0.7.0.1
 */