package d8;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Telephony.Sms;

class r
  implements m
{
  private ContentResolver a;
  
  r(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    Cursor localCursor = this.a.query(Telephony.Sms.CONTENT_URI, new String[] { "_id", "address", "person", "body" }, null, null, null);
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
 * Qualified Name:     d8.r
 * JD-Core Version:    0.7.0.1
 */