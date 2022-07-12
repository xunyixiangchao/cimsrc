package t2;

import android.graphics.drawable.Drawable;
import b2.a;
import d2.q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import v2.b;
import x2.l;

public class g<R>
  implements d<R>, h<R>
{
  private static final a k = new a();
  private final int a;
  private final int b;
  private final boolean c;
  private final a d;
  private R e;
  private e f;
  private boolean g;
  private boolean h;
  private boolean i;
  private q j;
  
  public g(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, true, k);
  }
  
  g(int paramInt1, int paramInt2, boolean paramBoolean, a parama)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
    this.d = parama;
  }
  
  private R n(Long paramLong)
  {
    try
    {
      if ((this.c) && (!isDone())) {
        l.a();
      }
      if (!this.g)
      {
        if (!this.i)
        {
          if (this.h)
          {
            paramLong = this.e;
            return paramLong;
          }
          if (paramLong == null)
          {
            this.d.b(this, 0L);
          }
          else if (paramLong.longValue() > 0L)
          {
            long l1 = System.currentTimeMillis();
            long l2 = paramLong.longValue() + l1;
            while ((!isDone()) && (l1 < l2))
            {
              this.d.b(this, l2 - l1);
              l1 = System.currentTimeMillis();
            }
          }
          if (!Thread.interrupted())
          {
            if (!this.i)
            {
              if (!this.g)
              {
                if (this.h)
                {
                  paramLong = this.e;
                  return paramLong;
                }
                throw new TimeoutException();
              }
              throw new CancellationException();
            }
            throw new ExecutionException(this.j);
          }
          throw new InterruptedException();
        }
        throw new ExecutionException(this.j);
      }
      throw new CancellationException();
    }
    finally {}
  }
  
  public void a() {}
  
  public void b(u2.g paramg) {}
  
  public void c(Drawable paramDrawable) {}
  
  public boolean cancel(boolean paramBoolean)
  {
    try
    {
      if (isDone()) {
        return false;
      }
      this.g = true;
      this.d.a(this);
      e locale = null;
      if (paramBoolean)
      {
        locale = this.f;
        this.f = null;
      }
      if (locale != null) {
        locale.clear();
      }
      return true;
    }
    finally {}
  }
  
  public void d() {}
  
  public boolean e(R paramR, Object paramObject, u2.h<R> paramh, a parama, boolean paramBoolean)
  {
    try
    {
      this.h = true;
      this.e = paramR;
      this.d.a(this);
      return false;
    }
    finally
    {
      paramR = finally;
      throw paramR;
    }
  }
  
  public void f(R paramR, b<? super R> paramb) {}
  
  public void g(Drawable paramDrawable) {}
  
  public R get()
  {
    try
    {
      Object localObject = n(null);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new AssertionError(localTimeoutException);
    }
  }
  
  public R get(long paramLong, TimeUnit paramTimeUnit)
  {
    return n(Long.valueOf(paramTimeUnit.toMillis(paramLong)));
  }
  
  public void i(u2.g paramg)
  {
    paramg.e(this.a, this.b);
  }
  
  public boolean isCancelled()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isDone()
  {
    try
    {
      if ((!this.g) && (!this.h))
      {
        bool = this.i;
        if (!bool)
        {
          bool = false;
          break label35;
        }
      }
      boolean bool = true;
      label35:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public e j()
  {
    try
    {
      e locale = this.f;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void k(Drawable paramDrawable) {}
  
  public void l(e parame)
  {
    try
    {
      this.f = parame;
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public boolean m(q paramq, Object paramObject, u2.h<R> paramh, boolean paramBoolean)
  {
    try
    {
      this.i = true;
      this.j = paramq;
      this.d.a(this);
      return false;
    }
    finally
    {
      paramq = finally;
      throw paramq;
    }
  }
  
  public void onDestroy() {}
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(super.toString());
    ((StringBuilder)localObject1).append("[status=");
    String str = ((StringBuilder)localObject1).toString();
    try
    {
      boolean bool = this.g;
      Object localObject3 = null;
      if (bool)
      {
        localObject1 = "CANCELLED";
      }
      else if (this.i)
      {
        localObject1 = "FAILURE";
      }
      else if (this.h)
      {
        localObject1 = "SUCCESS";
      }
      else
      {
        localObject1 = "PENDING";
        localObject3 = this.f;
      }
      if (localObject3 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", request=[");
        localStringBuilder.append(localObject3);
        localStringBuilder.append("]]");
        return localStringBuilder.toString();
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("]");
      return ((StringBuilder)localObject3).toString();
    }
    finally {}
  }
  
  static class a
  {
    void a(Object paramObject)
    {
      paramObject.notifyAll();
    }
    
    void b(Object paramObject, long paramLong)
    {
      paramObject.wait(paramLong);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t2.g
 * JD-Core Version:    0.7.0.1
 */