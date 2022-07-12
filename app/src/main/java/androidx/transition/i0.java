package androidx.transition;

import android.view.View;
import android.view.WindowId;

class i0
  implements j0
{
  private final WindowId a;
  
  i0(View paramView)
  {
    this.a = paramView.getWindowId();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof i0)) && (((i0)paramObject).a.equals(this.a));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.i0
 * JD-Core Version:    0.7.0.1
 */