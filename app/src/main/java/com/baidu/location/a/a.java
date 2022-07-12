package com.baidu.location.a;

import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;

public class a
  implements LBSAuthManagerListener
{
  private static Object b = new Object();
  private static a c;
  public int a = 0;
  private int d = 0;
  private Context e = null;
  private long f = 0L;
  private String g = null;
  
  public static a a()
  {
    synchronized (b)
    {
      if (c == null) {
        c = new a();
      }
      a locala = c;
      return locala;
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = LBSAuthManager.getInstance(paramContext).getPublicKey(paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = LBSAuthManager.getInstance(paramContext).getMCode();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    this.e = paramContext;
    LBSAuthManager.getInstance(paramContext).authenticate(false, "lbs_locsdk", null, this);
    this.f = System.currentTimeMillis();
  }
  
  public boolean b()
  {
    int i = this.d;
    boolean bool;
    if ((i != 0) && (i != 602) && (i != 601) && (i != -10) && (i != -11)) {
      bool = false;
    } else {
      bool = true;
    }
    if (this.e != null)
    {
      long l = System.currentTimeMillis() - this.f;
      if (bool ? l <= 86400000L : (l < 0L) || (l > 10000L))
      {
        LBSAuthManager.getInstance(this.e).authenticate(false, "lbs_locsdk", null, this);
        this.f = System.currentTimeMillis();
      }
    }
    return bool;
  }
  
  public void onAuthResult(int paramInt, String paramString)
  {
    this.d = paramInt;
    Object localObject;
    if (paramInt == 0)
    {
      localObject = "LocationAuthManager Authentication AUTHENTICATE_SUCC";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LocationAuthManager Authentication Error errorcode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , msg = ");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    Log.i("baidu_location_service", (String)localObject);
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("token")) && (paramString.getString("token") != null)) {
          this.g = paramString.getString("token");
        }
        if ((paramString.has("ak_permission")) && (paramString.getInt("ak_permission") != 0))
        {
          this.a = paramString.getInt("ak_permission");
          paramString = new StringBuilder();
          paramString.append("LocationAuthManager ak_permission = ");
          paramString.append(this.a);
          Log.i("baidu_location_service", paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.a.a
 * JD-Core Version:    0.7.0.1
 */