package s;

import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r2
{
  private final String a;
  private final Map<String, b> b = new LinkedHashMap();
  
  public r2(String paramString)
  {
    this.a = paramString;
  }
  
  private b i(String paramString, g2 paramg2, t2<?> paramt2)
  {
    b localb2 = (b)this.b.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(paramg2, paramt2);
      this.b.put(paramString, localb1);
    }
    return localb1;
  }
  
  private Collection<g2> j(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((parama == null) || (parama.a((b)localEntry.getValue()))) {
        localArrayList.add(((b)localEntry.getValue()).c());
      }
    }
    return localArrayList;
  }
  
  private Collection<t2<?>> k(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((parama == null) || (parama.a((b)localEntry.getValue()))) {
        localArrayList.add(((b)localEntry.getValue()).d());
      }
    }
    return localArrayList;
  }
  
  public g2.g d()
  {
    g2.g localg = new g2.g();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.b.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      b localb = (b)((Map.Entry)localObject2).getValue();
      if ((localb.a()) && (localb.b()))
      {
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        localg.a(localb.c());
        localArrayList.add(localObject2);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Active and attached use case: ");
    ((StringBuilder)localObject1).append(localArrayList);
    ((StringBuilder)localObject1).append(" for camera: ");
    ((StringBuilder)localObject1).append(this.a);
    n1.a("UseCaseAttachState", ((StringBuilder)localObject1).toString());
    return localg;
  }
  
  public Collection<g2> e()
  {
    return Collections.unmodifiableCollection(j(o2.a));
  }
  
  public g2.g f()
  {
    g2.g localg = new g2.g();
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      b localb = (b)localEntry.getValue();
      if (localb.b())
      {
        localg.a(localb.c());
        localArrayList.add((String)localEntry.getKey());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("All use case: ");
    ((StringBuilder)localObject).append(localArrayList);
    ((StringBuilder)localObject).append(" for camera: ");
    ((StringBuilder)localObject).append(this.a);
    n1.a("UseCaseAttachState", ((StringBuilder)localObject).toString());
    return localg;
  }
  
  public Collection<g2> g()
  {
    return Collections.unmodifiableCollection(j(p2.a));
  }
  
  public Collection<t2<?>> h()
  {
    return Collections.unmodifiableCollection(k(q2.a));
  }
  
  public boolean l(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      return false;
    }
    return ((b)this.b.get(paramString)).b();
  }
  
  public void p(String paramString)
  {
    this.b.remove(paramString);
  }
  
  public void q(String paramString, g2 paramg2, t2<?> paramt2)
  {
    i(paramString, paramg2, paramt2).e(true);
  }
  
  public void r(String paramString, g2 paramg2, t2<?> paramt2)
  {
    i(paramString, paramg2, paramt2).f(true);
  }
  
  public void s(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      return;
    }
    b localb = (b)this.b.get(paramString);
    localb.f(false);
    if (!localb.a()) {
      this.b.remove(paramString);
    }
  }
  
  public void t(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      return;
    }
    b localb = (b)this.b.get(paramString);
    localb.e(false);
    if (!localb.b()) {
      this.b.remove(paramString);
    }
  }
  
  public void u(String paramString, g2 paramg2, t2<?> paramt2)
  {
    if (!this.b.containsKey(paramString)) {
      return;
    }
    paramg2 = new b(paramg2, paramt2);
    paramt2 = (b)this.b.get(paramString);
    paramg2.f(paramt2.b());
    paramg2.e(paramt2.a());
    this.b.put(paramString, paramg2);
  }
  
  private static abstract interface a
  {
    public abstract boolean a(r2.b paramb);
  }
  
  private static final class b
  {
    private final g2 a;
    private final t2<?> b;
    private boolean c = false;
    private boolean d = false;
    
    b(g2 paramg2, t2<?> paramt2)
    {
      this.a = paramg2;
      this.b = paramt2;
    }
    
    boolean a()
    {
      return this.d;
    }
    
    boolean b()
    {
      return this.c;
    }
    
    g2 c()
    {
      return this.a;
    }
    
    t2<?> d()
    {
      return this.b;
    }
    
    void e(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }
    
    void f(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.r2
 * JD-Core Version:    0.7.0.1
 */