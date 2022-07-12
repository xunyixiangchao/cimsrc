package m9;

import f9.l;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;

public final class f
{
  public static final String a(String paramString)
  {
    a9.f.f(paramString, "<this>");
    int i = 0;
    Object localObject;
    if (l.C(paramString, ":", false, 2, null))
    {
      if ((l.x(paramString, "[", false, 2, null)) && (l.k(paramString, "]", false, 2, null))) {
        localObject = e.d(paramString, 1, paramString.length() - 1);
      } else {
        localObject = e.d(paramString, 0, paramString.length());
      }
      if (localObject == null) {
        return null;
      }
      localObject = InetAddress.getByAddress((byte[])localObject);
      byte[] arrayOfByte = ((InetAddress)localObject).getAddress();
      if (arrayOfByte.length == 16)
      {
        a9.f.e(arrayOfByte, "address");
        return e.e(arrayOfByte);
      }
      if (arrayOfByte.length == 4) {
        return ((InetAddress)localObject).getHostAddress();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid IPv6 address: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('\'');
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    do
    {
      try
      {
        paramString = IDN.toASCII(paramString);
        a9.f.e(paramString, "toASCII(host)");
        localObject = Locale.US;
        a9.f.e(localObject, "US");
        paramString = paramString.toLowerCase((Locale)localObject);
        a9.f.e(paramString, "this as java.lang.String).toLowerCase(locale)");
        if (paramString.length() != 0) {
          continue;
        }
        i = 1;
      }
      catch (IllegalArgumentException paramString)
      {
        boolean bool;
        return null;
      }
      bool = e.b(paramString);
      if (bool) {
        return null;
      }
      return paramString;
    } while (i == 0);
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.f
 * JD-Core Version:    0.7.0.1
 */