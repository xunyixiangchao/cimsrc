package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class b
{
  private boolean a;
  private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList();
  
  public b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  void a(a parama)
  {
    this.b.add(parama);
  }
  
  public abstract void b();
  
  public final boolean c()
  {
    return this.a;
  }
  
  public final void d()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).cancel();
    }
  }
  
  void e(a parama)
  {
    this.b.remove(parama);
  }
  
  public final void f(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.activity.b
 * JD-Core Version:    0.7.0.1
 */