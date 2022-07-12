package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

public class n0
{
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramView.setTooltipText(paramCharSequence);
      return;
    }
    o0.f(paramView, paramCharSequence);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.n0
 * JD-Core Version:    0.7.0.1
 */