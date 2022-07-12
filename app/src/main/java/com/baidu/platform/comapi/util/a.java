package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public class a
{
  public static final a b = new a();
  private final Map<Class<?>, CopyOnWriteArraySet<b>> a = new HashMap();
  
  private a()
  {
    new HashMap();
  }
  
  public static a a()
  {
    return b;
  }
  
  private void a(c paramc, Object paramObject)
  {
    paramc.a(paramObject);
  }
  
  public void a(final Object paramObject)
  {
    if (this.a.containsKey(paramObject.getClass())) {
      try
      {
        Object localObject = (CopyOnWriteArraySet)this.a.get(paramObject.getClass());
        localObject = ((CopyOnWriteArraySet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          h.a(new a((b)((Iterator)localObject).next(), paramObject), 0L);
        }
        return;
      }
      finally {}
    }
  }
  
  class a
    implements Runnable
  {
    a(a.b paramb, Object paramObject) {}
    
    public void run()
    {
      a.a(a.this, this.a, paramObject);
    }
  }
  
  private class b
    implements a.c
  {
    private final a.c a;
    
    public void a(Object paramObject)
    {
      this.a.a(paramObject);
    }
    
    public boolean equals(Object paramObject)
    {
      return this.a.equals(paramObject);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Object paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.a
 * JD-Core Version:    0.7.0.1
 */