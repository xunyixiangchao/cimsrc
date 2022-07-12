package v7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  extends l
  implements Iterable<l>
{
  private final List<l> a = new ArrayList();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof i)) && (((i)paramObject).a.equals(this.a)));
  }
  
  public void h(l paraml)
  {
    Object localObject = paraml;
    if (paraml == null) {
      localObject = n.a;
    }
    this.a.add(localObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Iterator<l> iterator()
  {
    return this.a.iterator();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.i
 * JD-Core Version:    0.7.0.1
 */