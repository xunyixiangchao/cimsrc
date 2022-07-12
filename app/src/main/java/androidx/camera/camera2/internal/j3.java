package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageWriter;
import android.util.Size;
import androidx.camera.core.e1;
import androidx.camera.core.i2;
import androidx.camera.core.impl.utils.c;
import androidx.camera.core.n1;
import androidx.camera.core.q1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import n.z;
import s.g2.b;
import s.k;
import s.l1;
import s.m1;
import s.v0;
import z.e;

final class j3
  implements f3
{
  private final Map<Integer, Size> a;
  private final z b;
  final e c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  i2 g;
  private k h;
  private v0 i;
  ImageWriter j;
  
  j3(z paramz)
  {
    this.b = paramz;
    this.f = k3.a(paramz, 4);
    this.a = k(paramz);
    this.c = new e(3, i3.a);
  }
  
  private void j()
  {
    Object localObject = this.c;
    while (!((z.a)localObject).c()) {
      ((e1)((z.a)localObject).a()).close();
    }
    localObject = this.i;
    if (localObject != null)
    {
      i2 locali2 = this.g;
      if (locali2 != null)
      {
        ((v0)localObject).i().h(new g3(locali2), t.a.d());
        this.g = null;
      }
      ((v0)localObject).c();
      this.i = null;
    }
    localObject = this.j;
    if (localObject != null)
    {
      ((ImageWriter)localObject).close();
      this.j = null;
    }
  }
  
  private Map<Integer, Size> k(z paramz)
  {
    paramz = (StreamConfigurationMap)paramz.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if ((paramz != null) && (paramz.getInputFormats() != null))
    {
      HashMap localHashMap = new HashMap();
      int[] arrayOfInt = paramz.getInputFormats();
      int m = arrayOfInt.length;
      int k = 0;
      while (k < m)
      {
        int n = arrayOfInt[k];
        Size[] arrayOfSize = paramz.getInputSizes(n);
        if (arrayOfSize != null)
        {
          Arrays.sort(arrayOfSize, new c(true));
          localHashMap.put(Integer.valueOf(n), arrayOfSize[0]);
        }
        k += 1;
      }
      return localHashMap;
    }
    return new HashMap();
  }
  
  private boolean l(z paramz, int paramInt)
  {
    paramz = (StreamConfigurationMap)paramz.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (paramz == null) {
      return false;
    }
    paramz = paramz.getValidOutputFormatsForInput(paramInt);
    if (paramz == null) {
      return false;
    }
    int k = paramz.length;
    paramInt = 0;
    while (paramInt < k)
    {
      if (paramz[paramInt] == 256) {
        return true;
      }
      paramInt += 1;
    }
    return false;
  }
  
  public void a(g2.b paramb)
  {
    j();
    if (this.d) {
      return;
    }
    if ((this.f) && (!this.a.isEmpty()) && (this.a.containsKey(Integer.valueOf(34))))
    {
      if (!l(this.b, 34)) {
        return;
      }
      Object localObject1 = (Size)this.a.get(Integer.valueOf(34));
      localObject1 = new q1(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight(), 34, 9);
      this.h = ((q1)localObject1).m();
      this.g = new i2((l1)localObject1);
      ((q1)localObject1).e(new h3(this), t.a.c());
      Object localObject2 = new m1(this.g.getSurface(), new Size(this.g.getWidth(), this.g.getHeight()), 34);
      this.i = ((v0)localObject2);
      localObject1 = this.g;
      localObject2 = ((v0)localObject2).i();
      Objects.requireNonNull(localObject1);
      ((u7.a)localObject2).h(new g3((i2)localObject1), t.a.d());
      paramb.l(this.i);
      paramb.d(this.h);
      paramb.k(new a());
      paramb.s(new InputConfiguration(this.g.getWidth(), this.g.getHeight(), this.g.c()));
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public boolean d(e1 parame1)
  {
    parame1 = parame1.J();
    Object localObject = this.j;
    if ((localObject != null) && (parame1 != null)) {
      try
      {
        w.a.c((ImageWriter)localObject, parame1);
        return true;
      }
      catch (IllegalStateException parame1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enqueueImageToImageWriter throws IllegalStateException = ");
        ((StringBuilder)localObject).append(parame1.getMessage());
        n1.c("ZslControlImpl", ((StringBuilder)localObject).toString());
      }
    }
    return false;
  }
  
  public void e(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public e1 g()
  {
    try
    {
      e1 locale1 = (e1)this.c.a();
      return locale1;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      label13:
      break label13;
    }
    n1.c("ZslControlImpl", "dequeueImageFromBuffer no such element");
    return null;
  }
  
  class a
    extends CameraCaptureSession.StateCallback
  {
    a() {}
    
    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession) {}
    
    public void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      paramCameraCaptureSession = paramCameraCaptureSession.getInputSurface();
      if (paramCameraCaptureSession != null) {
        j3.this.j = w.a.a(paramCameraCaptureSession, 1);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.j3
 * JD-Core Version:    0.7.0.1
 */