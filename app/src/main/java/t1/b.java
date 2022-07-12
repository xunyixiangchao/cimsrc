package t1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import androidx.transition.Transition;
import androidx.transition.t;

public class b
  extends d
{
  private float b = 3.0F;
  private int c = 80;
  
  private int h(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int j = this.c;
    int k = 1;
    int i = 1;
    if (j == 8388611)
    {
      if (x.B(paramView) != 1) {
        i = 0;
      }
      if (i != 0)
      {
        i = 5;
        break label87;
      }
    }
    for (;;)
    {
      i = 3;
      break label87;
      i = j;
      if (j != 8388613) {
        break label87;
      }
      if (x.B(paramView) == 1) {
        i = k;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
    }
    label87:
    if (i != 3)
    {
      if (i != 5)
      {
        if (i != 48)
        {
          if (i != 80) {
            return 0;
          }
          return paramInt2 - paramInt6 + Math.abs(paramInt3 - paramInt1);
        }
        return paramInt8 - paramInt2 + Math.abs(paramInt3 - paramInt1);
      }
      return paramInt1 - paramInt5 + Math.abs(paramInt4 - paramInt2);
    }
    return paramInt7 - paramInt1 + Math.abs(paramInt4 - paramInt2);
  }
  
  private int i(ViewGroup paramViewGroup)
  {
    int i = this.c;
    if ((i != 3) && (i != 5) && (i != 8388611) && (i != 8388613)) {
      return paramViewGroup.getHeight();
    }
    return paramViewGroup.getWidth();
  }
  
  public long c(ViewGroup paramViewGroup, Transition paramTransition, t paramt1, t paramt2)
  {
    if ((paramt1 == null) && (paramt2 == null)) {
      return 0L;
    }
    Rect localRect = paramTransition.u();
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
    paramt1 = new int[2];
    paramViewGroup.getLocationOnScreen(paramt1);
    int i1 = paramt1[0] + Math.round(paramViewGroup.getTranslationX());
    int i2 = paramt1[1] + Math.round(paramViewGroup.getTranslationY());
    int i3 = i1 + paramViewGroup.getWidth();
    int i4 = i2 + paramViewGroup.getHeight();
    int j;
    int k;
    if (localRect != null)
    {
      j = localRect.centerX();
      k = localRect.centerY();
    }
    else
    {
      j = (i1 + i3) / 2;
      k = (i2 + i4) / 2;
    }
    float f = h(paramViewGroup, m, n, j, k, i1, i2, i3, i4) / i(paramViewGroup);
    long l2 = paramTransition.t();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return Math.round((float)(l1 * i) / this.b * f);
  }
  
  public void j(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t1.b
 * JD-Core Version:    0.7.0.1
 */