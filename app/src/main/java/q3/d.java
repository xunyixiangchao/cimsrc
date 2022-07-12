package q3;

import android.database.Cursor;
import androidx.room.f0;
import com.farsunset.hoxin.common.entity.GlideVersion;
import java.util.Collections;
import java.util.List;
import m1.g;
import m1.l;
import p1.i;
import p1.k;

public final class d
  implements c
{
  private final f0 a;
  private final g<GlideVersion> b;
  
  public d(f0 paramf0)
  {
    this.a = paramf0;
    this.b = new a(paramf0);
  }
  
  public static List<Class<?>> c()
  {
    return Collections.emptyList();
  }
  
  public void a(GlideVersion paramGlideVersion)
  {
    this.a.d();
    this.a.e();
    try
    {
      this.b.i(paramGlideVersion);
      this.a.B();
      return;
    }
    finally
    {
      this.a.j();
    }
  }
  
  public String b(String paramString)
  {
    l locall = l.h("select version from t_hoxin_glide_version where url = ? order by id desc limit 1", 1);
    if (paramString == null) {
      locall.y(1);
    } else {
      locall.r(1, paramString);
    }
    this.a.d();
    paramString = this.a;
    Object localObject = null;
    Cursor localCursor = o1.c.b(paramString, locall, false, null);
    paramString = localObject;
    try
    {
      if (localCursor.moveToFirst()) {
        if (localCursor.isNull(0)) {
          paramString = localObject;
        } else {
          paramString = localCursor.getString(0);
        }
      }
      return paramString;
    }
    finally
    {
      localCursor.close();
      locall.d0();
    }
  }
  
  class a
    extends g<GlideVersion>
  {
    a(f0 paramf0)
    {
      super();
    }
    
    public String d()
    {
      return "INSERT OR REPLACE INTO `t_hoxin_glide_version` (`id`,`url`,`version`) VALUES (nullif(?, 0),?,?)";
    }
    
    public void k(k paramk, GlideVersion paramGlideVersion)
    {
      paramk.O(1, paramGlideVersion.id);
      String str = paramGlideVersion.url;
      if (str == null) {
        paramk.y(2);
      } else {
        paramk.r(2, str);
      }
      paramGlideVersion = paramGlideVersion.version;
      if (paramGlideVersion == null)
      {
        paramk.y(3);
        return;
      }
      paramk.r(3, paramGlideVersion);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q3.d
 * JD-Core Version:    0.7.0.1
 */