package s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c2
{
  private final List<b2> a;
  
  public c2(List<b2> paramList)
  {
    this.a = new ArrayList(paramList);
  }
  
  public boolean a(Class<? extends b2> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (paramClass.isAssignableFrom(((b2)localIterator.next()).getClass())) {
        return true;
      }
    }
    return false;
  }
  
  public <T extends b2> T b(Class<T> paramClass)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b2 localb2 = (b2)localIterator.next();
      if (localb2.getClass() == paramClass) {
        return localb2;
      }
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.c2
 * JD-Core Version:    0.7.0.1
 */