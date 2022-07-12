package i3;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.User;
import com.farsunset.hoxin.friend.entity.Friend;
import com.tencent.bugly.crashreport.CrashReport;
import i4.a;
import java.io.File;

public class e
{
  public static void a(User paramUser, String paramString)
  {
    CrashReport.setUserId(String.valueOf(paramUser.id));
    AccountManager localAccountManager = AccountManager.get(HoxinApplication.h());
    Account localAccount = new Account(paramUser.name, HoxinApplication.h().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_USER_ID", String.valueOf(paramUser.id));
    localBundle.putString("KEY_USER_NAME", paramUser.name);
    localBundle.putString("KEY_USER_GENDER", String.valueOf(paramUser.gender));
    localBundle.putString("KEY_USER_MOTTO", paramUser.motto);
    localBundle.putString("KEY_USER_EMAIL", paramUser.email);
    localBundle.putString("KEY_USER_TELEPHONE", paramUser.telephone);
    localAccountManager.addAccountExplicitly(localAccount, paramString, localBundle);
  }
  
  public static void b()
  {
    int i = h();
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().putInt("KEY_ROOM_CALL_MISS_COUNT%1$s", i + 1).apply();
  }
  
  public static void c(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().putBoolean(String.format("KEY_BASE_DATA_LOAD_FINISHED_%1$s", new Object[] { Long.valueOf(paramLong) }), false).apply();
  }
  
  public static void d()
  {
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().remove("KEY_ROOM_CALL_MISS_COUNT%1$s").apply();
  }
  
  public static String e()
  {
    Account localAccount = f();
    if (localAccount == null) {
      return null;
    }
    return AccountManager.get(HoxinApplication.h()).getPassword(localAccount);
  }
  
  private static Account f()
  {
    Account[] arrayOfAccount = AccountManager.get(HoxinApplication.h()).getAccountsByType("com.farsunset.hoxin");
    if (arrayOfAccount.length > 0) {
      return arrayOfAccount[0];
    }
    return null;
  }
  
  public static User g()
  {
    Account localAccount = f();
    AccountManager localAccountManager = AccountManager.get(HoxinApplication.h());
    User localUser = new User();
    localUser.id = Long.parseLong(localAccountManager.getUserData(localAccount, "KEY_USER_ID"));
    localUser.name = localAccountManager.getUserData(localAccount, "KEY_USER_NAME");
    localUser.motto = localAccountManager.getUserData(localAccount, "KEY_USER_MOTTO");
    localUser.email = localAccountManager.getUserData(localAccount, "KEY_USER_EMAIL");
    localUser.telephone = localAccountManager.getUserData(localAccount, "KEY_USER_TELEPHONE");
    return localUser;
  }
  
  public static int h()
  {
    return HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).getInt("KEY_ROOM_CALL_MISS_COUNT%1$s", 0);
  }
  
  public static String i()
  {
    return AccountManager.get(HoxinApplication.h()).getUserData(f(), "KEY_USER_MOTTO");
  }
  
  public static String j()
  {
    return AccountManager.get(HoxinApplication.h()).getUserData(f(), "KEY_USER_NAME");
  }
  
  public static String k(long paramLong)
  {
    String str = a.k(paramLong);
    if (str != null) {
      return str;
    }
    return j();
  }
  
  public static int l()
  {
    return HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).getInt("KEY_PHONE_CALL_STATE", 0);
  }
  
  public static Uri m()
  {
    return Uri.fromFile(new File(HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).getString("KEY_PHOTO_GRAPH_FILE_PATH", null)));
  }
  
  public static String n()
  {
    return AccountManager.get(HoxinApplication.h()).getUserData(f(), "KEY_USER_TELEPHONE");
  }
  
  public static Long o()
  {
    return Long.valueOf(Long.parseLong(AccountManager.get(HoxinApplication.h()).getUserData(f(), "KEY_USER_ID")));
  }
  
  public static boolean p()
  {
    return f() != null;
  }
  
  public static boolean q()
  {
    return (p()) && (e() != null);
  }
  
  public static boolean r(long paramLong)
  {
    return HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).getBoolean(String.format("KEY_BASE_DATA_LOAD_FINISHED_%1$s", new Object[] { Long.valueOf(paramLong) }), false);
  }
  
  public static void s()
  {
    Account localAccount = f();
    if (localAccount == null) {
      return;
    }
    AccountManager.get(HoxinApplication.h()).removeAccountExplicitly(localAccount);
  }
  
  public static void t()
  {
    Account localAccount = f();
    if (localAccount == null) {
      return;
    }
    AccountManager.get(HoxinApplication.h()).clearPassword(localAccount);
  }
  
  public static void u(long paramLong)
  {
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().putBoolean(String.format("KEY_BASE_DATA_LOAD_FINISHED_%1$s", new Object[] { Long.valueOf(paramLong) }), true).apply();
  }
  
  public static void v(String paramString)
  {
    AccountManager.get(HoxinApplication.h()).setUserData(f(), "KEY_USER_MOTTO", paramString);
  }
  
  public static void w(String paramString)
  {
    AccountManager.get(HoxinApplication.h()).setUserData(f(), "KEY_USER_NAME", paramString);
  }
  
  public static void x(int paramInt)
  {
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().putInt("KEY_PHONE_CALL_STATE", paramInt).apply();
  }
  
  public static void y(String paramString)
  {
    HoxinApplication.h().getSharedPreferences("CURRENT_USER", 0).edit().putString("KEY_PHOTO_GRAPH_FILE_PATH", paramString).apply();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i3.e
 * JD-Core Version:    0.7.0.1
 */