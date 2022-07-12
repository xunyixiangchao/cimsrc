package i2;

import android.content.Context;
import android.net.Uri;
import b2.h;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.InputStream;
import k2.b0;

public class c
  implements n<Uri, InputStream>
{
  private final Context a;
  
  public c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private boolean e(h paramh)
  {
    paramh = (Long)paramh.c(b0.d);
    return (paramh != null) && (paramh.longValue() == -1L);
  }
  
  public n.a<InputStream> c(Uri paramUri, int paramInt1, int paramInt2, h paramh)
  {
    if ((c2.b.d(paramInt1, paramInt2)) && (e(paramh))) {
      return new n.a(new w2.b(paramUri), c2.c.g(this.a, paramUri));
    }
    return null;
  }
  
  public boolean d(Uri paramUri)
  {
    return c2.b.c(paramUri);
  }
  
  public static class a
    implements o<Uri, InputStream>
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public n<Uri, InputStream> b(r paramr)
    {
      return new c(this.a);
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i2.c
 * JD-Core Version:    0.7.0.1
 */