package s;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public final class u1
  extends y1
  implements t1
{
  private static final s0.c D = s0.c.c;
  
  private u1(TreeMap<s0.a<?>, Map<s0.c, Object>> paramTreeMap)
  {
    super(paramTreeMap);
  }
  
  public static u1 M()
  {
    return new u1(new TreeMap(y1.B));
  }
  
  public static u1 N(s0 params0)
  {
    TreeMap localTreeMap = new TreeMap(y1.B);
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
    return new u1(localTreeMap);
  }
  
  public <ValueT> void G(s0.a<ValueT> parama, ValueT paramValueT)
  {
    t(parama, D, paramValueT);
  }
  
  public <ValueT> ValueT O(s0.a<ValueT> parama)
  {
    return this.A.remove(parama);
  }
  
  public <ValueT> void t(s0.a<ValueT> parama, s0.c paramc, ValueT paramValueT)
  {
    Object localObject = (Map)this.A.get(parama);
    if (localObject == null)
    {
      localObject = new ArrayMap();
      this.A.put(parama, localObject);
      ((Map)localObject).put(paramc, paramValueT);
      return;
    }
    s0.c localc = (s0.c)Collections.min(((Map)localObject).keySet());
    if ((!Objects.equals(((Map)localObject).get(localc), paramValueT)) && (r0.a(localc, paramc)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Option values conflicts: ");
      localStringBuilder.append(parama.c());
      localStringBuilder.append(", existing value (");
      localStringBuilder.append(localc);
      localStringBuilder.append(")=");
      localStringBuilder.append(((Map)localObject).get(localc));
      localStringBuilder.append(", conflicting (");
      localStringBuilder.append(paramc);
      localStringBuilder.append(")=");
      localStringBuilder.append(paramValueT);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    ((Map)localObject).put(paramc, paramValueT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.u1
 * JD-Core Version:    0.7.0.1
 */