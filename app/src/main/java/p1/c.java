package p1;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;

public final class c
{
  public static Uri a(Cursor paramCursor)
  {
    return paramCursor.getNotificationUri();
  }
  
  public static boolean b(ActivityManager paramActivityManager)
  {
    return paramActivityManager.isLowRamDevice();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.c
 * JD-Core Version:    0.7.0.1
 */