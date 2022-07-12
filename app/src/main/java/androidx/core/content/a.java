package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import u0.b;
import u0.e;

public final class a
{
  public static Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      try
      {
        paramb = paramb.b();
        paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (CancellationSignal)paramb);
        return paramContentResolver;
      }
      catch (Exception paramContentResolver)
      {
        continue;
      }
      if ((paramContentResolver instanceof OperationCanceledException)) {
        throw new e();
      }
      throw paramContentResolver;
      paramb = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.content.a
 * JD-Core Version:    0.7.0.1
 */