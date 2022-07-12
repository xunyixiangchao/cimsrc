package f2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import x2.k;

final class c
{
  private final Map<String, a> a = new HashMap();
  private final b b = new b();
  
  void a(String paramString)
  {
    try
    {
      a locala2 = (a)this.a.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = this.b.a();
        this.a.put(paramString, locala1);
      }
      locala1.b += 1;
      locala1.a.lock();
      return;
    }
    finally {}
  }
  
  void b(String paramString)
  {
    try
    {
      a locala = (a)k.d(this.a.get(paramString));
      int i = locala.b;
      if (i >= 1)
      {
        i -= 1;
        locala.b = i;
        if (i == 0)
        {
          localObject = (a)this.a.remove(paramString);
          if (localObject.equals(locala))
          {
            this.b.b((a)localObject);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Removed the wrong lock, expected to remove: ");
            localStringBuilder.append(locala);
            localStringBuilder.append(", but actually removed: ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", safeKey: ");
            localStringBuilder.append(paramString);
            throw new IllegalStateException(localStringBuilder.toString());
          }
        }
        locala.a.unlock();
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot release a lock that is not held, safeKey: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", interestedThreads: ");
      ((StringBuilder)localObject).append(locala.b);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    finally {}
  }
  
  private static class a
  {
    final Lock a = new ReentrantLock();
    int b;
  }
  
  private static class b
  {
    private final Queue<c.a> a = new ArrayDeque();
    
    c.a a()
    {
      synchronized (this.a)
      {
        c.a locala = (c.a)this.a.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new c.a();
        }
        return ???;
      }
    }
    
    void b(c.a parama)
    {
      synchronized (this.a)
      {
        if (this.a.size() < 10) {
          this.a.offer(parama);
        }
        return;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.c
 * JD-Core Version:    0.7.0.1
 */