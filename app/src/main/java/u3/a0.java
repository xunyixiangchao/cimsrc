package u3;

import android.app.Application;
import android.os.Environment;
import com.farsunset.hoxin.HoxinApplication;
import java.io.File;

public class a0
{
  private static File a;
  private static File b;
  private static File c;
  private static File d;
  private static File e;
  
  public static void a()
  {
    a = HoxinApplication.h().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
    c = HoxinApplication.h().getExternalFilesDir("Medias");
    d = HoxinApplication.h().getExternalFilesDir("config");
    b = HoxinApplication.h().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    e = new File(HoxinApplication.h().getExternalFilesDir(Environment.DIRECTORY_DCIM), "hoxin");
  }
  
  public static File b(String paramString)
  {
    return new File(e, paramString);
  }
  
  public static File c(String paramString)
  {
    return new File(d, paramString);
  }
  
  public static File d()
  {
    return a;
  }
  
  public static File e(String paramString)
  {
    return new File(a, paramString);
  }
  
  public static File f(String paramString)
  {
    return new File(b, paramString);
  }
  
  public static File g(String paramString)
  {
    return new File(c, paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.a0
 * JD-Core Version:    0.7.0.1
 */