package d2;

import b2.f;
import java.util.HashMap;
import java.util.Map;

final class s
{
  private final Map<f, l<?>> a = new HashMap();
  private final Map<f, l<?>> b = new HashMap();
  
  private Map<f, l<?>> b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return this.a;
  }
  
  l<?> a(f paramf, boolean paramBoolean)
  {
    return (l)b(paramBoolean).get(paramf);
  }
  
  void c(f paramf, l<?> paraml)
  {
    b(paraml.p()).put(paramf, paraml);
  }
  
  void d(f paramf, l<?> paraml)
  {
    Map localMap = b(paraml.p());
    if (paraml.equals(localMap.get(paramf))) {
      localMap.remove(paramf);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.s
 * JD-Core Version:    0.7.0.1
 */