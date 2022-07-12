package androidx.transition;

import android.view.ViewGroup;

public class o
{
  private ViewGroup a;
  private Runnable b;
  
  public static o b(ViewGroup paramViewGroup)
  {
    return (o)paramViewGroup.getTag(R.id.transition_current_scene);
  }
  
  static void c(ViewGroup paramViewGroup, o paramo)
  {
    paramViewGroup.setTag(R.id.transition_current_scene, paramo);
  }
  
  public void a()
  {
    if (b(this.a) == this)
    {
      Runnable localRunnable = this.b;
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.o
 * JD-Core Version:    0.7.0.1
 */