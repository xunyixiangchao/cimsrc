package y0;

import android.view.accessibility.AccessibilityEvent;

public final class b
{
  public static int a(AccessibilityEvent paramAccessibilityEvent)
  {
    return paramAccessibilityEvent.getContentChangeTypes();
  }
  
  public static void b(AccessibilityEvent paramAccessibilityEvent, int paramInt)
  {
    paramAccessibilityEvent.setContentChangeTypes(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.b
 * JD-Core Version:    0.7.0.1
 */