package q2;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import u2.h;
import x2.l;

public final class k
  implements f
{
  private final Set<h<?>> a = Collections.newSetFromMap(new WeakHashMap());
  
  public void a()
  {
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).a();
    }
  }
  
  public void d()
  {
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.a.clear();
  }
  
  public List<h<?>> h()
  {
    return l.j(this.a);
  }
  
  public void m(h<?> paramh)
  {
    this.a.add(paramh);
  }
  
  public void n(h<?> paramh)
  {
    this.a.remove(paramh);
  }
  
  public void onDestroy()
  {
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((h)localIterator.next()).onDestroy();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q2.k
 * JD-Core Version:    0.7.0.1
 */