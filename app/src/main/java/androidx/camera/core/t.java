package androidx.camera.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import s.g0;
import s.n1;

public final class t
{
  public static final t b = new a().d(0).b();
  public static final t c = new a().d(1).b();
  private LinkedHashSet<q> a;
  
  t(LinkedHashSet<q> paramLinkedHashSet)
  {
    this.a = paramLinkedHashSet;
  }
  
  public LinkedHashSet<g0> a(LinkedHashSet<g0> paramLinkedHashSet)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramLinkedHashSet.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((g0)((Iterator)localObject2).next()).e());
    }
    localObject1 = b((List)localObject1);
    localObject2 = new LinkedHashSet();
    paramLinkedHashSet = paramLinkedHashSet.iterator();
    while (paramLinkedHashSet.hasNext())
    {
      g0 localg0 = (g0)paramLinkedHashSet.next();
      if (((List)localObject1).contains(localg0.e())) {
        ((LinkedHashSet)localObject2).add(localg0);
      }
    }
    return localObject2;
  }
  
  public List<r> b(List<r> paramList)
  {
    Object localObject = new ArrayList(paramList);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      localObject = ((q)localIterator.next()).b(Collections.unmodifiableList((List)localObject));
    }
    ((List)localObject).retainAll(paramList);
    return localObject;
  }
  
  public LinkedHashSet<q> c()
  {
    return this.a;
  }
  
  public Integer d()
  {
    Iterator localIterator = this.a.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (q)localIterator.next();
      if ((localObject2 instanceof n1))
      {
        localObject2 = Integer.valueOf(((n1)localObject2).c());
        if (localObject1 == null) {
          localObject1 = localObject2;
        } else if (!localObject1.equals(localObject2)) {
          throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
        }
      }
    }
    return localObject1;
  }
  
  public g0 e(LinkedHashSet<g0> paramLinkedHashSet)
  {
    paramLinkedHashSet = a(paramLinkedHashSet).iterator();
    if (paramLinkedHashSet.hasNext()) {
      return (g0)paramLinkedHashSet.next();
    }
    throw new IllegalArgumentException("No available camera can be found");
  }
  
  public static final class a
  {
    private final LinkedHashSet<q> a;
    
    public a()
    {
      this.a = new LinkedHashSet();
    }
    
    private a(LinkedHashSet<q> paramLinkedHashSet)
    {
      this.a = new LinkedHashSet(paramLinkedHashSet);
    }
    
    public static a c(t paramt)
    {
      return new a(paramt.c());
    }
    
    public a a(q paramq)
    {
      this.a.add(paramq);
      return this;
    }
    
    public t b()
    {
      return new t(this.a);
    }
    
    public a d(int paramInt)
    {
      this.a.add(new n1(paramInt));
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.t
 * JD-Core Version:    0.7.0.1
 */