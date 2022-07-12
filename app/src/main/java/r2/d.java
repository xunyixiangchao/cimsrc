package r2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
public final class d
{
  private final Context a;
  
  public d(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static b b(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      StringBuilder localStringBuilder = null;
      try
      {
        paramString = localClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      }
      catch (InvocationTargetException paramString) {}catch (NoSuchMethodException paramString) {}catch (IllegalAccessException paramString) {}catch (InstantiationException paramString) {}
      c(localClass, paramString);
      paramString = localStringBuilder;
      if ((paramString instanceof b)) {
        return (b)paramString;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected instanceof GlideModule, but found: ");
      localStringBuilder.append(paramString);
      throw new RuntimeException(localStringBuilder.toString());
    }
    catch (ClassNotFoundException paramString)
    {
      throw new IllegalArgumentException("Unable to find GlideModule implementation", paramString);
    }
  }
  
  private static void c(Class<?> paramClass, Exception paramException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to instantiate GlideModule implementation for ");
    localStringBuilder.append(paramClass);
    throw new RuntimeException(localStringBuilder.toString(), paramException);
  }
  
  public List<b> a()
  {
    if (Log.isLoggable("ManifestParser", 3)) {
      Log.d("ManifestParser", "Loading Glide modules");
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      ApplicationInfo localApplicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (localApplicationInfo.metaData == null)
      {
        if (Log.isLoggable("ManifestParser", 3))
        {
          Log.d("ManifestParser", "Got null app info metadata");
          return localArrayList;
        }
      }
      else
      {
        if (Log.isLoggable("ManifestParser", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Got app info metadata: ");
          ((StringBuilder)localObject).append(localApplicationInfo.metaData);
          Log.v("ManifestParser", ((StringBuilder)localObject).toString());
        }
        Object localObject = localApplicationInfo.metaData.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ("GlideModule".equals(localApplicationInfo.metaData.get(str)))
          {
            localArrayList.add(b(str));
            if (Log.isLoggable("ManifestParser", 3))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Loaded Glide module: ");
              localStringBuilder.append(str);
              Log.d("ManifestParser", localStringBuilder.toString());
            }
          }
        }
        if (Log.isLoggable("ManifestParser", 3)) {
          Log.d("ManifestParser", "Finished loading Glide modules");
        }
        return localArrayList;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Unable to find metadata to parse GlideModules", localNameNotFoundException);
    }
    return localNameNotFoundException;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r2.d
 * JD-Core Version:    0.7.0.1
 */