package h6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.moment.entity.MomentRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.c;
import p1.i;
import p1.k;

public final class f
  implements e
{
  private final f0 a;
  private final g<MomentRule> b;
  private final m c;
  
  public f(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
  }
  
  public static List<Class<?>> f()
  {
    return Collections.emptyList();
  }
  
  public void a(Long paramLong, byte paramByte)
  {
    this.a.d();
    k localk = this.c.a();
    if (paramLong == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong.longValue());
    }
    localk.O(2, paramByte);
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
  
  public void b(List<MomentRule> paramList)
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
  
  public boolean c(Long paramLong, byte paramByte)
  {
    l locall = l.h("select * from t_hoxin_moment_rule where target_id = ? and type = ?", 2);
    boolean bool2 = true;
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    locall.O(2, paramByte);
    this.a.d();
    paramLong = this.a;
    boolean bool1 = false;
    paramLong = c.b(paramLong, locall, false, null);
    try
    {
      if (paramLong.moveToFirst())
      {
        paramByte = paramLong.getInt(0);
        if (paramByte != 0) {
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
  
  public List<Long> d()
  {
    l locall = l.h("select target_id from t_hoxin_moment_rule where  type = 1", 0);
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
  
  public void e(MomentRule paramMomentRule)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramMomentRule);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  class a
    extends g<MomentRule>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_moment_rule` (`id`,`target_id`,`type`) VALUES (nullif(?, 0),?,?)";
    }
    
    public void k(k paramk, MomentRule paramMomentRule)
    {
      paramk.O(1, paramMomentRule.id);
      paramk.O(2, paramMomentRule.targetId);
      paramk.O(3, paramMomentRule.type);
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
      return "delete from t_hoxin_moment_rule where target_id = ? and type = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h6.f
 * JD-Core Version:    0.7.0.1
 */