package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

class e0
  extends d0
{
  private static boolean g = true;
  
  @SuppressLint({"NewApi"})
  public void e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (g) {}
    try
    {
      paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label17:
      break label17;
    }
    g = false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.e0
 * JD-Core Version:    0.7.0.1
 */