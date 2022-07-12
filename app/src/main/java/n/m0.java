package n;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.core.impl.utils.k;
import java.util.Map;
import java.util.concurrent.Executor;

public final class m0
{
  private final b a;
  private final Map<String, z> b = new ArrayMap(4);
  
  private m0(b paramb)
  {
    this.a = paramb;
  }
  
  public static m0 a(Context paramContext)
  {
    return b(paramContext, k.a());
  }
  
  public static m0 b(Context paramContext, Handler paramHandler)
  {
    return new m0(n0.a(paramContext, paramHandler));
  }
  
  public z c(String paramString)
  {
    synchronized (this.b)
    {
      z localz2 = (z)this.b.get(paramString);
      z localz1 = localz2;
      if (localz2 == null) {
        try
        {
          localz1 = z.e(this.a.c(paramString));
          this.b.put(paramString, localz1);
        }
        catch (AssertionError paramString)
        {
          throw new f(10002, paramString.getMessage(), paramString);
        }
      }
      return localz1;
    }
  }
  
  public String[] d()
  {
    return this.a.e();
  }
  
  public void e(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    this.a.d(paramString, paramExecutor, paramStateCallback);
  }
  
  public void f(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    this.a.a(paramExecutor, paramAvailabilityCallback);
  }
  
  public void g(CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    this.a.b(paramAvailabilityCallback);
  }
  
  static final class a
    extends CameraManager.AvailabilityCallback
  {
    private final Executor a;
    final CameraManager.AvailabilityCallback b;
    private final Object c = new Object();
    private boolean d = false;
    
    a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
    {
      this.a = paramExecutor;
      this.b = paramAvailabilityCallback;
    }
    
    void g()
    {
      synchronized (this.c)
      {
        this.d = true;
        return;
      }
    }
    
    public void onCameraAccessPrioritiesChanged()
    {
      synchronized (this.c)
      {
        if (!this.d) {
          this.a.execute(new j0(this));
        }
        return;
      }
    }
    
    public void onCameraAvailable(String paramString)
    {
      synchronized (this.c)
      {
        if (!this.d) {
          this.a.execute(new k0(this, paramString));
        }
        return;
      }
    }
    
    public void onCameraUnavailable(String paramString)
    {
      synchronized (this.c)
      {
        if (!this.d) {
          this.a.execute(new l0(this, paramString));
        }
        return;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback);
    
    public abstract void b(CameraManager.AvailabilityCallback paramAvailabilityCallback);
    
    public abstract CameraCharacteristics c(String paramString);
    
    public abstract void d(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback);
    
    public abstract String[] e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.m0
 * JD-Core Version:    0.7.0.1
 */