package h6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.moment.entity.Moment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.b;
import o1.f;
import p1.i;
import p1.j;
import p1.k;

public final class d
  implements c
{
  private final f0 a;
  private final g<Moment> b;
  private final g<Moment> c;
  private final m d;
  private final m e;
  private final m f;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
    this.f = new e(paramf0);
  }
  
  public static List<Class<?>> m()
  {
    return Collections.emptyList();
  }
  
  public void a(Long paramLong)
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
  
  public void b(List<Moment> paramList)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.c.h(paramList);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public Moment c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_moment where id = ? ", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    Object localObject = this.a;
    paramLong = null;
    localObject = o1.c.b((f0)localObject, locall, false, null);
    try
    {
      int i = b.e((Cursor)localObject, "id");
      int j = b.e((Cursor)localObject, "uid");
      int k = b.e((Cursor)localObject, "text");
      int m = b.e((Cursor)localObject, "content");
      int n = b.e((Cursor)localObject, "extra");
      int i1 = b.e((Cursor)localObject, "type");
      int i2 = b.e((Cursor)localObject, "create_time");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new Moment();
        paramLong.id = ((Cursor)localObject).getLong(i);
        paramLong.uid = ((Cursor)localObject).getLong(j);
        if (((Cursor)localObject).isNull(k)) {
          paramLong.text = null;
        } else {
          paramLong.text = ((Cursor)localObject).getString(k);
        }
        if (((Cursor)localObject).isNull(m)) {
          paramLong.content = null;
        } else {
          paramLong.content = ((Cursor)localObject).getString(m);
        }
        if (((Cursor)localObject).isNull(n)) {
          paramLong.extra = null;
        } else {
          paramLong.extra = ((Cursor)localObject).getString(n);
        }
        paramLong.type = ((byte)((Cursor)localObject).getShort(i1));
        if (((Cursor)localObject).isNull(i2)) {
          paramLong.createTime = null;
        } else {
          paramLong.createTime = Long.valueOf(((Cursor)localObject).getLong(i2));
        }
      }
      return paramLong;
    }
    finally
    {
      ((Cursor)localObject).close();
      locall.d0();
    }
  }
  
  public List<Moment> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_moment where text like ? order by create_time desc", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    paramString = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(paramString, "id");
      int j = b.e(paramString, "uid");
      int k = b.e(paramString, "text");
      int m = b.e(paramString, "content");
      int n = b.e(paramString, "extra");
      int i1 = b.e(paramString, "type");
      int i2 = b.e(paramString, "create_time");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Moment localMoment = new Moment();
        localMoment.id = paramString.getLong(i);
        localMoment.uid = paramString.getLong(j);
        if (paramString.isNull(k)) {
          localMoment.text = null;
        } else {
          localMoment.text = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localMoment.content = null;
        } else {
          localMoment.content = paramString.getString(m);
        }
        if (paramString.isNull(n)) {
          localMoment.extra = null;
        } else {
          localMoment.extra = paramString.getString(n);
        }
        localMoment.type = ((byte)paramString.getShort(i1));
        if (paramString.isNull(i2)) {
          localMoment.createTime = null;
        } else {
          localMoment.createTime = Long.valueOf(paramString.getLong(i2));
        }
        localArrayList.add(localMoment);
      }
      return localArrayList;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  public List<Moment> e(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_moment order by create_time desc limit ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(localCursor, "id");
      int j = b.e(localCursor, "uid");
      int k = b.e(localCursor, "text");
      int m = b.e(localCursor, "content");
      int n = b.e(localCursor, "extra");
      int i1 = b.e(localCursor, "type");
      int i2 = b.e(localCursor, "create_time");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Moment localMoment = new Moment();
        localMoment.id = localCursor.getLong(i);
        localMoment.uid = localCursor.getLong(j);
        if (localCursor.isNull(k)) {
          localMoment.text = null;
        } else {
          localMoment.text = localCursor.getString(k);
        }
        if (localCursor.isNull(m)) {
          localMoment.content = null;
        } else {
          localMoment.content = localCursor.getString(m);
        }
        if (localCursor.isNull(n)) {
          localMoment.extra = null;
        } else {
          localMoment.extra = localCursor.getString(n);
        }
        localMoment.type = ((byte)localCursor.getShort(i1));
        if (localCursor.isNull(i2)) {
          localMoment.createTime = null;
        } else {
          localMoment.createTime = Long.valueOf(localCursor.getLong(i2));
        }
        localArrayList.add(localMoment);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void f(Moment paramMoment)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramMoment);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public List<Moment> g(Long paramLong, long paramLong1)
  {
    l locall = l.h("select * from t_hoxin_moment where uid = ? order by create_time desc limit?", 2);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    locall.O(2, paramLong1);
    this.a.d();
    paramLong = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(paramLong, "id");
      int j = b.e(paramLong, "uid");
      int k = b.e(paramLong, "text");
      int m = b.e(paramLong, "content");
      int n = b.e(paramLong, "extra");
      int i1 = b.e(paramLong, "type");
      int i2 = b.e(paramLong, "create_time");
      ArrayList localArrayList = new ArrayList(paramLong.getCount());
      while (paramLong.moveToNext())
      {
        Moment localMoment = new Moment();
        localMoment.id = paramLong.getLong(i);
        localMoment.uid = paramLong.getLong(j);
        if (paramLong.isNull(k)) {
          localMoment.text = null;
        } else {
          localMoment.text = paramLong.getString(k);
        }
        if (paramLong.isNull(m)) {
          localMoment.content = null;
        } else {
          localMoment.content = paramLong.getString(m);
        }
        if (paramLong.isNull(n)) {
          localMoment.extra = null;
        } else {
          localMoment.extra = paramLong.getString(n);
        }
        localMoment.type = ((byte)paramLong.getShort(i1));
        if (paramLong.isNull(i2)) {
          localMoment.createTime = null;
        } else {
          localMoment.createTime = Long.valueOf(paramLong.getLong(i2));
        }
        localArrayList.add(localMoment);
      }
      return localArrayList;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public void h()
  {
    this.a.d();
    k localk = this.f.a();
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
      this.f.f(localk);
    }
  }
  
  public boolean i(long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_moment where id = ? ", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject1 = this.a;
    boolean bool1 = false;
    localObject1 = o1.c.b((f0)localObject1, locall, false, null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        int i = ((Cursor)localObject1).getInt(0);
        if (i != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      ((Cursor)localObject1).close();
      locall.d0();
    }
  }
  
  public boolean isEmpty()
  {
    boolean bool2 = false;
    l locall = l.h("select count(*) = 0 from t_hoxin_moment", 0);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    boolean bool1 = bool2;
    try
    {
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<Moment> j(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_moment where uid = ? and type in(0,2,4) order by create_time desc limit 3", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(paramLong, "id");
      int j = b.e(paramLong, "uid");
      int k = b.e(paramLong, "text");
      int m = b.e(paramLong, "content");
      int n = b.e(paramLong, "extra");
      int i1 = b.e(paramLong, "type");
      int i2 = b.e(paramLong, "create_time");
      ArrayList localArrayList = new ArrayList(paramLong.getCount());
      while (paramLong.moveToNext())
      {
        Moment localMoment = new Moment();
        localMoment.id = paramLong.getLong(i);
        localMoment.uid = paramLong.getLong(j);
        if (paramLong.isNull(k)) {
          localMoment.text = null;
        } else {
          localMoment.text = paramLong.getString(k);
        }
        if (paramLong.isNull(m)) {
          localMoment.content = null;
        } else {
          localMoment.content = paramLong.getString(m);
        }
        if (paramLong.isNull(n)) {
          localMoment.extra = null;
        } else {
          localMoment.extra = paramLong.getString(n);
        }
        localMoment.type = ((byte)paramLong.getShort(i1));
        if (paramLong.isNull(i2)) {
          localMoment.createTime = null;
        } else {
          localMoment.createTime = Long.valueOf(paramLong.getLong(i2));
        }
        localArrayList.add(localMoment);
      }
      return localArrayList;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public List<Moment> k(List<Long> paramList, long paramLong)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_moment where uid not in(");
    int j = paramList.size();
    f.a((StringBuilder)localObject1, j);
    ((StringBuilder)localObject1).append(") order by create_time desc limit ");
    ((StringBuilder)localObject1).append("?");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 1;
    j += 1;
    localObject1 = l.h((String)localObject1, j);
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (Long)paramList.next();
      if (localObject2 == null) {
        ((l)localObject1).y(i);
      } else {
        ((l)localObject1).O(i, ((Long)localObject2).longValue());
      }
      i += 1;
    }
    ((l)localObject1).O(j, paramLong);
    this.a.d();
    paramList = o1.c.b(this.a, (j)localObject1, false, null);
    try
    {
      i = b.e(paramList, "id");
      j = b.e(paramList, "uid");
      int k = b.e(paramList, "text");
      int m = b.e(paramList, "content");
      int n = b.e(paramList, "extra");
      int i1 = b.e(paramList, "type");
      int i2 = b.e(paramList, "create_time");
      localObject2 = new ArrayList(paramList.getCount());
      while (paramList.moveToNext())
      {
        Moment localMoment = new Moment();
        localMoment.id = paramList.getLong(i);
        localMoment.uid = paramList.getLong(j);
        if (paramList.isNull(k)) {
          localMoment.text = null;
        } else {
          localMoment.text = paramList.getString(k);
        }
        if (paramList.isNull(m)) {
          localMoment.content = null;
        } else {
          localMoment.content = paramList.getString(m);
        }
        if (paramList.isNull(n)) {
          localMoment.extra = null;
        } else {
          localMoment.extra = paramList.getString(n);
        }
        localMoment.type = ((byte)paramList.getShort(i1));
        if (paramList.isNull(i2)) {
          localMoment.createTime = null;
        } else {
          localMoment.createTime = Long.valueOf(paramList.getLong(i2));
        }
        ((List)localObject2).add(localMoment);
      }
      return localObject2;
    }
    finally
    {
      paramList.close();
      ((l)localObject1).d0();
    }
  }
  
  public void l(long paramLong)
  {
    this.a.d();
    k localk = this.e.a();
    localk.O(1, paramLong);
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
  
  class a
    extends g<Moment>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_moment` (`id`,`uid`,`text`,`content`,`extra`,`type`,`create_time`) VALUES (?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Moment paramMoment)
    {
      paramk.O(1, paramMoment.id);
      paramk.O(2, paramMoment.uid);
      String str = paramMoment.text;
      if (str == null) {
        paramk.y(3);
      } else {
        paramk.r(3, str);
      }
      str = paramMoment.content;
      if (str == null) {
        paramk.y(4);
      } else {
        paramk.r(4, str);
      }
      str = paramMoment.extra;
      if (str == null) {
        paramk.y(5);
      } else {
        paramk.r(5, str);
      }
      paramk.O(6, paramMoment.type);
      paramMoment = paramMoment.createTime;
      if (paramMoment == null)
      {
        paramk.y(7);
        return;
      }
      paramk.O(7, paramMoment.longValue());
    }
  }
  
  class b
    extends g<Moment>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR IGNORE INTO `t_hoxin_moment` (`id`,`uid`,`text`,`content`,`extra`,`type`,`create_time`) VALUES (?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Moment paramMoment)
    {
      paramk.O(1, paramMoment.id);
      paramk.O(2, paramMoment.uid);
      String str = paramMoment.text;
      if (str == null) {
        paramk.y(3);
      } else {
        paramk.r(3, str);
      }
      str = paramMoment.content;
      if (str == null) {
        paramk.y(4);
      } else {
        paramk.r(4, str);
      }
      str = paramMoment.extra;
      if (str == null) {
        paramk.y(5);
      } else {
        paramk.r(5, str);
      }
      paramk.O(6, paramMoment.type);
      paramMoment = paramMoment.createTime;
      if (paramMoment == null)
      {
        paramk.y(7);
        return;
      }
      paramk.O(7, paramMoment.longValue());
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
      return "delete from t_hoxin_moment where id = ?";
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
      return "delete from t_hoxin_moment where uid = ?";
    }
  }
  
  class e
    extends m
  {
    e(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_moment";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h6.d
 * JD-Core Version:    0.7.0.1
 */