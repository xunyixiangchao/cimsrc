package cn.dreamtobe.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import v1.a;

public class KPSwitchPanelFrameLayout
  extends FrameLayout
  implements v1.b, a
{
  private w1.b a;
  
  public KPSwitchPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f(paramAttributeSet);
  }
  
  public KPSwitchPanelFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f(paramAttributeSet);
  }
  
  private void f(AttributeSet paramAttributeSet)
  {
    this.a = new w1.b(this, paramAttributeSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.h(paramBoolean);
  }
  
  public boolean b()
  {
    return this.a.b();
  }
  
  public void c(int paramInt)
  {
    this.a.f(paramInt);
  }
  
  public void d()
  {
    super.setVisibility(0);
  }
  
  public void e()
  {
    this.a.e();
  }
  
  public boolean isVisible()
  {
    return this.a.isVisible();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.a.c(paramInt1, paramInt2);
    super.onMeasure(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void setIgnoreRecommendHeight(boolean paramBoolean)
  {
    this.a.g(paramBoolean);
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.a.a(paramInt)) {
      return;
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     cn.dreamtobe.kpswitch.widget.KPSwitchPanelFrameLayout
 * JD-Core Version:    0.7.0.1
 */