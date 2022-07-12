package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout
  extends FrameLayout
{
  private v a;
  
  public FitWindowsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    v localv = this.a;
    if (localv != null) {
      localv.a(paramRect);
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public void setOnFitSystemWindowsListener(v paramv)
  {
    this.a = paramv;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.FitWindowsFrameLayout
 * JD-Core Version:    0.7.0.1
 */