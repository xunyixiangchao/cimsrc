package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class z
{
  private static Method a;
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {}
    try
    {
      a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
  }
  
  private static float a(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT >= 25)
    {
      localMethod = a;
      if (localMethod == null) {}
    }
    try
    {
      int i = ((Integer)localMethod.invoke(paramViewConfiguration, new Object[0])).intValue();
      return i;
    }
    catch (Exception paramViewConfiguration)
    {
      label35:
      break label35;
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true)) {
      return paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
    }
    return 0.0F;
  }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    }
    return a(paramViewConfiguration, paramContext);
  }
  
  public static int c(ViewConfiguration paramViewConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.getScaledHoverSlop();
    }
    return paramViewConfiguration.getScaledTouchSlop() / 2;
  }
  
  public static float d(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    }
    return a(paramViewConfiguration, paramContext);
  }
  
  public static boolean e(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
    paramViewConfiguration = paramContext.getResources();
    int i = paramViewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    return (i != 0) && (paramViewConfiguration.getBoolean(i));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.z
 * JD-Core Version:    0.7.0.1
 */