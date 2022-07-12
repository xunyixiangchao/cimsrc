package a0;

import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.e1;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import s.k1;
import s.p0;
import s.t;
import s.u;

public final class a
  implements p0
{
  private final CaptureProcessorImpl a;
  
  public a(CaptureProcessorImpl paramCaptureProcessorImpl)
  {
    this.a = paramCaptureProcessorImpl;
  }
  
  public void a(Size paramSize)
  {
    this.a.onResolutionUpdate(paramSize);
  }
  
  public void b(k1 paramk1)
  {
    Object localObject1 = paramk1.b();
    HashMap localHashMap = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      Integer localInteger;
      Object localObject2;
      if (((Iterator)localObject1).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject1).next();
        localObject2 = paramk1.a(localInteger.intValue());
      }
      try
      {
        localObject2 = (e1)((Future)localObject2).get(5L, TimeUnit.SECONDS);
        if (((e1)localObject2).J() == null) {
          return;
        }
        Object localObject3 = u.a(((e1)localObject2).q());
        if (localObject3 == null) {
          return;
        }
        localObject3 = m.a.a((t)localObject3);
        if (localObject3 == null) {
          return;
        }
        localObject3 = (TotalCaptureResult)localObject3;
        localHashMap.put(localInteger, new Pair(((e1)localObject2).J(), localObject3));
      }
      catch (TimeoutException|ExecutionException|InterruptedException paramk1) {}
    }
    this.a.process(localHashMap);
    return;
  }
  
  public void c(Surface paramSurface, int paramInt)
  {
    this.a.onOutputSurface(paramSurface, paramInt);
    this.a.onImageFormatUpdate(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.a
 * JD-Core Version:    0.7.0.1
 */