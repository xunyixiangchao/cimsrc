package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.x;
import t0.a;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private Runnable d;
  OverScroller e;
  private boolean f;
  private int g = -1;
  private int h;
  private int i = -1;
  private VelocityTracker j;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void I()
  {
    if (this.j == null) {
      this.j = VelocityTracker.obtain();
    }
  }
  
  public boolean D(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getActionMasked();
    boolean bool = true;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k == 3) {
          break label205;
        }
        if (k == 6)
        {
          if (paramMotionEvent.getActionIndex() == 0) {
            k = 1;
          } else {
            k = 0;
          }
          this.g = paramMotionEvent.getPointerId(k);
          this.h = ((int)(paramMotionEvent.getY(k) + 0.5F));
        }
      }
      else
      {
        k = paramMotionEvent.findPointerIndex(this.g);
        if (k == -1) {
          return false;
        }
        k = (int)paramMotionEvent.getY(k);
        m = this.h;
        this.h = k;
        O(paramCoordinatorLayout, paramV, m - k, K(paramV), 0);
      }
      m = 0;
      break label244;
    }
    else
    {
      VelocityTracker localVelocityTracker = this.j;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.addMovement(paramMotionEvent);
        this.j.computeCurrentVelocity(1000);
        float f1 = this.j.getYVelocity(this.g);
        J(paramCoordinatorLayout, paramV, -L(paramV), 0, f1);
        k = 1;
        break label208;
      }
    }
    label205:
    k = 0;
    label208:
    this.f = false;
    this.g = -1;
    paramCoordinatorLayout = this.j;
    int m = k;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.recycle();
      this.j = null;
      m = k;
    }
    label244:
    paramCoordinatorLayout = this.j;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    if (!this.f)
    {
      if (m != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  boolean H(V paramV)
  {
    return false;
  }
  
  final boolean J(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = this.d;
    if (localRunnable != null)
    {
      paramV.removeCallbacks(localRunnable);
      this.d = null;
    }
    if (this.e == null) {
      this.e = new OverScroller(paramV.getContext());
    }
    this.e.fling(0, E(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.e.computeScrollOffset())
    {
      paramCoordinatorLayout = new a(paramCoordinatorLayout, paramV);
      this.d = paramCoordinatorLayout;
      x.i0(paramV, paramCoordinatorLayout);
      return true;
    }
    N(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int K(V paramV)
  {
    return -paramV.getHeight();
  }
  
  int L(V paramV)
  {
    return paramV.getHeight();
  }
  
  int M()
  {
    return E();
  }
  
  void N(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  final int O(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return Q(paramCoordinatorLayout, paramV, M() - paramInt1, paramInt2, paramInt3);
  }
  
  int P(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return Q(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  int Q(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = E();
    if ((paramInt2 != 0) && (k >= paramInt2) && (k <= paramInt3))
    {
      paramInt1 = a.b(paramInt1, paramInt2, paramInt3);
      if (k != paramInt1)
      {
        G(paramInt1);
        return k - paramInt1;
      }
    }
    return 0;
  }
  
  public boolean k(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.i < 0) {
      this.i = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int k;
    if ((paramMotionEvent.getActionMasked() == 2) && (this.f))
    {
      k = this.g;
      if (k == -1) {
        return false;
      }
      k = paramMotionEvent.findPointerIndex(k);
      if (k == -1) {
        return false;
      }
      k = (int)paramMotionEvent.getY(k);
      if (Math.abs(k - this.h) > this.i)
      {
        this.h = k;
        return true;
      }
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.g = -1;
      k = (int)paramMotionEvent.getX();
      int m = (int)paramMotionEvent.getY();
      boolean bool;
      if ((H(paramV)) && (paramCoordinatorLayout.F(paramV, k, m))) {
        bool = true;
      } else {
        bool = false;
      }
      this.f = bool;
      if (bool)
      {
        this.h = m;
        this.g = paramMotionEvent.getPointerId(0);
        I();
        paramCoordinatorLayout = this.e;
        if ((paramCoordinatorLayout != null) && (!paramCoordinatorLayout.isFinished()))
        {
          this.e.abortAnimation();
          return true;
        }
      }
    }
    paramCoordinatorLayout = this.j;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return false;
  }
  
  private class a
    implements Runnable
  {
    private final CoordinatorLayout a;
    private final V b;
    
    a(V paramV)
    {
      this.a = paramV;
      Object localObject;
      this.b = localObject;
    }
    
    public void run()
    {
      if (this.b != null)
      {
        Object localObject = HeaderBehavior.this.e;
        if (localObject != null)
        {
          if (((OverScroller)localObject).computeScrollOffset())
          {
            localObject = HeaderBehavior.this;
            ((HeaderBehavior)localObject).P(this.a, this.b, ((HeaderBehavior)localObject).e.getCurrY());
            x.i0(this.b, this);
            return;
          }
          HeaderBehavior.this.N(this.a, this.b);
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */