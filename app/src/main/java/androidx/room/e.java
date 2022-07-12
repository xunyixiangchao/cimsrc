package androidx.room;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p1.g;
import p1.h;
import p1.j;
import p1.k;

final class e
  implements h, i
{
  private final h a;
  private final a b;
  private final a c;
  
  e(h paramh, a parama)
  {
    this.a = paramh;
    this.c = parama;
    parama.f(paramh);
    this.b = new a(parama);
  }
  
  public g X()
  {
    this.b.e0();
    return this.b;
  }
  
  public h a()
  {
    return this.a;
  }
  
  public void close()
  {
    try
    {
      this.b.close();
      return;
    }
    catch (IOException localIOException)
    {
      o1.e.a(localIOException);
    }
  }
  
  a g()
  {
    return this.c;
  }
  
  public String getDatabaseName()
  {
    return this.a.getDatabaseName();
  }
  
  public void setWriteAheadLoggingEnabled(boolean paramBoolean)
  {
    this.a.setWriteAheadLoggingEnabled(paramBoolean);
  }
  
  static final class a
    implements g
  {
    private final a a;
    
    a(a parama)
    {
      this.a = parama;
    }
    
    public String G()
    {
      return (String)this.a.c(m1.b.a);
    }
    
    public boolean I()
    {
      if (this.a.d() == null) {
        return false;
      }
      return ((Boolean)this.a.c(m1.c.a)).booleanValue();
    }
    
    public boolean M()
    {
      return ((Boolean)this.a.c(c.a)).booleanValue();
    }
    
    public void P()
    {
      g localg = this.a.d();
      if (localg != null)
      {
        localg.P();
        return;
      }
      throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
    }
    
    public Cursor Q(j paramj, CancellationSignal paramCancellationSignal)
    {
      try
      {
        paramj = this.a.e().Q(paramj, paramCancellationSignal);
        return new e.c(paramj, this.a);
      }
      finally
      {
        this.a.b();
      }
    }
    
    public void R()
    {
      g localg = this.a.e();
      try
      {
        localg.R();
        return;
      }
      finally
      {
        this.a.b();
      }
    }
    
    public Cursor a0(String paramString)
    {
      try
      {
        paramString = this.a.e().a0(paramString);
        return new e.c(paramString, this.a);
      }
      finally
      {
        this.a.b();
      }
    }
    
    public void close()
    {
      this.a.a();
    }
    
    public void e()
    {
      if (this.a.d() != null) {
        try
        {
          this.a.d().e();
          return;
        }
        finally
        {
          this.a.b();
        }
      }
      throw new IllegalStateException("End transaction called but delegateDb is null");
    }
    
    void e0()
    {
      this.a.c(d.a);
    }
    
    public void f()
    {
      g localg = this.a.e();
      try
      {
        localg.f();
        return;
      }
      finally
      {
        this.a.b();
      }
    }
    
    public boolean isOpen()
    {
      g localg = this.a.d();
      if (localg == null) {
        return false;
      }
      return localg.isOpen();
    }
    
    public List<Pair<String, String>> m()
    {
      return (List)this.a.c(m1.a.a);
    }
    
    public void p(String paramString)
    {
      this.a.c(new b(paramString));
    }
    
    public k v(String paramString)
    {
      return new e.b(paramString, this.a);
    }
    
    public Cursor x(j paramj)
    {
      try
      {
        paramj = this.a.e().x(paramj);
        return new e.c(paramj, this.a);
      }
      finally
      {
        this.a.b();
      }
    }
  }
  
  private static class b
    implements k
  {
    private final String a;
    private final ArrayList<Object> b = new ArrayList();
    private final a c;
    
    b(String paramString, a parama)
    {
      this.a = paramString;
      this.c = parama;
    }
    
    private void B(int paramInt, Object paramObject)
    {
      int i = paramInt - 1;
      if (i >= this.b.size())
      {
        paramInt = this.b.size();
        while (paramInt <= i)
        {
          this.b.add(null);
          paramInt += 1;
        }
      }
      this.b.set(i, paramObject);
    }
    
    private void g(k paramk)
    {
      int j;
      for (int i = 0; i < this.b.size(); i = j)
      {
        j = i + 1;
        Object localObject = this.b.get(i);
        if (localObject == null) {
          paramk.y(j);
        } else if ((localObject instanceof Long)) {
          paramk.O(j, ((Long)localObject).longValue());
        } else if ((localObject instanceof Double)) {
          paramk.A(j, ((Double)localObject).doubleValue());
        } else if ((localObject instanceof String)) {
          paramk.r(j, (String)localObject);
        } else if ((localObject instanceof byte[])) {
          paramk.S(j, (byte[])localObject);
        }
      }
    }
    
    private <T> T h(k.a<k, T> parama)
    {
      return this.c.c(new f(this, parama));
    }
    
    public void A(int paramInt, double paramDouble)
    {
      B(paramInt, Double.valueOf(paramDouble));
    }
    
    public void O(int paramInt, long paramLong)
    {
      B(paramInt, Long.valueOf(paramLong));
    }
    
    public void S(int paramInt, byte[] paramArrayOfByte)
    {
      B(paramInt, paramArrayOfByte);
    }
    
    public long Z()
    {
      return ((Long)h(m1.e.a)).longValue();
    }
    
    public void close() {}
    
    public void r(int paramInt, String paramString)
    {
      B(paramInt, paramString);
    }
    
    public int u()
    {
      return ((Integer)h(m1.d.a)).intValue();
    }
    
    public void y(int paramInt)
    {
      B(paramInt, null);
    }
  }
  
  private static final class c
    implements Cursor
  {
    private final Cursor a;
    private final a b;
    
    c(Cursor paramCursor, a parama)
    {
      this.a = paramCursor;
      this.b = parama;
    }
    
    public void close()
    {
      this.a.close();
      this.b.b();
    }
    
    public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
    {
      this.a.copyStringToBuffer(paramInt, paramCharArrayBuffer);
    }
    
    @Deprecated
    public void deactivate()
    {
      this.a.deactivate();
    }
    
    public byte[] getBlob(int paramInt)
    {
      return this.a.getBlob(paramInt);
    }
    
    public int getColumnCount()
    {
      return this.a.getColumnCount();
    }
    
    public int getColumnIndex(String paramString)
    {
      return this.a.getColumnIndex(paramString);
    }
    
    public int getColumnIndexOrThrow(String paramString)
    {
      return this.a.getColumnIndexOrThrow(paramString);
    }
    
    public String getColumnName(int paramInt)
    {
      return this.a.getColumnName(paramInt);
    }
    
    public String[] getColumnNames()
    {
      return this.a.getColumnNames();
    }
    
    public int getCount()
    {
      return this.a.getCount();
    }
    
    public double getDouble(int paramInt)
    {
      return this.a.getDouble(paramInt);
    }
    
    public Bundle getExtras()
    {
      return this.a.getExtras();
    }
    
    public float getFloat(int paramInt)
    {
      return this.a.getFloat(paramInt);
    }
    
    public int getInt(int paramInt)
    {
      return this.a.getInt(paramInt);
    }
    
    public long getLong(int paramInt)
    {
      return this.a.getLong(paramInt);
    }
    
    public Uri getNotificationUri()
    {
      return p1.c.a(this.a);
    }
    
    public List<Uri> getNotificationUris()
    {
      return p1.f.a(this.a);
    }
    
    public int getPosition()
    {
      return this.a.getPosition();
    }
    
    public short getShort(int paramInt)
    {
      return this.a.getShort(paramInt);
    }
    
    public String getString(int paramInt)
    {
      return this.a.getString(paramInt);
    }
    
    public int getType(int paramInt)
    {
      return this.a.getType(paramInt);
    }
    
    public boolean getWantsAllOnMoveCalls()
    {
      return this.a.getWantsAllOnMoveCalls();
    }
    
    public boolean isAfterLast()
    {
      return this.a.isAfterLast();
    }
    
    public boolean isBeforeFirst()
    {
      return this.a.isBeforeFirst();
    }
    
    public boolean isClosed()
    {
      return this.a.isClosed();
    }
    
    public boolean isFirst()
    {
      return this.a.isFirst();
    }
    
    public boolean isLast()
    {
      return this.a.isLast();
    }
    
    public boolean isNull(int paramInt)
    {
      return this.a.isNull(paramInt);
    }
    
    public boolean move(int paramInt)
    {
      return this.a.move(paramInt);
    }
    
    public boolean moveToFirst()
    {
      return this.a.moveToFirst();
    }
    
    public boolean moveToLast()
    {
      return this.a.moveToLast();
    }
    
    public boolean moveToNext()
    {
      return this.a.moveToNext();
    }
    
    public boolean moveToPosition(int paramInt)
    {
      return this.a.moveToPosition(paramInt);
    }
    
    public boolean moveToPrevious()
    {
      return this.a.moveToPrevious();
    }
    
    public void registerContentObserver(ContentObserver paramContentObserver)
    {
      this.a.registerContentObserver(paramContentObserver);
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.a.registerDataSetObserver(paramDataSetObserver);
    }
    
    @Deprecated
    public boolean requery()
    {
      return this.a.requery();
    }
    
    public Bundle respond(Bundle paramBundle)
    {
      return this.a.respond(paramBundle);
    }
    
    public void setExtras(Bundle paramBundle)
    {
      p1.e.a(this.a, paramBundle);
    }
    
    public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
    {
      this.a.setNotificationUri(paramContentResolver, paramUri);
    }
    
    public void setNotificationUris(ContentResolver paramContentResolver, List<Uri> paramList)
    {
      p1.f.b(this.a, paramContentResolver, paramList);
    }
    
    public void unregisterContentObserver(ContentObserver paramContentObserver)
    {
      this.a.unregisterContentObserver(paramContentObserver);
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.a.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.e
 * JD-Core Version:    0.7.0.1
 */