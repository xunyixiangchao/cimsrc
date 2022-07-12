package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;

public abstract class Animation
{
  public BDAnimation bdAnimation;
  
  public abstract void cancel();
  
  public abstract void setAnimationListener(AnimationListener paramAnimationListener);
  
  public abstract void setDuration(long paramLong);
  
  public abstract void setInterpolator(Interpolator paramInterpolator);
  
  public static abstract interface AnimationListener
  {
    public abstract void onAnimationCancel();
    
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationRepeat();
    
    public abstract void onAnimationStart();
  }
  
  public static enum RepeatMode
  {
    static
    {
      RepeatMode localRepeatMode1 = new RepeatMode("RESTART", 0);
      RESTART = localRepeatMode1;
      RepeatMode localRepeatMode2 = new RepeatMode("REVERSE", 1);
      REVERSE = localRepeatMode2;
      a = new RepeatMode[] { localRepeatMode1, localRepeatMode2 };
    }
    
    private RepeatMode() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.animation.Animation
 * JD-Core Version:    0.7.0.1
 */