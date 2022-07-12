package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import k0.e;

public class Group
  extends ConstraintHelper
{
  public Group(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void j(ConstraintLayout paramConstraintLayout)
  {
    i(paramConstraintLayout);
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    super.o(paramAttributeSet);
    this.e = false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h();
  }
  
  public void r(ConstraintLayout paramConstraintLayout)
  {
    paramConstraintLayout = (ConstraintLayout.LayoutParams)getLayoutParams();
    paramConstraintLayout.v0.o1(0);
    paramConstraintLayout.v0.P0(0);
  }
  
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    h();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    h();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.Group
 * JD-Core Version:    0.7.0.1
 */