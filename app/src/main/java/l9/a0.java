package l9;

import a9.f;
import aa.b;
import aa.c;
import aa.e;
import aa.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import m9.o;

public final class a0
  extends e0
{
  public static final b g = new b(null);
  public static final z h;
  public static final z i;
  public static final z j;
  public static final z k;
  public static final z l;
  private static final byte[] m;
  private static final byte[] n;
  private static final byte[] o;
  private final e b;
  private final z c;
  private final List<c> d;
  private final z e;
  private long f;
  
  static
  {
    z.a locala = z.e;
    h = locala.a("multipart/mixed");
    i = locala.a("multipart/alternative");
    j = locala.a("multipart/digest");
    k = locala.a("multipart/parallel");
    l = locala.a("multipart/form-data");
    m = new byte[] { (byte)58, (byte)32 };
    n = new byte[] { (byte)13, (byte)10 };
    int i1 = (byte)45;
    o = new byte[] { i1, i1 };
  }
  
  public a0(e parame, z paramz, List<c> paramList)
  {
    this.b = parame;
    this.c = paramz;
    this.d = paramList;
    parame = z.e;
    paramList = new StringBuilder();
    paramList.append(paramz);
    paramList.append("; boundary=");
    paramList.append(h());
    this.e = parame.a(paramList.toString());
    this.f = -1L;
  }
  
  private final long i(c paramc, boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = new b();
      paramc = (c)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramc;
      paramc = (c)localObject2;
    }
    int i3 = this.d.size();
    long l1 = 0L;
    int i1 = 0;
    while (i1 < i3)
    {
      localObject2 = (c)this.d.get(i1);
      Object localObject3 = ((c)localObject2).c();
      localObject2 = ((c)localObject2).a();
      f.c(localObject1);
      ((c)localObject1).K(o);
      ((c)localObject1).Y(this.b);
      ((c)localObject1).K(n);
      if (localObject3 != null)
      {
        int i4 = ((w)localObject3).size();
        int i2 = 0;
        while (i2 < i4)
        {
          ((c)localObject1).V(((w)localObject3).c(i2)).K(m).V(((w)localObject3).f(i2)).K(n);
          i2 += 1;
        }
      }
      localObject3 = ((e0)localObject2).b();
      if (localObject3 != null) {
        ((c)localObject1).V("Content-Type: ").V(((z)localObject3).toString()).K(n);
      }
      l2 = ((e0)localObject2).a();
      if (l2 != -1L)
      {
        ((c)localObject1).V("Content-Length: ").W(l2).K(n);
      }
      else if (paramBoolean)
      {
        f.c(paramc);
        paramc.a();
        return -1L;
      }
      localObject3 = n;
      ((c)localObject1).K((byte[])localObject3);
      if (paramBoolean) {
        l1 += l2;
      } else {
        ((e0)localObject2).g((c)localObject1);
      }
      ((c)localObject1).K((byte[])localObject3);
      i1 += 1;
    }
    f.c(localObject1);
    Object localObject2 = o;
    ((c)localObject1).K((byte[])localObject2);
    ((c)localObject1).Y(this.b);
    ((c)localObject1).K((byte[])localObject2);
    ((c)localObject1).K(n);
    long l2 = l1;
    if (paramBoolean)
    {
      f.c(paramc);
      l2 = l1 + paramc.z0();
      paramc.a();
    }
    return l2;
  }
  
  public long a()
  {
    long l2 = this.f;
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = i(null, true);
      this.f = l1;
    }
    return l1;
  }
  
  public z b()
  {
    return this.e;
  }
  
  public void g(c paramc)
  {
    f.f(paramc, "sink");
    i(paramc, false);
  }
  
  public final String h()
  {
    return this.b.u();
  }
  
  public static final class a
  {
    private final e a;
    private z b;
    private final List<a0.c> c;
    
    public a()
    {
      this(null, 1, null);
    }
    
    public a(String paramString)
    {
      this.a = e.d.c(paramString);
      this.b = a0.h;
      this.c = new ArrayList();
    }
    
    public final a a(w paramw, e0 parame0)
    {
      f.f(parame0, "body");
      b(a0.c.c.a(paramw, parame0));
      return this;
    }
    
    public final a b(a0.c paramc)
    {
      f.f(paramc, "part");
      this.c.add(paramc);
      return this;
    }
    
    public final a0 c()
    {
      if ((this.c.isEmpty() ^ true)) {
        return new a0(this.a, this.b, o.u(this.c));
      }
      throw new IllegalStateException("Multipart body must have at least one part.".toString());
    }
    
    public final a d(z paramz)
    {
      f.f(paramz, "type");
      if (f.a(paramz.g(), "multipart"))
      {
        this.b = paramz;
        return this;
      }
      throw new IllegalArgumentException(f.m("multipart != ", paramz).toString());
    }
  }
  
  public static final class b
  {
    public final void a(StringBuilder paramStringBuilder, String paramString)
    {
      f.f(paramStringBuilder, "<this>");
      f.f(paramString, "key");
      paramStringBuilder.append('"');
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        String str;
        if (c == '\n') {
          str = "%0A";
        }
        for (;;)
        {
          paramStringBuilder.append(str);
          break label94;
          if (c == '\r')
          {
            str = "%0D";
          }
          else
          {
            if (c != '"') {
              break;
            }
            str = "%22";
          }
        }
        paramStringBuilder.append(c);
        label94:
        i += 1;
      }
      paramStringBuilder.append('"');
    }
  }
  
  public static final class c
  {
    public static final a c = new a(null);
    private final w a;
    private final e0 b;
    
    private c(w paramw, e0 parame0)
    {
      this.a = paramw;
      this.b = parame0;
    }
    
    public static final c b(String paramString1, String paramString2, e0 parame0)
    {
      return c.b(paramString1, paramString2, parame0);
    }
    
    public final e0 a()
    {
      return this.b;
    }
    
    public final w c()
    {
      return this.a;
    }
    
    public static final class a
    {
      public final a0.c a(w paramw, e0 parame0)
      {
        f.f(parame0, "body");
        String str;
        if (paramw == null) {
          str = null;
        } else {
          str = paramw.a("Content-Type");
        }
        int j = 1;
        int i;
        if (str == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (paramw == null) {
            str = null;
          } else {
            str = paramw.a("Content-Length");
          }
          if (str == null) {
            i = j;
          } else {
            i = 0;
          }
          if (i != 0) {
            return new a0.c(paramw, parame0, null);
          }
          throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
      }
      
      public final a0.c b(String paramString1, String paramString2, e0 parame0)
      {
        f.f(paramString1, "name");
        f.f(parame0, "body");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("form-data; name=");
        a0.b localb = a0.g;
        localb.a(localStringBuilder, paramString1);
        if (paramString2 != null)
        {
          localStringBuilder.append("; filename=");
          localb.a(localStringBuilder, paramString2);
        }
        paramString1 = localStringBuilder.toString();
        f.e(paramString1, "StringBuilder().apply(builderAction).toString()");
        return a(new w.a().e("Content-Disposition", paramString1).f(), parame0);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.a0
 * JD-Core Version:    0.7.0.1
 */