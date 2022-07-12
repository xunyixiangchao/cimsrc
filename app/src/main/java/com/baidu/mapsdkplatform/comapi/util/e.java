package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static volatile e d;
  private boolean a = false;
  private final List<d> b = new ArrayList();
  private d c = null;
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    boolean bool3;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      bool1 = bool2;
      localStringBuilder.append(paramString);
      bool1 = bool2;
      localStringBuilder.append("/test.0");
      bool1 = bool2;
      paramString = new File(localStringBuilder.toString());
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
      }
      bool1 = bool2;
      bool2 = paramString.createNewFile();
      bool1 = bool2;
      bool3 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
        return bool2;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      bool3 = bool1;
    }
    return bool3;
  }
  
  public static e b()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new e();
        }
      }
      finally {}
    }
    return d;
  }
  
  public d a()
  {
    return this.c;
  }
  
  public d a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.c().equals(paramContext)) {
          return locald;
        }
      }
    }
    return null;
  }
  
  public boolean a(Context paramContext, d paramd)
  {
    paramd = paramd.c();
    if (!a(paramd)) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("map_pref", 0).edit();
    paramContext.putString("PREFFERED_SD_CARD", paramd);
    return paramContext.commit();
  }
  
  public void b(Context paramContext)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    try
    {
      this.c = new d(paramContext);
      this.b.clear();
      this.b.add(this.c);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      if (this.b.size() > 0)
      {
        Object localObject1 = null;
        Iterator localIterator = this.b.iterator();
        int i = 0;
        Object localObject2;
        while (localIterator.hasNext())
        {
          localObject2 = (d)localIterator.next();
          if (new File(((d)localObject2).a()).exists())
          {
            i += 1;
            localObject1 = localObject2;
          }
        }
        if (i == 0)
        {
          localObject1 = a(paramContext);
          this.c = ((d)localObject1);
          if (localObject1 == null)
          {
            localObject2 = this.b.iterator();
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject1 = (d)((Iterator)localObject2).next();
            } while (!a(paramContext, (d)localObject1));
          }
        }
        else
        {
          for (;;)
          {
            this.c = ((d)localObject1);
            break label227;
            if (i != 1) {
              break;
            }
            if (!a(paramContext, (d)localObject1)) {
              break label227;
            }
          }
          this.c = a(paramContext);
        }
        label227:
        if (this.c == null) {
          this.c = ((d)this.b.get(0));
        }
      }
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    try
    {
      d locald = this.c;
      if ((locald != null) && (a(locald.c())))
      {
        paramContext = new File(this.c.a());
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        paramContext = new File(this.c.b());
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
        paramContext = new File(paramContext, ".nomedia");
        if (!paramContext.exists()) {
          paramContext.createNewFile();
        }
      }
      else
      {
        this.c = new d(paramContext);
        this.b.clear();
        this.b.add(this.c);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.util.e
 * JD-Core Version:    0.7.0.1
 */