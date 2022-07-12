package i2;

import b2.h;
import com.bumptech.glide.load.data.j;
import h2.m;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.InputStream;

public class a
  implements n<h2.g, InputStream>
{
  public static final b2.g<Integer> b = b2.g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
  private final m<h2.g, h2.g> a;
  
  public a(m<h2.g, h2.g> paramm)
  {
    this.a = paramm;
  }
  
  public n.a<InputStream> c(h2.g paramg, int paramInt1, int paramInt2, h paramh)
  {
    m localm = this.a;
    h2.g localg = paramg;
    if (localm != null)
    {
      localg = (h2.g)localm.a(paramg, 0, 0);
      if (localg == null)
      {
        this.a.b(paramg, 0, 0, paramg);
        localg = paramg;
      }
    }
    return new n.a(localg, new j(localg, ((Integer)paramh.c(b)).intValue()));
  }
  
  public boolean d(h2.g paramg)
  {
    return true;
  }
  
  public static class a
    implements o<h2.g, InputStream>
  {
    private final m<h2.g, h2.g> a = new m(500L);
    
    public n<h2.g, InputStream> b(r paramr)
    {
      return new a(this.a);
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i2.a
 * JD-Core Version:    0.7.0.1
 */