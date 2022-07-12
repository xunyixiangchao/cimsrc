package s;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class y1
  implements s0
{
  protected static final Comparator<s0.a<?>> B;
  private static final y1 C;
  protected final TreeMap<s0.a<?>, Map<s0.c, Object>> A;
  
  static
  {
    x1 localx1 = x1.a;
    B = localx1;
    C = new y1(new TreeMap(localx1));
  }
  
  y1(TreeMap<s0.a<?>, Map<s0.c, Object>> paramTreeMap)
  {
    this.A = paramTreeMap;
  }
  
  public static y1 J()
  {
    return C;
  }
  
  public static y1 K(s0 params0)
  {
    if (y1.class.equals(params0.getClass())) {
      return (y1)params0;
    }
    TreeMap localTreeMap = new TreeMap(B);
    Iterator localIterator = params0.c().iterator();
    while (localIterator.hasNext())
    {
      s0.a locala = (s0.a)localIterator.next();
      Object localObject = params0.F(locala);
      ArrayMap localArrayMap = new ArrayMap();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        s0.c localc = (s0.c)((Iterator)localObject).next();
        localArrayMap.put(localc, params0.g(locala, localc));
      }
      localTreeMap.put(locala, localArrayMap);
    }
    return new y1(localTreeMap);
  }
  
  public Set<s0.c> F(s0.a<?> parama)
  {
    parama = (Map)this.A.get(parama);
    if (parama == null) {
      return Collections.emptySet();
    }
    return Collections.unmodifiableSet(parama.keySet());
  }
  
  public <ValueT> ValueT a(s0.a<ValueT> parama)
  {
    Object localObject = (Map)this.A.get(parama);
    if (localObject != null) {
      return ((Map)localObject).get((s0.c)Collections.min(((Map)localObject).keySet()));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Option does not exist: ");
    ((StringBuilder)localObject).append(parama);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public boolean b(s0.a<?> parama)
  {
    return this.A.containsKey(parama);
  }
  
  public Set<s0.a<?>> c()
  {
    return Collections.unmodifiableSet(this.A.keySet());
  }
  
  public s0.c d(s0.a<?> parama)
  {
    Object localObject = (Map)this.A.get(parama);
    if (localObject != null) {
      return (s0.c)Collections.min(((Map)localObject).keySet());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Option does not exist: ");
    ((StringBuilder)localObject).append(parama);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public <ValueT> ValueT e(s0.a<ValueT> parama, ValueT paramValueT)
  {
    try
    {
      parama = a(parama);
      return parama;
    }
    catch (IllegalArgumentException parama) {}
    return paramValueT;
  }
  
  public <ValueT> ValueT g(s0.a<ValueT> parama, s0.c paramc)
  {
    Object localObject = (Map)this.A.get(parama);
    if (localObject != null)
    {
      if (((Map)localObject).containsKey(paramc)) {
        return ((Map)localObject).get(paramc);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Option does not exist: ");
      ((StringBuilder)localObject).append(parama);
      ((StringBuilder)localObject).append(" with priority=");
      ((StringBuilder)localObject).append(paramc);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    paramc = new StringBuilder();
    paramc.append("Option does not exist: ");
    paramc.append(parama);
    throw new IllegalArgumentException(paramc.toString());
  }
  
  public void i(String paramString, s0.b paramb)
  {
    Object localObject = s0.a.a(paramString, Void.class);
    localObject = this.A.tailMap(localObject).entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
      if (!((s0.a)localEntry.getKey()).c().startsWith(paramString)) {
        return;
      }
    } while (paramb.a((s0.a)localEntry.getKey()));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.y1
 * JD-Core Version:    0.7.0.1
 */