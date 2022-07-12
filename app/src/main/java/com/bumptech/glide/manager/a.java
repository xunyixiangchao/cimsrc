package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import q2.e;
import q2.f;
import x2.l;

class a
  implements e
{
  private final Set<f> a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  public void a(f paramf)
  {
    this.a.remove(paramf);
  }
  
  public void b(f paramf)
  {
    this.a.add(paramf);
    if (this.c)
    {
      paramf.onDestroy();
      return;
    }
    if (this.b)
    {
      paramf.a();
      return;
    }
    paramf.d();
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).onDestroy();
    }
  }
  
  void d()
  {
    this.b = true;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a();
    }
  }
  
  void e()
  {
    this.b = false;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).d();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.manager.a
 * JD-Core Version:    0.7.0.1
 */