package a2;

import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import h2.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l9.d0.a;
import l9.e.a;
import l9.f;
import l9.f0;
import l9.g0;
import x2.c;
import x2.k;

public class a
  implements d<InputStream>, f
{
  private final e.a a;
  private final g b;
  private InputStream c;
  private g0 d;
  private d.a<? super InputStream> e;
  private volatile l9.e f;
  
  public a(e.a parama, g paramg)
  {
    this.a = parama;
    this.b = paramg;
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  public void b()
  {
    try
    {
      localObject = this.c;
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
    }
    catch (IOException localIOException)
    {
      Object localObject;
      label13:
      break label13;
    }
    localObject = this.d;
    if (localObject != null) {
      ((g0)localObject).close();
    }
    this.e = null;
  }
  
  public void c(l9.e parame, f0 paramf0)
  {
    this.d = paramf0.a();
    if (paramf0.j0())
    {
      long l = ((g0)k.d(this.d)).i();
      parame = c.g(this.d.a(), l);
      this.c = parame;
      this.e.d(parame);
      return;
    }
    this.e.c(new b2.e(paramf0.k0(), paramf0.B()));
  }
  
  public void cancel()
  {
    l9.e locale = this.f;
    if (locale != null) {
      locale.cancel();
    }
  }
  
  public void d(l9.e parame, IOException paramIOException)
  {
    if (Log.isLoggable("OkHttpFetcher", 3)) {
      Log.d("OkHttpFetcher", "OkHttp failed to obtain result", paramIOException);
    }
    this.e.c(paramIOException);
  }
  
  public b2.a e()
  {
    return b2.a.b;
  }
  
  public void f(h paramh, d.a<? super InputStream> parama)
  {
    paramh = new d0.a().o(this.b.h());
    Iterator localIterator = this.b.e().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramh.a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    paramh = paramh.b();
    this.e = parama;
    this.f = this.a.a(paramh);
    this.f.d0(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a2.a
 * JD-Core Version:    0.7.0.1
 */