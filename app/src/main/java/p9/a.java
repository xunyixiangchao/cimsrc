package p9;

import a9.f;

public abstract class a
{
  private final String a;
  private final boolean b;
  private c c;
  private long d;
  
  public a(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
    this.d = -1L;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final long c()
  {
    return this.d;
  }
  
  public final c d()
  {
    return this.c;
  }
  
  public final void e(c paramc)
  {
    f.f(paramc, "queue");
    c localc = this.c;
    if (localc == paramc) {
      return;
    }
    int i;
    if (localc == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.c = paramc;
      return;
    }
    throw new IllegalStateException("task is in multiple queues".toString());
  }
  
  public abstract long f();
  
  public final void g(long paramLong)
  {
    this.d = paramLong;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p9.a
 * JD-Core Version:    0.7.0.1
 */