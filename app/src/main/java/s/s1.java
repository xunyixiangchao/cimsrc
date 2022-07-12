package s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class s1<C>
{
  private Set<C> a = new HashSet();
  
  public void a(List<C> paramList)
  {
    this.a.addAll(paramList);
  }
  
  public abstract s1<C> b();
  
  public List<C> c()
  {
    return Collections.unmodifiableList(new ArrayList(this.a));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.s1
 * JD-Core Version:    0.7.0.1
 */