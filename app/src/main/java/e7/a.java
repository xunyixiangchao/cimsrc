package e7;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import i1.b;
import i1.c;

public class a
{
  public static final TimeInterpolator a = new LinearInterpolator();
  public static final TimeInterpolator b = new b();
  public static final TimeInterpolator c = new i1.a();
  public static final TimeInterpolator d = new c();
  public static final TimeInterpolator e = new DecelerateInterpolator();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 < paramFloat3) {
      return paramFloat1;
    }
    if (paramFloat5 > paramFloat4) {
      return paramFloat2;
    }
    return a(paramFloat1, paramFloat2, (paramFloat5 - paramFloat3) / (paramFloat4 - paramFloat3));
  }
  
  public static int c(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.a
 * JD-Core Version:    0.7.0.1
 */