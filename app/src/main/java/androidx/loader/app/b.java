package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import androidx.lifecycle.z;
import g0.h;
import j1.c;
import j1.c.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class b
  extends a
{
  static boolean c = false;
  private final l a;
  private final c b;
  
  b(l paraml, z paramz)
  {
    this.a = paraml;
    this.b = c.h(paramz);
  }
  
  private <D> c<D> f(int paramInt, Bundle paramBundle, a.a<D> parama, c<D> paramc)
  {
    try
    {
      this.b.n();
      c localc = parama.b(paramInt, paramBundle);
      if (localc != null)
      {
        if ((localc.getClass().isMemberClass()) && (!Modifier.isStatic(localc.getClass().getModifiers())))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
          paramBundle.append(localc);
          throw new IllegalArgumentException(paramBundle.toString());
        }
        paramBundle = new a(paramInt, paramBundle, localc, paramc);
        if (c)
        {
          paramc = new StringBuilder();
          paramc.append("  Created new loader ");
          paramc.append(paramBundle);
          Log.v("LoaderManager", paramc.toString());
        }
        this.b.l(paramInt, paramBundle);
        return paramBundle.t(this.a, parama);
      }
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    }
    finally
    {
      this.b.g();
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.b.j())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        if (c)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("destroyLoader in ");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(" of ");
          ((StringBuilder)localObject).append(paramInt);
          Log.v("LoaderManager", ((StringBuilder)localObject).toString());
        }
        Object localObject = this.b.i(paramInt);
        if (localObject != null)
        {
          ((a)localObject).p(true);
          this.b.m(paramInt);
        }
        return;
      }
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  @Deprecated
  public void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.b.f(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public <D> c<D> d(int paramInt, Bundle paramBundle, a.a<D> parama)
  {
    if (!this.b.j())
    {
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        a locala = this.b.i(paramInt);
        if (c)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initLoader in ");
          localStringBuilder.append(this);
          localStringBuilder.append(": args=");
          localStringBuilder.append(paramBundle);
          Log.v("LoaderManager", localStringBuilder.toString());
        }
        if (locala == null) {
          return f(paramInt, paramBundle, parama, null);
        }
        if (c)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("  Re-using existing loader ");
          paramBundle.append(locala);
          Log.v("LoaderManager", paramBundle.toString());
        }
        return locala.t(this.a, parama);
      }
      throw new IllegalStateException("initLoader must be called on the main thread");
    }
    throw new IllegalStateException("Called while creating a loader");
  }
  
  public void e()
  {
    this.b.k();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    x0.b.a(this.a, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public static class a<D>
    extends r<D>
    implements c.c<D>
  {
    private final int l;
    private final Bundle m;
    private final c<D> n;
    private l o;
    private b.b<D> p;
    private c<D> q;
    
    a(int paramInt, Bundle paramBundle, c<D> paramc1, c<D> paramc2)
    {
      this.l = paramInt;
      this.m = paramBundle;
      this.n = paramc1;
      this.q = paramc2;
      paramc1.t(paramInt, this);
    }
    
    public void a(c<D> paramc, D paramD)
    {
      if (b.c)
      {
        paramc = new StringBuilder();
        paramc.append("onLoadComplete: ");
        paramc.append(this);
        Log.v("LoaderManager", paramc.toString());
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        o(paramD);
        return;
      }
      if (b.c) {
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
      }
      m(paramD);
    }
    
    protected void k()
    {
      if (b.c)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Starting: ");
        localStringBuilder.append(this);
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.n.w();
    }
    
    protected void l()
    {
      if (b.c)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Stopping: ");
        localStringBuilder.append(this);
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.n.x();
    }
    
    public void n(s<? super D> params)
    {
      super.n(params);
      this.o = null;
      this.p = null;
    }
    
    public void o(D paramD)
    {
      super.o(paramD);
      paramD = this.q;
      if (paramD != null)
      {
        paramD.u();
        this.q = null;
      }
    }
    
    c<D> p(boolean paramBoolean)
    {
      if (b.c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("  Destroying: ");
        ((StringBuilder)localObject).append(this);
        Log.v("LoaderManager", ((StringBuilder)localObject).toString());
      }
      this.n.b();
      this.n.a();
      Object localObject = this.p;
      if (localObject != null)
      {
        n((s)localObject);
        if (paramBoolean) {
          ((b.b)localObject).d();
        }
      }
      this.n.z(this);
      if (((localObject != null) && (!((b.b)localObject).c())) || (paramBoolean))
      {
        this.n.u();
        return this.q;
      }
      return this.n;
    }
    
    public void q(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.l);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.m);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.n);
      c localc = this.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      localc.g(localStringBuilder.toString(), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      if (this.p != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(this.p);
        paramFileDescriptor = this.p;
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append(paramString);
        paramArrayOfString.append("  ");
        paramFileDescriptor.b(paramArrayOfString.toString(), paramPrintWriter);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(r().d(f()));
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.println(h());
    }
    
    c<D> r()
    {
      return this.n;
    }
    
    void s()
    {
      l locall = this.o;
      b.b localb = this.p;
      if ((locall != null) && (localb != null))
      {
        super.n(localb);
        i(locall, localb);
      }
    }
    
    c<D> t(l paraml, a.a<D> parama)
    {
      parama = new b.b(this.n, parama);
      i(paraml, parama);
      b.b localb = this.p;
      if (localb != null) {
        n(localb);
      }
      this.o = paraml;
      this.p = parama;
      return this.n;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" : ");
      x0.b.a(this.n, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
  
  static class b<D>
    implements s<D>
  {
    private final c<D> a;
    private final a.a<D> b;
    private boolean c = false;
    
    b(c<D> paramc, a.a<D> parama)
    {
      this.a = paramc;
      this.b = parama;
    }
    
    public void a(D paramD)
    {
      if (b.c)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  onLoadFinished in ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(": ");
        localStringBuilder.append(this.a.d(paramD));
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      this.b.a(this.a, paramD);
      this.c = true;
    }
    
    public void b(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mDeliveredData=");
      paramPrintWriter.println(this.c);
    }
    
    boolean c()
    {
      return this.c;
    }
    
    void d()
    {
      if (this.c)
      {
        if (b.c)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("  Resetting: ");
          localStringBuilder.append(this.a);
          Log.v("LoaderManager", localStringBuilder.toString());
        }
        this.b.c(this.a);
      }
    }
    
    public String toString()
    {
      return this.b.toString();
    }
  }
  
  static class c
    extends x
  {
    private static final y.b e = new a();
    private h<b.a> c = new h();
    private boolean d = false;
    
    static c h(z paramz)
    {
      return (c)new y(paramz, e).a(c.class);
    }
    
    protected void d()
    {
      super.d();
      int j = this.c.n();
      int i = 0;
      while (i < j)
      {
        ((b.a)this.c.o(i)).p(true);
        i += 1;
      }
      this.c.b();
    }
    
    public void f(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      if (this.c.n() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("    ");
        localObject = ((StringBuilder)localObject).toString();
        int i = 0;
        while (i < this.c.n())
        {
          b.a locala = (b.a)this.c.o(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.c.k(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(locala.toString());
          locala.q((String)localObject, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          i += 1;
        }
      }
    }
    
    void g()
    {
      this.d = false;
    }
    
    <D> b.a<D> i(int paramInt)
    {
      return (b.a)this.c.e(paramInt);
    }
    
    boolean j()
    {
      return this.d;
    }
    
    void k()
    {
      int j = this.c.n();
      int i = 0;
      while (i < j)
      {
        ((b.a)this.c.o(i)).s();
        i += 1;
      }
    }
    
    void l(int paramInt, b.a parama)
    {
      this.c.l(paramInt, parama);
    }
    
    void m(int paramInt)
    {
      this.c.m(paramInt);
    }
    
    void n()
    {
      this.d = true;
    }
    
    static final class a
      implements y.b
    {
      public <T extends x> T a(Class<T> paramClass)
      {
        return new b.c();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.loader.app.b
 * JD-Core Version:    0.7.0.1
 */