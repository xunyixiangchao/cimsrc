package q6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.organization.entity.DepartmentMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.f;
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
  private final g<DepartmentMember> b;
  private final f<DepartmentMember> c;
  private final m d;
  private final m e;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
  }
  
  public static List<Class<?>> h()
  {
    return Collections.emptyList();
  }
  
  public void a(DepartmentMember paramDepartmentMember)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramDepartmentMember);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public void b(List<DepartmentMember> paramList)
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
  
  public DepartmentMember c(long paramLong1, long paramLong2)
  {
    l locall = l.h("select * from t_hoxin_department_member where organization_id = ? and uid = ? limit 1", 2);
    locall.O(1, paramLong1);
    locall.O(2, paramLong2);
    this.a.d();
    Object localObject2 = this.a;
    DepartmentMember localDepartmentMember = null;
    localObject2 = c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = o1.b.e((Cursor)localObject2, "id");
      int j = o1.b.e((Cursor)localObject2, "department_id");
      int k = o1.b.e((Cursor)localObject2, "organization_id");
      int m = o1.b.e((Cursor)localObject2, "uid");
      int n = o1.b.e((Cursor)localObject2, "title");
      if (((Cursor)localObject2).moveToFirst())
      {
        localDepartmentMember = new DepartmentMember();
        if (((Cursor)localObject2).isNull(i)) {
          localDepartmentMember.id = null;
        } else {
          localDepartmentMember.id = Long.valueOf(((Cursor)localObject2).getLong(i));
        }
        if (((Cursor)localObject2).isNull(j)) {
          localDepartmentMember.departmentId = null;
        } else {
          localDepartmentMember.departmentId = Long.valueOf(((Cursor)localObject2).getLong(j));
        }
        if (((Cursor)localObject2).isNull(k)) {
          localDepartmentMember.organizationId = null;
        } else {
          localDepartmentMember.organizationId = Long.valueOf(((Cursor)localObject2).getLong(k));
        }
        if (((Cursor)localObject2).isNull(m)) {
          localDepartmentMember.uid = null;
        } else {
          localDepartmentMember.uid = Long.valueOf(((Cursor)localObject2).getLong(m));
        }
        if (((Cursor)localObject2).isNull(n)) {
          localDepartmentMember.title = null;
        } else {
          localDepartmentMember.title = ((Cursor)localObject2).getString(n);
        }
      }
      return localDepartmentMember;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public List<Long> d(long paramLong1, long paramLong2)
  {
    l locall = l.h("select uid from t_hoxin_department_member where organization_id = ? and department_id = ?", 2);
    locall.O(1, paramLong1);
    locall.O(2, paramLong2);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Long localLong;
        if (localCursor.isNull(0)) {
          localLong = null;
        } else {
          localLong = Long.valueOf(localCursor.getLong(0));
        }
        localArrayList.add(localLong);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<DepartmentMember> e(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_department_member where organization_id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(localCursor, "id");
      int j = o1.b.e(localCursor, "department_id");
      int k = o1.b.e(localCursor, "organization_id");
      int m = o1.b.e(localCursor, "uid");
      int n = o1.b.e(localCursor, "title");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        DepartmentMember localDepartmentMember = new DepartmentMember();
        if (localCursor.isNull(i)) {
          localDepartmentMember.id = null;
        } else {
          localDepartmentMember.id = Long.valueOf(localCursor.getLong(i));
        }
        if (localCursor.isNull(j)) {
          localDepartmentMember.departmentId = null;
        } else {
          localDepartmentMember.departmentId = Long.valueOf(localCursor.getLong(j));
        }
        if (localCursor.isNull(k)) {
          localDepartmentMember.organizationId = null;
        } else {
          localDepartmentMember.organizationId = Long.valueOf(localCursor.getLong(k));
        }
        if (localCursor.isNull(m)) {
          localDepartmentMember.uid = null;
        } else {
          localDepartmentMember.uid = Long.valueOf(localCursor.getLong(m));
        }
        if (localCursor.isNull(n)) {
          localDepartmentMember.title = null;
        } else {
          localDepartmentMember.title = localCursor.getString(n);
        }
        localArrayList.add(localDepartmentMember);
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
  
  public List<Long> g(long paramLong)
  {
    l locall = l.h("select uid from t_hoxin_department_member where organization_id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Long localLong;
        if (localCursor.isNull(0)) {
          localLong = null;
        } else {
          localLong = Long.valueOf(localCursor.getLong(0));
        }
        localArrayList.add(localLong);
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
    extends g<DepartmentMember>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_department_member` (`id`,`department_id`,`organization_id`,`uid`,`title`) VALUES (?,?,?,?,?)";
    }
    
    public void k(k paramk, DepartmentMember paramDepartmentMember)
    {
      Long localLong = paramDepartmentMember.id;
      if (localLong == null) {
        paramk.y(1);
      } else {
        paramk.O(1, localLong.longValue());
      }
      localLong = paramDepartmentMember.departmentId;
      if (localLong == null) {
        paramk.y(2);
      } else {
        paramk.O(2, localLong.longValue());
      }
      localLong = paramDepartmentMember.organizationId;
      if (localLong == null) {
        paramk.y(3);
      } else {
        paramk.O(3, localLong.longValue());
      }
      localLong = paramDepartmentMember.uid;
      if (localLong == null) {
        paramk.y(4);
      } else {
        paramk.O(4, localLong.longValue());
      }
      paramDepartmentMember = paramDepartmentMember.title;
      if (paramDepartmentMember == null)
      {
        paramk.y(5);
        return;
      }
      paramk.r(5, paramDepartmentMember);
    }
  }
  
  class b
    extends f<DepartmentMember>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "UPDATE OR ABORT `t_hoxin_department_member` SET `id` = ?,`department_id` = ?,`organization_id` = ?,`uid` = ?,`title` = ? WHERE `id` = ?";
    }
    
    public void i(k paramk, DepartmentMember paramDepartmentMember)
    {
      Object localObject = paramDepartmentMember.id;
      if (localObject == null) {
        paramk.y(1);
      } else {
        paramk.O(1, ((Long)localObject).longValue());
      }
      localObject = paramDepartmentMember.departmentId;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.O(2, ((Long)localObject).longValue());
      }
      localObject = paramDepartmentMember.organizationId;
      if (localObject == null) {
        paramk.y(3);
      } else {
        paramk.O(3, ((Long)localObject).longValue());
      }
      localObject = paramDepartmentMember.uid;
      if (localObject == null) {
        paramk.y(4);
      } else {
        paramk.O(4, ((Long)localObject).longValue());
      }
      localObject = paramDepartmentMember.title;
      if (localObject == null) {
        paramk.y(5);
      } else {
        paramk.r(5, (String)localObject);
      }
      paramDepartmentMember = paramDepartmentMember.id;
      if (paramDepartmentMember == null)
      {
        paramk.y(6);
        return;
      }
      paramk.O(6, paramDepartmentMember.longValue());
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
      return "delete from t_hoxin_department_member where organization_id = ? and uid=?";
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
      return "delete from t_hoxin_department_member where organization_id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q6.b
 * JD-Core Version:    0.7.0.1
 */