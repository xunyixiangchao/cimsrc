package y0;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public class f
{
  public static void a(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    paramAccessibilityRecord.setMaxScrollX(paramInt);
  }
  
  public static void b(AccessibilityRecord paramAccessibilityRecord, int paramInt)
  {
    paramAccessibilityRecord.setMaxScrollY(paramInt);
  }
  
  public static void c(AccessibilityRecord paramAccessibilityRecord, View paramView, int paramInt)
  {
    paramAccessibilityRecord.setSource(paramView, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.f
 * JD-Core Version:    0.7.0.1
 */