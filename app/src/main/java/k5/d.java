package k5;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.MessageSearchHit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m1.g;
import m1.l;
import m1.m;
import o1.b;
import o1.f;
import p1.i;
import p1.j;
import p1.k;

public final class d
  implements c
{
  private final f0 a;
  private final g<Message> b;
  private final m c;
  private final m d;
  private final m e;
  private final m f;
  private final m g;
  private final m h;
  private final m i;
  private final m j;
  private final m k;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new b(paramf0);
    this.c = new c(paramf0);
    this.d = new d(paramf0);
    this.e = new e(paramf0);
    this.f = new f(paramf0);
    this.g = new g(paramf0);
    this.h = new h(paramf0);
    this.i = new i(paramf0);
    this.j = new j(paramf0);
    this.k = new a(paramf0);
  }
  
  public static List<Class<?>> C()
  {
    return Collections.emptyList();
  }
  
  public void A(String[] paramArrayOfString, Byte paramByte)
  {
    this.a.d();
    Object localObject = f.b();
    ((StringBuilder)localObject).append("update t_hoxin_message set state = ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" where `action` in(");
    f.a((StringBuilder)localObject, paramArrayOfString.length);
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.a.g((String)localObject);
    if (paramByte == null) {
      ((i)localObject).y(1);
    } else {
      ((i)localObject).O(1, paramByte.byteValue());
    }
    int n = 2;
    int i1 = paramArrayOfString.length;
    int m = 0;
    while (m < i1)
    {
      paramByte = paramArrayOfString[m];
      if (paramByte == null) {
        ((i)localObject).y(n);
      } else {
        ((i)localObject).r(n, paramByte);
      }
      n += 1;
      m += 1;
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
  
  public void B(Long paramLong, String paramString)
  {
    this.a.d();
    k localk = this.j.a();
    if (paramLong == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong.longValue());
    }
    if (paramString == null) {
      localk.y(2);
    } else {
      localk.r(2, paramString);
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
      this.j.f(localk);
    }
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
  
  public List<Message> b(long paramLong, byte paramByte, int[] paramArrayOfInt)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_message where session_id = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and format = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and state not in(");
    int m = paramArrayOfInt.length;
    f.a((StringBuilder)localObject1, m);
    ((StringBuilder)localObject1).append(")  order by create_time desc");
    Object localObject5 = l.h(((StringBuilder)localObject1).toString(), m + 2);
    ((l)localObject5).O(1, paramLong);
    ((l)localObject5).O(2, paramByte);
    byte b1 = paramArrayOfInt.length;
    m = 3;
    paramByte = 0;
    while (paramByte < b1)
    {
      ((l)localObject5).O(m, paramArrayOfInt[paramByte]);
      m += 1;
      paramByte += 1;
    }
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject5, false, null);
    localObject1 = localObject5;
    for (;;)
    {
      Object localObject3;
      try
      {
        paramByte = b.e(localCursor, "id");
        localObject1 = localObject5;
        m = b.e(localCursor, "session_id");
        localObject1 = localObject5;
        b1 = b.e(localCursor, "sender");
        localObject1 = localObject5;
        int n = b.e(localCursor, "receiver");
        localObject1 = localObject5;
        int i1 = b.e(localCursor, "action");
        localObject1 = localObject5;
        int i2 = b.e(localCursor, "content");
        localObject1 = localObject5;
        int i3 = b.e(localCursor, "title");
        localObject1 = localObject5;
        int i4 = b.e(localCursor, "extra");
        localObject1 = localObject5;
        int i5 = b.e(localCursor, "format");
        localObject1 = localObject5;
        int i6 = b.e(localCursor, "state");
        localObject1 = localObject5;
        int i7 = b.e(localCursor, "direction");
        localObject1 = localObject5;
        int i8 = b.e(localCursor, "create_time");
        localObject1 = localObject5;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        paramArrayOfInt = (int[])localObject5;
        localObject1 = paramArrayOfInt;
        if (localCursor.moveToNext())
        {
          localObject1 = paramArrayOfInt;
          localObject5 = new Message();
          try
          {
            ((Message)localObject5).id = localCursor.getLong(paramByte);
            if (localCursor.isNull(m)) {
              ((Message)localObject5).sessionId = null;
            } else {
              ((Message)localObject5).sessionId = Long.valueOf(localCursor.getLong(m));
            }
            if (localCursor.isNull(b1)) {
              ((Message)localObject5).sender = null;
            } else {
              ((Message)localObject5).sender = Long.valueOf(localCursor.getLong(b1));
            }
            if (localCursor.isNull(n)) {
              ((Message)localObject5).receiver = null;
            } else {
              ((Message)localObject5).receiver = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              ((Message)localObject5).action = null;
            } else {
              ((Message)localObject5).action = localCursor.getString(i1);
            }
            if (localCursor.isNull(i2)) {
              ((Message)localObject5).content = null;
            } else {
              ((Message)localObject5).content = localCursor.getString(i2);
            }
            if (localCursor.isNull(i3)) {
              ((Message)localObject5).title = null;
            } else {
              ((Message)localObject5).title = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              ((Message)localObject5).extra = null;
            } else {
              ((Message)localObject5).extra = localCursor.getString(i4);
            }
            ((Message)localObject5).format = ((byte)localCursor.getShort(i5));
            if (localCursor.isNull(i6)) {
              ((Message)localObject5).state = null;
            } else {
              ((Message)localObject5).state = Byte.valueOf((byte)localCursor.getShort(i6));
            }
            ((Message)localObject5).direction = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              ((Message)localObject5).createTime = null;
            } else {
              ((Message)localObject5).createTime = Long.valueOf(localCursor.getLong(i8));
            }
          }
          finally
          {
            continue;
          }
          localArrayList.add(localObject5);
        }
        else
        {
          localCursor.close();
          paramArrayOfInt.d0();
          return localArrayList;
        }
      }
      finally
      {
        paramArrayOfInt = localObject2;
        localObject3 = localObject4;
        localCursor.close();
        paramArrayOfInt.d0();
      }
    }
  }
  
  public Message c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_message where id = ? ", 1);
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
      int m = b.e((Cursor)localObject, "id");
      int n = b.e((Cursor)localObject, "session_id");
      int i1 = b.e((Cursor)localObject, "sender");
      int i2 = b.e((Cursor)localObject, "receiver");
      int i3 = b.e((Cursor)localObject, "action");
      int i4 = b.e((Cursor)localObject, "content");
      int i5 = b.e((Cursor)localObject, "title");
      int i6 = b.e((Cursor)localObject, "extra");
      int i7 = b.e((Cursor)localObject, "format");
      int i8 = b.e((Cursor)localObject, "state");
      int i9 = b.e((Cursor)localObject, "direction");
      int i10 = b.e((Cursor)localObject, "create_time");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new Message();
        paramLong.id = ((Cursor)localObject).getLong(m);
        if (((Cursor)localObject).isNull(n)) {
          paramLong.sessionId = null;
        } else {
          paramLong.sessionId = Long.valueOf(((Cursor)localObject).getLong(n));
        }
        if (((Cursor)localObject).isNull(i1)) {
          paramLong.sender = null;
        } else {
          paramLong.sender = Long.valueOf(((Cursor)localObject).getLong(i1));
        }
        if (((Cursor)localObject).isNull(i2)) {
          paramLong.receiver = null;
        } else {
          paramLong.receiver = Long.valueOf(((Cursor)localObject).getLong(i2));
        }
        if (((Cursor)localObject).isNull(i3)) {
          paramLong.action = null;
        } else {
          paramLong.action = ((Cursor)localObject).getString(i3);
        }
        if (((Cursor)localObject).isNull(i4)) {
          paramLong.content = null;
        } else {
          paramLong.content = ((Cursor)localObject).getString(i4);
        }
        if (((Cursor)localObject).isNull(i5)) {
          paramLong.title = null;
        } else {
          paramLong.title = ((Cursor)localObject).getString(i5);
        }
        if (((Cursor)localObject).isNull(i6)) {
          paramLong.extra = null;
        } else {
          paramLong.extra = ((Cursor)localObject).getString(i6);
        }
        paramLong.format = ((byte)((Cursor)localObject).getShort(i7));
        if (((Cursor)localObject).isNull(i8)) {
          paramLong.state = null;
        } else {
          paramLong.state = Byte.valueOf((byte)((Cursor)localObject).getShort(i8));
        }
        paramLong.direction = ((byte)((Cursor)localObject).getShort(i9));
        if (((Cursor)localObject).isNull(i10)) {
          paramLong.createTime = null;
        } else {
          paramLong.createTime = Long.valueOf(((Cursor)localObject).getLong(i10));
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
  
  public List<Message> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_message where `action` = ? order by create_time desc", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    paramString = o1.c.b(this.a, locall, false, null);
    label572:
    for (;;)
    {
      try
      {
        int n = b.e(paramString, "id");
        int i2 = b.e(paramString, "session_id");
        int i3 = b.e(paramString, "sender");
        int i4 = b.e(paramString, "receiver");
        int i5 = b.e(paramString, "action");
        int i6 = b.e(paramString, "content");
        int i7 = b.e(paramString, "title");
        int i8 = b.e(paramString, "extra");
        int i9 = b.e(paramString, "format");
        int i10 = b.e(paramString, "state");
        int i1 = b.e(paramString, "direction");
        int m = b.e(paramString, "create_time");
        ArrayList localArrayList = new ArrayList(paramString.getCount());
        if (paramString.moveToNext())
        {
          Message localMessage = new Message();
          localMessage.id = paramString.getLong(n);
          if (paramString.isNull(i2)) {
            localMessage.sessionId = null;
          } else {
            localMessage.sessionId = Long.valueOf(paramString.getLong(i2));
          }
          if (paramString.isNull(i3)) {
            localMessage.sender = null;
          } else {
            localMessage.sender = Long.valueOf(paramString.getLong(i3));
          }
          if (paramString.isNull(i4)) {
            localMessage.receiver = null;
          } else {
            localMessage.receiver = Long.valueOf(paramString.getLong(i4));
          }
          if (paramString.isNull(i5)) {
            localMessage.action = null;
          } else {
            localMessage.action = paramString.getString(i5);
          }
          if (paramString.isNull(i6)) {
            localMessage.content = null;
          } else {
            localMessage.content = paramString.getString(i6);
          }
          if (paramString.isNull(i7)) {
            localMessage.title = null;
          } else {
            localMessage.title = paramString.getString(i7);
          }
          if (paramString.isNull(i8)) {
            localMessage.extra = null;
          } else {
            localMessage.extra = paramString.getString(i8);
          }
          localMessage.format = ((byte)paramString.getShort(i9));
          if (paramString.isNull(i10))
          {
            localMessage.state = null;
          }
          else
          {
            localMessage.state = Byte.valueOf((byte)paramString.getShort(i10));
            break label572;
            localMessage.direction = ((byte)paramString.getShort(i1));
            if (paramString.isNull(m)) {
              localMessage.createTime = null;
            } else {
              localMessage.createTime = Long.valueOf(paramString.getLong(m));
            }
            localArrayList.add(localMessage);
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
    }
  }
  
  public List<Message> e(long paramLong)
  {
    Object localObject1 = l.h("select * from t_hoxin_message where session_id = ? order by create_time desc", 1);
    ((l)localObject1).O(1, paramLong);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject1, false, null);
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject4;
      try
      {
        int m = b.e(localCursor, "id");
        localObject2 = localObject1;
        int n = b.e(localCursor, "session_id");
        localObject2 = localObject1;
        int i1 = b.e(localCursor, "sender");
        localObject2 = localObject1;
        int i2 = b.e(localCursor, "receiver");
        localObject2 = localObject1;
        int i3 = b.e(localCursor, "action");
        localObject2 = localObject1;
        int i4 = b.e(localCursor, "content");
        localObject2 = localObject1;
        int i5 = b.e(localCursor, "title");
        localObject2 = localObject1;
        int i6 = b.e(localCursor, "extra");
        localObject2 = localObject1;
        int i7 = b.e(localCursor, "format");
        localObject2 = localObject1;
        int i8 = b.e(localCursor, "state");
        localObject2 = localObject1;
        int i9 = b.e(localCursor, "direction");
        localObject2 = localObject1;
        int i10 = b.e(localCursor, "create_time");
        localObject2 = localObject1;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        localObject2 = localObject1;
        if (localCursor.moveToNext())
        {
          localObject2 = localObject1;
          Message localMessage = new Message();
          try
          {
            localMessage.id = localCursor.getLong(m);
            if (localCursor.isNull(n)) {
              localMessage.sessionId = null;
            } else {
              localMessage.sessionId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              localMessage.sender = null;
            } else {
              localMessage.sender = Long.valueOf(localCursor.getLong(i1));
            }
            if (localCursor.isNull(i2)) {
              localMessage.receiver = null;
            } else {
              localMessage.receiver = Long.valueOf(localCursor.getLong(i2));
            }
            if (localCursor.isNull(i3)) {
              localMessage.action = null;
            } else {
              localMessage.action = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              localMessage.content = null;
            } else {
              localMessage.content = localCursor.getString(i4);
            }
            if (localCursor.isNull(i5)) {
              localMessage.title = null;
            } else {
              localMessage.title = localCursor.getString(i5);
            }
            if (localCursor.isNull(i6)) {
              localMessage.extra = null;
            } else {
              localMessage.extra = localCursor.getString(i6);
            }
            localMessage.format = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              localMessage.state = null;
            } else {
              localMessage.state = Byte.valueOf((byte)localCursor.getShort(i8));
            }
            localMessage.direction = ((byte)localCursor.getShort(i9));
            if (localCursor.isNull(i10)) {
              localMessage.createTime = null;
            } else {
              localMessage.createTime = Long.valueOf(localCursor.getLong(i10));
            }
          }
          finally
          {
            continue;
          }
          localArrayList.add(localMessage);
        }
        else
        {
          localCursor.close();
          ((l)localObject1).d0();
          return localArrayList;
        }
      }
      finally
      {
        localObject1 = localObject3;
        localObject4 = localObject5;
        localCursor.close();
        ((l)localObject1).d0();
      }
    }
  }
  
  public List<Message> f(String[] paramArrayOfString, Byte paramByte, long paramLong)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_message where  `action` in(");
    int i2 = paramArrayOfString.length;
    f.a((StringBuilder)localObject1, i2);
    ((StringBuilder)localObject1).append(") and state =");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" order by create_time desc limit ");
    ((StringBuilder)localObject1).append("?");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i1 = i2 + 2;
    localObject1 = l.h((String)localObject1, i1);
    int i3 = paramArrayOfString.length;
    int m = 0;
    int n = 1;
    Object localObject3;
    while (m < i3)
    {
      localObject3 = paramArrayOfString[m];
      if (localObject3 == null) {
        ((l)localObject1).y(n);
      } else {
        ((l)localObject1).r(n, (String)localObject3);
      }
      n += 1;
      m += 1;
    }
    m = i2 + 1;
    if (paramByte == null) {
      ((l)localObject1).y(m);
    } else {
      ((l)localObject1).O(m, paramByte.byteValue());
    }
    ((l)localObject1).O(i1, paramLong);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject1, false, null);
    paramByte = (Byte)localObject1;
    for (;;)
    {
      try
      {
        m = b.e(localCursor, "id");
        paramByte = (Byte)localObject1;
        n = b.e(localCursor, "session_id");
        paramByte = (Byte)localObject1;
        i1 = b.e(localCursor, "sender");
        paramByte = (Byte)localObject1;
        i2 = b.e(localCursor, "receiver");
        paramByte = (Byte)localObject1;
        i3 = b.e(localCursor, "action");
        paramByte = (Byte)localObject1;
        int i4 = b.e(localCursor, "content");
        paramByte = (Byte)localObject1;
        int i5 = b.e(localCursor, "title");
        paramByte = (Byte)localObject1;
        int i6 = b.e(localCursor, "extra");
        paramByte = (Byte)localObject1;
        int i7 = b.e(localCursor, "format");
        paramByte = (Byte)localObject1;
        int i8 = b.e(localCursor, "state");
        paramByte = (Byte)localObject1;
        int i9 = b.e(localCursor, "direction");
        paramByte = (Byte)localObject1;
        int i10 = b.e(localCursor, "create_time");
        paramByte = (Byte)localObject1;
        localObject3 = new ArrayList(localCursor.getCount());
        paramArrayOfString = (String[])localObject1;
        paramByte = paramArrayOfString;
        if (localCursor.moveToNext())
        {
          paramByte = paramArrayOfString;
          localObject1 = new Message();
          try
          {
            ((Message)localObject1).id = localCursor.getLong(m);
            if (localCursor.isNull(n)) {
              ((Message)localObject1).sessionId = null;
            } else {
              ((Message)localObject1).sessionId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              ((Message)localObject1).sender = null;
            } else {
              ((Message)localObject1).sender = Long.valueOf(localCursor.getLong(i1));
            }
            if (localCursor.isNull(i2)) {
              ((Message)localObject1).receiver = null;
            } else {
              ((Message)localObject1).receiver = Long.valueOf(localCursor.getLong(i2));
            }
            if (localCursor.isNull(i3)) {
              ((Message)localObject1).action = null;
            } else {
              ((Message)localObject1).action = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              ((Message)localObject1).content = null;
            } else {
              ((Message)localObject1).content = localCursor.getString(i4);
            }
            if (localCursor.isNull(i5)) {
              ((Message)localObject1).title = null;
            } else {
              ((Message)localObject1).title = localCursor.getString(i5);
            }
            if (localCursor.isNull(i6)) {
              ((Message)localObject1).extra = null;
            } else {
              ((Message)localObject1).extra = localCursor.getString(i6);
            }
            ((Message)localObject1).format = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              ((Message)localObject1).state = null;
            } else {
              ((Message)localObject1).state = Byte.valueOf((byte)localCursor.getShort(i8));
            }
            ((Message)localObject1).direction = ((byte)localCursor.getShort(i9));
            if (localCursor.isNull(i10)) {
              ((Message)localObject1).createTime = null;
            } else {
              ((Message)localObject1).createTime = Long.valueOf(localCursor.getLong(i10));
            }
          }
          finally
          {
            continue;
          }
          ((List)localObject3).add(localObject1);
        }
        else
        {
          localCursor.close();
          paramArrayOfString.d0();
          return localObject3;
        }
      }
      finally
      {
        paramArrayOfString = paramByte;
        paramByte = localObject2;
        localCursor.close();
        paramArrayOfString.d0();
      }
    }
  }
  
  public void g(Message paramMessage)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramMessage);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public void h(Long paramLong, String paramString1, String paramString2)
  {
    this.a.d();
    k localk = this.k.a();
    if (paramLong == null) {
      localk.y(1);
    } else {
      localk.O(1, paramLong.longValue());
    }
    if (paramString1 == null) {
      localk.y(2);
    } else {
      localk.r(2, paramString1);
    }
    if (paramString2 == null) {
      localk.y(3);
    } else {
      localk.r(3, paramString2);
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
      this.k.f(localk);
    }
  }
  
  public boolean i(long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_message where id = ?", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject1 = this.a;
    boolean bool1 = false;
    localObject1 = o1.c.b((f0)localObject1, locall, false, null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        int m = ((Cursor)localObject1).getInt(0);
        if (m != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    finally
    {
      ((Cursor)localObject1).close();
      locall.d0();
    }
  }
  
  public List<Message> j(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject1 = l.h("select * from t_hoxin_message where session_id = ? order by create_time desc limit ?, ?", 3);
    ((l)localObject1).O(1, paramLong1);
    ((l)localObject1).O(2, paramLong2);
    ((l)localObject1).O(3, paramLong3);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject1, false, null);
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject4;
      try
      {
        int m = b.e(localCursor, "id");
        localObject2 = localObject1;
        int n = b.e(localCursor, "session_id");
        localObject2 = localObject1;
        int i1 = b.e(localCursor, "sender");
        localObject2 = localObject1;
        int i2 = b.e(localCursor, "receiver");
        localObject2 = localObject1;
        int i3 = b.e(localCursor, "action");
        localObject2 = localObject1;
        int i4 = b.e(localCursor, "content");
        localObject2 = localObject1;
        int i5 = b.e(localCursor, "title");
        localObject2 = localObject1;
        int i6 = b.e(localCursor, "extra");
        localObject2 = localObject1;
        int i7 = b.e(localCursor, "format");
        localObject2 = localObject1;
        int i8 = b.e(localCursor, "state");
        localObject2 = localObject1;
        int i9 = b.e(localCursor, "direction");
        localObject2 = localObject1;
        int i10 = b.e(localCursor, "create_time");
        localObject2 = localObject1;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        localObject2 = localObject1;
        if (localCursor.moveToNext())
        {
          localObject2 = localObject1;
          Message localMessage = new Message();
          try
          {
            localMessage.id = localCursor.getLong(m);
            if (localCursor.isNull(n)) {
              localMessage.sessionId = null;
            } else {
              localMessage.sessionId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              localMessage.sender = null;
            } else {
              localMessage.sender = Long.valueOf(localCursor.getLong(i1));
            }
            if (localCursor.isNull(i2)) {
              localMessage.receiver = null;
            } else {
              localMessage.receiver = Long.valueOf(localCursor.getLong(i2));
            }
            if (localCursor.isNull(i3)) {
              localMessage.action = null;
            } else {
              localMessage.action = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              localMessage.content = null;
            } else {
              localMessage.content = localCursor.getString(i4);
            }
            if (localCursor.isNull(i5)) {
              localMessage.title = null;
            } else {
              localMessage.title = localCursor.getString(i5);
            }
            if (localCursor.isNull(i6)) {
              localMessage.extra = null;
            } else {
              localMessage.extra = localCursor.getString(i6);
            }
            localMessage.format = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              localMessage.state = null;
            } else {
              localMessage.state = Byte.valueOf((byte)localCursor.getShort(i8));
            }
            localMessage.direction = ((byte)localCursor.getShort(i9));
            if (localCursor.isNull(i10)) {
              localMessage.createTime = null;
            } else {
              localMessage.createTime = Long.valueOf(localCursor.getLong(i10));
            }
          }
          finally
          {
            continue;
          }
          localArrayList.add(localMessage);
        }
        else
        {
          localCursor.close();
          ((l)localObject1).d0();
          return localArrayList;
        }
      }
      finally
      {
        localObject1 = localObject3;
        localObject4 = localObject5;
        localCursor.close();
        ((l)localObject1).d0();
      }
    }
  }
  
  public void k(Long paramLong, Byte paramByte)
  {
    this.a.d();
    k localk = this.d.a();
    if (paramByte == null) {
      localk.y(1);
    } else {
      localk.O(1, paramByte.byteValue());
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
  
  public void l(Long paramLong, String paramString, Byte paramByte)
  {
    this.a.d();
    k localk = this.e.a();
    if (paramByte == null) {
      localk.y(1);
    } else {
      localk.O(1, paramByte.byteValue());
    }
    if (paramLong == null) {
      localk.y(2);
    } else {
      localk.O(2, paramLong.longValue());
    }
    if (paramString == null) {
      localk.y(3);
    } else {
      localk.r(3, paramString);
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
  
  public void m(Long paramLong1, Long paramLong2)
  {
    this.a.d();
    k localk = this.g.a();
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
      this.g.f(localk);
    }
  }
  
  public Message n(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_message where session_id = ? order by create_time desc limit 1", 1);
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
      int m = b.e((Cursor)localObject, "id");
      int n = b.e((Cursor)localObject, "session_id");
      int i1 = b.e((Cursor)localObject, "sender");
      int i2 = b.e((Cursor)localObject, "receiver");
      int i3 = b.e((Cursor)localObject, "action");
      int i4 = b.e((Cursor)localObject, "content");
      int i5 = b.e((Cursor)localObject, "title");
      int i6 = b.e((Cursor)localObject, "extra");
      int i7 = b.e((Cursor)localObject, "format");
      int i8 = b.e((Cursor)localObject, "state");
      int i9 = b.e((Cursor)localObject, "direction");
      int i10 = b.e((Cursor)localObject, "create_time");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new Message();
        paramLong.id = ((Cursor)localObject).getLong(m);
        if (((Cursor)localObject).isNull(n)) {
          paramLong.sessionId = null;
        } else {
          paramLong.sessionId = Long.valueOf(((Cursor)localObject).getLong(n));
        }
        if (((Cursor)localObject).isNull(i1)) {
          paramLong.sender = null;
        } else {
          paramLong.sender = Long.valueOf(((Cursor)localObject).getLong(i1));
        }
        if (((Cursor)localObject).isNull(i2)) {
          paramLong.receiver = null;
        } else {
          paramLong.receiver = Long.valueOf(((Cursor)localObject).getLong(i2));
        }
        if (((Cursor)localObject).isNull(i3)) {
          paramLong.action = null;
        } else {
          paramLong.action = ((Cursor)localObject).getString(i3);
        }
        if (((Cursor)localObject).isNull(i4)) {
          paramLong.content = null;
        } else {
          paramLong.content = ((Cursor)localObject).getString(i4);
        }
        if (((Cursor)localObject).isNull(i5)) {
          paramLong.title = null;
        } else {
          paramLong.title = ((Cursor)localObject).getString(i5);
        }
        if (((Cursor)localObject).isNull(i6)) {
          paramLong.extra = null;
        } else {
          paramLong.extra = ((Cursor)localObject).getString(i6);
        }
        paramLong.format = ((byte)((Cursor)localObject).getShort(i7));
        if (((Cursor)localObject).isNull(i8)) {
          paramLong.state = null;
        } else {
          paramLong.state = Byte.valueOf((byte)((Cursor)localObject).getShort(i8));
        }
        paramLong.direction = ((byte)((Cursor)localObject).getShort(i9));
        if (((Cursor)localObject).isNull(i10)) {
          paramLong.createTime = null;
        } else {
          paramLong.createTime = Long.valueOf(((Cursor)localObject).getLong(i10));
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
  
  public List<Message> o(long paramLong1, long paramLong2)
  {
    Object localObject1 = l.h("select * from t_hoxin_message where session_id = ? and id >= ? order by create_time desc", 2);
    ((l)localObject1).O(1, paramLong1);
    ((l)localObject1).O(2, paramLong2);
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject1, false, null);
    Object localObject2 = localObject1;
    for (;;)
    {
      Object localObject4;
      try
      {
        int m = b.e(localCursor, "id");
        localObject2 = localObject1;
        int n = b.e(localCursor, "session_id");
        localObject2 = localObject1;
        int i1 = b.e(localCursor, "sender");
        localObject2 = localObject1;
        int i2 = b.e(localCursor, "receiver");
        localObject2 = localObject1;
        int i3 = b.e(localCursor, "action");
        localObject2 = localObject1;
        int i4 = b.e(localCursor, "content");
        localObject2 = localObject1;
        int i5 = b.e(localCursor, "title");
        localObject2 = localObject1;
        int i6 = b.e(localCursor, "extra");
        localObject2 = localObject1;
        int i7 = b.e(localCursor, "format");
        localObject2 = localObject1;
        int i8 = b.e(localCursor, "state");
        localObject2 = localObject1;
        int i9 = b.e(localCursor, "direction");
        localObject2 = localObject1;
        int i10 = b.e(localCursor, "create_time");
        localObject2 = localObject1;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        localObject2 = localObject1;
        if (localCursor.moveToNext())
        {
          localObject2 = localObject1;
          Message localMessage = new Message();
          try
          {
            localMessage.id = localCursor.getLong(m);
            if (localCursor.isNull(n)) {
              localMessage.sessionId = null;
            } else {
              localMessage.sessionId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              localMessage.sender = null;
            } else {
              localMessage.sender = Long.valueOf(localCursor.getLong(i1));
            }
            if (localCursor.isNull(i2)) {
              localMessage.receiver = null;
            } else {
              localMessage.receiver = Long.valueOf(localCursor.getLong(i2));
            }
            if (localCursor.isNull(i3)) {
              localMessage.action = null;
            } else {
              localMessage.action = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              localMessage.content = null;
            } else {
              localMessage.content = localCursor.getString(i4);
            }
            if (localCursor.isNull(i5)) {
              localMessage.title = null;
            } else {
              localMessage.title = localCursor.getString(i5);
            }
            if (localCursor.isNull(i6)) {
              localMessage.extra = null;
            } else {
              localMessage.extra = localCursor.getString(i6);
            }
            localMessage.format = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              localMessage.state = null;
            } else {
              localMessage.state = Byte.valueOf((byte)localCursor.getShort(i8));
            }
            localMessage.direction = ((byte)localCursor.getShort(i9));
            if (localCursor.isNull(i10)) {
              localMessage.createTime = null;
            } else {
              localMessage.createTime = Long.valueOf(localCursor.getLong(i10));
            }
          }
          finally
          {
            continue;
          }
          localArrayList.add(localMessage);
        }
        else
        {
          localCursor.close();
          ((l)localObject1).d0();
          return localArrayList;
        }
      }
      finally
      {
        localObject1 = localObject3;
        localObject4 = localObject5;
        localCursor.close();
        ((l)localObject1).d0();
      }
    }
  }
  
  public Message p(String paramString)
  {
    l locall = l.h("select * from t_hoxin_message where  `action` =? order by create_time desc limit 1", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    Object localObject = this.a;
    paramString = null;
    localObject = o1.c.b((f0)localObject, locall, false, null);
    try
    {
      int m = b.e((Cursor)localObject, "id");
      int n = b.e((Cursor)localObject, "session_id");
      int i1 = b.e((Cursor)localObject, "sender");
      int i2 = b.e((Cursor)localObject, "receiver");
      int i3 = b.e((Cursor)localObject, "action");
      int i4 = b.e((Cursor)localObject, "content");
      int i5 = b.e((Cursor)localObject, "title");
      int i6 = b.e((Cursor)localObject, "extra");
      int i7 = b.e((Cursor)localObject, "format");
      int i8 = b.e((Cursor)localObject, "state");
      int i9 = b.e((Cursor)localObject, "direction");
      int i10 = b.e((Cursor)localObject, "create_time");
      if (((Cursor)localObject).moveToFirst())
      {
        paramString = new Message();
        paramString.id = ((Cursor)localObject).getLong(m);
        if (((Cursor)localObject).isNull(n)) {
          paramString.sessionId = null;
        } else {
          paramString.sessionId = Long.valueOf(((Cursor)localObject).getLong(n));
        }
        if (((Cursor)localObject).isNull(i1)) {
          paramString.sender = null;
        } else {
          paramString.sender = Long.valueOf(((Cursor)localObject).getLong(i1));
        }
        if (((Cursor)localObject).isNull(i2)) {
          paramString.receiver = null;
        } else {
          paramString.receiver = Long.valueOf(((Cursor)localObject).getLong(i2));
        }
        if (((Cursor)localObject).isNull(i3)) {
          paramString.action = null;
        } else {
          paramString.action = ((Cursor)localObject).getString(i3);
        }
        if (((Cursor)localObject).isNull(i4)) {
          paramString.content = null;
        } else {
          paramString.content = ((Cursor)localObject).getString(i4);
        }
        if (((Cursor)localObject).isNull(i5)) {
          paramString.title = null;
        } else {
          paramString.title = ((Cursor)localObject).getString(i5);
        }
        if (((Cursor)localObject).isNull(i6)) {
          paramString.extra = null;
        } else {
          paramString.extra = ((Cursor)localObject).getString(i6);
        }
        paramString.format = ((byte)((Cursor)localObject).getShort(i7));
        if (((Cursor)localObject).isNull(i8)) {
          paramString.state = null;
        } else {
          paramString.state = Byte.valueOf((byte)((Cursor)localObject).getShort(i8));
        }
        paramString.direction = ((byte)((Cursor)localObject).getShort(i9));
        if (((Cursor)localObject).isNull(i10)) {
          paramString.createTime = null;
        } else {
          paramString.createTime = Long.valueOf(((Cursor)localObject).getLong(i10));
        }
      }
      return paramString;
    }
    finally
    {
      ((Cursor)localObject).close();
      locall.d0();
    }
  }
  
  public List<MessageSearchHit> q(String[] paramArrayOfString, byte paramByte, String paramString, int[] paramArrayOfInt)
  {
    Object localObject = f.b();
    ((StringBuilder)localObject).append("select session_id,count(session_id) as count,max(create_time) as timestamp from t_hoxin_message where `action` in(");
    int n = paramArrayOfString.length;
    f.a((StringBuilder)localObject, n);
    ((StringBuilder)localObject).append(") and format = ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and content like ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and state not in(");
    int m = paramArrayOfInt.length;
    f.a((StringBuilder)localObject, m);
    ((StringBuilder)localObject).append(") group by session_id order by timestamp desc");
    localObject = ((StringBuilder)localObject).toString();
    int i1 = n + 2;
    localObject = l.h((String)localObject, m + i1);
    int i2 = paramArrayOfString.length;
    m = 0;
    byte b1 = 1;
    while (m < i2)
    {
      String str = paramArrayOfString[m];
      if (str == null) {
        ((l)localObject).y(b1);
      } else {
        ((l)localObject).r(b1, str);
      }
      b1 += 1;
      m += 1;
    }
    ((l)localObject).O(n + 1, paramByte);
    if (paramString == null) {
      ((l)localObject).y(i1);
    } else {
      ((l)localObject).r(i1, paramString);
    }
    m = n + 3;
    b1 = paramArrayOfInt.length;
    paramByte = 0;
    while (paramByte < b1)
    {
      ((l)localObject).O(m, paramArrayOfInt[paramByte]);
      m += 1;
      paramByte += 1;
    }
    this.a.d();
    paramArrayOfString = o1.c.b(this.a, (j)localObject, false, null);
    try
    {
      paramString = new ArrayList(paramArrayOfString.getCount());
      while (paramArrayOfString.moveToNext())
      {
        paramArrayOfInt = new MessageSearchHit();
        paramArrayOfInt.sessionId = paramArrayOfString.getLong(0);
        paramArrayOfInt.count = paramArrayOfString.getLong(1);
        paramArrayOfInt.timestamp = paramArrayOfString.getLong(2);
        paramString.add(paramArrayOfInt);
      }
      return paramString;
    }
    finally
    {
      paramArrayOfString.close();
      ((l)localObject).d0();
    }
  }
  
  public Message r(long paramLong1, long paramLong2)
  {
    l locall = l.h("select * from t_hoxin_message where session_id = ? and create_time >= ? order by create_time limit 1", 2);
    locall.O(1, paramLong1);
    locall.O(2, paramLong2);
    this.a.d();
    Object localObject2 = this.a;
    Message localMessage = null;
    localObject2 = o1.c.b((f0)localObject2, locall, false, null);
    try
    {
      int m = b.e((Cursor)localObject2, "id");
      int n = b.e((Cursor)localObject2, "session_id");
      int i1 = b.e((Cursor)localObject2, "sender");
      int i2 = b.e((Cursor)localObject2, "receiver");
      int i3 = b.e((Cursor)localObject2, "action");
      int i4 = b.e((Cursor)localObject2, "content");
      int i5 = b.e((Cursor)localObject2, "title");
      int i6 = b.e((Cursor)localObject2, "extra");
      int i7 = b.e((Cursor)localObject2, "format");
      int i8 = b.e((Cursor)localObject2, "state");
      int i9 = b.e((Cursor)localObject2, "direction");
      int i10 = b.e((Cursor)localObject2, "create_time");
      if (((Cursor)localObject2).moveToFirst())
      {
        localMessage = new Message();
        localMessage.id = ((Cursor)localObject2).getLong(m);
        if (((Cursor)localObject2).isNull(n)) {
          localMessage.sessionId = null;
        } else {
          localMessage.sessionId = Long.valueOf(((Cursor)localObject2).getLong(n));
        }
        if (((Cursor)localObject2).isNull(i1)) {
          localMessage.sender = null;
        } else {
          localMessage.sender = Long.valueOf(((Cursor)localObject2).getLong(i1));
        }
        if (((Cursor)localObject2).isNull(i2)) {
          localMessage.receiver = null;
        } else {
          localMessage.receiver = Long.valueOf(((Cursor)localObject2).getLong(i2));
        }
        if (((Cursor)localObject2).isNull(i3)) {
          localMessage.action = null;
        } else {
          localMessage.action = ((Cursor)localObject2).getString(i3);
        }
        if (((Cursor)localObject2).isNull(i4)) {
          localMessage.content = null;
        } else {
          localMessage.content = ((Cursor)localObject2).getString(i4);
        }
        if (((Cursor)localObject2).isNull(i5)) {
          localMessage.title = null;
        } else {
          localMessage.title = ((Cursor)localObject2).getString(i5);
        }
        if (((Cursor)localObject2).isNull(i6)) {
          localMessage.extra = null;
        } else {
          localMessage.extra = ((Cursor)localObject2).getString(i6);
        }
        localMessage.format = ((byte)((Cursor)localObject2).getShort(i7));
        if (((Cursor)localObject2).isNull(i8)) {
          localMessage.state = null;
        } else {
          localMessage.state = Byte.valueOf((byte)((Cursor)localObject2).getShort(i8));
        }
        localMessage.direction = ((byte)((Cursor)localObject2).getShort(i9));
        if (((Cursor)localObject2).isNull(i10)) {
          localMessage.createTime = null;
        } else {
          localMessage.createTime = Long.valueOf(((Cursor)localObject2).getLong(i10));
        }
      }
      return localMessage;
    }
    finally
    {
      ((Cursor)localObject2).close();
      locall.d0();
    }
  }
  
  public void s(String paramString)
  {
    this.a.d();
    k localk = this.i.a();
    if (paramString == null) {
      localk.y(1);
    } else {
      localk.r(1, paramString);
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
      this.i.f(localk);
    }
  }
  
  public void t(List<Long> paramList)
  {
    this.a.d();
    Object localObject = f.b();
    ((StringBuilder)localObject).append("delete from t_hoxin_message where session_id  in(");
    f.a((StringBuilder)localObject, paramList.size());
    ((StringBuilder)localObject).append(")");
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.a.g((String)localObject);
    paramList = paramList.iterator();
    int m = 1;
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      if (localLong == null) {
        ((i)localObject).y(m);
      } else {
        ((i)localObject).O(m, localLong.longValue());
      }
      m += 1;
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
  
  public List<Message> u(long paramLong, byte paramByte, String paramString, int[] paramArrayOfInt)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_message where session_id = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and format = ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and content like ");
    ((StringBuilder)localObject1).append("?");
    ((StringBuilder)localObject1).append(" and state not in(");
    int m = paramArrayOfInt.length;
    f.a((StringBuilder)localObject1, m);
    ((StringBuilder)localObject1).append(")  order by create_time desc");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), m + 3);
    ((l)localObject1).O(1, paramLong);
    ((l)localObject1).O(2, paramByte);
    if (paramString == null) {
      ((l)localObject1).y(3);
    } else {
      ((l)localObject1).r(3, paramString);
    }
    m = 4;
    byte b1 = paramArrayOfInt.length;
    paramByte = 0;
    while (paramByte < b1)
    {
      ((l)localObject1).O(m, paramArrayOfInt[paramByte]);
      m += 1;
      paramByte += 1;
    }
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject1, false, null);
    paramArrayOfInt = (int[])localObject1;
    for (;;)
    {
      try
      {
        paramByte = b.e(localCursor, "id");
        paramArrayOfInt = (int[])localObject1;
        m = b.e(localCursor, "session_id");
        paramArrayOfInt = (int[])localObject1;
        b1 = b.e(localCursor, "sender");
        paramArrayOfInt = (int[])localObject1;
        int n = b.e(localCursor, "receiver");
        paramArrayOfInt = (int[])localObject1;
        int i1 = b.e(localCursor, "action");
        paramArrayOfInt = (int[])localObject1;
        int i2 = b.e(localCursor, "content");
        paramArrayOfInt = (int[])localObject1;
        int i3 = b.e(localCursor, "title");
        paramArrayOfInt = (int[])localObject1;
        int i4 = b.e(localCursor, "extra");
        paramArrayOfInt = (int[])localObject1;
        int i5 = b.e(localCursor, "format");
        paramArrayOfInt = (int[])localObject1;
        int i6 = b.e(localCursor, "state");
        paramArrayOfInt = (int[])localObject1;
        int i7 = b.e(localCursor, "direction");
        paramArrayOfInt = (int[])localObject1;
        int i8 = b.e(localCursor, "create_time");
        paramArrayOfInt = (int[])localObject1;
        Object localObject3 = new ArrayList(localCursor.getCount());
        paramString = (String)localObject1;
        localObject1 = localObject3;
        paramArrayOfInt = paramString;
        if (localCursor.moveToNext())
        {
          paramArrayOfInt = paramString;
          localObject3 = new Message();
          try
          {
            ((Message)localObject3).id = localCursor.getLong(paramByte);
            if (localCursor.isNull(m)) {
              ((Message)localObject3).sessionId = null;
            } else {
              ((Message)localObject3).sessionId = Long.valueOf(localCursor.getLong(m));
            }
            if (localCursor.isNull(b1)) {
              ((Message)localObject3).sender = null;
            } else {
              ((Message)localObject3).sender = Long.valueOf(localCursor.getLong(b1));
            }
            if (localCursor.isNull(n)) {
              ((Message)localObject3).receiver = null;
            } else {
              ((Message)localObject3).receiver = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              ((Message)localObject3).action = null;
            } else {
              ((Message)localObject3).action = localCursor.getString(i1);
            }
            if (localCursor.isNull(i2)) {
              ((Message)localObject3).content = null;
            } else {
              ((Message)localObject3).content = localCursor.getString(i2);
            }
            if (localCursor.isNull(i3)) {
              ((Message)localObject3).title = null;
            } else {
              ((Message)localObject3).title = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              ((Message)localObject3).extra = null;
            } else {
              ((Message)localObject3).extra = localCursor.getString(i4);
            }
            ((Message)localObject3).format = ((byte)localCursor.getShort(i5));
            if (localCursor.isNull(i6)) {
              ((Message)localObject3).state = null;
            } else {
              ((Message)localObject3).state = Byte.valueOf((byte)localCursor.getShort(i6));
            }
            ((Message)localObject3).direction = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              ((Message)localObject3).createTime = null;
            } else {
              ((Message)localObject3).createTime = Long.valueOf(localCursor.getLong(i8));
            }
          }
          finally
          {
            continue;
          }
          ((List)localObject1).add(localObject3);
        }
        else
        {
          localCursor.close();
          paramString.d0();
          return localObject1;
        }
      }
      finally
      {
        paramString = paramArrayOfInt;
        paramArrayOfInt = localObject2;
        localCursor.close();
        paramString.d0();
      }
    }
  }
  
  public List<Message> v(String[] paramArrayOfString)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_message where `action` in(");
    int m = paramArrayOfString.length;
    f.a((StringBuilder)localObject1, m);
    ((StringBuilder)localObject1).append(") order by create_time desc");
    Object localObject4 = l.h(((StringBuilder)localObject1).toString(), m + 0);
    int i1 = paramArrayOfString.length;
    int n = 1;
    m = 0;
    while (m < i1)
    {
      localObject1 = paramArrayOfString[m];
      if (localObject1 == null) {
        ((l)localObject4).y(n);
      } else {
        ((l)localObject4).r(n, (String)localObject1);
      }
      n += 1;
      m += 1;
    }
    this.a.d();
    Cursor localCursor = o1.c.b(this.a, (j)localObject4, false, null);
    localObject1 = localObject4;
    for (;;)
    {
      Object localObject3;
      try
      {
        m = b.e(localCursor, "id");
        localObject1 = localObject4;
        n = b.e(localCursor, "session_id");
        localObject1 = localObject4;
        i1 = b.e(localCursor, "sender");
        localObject1 = localObject4;
        int i2 = b.e(localCursor, "receiver");
        localObject1 = localObject4;
        int i3 = b.e(localCursor, "action");
        localObject1 = localObject4;
        int i4 = b.e(localCursor, "content");
        localObject1 = localObject4;
        int i5 = b.e(localCursor, "title");
        localObject1 = localObject4;
        int i6 = b.e(localCursor, "extra");
        localObject1 = localObject4;
        int i7 = b.e(localCursor, "format");
        localObject1 = localObject4;
        int i8 = b.e(localCursor, "state");
        localObject1 = localObject4;
        int i9 = b.e(localCursor, "direction");
        localObject1 = localObject4;
        int i10 = b.e(localCursor, "create_time");
        localObject1 = localObject4;
        ArrayList localArrayList = new ArrayList(localCursor.getCount());
        paramArrayOfString = (String[])localObject4;
        localObject1 = paramArrayOfString;
        if (localCursor.moveToNext())
        {
          localObject1 = paramArrayOfString;
          localObject4 = new Message();
          try
          {
            ((Message)localObject4).id = localCursor.getLong(m);
            if (localCursor.isNull(n)) {
              ((Message)localObject4).sessionId = null;
            } else {
              ((Message)localObject4).sessionId = Long.valueOf(localCursor.getLong(n));
            }
            if (localCursor.isNull(i1)) {
              ((Message)localObject4).sender = null;
            } else {
              ((Message)localObject4).sender = Long.valueOf(localCursor.getLong(i1));
            }
            if (localCursor.isNull(i2)) {
              ((Message)localObject4).receiver = null;
            } else {
              ((Message)localObject4).receiver = Long.valueOf(localCursor.getLong(i2));
            }
            if (localCursor.isNull(i3)) {
              ((Message)localObject4).action = null;
            } else {
              ((Message)localObject4).action = localCursor.getString(i3);
            }
            if (localCursor.isNull(i4)) {
              ((Message)localObject4).content = null;
            } else {
              ((Message)localObject4).content = localCursor.getString(i4);
            }
            if (localCursor.isNull(i5)) {
              ((Message)localObject4).title = null;
            } else {
              ((Message)localObject4).title = localCursor.getString(i5);
            }
            if (localCursor.isNull(i6)) {
              ((Message)localObject4).extra = null;
            } else {
              ((Message)localObject4).extra = localCursor.getString(i6);
            }
            ((Message)localObject4).format = ((byte)localCursor.getShort(i7));
            if (localCursor.isNull(i8)) {
              ((Message)localObject4).state = null;
            } else {
              ((Message)localObject4).state = Byte.valueOf((byte)localCursor.getShort(i8));
            }
            ((Message)localObject4).direction = ((byte)localCursor.getShort(i9));
            if (localCursor.isNull(i10)) {
              ((Message)localObject4).createTime = null;
            } else {
              ((Message)localObject4).createTime = Long.valueOf(localCursor.getLong(i10));
            }
          }
          finally
          {
            continue;
          }
          localArrayList.add(localObject4);
        }
        else
        {
          localCursor.close();
          paramArrayOfString.d0();
          return localArrayList;
        }
      }
      finally
      {
        paramArrayOfString = localObject2;
        localObject3 = localObject5;
        localCursor.close();
        paramArrayOfString.d0();
      }
    }
  }
  
  public void w()
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
  
  public int x(String[] paramArrayOfString, byte paramByte)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select count(*) from t_hoxin_message where  `action` in(");
    int m = paramArrayOfString.length;
    f.a((StringBuilder)localObject1, m);
    ((StringBuilder)localObject1).append(") and state = ");
    ((StringBuilder)localObject1).append("?");
    localObject1 = ((StringBuilder)localObject1).toString();
    int n = 1;
    int i1 = m + 1;
    localObject1 = l.h((String)localObject1, i1);
    int i2 = paramArrayOfString.length;
    byte b1 = 0;
    m = 0;
    while (m < i2)
    {
      String str = paramArrayOfString[m];
      if (str == null) {
        ((l)localObject1).y(n);
      } else {
        ((l)localObject1).r(n, str);
      }
      n += 1;
      m += 1;
    }
    ((l)localObject1).O(i1, paramByte);
    this.a.d();
    paramArrayOfString = o1.c.b(this.a, (j)localObject1, false, null);
    paramByte = b1;
    try
    {
      if (paramArrayOfString.moveToFirst()) {
        paramByte = paramArrayOfString.getInt(0);
      }
      return paramByte;
    }
    finally
    {
      paramArrayOfString.close();
      ((l)localObject1).d0();
    }
  }
  
  public void y(String paramString, Byte paramByte)
  {
    this.a.d();
    k localk = this.f.a();
    if (paramByte == null) {
      localk.y(1);
    } else {
      localk.O(1, paramByte.byteValue());
    }
    if (paramString == null) {
      localk.y(2);
    } else {
      localk.r(2, paramString);
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
  
  public int z(String paramString, byte paramByte)
  {
    l locall = l.h("select count(*) from t_hoxin_message where  `action` = ? and state = ?", 2);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    locall.O(2, paramByte);
    this.a.d();
    paramString = this.a;
    paramByte = 0;
    paramString = o1.c.b(paramString, locall, false, null);
    try
    {
      if (paramString.moveToFirst()) {
        paramByte = paramString.getInt(0);
      }
      return paramByte;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  class a
    extends m
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_message where sender = ? and `action` = ? and content = ?";
    }
  }
  
  class b
    extends g<Message>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_message` (`id`,`session_id`,`sender`,`receiver`,`action`,`content`,`title`,`extra`,`format`,`state`,`direction`,`create_time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Message paramMessage)
    {
      paramk.O(1, paramMessage.id);
      Object localObject = paramMessage.sessionId;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.O(2, ((Long)localObject).longValue());
      }
      localObject = paramMessage.sender;
      if (localObject == null) {
        paramk.y(3);
      } else {
        paramk.O(3, ((Long)localObject).longValue());
      }
      localObject = paramMessage.receiver;
      if (localObject == null) {
        paramk.y(4);
      } else {
        paramk.O(4, ((Long)localObject).longValue());
      }
      localObject = paramMessage.action;
      if (localObject == null) {
        paramk.y(5);
      } else {
        paramk.r(5, (String)localObject);
      }
      localObject = paramMessage.content;
      if (localObject == null) {
        paramk.y(6);
      } else {
        paramk.r(6, (String)localObject);
      }
      localObject = paramMessage.title;
      if (localObject == null) {
        paramk.y(7);
      } else {
        paramk.r(7, (String)localObject);
      }
      localObject = paramMessage.extra;
      if (localObject == null) {
        paramk.y(8);
      } else {
        paramk.r(8, (String)localObject);
      }
      paramk.O(9, paramMessage.format);
      localObject = paramMessage.state;
      if (localObject == null) {
        paramk.y(10);
      } else {
        paramk.O(10, ((Byte)localObject).byteValue());
      }
      paramk.O(11, paramMessage.direction);
      paramMessage = paramMessage.createTime;
      if (paramMessage == null)
      {
        paramk.y(12);
        return;
      }
      paramk.O(12, paramMessage.longValue());
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
      return "update t_hoxin_message set state = 2 where state = 1";
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
      return "update t_hoxin_message set state = ? where id = ? ";
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
      return "update t_hoxin_message set state = ? where sender = ? and `action` = ? ";
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
      return "update t_hoxin_message set state = ? where `action` = ? and state = 10";
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
      return "update t_hoxin_message set session_id = ? where id = ? ";
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
      return "delete from t_hoxin_message where id = ?";
    }
  }
  
  class i
    extends m
  {
    i(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_message where `action` = ?";
    }
  }
  
  class j
    extends m
  {
    j(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "delete from t_hoxin_message where sender = ? and `action` = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k5.d
 * JD-Core Version:    0.7.0.1
 */