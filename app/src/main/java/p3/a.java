package p3;

import com.farsunset.hoxin.common.database.base.PublicRoomDatabase;
import com.farsunset.hoxin.common.entity.Config;

public class a
{
  private static q3.a a = ;
  
  public static String a(String paramString1, String paramString2)
  {
    return a.b(paramString1, paramString2);
  }
  
  public static String b(long paramLong)
  {
    return a("X-APP-CACHE", String.format("MT:%s", new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void c(long paramLong, String paramString)
  {
    Config localConfig = new Config();
    localConfig.id = System.currentTimeMillis();
    localConfig.domain = "X-APP-CACHE";
    localConfig.name = String.format("MT:%s", new Object[] { Long.valueOf(paramLong) });
    localConfig.value = paramString;
    a.a(localConfig);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p3.a
 * JD-Core Version:    0.7.0.1
 */