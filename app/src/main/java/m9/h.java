package m9;

import a9.f;
import aa.c;
import aa.e;
import l9.e0;
import l9.z;

public final class h
{
  public static final long a(e0 parame0)
  {
    f.f(parame0, "<this>");
    return -1L;
  }
  
  public static final boolean b(e0 parame0)
  {
    f.f(parame0, "<this>");
    return false;
  }
  
  public static final boolean c(e0 parame0)
  {
    f.f(parame0, "<this>");
    return false;
  }
  
  public static final e0 d(final e parame, z paramz)
  {
    f.f(parame, "<this>");
    return new b(paramz, parame);
  }
  
  public static final e0 e(final byte[] paramArrayOfByte, z paramz, final int paramInt1, final int paramInt2)
  {
    f.f(paramArrayOfByte, "<this>");
    l.e(paramArrayOfByte.length, paramInt1, paramInt2);
    return new a(paramz, paramInt2, paramArrayOfByte, paramInt1);
  }
  
  public static final class a
    extends e0
  {
    a(z paramz, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
    
    public long a()
    {
      return paramInt2;
    }
    
    public z b()
    {
      return this.b;
    }
    
    public void g(c paramc)
    {
      f.f(paramc, "sink");
      paramc.d(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static final class b
    extends e0
  {
    b(z paramz, e parame) {}
    
    public long a()
    {
      return parame.r();
    }
    
    public z b()
    {
      return this.b;
    }
    
    public void g(c paramc)
    {
      f.f(paramc, "sink");
      paramc.Y(parame);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.h
 * JD-Core Version:    0.7.0.1
 */