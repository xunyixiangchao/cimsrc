package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class g<K extends l, V>
{
  private final a<K, V> a = new a();
  private final Map<K, a<K, V>> b = new HashMap();
  
  private void b(a<K, V> parama)
  {
    e(parama);
    a locala = this.a;
    parama.d = locala;
    parama.c = locala.c;
    g(parama);
  }
  
  private void c(a<K, V> parama)
  {
    e(parama);
    a locala = this.a;
    parama.d = locala.d;
    parama.c = locala;
    g(parama);
  }
  
  private static <K, V> void e(a<K, V> parama)
  {
    a locala = parama.d;
    locala.c = parama.c;
    parama.c.d = locala;
  }
  
  private static <K, V> void g(a<K, V> parama)
  {
    parama.c.d = parama;
    parama.d.c = parama;
  }
  
  public V a(K paramK)
  {
    a locala = (a)this.b.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      this.b.put(paramK, locala);
      paramK = locala;
    }
    else
    {
      paramK.a();
      paramK = locala;
    }
    b(paramK);
    return paramK.b();
  }
  
  public void d(K paramK, V paramV)
  {
    a locala = (a)this.b.get(paramK);
    if (locala == null)
    {
      locala = new a(paramK);
      c(locala);
      this.b.put(paramK, locala);
      paramK = locala;
    }
    else
    {
      paramK.a();
      paramK = locala;
    }
    paramK.a(paramV);
  }
  
  public V f()
  {
    a locala = this.a;
    for (;;)
    {
      locala = locala.d;
      if (locala.equals(this.a)) {
        break;
      }
      Object localObject = locala.b();
      if (localObject != null) {
        return localObject;
      }
      e(locala);
      this.b.remove(locala.a);
      ((l)locala.a).a();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    a locala = this.a.c;
    int i = 0;
    while (!locala.equals(this.a))
    {
      i = 1;
      localStringBuilder.append('{');
      localStringBuilder.append(locala.a);
      localStringBuilder.append(':');
      localStringBuilder.append(locala.c());
      localStringBuilder.append("}, ");
      locala = locala.c;
    }
    if (i != 0) {
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    }
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
  
  private static class a<K, V>
  {
    final K a;
    private List<V> b;
    a<K, V> c = this;
    a<K, V> d = this;
    
    a()
    {
      this(null);
    }
    
    a(K paramK)
    {
      this.a = paramK;
    }
    
    public void a(V paramV)
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      this.b.add(paramV);
    }
    
    public V b()
    {
      int i = c();
      if (i > 0) {
        return this.b.remove(i - 1);
      }
      return null;
    }
    
    public int c()
    {
      List localList = this.b;
      if (localList != null) {
        return localList.size();
      }
      return 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e2.g
 * JD-Core Version:    0.7.0.1
 */