package p3;

import com.farsunset.hoxin.common.database.base.PublicRoomDatabase;
import com.farsunset.hoxin.common.entity.GlideVersion;
import q3.c;

public class b
{
  private static c a = ;
  
  public static void a(String paramString)
  {
    GlideVersion localGlideVersion = new GlideVersion();
    localGlideVersion.url = paramString;
    localGlideVersion.version = String.valueOf(System.currentTimeMillis());
    a.a(localGlideVersion);
  }
  
  public static String b(String paramString)
  {
    return a.b(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p3.b
 * JD-Core Version:    0.7.0.1
 */