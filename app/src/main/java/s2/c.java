package s2;

import d2.i;
import d2.t;
import g0.a;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import x2.j;

public class c
{
  private static final t<?, ?, ?> c = new t(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.emptyList(), new p2.g(), null)), null);
  private final a<j, t<?, ?, ?>> a = new a();
  private final AtomicReference<j> b = new AtomicReference();
  
  private j b(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    j localj2 = (j)this.b.getAndSet(null);
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    localj1.a(paramClass1, paramClass2, paramClass3);
    return localj1;
  }
  
  public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> arg1, Class<TResource> paramClass1, Class<Transcode> paramClass2)
  {
    paramClass1 = b(???, paramClass1, paramClass2);
    synchronized (this.a)
    {
      paramClass2 = (t)this.a.get(paramClass1);
      this.b.set(paramClass1);
      return paramClass2;
    }
  }
  
  public boolean c(t<?, ?, ?> paramt)
  {
    return c.equals(paramt);
  }
  
  public void d(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3, t<?, ?, ?> paramt)
  {
    synchronized (this.a)
    {
      a locala2 = this.a;
      paramClass1 = new j(paramClass1, paramClass2, paramClass3);
      if (paramt == null) {
        paramt = c;
      }
      locala2.put(paramClass1, paramt);
      return;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s2.c
 * JD-Core Version:    0.7.0.1
 */