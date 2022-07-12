package n;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import java.util.List;
import java.util.concurrent.Executor;

public final class g
{
  private final a a;
  
  private g(CameraCaptureSession paramCameraCaptureSession, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.a = new v(paramCameraCaptureSession);
      return;
    }
    this.a = w.d(paramCameraCaptureSession, paramHandler);
  }
  
  public static g d(CameraCaptureSession paramCameraCaptureSession, Handler paramHandler)
  {
    return new g(paramCameraCaptureSession, paramHandler);
  }
  
  public int a(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return this.a.c(paramList, paramExecutor, paramCaptureCallback);
  }
  
  public int b(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return this.a.b(paramCaptureRequest, paramExecutor, paramCaptureCallback);
  }
  
  public CameraCaptureSession c()
  {
    return this.a.a();
  }
  
  static abstract interface a
  {
    public abstract CameraCaptureSession a();
    
    public abstract int b(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback);
    
    public abstract int c(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback);
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    final CameraCaptureSession.CaptureCallback a;
    private final Executor b;
    
    b(Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
    {
      this.b = paramExecutor;
      this.a = paramCaptureCallback;
    }
    
    public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
    {
      this.b.execute(new n(this, paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong));
    }
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      this.b.execute(new m(this, paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult));
    }
    
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      this.b.execute(new k(this, paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure));
    }
    
    public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      this.b.execute(new l(this, paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult));
    }
    
    public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      this.b.execute(new h(this, paramCameraCaptureSession, paramInt));
    }
    
    public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
    {
      this.b.execute(new i(this, paramCameraCaptureSession, paramInt, paramLong));
    }
    
    public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      this.b.execute(new j(this, paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2));
    }
  }
  
  static final class c
    extends CameraCaptureSession.StateCallback
  {
    final CameraCaptureSession.StateCallback a;
    private final Executor b;
    
    c(Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      this.b = paramExecutor;
      this.a = paramStateCallback;
    }
    
    public void onActive(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new o(this, paramCameraCaptureSession));
    }
    
    public void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new q(this, paramCameraCaptureSession));
    }
    
    public void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new p(this, paramCameraCaptureSession));
    }
    
    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new s(this, paramCameraCaptureSession));
    }
    
    public void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new r(this, paramCameraCaptureSession));
    }
    
    public void onReady(CameraCaptureSession paramCameraCaptureSession)
    {
      this.b.execute(new t(this, paramCameraCaptureSession));
    }
    
    public void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
    {
      this.b.execute(new u(this, paramCameraCaptureSession, paramSurface));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n.g
 * JD-Core Version:    0.7.0.1
 */