package d8;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.CalendarContract.Calendars;
import java.util.TimeZone;

class c
  implements m
{
  private ContentResolver a;
  
  c(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    try
    {
      localObject3 = TimeZone.getDefault();
      Object localObject1 = new ContentValues();
      ((ContentValues)localObject1).put("name", "PERMISSION");
      ((ContentValues)localObject1).put("account_name", "permission@gmail.com");
      ((ContentValues)localObject1).put("account_type", "LOCAL");
      ((ContentValues)localObject1).put("calendar_displayName", "PERMISSION");
      boolean bool = true;
      ((ContentValues)localObject1).put("visible", Integer.valueOf(1));
      ((ContentValues)localObject1).put("calendar_color", Integer.valueOf(-16776961));
      ((ContentValues)localObject1).put("calendar_access_level", Integer.valueOf(700));
      ((ContentValues)localObject1).put("sync_events", Integer.valueOf(1));
      ((ContentValues)localObject1).put("calendar_timezone", ((TimeZone)localObject3).getID());
      ((ContentValues)localObject1).put("ownerAccount", "PERMISSION");
      ((ContentValues)localObject1).put("canOrganizerRespond", Integer.valueOf(0));
      localObject3 = CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "PERMISSION").appendQueryParameter("account_type", "LOCAL").build();
      long l = ContentUris.parseId(this.a.insert((Uri)localObject3, (ContentValues)localObject1));
      if (l <= 0L) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      Object localObject3 = CalendarContract.Calendars.CONTENT_URI.buildUpon().build();
      this.a.delete((Uri)localObject3, "account_name=?", new String[] { "permission@gmail.com" });
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.c
 * JD-Core Version:    0.7.0.1
 */