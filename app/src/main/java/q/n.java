package q;

import android.util.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p.l;
import p.o;
import s.l2.b;

public class n
{
  private final o a;
  
  public n()
  {
    this((o)l.a(o.class));
  }
  
  n(o paramo)
  {
    this.a = paramo;
  }
  
  public List<Size> a(l2.b paramb, List<Size> paramList)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return paramList;
    }
    paramb = ((o)localObject).a(paramb);
    if (paramb == null) {
      return paramList;
    }
    localObject = new ArrayList();
    ((List)localObject).add(paramb);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Size localSize = (Size)paramList.next();
      if (!localSize.equals(paramb)) {
        ((List)localObject).add(localSize);
      }
    }
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.n
 * JD-Core Version:    0.7.0.1
 */