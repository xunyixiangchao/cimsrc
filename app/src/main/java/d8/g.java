package d8;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

class g
  implements m
{
  private ContentResolver a;
  
  g(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    Cursor localCursor = this.a.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { "_id", "data1" }, null, null, null);
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
 * Qualified Name:     d8.g
 * JD-Core Version:    0.7.0.1
 */