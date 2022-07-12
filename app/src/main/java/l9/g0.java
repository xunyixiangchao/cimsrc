package l9;

import a9.f;
import aa.d;
import aa.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import m9.a;
import m9.j;

public abstract class g0
  implements Closeable
{
  public static final b b = new b(null);
  private Reader a;
  
  public static final g0 d0(z paramz, long paramLong, d paramd)
  {
    return b.b(paramz, paramLong, paramd);
  }
  
  private final Charset h()
  {
    return a.b(B(), null, 1, null);
  }
  
  public abstract z B();
  
  public final InputStream a()
  {
    return e0().c0();
  }
  
  public void close()
  {
    j.b(this);
  }
  
  public abstract d e0();
  
  public final Reader g()
  {
    Reader localReader = this.a;
    Object localObject = localReader;
    if (localReader == null)
    {
      localObject = new a(e0(), h());
      this.a = ((Reader)localObject);
    }
    return localObject;
  }
  
  public abstract long i();
  
  public static final class a
    extends Reader
  {
    private final d a;
    private final Charset b;
    private boolean c;
    private Reader d;
    
    public a(d paramd, Charset paramCharset)
    {
      this.a = paramd;
      this.b = paramCharset;
    }
    
    public void close()
    {
      this.c = true;
      Object localObject = this.d;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        ((Reader)localObject).close();
        localObject = o8.o.a;
      }
      if (localObject == null) {
        this.a.close();
      }
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      f.f(paramArrayOfChar, "cbuf");
      if (!this.c)
      {
        Reader localReader = this.d;
        Object localObject = localReader;
        if (localReader == null)
        {
          localObject = new InputStreamReader(this.a.c0(), m9.o.m(this.a, this.b));
          this.d = ((Reader)localObject);
        }
        return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
      }
      throw new IOException("Stream closed");
    }
  }
  
  public static final class b
  {
    public final g0 a(d paramd, z paramz, long paramLong)
    {
      f.f(paramd, "<this>");
      return j.a(paramd, paramz, paramLong);
    }
    
    public final g0 b(z paramz, long paramLong, d paramd)
    {
      f.f(paramd, "content");
      return a(paramd, paramz, paramLong);
    }
    
    public final g0 c(byte[] paramArrayOfByte, z paramz)
    {
      f.f(paramArrayOfByte, "<this>");
      return j.c(paramArrayOfByte, paramz);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.g0
 * JD-Core Version:    0.7.0.1
 */