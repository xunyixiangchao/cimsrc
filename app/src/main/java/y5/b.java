package y5;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.micro.entity.MicroServerMenu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.c;
import p1.i;
import p1.k;

public final class b
  implements a
{
  private final f0 a;
  private final g<MicroServerMenu> b;
  private final m c;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
  }
  
  public static List<Class<?>> c()
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
  
  public void b(List<MicroServerMenu> paramList)
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
  
  public List<MicroServerMenu> e(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_micro_server_menu where server_id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(paramLong, "id");
      int j = o1.b.e(paramLong, "parent_id");
      int k = o1.b.e(paramLong, "server_id");
      int m = o1.b.e(paramLong, "name");
      int n = o1.b.e(paramLong, "code");
      int i1 = o1.b.e(paramLong, "type");
      int i2 = o1.b.e(paramLong, "content");
      int i3 = o1.b.e(paramLong, "sort");
      ArrayList localArrayList = new ArrayList(paramLong.getCount());
      while (paramLong.moveToNext())
      {
        MicroServerMenu localMicroServerMenu = new MicroServerMenu();
        localMicroServerMenu.id = paramLong.getLong(i);
        if (paramLong.isNull(j)) {
          localMicroServerMenu.parentId = null;
        } else {
          localMicroServerMenu.parentId = Long.valueOf(paramLong.getLong(j));
        }
        localMicroServerMenu.serverId = paramLong.getLong(k);
        if (paramLong.isNull(m)) {
          localMicroServerMenu.name = null;
        } else {
          localMicroServerMenu.name = paramLong.getString(m);
        }
        if (paramLong.isNull(n)) {
          localMicroServerMenu.code = null;
        } else {
          localMicroServerMenu.code = paramLong.getString(n);
        }
        if (paramLong.isNull(i1)) {
          localMicroServerMenu.type = null;
        } else {
          localMicroServerMenu.type = Byte.valueOf((byte)paramLong.getShort(i1));
        }
        if (paramLong.isNull(i2)) {
          localMicroServerMenu.content = null;
        } else {
          localMicroServerMenu.content = paramLong.getString(i2);
        }
        localMicroServerMenu.sort = paramLong.getInt(i3);
        localArrayList.add(localMicroServerMenu);
      }
      return localArrayList;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  class a
    extends g<MicroServerMenu>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_micro_server_menu` (`id`,`parent_id`,`server_id`,`name`,`code`,`type`,`content`,`sort`) VALUES (?,?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, MicroServerMenu paramMicroServerMenu)
    {
      paramk.O(1, paramMicroServerMenu.id);
      Object localObject = paramMicroServerMenu.parentId;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.O(2, ((Long)localObject).longValue());
      }
      paramk.O(3, paramMicroServerMenu.serverId);
      localObject = paramMicroServerMenu.name;
      if (localObject == null) {
        paramk.y(4);
      } else {
        paramk.r(4, (String)localObject);
      }
      localObject = paramMicroServerMenu.code;
      if (localObject == null) {
        paramk.y(5);
      } else {
        paramk.r(5, (String)localObject);
      }
      localObject = paramMicroServerMenu.type;
      if (localObject == null) {
        paramk.y(6);
      } else {
        paramk.O(6, ((Byte)localObject).byteValue());
      }
      localObject = paramMicroServerMenu.content;
      if (localObject == null) {
        paramk.y(7);
      } else {
        paramk.r(7, (String)localObject);
      }
      paramk.O(8, paramMicroServerMenu.sort);
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
      return "delete from t_hoxin_micro_server_menu where server_id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y5.b
 * JD-Core Version:    0.7.0.1
 */