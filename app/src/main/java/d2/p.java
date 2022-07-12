package d2;

import b2.f;
import x2.k;

class p<Z>
  implements v<Z>
{
  private final boolean a;
  private final boolean b;
  private final v<Z> c;
  private final a d;
  private final f e;
  private int f;
  private boolean g;
  
  p(v<Z> paramv, boolean paramBoolean1, boolean paramBoolean2, f paramf, a parama)
  {
    this.c = ((v)k.d(paramv));
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.e = paramf;
    this.d = ((a)k.d(parama));
  }
  
  public void a()
  {
    try
    {
      if (this.f <= 0)
      {
        if (!this.g)
        {
          this.g = true;
          if (this.b) {
            this.c.a();
          }
          return;
        }
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
      }
      throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }
    finally {}
  }
  
  void b()
  {
    try
    {
      if (!this.g)
      {
        this.f += 1;
        return;
      }
      throw new IllegalStateException("Cannot acquire a recycled resource");
    }
    finally {}
  }
  
  public int c()
  {
    return this.c.c();
  }
  
  public Class<Z> d()
  {
    return this.c.d();
  }
  
  v<Z> e()
  {
    return this.c;
  }
  
  boolean f()
  {
    return this.a;
  }
  
  void g()
  {
    for (;;)
    {
      try
      {
        int j = this.f;
        if (j > 0)
        {
          i = 1;
          j -= 1;
          this.f = j;
          if (j == 0) {
            if (i != 0) {
              this.d.d(this.e, this);
            }
          }
        }
        else
        {
          throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public Z get()
  {
    return this.c.get();
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("EngineResource{isMemoryCacheable=");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", listener=");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(", key=");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(", acquired=");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).append(", isRecycled=");
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append(", resource=");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append('}');
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  static abstract interface a
  {
    public abstract void d(f paramf, p<?> paramp);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.p
 * JD-Core Version:    0.7.0.1
 */