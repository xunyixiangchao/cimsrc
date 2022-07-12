package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.c.d;
import com.baidu.location.f;

public class b
{
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static int i = 0;
  public static int j = -2;
  public static long k = -1L;
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  private boolean l = false;
  
  private b()
  {
    if (f.getServiceContext() != null) {
      a(f.getServiceContext());
    }
  }
  
  public static b a()
  {
    return a.a;
  }
  
  public String a(boolean paramBoolean)
  {
    return a(paramBoolean, null);
  }
  
  public String a(boolean paramBoolean, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    localStringBuffer.append("&sdk=");
    localStringBuffer.append(9.303001F);
    if (paramBoolean)
    {
      if (h.e.equals("all")) {
        localStringBuffer.append("&addr=allj2");
      }
      if (h.h) {
        localStringBuffer.append("&adtp=n2");
      }
      if ((h.g) || (h.j) || (h.k) || (h.i))
      {
        localStringBuffer.append("&sema=");
        if (h.g) {
          localStringBuffer.append("aptag|");
        }
        if (h.i) {
          localStringBuffer.append("aptagd2|");
        }
        if (h.j) {
          localStringBuffer.append("poiregion|");
        }
        if (h.k) {
          localStringBuffer.append("regular");
        }
      }
    }
    if (paramBoolean)
    {
      if (paramString == null) {
        paramString = "&coor=gcj02";
      } else {
        localStringBuffer.append("&coor=");
      }
      localStringBuffer.append(paramString);
      paramString = d.l();
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
    }
    if (this.c == null) {}
    for (paramString = "&im=";; paramString = "&Aim=")
    {
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.a);
      break;
      localStringBuffer.append("&cu=");
      localStringBuffer.append(this.c);
      paramString = this.a;
      if ((paramString == null) || (paramString.equals("NULL")) || (this.c.contains(new StringBuffer(this.a).reverse().toString()))) {
        break;
      }
    }
    if (this.b != null)
    {
      localStringBuffer.append("&snd=");
      localStringBuffer.append(this.b);
    }
    if (this.d != null)
    {
      localStringBuffer.append("&Aid=");
      localStringBuffer.append(this.d);
    }
    localStringBuffer.append("&fw=");
    localStringBuffer.append(f.getFrameVersion());
    localStringBuffer.append("&lt=1");
    localStringBuffer.append("&mb=");
    localStringBuffer.append(Build.MODEL);
    localStringBuffer.append("&resid=");
    localStringBuffer.append("12");
    localStringBuffer.append("&os=A");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (paramBoolean)
    {
      localStringBuffer.append("&sv=");
      String str = Build.VERSION.RELEASE;
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (str.length() > 6) {
          paramString = str.substring(0, 6);
        }
      }
      localStringBuffer.append(paramString);
    }
    return localStringBuffer.toString();
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      if (this.l) {
        return;
      }
    }
    try
    {
      this.c = LBSAuthManager.getInstance(paramContext).getCUID();
    }
    catch (Exception localException)
    {
      label26:
      break label26;
    }
    this.c = null;
    try
    {
      e = paramContext.getPackageName();
    }
    catch (Exception paramContext)
    {
      label41:
      break label41;
    }
    e = null;
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(this.c);
    h.n = paramContext.toString();
    this.l = true;
  }
  
  public void a(String paramString1, String paramString2)
  {
    f = paramString1;
    e = paramString2;
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    String str;
    if (this.c != null)
    {
      localStringBuffer.append("&cu=");
      str = this.c;
    }
    else
    {
      localStringBuffer.append("&im=");
      str = this.a;
    }
    localStringBuffer.append(str);
    try
    {
      localStringBuffer.append("&mb=");
      localStringBuffer.append(Build.MODEL);
      localStringBuffer.append("&pack=");
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuffer.append(e);
        label81:
        localStringBuffer.append("&sdk=");
        localStringBuffer.append(9.303001F);
        return localStringBuffer.toString();
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label81;
      }
    }
  }
  
  private static class a
  {
    public static final b a = new b(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.e.b
 * JD-Core Version:    0.7.0.1
 */