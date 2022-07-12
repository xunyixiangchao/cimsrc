package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.n1;
import androidx.camera.core.v2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import n.z;
import q.p;
import s.g2;
import s.g2.b;
import s.m1;
import s.s0;
import s.t2;
import s.u1;
import s.v0;
import t.a;
import u.c;
import u.f;

class e2
{
  private v0 a;
  private final g2 b;
  private final b c;
  private final p d = new p();
  
  e2(final z paramz, x1 paramx1)
  {
    Object localObject = new b();
    this.c = ((b)localObject);
    final SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    paramz = d(paramz, paramx1);
    paramx1 = new StringBuilder();
    paramx1.append("MeteringSession SurfaceTexture size: ");
    paramx1.append(paramz);
    n1.a("MeteringRepeating", paramx1.toString());
    localSurfaceTexture.setDefaultBufferSize(paramz.getWidth(), paramz.getHeight());
    paramz = new Surface(localSurfaceTexture);
    paramx1 = g2.b.p((t2)localObject);
    paramx1.t(1);
    localObject = new m1(paramz);
    this.a = ((v0)localObject);
    f.b(((v0)localObject).i(), new a(paramz, localSurfaceTexture), a.a());
    paramx1.l(this.a);
    this.b = paramx1.n();
  }
  
  private Size d(z paramz, x1 paramx1)
  {
    paramz = (StreamConfigurationMap)paramz.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (paramz == null)
    {
      n1.c("MeteringRepeating", "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
      return new Size(0, 0);
    }
    paramz = paramz.getOutputSizes(34);
    if (paramz == null)
    {
      n1.c("MeteringRepeating", "Can not get output size list.");
      return new Size(0, 0);
    }
    Size[] arrayOfSize = this.d.a(paramz);
    List localList = Arrays.asList(arrayOfSize);
    Collections.sort(localList, d2.a);
    paramz = paramx1.d();
    long l = Math.min(paramz.getWidth() * paramz.getHeight(), 307200L);
    paramz = null;
    int j = arrayOfSize.length;
    int i = 0;
    while (i < j)
    {
      paramx1 = arrayOfSize[i];
      boolean bool = paramx1.getWidth() * paramx1.getHeight() < l;
      if (!bool) {
        return paramx1;
      }
      if (bool)
      {
        if (paramz == null) {
          break;
        }
        return paramz;
      }
      i += 1;
      paramz = paramx1;
    }
    return (Size)localList.get(0);
  }
  
  void b()
  {
    n1.a("MeteringRepeating", "MeteringRepeating clear!");
    v0 localv0 = this.a;
    if (localv0 != null) {
      localv0.c();
    }
    this.a = null;
  }
  
  String c()
  {
    return "MeteringRepeating";
  }
  
  g2 e()
  {
    return this.b;
  }
  
  t2<?> f()
  {
    return this.c;
  }
  
  class a
    implements c<Void>
  {
    a(Surface paramSurface, SurfaceTexture paramSurfaceTexture) {}
    
    public void a(Throwable paramThrowable)
    {
      throw new IllegalStateException("Future should never fail. Did it get completed by GC?", paramThrowable);
    }
    
    public void c(Void paramVoid)
    {
      paramz.release();
      localSurfaceTexture.release();
    }
  }
  
  private static class b
    implements t2<v2>
  {
    private final s0 A;
    
    b()
    {
      u1 localu1 = u1.M();
      localu1.G(t2.p, new e1());
      this.A = localu1;
    }
    
    public s0 p()
    {
      return this.A;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.e2
 * JD-Core Version:    0.7.0.1
 */