package h2;

import android.net.Uri;
import b2.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class x<Data>
  implements n<Uri, Data>
{
  private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
  private final n<g, Data> a;
  
  public x(n<g, Data> paramn)
  {
    this.a = paramn;
  }
  
  public n.a<Data> c(Uri paramUri, int paramInt1, int paramInt2, h paramh)
  {
    paramUri = new g(paramUri.toString());
    return this.a.b(paramUri, paramInt1, paramInt2, paramh);
  }
  
  public boolean d(Uri paramUri)
  {
    return b.contains(paramUri.getScheme());
  }
  
  public static class a
    implements o<Uri, InputStream>
  {
    public n<Uri, InputStream> b(r paramr)
    {
      return new x(paramr.d(g.class, InputStream.class));
    }
    
    public void c() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.x
 * JD-Core Version:    0.7.0.1
 */