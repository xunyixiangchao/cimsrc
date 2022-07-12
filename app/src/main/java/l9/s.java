package l9;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public abstract interface s
{
  public static final a a = a.a;
  public static final s b = new s.a.a();
  
  public abstract List<InetAddress> a(String paramString);
  
  public static final class a
  {
    private static final class a
      implements s
    {
      public List<InetAddress> a(String paramString)
      {
        a9.f.f(paramString, "hostname");
        try
        {
          Object localObject = InetAddress.getAllByName(paramString);
          a9.f.e(localObject, "getAllByName(hostname)");
          localObject = p8.f.u((Object[])localObject);
          return localObject;
        }
        catch (NullPointerException localNullPointerException)
        {
          paramString = new UnknownHostException(a9.f.m("Broken system behaviour for dns lookup of ", paramString));
          paramString.initCause(localNullPointerException);
          throw paramString;
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l9.s
 * JD-Core Version:    0.7.0.1
 */