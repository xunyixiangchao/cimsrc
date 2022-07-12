package q;

import androidx.camera.camera2.internal.l2;
import androidx.camera.camera2.internal.l2.a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p.h;
import s.c2;

public class g
{
  private final h a;
  
  public g(c2 paramc2)
  {
    this.a = ((h)paramc2.b(h.class));
  }
  
  private void a(Set<l2> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      l2 locall2 = (l2)paramSet.next();
      locall2.a().p(locall2);
    }
  }
  
  private void b(Set<l2> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      l2 locall2 = (l2)paramSet.next();
      locall2.a().q(locall2);
    }
  }
  
  public void c(l2 paraml2, List<l2> paramList1, List<l2> paramList2, a parama)
  {
    if (d())
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        l2 locall2 = (l2)paramList1.next();
        if (locall2 == paraml2) {
          break;
        }
        localLinkedHashSet.add(locall2);
      }
      b(localLinkedHashSet);
    }
    parama.a(paraml2);
    if (d())
    {
      paramList1 = new LinkedHashSet();
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        parama = (l2)paramList2.next();
        if (parama == paraml2) {
          break;
        }
        paramList1.add(parama);
      }
      a(paramList1);
    }
  }
  
  public boolean d()
  {
    return this.a != null;
  }
  
  @FunctionalInterface
  public static abstract interface a
  {
    public abstract void a(l2 paraml2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q.g
 * JD-Core Version:    0.7.0.1
 */