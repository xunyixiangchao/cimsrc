package androidx.camera.extensions;

import a0.j;
import a0.o;
import a0.p;
import android.content.Context;
import androidx.camera.core.n1;
import androidx.camera.core.s;
import androidx.camera.core.t;
import androidx.camera.extensions.impl.InitializerImpl.OnExtensionsInitializedCallback;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.util.concurrent.Future;
import u.f;
import u7.a;

public final class ExtensionsManager
{
  private static final Object c = new Object();
  private static a<ExtensionsManager> d;
  private static a<Void> e;
  private static ExtensionsManager f;
  private final ExtensionsAvailability a;
  private final d b;
  
  private ExtensionsManager(ExtensionsAvailability paramExtensionsAvailability, s params)
  {
    this.a = paramExtensionsAvailability;
    this.b = new d(params);
  }
  
  public static a<ExtensionsManager> c(Context paramContext, s params)
  {
    return d(paramContext, params, p.a());
  }
  
  static a<ExtensionsManager> d(Context paramContext, s params, p paramp)
  {
    synchronized (c)
    {
      a locala = e;
      if ((locala != null) && (!locala.isDone())) {
        throw new IllegalStateException("Not yet done deinitializing extensions");
      }
      e = null;
      if (j.b() == null)
      {
        paramContext = f.h(e(ExtensionsAvailability.NONE, params));
        return paramContext;
      }
      if (j.b().a(o.b) < 0)
      {
        paramContext = f.h(e(ExtensionsAvailability.LIBRARY_AVAILABLE, params));
        return paramContext;
      }
      if (d == null) {
        d = c.a(new e(paramp, paramContext, params));
      }
      paramContext = d;
      return paramContext;
    }
  }
  
  static ExtensionsManager e(ExtensionsAvailability paramExtensionsAvailability, s params)
  {
    synchronized (c)
    {
      ExtensionsManager localExtensionsManager = f;
      if (localExtensionsManager != null) {
        return localExtensionsManager;
      }
      paramExtensionsAvailability = new ExtensionsManager(paramExtensionsAvailability, params);
      f = paramExtensionsAvailability;
      return paramExtensionsAvailability;
    }
  }
  
  public t b(t paramt, int paramInt)
  {
    if (paramInt == 0) {
      return paramt;
    }
    if (this.a == ExtensionsAvailability.LIBRARY_AVAILABLE) {
      return this.b.c(paramt, paramInt);
    }
    throw new IllegalArgumentException("This device doesn't support extensions function! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
  }
  
  public boolean f(t paramt, int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    if (this.a != ExtensionsAvailability.LIBRARY_AVAILABLE) {
      return false;
    }
    return this.b.h(paramt, paramInt);
  }
  
  static enum ExtensionsAvailability
  {
    static
    {
      ExtensionsAvailability localExtensionsAvailability1 = new ExtensionsAvailability("LIBRARY_AVAILABLE", 0);
      LIBRARY_AVAILABLE = localExtensionsAvailability1;
      ExtensionsAvailability localExtensionsAvailability2 = new ExtensionsAvailability("LIBRARY_UNAVAILABLE_ERROR_LOADING", 1);
      LIBRARY_UNAVAILABLE_ERROR_LOADING = localExtensionsAvailability2;
      ExtensionsAvailability localExtensionsAvailability3 = new ExtensionsAvailability("LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION", 2);
      LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION = localExtensionsAvailability3;
      ExtensionsAvailability localExtensionsAvailability4 = new ExtensionsAvailability("NONE", 3);
      NONE = localExtensionsAvailability4;
      $VALUES = new ExtensionsAvailability[] { localExtensionsAvailability1, localExtensionsAvailability2, localExtensionsAvailability3, localExtensionsAvailability4 };
    }
    
    private ExtensionsAvailability() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.extensions.ExtensionsManager
 * JD-Core Version:    0.7.0.1
 */