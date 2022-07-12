package z0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class a
{
  public static Interpolator a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return new PathInterpolator(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static Interpolator b(Path paramPath)
  {
    return new PathInterpolator(paramPath);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z0.a
 * JD-Core Version:    0.7.0.1
 */