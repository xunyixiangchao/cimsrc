package i2;

import b2.h;
import h2.g;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.InputStream;
import java.net.URL;

public class e
  implements n<URL, InputStream>
{
  private final n<g, InputStream> a;
  
  public e(n<g, InputStream> paramn)
  {
    this.a = paramn;
  }
  
  public n.a<InputStream> c(URL paramURL, int paramInt1, int paramInt2, h paramh)
  {
    return this.a.b(new g(paramURL), paramInt1, paramInt2, paramh);
  }
  
  public boolean d(URL paramURL)
  {
    return true;
  }
  
  public static class a
    implements o<URL, InputStream>
  {
    public n<URL, InputStream> b(r paramr)
    {
      return new e(paramr.d(g.class, InputStream.class));
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i2.e
 * JD-Core Version:    0.7.0.1
 */