package p8;

import a9.f;
import b9.a;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class y
  implements Map, Serializable, a
{
  public static final y a = new y();
  
  public boolean a(Void paramVoid)
  {
    f.f(paramVoid, "value");
    return false;
  }
  
  public Void b(Object paramObject)
  {
    return null;
  }
  
  public Set<Map.Entry> c()
  {
    return z.a;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public Set<Object> d()
  {
    return z.a;
  }
  
  public int e()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Map)) && (((Map)paramObject).isEmpty());
  }
  
  public Collection f()
  {
    return x.a;
  }
  
  public Void g(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public void putAll(Map paramMap)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public String toString()
  {
    return "{}";
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p8.y
 * JD-Core Version:    0.7.0.1
 */