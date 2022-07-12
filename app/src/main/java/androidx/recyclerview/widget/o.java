package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.a;
import androidx.core.view.x;
import java.util.Map;
import java.util.WeakHashMap;
import y0.d;
import y0.e;

public class o
  extends a
{
  final RecyclerView d;
  private final a e;
  
  public o(RecyclerView paramRecyclerView)
  {
    this.d = paramRecyclerView;
    paramRecyclerView = n();
    if ((paramRecyclerView != null) && ((paramRecyclerView instanceof a))) {
      paramRecyclerView = (a)paramRecyclerView;
    } else {
      paramRecyclerView = new a(this);
    }
    this.e = paramRecyclerView;
  }
  
  public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.f(paramView, paramAccessibilityEvent);
    if (((paramView instanceof RecyclerView)) && (!o()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().K0(paramAccessibilityEvent);
      }
    }
  }
  
  public void g(View paramView, d paramd)
  {
    super.g(paramView, paramd);
    if ((!o()) && (this.d.getLayoutManager() != null)) {
      this.d.getLayoutManager().N0(paramd);
    }
  }
  
  public boolean j(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.j(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!o()) && (this.d.getLayoutManager() != null)) {
      return this.d.getLayoutManager().g1(paramInt, paramBundle);
    }
    return false;
  }
  
  public a n()
  {
    return this.e;
  }
  
  boolean o()
  {
    return this.d.o0();
  }
  
  public static class a
    extends a
  {
    final o d;
    private Map<View, a> e = new WeakHashMap();
    
    public a(o paramo)
    {
      this.d = paramo;
    }
    
    public boolean a(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null) {
        return locala.a(paramView, paramAccessibilityEvent);
      }
      return super.a(paramView, paramAccessibilityEvent);
    }
    
    public e b(View paramView)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null) {
        return locala.b(paramView);
      }
      return super.b(paramView);
    }
    
    public void f(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null)
      {
        locala.f(paramView, paramAccessibilityEvent);
        return;
      }
      super.f(paramView, paramAccessibilityEvent);
    }
    
    public void g(View paramView, d paramd)
    {
      if ((!this.d.o()) && (this.d.d.getLayoutManager() != null))
      {
        this.d.d.getLayoutManager().O0(paramView, paramd);
        a locala = (a)this.e.get(paramView);
        if (locala != null)
        {
          locala.g(paramView, paramd);
          return;
        }
      }
      super.g(paramView, paramd);
    }
    
    public void h(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null)
      {
        locala.h(paramView, paramAccessibilityEvent);
        return;
      }
      super.h(paramView, paramAccessibilityEvent);
    }
    
    public boolean i(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a locala = (a)this.e.get(paramViewGroup);
      if (locala != null) {
        return locala.i(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return super.i(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      if ((!this.d.o()) && (this.d.d.getLayoutManager() != null))
      {
        a locala = (a)this.e.get(paramView);
        if (locala != null)
        {
          if (locala.j(paramView, paramInt, paramBundle)) {
            return true;
          }
        }
        else if (super.j(paramView, paramInt, paramBundle)) {
          return true;
        }
        return this.d.d.getLayoutManager().i1(paramView, paramInt, paramBundle);
      }
      return super.j(paramView, paramInt, paramBundle);
    }
    
    public void l(View paramView, int paramInt)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null)
      {
        locala.l(paramView, paramInt);
        return;
      }
      super.l(paramView, paramInt);
    }
    
    public void m(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      a locala = (a)this.e.get(paramView);
      if (locala != null)
      {
        locala.m(paramView, paramAccessibilityEvent);
        return;
      }
      super.m(paramView, paramAccessibilityEvent);
    }
    
    a n(View paramView)
    {
      return (a)this.e.remove(paramView);
    }
    
    void o(View paramView)
    {
      a locala = x.l(paramView);
      if ((locala != null) && (locala != this)) {
        this.e.put(paramView, locala);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.o
 * JD-Core Version:    0.7.0.1
 */