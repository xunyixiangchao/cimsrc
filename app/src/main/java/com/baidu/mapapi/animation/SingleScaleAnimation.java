package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.mapsdkplatform.comapi.animation.e;

public class SingleScaleAnimation
  extends Animation
{
  public SingleScaleAnimation(ScaleType paramScaleType, float... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (paramScaleType == ScaleType.SCALE_X) {}
      for (paramScaleType = new e(1, paramVarArgs);; paramScaleType = new e(2, paramVarArgs))
      {
        this.bdAnimation = paramScaleType;
        return;
        if (paramScaleType != ScaleType.SCALE_Y) {
          break;
        }
      }
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
  
  public static enum ScaleType
  {
    static
    {
      ScaleType localScaleType1 = new ScaleType("SCALE_X", 0);
      SCALE_X = localScaleType1;
      ScaleType localScaleType2 = new ScaleType("SCALE_Y", 1);
      SCALE_Y = localScaleType2;
      a = new ScaleType[] { localScaleType1, localScaleType2 };
    }
    
    private ScaleType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.animation.SingleScaleAnimation
 * JD-Core Version:    0.7.0.1
 */