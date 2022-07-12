package aa;

import a9.f;
import java.util.concurrent.atomic.AtomicReference;

public final class t
{
  public static final t a = new t();
  private static final int b = 65536;
  private static final s c;
  private static final int d;
  private static final AtomicReference<s>[] e;
  
  static
  {
    int i = 0;
    c = new s(new byte[0], 0, 0, false, false);
    int j = Integer.highestOneBit(Runtime.getRuntime().availableProcessors() * 2 - 1);
    d = j;
    AtomicReference[] arrayOfAtomicReference = new AtomicReference[j];
    while (i < j)
    {
      arrayOfAtomicReference[i] = new AtomicReference();
      i += 1;
    }
    e = arrayOfAtomicReference;
  }
  
  private final AtomicReference<s> a()
  {
    int i = (int)(Thread.currentThread().getId() & d - 1L);
    return e[i];
  }
  
  public static final void b(s params)
  {
    f.f(params, "segment");
    int i;
    if ((params.f == null) && (params.g == null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (params.d) {
        return;
      }
      AtomicReference localAtomicReference = a.a();
      s locals = (s)localAtomicReference.get();
      if (locals == c) {
        return;
      }
      if (locals == null) {
        i = 0;
      } else {
        i = locals.c;
      }
      if (i >= b) {
        return;
      }
      params.f = locals;
      params.b = 0;
      params.c = (i + 8192);
      if (!localAtomicReference.compareAndSet(locals, params)) {
        params.f = null;
      }
      return;
    }
    throw new IllegalArgumentException("Failed requirement.".toString());
  }
  
  public static final s c()
  {
    AtomicReference localAtomicReference = a.a();
    s locals1 = c;
    s locals2 = (s)localAtomicReference.getAndSet(locals1);
    if (locals2 == locals1) {
      return new s();
    }
    if (locals2 == null)
    {
      localAtomicReference.set(null);
      return new s();
    }
    localAtomicReference.set(locals2.f);
    locals2.f = null;
    locals2.c = 0;
    return locals2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.t
 * JD-Core Version:    0.7.0.1
 */