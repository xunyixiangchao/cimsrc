package u3;

import aa.v;
import android.os.Looper;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.model.FileResource;
import ea.d;
import ea.t;
import ea.u;
import ea.u.b;
import fa.a;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import l9.a0.c;
import l9.b0;
import l9.e;
import l9.r;
import l9.z;

public class c0
{
  private static final d<BaseResult> a = new a();
  private static final z b = z.f("application/octet-stream");
  private static final b0 c = l3.g.b();
  
  public static void b(FileResource paramFileResource)
  {
    m3.b localb = f();
    String str = l.r(paramFileResource.name);
    try
    {
      localb.b(a0.c.b("file", str, l9.e0.d(b, ca.c.i(paramFileResource.file))), paramFileResource.bucket.a(), paramFileResource.name).B(a);
      return;
    }
    catch (Exception paramFileResource) {}
  }
  
  public static void c(FileResource paramFileResource, s3.g paramg)
  {
    m3.b localb = f();
    paramg = new b(paramg, paramFileResource, null);
    localb.b(a0.c.b("file", paramFileResource.name, new c(paramFileResource.file, paramFileResource.name, paramg)), paramFileResource.bucket.a(), paramFileResource.name).B(paramg);
  }
  
  public static void d(o3.b paramb, File paramFile, s3.g paramg)
  {
    c(FileResource.of(paramb, paramFile.getName(), paramFile), paramg);
  }
  
  public static void e(o3.b paramb, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramb.a());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    paramb = ((StringBuilder)localObject).toString();
    paramString = c.o().n().iterator();
    while (paramString.hasNext())
    {
      localObject = (e)paramString.next();
      if (((e)localObject).h().j().toString().endsWith(paramb))
      {
        ((e)localObject).cancel();
        return;
      }
    }
    paramString = c.o().m().iterator();
    while (paramString.hasNext())
    {
      localObject = (e)paramString.next();
      if (((e)localObject).h().j().toString().endsWith(paramb)) {
        ((e)localObject).cancel();
      }
    }
  }
  
  protected static m3.b f()
  {
    return (m3.b)new u.b().b("http://api.hoxin.farsunset.com").f(c).a(a.f()).d().b(m3.b.class);
  }
  
  public static void g(FileResource paramFileResource, s3.f0 paramf0)
  {
    f().b(a0.c.b("file", paramFileResource.name, new c(paramFileResource.file, paramFileResource.name, paramf0)), paramFileResource.bucket.a(), paramFileResource.name).g();
  }
  
  class a
    implements d<BaseResult>
  {
    public void a(ea.b<BaseResult> paramb, Throwable paramThrowable) {}
    
    public void c(ea.b<BaseResult> paramb, t<BaseResult> paramt) {}
  }
  
  private static class b
    implements d<BaseResult>, s3.f0
  {
    private final boolean a;
    private final s3.g b;
    private final FileResource c;
    
    private b(s3.g paramg, FileResource paramFileResource)
    {
      boolean bool;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
      this.b = paramg;
      this.c = paramFileResource;
    }
    
    public void a(ea.b<BaseResult> paramb, Throwable paramThrowable)
    {
      if (this.a)
      {
        m0.b(new f0(this, paramThrowable));
        return;
      }
      this.b.z(this.c, (Exception)paramThrowable);
    }
    
    public void b(String paramString, float paramFloat)
    {
      if (this.a)
      {
        m0.b(new e0(this, paramString, paramFloat));
        return;
      }
      this.b.X(paramString, paramFloat);
    }
    
    public void c(ea.b<BaseResult> paramb, t<BaseResult> paramt)
    {
      if (this.a)
      {
        m0.b(new d0(this));
        return;
      }
      this.b.N(this.c);
    }
  }
  
  private static class c
    extends l9.e0
  {
    private final String b;
    private final s3.f0 c;
    private final InputStream d;
    
    c(InputStream paramInputStream, String paramString, s3.f0 paramf0)
    {
      this.c = paramf0;
      this.d = paramInputStream;
      this.b = paramString;
    }
    
    public long a()
    {
      return this.d.available();
    }
    
    public z b()
    {
      return c0.a();
    }
    
    public void g(aa.c paramc)
    {
      long l1 = a();
      aa.x localx = aa.l.f(this.d);
      aa.b localb = new aa.b();
      AtomicLong localAtomicLong = new AtomicLong(0L);
      for (;;)
      {
        long l2 = localx.k(localb, 2048L);
        if (l2 == -1L) {
          break;
        }
        paramc.L(localb, l2);
        float f = (float)(localAtomicLong.addAndGet(l2) * 100L) / (float)l1;
        this.c.b(this.b, f);
      }
      localx.close();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.c0
 * JD-Core Version:    0.7.0.1
 */