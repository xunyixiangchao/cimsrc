package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n.c;

class g1
  extends CameraCaptureSession.CaptureCallback
{
  final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> a = new HashMap();
  a b = null;
  
  private List<CameraCaptureSession.CaptureCallback> b(CaptureRequest paramCaptureRequest)
  {
    paramCaptureRequest = (List)this.a.get(paramCaptureRequest);
    if (paramCaptureRequest != null) {
      return paramCaptureRequest;
    }
    return Collections.emptyList();
  }
  
  void a(CaptureRequest paramCaptureRequest, List<CameraCaptureSession.CaptureCallback> paramList)
  {
    List localList = (List)this.a.get(paramCaptureRequest);
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size() + localList.size());
      localArrayList.addAll(paramList);
      localArrayList.addAll(localList);
      this.a.put(paramCaptureRequest, localArrayList);
      return;
    }
    this.a.put(paramCaptureRequest, paramList);
  }
  
  public void c(a parama)
  {
    this.b = parama;
  }
  
  public void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
  {
    Iterator localIterator = b(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      c.a((CameraCaptureSession.CaptureCallback)localIterator.next(), paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
    }
  }
  
  public void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
  {
    Iterator localIterator = b(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
    }
  }
  
  public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
  {
    Iterator localIterator = b(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
    }
  }
  
  public void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
  {
    Iterator localIterator = b(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
    }
  }
  
  public void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
  {
    Object localObject = this.a.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
      }
    }
    localObject = this.b;
    if (localObject != null) {
      ((a)localObject).a(paramCameraCaptureSession, paramInt, true);
    }
  }
  
  public void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
  {
    Object localObject = this.a.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((List)((Iterator)localObject).next()).iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
      }
    }
    localObject = this.b;
    if (localObject != null) {
      ((a)localObject).a(paramCameraCaptureSession, paramInt, false);
    }
  }
  
  public void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
  {
    Iterator localIterator = b(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(CameraCaptureSession paramCameraCaptureSession, int paramInt, boolean paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.g1
 * JD-Core Version:    0.7.0.1
 */