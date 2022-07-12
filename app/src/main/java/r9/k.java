package r9;

import a9.f;
import f9.l;
import java.net.ProtocolException;
import l9.c0;

public final class k
{
  public static final a d = new a(null);
  public final c0 a;
  public final int b;
  public final String c;
  
  public k(c0 paramc0, int paramInt, String paramString)
  {
    this.a = paramc0;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a == c0.c) {
      str = "HTTP/1.0";
    } else {
      str = "HTTP/1.1";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.b);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.c);
    String str = localStringBuilder.toString();
    f.e(str, "StringBuilder().apply(builderAction).toString()");
    return str;
  }
  
  public static final class a
  {
    public final k a(String paramString)
    {
      f.f(paramString, "statusLine");
      boolean bool = l.x(paramString, "HTTP/1.", false, 2, null);
      int i = 9;
      c0 localc0;
      if (bool)
      {
        if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
        {
          j = paramString.charAt(7) - '0';
          if (j != 0)
          {
            if (j == 1) {
              localc0 = c0.d;
            } else {
              throw new ProtocolException(f.m("Unexpected status line: ", paramString));
            }
          }
          else {
            localc0 = c0.c;
          }
        }
        else
        {
          throw new ProtocolException(f.m("Unexpected status line: ", paramString));
        }
      }
      else
      {
        if (!l.x(paramString, "ICY ", false, 2, null)) {
          break label270;
        }
        localc0 = c0.c;
        i = 4;
      }
      int k = paramString.length();
      int j = i + 3;
      if (k >= j)
      {
        Object localObject = paramString.substring(i, j);
        f.e(localObject, "this as java.lang.String…ing(startIndex, endIndex)");
        localObject = l.f((String)localObject);
        if (localObject != null)
        {
          k = ((Integer)localObject).intValue();
          if (paramString.length() > j)
          {
            if (paramString.charAt(j) == ' ')
            {
              paramString = paramString.substring(i + 4);
              f.e(paramString, "this as java.lang.String).substring(startIndex)");
            }
            else
            {
              throw new ProtocolException(f.m("Unexpected status line: ", paramString));
            }
          }
          else {
            paramString = "";
          }
          return new k(localc0, k, paramString);
        }
        throw new ProtocolException(f.m("Unexpected status line: ", paramString));
      }
      throw new ProtocolException(f.m("Unexpected status line: ", paramString));
      label270:
      throw new ProtocolException(f.m("Unexpected status line: ", paramString));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.k
 * JD-Core Version:    0.7.0.1
 */