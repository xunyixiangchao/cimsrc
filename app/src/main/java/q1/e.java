package q1;

import android.database.sqlite.SQLiteStatement;
import p1.k;

class e
  extends d
  implements k
{
  private final SQLiteStatement b;
  
  e(SQLiteStatement paramSQLiteStatement)
  {
    super(paramSQLiteStatement);
    this.b = paramSQLiteStatement;
  }
  
  public long Z()
  {
    return this.b.executeInsert();
  }
  
  public int u()
  {
    return this.b.executeUpdateDelete();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q1.e
 * JD-Core Version:    0.7.0.1
 */