package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelLinearLayout;
import cn.dreamtobe.kpswitch.widget.KPSwitchRootRelativeLayout;

public class SwitchPanelRootRelativeLayout
  extends KPSwitchRootRelativeLayout
{
  private KPSwitchPanelLinearLayout b;
  
  public SwitchPanelRootRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      this.b = ((KPSwitchPanelLinearLayout)findViewById(2131230733));
    }
    KPSwitchPanelLinearLayout localKPSwitchPanelLinearLayout = this.b;
    if (localKPSwitchPanelLinearLayout != null) {
      localKPSwitchPanelLinearLayout.requestLayout();
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.SwitchPanelRootRelativeLayout
 * JD-Core Version:    0.7.0.1
 */