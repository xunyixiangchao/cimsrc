package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.mapsdkplatform.comapi.animation.b;

public class AnimationSet
  extends Animation
{
  public AnimationSet()
  {
    this.bdAnimation = new b();
  }
  
  public void addAnimation(Animation paramAnimation)
  {
    if (paramAnimation != null) {
      ((b)this.bdAnimation).a(paramAnimation);
    }
  }
  
  public void cancel()
  {
    this.bdAnimation.cancelAnimation();
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.bdAnimation.setAnimationListener(paramAnimationListener);
  }
  
  public void setAnimatorSetMode(int paramInt)
  {
    this.bdAnimation.setAnimatorSetMode(paramInt);
  }
  
  public void setDuration(long paramLong)
  {
    this.bdAnimation.setDuration(paramLong);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.bdAnimation.setInterpolator(paramInterpolator);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.animation.AnimationSet
 * JD-Core Version:    0.7.0.1
 */