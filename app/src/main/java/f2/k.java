package f2;

import b2.f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import x0.e;
import x2.h;
import x2.l;
import y2.a;
import y2.a.d;
import y2.a.f;
import y2.c;

public class k
{
  private final h<f, String> a = new h(1000L);
  private final e<b> b = a.d(10, new a());
  
  private String a(f paramf)
  {
    b localb = (b)x2.k.d(this.b.b());
    try
    {
      paramf.b(localb.a);
      paramf = l.w(localb.a.digest());
      return paramf;
    }
    finally
    {
      this.b.a(localb);
    }
  }
  
  public String b(f paramf)
  {
    synchronized (this.a)
    {
      ??? = (String)this.a.g(paramf);
      ??? = ???;
      if (??? == null) {
        ??? = a(paramf);
      }
      synchronized (this.a)
      {
        this.a.k(paramf, ???);
        return ???;
      }
    }
  }
  
  class a
    implements a.d<k.b>
  {
    a() {}
    
    public k.b b()
    {
      try
      {
        k.b localb = new k.b(MessageDigest.getInstance("SHA-256"));
        return localb;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException(localNoSuchAlgorithmException);
      }
    }
  }
  
  private static final class b
    implements a.f
  {
    final MessageDigest a;
    private final c b = c.a();
    
    b(MessageDigest paramMessageDigest)
    {
      this.a = paramMessageDigest;
    }
    
    public c e()
    {
      return this.b;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.k
 * JD-Core Version:    0.7.0.1
 */