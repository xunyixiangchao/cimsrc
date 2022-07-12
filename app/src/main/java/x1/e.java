package x1;

import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class e
{
  @TargetApi(16)
  static boolean a(Activity paramActivity)
  {
    return ((ViewGroup)paramActivity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
  }
  
  public static boolean b(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) != 0;
  }
  
  @TargetApi(19)
  public static boolean c(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x4000000) != 0;
  }
  
  public static boolean d(View paramView, int paramInt)
  {
    if (paramView.isInEditMode()) {
      return false;
    }
    Log.d("ViewUtil", String.format("refresh Height %d %d", new Object[] { Integer.valueOf(paramView.getHeight()), Integer.valueOf(paramInt) }));
    if (paramView.getHeight() == paramInt) {
      return false;
    }
    if (Math.abs(paramView.getHeight() - paramInt) == d.a(paramView.getContext())) {
      return false;
    }
    paramInt = c.g(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-1, paramInt));
      return true;
    }
    localLayoutParams.height = paramInt;
    paramView.requestLayout();
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x1.e
 * JD-Core Version:    0.7.0.1
 */