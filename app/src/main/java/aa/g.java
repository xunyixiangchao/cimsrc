package aa;

import a9.f;

public abstract class g
  implements x
{
  private final x a;
  
  public g(x paramx)
  {
    this.a = paramx;
  }
  
  public final x a()
  {
    return this.a;
  }
  
  public y c()
  {
    return this.a.c();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public long k(b paramb, long paramLong)
  {
    f.f(paramb, "sink");
    return this.a.k(paramb, paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append('(');
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.g
 * JD-Core Version:    0.7.0.1
 */