package l9;

import a9.f;
import aa.b;
import aa.c;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import m9.o;

public final class u
  extends e0
{
  public static final b d = new b(null);
  private static final z e = z.e.a("application/x-www-form-urlencoded");
  private final List<String> b;
  private final List<String> c;
  
  public u(List<String> paramList1, List<String> paramList2)
  {
    this.b = o.u(paramList1);
    this.c = o.u(paramList2);
  }
  
  private final long h(c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramc = new b();
    }
    else
    {
      f.c(paramc);
      paramc = paramc.b();
    }
    int i = 0;
    int j = this.b.size();
    while (i < j)
    {
      if (i > 0) {
        paramc.H0(38);
      }
      paramc.N0((String)this.b.get(i));
      paramc.H0(61);
      paramc.N0((String)this.c.get(i));
      i += 1;
    }
    if (paramBoolean)
    {
      long l = paramc.z0();
      paramc.a();
      return l;
    }
    return 0L;
  }
  
  public long a()
  {
    return h(null, true);
  }
  
  public z b()
  {
    return e;
  }
  
  public void g(c paramc)
  {
    f.f(paramc, "sink");
    h(paramc, false);
  }
  
  public static final class a
  {
    private final Charset a;
    private final List<String> b;
    private final List<String> c;
    
    public a()
    {
      this(null, 1, null);
    }
    
    public a(Charset paramCharset)
    {
      this.a = paramCharset;
      this.b = new ArrayList();
      this.c = new ArrayList();
    }
    
    public final a a(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      List localList = this.b;
      x.b localb = x.k;
      localList.add(x.b.b(localb, paramString1, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, this.a, 91, null));
      this.c.add(x.b.b(localb, paramString2, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, this.a, 91, null));
      return this;
    }
    
    public final a b(String paramString1, String paramString2)
    {
      f.f(paramString1, "name");
      f.f(paramString2, "value");
      List localList = this.b;
      x.b localb = x.k;
      localList.add(x.b.b(localb, paramString1, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, this.a, 83, null));
      this.c.add(x.b.b(localb, paramString2, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, this.a, 83, null));
      return this;
    }
    
    public final u c()
    {
      return new u(this.b, this.c);
    }
  }
  
  public static final class b {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.u
 * JD-Core Version:    0.7.0.1
 */