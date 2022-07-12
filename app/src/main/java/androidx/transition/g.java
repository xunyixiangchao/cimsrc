package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class g
  implements e
{
  private static Class<?> b;
  private static boolean c;
  private static Method d;
  private static boolean e;
  private static Method f;
  private static boolean g;
  private final View a;
  
  private g(View paramView)
  {
    this.a = paramView;
  }
  
  static e b(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    c();
    Method localMethod = d;
    if (localMethod != null) {}
    try
    {
      paramView = new g((View)localMethod.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
      return paramView;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return null;
    }
    catch (IllegalAccessException paramView) {}
    return null;
  }
  
  private static void c()
  {
    if (!e)
    {
      try
      {
        d();
        Method localMethod = b.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
        d = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve addGhost method", localNoSuchMethodException);
      }
      e = true;
    }
  }
  
  private static void d()
  {
    if (!c)
    {
      try
      {
        b = Class.forName("android.view.GhostView");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve GhostView class", localClassNotFoundException);
      }
      c = true;
    }
  }
  
  private static void e()
  {
    if (!g)
    {
      try
      {
        d();
        Method localMethod = b.getDeclaredMethod("removeGhost", new Class[] { View.class });
        f = localMethod;
        localMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", localNoSuchMethodException);
      }
      g = true;
    }
  }
  
  static void f(View paramView)
  {
    e();
    Method localMethod = f;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(null, new Object[] { paramView });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  public void a(ViewGroup paramViewGroup, View paramView) {}
  
  public void setVisibility(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.g
 * JD-Core Version:    0.7.0.1
 */