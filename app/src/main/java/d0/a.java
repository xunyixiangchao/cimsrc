package d0;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest.Key;
import androidx.camera.extensions.impl.advanced.Camera2OutputConfigImpl;
import androidx.camera.extensions.impl.advanced.Camera2SessionConfigImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceImpl;
import androidx.camera.extensions.impl.advanced.RequestProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl.CaptureCallback;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r.j;
import r.j.a;
import s.f2;
import s.h2.a;
import s.s0;
import s.s0.a;
import s.z1;

public class a
  extends l
{
  private final SessionProcessorImpl g;
  private final Context h;
  
  public a(SessionProcessorImpl paramSessionProcessorImpl, Context paramContext)
  {
    this.g = paramSessionProcessorImpl;
    this.h = paramContext;
  }
  
  private g m(Camera2SessionConfigImpl paramCamera2SessionConfigImpl)
  {
    h localh = new h();
    Iterator localIterator = paramCamera2SessionConfigImpl.getOutputConfigs().iterator();
    while (localIterator.hasNext()) {
      localh.a(f.a((Camera2OutputConfigImpl)localIterator.next()));
    }
    localIterator = paramCamera2SessionConfigImpl.getSessionParameters().keySet().iterator();
    while (localIterator.hasNext())
    {
      CaptureRequest.Key localKey = (CaptureRequest.Key)localIterator.next();
      localh.b(localKey, paramCamera2SessionConfigImpl.getSessionParameters().get(localKey));
    }
    localh.d(paramCamera2SessionConfigImpl.getSessionTemplateId());
    return localh.c();
  }
  
  public void a(s0 params0)
  {
    HashMap localHashMap = new HashMap();
    params0 = j.a.e(params0).d();
    Iterator localIterator = params0.c().iterator();
    while (localIterator.hasNext())
    {
      s0.a locala = (s0.a)localIterator.next();
      localHashMap.put((CaptureRequest.Key)locala.d(), params0.a(locala));
    }
    this.g.setParameters(localHashMap);
  }
  
  public int b(h2.a parama)
  {
    return this.g.startRepeating(new c(parama));
  }
  
  public int c(h2.a parama)
  {
    return this.g.startCapture(new c(parama));
  }
  
  public void e()
  {
    this.g.onCaptureSessionEnd();
  }
  
  public void g(f2 paramf2)
  {
    this.g.onCaptureSessionStart(new b(paramf2));
  }
  
  protected void j()
  {
    this.g.deInitSession();
  }
  
  protected g k(String paramString, Map<String, CameraCharacteristics> paramMap, z1 paramz11, z1 paramz12, z1 paramz13)
  {
    SessionProcessorImpl localSessionProcessorImpl = this.g;
    Context localContext = this.h;
    a locala = new a(paramz11);
    paramz12 = new a(paramz12);
    if (paramz13 == null) {
      paramz11 = null;
    } else {
      paramz11 = new a(paramz13);
    }
    return m(localSessionProcessorImpl.initSession(paramString, paramMap, localContext, locala, paramz12, paramz11));
  }
  
  private static class a
    implements OutputSurfaceImpl
  {
    private final z1 a;
    
    a(z1 paramz1)
    {
      this.a = paramz1;
    }
  }
  
  private class b
    implements RequestProcessorImpl
  {
    private final f2 a;
    
    b(f2 paramf2)
    {
      this.a = paramf2;
    }
  }
  
  private static class c
    implements SessionProcessorImpl.CaptureCallback
  {
    private final h2.a a;
    
    c(h2.a parama)
    {
      this.a = parama;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.a
 * JD-Core Version:    0.7.0.1
 */