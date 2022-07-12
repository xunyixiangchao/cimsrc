package b4;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import o1.c;
import p1.i;
import p1.k;

public final class b
  implements a
{
  private final f0 a;
  private final g<EmoticonItem> b;
  
  public b(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
  }
  
  public static List<Class<?>> a()
  {
    return Collections.emptyList();
  }
  
  public void b(List<EmoticonItem> paramList)
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
  
  public List<EmoticonItem> e(long paramLong)
  {
    l locall = l.h("select * from t_hoxin_emoticon_item where emoticon_id = ? order by id", 1);
    locall.O(1, paramLong);
    this.a.d();
    Cursor localCursor = c.b(this.a, locall, false, null);
    try
    {
      int i = o1.b.e(localCursor, "id");
      int j = o1.b.e(localCursor, "emoticon_id");
      int k = o1.b.e(localCursor, "name");
      int m = o1.b.e(localCursor, "type");
      ArrayList localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
      {
        EmoticonItem localEmoticonItem = new EmoticonItem();
        if (localCursor.isNull(i)) {
          localEmoticonItem.id = null;
        } else {
          localEmoticonItem.id = Long.valueOf(localCursor.getLong(i));
        }
        if (localCursor.isNull(j)) {
          localEmoticonItem.emoticonId = null;
        } else {
          localEmoticonItem.emoticonId = Long.valueOf(localCursor.getLong(j));
        }
        if (localCursor.isNull(k)) {
          localEmoticonItem.name = null;
        } else {
          localEmoticonItem.name = localCursor.getString(k);
        }
        localEmoticonItem.type = ((byte)localCursor.getShort(m));
        localArrayList.add(localEmoticonItem);
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
    extends g<EmoticonItem>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_emoticon_item` (`id`,`emoticon_id`,`name`,`type`) VALUES (?,?,?,?)";
    }
    
    public void k(k paramk, EmoticonItem paramEmoticonItem)
    {
      Object localObject = paramEmoticonItem.id;
      if (localObject == null) {
        paramk.y(1);
      } else {
        paramk.O(1, ((Long)localObject).longValue());
      }
      localObject = paramEmoticonItem.emoticonId;
      if (localObject == null) {
        paramk.y(2);
      } else {
        paramk.O(2, ((Long)localObject).longValue());
      }
      localObject = paramEmoticonItem.name;
      if (localObject == null) {
        paramk.y(3);
      } else {
        paramk.r(3, (String)localObject);
      }
      paramk.O(4, paramEmoticonItem.type);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b4.b
 * JD-Core Version:    0.7.0.1
 */