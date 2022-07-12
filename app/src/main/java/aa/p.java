package aa;

import a9.f;
import java.io.OutputStream;

final class p
  implements v
{
  private final OutputStream a;
  private final y b;
  
  public p(OutputStream paramOutputStream, y paramy)
  {
    this.a = paramOutputStream;
    this.b = paramy;
  }
  
  public void L(b paramb, long paramLong)
  {
    f.f(paramb, "source");
    c0.b(paramb.z0(), 0L, paramLong);
    while (paramLong > 0L)
    {
      this.b.f();
      s locals = paramb.a;
      f.c(locals);
      int i = (int)Math.min(paramLong, locals.c - locals.b);
      this.a.write(locals.a, locals.b, i);
      locals.b += i;
      long l2 = i;
      long l1 = paramLong - l2;
      paramb.y0(paramb.z0() - l2);
      paramLong = l1;
      if (locals.b == locals.c)
      {
        paramb.a = locals.b();
        t.b(locals);
        paramLong = l1;
      }
    }
  }
  
  public y c()
  {
    return this.b;
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
    localStringBuilder.append("sink(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.p
 * JD-Core Version:    0.7.0.1
 */