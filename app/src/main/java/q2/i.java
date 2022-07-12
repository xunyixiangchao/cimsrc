package q2;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import t2.e;
import x2.l;

public class i
{
  private final Set<e> a = Collections.newSetFromMap(new WeakHashMap());
  private final Set<e> b = new HashSet();
  private boolean c;
  
  public boolean a(e parame)
  {
    boolean bool2 = true;
    if (parame == null) {
      return true;
    }
    boolean bool3 = this.a.remove(parame);
    boolean bool1 = bool2;
    if (!this.b.remove(parame)) {
      if (bool3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    if (bool1) {
      parame.clear();
    }
    return bool1;
  }
  
  public void b()
  {
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext()) {
      a((e)localIterator.next());
    }
    this.b.clear();
  }
  
  public void c()
  {
    this.c = true;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((locale.isRunning()) || (locale.j()))
      {
        locale.clear();
        this.b.add(locale);
      }
    }
  }
  
  public void d()
  {
    this.c = true;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (locale.isRunning())
      {
        locale.pause();
        this.b.add(locale);
      }
    }
  }
  
  public void e()
  {
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((!locale.j()) && (!locale.f()))
      {
        locale.clear();
        if (!this.c) {
          locale.i();
        } else {
          this.b.add(locale);
        }
      }
    }
  }
  
  public void f()
  {
    this.c = false;
    Iterator localIterator = l.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if ((!locale.j()) && (!locale.isRunning())) {
        locale.i();
      }
    }
    this.b.clear();
  }
  
  public void g(e parame)
  {
    this.a.add(parame);
    if (!this.c)
    {
      parame.i();
      return;
    }
    parame.clear();
    if (Log.isLoggable("RequestTracker", 2)) {
      Log.v("RequestTracker", "Paused, delaying request");
    }
    this.b.add(parame);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{numRequests=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", isPaused=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q2.i
 * JD-Core Version:    0.7.0.1
 */