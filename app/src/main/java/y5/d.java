package y5;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.micro.entity.MicroServer;
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
  private final g<MicroServer> b;
  private final m c;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
  }
  
  public static List<Class<?>> g()
  {
    return Collections.emptyList();
  }
  
  public void a(Long paramLong)
  {
    this.a.d();
    k localk = this.c.a();
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
      this.c.f(localk);
    }
  }
  
  public void b(List<MicroServer> paramList)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.h(paramList);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public MicroServer c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_micro_server where id = ? ", 1);
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
      int j = b.e((Cursor)localObject, "account");
      int k = b.e((Cursor)localObject, "description");
      int m = b.e((Cursor)localObject, "name");
      int n = b.e((Cursor)localObject, "website");
      int i1 = b.e((Cursor)localObject, "greet");
      int i2 = b.e((Cursor)localObject, "url");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new MicroServer();
        paramLong.id = ((Cursor)localObject).getLong(i);
        if (((Cursor)localObject).isNull(j)) {
          paramLong.account = null;
        } else {
          paramLong.account = ((Cursor)localObject).getString(j);
        }
        if (((Cursor)localObject).isNull(k)) {
          paramLong.description = null;
        } else {
          paramLong.description = ((Cursor)localObject).getString(k);
        }
        if (((Cursor)localObject).isNull(m)) {
          paramLong.name = null;
        } else {
          paramLong.name = ((Cursor)localObject).getString(m);
        }
        if (((Cursor)localObject).isNull(n)) {
          paramLong.website = null;
        } else {
          paramLong.website = ((Cursor)localObject).getString(n);
        }
        if (((Cursor)localObject).isNull(i1)) {
          paramLong.greet = null;
        } else {
          paramLong.greet = ((Cursor)localObject).getString(i1);
        }
        if (((Cursor)localObject).isNull(i2)) {
          paramLong.url = null;
        } else {
          paramLong.url = ((Cursor)localObject).getString(i2);
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
  
  public List<MicroServer> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_micro_server where account like ? or name like ?", 2);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    if (paramString == null) {
      locall.y(2);
    } else {
      locall.r(2, paramString);
    }
    this.a.d();
    paramString = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(paramString, "id");
      int j = b.e(paramString, "account");
      int k = b.e(paramString, "description");
      int m = b.e(paramString, "name");
      int n = b.e(paramString, "website");
      int i1 = b.e(paramString, "greet");
      int i2 = b.e(paramString, "url");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        MicroServer localMicroServer = new MicroServer();
        localMicroServer.id = paramString.getLong(i);
        if (paramString.isNull(j)) {
          localMicroServer.account = null;
        } else {
          localMicroServer.account = paramString.getString(j);
        }
        if (paramString.isNull(k)) {
          localMicroServer.description = null;
        } else {
          localMicroServer.description = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localMicroServer.name = null;
        } else {
          localMicroServer.name = paramString.getString(m);
        }
        if (paramString.isNull(n)) {
          localMicroServer.website = null;
        } else {
          localMicroServer.website = paramString.getString(n);
        }
        if (paramString.isNull(i1)) {
          localMicroServer.greet = null;
        } else {
          localMicroServer.greet = paramString.getString(i1);
        }
        if (paramString.isNull(i2)) {
          localMicroServer.url = null;
        } else {
          localMicroServer.url = paramString.getString(i2);
        }
        localArrayList.add(localMicroServer);
      }
      return localArrayList;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  public List<MicroServer> e()
  {
    l locall = l.h("select * from t_hoxin_micro_server", 0);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(localCursor, "id");
      int j = b.e(localCursor, "account");
      int k = b.e(localCursor, "description");
      int m = b.e(localCursor, "name");
      int n = b.e(localCursor, "website");
      int i1 = b.e(localCursor, "greet");
      int i2 = b.e(localCursor, "url");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        MicroServer localMicroServer = new MicroServer();
        localMicroServer.id = localCursor.getLong(i);
        if (localCursor.isNull(j)) {
          localMicroServer.account = null;
        } else {
          localMicroServer.account = localCursor.getString(j);
        }
        if (localCursor.isNull(k)) {
          localMicroServer.description = null;
        } else {
          localMicroServer.description = localCursor.getString(k);
        }
        if (localCursor.isNull(m)) {
          localMicroServer.name = null;
        } else {
          localMicroServer.name = localCursor.getString(m);
        }
        if (localCursor.isNull(n)) {
          localMicroServer.website = null;
        } else {
          localMicroServer.website = localCursor.getString(n);
        }
        if (localCursor.isNull(i1)) {
          localMicroServer.greet = null;
        } else {
          localMicroServer.greet = localCursor.getString(i1);
        }
        if (localCursor.isNull(i2)) {
          localMicroServer.url = null;
        } else {
          localMicroServer.url = localCursor.getString(i2);
        }
        localArrayList.add(localMicroServer);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void f(MicroServer paramMicroServer)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramMicroServer);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  class a
    extends g<MicroServer>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_micro_server` (`id`,`account`,`description`,`name`,`website`,`greet`,`url`) VALUES (?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, MicroServer paramMicroServer)
    {
      paramk.O(1, paramMicroServer.id);
      String str = paramMicroServer.account;
      if (str == null) {
        paramk.y(2);
      } else {
        paramk.r(2, str);
      }
      str = paramMicroServer.description;
      if (str == null) {
        paramk.y(3);
      } else {
        paramk.r(3, str);
      }
      str = paramMicroServer.name;
      if (str == null) {
        paramk.y(4);
      } else {
        paramk.r(4, str);
      }
      str = paramMicroServer.website;
      if (str == null) {
        paramk.y(5);
      } else {
        paramk.r(5, str);
      }
      str = paramMicroServer.greet;
      if (str == null) {
        paramk.y(6);
      } else {
        paramk.r(6, str);
      }
      paramMicroServer = paramMicroServer.url;
      if (paramMicroServer == null)
      {
        paramk.y(7);
        return;
      }
      paramk.r(7, paramMicroServer);
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
      return "delete from t_hoxin_micro_server where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y5.d
 * JD-Core Version:    0.7.0.1
 */