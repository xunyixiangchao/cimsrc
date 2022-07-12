package m9;

import a9.f;
import aa.b;
import aa.d;
import l9.g0;
import l9.g0.b;
import l9.z;

public final class j
{
  public static final g0 a(d paramd, z paramz, final long paramLong)
  {
    f.f(paramd, "<this>");
    return new a(paramz, paramLong, paramd);
  }
  
  public static final void b(g0 paramg0)
  {
    f.f(paramg0, "<this>");
    l.f(paramg0.e0());
  }
  
  public static final g0 c(byte[] paramArrayOfByte, z paramz)
  {
    f.f(paramArrayOfByte, "<this>");
    return g0.b.a(new b().E0(paramArrayOfByte), paramz, paramArrayOfByte.length);
  }
  
  public static final class a
    extends g0
  {
    a(z paramz, long paramLong, d paramd) {}
    
    public z B()
    {
      return this.c;
    }
    
    public d e0()
    {
      return this.e;
    }
    
    public long i()
    {
      return paramLong;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.j
 * JD-Core Version:    0.7.0.1
 */