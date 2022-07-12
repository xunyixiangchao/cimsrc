package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.map.Marker;

public class c
  extends BDAnimation
{
  private Animator a = null;
  private long b = 0L;
  private Interpolator c = null;
  private Animation.AnimationListener d = null;
  private int e = 1;
  private int f = 0;
  private float[] g;
  
  public c(float... paramVarArgs)
  {
    this.g = paramVarArgs;
  }
  
  public int a()
  {
    return this.e;
  }
  
  @TargetApi(11)
  ObjectAnimator a(Marker paramMarker)
  {
    paramMarker = ObjectAnimator.ofFloat(paramMarker, "rotate", this.g);
    if (paramMarker != null)
    {
      paramMarker.setRepeatCount(this.f);
      paramMarker.setRepeatMode(a());
      paramMarker.setDuration(this.b);
      Interpolator localInterpolator = this.c;
      if (localInterpolator != null) {
        paramMarker.setInterpolator(localInterpolator);
      }
    }
    return paramMarker;
  }
  
  @TargetApi(11)
  protected void addAnimationListener(Animator paramAnimator)
  {
    if (paramAnimator == null) {
      return;
    }
    paramAnimator.addListener(new a());
  }
  
  @TargetApi(11)
  public void cancelAnimation()
  {
    Animator localAnimator = this.a;
    if (localAnimator != null)
    {
      localAnimator.cancel();
      this.a = null;
    }
  }
  
  @TargetApi(11)
  public void setAnimation(Marker paramMarker, Animation paramAnimation)
  {
    paramMarker = a(paramMarker);
    this.a = paramMarker;
    addAnimationListener(paramMarker);
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.d = paramAnimationListener;
  }
  
  public void setAnimatorSetMode(int paramInt) {}
  
  public void setDuration(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.b = l;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.c = paramInterpolator;
  }
  
  public void setRepeatCount(int paramInt)
  {
    if ((paramInt > 0) || (paramInt == -1)) {
      this.f = paramInt;
    }
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.e = paramInt;
  }
  
  @TargetApi(11)
  public void startAnimation()
  {
    Animator localAnimator = this.a;
    if (localAnimator == null) {
      return;
    }
    localAnimator.start();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).onAnimationCancel();
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).onAnimationEnd();
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).onAnimationRepeat();
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).onAnimationStart();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.animation.c
 * JD-Core Version:    0.7.0.1
 */