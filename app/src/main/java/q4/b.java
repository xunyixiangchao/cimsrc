package q4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.group.entity.GroupMember;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.c;
import p1.i;
import p1.j;
import p1.k;

public final class b
  implements a
{
  private final f0 a;
  private final g<GroupMember> b;
  private final m1.f<GroupMember> c;
  private final m d;
  private final m e;
  private final m f;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
    this.f = new e(paramf0);
  }
  
  public static List<Class<?>> p()
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
  
  public void b(Long paramLong1, Long paramLong2)
  {
    this.a.d();
    k localk = this.e.a();
    if (paramLong1 == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong1.longValue());
    }
    if (paramLong2 == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong2.longValue());
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
  
  public long c(Long paramLong)
  {
    l locall = l.h("select count(*) from t_hoxin_group_member where group_id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = c.b(this.a, locall, false, null);
    try
    {
      long l;
      if (paramLong.moveToFirst()) {
        l = paramLong.getLong(0);
      } else {
        l = 0L;
      }
      return l;
    }
    finally
    {
      paramLong.close();
      locall.d0();
    }
  }
  
  public List<Long> d(Long paramLong, int paramInt)
  {
    l locall = l.h("select distinct uid from t_hoxin_group_member where group_id = ? and is_deleted = 0 order by type desc limit ?", 2);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    locall.O(2, paramInt);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        if (localCursor.isNull(0)) {
          paramLong = null;
        } else {
          paramLong = Long.valueOf(localCursor.getLong(0));
        }
        localArrayList.add(paramLong);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<GroupMember> e(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_group_member where group_id = ? and is_deleted = 0  order by type desc", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = c.b(this.a, locall, false, null);
    for (;;)
    {
      try
      {
        int i = o1.b.e(paramLong, "id");
        int j = o1.b.e(paramLong, "group_id");
        int k = o1.b.e(paramLong, "uid");
        int m = o1.b.e(paramLong, "type");
        int n = o1.b.e(paramLong, "is_deleted");
        int i1 = o1.b.e(paramLong, "name");
        ArrayList localArrayList = new ArrayList(paramLong.getCount());
        if (paramLong.moveToNext())
        {
          GroupMember localGroupMember = new GroupMember();
          localGroupMember.id = paramLong.getLong(i);
          localGroupMember.groupId = paramLong.getLong(j);
          localGroupMember.uid = paramLong.getLong(k);
          localGroupMember.type = ((byte)paramLong.getShort(m));
          if (paramLong.getInt(n) != 0)
          {
            bool = true;
            localGroupMember.deleted = bool;
            if (paramLong.isNull(i1)) {
              localGroupMember.name = null;
            } else {
              localGroupMember.name = paramLong.getString(i1);
            }
            localArrayList.add(localGroupMember);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      finally
      {
        paramLong.close();
        locall.d0();
      }
      boolean bool = false;
    }
  }
  
  public String f(Long paramLong1, Long paramLong2)
  {
    l locall = l.h("select name from t_hoxin_group_member where  group_id = ? and uid = ? limit 1", 2);
    if (paramLong1 == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong1.longValue());
    }
    if (paramLong2 == null) {
      locall.y(2);
    } else {
      locall.O(2, paramLong2.longValue());
    }
    this.a.d();
    paramLong1 = this.a;
    paramLong2 = null;
    Cursor localCursor = c.b(paramLong1, locall, false, null);
    paramLong1 = paramLong2;
    try
    {
      if (localCursor.moveToFirst()) {
        if (localCursor.isNull(0)) {
          paramLong1 = paramLong2;
        } else {
          paramLong1 = localCursor.getString(0);
        }
      }
      return paramLong1;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<GroupMember> g(Long paramLong, long paramLong1)
  {
    l locall = l.h("select * from t_hoxin_group_member where group_id = ? and is_deleted = 0  order by type desc limit ?", 2);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    locall.O(2, paramLong1);
    this.a.d();
    paramLong = c.b(this.a, locall, false, null);
    for (;;)
    {
      try
      {
        int i = o1.b.e(paramLong, "id");
        int j = o1.b.e(paramLong, "group_id");
        int k = o1.b.e(paramLong, "uid");
        int m = o1.b.e(paramLong, "type");
        int n = o1.b.e(paramLong, "is_deleted");
        int i1 = o1.b.e(paramLong, "name");
        ArrayList localArrayList = new ArrayList(paramLong.getCount());
        if (paramLong.moveToNext())
        {
          GroupMember localGroupMember = new GroupMember();
          localGroupMember.id = paramLong.getLong(i);
          localGroupMember.groupId = paramLong.getLong(j);
          localGroupMember.uid = paramLong.getLong(k);
          localGroupMember.type = ((byte)paramLong.getShort(m));
          if (paramLong.getInt(n) != 0)
          {
            bool = true;
            localGroupMember.deleted = bool;
            if (paramLong.isNull(i1)) {
              localGroupMember.name = null;
            } else {
              localGroupMember.name = paramLong.getString(i1);
            }
            localArrayList.add(localGroupMember);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      finally
      {
        paramLong.close();
        locall.d0();
      }
      boolean bool = false;
    }
  }
  
  public void h(Long paramLong1, Long paramLong2, byte paramByte)
  {
    this.a.d();
    k localk = this.f.a();
    localk.O(1, paramByte);
    if (paramLong1 == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong1.longValue());
    }
    if (paramLong2 == null) {
      localk.y(3);
    } else {
      localk.O(3, paramLong2.longValue());
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
  
  public void i(GroupMember paramGroupMember)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramGroupMember);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public boolean j(Long paramLong1, Long paramLong2)
  {
    l locall = l.h("select count(*) > 0 from t_hoxin_group_member where group_id = ? and uid = ?", 2);
    boolean bool2 = true;
    if (paramLong1 == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong1.longValue());
    }
    if (paramLong2 == null) {
      locall.y(2);
    } else {
      locall.O(2, paramLong2.longValue());
    }
    this.a.d();
    paramLong1 = this.a;
    boolean bool1 = false;
    paramLong1 = c.b(paramLong1, locall, false, null);
    try
    {
      if (paramLong1.moveToFirst())
      {
        int i = paramLong1.getInt(0);
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
      paramLong1.close();
      locall.d0();
    }
  }
  
  public GroupMember k(Long paramLong1, Long paramLong2)
  {
    l locall = l.h("select * from t_hoxin_group_member where group_id = ? and uid = ?", 2);
    boolean bool = true;
    if (paramLong1 == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong1.longValue());
    }
    if (paramLong2 == null) {
      locall.y(2);
    } else {
      locall.O(2, paramLong2.longValue());
    }
    this.a.d();
    paramLong2 = this.a;
    paramLong1 = null;
    paramLong2 = c.b(paramLong2, locall, false, null);
    for (;;)
    {
      try
      {
        int i = o1.b.e(paramLong2, "id");
        int j = o1.b.e(paramLong2, "group_id");
        int k = o1.b.e(paramLong2, "uid");
        int m = o1.b.e(paramLong2, "type");
        int n = o1.b.e(paramLong2, "is_deleted");
        int i1 = o1.b.e(paramLong2, "name");
        if (paramLong2.moveToFirst())
        {
          paramLong1 = new GroupMember();
          paramLong1.id = paramLong2.getLong(i);
          paramLong1.groupId = paramLong2.getLong(j);
          paramLong1.uid = paramLong2.getLong(k);
          paramLong1.type = ((byte)paramLong2.getShort(m));
          if (paramLong2.getInt(n) == 0) {
            break label270;
          }
          paramLong1.deleted = bool;
          if (paramLong2.isNull(i1)) {
            paramLong1.name = null;
          } else {
            paramLong1.name = paramLong2.getString(i1);
          }
        }
        return paramLong1;
      }
      finally
      {
        paramLong2.close();
        locall.d0();
      }
      label270:
      bool = false;
    }
  }
  
  public List<GroupMember> l(Long paramLong, List<Long> paramList, String paramString)
  {
    Object localObject = o1.f.b();
    ((StringBuilder)localObject).append("select * from t_hoxin_group_member where group_id = ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and uid not in(");
    int j = paramList.size();
    o1.f.a((StringBuilder)localObject, j);
    ((StringBuilder)localObject).append(") and name like ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and is_deleted = 0  order by type desc");
    localObject = ((StringBuilder)localObject).toString();
    int i = 2;
    j += 2;
    localObject = l.h((String)localObject, j);
    if (paramLong == null) {
      ((l)localObject).y(1);
    } else {
      ((l)localObject).O(1, paramLong.longValue());
    }
    paramLong = paramList.iterator();
    while (paramLong.hasNext())
    {
      paramList = (Long)paramLong.next();
      if (paramList == null) {
        ((l)localObject).y(i);
      } else {
        ((l)localObject).O(i, paramList.longValue());
      }
      i += 1;
    }
    if (paramString == null) {
      ((l)localObject).y(j);
    } else {
      ((l)localObject).r(j, paramString);
    }
    this.a.d();
    paramLong = c.b(this.a, (j)localObject, false, null);
    for (;;)
    {
      try
      {
        i = o1.b.e(paramLong, "id");
        j = o1.b.e(paramLong, "group_id");
        int k = o1.b.e(paramLong, "uid");
        int m = o1.b.e(paramLong, "type");
        int n = o1.b.e(paramLong, "is_deleted");
        int i1 = o1.b.e(paramLong, "name");
        paramList = new ArrayList(paramLong.getCount());
        if (paramLong.moveToNext())
        {
          paramString = new GroupMember();
          paramString.id = paramLong.getLong(i);
          paramString.groupId = paramLong.getLong(j);
          paramString.uid = paramLong.getLong(k);
          paramString.type = ((byte)paramLong.getShort(m));
          if (paramLong.getInt(n) != 0)
          {
            bool = true;
            paramString.deleted = bool;
            if (paramLong.isNull(i1)) {
              paramString.name = null;
            } else {
              paramString.name = paramLong.getString(i1);
            }
            paramList.add(paramString);
          }
        }
        else
        {
          return paramList;
        }
      }
      finally
      {
        paramLong.close();
        ((l)localObject).d0();
      }
      boolean bool = false;
    }
  }
  
  public List<Long> m(Long paramLong)
  {
    l locall = l.h("select distinct uid from t_hoxin_group_member where group_id = ? and is_deleted = 0 order by type desc", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        if (localCursor.isNull(0)) {
          paramLong = null;
        } else {
          paramLong = Long.valueOf(localCursor.getLong(0));
        }
        localArrayList.add(paramLong);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<GroupMember> n(Long paramLong, String paramString)
  {
    l locall = l.h("select * from t_hoxin_group_member where group_id = ? and name like ? and is_deleted = 0  order by type desc", 2);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    if (paramString == null) {
      locall.y(2);
    } else {
      locall.r(2, paramString);
    }
    this.a.d();
    paramLong = c.b(this.a, locall, false, null);
    for (;;)
    {
      try
      {
        int i = o1.b.e(paramLong, "id");
        int j = o1.b.e(paramLong, "group_id");
        int k = o1.b.e(paramLong, "uid");
        int m = o1.b.e(paramLong, "type");
        int n = o1.b.e(paramLong, "is_deleted");
        int i1 = o1.b.e(paramLong, "name");
        paramString = new ArrayList(paramLong.getCount());
        if (paramLong.moveToNext())
        {
          GroupMember localGroupMember = new GroupMember();
          localGroupMember.id = paramLong.getLong(i);
          localGroupMember.groupId = paramLong.getLong(j);
          localGroupMember.uid = paramLong.getLong(k);
          localGroupMember.type = ((byte)paramLong.getShort(m));
          if (paramLong.getInt(n) != 0)
          {
            bool = true;
            localGroupMember.deleted = bool;
            if (paramLong.isNull(i1)) {
              localGroupMember.name = null;
            } else {
              localGroupMember.name = paramLong.getString(i1);
            }
            paramString.add(localGroupMember);
          }
        }
        else
        {
          return paramString;
        }
      }
      finally
      {
        paramLong.close();
        locall.d0();
      }
      boolean bool = false;
    }
  }
  
  public List<GroupMember> o(Long paramLong, List<Long> paramList)
  {
    Object localObject = o1.f.b();
    ((StringBuilder)localObject).append("select * from t_hoxin_group_member where group_id = ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and uid not in(");
    int i = paramList.size();
    o1.f.a((StringBuilder)localObject, i);
    ((StringBuilder)localObject).append(") and is_deleted = 0  order by type desc");
    localObject = l.h(((StringBuilder)localObject).toString(), i + 1);
    if (paramLong == null) {
      ((l)localObject).y(1);
    } else {
      ((l)localObject).O(1, paramLong.longValue());
    }
    i = 2;
    paramLong = paramList.iterator();
    while (paramLong.hasNext())
    {
      paramList = (Long)paramLong.next();
      if (paramList == null) {
        ((l)localObject).y(i);
      } else {
        ((l)localObject).O(i, paramList.longValue());
      }
      i += 1;
    }
    this.a.d();
    paramLong = c.b(this.a, (j)localObject, false, null);
    for (;;)
    {
      try
      {
        i = o1.b.e(paramLong, "id");
        int j = o1.b.e(paramLong, "group_id");
        int k = o1.b.e(paramLong, "uid");
        int m = o1.b.e(paramLong, "type");
        int n = o1.b.e(paramLong, "is_deleted");
        int i1 = o1.b.e(paramLong, "name");
        paramList = new ArrayList(paramLong.getCount());
        if (paramLong.moveToNext())
        {
          GroupMember localGroupMember = new GroupMember();
          localGroupMember.id = paramLong.getLong(i);
          localGroupMember.groupId = paramLong.getLong(j);
          localGroupMember.uid = paramLong.getLong(k);
          localGroupMember.type = ((byte)paramLong.getShort(m));
          if (paramLong.getInt(n) != 0)
          {
            bool = true;
            localGroupMember.deleted = bool;
            if (paramLong.isNull(i1)) {
              localGroupMember.name = null;
            } else {
              localGroupMember.name = paramLong.getString(i1);
            }
            paramList.add(localGroupMember);
          }
        }
        else
        {
          return paramList;
        }
      }
      finally
      {
        paramLong.close();
        ((l)localObject).d0();
      }
      boolean bool = false;
    }
  }
  
  class a
    extends g<GroupMember>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_group_member` (`id`,`group_id`,`uid`,`type`,`is_deleted`,`name`) VALUES (nullif(?, 0),?,?,?,?,?)";
    }
    
    public void k(k paramk, GroupMember paramGroupMember)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  class b
    extends m1.f<GroupMember>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "UPDATE OR ABORT `t_hoxin_group_member` SET `id` = ?,`group_id` = ?,`uid` = ?,`type` = ?,`is_deleted` = ?,`name` = ? WHERE `id` = ?";
    }
    
    public void i(k paramk, GroupMember paramGroupMember)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      return "delete from t_hoxin_group_member  where group_id = ?";
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
      return "update t_hoxin_group_member set is_deleted = 1 where group_id = ? and uid = ?";
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
      return "update t_hoxin_group_member set type = ? where group_id = ? and uid = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q4.b
 * JD-Core Version:    0.7.0.1
 */