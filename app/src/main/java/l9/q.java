package l9;

import a9.f;
import aa.e;
import aa.e.a;
import java.nio.charset.Charset;

public final class q
{
  public static final q a = new q();
  
  public static final String a(String paramString1, String paramString2, Charset paramCharset)
  {
    f.f(paramString1, "username");
    f.f(paramString2, "password");
    f.f(paramCharset, "charset");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(':');
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    return f.m("Basic ", e.d.b(paramString1, paramCharset).a());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.q
 * JD-Core Version:    0.7.0.1
 */