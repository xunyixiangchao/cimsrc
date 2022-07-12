package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class q
{
  private int a;
  private int b;
  
  public q(ViewGroup paramViewGroup) {}
  
  public int a()
  {
    return this.a | this.b;
  }
  
  public void b(View paramView1, View paramView2, int paramInt)
  {
    c(paramView1, paramView2, paramInt, 0);
  }
  
  public void c(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      this.b = paramInt1;
      return;
    }
    this.a = paramInt1;
  }
  
  public void d(View paramView)
  {
    e(paramView, 0);
  }
  
  public void e(View paramView, int paramInt)
  {
    if (paramInt == 1)
    {
      this.b = 0;
      return;
    }
    this.a = 0;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.q
 * JD-Core Version:    0.7.0.1
 */