package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class h
{
  AtomicReference<Object> a = new AtomicReference();
  
  public abstract void a(k paramk);
  
  public abstract c b();
  
  public abstract void c(k paramk);
  
  public static enum b
  {
    static
    {
      b localb1 = new b("ON_CREATE", 0);
      ON_CREATE = localb1;
      b localb2 = new b("ON_START", 1);
      ON_START = localb2;
      b localb3 = new b("ON_RESUME", 2);
      ON_RESUME = localb3;
      b localb4 = new b("ON_PAUSE", 3);
      ON_PAUSE = localb4;
      b localb5 = new b("ON_STOP", 4);
      ON_STOP = localb5;
      b localb6 = new b("ON_DESTROY", 5);
      ON_DESTROY = localb6;
      b localb7 = new b("ON_ANY", 6);
      ON_ANY = localb7;
      $VALUES = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7 };
    }
    
    private b() {}
    
    public static b a(h.c paramc)
    {
      int i = h.a.a[paramc.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return ON_PAUSE;
        }
        return ON_STOP;
      }
      return ON_DESTROY;
    }
    
    public static b c(h.c paramc)
    {
      int i = h.a.a[paramc.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5) {
            return null;
          }
          return ON_CREATE;
        }
        return ON_RESUME;
      }
      return ON_START;
    }
    
    public h.c b()
    {
      switch (h.a.b[ordinal()])
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append(" has no target state");
        throw new IllegalArgumentException(localStringBuilder.toString());
      case 6: 
        return h.c.a;
      case 5: 
        return h.c.e;
      case 3: 
      case 4: 
        return h.c.d;
      }
      return h.c.c;
    }
  }
  
  public static enum c
  {
    static
    {
      c localc1 = new c("DESTROYED", 0);
      a = localc1;
      c localc2 = new c("INITIALIZED", 1);
      b = localc2;
      c localc3 = new c("CREATED", 2);
      c = localc3;
      c localc4 = new c("STARTED", 3);
      d = localc4;
      c localc5 = new c("RESUMED", 4);
      e = localc5;
      f = new c[] { localc1, localc2, localc3, localc4, localc5 };
    }
    
    private c() {}
    
    public boolean a(c paramc)
    {
      return compareTo(paramc) >= 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.h
 * JD-Core Version:    0.7.0.1
 */