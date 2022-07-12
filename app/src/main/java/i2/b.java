package i2;

import android.content.Context;
import android.net.Uri;
import b2.h;
import c2.c;
import h2.n;
import h2.n.a;
import h2.o;
import h2.r;
import java.io.InputStream;

public class b
  implements n<Uri, InputStream>
{
  private final Context a;
  
  public b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public n.a<InputStream> c(Uri paramUri, int paramInt1, int paramInt2, h paramh)
  {
    if (c2.b.d(paramInt1, paramInt2)) {
      return new n.a(new w2.b(paramUri), c.d(this.a, paramUri));
    }
    return null;
  }
  
  public boolean d(Uri paramUri)
  {
    return c2.b.a(paramUri);
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
      return new b(this.a);
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i2.b
 * JD-Core Version:    0.7.0.1
 */