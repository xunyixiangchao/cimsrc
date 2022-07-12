package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e7.b;
import e7.i;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior
  extends ExpandableTransformationBehavior
{
  private final i c = new i(75L, 150L);
  private final i d = new i(0L, 150L);
  
  public FabTransformationScrimBehavior() {}
  
  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void K(View paramView, boolean paramBoolean1, boolean paramBoolean2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (paramBoolean1) {
      paramList1 = this.c;
    } else {
      paramList1 = this.d;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        paramView.setAlpha(0.0F);
      }
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F });
    }
    else
    {
      paramView = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F });
    }
    paramList1.a(paramView);
    paramList.add(paramView);
  }
  
  public boolean D(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return super.D(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
  
  protected AnimatorSet J(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    paramView1 = new ArrayList();
    K(paramView2, paramBoolean1, paramBoolean2, paramView1, new ArrayList());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    b.a(localAnimatorSet, paramView1);
    localAnimatorSet.addListener(new a(paramBoolean1, paramView2));
    return localAnimatorSet;
  }
  
  public boolean e(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(boolean paramBoolean, View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!paramBoolean1) {
        paramView2.setVisibility(4);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (paramBoolean1) {
        paramView2.setVisibility(0);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.transformation.FabTransformationScrimBehavior
 * JD-Core Version:    0.7.0.1
 */