package h9;

import java.io.FileNotFoundException;
import java.io.IOException;
import k9.b;

class a
{
  private b a = null;
  
  private a()
  {
    e();
  }
  
  private String a(char paramChar)
  {
    Object localObject1 = Integer.toHexString(paramChar).toUpperCase();
    localObject1 = d().a((String)localObject1);
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((b)localObject1).c();
    } else {
      localObject1 = null;
    }
    if (f((String)localObject1)) {
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  static a c()
  {
    return b.a;
  }
  
  private void e()
  {
    try
    {
      h(new b());
      d().d(d.a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
      d().e(d.a("/pinyindb/multi_pinyin.txt"));
      d().f();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  private boolean f(String paramString)
  {
    return (paramString != null) && (!paramString.equals("(none0)")) && (paramString.startsWith("(")) && (paramString.endsWith(")"));
  }
  
  private void h(b paramb)
  {
    this.a = paramb;
  }
  
  String[] b(char paramChar)
  {
    return g(a(paramChar));
  }
  
  b d()
  {
    return this.a;
  }
  
  String[] g(String paramString)
  {
    if (paramString != null) {
      return paramString.substring(paramString.indexOf("(") + 1, paramString.lastIndexOf(")")).split(",");
    }
    return null;
  }
  
  private static class b
  {
    static final a a = new a(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h9.a
 * JD-Core Version:    0.7.0.1
 */