package s;

import android.view.Surface;
import androidx.concurrent.futures.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import u.f;
import u7.a;

public final class a1
{
  public static void e(List<v0> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((v0)paramList.next()).d();
    }
  }
  
  public static void f(List<v0> paramList)
  {
    if (!paramList.isEmpty())
    {
      int i = 0;
      for (;;)
      {
        int k = i;
        try
        {
          ((v0)paramList.get(i)).j();
          int j = i + 1;
          k = j;
          int m = paramList.size();
          i = j;
          if (j >= m) {}
        }
        catch (v0.a locala)
        {
          i = k - 1;
          while (i >= 0)
          {
            ((v0)paramList.get(i)).d();
            i -= 1;
          }
          throw locala;
        }
      }
    }
  }
  
  public static a<List<Surface>> k(Collection<v0> paramCollection, boolean paramBoolean, long paramLong, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(f.j(((v0)paramCollection.next()).h()));
    }
    return androidx.concurrent.futures.c.a(new w0(localArrayList, paramScheduledExecutorService, paramExecutor, paramLong, paramBoolean));
  }
  
  class a
    implements u.c<List<Surface>>
  {
    a(c.a parama, ScheduledFuture paramScheduledFuture) {}
    
    public void a(Throwable paramThrowable)
    {
      this.b.c(Collections.unmodifiableList(Collections.emptyList()));
      this.c.cancel(true);
    }
    
    public void c(List<Surface> paramList)
    {
      paramList = new ArrayList(paramList);
      if (this.a) {
        paramList.removeAll(Collections.singleton(null));
      }
      this.b.c(paramList);
      this.c.cancel(true);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.a1
 * JD-Core Version:    0.7.0.1
 */