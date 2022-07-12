package u3;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.core.app.k;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Location;
import i3.e;

public class d
{
  public static void A(int paramInt)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putInt("KEY_THEME_MODE_%1$s", paramInt).apply();
    androidx.appcompat.app.d.H(paramInt);
  }
  
  public static void B()
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean(String.format("KEY_TIMELINE_MOMENT_LOADED_%1$s", new Object[] { e.o() }), true).apply();
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences localSharedPreferences = HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0);
    int i = localSharedPreferences.getInt(String.format("NEW_GROUP_MESSAGE_COUNT_%1$s", new Object[] { Long.valueOf(paramLong) }), 0);
    localSharedPreferences.edit().putInt(String.format("NEW_GROUP_MESSAGE_COUNT_%1$s", new Object[] { Long.valueOf(paramLong) }), i + 1).apply();
  }
  
  public static boolean b()
  {
    HoxinApplication localHoxinApplication = HoxinApplication.h();
    boolean bool = false;
    long l = localHoxinApplication.getSharedPreferences("CLIENT_CONFIG", 0).getLong("KEY_LAST_LOCATION_TIME", 0L);
    if (System.currentTimeMillis() - l > 300000L) {
      bool = true;
    }
    return bool;
  }
  
  public static void c(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().remove(String.format("NEW_HAS_AT_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) })).apply();
  }
  
  public static void d(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().remove(String.format("NEW_GROUP_MESSAGE_COUNT_%1$s", new Object[] { Long.valueOf(paramLong) })).apply();
  }
  
  public static void e(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().remove(String.format("KEY_BE_REMOVED_FORM_GROUP_%1$s", new Object[] { Long.valueOf(paramLong) })).apply();
  }
  
  public static void f()
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean("KEY_ENABLE_PERSIST_NOTIFICATION", false).apply();
  }
  
  public static void g()
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean("KEY_ENABLE_PERSIST_NOTIFICATION", true).apply();
  }
  
  public static boolean h(String paramString, boolean paramBoolean)
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean(paramString, paramBoolean);
  }
  
  public static Location i()
  {
    String str = HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getString("KEY_LAST_LOCATION", null);
    if (str == null) {
      return null;
    }
    return (Location)l.s0(str, Location.class);
  }
  
  public static boolean j()
  {
    return k.e(HoxinApplication.h()).a();
  }
  
  public static boolean k()
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean("KEY_MESSAGE_VIEW_SWITCH", true);
  }
  
  public static int l(long paramLong)
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getInt(String.format("NEW_GROUP_MESSAGE_COUNT_%1$s", new Object[] { Long.valueOf(paramLong) }), 0);
  }
  
  public static int m()
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getInt("KEY_THEME_MODE_%1$s", -1);
  }
  
  public static int n()
  {
    int i = m();
    if (i == -1) {
      return 2131689878;
    }
    if (i == 2) {
      return 2131689876;
    }
    return 2131689877;
  }
  
  public static boolean o(long paramLong)
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean(String.format("NEW_HAS_AT_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }), false);
  }
  
  public static boolean p(long paramLong)
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean(String.format("NEW_IS_AT_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }), false);
  }
  
  public static boolean q()
  {
    return (Resources.getSystem().getConfiguration().uiMode & 0x30) == 32;
  }
  
  public static boolean r()
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean("KEY_ENABLE_PERSIST_NOTIFICATION", false);
  }
  
  public static boolean s(Object paramObject)
  {
    return "1".equals(HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getString(String.format("IGNORE_GROUP_MESSAGE_%1$s", new Object[] { paramObject }), null));
  }
  
  public static boolean t()
  {
    return HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).getBoolean(String.format("KEY_TIMELINE_MOMENT_LOADED_%1$s", new Object[] { e.o() }), false);
  }
  
  public static void u(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean(String.format("NEW_IS_AT_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }), true).apply();
  }
  
  public static void v(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean(String.format("NEW_HAS_AT_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }), true).apply();
  }
  
  public static void w(long paramLong, boolean paramBoolean)
  {
    Object localObject = HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0);
    if (paramBoolean) {
      localObject = ((SharedPreferences)localObject).edit().putString(String.format("IGNORE_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }), "1");
    } else {
      localObject = ((SharedPreferences)localObject).edit().remove(String.format("IGNORE_GROUP_MESSAGE_%1$s", new Object[] { Long.valueOf(paramLong) }));
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public static void x()
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putLong("KEY_LAST_LOCATION_TIME", System.currentTimeMillis()).apply();
  }
  
  public static void y(String paramString, boolean paramBoolean)
  {
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public static void z(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    HoxinApplication.h().getSharedPreferences("CLIENT_CONFIG", 0).edit().putString("KEY_LAST_LOCATION", l.H0(paramLocation)).apply();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.d
 * JD-Core Version:    0.7.0.1
 */