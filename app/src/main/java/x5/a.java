package x5;

import android.text.TextUtils;
import com.farsunset.hoxin.micro.entity.MicroServer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y5.c;

public class a
{
  private static c a;
  
  public static void a(MicroServer paramMicroServer)
  {
    a.f(paramMicroServer);
  }
  
  public static void b(List<MicroServer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      a.b(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b.a(((MicroServer)paramList.next()).menuList);
      }
    }
  }
  
  public static void c(Long paramLong)
  {
    a.a(paramLong);
  }
  
  public static List<MicroServer> d()
  {
    return a.e();
  }
  
  public static List<MicroServer> e(String paramString)
  {
    if (TextUtils.isEmpty(paramString.trim())) {
      return Collections.emptyList();
    }
    c localc = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("%");
    localStringBuilder.append(paramString);
    localStringBuilder.append("%");
    return localc.d(localStringBuilder.toString());
  }
  
  public static MicroServer f(long paramLong)
  {
    return a.c(Long.valueOf(paramLong));
  }
  
  public static void g(c paramc)
  {
    a = paramc;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x5.a
 * JD-Core Version:    0.7.0.1
 */