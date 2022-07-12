package aa;

import a9.f;
import f9.d;

public final class b0
{
  public static final byte[] a(String paramString)
  {
    f.f(paramString, "<this>");
    paramString = paramString.getBytes(d.b);
    f.e(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
  
  public static final String b(byte[] paramArrayOfByte)
  {
    f.f(paramArrayOfByte, "<this>");
    return new String(paramArrayOfByte, d.b);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.b0
 * JD-Core Version:    0.7.0.1
 */