package t1;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.t;

public class a
  extends d
{
  private float b = 3.0F;
  
  private static float h(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  public long c(ViewGroup paramViewGroup, Transition paramTransition, t paramt1, t paramt2)
  {
    if ((paramt1 == null) && (paramt2 == null)) {
      return 0L;
    }
    int i;
    if ((paramt2 != null) && (e(paramt1) != 0))
    {
      i = 1;
      paramt1 = paramt2;
    }
    else
    {
      i = -1;
    }
    int m = f(paramt1);
    int n = g(paramt1);
    paramt1 = paramTransition.u();
    int j;
    int k;
    if (paramt1 != null)
    {
      j = paramt1.centerX();
      k = paramt1.centerY();
    }
    else
    {
      paramt1 = new int[2];
      paramViewGroup.getLocationOnScreen(paramt1);
      j = Math.round(paramt1[0] + paramViewGroup.getWidth() / 2 + paramViewGroup.getTranslationX());
      k = Math.round(paramt1[1] + paramViewGroup.getHeight() / 2 + paramViewGroup.getTranslationY());
    }
    float f = h(m, n, j, k) / h(0.0F, 0.0F, paramViewGroup.getWidth(), paramViewGroup.getHeight());
    long l2 = paramTransition.t();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return Math.round((float)(l1 * i) / this.b * f);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t1.a
 * JD-Core Version:    0.7.0.1
 */