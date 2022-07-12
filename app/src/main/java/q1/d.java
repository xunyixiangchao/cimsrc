package q1;

import android.database.sqlite.SQLiteProgram;
import p1.i;

class d
  implements i
{
  private final SQLiteProgram a;
  
  d(SQLiteProgram paramSQLiteProgram)
  {
    this.a = paramSQLiteProgram;
  }
  
  public void A(int paramInt, double paramDouble)
  {
    this.a.bindDouble(paramInt, paramDouble);
  }
  
  public void O(int paramInt, long paramLong)
  {
    this.a.bindLong(paramInt, paramLong);
  }
  
  public void S(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.bindBlob(paramInt, paramArrayOfByte);
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void r(int paramInt, String paramString)
  {
    this.a.bindString(paramInt, paramString);
  }
  
  public void y(int paramInt)
  {
    this.a.bindNull(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q1.d
 * JD-Core Version:    0.7.0.1
 */