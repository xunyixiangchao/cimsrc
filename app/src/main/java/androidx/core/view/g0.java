package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;

public final class g0
{
  public static i0 a(Window paramWindow, View paramView)
  {
    if (Build.VERSION.SDK_INT >= 30) {
      return b.a(paramWindow);
    }
    return new i0(paramWindow, paramView);
  }
  
  public static void b(Window paramWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      b.b(paramWindow, paramBoolean);
      return;
    }
    a.a(paramWindow, paramBoolean);
  }
  
  private static class a
  {
    static void a(Window paramWindow, boolean paramBoolean)
    {
      paramWindow = paramWindow.getDecorView();
      int i = paramWindow.getSystemUiVisibility();
      if (paramBoolean) {
        i &= 0xFFFFF8FF;
      } else {
        i |= 0x700;
      }
      paramWindow.setSystemUiVisibility(i);
    }
  }
  
  private static class b
  {
    static i0 a(Window paramWindow)
    {
      paramWindow = paramWindow.getInsetsController();
      if (paramWindow != null) {
        return i0.c(paramWindow);
      }
      return null;
    }
    
    static void b(Window paramWindow, boolean paramBoolean)
    {
      paramWindow.setDecorFitsSystemWindows(paramBoolean);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.g0
 * JD-Core Version:    0.7.0.1
 */