package d0;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest.Key;
import android.media.ImageReader;
import android.os.HandlerThread;
import android.util.Size;
import androidx.camera.core.n1;
import androidx.camera.core.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m.b.a;
import r.h;
import s.g2;
import s.g2.b;
import s.g2.e;
import s.g2.e.a;
import s.h2;
import s.i2;
import s.v0;
import s.z1;

abstract class l
  implements h2
{
  private Map<Integer, ImageReader> a = new HashMap();
  private Map<Integer, e> b = new HashMap();
  private HandlerThread c;
  private List<v0> d = new ArrayList();
  private final Object e = new Object();
  private String f;
  
  private static i2 i(e parame, Map<Integer, ImageReader> paramMap)
  {
    if ((parame instanceof m)) {
      return new i2(((m)parame).e(), parame.getId());
    }
    if ((parame instanceof i))
    {
      Object localObject = (i)parame;
      localObject = ImageReader.newInstance(((i)localObject).g().getWidth(), ((i)localObject).g().getHeight(), ((i)localObject).e(), ((i)localObject).f());
      paramMap.put(Integer.valueOf(parame.getId()), localObject);
      parame = new i2(((ImageReader)localObject).getSurface(), parame.getId());
      parame.i().h(new k((ImageReader)localObject), t.a.a());
      return parame;
    }
    if ((parame instanceof j)) {
      throw new UnsupportedOperationException("MultiResolutionImageReader not supported yet");
    }
    paramMap = new StringBuilder();
    paramMap.append("Unsupported Camera2OutputConfig:");
    paramMap.append(parame);
    throw new UnsupportedOperationException(paramMap.toString());
  }
  
  public final g2 d(r paramr, z1 paramz11, z1 paramz12, z1 arg4)
  {
    paramr = h.b(paramr);
    Object localObject1 = paramr.d();
    paramz12 = k(paramr.e(), (Map)localObject1, paramz11, paramz12, ???);
    paramz11 = new g2.b();
    synchronized (this.e)
    {
      localObject1 = paramz12.c().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (e)((Iterator)localObject1).next();
        localObject2 = i((e)localObject3, this.a);
        this.d.add(localObject2);
        this.b.put(Integer.valueOf(((e)localObject3).getId()), localObject3);
        localObject2 = g2.e.a((v0)localObject2).b(((e)localObject3).a()).d(((e)localObject3).c());
        Object localObject4 = ((e)localObject3).b();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
        {
          localObject3 = new ArrayList();
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            e locale = (e)((Iterator)localObject4).next();
            this.b.put(Integer.valueOf(locale.getId()), locale);
            ((List)localObject3).add(i(locale, this.a));
          }
          ((g2.e.a)localObject2).c((List)localObject3);
        }
        paramz11.i(((g2.e.a)localObject2).a());
      }
      ??? = new b.a();
      localObject1 = paramz12.a().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CaptureRequest.Key)((Iterator)localObject1).next();
        ???.e((CaptureRequest.Key)localObject2, paramz12.a().get(localObject2));
      }
      paramz11.r(???.c());
      paramz11.t(paramz12.b());
      paramz12 = new HandlerThread("CameraX-extensions_image_reader");
      this.c = paramz12;
      paramz12.start();
      this.f = paramr.e();
      paramr = new StringBuilder();
      paramr.append("initSession: cameraId=");
      paramr.append(this.f);
      n1.a("SessionProcessorBase", paramr.toString());
      return paramz11.n();
    }
  }
  
  public final void f()
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("deInitSession: cameraId=");
    ((StringBuilder)???).append(this.f);
    n1.c("SessionProcessorBase", ((StringBuilder)???).toString());
    j();
    synchronized (this.e)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((v0)localIterator.next()).c();
      }
      this.d.clear();
      this.a.clear();
      this.b.clear();
      ??? = this.c;
      if (??? != null)
      {
        ((HandlerThread)???).quitSafely();
        this.c = null;
      }
      return;
    }
  }
  
  protected abstract void j();
  
  protected abstract g k(String paramString, Map<String, CameraCharacteristics> paramMap, z1 paramz11, z1 paramz12, z1 paramz13);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.l
 * JD-Core Version:    0.7.0.1
 */