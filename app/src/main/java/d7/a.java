package d7;

import android.annotation.TargetApi;
import android.view.View;

class a
{
  public static void a(View paramView, Runnable paramRunnable)
  {
    b(paramView, paramRunnable);
  }
  
  @TargetApi(16)
  private static void b(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d7.a
 * JD-Core Version:    0.7.0.1
 */