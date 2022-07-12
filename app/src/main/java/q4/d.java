package q4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.group.entity.Group;
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
  private final g<Group> b;
  private final m c;
  private final m d;
  private final m e;
  private final m f;
  private final m g;
  private final m h;
  private final m i;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
    this.f = new e(paramf0);
    this.g = new f(paramf0);
    this.h = new g(paramf0);
    this.i = new h(paramf0);
  }
  
  public static List<Class<?>> p()
  {
    return Collections.emptyList();
  }
  
  public void a(Long paramLong)
  {
    this.a.d();
    k localk = this.h.a();
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
      this.h.f(localk);
    }
  }
  
  public void b(List<Group> paramList)
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
  
  public Group c(Long paramLong)
  {
    boolean bool = true;
    l locall = l.h("select * from t_hoxin_group where id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    Object localObject2 = this.a;
    paramLong = null;
    Object localObject1 = null;
    Cursor localCursor = o1.c.b((f0)localObject2, locall, false, null);
    for (;;)
    {
      try
      {
        int j = b.e(localCursor, "id");
        int k = b.e(localCursor, "uid");
        int m = b.e(localCursor, "name");
        int n = b.e(localCursor, "notice");
        int i1 = b.e(localCursor, "state");
        int i2 = b.e(localCursor, "is_deleted");
        if (localCursor.moveToFirst())
        {
          localObject2 = new Group();
          ((Group)localObject2).id = localCursor.getLong(j);
          ((Group)localObject2).uid = localCursor.getLong(k);
          if (localCursor.isNull(m)) {
            ((Group)localObject2).name = null;
          } else {
            ((Group)localObject2).name = localCursor.getString(m);
          }
          if (localCursor.isNull(n))
          {
            paramLong = localObject1;
            ((Group)localObject2).notice = paramLong;
          }
          else
          {
            paramLong = localCursor.getString(n);
            continue;
          }
          ((Group)localObject2).state = ((byte)localCursor.getShort(i1));
          if (localCursor.getInt(i2) != 0)
          {
            ((Group)localObject2).deleted = bool;
            paramLong = (Long)localObject2;
          }
        }
        else
        {
          return paramLong;
        }
      }
      finally
      {
        localCursor.close();
        locall.d0();
      }
      bool = false;
    }
  }
  
  public List<Group> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_group where name like ? and is_deleted = 0", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    paramString = o1.c.b(this.a, locall, false, null);
    for (;;)
    {
      try
      {
        int j = b.e(paramString, "id");
        int k = b.e(paramString, "uid");
        int m = b.e(paramString, "name");
        int n = b.e(paramString, "notice");
        int i1 = b.e(paramString, "state");
        int i2 = b.e(paramString, "is_deleted");
        ArrayList localArrayList = new ArrayList(paramString.getCount());
        if (paramString.moveToNext())
        {
          Group localGroup = new Group();
          localGroup.id = paramString.getLong(j);
          localGroup.uid = paramString.getLong(k);
          if (paramString.isNull(m)) {
            localGroup.name = null;
          } else {
            localGroup.name = paramString.getString(m);
          }
          if (paramString.isNull(n)) {
            localGroup.notice = null;
          } else {
            localGroup.notice = paramString.getString(n);
          }
          localGroup.state = ((byte)paramString.getShort(i1));
          if (paramString.getInt(i2) != 0)
          {
            bool = true;
            localGroup.deleted = bool;
            localArrayList.add(localGroup);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      finally
      {
        paramString.close();
        locall.d0();
      }
      boolean bool = false;
    }
  }
  
  public List<Group> e()
  {
    l locall = l.h("select * from t_hoxin_group where is_deleted = 0", 0);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, locall, false, null);
    for (;;)
    {
      try
      {
        int j = b.e(localCursor, "id");
        int k = b.e(localCursor, "uid");
        int m = b.e(localCursor, "name");
        int n = b.e(localCursor, "notice");
        int i1 = b.e(localCursor, "state");
        int i2 = b.e(localCursor, "is_deleted");
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        if (localCursor.moveToNext())
        {
          Group localGroup = new Group();
          localGroup.id = localCursor.getLong(j);
          localGroup.uid = localCursor.getLong(k);
          if (localCursor.isNull(m)) {
            localGroup.name = null;
          } else {
            localGroup.name = localCursor.getString(m);
          }
          if (localCursor.isNull(n)) {
            localGroup.notice = null;
          } else {
            localGroup.notice = localCursor.getString(n);
          }
          localGroup.state = ((byte)localCursor.getShort(i1));
          if (localCursor.getInt(i2) != 0)
          {
            bool = true;
            localGroup.deleted = bool;
            localArrayList.add(localGroup);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      finally
      {
        localCursor.close();
        locall.d0();
      }
      boolean bool = false;
    }
  }
  
  public boolean f(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_group where id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = this.a;
    boolean bool1 = false;
    paramLong = o1.c.b(paramLong, locall, false, null);
    try
    {
      if (paramLong.moveToFirst())
      {
        int j = paramLong.getInt(0);
        if (j != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public void g(Long paramLong, String paramString)
  {
    this.a.d();
    k localk = this.c.a();
    if (paramString == null) {
      localk.y(1);
    } else {
      localk.r(1, paramString);
    }
    if (paramLong == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong.longValue());
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
  
  public void h(Group paramGroup)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramGroup);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public boolean i(long paramLong, Long paramLong1)
  {
    l locall = l.h("select count(*) > 0 from t_hoxin_group where id = ? and uid = ? ", 2);
    boolean bool2 = true;
    locall.O(1, paramLong);
    if (paramLong1 == null) {
      locall.y(2);
    } else {
      locall.O(2, paramLong1.longValue());
    }
    this.a.d();
    paramLong1 = this.a;
    boolean bool1 = false;
    paramLong1 = o1.c.b(paramLong1, locall, false, null);
    try
    {
      if (paramLong1.moveToFirst())
      {
        int j = paramLong1.getInt(0);
        if (j != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      paramLong1.close();
      locall.d0();
    }
  }
  
  public void j(Long paramLong)
  {
    this.a.d();
    k localk = this.f.a();
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
      this.f.f(localk);
    }
  }
  
  public void k(Long paramLong1, Long paramLong2)
  {
    this.a.d();
    k localk = this.e.a();
    if (paramLong2 == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong2.longValue());
    }
    if (paramLong1 == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong1.longValue());
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
  
  public boolean l(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_group where id = ? and state = 1", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = this.a;
    boolean bool1 = false;
    paramLong = o1.c.b(paramLong, locall, false, null);
    try
    {
      if (paramLong.moveToFirst())
      {
        int j = paramLong.getInt(0);
        if (j != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public void m(Long paramLong)
  {
    this.a.d();
    k localk = this.g.a();
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
      this.g.f(localk);
    }
  }
  
  public void n(Long paramLong, String paramString)
  {
    this.a.d();
    k localk = this.d.a();
    if (paramString == null) {
      localk.y(1);
    } else {
      localk.r(1, paramString);
    }
    if (paramLong == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong.longValue());
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
  
  public boolean o(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_group where id = ? and is_deleted = 1 ", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = this.a;
    boolean bool1 = false;
    paramLong = o1.c.b(paramLong, locall, false, null);
    try
    {
      if (paramLong.moveToFirst())
      {
        int j = paramLong.getInt(0);
        if (j != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  class a
    extends g<Group>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_group` (`id`,`uid`,`name`,`notice`,`state`,`is_deleted`) VALUES (?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Group paramGroup)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      return "update t_hoxin_group set name = ? where id = ?";
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
      return "update t_hoxin_group set notice = ? where id = ?";
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
      return "update t_hoxin_group set uid = ? where id = ?";
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
      return "update t_hoxin_group set state = 1 where id = ?";
    }
  }
  
  class f
    extends m
  {
    f(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "update t_hoxin_group set state = 0 where id = ?";
    }
  }
  
  class g
    extends m
  {
    g(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "update  t_hoxin_group set is_deleted = 1 where id = ?";
    }
  }
  
  class h
    extends m
  {
    h(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_group where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q4.d
 * JD-Core Version:    0.7.0.1
 */