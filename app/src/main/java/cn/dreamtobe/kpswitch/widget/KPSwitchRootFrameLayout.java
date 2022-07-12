package cn.dreamtobe.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import w1.c;

public class KPSwitchRootFrameLayout
  extends FrameLayout
{
  private c a;
  
  public KPSwitchRootFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public KPSwitchRootFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new c(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.a.b(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     cn.dreamtobe.kpswitch.widget.KPSwitchRootFrameLayout
 * JD-Core Version:    0.7.0.1
 */