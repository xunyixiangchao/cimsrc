package j1;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import u0.e;
import x0.i;

public abstract class a<D>
  extends c<D>
{
  private final Executor j;
  volatile a<D>.a k;
  volatile a<D>.a l;
  long m;
  long n = -10000L;
  Handler o;
  
  public a(Context paramContext)
  {
    this(paramContext, d.h);
  }
  
  private a(Context paramContext, Executor paramExecutor)
  {
    super(paramContext);
    this.j = paramExecutor;
  }
  
  public void A() {}
  
  void B(a<D>.a parama, D paramD)
  {
    G(paramD);
    if (this.l == parama)
    {
      v();
      this.n = SystemClock.uptimeMillis();
      this.l = null;
      e();
      D();
    }
  }
  
  void C(a<D>.a parama, D paramD)
  {
    if (this.k != parama)
    {
      B(parama, paramD);
      return;
    }
    if (j())
    {
      G(paramD);
      return;
    }
    c();
    this.n = SystemClock.uptimeMillis();
    this.k = null;
    f(paramD);
  }
  
  void D()
  {
    if ((this.l == null) && (this.k != null))
    {
      if (this.k.l)
      {
        this.k.l = false;
        this.o.removeCallbacks(this.k);
      }
      if ((this.m > 0L) && (SystemClock.uptimeMillis() < this.n + this.m))
      {
        this.k.l = true;
        this.o.postAtTime(this.k, this.n + this.m);
        return;
      }
      this.k.c(this.j, null);
    }
  }
  
  public boolean E()
  {
    return this.l != null;
  }
  
  public abstract D F();
  
  public abstract void G(D paramD);
  
  protected D H()
  {
    return F();
  }
  
  @Deprecated
  public void g(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.g(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.k != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.k.l);
    }
    if (this.l != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(this.l);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(this.l.l);
    }
    if (this.m != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      i.c(this.m, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      i.b(this.n, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  protected boolean n()
  {
    if (this.k != null)
    {
      if (!this.e) {
        this.h = true;
      }
      if (this.l != null)
      {
        if (this.k.l)
        {
          this.k.l = false;
          this.o.removeCallbacks(this.k);
        }
        this.k = null;
        return false;
      }
      if (this.k.l)
      {
        this.k.l = false;
        this.o.removeCallbacks(this.k);
        this.k = null;
        return false;
      }
      boolean bool = this.k.a(false);
      if (bool)
      {
        this.l = this.k;
        A();
      }
      this.k = null;
      return bool;
    }
    return false;
  }
  
  protected void p()
  {
    super.p();
    b();
    this.k = new a();
    D();
  }
  
  final class a
    extends d<Void, Void, D>
    implements Runnable
  {
    private final CountDownLatch k = new CountDownLatch(1);
    boolean l;
    
    a() {}
    
    protected void h(D paramD)
    {
      try
      {
        a.this.B(this, paramD);
        return;
      }
      finally
      {
        this.k.countDown();
      }
    }
    
    protected void i(D paramD)
    {
      try
      {
        a.this.C(this, paramD);
        return;
      }
      finally
      {
        this.k.countDown();
      }
    }
    
    protected D n(Void... paramVarArgs)
    {
      try
      {
        paramVarArgs = a.this.H();
        return paramVarArgs;
      }
      catch (e paramVarArgs)
      {
        if (f()) {
          return null;
        }
        throw paramVarArgs;
      }
    }
    
    public void run()
    {
      this.l = false;
      a.this.D();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j1.a
 * JD-Core Version:    0.7.0.1
 */