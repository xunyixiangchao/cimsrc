package h2;

import android.net.Uri;
import android.text.TextUtils;
import b2.f;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import x2.k;

public class g
  implements f
{
  private final h b;
  private final URL c;
  private final String d;
  private String e;
  private URL f;
  private volatile byte[] g;
  private int h;
  
  public g(String paramString)
  {
    this(paramString, h.b);
  }
  
  public g(String paramString, h paramh)
  {
    this.c = null;
    this.d = k.b(paramString);
    this.b = ((h)k.d(paramh));
  }
  
  public g(URL paramURL)
  {
    this(paramURL, h.b);
  }
  
  public g(URL paramURL, h paramh)
  {
    this.c = ((URL)k.d(paramURL));
    this.d = null;
    this.b = ((h)k.d(paramh));
  }
  
  private byte[] d()
  {
    if (this.g == null) {
      this.g = c().getBytes(f.a);
    }
    return this.g;
  }
  
  private String f()
  {
    if (TextUtils.isEmpty(this.e))
    {
      String str2 = this.d;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = ((URL)k.d(this.c)).toString();
      }
      this.e = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%;$");
    }
    return this.e;
  }
  
  private URL g()
  {
    if (this.f == null) {
      this.f = new URL(f());
    }
    return this.f;
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    paramMessageDigest.update(d());
  }
  
  public String c()
  {
    String str = this.d;
    if (str != null) {
      return str;
    }
    return ((URL)k.d(this.c)).toString();
  }
  
  public Map<String, String> e()
  {
    return this.b.a();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof g;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (g)paramObject;
      bool1 = bool2;
      if (c().equals(paramObject.c()))
      {
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String h()
  {
    return f();
  }
  
  public int hashCode()
  {
    if (this.h == 0)
    {
      int i = c().hashCode();
      this.h = i;
      this.h = (i * 31 + this.b.hashCode());
    }
    return this.h;
  }
  
  public URL i()
  {
    return g();
  }
  
  public String toString()
  {
    return c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.g
 * JD-Core Version:    0.7.0.1
 */