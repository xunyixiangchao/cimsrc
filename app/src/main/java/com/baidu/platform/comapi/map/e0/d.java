package com.baidu.platform.comapi.map.e0;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.platform.comapi.b;

public class d
{
  private VelocityTracker a;
  public final int b;
  public final int c;
  
  public d()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(b.b());
    int i;
    if (localViewConfiguration == null)
    {
      this.c = ViewConfiguration.getMinimumFlingVelocity();
      i = ViewConfiguration.getMaximumFlingVelocity();
    }
    else
    {
      this.c = localViewConfiguration.getScaledMinimumFlingVelocity();
      i = localViewConfiguration.getScaledMaximumFlingVelocity();
    }
    this.b = i;
  }
  
  public void a()
  {
    VelocityTracker localVelocityTracker = this.a;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.a = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    VelocityTracker localVelocityTracker = this.a;
    if (localVelocityTracker == null)
    {
      this.a = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.addMovement(paramMotionEvent);
  }
  
  public void b()
  {
    this.a = VelocityTracker.obtain();
  }
  
  public Pair<a.d, a.d> c()
  {
    VelocityTracker localVelocityTracker = this.a;
    if (localVelocityTracker == null) {
      return new Pair(new a.d(0.0D, 0.0D), new a.d(0.0D, 0.0D));
    }
    localVelocityTracker.computeCurrentVelocity(1000, this.b);
    float f1 = this.a.getXVelocity(0);
    float f2 = this.a.getYVelocity(0);
    float f3 = this.a.getXVelocity(1);
    float f4 = this.a.getYVelocity(1);
    return new Pair(new a.d(f1, f2), new a.d(f3, f4));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.e0.d
 * JD-Core Version:    0.7.0.1
 */