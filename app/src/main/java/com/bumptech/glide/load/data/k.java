package com.bumptech.glide.load.data;

import e2.b;
import java.io.InputStream;
import k2.w;

public final class k
  implements e<InputStream>
{
  private final w a;
  
  public k(InputStream paramInputStream, b paramb)
  {
    paramInputStream = new w(paramInputStream, paramb);
    this.a = paramInputStream;
    paramInputStream.mark(5242880);
  }
  
  public void b()
  {
    this.a.h();
  }
  
  public void c()
  {
    this.a.g();
  }
  
  public InputStream d()
  {
    this.a.reset();
    return this.a;
  }
  
  public static final class a
    implements e.a<InputStream>
  {
    private final b a;
    
    public a(b paramb)
    {
      this.a = paramb;
    }
    
    public Class<InputStream> a()
    {
      return InputStream.class;
    }
    
    public e<InputStream> c(InputStream paramInputStream)
    {
      return new k(paramInputStream, this.a);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.k
 * JD-Core Version:    0.7.0.1
 */