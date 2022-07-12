package f9;

import a9.f;
import java.nio.charset.Charset;

public final class d
{
  public static final d a = new d();
  public static final Charset b;
  public static final Charset c;
  public static final Charset d;
  public static final Charset e;
  public static final Charset f;
  public static final Charset g;
  private static Charset h;
  private static Charset i;
  
  static
  {
    Charset localCharset = Charset.forName("UTF-8");
    f.e(localCharset, "forName(\"UTF-8\")");
    b = localCharset;
    localCharset = Charset.forName("UTF-16");
    f.e(localCharset, "forName(\"UTF-16\")");
    c = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    f.e(localCharset, "forName(\"UTF-16BE\")");
    d = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    f.e(localCharset, "forName(\"UTF-16LE\")");
    e = localCharset;
    localCharset = Charset.forName("US-ASCII");
    f.e(localCharset, "forName(\"US-ASCII\")");
    f = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    f.e(localCharset, "forName(\"ISO-8859-1\")");
    g = localCharset;
  }
  
  public final Charset a()
  {
    Charset localCharset2 = i;
    Charset localCharset1 = localCharset2;
    if (localCharset2 == null)
    {
      localCharset1 = Charset.forName("UTF-32BE");
      f.e(localCharset1, "forName(\"UTF-32BE\")");
      i = localCharset1;
    }
    return localCharset1;
  }
  
  public final Charset b()
  {
    Charset localCharset2 = h;
    Charset localCharset1 = localCharset2;
    if (localCharset2 == null)
    {
      localCharset1 = Charset.forName("UTF-32LE");
      f.e(localCharset1, "forName(\"UTF-32LE\")");
      h = localCharset1;
    }
    return localCharset1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.d
 * JD-Core Version:    0.7.0.1
 */