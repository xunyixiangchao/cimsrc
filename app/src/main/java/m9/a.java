package m9;

import a9.f;
import f9.d;
import java.nio.charset.Charset;
import l9.i;
import l9.i.b;
import l9.z;

public final class a
{
  public static final Charset a(z paramz, Charset paramCharset)
  {
    f.f(paramCharset, "defaultValue");
    if (paramz == null) {
      paramz = null;
    } else {
      paramz = paramz.a(paramCharset);
    }
    paramCharset = paramz;
    if (paramz == null) {
      paramCharset = d.b;
    }
    return paramCharset;
  }
  
  public static final String[] c(l9.l paraml, String[] paramArrayOfString)
  {
    f.f(paraml, "<this>");
    f.f(paramArrayOfString, "socketEnabledCipherSuites");
    String[] arrayOfString = paramArrayOfString;
    if (paraml.d() != null) {
      arrayOfString = l.w(paramArrayOfString, paraml.d(), i.b.c());
    }
    return arrayOfString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.a
 * JD-Core Version:    0.7.0.1
 */