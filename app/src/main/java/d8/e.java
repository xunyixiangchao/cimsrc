package d8;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CallLog.Calls;

class e
  implements m
{
  private ContentResolver a;
  
  e(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      boolean bool = true;
      localContentValues.put("type", Integer.valueOf(1));
      localContentValues.put("number", "1");
      localContentValues.put("date", Integer.valueOf(20080808));
      localContentValues.put("new", "0");
      long l = ContentUris.parseId(this.a.insert(CallLog.Calls.CONTENT_URI, localContentValues));
      if (l <= 0L) {
        bool = false;
      }
      return bool;
    }
    finally
    {
      this.a.delete(CallLog.Calls.CONTENT_URI, "number=?", new String[] { "1" });
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.e
 * JD-Core Version:    0.7.0.1
 */