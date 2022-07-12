package androidx.room;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import m1.k;
import n1.b;
import p1.a;
import p1.g;
import p1.h.a;

public class g0
  extends h.a
{
  private h b;
  private final a c;
  private final String d;
  private final String e;
  
  public g0(h paramh, a parama, String paramString1, String paramString2)
  {
    super(parama.a);
    this.b = paramh;
    this.c = parama;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  private void h(g paramg)
  {
    b localb;
    if (k(paramg))
    {
      localb = null;
      Cursor localCursor = paramg.x(new a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
      paramg = localb;
      try
      {
        if (localCursor.moveToFirst()) {
          paramg = localCursor.getString(0);
        }
        localCursor.close();
        if (this.d.equals(paramg)) {
          break label121;
        }
        if (this.e.equals(paramg)) {
          return;
        }
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
      }
      finally
      {
        localCursor.close();
      }
    }
    else
    {
      localb = this.c.g(paramg);
      if (!localb.a) {
        break label122;
      }
      this.c.e(paramg);
      l(paramg);
    }
    label121:
    return;
    label122:
    paramg = new StringBuilder();
    paramg.append("Pre-packaged database has an invalid schema: ");
    paramg.append(localb.b);
    throw new IllegalStateException(paramg.toString());
  }
  
  private void i(g paramg)
  {
    paramg.p("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
  }
  
  private static boolean j(g paramg)
  {
    paramg = paramg.a0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
    try
    {
      boolean bool3 = paramg.moveToFirst();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = paramg.getInt(0);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      paramg.close();
    }
  }
  
  private static boolean k(g paramg)
  {
    paramg = paramg.a0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    try
    {
      boolean bool3 = paramg.moveToFirst();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool3)
      {
        int i = paramg.getInt(0);
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      paramg.close();
    }
  }
  
  private void l(g paramg)
  {
    i(paramg);
    paramg.p(k.a(this.d));
  }
  
  public void b(g paramg)
  {
    super.b(paramg);
  }
  
  public void d(g paramg)
  {
    boolean bool = j(paramg);
    this.c.a(paramg);
    if (!bool)
    {
      b localb = this.c.g(paramg);
      if (!localb.a)
      {
        paramg = new StringBuilder();
        paramg.append("Pre-packaged database has an invalid schema: ");
        paramg.append(localb.b);
        throw new IllegalStateException(paramg.toString());
      }
    }
    l(paramg);
    this.c.c(paramg);
  }
  
  public void e(g paramg, int paramInt1, int paramInt2)
  {
    g(paramg, paramInt1, paramInt2);
  }
  
  public void f(g paramg)
  {
    super.f(paramg);
    h(paramg);
    this.c.d(paramg);
    this.b = null;
  }
  
  public void g(g paramg, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((h)localObject).d.c(paramInt1, paramInt2);
      if (localObject != null)
      {
        this.c.f(paramg);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).a(paramg);
        }
        localObject = this.c.g(paramg);
        if (((b)localObject).a)
        {
          this.c.e(paramg);
          l(paramg);
          i = 1;
          break label149;
        }
        paramg = new StringBuilder();
        paramg.append("Migration didn't properly handle: ");
        paramg.append(((b)localObject).b);
        throw new IllegalStateException(paramg.toString());
      }
    }
    int i = 0;
    label149:
    if (i == 0)
    {
      localObject = this.b;
      if ((localObject != null) && (!((h)localObject).a(paramInt1, paramInt2)))
      {
        this.c.b(paramg);
        this.c.a(paramg);
        return;
      }
      paramg = new StringBuilder();
      paramg.append("A migration from ");
      paramg.append(paramInt1);
      paramg.append(" to ");
      paramg.append(paramInt2);
      paramg.append(" was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
      throw new IllegalStateException(paramg.toString());
    }
  }
  
  public static abstract class a
  {
    public final int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    protected abstract void a(g paramg);
    
    protected abstract void b(g paramg);
    
    protected abstract void c(g paramg);
    
    protected abstract void d(g paramg);
    
    protected abstract void e(g paramg);
    
    protected abstract void f(g paramg);
    
    protected abstract g0.b g(g paramg);
  }
  
  public static class b
  {
    public final boolean a;
    public final String b;
    
    public b(boolean paramBoolean, String paramString)
    {
      this.a = paramBoolean;
      this.b = paramString;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.g0
 * JD-Core Version:    0.7.0.1
 */