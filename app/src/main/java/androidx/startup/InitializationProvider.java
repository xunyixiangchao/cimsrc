package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import r1.b;

public final class InitializationProvider
  extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Not allowed.");
  }
  
  public String getType(Uri paramUri)
  {
    throw new IllegalStateException("Not allowed.");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new IllegalStateException("Not allowed.");
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    if (localContext != null)
    {
      a.c(localContext).a();
      return true;
    }
    throw new b("Context cannot be null");
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    throw new IllegalStateException("Not allowed.");
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new IllegalStateException("Not allowed.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.startup.InitializationProvider
 * JD-Core Version:    0.7.0.1
 */