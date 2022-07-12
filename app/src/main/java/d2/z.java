package d2;

import android.util.Log;
import com.bumptech.glide.load.data.d.a;
import f2.a.b;
import h2.n.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

class z
  implements f, f.a
{
  private final g<?> a;
  private final f.a b;
  private volatile int c;
  private volatile c d;
  private volatile Object e;
  private volatile n.a<?> f;
  private volatile d g;
  
  z(g<?> paramg, f.a parama)
  {
    this.a = paramg;
    this.b = parama;
  }
  
  private boolean d(Object paramObject)
  {
    long l = x2.g.b();
    int i = 1;
    try
    {
      com.bumptech.glide.load.data.e locale = this.a.o(paramObject);
      Object localObject2 = locale.a();
      Object localObject1 = this.a.q(localObject2);
      Object localObject3 = new e((b2.d)localObject1, localObject2, this.a.k());
      localObject2 = new d(this.f.a, this.a.p());
      f2.a locala = this.a.d();
      locala.a((b2.f)localObject2, (a.b)localObject3);
      boolean bool = Log.isLoggable("SourceGenerator", 2);
      if (bool)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Finished encoding source to cache, key: ");
        ((StringBuilder)localObject3).append(localObject2);
        ((StringBuilder)localObject3).append(", data: ");
        ((StringBuilder)localObject3).append(paramObject);
        ((StringBuilder)localObject3).append(", encoder: ");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(", duration: ");
        ((StringBuilder)localObject3).append(x2.g.a(l));
        Log.v("SourceGenerator", ((StringBuilder)localObject3).toString());
      }
      if (locala.b((b2.f)localObject2) != null)
      {
        this.g = ((d)localObject2);
        this.d = new c(Collections.singletonList(this.f.a), this.a, this);
        this.f.c.b();
        return true;
      }
      if (Log.isLoggable("SourceGenerator", 3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Attempt to write: ");
        ((StringBuilder)localObject1).append(this.g);
        ((StringBuilder)localObject1).append(", data: ");
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append(" to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
        Log.d("SourceGenerator", ((StringBuilder)localObject1).toString());
      }
      try
      {
        this.b.c(this.f.a, locale.a(), this.f.c, this.f.c.e(), this.f.a);
        return false;
      }
      finally {}
      if (i != 0) {
        break label399;
      }
    }
    finally
    {
      i = 0;
    }
    this.f.c.b();
    label399:
    throw paramObject;
  }
  
  private boolean f()
  {
    return this.c < this.a.g().size();
  }
  
  private void j(final n.a<?> parama)
  {
    this.f.c.f(this.a.l(), new a(parama));
  }
  
  public void a()
  {
    throw new UnsupportedOperationException();
  }
  
  public void b(b2.f paramf, Exception paramException, com.bumptech.glide.load.data.d<?> paramd, b2.a parama)
  {
    this.b.b(paramf, paramException, paramd, this.f.c.e());
  }
  
  public void c(b2.f paramf1, Object paramObject, com.bumptech.glide.load.data.d<?> paramd, b2.a parama, b2.f paramf2)
  {
    this.b.c(paramf1, paramObject, paramd, this.f.c.e(), paramf1);
  }
  
  public void cancel()
  {
    n.a locala = this.f;
    if (locala != null) {
      locala.c.cancel();
    }
  }
  
  public boolean e()
  {
    if (this.e != null)
    {
      Object localObject = this.e;
      this.e = null;
      try
      {
        bool = d(localObject);
        if (!bool) {
          return true;
        }
      }
      catch (IOException localIOException)
      {
        if (Log.isLoggable("SourceGenerator", 3)) {
          Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", localIOException);
        }
      }
    }
    if ((this.d != null) && (this.d.e())) {
      return true;
    }
    this.d = null;
    this.f = null;
    for (boolean bool = false; (!bool) && (f()); bool = true)
    {
      label79:
      List localList = this.a.g();
      int i = this.c;
      this.c = (i + 1);
      this.f = ((n.a)localList.get(i));
      if ((this.f == null) || ((!this.a.e().c(this.f.c.e())) && (!this.a.u(this.f.c.a())))) {
        break label79;
      }
      j(this.f);
    }
    return bool;
  }
  
  boolean g(n.a<?> parama)
  {
    n.a locala = this.f;
    return (locala != null) && (locala == parama);
  }
  
  void h(n.a<?> parama, Object paramObject)
  {
    Object localObject = this.a.e();
    if ((paramObject != null) && (((j)localObject).c(parama.c.e())))
    {
      this.e = paramObject;
      this.b.a();
      return;
    }
    localObject = this.b;
    b2.f localf = parama.a;
    parama = parama.c;
    ((f.a)localObject).c(localf, paramObject, parama, parama.e(), this.g);
  }
  
  void i(n.a<?> parama, Exception paramException)
  {
    f.a locala = this.b;
    d locald = this.g;
    parama = parama.c;
    locala.b(locald, paramException, parama, parama.e());
  }
  
  class a
    implements d.a<Object>
  {
    a(n.a parama) {}
    
    public void c(Exception paramException)
    {
      if (z.this.g(parama)) {
        z.this.i(parama, paramException);
      }
    }
    
    public void d(Object paramObject)
    {
      if (z.this.g(parama)) {
        z.this.h(parama, paramObject);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.z
 * JD-Core Version:    0.7.0.1
 */