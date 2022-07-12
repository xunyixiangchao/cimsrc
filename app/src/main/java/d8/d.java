package d8;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog.Calls;

class d
  implements m
{
  private ContentResolver a;
  
  d(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    Cursor localCursor = this.a.query(CallLog.Calls.CONTENT_URI, new String[] { "_id", "number", "type" }, null, null, null);
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
 * Qualified Name:     d8.d
 * JD-Core Version:    0.7.0.1
 */