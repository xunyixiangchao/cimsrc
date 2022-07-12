package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;

public final class j
{
  public static MenuItem a(MenuItem paramMenuItem, b paramb)
  {
    if ((paramMenuItem instanceof s0.b)) {
      return ((s0.b)paramMenuItem).a(paramb);
    }
    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    return paramMenuItem;
  }
  
  public static void b(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setAlphabeticShortcut(paramChar, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setAlphabeticShortcut(paramChar, paramInt);
    }
  }
  
  public static void c(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setContentDescription(paramCharSequence);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setContentDescription(paramCharSequence);
    }
  }
  
  public static void d(MenuItem paramMenuItem, ColorStateList paramColorStateList)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setIconTintList(paramColorStateList);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintList(paramColorStateList);
    }
  }
  
  public static void e(MenuItem paramMenuItem, PorterDuff.Mode paramMode)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setIconTintMode(paramMode);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setIconTintMode(paramMode);
    }
  }
  
  public static void f(MenuItem paramMenuItem, char paramChar, int paramInt)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setNumericShortcut(paramChar, paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setNumericShortcut(paramChar, paramInt);
    }
  }
  
  public static void g(MenuItem paramMenuItem, CharSequence paramCharSequence)
  {
    if ((paramMenuItem instanceof s0.b))
    {
      ((s0.b)paramMenuItem).setTooltipText(paramCharSequence);
      return;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      paramMenuItem.setTooltipText(paramCharSequence);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.j
 * JD-Core Version:    0.7.0.1
 */