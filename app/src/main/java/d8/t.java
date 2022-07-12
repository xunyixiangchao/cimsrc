package d8;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

class t
  implements m
{
  public boolean a()
  {
    if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
      return true;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if (!((File)localObject).exists()) {
      return true;
    }
    long l = ((File)localObject).lastModified();
    localObject = ((File)localObject).list();
    return (l > 0L) && (localObject != null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.t
 * JD-Core Version:    0.7.0.1
 */