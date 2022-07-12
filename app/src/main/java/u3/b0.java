package u3;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import o3.b;

public class b0
{
  public static String a(Long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.i.a(), paramLong });
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.f.a(), paramString });
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    File localFile = a0.g(paramString);
    if (localFile.exists()) {
      return l.L(localFile).toString();
    }
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.f.a(), paramString });
  }
  
  public static String d(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.k.a(), Long.valueOf(paramLong) });
  }
  
  public static String e(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.j.a(), Long.valueOf(paramLong) });
  }
  
  public static String f(String paramString1, String paramString2)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { paramString1, paramString2 });
  }
  
  public static String g(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.d.a(), Long.valueOf(paramLong) });
  }
  
  public static String h(String paramString)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.g.a(), paramString });
  }
  
  public static String i(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.h.a(), String.valueOf(paramLong) });
  }
  
  public static String j(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.e.a(), Long.valueOf(paramLong) });
  }
  
  public static String k(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.c.a(), Long.valueOf(paramLong) });
  }
  
  public static String l(long paramLong)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.b.a(), Long.valueOf(paramLong) });
  }
  
  public static String m(String paramString)
  {
    return String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.b.a(), paramString });
  }
  
  public static boolean n(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!paramString.startsWith("file://"))
    {
      if (paramString.startsWith("content://")) {
        return true;
      }
      if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.b.a(), "" }))) {
        if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.e.a(), "" }))) {
          if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.i.a(), "" }))) {
            if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.c.a(), "" }))) {
              if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.h.a(), "" }))) {
                if (!paramString.startsWith(String.format("http://api.hoxin.farsunset.com/file/%1$s/%2$s", new Object[] { b.d.a(), "" }))) {
                  break label215;
                }
              }
            }
          }
        }
      }
      bool1 = true;
      label215:
      return bool1;
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.b0
 * JD-Core Version:    0.7.0.1
 */