package l9;

import a9.f;
import aa.c;
import aa.e;
import m9.h;

public abstract class e0
{
  public static final a a = new a(null);
  
  public static final e0 c(z paramz, e parame)
  {
    return a.b(paramz, parame);
  }
  
  public static final e0 d(z paramz, byte[] paramArrayOfByte)
  {
    return a.c(paramz, paramArrayOfByte);
  }
  
  public long a()
  {
    return h.a(this);
  }
  
  public abstract z b();
  
  public boolean e()
  {
    return h.b(this);
  }
  
  public boolean f()
  {
    return h.c(this);
  }
  
  public abstract void g(c paramc);
  
  public static final class a
  {
    public final e0 a(e parame, z paramz)
    {
      f.f(parame, "<this>");
      return h.d(parame, paramz);
    }
    
    public final e0 b(z paramz, e parame)
    {
      f.f(parame, "content");
      return a(parame, paramz);
    }
    
    public final e0 c(z paramz, byte[] paramArrayOfByte)
    {
      f.f(paramArrayOfByte, "content");
      return f(this, paramz, paramArrayOfByte, 0, 0, 12, null);
    }
    
    public final e0 d(z paramz, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      f.f(paramArrayOfByte, "content");
      return e(paramArrayOfByte, paramz, paramInt1, paramInt2);
    }
    
    public final e0 e(byte[] paramArrayOfByte, z paramz, int paramInt1, int paramInt2)
    {
      f.f(paramArrayOfByte, "<this>");
      return h.e(paramArrayOfByte, paramz, paramInt1, paramInt2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.e0
 * JD-Core Version:    0.7.0.1
 */