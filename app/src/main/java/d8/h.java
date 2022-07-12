package d8;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;

class h
  implements m
{
  private ContentResolver a;
  
  h(ContentResolver paramContentResolver)
  {
    this.a = paramContentResolver;
  }
  
  private boolean b()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id", Long.valueOf(ContentUris.parseId(this.a.insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues))));
    localContentValues.put("data1", "PERMISSION");
    localContentValues.put("data2", "PERMISSION");
    localContentValues.put("mimetype", "vnd.android.cursor.item/name");
    return ContentUris.parseId(this.a.insert(ContactsContract.Data.CONTENT_URI, localContentValues)) > 0L;
  }
  
  private boolean c(long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("raw_contact_id", Long.valueOf(paramLong));
    localContentValues.put("data1", "PERMISSION");
    localContentValues.put("data2", "PERMISSION");
    localContentValues.put("mimetype", "vnd.android.cursor.item/name");
    return ContentUris.parseId(this.a.insert(ContactsContract.Data.CONTENT_URI, localContentValues)) > 0L;
  }
  
  public boolean a()
  {
    Cursor localCursor = this.a.query(ContactsContract.Data.CONTENT_URI, new String[] { "raw_contact_id" }, "mimetype=? and data1=?", new String[] { "vnd.android.cursor.item/name", "PERMISSION" }, null);
    if (localCursor != null)
    {
      if (localCursor.moveToFirst())
      {
        long l = localCursor.getLong(0);
        localCursor.close();
        return c(l);
      }
      localCursor.close();
      return b();
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.h
 * JD-Core Version:    0.7.0.1
 */