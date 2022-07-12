package q6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.organization.entity.Organization;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.b;
import o1.c;
import p1.i;
import p1.k;

public final class f
  implements e
{
  private final f0 a;
  private final g<Organization> b;
  private final m c;
  
  public f(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
  }
  
  public static List<Class<?>> e()
  {
    return Collections.emptyList();
  }
  
  public Organization a(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_organization where id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject2 = this.a;
    Organization localOrganization = null;
    localObject2 = c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = b.e((Cursor)localObject2, "id");
      int j = b.e((Cursor)localObject2, "name");
      if (((Cursor)localObject2).moveToFirst())
      {
        localOrganization = new Organization();
        if (((Cursor)localObject2).isNull(i)) {
          localOrganization.id = null;
        } else {
          localOrganization.id = Long.valueOf(((Cursor)localObject2).getLong(i));
        }
        if (((Cursor)localObject2).isNull(j)) {
          localOrganization.name = null;
        } else {
          localOrganization.name = ((Cursor)localObject2).getString(j);
        }
      }
      return localOrganization;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public Organization b()
  {
    l locall = l.h("select * from t_hoxin_organization limit 1", 0);
    this.a.d();
    Object localObject2 = this.a;
    Organization localOrganization = null;
    localObject2 = c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = b.e((Cursor)localObject2, "id");
      int j = b.e((Cursor)localObject2, "name");
      if (((Cursor)localObject2).moveToFirst())
      {
        localOrganization = new Organization();
        if (((Cursor)localObject2).isNull(i)) {
          localOrganization.id = null;
        } else {
          localOrganization.id = Long.valueOf(((Cursor)localObject2).getLong(i));
        }
        if (((Cursor)localObject2).isNull(j)) {
          localOrganization.name = null;
        } else {
          localOrganization.name = ((Cursor)localObject2).getString(j);
        }
      }
      return localOrganization;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public void c()
  {
    this.a.d();
    k localk = this.c.a();
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
  
  public void d(Organization paramOrganization)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramOrganization);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  class a
    extends g<Organization>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_organization` (`id`,`name`) VALUES (?,?)";
    }
    
    public void k(k paramk, Organization paramOrganization)
    {
      Long localLong = paramOrganization.id;
      if (localLong == null) {
        paramk.y(1);
      } else {
        paramk.O(1, localLong.longValue());
      }
      paramOrganization = paramOrganization.name;
      if (paramOrganization == null)
      {
        paramk.y(2);
        return;
      }
      paramk.r(2, paramOrganization);
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
      return "delete from t_hoxin_organization";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q6.f
 * JD-Core Version:    0.7.0.1
 */