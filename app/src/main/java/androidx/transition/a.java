package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a
{
  static void a(Animator paramAnimator, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    paramAnimator.addPauseListener(paramAnimatorListenerAdapter);
  }
  
  static void b(Animator paramAnimator)
  {
    paramAnimator.pause();
  }
  
  static void c(Animator paramAnimator)
  {
    paramAnimator.resume();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.a
 * JD-Core Version:    0.7.0.1
 */