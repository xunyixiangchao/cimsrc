package q1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import p1.d;
import p1.g;
import p1.h;
import p1.h.a;

class b
  implements h
{
  private final Context a;
  private final String b;
  private final h.a c;
  private final boolean d;
  private final Object e;
  private a f;
  private boolean g;
  
  b(Context paramContext, String paramString, h.a parama, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = parama;
    this.d = paramBoolean;
    this.e = new Object();
  }
  
  private a a()
  {
    synchronized (this.e)
    {
      if (this.f == null)
      {
        localObject2 = new a[1];
        if ((this.b != null) && (this.d))
        {
          File localFile = new File(d.a(this.a), this.b);
          this.f = new a(this.a, localFile.getAbsolutePath(), (a[])localObject2, this.c);
        }
        else
        {
          this.f = new a(this.a, this.b, (a[])localObject2, this.c);
        }
        p1.b.d(this.f, this.g);
      }
      Object localObject2 = this.f;
      return localObject2;
    }
  }
  
  public g X()
  {
    return a().h();
  }
  
  public void close()
  {
    a().close();
  }
  
  public String getDatabaseName()
  {
    return this.b;
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    synchronized (this.e)
    {
      a locala = this.f;
      if (locala != null) {
        p1.b.d(locala, paramBoolean);
      }
      this.g = paramBoolean;
      return;
    }
  }
  
  static class a
    extends SQLiteOpenHelper
  {
    final a[] a;
    final h.a b;
    private boolean c;
    
    a(Context paramContext, String paramString, final a[] paramArrayOfa, h.a parama)
    {
      super(paramString, null, parama.a, new a(parama, paramArrayOfa));
      this.b = parama;
      this.a = paramArrayOfa;
    }
    
    static a g(a[] paramArrayOfa, SQLiteDatabase paramSQLiteDatabase)
    {
      a locala = paramArrayOfa[0];
      if ((locala == null) || (!locala.a(paramSQLiteDatabase))) {
        paramArrayOfa[0] = new a(paramSQLiteDatabase);
      }
      return paramArrayOfa[0];
    }
    
    a a(SQLiteDatabase paramSQLiteDatabase)
    {
      return g(this.a, paramSQLiteDatabase);
    }
    
    public void close()
    {
      try
      {
        super.close();
        this.a[0] = null;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    g h()
    {
      try
      {
        this.c = false;
        Object localObject1 = super.getWritableDatabase();
        if (this.c)
        {
          close();
          localObject1 = h();
          return localObject1;
        }
        localObject1 = a((SQLiteDatabase)localObject1);
        return localObject1;
      }
      finally {}
    }
    
    public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
    {
      this.b.b(a(paramSQLiteDatabase));
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      this.b.d(a(paramSQLiteDatabase));
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.c = true;
      this.b.e(a(paramSQLiteDatabase), paramInt1, paramInt2);
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!this.c) {
        this.b.f(a(paramSQLiteDatabase));
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      this.c = true;
      this.b.g(a(paramSQLiteDatabase), paramInt1, paramInt2);
    }
    
    class a
      implements DatabaseErrorHandler
    {
      a(a[] paramArrayOfa) {}
      
      public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
      {
        b.a.this.c(b.a.g(paramArrayOfa, paramSQLiteDatabase));
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q1.b
 * JD-Core Version:    0.7.0.1
 */