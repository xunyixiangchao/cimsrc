package x2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h<T, Y>
{
  private final Map<T, a<Y>> a = new LinkedHashMap(100, 0.75F, true);
  private final long b;
  private long c;
  private long d;
  
  public h(long paramLong)
  {
    this.b = paramLong;
    this.c = paramLong;
  }
  
  private void f()
  {
    m(this.c);
  }
  
  public void a()
  {
    m(0L);
  }
  
  public Y g(T paramT)
  {
    try
    {
      paramT = (a)this.a.get(paramT);
      if (paramT != null) {
        paramT = paramT.a;
      } else {
        paramT = null;
      }
      return paramT;
    }
    finally {}
  }
  
  public long h()
  {
    try
    {
      long l = this.c;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected int i(Y paramY)
  {
    return 1;
  }
  
  protected void j(T paramT, Y paramY) {}
  
  public Y k(T paramT, Y paramY)
  {
    try
    {
      int i = i(paramY);
      long l1 = i;
      long l2 = this.c;
      Object localObject = null;
      if (l1 >= l2)
      {
        j(paramT, paramY);
        return null;
      }
      if (paramY != null) {
        this.d += l1;
      }
      Map localMap = this.a;
      if (paramY == null) {
        locala = null;
      } else {
        locala = new a(paramY, i);
      }
      a locala = (a)localMap.put(paramT, locala);
      if (locala != null)
      {
        this.d -= locala.b;
        if (!locala.a.equals(paramY)) {
          j(paramT, locala.a);
        }
      }
      f();
      paramT = localObject;
      if (locala != null) {
        paramT = locala.a;
      }
      return paramT;
    }
    finally {}
  }
  
  public Y l(T paramT)
  {
    try
    {
      paramT = (a)this.a.remove(paramT);
      if (paramT == null) {
        return null;
      }
      this.d -= paramT.b;
      paramT = paramT.a;
      return paramT;
    }
    finally {}
  }
  
  protected void m(long paramLong)
  {
    try
    {
      while (this.d > paramLong)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        Object localObject2 = (Map.Entry)localIterator.next();
        a locala = (a)((Map.Entry)localObject2).getValue();
        this.d -= locala.b;
        localObject2 = ((Map.Entry)localObject2).getKey();
        localIterator.remove();
        j(localObject2, locala.a);
      }
      return;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  static final class a<Y>
  {
    final Y a;
    final int b;
    
    a(Y paramY, int paramInt)
    {
      this.a = paramY;
      this.b = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x2.h
 * JD-Core Version:    0.7.0.1
 */