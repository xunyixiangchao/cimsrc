package b4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.b;
import p1.i;
import p1.k;

public final class d
  implements c
{
  private final f0 a;
  private final g<Emoticon> b;
  private final m c;
  private final m d;
  private final m e;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
  }
  
  public static List<Class<?>> b()
  {
    return Collections.emptyList();
  }
  
  public Emoticon a(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_emoticon where id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject2 = this.a;
    Emoticon localEmoticon = null;
    localObject2 = o1.c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = b.e((Cursor)localObject2, "id");
      int j = b.e((Cursor)localObject2, "name");
      int k = b.e((Cursor)localObject2, "state");
      int m = b.e((Cursor)localObject2, "index");
      int n = b.e((Cursor)localObject2, "type");
      int i1 = b.e((Cursor)localObject2, "description");
      if (((Cursor)localObject2).moveToFirst())
      {
        localEmoticon = new Emoticon();
        if (((Cursor)localObject2).isNull(i)) {
          localEmoticon.id = null;
        } else {
          localEmoticon.id = Long.valueOf(((Cursor)localObject2).getLong(i));
        }
        if (((Cursor)localObject2).isNull(j)) {
          localEmoticon.name = null;
        } else {
          localEmoticon.name = ((Cursor)localObject2).getString(j);
        }
        localEmoticon.state = ((byte)((Cursor)localObject2).getShort(k));
        localEmoticon.index = ((Cursor)localObject2).getLong(m);
        localEmoticon.type = ((byte)((Cursor)localObject2).getShort(n));
        if (((Cursor)localObject2).isNull(i1)) {
          localEmoticon.description = null;
        } else {
          localEmoticon.description = ((Cursor)localObject2).getString(i1);
        }
      }
      return localEmoticon;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public List<Emoticon> e()
  {
    l locall = l.h("select * from t_hoxin_emoticon where state = 0 order by `index` desc", 0);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(localCursor, "id");
      int j = b.e(localCursor, "name");
      int k = b.e(localCursor, "state");
      int m = b.e(localCursor, "index");
      int n = b.e(localCursor, "type");
      int i1 = b.e(localCursor, "description");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Emoticon localEmoticon = new Emoticon();
        if (localCursor.isNull(i)) {
          localEmoticon.id = null;
        } else {
          localEmoticon.id = Long.valueOf(localCursor.getLong(i));
        }
        if (localCursor.isNull(j)) {
          localEmoticon.name = null;
        } else {
          localEmoticon.name = localCursor.getString(j);
        }
        localEmoticon.state = ((byte)localCursor.getShort(k));
        localEmoticon.index = localCursor.getLong(m);
        localEmoticon.type = ((byte)localCursor.getShort(n));
        if (localCursor.isNull(i1)) {
          localEmoticon.description = null;
        } else {
          localEmoticon.description = localCursor.getString(i1);
        }
        localArrayList.add(localEmoticon);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void f(Long paramLong)
  {
    this.a.d();
    k localk = this.d.a();
    if (paramLong == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong.longValue());
    }
    this.a.e();
    try
    {
      localk.u();
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
      this.d.f(localk);
    }
  }
  
  public void g(Emoticon paramEmoticon)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramEmoticon);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public long h(long paramLong, byte paramByte)
  {
    l locall = l.h("select count(*) from t_hoxin_emoticon where id = ? and state = ?", 2);
    locall.O(1, paramLong);
    locall.O(2, paramByte);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      if (localCursor.moveToFirst()) {
        paramLong = localCursor.getLong(0);
      } else {
        paramLong = 0L;
      }
      return paramLong;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void i(Long paramLong)
  {
    this.a.d();
    k localk = this.e.a();
    if (paramLong == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong.longValue());
    }
    this.a.e();
    try
    {
      localk.u();
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
      this.e.f(localk);
    }
  }
  
  public long j(long paramLong)
  {
    l locall = l.h("select count(*) from t_hoxin_emoticon where id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      if (localCursor.moveToFirst()) {
        paramLong = localCursor.getLong(0);
      } else {
        paramLong = 0L;
      }
      return paramLong;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<Emoticon> k()
  {
    l locall = l.h("select * from t_hoxin_emoticon where state != -1 order by `index` desc", 0);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(localCursor, "id");
      int j = b.e(localCursor, "name");
      int k = b.e(localCursor, "state");
      int m = b.e(localCursor, "index");
      int n = b.e(localCursor, "type");
      int i1 = b.e(localCursor, "description");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Emoticon localEmoticon = new Emoticon();
        if (localCursor.isNull(i)) {
          localEmoticon.id = null;
        } else {
          localEmoticon.id = Long.valueOf(localCursor.getLong(i));
        }
        if (localCursor.isNull(j)) {
          localEmoticon.name = null;
        } else {
          localEmoticon.name = localCursor.getString(j);
        }
        localEmoticon.state = ((byte)localCursor.getShort(k));
        localEmoticon.index = localCursor.getLong(m);
        localEmoticon.type = ((byte)localCursor.getShort(n));
        if (localCursor.isNull(i1)) {
          localEmoticon.description = null;
        } else {
          localEmoticon.description = localCursor.getString(i1);
        }
        localArrayList.add(localEmoticon);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  class a
    extends g<Emoticon>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_emoticon` (`id`,`name`,`state`,`index`,`type`,`description`) VALUES (?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Emoticon paramEmoticon)
    {
      Object localObject = paramEmoticon.id;
      if (localObject == null) {
        paramk.y(1);
      } else {
        paramk.O(1, ((Long)localObject).longValue());
      }
      localObject = paramEmoticon.name;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.r(2, (String)localObject);
      }
      paramk.O(3, paramEmoticon.state);
      paramk.O(4, paramEmoticon.index);
      paramk.O(5, paramEmoticon.type);
      paramEmoticon = paramEmoticon.description;
      if (paramEmoticon == null)
      {
        paramk.y(6);
        return;
      }
      paramk.r(6, paramEmoticon);
    }
  }
  
  class b
    extends m
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_emoticon where id = ?";
    }
  }
  
  class c
    extends m
  {
    c(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "update t_hoxin_emoticon set state = 0 where id = ?";
    }
  }
  
  class d
    extends m
  {
    d(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "update t_hoxin_emoticon set state = 1 where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b4.d
 * JD-Core Version:    0.7.0.1
 */