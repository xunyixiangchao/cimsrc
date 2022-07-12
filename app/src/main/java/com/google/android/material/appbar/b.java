package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.R.attr;
import com.google.android.material.R.integer;
import com.google.android.material.internal.p;

class b
{
  private static final int[] a = { 16843848 };
  
  static void a(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }
  
  static void b(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int j = R.attr.state_liftable;
    int k = -R.attr.state_lifted;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F });
    long l = i;
    localObjectAnimator = localObjectAnimator.setDuration(l);
    localStateListAnimator.addState(new int[] { 16842910, j, k }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(l);
    localStateListAnimator.addState(new int[] { 16842910 }, localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L);
    localStateListAnimator.addState(new int[0], localObjectAnimator);
    paramView.setStateListAnimator(localStateListAnimator);
  }
  
  static void c(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Context localContext = paramView.getContext();
    paramAttributeSet = p.h(localContext, paramAttributeSet, a, paramInt1, paramInt2, new int[0]);
    try
    {
      if (paramAttributeSet.hasValue(0)) {
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, paramAttributeSet.getResourceId(0, 0)));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.b
 * JD-Core Version:    0.7.0.1
 */