package q9;

import a9.f;
import l9.a;
import l9.x;

public abstract interface n
{
  public abstract boolean a(i parami);
  
  public abstract c b();
  
  public abstract a c();
  
  public abstract boolean d(x paramx);
  
  public abstract boolean i();
  
  public static final class a
  {
    private final n.c a;
    private final n.c b;
    private final Throwable c;
    
    public a(n.c paramc1, n.c paramc2, Throwable paramThrowable)
    {
      this.a = paramc1;
      this.b = paramc2;
      this.c = paramThrowable;
    }
    
    public final n.c a()
    {
      return this.b;
    }
    
    public final Throwable b()
    {
      return this.c;
    }
    
    public final n.c c()
    {
      return this.b;
    }
    
    public final n.c d()
    {
      return this.a;
    }
    
    public final Throwable e()
    {
      return this.c;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (!f.a(this.a, paramObject.a)) {
        return false;
      }
      if (!f.a(this.b, paramObject.b)) {
        return false;
      }
      return f.a(this.c, paramObject.c);
    }
    
    public final boolean f()
    {
      return (this.b == null) && (this.c == null);
    }
    
    public int hashCode()
    {
      int k = this.a.hashCode();
      Object localObject = this.b;
      int j = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = localObject.hashCode();
      }
      localObject = this.c;
      if (localObject != null) {
        j = ((Throwable)localObject).hashCode();
      }
      return (k * 31 + i) * 31 + j;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConnectResult(plan=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", nextPlan=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", throwable=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
  }
  
  public static final class b {}
  
  public static abstract interface c
  {
    public abstract c a();
    
    public abstract n.a b();
    
    public abstract i c();
    
    public abstract void cancel();
    
    public abstract boolean d();
    
    public abstract n.a f();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.n
 * JD-Core Version:    0.7.0.1
 */