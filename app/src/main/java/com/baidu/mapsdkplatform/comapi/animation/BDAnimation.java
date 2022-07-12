package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.map.Marker;

public abstract class BDAnimation
{
  protected abstract void addAnimationListener(Animator paramAnimator);
  
  public abstract void cancelAnimation();
  
  public abstract void setAnimation(Marker paramMarker, Animation paramAnimation);
  
  public abstract void setAnimationListener(Animation.AnimationListener paramAnimationListener);
  
  public abstract void setAnimatorSetMode(int paramInt);
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public abstract void setRepeatCount(int paramInt);
  
  public abstract void setRepeatMode(int paramInt);
  
  public abstract void startAnimation();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.animation.BDAnimation
 * JD-Core Version:    0.7.0.1
 */