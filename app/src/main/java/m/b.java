package m;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CaptureRequest.Key;
import androidx.camera.core.i0;
import java.util.Iterator;
import java.util.Set;
import r.j;
import r.j.a;
import s.s0;
import s.s0.a;
import s.t1;
import s.u1;
import s.y1;

public final class b
  extends j
{
  public static final s0.a<Integer> B = s0.a.a("camera2.captureRequest.templateType", Integer.TYPE);
  public static final s0.a<CameraDevice.StateCallback> C = s0.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
  public static final s0.a<CameraCaptureSession.StateCallback> D = s0.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
  public static final s0.a<CameraCaptureSession.CaptureCallback> E = s0.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
  public static final s0.a<d> F = s0.a.a("camera2.cameraEvent.callback", d.class);
  public static final s0.a<Object> G = s0.a.a("camera2.captureRequest.tag", Object.class);
  public static final s0.a<String> H = s0.a.a("camera2.cameraCaptureSession.physicalCameraId", String.class);
  
  public b(s0 params0)
  {
    super(params0);
  }
  
  public static s0.a<Object> I(CaptureRequest.Key<?> paramKey)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("camera2.captureRequest.option.");
    localStringBuilder.append(paramKey.getName());
    return s0.a.b(localStringBuilder.toString(), Object.class, paramKey);
  }
  
  public d J(d paramd)
  {
    return (d)p().e(F, paramd);
  }
  
  public j K()
  {
    return j.a.e(p()).d();
  }
  
  public Object L(Object paramObject)
  {
    return p().e(G, paramObject);
  }
  
  public int M(int paramInt)
  {
    return ((Integer)p().e(B, Integer.valueOf(paramInt))).intValue();
  }
  
  public CameraDevice.StateCallback N(CameraDevice.StateCallback paramStateCallback)
  {
    return (CameraDevice.StateCallback)p().e(C, paramStateCallback);
  }
  
  public String O(String paramString)
  {
    return (String)p().e(H, paramString);
  }
  
  public CameraCaptureSession.CaptureCallback P(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    return (CameraCaptureSession.CaptureCallback)p().e(E, paramCaptureCallback);
  }
  
  public CameraCaptureSession.StateCallback Q(CameraCaptureSession.StateCallback paramStateCallback)
  {
    return (CameraCaptureSession.StateCallback)p().e(D, paramStateCallback);
  }
  
  public static final class a
    implements i0<b>
  {
    private final u1 a = u1.M();
    
    public t1 a()
    {
      return this.a;
    }
    
    public b c()
    {
      return new b(y1.K(this.a));
    }
    
    public a d(s0 params0)
    {
      Iterator localIterator = params0.c().iterator();
      while (localIterator.hasNext())
      {
        s0.a locala = (s0.a)localIterator.next();
        this.a.G(locala, params0.a(locala));
      }
      return this;
    }
    
    public <ValueT> a e(CaptureRequest.Key<ValueT> paramKey, ValueT paramValueT)
    {
      paramKey = b.I(paramKey);
      this.a.G(paramKey, paramValueT);
      return this;
    }
  }
  
  public static final class b<T>
  {
    i0<T> a;
    
    public b(i0<T> parami0)
    {
      this.a = parami0;
    }
    
    public b<T> a(d paramd)
    {
      this.a.a().G(b.F, paramd);
      return this;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m.b
 * JD-Core Version:    0.7.0.1
 */