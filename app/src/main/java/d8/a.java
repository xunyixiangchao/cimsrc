package d8;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.VoicemailContract.Voicemails;
import android.text.TextUtils;

class a
  implements m
{
  private ContentResolver a;
  
  a(Context paramContext)
  {
    this.a = paramContext.getContentResolver();
  }
  
  public boolean a()
  {
    try
    {
      Uri localUri = VoicemailContract.Voicemails.CONTENT_URI;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("date", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("number", "1");
      localContentValues.put("duration", Integer.valueOf(1));
      localContentValues.put("source_package", "permission");
      localContentValues.put("source_data", "permission");
      localContentValues.put("is_read", Integer.valueOf(0));
      long l = ContentUris.parseId(this.a.insert(localUri, localContentValues));
      int i = this.a.delete(localUri, "_id=?", new String[] { Long.toString(l) });
      return i > 0;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      if (!TextUtils.isEmpty(str)) {
        return str.toLowerCase().contains("add_voicemail") ^ true;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.a
 * JD-Core Version:    0.7.0.1
 */