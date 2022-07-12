package d8;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract.Calendars;

class b
  implements m
{
  private ContentResolver a;
  
  b(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    Cursor localCursor = this.a.query(CalendarContract.Calendars.CONTENT_URI, new String[] { "_id", "name" }, null, null, null);
    if (localCursor != null) {
      try
      {
        m.a.a(localCursor);
        return true;
      }
      finally
      {
        localCursor.close();
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.b
 * JD-Core Version:    0.7.0.1
 */