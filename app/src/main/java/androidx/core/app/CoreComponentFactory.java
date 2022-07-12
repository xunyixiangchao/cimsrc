package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory
  extends AppComponentFactory
{
  static <T> T a(T paramT)
  {
    if ((paramT instanceof a))
    {
      Object localObject = ((a)paramT).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return paramT;
  }
  
  public Activity instantiateActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (Activity)a(super.instantiateActivity(paramClassLoader, paramString, paramIntent));
  }
  
  public Application instantiateApplication(ClassLoader paramClassLoader, String paramString)
  {
    return (Application)a(super.instantiateApplication(paramClassLoader, paramString));
  }
  
  public ContentProvider instantiateProvider(ClassLoader paramClassLoader, String paramString)
  {
    return (ContentProvider)a(super.instantiateProvider(paramClassLoader, paramString));
  }
  
  public BroadcastReceiver instantiateReceiver(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (BroadcastReceiver)a(super.instantiateReceiver(paramClassLoader, paramString, paramIntent));
  }
  
  public Service instantiateService(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    return (Service)a(super.instantiateService(paramClassLoader, paramString, paramIntent));
  }
  
  public static abstract interface a
  {
    public abstract Object a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.CoreComponentFactory
 * JD-Core Version:    0.7.0.1
 */