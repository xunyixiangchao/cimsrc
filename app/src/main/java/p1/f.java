package p1;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

public final class f
{
  public static List<Uri> a(Cursor paramCursor)
  {
    return paramCursor.getNotificationUris();
  }
  
  public static void b(Cursor paramCursor, ContentResolver paramContentResolver, List<Uri> paramList)
  {
    paramCursor.setNotificationUris(paramContentResolver, paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.f
 * JD-Core Version:    0.7.0.1
 */