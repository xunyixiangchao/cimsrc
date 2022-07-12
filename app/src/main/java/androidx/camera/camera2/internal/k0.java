package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import n.c;

public final class k0
{
  static CameraCaptureSession.CaptureCallback a(List<CameraCaptureSession.CaptureCallback> paramList)
  {
    return new a(paramList);
  }
  
  public static CameraCaptureSession.CaptureCallback b(CameraCaptureSession.CaptureCallback... paramVarArgs)
  {
    return a(Arrays.asList(paramVarArgs));
  }
  
  public static CameraCaptureSession.CaptureCallback c()
  {
    return new b();
  }
  
  private static final class a
    extends CameraCaptureSession.CaptureCallback
  {
    private final List<CameraCaptureSession.CaptureCallback> a = new ArrayList();
    
    a(List<CameraCaptureSession.CaptureCallback> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CameraCaptureSession.CaptureCallback localCaptureCallback = (CameraCaptureSession.CaptureCallback)paramList.next();
        if (!(localCaptureCallback instanceof k0.b)) {
          this.a.add(localCaptureCallback);
        }
      }
    }
    
    public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        c.a((CameraCaptureSession.CaptureCallback)localIterator.next(), paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
      }
    }
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
      }
    }
    
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
      }
    }
    
    public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
      }
    }
    
    public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
      }
    }
    
    public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
      }
    }
    
    public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
      }
    }
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong) {}
    
    public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult) {}
    
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure) {}
    
    public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult) {}
    
    public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt) {}
    
    public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong) {}
    
    public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.k0
 * JD-Core Version:    0.7.0.1
 */