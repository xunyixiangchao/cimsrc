package s;

import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import t.a;

public final class r1<T>
  implements w1<T>
{
  final r<b<T>> a = new r();
  private final Map<w1.a<? super T>, a<T>> b = new HashMap();
  
  public void a(w1.a<? super T> parama)
  {
    synchronized (this.b)
    {
      parama = (a)this.b.remove(parama);
      if (parama != null)
      {
        parama.c();
        a.d().execute(new o1(this, parama));
      }
      return;
    }
  }
  
  public void b(Executor paramExecutor, w1.a<? super T> parama)
  {
    synchronized (this.b)
    {
      a locala = (a)this.b.get(parama);
      if (locala != null) {
        locala.c();
      }
      paramExecutor = new a(paramExecutor, parama);
      this.b.put(parama, paramExecutor);
      a.d().execute(new p1(this, locala, paramExecutor));
      return;
    }
  }
  
  public void g(T paramT)
  {
    this.a.m(b.b(paramT));
  }
  
  private static final class a<T>
    implements s<r1.b<T>>
  {
    final AtomicBoolean a = new AtomicBoolean(true);
    final w1.a<? super T> b;
    final Executor c;
    
    a(Executor paramExecutor, w1.a<? super T> parama)
    {
      this.c = paramExecutor;
      this.b = parama;
    }
    
    void c()
    {
      this.a.set(false);
    }
    
    public void e(r1.b<T> paramb)
    {
      this.c.execute(new q1(this, paramb));
    }
  }
  
  public static final class b<T>
  {
    private final T a;
    private final Throwable b;
    
    private b(T paramT, Throwable paramThrowable)
    {
      this.a = paramT;
      this.b = paramThrowable;
    }
    
    static <T> b<T> b(T paramT)
    {
      return new b(paramT, null);
    }
    
    public boolean a()
    {
      return this.b == null;
    }
    
    public Throwable c()
    {
      return this.b;
    }
    
    public T d()
    {
      if (a()) {
        return this.a;
      }
      throw new IllegalStateException("Result contains an error. Does not contain a value.");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[Result: <");
      StringBuilder localStringBuilder1;
      Object localObject;
      if (a())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Value: ");
        localObject = this.a;
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Error: ");
        localObject = this.b;
      }
      localStringBuilder1.append(localObject);
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder2.append(">]");
      return localStringBuilder2.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.r1
 * JD-Core Version:    0.7.0.1
 */