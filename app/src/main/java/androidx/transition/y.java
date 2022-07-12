package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class y
{
  private static boolean a = true;
  private static Method b;
  private static boolean c;
  
  static int a(ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return paramViewGroup.getChildDrawingOrder(paramInt);
    }
    if (!c) {}
    try
    {
      Object localObject = Integer.TYPE;
      localObject = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[] { localObject, localObject });
      b = (Method)localObject;
      ((Method)localObject).setAccessible(true);
      label53:
      c = true;
      localObject = b;
      if (localObject != null) {}
      try
      {
        int i = ((Integer)((Method)localObject).invoke(paramViewGroup, new Object[] { Integer.valueOf(paramViewGroup.getChildCount()), Integer.valueOf(paramInt) })).intValue();
        return i;
      }
      catch (IllegalAccessException|InvocationTargetException paramViewGroup) {}
      return paramInt;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label53;
    }
    return paramInt;
  }
  
  static x b(ViewGroup paramViewGroup)
  {
    return new w(paramViewGroup);
  }
  
  @SuppressLint({"NewApi"})
  private static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (a) {}
    try
    {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    }
    catch (NoSuchMethodError paramViewGroup)
    {
      label12:
      break label12;
    }
    a = false;
  }
  
  static void d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramViewGroup.suppressLayout(paramBoolean);
      return;
    }
    c(paramViewGroup, paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.y
 * JD-Core Version:    0.7.0.1
 */