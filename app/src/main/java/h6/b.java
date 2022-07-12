package h6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.moment.entity.Comment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.c;
import o1.f;
import p1.i;
import p1.j;
import p1.k;

public final class b
  implements a
{
  private final f0 a;
  private final g<Comment> b;
  private final m c;
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
  
  public static List<Class<?>> g()
  {
    return Collections.emptyList();
  }
  
  public void a(Long paramLong)
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
  
  public void b(List<Comment> paramList)
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
  
  public Comment c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_moment_comment where id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    Object localObject = this.a;
    paramLong = null;
    localObject = c.b((f0)localObject, locall, false, null);
    for (;;)
    {
      try
      {
        int i = o1.b.e((Cursor)localObject, "id");
        int j = o1.b.e((Cursor)localObject, "moment_id");
        int k = o1.b.e((Cursor)localObject, "uid");
        int m = o1.b.e((Cursor)localObject, "content");
        int n = o1.b.e((Cursor)localObject, "parent_id");
        int i1 = o1.b.e((Cursor)localObject, "type");
        int i2 = o1.b.e((Cursor)localObject, "is_deleted");
        int i3 = o1.b.e((Cursor)localObject, "create_time");
        if (((Cursor)localObject).moveToFirst())
        {
          paramLong = new Comment();
          try
          {
            paramLong.id = ((Cursor)localObject).getLong(i);
            paramLong.momentId = ((Cursor)localObject).getLong(j);
            paramLong.uid = ((Cursor)localObject).getLong(k);
            if (((Cursor)localObject).isNull(m)) {
              paramLong.content = null;
            } else {
              paramLong.content = ((Cursor)localObject).getString(m);
            }
            if (((Cursor)localObject).isNull(n)) {
              paramLong.parentId = null;
            } else {
              paramLong.parentId = Long.valueOf(((Cursor)localObject).getLong(n));
            }
            if (((Cursor)localObject).isNull(i1)) {
              paramLong.type = null;
            } else {
              paramLong.type = ((Cursor)localObject).getString(i1);
            }
            if (((Cursor)localObject).getInt(i2) == 0) {
              break label380;
            }
            bool = true;
            paramLong.deleted = bool;
            if (((Cursor)localObject).isNull(i3)) {
              paramLong.createTime = null;
            } else {
              paramLong.createTime = Long.valueOf(((Cursor)localObject).getLong(i3));
            }
          }
          finally
          {
            continue;
          }
        }
        return paramLong;
      }
      finally
      {
        ((Cursor)localObject).close();
        locall.d0();
      }
      label380:
      boolean bool = false;
    }
  }
  
  public void d(Comment paramComment)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramComment);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public List<Comment> e(Long paramLong)
  {
    Object localObject4 = l.h("select * from t_hoxin_moment_comment where moment_id = ? and is_deleted = 0 order by create_time ", 1);
    if (paramLong == null) {
      ((l)localObject4).y(1);
    } else {
      ((l)localObject4).O(1, paramLong.longValue());
    }
    this.a.d();
    Cursor localCursor = c.b(this.a, (j)localObject4, false, null);
    Object localObject1 = localObject4;
    for (;;)
    {
      Object localObject3;
      try
      {
        int i = o1.b.e(localCursor, "id");
        localObject1 = localObject4;
        int j = o1.b.e(localCursor, "moment_id");
        localObject1 = localObject4;
        int k = o1.b.e(localCursor, "uid");
        localObject1 = localObject4;
        int m = o1.b.e(localCursor, "content");
        localObject1 = localObject4;
        int n = o1.b.e(localCursor, "parent_id");
        localObject1 = localObject4;
        int i1 = o1.b.e(localCursor, "type");
        localObject1 = localObject4;
        int i2 = o1.b.e(localCursor, "is_deleted");
        localObject1 = localObject4;
        int i3 = o1.b.e(localCursor, "create_time");
        localObject1 = localObject4;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        paramLong = (Long)localObject4;
        localObject1 = paramLong;
        if (localCursor.moveToNext())
        {
          localObject1 = paramLong;
          localObject4 = new Comment();
          try
          {
            ((Comment)localObject4).id = localCursor.getLong(i);
            ((Comment)localObject4).momentId = localCursor.getLong(j);
            ((Comment)localObject4).uid = localCursor.getLong(k);
            if (localCursor.isNull(m)) {
              ((Comment)localObject4).content = null;
            } else {
              ((Comment)localObject4).content = localCursor.getString(m);
            }
            if (localCursor.isNull(n)) {
              ((Comment)localObject4).parentId = null;
            } else {
              ((Comment)localObject4).parentId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              ((Comment)localObject4).type = null;
            } else {
              ((Comment)localObject4).type = localCursor.getString(i1);
            }
            if (localCursor.getInt(i2) == 0) {
              break label467;
            }
            bool = true;
            ((Comment)localObject4).deleted = bool;
            if (localCursor.isNull(i3)) {
              ((Comment)localObject4).createTime = null;
            } else {
              ((Comment)localObject4).createTime = Long.valueOf(localCursor.getLong(i3));
            }
            localArrayList.add(localObject4);
          }
          finally
          {
            continue;
          }
        }
        localCursor.close();
        paramLong.d0();
        return localArrayList;
      }
      finally
      {
        paramLong = localObject2;
        localObject3 = localObject5;
        localCursor.close();
        paramLong.d0();
      }
      label467:
      boolean bool = false;
    }
  }
  
  public void f(Long paramLong)
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
  
  public void h()
  {
    this.a.d();
    k localk = this.d.a();
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
  
  public List<Comment> i(long paramLong, List<Long> paramList)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_moment_comment where moment_id = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and is_deleted = 0 and uid not in(");
    int i = paramList.size();
    f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") order by create_time ");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), i + 1);
    ((l)localObject1).O(1, paramLong);
    paramList = paramList.iterator();
    i = 2;
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
    this.a.d();
    paramList = c.b(this.a, (j)localObject1, false, null);
    for (;;)
    {
      try
      {
        i = o1.b.e(paramList, "id");
        int j = o1.b.e(paramList, "moment_id");
        int k = o1.b.e(paramList, "uid");
        int m = o1.b.e(paramList, "content");
        int n = o1.b.e(paramList, "parent_id");
        int i1 = o1.b.e(paramList, "type");
        int i2 = o1.b.e(paramList, "is_deleted");
        int i3 = o1.b.e(paramList, "create_time");
        localObject2 = new ArrayList(paramList.getCount());
        if (paramList.moveToNext())
        {
          Comment localComment = new Comment();
          localComment.id = paramList.getLong(i);
          localComment.momentId = paramList.getLong(j);
          localComment.uid = paramList.getLong(k);
          if (paramList.isNull(m)) {
            localComment.content = null;
          } else {
            localComment.content = paramList.getString(m);
          }
          if (paramList.isNull(n)) {
            localComment.parentId = null;
          } else {
            localComment.parentId = Long.valueOf(paramList.getLong(n));
          }
          if (paramList.isNull(i1)) {
            localComment.type = null;
          } else {
            localComment.type = paramList.getString(i1);
          }
          if (paramList.getInt(i2) != 0)
          {
            bool = true;
            localComment.deleted = bool;
            if (paramList.isNull(i3)) {
              localComment.createTime = null;
            } else {
              localComment.createTime = Long.valueOf(paramList.getLong(i3));
            }
            ((List)localObject2).add(localComment);
          }
        }
        else
        {
          return localObject2;
        }
      }
      finally
      {
        paramList.close();
        ((l)localObject1).d0();
      }
      boolean bool = false;
    }
  }
  
  class a
    extends g<Comment>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_moment_comment` (`id`,`moment_id`,`uid`,`content`,`parent_id`,`type`,`is_deleted`,`create_time`) VALUES (?,?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Comment paramComment)
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
      return "delete from t_hoxin_moment_comment where moment_id = ?";
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
      return "delete from t_hoxin_moment_comment";
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
      return "update t_hoxin_moment_comment set is_deleted = 1 where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h6.b
 * JD-Core Version:    0.7.0.1
 */