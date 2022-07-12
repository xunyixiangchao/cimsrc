package x2;

import g0.a;
import g0.g;

public final class b<K, V>
  extends a<K, V>
{
  private int i;
  
  public void clear()
  {
    this.i = 0;
    super.clear();
  }
  
  public int hashCode()
  {
    if (this.i == 0) {
      this.i = super.hashCode();
    }
    return this.i;
  }
  
  public void j(g<? extends K, ? extends V> paramg)
  {
    this.i = 0;
    super.j(paramg);
  }
  
  public V k(int paramInt)
  {
    this.i = 0;
    return super.k(paramInt);
  }
  
  public V l(int paramInt, V paramV)
  {
    this.i = 0;
    return super.l(paramInt, paramV);
  }
  
  public V put(K paramK, V paramV)
  {
    this.i = 0;
    return super.put(paramK, paramV);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.b
 * JD-Core Version:    0.7.0.1
 */