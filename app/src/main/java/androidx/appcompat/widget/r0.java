package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.x;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class r0
{
  private static Method a;
  
  static
  {
    try
    {
      Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      a = localMethod;
      if (localMethod.isAccessible()) {
        break label49;
      }
      a.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label41:
      label49:
      break label41;
    }
    Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    Method localMethod = a;
    if (localMethod != null) {
      try
      {
        localMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        return;
      }
      catch (Exception paramView)
      {
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", paramView);
      }
    }
  }
  
  public static boolean b(View paramView)
  {
    return x.B(paramView) == 1;
  }
  
  public static void c(View paramView)
  {
    try
    {
      try
      {
        Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        localMethod.invoke(paramView, new Object[0]);
        return;
      }
      catch (IllegalAccessException paramView) {}catch (InvocationTargetException paramView) {}
      Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      return;
    }
    catch (NoSuchMethodException paramView)
    {
      label52:
      break label52;
    }
    Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.r0
 * JD-Core Version:    0.7.0.1
 */