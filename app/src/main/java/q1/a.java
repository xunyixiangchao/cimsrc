package q1;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import java.util.List;
import p1.b;
import p1.g;
import p1.j;
import p1.k;

class a
  implements g
{
  private static final String[] b = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  private static final String[] c = new String[0];
  private final SQLiteDatabase a;
  
  a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
  }
  
  public String G()
  {
    return this.a.getPath();
  }
  
  public boolean I()
  {
    return this.a.inTransaction();
  }
  
  public boolean M()
  {
    return b.b(this.a);
  }
  
  public void P()
  {
    this.a.setTransactionSuccessful();
  }
  
  public Cursor Q(final j paramj, CancellationSignal paramCancellationSignal)
  {
    return b.c(this.a, paramj.g(), c, null, paramCancellationSignal, new b(paramj));
  }
  
  public void R()
  {
    this.a.beginTransactionNonExclusive();
  }
  
  boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    return this.a == paramSQLiteDatabase;
  }
  
  public Cursor a0(String paramString)
  {
    return x(new p1.a(paramString));
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void e()
  {
    this.a.endTransaction();
  }
  
  public void f()
  {
    this.a.beginTransaction();
  }
  
  public boolean isOpen()
  {
    return this.a.isOpen();
  }
  
  public List<Pair<String, String>> m()
  {
    return this.a.getAttachedDbs();
  }
  
  public void p(String paramString)
  {
    this.a.execSQL(paramString);
  }
  
  public k v(String paramString)
  {
    return new e(this.a.compileStatement(paramString));
  }
  
  public Cursor x(final j paramj)
  {
    return this.a.rawQueryWithFactory(new a(paramj), paramj.g(), c, null);
  }
  
  class a
    implements SQLiteDatabase.CursorFactory
  {
    a(j paramj) {}
    
    public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
    {
      paramj.a(new d(paramSQLiteQuery));
      return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    }
  }
  
  class b
    implements SQLiteDatabase.CursorFactory
  {
    b(j paramj) {}
    
    public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
    {
      paramj.a(new d(paramSQLiteQuery));
      return new SQLiteCursor(paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q1.a
 * JD-Core Version:    0.7.0.1
 */