package y0;

import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;

public final class c
{
  public static boolean a(AccessibilityManager paramAccessibilityManager, a parama)
  {
    if (parama == null) {
      return false;
    }
    return paramAccessibilityManager.addTouchExplorationStateChangeListener(new b(parama));
  }
  
  public static boolean b(AccessibilityManager paramAccessibilityManager, a parama)
  {
    if (parama == null) {
      return false;
    }
    return paramAccessibilityManager.removeTouchExplorationStateChangeListener(new b(parama));
  }
  
  public static abstract interface a
  {
    public abstract void onTouchExplorationStateChanged(boolean paramBoolean);
  }
  
  private static final class b
    implements AccessibilityManager.TouchExplorationStateChangeListener
  {
    final c.a a;
    
    b(c.a parama)
    {
      this.a = parama;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      return this.a.equals(paramObject.a);
    }
    
    public int hashCode()
    {
      return this.a.hashCode();
    }
    
    public void onTouchExplorationStateChanged(boolean paramBoolean)
    {
      this.a.onTouchExplorationStateChanged(paramBoolean);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.c
 * JD-Core Version:    0.7.0.1
 */