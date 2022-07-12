package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class w
  implements x
{
  private final ViewGroupOverlay a;
  
  w(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
  
  public void c(View paramView)
  {
    this.a.add(paramView);
  }
  
  public void d(View paramView)
  {
    this.a.remove(paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.w
 * JD-Core Version:    0.7.0.1
 */