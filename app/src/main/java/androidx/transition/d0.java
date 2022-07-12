package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

class d0
  extends c0
{
  private static boolean d = true;
  private static boolean e = true;
  private static boolean f = true;
  
  @SuppressLint({"NewApi"})
  public void d(View paramView, Matrix paramMatrix)
  {
    if (d) {}
    try
    {
      paramView.setAnimationMatrix(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    d = false;
  }
  
  @SuppressLint({"NewApi"})
  public void h(View paramView, Matrix paramMatrix)
  {
    if (e) {}
    try
    {
      paramView.transformMatrixToGlobal(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    e = false;
  }
  
  @SuppressLint({"NewApi"})
  public void i(View paramView, Matrix paramMatrix)
  {
    if (f) {}
    try
    {
      paramView.transformMatrixToLocal(paramMatrix);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label12:
      break label12;
    }
    f = false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.d0
 * JD-Core Version:    0.7.0.1
 */