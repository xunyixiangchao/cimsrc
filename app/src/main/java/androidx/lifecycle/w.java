package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class w
  extends y.c
{
  private static final Class<?>[] f = { Application.class, v.class };
  private static final Class<?>[] g = { v.class };
  private final Application a;
  private final y.b b;
  private final Bundle c;
  private final h d;
  private final SavedStateRegistry e;
  
  @SuppressLint({"LambdaLast"})
  public w(Application paramApplication, b paramb, Bundle paramBundle)
  {
    this.e = paramb.getSavedStateRegistry();
    this.d = paramb.getLifecycle();
    this.c = paramBundle;
    this.a = paramApplication;
    if (paramApplication != null) {
      paramApplication = y.a.c(paramApplication);
    } else {
      paramApplication = y.d.b();
    }
    this.b = paramApplication;
  }
  
  private static <T> Constructor<T> d(Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    paramClass = paramClass.getConstructors();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Constructor<T> localConstructor = paramClass[i];
      if (Arrays.equals(paramArrayOfClass, localConstructor.getParameterTypes())) {
        return localConstructor;
      }
      i += 1;
    }
    return null;
  }
  
  public <T extends x> T a(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str != null) {
      return c(str, paramClass);
    }
    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
  }
  
  void b(x paramx)
  {
    SavedStateHandleController.a(paramx, this.e, this.d);
  }
  
  public <T extends x> T c(String paramString, Class<T> paramClass)
  {
    boolean bool = a.class.isAssignableFrom(paramClass);
    Object localObject;
    if ((bool) && (this.a != null)) {
      localObject = d(paramClass, f);
    } else {
      localObject = d(paramClass, g);
    }
    if (localObject == null) {
      return this.b.a(paramClass);
    }
    SavedStateHandleController localSavedStateHandleController = SavedStateHandleController.e(this.e, this.d, paramString, this.c);
    if (bool) {}
    try
    {
      paramString = this.a;
      if (paramString != null) {}
      for (paramString = ((Constructor)localObject).newInstance(new Object[] { paramString, localSavedStateHandleController.f() });; paramString = ((Constructor)localObject).newInstance(new Object[] { localSavedStateHandleController.f() }))
      {
        paramString = (x)paramString;
        break;
      }
      paramString.e("androidx.lifecycle.savedstate.vm.tag", localSavedStateHandleController);
      return paramString;
    }
    catch (InvocationTargetException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("An exception happened in constructor of ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString.getCause());
    }
    catch (InstantiationException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("A ");
      ((StringBuilder)localObject).append(paramClass);
      ((StringBuilder)localObject).append(" cannot be instantiated.");
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString);
    }
    catch (IllegalAccessException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to access ");
      ((StringBuilder)localObject).append(paramClass);
      throw new RuntimeException(((StringBuilder)localObject).toString(), paramString);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.lifecycle.w
 * JD-Core Version:    0.7.0.1
 */