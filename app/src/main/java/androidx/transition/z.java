package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class z
  implements a0
{
  private final ViewOverlay a;
  
  z(View paramView)
  {
    this.a = paramView.getOverlay();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.a.add(paramDrawable);
  }
  
  public void b(Drawable paramDrawable)
  {
    this.a.remove(paramDrawable);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.z
 * JD-Core Version:    0.7.0.1
 */