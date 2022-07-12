package v7;

import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;
import x7.h;

public final class o
  extends l
{
  private final h<String, l> a = new h();
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof o)) && (((o)paramObject).a.equals(this.a)));
  }
  
  public void h(String paramString, l paraml)
  {
    Object localObject = paraml;
    if (paraml == null) {
      localObject = n.a;
    }
    this.a.put(paramString, localObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Set<Map.Entry<String, l>> i()
  {
    return this.a.entrySet();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.o
 * JD-Core Version:    0.7.0.1
 */