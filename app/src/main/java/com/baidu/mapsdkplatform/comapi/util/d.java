package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;

public final class d
{
  private final String a;
  private final String b;
  private final String c;
  
  d(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29) {}
    for (Object localObject = a(paramContext);; localObject = ((File)localObject).getAbsolutePath())
    {
      this.a = ((String)localObject);
      break label42;
      localObject = Environment.getExternalStorageDirectory();
      if (localObject == null) {
        break;
      }
    }
    label42:
    localObject = File.separator;
    this.b = paramContext.getCacheDir().getAbsolutePath();
    this.c = "";
  }
  
  private String a(Context paramContext)
  {
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (localFile.exists())) {
      return localFile.getPath();
    }
    return paramContext.getFilesDir().getPath();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("BaiduMapSDKNew");
    return localStringBuilder.toString();
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && (d.class.isInstance(paramObject)))
    {
      paramObject = (d)paramObject;
      return this.a.equals(paramObject.a);
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.d
 * JD-Core Version:    0.7.0.1
 */