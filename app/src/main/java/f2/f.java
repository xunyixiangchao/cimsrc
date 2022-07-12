package f2;

import android.content.Context;
import java.io.File;

public final class f
  extends d
{
  public f(Context paramContext, final String paramString, long paramLong)
  {
    super(new a(paramContext, paramString), paramLong);
  }
  
  class a
    implements d.a
  {
    a(String paramString) {}
    
    private File b()
    {
      File localFile = f.this.getCacheDir();
      if (localFile == null) {
        return null;
      }
      if (paramString != null) {
        return new File(localFile, paramString);
      }
      return localFile;
    }
    
    public File a()
    {
      File localFile1 = b();
      if ((localFile1 != null) && (localFile1.exists())) {
        return localFile1;
      }
      File localFile2 = f.this.getExternalCacheDir();
      if (localFile2 != null)
      {
        if (!localFile2.canWrite()) {
          return localFile1;
        }
        if (paramString != null) {
          return new File(localFile2, paramString);
        }
        return localFile2;
      }
      return localFile1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f2.f
 * JD-Core Version:    0.7.0.1
 */