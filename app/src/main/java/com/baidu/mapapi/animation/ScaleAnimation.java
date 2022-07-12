package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.mapsdkplatform.comapi.animation.d;

public class ScaleAnimation
  extends Animation
{
  public ScaleAnimation(float... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      this.bdAnimation = new d(paramVarArgs);
      return;
    }
    throw new NullPointerException("BDMapSDKException: the scales is null");
  }
  
  public void cancel()
  {
    this.bdAnimation.cancelAnimation();
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.bdAnimation.setAnimationListener(paramAnimationListener);
  }
  
  public void setDuration(long paramLong)
  {
    this.bdAnimation.setDuration(paramLong);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.bdAnimation.setInterpolator(paramInterpolator);
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.bdAnimation.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(Animation.RepeatMode paramRepeatMode)
  {
    if (paramRepeatMode == Animation.RepeatMode.RESTART) {
      paramRepeatMode = this.bdAnimation;
    }
    for (int i = 1;; i = 2)
    {
      paramRepeatMode.setRepeatMode(i);
      return;
      if (paramRepeatMode != Animation.RepeatMode.REVERSE) {
        break;
      }
      paramRepeatMode = this.bdAnimation;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.animation.ScaleAnimation
 * JD-Core Version:    0.7.0.1
 */