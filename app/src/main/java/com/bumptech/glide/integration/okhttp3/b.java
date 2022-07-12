package com.bumptech.glide.integration.okhttp3;

import a2.a;
import b2.h;
import h2.g;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.InputStream;
import l9.b0;
import l9.e.a;

public class b
  implements n<g, InputStream>
{
  private final e.a a;
  
  public b(e.a parama)
  {
    this.a = parama;
  }
  
  public n.a<InputStream> c(g paramg, int paramInt1, int paramInt2, h paramh)
  {
    return new n.a(paramg, new a(this.a, paramg));
  }
  
  public boolean d(g paramg)
  {
    return true;
  }
  
  public static class a
    implements o<g, InputStream>
  {
    private static volatile e.a b;
    private final e.a a;
    
    public a()
    {
      this(a());
    }
    
    public a(e.a parama)
    {
      this.a = parama;
    }
    
    private static e.a a()
    {
      if (b == null) {
        try
        {
          if (b == null) {
            b = new b0();
          }
        }
        finally {}
      }
      return b;
    }
    
    public n<g, InputStream> b(r paramr)
    {
      return new b(this.a);
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.integration.okhttp3.b
 * JD-Core Version:    0.7.0.1
 */