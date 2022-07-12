package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

public class SwipeDismissTouchListener
  implements View.OnTouchListener
{
  private int a;
  private int b;
  private int c;
  private long d;
  private View e;
  private DismissCallbacks f;
  private int g = 1;
  private float h;
  private float i;
  private boolean j;
  private int k;
  private Object l;
  private VelocityTracker m;
  private float n;
  private boolean o;
  private boolean p;
  
  public SwipeDismissTouchListener(View paramView, Object paramObject, DismissCallbacks paramDismissCallbacks)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramView.getContext());
    this.a = localViewConfiguration.getScaledTouchSlop();
    this.b = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.d = paramView.getContext().getResources().getInteger(17694720);
    this.e = paramView;
    paramView.getContext();
    this.l = paramObject;
    this.f = paramDismissCallbacks;
  }
  
  @TargetApi(11)
  private void a()
  {
    final ViewGroup.LayoutParams localLayoutParams = this.e.getLayoutParams();
    final int i1 = this.e.getHeight();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, 1 }).setDuration(this.d);
    localValueAnimator.addListener(new b(localLayoutParams, i1));
    localValueAnimator.addUpdateListener(new c(localLayoutParams));
    localValueAnimator.start();
  }
  
  @TargetApi(12)
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent.offsetLocation(this.n, 0.0F);
    if (this.g < 2) {
      this.g = this.e.getWidth();
    }
    int i4 = paramMotionEvent.getActionMasked();
    int i3 = 1;
    int i1 = 1;
    if (i4 != 0)
    {
      if (i4 != 1) {
        if (i4 != 2)
        {
          if (i4 != 3) {
            return false;
          }
          if (this.m == null) {
            return false;
          }
        }
      }
      for (;;)
      {
        this.e.animate().translationX(0.0F).setDuration(this.d).setListener(null);
        label594:
        label601:
        do
        {
          for (;;)
          {
            this.m.recycle();
            this.m = null;
            this.n = 0.0F;
            this.h = 0.0F;
            this.i = 0.0F;
            this.j = false;
            return false;
            paramView = this.m;
            if (paramView == null) {
              return false;
            }
            paramView.addMovement(paramMotionEvent);
            float f1 = paramMotionEvent.getRawX() - this.h;
            float f2 = paramMotionEvent.getRawY();
            float f3 = this.i;
            if ((Math.abs(f1) > this.a) && (Math.abs(f2 - f3) < Math.abs(f1) / 2.0F))
            {
              this.j = true;
              if (f1 > 0.0F) {
                i1 = this.a;
              } else {
                i1 = -this.a;
              }
              this.k = i1;
              this.e.getParent().requestDisallowInterceptTouchEvent(true);
              if (!this.o)
              {
                this.o = true;
                this.f.onNotify();
              }
              if (Math.abs(f1) > this.g / 3)
              {
                if (!this.p)
                {
                  this.p = true;
                  this.f.onNotify();
                }
              }
              else {
                this.p = false;
              }
              paramView = MotionEvent.obtain(paramMotionEvent);
              paramView.setAction(paramMotionEvent.getActionIndex() << 8 | 0x3);
              this.e.onTouchEvent(paramView);
              paramView.recycle();
            }
            if (!this.j) {
              break label674;
            }
            this.n = f1;
            this.e.setTranslationX(f1 - this.k);
            return true;
            if (this.m == null) {
              return false;
            }
            f1 = paramMotionEvent.getRawX() - this.h;
            this.m.addMovement(paramMotionEvent);
            this.m.computeCurrentVelocity(1000);
            f2 = this.m.getXVelocity();
            f3 = Math.abs(f2);
            float f4 = Math.abs(this.m.getYVelocity());
            if ((Math.abs(f1) > this.g / 3) && (this.j))
            {
              if (f1 > 0.0F)
              {
                i4 = 1;
                i1 = i3;
                i3 = i4;
                break label601;
              }
            }
            else
            {
              if ((this.b > f3) || (f3 > this.c)) {
                break label594;
              }
              bool = f4 < f3;
              if ((!bool) || (!bool) || (!this.j)) {
                break label594;
              }
              if (f2 < 0.0F) {
                bool = true;
              } else {
                bool = false;
              }
              if (f1 < 0.0F) {
                i3 = 1;
              } else {
                i3 = 0;
              }
              if (bool == i3) {
                bool = true;
              } else {
                bool = false;
              }
              if (this.m.getXVelocity() > 0.0F)
              {
                i3 = 1;
                break label601;
              }
            }
            i3 = 0;
            break label601;
            i3 = 0;
            boolean bool = i3;
            if (!bool) {
              break;
            }
            paramView = this.e.animate();
            int i2;
            if (i3 != 0) {
              i2 = this.g;
            } else {
              i2 = -this.g;
            }
            paramView.translationX(i2).setDuration(this.d).setListener(new a());
          }
        } while (!this.j);
      }
      label674:
      return false;
    }
    this.h = paramMotionEvent.getRawX();
    this.i = paramMotionEvent.getRawY();
    if (this.f.canDismiss(this.l))
    {
      this.o = false;
      paramView = VelocityTracker.obtain();
      this.m = paramView;
      paramView.addMovement(paramMotionEvent);
    }
    return true;
  }
  
  public static abstract interface DismissCallbacks
  {
    public abstract boolean canDismiss(Object paramObject);
    
    public abstract void onDismiss(View paramView, Object paramObject);
    
    public abstract void onNotify();
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      SwipeDismissTouchListener.a(SwipeDismissTouchListener.this);
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b(ViewGroup.LayoutParams paramLayoutParams, int paramInt) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      SwipeDismissTouchListener.d(SwipeDismissTouchListener.this).onDismiss(SwipeDismissTouchListener.b(SwipeDismissTouchListener.this), SwipeDismissTouchListener.c(SwipeDismissTouchListener.this));
      SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setTranslationX(0.0F);
      localLayoutParams.height = i1;
      SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setLayoutParams(localLayoutParams);
    }
  }
  
  class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(ViewGroup.LayoutParams paramLayoutParams) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      SwipeDismissTouchListener.b(SwipeDismissTouchListener.this).setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.SwipeDismissTouchListener
 * JD-Core Version:    0.7.0.1
 */