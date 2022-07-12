package y0;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class e
{
  private final Object a;
  
  public e()
  {
    if (Build.VERSION.SDK_INT >= 26) {}
    for (Object localObject = new c(this);; localObject = new b(this))
    {
      this.a = localObject;
      return;
    }
  }
  
  public e(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public void a(int paramInt, d paramd, String paramString, Bundle paramBundle) {}
  
  public d b(int paramInt)
  {
    return null;
  }
  
  public List<d> c(String paramString, int paramInt)
  {
    return null;
  }
  
  public d d(int paramInt)
  {
    return null;
  }
  
  public Object e()
  {
    return this.a;
  }
  
  public boolean f(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return false;
  }
  
  static class a
    extends AccessibilityNodeProvider
  {
    final e a;
    
    a(e parame)
    {
      this.a = parame;
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      d locald = this.a.b(paramInt);
      if (locald == null) {
        return null;
      }
      return locald.I0();
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
    {
      paramString = this.a.c(paramString, paramInt);
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = paramString.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localArrayList.add(((d)paramString.get(paramInt)).I0());
        paramInt += 1;
      }
      return localArrayList;
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return this.a.f(paramInt1, paramInt2, paramBundle);
    }
  }
  
  static class b
    extends e.a
  {
    b(e parame)
    {
      super();
    }
    
    public AccessibilityNodeInfo findFocus(int paramInt)
    {
      d locald = this.a.d(paramInt);
      if (locald == null) {
        return null;
      }
      return locald.I0();
    }
  }
  
  static class c
    extends e.b
  {
    c(e parame)
    {
      super();
    }
    
    public void addExtraDataToAccessibilityNodeInfo(int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
    {
      this.a.a(paramInt, d.J0(paramAccessibilityNodeInfo), paramString, paramBundle);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.e
 * JD-Core Version:    0.7.0.1
 */