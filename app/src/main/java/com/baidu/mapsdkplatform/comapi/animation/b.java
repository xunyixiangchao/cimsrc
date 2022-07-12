package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import java.util.ArrayList;

public class b
  extends BDAnimation
{
  private Animator a = null;
  private long b = 0L;
  private Interpolator c = null;
  private Animation.AnimationListener d = null;
  private int e = 0;
  private ArrayList<Animation> f = new ArrayList();
  
  @TargetApi(11)
  private ObjectAnimator a(Marker paramMarker, Animation paramAnimation)
  {
    if ((paramAnimation instanceof AlphaAnimation)) {
      return ((a)paramAnimation.bdAnimation).a(paramMarker);
    }
    if ((paramAnimation instanceof RotateAnimation)) {
      return ((c)paramAnimation.bdAnimation).a(paramMarker);
    }
    if ((paramAnimation instanceof Transformation)) {
      return ((f)paramAnimation.bdAnimation).a(paramMarker);
    }
    if ((paramAnimation instanceof ScaleAnimation)) {
      return ((d)paramAnimation.bdAnimation).a(paramMarker);
    }
    if ((paramAnimation instanceof SingleScaleAnimation)) {
      return ((e)paramAnimation.bdAnimation).a(paramMarker);
    }
    return null;
  }
  
  public void a(Animation paramAnimation)
  {
    if (!this.f.contains(paramAnimation)) {
      this.f.add(paramAnimation);
    }
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
    this.a = new AnimatorSet();
    ArrayList localArrayList = this.f;
    paramAnimation = new ArrayList();
    paramAnimation.clear();
    int i = 0;
    while (i < localArrayList.size())
    {
      Object localObject = (Animation)localArrayList.get(i);
      if (localObject != null)
      {
        localObject = a(paramMarker, (Animation)localObject);
        if (localObject != null) {
          paramAnimation.add(localObject);
        }
      }
      i += 1;
    }
    long l = this.b;
    if (l != 0L) {
      this.a.setDuration(l);
    }
    paramMarker = this.c;
    if (paramMarker != null) {
      this.a.setInterpolator(paramMarker);
    }
    if (paramAnimation.size() != 0)
    {
      i = this.e;
      if (i == 0) {
        ((AnimatorSet)this.a).playTogether(paramAnimation);
      } else if (i == 1) {
        ((AnimatorSet)this.a).playSequentially(paramAnimation);
      }
    }
    addAnimationListener(this.a);
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.d = paramAnimationListener;
  }
  
  public void setAnimatorSetMode(int paramInt)
  {
    this.e = paramInt;
  }
  
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
  
  public void setRepeatCount(int paramInt) {}
  
  public void setRepeatMode(int paramInt) {}
  
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
      if (b.a(b.this) != null) {
        b.a(b.this).onAnimationCancel();
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (b.a(b.this) != null) {
        b.a(b.this).onAnimationEnd();
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (b.a(b.this) != null) {
        b.a(b.this).onAnimationRepeat();
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (b.a(b.this) != null) {
        b.a(b.this).onAnimationStart();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.animation.b
 * JD-Core Version:    0.7.0.1
 */