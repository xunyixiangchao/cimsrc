package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
  extends ProgressBar
{
  long a = -1L;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  private final Runnable e = new e(this);
  private final Runnable f = new f(this);
  
  public ContentLoadingProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void e()
  {
    removeCallbacks(this.e);
    removeCallbacks(this.f);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    e();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.ContentLoadingProgressBar
 * JD-Core Version:    0.7.0.1
 */