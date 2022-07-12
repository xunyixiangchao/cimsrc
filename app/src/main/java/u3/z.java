package u3;

import aa.d;
import aa.g;
import ca.c;
import com.farsunset.hoxin.home.service.ApkDownloaderService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l9.b0.a;
import l9.d0.a;
import l9.e;
import l9.f0;
import l9.f0.a;
import l9.g0;
import l9.y.a;
import s3.f;

public class z
{
  private static final ConcurrentHashMap<String, e> a = new ConcurrentHashMap();
  private static final ExecutorService b = Executors.newCachedThreadPool();
  
  public static void f(File paramFile, String paramString, f paramf)
  {
    b.execute(new u(paramString, paramFile, paramf));
  }
  
  public static void g(String paramString, File paramFile)
  {
    f(paramFile, paramString, null);
  }
  
  public static void h(o3.b paramb, File paramFile, f paramf)
  {
    f(paramFile, b0.f(paramb.a(), paramFile.getName()), paramf);
  }
  
  private static void i(String paramString, File paramFile, f paramf)
  {
    long l2 = j(paramString);
    if ((paramFile.exists()) && (l2 == paramFile.length()) && (l2 > 0L))
    {
      p(paramString, paramFile, paramf);
      return;
    }
    if ((paramFile.exists()) && (l2 < paramFile.length()))
    {
      paramFile.delete();
      l.n(paramFile);
    }
    long l1;
    if ((paramFile.exists()) && (l2 > paramFile.length())) {
      l1 = paramFile.length();
    } else {
      l1 = 0L;
    }
    if (l2 == 0L)
    {
      q(paramString, paramFile, paramf);
      return;
    }
    Object localObject1 = new d0.a().o(paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("bytes=");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("-");
    localObject1 = ((d0.a)localObject1).e("RANGE", ((StringBuilder)localObject2).toString()).b();
    localObject1 = new b0.a().b(new a(new y(paramString, paramf, paramFile), l2, l1)).c().a((l9.d0)localObject1);
    a.put(paramString, localObject1);
    try
    {
      localObject2 = ((e)localObject1).g().a().a();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "rwd");
      localRandomAccessFile.seek(l1);
      byte[] arrayOfByte = new byte[2048];
      for (;;)
      {
        int i = ((InputStream)localObject2).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localRandomAccessFile.write(arrayOfByte, 0, i);
      }
      c.b((InputStream)localObject2);
      c.a(localRandomAccessFile);
      return;
    }
    catch (Exception localException)
    {
      t.b("downloader", "", localException);
      if (!((e)localObject1).i()) {
        q(paramString, paramFile, paramf);
      }
    }
  }
  
  private static long j(String paramString)
  {
    l9.b0 localb0 = new l9.b0();
    paramString = new d0.a().o(paramString).b();
    try
    {
      paramString = localb0.a(paramString).g();
      if (paramString.j0())
      {
        long l = paramString.a().i();
        c.a(paramString);
        return l;
      }
    }
    catch (IOException paramString)
    {
      t.b("downloader", "", paramString);
    }
    return 0L;
  }
  
  private static void p(String paramString, File paramFile, f paramf)
  {
    if (paramf != null) {
      m0.b(new w(paramf, paramFile, paramString));
    }
  }
  
  private static void q(String paramString, File paramFile, f paramf)
  {
    if (paramf != null) {
      m0.b(new v(paramf, paramFile, paramString));
    }
  }
  
  private static void r(String paramString, float paramFloat, f paramf)
  {
    if (paramf != null)
    {
      if ((paramf instanceof ApkDownloaderService))
      {
        paramf.z0(paramString, paramFloat);
        return;
      }
      m0.b(new x(paramf, paramString, paramFloat));
    }
  }
  
  public static void s(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = (e)a.get(paramString);
    if ((paramString != null) && (!paramString.i())) {
      paramString.cancel();
    }
  }
  
  private static class a
    implements l9.y
  {
    private final s3.d0 a;
    private g0 b;
    private final long c;
    private final long d;
    
    a(s3.d0 paramd0, long paramLong1, long paramLong2)
    {
      this.a = paramd0;
      this.d = paramLong2;
      this.c = paramLong1;
    }
    
    public f0 a(y.a parama)
    {
      parama = parama.a(parama.h());
      this.b = parama.a();
      return parama.m0().b(new a()).c();
    }
    
    class a
      extends g0
    {
      private d c;
      
      a() {}
      
      private aa.x f0(aa.x paramx)
      {
        return new a(paramx);
      }
      
      public l9.z B()
      {
        return z.a.b(z.a.this).B();
      }
      
      public d e0()
      {
        if (this.c == null) {
          this.c = aa.l.b(f0(z.a.b(z.a.this).e0()));
        }
        return this.c;
      }
      
      public long i()
      {
        return z.a.b(z.a.this).i();
      }
      
      class a
        extends g
      {
        long b = z.a.c(z.a.this);
        
        a(aa.x paramx)
        {
          super();
        }
        
        public long k(aa.b paramb, long paramLong)
        {
          long l1 = super.k(paramb, paramLong);
          long l2 = this.b;
          if (l1 != -1L) {
            paramLong = l1;
          } else {
            paramLong = 0L;
          }
          paramLong = l2 + paramLong;
          this.b = paramLong;
          float f = (float)(paramLong * 100L / z.a.d(z.a.this));
          z.a.e(z.a.this).a(f);
          return l1;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.z
 * JD-Core Version:    0.7.0.1
 */