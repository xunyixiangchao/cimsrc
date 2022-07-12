package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.d;
import com.baidu.mapsdkplatform.comapi.util.e;
import java.io.File;

public class EnvironmentUtilities
{
  static String a;
  static String b;
  static String c;
  static int d;
  static int e;
  static int f;
  static int g;
  private static e h;
  
  public static String getAppCachePath()
  {
    return b;
  }
  
  public static String getAppSDCardPath()
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/BaiduMapSDKNew");
    str = ((StringBuilder)localObject).toString();
    if (str.length() != 0)
    {
      localObject = new File(str);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
    }
    return str;
  }
  
  public static String getAppSecondCachePath()
  {
    return c;
  }
  
  public static int getDomTmpStgMax()
  {
    return e;
  }
  
  public static int getItsTmpStgMax()
  {
    return f;
  }
  
  public static int getMapTmpStgMax()
  {
    return d;
  }
  
  public static String getSDCardPath()
  {
    return a;
  }
  
  public static int getSsgTmpStgMax()
  {
    return g;
  }
  
  public static void initAppDirectory(Context paramContext)
  {
    Object localObject;
    if (h == null)
    {
      localObject = e.b();
      h = (e)localObject;
      ((e)localObject).b(paramContext);
    }
    paramContext = a;
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = new StringBuilder();
      paramContext.append(a);
      localObject = File.separator;
      paramContext.append((String)localObject);
      paramContext.append("BaiduMapSDKNew");
      paramContext.append((String)localObject);
      paramContext.append("cache");
      paramContext = paramContext.toString();
    }
    else
    {
      a = h.a().c();
      paramContext = h.a().b();
    }
    b = paramContext;
    c = h.a().d();
    d = 52428800;
    e = 52428800;
    f = 5242880;
    g = 52428800;
  }
  
  public static void setSDCardPath(String paramString)
  {
    a = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.common.EnvironmentUtilities
 * JD-Core Version:    0.7.0.1
 */