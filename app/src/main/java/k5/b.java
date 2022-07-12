package k5;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.message.entity.ChatSession;
import java.util.ArrayList;
import java.util.Collections;
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
  private final g<ChatSession> b;
  private final m1.f<ChatSession> c;
  private final m d;
  private final m e;
  private final m f;
  private final m g;
  private final m h;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
    this.c = new b(paramf0);
    this.d = new c(paramf0);
    this.e = new d(paramf0);
    this.f = new e(paramf0);
    this.g = new f(paramf0);
    this.h = new g(paramf0);
  }
  
  public static List<Class<?>> b()
  {
    return Collections.emptyList();
  }
  
  public ChatSession a(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_chat_session where id = ? ", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject2 = this.a;
    ChatSession localChatSession = null;
    localObject2 = c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = o1.b.e((Cursor)localObject2, "id");
      int j = o1.b.e((Cursor)localObject2, "name");
      int k = o1.b.e((Cursor)localObject2, "source_id");
      int m = o1.b.e((Cursor)localObject2, "source_type");
      int n = o1.b.e((Cursor)localObject2, "message");
      int i1 = o1.b.e((Cursor)localObject2, "state");
      int i2 = o1.b.e((Cursor)localObject2, "visible");
      int i3 = o1.b.e((Cursor)localObject2, "priority");
      int i4 = o1.b.e((Cursor)localObject2, "badge");
      int i5 = o1.b.e((Cursor)localObject2, "timestamp");
      if (((Cursor)localObject2).moveToFirst())
      {
        localChatSession = new ChatSession();
        localChatSession.id = ((Cursor)localObject2).getLong(i);
        if (((Cursor)localObject2).isNull(j)) {
          localChatSession.name = null;
        } else {
          localChatSession.name = ((Cursor)localObject2).getString(j);
        }
        localChatSession.sourceId = ((Cursor)localObject2).getLong(k);
        localChatSession.sourceType = ((Cursor)localObject2).getInt(m);
        if (((Cursor)localObject2).isNull(n)) {
          localChatSession.message = null;
        } else {
          localChatSession.message = ((Cursor)localObject2).getString(n);
        }
        localChatSession.state = ((Cursor)localObject2).getInt(i1);
        localChatSession.visible = ((Cursor)localObject2).getInt(i2);
        localChatSession.priority = ((Cursor)localObject2).getLong(i3);
        localChatSession.badge = ((Cursor)localObject2).getInt(i4);
        localChatSession.timestamp = ((Cursor)localObject2).getLong(i5);
      }
      return localChatSession;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public ChatSession c(long paramLong1, long paramLong2)
  {
    l locall = l.h("select * from t_hoxin_chat_session where source_id = ? and source_type = ? ", 2);
    locall.O(1, paramLong1);
    locall.O(2, paramLong2);
    this.a.d();
    Object localObject2 = this.a;
    ChatSession localChatSession = null;
    localObject2 = c.b((f0)localObject2, locall, false, null);
    try
    {
      int i = o1.b.e((Cursor)localObject2, "id");
      int j = o1.b.e((Cursor)localObject2, "name");
      int k = o1.b.e((Cursor)localObject2, "source_id");
      int m = o1.b.e((Cursor)localObject2, "source_type");
      int n = o1.b.e((Cursor)localObject2, "message");
      int i1 = o1.b.e((Cursor)localObject2, "state");
      int i2 = o1.b.e((Cursor)localObject2, "visible");
      int i3 = o1.b.e((Cursor)localObject2, "priority");
      int i4 = o1.b.e((Cursor)localObject2, "badge");
      int i5 = o1.b.e((Cursor)localObject2, "timestamp");
      if (((Cursor)localObject2).moveToFirst())
      {
        localChatSession = new ChatSession();
        localChatSession.id = ((Cursor)localObject2).getLong(i);
        if (((Cursor)localObject2).isNull(j)) {
          localChatSession.name = null;
        } else {
          localChatSession.name = ((Cursor)localObject2).getString(j);
        }
        localChatSession.sourceId = ((Cursor)localObject2).getLong(k);
        localChatSession.sourceType = ((Cursor)localObject2).getInt(m);
        if (((Cursor)localObject2).isNull(n)) {
          localChatSession.message = null;
        } else {
          localChatSession.message = ((Cursor)localObject2).getString(n);
        }
        localChatSession.state = ((Cursor)localObject2).getInt(i1);
        localChatSession.visible = ((Cursor)localObject2).getInt(i2);
        localChatSession.priority = ((Cursor)localObject2).getLong(i3);
        localChatSession.badge = ((Cursor)localObject2).getInt(i4);
        localChatSession.timestamp = ((Cursor)localObject2).getLong(i5);
      }
      return localChatSession;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    this.a.d();
    k localk = this.d.a();
    localk.O(1, paramLong2);
    localk.O(2, paramLong1);
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
  
  public List<ChatSession> e()
  {
    l locall = l.h("select * from (select * from t_hoxin_chat_session where visible = 1 order by  timestamp desc) t order by t.priority desc", 0);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      int j = o1.b.e(localCursor, "id");
      int i = o1.b.e(localCursor, "name");
      int k = o1.b.e(localCursor, "source_id");
      int m = o1.b.e(localCursor, "source_type");
      int n = o1.b.e(localCursor, "message");
      int i1 = o1.b.e(localCursor, "state");
      int i2 = o1.b.e(localCursor, "visible");
      int i3 = o1.b.e(localCursor, "priority");
      int i4 = o1.b.e(localCursor, "badge");
      int i5 = o1.b.e(localCursor, "timestamp");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        ChatSession localChatSession = new ChatSession();
        localChatSession.id = localCursor.getLong(j);
        if (localCursor.isNull(i)) {
          localChatSession.name = null;
        } else {
          localChatSession.name = localCursor.getString(i);
        }
        localChatSession.sourceId = localCursor.getLong(k);
        localChatSession.sourceType = localCursor.getInt(m);
        if (localCursor.isNull(n)) {
          localChatSession.message = null;
        } else {
          localChatSession.message = localCursor.getString(n);
        }
        localChatSession.state = localCursor.getInt(i1);
        localChatSession.visible = localCursor.getInt(i2);
        localChatSession.priority = localCursor.getLong(i3);
        localChatSession.badge = localCursor.getInt(i4);
        localChatSession.timestamp = localCursor.getLong(i5);
        localArrayList.add(localChatSession);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public long f(ChatSession paramChatSession)
  {
    this.a.d();
    this.a.e();
    try
    {
      long l = this.b.j(paramChatSession);
      this.a.B();
      return l;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public List<Long> g(Long[] paramArrayOfLong, long paramLong)
  {
    Object localObject1 = o1.f.b();
    ((StringBuilder)localObject1).append("select id from t_hoxin_chat_session where source_id in( ");
    int i = paramArrayOfLong.length;
    o1.f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and source_type = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" ");
    localObject1 = ((StringBuilder)localObject1).toString();
    int j = 1;
    int k = i + 1;
    localObject1 = l.h((String)localObject1, k);
    int m = paramArrayOfLong.length;
    i = 0;
    while (i < m)
    {
      localObject2 = paramArrayOfLong[i];
      if (localObject2 == null) {
        ((l)localObject1).y(j);
      } else {
        ((l)localObject1).O(j, ((Long)localObject2).longValue());
      }
      j += 1;
      i += 1;
    }
    ((l)localObject1).O(k, paramLong);
    this.a.d();
    Object localObject2 = c.b(this.a, (j)localObject1, false, null);
    try
    {
      ArrayList localArrayList = new ArrayList(((Cursor)localObject2).getCount());
      while (((Cursor)localObject2).moveToNext())
      {
        if (((Cursor)localObject2).isNull(0)) {
          paramArrayOfLong = null;
        } else {
          paramArrayOfLong = Long.valueOf(((Cursor)localObject2).getLong(0));
        }
        localArrayList.add(paramArrayOfLong);
      }
      return localArrayList;
    }
    finally
    {
      ((Cursor)localObject2).close();
      ((l)localObject1).d0();
    }
  }
  
  public void h(long paramLong, int paramInt)
  {
    this.a.d();
    k localk = this.h.a();
    localk.O(1, paramInt);
    localk.O(2, paramLong);
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
  
  public long i()
  {
    l locall = l.h("select count(id) from  t_hoxin_chat_session where badge > 0", 0);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      long l;
      if (localCursor.moveToFirst()) {
        l = localCursor.getLong(0);
      } else {
        l = 0L;
      }
      return l;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void j(long paramLong1, long paramLong2, String paramString)
  {
    this.a.d();
    k localk = this.g.a();
    if (paramString == null) {
      localk.y(1);
    } else {
      localk.r(1, paramString);
    }
    localk.O(2, paramLong1);
    localk.O(3, paramLong2);
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
  
  public long k()
  {
    l locall = l.h("select sum(badge) from  t_hoxin_chat_session", 0);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      long l;
      if (localCursor.moveToFirst()) {
        l = localCursor.getLong(0);
      } else {
        l = 0L;
      }
      return l;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void l(Long[] paramArrayOfLong, int paramInt)
  {
    this.a.d();
    Object localObject = o1.f.b();
    ((StringBuilder)localObject).append("update t_hoxin_chat_session set visible=");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" where id in (");
    o1.f.a((StringBuilder)localObject, paramArrayOfLong.length);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.a.g((String)localObject);
    ((i)localObject).O(1, paramInt);
    int j = paramArrayOfLong.length;
    int i = 2;
    paramInt = 0;
    while (paramInt < j)
    {
      Long localLong = paramArrayOfLong[paramInt];
      if (localLong == null) {
        ((i)localObject).y(i);
      } else {
        ((i)localObject).O(i, localLong.longValue());
      }
      i += 1;
      paramInt += 1;
    }
    this.a.e();
    try
    {
      ((k)localObject).u();
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public List<ChatSession> m(int[] paramArrayOfInt, String paramString)
  {
    Object localObject1 = o1.f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_chat_session where visible = 1 and source_type in(");
    int i = paramArrayOfInt.length;
    o1.f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and name like ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" order by  priority,timestamp desc");
    localObject1 = ((StringBuilder)localObject1).toString();
    int k = i + 1;
    localObject1 = l.h((String)localObject1, k);
    int m = paramArrayOfInt.length;
    int j = 1;
    i = 0;
    while (i < m)
    {
      ((l)localObject1).O(j, paramArrayOfInt[i]);
      j += 1;
      i += 1;
    }
    if (paramString == null) {
      ((l)localObject1).y(k);
    } else {
      ((l)localObject1).r(k, paramString);
    }
    this.a.d();
    Cursor localCursor = c.b(this.a, (j)localObject1, false, null);
    paramString = (String)localObject1;
    try
    {
      i = o1.b.e(localCursor, "id");
      paramString = (String)localObject1;
      j = o1.b.e(localCursor, "name");
      paramString = (String)localObject1;
      k = o1.b.e(localCursor, "source_id");
      paramString = (String)localObject1;
      m = o1.b.e(localCursor, "source_type");
      paramString = (String)localObject1;
      int n = o1.b.e(localCursor, "message");
      paramString = (String)localObject1;
      int i1 = o1.b.e(localCursor, "state");
      paramString = (String)localObject1;
      int i2 = o1.b.e(localCursor, "visible");
      paramString = (String)localObject1;
      int i3 = o1.b.e(localCursor, "priority");
      paramString = (String)localObject1;
      int i4 = o1.b.e(localCursor, "badge");
      paramString = (String)localObject1;
      int i5 = o1.b.e(localCursor, "timestamp");
      paramString = (String)localObject1;
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      paramArrayOfInt = (int[])localObject1;
      for (;;)
      {
        paramString = paramArrayOfInt;
        if (localCursor.moveToNext())
        {
          paramString = paramArrayOfInt;
          localObject1 = new ChatSession();
          try
          {
            ((ChatSession)localObject1).id = localCursor.getLong(i);
            if (localCursor.isNull(j)) {
              ((ChatSession)localObject1).name = null;
            } else {
              ((ChatSession)localObject1).name = localCursor.getString(j);
            }
            ((ChatSession)localObject1).sourceId = localCursor.getLong(k);
            ((ChatSession)localObject1).sourceType = localCursor.getInt(m);
            if (localCursor.isNull(n)) {
              ((ChatSession)localObject1).message = null;
            } else {
              ((ChatSession)localObject1).message = localCursor.getString(n);
            }
            ((ChatSession)localObject1).state = localCursor.getInt(i1);
            ((ChatSession)localObject1).visible = localCursor.getInt(i2);
            ((ChatSession)localObject1).priority = localCursor.getLong(i3);
            ((ChatSession)localObject1).badge = localCursor.getInt(i4);
            ((ChatSession)localObject1).timestamp = localCursor.getLong(i5);
            localArrayList.add(localObject1);
          }
          finally
          {
            break label534;
          }
        }
      }
      localCursor.close();
      paramArrayOfInt.d0();
      return localArrayList;
    }
    finally
    {
      paramArrayOfInt = paramString;
      paramString = localObject2;
      label534:
      localCursor.close();
      paramArrayOfInt.d0();
    }
  }
  
  public void n(long paramLong, int paramInt)
  {
    this.a.d();
    k localk = this.f.a();
    localk.O(1, paramInt);
    localk.O(2, paramLong);
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
  
  public Long o(long paramLong1, long paramLong2)
  {
    l locall = l.h("select id from t_hoxin_chat_session where source_id = ? and source_type = ? ", 2);
    locall.O(1, paramLong1);
    locall.O(2, paramLong2);
    this.a.d();
    Object localObject1 = this.a;
    Object localObject3 = null;
    Cursor localCursor = c.b((f0)localObject1, locall, false, null);
    localObject1 = localObject3;
    try
    {
      if (localCursor.moveToFirst()) {
        if (localCursor.isNull(0)) {
          localObject1 = localObject3;
        } else {
          localObject1 = Long.valueOf(localCursor.getLong(0));
        }
      }
      return localObject1;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public List<ChatSession> p(int[] paramArrayOfInt)
  {
    Object localObject1 = o1.f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_chat_session where visible = 1 and source_type in(");
    int i = paramArrayOfInt.length;
    o1.f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") order by  priority,timestamp desc");
    Object localObject4 = l.h(((StringBuilder)localObject1).toString(), i + 0);
    int k = paramArrayOfInt.length;
    i = 0;
    int j = 1;
    while (i < k)
    {
      ((l)localObject4).O(j, paramArrayOfInt[i]);
      j += 1;
      i += 1;
    }
    this.a.d();
    Cursor localCursor = c.b(this.a, (j)localObject4, false, null);
    localObject1 = localObject4;
    Object localObject3;
    try
    {
      i = o1.b.e(localCursor, "id");
      localObject1 = localObject4;
      j = o1.b.e(localCursor, "name");
      localObject1 = localObject4;
      k = o1.b.e(localCursor, "source_id");
      localObject1 = localObject4;
      int m = o1.b.e(localCursor, "source_type");
      localObject1 = localObject4;
      int n = o1.b.e(localCursor, "message");
      localObject1 = localObject4;
      int i1 = o1.b.e(localCursor, "state");
      localObject1 = localObject4;
      int i2 = o1.b.e(localCursor, "visible");
      localObject1 = localObject4;
      int i3 = o1.b.e(localCursor, "priority");
      localObject1 = localObject4;
      int i4 = o1.b.e(localCursor, "badge");
      localObject1 = localObject4;
      int i5 = o1.b.e(localCursor, "timestamp");
      localObject1 = localObject4;
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      paramArrayOfInt = (int[])localObject4;
      for (;;)
      {
        localObject1 = paramArrayOfInt;
        if (localCursor.moveToNext())
        {
          localObject1 = paramArrayOfInt;
          localObject4 = new ChatSession();
          try
          {
            ((ChatSession)localObject4).id = localCursor.getLong(i);
            if (localCursor.isNull(j)) {
              ((ChatSession)localObject4).name = null;
            } else {
              ((ChatSession)localObject4).name = localCursor.getString(j);
            }
            ((ChatSession)localObject4).sourceId = localCursor.getLong(k);
            ((ChatSession)localObject4).sourceType = localCursor.getInt(m);
            if (localCursor.isNull(n)) {
              ((ChatSession)localObject4).message = null;
            } else {
              ((ChatSession)localObject4).message = localCursor.getString(n);
            }
            ((ChatSession)localObject4).state = localCursor.getInt(i1);
            ((ChatSession)localObject4).visible = localCursor.getInt(i2);
            ((ChatSession)localObject4).priority = localCursor.getLong(i3);
            ((ChatSession)localObject4).badge = localCursor.getInt(i4);
            ((ChatSession)localObject4).timestamp = localCursor.getLong(i5);
            localArrayList.add(localObject4);
          }
          finally
          {
            break label496;
          }
        }
      }
      localCursor.close();
      paramArrayOfInt.d0();
      return localArrayList;
    }
    finally
    {
      paramArrayOfInt = localObject2;
      localObject3 = localObject5;
      label496:
      localCursor.close();
      paramArrayOfInt.d0();
    }
  }
  
  public void q(long paramLong)
  {
    this.a.d();
    k localk = this.e.a();
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
      this.e.f(localk);
    }
  }
  
  public long r(long paramLong)
  {
    l locall = l.h("select badge from  t_hoxin_chat_session where id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      if (localCursor.moveToFirst()) {
        paramLong = localCursor.getLong(0);
      } else {
        paramLong = 0L;
      }
      return paramLong;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public void s(ChatSession paramChatSession)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.c.h(paramChatSession);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  class a
    extends g<ChatSession>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_chat_session` (`id`,`name`,`source_id`,`source_type`,`message`,`state`,`visible`,`priority`,`badge`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, ChatSession paramChatSession)
    {
      paramk.O(1, paramChatSession.id);
      String str = paramChatSession.name;
      if (str == null) {
        paramk.y(2);
      } else {
        paramk.r(2, str);
      }
      paramk.O(3, paramChatSession.sourceId);
      paramk.O(4, paramChatSession.sourceType);
      str = paramChatSession.message;
      if (str == null) {
        paramk.y(5);
      } else {
        paramk.r(5, str);
      }
      paramk.O(6, paramChatSession.state);
      paramk.O(7, paramChatSession.visible);
      paramk.O(8, paramChatSession.priority);
      paramk.O(9, paramChatSession.badge);
      paramk.O(10, paramChatSession.timestamp);
    }
  }
  
  class b
    extends m1.f<ChatSession>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "UPDATE OR REPLACE `t_hoxin_chat_session` SET `id` = ?,`name` = ?,`source_id` = ?,`source_type` = ?,`message` = ?,`state` = ?,`visible` = ?,`priority` = ?,`badge` = ?,`timestamp` = ? WHERE `id` = ?";
    }
    
    public void i(k paramk, ChatSession paramChatSession)
    {
      paramk.O(1, paramChatSession.id);
      String str = paramChatSession.name;
      if (str == null) {
        paramk.y(2);
      } else {
        paramk.r(2, str);
      }
      paramk.O(3, paramChatSession.sourceId);
      paramk.O(4, paramChatSession.sourceType);
      str = paramChatSession.message;
      if (str == null) {
        paramk.y(5);
      } else {
        paramk.r(5, str);
      }
      paramk.O(6, paramChatSession.state);
      paramk.O(7, paramChatSession.visible);
      paramk.O(8, paramChatSession.priority);
      paramk.O(9, paramChatSession.badge);
      paramk.O(10, paramChatSession.timestamp);
      paramk.O(11, paramChatSession.id);
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
      return "update t_hoxin_chat_session set priority = ? where id = ?";
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
      return "update t_hoxin_chat_session set priority = 0 where id = ?";
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
      return "update t_hoxin_chat_session set badge = ? where id = ?";
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
      return "update t_hoxin_chat_session set name = ? where source_id = ? and source_type = ?";
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
      return "update t_hoxin_chat_session set state = ? where id = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k5.b
 * JD-Core Version:    0.7.0.1
 */