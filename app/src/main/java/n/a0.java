package n;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import java.util.concurrent.Executor;
import o.g;

public final class a0
{
  private final a a;
  
  private a0(CameraDevice paramCameraDevice, Handler paramHandler)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28)
    {
      this.a = new h0(paramCameraDevice);
      return;
    }
    if (i >= 24) {}
    for (paramCameraDevice = g0.g(paramCameraDevice, paramHandler);; paramCameraDevice = f0.f(paramCameraDevice, paramHandler))
    {
      this.a = paramCameraDevice;
      return;
    }
  }
  
  public static a0 b(CameraDevice paramCameraDevice, Handler paramHandler)
  {
    return new a0(paramCameraDevice, paramHandler);
  }
  
  public void a(g paramg)
  {
    this.a.a(paramg);
  }
  
  static abstract interface a
  {
    public abstract void a(g paramg);
  }
  
  static final class b
    extends CameraDevice.StateCallback
  {
    final CameraDevice.StateCallback a;
    private final Executor b;
    
    b(Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
    {
      this.b = paramExecutor;
      this.a = paramStateCallback;
    }
    
    public void onClosed(CameraDevice paramCameraDevice)
    {
      this.b.execute(new d0(this, paramCameraDevice));
    }
    
    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      this.b.execute(new b0(this, paramCameraDevice));
    }
    
    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      this.b.execute(new e0(this, paramCameraDevice, paramInt));
    }
    
    public void onOpened(CameraDevice paramCameraDevice)
    {
      this.b.execute(new c0(this, paramCameraDevice));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.a0
 * JD-Core Version:    0.7.0.1
 */