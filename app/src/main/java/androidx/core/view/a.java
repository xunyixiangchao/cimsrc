package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import y0.d;
import y0.d.a;
import y0.e;

public class a
{
  private static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
  private final View.AccessibilityDelegate a;
  private final View.AccessibilityDelegate b;
  
  public a()
  {
    this(c);
  }
  
  public a(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.a = paramAccessibilityDelegate;
    this.b = new a(this);
  }
  
  static List<d.a> c(View paramView)
  {
    List localList = (List)paramView.getTag(R.id.tag_accessibility_actions);
    paramView = localList;
    if (localList == null) {
      paramView = Collections.emptyList();
    }
    return paramView;
  }
  
  private boolean e(ClickableSpan paramClickableSpan, View paramView)
  {
    if (paramClickableSpan != null)
    {
      paramView = d.q(paramView.createAccessibilityNodeInfo().getText());
      int i = 0;
      while ((paramView != null) && (i < paramView.length))
      {
        if (paramClickableSpan.equals(paramView[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean k(int paramInt, View paramView)
  {
    Object localObject = (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
    if (localObject != null)
    {
      localObject = (WeakReference)((SparseArray)localObject).get(paramInt);
      if (localObject != null)
      {
        localObject = (ClickableSpan)((WeakReference)localObject).get();
        if (e((ClickableSpan)localObject, paramView))
        {
          ((ClickableSpan)localObject).onClick(paramView);
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public e b(View paramView)
  {
    paramView = this.a.getAccessibilityNodeProvider(paramView);
    if (paramView != null) {
      return new e(paramView);
    }
    return null;
  }
  
  View.AccessibilityDelegate d()
  {
    return this.b;
  }
  
  public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void g(View paramView, d paramd)
  {
    this.a.onInitializeAccessibilityNodeInfo(paramView, paramd.I0());
  }
  
  public void h(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean i(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.a.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean j(View paramView, int paramInt, Bundle paramBundle)
  {
    List localList = c(paramView);
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= localList.size()) {
        break;
      }
      d.a locala = (d.a)localList.get(i);
      if (locala.b() == paramInt)
      {
        bool1 = locala.d(paramView, paramBundle);
        break;
      }
      i += 1;
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = this.a.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (paramInt == R.id.accessibility_action_clickable_span) {
        bool1 = k(paramBundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), paramView);
      }
    }
    return bool1;
  }
  
  public void l(View paramView, int paramInt)
  {
    this.a.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void m(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.a.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  static final class a
    extends View.AccessibilityDelegate
  {
    final a a;
    
    a(a parama)
    {
      this.a = parama;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.a.a(paramView, paramAccessibilityEvent);
    }
    
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      paramView = this.a.b(paramView);
      if (paramView != null) {
        return (AccessibilityNodeProvider)paramView.e();
      }
      return null;
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.a.f(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      d locald = d.J0(paramAccessibilityNodeInfo);
      locald.y0(x.X(paramView));
      locald.m0(x.S(paramView));
      locald.t0(x.p(paramView));
      locald.E0(x.J(paramView));
      this.a.g(paramView, locald);
      locald.f(paramAccessibilityNodeInfo.getText(), paramView);
      paramView = a.c(paramView);
      int i = 0;
      while (i < paramView.size())
      {
        locald.b((d.a)paramView.get(i));
        i += 1;
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.a.h(paramView, paramAccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.a.i(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return this.a.j(paramView, paramInt, paramBundle);
    }
    
    public void sendAccessibilityEvent(View paramView, int paramInt)
    {
      this.a.l(paramView, paramInt);
    }
    
    public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.a.m(paramView, paramAccessibilityEvent);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.a
 * JD-Core Version:    0.7.0.1
 */