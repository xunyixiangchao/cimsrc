package u3;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.provider.MediaStore.Files;
import com.farsunset.hoxin.HoxinApplication;
import j1.b;

public class a
  extends b
{
  private static final String[] A = { "_id", "bucket_id", "bucket_display_name", "mime_type" };
  private static final String[] B = { String.valueOf(1), String.valueOf(3) };
  private static final Uri y = MediaStore.Files.getContentUri("external");
  private static final String[] z = { "_id", "bucket_id", "bucket_display_name", "mime_type" };
  private boolean x;
  
  private a(Context paramContext, String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramContext, y, A, paramString, paramArrayOfString, "datetaken DESC");
    this.x = paramBoolean;
  }
  
  private static String L(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "media_type=? AND _size>0";
    }
    return "(media_type=? OR media_type=?) AND _size>0";
  }
  
  private static String[] M(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new String[] { String.valueOf(1) };
    }
    return B;
  }
  
  static a N(Context paramContext, boolean paramBoolean)
  {
    return new a(paramContext, L(paramBoolean), M(paramBoolean), paramBoolean);
  }
  
  public Cursor J()
  {
    Cursor localCursor = super.J();
    MatrixCursor localMatrixCursor = new MatrixCursor(z);
    if (!this.x)
    {
      localMatrixCursor.addRow(new Object[] { null, "ALL_MEDIA_7458293244741369741", HoxinApplication.h().getString(2131689643), null });
      localMatrixCursor.addRow(new Object[] { null, "VIDEO_ONLY_7458293244741369741", HoxinApplication.h().getString(2131689647), null });
    }
    else
    {
      localMatrixCursor.addRow(new Object[] { null, "IMAGE_ONLY_7458293244741369741", HoxinApplication.h().getString(2131689645), null });
    }
    return new MergeCursor(new Cursor[] { localMatrixCursor, localCursor });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.a
 * JD-Core Version:    0.7.0.1
 */