package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

public final class k
{
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    b.c(paramPopupWindow, paramBoolean);
  }
  
  public static void b(PopupWindow paramPopupWindow, int paramInt)
  {
    b.d(paramPopupWindow, paramInt);
  }
  
  public static void c(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  static class a
  {
    static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static class b
  {
    static boolean a(PopupWindow paramPopupWindow)
    {
      return paramPopupWindow.getOverlapAnchor();
    }
    
    static int b(PopupWindow paramPopupWindow)
    {
      return paramPopupWindow.getWindowLayoutType();
    }
    
    static void c(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    
    static void d(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.k
 * JD-Core Version:    0.7.0.1
 */