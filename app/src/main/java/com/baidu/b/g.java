package com.baidu.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.System;
import android.util.Log;
import com.baidu.b.d.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class g
{
  private Context a;
  private c b;
  
  public g(Context paramContext, c paramc)
  {
    this.a = paramContext;
    this.b = paramc;
  }
  
  private f a()
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
    if (localFile.exists()) {
      return f.b(com.baidu.b.f.c.a(localFile));
    }
    return null;
  }
  
  private f a(Context paramContext)
  {
    Object localObject3 = this.b.b(paramContext);
    Object localObject1 = null;
    Object localObject2 = null;
    if (localObject3 != null)
    {
      String str = "files";
      paramContext = paramContext.getFilesDir();
      if (!"files".equals(paramContext.getName()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fetal error:: app files dir name is unexpectedly :: ");
        ((StringBuilder)localObject1).append(paramContext.getAbsolutePath());
        Log.e("CuidV266Manager", ((StringBuilder)localObject1).toString());
        str = paramContext.getName();
      }
      localObject3 = ((List)localObject3).iterator();
      paramContext = localObject2;
      do
      {
        do
        {
          do
          {
            localObject1 = paramContext;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (b)((Iterator)localObject3).next();
          } while (((b)localObject1).d);
          localObject1 = new File(new File(((b)localObject1).a.dataDir, str), "libcuid.so");
        } while (!((File)localObject1).exists());
        localObject1 = f.b(com.baidu.b.f.c.a((File)localObject1));
        paramContext = (Context)localObject1;
      } while (localObject1 == null);
    }
    return localObject1;
  }
  
  private f b()
  {
    return f.a(c("com.baidu.deviceid"), c("bd_setting_i"));
  }
  
  private boolean b(String paramString)
  {
    return this.a.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  private String c(String paramString)
  {
    try
    {
      paramString = Settings.System.getString(this.a.getContentResolver(), paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      com.baidu.b.f.c.a(paramString);
    }
    return null;
  }
  
  private String d(String paramString)
  {
    return "0";
  }
  
  private f e(String paramString)
  {
    String str1 = "";
    paramString = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
    if (!paramString.exists()) {
      paramString = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
    }
    try
    {
      Object localObject = new BufferedReader(new FileReader(paramString));
      paramString = new StringBuilder();
      for (;;)
      {
        String str2 = ((BufferedReader)localObject).readLine();
        if (str2 == null) {
          break;
        }
        paramString.append(str2);
        paramString.append("\r\n");
      }
      ((BufferedReader)localObject).close();
      localObject = com.baidu.b.c.a.g.a();
      localObject = new String(com.baidu.b.c.a.c.a((byte[])localObject, (byte[])localObject, a.a(paramString.toString().getBytes()))).split("=");
      if ((localObject != null) && (localObject.length == 2))
      {
        paramString = localObject[0];
        str1 = localObject[1];
      }
    }
    catch (FileNotFoundException|IOException|Exception paramString)
    {
      label148:
      break label148;
    }
    paramString = "";
    return f.a(str1, paramString);
  }
  
  public f a(String paramString)
  {
    Object localObject = a(this.a);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = f.b(c("com.baidu.deviceid.v2"));
    }
    boolean bool = b("android.permission.READ_EXTERNAL_STORAGE");
    localObject = paramString;
    if (paramString == null)
    {
      localObject = paramString;
      if (bool) {
        localObject = a();
      }
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = b();
    }
    int j = 0;
    int i = j;
    localObject = paramString;
    if (paramString == null)
    {
      i = j;
      localObject = paramString;
      if (bool)
      {
        paramString = d("");
        i = 1;
        localObject = e(paramString);
      }
    }
    if (i == 0) {
      d("");
    }
    if (localObject != null) {
      ((f)localObject).c();
    }
    return localObject;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.g
 * JD-Core Version:    0.7.0.1
 */