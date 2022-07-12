package d8;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

class u
  implements m
{
  public boolean a()
  {
    if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
      return true;
    }
    File localFile = Environment.getExternalStorageDirectory();
    if (!localFile.exists()) {
      return true;
    }
    localFile = new File(localFile, "Android");
    if ((localFile.exists()) && (localFile.isFile()) && (!localFile.delete())) {
      return false;
    }
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return false;
    }
    localFile = new File(localFile, "ANDROID.PERMISSION.TEST");
    if (localFile.exists()) {
      return localFile.delete();
    }
    return localFile.createNewFile();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.u
 * JD-Core Version:    0.7.0.1
 */