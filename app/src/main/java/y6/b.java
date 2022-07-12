package y6;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.webrtc.entity.GroupCallLog;
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
  private final g<GroupCallLog> b;
  private final m c;
  private final m d;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
  }
  
  public static List<Class<?>> c()
  {
    return Collections.emptyList();
  }
  
  public void a(GroupCallLog paramGroupCallLog)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramGroupCallLog);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public void b(long paramLong)
  {
    this.a.d();
    k localk = this.d.a();
    localk.O(1, paramLong);
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
  
  public List<GroupCallLog> e()
  {
    l locall = l.h("select * from t_hoxin_group_call_log order by id desc", 0);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(localCursor, "id");
      int j = o1.b.e(localCursor, "tag");
      int k = o1.b.e(localCursor, "uid");
      int m = o1.b.e(localCursor, "type");
      int n = o1.b.e(localCursor, "state");
      int i1 = o1.b.e(localCursor, "content");
      int i2 = o1.b.e(localCursor, "duration");
      int i3 = o1.b.e(localCursor, "timestamp");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        GroupCallLog localGroupCallLog = new GroupCallLog();
        localGroupCallLog.id = localCursor.getLong(i);
        if (localCursor.isNull(j)) {
          localGroupCallLog.tag = null;
        } else {
          localGroupCallLog.tag = localCursor.getString(j);
        }
        localGroupCallLog.uid = localCursor.getLong(k);
        localGroupCallLog.type = localCursor.getInt(m);
        localGroupCallLog.state = localCursor.getInt(n);
        if (localCursor.isNull(i1)) {
          localGroupCallLog.content = null;
        } else {
          localGroupCallLog.content = localCursor.getString(i1);
        }
        if (localCursor.isNull(i2)) {
          localGroupCallLog.duration = null;
        } else {
          localGroupCallLog.duration = Long.valueOf(localCursor.getLong(i2));
        }
        if (localCursor.isNull(i3)) {
          localGroupCallLog.timestamp = null;
        } else {
          localGroupCallLog.timestamp = Long.valueOf(localCursor.getLong(i3));
        }
        localArrayList.add(localGroupCallLog);
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
    extends g<GroupCallLog>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_group_call_log` (`id`,`tag`,`uid`,`type`,`state`,`content`,`duration`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, GroupCallLog paramGroupCallLog)
    {
      paramk.O(1, paramGroupCallLog.id);
      Object localObject = paramGroupCallLog.tag;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.r(2, (String)localObject);
      }
      paramk.O(3, paramGroupCallLog.uid);
      paramk.O(4, paramGroupCallLog.type);
      paramk.O(5, paramGroupCallLog.state);
      localObject = paramGroupCallLog.content;
      if (localObject == null) {
        paramk.y(6);
      } else {
        paramk.r(6, (String)localObject);
      }
      localObject = paramGroupCallLog.duration;
      if (localObject == null) {
        paramk.y(7);
      } else {
        paramk.O(7, ((Long)localObject).longValue());
      }
      paramGroupCallLog = paramGroupCallLog.timestamp;
      if (paramGroupCallLog == null)
      {
        paramk.y(8);
        return;
      }
      paramk.O(8, paramGroupCallLog.longValue());
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
      return "delete from t_hoxin_group_call_log where tag = ?";
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
      return "delete from t_hoxin_group_call_log where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y6.b
 * JD-Core Version:    0.7.0.1
 */