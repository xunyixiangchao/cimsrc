package aa;

public abstract class f
  implements v
{
  private final v a;
  
  public f(v paramv)
  {
    this.a = paramv;
  }
  
  public void L(b paramb, long paramLong)
  {
    a9.f.f(paramb, "source");
    this.a.L(paramb, paramLong);
  }
  
  public y c()
  {
    return this.a.c();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
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
 * Qualified Name:     aa.f
 * JD-Core Version:    0.7.0.1
 */