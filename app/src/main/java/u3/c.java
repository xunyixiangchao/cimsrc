package u3;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import com.farsunset.hoxin.common.model.AlbumMedia;
import j1.b;
import java.util.ArrayList;
import java.util.List;

public class c
  extends b
{
  private static final String[] A = { String.valueOf(1), String.valueOf(3) };
  private static final Uri x = MediaStore.Files.getContentUri("external");
  private static String y = "duration";
  private static final String[] z = { "_id", "_data", "_display_name", "mime_type", "_size", "duration" };
  
  private c(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    super(paramContext, x, z, paramString, paramArrayOfString, "date_added DESC");
  }
  
  private static String[] L(String paramString)
  {
    return new String[] { String.valueOf(1), String.valueOf(3), paramString };
  }
  
  public static c M(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = "media_type=? AND _size>0";
    if ((paramString != null) && (!paramString.equals("ALL_MEDIA_7458293244741369741")) && (!paramString.equals("IMAGE_ONLY_7458293244741369741")))
    {
      if (paramString.equals("VIDEO_ONLY_7458293244741369741"))
      {
        paramString = new String[1];
        paramString[0] = String.valueOf(3);
      }
      else if (paramBoolean)
      {
        str = "media_type=? AND  bucket_id=? AND _size>0";
        paramString = new String[] { String.valueOf(1), paramString };
      }
      else
      {
        paramString = L(paramString);
        str = "(media_type=? OR media_type=?) AND  bucket_id=? AND _size>0";
      }
    }
    else if (paramBoolean)
    {
      paramString = new String[1];
      paramString[0] = String.valueOf(1);
    }
    else
    {
      paramString = A;
      str = "(media_type=? OR media_type=?) AND _size>0";
    }
    return new c(paramContext, str, paramString);
  }
  
  public Cursor J()
  {
    Cursor localCursor = super.J();
    return new MergeCursor(new Cursor[] { new MatrixCursor(z), localCursor });
  }
  
  public List<AlbumMedia> N()
  {
    Cursor localCursor = J();
    ArrayList localArrayList = new ArrayList();
    while ((localCursor != null) && (localCursor.moveToNext()))
    {
      AlbumMedia localAlbumMedia = new AlbumMedia();
      localAlbumMedia.uri = l.D(localCursor);
      localAlbumMedia.mimeType = localCursor.getString(localCursor.getColumnIndex("mime_type"));
      localAlbumMedia.duration = localCursor.getInt(localCursor.getColumnIndex(y));
      localAlbumMedia.size = localCursor.getLong(localCursor.getColumnIndex("_size"));
      localArrayList.add(localAlbumMedia);
    }
    l.j(localCursor);
    return localArrayList;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.c
 * JD-Core Version:    0.7.0.1
 */