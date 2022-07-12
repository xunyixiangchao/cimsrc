package o2;

import android.util.Log;
import b2.h;
import b2.k;
import d2.v;
import java.io.File;
import java.io.IOException;
import x2.a;

public class d
  implements k<c>
{
  public b2.c b(h paramh)
  {
    return b2.c.a;
  }
  
  public boolean c(v<c> paramv, File paramFile, h paramh)
  {
    paramv = (c)paramv.get();
    try
    {
      a.f(paramv.c(), paramFile);
      return true;
    }
    catch (IOException paramv)
    {
      if (Log.isLoggable("GifEncoder", 5)) {
        Log.w("GifEncoder", "Failed to encode GIF drawable data", paramv);
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o2.d
 * JD-Core Version:    0.7.0.1
 */