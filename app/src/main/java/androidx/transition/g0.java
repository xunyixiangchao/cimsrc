package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class g0
  extends f0
{
  public float b(View paramView)
  {
    return paramView.getTransitionAlpha();
  }
  
  public void d(View paramView, Matrix paramMatrix)
  {
    paramView.setAnimationMatrix(paramMatrix);
  }
  
  public void e(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeftTopRightBottom(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void f(View paramView, float paramFloat)
  {
    paramView.setTransitionAlpha(paramFloat);
  }
  
  public void g(View paramView, int paramInt)
  {
    paramView.setTransitionVisibility(paramInt);
  }
  
  public void h(View paramView, Matrix paramMatrix)
  {
    paramView.transformMatrixToGlobal(paramMatrix);
  }
  
  public void i(View paramView, Matrix paramMatrix)
  {
    paramView.transformMatrixToLocal(paramMatrix);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.g0
 * JD-Core Version:    0.7.0.1
 */