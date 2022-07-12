package p1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

public final class b
{
  public static boolean a(File paramFile)
  {
    return SQLiteDatabase.deleteDatabase(paramFile);
  }
  
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    return paramSQLiteDatabase.isWriteAheadLoggingEnabled();
  }
  
  public static Cursor c(SQLiteDatabase paramSQLiteDatabase, String paramString1, String[] paramArrayOfString, String paramString2, CancellationSignal paramCancellationSignal, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return paramSQLiteDatabase.rawQueryWithFactory(paramCursorFactory, paramString1, paramArrayOfString, paramString2, paramCancellationSignal);
  }
  
  public static void d(SQLiteOpenHelper paramSQLiteOpenHelper, boolean paramBoolean)
  {
    paramSQLiteOpenHelper.setWriteAheadLoggingEnabled(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.b
 * JD-Core Version:    0.7.0.1
 */