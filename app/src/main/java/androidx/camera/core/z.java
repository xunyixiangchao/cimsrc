package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.concurrent.futures.c;
import androidx.concurrent.futures.c.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import s.c0;
import s.d0;
import s.h0;
import s.u2;
import u.f;
import u7.a;
import x0.h;

public final class z
{
  private static final Object o = new Object();
  private static final SparseArray<Integer> p = new SparseArray();
  final h0 a = new h0();
  private final Object b = new Object();
  private final a0 c;
  private final Executor d;
  private final Handler e;
  private final HandlerThread f;
  private d0 g;
  private c0 h;
  private u2 i;
  private Context j;
  private final a<Void> k;
  private a l = a.a;
  private a<Void> m = f.h(null);
  private final Integer n;
  
  public z(Context paramContext, a0.b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      this.c = paramb.getCameraXConfig();
      break;
      paramb = f(paramContext);
      if (paramb == null) {
        break label193;
      }
    }
    Executor localExecutor = this.c.J(null);
    Handler localHandler = this.c.M(null);
    paramb = localExecutor;
    if (localExecutor == null) {
      paramb = new o();
    }
    this.d = paramb;
    if (localHandler == null)
    {
      paramb = new HandlerThread("CameraX-scheduler", 10);
      this.f = paramb;
      paramb.start();
      this.e = u0.d.a(paramb.getLooper());
    }
    else
    {
      this.f = null;
      this.e = localHandler;
    }
    paramb = (Integer)this.c.e(a0.G, null);
    this.n = paramb;
    i(paramb);
    this.k = k(paramContext);
    return;
    label193:
    throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
  }
  
  private static a0.b f(Context paramContext)
  {
    Application localApplication = androidx.camera.core.impl.utils.d.b(paramContext);
    if ((localApplication instanceof a0.b)) {
      return (a0.b)localApplication;
    }
    for (;;)
    {
      try
      {
        paramContext = androidx.camera.core.impl.utils.d.a(paramContext);
        paramContext = paramContext.getPackageManager().getServiceInfo(new ComponentName(paramContext, MetadataHolderService.class), 640).metaData;
        if (paramContext == null) {
          break label132;
        }
        paramContext = paramContext.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER");
        if (paramContext == null)
        {
          n1.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
          return null;
        }
        paramContext = (a0.b)Class.forName(paramContext).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        return paramContext;
      }
      catch (NullPointerException paramContext) {}catch (IllegalAccessException paramContext) {}catch (NoSuchMethodException paramContext) {}catch (InvocationTargetException paramContext) {}catch (InstantiationException paramContext) {}catch (ClassNotFoundException paramContext) {}catch (PackageManager.NameNotFoundException paramContext) {}
      n1.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", paramContext);
      return null;
      label132:
      paramContext = null;
    }
  }
  
  /* Error */
  private static void i(Integer paramInteger)
  {
    // Byte code:
    //   0: getstatic 45	androidx/camera/core/z:o	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull +6 -> 13
    //   10: aload_2
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokevirtual 246	java/lang/Integer:intValue	()I
    //   17: iconst_3
    //   18: bipush 6
    //   20: ldc 248
    //   22: invokestatic 253	x0/h:c	(IIILjava/lang/String;)I
    //   25: pop
    //   26: getstatic 50	androidx/camera/core/z:p	Landroid/util/SparseArray;
    //   29: astore_3
    //   30: aload_3
    //   31: aload_0
    //   32: invokevirtual 246	java/lang/Integer:intValue	()I
    //   35: invokevirtual 257	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   38: astore 4
    //   40: iconst_1
    //   41: istore_1
    //   42: aload 4
    //   44: ifnull +20 -> 64
    //   47: iconst_1
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 246	java/lang/Integer:intValue	()I
    //   53: invokevirtual 257	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   56: checkcast 128	java/lang/Integer
    //   59: invokevirtual 246	java/lang/Integer:intValue	()I
    //   62: iadd
    //   63: istore_1
    //   64: aload_3
    //   65: aload_0
    //   66: invokevirtual 246	java/lang/Integer:intValue	()I
    //   69: iload_1
    //   70: invokestatic 261	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 265	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   76: invokestatic 267	androidx/camera/core/z:p	()V
    //   79: aload_2
    //   80: monitorexit
    //   81: return
    //   82: astore_0
    //   83: aload_2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramInteger	Integer
    //   41	29	1	i1	int
    //   3	81	2	localObject1	Object
    //   29	36	3	localSparseArray	SparseArray
    //   38	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	12	82	finally
    //   13	40	82	finally
    //   47	64	82	finally
    //   64	81	82	finally
    //   83	85	82	finally
  }
  
  private void j(Executor paramExecutor, long paramLong, Context paramContext, c.a<Void> parama)
  {
    paramExecutor.execute(new x(this, paramContext, paramExecutor, parama, paramLong));
  }
  
  private a<Void> k(Context paramContext)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.l == a.a)
        {
          bool = true;
          h.j(bool, "CameraX.initInternal() should only be called once per instance");
          this.l = a.b;
          paramContext = c.a(new w(this, paramContext));
          return paramContext;
        }
      }
      boolean bool = false;
    }
  }
  
  private void o()
  {
    synchronized (this.b)
    {
      this.l = a.d;
      return;
    }
  }
  
  private static void p()
  {
    SparseArray localSparseArray = p;
    if (localSparseArray.size() == 0)
    {
      n1.h();
      return;
    }
    int i1 = 3;
    if (localSparseArray.get(3) != null) {}
    do
    {
      do
      {
        do
        {
          n1.i(i1);
          return;
          i1 = 4;
        } while (localSparseArray.get(4) != null);
        i1 = 5;
      } while (localSparseArray.get(5) != null);
      i1 = 6;
    } while (localSparseArray.get(6) != null);
  }
  
  public c0 d()
  {
    c0 localc0 = this.h;
    if (localc0 != null) {
      return localc0;
    }
    throw new IllegalStateException("CameraX not initialized yet.");
  }
  
  public h0 e()
  {
    return this.a;
  }
  
  public u2 g()
  {
    u2 localu2 = this.i;
    if (localu2 != null) {
      return localu2;
    }
    throw new IllegalStateException("CameraX not initialized yet.");
  }
  
  public a<Void> h()
  {
    return this.k;
  }
  
  private static enum a
  {
    static
    {
      a locala1 = new a("UNINITIALIZED", 0);
      a = locala1;
      a locala2 = new a("INITIALIZING", 1);
      b = locala2;
      a locala3 = new a("INITIALIZING_ERROR", 2);
      c = locala3;
      a locala4 = new a("INITIALIZED", 3);
      d = locala4;
      a locala5 = new a("SHUTDOWN", 4);
      e = locala5;
      f = new a[] { locala1, locala2, locala3, locala4, locala5 };
    }
    
    private a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.z
 * JD-Core Version:    0.7.0.1
 */