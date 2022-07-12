package x4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.home.entity.StarMark;
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
  private final g<StarMark> b;
  private final m c;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
  }
  
  public static List<Class<?>> d()
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
  
  public List<Long> b()
  {
    l locall = l.h("select uid from t_hoxin_star_mark", 0);
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
  
  public void c(StarMark paramStarMark)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramStarMark);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public boolean f(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_star_mark where uid = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = this.a;
    boolean bool1 = false;
    paramLong = c.b(paramLong, locall, false, null);
    try
    {
      if (paramLong.moveToFirst())
      {
        int i = paramLong.getInt(0);
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
      paramLong.close();
      locall.d0();
    }
  }
  
  class a
    extends g<StarMark>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_star_mark` (`uid`) VALUES (?)";
    }
    
    public void k(k paramk, StarMark paramStarMark)
    {
      paramk.O(1, paramStarMark.uid);
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
      return "delete from t_hoxin_star_mark where uid = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x4.b
 * JD-Core Version:    0.7.0.1
 */