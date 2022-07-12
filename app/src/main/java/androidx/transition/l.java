package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class l
{
  static <T> ObjectAnimator a(T paramT, Property<T, PointF> paramProperty, Path paramPath)
  {
    return ObjectAnimator.ofObject(paramT, paramProperty, null, paramPath);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.l
 * JD-Core Version:    0.7.0.1
 */