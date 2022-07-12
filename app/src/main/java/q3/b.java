package q3;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.common.entity.Config;
import java.util.Collections;
import java.util.List;
import m1.f;
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
  private final g<Config> b;
  private final f<Config> c;
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
  
  public void a(Config paramConfig)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramConfig);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    l locall = l.h("select value from t_hoxin_config where domain = ? and name = ?", 2);
    if (paramString1 == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString1);
    }
    if (paramString2 == null) {
      locall.y(2);
    } else {
      locall.r(2, paramString2);
    }
    this.a.d();
    paramString1 = this.a;
    paramString2 = null;
    Cursor localCursor = c.b(paramString1, locall, false, null);
    paramString1 = paramString2;
    try
    {
      if (localCursor.moveToFirst()) {
        if (localCursor.isNull(0)) {
          paramString1 = paramString2;
        } else {
          paramString1 = localCursor.getString(0);
        }
      }
      return paramString1;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  class a
    extends g<Config>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_config` (`id`,`name`,`value`,`domain`,`description`) VALUES (?,?,?,?,?)";
    }
    
    public void k(k paramk, Config paramConfig)
    {
      paramk.O(1, paramConfig.id);
      String str = paramConfig.name;
      if (str == null) {
        paramk.y(2);
      } else {
        paramk.r(2, str);
      }
      str = paramConfig.value;
      if (str == null) {
        paramk.y(3);
      } else {
        paramk.r(3, str);
      }
      str = paramConfig.domain;
      if (str == null) {
        paramk.y(4);
      } else {
        paramk.r(4, str);
      }
      paramConfig = paramConfig.description;
      if (paramConfig == null)
      {
        paramk.y(5);
        return;
      }
      paramk.r(5, paramConfig);
    }
  }
  
  class b
    extends f<Config>
  {
    b(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "DELETE FROM `t_hoxin_config` WHERE `id` = ?";
    }
    
    public void i(k paramk, Config paramConfig)
    {
      paramk.O(1, paramConfig.id);
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
      return "delete from t_hoxin_config where domain = ? and name = ?";
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q3.b
 * JD-Core Version:    0.7.0.1
 */