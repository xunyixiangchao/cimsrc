package androidx.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class z
{
  private final HashMap<String, x> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).a();
    }
    this.a.clear();
  }
  
  final x b(String paramString)
  {
    return (x)this.a.get(paramString);
  }
  
  Set<String> c()
  {
    return new HashSet(this.a.keySet());
  }
  
  final void d(String paramString, x paramx)
  {
    paramString = (x)this.a.put(paramString, paramx);
    if (paramString != null) {
      paramString.d();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.z
 * JD-Core Version:    0.7.0.1
 */