package j4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.friend.entity.Friend;
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
  private final g<Friend> b;
  private final m c;
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
  
  public static List<Class<?>> a()
  {
    return Collections.emptyList();
  }
  
  public Friend c(Long paramLong)
  {
    l locall = l.h("select * from t_hoxin_friend where id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    Object localObject = this.a;
    paramLong = null;
    localObject = c.b((f0)localObject, locall, false, null);
    try
    {
      int i = o1.b.e((Cursor)localObject, "id");
      int j = o1.b.e((Cursor)localObject, "name");
      int k = o1.b.e((Cursor)localObject, "motto");
      int m = o1.b.e((Cursor)localObject, "gender");
      int n = o1.b.e((Cursor)localObject, "telephone");
      int i1 = o1.b.e((Cursor)localObject, "email");
      int i2 = o1.b.e((Cursor)localObject, "type");
      if (((Cursor)localObject).moveToFirst())
      {
        paramLong = new Friend();
        paramLong.id = ((Cursor)localObject).getLong(i);
        if (((Cursor)localObject).isNull(j)) {
          paramLong.name = null;
        } else {
          paramLong.name = ((Cursor)localObject).getString(j);
        }
        if (((Cursor)localObject).isNull(k)) {
          paramLong.motto = null;
        } else {
          paramLong.motto = ((Cursor)localObject).getString(k);
        }
        if (((Cursor)localObject).isNull(m)) {
          paramLong.gender = null;
        } else {
          paramLong.gender = Byte.valueOf((byte)((Cursor)localObject).getShort(m));
        }
        if (((Cursor)localObject).isNull(n)) {
          paramLong.telephone = null;
        } else {
          paramLong.telephone = ((Cursor)localObject).getString(n);
        }
        if (((Cursor)localObject).isNull(i1)) {
          paramLong.email = null;
        } else {
          paramLong.email = ((Cursor)localObject).getString(i1);
        }
        paramLong.type = ((byte)((Cursor)localObject).getShort(i2));
      }
      return paramLong;
    }
    finally
    {
      ((Cursor)localObject).close();
      locall.d0();
    }
  }
  
  public List<Friend> d(String paramString)
  {
    l locall = l.h("select * from t_hoxin_friend where  name like ? and type != 3", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    paramString = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(paramString, "id");
      int j = o1.b.e(paramString, "name");
      int k = o1.b.e(paramString, "motto");
      int m = o1.b.e(paramString, "gender");
      int n = o1.b.e(paramString, "telephone");
      int i1 = o1.b.e(paramString, "email");
      int i2 = o1.b.e(paramString, "type");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramString.getLong(i);
        if (paramString.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramString.getString(j);
        }
        if (paramString.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramString.getShort(m));
        }
        if (paramString.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramString.getString(n);
        }
        if (paramString.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramString.getString(i1);
        }
        localFriend.type = ((byte)paramString.getShort(i2));
        localArrayList.add(localFriend);
      }
      return localArrayList;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  public List<Friend> e()
  {
    l locall = l.h("select * from t_hoxin_friend where type != 3", 0);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(localCursor, "id");
      int j = o1.b.e(localCursor, "name");
      int k = o1.b.e(localCursor, "motto");
      int m = o1.b.e(localCursor, "gender");
      int n = o1.b.e(localCursor, "telephone");
      int i1 = o1.b.e(localCursor, "email");
      int i2 = o1.b.e(localCursor, "type");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = localCursor.getLong(i);
        if (localCursor.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = localCursor.getString(j);
        }
        if (localCursor.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = localCursor.getString(k);
        }
        if (localCursor.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)localCursor.getShort(m));
        }
        if (localCursor.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = localCursor.getString(n);
        }
        if (localCursor.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = localCursor.getString(i1);
        }
        localFriend.type = ((byte)localCursor.getShort(i2));
        localArrayList.add(localFriend);
      }
      return localArrayList;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public boolean f(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_friend where id = ?", 1);
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
  
  public List<Friend> h(String paramString)
  {
    l locall = l.h("select * from t_hoxin_friend where  name like ? or telephone like ? and type != 3", 2);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    if (paramString == null) {
      locall.y(2);
    } else {
      locall.r(2, paramString);
    }
    this.a.d();
    paramString = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(paramString, "id");
      int j = o1.b.e(paramString, "name");
      int k = o1.b.e(paramString, "motto");
      int m = o1.b.e(paramString, "gender");
      int n = o1.b.e(paramString, "telephone");
      int i1 = o1.b.e(paramString, "email");
      int i2 = o1.b.e(paramString, "type");
      ArrayList localArrayList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramString.getLong(i);
        if (paramString.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramString.getString(j);
        }
        if (paramString.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramString.getShort(m));
        }
        if (paramString.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramString.getString(n);
        }
        if (paramString.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramString.getString(i1);
        }
        localFriend.type = ((byte)paramString.getShort(i2));
        localArrayList.add(localFriend);
      }
      return localArrayList;
    }
    finally
    {
      paramString.close();
      locall.d0();
    }
  }
  
  public List<Friend> i(String paramString, List<Long> paramList)
  {
    Object localObject = f.b();
    ((StringBuilder)localObject).append("select * from t_hoxin_friend where  name like ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and id not in(");
    int i = paramList.size();
    f.a((StringBuilder)localObject, i);
    ((StringBuilder)localObject).append(") and type != 3");
    localObject = l.h(((StringBuilder)localObject).toString(), i + 1);
    if (paramString == null) {
      ((l)localObject).y(1);
    } else {
      ((l)localObject).r(1, paramString);
    }
    i = 2;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (Long)paramString.next();
      if (paramList == null) {
        ((l)localObject).y(i);
      } else {
        ((l)localObject).O(i, paramList.longValue());
      }
      i += 1;
    }
    this.a.d();
    paramString = c.b(this.a, (j)localObject, false, null);
    try
    {
      i = o1.b.e(paramString, "id");
      int j = o1.b.e(paramString, "name");
      int k = o1.b.e(paramString, "motto");
      int m = o1.b.e(paramString, "gender");
      int n = o1.b.e(paramString, "telephone");
      int i1 = o1.b.e(paramString, "email");
      int i2 = o1.b.e(paramString, "type");
      paramList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramString.getLong(i);
        if (paramString.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramString.getString(j);
        }
        if (paramString.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramString.getShort(m));
        }
        if (paramString.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramString.getString(n);
        }
        if (paramString.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramString.getString(i1);
        }
        localFriend.type = ((byte)paramString.getShort(i2));
        paramList.add(localFriend);
      }
      return paramList;
    }
    finally
    {
      paramString.close();
      ((l)localObject).d0();
    }
  }
  
  public List<Friend> j(String paramString, List<Long> paramList)
  {
    Object localObject = f.b();
    ((StringBuilder)localObject).append("select * from t_hoxin_friend where  name like ");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(" and id in(");
    int i = paramList.size();
    f.a((StringBuilder)localObject, i);
    ((StringBuilder)localObject).append(") and type != 3");
    localObject = l.h(((StringBuilder)localObject).toString(), i + 1);
    if (paramString == null) {
      ((l)localObject).y(1);
    } else {
      ((l)localObject).r(1, paramString);
    }
    i = 2;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (Long)paramString.next();
      if (paramList == null) {
        ((l)localObject).y(i);
      } else {
        ((l)localObject).O(i, paramList.longValue());
      }
      i += 1;
    }
    this.a.d();
    paramString = c.b(this.a, (j)localObject, false, null);
    try
    {
      i = o1.b.e(paramString, "id");
      int j = o1.b.e(paramString, "name");
      int k = o1.b.e(paramString, "motto");
      int m = o1.b.e(paramString, "gender");
      int n = o1.b.e(paramString, "telephone");
      int i1 = o1.b.e(paramString, "email");
      int i2 = o1.b.e(paramString, "type");
      paramList = new ArrayList(paramString.getCount());
      while (paramString.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramString.getLong(i);
        if (paramString.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramString.getString(j);
        }
        if (paramString.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramString.getString(k);
        }
        if (paramString.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramString.getShort(m));
        }
        if (paramString.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramString.getString(n);
        }
        if (paramString.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramString.getString(i1);
        }
        localFriend.type = ((byte)paramString.getShort(i2));
        paramList.add(localFriend);
      }
      return paramList;
    }
    finally
    {
      paramString.close();
      ((l)localObject).d0();
    }
  }
  
  public String k(Long paramLong)
  {
    l locall = l.h("select name from t_hoxin_friend where id = ?", 1);
    if (paramLong == null) {
      locall.y(1);
    } else {
      locall.O(1, paramLong.longValue());
    }
    this.a.d();
    paramLong = this.a;
    Object localObject = null;
    Cursor localCursor = c.b(paramLong, locall, false, null);
    paramLong = localObject;
    try
    {
      if (localCursor.moveToFirst()) {
        if (localCursor.isNull(0)) {
          paramLong = localObject;
        } else {
          paramLong = localCursor.getString(0);
        }
      }
      return paramLong;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  public boolean l(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_friend where id = ? and type in( 1,3)", 1);
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
  
  public void m(Long paramLong, String paramString)
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
  
  public void n(Long paramLong, byte paramByte)
  {
    this.a.d();
    k localk = this.e.a();
    localk.O(1, paramByte);
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
      this.e.f(localk);
    }
  }
  
  public boolean o(long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_friend where id = ? and type in( 2,0)", 1);
    locall.O(1, paramLong);
    this.a.d();
    Object localObject1 = this.a;
    boolean bool1 = false;
    localObject1 = c.b((f0)localObject1, locall, false, null);
    try
    {
      if (((Cursor)localObject1).moveToFirst())
      {
        int i = ((Cursor)localObject1).getInt(0);
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
      ((Cursor)localObject1).close();
      locall.d0();
    }
  }
  
  public boolean p(Long paramLong)
  {
    boolean bool2 = true;
    l locall = l.h("select count(*) > 0 from t_hoxin_friend where id = ? and type !=3", 1);
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
  
  public void q(byte paramByte1, byte paramByte2)
  {
    this.a.d();
    k localk = this.f.a();
    localk.O(1, paramByte2);
    localk.O(2, paramByte1);
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
  
  public List<Friend> r(long[] paramArrayOfLong)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_friend where  id in(");
    int i = paramArrayOfLong.length;
    f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and type != 3");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), i + 0);
    int k = paramArrayOfLong.length;
    i = 0;
    int j = 1;
    while (i < k)
    {
      ((l)localObject1).O(j, paramArrayOfLong[i]);
      j += 1;
      i += 1;
    }
    this.a.d();
    paramArrayOfLong = c.b(this.a, (j)localObject1, false, null);
    try
    {
      i = o1.b.e(paramArrayOfLong, "id");
      j = o1.b.e(paramArrayOfLong, "name");
      k = o1.b.e(paramArrayOfLong, "motto");
      int m = o1.b.e(paramArrayOfLong, "gender");
      int n = o1.b.e(paramArrayOfLong, "telephone");
      int i1 = o1.b.e(paramArrayOfLong, "email");
      int i2 = o1.b.e(paramArrayOfLong, "type");
      ArrayList localArrayList = new ArrayList(paramArrayOfLong.getCount());
      while (paramArrayOfLong.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramArrayOfLong.getLong(i);
        if (paramArrayOfLong.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramArrayOfLong.getString(j);
        }
        if (paramArrayOfLong.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramArrayOfLong.getString(k);
        }
        if (paramArrayOfLong.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramArrayOfLong.getShort(m));
        }
        if (paramArrayOfLong.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramArrayOfLong.getString(n);
        }
        if (paramArrayOfLong.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramArrayOfLong.getString(i1);
        }
        localFriend.type = ((byte)paramArrayOfLong.getShort(i2));
        localArrayList.add(localFriend);
      }
      return localArrayList;
    }
    finally
    {
      paramArrayOfLong.close();
      ((l)localObject1).d0();
    }
  }
  
  public List<Friend> s(List<Long> paramList)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_friend where  id not in(");
    int i = paramList.size();
    f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and type != 3");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), i + 0);
    paramList = paramList.iterator();
    i = 1;
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
    try
    {
      i = o1.b.e(paramList, "id");
      int j = o1.b.e(paramList, "name");
      int k = o1.b.e(paramList, "motto");
      int m = o1.b.e(paramList, "gender");
      int n = o1.b.e(paramList, "telephone");
      int i1 = o1.b.e(paramList, "email");
      int i2 = o1.b.e(paramList, "type");
      localObject2 = new ArrayList(paramList.getCount());
      while (paramList.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramList.getLong(i);
        if (paramList.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramList.getString(j);
        }
        if (paramList.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramList.getString(k);
        }
        if (paramList.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramList.getShort(m));
        }
        if (paramList.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramList.getString(n);
        }
        if (paramList.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramList.getString(i1);
        }
        localFriend.type = ((byte)paramList.getShort(i2));
        ((List)localObject2).add(localFriend);
      }
      return localObject2;
    }
    finally
    {
      paramList.close();
      ((l)localObject1).d0();
    }
  }
  
  public List<Friend> t(long[] paramArrayOfLong)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_friend where  id not in(");
    int i = paramArrayOfLong.length;
    f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and type != 3");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), i + 0);
    int k = paramArrayOfLong.length;
    i = 0;
    int j = 1;
    while (i < k)
    {
      ((l)localObject1).O(j, paramArrayOfLong[i]);
      j += 1;
      i += 1;
    }
    this.a.d();
    paramArrayOfLong = c.b(this.a, (j)localObject1, false, null);
    try
    {
      i = o1.b.e(paramArrayOfLong, "id");
      j = o1.b.e(paramArrayOfLong, "name");
      k = o1.b.e(paramArrayOfLong, "motto");
      int m = o1.b.e(paramArrayOfLong, "gender");
      int n = o1.b.e(paramArrayOfLong, "telephone");
      int i1 = o1.b.e(paramArrayOfLong, "email");
      int i2 = o1.b.e(paramArrayOfLong, "type");
      ArrayList localArrayList = new ArrayList(paramArrayOfLong.getCount());
      while (paramArrayOfLong.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramArrayOfLong.getLong(i);
        if (paramArrayOfLong.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramArrayOfLong.getString(j);
        }
        if (paramArrayOfLong.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramArrayOfLong.getString(k);
        }
        if (paramArrayOfLong.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramArrayOfLong.getShort(m));
        }
        if (paramArrayOfLong.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramArrayOfLong.getString(n);
        }
        if (paramArrayOfLong.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramArrayOfLong.getString(i1);
        }
        localFriend.type = ((byte)paramArrayOfLong.getShort(i2));
        localArrayList.add(localFriend);
      }
      return localArrayList;
    }
    finally
    {
      paramArrayOfLong.close();
      ((l)localObject1).d0();
    }
  }
  
  public List<Long> u(byte paramByte)
  {
    l locall = l.h("select id from t_hoxin_friend where type = ?", 1);
    locall.O(1, paramByte);
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
  
  public List<Friend> v(List<Long> paramList)
  {
    Object localObject1 = f.b();
    ((StringBuilder)localObject1).append("select * from t_hoxin_friend where  id in(");
    int i = paramList.size();
    f.a((StringBuilder)localObject1, i);
    ((StringBuilder)localObject1).append(") and type != 3");
    localObject1 = l.h(((StringBuilder)localObject1).toString(), i + 0);
    paramList = paramList.iterator();
    i = 1;
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
    try
    {
      i = o1.b.e(paramList, "id");
      int j = o1.b.e(paramList, "name");
      int k = o1.b.e(paramList, "motto");
      int m = o1.b.e(paramList, "gender");
      int n = o1.b.e(paramList, "telephone");
      int i1 = o1.b.e(paramList, "email");
      int i2 = o1.b.e(paramList, "type");
      localObject2 = new ArrayList(paramList.getCount());
      while (paramList.moveToNext())
      {
        Friend localFriend = new Friend();
        localFriend.id = paramList.getLong(i);
        if (paramList.isNull(j)) {
          localFriend.name = null;
        } else {
          localFriend.name = paramList.getString(j);
        }
        if (paramList.isNull(k)) {
          localFriend.motto = null;
        } else {
          localFriend.motto = paramList.getString(k);
        }
        if (paramList.isNull(m)) {
          localFriend.gender = null;
        } else {
          localFriend.gender = Byte.valueOf((byte)paramList.getShort(m));
        }
        if (paramList.isNull(n)) {
          localFriend.telephone = null;
        } else {
          localFriend.telephone = paramList.getString(n);
        }
        if (paramList.isNull(i1)) {
          localFriend.email = null;
        } else {
          localFriend.email = paramList.getString(i1);
        }
        localFriend.type = ((byte)paramList.getShort(i2));
        ((List)localObject2).add(localFriend);
      }
      return localObject2;
    }
    finally
    {
      paramList.close();
      ((l)localObject1).d0();
    }
  }
  
  public void w(Friend paramFriend)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramFriend);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  class a
    extends g<Friend>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_friend` (`id`,`name`,`motto`,`gender`,`telephone`,`email`,`type`) VALUES (?,?,?,?,?,?,?)";
    }
    
    public void k(k paramk, Friend paramFriend)
    {
      paramk.O(1, paramFriend.id);
      Object localObject = paramFriend.name;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.r(2, (String)localObject);
      }
      localObject = paramFriend.motto;
      if (localObject == null) {
        paramk.y(3);
      } else {
        paramk.r(3, (String)localObject);
      }
      localObject = paramFriend.gender;
      if (localObject == null) {
        paramk.y(4);
      } else {
        paramk.O(4, ((Byte)localObject).byteValue());
      }
      localObject = paramFriend.telephone;
      if (localObject == null) {
        paramk.y(5);
      } else {
        paramk.r(5, (String)localObject);
      }
      localObject = paramFriend.email;
      if (localObject == null) {
        paramk.y(6);
      } else {
        paramk.r(6, (String)localObject);
      }
      paramk.O(7, paramFriend.type);
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
      return "update t_hoxin_friend set name = ? where id = ?";
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
      return "update t_hoxin_friend set motto = ? where id = ?";
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
      return "update t_hoxin_friend set type = ? where id = ?";
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
      return "update t_hoxin_friend set type = ? where type = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j4.b
 * JD-Core Version:    0.7.0.1
 */