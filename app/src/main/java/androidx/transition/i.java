package androidx.transition;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class i
{
  static e a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if (Build.VERSION.SDK_INT == 28) {
      return g.b(paramView, paramViewGroup, paramMatrix);
    }
    return h.b(paramView, paramViewGroup, paramMatrix);
  }
  
  static void b(View paramView)
  {
    if (Build.VERSION.SDK_INT == 28)
    {
      g.f(paramView);
      return;
    }
    h.f(paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.i
 * JD-Core Version:    0.7.0.1
 */