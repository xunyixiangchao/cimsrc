package cn.dreamtobe.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import v1.b;
import w1.a;
import x1.e;

public class KPSwitchFSPanelLinearLayout
  extends LinearLayout
  implements b
{
  private a a;
  
  public KPSwitchFSPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  @TargetApi(11)
  public KPSwitchFSPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.a = new a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void c(int paramInt)
  {
    e.d(this, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */