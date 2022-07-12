package f2;

import android.content.Context;
import java.io.File;

public final class g
  extends d
{
  public g(Context paramContext)
  {
    this(paramContext, "image_manager_disk_cache", 262144000L);
  }
  
  public g(Context paramContext, final String paramString, long paramLong)
  {
    super(new a(paramContext, paramString), paramLong);
  }
  
  class a
    implements d.a
  {
    a(String paramString) {}
    
    public File a()
    {
      File localFile = g.this.getCacheDir();
      if (localFile == null) {
        return null;
      }
      if (paramString != null) {
        return new File(localFile, paramString);
      }
      return localFile;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.g
 * JD-Core Version:    0.7.0.1
 */