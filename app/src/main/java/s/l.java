package s;

import java.util.Iterator;
import java.util.List;

public final class l
  extends k
{
  private final List<k> a;
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).a();
    }
  }
  
  public void b(t paramt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).b(paramt);
    }
  }
  
  public void c(m paramm)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).c(paramm);
    }
  }
  
  public List<k> d()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.l
 * JD-Core Version:    0.7.0.1
 */