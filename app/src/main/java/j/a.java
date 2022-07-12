package j;

import java.util.HashMap;
import java.util.Map.Entry;

public class a<K, V>
  extends b<K, V>
{
  private HashMap<K, b.c<K, V>> e = new HashMap();
  
  protected b.c<K, V> c(K paramK)
  {
    return (b.c)this.e.get(paramK);
  }
  
  public boolean contains(K paramK)
  {
    return this.e.containsKey(paramK);
  }
  
  public V g(K paramK, V paramV)
  {
    b.c localc = c(paramK);
    if (localc != null) {
      return localc.b;
    }
    this.e.put(paramK, f(paramK, paramV));
    return null;
  }
  
  public V h(K paramK)
  {
    Object localObject = super.h(paramK);
    this.e.remove(paramK);
    return localObject;
  }
  
  public Map.Entry<K, V> i(K paramK)
  {
    if (contains(paramK)) {
      return ((b.c)this.e.get(paramK)).d;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j.a
 * JD-Core Version:    0.7.0.1
 */