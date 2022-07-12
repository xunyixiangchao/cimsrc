package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a<T extends g<T>>
{
  private final Map<Integer, T> a = new HashMap();
  private final Set<Integer> b = new HashSet();
  private b c;
  private boolean d;
  private boolean e;
  
  private boolean g(g<T> paramg)
  {
    int i = paramg.getId();
    if (this.b.contains(Integer.valueOf(i))) {
      return false;
    }
    g localg = (g)this.a.get(Integer.valueOf(k()));
    if (localg != null) {
      r(localg, false);
    }
    boolean bool = this.b.add(Integer.valueOf(i));
    if (!paramg.isChecked()) {
      paramg.setChecked(true);
    }
    return bool;
  }
  
  private void m()
  {
    b localb = this.c;
    if (localb != null) {
      localb.a(i());
    }
  }
  
  private boolean r(g<T> paramg, boolean paramBoolean)
  {
    int i = paramg.getId();
    if (!this.b.contains(Integer.valueOf(i))) {
      return false;
    }
    if ((paramBoolean) && (this.b.size() == 1) && (this.b.contains(Integer.valueOf(i))))
    {
      paramg.setChecked(true);
      return false;
    }
    paramBoolean = this.b.remove(Integer.valueOf(i));
    if (paramg.isChecked()) {
      paramg.setChecked(false);
    }
    return paramBoolean;
  }
  
  public void e(T paramT)
  {
    this.a.put(Integer.valueOf(paramT.getId()), paramT);
    if (paramT.isChecked()) {
      g(paramT);
    }
    paramT.setInternalOnCheckedChangeListener(new a());
  }
  
  public void f(int paramInt)
  {
    g localg = (g)this.a.get(Integer.valueOf(paramInt));
    if (localg == null) {
      return;
    }
    if (g(localg)) {
      m();
    }
  }
  
  public void h()
  {
    boolean bool = this.b.isEmpty();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      r((g)localIterator.next(), false);
    }
    if ((bool ^ true)) {
      m();
    }
  }
  
  public Set<Integer> i()
  {
    return new HashSet(this.b);
  }
  
  public List<Integer> j(ViewGroup paramViewGroup)
  {
    Set localSet = i();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof g)) && (localSet.contains(Integer.valueOf(localView.getId())))) {
        localArrayList.add(Integer.valueOf(localView.getId()));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int k()
  {
    if ((this.d) && (!this.b.isEmpty())) {
      return ((Integer)this.b.iterator().next()).intValue();
    }
    return -1;
  }
  
  public boolean l()
  {
    return this.d;
  }
  
  public void n(T paramT)
  {
    paramT.setInternalOnCheckedChangeListener(null);
    this.a.remove(Integer.valueOf(paramT.getId()));
    this.b.remove(Integer.valueOf(paramT.getId()));
  }
  
  public void o(b paramb)
  {
    this.c = paramb;
  }
  
  public void p(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.d != paramBoolean)
    {
      this.d = paramBoolean;
      h();
    }
  }
  
  class a
    implements g.a<T>
  {
    a() {}
    
    public void b(T paramT, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (!a.a(a.this, paramT)) {
          return;
        }
      }
      else
      {
        a locala = a.this;
        if (!a.c(locala, paramT, a.b(locala))) {
          return;
        }
      }
      a.d(a.this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Set<Integer> paramSet);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.a
 * JD-Core Version:    0.7.0.1
 */