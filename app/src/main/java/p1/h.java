package p1;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public abstract interface h
  extends Closeable
{
  public abstract g X();
  
  public abstract void close();
  
  public abstract String getDatabaseName();
  
  public abstract void setWriteAheadLoggingEnabled(boolean paramBoolean);
  
  public static abstract class a
  {
    public final int a;
    
    public a(int paramInt)
    {
      this.a = paramInt;
    }
    
    private void a(String paramString)
    {
      if (!paramString.equalsIgnoreCase(":memory:"))
      {
        if (paramString.trim().length() == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("deleting the database file: ");
        localStringBuilder.append(paramString);
        Log.w("SupportSQLite", localStringBuilder.toString());
        try
        {
          b.a(new File(paramString));
          return;
        }
        catch (Exception paramString)
        {
          Log.w("SupportSQLite", "delete failed: ", paramString);
        }
      }
    }
    
    public void b(g paramg) {}
    
    public void c(g paramg)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Corruption reported by sqlite on database: ");
      ((StringBuilder)localObject1).append(paramg.G());
      Log.e("SupportSQLite", ((StringBuilder)localObject1).toString());
      if (!paramg.isOpen())
      {
        a(paramg.G());
        return;
      }
      localObject1 = null;
      Object localObject3 = null;
      label143:
      try
      {
        try
        {
          List localList = paramg.m();
          localObject1 = localList;
        }
        finally
        {
          break label89;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        label78:
        label89:
        break label78;
      }
      localObject3 = localObject2;
      try
      {
        paramg.close();
      }
      catch (IOException localIOException)
      {
        break label143;
      }
      if (localObject3 != null)
      {
        paramg = localObject3.iterator();
        while (paramg.hasNext()) {
          a((String)((Pair)paramg.next()).second);
        }
      }
      a(paramg.G());
      throw localObject2;
      if (localObject2 != null)
      {
        paramg = localObject2.iterator();
        while (paramg.hasNext()) {
          a((String)((Pair)paramg.next()).second);
        }
      }
      a(paramg.G());
    }
    
    public abstract void d(g paramg);
    
    public abstract void e(g paramg, int paramInt1, int paramInt2);
    
    public void f(g paramg) {}
    
    public abstract void g(g paramg, int paramInt1, int paramInt2);
  }
  
  public static class b
  {
    public final Context a;
    public final String b;
    public final h.a c;
    public final boolean d;
    
    b(Context paramContext, String paramString, h.a parama, boolean paramBoolean)
    {
      this.a = paramContext;
      this.b = paramString;
      this.c = parama;
      this.d = paramBoolean;
    }
    
    public static a a(Context paramContext)
    {
      return new a(paramContext);
    }
    
    public static class a
    {
      Context a;
      String b;
      h.a c;
      boolean d;
      
      a(Context paramContext)
      {
        this.a = paramContext;
      }
      
      public h.b a()
      {
        if (this.c != null)
        {
          if (this.a != null)
          {
            if ((this.d) && (TextUtils.isEmpty(this.b))) {
              throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
            return new h.b(this.a, this.b, this.c, this.d);
          }
          throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        throw new IllegalArgumentException("Must set a callback to create the configuration.");
      }
      
      public a b(h.a parama)
      {
        this.c = parama;
        return this;
      }
      
      public a c(String paramString)
      {
        this.b = paramString;
        return this;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract h a(h.b paramb);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.h
 * JD-Core Version:    0.7.0.1
 */