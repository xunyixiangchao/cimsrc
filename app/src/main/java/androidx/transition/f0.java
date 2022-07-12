package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;

class f0
  extends e0
{
  private static boolean h = true;
  
  @SuppressLint({"NewApi"})
  public void g(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT == 28)
    {
      super.g(paramView, paramInt);
      return;
    }
    if (h) {}
    try
    {
      paramView.setTransitionVisibility(paramInt);
      return;
    }
    catch (NoSuchMethodError paramView)
    {
      label27:
      break label27;
    }
    h = false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.f0
 * JD-Core Version:    0.7.0.1
 */