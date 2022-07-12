package w1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import cn.dreamtobe.kpswitch.R.styleable;
import v1.a;
import x1.e;

public class b
  implements a
{
  private final View a;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public b(View paramView, AttributeSet paramAttributeSet)
  {
    this.a = paramView;
    if (paramAttributeSet != null)
    {
      View localView = null;
      try
      {
        paramView = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.KPSwitchPanelLayout);
        localView = paramView;
        this.c = paramView.getBoolean(R.styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
        paramView.recycle();
        return;
      }
      finally
      {
        if (localView != null) {
          localView.recycle();
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt == 0) {
      this.b = false;
    }
    if (paramInt == this.a.getVisibility()) {
      return true;
    }
    return (b()) && (paramInt == 0);
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int[] c(int paramInt1, int paramInt2)
  {
    if (this.b)
    {
      this.a.setVisibility(8);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
    return new int[] { paramInt1, paramInt2 };
  }
  
  public void d()
  {
    throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
  }
  
  public void e()
  {
    this.b = true;
  }
  
  public void f(int paramInt)
  {
    if (this.c) {
      return;
    }
    e.d(this.a, paramInt);
  }
  
  public void g(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean isVisible()
  {
    return this.b ^ true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w1.b
 * JD-Core Version:    0.7.0.1
 */