package q6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.organization.entity.Department;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.f;
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
  private final g<Department> b;
  private final f<Department> c;
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
  
  public static List<Class<?>> j()
  {
    return Collections.emptyList();
  }
  
  public List<Department> a(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_department where organization_id = ? and parent_id is null", 1);
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
      int j = b.e(paramLong, "parent_id");
      int k = b.e(paramLong, "organization_id");
      int m = b.e(paramLong, "name");
      ArrayList localArrayList = new ArrayList(paramLong.getCount());
      while (paramLong.moveToNext())
      {
        Department localDepartment = new Department();
        if (paramLong.isNull(i)) {
          localDepartment.id = null;
        } else {
          localDepartment.id = Long.valueOf(paramLong.getLong(i));
        }
        if (paramLong.isNull(j)) {
          localDepartment.parentId = null;
        } else {
          localDepartment.parentId = Long.valueOf(paramLong.getLong(j));
        }
        if (paramLong.isNull(k)) {
          localDepartment.organizationId = null;
        } else {
          localDepartment.organizationId = Long.valueOf(paramLong.getLong(k));
        }
        if (paramLong.isNull(m)) {
          localDepartment.name = null;
        } else {
          localDepartment.name = paramLong.getString(m);
        }
        localArrayList.add(localDepartment);
      }
      return localArrayList;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public void b(List<Department> paramList)
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
  
  public Department c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_department where id = ?", 1);
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
      int j = b.e((Cursor)localObject, "parent_id");
      int k = b.e((Cursor)localObject, "organization_id");
      int m = b.e((Cursor)localObject, "name");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new Department();
        if (((Cursor)localObject).isNull(i)) {
          paramLong.id = null;
        } else {
          paramLong.id = Long.valueOf(((Cursor)localObject).getLong(i));
        }
        if (((Cursor)localObject).isNull(j)) {
          paramLong.parentId = null;
        } else {
          paramLong.parentId = Long.valueOf(((Cursor)localObject).getLong(j));
        }
        if (((Cursor)localObject).isNull(k)) {
          paramLong.organizationId = null;
        } else {
          paramLong.organizationId = Long.valueOf(((Cursor)localObject).getLong(k));
        }
        if (((Cursor)localObject).isNull(m)) {
          paramLong.name = null;
        } else {
          paramLong.name = ((Cursor)localObject).getString(m);
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
  
  public List<Department> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_department where name like ?", 1);
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
      int j = b.e(paramString, "parent_id");
      int k = b.e(paramString, "organization_id");
      int m = b.e(paramString, "name");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Department localDepartment = new Department();
        if (paramString.isNull(i)) {
          localDepartment.id = null;
        } else {
          localDepartment.id = Long.valueOf(paramString.getLong(i));
        }
        if (paramString.isNull(j)) {
          localDepartment.parentId = null;
        } else {
          localDepartment.parentId = Long.valueOf(paramString.getLong(j));
        }
        if (paramString.isNull(k)) {
          localDepartment.organizationId = null;
        } else {
          localDepartment.organizationId = Long.valueOf(paramString.getLong(k));
        }
        if (paramString.isNull(m)) {
          localDepartment.name = null;
        } else {
          localDepartment.name = paramString.getString(m);
        }
        localArrayList.add(localDepartment);
      }
      return localArrayList;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  public List<Department> e(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_department where organization_id = ?", 1);
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
      int j = b.e(paramLong, "parent_id");
      int k = b.e(paramLong, "organization_id");
      int m = b.e(paramLong, "name");
      ArrayList localArrayList = new ArrayList(paramLong.getCount());
      while (paramLong.moveToNext())
      {
        Department localDepartment = new Department();
        if (paramLong.isNull(i)) {
          localDepartment.id = null;
        } else {
          localDepartment.id = Long.valueOf(paramLong.getLong(i));
        }
        if (paramLong.isNull(j)) {
          localDepartment.parentId = null;
        } else {
          localDepartment.parentId = Long.valueOf(paramLong.getLong(j));
        }
        if (paramLong.isNull(k)) {
          localDepartment.organizationId = null;
        } else {
          localDepartment.organizationId = Long.valueOf(paramLong.getLong(k));
        }
        if (paramLong.isNull(m)) {
          localDepartment.name = null;
        } else {
          localDepartment.name = paramLong.getString(m);
        }
        localArrayList.add(localDepartment);
      }
      return localArrayList;
    }
    finally
    {
      paramLong.close();
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
  
  public void g(Long paramLong)
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
  
  public void h(Department paramDepartment)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramDepartment);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public List<Department> i(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_department where parent_id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    try
    {
      int i = b.e(localCursor, "id");
      int j = b.e(localCursor, "parent_id");
      int k = b.e(localCursor, "organization_id");
      int m = b.e(localCursor, "name");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Department localDepartment = new Department();
        if (localCursor.isNull(i)) {
          localDepartment.id = null;
        } else {
          localDepartment.id = Long.valueOf(localCursor.getLong(i));
        }
        if (localCursor.isNull(j)) {
          localDepartment.parentId = null;
        } else {
          localDepartment.parentId = Long.valueOf(localCursor.getLong(j));
        }
        if (localCursor.isNull(k)) {
          localDepartment.organizationId = null;
        } else {
          localDepartment.organizationId = Long.valueOf(localCursor.getLong(k));
        }
        if (localCursor.isNull(m)) {
          localDepartment.name = null;
        } else {
          localDepartment.name = localCursor.getString(m);
        }
        localArrayList.add(localDepartment);
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
    extends g<Department>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_department` (`id`,`parent_id`,`organization_id`,`name`) VALUES (?,?,?,?)";
    }
    
    public void k(k paramk, Department paramDepartment)
    {
      Long localLong = paramDepartment.id;
      if (localLong == null) {
        paramk.y(1);
      } else {
        paramk.O(1, localLong.longValue());
      }
      localLong = paramDepartment.parentId;
      if (localLong == null) {
        paramk.y(2);
      } else {
        paramk.O(2, localLong.longValue());
      }
      localLong = paramDepartment.organizationId;
      if (localLong == null) {
        paramk.y(3);
      } else {
        paramk.O(3, localLong.longValue());
      }
      paramDepartment = paramDepartment.name;
      if (paramDepartment == null)
      {
        paramk.y(4);
        return;
      }
      paramk.r(4, paramDepartment);
    }
  }
  
  class b
    extends f<Department>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "UPDATE OR ABORT `t_hoxin_department` SET `id` = ?,`parent_id` = ?,`organization_id` = ?,`name` = ? WHERE `id` = ?";
    }
    
    public void i(k paramk, Department paramDepartment)
    {
      Object localObject = paramDepartment.id;
      if (localObject == null) {
        paramk.y(1);
      } else {
        paramk.O(1, ((Long)localObject).longValue());
      }
      localObject = paramDepartment.parentId;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.O(2, ((Long)localObject).longValue());
      }
      localObject = paramDepartment.organizationId;
      if (localObject == null) {
        paramk.y(3);
      } else {
        paramk.O(3, ((Long)localObject).longValue());
      }
      localObject = paramDepartment.name;
      if (localObject == null) {
        paramk.y(4);
      } else {
        paramk.r(4, (String)localObject);
      }
      paramDepartment = paramDepartment.id;
      if (paramDepartment == null)
      {
        paramk.y(5);
        return;
      }
      paramk.O(5, paramDepartment.longValue());
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
      return "delete from t_hoxin_department where id = ?";
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
      return "delete from t_hoxin_department where organization_id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q6.d
 * JD-Core Version:    0.7.0.1
 */